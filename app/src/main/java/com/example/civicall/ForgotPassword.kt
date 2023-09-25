package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val signInTextView = findViewById<TextView>(R.id.sigintext)
        // Set an OnClickListener for the "Sign-In" TextView
        signInTextView.setOnClickListener {
            // Create an Intent to open the Login activity
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        //TEMPORARY START
        val sendOTPButton: Button = findViewById(R.id.btnsend)

        // Set an OnClickListener for the "Send OTP" button
        sendOTPButton.setOnClickListener {
            // Create an Intent to open the ForgotPass2 activity
            val intent = Intent(this@ForgotPassword, ForgotPass2::class.java)
            startActivity(intent)
        }
        //TEMPORARY END

    }
}