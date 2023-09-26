package com.example.civicall.DisasterResponse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.CivicAdapterMain
import com.example.civicall.CivicEngagementInfo.DataMain

class DisasterResponseMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disaster_response_menu)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val campusList = listOf(
            DataMain("Emergency Preparedness: Plan ahead for safety."),
            DataMain("Tips Navigating Civic Engagement: Do's and Don't"),
            DataMain("Skills and Qualities of a Successful Community Engagement Leader"),
            DataMain("Civic Engagement 101: A Guide to Getting Started"),
            DataMain("Amplify Your Voice: Civic Engagement Tactics for Impact"),
            DataMain("Your Civic Journey: A Roadmap to Successful Engagement"),
            DataMain("Civic Engagement and Advocacy: Making Your Voice Heard on Key Issues"),
            DataMain("Youth Empowerment in Civic Engagement: Shaping Tomorrow's Leaders"),
            DataMain("Digital Age Civic Engagement: Harnessing Social Media for Change"),
            DataMain("Civic Engagement Beyond Voting: How to Make a Lasting Impact"),
        )

        val adapter = CivicAdapterMain(campusList)
        recyclerView.adapter = adapter
    }
}
