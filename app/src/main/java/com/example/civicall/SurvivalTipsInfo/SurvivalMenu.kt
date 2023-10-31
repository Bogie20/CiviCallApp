package com.example.civicall.SurvivalTipsInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.civicall.CivicEngagementInfo.CivicAdapterMain
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataMain
import com.example.civicall.R

class SurvivalMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survival_menu)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val campusList = listOf(
            DataMain("Surviving Philippine Earthquakes: Preparedness and Response"),
            DataMain("Volcanic Eruption Survival in the Philippines: Ashfall and Lava Flow"),
            DataMain("Surviving a Tsunami in the Philippines: Coastal Disaster Preparedness"),
            DataMain("College Student's Guide to Typhoon Preparedness in the Philippines"),
            DataMain("Coping with El Niño: Managing Drought and Water Scarcity"),
            DataMain("Philippine jungle survival: navigating the dense rainforests"),
            DataMain("Navigating Philippine Mountains: Survival in Rugged Terrain"),
            DataMain("Island Survival Strategies: Thriving in Remote Philippine Archipelagos"),
            DataMain("Survival Psychology in the Philippines: Mental Resilience Amidst Disasters"),
            DataMain("Philippine Coastal Survival: Navigating Coastal Challenges")
        )

        val adapter = CivicAdapterMain(campusList) { position ->
            // Handle the item click here based on the position
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, EarthquakesInfo::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, VolcanicEruptionInfo::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this, TsunamiInfo::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, TyphoonInfo::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, ElNinoInfo::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, JunglerInfo::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, NavigatingMountainInfo::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, IslandSurvivalInfo::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, SurvivalPsychologyInfo::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, CoastalSurvivalInfo::class.java)
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



