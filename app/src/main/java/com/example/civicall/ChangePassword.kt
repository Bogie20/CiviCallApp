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
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.civicall.databinding.ActivityChangePasswordBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider


class ChangePassword : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var passwordTextInputLayout: TextInputLayout
    private lateinit var newpasswordTextInputLayout: TextInputLayout
    private lateinit var retypepasswordTextInputLayout: TextInputLayout
    private var user: FirebaseUser? = null
    private var currentpassword = ""
    private var newpassword = ""
    private var retypepassword = ""
    private lateinit var networkUtils: NetworkUtils
    private fun validateCurrentPassword(): Boolean {
        val password = binding.CurrentPassword.text.toString().trim()

        if (password.isEmpty()) {
            binding.CurrentPassword.error = "Password is required"
            return false
        } else if (password.length < 8) {
            binding.CurrentPassword.error =
                "Password must be at least 8 characters long"
            return false
        } else if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d).+\$".toRegex())) {
            binding.CurrentPassword.error =
                "Password must contain both letters and numbers"
            return false
        } else {
            binding.CurrentPassword.error = null
            return true
        }
    }

    private fun validateNewPassword(): Boolean {
        val password = binding.newpassword.text.toString().trim()

        if (password.isEmpty()) {
            binding.newpassword.error = "New Password is required"
            return false
        } else if (password.length < 8) {
            binding.newpassword.error =
                "New Password must be at least 8 characters long"
            return false
        } else if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d).+\$".toRegex())) {
            binding.newpassword.error =
                "NewPassword must contain both letters and numbers"
            return false
        } else {
            binding.newpassword.error = null
            return true
        }
    }

    private fun validateRetypePassword(): Boolean {
        val password = binding.retypepassword.text.toString().trim()

        if (password.isEmpty()) {
            binding.retypepassword.error = "RetypePassword is required"
            return false
        } else if (password.length < 8) {
            binding.retypepassword.error =
                "RetypePassword must be at least 8 characters long"
            return false
        } else if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d).+\$".toRegex())) {
            binding.retypepassword.error =
                "RetypePassword must contain both letters and numbers"
            return false
        } else {
            binding.retypepassword.error = null
            return true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        binding.backbtn.setOnClickListener {
                super.onBackPressed()
                overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            }
        auth = FirebaseAuth.getInstance()
        binding.btnchange.setOnClickListener {
            if (networkUtils.isOnline) {
                validateData()
            } else {
                if (!isNoInternetDialogShowing) {
                    dismissCustomDialog()
                    showNoInternetPopup()
                }
            }
        }
    passwordTextInputLayout = binding.passwordTextInputLayout
        newpasswordTextInputLayout = binding.newpasswordTextInputLayout
        retypepasswordTextInputLayout = binding.retypepasswordTextInputLayout

        var isDialogVisible = false
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

    }
    private fun showGoogleSignInMessage() {
        showMessage(
            "You are currently signed in using Google.",
            4000,
            "Not possible",
            R.drawable.civicalllogo,
            R.layout.dialog_sadface
        )
    }
    private var isAlreadyJoinDialogShowing = false

    private fun showMessage(
        message: String,
        durationMillis: Long,
        customSlideTitle: String?,
        customDialogImageResId: Int?,
        customDialogLayoutResId: Int?
    ) {
        if (isAlreadyJoinDialogShowing) {
            return
        }
        dismissCustomDialog()

        // Use the custom layout resource ID if provided, otherwise use the default
        val dialogView = layoutInflater.inflate(customDialogLayoutResId ?: R.layout.dialog_happyface, null)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val slideTitle: AppCompatTextView = dialogView.findViewById(R.id.dialog_title_emotion)
        val dialogImage: AppCompatImageView = dialogView.findViewById(R.id.img_icon_emotion)
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationSlideLeft
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Use custom slideTitle if provided, otherwise use the default
        slideTitle.text = customSlideTitle ?: "Verifying Account"

        val messageTextView = dialogView.findViewById<TextView>(R.id.dialog_message)
        messageTextView.text = message
        alertDialog.show()

        // Use custom dialogImage if provided, otherwise use the default
        dialogImage.setImageResource(customDialogImageResId ?: R.drawable.papermani)

        isAlreadyJoinDialogShowing = true
        alertDialog.setOnDismissListener {
            isAlreadyJoinDialogShowing = false
        }
        Handler(Looper.getMainLooper()).postDelayed({
            alertDialog.dismiss()
            isAlreadyJoinDialogShowing = false
        }, durationMillis)
    }


    private fun validateData() {
        currentpassword = passwordTextInputLayout.editText?.text.toString().trim()
        newpassword = newpasswordTextInputLayout.editText?.text.toString().trim()
        retypepassword = retypepasswordTextInputLayout.editText?.text.toString().trim()
        val passwordMaxLength = 128

        val isCurrentPasswordValid = validateCurrentPassword()
        val isNewPasswordValid = validateNewPassword()
        val isRetypePasswordValid = validateRetypePassword()
        if (isGoogleSignIn()) {
            showGoogleSignInMessage()
            return
        }
        if (isCurrentPasswordValid && isNewPasswordValid && isRetypePasswordValid) {
            if (currentpassword.length > passwordMaxLength || newpassword.length > passwordMaxLength || retypepassword.length > passwordMaxLength) {
                binding.CurrentPassword.error =
                    "Password is too long (max $passwordMaxLength characters)"
                binding.newpassword.error = "Password is too long (max $passwordMaxLength characters)"
                binding.retypepassword.error =
                    "Password is too long (max $passwordMaxLength characters)"
            } else {
               showSaveConfirmationDialog()
            }
        }
    }

    private fun isGoogleSignIn(): Boolean {
        val currentUser = FirebaseAuth.getInstance().currentUser
        return currentUser != null && currentUser.providerData.any { it.providerId == GoogleAuthProvider.PROVIDER_ID }
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

        auth.sendPasswordResetEmail(emailText).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                showCustomChangedPassMessage(
                    "Check Your Email to change the Password",
                    3000,
                    R.layout.dialog_happyface
                )

                dialog.dismiss()
            } else {
                showCustomChangedPassMessage(
                    "Check for typos or your internet connection",
                    3000,
                    R.layout.dialog_sadface
                )
            }
        }
    }

    private fun dismissCustomDialog() {

        if (isProgressShowing) {

            isProgressShowing = false
        }
        if (isSaveConfirmationDialogShowing) {

            isSaveConfirmationDialogShowing = false
        }
        if (isNoInternetDialogShowing) {

            isNoInternetDialogShowing = false
        }
        if (isAlreadyJoinDialogShowing) {

            isAlreadyJoinDialogShowing = false
        }

    }

    private var isProgressShowing = false
    private fun showCustomChangedPassMessage(
        message: String,
        durationMillis: Long,
        dialogLayout: Int
    ) {
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

    private var isSaveConfirmationDialogShowing = false // Add this variable

    private fun showSaveConfirmationDialog() {
        if (isSaveConfirmationDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.dialog_confirmation, null)
        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val confirmTitle: AppCompatTextView = dialogView.findViewById(R.id.ConfirmTitle)
        val logoutMsg: AppCompatTextView = dialogView.findViewById(R.id.logoutMsg)
        val saveBtn: MaterialButton = dialogView.findViewById(R.id.saveBtn)
        val cancelBtn: MaterialButton = dialogView.findViewById(R.id.cancelBtn)


        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink


        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        confirmTitle.text = "Confirmation"
        logoutMsg.text = "Are you certain you want to proceed with changing your password?"

        saveBtn.text = "Save"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()


            changePassword()
        }
        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isSaveConfirmationDialogShowing = false
            alertDialog.dismiss()
        }
        alertDialog.setOnDismissListener{
            isSaveConfirmationDialogShowing = false
        }

        alertDialog.show()
        isSaveConfirmationDialogShowing =
            true
    }
    private var isNoInternetDialogShowing = false
    private fun showNoInternetPopup() {
        isNoInternetDialogShowing = true
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_network, null)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        view.findViewById<Button>(R.id.retryBtn).setOnClickListener {
            dialog.dismiss()
            isNoInternetDialogShowing = false
        }
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        dialog.setOnDismissListener {
            isNoInternetDialogShowing = false
        }
        dialog.show()
    }


    private fun changePassword() {
        if (binding.CurrentPassword.text?.isNotEmpty() == true &&
            binding.newpassword.text?.isNotEmpty() == true &&
            binding.retypepassword.text?.isNotEmpty() == true
        ) {
            user = auth.currentUser

            if (user != null) {
                val credential = EmailAuthProvider.getCredential(
                    user!!.email!!,
                    binding.CurrentPassword.text.toString()
                )

                // Re-authenticate the user
                user!!.reauthenticate(credential)
                    .addOnCompleteListener { reauthTask ->
                        if (reauthTask.isSuccessful) {
                            // Re-authentication succeeded, now update the password
                            if (binding.newpassword.text.toString() == binding.retypepassword.text.toString()) {
                                user!!.updatePassword(binding.newpassword.text.toString())
                                    .addOnCompleteListener { updateTask ->
                                        if (updateTask.isSuccessful) {
                                            showCustomChangedPassMessage(
                                                "Password Successfully Changed",
                                                1500,
                                                R.layout.dialog_happyface
                                            )
                                            Handler(Looper.getMainLooper()).postDelayed({
                                                auth.signOut()
                                                val intent = Intent(this, Login::class.java)
                                                startActivity(intent)
                                                finish()
                                            }, 2000)
                                        } else {
                                            showCustomChangedPassMessage(
                                                "Password Change Failed",
                                                1500,
                                                R.layout.dialog_sadface
                                            )
                                        }
                                    }
                            } else {
                                showCustomChangedPassMessage(
                                    "Password Mismatch",
                                    3000,
                                    R.layout.dialog_sadface
                                )
                            }
                        } else {
                            showCustomChangedPassMessage(
                                "Re-authentication Failed: Please review the entered inputs.",
                                3000,
                                R.layout.dialog_sadface
                            )
                        }
                    }
            }
        } else {
            showCustomChangedPassMessage(
                "Please Enter All the Fields",
                3000,
                R.layout.dialog_sadface
            )
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}