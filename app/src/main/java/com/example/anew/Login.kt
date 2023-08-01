package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private val emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        auth = FirebaseAuth.getInstance()


        val emailadd: EditText = findViewById(R.id.email_login)
        val password: EditText = findViewById(R.id.password_text)
        val passwordlayout: TextInputLayout = findViewById(R.id.password_layout)
        val loginbtn: Button = findViewById(R.id.btnlogin)
        val loginprogbar: ProgressBar = findViewById(R.id.progress_loading)

        val registertext: TextView = findViewById(R.id.signUpTextView)


        registertext.setOnClickListener {
            val intent = Intent(this, Register1::class.java)
            startActivity(intent)

        }

        loginbtn.setOnClickListener {
            loginprogbar.visibility = View.VISIBLE
            passwordlayout.isPasswordVisibilityToggleEnabled = true

            val email = emailadd.text.toString()
            val pass = password.text.toString()


            if (email.isEmpty() || pass.isEmpty()) {
                if (email.isEmpty()) {
                    emailadd.error = "Enter Email Address"


                }
                if (pass.isEmpty()) {
                    password.error = "Enter Password"
                    passwordlayout.isPasswordVisibilityToggleEnabled = false


                }
                loginprogbar.visibility = View.GONE
                Toast.makeText(this, "Enter Valid Details", Toast.LENGTH_SHORT).show()


            } else if (!email.matches(emailpattern.toRegex())) {
                loginprogbar.visibility = View.GONE
                emailadd.error = "Enter Valid Email Address"
                Toast.makeText(this, "Enter Valid Email Address", Toast.LENGTH_SHORT).show()
            } else if (pass.length <= 8) {
                loginprogbar.visibility = View.GONE
                password.error = "Enter a password more than 8 character"
                Toast.makeText(this, "Something went Wrong", Toast.LENGTH_SHORT).show()


            } else {
                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, Dashboard::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Email or password are incorrect", Toast.LENGTH_SHORT)
                        loginprogbar.visibility = View.GONE

                    }
                }
            }

        }
    }
}












