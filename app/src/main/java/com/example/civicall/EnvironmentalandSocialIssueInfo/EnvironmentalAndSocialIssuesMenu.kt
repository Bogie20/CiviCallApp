package com.example.civicall.EnvironmentalandSocialIssueInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataMain
import com.example.civicall.CivicRightsAndResponsibility.CivicResponsibilityInfo
import com.example.civicall.CivicRightsAndResponsibility.CivicResponsibilityandEducationinfo
import com.example.civicall.CivicRightsAndResponsibility.CivicResponsibilityandtheRuleofLawInfo
import com.example.civicall.CivicRightsAndResponsibility.CivicResponsibilityinTimesofCrisisInfo
import com.example.civicall.CivicRightsAndResponsibility.CivicRightsinaDigitalWorldInfo
import com.example.civicall.CivicRightsAndResponsibility.EnvironmentalCivicResponsibilityinfo
import com.example.civicall.CivicRightsAndResponsibility.GenderEqualityandCivicResponsibilityInfo
import com.example.civicall.CivicRightsAndResponsibility.GlobalCitizenshipandCivicResponsibilityInfo
import com.example.civicall.CivicRightsAndResponsibility.RighttoProtestandFreeSpeechInfo
import com.example.civicall.CivicRightsAndResponsibility.UnderstandingCivicRightsInfo
import com.example.civicall.R

class EnvironmentalAndSocialIssuesMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_environmental_and_social_issues_info)




        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val campusList = listOf(
            DataMain("Understanding Civic Rights"),
            DataMain("Civic Responsibility in a Democratic Society"),
            DataMain("The Right to Protest and Free Speech"),
            DataMain("Environmental Civic Responsibility"),
            DataMain("Civic Responsibility and the Rule of Law"),
            DataMain("Civic Rights in a Digital World"),
            DataMain("Gender Equality and Civic Responsibility"),
            DataMain("Civic Responsibility in Times of Crisis"),
            DataMain("Civic Responsibility and Education"),
            DataMain("Global Citizenship and Civic Responsibility")
        )

        val adapter = CivicAdapterMain(campusList) { position ->
            // Handle the item click here based on the position
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, UnderstandingCivicRightsInfo::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, CivicResponsibilityInfo::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this, RighttoProtestandFreeSpeechInfo::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, EnvironmentalCivicResponsibilityinfo::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, CivicResponsibilityandtheRuleofLawInfo::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, CivicRightsinaDigitalWorldInfo::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, GenderEqualityandCivicResponsibilityInfo::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, CivicResponsibilityinTimesofCrisisInfo::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, CivicResponsibilityandEducationinfo::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, GlobalCitizenshipandCivicResponsibilityInfo::class.java)
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