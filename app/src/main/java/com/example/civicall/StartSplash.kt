package com.example.civicall

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivityStartSplashBinding

class StartSplash : AppCompatActivity() {
    private lateinit var binding: ActivityStartSplashBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        //Setting trhe first image and thgen changing the background image at regular intervals
        binding.volunteerImage.setImageResource(R.drawable.volunteer)

        //Next button clicking activity
        binding.nextButton.setOnClickListener {
            val i = Intent(this, StartSplash2::class.java)
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