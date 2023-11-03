package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.civicall.databinding.ActivityStartSplash2Binding
import com.example.civicall.databinding.ActivityStartSplashBinding
import java.util.*
import kotlin.concurrent.schedule

class StartSplash2 : AppCompatActivity() {
    private lateinit var binding: ActivityStartSplash2Binding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartSplash2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        //Setting trhe first image and thgen changing the background image at regular intervals
        binding.volunteerImage.setImageResource(R.drawable.volunteer2)

        //Next button clicking activity
        binding.nextButton.setOnClickListener {
            val i = Intent(this, StartSplash3::class.java)
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