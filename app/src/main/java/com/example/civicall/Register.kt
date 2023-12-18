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
import com.example.civicall.CivicEngagementPost.CivicPostFragment
import com.example.civicall.databinding.ActivityRegister1Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.TimeZone

class Register : AppCompatActivity() {
    private lateinit var activityRegister1Binding: ActivityRegister1Binding
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
        val firstName = activityRegister1Binding.fname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (firstName.isEmpty()) {
            activityRegister1Binding.fnameTextInputLayout.error = "Required"
            return false
        } else if (!firstName.matches(regex.toRegex())) {
            activityRegister1Binding.fnameTextInputLayout.error =
                "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            activityRegister1Binding.fnameTextInputLayout.error = null
            return true
        }
    }
    private fun validateMiddleName(): Boolean {
        val middleName = activityRegister1Binding.Mname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (middleName.isEmpty()) {
            activityRegister1Binding.MiddleNameTextInputLayout.error = "Required"
            return false
        } else if (!middleName.matches(regex.toRegex())) {
            activityRegister1Binding.MiddleNameTextInputLayout.error =
                "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            activityRegister1Binding.MiddleNameTextInputLayout.error = null
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
            activityRegister1Binding.birthdateTextInputLayout.error = "Date of Birth is Required"
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

    private fun validateCampus(): Boolean {
        val campus = activityRegister1Binding.campus.text.toString().trim()

        if (campus.isEmpty()) {
            activityRegister1Binding.campusTextInputLayout.error = "Please select your campus"
            return false
        } else {
            activityRegister1Binding.campusTextInputLayout.error = null
            return true
        }
    }
    private fun validateUserCategory(): Boolean {
        val userCategory = activityRegister1Binding.usercategory.text.toString().trim()

        if (userCategory.isEmpty()) {
            activityRegister1Binding.usercateTextInputLayout.error = "Please select a user category"
            return false
        } else {
            activityRegister1Binding.usercateTextInputLayout.error = null
            return true
        }
    }

    private fun validateGender(): Boolean {
        val gender = activityRegister1Binding.spinnerSex.text.toString().trim()

        if (gender.isEmpty()) {
            activityRegister1Binding.genderTextInputLayout.error = "Select a Gender"
            return false
        } else {
            activityRegister1Binding.genderTextInputLayout.error = null
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
        initialMiddleName = activityRegister1Binding.Mname.text.toString().trim()
        initialEmail = activityRegister1Binding.Emailline.text.toString().trim()
        initialPassword = activityRegister1Binding.pass.text.toString().trim()
        initialConfirmPassword = activityRegister1Binding.confirmPass.text.toString().trim()
        initialContactNumber = activityRegister1Binding.Contactline.text.toString().trim()
        initialAddress = activityRegister1Binding.address.text.toString().trim()
        initialBirthday = activityRegister1Binding.birthdate.text.toString().trim()
        initialCampus = activityRegister1Binding.campus.text.toString().trim()
        initialGender = activityRegister1Binding.spinnerSex.text.toString().trim()
        initialUserCategory = activityRegister1Binding.usercategory.text.toString().trim()

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

        val contactNumber = activityRegister1Binding.Contactline

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
        )
        campusAutoCompleteTextView.setAdapter(campusAdapter)
        // Set the adapter for the AutoCompleteTextView
        val usercategoryAutoCompleteTextView = activityRegister1Binding.usercategory
        val usercatOptions = resources.getStringArray(R.array.user_category)

        val usercategoryAdapter = ArrayAdapter(
            this,
            R.layout.dropdown_item,
            usercatOptions
        )
        usercategoryAutoCompleteTextView.setAdapter(usercategoryAdapter)
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
        val middleNameEditText = activityRegister1Binding.Mname
        val lastNameEditText = activityRegister1Binding.Lname
        val filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        val emailEditText = activityRegister1Binding.Emailline
        val emailFilters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxEmailLength))
        val contactNumberEditText = activityRegister1Binding.Contactline
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
        emailEditText.filters = emailFilters
        firstNameEditText.filters = filters
        middleNameEditText.filters = filters
        lastNameEditText.filters = filters
        contactNumber.inputType = InputType.TYPE_CLASS_PHONE

        val birthdayEditText = activityRegister1Binding.birthdate
        val campusEditText = activityRegister1Binding.campus
        val usercategoryEditText = activityRegister1Binding.usercategory
        val genderEditText = activityRegister1Binding.spinnerSex
        val confirmpassword = activityRegister1Binding.confirmPass

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

        activityRegister1Binding.backbtn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter,R.anim.animate_fade_exit)
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
                { _, year, month, dayOfMonth ->
                    val dateString = "${month + 1}/${dayOfMonth}/${year}"
                    birthday.setText(dateString)
                },
                Myear,
                Mmonth,
                day
            )
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
            activityRegister1Binding.birthdateTextInputLayout.error = null
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
        fname = activityRegister1Binding.fname.text.toString().trim()
        Mname = activityRegister1Binding.Mname.text.toString().trim()
        lname = activityRegister1Binding.Lname.text.toString().trim()
        email = activityRegister1Binding.Emailline.text.toString().trim()
        pass = activityRegister1Binding.pass.text.toString().trim()
        confirmPass = activityRegister1Binding.confirmPass.text.toString().trim()
        phoneno = activityRegister1Binding.Contactline.text.toString().trim()
        address = activityRegister1Binding.address.text.toString().trim()
        birtdate = activityRegister1Binding.birthdate.text.toString().trim()
        spinnerSex = activityRegister1Binding.spinnerSex.text.toString()
        userCategory = activityRegister1Binding.usercategory.text.toString()
        selectedCampus = activityRegister1Binding.campus.text.toString()


        activityRegister1Binding.fnameTextInputLayout.error = null
        activityRegister1Binding.MiddleNameTextInputLayout.error = null
        activityRegister1Binding.lastNameTextInputLayout.error = null
        activityRegister1Binding.emailTextInputLayout.error = null
        activityRegister1Binding.passwordTextInputLayout.error = null
        activityRegister1Binding.confirmPassword.error = null
        activityRegister1Binding.contactNumberTextInputLayout.error = null
        activityRegister1Binding.addressTextInputLayout.error = null
        activityRegister1Binding.birthdateTextInputLayout.error = null
        activityRegister1Binding.campusTextInputLayout.error = null
        activityRegister1Binding.usercateTextInputLayout.error = null
        activityRegister1Binding.spinnerSex.error = null

        val checkedTextView = findViewById<CheckBox>(R.id.checkedTextView)
        val errorMessages = mutableListOf<String>()
        if (!validateFirstName() || !validateMiddleName() || !validateUserCategory() || !validateLastName() || !validateCampus() || !validateGender() || !validateAddress() || !validateBirthday() || !validatePasswordMatch() || !validateEmail() || !validatePassword() || !validateConfirmPassword() || !validateContactNumber()) {
            errorMessages.add("Please provide valid information for the following fields.")
        }
        else if (!checkedTextView.isChecked()) {
            errorMessages.add("Please Accept the terms and Condition")
        }

        val campusAutoCompleteTextView = activityRegister1Binding.campus

        campusAutoCompleteTextView.setOnItemClickListener { _, _, _, _ ->
            // Clear the error message when a valid selection is made
            activityRegister1Binding.campusTextInputLayout.error = null
        }

        val usercategoryAutoCompleteTextView = activityRegister1Binding.usercategory

        usercategoryAutoCompleteTextView.setOnItemClickListener { _, _, _, _ ->
            // Clear the error message when a valid selection is made
            activityRegister1Binding.usercateTextInputLayout.error = null
        }
        val spinnerSexAutoCompleteTextView = activityRegister1Binding.spinnerSex

        spinnerSexAutoCompleteTextView.setOnItemClickListener { _, _, _, _ ->
            // Clear the error message when a valid selection is made
            activityRegister1Binding.genderTextInputLayout.error = null
        }

        if (!validateFirstName()) {
            activityRegister1Binding.fnameTextInputLayout.error = "Please enter a valid first name"
        }
        if (!validateMiddleName()) {
            activityRegister1Binding.MiddleNameTextInputLayout.error = "Please enter a valid middle name"
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

        if (!validateAddress()) {
            activityRegister1Binding.addressTextInputLayout.error = "Please enter a valid address"
        }


        if (selectedCampus.isEmpty()) {
            activityRegister1Binding.campusTextInputLayout.error = "Please select a campus"
        }
        if (userCategory.isEmpty()) {
            activityRegister1Binding.usercateTextInputLayout.error = "Please select a category"
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
        alertDialog.setOnDismissListener {
            // Reset the flag when dismissing the dialog
            isPopupShowing = false
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

        val dateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm z")
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
}
