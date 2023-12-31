package com.example.civicall.CampusGovernanceInfo

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
import com.example.civicall.databinding.ActivityCampusGovernanceMenuBinding

class CampusGovernanceMenu : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    private lateinit var binding: ActivityCampusGovernanceMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityCampusGovernanceMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }

        val campusList = listOf(
            DataMain("Discovering the History of Batangas State University"),
            DataMain("Navigating University Governance and Leadership"),
            DataMain("Your Path to Admission: Requirements and Deadlines"),
            DataMain("Discover our Vibrant Campus Locations: Your Path to Unique Learning Environments"),
            DataMain("Empowering Student Representation in University Governance"),
            DataMain("Connecting Globally: International Programs and Partnerships"),
            DataMain("Enhancing Institutional Sustainability Through Comprehensive Governance and Management"),
            DataMain("Exploring Diverse Academic and Co-curricular Offerings"),
            DataMain("Nurturing Holistic Student Development: The Role of OSAS at Batangas State University"),
            DataMain("Sustainability and Social Responsibility at BSU")
        )
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMain)
        val adapter = CivicAdapterMain(campusList) { position ->
            // Handle the item click here based on the position
            when (position) {
                0 -> {
                    // Handle click for Item 0
                    val intent = Intent(this, ZeroAboutTheUniversity::class.java)
                    startActivity(intent)
                }

                1 -> {
                    // Handle click for Item 1
                    val intent = Intent(this, OneAdministration::class.java)
                    startActivity(intent)
                }

                2 -> {
                    // Handle click for Item 2
                    val intent = Intent(this, TwoAdmission::class.java)
                    startActivity(intent)
                }

                3 -> {
                    // Handle click for Item 3
                    val intent = Intent(this, ThreeAboutTheCampuses::class.java)
                    startActivity(intent)
                }

                4 -> {
                    // Handle click for Item 4
                    val intent = Intent(this, FourStudentInitiatives::class.java)
                    startActivity(intent)
                }

                5 -> {
                    // Handle click for Item 5
                    val intent = Intent(this, FiveEmbraceSustainability::class.java)
                    startActivity(intent)
                }

                6 -> {
                    // Handle click for Item 6
                    val intent = Intent(this, SixProperManagement::class.java)
                    startActivity(intent)
                }

                7 -> {
                    // Handle click for Item 7
                    val intent = Intent(this, SevenPrograms::class.java)
                    startActivity(intent)
                }

                8 -> {
                    // Handle click for Item 8
                    val intent = Intent(this, EightStudentDevelopment::class.java)
                    startActivity(intent)
                }

                9 -> {
                    // Handle click for Item 9
                    val intent = Intent(this, NineSustainability::class.java)
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