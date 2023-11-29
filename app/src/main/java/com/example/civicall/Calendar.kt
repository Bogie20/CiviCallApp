package com.example.civicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Calendar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
    }

    companion object {
        fun getInstance(): Any {
            // Add your implementation here
            return Any()
        }
    }
}