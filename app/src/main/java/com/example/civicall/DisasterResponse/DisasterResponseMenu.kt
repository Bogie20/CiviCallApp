package com.example.civicall.DisasterResponse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.civicall.CivicEngagementInfo.Advocacy
import com.example.civicall.CivicEngagementInfo.DigitalAgeCivic
import com.example.civicall.CivicEngagementInfo.GettingStarted
import com.example.civicall.CivicEngagementInfo.LastingImpact
import com.example.civicall.CivicEngagementInfo.ParticipantTips
import com.example.civicall.CivicEngagementInfo.Roadmap
import com.example.civicall.CivicEngagementInfo.Strategies
import com.example.civicall.CivicEngagementInfo.TacticsImpact
import com.example.civicall.CivicEngagementInfo.YouthEmpowerment
import com.example.civicall.CivicEngagementInfo.navigatingtips
import com.example.civicall.R

class DisasterResponseMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disaster_response_menu)

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