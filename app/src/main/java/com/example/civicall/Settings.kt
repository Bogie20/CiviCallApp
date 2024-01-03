package com.example.civicall

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.example.civicall.databinding.ActivitySettingsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class Settings : AppCompatActivity(), ValueEventListener {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var networkUtils: NetworkUtils
    private lateinit var notificationSwitch: SwitchCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        notificationSwitch = binding.notificationSwitch
        notificationSwitch.isChecked = areNotificationsEnabled()

        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            openNotificationSettings()
        }


        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val changepass = binding.changepass
        changepass.setOnClickListener {
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }
        val otherproblem = binding.otherproblem
        otherproblem.setOnClickListener {
            val intent = Intent(this, ReportProblem::class.java)
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
    }

    private fun openNotificationSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = android.net.Uri.fromParts("package", packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    private fun areNotificationsEnabled(): Boolean {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        return notificationManager.areNotificationsEnabled()
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        // Handle data changes if needed
    }

    override fun onCancelled(error: DatabaseError) {
        // Handle database errors if needed
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }

    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
}
