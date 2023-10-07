package com.example.civicall

import android.app.Dialog
import android.content.Intent
import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: Dialog
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var emailTextInputLayout: TextInputLayout
    private lateinit var passwordTextInputLayout: TextInputLayout
    private var isNewAccount = false
    private var email = ""
    private var password = ""
    private fun validateEmail() {
        val emailText = emailEditText.text.toString().trim()

        if (TextUtils.isEmpty(emailText)) {
            emailTextInputLayout.error = "Please Input Valid Email"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            emailTextInputLayout.error = "Invalid Email"
        } else {
            emailTextInputLayout.error = null
        }
    }

    // Function to validate password
    private fun validatePassword() {
        val passwordText = passwordEditText.text.toString().trim()

        if (TextUtils.isEmpty(passwordText)) {
            passwordTextInputLayout.error = "Please enter your password"
        } else {
            passwordTextInputLayout.error = null
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

        val showSuccessPopup = intent.getBooleanExtra("showSuccessPopup", false)

        if (showSuccessPopup) {
            // Display the "Account Created Successfully!" popup
            showCustomPopupSuccess("Account Created Successfully!")
        }

        val forgotPasswordTextView = findViewById<TextView>(R.id.forgotpassword)
        // Initialize your email and password EditText fields
        emailEditText = binding.emailLogin
        passwordEditText = binding.passwordText

        binding.signUpTextView.setOnClickListener {
            startActivity(Intent(this, Register1::class.java))
        }

        binding.btnlogin.setOnClickListener {
            validateData()
        }
        // Set a focus change listener for the email EditText
        // Set a focus change listener for the email EditText
        emailTextInputLayout = binding.emailTextInputLayout
        passwordTextInputLayout = binding.passwordTextInputLayout

        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateEmail()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validatePassword()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        // Set a focus change listener for the email TextInputLayout
        emailTextInputLayout.editText?.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val emailText = emailTextInputLayout.editText?.text.toString().trim()
                if (emailText.isEmpty()) {
                    emailTextInputLayout.error = "Please Input your email"
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                    emailTextInputLayout.error = "Invalid Email"
                } else {
                    emailTextInputLayout.error = null
                }
            }
        }


        // Set a focus change listener for the password TextInputLayout
        passwordTextInputLayout.editText?.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val passwordText = passwordTextInputLayout.editText?.text.toString().trim()
                if (passwordText.isEmpty()) {
                    passwordTextInputLayout.error = "Please Enter your password"
                } else {
                    passwordTextInputLayout.error = null
                }
            }
        }



        // Create an Intent to open the ForgotPassword activity
        forgotPasswordTextView.setOnClickListener {
            // Create an Intent to open the ForgotPassword activity
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }
    }

    private fun showCustomPopupSuccess(message: String) {
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
        }

        alertDialog.show()
    }

    private fun showCustomProgressBar(message: String, durationMillis: Long) {
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

        // Dismiss the dialog after the specified duration
        Handler(Looper.getMainLooper()).postDelayed({
            alertDialog.dismiss()
        }, durationMillis)

        alertDialog.show()
    }


    private fun validateData() {
        email = emailTextInputLayout.editText?.text.toString().trim()
        password = passwordTextInputLayout.editText?.text.toString().trim()

        val emailMaxLength = 320
        val passwordMaxLength = 128

        if (email.isEmpty()) {
            emailTextInputLayout.error = "Please input your email"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailTextInputLayout.error = "Invalid Email"
        } else if (email.length > emailMaxLength) {
            emailTextInputLayout.error = "Email is too long (max $emailMaxLength characters)"
        } else if (password.isEmpty()) {
            passwordTextInputLayout.error = "Please enter your password"
        } else if (password.length > passwordMaxLength) {
            passwordTextInputLayout.error = "Password is too long (max $passwordMaxLength characters)"
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
                    emailTextInputLayout.error = "Invalid Email"
                    passwordTextInputLayout.error = null // Clear password error
                } else if (e.message == "There is no user record corresponding to this identifier. The user may have been deleted.") {
                    // User does not exist in the database, show the custom popup with an error message
                    showCustomPopupError("Account Not Found")
                } else {
                    // Show "Incorrect Password" for other login errors
                    passwordTextInputLayout.error = "Incorrect Password"
                    emailTextInputLayout.error = null // Clear email error
                    // Call showCustomPopupIncorrectPass for incorrect password error
                    showCustomPopupIncorrectPass("Incorrect Password")
                }
            }
    }

    private fun dismissCustomProgressBar() {
        // Dismiss the progress bar here
        progressDialog.dismiss()
    }


    private fun showCustomPopupError(message: String) {
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
        }

        alertDialog.show()
    }


    private fun showCustomPopupIncorrectPass(message: String) {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_flat, null)

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
        }

        alertDialog.show()
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
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
    }
}






