package com.example.civicall.SurvivalTipsInfo

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

class ThreeTyphoon : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_typhoon_info)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "COMMUNITY TYPHOON PREPAREDNESS MEASURES",
                "\"In the Philippines, where breathtaking beauty meets the relentless power of typhoons, community resilience becomes paramount. Join us in exploring the essential measures for bolstering our defenses against nature's fury.\"\"\n\n" +
                        "1. BUILD AN EMERGENCY KIT: Assemble essential supplies including non-perishable food, water, first-aid supplies, flashlights, and more to sustain your family during and after a typhoon.\n\n" +
                        "2. CREATE A FAMILY COMMUNICATIONS PLAN: Develop a comprehensive plan with meeting points, contact information, and emergency contacts, ensuring everyone stays connected during the storm.\n\n" +
                        "3. KNOW YOUR SURROUNDINGS: Familiarize yourself with your local area, including the elevation level of your property and its susceptibility to flooding during storm surges or heavy rainfall.\n\n" +
                        "4. IDENTIFY LEVEES AND DAMS: Determine the location and condition of nearby levees and dams, assessing whether they pose any risks to your community during a typhoon.\n\n" +
                        "5. LEARN EVACUATION ROUTES: Understand the community typhoon evacuation routes and methods to reach higher ground, creating a clear plan for evacuating if necessary.\n\n" +
                        "6. SECURE YOUR PROPERTY: Prepare your home by installing permanent storm shutters or boarding up windows with marine plywood, ensuring your roof is securely fastened to reduce damage, and trimming trees and shrubs for improved wind resistance.\n\n" +
                        "7. CLEAR GUTTERS AND DOWNSPOUTS: Prevent water buildup by clearing loose and clogged rain gutters and downspouts, reducing the risk of flooding.\n\n" +
                        "8. REINFORCE GARAGE DOORS: Strengthen garage doors to prevent wind from causing structural damage, safeguarding not only your property but also the safety of residents.\n\n" +
                        "9. SECURE OUTDOOR ITEMS: Bring in or secure outdoor furniture, decorations, and loose objects that can become dangerous projectiles during a typhoon.\n\n" +
                        "10. BOAT AND HIGH-RISE BUILDING PREPARATIONS: Determine how to secure boats and, if residing in a high-rise building, be prepared to seek shelter on or below the 10th floor in case of severe weather.\n\n",

                "https://www.worldbank.org/content/dam/photos/780x439/2016/may-26/vn-communitybased-disasterrisk-780x439.jpg",
                "http://typhoonmanila.weebly.com/typhoon-preparedness.html"

            )
        )
        dataList.add(
            DataItem("ASSEMBLING A TYPHOON EMERGENCY KIT FOR RESIDENTIAL AREAS",
                "\"Typhoons are an ever-present reality in the Philippines, making it essential for residents to be prepared to weather the storm. In this guide, we'll explore the art of assembling a life-saving Typhoon Emergency Kit specifically designed for residential areas, ensuring you're ready to face the tempest head-on.\"\n\n" +
                        "1. WATER AND FOOD SUPPLY: Ensure an ample supply of clean drinking water and non-perishable food items to sustain your household for at least two weeks in case of extended power outages and limited access to supplies.\n\n" +
                        "2. BATTERY-POWERED RADIO: Have a battery-powered or hand-crank radio on hand to stay informed about typhoon updates, evacuation orders, and vital information during power outages.\n\n" +
                        "3. FLASHLIGHTS AND EXTRA BATTERIES: Prepare battery or solar-powered flashlights and a stock of extra batteries to provide essential lighting when power is lost.\n\n" +
                        "4. EMERGENCY TOOLS: Include a basic toolkit with a wrench, pliers, and a can opener to address various needs, from home repairs to accessing canned goods.\n\n" +
                        "5. FIRST AID KIT: Assemble a comprehensive first aid kit with necessary supplies, including bandages, antiseptic solutions, and essential medical tools to address injuries and health concerns.\n\n" +
                        "6. IMPORTANT DOCUMENTS: Safeguard critical family documents such as birth certificates, insurance policies, and property deeds in waterproof storage, ensuring they are readily accessible in case of evacuation.\n\n" +
                        "7. HYGIENE SUPPLIES: Pack personal hygiene items, such as toothbrushes, soap, hand sanitizer, and feminine hygiene products, in sealed, waterproof bags for cleanliness during emergencies.\n\n" +
                        "8. FACE MASKS: Include protective face masks, which are not only vital during a pandemic but also useful for filtering contaminated air in the event of fires or poor air quality.\n\n" +
                        "9. WHISTLE: Equip your kit with a whistle to signal for help or alert rescuers to your location with a sound that can carry in adverse conditions.\n\n" +
                        "10. PLASTIC SHEETING AND DUCT TAPE: Prepare plastic sheeting and duct tape to create makeshift shelters or address leaks, ensuring your family's safety and comfort during typhoon-related evacuations or incidents.\n\n",

                "https://japantoday-asset.scdn3.secure.raxcdn.com/img/store/ad/d9/7f9182505a60ccea40d04dbdfc7de7e99115/dk-18/_w850.png",
                "https://www.lumina.com.ph/news-and-blogs/blogs/typhoon-ready-tools-to-include-in-your-emergency-kit/"
               )
        )
        dataList.add(
            DataItem("EVACUATION STRATEGIES AND SAFE ZONES DURING TYPHOONS",
                "\"Explore the vital strategies for effective evacuations and the identification of safe zones during typhoons in our comprehensive guide, ensuring you're ready to weather the storm with confidence.\"\n\n" +
                        "1. STAY INFORMED: Continuously monitor official weather reports and updates to know when a typhoon is approaching and to receive evacuation advisories.\n\n" +
                        "2. KNOW YOUR EVACUATION ROUTE: Familiarize yourself with the designated evacuation routes in your area and the location of nearby emergency shelters.\n\n" +
                        "3. CREATE A FAMILY EVACUATION PLAN: Develop a detailed plan with your family that includes a meeting point, contact information, and procedures to follow in case you get separated during evacuation.\n\n" +
                        "4. PREPARE AN EMERGENCY KIT: Assemble a well-stocked emergency kit with essentials like food, water, first-aid supplies, flashlights, and personal documents.\n\n" +
                        "5. SECURE YOUR HOME: Before evacuating, ensure your home is as secure as possible by reinforcing doors and windows and moving valuable items to higher ground.\n\n" +
                        "6. FOLLOW OFFICIAL INSTRUCTIONS: Always adhere to evacuation orders issued by local authorities. Delaying evacuation can be dangerous.\n\n" +
                        "7. STAY IN SAFE ZONES: When evacuating, head to designated safe zones or emergency shelters. Avoid low-lying areas, riverbanks, and coastal regions.\n\n" +
                        "8. KEEP COMMUNICATION DEVICES CHARGED: Ensure your mobile phones and other communication devices are fully charged before evacuating. Consider bringing portable chargers.\n\n" +
                        "9. STAY CALM AND INFORMED: While in a safe zone, stay updated on typhoon developments through battery-operated radios or mobile apps. Stay calm and follow instructions from authorities.\n\n" +
                        "10. ASSIST OTHERS: Look out for neighbors, especially the elderly, disabled, or those with special needs, and offer assistance in evacuating to ensure the safety of your community.",

                "https://www.rappler.com/tachyon/2022/07/evacuation-center-tanauan-city-taal.jpg",
                "https://www.moneymax.ph/lifestyle/articles/typhoon-in-the-philippines#:~:text=Evacuate%20immediately%20and%20calmly%E2%80%94if,your%20family%20during%20a%20typhoon."
            )
        )

        dataList.add(
            DataItem("REBUILDING COMMUNITIES AND RESTORING LIVELIHOODS AFTER TYPHOON ",
                "\"In the wake of a devastating typhoon, the Philippines exemplified resilience and recovery, illuminating a path to hope and income for affected families.\"\n\n\n" +
                        "1. SAFETY ASSESSMENT: Begin by conducting a safety assessment of the affected areas to identify potential hazards and ensure safe cleanup efforts.\n\n" +
                        "2. DEBRIS CLEARING: Organize teams to clear debris from roads, homes, and public spaces, and properly dispose of damaged materials.\n\n" +
                        "3. TEMPORARY SHELTER: Provide temporary shelter for families who lost their homes during the typhoon to ensure their safety and well-being.\n\n" +
                        "4. FOOD AND WATER DISTRIBUTION: Ensure that affected communities have access to clean drinking water and emergency food supplies through efficient distribution channels.\n\n" +
                        "5. MEDICAL AID: Set up temporary medical clinics to provide first aid and essential healthcare to those injured or in need.\n\n" +
                        "6. RESTORING INFRASTRUCTURE: Focus on rebuilding critical infrastructure such as roads, bridges, and schools to expedite the return to normalcy.\n\n" +
                        "7. PSYCHOSOCIAL SUPPORT: Offer psychosocial support and counseling services to help individuals and families cope with trauma and loss.\n\n" +
                        "8. LIVELIHOOD SUPPORT: Initiate programs to restore livelihoods, especially for those who lost their sources of income during the typhoon.\n\n" +
                        "9. COMMUNITY MOBILIZATION: Encourage affected communities to actively participate in the recovery process, fostering a sense of ownership and empowerment.\n\n" +
                        "10. PREPAREDNESS FOR THE FUTURE: Educate communities on disaster preparedness, including creating emergency plans, assembling disaster kits, and understanding early warning systems to enhance resilience for future typhoon seasons.",

                "https://reliefweb.int/sites/default/files/styles/large/public/images/reports/f1/65/f1655928-79de-30d0-a0db-5308bb534939.jpg.webp",
                "https://reliefweb.int/report/philippines/after-philippines-typhoon-clean-brings-recovery"
              )
        )

        dataList.add(
            DataItem("UNDERSTANDING THE IMPORTANCE OF LOCAL TYPHOON PREPAREDNESS INITIATIVES",
                "In the storm-prone regions of the Philippines, resilience is forged through preparedness. Explore how local typhoon preparedness initiatives serve as the backbone of community survival and recovery in the face of nature's fury.\"" +
                        "1. EARLY WARNING SYSTEMS: Implement robust early warning systems that provide timely information about approaching typhoons, enabling residents to prepare and evacuate promptly.\n" +
                        "2. COMMUNITY-BASED TRAINING: Conduct regular disaster preparedness training sessions within local communities, ensuring that residents are well-informed about safety measures and response strategies.\n" +
                        "3. SAFE EVACUATION PLANS: Develop and communicate clear evacuation plans, indicating the nearest shelters, escape routes, and assembly points to maximize safety during typhoons.\n" +
                        "4. FOOD AND RESOURCE STOCKPILING: Encourage households to maintain emergency supplies, such as canned food, clean water, first-aid kits, flashlights, and essential items, in preparation for extended periods of isolation.\n" +
                        "5. HOME REINFORCEMENT: Train residents on securing their homes against strong winds, heavy rainfall, and potential flooding to minimize structural damage.\n" +
                        "6. EMERGENCY EQUIPMENT: Promote the importance of emergency kits, including radios, batteries, clothing, and other necessities, to facilitate immediate response and communication during and after a typhoon.\n" +
                        "7. COMMUNITY COORDINATION: Foster collaborative efforts within the community by appointing local leaders to coordinate preparedness activities and ensure a swift and organized response.\n" +
                        "8. VULNERABLE GROUPS INCLUSION: Pay special attention to the needs of vulnerable groups such as senior citizens, widowers, and children, providing them with tailored training and assistance.\n" +
                        "9. CAPACITY BUILDING: Continuously enhance the skills and knowledge of community members to cope with various types of disasters, including tsunamis, earthquakes, and fires.\n" +
                        "10. EMERGENCY PAILS: Encourage households to maintain fully equipped emergency pails, which contain essential items for survival and can be vital during emergencies, such as typhoons and their aftermath.\n",

                "https://static.wixstatic.com/media/cb2848_1b465fe4ebf3412c91ea6c0396b63002~mv2.jpg/v1/fit/w_2500,h_1330,al_c/cb2848_1b465fe4ebf3412c91ea6c0396b63002~mv2.jpg",
                "https://reliefweb.int/report/philippines/value-disaster-preparedness"
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