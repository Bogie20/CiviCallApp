package com.example.civicall.CurrentEngagementList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.civicall.ProfileDetails
import com.example.civicall.databinding.ActivityCurrentEngagementsBinding
import com.example.civicall.R

class CurrentEngagements : AppCompatActivity() {
    private lateinit var binding: ActivityCurrentEngagementsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrentEngagementsBinding.inflate(layoutInflater)

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
    }
}