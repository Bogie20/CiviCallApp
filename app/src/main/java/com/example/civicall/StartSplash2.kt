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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartSplash2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        //Setting trhe first image and thgen changing the background image at regular intervals
        binding.volunteerImage.setImageResource(R.drawable.volunteer2)

        //Next button clicking activity
        binding.nextButton.setOnClickListener {
            val i = Intent(this, StartSplash3::class.java)
            startActivity(i)
            overridePendingTransition(
                com.google.android.material.R.anim.abc_fade_in,
                com.google.android.material.R.anim.abc_fade_out)
            finish()
        }

        //skip button clicking activity
        binding.skipButton.setOnClickListener {
            val i = Intent(this, Login::class.java)
            startActivity(i)
            overridePendingTransition(
                com.google.android.material.R.anim.abc_fade_in,
                com.google.android.material.R.anim.abc_fade_out)
            finish()
        }
    }
}