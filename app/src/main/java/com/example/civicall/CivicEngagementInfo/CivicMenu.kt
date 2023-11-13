package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityCivicMenuBinding

class CivicMenu : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    private lateinit var binding: ActivityCivicMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityCivicMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }

        val campusList = listOf(
            DataMain("What is Civic Engagement? and How to Engage for Community Building"),
            DataMain("Technology for Civic Engagement"),
            DataMain("Be a part of the Global Advancement"),
            DataMain("Amplifying Your Voice for Effective Communication"),
            DataMain("Know About Social Justice"),
            DataMain("Making Your Voice Heard on Key Issues"),
            DataMain("Youth Leadership as a Student"),
            DataMain("A Guide for Strategic Advocacy"),
            DataMain("Digital Civic Engagement"),
            DataMain("Campus Initiative for Sustainability"),
                    DataMain("TenSustainableGoals")


        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        val adapter = CivicAdapterMain(campusList) { position ->
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, ZeroCivicLeadership::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, OneTechnologyforCivic::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this, TwoGlobalAdvancement::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, ThreeEffectiveAdvocacy::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, FourSocialJustice::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, FiveMakeYourVoiceHeard::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, SixStudentLeadership::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, SevenCivicAdvocacy::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, EightDigitalCivic::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, NineCampusInitiative::class.java)
                    startActivity(intent)
                }
                10 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, TenSustainableGoals::class.java)
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