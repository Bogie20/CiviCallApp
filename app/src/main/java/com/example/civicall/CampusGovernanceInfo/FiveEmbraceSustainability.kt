package com.example.civicall.CampusGovernanceInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityFiveEmbraceSustainabilityBinding

class FiveEmbraceSustainability : AppCompatActivity() {
    private lateinit var binding:ActivityFiveEmbraceSustainabilityBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityFiveEmbraceSustainabilityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dataList = ArrayList<DataItem>()


        dataList.add(
            DataItem(
                "INDUSTRY IMMERSION AND INTERNSHIP PROGRAM",
                "The University endeavors to strengthen the industry exposure of its faculty and students by infusing industry-based skills into the curriculum. Immersion with foreign industries and conducting internship in foreign institutions ensure that faculty and students apply theory to practice in a global environment, thus avoiding skills mismatch between academic inputs and industry needs.\"Comprehensive Disaster Preparedness Kits: A Guide to Effective Disaster Response\" and equip yourself with the knowledge to safeguard your community and ensure a brighter, more resilient future.\"\"\n\n",


                "https://images.squarespace-cdn.com/content/v1/5cc4ebe48dfc8cbcaefee893/1579057740517-NC8OG2J3WY7MGHJ1KZVH/IIP_WEB_1.png",
                "https://batstate-u.edu.ph/global/"
            )
        )


        dataList.add(
            DataItem(
                "SOCIAL INNOVATION PROGRAM",
                "Batangas State University partners with foreign institutions for a social innovation program, where BatStateU students collaborate with foreign students in engaging in community-based projects and volunteer activities to address the needs of local communities, while at the same time harnessing their critical thinking and collaborative learning skills using the Design Thinking Methodology. \n\n",


                "https://www.soil.edu.in/wp-content/uploads/2016/10/blog-SOIL-PGP-One-year-MBA-inclusive-of-the-Social-Innovation-Program.jpg",
                "https://batstate-u.edu.ph/global/"
            )
        )


        dataList.add(
            DataItem(
                "VISITING PROFESSOR PROGRAM",
                "The university’s Visiting Professor Program welcomes faculty experts and professionals from all over the world to conduct a series of lectures on specialized topics in various academic and research fields. The program is sometimes facilitated in partnership with other universities or organizations.\n\n",

                "https://paruluniversity.ac.in/app/202111127523/images/Visiting%20Professor.jpg",
                "https://batstate-u.edu.ph/global/"
            )
        )


        dataList.add(
            DataItem(
                "STUDENT EXCHANGE PROGRAM",
                "The program provides opportunities for BatStateU students to study in a foreign country and explore that country’s rich history and culture. Similarly, students from other countries are welcomed in Batangas State University, as they study here and engage themselves in various cultural and social activities for academic and personal development. \n\n",


                "https://public.goodeducation.com.au/images/800x100p/iStock_000020672036Medium2sml2.jpg",
                "https://batstate-u.edu.ph/global/"
            )
        )


        dataList.add(
            DataItem(
                "INTERNATIONAL CONFERENCE HOSTING",
                "The University hosts the biennial International Research Conference on Innovations in Engineering, Science and Technology (IRCIEST), which is an international gathering of science and engineering professionals, researchers, and academicians who share advancements in the field through intensive lectures, master classes, research presentations, and pitching competitions. The university also hosts an International Research Conference on Business, Education and Social Sciences. Recently, the university hosted the first ASEAN Conference and Exposition on Disaster Risk Management and Climate Change Adaptation.\n\n",

                "https://kmeducationhub.de/wp-content/uploads/2014/08/wc-knowledgemanagement-conferences.jpg",
                "https://batstate-u.edu.ph/global/"
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

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
    override fun onDestroy() {
        super.onDestroy()


        // Cleanup to unregister the network callback
        networkUtils.cleanup()
    }

}