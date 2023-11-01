package com.example.civicall.PublicHealtAwarenessInfo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.civicall.CivicEngagementInfo.CivicAdapterMain
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataMain
import com.example.civicall.NetworkUtils
import com.example.civicall.R

class healtawarenessinfoMenu : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_healtawarenessinfo_menu)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val campusList = listOf(
            DataMain("Empowering Communities Grassroots Efforts in Public Health"),
            DataMain("Environmental Health in the Philippines: Awareness and Action"),
            DataMain("Evaluating the effectiveness of public health campaigns in the philippines"),
            DataMain("Gender Disparities in Public Health Awareness and Access"),
            DataMain("Innovations in Healthcare Leveraging Technology for Awareness"),
            DataMain("Mental Health Matters Breaking the Stigma in the Philippines"),
            DataMain("Preventive Healthcare a Key to a Healthier Philippines Topic"),
            DataMain("The Role of Nutrition Education in Public Health Awareness"),
            DataMain("Socioeconomic Factors and Health Inequities in the Philippines"),
            DataMain("The Impact of Public Health Awareness on Lifestyle Diseases")
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
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}