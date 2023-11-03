package com.example.civicall

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivityStartSplashBinding

class StartSplash : AppCompatActivity() {
    private lateinit var binding: ActivityStartSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Setting trhe first image and thgen changing the background image at regular intervals
        binding.volunteerImage.setImageResource(R.drawable.volunteer)

        //Next button clicking activity
        binding.nextButton.setOnClickListener {
            val i = Intent(this, StartSplash2::class.java)
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