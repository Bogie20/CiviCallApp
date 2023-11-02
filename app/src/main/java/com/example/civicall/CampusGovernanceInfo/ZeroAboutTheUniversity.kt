package com.example.civicall.CampusGovernanceInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityZeroAboutUniversityBinding

class ZeroAboutTheUniversity : AppCompatActivity() {
    private lateinit var binding:ActivityZeroAboutUniversityBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityZeroAboutUniversityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, CampusGovernanceMenu::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }


        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "DISCOVERING THE HISTORY OF BATANGAS STATE UNIVERSITY",
                "Batangas State University (BatStateU): Nurturing Innovation, Engineering Excellence, and Sustainable Development\n\n" +


                        "Nestled in the heart of the Philippines, Batangas State University (BatStateU) has a rich history that spans over a century. Established in 1903 as a Manual Training School for young men, the university has evolved into a distinguished institution known for its engineering programs, sustainable practices, and global impact.\"\n\n" +

                        "A JOURNEY THROUGH TIME\n\n" +


                        "1903 - 1957: FROM TRADE SCHOOL TO ARTS AND TRADES.\n\n" +

                        "Batangas State University's journey began in 1903 when it was founded as a Manual Training School. Over the years, it underwent several name changes and transformations:\"\n\n" +

                        "• In 1905, it became the Batangas Trade School.\n\n" +

                        "• 1952 marked its conversion into a National Trade School.\n\n" +

                        "• A year later, it was renamed the Pablo Borbon Memorial Trade School.\n\n" +

                        "• In 1957, it was rebranded as the Pablo Borbon Regional School of Arts and Trades, and it started offering technical courses.\n\n" +

                        "1968 - 2001: STATE COLLEGE TO STATE UNIVERSITY\n\n" +

                        "The next significant phase began in 1968 when it was converted into a state college and named the Pablo Borbon Memorial Institute of Technology. This transformation marked the 23rd state college in the Philippines. In 1971, it began offering industrial education and engineering programs. The journey continued, and in 1974, graduate degree programs were introduced.\n\n" +

                        "2001 - PRESENT: BECOMING BATANGAS STATE UNIVERSITY\n\n" +

                        "The dawn of the 21st century brought a pivotal change. In 2001, the institution was elevated to state university status and renamed Batangas State University. The subsequent years saw the establishment of international partnerships and the modernization of infrastructure to create a 21st-century learning environment.\n\n" +

                        "BatStateU's commitment to excellence was further solidified with its recognition as a Center of Excellence in Electronics Engineering and Center of Development in Mechanical Engineering, Electrical Engineering, Teacher Education, and Development Communication. It attained Level IV state university classification and received international accreditation for its engineering and IT programs.\n\n" +

                        "In 2018, the university received ISO 9001:2015 certification and was recognized as a Regional Center for Disaster Risk Management Education and Research. In 2020, it was awarded three stars by the QS stars rating, and 27 emerging programs in engineering and allied fields were approved for offering.\n\n" +

                        "2021 marked an expansion of international partnerships, including formalized cooperation with the Embassy of India through the BatStateU Knowledge, Innovation, and Science Technology (KIST) Park.\n\n" +

                        "THE LANDMARK MOMENT IN 2022\n\n" +

                        "In 2022, Batangas State University achieved a historic milestone. By virtue of Republic Act No. 11694, it became the first and only National Engineering University in the Philippines, underlining its dedication to nurturing innovation, engineering excellence, and sustainable development.\n\n" +

                        "A BEACON OF EXCELLENCE\n\n" +

                        "With a diverse student body of over 61,000 students and a dedicated faculty and staff of 2,600, Batangas State University stands as a beacon of excellence in the Philippines. It offers a comprehensive range of engineering programs and has gained recognition for its sustainable practices and international impact.\n\n" +

                        "The university's commitment to sustainability is evident in its ranking as the 351st World's Most Sustainable University by UI GreenMetric World University Ranking. It has actively embraced sustainability through the establishment of the Center for Sustainable Development (CSD) and Sustainability Development Officers (SDOs) in every constituent campus.\n\n" +

                        "As Batangas State University continues its journey towards becoming a premier national university, it remains devoted to developing leaders in the global knowledge economy, advancing engineering education, and promoting sustainable development, all while fostering innovation and excellence.\n\n" +

                        "Discovering the history of Batangas State University is not just a journey through time; it's a testament to the institution's enduring commitment to progress, innovation, and the betterment of society.\n\n",
                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/homepage-webslider-1.jpg",
                "https://batstate-u.edu.ph/about/"

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

    override fun onDestroy() {
        super.onDestroy()

        networkUtils.cleanup()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)}
}