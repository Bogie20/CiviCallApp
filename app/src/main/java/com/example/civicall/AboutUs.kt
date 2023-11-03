package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.civicall.databinding.ActivityAboutUsBinding

class AboutUs : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    private lateinit var binding: ActivityAboutUsBinding
    private lateinit var BackClick: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        BackClick = findViewById(R.id.back100)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        BackClick.setOnClickListener {
            // Open the "Menu" activity/form
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
}