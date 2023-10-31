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

class GenderDisparitiesinPublicInfo : AppCompatActivity() {

    private lateinit var binding: ActivityEmpoweringCommunitiesInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gender_disparitiesin_public_info)
        binding = ActivityEmpoweringCommunitiesInfoBinding.inflate(layoutInflater)
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
                "GENDER HEALTH DISPARITIES: UNRAVELING INEQUITIES IN PUBLIC HEALTH",
                "In a world marked by gender health disparities, this article delves into the intricacies of public health inequalities between genders. Explore how cultural norms, power dynamics, and access to healthcare resources contribute to these disparities and what can be done to unravel them.\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. CULTURAL NORMS AND BELIEFS: Cultural norms have a substantial influence on health-seeking behavior and access to healthcare services, highlighting the need to consider sociocultural factors in public health.\n\n" +
                        "2. POWER DYNAMICS WITHIN HOUSEHOLDS: Household power structures, often male-dominated, impact healthcare decision-making and access, necessitating a reevaluation of these dynamics for improved health equity.\n\n" +
                        "3. GENDER ROLES AND RESPONSIBILITIES: Traditional gender roles and responsibilities dictate who seeks healthcare and when, creating barriers that affect both men and women's well-being.\n\n" +
                        "4. LIMITED ACCESS TO RESOURCES: Men, in particular, face limitations in accessing healthcare resources, primarily due to work-related constraints and concerns about lost earnings.\n\n" +
                        "5. GENDER-BLIND POLICIES: Existing health policies and guidelines often lack a gender perspective, underscoring the necessity of addressing gender-specific health needs and challenges.\n\n" +
                        "6. WORKPLACE BARRIERS: Fear of job loss upon health condition disclosure presents a significant barrier, especially for those working in the formal sector, prompting a reevaluation of workplace policies.\n\n" +
                        "7. CONFIDENTIALITY AND STIGMA: The stigma surrounding TB diagnosis is more acutely felt by men, resulting from societal expectations of masculinity and its consequences, further emphasizing the need for sensitivity and confidentiality in healthcare.\n\n" +
                        "8. ENHANCED DATA COLLECTION: Improving gender-specific data collection within health services is essential to monitor progress and adapt policies and programs effectively.\n\n" +
                        "9. GENDER-SENSITIVE HEALTHCARE: A gender-sensitive approach is crucial in healthcare service provision to ensure equitable health benefits for all, transcending the constraints of traditional gender norms and roles.\n\n" +
                        "10. IMPACT OF SOCIAL, CULTURAL, AND ECONOMIC FACTORS: Investigate the disparities in health outcomes between genders, including the impact of social, cultural, and economic factors.",

                "https://www.rappler.com/tachyon/2022/03/jabs-in-job-sites-makati-covid-19-vaccination-march-8-2022-002.jpg",
                "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10446658/"

            )
        )
        dataList.add(
            DataItem("YOUTH PREGNANCY AND MATERNAL HEALTH CHALLENGES IN THE PHILIPPINES",
                "Teen pregnancy has emerged as a pressing concern in the Philippines, raising maternal health challenges. This article delves into the impact of youth pregnancies and efforts to address maternal health disparities in the country.\n\n" +
                        "1. TEEN PREGNANCY CONCERN: A 2020 SWS survey highlights that teen pregnancy is a major concern among Filipinos, dominating the women's health agenda in the Philippines.\n\n" +
                        "2. ALARMING STATISTICS: The Commission on Population and Development reports a significant increase in teen pregnancies, projecting 133,265 cases by the end of 2021.\n\n" +
                        "3. STIGMA AND LEGAL BARRIERS: Advocates emphasize the difficulties young people face in accessing birth control services due to legal barriers and social stigma.\n\n" +
                        "4. REGIONAL VARIATION: Survey data reveals that Mindanao residents are particularly concerned, with 67% emphasizing teen pregnancy as the top issue.\n\n" +
                        "5. GOVERNMENT RESPONSE: Mixed reviews on government efforts with Mindanao and Visayas residents finding them adequate, while only 12% in Metro Manila share this view.\n\n" +
                        "6. LIMITED ACCESS TO FAMILY PLANNING: 4% of respondents believe that inadequate access to family planning information and services is a significant issue.\n\n" +
                        "7. YOUNG MOTHERS’ STRUGGLES: The personal story of Andrea Hernandez, a young mother, underscores the challenges faced by teen mothers, including limited access to contraceptives.\n\n" +
                        "8. ADVOCACY FOR CHANGE: Advocacy groups and legislators are pushing for new bills to prevent teen pregnancies and provide social protection to young mothers.\n\n" +
                        "9. LEGAL CHALLENGES: The 2014 Supreme Court ruling that struck down a provision allowing birth control access for minors without parental consent is being reconsidered by the Philippine Legislators’ Committee on Population and Development.\n\n" +
                        "10. PREVENTIVE FOCUS: Advocates emphasize the importance of educating young people on safe practices to prevent unplanned pregnancies and sexually transmitted infections.\n\n",

                "https://www.rappler.com/tachyon/2022/07/teen-pregnancy-20170930.jpg?resize=640%2C360&zoom=1",
                "https://www.rappler.com/nation/teen-pregnancy-most-important-problem-women-today-philippines-sws-survey-november-2020/"
               )
        )
        dataList.add(
            DataItem("REPRODUCTIVE HEALTH: EMPOWERING WOMEN'S HEALTH AND CHOICES",
                "Bayer Philippines Inc. is leading the charge in empowering women's reproductive health and choices. In a country where gender biases persist, Bayer's 'Conversations of Care' initiative seeks to break taboos and provide women with the knowledge and support they need for informed decisions about their bodies\"\n\n" +
                        "1. EMPOWERING WOMEN: Bayer's Initiative - Bayer Philippines is taking proactive steps to empower women in making informed decisions about their reproductive health.\n\n" +
                        "2. GENDER BIASES IN THE PHILIPPINES: A Look at Gender Biases - Examining the prevalence of gender biases in political, educational, economic, and bodily autonomy dimensions in the Philippines.\n\n" +
                        "3. CHALLENGES IN REPRODUCTIVE RIGHTS: Women's Struggles with Reproductive Rights - Highlighting the challenges faced by women in exercising their reproductive rights, despite progress in family planning.\n\n" +
                        "4. TABOOS AROUND WOMEN'S HEALTH: Breaking the Silence - Addressing the societal taboos that shroud women's health issues, hindering open discussions and awareness.\n\n" +
                        "5. SAFE SPACES FOR DISCUSSION: Bayer's Pop-Up Clinics - Introducing Bayer for Her's pop-up consultation clinics aimed at creating safe spaces for women to discuss reproductive health concerns.\n\n" +
                        "6. PCOS AND ITS IMPACT: The Challenge of PCOS - Exploring the prevalence of polycystic ovary syndrome (PCOS) and its impact on women's quality of life.\n\n" +
                        "7. SEEKING PROFESSIONAL ADVICE: The Importance of Consultation - Emphasizing the importance of seeking professional healthcare advice to manage PCOS effectively.\n\n" +
                        "8. UNDERSTANDING ENDOMETRIOSIS: The Impact of Endometriosis - Shedding light on the painful gynecological disease, endometriosis, and its wide-ranging effects on women.\n\n" +
                        "9. OPEN CONVERSATIONS: Say Tioco's Advocacy - Stressing the importance of open conversations about contraception, women's health concerns, and the need to dispel myths and stigma.\n\n" +
                        "10. CHAMPIONING WOMEN'S HEALTH: Bayer's Initiatives - Summarizing Bayer's efforts in championing women's health through various initiatives, including webinars, chatbots, and community outreach.",

                "https://media.philstar.com/images/articles/gen9-family-planning_2018-07-11_22-15-03.jpg",
                "https://philstarlife.com/self/774890-bayer-empowers-filipino-women-reproductive-health?page=2"
       )
        )

        dataList.add(
            DataItem("HEALTHCARE ACCESS: BREAKING BARRIERS FOR ALL GENDERS",
                "In the challenging landscape of healthcare access, breaking barriers is vital to ensure everyone receives the care they need. This includes addressing the unique challenges faced by persons with disabilities in rural areas and striving for equitable healthcare access for all genders.\"\n" +

                        "1. CHALLENGES IN RURAL HEALTHCARE: Persons with disabilities (PWDs) in rural areas face significant barriers to accessing primary healthcare services.\n\n" +
                        "2. GLOBAL SCOPE: The article explores these challenges on a global scale, considering various countries and health systems.\n\n" +
                        "3. HEALTHCARE DISPARITIES: PWDs experience more obstacles in accessing primary healthcare compared to the general population, leading to health disparities.\n\n" +
                        "4. NEGATIVE HEALTH OUTCOMES: These barriers contribute to adverse health outcomes and exacerbate disparities between PWDs and the rest of the population.\n\n" +
                        "5. FOCUS ON PRIMARY HEALTHCARE: Primary healthcare encompasses various services, including preventive care, treatment, and essential drugs, and is the first point of contact for health services.\n\n" +
                        "6. RUSSELL'S ACCESS FRAMEWORK: The review employs Russell and colleagues' conceptual framework, which defines access through dimensions like availability, affordability, geography, and acceptability.\n\n" +
                        "7. LIMITED RESEARCH FOCUS: Previous studies have primarily concentrated on urban areas and certain services, leaving gaps in our understanding of rural PHC access for PWDs.\n\n" +
                        "8. GROWING CONCERN: Access to appropriate healthcare services is the top research priority for PWDs, including those in rural regions.\n\n" +
                        "9. UNIVERSAL HEALTH COVERAGE: The United Nations' Sustainable Development Goal 3 underscores the importance of universal health coverage, quality health access, and equity.\n\n" +
                        "10. POLICY AND PRACTICE IMPLICATIONS: The review aims to inform health policies, enhance clinical practices, and expand knowledge about PHC access for PWDs in rural areas on a global scale.",

                "https://media.philstar.com/images/articles/met1-hospital-patients_2018-08-12_20-11-43.jpg",
                "https://ghrp.biomedcentral.com/articles/10.1186/s41256-018-0091-x"
            )
        )

        dataList.add(
            DataItem("GENDER-SENSITIVE PROGRAMS: FOSTERING INCLUSIVE PUBLIC HEALTH",
                "\"In the realm of public health, gender-sensitive programs are taking center stage as agents of change. These initiatives foster inclusive healthcare, addressing the unique needs of diverse genders and contributing to the promotion of gender-responsive public health policies.\n\n\n" +
                        "1. PCW'S SECOND GADTIMPALA: The Philippine Commission on Women (PCW) acknowledges outstanding regional gender and development (GAD) programs at the GADtimpala for Regional GAD Mechanisms Awarding Ceremony.\n" +
                        "2. MAGNA CARTA OF WOMEN (MCW): Republic Act 9710, known as the Magna Carta of Women, empowers PCW to establish awards recognizing entities, government agencies, and local units for their gender-responsive achievements.\n" +
                        "3. CELEBRATING RGADCS: The awards celebrate the remarkable efforts of Regional Gender and Development Committees (RGADCs) in advancing gender-responsive policies and programs at regional and local levels.\n" +
                        "4. GENDER MAINSTREAMING: RGADCs contribute to the development and monitoring of gender mainstreaming efforts, promoting gender equity in government initiatives.\n" +
                        "5. AWARDS SELECTION PROCESS: A rigorous selection process based on RGADC profiles, evaluation forms, and annual monitoring reports determines the deserving awardees.\n" +
                        "6. PCW MANAGEMENT COMMITTEE: The selected awardees gain approval from the PCW Management Committee, recognizing their exceptional contributions to gender equality.\n" +
                        "7. DEPUTY EXECUTIVE DIRECTOR'S PRAISE: Deputy Executive Director for Operations, Maria Kristine Josefina Balmes, commends RGADCs' resilience and dedication in promoting gender-responsive policies despite challenges, including the COVID-19 pandemic.\n" +
                        "8. RGADC INNOVATION: RGADCs demonstrate innovation in gender mainstreaming, showcasing dedication to addressing gender disparities at the local level.\n" +
                        "9. RGADC'S DEDICATION: RGADCs are commended for their unwavering commitment to protect women's rights, eliminate discrimination, and promote gender equality in public health programs.\n" +
                        "10. INSPIRATION AND DEDICATION: The 3rd RGADC Summit inspires participants to intensify gender advocacy, furthering the cause of inclusive public health through innovative approaches and collaboration.",

                "https://pia.gov.ph/uploads/2023/06/908e26caf9af2c0b74f6fbdc9116447d.jpg",
                "https://pia.gov.ph/press-releases/2023/06/26/pcw-recognizes-excellent-regional-gender-responsive-programs"
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