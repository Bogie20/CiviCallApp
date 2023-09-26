package com.example.civicall.CivicEngagementInfo

import android.os.Bundle
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
            DataMain("Civic Engagement Beyond Voting: How to Make a Lasting Impact"),
        )

        val adapter = CivicAdapterMain(campusList)
        recyclerView.adapter = adapter
    }
}
