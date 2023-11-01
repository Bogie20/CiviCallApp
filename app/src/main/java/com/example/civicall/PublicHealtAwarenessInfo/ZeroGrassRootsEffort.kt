package com.example.civicall.PublicHealtAwarenessInfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R
import com.example.civicall.databinding.ActivityZeroGrassrootsEffortBinding


class ZeroGrassRootsEffort : AppCompatActivity() {

    private lateinit var binding: ActivityZeroGrassrootsEffortBinding  // Declare the binding variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityZeroGrassrootsEffortBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Now, you can use 'binding' to reference your views in the layout
        binding.backbtn.setOnClickListener {
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
                "EMPOWERING COMMUNITIES: THE VITAL ROLE OF COMMUNITY HEALTH WORKERS",
                "Unlocking Community Resilience: The Unsung Heroes of Public Health. Discover the indispensable role of community health workers as they stand at the forefront of empowering and safeguarding our communities' well-being.\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. DEDICATED COMMUNITY HEALTH WORKERS: Community health workers (CHWs) in rural areas, like Barangay Macalong, play a pivotal role in healthcare outreach and support.\n\n" +
                        "2. LOCAL KNOWLEDGE FOR CONTACT TRACING: CHWs have invaluable local knowledge, making them effective in contact tracing efforts during the COVID-19 pandemic.\n\n" +
                        "3. UNDERRECOGNIZED ROLE: Despite their local expertise, the government often overlooks the potential of CHWs as contact tracers at the barangay level.\n\n" +
                        "4. VOLUNTEER BASIS: CHWs serve voluntarily and receive honorariums, with the amounts varying widely based on the barangay's revenue.\n\n" +
                        "5. UNEQUAL COMPENSATION: Compensation ranges from as low as P200 to P60 in some municipalities to as high as P10,000 in others, depending on local revenue.\n\n" +
                        "6. SPECIAL RISK ALLOWANCE: President Duterte signed Administrative Order No. 28, granting front-line public health workers a special risk allowance during the pandemic, but CHWs have faced issues in receiving it.\n\n" +
                        "7. CHALLENGES IN IMPLEMENTATION: Reports suggest that CHWs did not receive hazard pay, and issues arise from how local government units interpret the allocation of funds.\n\n" +
                        "8. MODEL RESPONSE IN CALOOCAN CITY: Barangay 28 in Caloocan City developed a successful COVID-19 response model, recognizing the importance of adequately supporting and compensating CHWs.\n\n" +
                        "9. COMMUNITY ENGAGEMENT: Barangay 28 prioritized community engagement through house-to-house visits, daily health monitoring, and real conversations with residents.\n\n" +
                        "10. PROPOSED LEGISLATION: Rep. Angelica Natasha Co introduced House Bill No. 3985 advocating for standard honorariums, medical assistance, and benefits for CHWs, highlighting their essential role in public health.",

                "https://newsinfo.inquirer.net/files/2020/09/News79557-e1599935163960.jpg",
                "https://newsinfo.inquirer.net/1334687/their-local-knowledge-is-key-to-effective-contact-tracing"

            )
        )
        dataList.add(
            DataItem("BARANGAY HEALTH CENTERS: CORNERSTONES OF PUBLIC HEALTH IN LOCAL COMMUNITIES",
                "Barangay Health Centers (BHCs) serve as vital pillars of public health in local communities across the Philippines. This study explores the challenges and multifaceted barriers faced by BHCs in providing essential health care services.\n\n" +
                        "1. ENHANCED BHC SERVICES: Invest in the development and expansion of BHC services to provide a wider range of primary healthcare services, including preventive care, maternal and child health services, and health education.\n\n" +
                        "2. TELEMEDICINE AND MOBILE CLINICS: Utilize telemedicine and mobile health clinics to reach remote areas where BHCs are not accessible.\n\n" +
                        "3. TRAINING AND SUPPORT FOR BHWs: Provide comprehensive training and support for Barangay Health Workers to ensure they are well-equipped to serve their communities effectively.\n\n" +
                        "4. STANDARDIZED POLICIES: Advocate for standardized policies and resource allocation at the local government level to ensure consistency in BHC operations.\n\n" +
                        "5. CONFLICT RESOLUTION TRAINING: Implement conflict resolution training programs for BHWs and supervisors to improve interpersonal relationships and communication.\n\n" +
                        "6. RESOURCE ALLOCATION: Allocate sufficient resources to BHCs, including staffing, equipment, and facilities, to address institutional barriers effectively.\n\n" +
                        "7. HEALTH EDUCATION CAMPAIGNS: Conduct health education campaigns to inform communities about the benefits of BHC services and dispel misconceptions about traditional healers.\n\n" +
                        "8. POLICY COORDINATION: Encourage coordination and alignment between different local health policies and funding sources to reduce disparities in healthcare provision.\n\n" +
                        "9. COMMUNITY ENGAGEMENT: Foster community engagement and support for BHCs through collaboration with local leaders and private organizations.\n\n" +
                        "10. RESEARCH AND ADVOCACY: Promote research and advocacy efforts to highlight the importance of BHCs in achieving health equity, which can drive policy changes and increased funding.",

                "https://files01.pna.gov.ph/ograph/2021/07/13/central-3.jpg",
                "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10481217/#:~:text=The%20Philippines'%20primary%20care%20is,barangay%20health%20workers%20(BHWs)."
            )
        )
        dataList.add(
            DataItem("EDUCATING FOR HEALTH: THE POWER OF COMMUNITY HEALTH EDUCATION",
                "Cultivating Health and Knowledge: The Potential of Community Health Education. Explore the transformative influence of education on individual and community well-being, paving the way for a healthier future.\"\n\n" +
                        "1. EMPOWERING WELL-BEING: HEALTH EDUCATION EQUIPS INDIVIDUALS WITH KNOWLEDGE AND SKILLS TO MAKE INFORMED DECISIONS ABOUT THEIR HEALTH, PROMOTING OVERALL WELL-BEING.\n\n" +
                        "2. RAISING AWARENESS: HEALTH EDUCATION ACTS AS A CATALYST FOR RAISING AWARENESS ABOUT PREVALENT HEALTH ISSUES, BOTH PHYSICAL AND MENTAL, FOSTERING PROACTIVE HEALTH APPROACHES.\n\n" +
                        "3. PROMOTING PREVENTIVE MEASURES: IT ENCOURAGES PREVENTIVE MEASURES AND HEALTHY BEHAVIORS, LEADING TO THE PREVENTION OF VARIOUS DISEASES AND CONDITIONS.\n\n" +
                        "4. INFORMED DECISION-MAKING: HEALTH EDUCATION EMPOWERS INDIVIDUALS TO MAKE INFORMED DECISIONS REGARDING THEIR HEALTH, IMPROVING HEALTH OUTCOMES AND REDUCING HEALTHCARE COSTS.\n\n" +
                        "5. MOTIVATING LIFESTYLE CHANGES: IT MOTIVATES INDIVIDUALS TO MAKE POSITIVE LIFESTYLE MODIFICATIONS, PRIORITIZING SELF-CARE AND HEALTHIER ALTERNATIVES.\n\n" +
                        "6. ADDRESSING MENTAL WELL-BEING: HEALTH EDUCATION ADDRESSES MENTAL WELL-BEING, REDUCING STIGMA, AND PRIORITIZING MENTAL HEALTH AS A CRUCIAL ASPECT OF OVERALL WELL-BEING.\n\n" +
                        "7. COMMUNITY ENGAGEMENT AND ADVOCACY: IT FOSTERS COMMUNITY ENGAGEMENT AND ADVOCACY, ENCOURAGING COMMUNITIES TO ADDRESS HEALTH DISPARITIES AND ADVOCATE FOR EQUITABLE ACCESS TO HEALTHCARE.\n\n" +
                        "8. TARGETED HEALTH EDUCATION: HEALTH EDUCATION SHOULD BE TAILORED TO MEET THE SPECIFIC NEEDS AND DEMOGRAPHICS OF DIFFERENT POPULATIONS FOR INCREASED RELEVANCE AND EFFECTIVENESS.\n\n" +
                        "9. LIFE SKILLS AND CRITICAL THINKING: HEALTH EDUCATION IMPARTS NOT ONLY KNOWLEDGE BUT ALSO ESSENTIAL LIFE SKILLS AND CRITICAL THINKING ABILITIES, ENABLING INDIVIDUALS TO NAVIGATE COMPLEX HEALTH CHALLENGES.\n\n" +
                        "10. DIGITAL HEALTH EDUCATION AND YOUTH EMPOWERMENT: INCORPORATING DIGITAL PLATFORMS ENHANCES ACCESSIBILITY, AND EMPOWERING YOUTH THROUGH EDUCATION FROM AN EARLY AGE IS VITAL FOR INFORMED DECISION-MAKING AND HEALTHY LIVES.",

                "https://childhope.org.ph/wp-content/uploads/2021/11/childhope-philippines-health-seminar-e1637221377162.jpg",
                "https://www.itmedicalteam.pl/articles/the-power-of-health-education-empowering-individuals-for-a-better-future-121260.html"
             )
        )

        dataList.add(
            DataItem("PRIMARY HEALTHCARE: THE FOUNDATION OF COMMUNITY WELLNESS",
                "\"Unlocking the Heart of Community Health: Discovering the Vital Role of Barangay Health Workers in the Philippines. This study delves into the motivating factors and transformative experiences of Barangay Health Workers (BHWs), emphasizing their significant contribution to 'PRIMARY HEALTHCARE: THE FOUNDATION OF COMMUNITY WELLNESS.'\"\"\n" +

                        "1. CRUCIAL COMMUNITY HEALTH WORKFORCE: Barangay Health Workers (BHWs) are a vital part of the primary healthcare system in the Philippines.\n\n" +
                        "2. EARLY ADOPTION OF CHW MODEL: The Philippines was among the pioneers in implementing the Community Health Worker (CHW) model.\n\n" +
                        "3. MOTIVATIONS AND SUSTAINABILITY: This study explores the factors that drive BHWs to volunteer and continue their essential work.\n\n" +
                        "4. VARIED INCENTIVES: BHWs are motivated by a mix of financial and non-financial incentives, enhancing community well-being.\n\n" +
                        "5. TECHNICAL KNOWLEDGE: Gaining technical expertise and skills is a key motivator for BHWs.\n\n" +
                        "6. IMPROVING COMMUNITY HEALTH: BHWs play a pivotal role in enhancing community members' health and well-being.\n\n" +
                        "7. CONNECTING COMMUNITIES: They act as bridges between the community and healthcare services.\n\n" +
                        "8. PUBLIC HEALTH SURVEILLANCE: BHWs also contribute to public health surveillance, tracking and addressing health needs.\n\n" +
                        "9. CHALLENGES OF POLITICAL CONNECTIONS: Socio-political connections often determine BHW appointments.\n\n" +
                        "10. ECONOMIC AND NON-MONETARY REWARDS: While honoraria and allowances are provided, many BHWs also work part-time and contribute their own resources to fulfill their roles.",

                "https://www.healthfuturesfoundation.com/wp-content/uploads/2022/04/Banner-HFI-WHO-Western-Pacific-Innovation-Challenge-e1650889195392.jpg",
                "https://bmchealthservres.biomedcentral.com/articles/10.1186/s12913-020-05699-0"
             )
        )

        dataList.add(
            DataItem("COMMUNITY ENGAGEMENT IN PUBLIC HEALTH: A COLLABORATIVE APPROACH",
                "Unlocking Community Potential: The Transformative Role of Community Engagement in Public Health. Step into a world where communities lead the charge in shaping their own health destinies and witness the impactful journey of grassroots initiatives in our modern public health landscape.\n\n\n" +
                        "1. THE YOUTHFUL GUARDIANS OF HEALTH: Young healthcare professionals (HCPs) are taking on increasing responsibilities in elder care, prompting a reevaluation of healthcare practices.\n\n" +
                        "2. DIGITAL TRANSFORMATION: Technology-driven changes are transforming healthcare systems worldwide, with the Philippines embracing telehealth and digital solutions.\n\n" +
                        "3. TELEHEALTH'S LIMITATIONS: Telehealth services, while on the rise, have their limitations, especially when dealing with the ongoing COVID-19 pandemic.\n\n" +
                        "4. DIGITAL INFRASTRUCTURE NEEDS: The Philippines requires robust digital infrastructure for comprehensive healthcare, necessitating public and private sector collaboration.\n\n" +
                        "5. EMPOWERING THE NEXT GENERATION: Philips' Future Health Index 2020 report highlights the pivotal role of young HCPs in healthcare transformation.\n\n" +
                        "6. CONFLUENCE OF TECHNOLOGY AND CULTURE: Ideal healthcare workplaces merge technology and culture, enabling young HCPs to maximize their contributions.\n\n" +
                        "7. COMMITTED CAREERS: Despite challenges, young HCPs in the Philippines remain dedicated, and technology can help sustain this commitment.\n\n" +
                        "8. SUPPORTIVE WORKFORCE: Young HCPs value collaborative cultures that combine technology with professional autonomy, impacting performance and work-life balance.\n\n" +
                        "9. ENGAGING THE WORKFORCE: Advancements excite younger HCPs, but education in data analysis and data-sharing technology is vital for the medical field's digitization.\n\n" +
                        "10. LOWERING INTERNAL BARRIERS: To harness the potential of younger HCPs, organizations must promote inclusivity and create platforms for their perspectives, paving the way for transformative healthcare.",

                "https://www.unicef.org/philippines/sites/unicef.org.philippines/files/styles/hero_desktop/public/UNIPH2020-WHD-BARMM.JPG?itok=H0je4qfg",
                "https://business.inquirer.net/317249/empowering-younger-healthcare-professionals-by-creating-the-ideal-working-environment"
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