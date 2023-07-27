package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Delay for 2 seconds before launching the login form
        Handler().postDelayed({
            // Start the login form activity
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
            // Close the current activity (splash screen)
            finish()
        }, 5000) // 2000 milliseconds = 2 seconds


        // Set a click listener to the button

    }
}



