package com.example.civicall.SurvivalTipsInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class ElNinoInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_el_nino_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "WATER CONSERVATION STRATEGIES",
                "\"In anticipation of the impending El Niño phenomenon and the potential water scarcity it brings, the EcoWaste Coalition offers a lifeline of water conservation strategies for the Philippines. Learn how to protect this precious resource while mitigating the impact of El Niño in the following guide.\"\"\n\n" +
                        "1. FIX ALL LEAKS: Repair any leaky pipes, tanks, and faucets to prevent water loss, especially during times of scarcity.\n\n" +
                        "2. HARVEST RAINWATER: Collect rainwater and store it properly for non-potable uses, reducing the demand on the main water supply.\n\n" +
                        "3. TURN OFF TAPS: Conserve water by turning off the tap while brushing teeth, washing your face, or shaving.\n\n" +
                        "4. SHORTER SHOWERS: Take shorter showers and consider reusing towels to reduce daily water consumption.\n\n" +
                        "5. FULL LAUNDRY LOADS: Run full loads of laundry to save on water, electricity, and detergent usage.\n\n" +
                        "6. REUSE GREY WATER: Utilize grey water from bathing and washing for flushing toilets, cleaning, and watering plants.\n\n" +
                        "7. TOILET TANK MODIFICATION: Place a brick or container filled with pebbles or sand in the toilet tank to reduce the water used per flush.\n\n" +
                        "8. COLLECT AC DRIP: Gather water dripping from air conditioners for various household purposes, such as cleaning and watering plants.\n\n" +
                        "9. SMART KITCHEN PRACTICES: Don't let the faucet run while washing rice, fruits, and vegetables, and reuse this water for plant irrigation.\n\n" +
                        "10. EFFICIENT COOKING: Steam vegetables instead of boiling and use the correct pot or pan size to minimize water consumption.\n\n",

                "https://media.philstar.com/photos/2020/02/24/water_2020-02-24_22-14-30371_thumbnail.jpg",
                "https://newsinfo.inquirer.net/1799837/pro-envt-group-urges-public-to-prepare-for-el-nino-gives-tips-on-water-conservation#:~:text=Collect%20water%20dripping%20from%20air,lessen%20the%20use%20of%20water."

            )
        )
        dataList.add(
            DataItem("DROUGHT-RESISTANT CROPS AND GARDENING",
                "\"Amid the looming threat of El Niño, the Philippines' Department of Agriculture stands ready to combat its adverse effects. Discover how resilient farming practices, including drought-resistant crops and gardening techniques, are the frontline defense in securing the nation's food supply during this climatic challenge.\"\n\n" +
                        "1. CROP SELECTION: Opt for drought-tolerant crop varieties such as sweet pepper, ubi, alugbati, mungbean, cassava, and sweet potato to withstand water scarcity.\n\n" +
                        "2. CONTROLLED IRRIGATION: Promote controlled irrigation methods like alternate wetting and drying (AWD) for rice farming to optimize water use and reduce greenhouse gas emissions.\n\n" +
                        "3. INTEGRATED FARMING: Embrace integrated farming systems like \"Palayamanan Plus,\" which combines rice cultivation with other crops and livestock to enhance resilience against prolonged drought.\n\n" +
                        "4. RAINFED LOWLAND RICE: Consider cultivating drought-resistant rice varieties like PSB Rc14, known as \"Rio Grande,\" which matures in 116 days and offers a maximum yield of 6.1 tons per hectare.\n\n" +
                        "5. SHALLOW TUBE WELLS: Distribute shallow tube wells to provide access to alternative water sources for farmers in severely affected areas.\n\n" +
                        "6. WATER-SAVING TECHNOLOGIES: Promote water-saving technologies that enhance irrigation efficiency and reduce water wastage, especially in rice fields.\n\n" +
                        "7. GREENHOUSE TECHNIQUES: Train farmers in the use of greenhouse technologies to protect crops from extreme weather conditions and maintain stable yields.\n\n" +
                        "8. EFFICIENT WATER ALLOCATION: Collaborate with irrigation associations to ensure the efficient allocation and utilization of water in irrigation systems.\n\n" +
                        "9. MONITORING AND INTERVENTION: Establish a task force to monitor and implement strategies that mitigate the impact of prolonged drought on agriculture and fisheries.\n\n" +
                        "10. RESILIENT FARMING PRACTICES: Educate farmers about diversified sources of food and income, enabling them to adapt to adverse weather conditions through resilient farming practices.\n\n",

                "https://www.benarnews.org/english/news/philippine/philippines-economy-04062019174245.html/190406-PH-El-Nino-1000.JPG/@@images/image",
                "https://www.officialgazette.gov.ph/2014/05/07/da-prepared-to-tackle-el-nino/#:~:text=Meanwhile%2C%20farmers%20who%20don't,saving%20technologies%20are%20also%20available."
            )
        )
        dataList.add(
            DataItem("RAINWATER HARVESTING TECHNIQUES",
                "\"Amidst the pressing challenge of water scarcity exacerbated by El Niño in the Philippines, innovative solutions emerge as beacons of hope. Explore the world of rainwater harvesting techniques and discover how this sustainable practice can offer vital relief during periods of water shortage.\"\n\n" +
                        "1. HARVESTING INFRASTRUCTURE: Invest in rainwater harvesting infrastructure, including collection ponds, tanks, and gutters, to capture and store rainwater efficiently.\n\n" +
                        "2. STORAGE CAPACITY: Ensure adequate storage capacity to hold a substantial volume of rainwater, allowing for use during extended periods of drought.\n\n" +
                        "3. FILTRATION SYSTEMS: Implement filtration systems to remove contaminants and debris from collected rainwater, ensuring its quality for various uses.\n\n" +
                        "4. WATER QUALITY TESTING: Regularly test the quality of harvested rainwater to confirm its safety for consumption and other applications.\n\n" +
                        "5. REUSE PLANNING: Develop a comprehensive plan for reusing harvested rainwater, including irrigation, sanitation, and other non-potable purposes.\n\n" +
                        "6. COMMUNITY INVOLVEMENT: Engage local communities in rainwater harvesting initiatives, fostering collective efforts to conserve water resources.\n\n" +
                        "7. EDUCATIONAL CAMPAIGNS: Launch educational campaigns to raise awareness about the benefits of rainwater harvesting and to encourage widespread adoption.\n\n" +
                        "8. REGULATORY COMPLIANCE: Adhere to local regulations and guidelines related to rainwater harvesting to ensure legal and safe practices.\n\n" +
                        "9. PERIODIC MAINTENANCE: Establish a regular maintenance schedule to clean and maintain the harvesting infrastructure for optimal functionality.\n\n" +
                        "10. MONITORING AND EFFICIENCY: Implement monitoring systems to track rainwater collection and usage, optimizing its efficiency and sustainability.",

                "https://5.imimg.com/data5/ZH/UO/HQ/SELLER-6136224/recharging-rainwater-harvesting-system-500x500.jpg",
                "https://balikas.net/rainwater-harvesting-solution-to-counter-el-nino/"
             )
        )

        dataList.add(
            DataItem("HEALTH AND HYGIENE IN DRY CONDITIONS",
                "Amidst the El Nino-induced drought in the Philippines, our 'El Nino Water, Sanitation, and Hygiene Initiative' offers life-changing solutions. From cutting-edge dry toilets to rainwater harvesting, we're combating water scarcity and disease in challenging dry conditions\"\n\n" +
                        "1. COMMUNITY ASSESSMENT: Conduct a thorough assessment of affected communities to identify areas with the greatest need for water, sanitation, and hygiene support.\n\n" +
                        "2. DRY TOILETS DEPLOYMENT: Distribute dry waterless toilets in areas where traditional flush toilets are rendered ineffective due to water scarcity, and promote their proper use and maintenance.\n\n" +
                        "3. HYGIENE KITS DISTRIBUTION: Provide hygiene kits to residents, including essential items like soap, hand sanitizers, and disinfectants, to promote good hygiene practices.\n\n" +
                        "4. WATER CONTAINER PROVISION: Distribute water containers to households, ensuring they have a means to store water for daily use and personal hygiene.\n\n" +
                        "5. EDUCATION AND TRAINING: Conduct training sessions and awareness programs on the proper use of dry toilets, handwashing, and personal hygiene to mitigate the spread of diseases.\n\n" +
                        "6. RAINWATER HARVESTING: Install giant rainwater collectors in preparation for rain, enabling communities to harvest and store water for future use.\n\n" +
                        "7. COMMUNITY HAND-WASHING STATIONS: Set up communal hand-wash stations to encourage regular hand hygiene practices among residents.\n\n" +
                        "8. PROMOTE WASTE REUSE: Educate and encourage beneficiaries to reuse human waste for agricultural purposes once water resources become available again.\n\n" +
                        "9. REGULAR MONITORING: Establish a monitoring system to track the effectiveness of dry toilets, hygiene practices, and rainwater harvesting, ensuring the long-term success of the initiative.\n\n" +
                        "10. SUSTAINABILITY PLANNING: Develop a sustainability plan to continue supporting communities in water, sanitation, and hygiene even beyond the El Nino crisis, helping them become more resilient to future challenges.",

                "https://www.makatimed.net.ph/wp-content/uploads/2021/01/1000-1-3.jpg",
                "https://www.globalgiving.org/projects/el-nino-water-sanitation-and-hygiene-initiative-1/"
              )
        )

        dataList.add(
            DataItem("COMMUNITY EFFORTS TO COMBAT EL NIÑO EFFECTS",
                "As El Niño looms over the Philippines, communities are uniting to combat its effects. Government agencies, led by the Department of Agriculture, are taking steps to secure the nation's food supply and enhance agricultural resilience.\"\n\n" +
                        "1. ASSESSMENT OF VULNERABLE AREAS: Conduct an assessment to identify areas vulnerable to El Niño's impact, focusing on agriculture and fisheries.\n\n" +
                        "2. INTER-AGENCY COLLABORATION: Establish inter-agency collaboration, involving key departments and organizations, to coordinate efforts to mitigate El Niño's effects.\n\n" +
                        "3. RESOURCE ALLOCATION: Allocate essential resources such as seeds, fertilizers, and other commodities to support farming communities in preparation for El Niño.\n\n" +
                        "4. INFORMATION DISSEMINATION: Develop and disseminate information, education, and communication materials to raise awareness about El Niño's potential impact and preventive measures.\n\n" +
                        "5. WATER MANAGEMENT: Implement proper water management strategies to conserve and optimize water resources in anticipation of drought conditions.\n\n" +
                        "6. RESOURCE PREPOSITIONING: Preposition necessary resources in areas likely to be severely affected by El Niño, ensuring swift response and relief.\n\n" +
                        "7. CROP DIVERSIFICATION: Promote crop diversification to reduce the risk associated with dependence on specific crops affected by El Niño.\n\n" +
                        "8. PLANTING CALENDAR ADJUSTMENT: Adjust planting calendars to align with expected El Niño conditions, optimizing crop growth.\n\n" +
                        "9. INPUT BUFFER STOCKING: Establish a buffer stock of essential agricultural inputs to mitigate supply chain disruptions during El Niño.\n\n" +
                        "10. PROMOTION OF RESILIENT CROPS: Encourage the cultivation of short-cycle and drought-tolerant crops to enhance agricultural resilience during dry spells.\n",

                "https://oxfam.org.ph/wp-content/uploads/2023/05/DSC_0310-1024x683.jpg",
                "https://www.pna.gov.ph/index.php/articles/1203047"
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