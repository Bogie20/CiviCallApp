package com.example.civicall.EnvironmentalandSocialIssueInfo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataMain
import com.example.civicall.R
import com.example.civicall.CivicEngagementInfo.CivicAdapterMain
import com.example.civicall.NetworkUtils
import com.example.civicall.databinding.ActivityEnvironmentalAndSocialIssuesMenuBinding

class EnvironmentalAndSocialIssuesMenu : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    private lateinit var binding: ActivityEnvironmentalAndSocialIssuesMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityEnvironmentalAndSocialIssuesMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        val campusList = listOf(
            DataMain("Breaking the Chains unraveling Human Trafficking and exploitation in the Philippines"),
            DataMain("Communities in Peril Displacement and Resettlement in the Philippines"),
            DataMain("Clearing the Haze Empowering College Students in the Fight Against Pollution"),
            DataMain("Rainforest Reckoning Unearthing the Precarious Future of the Philippine Green Treasure"),
            DataMain("Invisible Labor Women's Rights and Gender Equality in the Philippines"),
            DataMain("Islands of Biodiversity Conservation Struggles in the Philippine Archipelago"),
            DataMain("Islands of Inequality Social Disparities and Access to Education in the Philippines"),
            DataMain("Rising Tides, Sinking Cities Coastal Vulnerability in the Philippines"),
            DataMain("The Silent Crisis Mental Health in the Philippines"),
            DataMain("Water Woes and Wins: Access and Scarcity in the Philippine Islands")
        )

        val adapter = CivicAdapterMain(campusList) { position ->
            // Handle the item click here based on the position
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, ZeroBreaktheChain::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, OneSocialDisparities::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this, TwoPollution::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, ThreeGreenTreasure::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, FourGenderEquality::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, FiveConservingBiodiversity::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, SixIslandInequality::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, SevenRisingAwareness::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, EightMentalHealthAwareness::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, NineCleanWater::class.java)
                    startActivity(intent)
                }

                else -> {
                    // Handle click for items not covered above (if any)
                    Toast.makeText(this, "Clicked on item at position $position", Toast.LENGTH_SHORT).show()
                }
            }
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}