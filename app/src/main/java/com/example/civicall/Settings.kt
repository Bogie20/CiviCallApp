package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.civicall.databinding.ActivitySettingsBinding
import android.view.View
import android.widget.Switch

class Settings : AppCompatActivity() {
    private lateinit var notificationToggle: Switch
    private lateinit var BackClick: View
    private lateinit var binding:ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        notificationToggle = binding.notificationToggle

        // Initialize the BackClick view using view binding
//        val BackClick = binding.back100

        // Set an OnCheckedChangeListener to detect switch state changes
        notificationToggle.setOnCheckedChangeListener { _, isChecked ->
            // Update the switch text when its state changes
            updateSwitchText(isChecked)
        }

        // Handle the "Back" button click to navigate to the Dashboard activity
        BackClick.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        val reportProblemsImageView = binding.reportProblemsImageView
        reportProblemsImageView.setOnClickListener {
            val intent = Intent(this, Reportproblems::class.java)
            startActivity(intent)
        }
    }

    private fun updateSwitchText(isChecked: Boolean) {
        if (isChecked) {
            notificationToggle.text = "On"
        } else {
            notificationToggle.text = "Off"
        }
    }
}