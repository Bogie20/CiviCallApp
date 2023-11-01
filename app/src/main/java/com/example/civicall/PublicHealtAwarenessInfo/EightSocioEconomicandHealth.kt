package com.example.civicall.PublicHealtAwarenessInfo

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
import com.example.civicall.databinding.ActivityEightSocioeconomicFactorHealthBinding

class EightSocioEconomicandHealth : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    private lateinit var binding: ActivityEightSocioeconomicFactorHealthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityEightSocioeconomicFactorHealthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager



        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "HEALTH INEQUITIES IN THE PHILIPPINES: UNMASKING THE SOCIOECONOMIC DIVIDE",
                "In the Philippines, a growing concern revolves around health inequities, where socioeconomic disparities impact access to vital healthcare services and coverage. This study unveils the intricate web of health inequalities among older adults, shedding light on the underlying factors and their consequences.\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. GROWING AGING POPULATION: The Philippines is experiencing an aging population, with projections indicating that older adults will comprise 14% of the total population by 2050.\n\n" +
                        "2. HEALTHCARE DEMAND: As the older population grows, there's an increasing demand for healthcare services, particularly to address complex health needs among older adults.\n\n" +
                        "3. HEALTH POLICY EVOLUTION: The country has implemented various health policies, including the National Health Insurance Program (NHIP), to improve healthcare access and reduce inequities.\n\n" +
                        "4. NATIONAL HEALTH INSURANCE PROGRAM (NHIP): NHIP aims to provide financial protection and enhance access to healthcare, covering diverse membership categories.\n\n" +
                        "5. SOCIAL HEALTH INSURANCE: The NHIP functions as a form of social health insurance and was established in 1995 through Republic Act 7875, creating the Philippine Health Insurance Corporation (PhilHealth).\n\n" +
                        "6. INCLUSION OF SENIOR CITIZENS: In 2014, older adults aged 60 and above were automatically enrolled in the NHIP, ensuring access to free inpatient healthcare at government hospitals.\n\n" +
                        "7. SOCIOECONOMIC DISPARITIES: The Philippines grapples with socioeconomic disparities in healthcare access, with differences based on factors like wealth, geography, and rural or urban residence.\n\n" +
                        "8. POLICY DEVELOPMENTS: Multiple policy developments, such as the 'No Balance Billing' and the 'Z Benefit Package,' aimed to improve access to quality healthcare.\n\n" +
                        "9. REDUCTION IN INEQUALITIES: The study reveals that NHIP coverage and healthcare utilization among older adults improved from 2003 to 2017, reducing socioeconomic inequalities over time.\n\n" +
                        "10. PUBLIC HEALTH CHALLENGE: Achieving universal health coverage and addressing health disparities among older adults remain important public health challenges in the Philippines.",

                "https://media.philstar.com/photos/2019/02/23/gen3-maternity-hospital-kjrosales_2019-02-23_23-04-39.jpg",
                "https://environhealthprevmed.biomedcentral.com/articles/10.1186/s12199-020-00854-9"

            )
        )
        dataList.add(
            DataItem("POVERTY'S TOLL ON HEALTH: UNDERSTANDING THE LINK",
                "In the Philippines, the intersection of poverty and health is a pressing concern. This article delves into the challenges faced by farmers, shedding light on the intricate link between socioeconomic status and health consequences, ultimately seeking to understand how poverty takes its toll on well-being.\n\n" +
                        "1. FARMERS STRUGGLE AMID ECONOMIC CHALLENGES: Farmers like Felipe Nazar in the Philippines face grueling work schedules and rising costs of farm inputs, impacting their livelihoods and contributing to poverty-related health concerns.\n\n" +
                        "2. EXTERNAL FACTORS WORSEN THE SITUATION: External events like the COVID-19 pandemic, Russia's invasion of Ukraine, and climate disruptions further compound the challenges faced by Filipino farmers, raising concerns about increased hunger in the country.\n\n" +
                        "3. INCREASING POVERTY AMONG FARMERS: Farmers and fisherfolk are among the poorest workers in the Philippines, with nearly one in three living below the poverty threshold, as input costs have doubled since 2020.\n\n" +
                        "4. IMPACT ON HOUSEHOLD INCOMES: Traditional incomes for farmers have dwindled, leading to financial struggles, debt, and the inability to afford basic necessities, including education for their children.\n\n" +
                        "5. REDUCED PROFITS IN FARMING: Despite the efforts of farmers and their families, many farms are not profitable, forcing them to sell their crops at low prices while consumers pay significantly more.\n\n" +
                        "6. DEBT AS A COPING MECHANISM: Many farmers resort to borrowing from loan sharks to cover costs, plunging them into a cycle of debt due to the high interest rates.\n\n" +
                        "7. HUNGER ON THE RISE: A significant portion of Filipinos faces hunger, with one in ten experiencing involuntary hunger, and the majority unable to afford a healthy diet.\n\n" +
                        "8. RISING FOOD INFLATION: While the Philippines has a growing middle class and a young population, food inflation is high, with households spending over half their income on food.\n\n" +
                        "9. REGIONAL DISPARITIES: Regional disparities persist, with some areas experiencing three to four times higher hunger levels than others, deepening the issue of poverty-related health concerns.\n\n" +
                        "10. GOVERNMENT'S ROLE AND POTENTIAL SOLUTIONS: Experts suggest that government intervention, including support for local farmers and strategic import policies, could alleviate the challenges faced by farmers and reduce the impact of poverty on health.\n\n",

                "https://assets.thenewhumanitarian.org/s3fs-public/2023-07/Danilo%20Ramos%20Philippines%20farmer%20protest.jpg",
                "https://www.thenewhumanitarian.org/analysis/2023/07/27/Filipino-farmers-profits-hunger-looms"
              )
        )
        dataList.add(
            DataItem("HEALTHCARE ACCESSIBILITY: BRIDGING THE GAP IN A DIVERSE LANDSCAPE",
                "In a nation as geographically diverse as the Philippines, healthcare accessibility is a multifaceted challenge. This article explores the hurdles faced by underserved communities, shedding light on the urgent need to bridge the healthcare gap in this diverse landscape.\"\n\n\n" +
                        "1. CHALLENGES IN JOMALIG'S REMOTE HEALTHCARE: The article investigates the struggles faced by the geographically isolated Jomalig Island in the Philippines, highlighting the difficulties in providing essential healthcare services.\n\n" +
                        "2. DEFICIENT PUBLIC HEALTH FACILITIES: Jomalig Island grapples with inadequate public health facilities and services, creating obstacles to addressing the health needs of its population.\n\n" +
                        "3. GEOGRAPHICAL DISADVANTAGE AND LIMITED ACCESS: Due to its remote location, Jomalig Island faces substantial challenges in delivering healthcare, with long travel times exacerbating the issue.\n\n" +
                        "4. ECONOMIC AND SOCIAL SERVICE CHALLENGES: The geographical isolation results in deficiencies in basic public services, such as water, electricity, and roads, impacting the overall well-being of the community.\n\n" +
                        "5. MORTALITY AND MORBIDITY RATES: Although not alarmingly high, mortality and morbidity rates reveal some health concerns on the island, including hypertension and diarrhea.\n\n" +
                        "6. RELIANCE ON FAITH HEALERS: A significant portion of the population resorts to 'faith healers' over traditional healthcare services, contributing to health complications.\n\n" +
                        "7. ECONOMIC HARDSHIPS AND LIMITED INCOME: The economic status of the population directly affects health outcomes, with malnutrition and financial constraints hindering access to healthcare.\n\n" +
                        "8. GEOGRAPHICAL LOCATION AND TRANSPORTATION ISSUES: Limited access to better-equipped healthcare facilities due to distance and sea conditions adds to the healthcare challenges faced by residents.\n\n" +
                        "9. ENVIRONMENTAL FACTORS: Unclean water sources, improper waste disposal, and unsanitary practices further compound public health problems in some communities.\n\n" +
                        "10. RECOMMENDATIONS AND POLICY IMPLICATIONS: To improve healthcare accessibility in geographically isolated areas like Jomalig Island, the article suggests a range of solutions, including emergency boats, health education campaigns, and infrastructure improvements.",

                "https://www.borgenmagazine.com/wp-content/uploads/2023/08/51088900678_c6434f2e45_k.jpg",
                "https://www.joghr.org/article/11962-challenges-in-public-health-facilities-and-services-evidence-from-a-geographically-isolated-and-disadvantaged-area-in-the-philippines"
           )
        )

        dataList.add(
            DataItem("SOCIAL DETERMINANTS OF HEALTH: SHAPING LIVES AND HEALTH OUTCOMES",
                "In the intricate interplay of social determinants and health, the Philippines grapples with a significant challenge. This article delves into the complex web of factors that shape lives and health outcomes in the country\"\n\n\n" +

                        "1. SOCIAL DETERMINANTS: The Silent Architects of Health - The article unveils the critical role of social determinants, such as education, income, and employment, in molding health outcomes and exacerbating health disparities.\n\n" +
                        "2. PHILIPPINES' HEALTH CARE DISPARITIES - It sheds light on the Philippines' ongoing struggle with healthcare inequities, where the distribution of health professionals fails to meet World Health Organization standards.\n" +
                        "3. DEFICIENCY IN HEALTH CARE WORKERS - The Philippines grapples with a severe shortage of healthcare professionals, with a ratio far below recommended levels, especially in regions with higher poverty rates.\n\n" +
                        "4. WEALTH DISPARITY AND HEALTH NEEDS - It emphasizes the correlation between wealth inequality and health outcomes, highlighting how poorer regions with greater health needs face underdeveloped health services.\n" +
                        "5. REGIONAL HEALTH CARE DISPARITIES - The data exposes disparities in health worker distribution, where more impoverished areas have fewer healthcare professionals, further limiting access to essential care.\n" +
                        "6. THE ROLE OF PUBLIC HEALTH CARE - The article suggests that expanding the public health care system with a focus on poorer regions could significantly bridge the healthcare gap.\n" +
                        "7. BUDGET ALLOCATION FOR HEALTH - It points out that the allocation of budgetary resources for public healthcare is a crucial political decision, but the current privatization of healthcare skews priorities.\n" +
                        "8. HEALTH WORKERS' NEEDS NEGLECTED - The health system's failure to address the economic and social needs of healthcare workers is a critical issue, leading to a recruitment and retention crisis.\n" +
                        "9. HEALTH WORKER MIGRATION - The Philippines experiences a significant outmigration of healthcare professionals due to inadequate salaries and benefits, pushing them to seek better opportunities abroad.\n" +
                        "10. PREVENTABLE HEALTH DISPARITIES - The article underscores that a lack of healthcare professionals and inadequate services in poorer regions directly contributes to more sickness and death, ultimately worsening health outcomes and deepening health disparities.",

                "https://newsinfo.inquirer.net/files/2023/04/HEALTH-WORKERS.jpeg",
                "https://newsinfo.inquirer.net/1760779/ph-health-care-conundrum-fewer-health-professionals-where-people-are-poorest"
        )
        )

        dataList.add(
            DataItem("HEALTH DISPARITIES: THE UNEQUAL BURDEN OF DISEASE",
                "Structural racism in the Philippines perpetuates health disparities, with marginalized populations facing unequal access to vital healthcare services. This article explores these inequalities, highlighting the urgent need for interventions to address the unequal burden of disease\n\n\n" +
                        "1. CHALLENGES IN HEALTHCARE ACCESSIBILITY: Uneven distribution of medical facilities and limited access to primary care services in the Philippines.\n" +
                        "2. HEALTH DISPARITIES AMONG INDIGENOUS COMMUNITIES: Indigenous populations in the Philippines experience substantially lower health outcomes, including higher infant and maternal mortality rates.\n" +
                        "3. STRUCTURAL RACISM AND HEALTH DISPARITIES: Structural racism compounds health disparities, as historically oppressed groups suffer from chronic discrimination, stress, and depression.\n" +
                        "4. RACIAL AND SOCIOECONOMIC INEQUITIES: Ethnic identity and socioeconomic status play pivotal roles in shaping health outcomes, perpetuating health disparities.\n" +
                        "5. LIMITED HEALTH INSURANCE COVERAGE: Indigenous populations often lack adequate health insurance coverage, leading to financially dependent children being underinsured.\n" +
                        "6. COVID-19 VULNERABILITY: Indigenous children are particularly vulnerable to the health risks associated with the COVID-19 pandemic, highlighting the need for targeted interventions.\n" +
                        "7. SOCIO-ECOLOGICAL MODEL FOR HEALTH: The Socio-Ecological Model underscores the complex interplay of societal and ecological influences on health-related behaviors.\n" +
                        "8. SYSTEMIC FACTORS AND HEALTH DISPARITIES: Many causes of health disparities are rooted in systemic factors that require multi-level interventions for effective solutions.\n" +
                        "9. IMPACT OF RESEARCH ON POPULATION HEALTH: Local evidence-based research and culturally congruent interventions are vital for improving public health in developing countries like the Philippines.\n" +
                        "10. COLLABORATIVE APPROACH TO ADDRESSING HEALTH DISPARITIES: Healthcare providers, researchers, community leaders, and policymakers must collaborate to eliminate structural racism and reduce health disparities in the Philippines.",

                "https://eon.com.ph/wp-content/uploads/2020/04/People-Wearing-Mask-Discussion.jpg",
                "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC10072864/"
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

}