package com.example.civicall.PublicHealtAwarenessInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R
import com.example.civicall.databinding.ActivityEmpoweringCommunitiesInfoBinding

class EvaluatingtheEffectivenessInfo : AppCompatActivity() {

    private lateinit var binding: ActivityEmpoweringCommunitiesInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluatingthe_effectiveness_info)

        binding = ActivityEmpoweringCommunitiesInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Now, you can use 'binding' to reference your views in the layout
        binding.back1.setOnClickListener {
            val intent = Intent(this, healtawarenessinfoMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                    "HEALTH COMMUNICATION: THE POWER OF EFFECTIVE MESSAGING",
                "In the realm of healthcare, the power of communication cannot be overstated. This article explores how effective messaging and communication strategies play a pivotal role in the health sector, promoting public health campaigns and disseminating vital information.\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. ENHANCING HEALTHCARE COMMUNICATION: The article emphasizes the critical role of communication in healthcare, particularly during the COVID-19 pandemic.\n\n" +
                        "2. INFORMATION DELIVERY IN HEALTHCARE: Nurses, doctors, and hospital staff are pivotal in delivering accurate and factual information to patients and the public.\n\n" +
                        "3. TRAINING FOR EFFECTIVE COMMUNICATION: The Zamboanga City Medical Center (ZCMC) recognizes the importance of staff training in communication to improve patient services.\n\n" +
                        "4. COMBATTING FAKE NEWS: The ZCMC's training program aims to create 'social media warriors' who can combat fake news and disseminate reliable information.\n\n" +
                        "5. THE KEY ROLE OF INFORMATION AND COMMUNICATION: Effective communication is seen as the key to creating understanding with the audience and clients, as noted by Dir. Noemi Edaga.\n\n" +
                        "6. MEDIA SKILLS FOR HEALTHCARE PROFESSIONALS: The training program covers topics such as news writing, photo journalism, photo captioning, and crisis and social media management.\n\n" +
                        "7. EAGER PARTICIPANTS: During the workshop, participants, including healthcare professionals, are eager to learn new communication skills.\n\n" +
                        "8. EMPHASIZING MEDIA ETHICS: The importance of media ethics is highlighted in the training, with an emphasis on responsible journalism.\n\n" +
                        "9. STRENGTHENING GOVERNMENT-PUBLIC RELATIONS: The project aims to strengthen government-public relations by sharing timely, accurate, and relevant information.\n\n" +
                        "10. PARTNERSHIP FOR EFFECTIVE COMMUNICATION: A partnership between PIA and ZCMC is forged to enhance communication and information dissemination in the healthcare sector.",

                "https://pia.gov.ph/uploads/2022/08/c6deb12e6bea2f60352d4ff49909a4c7.jpg",
                "https://pia.gov.ph/features/2022/08/23/the-role-of-communication-in-the-health-sector"

            )
        )
        dataList.add(
            DataItem("CAMPAIGN EVALUATION: MEASURING THE IMPACT OF PUBLIC HEALTH INITIATIVES",
                "In the realm of public health, evaluating the effectiveness of campaigns is paramount. Discover proven strategies to measure the impact of initiatives and assess behavioral changes in 'Campaign Evaluation: Measuring Public Health Impact.\n\n" +
                        "1. PUBLIC HEALTH INITIATIVES EVALUATION: The article focuses on evaluating the effectiveness of public health campaigns to measure their impact.\n\n" +
                        "2. IMPORTANCE OF OUTCOME MEASUREMENT: Measuring the outcomes of public health initiatives is crucial for assessing their success.\n\n" +
                        "3. KW2'S EXPERTISE IN BEHAVIOR CHANGE MARKETING: KW2 specializes in behavior change marketing, contributing significantly to life-changing efforts.\n\n" +
                        "4. CHALLENGES OF FUNDING CAMPAIGN EVALUATION: Budget constraints often limit the evaluation of public health campaigns.\n\n" +
                        "5. QUESTIONS FOR PROVING EFFECTIVENESS: Effectiveness is determined by whether the campaign reaches the intended community, increases awareness, and induces positive behavioral changes.\n\n" +
                        "6. GATHERING COMMUNITY INSIGHTS: Building relationships with community leaders and activists to gather insights and set benchmarks before, during, and after a campaign.\n\n" +
                        "7. MESSAGE EXPOSURE STUDIES: Conducting surveys before and after a campaign to measure awareness and its impact.\n\n" +
                        "8. MEDIA CAMPAIGN METRICS: Assessing the reach and frequency of traditional media campaigns for targeted audiences.\n\n" +
                        "9. WEBSITE METRICS: Tracking website data, including sources, campaign-specific actions, content engagement, and visitor demographics.\n\n" +
                        "10. SOCIAL LISTENING AND ANECDOTAL EVIDENCE: Monitoring online conversations and assessing anecdotal evidence to gauge the impact of public health campaigns.",

                "https://images.ctfassets.net/pdf29us7flmy/56FDHfKmc9l3Q1zavye3Dh/0277fb8041e8327a11c714a22c3437dd/5Cs-of-marketing_DE_Blog_Header_Images_03_.jpg?w=720&q=100&fm=jpg",
                "https://kw2marketing.com/articles/five-proven-strategies-public-health-campaigns"
             )
        )
        dataList.add(
            DataItem("BEHAVIOR CHANGE: THE HEART OF PUBLIC HEALTH SUCCESS",
                "In the realm of public health, achieving success often hinges on behavior change. Explore how the heart of public health triumph lies in understanding and influencing human behaviors.\"\n\n" +
                        "1. CHALLENGES OF HUMAN RIGHTS COMMUNICATION: Human rights workers in the Philippines face difficulties in engaging the public due to disinformation, harassment, and conspiracy theories.\n\n" +
                        "2. EROSION OF PUBLIC SUPPORT: Despite robust laws and institutions, public support for human rights has declined in recent years.\n\n" +
                        "3. NEW TECHNOLOGY AND ATTACKS: Advances in technology have facilitated targeted attacks against human rights workers, making their work challenging and dangerous.\n\n" +
                        "4. LACK OF SUPPORT FOR COMMUNICATIONS: Many human rights organizations lack dedicated communications teams and professional personnel.\n\n" +
                        "5. THE NEED FOR SPECIFIC ADVOCACY: Engaging younger generations in human rights advocacy requires specific strategies and calls to action.\n\n" +
                        "6. SOCIAL AND BEHAVIOR CHANGE (SBC) APPROACH: The Asia Foundation's Initiative for Advancing Community Transformation (I-ACT) uses SBC techniques to promote human rights advocacy.\n\n" +
                        "7. ADAPTING TO ONLINE SPACES: Traditional tactics and tools used by older organizations may no longer be effective in the online spaces where younger Filipinos seek information.\n\n" +
                        "8. SPECIFICITY IN CAMPAIGNS: SBC encourages organizations to understand their target audience and design campaigns to lower barriers to positive behaviors.\n\n" +
                        "9. EXPERIMENTING WITH TIKTOK: Organizations like the Legal Rights and Natural Resources Center (LRC) are using TikTok to reach younger audiences and promote human rights.\n\n" +
                        "10. SHARING KNOWLEDGE AND RESOURCES: I-ACT shares research findings and resources to help civil society organizations improve their campaigns and advocacy efforts.",

                "https://asiafoundation.org/wp-content/uploads/2023/07/Andrei-Venal.jpg",
                "https://asiafoundation.org/2023/07/26/promoting-social-and-behavior-change-in-the-philippine-human-rights-sector/"
             )
        )

        dataList.add(
            DataItem("HEALTH EDUCATION: EMPOWERING INDIVIDUALS WITH KNOWLEDGE",
                "In a world where health and well-being are paramount, knowledge is the key to empowerment. Explore how health education programs in the Philippines are equipping individuals with the knowledge to make informed decisions, prevent diseases, and take control of their well-being \"\n" +
                        "1. EMPOWERING THROUGH EDUCATION: Health education programs in the Philippines aim to empower individuals with knowledge to make informed health decisions.\n\n" +
                        "2. ADDRESSING MALNUTRITION: Health programs tackle issues such as malnutrition among Filipinos, particularly children.\n\n" +
                        "3. GOVERNMENT INITIATIVES: The Department of Health collaborates with other government branches to provide free medical services and promote holistic health.\n\n" +
                        "4. NATIONAL HEALTH GOALS: The National Objectives for Health 2017-2022 outlines strategic goals for improving national health, including affordability and accessibility.\n\n" +
                        "5. SAFE MOTHERHOOD PROGRAM: Initiatives like the Safe Motherhood Program prioritize the welfare of mothers during pregnancy, offering safe deliveries, check-ups, and care visits.\n\n" +
                        "6. REPRODUCTIVE HEALTH: Programs promote family planning and raise awareness about sexually transmitted diseases to address overpopulation.\n\n" +
                        "7. CHILDREN'S HEALTH: Health programs include newborn screening, immunization, and feeding programs to improve children's health.\n\n" +
                        "8. MENTAL HEALTH FOCUS: The Philippine Mental Health Act of 2017 safeguards the rights of patients dealing with mental health issues.\n\n" +
                        "9. COVID-19 RESPONSE: The Philippines adapted health programs during the pandemic, leveraging telemedicine and promoting health awareness.\n\n" +
                        "10. CHILDHOPE PHILIPPINES INITIATIVES: NGOs like Childhope Philippines run programs for street children, including KalyEskwela, psychosocial interventions, KliniKalye, and skills development.",


                "https://childhope.org.ph/wp-content/uploads/2022/06/childhope-philippines-kalyeskwela-e1656894116674.jpg",
                "https://childhope.org.ph/health-programs-in-the-philippines/"
            )
        )

        dataList.add(
            DataItem("PUBLIC HEALTH STRATEGIES: CRAFTING EFFECTIVE CAMPAIGNS",
                "In an era of changing climate and evolving public health challenges, crafting effective campaigns is vital. Explore the strategies and initiatives designed to safeguard public health against climate-related threats in our rapidly transforming world.\n\n\n" +
                        "1. PROMOTING CLIMATE RESILIENCE: The CDC's BRACE framework equips health officials to anticipate climate impacts and vulnerabilities.\n\n" +
                        "2. COMMUNITY HEALTH PREPAREDNESS: Strategies in the article demonstrate how communities can proactively address health threats arising from climate change.\n\n" +
                        "3. EXTREME HEAT AWARENESS: Raising awareness about heat island risks is a critical first step in mitigating heat-related health issues.\n\n" +
                        "4. INCENTIVES FOR ACTION: Governments and organizations can incentivize individuals to reduce heat islands, promoting public health.\n\n" +
                        "5. URBAN FORESTRY PROGRAMS: Urban forestry and tree planting initiatives contribute to cooling urban areas, a key factor in public health.\n\n" +
                        "6. RETROFITTING FOR COOL TECHNOLOGIES: Procuring cool technologies for public buildings is a fundamental step in heat island mitigation.\n\n" +
                        "7. POLICY AND BUILDING STANDARDS: Building codes, green initiatives, and comprehensive plans influence public health adaptation efforts.\n\n" +
                        "8. AIR QUALITY CONCERNS: Climate change's impact on air quality is a pressing public health issue.\n\n" +
                        "9. ASSESSING VULNERABILITIES: Identifying vulnerable populations and locations is essential for effective climate-related public health strategies.\n\n" +
                        "10. CDC's BRACE FRAMEWORK: The CDC's five-step process aids in developing resilient public health initiatives.",

                "https://childhope.org.ph/wp-content/uploads/2021/03/childhope-philippines-advocacy-campaign-delivering-hope-1024x1024.jpg",
                "https://www.epa.gov/arc-x/public-health-adaptation-strategies-climate-change"
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