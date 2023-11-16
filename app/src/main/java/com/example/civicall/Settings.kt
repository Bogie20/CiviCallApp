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


        binding.backbtn.setOnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        val changepass = binding.changepass
        changepass.setOnClickListener {
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }
        val Otherproblems = binding.reportproblem
        Otherproblems.setOnClickListener {
            val intent = Intent(this, Otherproblem::class.java)
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



