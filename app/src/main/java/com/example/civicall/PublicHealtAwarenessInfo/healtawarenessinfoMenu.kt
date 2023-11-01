package com.example.civicall.PublicHealtAwarenessInfo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.civicall.CivicEngagementInfo.CivicAdapterMain
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataMain
import com.example.civicall.R

class healtawarenessinfoMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healtawarenessinfo_menu)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val campusList = listOf(
            DataMain("Empowering communities grassroots efforts in public health"),
            DataMain("Environmental health in the philippines: awareness and action"),
            DataMain("Evaluating the effectiveness of public health campaigns in the philippines"),
            DataMain("Gender disparities in public health awareness and access"),
            DataMain("Innovations in healthcare leveraging technology for awareness"),
            DataMain("Mental health matters breaking the stigma in the philippines"),
            DataMain("Preventive healthcare a key to a healthier philippines topic"),
            DataMain("The role of nutrition education in public health awareness"),
            DataMain("Socioeconomic factors and health inequities in the philippines"),
            DataMain("The Impact of public health awareness on lifestyle diseases")
        )

        val adapter = CivicAdapterMain(campusList) { position ->
            // Handle the item click here based on the position
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, ZeroGrassRootsEffort::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, OneHealingtheEnvironment::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this, TwoEffectiveCampaign::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, ThreeGenderHealthDisparities::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, FourHealthcareTechnology::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, FiveMentalHealthMatters::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, SixHealthisWealth::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, SevenNutritionEducation::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, EightSocioEconomicandHealth::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, NineImpactofHealthAwareness::class.java)
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