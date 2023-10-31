package com.example.civicall.CampusGovernanceInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.CivicAdapterMain
import com.example.civicall.CivicEngagementInfo.DataMain
import com.example.civicall.R

class CampusGovernanceMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campus_governance_menu)



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val campusList = listOf(
            DataMain("Discovering the history of batangas state university"),
            DataMain("Navigating university governance and leadership"),
            DataMain("Your path to admission: requirements and deadlines"),
            DataMain("Discover our vibrant campus locations: your path to unique learning environments"),
            DataMain("Empowering student representation in university governance"),
            DataMain("Connecting globally: international programs and partnerships"),
            DataMain("Enhancing institutional sustainability through comprehensive governance and management"),
            DataMain("Exploring diverse academic and co-curricular offerings"),
            DataMain("Nurturing holistic student development: the role of osas at batangas state university"),
            DataMain("Sustainability and social responsibility at Bsu")
        )

        val adapter = CivicAdapterMain(campusList) { position ->
            // Handle the item click here based on the position
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, AboutInfo::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, AdministrationInfo::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this, AdmissionBsuInfo::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, CampusesAboutInfo::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, EmpoweringStudentInfo::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, GlobalbsuInfo::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, InstitutionalSustainabilityInfo::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, ProgramsInBsuInfo::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, StudentsBSUInfo::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, SustainabilityBsuInfo::class.java)
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