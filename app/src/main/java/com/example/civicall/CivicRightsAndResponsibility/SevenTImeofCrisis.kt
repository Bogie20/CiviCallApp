package com.example.civicall.CivicRightsAndResponsibility

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class SevenTImeofCrisis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven_timeofcrisis)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "DISASTER PREPAREDNESS IN CITIZEN RESPONSIBILITIES",
                "Amidst recent disasters, youth groups call for strengthening local civilian organizations, like the Sanggunian Kabataan (SK), highlighting the pivotal role of citizens in disaster preparedness and response. Explore how civic responsibilities play a crucial role in disaster resilience.\n\n" +
                        "1. CIVIC EMPOWERMENT THROUGH SKS\n" +
                        "   - Youth groups advocate for the empowerment of Sanggunian Kabataan (SK) in disaster response.\n" +
                        "2. LOCAL CIVILIAN LEADERSHIP MATTERS\n" +
                        "   - Local community officials and youth organizations are vital for mobilizing communities during crises.\n" +
                        "3. SKS AND CIVILIAN EXPERTISE\n" +
                        "   - SKs possess grassroots knowledge that can enhance disaster response efforts.\n" +
                        "4. A CALL FOR GOVERNMENT SUPPORT\n" +
                        "   - Youth groups stress the need for proper training, funding, and government support for civic organizations.\n" +
                        "5. THE ROLE OF MILITARY IN DISASTERS\n" +
                        "   - The military is seen as a force multiplier in national emergencies but should collaborate with locals for effective response.\n" +
                        "6. RECOGNIZING LOCAL BAYANIHAN EFFORTS\n" +
                        "   - Acknowledging citizens' efforts despite limited resources is crucial for disaster resilience.\n" +
                        "7. EMPOWERING SK OFFICIALS\n" +
                        "   - The SK compensation and empowerment law aims to professionalize youth leaders in disaster response.\n" +
                        "8. GRASSROOTS ORGANIZATIONS IN DISASTER RESPONSE\n" +
                        "   - Grassroots organizations like SKs are well-positioned for local disaster risk reduction and relief efforts.\n" +
                        "9. GOVERNMENT RESPONSIBILITY\n" +
                        "   - Strengthening civic organizations doesn't absolve the national government from its disaster response duties.\n" +
                        "10. ADDRESSING THE CLIMATE CRISIS\n" +
                        "    - The need to hold elites accountable for the climate crisis is emphasized, moving beyond disaster preparedness to root causes.\n",

                "https://www.rappler.com/tachyon/2022/10/paeng-aftermath-kawit-cavite-october-30-2022-001.jpg?resize=1400%2C933&zoom=1",
                "https://www.rappler.com/nation/youth-groups-say-government-must-strengthen-sangguniang-kabataan-civilian-role-disaster-response/"

            )
        )
        dataList.add(
            DataItem("ROLE OF CIVIL SOCIETY ORGANIZATIONS IN CRISIS RESPONSE",
                "\"Discover Agos, the innovative platform powered by eBayanihan, where civil society organizations leverage technology to connect those in need with those who can help during disasters. Explore how Agos fosters a collaborative approach in crisis response, bridging the gap between government action and civic engagement for a more resilient nation.\n\n" +
                        "1. A COLLABORATIVE PLATFORM\n" +
                        "   - Agos combines government action with bottom-up civic engagement for effective disaster management.\n" +
                        "2. AGOS ALERT MAP FOR CRITICAL INFORMATION\n" +
                        "   - The Agos Alert Map integrates and validates critical information for disaster preparedness and response.\n" +
                        "3. AGOS MICROSITE FOR KNOWLEDGE\n" +
                        "   - The Agos microsite provides multimedia content explaining disaster risk reduction and climate change adaptation.\n" +
                        "4. CIVIC ENGAGEMENT THROUGH MOVE.PH\n" +
                        "   - Agos conducts on-ground activities and trainings, fostering a community aligned with disaster response.\n" +
                        "5. COLLABORATION BETWEEN RAPPLER AND EBAYANIHAN\n" +
                        "   - The collaboration combines academic analysis with user experience, enhancing disaster management.\n" +
                        "6. REAL-WORLD IMPACT\n" +
                        "   - Agos-eBayanihan has made a significant impact during disasters like Super Typhoon Yolanda and Typhoon Mario.\n" +
                        "7. CITIZEN ACTION IN DISASTER RESPONSE\n" +
                        "   - Citizen action through social media is a crucial part of the government's disaster response.\n" +
                        "8. POPULARIZING HAZARD INFORMATION\n" +
                        "   - Agos' microsite spreads in-depth information on hazards and disaster prevention to millions of people.\n" +
                        "9. DISASTER PREPAREDNESS AND TRAINING\n" +
                        "   - Agos conducts training and workshops for government agencies and civil society groups to improve preparedness.\n" +
                        "10. SUPPORT FROM THE AUSTRALIAN GOVERNMENT\n" +
                        "   - Agos launched the campaign 'Make #ZeroCasualty a reality' with support from the Australian Government, connecting a network of experts and civic leaders for disaster management.\n",

                "https://blogs.adb.org/sites/blogs/files/phi-smokey-mountain-06-1.jpg",
                "https://www.rappler.com/environment/disasters/174836-174836-about-agos-ebayanihan-disasters-community-action/"
          )
        )
        dataList.add(
            DataItem("COMMUNITY RESILIENCE IN CIVIC ENGAGEMENT",
                "Explore the heart of community resilience in disaster response as engaged communities and households take center stage. Learn how civic engagement plays a crucial role in achieving a zero-casualty disaster response, addressing challenges, and utilizing innovative solutions.\"\n\n" +

                        "1. COMMUNITY ENGAGEMENT FOR DISASTER RESPONSE\n" +
                        "   - Engaged communities and households are central to successful disaster response and risk reduction efforts.\n" +
                        "2. BALANCING INFORMATION AND ACTION\n" +
                        "   - Effective disaster management requires not only accessible information on disasters but also active community participation.\n" +
                        "3. ONGOING CONVERSATION ON DISASTER MITIGATION\n" +
                        "   - The Philippines continues to discuss how to improve disaster response and mitigation, especially after ranking high on the 2022 World Risk Index.\n" +
                        "4. ISSUES DISCUSSED IN THE FORUM\n" +
                        "   - The forum titled '#ZeroCasualty: How Do We Get There' addresses topics like disinformation during disasters, education, disaster risk communication, and persistent challenges.\n" +
                        "5. PANEL PARTICIPANTS\n" +
                        "   - The panel included experts from various fields, including representatives from Phivolcs, Oxfam Pilipinas, and The Bike Scouts Project.\n" +
                        "6. THE IMPORTANCE OF LOCAL CONTEXT\n" +
                        "   - Discussions on disaster risk reduction sometimes overlook the importance of local context in determining community needs.\n" +
                        "7. HOUSEHOLD RESILIENCE\n" +
                        "   - To build resilient communities, households must be trained and prepared for disaster response.\n" +
                        "8. CHALLENGES IN DISASTER RESPONSE\n" +
                        "   - Challenges include underutilized disaster funds, procurement difficulties, and insufficient resources at various government levels.\n" +
                        "9. UTILIZING SOCIAL MEDIA\n" +
                        "   - Social media can be a valuable tool for disaster response, provided that information shared is accurate.\n" +
                        "10. EXAMPLES OF EFFECTIVE RESPONSE\n" +
                        "    - Albay province's evacuation measures and grassroots initiatives like the Linao Self Help Group are cited as examples of effective disaster response and recovery efforts.\n",

                "https://www.rappler.com/tachyon/2023/07/move-ph-zero-casualty-forum-july-28-2023.png?resize=2878%2C1540&zoom=0.5",
                "https://www.rappler.com/nation/communities-families-heart-zero-casualty-disaster-response/"
              )
        )

        dataList.add(
            DataItem("CIVIC RESPONSIBILITY IN POST-DISASTER RECOVERY",
                "Discover how civic responsibility played a pivotal role in post-disaster recovery efforts following Typhoon Yolanda. This article highlights the collaborative actions of local and international organizations, emphasizing the importance of mutual cooperation and volunteerism in rebuilding communities.\"\n" +
                        "1. INTERNATIONAL COLLABORATION FOR RECOVERY\n" +
                        "   - Civic responsibility shone brightly in the wake of Typhoon Yolanda as local and international support joined forces for the Philippines' recovery.\n" +
                        "2. WISDOM OF THE INTERNATIONAL COMMUNITY\n" +
                        "   - Gathering global wisdom and fostering lasting relationships were seen as essential for effective disaster response and future cooperation.\n" +
                        "3. EMPOWERING VOLUNTEERISM\n" +
                        "   - The promotion of volunteerism in the face of climate challenges was a cornerstone of Yolanda recovery, uniting international communities and local wisdom.\n" +
                        "4. SYMBOL OF HOPE AND RESILIENCE\n" +
                        "   - Super Typhoon Yolanda became a symbol of hope and resilience, inspiring shared endeavors between individuals and international aid for affected residents.\n" +
                        "5. CHALLENGES IN RECONSTRUCTION\n" +
                        "   - Local government units faced challenges in the reconstruction process, highlighting the importance of coordinated activities and support from various groups.\n" +
                        "6. MONEY DONATIONS FOR REBUILDING\n" +
                        "   - Donations played a crucial role in rebuilding key infrastructures and social services, helping communities start their recovery efforts.\n" +
                        "7. OVERWHELMING STRENGTH\n" +
                        "   - The strength demonstrated by Yolanda survivors inspired the world to unite in adversity, fostering gratitude and confidence in the rebuilding process.\n" +
                        "8. GOVERNMENT AGENCY'S VITAL ROLE\n" +
                        "   - The Department of Health (DOH) played a vital role in streamlining medical missions and coordinating disaster response efforts.\n" +
                        "9. MILITARY AND RESERVE COMPONENTS\n" +
                        "   - General Virgilio Garcia discussed the role of the military and reserve components, emphasizing the need to review laws governing reserve forces.\n" +
                        "10. ENHANCING VOLUNTEERISM\n" +
                        "   - The article highlighted the importance of volunteers learning to navigate the politics of relief operations and collaborating with neutral institutions for more effective disaster response.\n",

                "https://www.rappler.com/tachyon/r3-assets/8FFDE3A183F7465DBE80D208ACB9843E/img/2E5DAE21839B478EB72C52C584C205A1/tatalon-evacuation-flooding-habagat-august-11-2018-004.jpg",
                "https://www.rappler.com/moveph/52797-yolanda-recovery-civic-engagement/"
             )
        )

        dataList.add(
            DataItem("LESSONS FROM PAST CRISES IN CIVIC ACTION",
                "Explore the Philippine government's response to a major disaster and the role of civic action in shaping policies. Discover the valuable lessons learned from past crises in this insightful article.\n\n\n" +
                        "1. DISASTER POLICY EVALUATION THROUGH CIVIC DELIBERATION\n" +
                        "   - Civic engagement plays a pivotal role in assessing disaster policies' effectiveness, using a deliberative approach.\n" +
                        "2. MINI-PUBLIC METHOD FOR POLICY ASSESSMENT\n" +
                        "   - Mini-public events bring together diverse participants, fostering collective deliberation to enhance policy understanding and development.\n" +
                        "3. BALANCING PUBLIC HEALTH INTERVENTIONS\n" +
                        "   - The article highlights the importance of balancing coercive public health interventions with public justification and deliberation.\n" +
                        "4. UNDERSTANDING POLICY DISCREPANCIES\n" +
                        "   - Examining discrepancies between disaster policy goals and outcomes is crucial for informed decision-making.\n" +
                        "5. PHILIPPINE COMMUNITY QUARANTINE POLICIES\n" +
                        "   - The article assesses the effectiveness of the Philippines' Community Quarantine policies during a major crisis.\n" +
                        "6. SEVERE IMPACT OF COVID-19\n" +
                        "   - Like in many countries, the Philippines faced significant challenges during the COVID-19 pandemic, impacting education, livelihoods, and daily life.\n" +
                        "7. STRINGENT POLICY MEASURES\n" +
                        "   - The Philippine government implemented highly restrictive policies, but it remained uncertain whether the outcomes justified their severity.\n" +
                        "8. DISCONNECT BETWEEN POLICY OBJECTIVES AND PERFORMANCE\n" +
                        "   - Inadequate enforcement and resource allocation created a disconnect between disaster policy objectives and their practical outcomes.\n" +
                        "9. IMPORTANCE OF LOCAL IMPLEMENTATION\n" +
                        "   - Effective disaster policies depend on the local implementation and enforcement of mandates, highlighting the role of Local Government Units (LGUs).\n" +
                        "10. RECOMMENDATIONS FOR IMPROVED POLICY\n" +
                        "   - Civic deliberation led to recommendations for better policy consistency, implementation, and local adaptation in disaster response efforts.",

                "https://asia.fes.de/fileadmin/_processed_/e/6/csm_Youth_4_Just_Transition_Twitter_Link_Preview_76611cd9b1.png",
                "https://onlinelibrary.wiley.com/doi/full/10.1002/app5.378"
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