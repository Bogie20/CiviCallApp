package com.example.civicall

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
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
    private fun validateFirstName(): Boolean {
        val lastName = activityRegister1Binding.fname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (lastName.isEmpty()) {
            activityRegister1Binding.fname.error = "Required"
            return false
        } else if (!lastName.matches(regex.toRegex())) {
            activityRegister1Binding.fname.error =  "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            activityRegister1Binding.fname.error = null
            return true
        }
    }

    private fun validateLastName(): Boolean {
        val lastName = activityRegister1Binding.Lname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (lastName.isEmpty()) {
            activityRegister1Binding.Lname.error = "Required"
            return false
        } else if (!lastName.matches(regex.toRegex())) {
            activityRegister1Binding.Lname.error=  "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            activityRegister1Binding.Lname.error = null
            return true
        }
    }

    private fun validateEmail(): Boolean {
        val email = activityRegister1Binding.Emailline.text.toString().trim()
        if (email.isEmpty()) {
            activityRegister1Binding.Emailline.error = "Email is required"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            activityRegister1Binding.Emailline.error = "Invalid email format"
            return false
        }
        return true
    }

    private fun validateConfirmPassword(): Boolean {
        val password = activityRegister1Binding.confirmPass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegister1Binding.confirmPass.error = "Required"
            return false
        }
        return true
    }

    private fun validatePassword(): Boolean {
        val password = activityRegister1Binding.pass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegister1Binding.pass.error = "Password is required"
            return false
        } else if (password.length < 8) {
            activityRegister1Binding.pass.error = "Password must be at least 8 characters long"
            return false
        } else if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d).+\$".toRegex())) {
            activityRegister1Binding.pass.error = "Password must contain both letters and numbers"
            return false
        }
        return true
    }

    private fun validateContactNumber(): Boolean {
        val contactNumber = activityRegister1Binding.Contactline.text.toString().trim()

        if (contactNumber.isEmpty()) {
            activityRegister1Binding.Contactline.error = "Please enter Contact Number"
            return false
        } else if (!isValidPhoneNumber(contactNumber)) {
            activityRegister1Binding.Contactline.error = "Invalid Contact Number"
            return false
        }
        return true
    }

    private fun isValidPhoneNumber(contactNumber: String): Boolean {
        val sanitizedNumber = contactNumber.replace("\\s".toRegex(), "")

        return if (sanitizedNumber.startsWith("+63")) {
            sanitizedNumber.length == 13
        } else if (sanitizedNumber.startsWith("09")) {
            sanitizedNumber.length == 11
        } else {
            false
        }
    }

    private fun validateContactEme(): Boolean {
        val contactNum = activityRegister1Binding.ContactEme.text.toString().trim()

        if (contactNum.isEmpty()) {
            activityRegister1Binding.ContactEme.error = "Please enter Contact Person"
            return false
        } else if (!isValidPhoneEme(contactNum)) {
            activityRegister1Binding.ContactEme.error = "Invalid Contact Person"
            return false
        }
        return true
    }

    private fun isValidPhoneEme(contactNum: String): Boolean {
        val sanitizedNum = contactNum.replace("\\s".toRegex(), "")

        return if (sanitizedNum.startsWith("+63")) {
            sanitizedNum.length == 13
        } else if (sanitizedNum.startsWith("09")) {
            sanitizedNum.length == 11
        } else {
            false
        }
    }

    private fun validateAddress(): Boolean {
        val address = activityRegister1Binding.address.text.toString().trim()

        if (address.isEmpty()) {
            activityRegister1Binding.address.error = "Address is required"
            return false
        } else if (address.length < 5) {
            activityRegister1Binding.address.error = "Address is too short"
            return false
        }
        return true
    }

    private fun validateBirthday(): Boolean {
        val birthday = activityRegister1Binding.birthdate.text.toString().trim()
        val birthdateTextInputLayout = activityRegister1Binding.birthdateTextInputLayout

        if (birthday.isEmpty()) {
            birthdateTextInputLayout.error = null
            birthdateTextInputLayout.helperText = "*required"
            return false
        }
        return true
    }

    private fun validatePasswordMatch(): Boolean {
        val password = activityRegister1Binding.pass.text.toString().trim()
        val confirmPassword = activityRegister1Binding.confirmPass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegister1Binding.pass.error = "Please Enter Password"
            return false
        } else if (confirmPassword.isEmpty()) {
            activityRegister1Binding.confirmPass.error = "Please Confirm Password"
            return false
        } else if (password != confirmPassword) {
            activityRegister1Binding.confirmPass.error = "Passwords do not match"
            return false
        }
        return true
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

        val campusAdapter = ArrayAdapter(this, R.layout.dropdown_item, campusOptions) // Create an ArrayAdapter with your options
        campusAutoCompleteTextView.setAdapter(campusAdapter) // Set the adapter for the AutoCompleteTextView

// For the "Gender" field
        val spinnerSexAutoCompleteTextView = activityRegister1Binding.spinnerSex
        val sexOptions = resources.getStringArray(R.array.gender_array)

        val sexAdapter = ArrayAdapter(this, R.layout.dropdown_item, sexOptions) // Create an ArrayAdapter with your options
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
            validateData()
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

        val checkBox = findViewById<CheckBox>(R.id.checkedTextView)
        val errorMessages = mutableListOf<String>()

        if (!validateFirstName()) {
            errorMessages.add("Please enter a valid first name")
        }

        if (!validateLastName()) {
            errorMessages.add("Please enter a valid last name")
        }

        if (!validateEmail()) {
            errorMessages.add("Please enter a valid email")
        }

        if (!validatePassword()) {
            errorMessages.add("Please enter a valid password")
        }

        if (!validateConfirmPassword()) {
            errorMessages.add("Please confirm your password")
        }

        if (!validateContactNumber()) {
            errorMessages.add("Please enter a valid contact number")
        }

        if (!validateContactEme()) {
            errorMessages.add("Please enter a valid contact person")
        }

        if (!validateAddress()) {
            errorMessages.add("Please enter a valid address")
        }
        if (!validatePasswordMatch()) {
            errorMessages.add("Password Not Match")
        }
        if (!checkBox.isChecked) {
            errorMessages.add("Please accept the terms and conditions")
        }

        if (selectedCampus.isEmpty()) {
            errorMessages.add("Please select a campus")
        }

        if (spinnerSex.isEmpty()) {
            errorMessages.add("Please select a gender")
        }

        if (birtdate.isNotEmpty()) {
            val dobParts = birtdate.split(" / ")
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
                    errorMessages.add("You must be at least 18 years old to register")
                }
            } else {
                errorMessages.add("Invalid Date of Birth format")
            }
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
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_popup, null)
        dialogBuilder.setView(dialogView)

        val alertDialog = dialogBuilder.create()

        val messageTextView = dialogView.findViewById<TextView>(R.id.popupMessageTextView)
        val okButton = dialogView.findViewById<Button>(R.id.popupOkButton)

        messageTextView.text = message

        okButton.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun createUserAccount() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.loading_layout, null)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false) // Prevent users from dismissing the dialog

        val accountCreationDialog = dialogBuilder.create()
        val progressMessage = dialogView.findViewById<TextView>(R.id.messageTextView)
        progressMessage.text = "Creating Account..." // Set the initial message

        accountCreationDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                accountCreationDialog.dismiss()

                if (task.isSuccessful) {
                    // Account creation success
                    updateUserInfo()
                } else {
                    // Account creation failed
                    val errorMessage = task.exception?.message ?: "Unknown error occurred."
                    Toast.makeText(
                        this,
                        "Failed Creating Account due to $errorMessage",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
    private fun updateUserInfo() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.loading_layout, null)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false) // Prevent users from dismissing the dialog

        val userInfoUpdateDialog = dialogBuilder.create()
        val progressMessage = dialogView.findViewById<TextView>(R.id.messageTextView)
        progressMessage.text = "Saving User Info..." // Set the initial message

        userInfoUpdateDialog.show()
        userInfoUpdateDialog.dismiss()
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
                userInfoUpdateDialog.dismiss()
                Toast.makeText(this, "Account Created!", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, Login::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                userInfoUpdateDialog.dismiss()
                Toast.makeText(
                    this,
                    "Failed Saving User's Info due to ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
    }
}