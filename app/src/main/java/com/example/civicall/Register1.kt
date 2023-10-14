package com.example.civicall

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.CivicEngagementPost.CivicPostFragment
import com.example.civicall.databinding.ActivityRegister1Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar

class Register1 : AppCompatActivity() {
    private lateinit var activityRegister1Binding: ActivityRegister1Binding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog
    private var selectedCampus = ""
    private var initialFirstName = ""
    private var initialLastName = ""
    private var initialEmail = ""
    private var initialPassword = ""
    private var initialConfirmPassword = ""
    private var initialContactNumber = ""
    private var initialContactEme = ""
    private var initialAddress = ""
    private var initialBirthday = ""
    private var isPopupShowing = false
    private lateinit var networkUtils: NetworkUtils

    private fun validateFirstName(): Boolean {
        val lastName = activityRegister1Binding.fname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (lastName.isEmpty()) {
            activityRegister1Binding.fnameTextInputLayout.error = "Required"
            return false
        } else if (!lastName.matches(regex.toRegex())) {
            activityRegister1Binding.fnameTextInputLayout.error =
                "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            activityRegister1Binding.fnameTextInputLayout.error = null
            return true
        }
    }

    private fun validateLastName(): Boolean {
        val lastName = activityRegister1Binding.Lname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (lastName.isEmpty()) {
            activityRegister1Binding.lastNameTextInputLayout.error = "Required"
            return false
        } else if (!lastName.matches(regex.toRegex())) {
            activityRegister1Binding.lastNameTextInputLayout.error =
                "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            activityRegister1Binding.lastNameTextInputLayout.error = null
            return true
        }
    }

    private fun validateEmail(): Boolean {
        val email = activityRegister1Binding.Emailline.text.toString().trim()
        if (email.isEmpty()) {
            activityRegister1Binding.emailTextInputLayout.error = "Email is required"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            activityRegister1Binding.emailTextInputLayout.error = "Invalid email format"
            return false
        } else {
            activityRegister1Binding.emailTextInputLayout.error = null
            return true
        }
    }

    private fun validateConfirmPassword(): Boolean {
        val password = activityRegister1Binding.confirmPass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegister1Binding.confirmPassword.error = "Required"
            return false
        } else {
            activityRegister1Binding.confirmPassword.error = null
            return true
        }
    }


    private fun validatePassword(): Boolean {
        val password = activityRegister1Binding.pass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegister1Binding.passwordTextInputLayout.error = "Password is required"
            return false
        } else if (password.length < 8) {
            activityRegister1Binding.passwordTextInputLayout.error =
                "Password must be at least 8 characters long"
            return false
        } else if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d).+\$".toRegex())) {
            activityRegister1Binding.passwordTextInputLayout.error =
                "Password must contain both letters and numbers"
            return false
        } else {
            activityRegister1Binding.passwordTextInputLayout.error = null
            return true
        }
    }


    private fun validateContactNumber(): Boolean {
        val contactNumber = activityRegister1Binding.Contactline.text.toString().trim()

        if (contactNumber.isEmpty()) {
            activityRegister1Binding.contactNumberTextInputLayout.error =
                "Please enter Contact Number"
            return false
        } else if (!isValidPhoneNumber(contactNumber)) {
            activityRegister1Binding.contactNumberTextInputLayout.error = "Invalid Contact Number"
            return false
        } else {
            activityRegister1Binding.contactNumberTextInputLayout.error = null
            return true
        }
    }


    private fun isValidPhoneNumber(contactNumber: String): Boolean {
        val sanitizedNumber = contactNumber.replace("\\s".toRegex(), "")

        return if (sanitizedNumber.startsWith("+63")) {
            sanitizedNumber.length == 13
        } else if (sanitizedNumber.startsWith("63")) {
            sanitizedNumber.length == 12
        } else if (sanitizedNumber.startsWith("09")) {
            sanitizedNumber.length == 11
        }else {
            false
        }
    }

    private fun validateContactEme(): Boolean {
        val contactNum = activityRegister1Binding.ContactEme.text.toString().trim()

        if (contactNum.isEmpty()) {
            activityRegister1Binding.contactEmeNum.error = "Please enter Contact Person"
            return false
        } else if (!isValidPhoneEme(contactNum)) {
            activityRegister1Binding.contactEmeNum.error = "Invalid Contact Person"
            return false
        } else {
            activityRegister1Binding.contactEmeNum.error = null
            return true
        }
    }


    private fun isValidPhoneEme(contactNum: String): Boolean {
        val sanitizedNum = contactNum.replace("\\s".toRegex(), "")

        return if (sanitizedNum.startsWith("+63")) {
            sanitizedNum.length == 13
        } else if (sanitizedNum.startsWith("63")) {
            sanitizedNum.length == 12
        } else if (sanitizedNum.startsWith("09")) {
            sanitizedNum.length == 11
        }else {
            false
        }
    }

    private fun validateAddress(): Boolean {
        val address = activityRegister1Binding.address.text.toString().trim()

        if (address.isEmpty()) {
            activityRegister1Binding.addressTextInputLayout.error = "Address is required"
            return false
        } else if (address.length < 5) {
            activityRegister1Binding.addressTextInputLayout.error = "Address is too short"
            return false
        } else {
            activityRegister1Binding.addressTextInputLayout.error = null
            return true
        }
    }


    private fun validateBirthday(): Boolean {
        val birthday = activityRegister1Binding.birthdate.text.toString().trim()
        val birthdateTextInputLayout = activityRegister1Binding.birthdateTextInputLayout

        if (birthday.isEmpty()) {
            birthdateTextInputLayout.error = null
            birthdateTextInputLayout.helperText = "*required"
            return false
        } else {
            val dobParts = birthday.split(" / ")
            if (dobParts.size == 3) {
                val day = dobParts[0].toInt()
                val month = dobParts[1].toInt()
                val year = dobParts[2].toInt()

                val calendar = Calendar.getInstance()
                val currentYear = calendar.get(Calendar.YEAR)
                val currentMonth = calendar.get(Calendar.MONTH) + 1
                val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

                val age =
                    currentYear - year - if (currentMonth < month || (currentMonth == month && currentDay < day)) 1 else 0

                if (age < 18) {
                    activityRegister1Binding.birthdateTextInputLayout.error =
                        "You must be at least 18 years old to register"
                    return false
                }
            } else {
                activityRegister1Binding.birthdateTextInputLayout.error =
                    "Invalid Date of Birth format"
                return false
            }

            // Clear the error message when valid input is provided
            activityRegister1Binding.birthdateTextInputLayout.error = null
            return true
        }
    }

    private fun validatePasswordMatch(): Boolean {
        val password = activityRegister1Binding.pass.text.toString().trim()
        val confirmPassword = activityRegister1Binding.confirmPass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegister1Binding.passwordTextInputLayout.error = "Please Enter Password"
            return false
        } else if (confirmPassword.isEmpty()) {
            activityRegister1Binding.confirmPassword.error = "Please Confirm Password"
            return false
        } else if (password != confirmPassword) {
            activityRegister1Binding.confirmPassword.error = "Passwords do not match"
            return false
        } else {
            activityRegister1Binding.confirmPassword.error = null
            return true
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        activityRegister1Binding = ActivityRegister1Binding.inflate(layoutInflater)
        setContentView(activityRegister1Binding.root)

        initialFirstName = activityRegister1Binding.fname.text.toString().trim()
        initialLastName = activityRegister1Binding.Lname.text.toString().trim()
        initialEmail = activityRegister1Binding.Emailline.text.toString().trim()
        initialPassword = activityRegister1Binding.pass.text.toString().trim()
        initialConfirmPassword = activityRegister1Binding.confirmPass.text.toString().trim()
        initialContactNumber = activityRegister1Binding.Contactline.text.toString().trim()
        initialContactEme = activityRegister1Binding.ContactEme.text.toString().trim()
        initialAddress = activityRegister1Binding.address.text.toString().trim()
        initialBirthday = activityRegister1Binding.birthdate.text.toString().trim()

        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        val contactNumber = activityRegister1Binding.Contactline
        val contactEme = activityRegister1Binding.ContactEme

        val maxLength = 80
        val maxEmailLength = 320
        val maxContactLength = 20
        val maxAddressLength = 255
        val maxPasswordLength = 128
// For the "Campus" field
        val campusAutoCompleteTextView = activityRegister1Binding.campus
        val campusOptions = resources.getStringArray(R.array.allowed_campuses)

        val campusAdapter = ArrayAdapter(
            this,
            R.layout.dropdown_item,
            campusOptions
        ) // Create an ArrayAdapter with your options
        campusAutoCompleteTextView.setAdapter(campusAdapter) // Set the adapter for the AutoCompleteTextView

// For the "Gender" field
        val spinnerSexAutoCompleteTextView = activityRegister1Binding.spinnerSex
        val sexOptions = resources.getStringArray(R.array.gender_array)

        val sexAdapter = ArrayAdapter(
            this,
            R.layout.dropdown_item,
            sexOptions
        ) // Create an ArrayAdapter with your options
        spinnerSexAutoCompleteTextView.setAdapter(sexAdapter) // Set the adapter for the AutoCompleteTextView

        val firstNameEditText = activityRegister1Binding.fname
        val lastNameEditText = activityRegister1Binding.Lname
        val filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        val emailEditText = activityRegister1Binding.Emailline
        val emailFilters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxEmailLength))
        val contactNumberEditText = activityRegister1Binding.Contactline
        val contactEmeEditText = activityRegister1Binding.ContactEme
        val contactFilters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxContactLength))
        val addressEditText = activityRegister1Binding.address
        val addressFilters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxAddressLength))
        val passwordEditText = activityRegister1Binding.pass
        val confirmPasswordEditText = activityRegister1Binding.confirmPass
        val passwordFilters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPasswordLength))
        passwordEditText.filters = passwordFilters
        confirmPasswordEditText.filters = passwordFilters
        addressEditText.filters = addressFilters
        contactNumberEditText.filters = contactFilters
        contactEmeEditText.filters = contactFilters
        emailEditText.filters = emailFilters
        firstNameEditText.filters = filters
        lastNameEditText.filters = filters
        contactNumber.inputType = InputType.TYPE_CLASS_PHONE
        contactEme.inputType = InputType.TYPE_CLASS_PHONE

        val birthdayEditText = activityRegister1Binding.birthdate
        val confirmpassword = activityRegister1Binding.confirmPass

        firstNameEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateFirstName()
                // Set selection to initial input length
                firstNameEditText.setSelection(initialFirstName.length)
            }
        }

        lastNameEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateLastName()
                // Set selection to initial input length
                lastNameEditText.setSelection(initialLastName.length)
            }
        }
        emailEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateEmail()
                emailEditText.setSelection(initialEmail.length)
            }
        }

        passwordEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validatePassword()
                passwordEditText.setSelection(initialPassword.length)
            }
        }
        confirmpassword.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateConfirmPassword()
                confirmpassword.setSelection(initialConfirmPassword.length)
            }
        }

        contactNumberEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateContactNumber()
                contactNumberEditText.setSelection(initialContactNumber.length)
            }
        }
        contactEmeEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateContactEme()
                contactEmeEditText.setSelection(initialContactEme.length)
            }
        }

        addressEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateAddress()
                addressEditText.setSelection(initialAddress.length)
            }
        }

        birthdayEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateBirthday()
                birthdayEditText.setSelection(initialBirthday.length)
            }
        }
        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait...")
        progressDialog.setCanceledOnTouchOutside(false)

        val backbtn: ImageView = findViewById(R.id.back)

        backbtn.setOnClickListener {
            onBackPressed()
        }
        val regbtn: Button = findViewById(R.id.Reg)
        regbtn.setOnClickListener {
            if (networkUtils.isOnline) {
                validateData()
            } else {
                showNoInternetPopup()
            }
            dismissCustomDialog()
        }


        val birthday = activityRegister1Binding.birthdate
        val cal = Calendar.getInstance()
        val Myear = cal.get(Calendar.YEAR)
        val Mmonth = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        birthday.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    val dateString = "$dayOfMonth / ${month + 1} / $year"
                    birthday.setText(dateString)
                },
                Myear,
                Mmonth,
                day
            )
            datePickerDialog.show()
        }

        // Ang ginagawa nito is habang nag tatype ka nawawala na agad yung error
        firstNameEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateFirstName()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
        lastNameEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateLastName()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
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
        confirmPasswordEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateConfirmPassword()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })


        contactNumberEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateContactNumber()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Handle before text changed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Handle text changed
            }
        })
        contactEmeEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateContactEme()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Handle before text changed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Handle text changed
            }
        })
        addressEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateAddress()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        birthdayEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Clear the error message when valid input is provided
                activityRegister1Binding.birthdateTextInputLayout.error = null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

    }

    private var fname = ""
    private var lname = ""
    private var email = ""
    private var pass = ""
    private var confirmPass = ""
    private var phoneno = ""
    private var phoneEme = ""
    private var address = ""
    private var birtdate = ""
    private var spinnerSex = ""

    private fun validateData() {
        fname = activityRegister1Binding.fname.text.toString().trim()
        lname = activityRegister1Binding.Lname.text.toString().trim()
        email = activityRegister1Binding.Emailline.text.toString().trim()
        pass = activityRegister1Binding.pass.text.toString().trim()
        confirmPass = activityRegister1Binding.confirmPass.text.toString().trim()
        phoneno = activityRegister1Binding.Contactline.text.toString().trim()
        phoneEme = activityRegister1Binding.ContactEme.text.toString().trim()
        address = activityRegister1Binding.address.text.toString().trim()
        birtdate = activityRegister1Binding.birthdate.text.toString().trim()
        spinnerSex = activityRegister1Binding.spinnerSex.text.toString()
        selectedCampus = activityRegister1Binding.campus.text.toString()


        activityRegister1Binding.fnameTextInputLayout.error = null
        activityRegister1Binding.lastNameTextInputLayout.error = null
        activityRegister1Binding.emailTextInputLayout.error = null
        activityRegister1Binding.passwordTextInputLayout.error = null
        activityRegister1Binding.confirmPassword.error = null
        activityRegister1Binding.contactNumberTextInputLayout.error = null
        activityRegister1Binding.contactEmeNum.error = null
        activityRegister1Binding.addressTextInputLayout.error = null

        val checkBox = findViewById<CheckBox>(R.id.checkedTextView)
        val errorMessages = mutableListOf<String>()
        if (!validateFirstName() || !validateLastName() || !validateAddress() || !validateBirthday() ||
            !validatePasswordMatch() || !validateEmail() || !validatePassword() || !validateConfirmPassword() || !validateContactNumber() && !validateContactEme()
        ) {
            errorMessages.add("Please provide valid information for the following fields.")
        } else if (!checkBox.isChecked()) {
            errorMessages.add("Please Accept the terms and Condition")
        }

        val campusAutoCompleteTextView = activityRegister1Binding.campus

        campusAutoCompleteTextView.setOnItemClickListener { _, _, _, _ ->
            // Clear the error message when a valid selection is made
            activityRegister1Binding.campusTextInputLayout.error = null
        }

        val spinnerSexAutoCompleteTextView = activityRegister1Binding.spinnerSex

        spinnerSexAutoCompleteTextView.setOnItemClickListener { _, _, _, _ ->
            // Clear the error message when a valid selection is made
            activityRegister1Binding.genderTextInputLayout.error = null
        }

        if (!validateFirstName()) {
            activityRegister1Binding.fnameTextInputLayout.error = "Please enter a valid first name"
        }

        if (!validateLastName()) {
            activityRegister1Binding.lastNameTextInputLayout.error =
                "Please enter a valid last name"
        }

        if (!validateEmail()) {
            activityRegister1Binding.emailTextInputLayout.error = "Please enter a valid email"
        }

        if (!validatePassword()) {
            activityRegister1Binding.passwordTextInputLayout.error = "Please enter a valid password"
        }

        if (!validateConfirmPassword()) {
            activityRegister1Binding.confirmPassword.error = "Please confirm your password"
        }

        if (!validateContactNumber()) {
            activityRegister1Binding.contactNumberTextInputLayout.error =
                "Please enter a valid contact number"
        }

        if (!validateContactEme()) {
            activityRegister1Binding.contactEmeNum.error = "Please enter a valid contact person"
        }

        if (!validateAddress()) {
            activityRegister1Binding.addressTextInputLayout.error = "Please enter a valid address"
        }


        if (selectedCampus.isEmpty()) {
            activityRegister1Binding.campusTextInputLayout.error = "Please select a campus"
        }

        if (spinnerSex.isEmpty()) {
            activityRegister1Binding.genderTextInputLayout.error = "Select a Gender"
        }
        if (birtdate.isEmpty()) {
            activityRegister1Binding.birthdateTextInputLayout.error = "Select Date of Birth"
        }



        validatePasswordMatch()


        if (errorMessages.isNotEmpty()) {
            for (message in errorMessages) {
                showCustomPopup(message)
            }
        } else {
            // Only create the user account if there are no validation errors
            createUserAccount()
        }
    }


    private fun showCustomPopup(message: String) {
        // Check if the pop-up is already showing, and if so, return early
        if (isPopupShowing) {
            return
        }
        dismissCustomDialog()
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

    private fun showCustomPopupError(message: String) {
        // Check if the pop-up is already showing, and if so, return early
        if (isPopupShowing) {
            return
        }
dismissCustomDialog()
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

    }
    private fun createUserAccount() {
        showCustomProgressBar("Creating Account...", 2000)

        firebaseAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Account creation success
                    // Call updateUserInfo to save user info after creating the account
                    updateUserInfo()
                    firebaseAuth.signOut()
                    // Now, navigate to the Login activity
                    val intent = Intent(this, Login::class.java)
                    intent.putExtra("showSuccessPopup", true) // Set the flag to true
                    startActivity(intent)
                    finish()
                } else {
                    // Account creation failed
                    val errorMessage = task.exception?.message ?: "Unknown error occurred."
                    showCustomPopupError("Failed Creating Account due to $errorMessage")
                }
            }
    }


    private fun updateUserInfo() {

        val searchFragment = CivicPostFragment()
        val args = Bundle()
        args.putString("firstName", fname)
        searchFragment.arguments = args
        val timestamp = System.currentTimeMillis()
        val uid = firebaseAuth.uid

        val hashMap: HashMap<String, Any?> = HashMap()
        hashMap["uid"] = uid
        hashMap["firstname"] = fname
        hashMap["lastname"] = lname
        hashMap["email"] = email
        hashMap["phoneno"] = phoneno
        hashMap["ContactEme"] = phoneEme
        hashMap["address"] = address
        hashMap["birthday"] = birtdate
        hashMap["gender"] = spinnerSex
        hashMap["ImageProfile"] = ""
        hashMap["userType"] = "Student"
        hashMap["timestamp"] = timestamp
        hashMap["campus"] = selectedCampus

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, searchFragment)
            .commit()
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid!!)
            .setValue(hashMap)
            .addOnSuccessListener {
                val intent = Intent(this, Login::class.java)
                intent.putExtra("showSuccessPopup", true) // Set the flag to true
                startActivity(intent)
                finish()
            }
            .addOnFailureListener { e ->
                showCustomPopupError("Failed Saving User's Info due to ${e.message}")
            }
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup() // Clean up when the activity is destroyed
    }
}
