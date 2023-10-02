package com.example.civicall

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import android.util.Patterns
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.CheckBox
import android.widget.TextView
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

    private fun validateFirstName() {
        val lastName = activityRegister1Binding.fname.text.toString().trim()

        val regex = "^[a-zA-Z.-]+$" // Regular expression to allow letters, '.', and '-'

        if (lastName.isEmpty()) {
            activityRegister1Binding.fname.error = "Required"
        } else if (!lastName.matches(regex.toRegex())) {
            activityRegister1Binding.fname.error =  "Only letters and symbols (, . -) are allowed"
        } else {
            activityRegister1Binding.fname.error = null
        }
    }



    private fun validateLastName() {
        val lastName = activityRegister1Binding.Lname.text.toString().trim()

        val regex = "^[a-zA-Z.-]+$" // Regular expression to allow letters, '.', and '-'

        if (lastName.isEmpty()) {
            activityRegister1Binding.Lname.error = "Required"
        } else if (!lastName.matches(regex.toRegex())) {
            activityRegister1Binding.Lname.error =  "Only letters and symbols (, . -) are allowed"
        } else {
            activityRegister1Binding.Lname.error = null
        }
    }

    private fun validateEmail() {
        val email = activityRegister1Binding.Emailline.text.toString().trim()
        if (email.isEmpty()) {
            activityRegister1Binding.Emailline.error = "Email is required"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            activityRegister1Binding.Emailline.error = "Invalid email format"
        } else {
            activityRegister1Binding.Emailline.error = null
        }
    }


    private fun validateConfirmPassword() {
        val password = activityRegister1Binding.confirmPass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegister1Binding.confirmPass.error = "Required"
        } else {
            activityRegister1Binding.confirmPass.error = null
        }
    }

    private fun validatePassword() {
        val password = activityRegister1Binding.pass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegister1Binding.pass.error = "Password is required"
        } else if (password.length < 8) {
            activityRegister1Binding.pass.error = "Password must be at least 8 characters long"
        } else if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d).+\$".toRegex())) {
            activityRegister1Binding.pass.error = "Password must contain both letters and numbers"
        } else {
            activityRegister1Binding.pass.error = null
        }
    }


    private fun validateContactNumber() {
        val contactNumber = activityRegister1Binding.Contactline.text.toString().trim()

        if (contactNumber.isEmpty()) {
            activityRegister1Binding.Contactline.error = "Please enter Contact Number"
        } else if (!isValidPhoneNumber(contactNumber)) {
            activityRegister1Binding.Contactline.error = "Invalid Contact Number"
        } else {
            activityRegister1Binding.Contactline.error = null
        }
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

    private fun validateContactEme() {
        val contactNum = activityRegister1Binding.ContactEme.text.toString().trim()

        if (contactNum.isEmpty()) {
            activityRegister1Binding.ContactEme.error = "Please enter Contact Person"
        } else if (!isValidPhoneEme(contactNum)) {
            activityRegister1Binding.ContactEme.error = "Invalid Contact Person"
        } else {
            activityRegister1Binding.ContactEme.error = null
        }
    }

    private fun isValidPhoneEme(contactNum: String): Boolean {
        // Remove spaces and special characters from the contact number
        val sanitizedNum = contactNum.replace("\\s".toRegex(), "")

        // Check if it starts with either "+63" or "0"
        return if (sanitizedNum.startsWith("+63")) {
            sanitizedNum.length == 13
        } else if (sanitizedNum.startsWith("09")) {
            sanitizedNum.length == 11
        } else {
            false
        }
    }

    private fun validateAddress() {
        val address = activityRegister1Binding.address.text.toString().trim()

        if (address.isEmpty()) {
            activityRegister1Binding.address.error = "Address is required"
        } else if (address.length < 5) {
            activityRegister1Binding.address.error = "Address is too short"
        } else {
            activityRegister1Binding.address.error = null
        }
    }
    private fun validateBirthday() {
        val birthday = activityRegister1Binding.birthdate.text.toString().trim()
        val birthdateTextInputLayout = activityRegister1Binding.birthdateTextInputLayout

        if (birthday.isEmpty()) {
            birthdateTextInputLayout.error = null // Set error to null when it's empty
            birthdateTextInputLayout.helperText = "*required"
        } else {
            birthdateTextInputLayout.error = null // Set error to null when it's not empty
            birthdateTextInputLayout.helperText = null
        }
    }


    private fun validatePasswordMatch() {
        val password = activityRegister1Binding.pass.text.toString().trim()
        val confirmPassword = activityRegister1Binding.confirmPass.text.toString().trim()

        if (password.isEmpty()) {
            activityRegister1Binding.pass.error = "Please Enter Password"
        } else if (confirmPassword.isEmpty()) {
            activityRegister1Binding.confirmPass.error = "Please Confirm Password"
        } else if (password != confirmPassword) {
            activityRegister1Binding.confirmPass.error = "Passwords do not match"
        } else {
            activityRegister1Binding.confirmPass.error = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        activityRegister1Binding = ActivityRegister1Binding.inflate(layoutInflater)
        setContentView(activityRegister1Binding.root)

        val genderSpinner = activityRegister1Binding.spinnerSex
        val genderArray = resources.getStringArray(R.array.gender_array).toMutableList()
        val campusSpinner = activityRegister1Binding.campus
        val campusArray = resources.getStringArray(R.array.allowed_campuses).toMutableList()

        val contactNumber = activityRegister1Binding.Contactline
        val contactEme = activityRegister1Binding.ContactEme
        genderArray.add(0, "Gender") // Add "Gender" as the first item in the list
        campusArray.add(0, "Select Your Campus")

        val maxLength = 80
        val maxEmailLength = 320
        val maxContactLength = 20
        val maxAddressLength = 255
        val maxPasswordLength = 128

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
// Gender Spinner
        val adapter = CustomSpinnerAdapter(
            this,
            R.layout.spinner_gender, // Use the custom layout here
            genderArray
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter

        val initialSelection = 0
        genderSpinner.setSelection(initialSelection)
        genderSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                spinnerSex = if (position == 0) {
                    "" // Set an empty string if "Gender" is selected
                } else {
                    parent?.getItemAtPosition(position).toString()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        // Campus Spinner
        val campusAdapter = CustomSpinnerAdapter(
            this,
            R.layout.spinner_campus, // Use the custom layout here
            campusArray
        )

        campusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        campusSpinner.adapter = campusAdapter

        val initialCampusSelection = 0
        campusSpinner.setSelection(initialCampusSelection)
        var selectedCampus = ""
        campusSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedCampus = if (position == 0) {
                    "" // Set an empty string if "Select Campus" is selected
                } else {
                    parent?.getItemAtPosition(position).toString()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedCampus = "" // Set an empty string if nothing is selected
            }
        }


        val birthdayEditText = activityRegister1Binding.birthdate
        val confirmpassword = activityRegister1Binding.confirmPass

        firstNameEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateFirstName()
            }
        }

        lastNameEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateLastName()
            }
        }

        emailEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateEmail()
            }
        }

        passwordEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validatePassword()
            }
        }
        confirmpassword.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateConfirmPassword()
            }
        }

        contactNumberEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateContactNumber()
            }
        }
        contactEmeEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateContactEme()
            }
        }

        addressEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateAddress()
            }
        }

        birthdayEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validateBirthday()
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
            validateBirthday()
            validateData()
        }

        emailEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                email = emailEditText.text.toString().trim()
            } else {
                passwordEditText.setText(pass)
                emailEditText.setText(email)
                addressEditText.setText(address)
                firstNameEditText.setText(fname)
                lastNameEditText.setText(lname)
                confirmPasswordEditText.setText(confirmPass)
                contactEmeEditText.setText(phoneEme)
                contactNumberEditText.setText(phoneno)

            }
        }

        passwordEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                pass = passwordEditText.text.toString().trim()
            } else {
                passwordEditText.setText(pass)
                emailEditText.setText(email)
                addressEditText.setText(address)
                firstNameEditText.setText(fname)
                lastNameEditText.setText(lname)
                confirmPasswordEditText.setText(confirmPass)
                contactEmeEditText.setText(phoneEme)
                contactNumberEditText.setText(phoneno)
            }
        }
        confirmPasswordEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                confirmPass = confirmPasswordEditText.text.toString().trim()
            } else {
                passwordEditText.setText(pass)
                emailEditText.setText(email)
                addressEditText.setText(address)
                firstNameEditText.setText(fname)
                lastNameEditText.setText(lname)
                confirmPasswordEditText.setText(confirmPass)
                contactEmeEditText.setText(phoneEme)
                contactNumberEditText.setText(phoneno)
            }
        }
        firstNameEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                fname = firstNameEditText.text.toString().trim()
            } else {
                passwordEditText.setText(pass)
                emailEditText.setText(email)
                addressEditText.setText(address)
                firstNameEditText.setText(fname)
                lastNameEditText.setText(lname)
                confirmPasswordEditText.setText(confirmPass)
                contactEmeEditText.setText(phoneEme)
                contactNumberEditText.setText(phoneno)
            }
        }

        lastNameEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                lname = lastNameEditText.text.toString().trim()
            } else {
                passwordEditText.setText(pass)
                emailEditText.setText(email)
                addressEditText.setText(address)
                firstNameEditText.setText(fname)
                lastNameEditText.setText(lname)
                confirmPasswordEditText.setText(confirmPass)
                contactEmeEditText.setText(phoneEme)
                contactNumberEditText.setText(phoneno)
            }

        }
        addressEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                address = addressEditText.text.toString().trim()
            } else {
                passwordEditText.setText(pass)
                emailEditText.setText(email)
                addressEditText.setText(address)
                firstNameEditText.setText(fname)
                lastNameEditText.setText(lname)
                confirmPasswordEditText.setText(confirmPass)
                contactEmeEditText.setText(phoneEme)
                contactNumberEditText.setText(phoneno)
            }

        }
        contactNumberEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                phoneno = contactNumberEditText.text.toString().trim()
            } else {
                passwordEditText.setText(pass)
                emailEditText.setText(email)
                addressEditText.setText(address)
                firstNameEditText.setText(fname)
                lastNameEditText.setText(lname)
                confirmPasswordEditText.setText(confirmPass)
                contactEmeEditText.setText(phoneEme)
                contactNumberEditText.setText(phoneno)
            }

        }
        contactEmeEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                phoneEme = contactEmeEditText.text.toString().trim()
            } else {
                passwordEditText.setText(pass)
                emailEditText.setText(email)
                addressEditText.setText(address)
                firstNameEditText.setText(fname)
                lastNameEditText.setText(lname)
                confirmPasswordEditText.setText(confirmPass)
                contactEmeEditText.setText(phoneEme)
                contactNumberEditText.setText(phoneno)
            }
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
        spinnerSex = activityRegister1Binding.spinnerSex.selectedItem.toString()
        selectedCampus = activityRegister1Binding.campus.selectedItem.toString()

        val checkBox = findViewById<CheckBox>(R.id.checkedTextView)
        val campusSpinner = activityRegister1Binding.campus
        val errorMessages = mutableListOf<String>()

        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || phoneno.isEmpty() ||
            phoneEme.isEmpty() || address.isEmpty() || birtdate.isEmpty() || spinnerSex.equals("Gender") || selectedCampus.equals("Select Your Campus") ||
            !checkBox.isChecked()) {
            errorMessages.add("Please Fill All the Fields");
        }
            if (fname.isEmpty()) {
                activityRegister1Binding.fname.error = "Required"
            } else {
                activityRegister1Binding.fname.error = null
            }
            if (lname.isEmpty()) {
                activityRegister1Binding.Lname.error = "Required"
            } else {
                activityRegister1Binding.Lname.error = null
            }
            if (email.isEmpty()) {
                activityRegister1Binding.Emailline.error = "Email is required"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                activityRegister1Binding.Emailline.error = "Invalid email format"
            } else {
                activityRegister1Binding.Emailline.error = null
            }
            if (phoneno.isEmpty() || !isValidPhoneNumber(phoneno)) {
                activityRegister1Binding.Contactline.error = if (phoneno.isEmpty()) {
                    "Please enter Contact Number"
                } else {
                    "Invalid Contact Number"
                }
            } else {
                activityRegister1Binding.Contactline.error = null
            }
            if (phoneEme.isEmpty() || !isValidPhoneEme(phoneEme)) {
                activityRegister1Binding.ContactEme.error = if (phoneEme.isEmpty()) {
                    "Please enter Contact Person"
                } else {
                    "Invalid Contact Person"
                }
            } else {
                activityRegister1Binding.ContactEme.error = null
            }
            if (address.isEmpty()) {
                activityRegister1Binding.address.error = "Required"
            } else {
                activityRegister1Binding.address.error = null
            }
            if (birtdate.isEmpty()) {
                activityRegister1Binding.birthdate.error = "Required"
            } else {
                activityRegister1Binding.birthdate.error = null
            }

        if (spinnerSex.isEmpty() || spinnerSex == "Gender") {
            val genderTextInputLayout = activityRegister1Binding.genderTextInputLayout
            genderTextInputLayout.error = "Please select a Gender"
        } else {
            val genderTextInputLayout = activityRegister1Binding.genderTextInputLayout
            genderTextInputLayout.error = null
        }
        if (selectedCampus.isEmpty() || selectedCampus == "Select Your Campus") {
            val campusTextInputLayout = activityRegister1Binding.campusTextInputLayout
            campusTextInputLayout.error = "Please select your Campus"
        } else {
            val campusTextInputLayout = activityRegister1Binding.campusTextInputLayout
            campusTextInputLayout.error = null
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

                val age = currentYear - year - if (currentMonth < month || (currentMonth == month && currentDay < day)) 1 else 0

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