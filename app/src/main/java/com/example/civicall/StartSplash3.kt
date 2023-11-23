package com.example.civicall

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivityStartSplash3Binding

class StartSplash3 : AppCompatActivity() {
    private lateinit var binding: ActivityStartSplash3Binding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartSplash3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding.volunteerImage.setImageResource(R.drawable.volunteer3)

        //Next button clicking activity
        binding.nextButton.setOnClickListener {
            val i = Intent(this, Login::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            finish()
        }

        //skip button clicking activity
        binding.skipButton.setOnClickListener {
            val i = Intent(this, Login::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}