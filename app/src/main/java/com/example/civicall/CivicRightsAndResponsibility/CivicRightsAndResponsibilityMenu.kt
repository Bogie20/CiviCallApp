package com.example.civicall.CivicRightsAndResponsibility

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.CivicAdapterMain
import com.example.civicall.CivicEngagementInfo.DataMain
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityCivicRightsAndResponsibilityMenuBinding

class CivicRightsAndResponsibilityMenu : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    private lateinit var binding: ActivityCivicRightsAndResponsibilityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityCivicRightsAndResponsibilityMenuBinding.inflate(layoutInflater)
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
            DataMain("Demystifying Civic Rights a Comprehensive Exploration"),
            DataMain("Civic Responsibility in a Democratic Society"),
            DataMain("The Right to Protest and Free Speech"),
            DataMain("Environmental Civic Responsibility"),
            DataMain("Civic Responsibility and the Rule of Law"),
            DataMain("Civic Rights in a Digital World"),
            DataMain("Gender Equality and Civic Responsibility"),
            DataMain("Civic Responsibility in Times of Crisis"),
            DataMain("Civic Responsibility and Education"),
            DataMain("Global Citizenship and Civic Responsibility"),
            DataMain("Articles of 1987 Constitution of the Philippines")
        )

        val adapter = CivicAdapterMain(campusList) { position ->
            // Handle the item click here based on the position
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, ZeroDemystifyingCivicRights::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, OneCivicRights::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this, TwoRighttoExpress::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, ThreeEnvironmentalResponsibility::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, FourLegality::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, FiveDigitalAge::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, SixEmpoweringYou::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, SevenTimeofCrisis::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, EightCivicResponsibility::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, NineGlobalCitizen::class.java)
                    startActivity(intent)
                }
                10 -> {
                    // Handle click for Item 10
                    val intent = Intent(this, TenConstitutionPhilippines::class.java)
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