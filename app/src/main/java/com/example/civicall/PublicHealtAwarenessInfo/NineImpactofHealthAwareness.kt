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
import com.example.civicall.databinding.ActivityNineImpactOfAwarenessBinding

class NineImpactofHealthAwareness : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    private lateinit var binding: ActivityNineImpactOfAwarenessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityNineImpactOfAwarenessBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "NON-COMMUNICABLE DISEASES: THE SILENT EPIDEMIC OF OUR TIME",
                "In an era where non-communicable diseases quietly claim countless lives, the Philippines grapples with a growing epidemic. The silent, yet pervasive, threat of NCDs demands our collective action.\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. NCDs: A Silent Epidemic: NON-COMMUNICABLE DISEASES (NCDs) are quietly causing widespread fatalities in the Philippines.\n\n" +
                        "2. COMMON NCDs: These diseases encompass diabetes, heart conditions, stroke, cancer, and chronic respiratory illnesses.\n\n" +
                        "3. SHARED ORIGINS: NCDs often share preventable risk factors such as unhealthy diets, physical inactivity, tobacco use, and excessive alcohol consumption.\n\n" +
                        "4. POSITIVE STEPS: The Philippines has taken measures like taxing tobacco and sugary beverages to combat NCDs.\n\n" +
                        "5. PERSISTENT RISKS: Despite efforts, a significant portion of the population is at risk for NCDs, with high rates of smoking and alcohol consumption.\n\n" +
                        "6. RISING OBESITY: Rates of obesity have doubled in two decades, with children and teenagers also affected.\n\n" +
                        "7. POOR DIETARY HABITS: The majority of adults fail to meet recommended fruit and vegetable intake, and many children suffer from stunting, predisposing them to future health risks.\n\n" +
                        "8. GLOBAL COLLABORATION: The WHO and UN agencies are partnering with the Philippines to reduce NCD-related premature deaths by a third by 2030.\n\n" +
                        "9. INTERAGENCY TASK FORCE: A UN-led Task Force, comprising over 40 agencies, is working to combat NCDs as part of the Sustainable Development Agenda.\n\n" +
                        "10. CRUCIAL MEASURES: The task force will recommend comprehensive tobacco control, regulation of unhealthy food marketing to children, nutrition labeling, and the promotion of healthy diets and physical activity.",

                "https://www.uicc.org/sites/default/files/styles/original_small/public/thumbnails/image/SUCCESS-Philippines-Jhpiego-20211107_161204.jpeg.webp?itok=LpZlbsAO",
                "https://www.who.int/philippines/news/commentaries/detail/time-for-action-to-stop-the-deadliest-diseases-in-the-philippines"

            )
        )
        dataList.add(
            DataItem("HEALTH CAMPAIGNS: SHAPING PUBLIC AWARENESS FOR A HEALTHIER TOMORROW",
                "Fostering a healthier tomorrow through strategic health campaigns that empower communities. Join us in shaping a future with improved public awareness and well-being.\n\n" +
                        "1. UNLOCKING HEALTH PROMOTION'S POTENTIAL: Understanding the significance of health promotion and its role in inspiring positive health changes.\n\n" +
                        "2. IMPACT OF SOCIETAL FACTORS ON HEALTH: Exploring how health and social well-being are influenced by various factors beyond healthcare.\n\n" +
                        "3. GLOBAL INITIATIVES IN HEALTH PROMOTION: Overview of international conferences and charters, like the Ottawa Charter, that drive global health promotion.\n\n" +
                        "4. TARGETING PRIORITY HEALTH CONCERNS: The importance of addressing specific health issues with comprehensive interventions.\n\n" +
                        "5. HEALTH PROMOTION AS A BEHAVIORAL SCIENCE: Describing health promotion as a multi-disciplinary effort to enhance health knowledge and behavior.\n\n" +
                        "6. THE IMPACT OF HEALTH PROMOTION: Highlighting the positive impact of health promotion on health status and healthcare costs.\n\n" +
                        "7. IMPLEMENTING HEALTH PROMOTION IN DIFFERENT SETTINGS: Integrating health promotion into schools, workplaces, and communities.\n\n" +
                        "8. TAILORED INTERVENTIONS FOR DIVERSE POPULATIONS: Addressing different population groups with specific interventions.\n\n" +
                        "9. PRIMORDIAL PREVENTION FOR RISK REDUCTION: Explaining primordial prevention's role in reducing health risks by preventing risk factors.\n\n" +
                        "10. CRAFTING IMPACTFUL HEALTH CAMPAIGNS: Step-by-step guide for creating effective health awareness campaigns.\n",

                "https://evident.ph/wp-content/uploads/2021/07/DOH_Behance_Main-Art.jpg",
                "https://www.adbirt.com/blog/how-to-promote-health-awareness/"
              )
        )
        dataList.add(
            DataItem("UNHEALTHY HABITS IN THE PHILIPPINES: EXPLORING THEIR IMPACT ON CHRONIC DISEASES",
                "In the vibrant Philippines, a silent health crisis looms as unhealthy habits, particularly among children and adolescents, gain prominence. This article delves into the root causes and consequences of these habits, shedding light on their profound impact on chronic diseases\n\"\n\n" +
                        "1. RISING HEALTH CRISIS: Unhealthy lifestyle choices in the Philippines pose a significant health crisis, especially among children and adolescents.\n\n" +
                        "2. POOR DIETS AND NUTRITION: Filipino youth are consuming unhealthy foods, leading to poor diets and inadequate nutrition.\n\n" +
                        "3. STUNTING AND MALNUTRITION: One in three Filipino children under five is stunted, with long-term consequences for their cognitive and physical development.\n\n" +
                        "4. TRIPLE BURDEN OF MALNUTRITION: The country faces undernutrition, hidden hunger, and overweight issues, all of which threaten child health.\n\n" +
                        "5. PANDEMIC EXACERBATION: COVID-19 has further fueled unhealthy lifestyle habits among Filipinos, with seven key areas of concern.\n\n" +
                        "6. FAST FOOD CONSUMPTION: The Philippines has witnessed a proliferation of fast-food chains offering convenient but often unhealthy meals.\n\n" +
                        "7. SUGARY BEVERAGES: High consumption of sugary drinks contributes to obesity, diabetes, and other metabolic disorders.\n\n" +
                        "8. PROCESSED SNACKS: Processed snacks, such as chips and candies, are now staples in Filipino households, lacking essential nutrients.\n\n" +
                        "9. TOBACCO AND ALCOHOL USE: Smoking remains a significant concern, while binge drinking is linked to various health problems.\n\n" +
                        "10. ECONOMIC AND HEALTHCARE IMPACT: Unhealthy habits strain the healthcare system and have economic repercussions, making urgent action necessary.",

                "https://www.southwestjournal.com/wp-content/webp-express/webp-images/uploads/2023/10/Sufary-beverages.jpg.webp",
                "https://www.southwestjournal.com/unhealthy-habits-in-the-philippines/"
)
        )

        dataList.add(
            DataItem("THE OBESITY EPIDEMIC: UNMASKING THE WEIGHTY CHALLENGE",
                "As the COVID-19 pandemic disrupted daily life, another silent epidemic quietly escalated in the Philippines. A surge in obesity, particularly among children and adults, has raised concerns about the nation's health and well-being.\"\n" +

                        "1. ESCALATING OBESITY RATES: The Philippines has witnessed a significant increase in obesity, particularly among children and adults, with prevalence rates surpassing previous figures.\n\n" +
                        "2. CONTRIBUTING FACTORS: The COVID-19 pandemic and related lockdowns resulted in reduced physical activity, while changes in dietary habits, including online fast food orders, added to the problem.\n\n" +
                        "3. OBESITY DEFINED: Obesity is characterized by excessive fat accumulation, presenting a serious health risk, and often develops over time due to poor dietary choices and a sedentary lifestyle.\n\n" +
                        "4. CONSEQUENCES OF OBESITY: Being overweight or obese increases the risk of various serious health conditions, including hypertension, diabetes, heart disease, and even mental health issues.\n\n" +
                        "5. GROWTH OF OBESITY WORLDWIDE: The problem of obesity is not limited to the Philippines and is a global concern, with over one billion affected worldwide.\n\n" +
                        "6. GENETICS AND LIFESTYLE: While genetics play a role in obesity, lifestyle choices significantly contribute, such as consuming high-energy, low-nutrition foods and leading sedentary lives.\n\n" +
                        "7. BODY MASS INDEX (BMI): BMI is used to assess body fat, and a range between 18.5 and 22.9 is considered healthy for individuals aged 16 and older.\n\n" +
                        "8. ALARMING STATISTICS: Over 27 million Filipinos are overweight or obese, and the prevalence of obesity among adults has steadily risen over the past two decades.\n\n" +
                        "9. PROJECTED TRENDS: Without action, it is estimated that more than 30% of Filipino adolescents will be overweight or obese by 2030.\n\n" +
                        "10. ADDRESSING THE ISSUE: Various organizations and government bodies are working to implement policies, promote healthy diets, and increase physical activity to combat the growing obesity problem in the Philippines.",

                "https://newsinfo.inquirer.net/files/2022/11/OBESITY.jpeg",
                "https://newsinfo.inquirer.net/1694528/obesitys-heavy-toll-millions-of-filipinos-now-at-greater-health-risks"
              )
        )

        dataList.add(
            DataItem("HEALTH LITERACY: EQUIPPING INDIVIDUALS FOR INFORMED HEALTH DECISIONS",
                "In the face of the pandemic's impact on healthcare, reimagining health education is the key to preparing future healthcare workers and empowering individuals to make informed health choices\n\n\n" +
                        "1. PANDEMIC CHALLENGES: The COVID-19 pandemic strained healthcare systems worldwide, revealing the need for a more robust health workforce.\n\n" +
                        "2. SHORTAGE OF NURSES: Many countries, including the Philippines, are experiencing a shortage of nurses, leading to recruitment from other nations.\n\n" +
                        "3. IMPACT ON LOCAL HEALTHCARE: Recruitment of health professionals abroad depletes local health facilities, hindering services for Filipinos.\n\n" +
                        "4. TECHNOLOGY'S LIMITATIONS: While telehealth and technology help, they can't replace the essential human aspect of healthcare.\n\n" +
                        "5. RECONFIGURATION NEEDED: The ongoing pandemic forces a reconfiguration of healthcare delivery and management.\n\n" +
                        "6. ROLE OF HEALTH EDUCATION: Health education institutions must adapt to new challenges to ensure a skilled and adaptable health workforce.\n\n" +
                        "7. ACCELERATION OF DIGITAL LEARNING: Digital technologies accelerate the change in how learning is provided, acquired, and assessed.\n\n" +
                        "8. COST OF EDUCATION: The rising cost of education is making it unaffordable for many students and their families.\n\n" +
                        "9. HYBRID LEARNING: A blend of physical and digital learning methods is necessary for comprehensive health education.\n\n" +
                        "10. ACCESSIBLE EDUCATION: Diversity, equity, and inclusion should be integral to affordable and accessible health education.",

                "https://business.inquirer.net/files/2023/01/HEALTH.png",
                "https://business.inquirer.net/380420/health-education-in-transition-preparing-future-health-workforce-for-patient-care"
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