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

class OneAdministration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_administration)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "ADMINISTRATIONS ABOUT",
                "The Administration and Finance – Central Administration serves as a proactive partner in delivering excellent service to the Batangas State University community. It embraces BASICS: Brand of Excellence, Access, Social Relevance, Inclusive Innovation, Capacity and Sustainability - the pillars of the University’s Strategic Plan 2019-2029.\n\n" +

                        "The Vice President for Administration and Finance provides leadership, over-all direction and supervision in the operation of and in the implementation of policies and procedures for procurement services, supplies and property management, human resource management and development, records keeping and management, facility planning and maintenance, motor pool, ground maintenance and other related services (Administration Services); accounting, budgeting, utilization and disbursement of cash (Financial Services); infrastructure development, project implementation, inspection and monitoring (Project Management); and medical and dental services (Health Services).\n\n" +

                        "Within those offices lie critical functions of strategic allocation of resources, including but not limited to human, physical and financial, and administrative and general support services that enable the University to excel in academic, research, extension and other community services. By providing data, financial information, insight and analysis, we assist leadership and management in its financial and management decisions that help fulfill its mission while maintaining a position of financial strength and ensuring compliance with applicable laws, rules and regulations, the university’s internal policies and guidelines including.\n\n" +


                        "The Administration and Finance – Central Administration is responsive to the short and long term needs of the BatStateU community. It interconnects its services to the United Nation's Sustainable Development Goals (SDGs). Our work is organized around three primary goal areas cutting across strategic priorities of the University:\n\n" +

                        "1. To provide the highest levels of services in order to promote the success of Red Spartans students, our colleagues in the BatStateU community, and the public using the best available tools, technologies and practices (Service);\n\n" +

                        "2. To provide a safe environment that protects and encourages improvements in the health and wellness of all aspects of the BatStateU community (Health and Safety); and\n\n" +


                        "3. to ensure that all human, financial, physical and other resources owned by and entrusted to the University are deployed and utilized in an effective, efficient, transparent, and socially responsible manner for viability and sustainability of its operation (Stewardship).\n\n" +


                        "With a team of dedicated men and women, we seek to elevate the University to “Greater Heights of Excellence in Innovation and Social Transformation” as it traverses its path to becoming a premier national university.\n\n" +


                "GUIDING PRINCIPLES\n\n" +

                        "PATRIOTISM\n" +

                        "We are proud of our identity as a Filipino with rich culture, ethics, dignity and moral values. We will embrace patriotism in the simplest acts in our professional work and personal lives. We will take a fair share of the burdens of improving the country, by protecting its interest, obeying our laws, and keeping public funds and property secured and well accounted for. We will work for the conservation and protection of the environment.\n\n" +


                        "INTEGRITY\n" +

                        "We will conduct ourselves in a manner that is exemplary and beyond reproach at all times. We will be professional, in every aspect, in dealing with our superiors, subordinates, and to our interactions with all persons, whether members of the BatStateU community or the larger society. When faced with difficult decisions and hard choices, we will do what is right, moral, just, and fair even in the face of adversity.\n\n" +

                        "EXCELLENCE\n" +

                        "We will measure excellence by equity, inclusion and superior performance. We shall embrace innovation by systematically exploring new ideas and encouraging employees to do it without fear of failure. We will treat everyone the same, regardless of that individual’s position within the University. We will endeavor to foster friendships and mutual understanding among those with whom we work, respect their opinion and individual differences, and approach each unfamiliar situation with an open and accepting frame of mind.\n\n" +


                        "SERVICE\n" +

                        "We will work together closely and collaboratively for the common good and make our personal goals secondary to group goals. We will encourage sense of belonging, cultivate strength in our combined experience and expertise, inculcate a greater sense of ownership and accountability for the work, and foster trustworthiness among each other. We will have passion on what we do and we will be proud of what we accomplished. We will be relentless and driven to meet our goals.\n\n" +


                        "RESILIENCE\n" +

                        "We will ensure our ability to prepare for and adapt to changing working conditions and leadership, governance and management mechanisms and recover rapidly from work disruptions and challenges it entails.\n\n" +


                        "FAITH \n" +

                        "We share and demonstrate our strong faith in a Supreme Being through committed, dedicated and faithful service to the BatstateU community. We will inspire faith that is needed in every step of our journey as public servant.\n\n" +


                        "With a team of dedicated men and women, we seek to elevate the University to “Greater Heights of Excellence in Innovation and Social Transformation” as it traverses its path to becoming a premier national university.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/11/irciest-3.jpg",
                "https://batstate-u.edu.ph/about/"

            )
        )

        dataList.add(
            DataItem(
                "ADMINISTRATION SERVICES",
                "Atty. Luzviminda Rosales, Vice President for Administration Finance, during the ocular inspection of unserviceable properties of the University for disposal.\n\n" +
                        "Facilitates University activities and operations; and provides proficient and economical services relating to records, humans resources, procurement, property and supply, and general services.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2023/02/vpaf-general-functions-of-unit-1.jpg",
                "https://batstate-u.edu.ph/administration-services/about-us"

            )
        )

        dataList.add(
            DataItem(
                "HUMAN RESOURCE MANAGEMENT OFFICE",
                        "Performs human resource responsibilities on recruitment, selection and placement; learning and development; rewards and recognition; and performance management, and ensures that the University strengthens employee empowerment.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2023/02/vpaf-general-functions-of-unit-2.jpg",
                "https://batstate-u.edu.ph/administration-services/general-functions-of-units/"

            )
        )

        dataList.add(
            DataItem(
                "PROCUREMENT OFFICE",
                "Procures best quality goods and services; reviews the accuracy and completeness of all documents pertaining to procurement transactions; and ensures effective and efficient management of procurement processes and procedures.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/scholar-1.jpg",
                "https://batstate-u.edu.ph/administration-services/general-functions-of-units/"

            )
        )



        dataList.add(
            DataItem(
                "RECORDS MANAGEMENT OFFICE",
                "Performs systemic and administrative control of records; ensures efficiency, consistency and uniformity of records management in terms of access, confidentiality and security; and complies with the rules and regulations that govern the management of public records.\n\n",

                "https://cda.gov.ph/wp-content/uploads/2021/01/2017-08-01-news-cormic.jpg",
                "https://batstate-u.edu.ph/administration-services/general-functions-of-units/"

            )
        )


        dataList.add(
            DataItem(
                "PROPERTY AND SUPPLY OFFICE",
                "Manages, utilizes and safeguards the properties and supplies against loss and wastage in accordance with the existing rules and regulations of the University which ensure the effective and efficient delivery of services to internal and external clients.\n\n",

                "https://dab.bangsamoro.gov.ph/wp-content/uploads/2023/07/239907930_159783403009539_9009296346119503774_n.jpg",
                "https://batstate-u.edu.ph/administration-services/general-functions-of-units/"

            )
        )

        dataList.add(
            DataItem(
                "GENERAL SERVICES OFFICE",
                "Implements policies and guidelines on general services functions such as facility management services; building, equipment and grounds maintenance, and motor pool services.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2023/02/vpaf-general-functions-of-unit-8.jpg",
                "https://batstate-u.edu.ph/administration-services/general-functions-of-units/"

            )
        )

        dataList.add(
            DataItem(
                "FINANCIAL SERVICES",
                "Provides quality financial services relating to accounting, budgeting and cashiering which include the effective and sustainable allocation and management of funds that support the strategic plan of the University.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/scholar-3.jpg",
                "https://batstate-u.edu.ph/administration-services/general-functions-of-units/"

            )
        )

        dataList.add(
            DataItem(
                "BUDGET OFFICE",
                "Performs the budgeting process from budget preparation to execution and accountability; and coordinates with the concerned offices/agencies on the proper allocation and utilization of government funds toward effective and efficient fiscal leadership.\n\n",

                "https://bongabong.gov.ph/assets/img/offices/MBO/MMO02780.JPG",
                "https://batstate-u.edu.ph/administration-services/general-functions-of-units/"

            )
        )



        dataList.add(
            DataItem(
                "CASHIER OFFICE",
                "Ensures safekeeping of money, checks and official receipts; ensures that all collections are properly recorded and timely deposited; and maintains a complete record of check disbursement and accounts.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2023/02/vpaf-general-functions-of-unit-10.jpg",
                "https://batstate-u.edu.ph/administration-services/general-functions-of-units/"

            )
        )


        dataList.add(
            DataItem(
                "PROJECT MANAGEMENT OFFICE",
                "Develops and implements plans for infrastructure development; and ensures that infrastructure projects are properly coordinated and consistent with University's strategic thrusts and priorities.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2023/02/vpaf-general-functions-of-unit-11.jpg",
                "https://batstate-u.edu.ph/administration-services/general-functions-of-units/"

            )
        )

        dataList.add(
            DataItem(
                "FINANCIAL SERVICES  OFFICE",
                "Provides quality financial services relating to accounting, budgeting and cashiering which include the effective and sustainable allocation and management of funds that support the strategic plan of the University.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/scholar-3.jpg",
                "https://batstate-u.edu.ph/administration-services/general-functions-of-units/"

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