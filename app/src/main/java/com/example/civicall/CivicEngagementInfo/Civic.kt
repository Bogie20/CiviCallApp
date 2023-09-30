package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Civic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civicengagement1)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val campusList = listOf(
            DataMain("Tips for the students who want to participate in Civic Engagement"),
            DataMain("Tips Navigating Civic Engagement: Do's and Don't"),
            DataMain("Skills and Qualities of a Successful Community Engagement Leader"),
            DataMain("Civic Engagement 101: A Guide to Getting Started"),
            DataMain("Amplify Your Voice: Civic Engagement Tactics for Impact"),
            DataMain("Your Civic Journey: A Roadmap to Successful Engagement"),
            DataMain("Civic Engagement and Advocacy: Making Your Voice Heard on Key Issues"),
            DataMain("Youth Empowerment in Civic Engagement: Shaping Tomorrow's Leaders"),
            DataMain("Digital Age Civic Engagement: Harnessing Social Media for Change"),
            DataMain("Civic Engagement Beyond Voting: How to Make a Lasting Impact")
        )

        val adapter = CivicAdapterMain(campusList) { position ->
            // Handle the item click here based on the position
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, ParticipantTips::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, navigatingtips::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this, Strategies::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, GettingStarted::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, TacticsImpact::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, Roadmap::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, Advocacy::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, YouthEmpowerment::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, DigitalAgeCivic::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, LastingImpact::class.java)
                    startActivity(intent)
                }

                else -> {
                    // Handle click for items not covered above (if any)
                    Toast.makeText(this, "Clicked on item at position $position", Toast.LENGTH_SHORT).show()
                }
            }
        }

        recyclerView.adapter = adapter
    }
}