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

class WaterWoesandWinsInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_woesand_wins_info)






        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "CLEAN WATER CHALLENGES IN RURAL AREAS (PHILIPPINES)",
                "In the heart of rural Philippines, the village of Tagbak grapples with a pressing issue – the dire lack of clean water sources. As we explore the challenges faced by this community, we shed light on the broader issue of clean water accessibility in rural areas.\"\n\n" +
                        "1. CLEAN WATER CRISIS IN TAGBAK, PHILIPPINES: The village of Tagbak struggles with insufficient clean water sources, forcing residents to rely on intermittent and often unsafe supplies.\n\n" +
                        "2. 3 MILLION FILIPINOS LACK SAFE WATER: Data from the World Health Organization (WHO) reveals that at least 3 million Filipinos depend on unsafe and unsustainable water sources, raising health concerns.\n\n" +
                        "3. CLIMATE CHANGE EXACERBATES THE ISSUE: The impending dry season and climate change pose threats to water availability in Tagbak, potentially exacerbating the problem.\n\n" +
                        "4. INTERMITTENT WATER SUPPLY: Residents in Tagbak face irregular water flow, sometimes waiting for hours for water to trickle from rusty pipes.\n\n" +
                        "5. COMMUNITY CHALLENGES: The villagers often need to travel to an impounding dike to fetch water during water shortages, incurring additional costs.\n\n" +
                        "6. LIMITED HOUSEHOLD RESOURCES: Families like Eileen Hinganan's, whose husband earns P2,800 a month, struggle with the added financial burden of securing water.\n\n" +
                        "7. GOVERNMENT INITIATIVE: The local government allocates P2 million for a pumping station to supply water, but the proposal's status remains uncertain.\n\n" +
                        "8. EXTERNAL FACTORS: The construction of a police camp near Tagbak has further strained water resources as pumps draw water from the village's pipelines.\n\n" +
                        "9. COMMUNITY SUPPORT: Retired Army major general Johnny Macanas offers assistance to the villagers by transporting their water containers to the impounding dike.\n\n" +
                        "10. HEALTH IMPLICATIONS: Lack of clean water sources can lead to poor personal hygiene and increased vulnerability to diseases, including COVID-19, emphasizing the urgency of addressing this challenge.\n\n",

                "https://www.rappler.com/tachyon/2022/04/Bukidnon-water1-scaled.jpg?resize=2560%2C1748&zoom=1",
                "https://www.rappler.com/nation/takbag-village-bukidnon-relies-unsafe-water-sources-survival/"

            )
        )
        dataList.add(
            DataItem("URBAN WATER INFRASTRUCTURE AND MANAGEMENT IN THE PHILIPPINES",
                "In the Philippines, urban water management is a pressing challenge, with companies in Metro Manila actively adapting to climate change and population growth for sustainable and resilient water infrastructure\n\n" +
                        "1. MAYNILAD'S AMBITIOUS INVESTMENT PLAN: Maynilad Water Services Inc. is planning to invest PHP163 billion from 2023 to 2027, with PHP101 billion designated for water projects and the remainder for wastewater projects.\n\n" +
                        "2. ENHANCING WATER SECURITY: Maynilad's service improvement plan focuses on enhancing water security, environmental sustainability, service expansion, and disaster resiliency, aiming to meet growing water demand.\n\n" +
                        "3. INFRASTRUCTURE DEVELOPMENT: A significant portion of the investment will be directed toward developing more water sources, building pumping stations, and replacing pipelines, striving for 24-hour water service.\n\n" +
                        "4. SUSTAINABILITY EFFORTS: Maynilad has allocated PHP9.9 billion to replace old and leaky pipes, reducing water losses and improving the distribution system, prioritizing 24-hour supply.\n\n" +
                        "5. RECYCLED WATER INITIATIVE: Maynilad introduces \"New Water\" produced at its water treatment plant as an alternative supply source, addressing water shortages and adhering to safety standards.\n\n" +
                        "6. COMMUNITY SUPPORT DURING DISASTERS: Maynilad provides a PHP1.7-million rebate to customers affected by Typhoon Paeng, assisting in clean-up efforts after flooding.\n\n" +
                        "7. REGULATORY COMMENDATION: Metropolitan Waterworks and Sewerage System-Regulatory Office commends Maynilad for its initiative in assisting typhoon-affected families.\n\n" +
                        "8. SAFE WATER ASSURANCE BY MANILA WATER: Manila Water assures 7.4 million consumers of safe and potable water round the clock, maintaining stringent water quality standards.\n\n" +
                        "9. CLIMATE ACTION AND ADAPTATION: Manila Water contributes to the United Nations Sustainable Development Goals on Climate Action through climate-resilient infrastructure and nature-based solutions.\n\n" +
                        "10. HIGH CDP RATINGS: Manila Water receives B ratings in CDP's Climate Change and Water Security Disclosures, exemplifying strengthened climate actions and a commitment to 24/7 water services.\n\n",

                "https://media.philstar.com/photos/2021/07/29/water2020-09-1521-49-24_2021-07-29_22-50-29.jpg",
                "https://www.pna.gov.ph/articles/1191389"
             )
        )
        dataList.add(
            DataItem("COMMUNITY-BASED SOLUTIONS FOR WATER ACCESS (PHILIPPINES)",
                "In the remote landscapes of the Philippines, innovative community-based solutions are addressing water access challenges. Discover how hydropanels are providing renewable drinking water to indigenous communities, exemplifying a sustainable path toward improved quality of life.\"\n\n" +
                        "1. RENEWABLE DRINKING WATER IN PALAWAN: Hydropanels are being deployed to generate more than 40,000 liters of renewable drinking water annually for the indigenous Binta't Karis community in Palawan.\n\n" +
                        "2. COMMUNITY COLLABORATION IN BARANGAY IRAAN: The hydropanel project benefits about 100 students, teachers, and their families in Barangay Iraan, Rizal municipality, Palawan, fostering community collaboration.\n\n" +
                        "3. PARTNERSHIP WITH CONSERVATION INTERNATIONAL: American nonprofit Conservation International collaborates with SOURCE Global (formerly Zero Mass Water), the producers of hydropanels, to bring sustainable water solutions to Palawan.\n\n" +
                        "4. SOLAR-POWERED HYDROPANELS: The hydropanels use solar power to create condensation, power fans, draw in ambient air, and pass it through a water-absorbing material, condensing it into liquid that's collected in a reservoir.\n\n" +
                        "5. PLASTIC WASTE REDUCTION: The hydropanels aim to offset over two million plastic water bottles, contributing to environmental sustainability.\n\n" +
                        "6. IMPROVED QUALITY OF LIFE: The project is expected to markedly improve the health and quality of life for the indigenous community in Palawan by providing clean drinking water.\n\n" +
                        "7. GLOBAL INITIATIVES: This Palawan installation is part of a global effort, with previous hydropanel projects in Colombia and Timor Leste, demonstrating the scalability of these solutions.\n\n" +
                        "8. ACKNOWLEDGMENT OF FUNDERS: Climate-tech accelerator Elemental Excelerator funded the grant, and the American and Philippine governments support the initiative.\n\n" +
                        "9. IMPACTFUL RENEWABLE SOLUTIONS: SOURCE Hydropanels excel in remote locations where access to clean water is challenging, addressing a pressing need for the Palawan community.\n\n" +
                        "10. SUSTAINABLE WATER ACCESS IN THE PHILIPPINES: The adoption of hydropanels as a community-based solution showcases a sustainable approach to ensuring water access for remote and underserved populations in the Philippines.\n\n",

                "https://www.rappler.com/tachyon/2020/10/hydropanels-1.jpg?resize=1019%2C573&zoom=1",
                "https://www.rappler.com/technology/innovations/source-hydropanels-conservation-international-bintat-karis-palawan/"
              )
        )

        dataList.add(
            DataItem("WATER QUALITY AND CONTAMINATION ISSUES IN THE PHILIPPINES",
                "In the Philippines, water quality and contamination pose significant challenges, affecting millions who rely on unsafe water sources and the nation's rich biodiversity. Explore the pressing issues surrounding water pollution, plastic waste, and the government's initiatives in addressing these concerns.\"\n" +

                        "1. UNSAFE WATER USAGE: Approximately three million Filipinos use unsafe water sources, risking their health daily, while seven million lack access to improved sanitation.\n\n" +
                        "2. WATER QUALITY OBSTACLES: Despite economic growth, the Philippines grapples with water and sanitation accessibility challenges, particularly in rapidly urbanizing areas.\n\n" +
                        "3. PLASTIC WATER POLLUTION: The country faces significant plastic water pollution issues, threatening its status as a biodiversity hotspot with a rich variety of animal and plant species.\n\n" +
                        "4. DETERIORATING WATER QUALITY: Dangerous chemicals and microorganisms contaminate rivers, lakes, seas, and oceans, leading to deteriorating water quality harmful to both humans and the environment.\n\n" +
                        "5. PLASTIC WASTE'S IMPACT: Plastic waste, particularly in rivers like those feeding into Laguna de Bay, contributes to species diversity decline and poses risks to aquatic life.\n\n" +
                        "6. PLASTIC POLLUTION IN RIVERS: The Philippines is home to 28% of the world's rivers polluted by plastic, with these plastic particles undergoing changes that can harm living organisms.\n\n" +
                        "7. LARGE PLASTIC DISCHARGE: The country ranks as one of the world's major plastic pollutants, with millions of tons of plastic entering its waters annually, suffocating coral reefs and affecting the fishing industry.\n\n" +
                        "8. ASIAN PLASTIC POLLUTION: Asian rivers, including the Philippines' rivers like the Pasig River, contribute to 81% of global plastic pollution in oceans.\n\n" +
                        "9. GOVERNMENT INITIATIVES: The government aims to achieve 60% plastic reuse by 2030 and is encouraging private sector involvement in managing plastic waste.\n\n" +
                        "10. RESTORATION EFFORTS: Initiatives are underway to address pollution and restore water bodies like the Pasig River and Manila Bay, aiming to improve water quality and ecosystem health.\n\n",

                "https://cloudfront-us-east-2.images.arcpublishing.com/reuters/ZRWS6SFZ7FPVVL4WFZOF7EIBUU.jpg",
                "https://www.developmentaid.org/news-stream/post/155108/water-pollution-in-the-philippines"
             )
        )

        dataList.add(
            DataItem("INDIGENOUS WATER MANAGEMENT PRACTICES IN THE PHILIPPINES",
                "In the northern Philippines, the Kankanaey people of Besao have harnessed traditional practices and beliefs to sustainably manage their water resources. Explore their indigenous water management techniques and their vital role in preserving the region's natural wealth.\n\n\n" +
                        "1. SUSTAINING WATER RESOURCES: The Kankanaey people rely on traditional practices and beliefs to sustainably manage water resources in their region.\n\n" +
                        "2. AGRICULTURE AND RICE CULTIVATION: Water is of paramount importance in Besao, where agriculture, particularly rice cultivation, is a way of life.\n\n" +
                        "3. DEPLETED WATER SUPPLIES: The Kankanaey face challenges such as deforestation, overlapping claims to water sources, deforestation, and the impact of 'alternative' development strategies on water resources.\n\n" +
                        "4. DEFORESTATION ISSUES: Fires and unregulated logging have led to the deforestation of mountain watersheds, which has severe implications for water sources.\n\n" +
                        "5. OVERLAPPING CLAIMS: Overlapping and conflicting claims to water sources, both at the national and local levels, exacerbate the water management problem.\n\n" +
                        "6. COMMERCIAL AGRICULTURE: Increasing cultivation of cash crops, including commercial vegetables, intensifies the demand for water and agricultural lands.\n\n" +
                        "7. SUSTAINABILITY THROUGH TRADITION: Despite these challenges, the Kankanaey maintain their traditional practices and adapt them to contemporary needs to ensure stable and sustainable livelihoods.\n\n" +
                        "8. ROLE OF CUSTOMARY LAW AND RELIGIOUS BELIEFS: Customary law and religious beliefs, guided by the inayan and lawa concepts, play a significant role in preserving natural resources, emphasizing respect for nature, morality, and harmony.\n\n" +
                        "9. NAKINBAEY AND WATER BELIEFS: Water is seen as life itself and is believed to be produced by the nakinbaey, a supernatural being inhabiting water sources. Respecting these sources is essential to ensure a continuous water supply.\n\n" +
                        "10. SHARED WATER OWNERSHIP: Water is considered a shared resource, and water rights are tied to land ownership. The Kankanaey employ a cooperative dumapat water management system to ensure equitable access to and distribution of water.",

                "https://www.adb.org/sites/default/files/content-media/6623-philippines-improving-community-water-supplies-feature-01.jpg",
                "https://www.culturalsurvival.org/publications/cultural-survival-quarterly/traditional-water-management-practices-kankanaey"
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