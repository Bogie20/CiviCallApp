package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)

        // Set a click listener to the button
        button.setOnClickListener {
            // Start the LoginActivity
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}



