package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ForgotPass2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass2)

        val forgotPasswordTextView = findViewById<TextView>(R.id.forgotpasstext)

     // Set an OnClickListener for the "Forgot Password" TextView
         forgotPasswordTextView.setOnClickListener {
            // Create an Intent to open the ForgotPassword activity
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }
    }
}