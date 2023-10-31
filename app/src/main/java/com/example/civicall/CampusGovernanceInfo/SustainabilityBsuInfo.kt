package com.example.civicall.CampusGovernanceInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class SustainabilityBsuInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sustainability_bsu_info)



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "WELCOME TO THE CENTER FOR SUSTAINABLE DEVELOPMENT",



                "The Batangas State University (BatStateU) as a Higher Education Institution recognizes the importance of sustaina development practices through education, governance and management, collaboration and innovation. It emanat from programs, projects, and processes of the University.\n" +
                        "\n" +
                        "Hence to continuously champion such fundamental actions, BatStateU established the Center for Sustainable Development (CSD) with the goal of supporting regional and global initiatives aimed at meeting the United Nations' Sustainable Development Goals.\n" +
                        "\n" +
                        "The primary responsibility of CSD is to ensure that sustainability is an essential component of the university's core duties of instruction, research, innovation, and extension services, as well as its general administrative and general support services functions.\n" +
                        "\n" +
                        "The Batangas State University as the National Engineering University through the Center for Sustainable Development strongly commits to facilitate sustainability efforts in order to achieve the Global Goals 2030.\n\n" +

                        "The Office of Student Affairs and Services (OSAS) aims to mold globally competent and value-laden citizens by striving to enrich students through a holistic approach in providing Student Welfare and Development Programs and Services in consonance with the vision, mission, goals and objectives of Batangas State University and the mandates of the Commission on Higher Education (CHED). These basic services and programs   ensure and promote student well-being and are designed to explore, enhance and     develop the student’s full    potential in leadership and social responsibility through various institutional and student–initiated activities that upholds the core values of the university. \n\n"+

                        "UNIVERSITY VISION\n\n"+

                        "A premier national university that develops leaders in the global knowledge economy.\n\n"+

                        "UNIVERSITY MISSION\n\n"+

                        "A university committed to producing leaders by providing a 21st century learning environment through innovations in education, multidisciplinary research, and community and industry partnerships in order to nurture the spirit of nationhood, propel the national economy, and engage the world for sustainable development.\n\n"+


                        "MANDATES OF THE CENTER FOR SUSTAINABLE DEVELOPMENT\n\n"+


                        "1. Be the hub for SDGs-related information and activities\n" +
                        "\n" +
                        "2. Initiate the preparation of the Sustainability Plan\n" +
                        "\n" +
                        "3. Foster collaboration that brings together people, ideas and resources\n" +
                        "\n" +
                        "4. Initiate programs and practices that integrate sustainability into the university, including policy formulation\n" +
                        "\n" +
                        "5. Provide education and outreach to the University and its campuses, and surrounding community about sustainability\n" +
                        "\n" +
                        "6. Communicate sustainability knowledge, progress and activities\n" +
                        "\n" +
                        "7. Support and coordinate the Sustainability Council/Committee\n" +
                        "\n" +
                        "8. Further efforts to meet the goals of the university's Sustainability Plan and sustainability commitments\n" +
                        "\n" +
                        "9. Equip campuses to envision and implement their unique contribution to sustainability 10. Measure, assess and continually improve university sustainability efforts\n" +
                        "\n" +
                        "11. Embed sustainability into the University's culture and traditions\n" +
                        "\n" +
                        "12. Coordinate with the campuses student sustainability leadership program\n" +
                        "\n" +
                        "13. Provide trainings for sustainability coordinators\n\n"+

                        "OBJECTIVES OF CENTER FOR SUSTAINABLE DEVELOPMENT\n" +
                        "\n" +
                        "1. To contribute in the global efforts towards achieving the SDGs both locally and internationally 2. To advance its institutional vision for and commitment to sustainability and codified it to SDGs\n" +
                        "\n" +
                        "3. To instil among students and graduates a well-rounded education and global awareness, and equip them with the know and understanding, skills and attributes needed to work and live in a way that safeguards environmental, social and eco wellbeing, both in the present and for future generations\n" +
                        "\n" +
                        "4. To promote SDGs in the field of research and academics as well as in the management and operations of the University\n" +
                        "\n" +
                        "5. To contribute to the sustainable development of the country through collaborations and dialogue, aiming to realize a mo resilient society\n\n",


                "https://sustainability.batstate-u.edu.ph/about/",
                "https://sustainability.batstate-u.edu.ph/about/"
            )
        )







        val adapter = DataAdapter(dataList)

        // Set an item click listener for the adapter to open the link when the reference TextView is clicked
        adapter.setOnItemClickListener(object : DataAdapter.OnItemClickListener {
            override fun onReferenceClick(position: Int) {
                val clickedItem = dataList[position]
                val link = clickedItem.link

                // Open the link in a web browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(intent)
            }

            override fun onImageClick(position: Int) {
                val clickedItem = dataList[position]
                val imageLink = clickedItem.imageLink

                // Open the imageLink in a web browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(imageLink))
                startActivity(intent)
            }
        })


        // Set the adapter for the RecyclerView
        recyclerView.adapter = adapter

    }
}