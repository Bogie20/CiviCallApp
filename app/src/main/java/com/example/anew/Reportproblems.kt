package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.anew.databinding.ActivityReportproblemsBinding

class Reportproblems : AppCompatActivity() {
    private lateinit var BackClick: View
    private lateinit var binding:ActivityReportproblemsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReportproblemsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val BackClick = binding.back100

        BackClick.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
    }
}