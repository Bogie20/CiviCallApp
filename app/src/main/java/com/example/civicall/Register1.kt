package com.example.civicall

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.CheckBox
import com.example.civicall.CivicEngagementPost.CivicPostFragment
import com.example.civicall.databinding.ActivityRegister1Binding

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar

class Register1 : AppCompatActivity() {
    private lateinit var activityRegister1Binding: ActivityRegister1Binding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog

    // Validation functions
    // Validation functions
    // Validation functions
    private fun validateFirstName() {
        val firstName = activityRegister1Binding.fname.text.toString().trim()

        if (firstName.isEmpty()) {
            activityRegister1Binding.fname.error = "Required"
        } else if (firstName.length > 80) { // Adjust the character limit as needed
            activityRegister1Binding.fname.error = "First Name is too long"
        } else {
            activityRegister1Binding.fname.error = null
        }
    }

    private fun validateLastName() {
        val lastName = activityRegister1Binding.Lname.text.toString().trim()

        if (lastName.isEmpty()) {
            activityRegister1Binding.Lname.error = "Required"
        } else if (lastName.length > 80) { // Adjust the character limit as needed
            activityRegister1Binding.Lname.error = "Last Name is too long"
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
            activityRegister1Binding.pass.error = "Required"
        } else {
            activityRegister1Binding.pass.error = null
        }
    }

    private fun validateContactNumber() {
        val contactNumber = activityRegister1Binding.Contactline.text.toString().trim()

        if (contactNumber.isEmpty()) {
            activityRegister1Binding.Contactline.error = "Required"
        } else if (!isValidPhoneNumber(contactNumber)) {
            activityRegister1Binding.Contactline.error = "Invalid Contact Number"
        } else {
            activityRegister1Binding.Contactline.error = null
        }
    }

    private fun isValidPhoneNumber(contactNumber: String): Boolean {
        // Remove spaces and special characters from the contact number
        val sanitizedNumber = contactNumber.replace("\\s".toRegex(), "")

        // Check if it starts with either "+63" or "0"
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
            activityRegister1Binding.ContactEme.error = "Required"
        } else if (!isValidPhoneEme(contactNum)) {
            activityRegister1Binding.ContactEme.error = "Invalid Contact Number"
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
        val address = activityRegister1Binding.adress.text.toString().trim()

        if (address.isEmpty()) {
            activityRegister1Binding.adress.error = "Required"
        } else if (address.length > 200) { // Adjust the character limit as needed
            activityRegister1Binding.adress.error = "Address is too long"
        } else {
            activityRegister1Binding.adress.error = null
        }
    }


    private fun validateBirthday() {
        val birthday = activityRegister1Binding.birthdate.text.toString().trim()

        if (birthday.isEmpty()) {
            activityRegister1Binding.birthdate.error = "Required"
        } else {
            activityRegister1Binding.birthdate.error = null
        }
    }

    private fun validatePasswordMatch() {
        val password = activityRegister1Binding.pass.text.toString().trim()
        val confirmPassword = activityRegister1Binding.confirmPass.text.toString().trim()

        if (password != confirmPassword) {
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

        // Set the adapter and default selection
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter
        genderSpinner.setSelection(adapter.getPosition("Gender")) // Set the default selection

        // Set an OnItemSelectedListener to capture the selected gender value
        genderSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Get the selected gender from the spinner
                spinnerSex = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // This method is required, but you can leave it empty
            }
        }

        val firstNameEditText = activityRegister1Binding.fname
        val lastNameEditText = activityRegister1Binding.Lname
        val emailEditText = activityRegister1Binding.Emailline
        val passwordEditText = activityRegister1Binding.pass
        val contactNumberEditText = activityRegister1Binding.Contactline
        val contactEmeEditText = activityRegister1Binding.ContactEme
        val addressEditText = activityRegister1Binding.adress
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
        address = activityRegister1Binding.adress.text.toString().trim()
        birtdate = activityRegister1Binding.birthdate.text.toString().trim()
        spinnerSex = activityRegister1Binding.spinnerSex.selectedItem.toString()

        val checkBox = findViewById<CheckBox>(R.id.checkedTextView)
        val isChecked = checkBox.isChecked

        // Create a list to store error messages
        val errorMessages = mutableListOf<String>()

        if (fname.isEmpty()) {
            errorMessages.add("Please Enter First Name")
        }

        if (lname.isEmpty()) {
            errorMessages.add("Please Enter Last Name")
        }

        if (email.isEmpty()) {
            errorMessages.add("Please Enter Email")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            errorMessages.add("Invalid Email Address")
        }

        if (pass.isEmpty()) {
            errorMessages.add("Please Enter Password")
        }

        if (confirmPass.isEmpty()) {
            errorMessages.add("Please Confirm Password")
        }

        if (phoneno.isEmpty()) {
            errorMessages.add("Please Enter Contact Number")
        }

        if (phoneEme.isEmpty()) {
            errorMessages.add("Please Enter Contact Person")
        }

        if (birtdate.isEmpty()) {
            errorMessages.add("Please Enter Date of Birth")
        } else if (spinnerSex == "-Gender-") {
            errorMessages.add("Please Select Gender")
        }

        if (address.isEmpty()) {
            errorMessages.add("Please Enter Address")
        } else if (address.length > 200) {
            errorMessages.add("Address is too long")
        }

        if (!isChecked) {
            errorMessages.add("Please accept the agreement to register")
        }

        if (pass != confirmPass) {
            errorMessages.add("Passwords do not match")
        }

        if (errorMessages.isNotEmpty()) {
            // If there are errors, display them using Toast or any other method
            for (message in errorMessages) {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        } else {
            // Call createUserAccount only when everything else is valid
            createUserAccount(phoneEme)
        }
    }

    private fun createUserAccount(contactEme: String) {
        val accountCreationDialog = ProgressDialog(this)
        accountCreationDialog.setMessage("Creating Account...")
        accountCreationDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                accountCreationDialog.dismiss()

                if (task.isSuccessful) {
                    updateUserInfo(contactEme)
                } else {
                    val errorMessage = task.exception?.message ?: "Unknown error occurred."
                    Toast.makeText(
                        this,
                        "Failed Creating Account due to $errorMessage",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }

    private fun updateUserInfo(contactEme: String) {
        val userInfoUpdateDialog = ProgressDialog(this)
        userInfoUpdateDialog.setMessage("Saving User Info...")
        userInfoUpdateDialog.show()
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