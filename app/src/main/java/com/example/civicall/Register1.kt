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
import com.example.civicall.CivicEngagementPost.CivicPostFragment
import com.example.civicall.databinding.ActivityRegister1Binding

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.util.Calendar

class Register1 : AppCompatActivity() {
    private lateinit var activityRegister1Binding: ActivityRegister1Binding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        activityRegister1Binding = ActivityRegister1Binding.inflate(layoutInflater)
        setContentView(activityRegister1Binding.root)
        val genderSpinner = activityRegister1Binding.spinnerSex


        ArrayAdapter.createFromResource(
            this,
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            genderSpinner.adapter = adapter

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
    private var phoneno = ""
    private var address = ""
    private var birtdate = ""
    private var spinnerSex = ""

    private fun validateData() {
        fname = activityRegister1Binding.fname.text.toString().trim()
        lname = activityRegister1Binding.Lname.text.toString().trim()
        email = activityRegister1Binding.Emailline.text.toString().trim()
        pass = activityRegister1Binding.pass.text.toString().trim()
        phoneno = activityRegister1Binding.Contactline.text.toString().trim()
        address = activityRegister1Binding.adress.text.toString().trim()
        birtdate = activityRegister1Binding.birthdate.text.toString().trim()
        spinnerSex = activityRegister1Binding.spinnerSex.selectedItem.toString()

        if (fname.isEmpty()) {
            activityRegister1Binding.fname.setError("Please Enter First Name")
        } else if (lname.isEmpty()) {
            activityRegister1Binding.Lname.setError("Please Enter Last Name")
        } else if (email.isEmpty()) {
            activityRegister1Binding.Emailline.setError("Please Enter Email")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_LONG).show()
        } else if (pass.isEmpty()) {
            activityRegister1Binding.pass.setError("Please Enter Password")
        } else if (phoneno.isEmpty()) {
            activityRegister1Binding.Contactline.setError("Please Enter Contact Number")
        } else if (spinnerSex.isEmpty()) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show()
        } else if (address.isEmpty()) {
            activityRegister1Binding.adress.setError("Please Enter Address")
        } else {
            createUserAccount()
        }
    }
    private fun createUserAccount() {
        // Show a separate progressDialog for account creation
        val accountCreationDialog = ProgressDialog(this)
        accountCreationDialog.setMessage("Creating Account...")
        accountCreationDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                // Dismiss the account creation progressDialog when the task is complete
                accountCreationDialog.dismiss()

                if (task.isSuccessful) {
                    // Account created successfully, proceed with updating user info.
                    updateUserInfo()
                } else {
                    // Account creation failed, handle the error.
                    val errorMessage = task.exception?.message ?: "Unknown error occurred."
                    Toast.makeText(this, "Failed Creating Account due to $errorMessage", Toast.LENGTH_LONG).show()
                }
            }
    }


    private fun updateUserInfo() {
        // Show a separate progressDialog for user info update
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
        hashMap["address"] = address
        hashMap["birthday"] = birtdate
        hashMap["gender"] = spinnerSex
        hashMap["ImageProfile"] = ""
        hashMap["userType"]="Student"
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
                Toast.makeText(this, "Failed Saving User's Info due to ${e.message}", Toast.LENGTH_LONG).show()
            }
    }
}