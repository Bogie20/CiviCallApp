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
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Patterns
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.example.civicall.CivicEngagementPost.CivicPostFragment
import com.example.civicall.databinding.ActivityRegisterBinding
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.TimeZone

class Register : AppCompatActivity() {
    private lateinit var activityRegisterBinding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog
    private var initialFirstName = ""
    private var initialLastName = ""
    private var initialEmail = ""
    private var initialPassword = ""
    private var initialConfirmPassword = ""
    private var initialContactNumber = ""
    private var initialMiddleName = ""
    private var initialAddress = ""
    private var initialBirthday = ""
    private var initialCampus = ""
    private var initialGender = ""
    private var initialUserCategory = ""
    private var isPopupShowing = false
    private lateinit var networkUtils: NetworkUtils

    private fun validateFirstName(): Boolean {
        val firstName = activityRegisterBinding.fname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (firstName.isEmpty()) {
            activityRegisterBinding.fnameTextInputLayout.error = "Required"
            return false
        } else if (!firstName.matches(regex.toRegex())) {
            activityRegisterBinding.fnameTextInputLayout.error =
                "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            activityRegisterBinding.fnameTextInputLayout.error = null
            return true
        }
    }
    private fun validateMiddleName(): Boolean {
        val middleName = activityRegisterBinding.Mname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (middleName.isEmpty()) {
            activityRegisterBinding.MiddleNameTextInputLayout.error = "Required"
            return false
        } else if (!middleName.matches(regex.toRegex())) {
            activityRegisterBinding.MiddleNameTextInputLayout.error =
                "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            activityRegisterBinding.MiddleNameTextInputLayout.error = null
            return true
        }
    }

    private fun validateLastName(): Boolean {
        val lastName = activityRegisterBinding.Lname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (lastName.isEmpty()) {
            activityRegisterBinding.lastNameTextInputLayout.error = "Required"
            return false
        } else if (!lastName.matches(regex.toRegex())) {
            activityRegisterBinding.lastNameTextInputLayout.error =
                "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            activityRegisterBinding.lastNameTextInputLayout.error = null
            return true
        }
    }

    private fun validateEmail(): Boolean {
        val email = activityRegisterBinding.Emailline.text.toString().trim()
        if (email.isEmpty()) {
            activityRegisterBinding.emailTextInputLayout.error = "Email is required"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            activityRegisterBinding.emailTextInputLayout.error = "Invalid email format"
            return false
        } else {
            activityRegisterBinding.emailTextInputLayout.error = null
            return true
        }
    }

    private fun validateConfirmPassword(): Boolean {
        val password = activityRegisterBinding.confirmPass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegisterBinding.confirmPassword.error = "Required"
            return false
        } else {
            activityRegisterBinding.confirmPassword.error = null
            return true
        }
    }


    private fun validatePassword(): Boolean {
        val password = activityRegisterBinding.pass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegisterBinding.passwordTextInputLayout.error = "Password is required"
            return false
        } else if (password.length < 8) {
            activityRegisterBinding.passwordTextInputLayout.error =
                "Password must be at least 8 characters long"
            return false
        } else if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d).+\$".toRegex())) {
            activityRegisterBinding.passwordTextInputLayout.error =
                "Password must contain both letters and numbers"
            return false
        } else {
            activityRegisterBinding.passwordTextInputLayout.error = null
            return true
        }
    }


    private fun validateContactNumber(): Boolean {
        val contactNumber = activityRegisterBinding.Contactline.text.toString().trim()

        if (contactNumber.isEmpty()) {
            activityRegisterBinding.contactNumberTextInputLayout.error =
                "Please enter Contact Number"
            return false
        } else if (!isValidPhoneNumber(contactNumber)) {
            activityRegisterBinding.contactNumberTextInputLayout.error = "Invalid Contact Number"
            return false
        } else {
            activityRegisterBinding.contactNumberTextInputLayout.error = null
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

    private fun validateAddress(): Boolean {
        val address = activityRegisterBinding.address.text.toString().trim()

        if (address.isEmpty()) {
            activityRegisterBinding.addressTextInputLayout.error = "Address is required"
            return false
        } else if (address.length < 5) {
            activityRegisterBinding.addressTextInputLayout.error = "Address is too short"
            return false
        } else {
            activityRegisterBinding.addressTextInputLayout.error = null
            return true
        }
    }


    private fun validateBirthday(): Boolean {
        val birthday = activityRegisterBinding.birthdate.text.toString().trim()
        val birthdateTextInputLayout = activityRegisterBinding.birthdateTextInputLayout

        if (birthday.isEmpty()) {
            birthdateTextInputLayout.error = null
            activityRegisterBinding.birthdateTextInputLayout.error = "Date of Birth is Required"
            return false
        } else {
            val dobParts = birthday.split("/")
            if (dobParts.size == 3) {
                val month = dobParts[0].toInt()
                val day = dobParts[1].toInt()
                val year = dobParts[2].toInt()

                val calendar = Calendar.getInstance()
                val currentYear = calendar.get(Calendar.YEAR)
                val currentMonth = calendar.get(Calendar.MONTH) + 1
                val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

                val age =
                    currentYear - year - if (currentMonth < month || (currentMonth == month && currentDay < day)) 1 else 0

                if (age < 18) {
                    activityRegisterBinding.birthdateTextInputLayout.error =
                        "You must be at least 18 years old to register"
                    return false
                }
            } else {
                activityRegisterBinding.birthdateTextInputLayout.error =
                    "Invalid Date of Birth format"
                return false
            }

            // Clear the error message when valid input is provided
            activityRegisterBinding.birthdateTextInputLayout.error = null
            return true
        }
    }

    private fun validateCampus(): Boolean {
        val campus = activityRegisterBinding.campus.text.toString().trim()

        if (campus.isEmpty()) {
            activityRegisterBinding.campusTextInputLayout.error = "Please select your campus"
            return false
        } else {
            activityRegisterBinding.campusTextInputLayout.error = null
            return true
        }
    }
    private fun validateUserCategory(): Boolean {
        val userCategory = activityRegisterBinding.usercategory.text.toString().trim()

        if (userCategory.isEmpty()) {
            activityRegisterBinding.usercateTextInputLayout.error = "Please select a user category"
            return false
        } else {
            activityRegisterBinding.usercateTextInputLayout.error = null
            return true
        }
    }

    private fun validateGender(): Boolean {
        val gender = activityRegisterBinding.spinnerSex.text.toString().trim()

        if (gender.isEmpty()) {
            activityRegisterBinding.genderTextInputLayout.error = "Select a Gender"
            return false
        } else {
            activityRegisterBinding.genderTextInputLayout.error = null
            return true
        }
    }
    private fun validatePasswordMatch(): Boolean {
        val password = activityRegisterBinding.pass.text.toString().trim()
        val confirmPassword = activityRegisterBinding.confirmPass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegisterBinding.passwordTextInputLayout.error = "Please Enter Password"
            return false
        } else if (confirmPassword.isEmpty()) {
            activityRegisterBinding.confirmPassword.error = "Please Confirm Password"
            return false
        } else if (password != confirmPassword) {
            activityRegisterBinding.confirmPassword.error = "Passwords do not match"
            return false
        } else {
            activityRegisterBinding.confirmPassword.error = null
            return true
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(activityRegisterBinding.root)

        initialFirstName = activityRegisterBinding.fname.text.toString().trim()
        initialLastName = activityRegisterBinding.Lname.text.toString().trim()
        initialMiddleName = activityRegisterBinding.Mname.text.toString().trim()
        initialEmail = activityRegisterBinding.Emailline.text.toString().trim()
        initialPassword = activityRegisterBinding.pass.text.toString().trim()
        initialConfirmPassword = activityRegisterBinding.confirmPass.text.toString().trim()
        initialContactNumber = activityRegisterBinding.Contactline.text.toString().trim()
        initialAddress = activityRegisterBinding.address.text.toString().trim()
        initialBirthday = activityRegisterBinding.birthdate.text.toString().trim()
        initialCampus = activityRegisterBinding.campus.text.toString().trim()
        initialGender = activityRegisterBinding.spinnerSex.text.toString().trim()
        initialUserCategory = activityRegisterBinding.usercategory.text.toString().trim()

        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        val termsAndPrivacyTextView: TextView = findViewById(R.id.rightTextView)

        // Create a SpannableString
        val spannableString = SpannableString("I have read and agree to the Terms and Conditions and Privacy Policy")

        // Create ClickableSpan for Terms and Conditions
        val termsClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Handle click for Terms and Conditions
                startActivity(Intent(this@Register, TermsAndConditions::class.java))
            }
        }

        spannableString.setSpan(termsClickableSpan, 29, 48, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(android.text.style.ForegroundColorSpan(resources.getColor(R.color.colorAccent)), 30, 49, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Create ClickableSpan for Privacy Policy
        val privacyClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                startActivity(Intent(this@Register, PrivacyAndPolicies::class.java))
            }
        }

        spannableString.setSpan(privacyClickableSpan, 54, spannableString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(android.text.style.ForegroundColorSpan(resources.getColor(R.color.colorAccent)), 54, spannableString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        termsAndPrivacyTextView.text = spannableString
        termsAndPrivacyTextView.movementMethod = LinkMovementMethod.getInstance()

        val contactNumber = activityRegisterBinding.Contactline

        val maxLength = 80
        val maxEmailLength = 320
        val maxContactLength = 20
        val maxAddressLength = 255
        val maxPasswordLength = 128
// For the "Campus" field
        val campusAutoCompleteTextView = activityRegisterBinding.campus
        val campusOptions = resources.getStringArray(R.array.allowed_campuses)

        val campusAdapter = ArrayAdapter(
            this,
            R.layout.dropdown_item,
            campusOptions
        )
        campusAutoCompleteTextView.setAdapter(campusAdapter)
        // Set the adapter for the AutoCompleteTextView
        val usercategoryAutoCompleteTextView = activityRegisterBinding.usercategory
        val usercatOptions = resources.getStringArray(R.array.user_category)

        val usercategoryAdapter = ArrayAdapter(
            this,
            R.layout.dropdown_item,
            usercatOptions
        )
        usercategoryAutoCompleteTextView.setAdapter(usercategoryAdapter)
// For the "Gender" field
        val spinnerSexAutoCompleteTextView = activityRegisterBinding.spinnerSex
        val sexOptions = resources.getStringArray(R.array.gender_array)

        val sexAdapter = ArrayAdapter(
            this,
            R.layout.dropdown_item,
            sexOptions
        ) // Create an ArrayAdapter with your options
        spinnerSexAutoCompleteTextView.setAdapter(sexAdapter) // Set the adapter for the AutoCompleteTextView


        val firstNameEditText = activityRegisterBinding.fname
        val middleNameEditText = activityRegisterBinding.Mname
        val lastNameEditText = activityRegisterBinding.Lname
        val filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        val emailEditText = activityRegisterBinding.Emailline
        val emailFilters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxEmailLength))
        val contactNumberEditText = activityRegisterBinding.Contactline
        val contactFilters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxContactLength))
        val addressEditText = activityRegisterBinding.address
        val addressFilters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxAddressLength))
        val passwordEditText = activityRegisterBinding.pass
        val confirmPasswordEditText = activityRegisterBinding.confirmPass
        val passwordFilters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxPasswordLength))
        passwordEditText.filters = passwordFilters
        confirmPasswordEditText.filters = passwordFilters
        addressEditText.filters = addressFilters
        contactNumberEditText.filters = contactFilters
        emailEditText.filters = emailFilters
        firstNameEditText.filters = filters
        middleNameEditText.filters = filters
        lastNameEditText.filters = filters
        contactNumber.inputType = InputType.TYPE_CLASS_PHONE

        val birthdayEditText = activityRegisterBinding.birthdate
        val campusEditText = activityRegisterBinding.campus
        val usercategoryEditText = activityRegisterBinding.usercategory
        val genderEditText = activityRegisterBinding.spinnerSex
        val confirmpassword = activityRegisterBinding.confirmPass

        firstNameEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateFirstName()
                // Set selection to initial input length
                firstNameEditText.setSelection(initialFirstName.length)
            }
        }
        middleNameEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateMiddleName()
                // Set selection to initial input length
                middleNameEditText.setSelection(initialMiddleName.length)
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
        campusEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateCampus()
                campusEditText.setSelection(initialCampus.length)
            }
        }
        genderEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateGender()
                genderEditText.setSelection(initialGender.length)
            }
        }
        usercategoryEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateUserCategory()
                usercategoryEditText.setSelection(initialUserCategory.length)
            }
        }
        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait...")
        progressDialog.setCanceledOnTouchOutside(false)

        activityRegisterBinding.backbtn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            dismissCustomDialog()
            overridePendingTransition(R.anim.animate_fade_enter,R.anim.animate_fade_exit)
            onBackPressed()
        }
        val regbtn: Button = findViewById(R.id.Reg)
        regbtn.setOnClickListener {
            if (networkUtils.isOnline) {
                validateData()
            } else {
                if (!isNoInternetDialogShowing) {
                    dismissCustomDialog()
                    showNoInternetPopup()
                }
            }
        }


    val birthday = activityRegisterBinding.birthdate
        val cal = Calendar.getInstance()
        val Myear = cal.get(Calendar.YEAR)
        val Mmonth = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        var isDatePickerShowing = false // Initialize the flag

        birthday.setOnClickListener {
            // Check if the date picker dialog is already showing, and if so, return early
            if (isDatePickerShowing) {
                return@setOnClickListener
            }
            isDatePickerShowing = true

            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    val dateString = "${month + 1}/${dayOfMonth}/${year}"
                    birthday.setText(dateString)
                },
                Myear,
                Mmonth,
                day
            )

            datePickerDialog.setOnDismissListener {
                // Reset the flag when dismissing the date picker dialog
                isDatePickerShowing = false
            }

            datePickerDialog.show()
        }


        fun addTextChangeListenerWithDelay(editText: EditText, validationFunction: () -> Unit, delayMillis: Long) {
            val handler = Handler(Looper.getMainLooper())

            val textWatcher = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    handler.removeCallbacksAndMessages(null) // Remove previous callbacks
                    handler.postDelayed({
                        validationFunction()
                    }, delayMillis)
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            }

            editText.addTextChangedListener(textWatcher)
        }
        addTextChangeListenerWithDelay(firstNameEditText, { validateFirstName() }, 500) // Delay of 500 milliseconds
        addTextChangeListenerWithDelay(middleNameEditText, { validateMiddleName() }, 500)
        addTextChangeListenerWithDelay(lastNameEditText, { validateLastName() }, 500)
        addTextChangeListenerWithDelay(emailEditText, { validateEmail() }, 1000)
        addTextChangeListenerWithDelay(passwordEditText, { validatePassword() }, 1000)
        addTextChangeListenerWithDelay(confirmPasswordEditText, { validateConfirmPassword() }, 500)
        addTextChangeListenerWithDelay(contactNumberEditText, { validateContactNumber() }, 1000)
        addTextChangeListenerWithDelay(addressEditText, { validateAddress() }, 500)
        addTextChangeListenerWithDelay(birthdayEditText, {
            // Clear the error message when valid input is provided
            activityRegisterBinding.birthdateTextInputLayout.error = null
        }, 500)
    }

    private var fname = ""
    private var Mname = ""
    private var lname = ""
    private var email = ""
    private var pass = ""
    private var confirmPass = ""
    private var phoneno = ""
    private var address = ""
    private var birtdate = ""
    private var selectedCampus = ""
    private var userCategory = ""
    private var spinnerSex = ""

    private fun validateData() {
        fname = activityRegisterBinding.fname.text.toString().trim()
        Mname = activityRegisterBinding.Mname.text.toString().trim()
        lname = activityRegisterBinding.Lname.text.toString().trim()
        email = activityRegisterBinding.Emailline.text.toString().trim()
        pass = activityRegisterBinding.pass.text.toString().trim()
        confirmPass = activityRegisterBinding.confirmPass.text.toString().trim()
        phoneno = activityRegisterBinding.Contactline.text.toString().trim()
        address = activityRegisterBinding.address.text.toString().trim()
        birtdate = activityRegisterBinding.birthdate.text.toString().trim()
        spinnerSex = activityRegisterBinding.spinnerSex.text.toString()
        userCategory = activityRegisterBinding.usercategory.text.toString()
        selectedCampus = activityRegisterBinding.campus.text.toString()


        activityRegisterBinding.fnameTextInputLayout.error = null
        activityRegisterBinding.MiddleNameTextInputLayout.error = null
        activityRegisterBinding.lastNameTextInputLayout.error = null
        activityRegisterBinding.emailTextInputLayout.error = null
        activityRegisterBinding.passwordTextInputLayout.error = null
        activityRegisterBinding.confirmPassword.error = null
        activityRegisterBinding.contactNumberTextInputLayout.error = null
        activityRegisterBinding.addressTextInputLayout.error = null
        activityRegisterBinding.birthdateTextInputLayout.error = null
        activityRegisterBinding.campusTextInputLayout.error = null
        activityRegisterBinding.usercateTextInputLayout.error = null
        activityRegisterBinding.spinnerSex.error = null

        val checkedTextView = findViewById<CheckBox>(R.id.checkedTextView)
        val errorMessages = mutableListOf<String>()
        if (!validateFirstName() || !validateMiddleName() || !validateUserCategory() || !validateLastName() || !validateCampus() || !validateGender() || !validateAddress() || !validateBirthday() || !validatePasswordMatch() || !validateEmail() || !validatePassword() || !validateConfirmPassword() || !validateContactNumber()) {
            errorMessages.add("Please provide valid information for the following fields.")
        }
        else if (!checkedTextView.isChecked()) {
            errorMessages.add("Please Accept the terms and Condition")
        }

        val campusAutoCompleteTextView = activityRegisterBinding.campus

        campusAutoCompleteTextView.setOnItemClickListener { _, _, _, _ ->
            // Clear the error message when a valid selection is made
            activityRegisterBinding.campusTextInputLayout.error = null
        }

        val usercategoryAutoCompleteTextView = activityRegisterBinding.usercategory

        usercategoryAutoCompleteTextView.setOnItemClickListener { _, _, _, _ ->
            // Clear the error message when a valid selection is made
            activityRegisterBinding.usercateTextInputLayout.error = null
        }
        val spinnerSexAutoCompleteTextView = activityRegisterBinding.spinnerSex

        spinnerSexAutoCompleteTextView.setOnItemClickListener { _, _, _, _ ->
            // Clear the error message when a valid selection is made
            activityRegisterBinding.genderTextInputLayout.error = null
        }

        if (!validateFirstName()) {
            activityRegisterBinding.fnameTextInputLayout.error = "Please enter a valid first name"
        }
        if (!validateMiddleName()) {
            activityRegisterBinding.MiddleNameTextInputLayout.error = "Please enter a valid middle name"
        }

        if (!validateLastName()) {
            activityRegisterBinding.lastNameTextInputLayout.error =
                "Please enter a valid last name"
        }

        if (!validateEmail()) {
            activityRegisterBinding.emailTextInputLayout.error = "Please enter a valid email"
        }

        if (!validatePassword()) {
            activityRegisterBinding.passwordTextInputLayout.error = "Please enter a valid password"
        }

        if (!validateConfirmPassword()) {
            activityRegisterBinding.confirmPassword.error = "Please confirm your password"
        }

        if (!validateContactNumber()) {
            activityRegisterBinding.contactNumberTextInputLayout.error =
                "Please enter a valid contact number"
        }

        if (!validateAddress()) {
            activityRegisterBinding.addressTextInputLayout.error = "Please enter a valid address"
        }


        if (selectedCampus.isEmpty()) {
            activityRegisterBinding.campusTextInputLayout.error = "Please select a campus"
        }
        if (userCategory.isEmpty()) {
            activityRegisterBinding.usercateTextInputLayout.error = "Please select a category"
        }

        if (spinnerSex.isEmpty()) {
            activityRegisterBinding.genderTextInputLayout.error = "Select a Gender"
        }
        if (birtdate.isEmpty()) {
            activityRegisterBinding.birthdateTextInputLayout.error = "Select Date of Birth"
        }



        validatePasswordMatch()


        if (errorMessages.isNotEmpty()) {
            for (message in errorMessages) {
                showCustomPopup(message)
            }
        } else {
            // Only create the user account if there are no validation errors
            showSaveConfirmationDialog()
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
        alertDialog.setOnDismissListener {
            // Reset the flag when dismissing the dialog
            isPopupShowing = false
        }

        alertDialog.show()
        isPopupShowing = true // Set the variable to true when the pop-up is displayed
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
        alertDialog.setOnDismissListener {
            // Reset the flag when dismissing the dialog
            isPopupShowing = false
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
        logoutMsg.text = "Are you sure about the inputs you provided for registration?"

        saveBtn.text = "Save"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()


            createUserAccount()
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
    private fun dismissCustomDialog() {
        if (isPopupShowing) {

            isPopupShowing = false
        }

        if (isProgressBarShowing) {

            isProgressBarShowing = false
        }
        if (isSaveConfirmationDialogShowing) {

            isSaveConfirmationDialogShowing = false
        }
        if (isNoInternetDialogShowing) {

            isNoInternetDialogShowing = false
        }

    }
    private fun createUserAccount() {
        showCustomProgressBar("Creating Account...", 2000)

        firebaseAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    updateUserInfo()

                    val intent = Intent(this, Login::class.java)
                    intent.putExtra("showSuccessPopup", true)
                    startActivity(intent)
                    finish()
                    firebaseAuth.signOut()
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

        val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a")
        dateFormat.timeZone = TimeZone.getTimeZone("Asia/Manila")
        val formattedDate = dateFormat.format(timestamp)

        val hashMap: HashMap<String, Any?> = HashMap()
        hashMap["uid"] = uid
        hashMap["firstname"] = fname
        hashMap["middlename"] = Mname
        hashMap["lastname"] = lname
        hashMap["email"] = email
        hashMap["phoneno"] = phoneno
        hashMap["address"] = address
        hashMap["birthday"] = birtdate
        hashMap["gender"] = spinnerSex
        hashMap["lastLogin"] = ""
        hashMap["course"] = ""
        hashMap["nstp"] = ""
        hashMap["srcode"] = ""
        hashMap["ContactEme"] = ""
        hashMap["yearandSection"] = ""
        hashMap["ImageProfile"] = ""
        hashMap["userType"] = userCategory
        hashMap["timestamp"] = formattedDate
        hashMap["campus"] = selectedCampus
        hashMap["verificationStatus"] = false
        hashMap["CurrentEngagement"] = 0
        hashMap["activepts"] = 0
        hashMap["finishactivity"] = 0

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
    override fun onPause() {
        super.onPause()
        dismissCustomDialog()
    }
}
