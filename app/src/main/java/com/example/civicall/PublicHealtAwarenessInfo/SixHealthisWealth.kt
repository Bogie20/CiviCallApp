package com.example.civicall.PublicHealtAwarenessInfo

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
import com.example.civicall.databinding.ActivitySixHealthIsWealthBinding

class SixHealthisWealth : AppCompatActivity() {
    private lateinit var binding:ActivitySixHealthIsWealthBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivitySixHealthIsWealthBinding.inflate(layoutInflater)
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
                "IMMUNIZATION PROGRAMS FOR PREVENTIVE HEALTHCARE IN THE PHILIPPINES",
                "Immunization programs are the cornerstone of preventive healthcare in the Philippines, safeguarding children from life-threatening diseases. This vital public health initiative ensures a healthier future for the nation.\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. ROUTINE VACCINATION SCHEDULE: Children in the Philippines receive routine vaccines from birth to one year of age, with additional doses during supplementary or outbreak vaccination campaigns.\n\n" +
                        "2. CRITICAL DISEASES PREVENTION: Vaccination programs protect children from life-threatening diseases, such as tuberculosis, hepatitis B, and poliovirus.\n\n" +
                        "3. BCG VACCINE: Administered at birth, the BCG vaccine offers protection against tuberculosis, a prevalent and challenging disease in the Philippines.\n\n" +
                        "4. HEPATITIS B IMMUNIZATION: Given at birth, the hepatitis B vaccine prevents chronic infections and complications that may arise later in life.\n\n" +
                        "5. PENTAVALENT VACCINE: Administered at 6, 10, and 14 weeks, this vaccine guards against diphtheria, pertussis, tetanus, Haemophilus influenzae type b, and hepatitis B.\n\n" +
                        "6. ORAL AND INACTIVATED POLIO VACCINES: These vaccines, given at specific intervals, protect against poliovirus, a virus that can cause paralysis and death.\n\n" +
                        "7. PCV VACCINE: Administered at 6, 10, and 14 weeks, the PCV vaccine helps prevent pneumonia and meningitis in young children.\n\n" +
                        "8. MMR VACCINE: Given at 9 months and 1 year old, the MMR vaccine safeguards against measles, mumps, and rubella, reducing the risk of serious complications.\n\n" +
                        "9. ONGOING VACCINATION DURING THE PANDEMIC: Routine immunization remains an essential health service even during the COVID-19 pandemic, with measures in place to ensure safety.\n\n" +
                        "10. HIGH COVERAGE TARGET: The government aims for routine immunization coverage among children to be at least 95%, and these vaccines are provided for free in public health centers and facilities to ensure accessibility for all.",

                "https://www.unicef.org/philippines/sites/unicef.org.philippines/files/styles/hero_extended/public/1000002294%20%286000%C3%974000%29.jpeg?itok=LE9RJ2vA",
                "https://www.unicef.org/philippines/stories/routine-immunization-children-philippines"

            )
        )
        dataList.add(
            DataItem("HEALTH SCREENINGS AND EARLY DETECTION IN THE CONTEXT OF PREVENTIVE HEALTHCARE",
                "In the Philippines, advocates are sounding the alarm on the inadequate cancer screening rates, emphasizing that a significant portion of cancer cases can be prevented. The call for intensifying cancer screening efforts is gaining momentum, driven by the urgency to reduce cancer-related mortality.\n\n" +
                        "1. LOW CANCER SCREENING RATES: The Philippines faces challenges with extremely low rates of breast and cervical cancer screenings, as highlighted in the article.\n\n" +
                        "2. PREVENTABLE CANCER BURDEN: Health experts stress that a substantial portion of the country's cancer burden is preventable through effective screening programs and early detection.\n\n" +
                        "3. EARLY DETECTION SIGNIFICANCE: Early cancer detection through screening is crucial for improving treatment outcomes and reducing mortality rates.\n\n" +
                        "4. GLOBAL COMPARISONS: The Philippines lags behind countries with advanced healthcare systems in terms of cancer screening prevalence, including self-breast examinations, mammograms, and PAP smears.\n\n" +
                        "5. BUDGETARY CHALLENGES: The article underscores the need for increased funding for the country's anti-cancer program, as the allocated budget is deemed insufficient to address the needs of cancer patients.\n\n" +
                        "6. NATIONAL INTEGRATED CANCER CONTROL ACT: The Philippine government has allocated P1.56 billion for Filipino cancer patients under Republic Act No. 11215, emphasizing the importance of policy support for cancer care.\n\n" +
                        "7. INSUFFICIENT FUNDING: Health advocates, including the Philippine General Hospital Cancer Institute Chairman, express concerns about the inadequacy of the allocated budget, particularly for breast and cervical cancer patients.\n\n" +
                        "8. LIMITED PATIENT COVERAGE: The allocated budget is only capable of providing assistance to a fraction of cancer patients throughout their required treatment cycles, whether it be targeted therapy or chemotherapy.\n\n" +
                        "9. TREATMENT COSTS: Chemotherapy costs about P5,000 per cycle, while targeted therapy costs around P30,000 per session, underlining the financial burden on cancer patients and the healthcare system.\n\n" +
                        "10. CANCER MORTALITY IN THE PHILIPPINES: The Philippines faces the challenge of addressing cancer as a leading cause of mortality, with breast cancer cases alone reaching 27,163 in 2020, according to data from the World Health Organization.\n\n",

                "https://childhope.org.ph/wp-content/uploads/2022/06/childhope-philippines-health-program-e1656895068613.jpg",
                "https://www.pids.gov.ph/details/news/in-the-news/advocates-seek-intensification-of-cancer-screening-in-ph"
             )
        )
        dataList.add(
            DataItem("IMPROVING HEALTHCARE INFRASTRUCTURE FOR PREVENTIVE MEDICINE IN THE PHILIPPINES",
                "In the face of global health challenges, the Philippines must revamp its healthcare infrastructure to fortify preventive medicine and bolster the nation's resilience in the wake of public health crises. The state of the Philippines' healthcare system, as discussed in this evaluation, unveils critical areas in need of improvement to support an effective preventive healthcare framework.\"\n\n" +
                        "1. STEWARDSHIP AND ACCOUNTABILITY: Leadership and Governance Challenges - Assessing the state of governance and leadership in the Philippines' healthcare system, emphasizing the need for effective policy frameworks and accountability.\n\n" +
                        "2. SHIFT TO PRIMARY CARE: UHC Law and the Paradigm Shift - Highlighting the Universal Health Care (UHC) Law as a milestone and its focus on transitioning to primary care.\n\n" +
                        "3. GOVERNMENT RESPONSE TO COVID-19: Emergency Measures and Late Travel Ban - Discussing the government's response to the COVID-19 pandemic, including late travel restrictions and their impact.\n\n" +
                        "4. RESOURCE DEVELOPMENT: Health Workforce and Neglect - Examining the status of the health workforce, information systems, and access to medical products, with a focus on the neglect of healthcare workers.\n\n" +
                        "5. FUNDING CHALLENGES: Budget Mismanagement in Healthcare - Highlighting the availability of funds but the mismanagement of the budget, particularly in approving testing kits and the affordability of tests.\n\n" +
                        "6. ADEQUACY OF FUNDS: Adequate Budget Allocation but Misuse - Discussing the government's significant allocation of funds for health services and the mismanagement of this budget.\n\n" +
                        "7. ACCESS TO TESTING: Slow Approval of Testing Kits - Examining the slow approval of testing kit applications and the unaffordability of tests for many Filipinos.\n\n" +
                        "8. VACCINATION CHALLENGES: Vaccine Distribution and Hurdles - Discussing the uneven distribution of vaccines across regions and the challenges in achieving vaccination goals due to a lack of health workers and accessible health centers.\n\n" +
                        "9. EFFORTS FALLING SHORT: Missed Opportunities in Vaccine Administration - Addressing the slow pace of vaccine administration and the failure to capitalize on vaccine availability.\n\n" +
                        "10. CALL FOR OVERHAUL: A Need for Systemic Improvements - Concluding with the call for a comprehensive overhaul of the Philippine healthcare system to address the shortcomings in the four crucial functions discussed.",

                "https://www.bworldonline.com/wp-content/uploads/2023/01/Covid-19-patient.jpg",
                "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC9201087/"
             )
        )

        dataList.add(
            DataItem("RAISING PUBLIC AWARENESS FOR PREVENTIVE HEALTHCARE",
                "In the Philippines, addressing stroke prevention and awareness is crucial as stroke remains a significant health challenge. This article presents a comprehensive strategy to raise public awareness for preventive healthcare, specifically in the context of stroke.\"\n\n\n" +

                        "1. ELEVATED STROKE INCIDENCE: Stroke is a major cause of mortality and disability in the Philippines, especially among those in lower-income brackets.\n\n" +
                        "2. COVID-19's IMPACT: The COVID-19 pandemic disrupted healthcare systems and posed challenges for stroke diagnosis and treatment, leading to delays in care.\n\n" +
                        "3. DELAYED HOSPITAL CONSULTATION: The pandemic resulted in delayed hospital consultations for stroke, contributing to increased stroke severity.\n\n" +
                        "4. CHALLENGES IN STROKE CARE: Gaps in the Philippine healthcare system regarding stroke care, including limitations in stroke awareness, are discussed.\n\n" +
                        "5. COMPREHENSIVE STROKE PREVENTION: A two-pronged approach combining community-based prevention and targeted public awareness campaigns to address stroke's multifaceted challenge.\n\n" +
                        "6. IDENTIFYING MODIFIABLE RISK FACTORS: Community-based stroke prevention involves personalized assessments of risk factors such as hypertension and smoking.\n\n" +
                        "7. THE NEED FOR PUBLIC STROKE AWARENESS: Emphasizing the importance of public awareness campaigns for recognizing stroke symptoms and seeking prompt medical attention.\n\n" +
                        "8. TAILORED STROKE AWARENESS CAMPAIGNS: Decentralized campaigns use culturally adapted materials, engagement with local stakeholders, and educational initiatives.\n\n" +
                        "9. ENGAGING COMMUNITY HEALTH WORKERS: Community health workers play a crucial role in educating high-risk individuals about stroke risk factors and recognition.\n\n" +
                        "10. COLLABORATIVE EFFORTS: Collaboration among national and local entities, including non-profit organizations and educational institutions, is vital for the success of stroke awareness campaigns.",

                "https://pia.gov.ph/uploads/2023/04/aa3fb09e46d5e9379a4b6c3c1a321938.jpg",
                "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10502210/"
              )
        )

        dataList.add(
            DataItem("ADDRESSING VACCINE HESITANCY IN THE PHILIPPINES",
                "In the face of the COVID-19 pandemic, addressing vaccine hesitancy in the Philippines is paramount. This article explores the challenges, historical concerns, and legal aspects surrounding vaccine hesitancy, emphasizing the need for transparent policy responses.\n\n\n" +
                        "1. UNDERSTANDING VACCINE HESITANCY: Introduction to the concept of vaccine hesitancy and its relevance in the Philippines.\n\n" +
                        "2. FILIPINO ATTITUDES TOWARDS COVID-19 VACCINATION: Highlights of survey data indicating hesitancy levels among Filipinos.\n\n" +
                        "3. VACCINE HESITANCY AND MEASLES OUTBREAK: Discussing past instances where vaccine hesitancy contributed to health crises in the Philippines.\n\n" +
                        "4. IMPACT OF DENGVAXIA SCARE: Exploring how the Dengvaxia controversy fueled vaccine hesitancy and its consequences.\n\n" +
                        "5. OBSTACLES TO SUCCESSFUL IMMUNIZATION PROGRAMS: Discussing challenges faced in previous public immunization schemes and their impact.\n\n" +
                        "6. VACCINE HESITANCY WORLDWIDE: Comparing vaccine hesitancy issues in the Philippines to those in other countries, such as the US.\n\n" +
                        "7. CONCERNS OVER COVID-19 VACCINE SIDE EFFECTS: Addressing how reported side effects of COVID-19 vaccines have contributed to hesitancy.\n\n" +
                        "8. MANDATORY VACCINATION AND CONSTITUTIONAL CONCERNS: Exploring the legality of mandatory vaccination and its implications on individual rights.\n\n" +
                        "9. LEADERSHIP AND PUBLIC TRUST: Highlighting the importance of leadership in restoring public trust in vaccines.\n\n" +
                        "10. FOSTERING VACCINE CONFIDENCE: Emphasizing the need for collective efforts, transparency, and civic engagement to combat vaccine hesitancy in the Philippines.",

                "https://www.rappler.com/tachyon/2021/04/imho-sq.jpg?resize=800%2C800&zoom=1",
                "https://www.rappler.com/voices/imho/analysis-exploring-vaccine-hesitancy-covid-19-pandemic/"
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