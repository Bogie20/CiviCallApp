package com.example.civicall.EnvironmentalandSocialIssueInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class CommunitiesinPerilInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communitiesin_peril_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "CAUSES OF DISPLACEMENT, INCLUDING NATURAL DISASTERS AND DEVELOPMENT PROJECTS",
                "Amidst lingering agrarian reform delays and land rights struggles, land grabbing takes center stage in this special two-part edition of Focus Policy Review. Delve into the intricate landscape of land grabbing, driven by political, economic, and environmental factors, as it intersects with issues of displacement and development projects.\"\n\n" +
                        "1. PROLONGED AGRARIAN REFORM: The Comprehensive Agrarian Reform Program (CARP) has taken 27 years to be implemented, causing frustration among farmers and advocates.\n\n" +
                        "2. CARP vs. Landed Elite: Despite its noble intentions, CARP is seen as favoring the interests of the landed elite, leading to discrepancies in land distribution.\n\n" +
                        "3. LAND GRABBING: Land grabbing is a significant issue affecting those targeted as agrarian reform beneficiaries and title holders. \n\n" +
                        "4. THE POLITICAL DIMENSION: Land grabbing is inherently political, with economic motives at its core, emphasizing the influence of power dynamics. \n\n" +
                        "5. BORACAY DEVELOPMENT: The case of Boracay's development for tourism serves as a striking example of land grabbing in action. \n\n" +
                        "6. DISASTER CAPITALISM: After the devastation of Typhoon Yolanda/Haiyan, disaster capitalism complicated land issues for affected rural communities.\n\n" +
                        "7. GOVERNMENT POLICIES: Government policies, including investment and public-private partnerships, have contributed to land grabbing issues. \n\n" +
                        "8. GLOBAL AND REGIONAL DYNAMICS: Land grabbing isn't limited to the Philippines; it's influenced by international actors and regional contexts\n\n" +
                        "9. LAND RIGHTS DEFINED: Understanding land grabbing involves grasping land rights, encompassing land ownership, control, and usage. \n\n" +
                        "10. LEGAL TOOLS AND HUMAN RIGHTS: There are international human rights instruments and legal tools aimed at safeguarding land, forests, fisheries, and natural resources. \n\n",
                R.drawable.img_321,
                "https://focusweb.org/wp-content/uploads/2017/04/PolicyReview2015_Understanding-Land-Rights_Land-Grabbing_21stCentury.pdf",
                "https://viacampesina.org/en/wp-content/uploads/sites/2/2014/03/solidarity%20missionscaled.jpg"
            )
        )
        dataList.add(
            DataItem("CHALLENGES FACED BY INTERNALLY DISPLACED PEOPLE",
                "In the Philippines, internally displaced people face a myriad of challenges. This article delves into the issues surrounding their displacement and the need for a rights-based approach to address them.\n\n" +
                        "1. ABSENCE OF NATIONAL POLICY: Internally displaced people (IDPs) in the Philippines face challenges due to the absence of a national policy on internal displacement.\n\n" +
                        "2. MARAWI CITY CONFLICT: The Marawi City conflict in 2017, which displaced around 360,000 people, serves as a specific example of IDP challenges..\n\n" +
                        "3. LEGAL FRAMEWORK: The response to displacement is primarily governed by the Philippine Disaster Risk Reduction and Management Act of 2010 (PDRRMA), which lacks a strong rights-based foundation.\n\n" +
                        "4. PROCUREMENT DELAYS: Government use of disaster funds often undergoes lengthy procurement and disbursement processes, delaying the provision of aid to IDPs.\n" +
                        "5. RESTRICTIONS ON RELIEF GOODS: IDPs are sometimes forbidden from selling relief goods, even when the quality and variety of goods provided are limited, which contravenes international standards.\n\n" +
                        "6. LACK OF LIVELIHOOD OPPORTUNITIES: Some displaced communities have limited access to livelihood opportunities, hindering their recovery.\n\n" +
                        "7. GENDER-SENSITIVE ARRANGEMENTS: Women and girl IDPs are vulnerable to sexual harassment and trafficking due to the absence of gender-sensitive arrangements in evacuation areas.\n\n" +
                        "8. CAMP COORDINATION CHALLENGES: Coordination mechanisms for IDP camps face issues due to confusion among government authorities and limited resources of local host governments.\n\n" +
                        "9. MILITARIZED RESPONSE: The response to IDP issues is heavily militarized, with the Department of National Defense playing a central role.\n\n" +
                        "10. RIGHTS-BASED APPROACH NEEDED: The absence of specific rights for IDPs hinders their ability to claim entitlements and engage in meaningful dialogue, highlighting the need for a more rights-based approach to internal displacement.\n\n",
                R.drawable.img_322,
                "https://chr.gov.ph/a-disaster-approach-to-displacement-idps-in-the-philippines/",
                "https://www.peaceinsight.org/wp-content/uploads/2015/06/Philippines-IDPs.jpg")
        )
        dataList.add(
            DataItem("RESETTLEMENT PROGRAMS AND THEIR EFFECTIVENESS",
                "In the wake of natural disasters and climate change challenges, resettlement programs have gained attention as a strategy to mitigate displacement. However, the effectiveness of these programs is under scrutiny, with concerns about prolonged displacement and increased vulnerability.\"\n\n" +
                        "1. COMPLEX RESETTLEMENT PROCESS: Resettling populations as a strategy to mitigate displacement from disasters is a complex process requiring substantial planning and resources.\n\n" +
                        "2. RIGHTS OF DISPLACED POPULATIONS: Insufficient planning and safeguards can infringe on the legal and human rights of displaced persons, prolonging their displacement.\n\n" +
                        "3. NATIONAL LEGAL FRAMEWORKS: Governments must have national legal frameworks in place to protect the rights of affected individuals in post-disaster resettlement.\n\n" +
                        "4. INSTITUTIONAL ARRANGEMENTS: Establishing institutional arrangements with clear roles and responsibilities at various levels of government is crucial for effective resettlement.\n\n" +
                        "5. PROTECTION STRATEGIES: International humanitarian agencies should implement transitional shelter and protection strategies during resettlement to safeguard internally displaced people.\n\n" +
                        "6. COLLABORATION: Governments and humanitarian agencies must collaborate to develop inclusive, innovative, and flexible shelter and resettlement responses that go beyond simply relocating people to new areas.\n\n" +
                        "7. AMBITIOUS GOVERNMENT PLAN: The Philippine government adopted an ambitious plan to resettle 200,000 households after Typhoon Haiyan to mitigate future displacement risks.\n\n" +
                        "8. DISPLACEMENT CHALLENGES: Observations indicate that government-led resettlement can carry significant risks, potentially prolonging displacement and increasing vulnerability.\n\n" +
                        "9. DISASTER RESPONSE: Humanitarian agencies play a crucial role in post-disaster resettlement, working alongside government counterparts and development agencies.\n\n" +
                        "10. LESSONS LEARNED: The article's findings stress the importance of careful planning, legal safeguards, and collaboration to ensure the effectiveness of resettlement programs in disaster-prone regions.",
                R.drawable.img_323,
                "https://reliefweb.int/report/philippines/philippines-post-typhoon-resettlement-plan-carries-risks",
                "https://www.jvejercito.com/wp-content/uploads/2018/07/30740556_1953317138011624_5043007353213943808_n-960x640.jpg")
        )

        dataList.add(
            DataItem("LEGAL RIGHTS AND PROTECTION FOR DISPLACED COMMUNITIES",
                "BARMM's proposed \"Rights of Internally Displaced Persons of the Bangsamoro Autonomous Region Act\" is a crucial step in safeguarding the rights and protection of displaced communities. This article delves into the importance of legal rights for those affected by displacement.\"\n\n" +

                        "1.IDP INCREASE IN BARMM: The Bangsamoro Autonomous Region in Muslim Mindanao (BARMM) has witnessed a significant rise in the number of internally displaced persons (IDPs) in recent years, reaching 127,826 in 2022 due to natural disasters and armed conflicts.\n\n" +
                        "2.PROPOSED REGIONAL LAW: BARMM introduces Bangsamoro Transition Authority (BTA) Bill No. 32, certifying it as a priority piece of legislation to protect the rights and welfare of both Muslim and non-Muslim IDPs within its jurisdiction.\n\n" +
                        "3.AIMS OF THE PROPOSED LAW: The Rights of Internally Displaced Persons of the Bangsamoro Autonomous Region Act is designed to address safety, basic needs, healthcare, education, and livelihood concerns of IDPs.\n\n" +
                        "4.COMMUNITY INVOLVEMENT: Public consultations were held in Marawi City and Cotabato City, giving IDPs, community leaders, and stakeholders a platform to express their opinions on the proposed law.\n\n" +
                        "5.ALARMING STATISTICS: BARMM's Ministry of Social Services and Development presented concerning figures during the consultations, highlighting the pressing need to support IDPs. In 2022, 58,915 IDPs were displaced due to natural disasters, while 68,911 were affected by armed conflicts.\n\n" +
                        "6.KEY PROVISIONS: The proposed law contains key provisions ensuring IDPs' access to basic needs, healthcare, education, freedom of movement, document recognition and replacement, and security and protection.\n\n" +
                        "7.IMMEDIATE RELIEF AND HUMANITARIAN ASSISTANCE: The legislation aims to provide immediate relief and humanitarian assistance to IDPs, their families, and communities.\n\n" +
                        "8.CONTINUED CONSULTATIONS: Additional consultations are scheduled in the provinces of Basilan, Sulu, and Tawi-Tawi, with a committee report expected in July.\n\n" +
                        "9.SAMIRA GUTOC'S PERSPECTIVE: Marawi Rescue Team head Samira Gutoc, a former senatorial candidate and an IDP herself, emphasizes that the bill promotes an environment that protects conflict victims and fosters economic growth.\n\n" +
                        "10.REGIONAL GOVERNMENT RESPONSIBILITY: The proposed legislation places significant responsibility on regional government bodies and local authorities to execute the mandate effectively in the absence of a national law addressing IDPs' rights in the Philippines.",
                R.drawable.img_324,
                "https://www.rappler.com/nation/mindanao/barmm-works-law-aid-residents-displaced-violence-disasters/",
                "https://www.rappler.com/tachyon/2021/07/bukidnon-07162021-002.jpg")
        )

        dataList.add(
            DataItem("ASSESSING PHILIPPINE RECLAMATION PROJECTS",
                "In the Philippines, a surge in reclamation projects promises economic growth but raises concerns about long-term consequences for displaced populations and the environment. Explore the impacts and transparency issues surrounding these ventures.\n\n\n" +

                        "1. RISING RECLAMATION PROJECTS: The Philippines witnesses a surge in reclamation projects, reaching over 180, promising economic development.\n\n" +
                        "2. DATA AND TRANSPARENCY ISSUES: Lack of data and public transparency hinder efforts to assess the real socioeconomic impacts of these reclamation projects.\n\n" +
                        "3. ENVIRONMENTAL AND SOCIAL CONCERNS: Scientists and environmentalists raise concerns about adverse and permanent effects, including displacements and food insecurity.\n\n" +
                        "4. HISTORICAL CONTEXT: Reclamation dates back to Spanish and American colonial eras, affecting communities and the environment.\n\n" +
                        "5. PAST CONTROVERSIES: Projects like the Cultural Center of the Philippines (CCP) Complex and Boulevard 2000 faced corruption scandals and environmental costs.\n\n" +
                        "6. RECENT PROPOSALS: Despite controversies, reclamation projects continue to gain momentum, especially during President Duterte's administration.\n\n" +
                        "7. IMPACT ON EMPLOYMENT: Questions are raised about the quality and security of jobs generated by reclamation projects.\n\n" +
                        "8. TRANSPARENCY CHALLENGES: Transparency issues, lack of consultations, and diversion tactics complicate the debate over reclamation.\n\n" +
                        "9. HOT SPOTS: Reclamation projects are concentrated in Visayas and Calabarzon regions, particularly Manila Bay.\n\n" +
                        "10. LONG-TERM CONSEQUENCES: Reclamation's impact on urban decline and increased flooding highlights the need for careful, data-driven assessments.",
                R.drawable.img_325,
                "https://www.rappler.com/environment/reclamations-philippines-spreading-posing-dangers/",
                "https://www.rappler.com/tachyon/2022/05/reclamation-watch-PH-May-27-2022.jpg?resize=1280%2C720&zoom=1")
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