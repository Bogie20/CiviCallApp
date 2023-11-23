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
import com.example.civicall.databinding.ActivitySixProperManagementBinding

class SixProperManagement : AppCompatActivity() {
    private lateinit var binding:ActivitySixProperManagementBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivitySixProperManagementBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }


        val dataList = ArrayList<DataItem>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        dataList.add(
            DataItem(
                "INSTITUTIONAL SUSTAINABILITY: GOVERNANCE & MANAGEMENT",
                "In today's rapidly evolving educational landscape, institutional sustainability is a cornerstone for long-term success and growth. Higher education institutions worldwide are seeking ways to ensure their continued relevance and impact. One essential component of this pursuit is comprehensive governance and management systems that demonstrate probity, strategic vision, accountability, risk management, and effective performance monitoring. These systems empower universities to respond to development and change proactively.\"\n\n" +


                        "Since 2014, an educational institution, known as the University, has been at the forefront of strategic initiatives, programs, and projects. These endeavors are meticulously designed to support collaboration, innovation, and engagement across the University's community. This comprehensive approach encompasses governance and management, teaching and learning, research, and extension services. The University's commitment to institutional sustainability is evident in its multi-faceted approach, aimed at ensuring its continued growth and impact.\"\n\n" +

                        "KEY COMPONENTS OF COMPREHENSIVE GOVERNANCE AND MANAGEMENT SYSTEMS\"\n\n" +

                        "Effective governance and management systems are crucial for achieving institutional sustainability. The comprehensive governance and management systems at the University consist of several key components, each contributing to the institution's long-term stability and growth. These components include:\"\n\n" +

                        "1. INTEGRITY AND OBJECTIVITY:\n\n" +
                        "A robust system is in place to ensure integrity and objectivity in the transaction of the University's business. This foundation fosters trust and transparency.\n\n" +


                        "2. STRATEGIC VISION:\n\n" +
                        "The University has a strategic plan that articulates its vision, strategy, and desired outcomes. This roadmap guides decision-making and sets the direction for future growth.\n\n" +

                        "3. CULTURE OF QUALITY AND ACCOUNTABILITY:\n\n" +
                        "A culture of quality and accountability is nurtured within the University. This culture ensures that all aspects of the institution operate at the highest standards.\n\n" +

                        "4. FINANCIAL STABILITY:\n\n" +
                        "A system and structure are established to safeguard the University's resources, making it solvent, financially stable, and viable. This financial strength is a cornerstone of sustainability\n\n" +


                        "5. CONTINUOUS IMPROVEMENT:\n\n" +
                        "Continuous quality improvement is a core principle at the University. This commitment to ongoing enhancement makes the institution reputable and sustainable over the long term.\n\n" +


                        "6. WELL-DOCUMENTED ORGANIZATIONAL STRUCTURES:\n\n" +
                        "The University maintains well-documented organizational structures, systems, and processes. These ensure sound management of the institution's day-to-day operations.\n\n" +


                        "7. SOUND FINANCIAL AND PHYSICAL RESOURCE MANAGEMENT:\n\n" +
                        "The University has well-documented systems and processes that reflect sound management of financial and physical resources. These processes are essential for effective resource allocation and utilization.\n\n" +


                        "EMBEDDING SUSTAINABILITY PRINCIPLES\n\n" +

                        "The principles of institutional sustainability are deeply embedded in the University's governance structures and operational policies. These principles influence decisions relating to various aspects of the institution, including employment, finance, campus services, support services, facilities, procurement, human resources, and student administration. This holistic approach ensures that every facet of the University's operation is geared towards sustainability.\n\n" +


                        "A HOLISTIC APPROACH TO SUSTAINABLE DEVELOPMENT\n\n" +
                        "While the University is already making significant contributions to sustainable development, a champion of sustainable development is necessary to further enhance these efforts. For true success, a whole-of-university approach is essential to deepen the institution's engagement with sustainable development, particularly focusing on Sustainable Development Goals (SDGs).\n\n" +


                        "TO ACHIEVE THIS, SEVERAL STEPS ARE ESSENTIAL:\n\n" +

                        "1. The University President, as a champion of sustainable development, must convene the Presidential Advisory Council to formally announce the adoption and advancement of SDGs at the University. This step is critical to align the entire institution with sustainable development objectives.\n\n" +

                        "2. The University needs to map its existing activities, connecting University teaching, research, extension, management, and operations to sustainable development goals. This mapping will identify areas of strength and areas that need further attention.\n\n" +

                        "3. Building internal capacity and ownership of sustainable development advocacies and programs is crucial. This step ensures that sustainable development principles are embraced and understood across the University.\n\n" +


                        "4. Identifying priorities, opportunities, and gaps is essential for targeted action. This strategic assessment will guide the University's efforts in sustainable development.\n\n" +

                        "5. Integrating, implementing, and embedding sustainable development within university strategies, policies, and plans is the practical realization of the institution's commitment to SDGs.\n\n\n" +

                        "6. Monitoring, evaluating, and communicating university actions on sustainable development is essential for accountability and transparency.\n\n" +

                        "7. Finally, the University should focus on strengthening public engagement and participation in addressing sustainable development. This includes initiating and facilitating cross-sectoral dialogue, ensuring representation in national implementation, designing sustainable development-based policies, and demonstrating unwavering commitment to sustainable development.\n\n\n" +





                        "The University's journey towards institutional sustainability is multifaceted. Governance and management systems are pivotal in ensuring that the institution remains accountable, proactive, and adaptable to change. By adopting the principles of sustainable development and the SDGs, the University is taking a significant step towards fostering a culture of sustainability that will shape its future.\n\n" +

                        "Achieving institutional sustainability is a collective endeavor that demands engagement from all corners of the University community. With the University President leading the way, and the commitment to a whole-of-university approach, the institution is poised to make a lasting impact on sustainable development, both locally and globally. As the higher education sector navigates an ever-changing landscape, institutions like the University are setting a benchmark for responsible, accountable, and forward-thinking governance and management.\n\n",

                "https://businessmirror.com.ph/wp-content/uploads/2023/02/Microsoft-Philippines-x-Batangas-State-University-scaled.jpg",
                "https://sustainability.batstate-u.edu.ph/programs/institutional-sustainability/governance-and-management/"

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

        networkUtils.cleanup()
    }
}