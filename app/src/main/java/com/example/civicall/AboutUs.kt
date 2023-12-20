package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.civicall.databinding.ActivityAboutUsBinding

class AboutUs : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        val backbtn: ImageView = findViewById(R.id.backbtn)
        backbtn.setOnClickListener {
            super.onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
}