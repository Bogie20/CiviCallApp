package com.example.civicall

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
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.CheckBox
import com.example.civicall.CivicEngagementPost.CivicPostFragment
import com.example.civicall.databinding.ActivityRegister1Binding
import com.google.android.material.textfield.TextInputLayout

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar

class Register1 : AppCompatActivity() {
    private lateinit var activityRegister1Binding: ActivityRegister1Binding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog


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
        val address = activityRegister1Binding.adress.text.toString().trim()

        if (address.isEmpty()) {
            activityRegister1Binding.adress.error = "Address is required"
        } else if (address.length < 5) {
            activityRegister1Binding.adress.error = "Address is too short"
        } else {
            activityRegister1Binding.adress.error = null
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
        val contactNumber = activityRegister1Binding.Contactline
        val contactEme = activityRegister1Binding.ContactEme
        genderArray.add(0, "Gender") // Add "Gender" as the first item in the list

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
        val addressEditText = activityRegister1Binding.adress
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

        val adapter = CustomSpinnerAdapter(
            this,
            android.R.layout.simple_spinner_item,
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

        val errorMessages = mutableListOf<String>()

        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || phoneno.isEmpty() ||
            phoneEme.isEmpty() || address.isEmpty() || birtdate.isEmpty() || spinnerSex == "Gender") {
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
                activityRegister1Binding.adress.error = "Required"
            } else {
                activityRegister1Binding.adress.error = null
            }
            if (birtdate.isEmpty()) {
                activityRegister1Binding.birthdate.error = "Required"
            } else {
                activityRegister1Binding.birthdate.error = null
            }
            if (spinnerSex == "Gender") {
                val genderTextInputLayout = activityRegister1Binding.genderTextInputLayout
                genderTextInputLayout.helperText = "*required"
                errorMessages.add("Please select a gender")
            } else {
                val genderTextInputLayout = activityRegister1Binding.genderTextInputLayout
                genderTextInputLayout.helperText = null
            }

            errorMessages.add("Please Fill All the Fields")
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

        if (!isChecked) {
            errorMessages.add("Please accept the agreement to register")
        }

        validatePasswordMatch()

        if (errorMessages.isNotEmpty()) {
            for (message in errorMessages) {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        } else {
            createUserAccount()
        }


    if (spinnerSex == "Gender") {
            val genderTextInputLayout = activityRegister1Binding.genderTextInputLayout
            genderTextInputLayout.helperText = "*required"
            errorMessages.add("Please select a gender")
        } else {
            val genderTextInputLayout = activityRegister1Binding.genderTextInputLayout
            genderTextInputLayout.helperText = null
        }

    }

    private fun createUserAccount() {
        val accountCreationDialog = ProgressDialog(this)
        accountCreationDialog.setMessage("Creating Account...")
        accountCreationDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                accountCreationDialog.dismiss()

                if (task.isSuccessful) {
                    updateUserInfo()
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

    private fun updateUserInfo() {
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