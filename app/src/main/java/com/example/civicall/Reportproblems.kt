package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.civicall.databinding.ActivityReportproblemsBinding

class Reportproblems : AppCompatActivity() {
    private lateinit var binding: ActivityReportproblemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReportproblemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Find the TextViews by their IDs
        val technicalIssueTextView = findViewById<TextView>(R.id.TechnicalIssue)
        val userInterfaceTextView = findViewById<TextView>(R.id.UserInterface)
        val otherTextView = findViewById<TextView>(R.id.other)

        // Set click listeners for each TextView
        technicalIssueTextView.setOnClickListener {
            openTechnicalIssueActivity()
        }

        userInterfaceTextView.setOnClickListener {
//            openUserInterfaceActivity()
        }

        otherTextView.setOnClickListener {
            openOtherActivity()
        }
    }

    /**
     * Opens the Technical Issue activity.
     */
    private fun openTechnicalIssueActivity() {
        val intent = Intent(this, TechnicalIssueReportProblems::class.java)
        startActivity(intent)
    }

    /**
     * Opens the User Interface Issue activity.
     */
//    private fun openUserInterfaceActivity() {
//        val intent = Intent(this, Userinterface::class.java)
//        startActivity(intent)
//    }

    /**
     * Opens the Other activity.
     */
    private fun openOtherActivity() {
        val intent = Intent(this, Otherproblem::class.java)
        startActivity(intent)
    }
}