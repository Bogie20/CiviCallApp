package com.example.anew

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        setContentView(R.layout.activity_main)

        // Set the fade-in animation for the splash screen
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

        // Delay for 2 seconds before launching the login form
        Handler().postDelayed({
            // Start the login form activity
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
            // Close the current activity (splash screen)
            finish()
            // Set the fade-out animation for the splash screen transition
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 3000) // 3000 milliseconds = 3 seconds
    }
}
