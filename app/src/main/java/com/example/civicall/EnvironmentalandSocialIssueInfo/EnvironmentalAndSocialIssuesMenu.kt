package com.example.civicall.EnvironmentalandSocialIssueInfo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataMain
import com.example.civicall.R
import com.example.civicall.CivicEngagementInfo.CivicAdapterMain

class EnvironmentalAndSocialIssuesMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_environmental_and_social_issues_info)




        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val campusList = listOf(
            DataMain("Breaking the chains unraveling human trafficking and exploitation in the Philippines"),
            DataMain("Communities in peril displacement and resettlement in the Philippines"),
            DataMain("Clearing the haze empowering college students in the fight against pollution"),
            DataMain("Rainforest reckoning unearthing the precarious future of the Philippine green treasure"),
            DataMain("Invisible labor women's rights and gender equality in the Philippines"),
            DataMain("Islands of biodiversity conservation struggles in the Philippine archipelago"),
            DataMain("Islands of inequality social disparities and access to education in the Philippines"),
            DataMain("Rising tides, sinking cities coastal vulnerability in the Philippines"),
            DataMain("The silent crisis mental health in the philippines"),
            DataMain("Water woes and wins: access and scarcity in the philippine islands")
        )

        val adapter = CivicAdapterMain(campusList) { position ->
            // Handle the item click here based on the position
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, BreakingtheChainsInfo::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, CommunitiesinPerilInfo::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this, DirtyAirBrightSolutionsInfo::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, GreenGoldRushInfo::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, InvisibleLaborInfo::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, IslandsofBiodiversityInfo::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, IslandsofInequalityInfo::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, RisingTidesInfo::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, TheSilentCrisisInfo::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, WaterWoesandWinsInfo::class.java)
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