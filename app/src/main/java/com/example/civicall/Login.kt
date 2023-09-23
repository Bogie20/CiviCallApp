package com.example.civicall

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.util.Patterns
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.civicall.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputEditText
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

    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = Dialog(this)
        progressDialog.setContentView(R.layout.loading_layout)
        progressDialog.setCancelable(false)

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
        emailEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                email = emailEditText.text.toString().trim()
            } else {
                // When email field gains focus, restore the entire password
                passwordEditText.setText(password)
            }
        }

// Set a focus change listener for the password EditText
        passwordEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                password = passwordEditText.text.toString().trim()
            } else {
                // When password field gains focus, restore the entire email
                emailEditText.setText(email)
            }
        }
    }

        private fun validateData() {
        email = binding.emailLogin.text.toString().trim()
        password = binding.passwordText.text.toString().trim()
        if (email.isEmpty()) {
            binding.emailLogin.setError("Please Input your Email")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailLogin.setError("Invalid Email")
        } else if (password.isEmpty()) {
            binding.passwordText.setError("Please Enter Password")
        } else {
            loginUser()
        }
    }

    private fun loginUser() {
        val messageTextView = progressDialog.findViewById<TextView>(R.id.messageTextView)
        val progressBar = progressDialog.findViewById<ProgressBar>(R.id.progressBar)
        messageTextView.text = "Logging In..."
        progressBar.visibility = ProgressBar.VISIBLE

        progressDialog.show()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                checkUser()
            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(this, "Login Failed due to $e.message", Toast.LENGTH_LONG).show()
            }
    }

    private fun checkUser() {
        val messageTextView = progressDialog.findViewById<TextView>(R.id.messageTextView)
        messageTextView.text = "Checking User..."

        val firebaseUser = firebaseAuth.currentUser!!
        val ref = FirebaseDatabase.getInstance().getReference("Users")

        ref.child(firebaseUser.uid)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    startActivity(Intent(this@Login, Dashboard::class.java))
                    finish()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
    }
}






