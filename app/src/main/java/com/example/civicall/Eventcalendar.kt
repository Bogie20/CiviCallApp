package com.example.civicall

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivityEventcalendarBinding

class Eventcalendar : AppCompatActivity() {
    private lateinit var BackClick: View
    private lateinit var binding: ActivityEventcalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventcalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        BackClick = binding.back100 // Assuming back100 is the ID in your layout

        BackClick.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}