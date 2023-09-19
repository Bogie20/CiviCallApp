package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.R

class Civic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civicengagement1)

        // Define click listeners for your TextViews
        val textViewParticipantTips = findViewById<TextView>(R.id.button1)
        val textViewNavigatingTips = findViewById<TextView>(R.id.button2)
        val textViewStrategies = findViewById<TextView>(R.id.button3)
        val textViewGettingStarted = findViewById<TextView>(R.id.button4)
        val textViewTacticsImpact = findViewById<TextView>(R.id.button5)
        val textViewRoadmap = findViewById<TextView>(R.id.button6)
        val textViewAdvocacy = findViewById<TextView>(R.id.button7)
        val textViewYouthEmpowerment = findViewById<TextView>(R.id.button8)
        val textViewDigitalAgeCivic = findViewById<TextView>(R.id.button9)

        val textViewLastingImpact = findViewById<TextView>(R.id.button10)








        // Set click listeners for the TextViews
        textViewAdvocacy.setOnClickListener {
            // Handle the click event for "Advocacy"
            // You can start a new activity or perform any desired action here
            val intent = Intent(this, Advocacy::class.java)
            startActivity(intent)
        }

        textViewDigitalAgeCivic.setOnClickListener {
            // Handle the click event for "DigitalAgeCivic"
            // You can start a new activity or perform any desired action here
            val intent = Intent(this, DigitalAgeCivic::class.java)
            startActivity(intent)
        }

        textViewGettingStarted.setOnClickListener {
            // Handle the click event for "GettingStarted"
            // You can start a new activity or perform any desired action here
            val intent = Intent(this, GettingStarted::class.java)
            startActivity(intent)
        }
        textViewLastingImpact.setOnClickListener {
            // Handle the click event for "GettingStarted"
            // You can start a new activity or perform any desired action here
            val intent = Intent(this, LastingImpact::class.java)
            startActivity(intent)
        }
        textViewNavigatingTips.setOnClickListener {
            // Handle the click event for "GettingStarted"
            // You can start a new activity or perform any desired action here
            val intent = Intent(this, navigatingtips::class.java)
            startActivity(intent)
        }

        textViewParticipantTips.setOnClickListener {
            // Handle the click event for "GettingStarted"
            // You can start a new activity or perform any desired action here
            val intent = Intent(this, ParticipantTips::class.java)
            startActivity(intent)
        }

        textViewRoadmap.setOnClickListener {
            // Handle the click event for "GettingStarted"
            // You can start a new activity or perform any desired action here
            val intent = Intent(this, Roadmap::class.java)
            startActivity(intent)
        }
        textViewStrategies.setOnClickListener {
            // Handle the click event for "Advocacy"
            // You can start a new activity or perform any desired action here
            val intent = Intent(this, Strategies::class.java)
            startActivity(intent)
        }
        textViewTacticsImpact.setOnClickListener {
            // Handle the click event for "Advocacy"
            // You can start a new activity or perform any desired action here
            val intent = Intent(this, TacticsImpact::class.java)
            startActivity(intent)
        }
        textViewYouthEmpowerment.setOnClickListener {
            // Handle the click event for "Advocacy"
            // You can start a new activity or perform any desired action here
            val intent = Intent(this, YouthEmpowerment::class.java)
            startActivity(intent)
        }








        // Handle the click event for the "Back" arrow
        fun BackClick(view: View) {
            onBackPressed()
        }
    }
}
