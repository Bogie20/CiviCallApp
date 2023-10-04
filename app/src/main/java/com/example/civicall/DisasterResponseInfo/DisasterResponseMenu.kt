package com.example.civicall.DisasterResponseInfo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
            DataMain("First Aid and Basic Life Support:Learn life-saving skills."),
            DataMain("Fire Safety: Mastering the Flames."),
            DataMain("Understanding the Diversity of Natural Disasters: A Comprehensive Exploration"),
            DataMain("Disaster Response and Search and Rescue Operations"),
            DataMain("Connecting for Crisis Enhancing Communication and Information in Disaster Response"),
            DataMain("Food Distribution &amp; Nutrition in Disaster Response"),
            DataMain("Resilience and Recovery Psychological Support Services in Disaster Response"),
            DataMain("Guiding Generosity: Volunteer and Donations Management in Disaster Response"),
            DataMain("Focused Recovery and Rebuilding Efforts: Strategies for Post-Disaster Resilience"),
        )

        val adapter = CivicAdapterMain(campusList) { position ->
            // Handle the item click here based on the position
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, EmergencyPreparednessInfo::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, FirstAidInfo::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this,  FireSafetyInfo::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, NaturalDisasterInfo::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, SearchAndRescueinfo::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, CommunicationAndInformationInfo::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, FoodDistributionAndNutrionInfo::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, PsychologicalSupportServicesInfo::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, VolunteerandDonationsManagementInfo::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, RecoveryandRebuildingEffortsInfo::class.java)
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