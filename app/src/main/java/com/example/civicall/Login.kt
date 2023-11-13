package com.example.civicall

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: Dialog
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var emailTextInputLayout: TextInputLayout
    private lateinit var databaseReference: DatabaseReference
    private lateinit var passwordTextInputLayout: TextInputLayout
    private lateinit var networkUtils: NetworkUtils
    private var isNewAccount = false
    private var email = ""
    private var password = ""
    private var isPopupShowing = false
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val Req_Code: Int = 123
    private var profileImageUri: String? = null

    private fun updateUserInfo(account: GoogleSignInAccount?) {
        val timestamp = System.currentTimeMillis()
        val uid = firebaseAuth.uid

        val hashMap: HashMap<String, Any?> = HashMap()
        hashMap["uid"] = uid
        hashMap["firstname"] = account?.givenName
        hashMap["middlename"] = ""
        hashMap["lastname"] = account?.familyName
        hashMap["email"] = account?.email
        hashMap["phoneno"] = ""
        hashMap["address"] = ""
        hashMap["birthday"] = ""
        hashMap["gender"] = ""
        hashMap["ImageProfile"] = profileImageUri
        hashMap["userType"] = ""
        hashMap["timestamp"] = timestamp
        hashMap["campus"] = ""
        hashMap["verificationStatus"] = false
        hashMap["CurrentEngagement"] = 0

        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid!!)
            .setValue(hashMap)
            .addOnSuccessListener {
                // Add TotalEngagement count to another location
                val totalEngagementRef = FirebaseDatabase.getInstance().getReference("TotalEngagement")
                totalEngagementRef.child(uid)
                    .setValue(0)

                // Proceed to the Dashboard or any other desired activity
                startActivity(Intent(this@Login, Dashboard::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                showCustomPopupError("Failed Saving User's Info due to ${e.message}")
            }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = Dialog(this)
        progressDialog.setContentView(R.layout.loading_layout)
        progressDialog.setCancelable(false)
        databaseReference = FirebaseDatabase.getInstance().getReference("connection_status")
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        val showSuccessPopup = intent.getBooleanExtra("showSuccessPopup", false)

        FirebaseApp.initializeApp(this)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.googlebtn.setOnClickListener {
            Toast.makeText(this, "Logging In", Toast.LENGTH_SHORT).show()
            signInGoogle()
        }

        if (showSuccessPopup) {
            // Display the "Account Created Successfully!" popup
            showCustomPopupSuccess("Account Created Successfully!")
        }

        // Initialize your email and password EditText fields
        emailEditText = binding.emailLogin
        passwordEditText = binding.passwordText

        binding.signUpTV.setOnClickListener {
            val intent = Intent(this, Register1::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        binding.btnlogin.setOnClickListener {
            validateData()
        }
        emailTextInputLayout = binding.emailTextInputLayout
        passwordTextInputLayout = binding.passwordTextInputLayout



        emailTextInputLayout.editText?.onFocusChangeListener =
            View.OnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) {
                    val emailText = emailTextInputLayout.editText?.text.toString().trim()
                    if (emailText.isEmpty()) {
                        emailEditText.error = "Please Input your email"
                    } else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                        emailEditText.error = "Invalid Email"
                    } else {
                        emailEditText.error = null
                    }
                }
            }


        // Set a focus change listener for the password TextInputLayout
        passwordTextInputLayout.editText?.onFocusChangeListener =
            View.OnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) {
                    val passwordText = passwordTextInputLayout.editText?.text.toString().trim()
                    if (passwordText.isEmpty()) {
                        passwordEditText.error = "Please Enter your password"
                    } else {
                        passwordEditText.error = null
                    }
                }
            }

        emailEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                email = emailEditText.text.toString().trim()
            } else {
                // When email field gains focus, restore the entire password
                passwordEditText.setText(password)
            }
        }

// Set a focus change listener for the password EditText
        passwordEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                password = passwordEditText.text.toString().trim()
            } else {
                // When password field gains focus, restore the entire email
                emailEditText.setText(email)
            }
        }
        var isDialogVisible = false // Add this flag

        binding.forgotPassword.setOnClickListener {
            if (!isDialogVisible) { // Check if the dialog is not already visible
                isDialogVisible = true // Set the flag to true
                val builder = AlertDialog.Builder(this)
                val view = layoutInflater.inflate(R.layout.dialog_forgotpass, null)
                val userEmail = view.findViewById<EditText>(R.id.email)
                builder.setView(view)
                val dialog = builder.create()

                // Set the animation after creating the dialog
                dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

                view.findViewById<Button>(R.id.resetbtn).setOnClickListener {
                    compareEmail(userEmail, dialog)
                    isDialogVisible = false // Reset the flag when the dialog is dismissed
                }
                view.findViewById<Button>(R.id.cancelbtn).setOnClickListener {
                    dialog.dismiss()
                    isDialogVisible = false // Reset the flag when the dialog is dismissed
                }
                dialog.setOnDismissListener {
                    isDialogVisible = false
                }

                if (dialog.window != null) {
                    // Set the background drawable here if needed
                    dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
                }

                dialog.show()
            }
        }


        binding.btnlogin.setOnClickListener {
            if (networkUtils.isOnline) {
                validateData()
            } else {
                showNoInternetPopup()
            }
            dismissCustomDialog()
        }
    }
    private fun compareEmail(email: EditText, dialog: Dialog) {
        val emailText = email.text.toString().trim()

        if (emailText.isEmpty()) {
            email.error = "Input Your Email First"
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            email.error = "Invalid Email"
            return
        }
        firebaseAuth.sendPasswordResetEmail(emailText).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                showCustomChangedPassMessage("Check Your Email to change the Password", 3000, R.layout.dialog_happyface)

                dialog.dismiss()
            } else {
                showCustomChangedPassMessage("Check for typos or your internet connection", 3000, R.layout.dialog_sadface)
            }
        }
    }

    private fun dismissCustomDialog() {
        if (isPopupShowing) {
            // Dismiss the custom popup dialog
            // For example:
            // alertDialog.dismiss()
            isPopupShowing = false
        }

        if (isProgressBarShowing) {
            // Dismiss the progress dialog
            // For example:
            // progressDialog.dismiss()
            isProgressBarShowing = false
        }

        if (isProgressShowing) {
            // Dismiss the progress dialog
            // For example:
            // progressAlertDialog.dismiss()
            isProgressShowing = false
        }
    }

    private fun showCustomPopupSuccess(message: String) {
        // Check if the pop-up is already showing, and if so, return early
        if (isPopupShowing) {
            return
        }

        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_success, null)

        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()

        // Set the animation style
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val messageTextView = dialogView.findViewById<TextView>(R.id.dialog_message_flat)
        val okButton = dialogView.findViewById<Button>(R.id.btn_action_flat)

        messageTextView.text = message

        okButton.setOnClickListener {
            alertDialog.dismiss()
            isPopupShowing = false // Set the variable to false when the pop-up is dismissed
        }
        dismissCustomDialog()

        alertDialog.show()
        isPopupShowing = true // Set the variable to true when the pop-up is displayed
    }
    private var isProgressBarShowing = false
    private fun showCustomProgressBar(message: String, durationMillis: Long) {
        // Check if the progress bar is already showing
        if (isProgressBarShowing) {
            return
        }

        dismissCustomDialog()

        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.loading_layout, null)

        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()

        // Set the animation style
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationSlideUp

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val messageTextView = dialogView.findViewById<TextView>(R.id.messageTextView)
        messageTextView.text = message

        alertDialog.show()

        // Set the variable to true to indicate that the progress bar is showing
        isProgressBarShowing = true

        // Dismiss the dialog after the specified duration
        Handler(Looper.getMainLooper()).postDelayed({
            alertDialog.dismiss()
            // Set the variable to false when the progress bar is dismissed
            isProgressBarShowing = false
        }, durationMillis)
    }
    private var isProgressShowing = false
    private fun showCustomChangedPassMessage(message: String, durationMillis: Long, dialogLayout: Int) {
        // Check if a dialog is already showing
        if (isProgressShowing) {
            return
        }
        dismissCustomDialog()

        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(dialogLayout, null)

        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()

        // Set the animation style
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationSlideLeft

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val messageTextView = dialogView.findViewById<TextView>(R.id.dialog_message)
        messageTextView.text = message

        alertDialog.show()

        // Set the variable to true to indicate that a dialog is showing
        isProgressShowing = true
        alertDialog.setOnDismissListener {
            // Reset the flag when dismissing the dialog
            isProgressShowing = false
        }
        // Dismiss the dialog after the specified duration
        Handler(Looper.getMainLooper()).postDelayed({
            alertDialog.dismiss()
            // Set the variable to false when the dialog is dismissed
            isProgressShowing = false
        }, durationMillis)
    }

    private fun validateData() {
        email = emailTextInputLayout.editText?.text.toString().trim()
        password = passwordTextInputLayout.editText?.text.toString().trim()

        val emailMaxLength = 320
        val passwordMaxLength = 128

        if (email.isEmpty()) {
            emailEditText.error = "Please input your email"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.error = "Invalid Email"
        } else if (email.length > emailMaxLength) {
            emailEditText.error = "Email is too long (max $emailMaxLength characters)"
        } else if (password.isEmpty()) {
            passwordEditText.error = "Please enter your password"
        } else if (password.length > passwordMaxLength) {
            passwordEditText.error = "Password is too long (max $passwordMaxLength characters)"
        } else {
            loginUser()
        }
    }


    private fun loginUser() {
        showCustomProgressBar("Logging In...", 1500)

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                checkUser()
            }
            .addOnFailureListener { e ->
                // Dismiss the progress bar when there's an error
                dismissCustomProgressBar()

                if (e.message == "The email address is badly formatted.") {
                    // Handle invalid email format error
                    emailEditText.error = "Invalid Email"
                    passwordEditText.error = null // Clear password error
                } else if (e.message == "There is no user record corresponding to this identifier. The user may have been deleted.") {
                    // User does not exist in the database, show the custom popup with an error message
                    showCustomPopupError("Account Not Found")
                } else if (e.message == "The password is invalid or the user does not have a password.") {
                    // Handle incorrect password error
                    passwordEditText.error = "Incorrect Password"
                    emailTextInputLayout.error = null // Clear email error
                    // Call showCustomPopupIncorrectPass for incorrect password error
                } else {
                    // Handle other errors, such as network issues or server problems
                    showCustomPopupError("Login Failed. Please try again later.")
                }
            }
    }


    private fun dismissCustomProgressBar() {
        // Dismiss the progress bar here
        progressDialog.dismiss()
    }


    private fun showCustomPopupError(message: String) {
        // Check if the pop-up is already showing, and if so, return early
        if (isPopupShowing) {
            return
        }

        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_error, null)

        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()

        // Set the animation style
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val messageTextView = dialogView.findViewById<TextView>(R.id.dialog_message_flat)
        val okButton = dialogView.findViewById<Button>(R.id.btn_action_flat)

        messageTextView.text = message

        okButton.setOnClickListener {
            alertDialog.dismiss()
            isPopupShowing = false // Set the variable to false when the pop-up is dismissed
        }

        alertDialog.show()
        isPopupShowing = true // Set the variable to true when the pop-up is displayed
    }
    private fun showNoInternetPopup() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_network, null)
        dismissCustomDialog()
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        view.findViewById<Button>(R.id.okbtns).setOnClickListener {
            dialog.dismiss()
        }

        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }

        dialog.show()
    }

    private fun checkUser() {
        val messageTextView = progressDialog.findViewById<TextView>(R.id.messageTextView)
        messageTextView.text = "Checking User..."

        val firebaseUser = firebaseAuth.currentUser!!
        val ref = FirebaseDatabase.getInstance().getReference("Users")

        ref.child(firebaseUser.uid)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // Proceed to the Dashboard or any other desired activity
                    startActivity(Intent(this@Login, Dashboard::class.java))
                    finish()

                    if (isNewAccount) {
                        // User has just created an account, show the success message here
                        showCustomPopupSuccess("Account Created Successfully!")
                        updateUserInfo(null)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
    }
    private fun signInGoogle() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, Req_Code, null)
    }

    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Req_Code) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleResult(task)
        }
    }

    private fun handleResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = completedTask.getResult(ApiException::class.java)
            if (account != null) {
                updateUI(account)
            }
        } catch (e: ApiException) {
            // Print the status code and error message for debugging
            Toast.makeText(
                this,
                "Google Sign-In failed: Status Code ${e.statusCode}, ${e.localizedMessage}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("email", account.email.toString())
                editor.putString("username", account.displayName.toString())
                editor.apply()

                // Set the URL of the user's profile picture
                profileImageUri = account.photoUrl?.toString()

                // Update the user information in the Firebase Realtime Database
                updateUserInfo(account)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }
    override fun onDestroy() {
        super.onDestroy()

        // Cleanup to unregister the network callback
        networkUtils.cleanup()
    }
}