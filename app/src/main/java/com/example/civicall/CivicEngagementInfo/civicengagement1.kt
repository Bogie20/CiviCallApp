package com.example.civicall.CivicEngagementInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.civicall.R

class civicengagement1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civicengagement1)

        fun BackClick(view: View) {
            // Handle the click event here
            // For example, you can navigate back or perform any other action
            onBackPressed()
        }
    }
}