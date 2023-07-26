package com.example.anew

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.example.anew.databinding.ActivityLoloBinding


class lolo : AppCompatActivity() {
    private lateinit var BackClick: ImageView
    private lateinit var binding: ActivityLoloBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lolo)

        BackClick = findViewById(R.id.back1)

        BackClick.setOnClickListener {
            // Open the "Menu" activity/form
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        val menuItem1: TextView = findViewById(R.id.menuItem1)
        val menuItem2: TextView = findViewById(R.id.menuItem2)

        val AboutUs1: TextView = findViewById(R.id.AboutUs1)
        val menuItem9: TextView = findViewById(R.id.menuItem9)
        menuItem1.setOnClickListener {
            // Handle click for menu item 1
            val intent = Intent(this, Myprofile::class.java)
            startActivity(intent)

            }
        menuItem2.setOnClickListener {
            // Handle click for menu item 1
            val intent = Intent(this, Accountverification::class.java)
            startActivity(intent)

        }
        AboutUs1.setOnClickListener {
            // Handle click for menu item 1
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)

        }
        menuItem9.setOnClickListener {
            // Handle click for menu item 1
            val intent = Intent(this, Feedback::class.java)
            startActivity(intent)

        }

    }
}
