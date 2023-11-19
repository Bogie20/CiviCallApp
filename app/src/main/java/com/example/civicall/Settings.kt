package com.example.civicall

import android.provider.Settings

import android.app.NotificationManager
import android.content.Context
import android.content.Intent

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.example.civicall.databinding.ActivitySettingsBinding
import com.google.android.material.switchmaterial.SwitchMaterial

class Settings : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val notificationSwitch = findViewById<SwitchMaterial>(R.id.notificationSwitch)
        binding.backbtn.setOnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val changepass = binding.changepass
        changepass.setOnClickListener {
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }

        val otherproblems = binding.reportproblem
        otherproblems.setOnClickListener {
            val intent = Intent(this, Otherproblem::class.java)
            startActivity(intent)
        }
        val termsandsupp = binding.termsandsupp
        termsandsupp.setOnClickListener {
            val intent = Intent(this, PrivacyAndPolicies::class.java)
            startActivity(intent)
        }
        val profilestt = binding.profilesett
        profilestt.setOnClickListener {
            val intent = Intent(this, TermsAndConditions::class.java)
            startActivity(intent)
        }

        val forumsett = binding.forumsett
        forumsett.setOnClickListener {
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)
        }


        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle the switch state change here
            if (isChecked) {
                // Switch is ON
                // Check if notification permission is granted
                if (!isNotificationPermissionGranted()) {
                    // Request notification permission
                    requestNotificationPermission()
                } else {
                    // Permission is already granted, perform actions when the switch is turned on
                    // (e.g., enable notifications)
                }
            } else {
                // Switch is OFF
                // Perform actions when the switch is turned off
            }
        }

        // Your existing code...
    }

    private fun isNotificationPermissionGranted(): Boolean {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        return notificationManager.areNotificationsEnabled()
    }

    private fun requestNotificationPermission() {
        val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
        startActivity(intent)
        Toast.makeText(
            this,
            "Please grant notification permission for the app",
            Toast.LENGTH_SHORT
        ).show()
    }
}

