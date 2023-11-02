package com.example.civicall.EnvironmentalandSocialIssueInfo

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
import com.example.civicall.databinding.ActivityTwoPollutionBinding

class TwoPollution : AppCompatActivity() {
    private lateinit var binding:ActivityTwoPollutionBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityTwoPollutionBinding.inflate(layoutInflater)
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
                "AIR QUALITY ISSUES IN THE PHILIPPINE CAPITAL",
                "In Metro Manila, the Philippines' capital, air quality concerns have reached a critical level, with smog from vehicular pollution clouding the skies. This article delves into the pressing air quality issues in the Philippine capital\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. AIR QUALITY CRISIS IN METRO MANILA: Smog from vehicular pollution in Metro Manila is causing air quality issues, emphasizing the need for urgent action.\n\n" +
                        "2. SUPREME IRONY ON WORLD CAR-FREE DAY: On World Car-Free Day, Metro Manila was shrouded in smog due to vehicle emissions, revealing a stark contradiction.\n\n" +
                        "3. ENVIRONMENTAL GROUPS RAISE CONCERNS: Various environmental and sustainable transport groups have expressed their concerns about the air quality situation in the capital.\n\n" +
                        "4. GOVERNMENT'S DATA ON AIR POLLUTION: The Department of Environment and Natural Resources (DENR) reports that 80% of air pollution in Metro Manila results from vehicles.\n\n" +
                        "5. URGENT CALL FOR GOVERNMENT ACTION: Environmental groups are urging the government to reduce car usage, enhance public transportation, and promote sustainable mobility options.\n\n" +
                        "6. CHALLENGES IN THE PROPOSED 2024 NATIONAL BUDGET: Concerns are raised about the budget allocation for clean transport and infrastructure in the 2024 government budget.\n\n" +
                        "7. AIR QUALITY MONITORING GAPS: Gaps in air quality monitoring, with numerous monitoring stations offline, hinder efforts to combat air pollution effectively.\n\n" +
                        "8. BUDGET SHORTAGES FOR MONITORING: The DENR has been struggling with insufficient funds for maintaining air quality monitoring stations.\n\n" +
                        "9. LESSONS FROM THE COVID-19 PANDEMIC: The COVID-19 lockdown period demonstrated the benefits of reduced car usage and its positive impact on air quality.\n\n" +
                        "10. MOVING TOWARDS A BETTER NORMAL: The article concludes by emphasizing the importance of applying lessons from the pandemic to create a cleaner and healthier future for the city.",

                "https://www.rappler.com/tachyon/2023/09/volcanic-smog-vog-taal-metro-manila-september-22-2023-003.jpg?resize=1982%2C1321&zoom=1",
                "https://www.rappler.com/environment/car-fueled-smog-metro-manila-shows-gaps-air-quality-transportation-policies/"

            )
        )
        dataList.add(
            DataItem("HEALTH IMPACTS AND SOCIAL INEQUALITY IN THE PHILIPPINES",
                "In the Philippines, achieving health for all remains a pressing challenge, with significant disparities in healthcare access and health outcomes. This article explores the intricate relationship between health impacts and social inequality, shedding light on the critical issues affecting the nation's well-being.\n\n" +
                        "1. UNIVERSAL HEALTH COVERAGE: The article emphasizes the importance of universal health coverage and access to essential health services as a fundamental human right.\n\n" +
                        "2. HEALTHCARE INEQUITIES IN ASIA AND THE PACIFIC: It highlights the fact that up to half of the population in some Asian and Pacific countries lack access to health services due to various barriers.\n\n" +
                        "3. FINANCIAL HARDSHIP IN HEALTH: The poorest Filipinos spend a significant portion of their income on healthcare, leading to financial hardship and trade-offs with food expenses.\n\n" +
                        "4. WHO's 70th ANNIVERSARY: The World Health Organization (WHO) marks its 70th anniversary by reemphasizing health as a fundamental human right and the need for 'health for all.'\n\n" +
                        "5. HEALTH CHALLENGES IN THE PHILIPPINES: The article underscores the health challenges facing the Philippines, including noncommunicable diseases and epidemics.\n\n" +
                        "6. GLARING GAPS IN ACCESS: It points out the existing gaps in access to healthcare, which may be due to affordability, geographical distance, knowledge gaps, or social stigma.\n\n" +
                        "7. PREVENTING NONCOMMUNICABLE DISEASES: The context stresses the importance of effective preventive measures and management of diseases like heart attacks, stroke, diabetes, and cancer.\n\n" +
                        "8. COMPREHENSIVE HEALTHCARE: It advocates for comprehensive healthcare services available closer to people's homes, provided by coordinated healthcare teams.\n\n" +
                        "9. LEADERSHIP FOR UNIVERSAL HEALTH COVERAGE: The need for visionary and courageous leadership committed to universal health coverage is highlighted as a critical step.\n\n" +
                        "10. ACTIONS IN THE PHILIPPINES: The article applauds the commitment of the Philippines' Secretary of Health, Francisco Duque III, to strengthen primary healthcare, invest in prevention, and promote good governance in health.\n\n",

                "https://borgenproject.org/wp-content/uploads/The_Effects_of_Poverty_in_the_Philippines.jpg",
                "https://www.who.int/philippines/news/commentaries/detail/health-for-all-is-key-for-a-safer-fairer-more-prosperous-philippines"
       )
        )
        dataList.add(
            DataItem("INITIATIVES FOR CLEANER AIR IN THE PHILIPPINES",
                "In the pursuit of cleaner air in the Philippines, the Department of Environment and Natural Resources (DENR) has undertaken significant initiatives. Through stringent measures and proactive programs, the nation strives to improve air quality, ensuring a healthier and more sustainable environment.\"\n\n" +
                        "1. DENR'S CLEAN AIR PRIORITY: The Department of Environment and Natural Resources (DENR) in the Philippines has made improving air quality a top priority.\n\n" +
                        "2. COMPREHENSIVE CLEAN AIR PROGRAM: The Clean Air Program focuses on achieving and maintaining air quality that aligns with National Air Quality Guidelines while minimizing negative economic impacts.\n\n" +
                        "3. THREE SUB-PROGRAMS: The program encompasses three key sub-programs: Motor Vehicle Emission Management, Industrial Emission Management, and Roadside and General Ambient Air Monitoring.\n\n" +
                        "4. ROADSIDE AND AMBIENT AIR MONITORING: Monitoring air quality at the roadside and general ambient levels is crucial for assessing and regulating air quality.\n\n" +
                        "5. NATIONWIDE MONITORING STATIONS: Monitoring stations are spread across the Philippines, providing a comprehensive view of air quality conditions.\n\n" +
                        "6. REAL-TIME MONITORING: Real-time continuous monitoring stations track criteria pollutants and meteorological parameters, making data accessible to the public.\n\n" +
                        "7. ACCESSIBLE DATA: The DENR website offers accessible, user-friendly air quality information, including layman descriptions for non-scientific users.\n\n" +
                        "8. PARTNERSHIPS FOR MAINTENANCE: Collaborations with host institutions and agencies ensure the ongoing maintenance and security of monitoring equipment.\n\n" +
                        "9. FULL AIRSHED OPERATIONALIZATION: Nationwide airshed operationalization and action plan implementation are part of the initiative.\n\n" +
                        "10. PROMOTING CLEANER AIR: DENR's efforts align with the broader goal of promoting cleaner air and a healthier environment in the Philippines.",

                "https://www.greenpeace.org/static/planet4-philippines-stateless/2021/06/f0f25e6f-gp1su2sq-1024x683.jpg",
                "https://www.denr.gov.ph/index.php/priority-programs/clean-air-program"
               )
        )

        dataList.add(
            DataItem("INDUSTRIAL EMISSIONS AND REGULATIONS IN THE PHILIPPINES",
                "Discover the dynamic landscape of environmental regulations in the Philippines, where a complex web of policies, agencies, and compliance measures shapes the path to sustainable development. Uncover the key facets of environmental law and its impact on industries, seafarers, and the nation's commitment to combating climate change.\"\n\n" +

                        "1. CONSTITUTIONAL BASIS FOR ENVIRONMENTAL POLICY: Environmental policy in the Philippines is rooted in the Constitution, emphasizing the right to a 'balanced and healthful ecology' and sustainable development.\n\n" +
                        "2. REGALIAN DOCTRINE AND RESOURCE OWNERSHIP: The Regalian Doctrine dictates that natural resources are state-owned, with the government regulating exploration, development, and utilization.\n\n" +
                        "3. VARIED ENVIRONMENTAL LAWS: Environmental policy in the Philippines encompasses a range of laws governing water, air, forestry, mining, fisheries, and more.\n\n" +
                        "4. ROLE OF THE DEPARTMENT OF ENVIRONMENT AND NATURAL RESOURCES (DENR): The DENR is the primary agency responsible for enforcing environmental laws, including the management and conservation of natural resources.\n\n" +
                        "5. SHIFT TOWARDS PARTICIPATORY GOVERNANCE: The Philippines has transitioned from a regulation-heavy regime to more participatory environmental governance, emphasizing public consultations and stakeholder involvement.\n\n" +
                        "6. FREEDOM OF INFORMATION MANDATE: The government is committed to transparency and access to environmental information, as exemplified by Executive Order No. 2 and the DENR's FOI Manual.\n\n" +
                        "7. ENVIRONMENTAL PERMIT REQUIREMENTS: Environmentally Critical Projects (ECPs) must obtain Environmental Compliance Certificates (ECCs), with various permits required for aspects like air quality, hazardous waste, and wastewater discharge.\n\n" +
                        "8. LEGAL RECOURSE FOR PERMIT DENIAL: Environmental regulators' decisions on permits are generally not appealable but can be challenged for grave abuse of discretion.\n\n" +
                        "9. EXTENDED PRODUCER RESPONSIBILITY (EPR): The EPR Act introduces EPR mechanisms for waste reduction and recovery, placing responsibility on producers throughout a product's lifecycle.\n\n" +
                        "10. CHALLENGES AND ENFORCEMENT POWERS: Environmental regulators have authority to investigate, collect samples, conduct site inspections, and enforce environmental laws, promoting accountability and compliance.",

                "https://development.asia/sites/default/files/summary/gms-pollution.png",
                "https://iclg.com/practice-areas/environment-and-climate-change-laws-and-regulations/philippines"
            )
        )

        dataList.add(
            DataItem("PUBLIC AWARENESS AND BEHAVIOR CHANGE IN THE PHILIPPINES",
                "In the Philippines, a growing awareness of the severe health impacts of air pollution has sparked a call for change. Health experts are leading the charge, advocating for stricter environmental regulations and fostering public awareness to drive behavior change, all in the pursuit of cleaner air and better health.\n\n\n" +
                        "1. AIR POLLUTION CRISIS: The Philippines faces a severe air pollution crisis, ranking among the highest in the world for air pollution-related deaths, primarily attributed to fine particulate matter in the air.\n\n" +
                        "2. HEALTH EXPERTS TAKE ACTION: Health experts in the country are advocating for the stricter enforcement of clean air and environmental protection laws to address the public health challenges posed by air pollution.\n\n" +
                        "3. IMPACT ON PUBLIC HEALTH: The Philippines records approximately 45.3 air pollution-related deaths per 100,000 people, emphasizing the critical impact on public health.\n\n" +
                        "4. REGIONAL CONCERN: Air pollution is a significant concern in the Asia-Pacific region, with the Western Pacific Region, including the Philippines, witnessing a substantial number of premature deaths due to air pollution.\n\n" +
                        "5. CALL FOR STRONGER REGULATIONS: Experts call for a revisit of environmental regulations, such as the Clean Air Act, to combat air pollution and waste management challenges more effectively.\n\n" +
                        "6. DIRTY AIR SOURCES: Coal-fired power plants are identified as major sources of air pollution in the Philippines, linked to various respiratory diseases.\n\n" +
                        "7. GLOBAL IMPACT: A joint study by Greenpeace Philippines and Harvard University highlights the global consequences of coal-fired power plants and their contribution to greenhouse gas emissions.\n\n" +
                        "8. GOVERNMENT ENERGY PLAN: The Philippine Department of Energy indicates that coal remains a significant part of the country's energy mix, with plans to expand domestic coal resources.\n\n" +
                        "9. TRANSITION TO CLEAN ENERGY: Experts stress the need to transition away from coal dependence and promote alternative energy sources like hydro, tidal, geothermal, wind, and solar power.\n\n" +
                        "10. CLIMATE CHANGE AND PUBLIC HEALTH: The Philippines is working on initiatives to reduce short-lived climate pollutants and align with the Paris climate change agreement, emphasizing the urgent public health aspect of addressing climate change and air pollution.",

                "https://newsinfo.inquirer.net/files/2023/03/AIR-POLLUTION.jpeg",
                "https://noharm-global.org/articles/news/asia/news-health-experts-philippines-lead-fight-against-dirty-air"
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