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

class SevenIslandSurvival : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven_island_survival_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "COASTAL NAVIGATION AND ISLAND-HOPPING:",
                "Embark on a journey through time and tides as we delve into the captivating world of 'Coastal Navigation and Island-Hopping' in the Philippines. Uncover the ancient secrets of indigenous seafarers and their remarkable techniques, guiding travelers safely through the archipelago's enchanting waters.\"\"\n\n" +
                        "1. CELESTIAL WAYFINDING: Learn the art of celestial navigation, where skilled seafarers use the position of stars, the sun, and other celestial bodies to determine their location and course.\n\n" +
                        "2. ENVIRONMENTAL CLUES: Discover how indigenous navigators read subtle environmental clues such as ocean currents, wind patterns, and bird migrations to steer their way across the archipelago.\n\n" +
                        "3. STAR COMPASSES: Explore the use of traditional star compasses, which incorporate specific stars and constellations as reference points to navigate accurately between islands.\n\n" +
                        "4. STICK CHARTS: Unearth the unique practice of creating stick charts, a traditional navigation tool used by seafaring communities to represent wave patterns and island locations.\n\n" +
                        "5. POLARIZED LIGHT NAVIGATION: Delve into the technique of polarized light navigation, where experienced sailors observe patterns in polarized light to detect the direction of the sun, even on cloudy days.\n\n" +
                        "6. WAYPOINT NAVIGATION: Understand the concept of using waypoints, significant natural landmarks and islands, to chart a safe course and navigate through intricate island chains.\n\n" +
                        "7. ORAL TRADITION AND STORYTELLING: Explore how indigenous communities pass down navigation knowledge through oral tradition and storytelling, preserving ancient techniques for future generations.\n\n" +
                        "8. SOUND AND ECHO NAVIGATION: Learn about the use of sound and echo navigation, where fishermen and navigators listen for underwater sounds and echoes to gauge their proximity to land or reefs.\n\n" +
                        "9. DEAD RECKONING: Discover the method of dead reckoning, which involves estimating a vessel's current position based on a previously known position and the course and speed of the boat.\n\n" +
                        "10. MODERN TOOLS WITH TRADITIONAL WISDOM: Understand the integration of modern navigational tools like GPS and compasses with the time-tested wisdom of indigenous navigation techniques, providing a comprehensive approach to island-hopping in the Philippines.",

                "https://tunatime.ph/cdn/shop/products/Tuna-Time-200-1024x1024.jpg?v=1662347138",
                "https://guides.library.manoa.hawaii.edu/c.php?g=105238&p=685462",

            )
        )
        dataList.add(
            DataItem("SUSTAINABLE FISHING TECHNIQUES:",
                "\"Explore the rich tapestry of fishing practices in this island nation, from time-honored methods to modern initiatives aimed at preserving marine life and ensuring a bountiful catch for generations to come.\n\n" +
                        "1. SELECTIVE FISHING GEAR: Utilize fishing gear that minimizes bycatch, such as turtle excluder devices and circle hooks, to target specific species and protect non-target marine life.\n\n" +
                        "2. LOCAL KNOWLEDGE SHARING: Promote the exchange of traditional fishing wisdom among local communities to ensure sustainable practices are passed down through generations.\n\n" +
                        "3. ECO-FRIENDLY BAIT: Opt for sustainable bait options, like artificial lures or locally-sourced bait, to reduce the impact on baitfish populations.\n\n" +
                        "4. CATCH AND RELEASE: Implement catch-and-release programs for vulnerable or overfished species to allow their populations to recover.\n\n" +
                        "5. MARINE PROTECTED AREAS: Support and respect marine protected areas that act as safe havens for fish populations to thrive and replenish.\n\n" +
                        "6. REDUCED GEAR IMPACT: Minimize gear impact on fragile ecosystems, such as coral reefs, by using lighter equipment that prevents habitat destruction.\n\n" +
                        "7. RESPONSIBLE SEAFOOD CERTIFICATION: Choose seafood products with certifications like the Marine Stewardship Council (MSC) to ensure they come from sustainable sources.\n\n" +
                        "8. BYCATCH REDUCTION DEVICES: Employ bycatch reduction devices like TEDs (Turtle Excluder Devices) and BRDs (Bycatch Reduction Devices) to release unintended catch unharmed.\n\n" +
                        "9. SEASONAL FISHING: Abide by seasonal fishing regulations to protect fish during their breeding and spawning seasons.\n\n" +
                        "10. EDUCATION AND AWARENESS: Engage in community education and awareness programs about sustainable fishing practices, encouraging responsible choices among local fishers and consumers.\n\n",

                "https://www.divescotty.com/images/pictures/blog/fishing/768/fishing-net-at-the-beach_768.jpg",
                "https://www.divescotty.com/underwater-blog/fishing-in-philippines.php#:~:text=Traditional%20Fishing%20in%20the%20Philippines&text=Spear%20guns%20are%20commonly%20used,fishing%20practice%20in%20the%20Philippines."
      )
        )
        dataList.add(
            DataItem("COCONUT UTILIZATION FOR SURVIVAL:",
                "\"\"Unlock the secrets of survival with nature's tropical treasure - the coconut. Imagine being marooned on a remote island, your only ally, the versatile coconut. In 'Coconut Utilization for Survival,' we explore how this wonder fruit can be your lifeline in challenging circumstances.\"\"\n\n" +
                        "1. COCONUT SELECTION: Choose mature coconuts that provide both water and meat, ensuring a balanced source of hydration and nutrition.\n\n" +
                        "2. OPENING COCONUTS: Master the skill of opening coconuts, whether they are young drinking nuts, mature nuts, or sprouting nuts.\n\n" +
                        "3. COCONUT WATER HARVESTING: Safely collect and store coconut water, a vital source of hydration rich in electrolytes.\n\n" +
                        "4. EXTRACTING COCONUT MEAT: Learn techniques to extract and prepare coconut meat for consumption, maximizing its nutritional value.\n\n" +
                        "5. IDENTIFYING SPROUTING COCONUTS: Recognize sprouting coconuts and utilize their carbohydrate-rich content for sustenance.\n\n" +
                        "6. AVOIDING COCONUT WATER PARADOX: Balance your coconut water consumption to stay hydrated without causing dehydration.\n\n" +
                        "7. SELECTING THE BEST COCONUTS: Choose coconuts that are heavy, contain enough water, and have dry eyes for optimal freshness.\n\n" +
                        "8. OPENING COCONUTS SAFELY: Safely open mature coconuts to access their meat and water, avoiding injury.\n\n" +
                        "9. COCONUT DERIVED PRODUCTS: Explore the use of coconut cream, milk, and oil for additional sustenance and practical purposes.\n\n" +
                        "10. SURVIVAL BALANCE: While coconuts are a valuable resource, remember to diversify your diet with other available foods and maintain a balanced approach to survival.\n\n",

                "https://images.surferseo.art/c9412812-9b0e-426e-b2d3-e2dc3142bcd7.jpeg",
                "https://www.desertislandsurvival.com/surviving-on-coconut/"
              )
        )

        dataList.add(
            DataItem("TRADITIONAL MEDICINE AND HEALING PLANTS:",
                "\"Unlock the ancient wisdom of traditional medicine and delve into the remarkable world of healing plants. In the lush highlands of Panay Island, Philippines, the indigenous Panay Bukidnon have harnessed the power of nature's remedies for generations, offering a unique glimpse into the secrets of traditional healing practices.\"\n\n\n" +
                        "1. COMMUNITY ENGAGEMENT: Establish a strong connection with the indigenous community, gaining their trust and understanding their traditional healthcare practices.\n\n" +
                        "2. KEY INFORMANT SELECTION: Identify knowledgeable individuals within the community, including traditional healers and elders, who can provide insights into the use of medicinal plants.\n\n" +
                        "3. STRUCTURED INTERVIEWS: Conduct structured interviews with key informants to document the names, preparation methods, and uses of medicinal plants.\n\n" +
                        "4. BOTANICAL COLLECTION: Collect plant samples with the assistance of informants, making sure to properly document their growth habits, locations, and any endemic species.\n\n" +
                        "5. PHOTOGRAPHIC DOCUMENTATION: Take clear photographs of the medicinal plants in their natural habitat for further reference and documentation.\n\n" +
                        "6. PLANT IDENTIFICATION: Use reliable online databases and consult with botanists to accurately identify the collected plant species.\n\n" +
                        "7. QUANTIFY PLANT IMPORTANCE: Apply various measures such as Use Value (UV), Relative Frequency of Citation (RFC), and Relative Importance Index (RI) to assess the significance of each medicinal plant.\n\n" +
                        "8. CONSENSUS ASSESSMENT: Evaluate the consensus among informants by calculating the Informant Consensus Factor (ICF) for different disease categories or use types.\n\n" +
                        "9. PREFERENCE ANALYSIS: Determine the most preferred medicinal plants for specific disease categories by calculating the Fidelity Level (FL).\n\n" +
                        "10. CULTURAL PRESERVATION: Use the collected data as a medium for preserving cultural heritage, aiding ethnopharmacological research, and contributing to the preservation of biological diversity.\n",

                "https://i0.wp.com/images-prod.healthline.com/hlcmsresource/images/topic_centers/Food-Nutrition/1296x728_Holy_Basil.jpg?w=1155&h=1528",
                "https://www.frontiersin.org/articles/10.3389/fphar.2021.790567/full"
              )
        )

        dataList.add(
            DataItem("ISLAND COMMUNITY COOPERATION:",
                "In the heart of the Philippines, an inspiring narrative unfolds – one of island communities coming together, fortified by resilience, and poised for disaster preparedness. Explore the story of 'Island Community Cooperation,' where unity and readiness stand as their shield against nature's unpredictability.\"\n\n\n" +
                        "1. COMMUNITY NEEDS ASSESSMENT: Begin by conducting a thorough assessment of the specific needs of each island community, taking into account their geographical location, vulnerabilities, and past disaster experiences.\n\n" +
                        "2. FORMATION OF LOCAL TASK FORCES: Establish local task forces consisting of community leaders, volunteers, and relevant experts to coordinate disaster preparedness and response efforts.\n\n" +
                        "3. CUSTOMIZED DISASTER PREPAREDNESS PLANS: Develop tailored disaster preparedness plans for each island community, considering their unique challenges and available resources.\n\n" +
                        "4. EDUCATION AND TRAINING: Implement educational programs and training sessions to equip community members with essential knowledge and skills for disaster response, including first aid, evacuation procedures, and communication.\n\n" +
                        "5. RESOURCE STOCKPILING: Ensure each island community has a stockpile of essential resources, including food, water, medical supplies, and communication tools, to sustain them during and after disasters.\n\n" +
                        "6. EARLY WARNING SYSTEMS: Establish effective early warning systems, which could include sirens, mobile alerts, or community liaisons, to ensure timely communication of disaster threats.\n\n" +
                        "7. EVACUATION PLANS: Develop evacuation plans with designated safe zones and evacuation routes, taking into account the community's topography and infrastructure.\n\n" +
                        "8. COMMUNITY DRILLS: Regularly conduct disaster preparedness drills, involving all community members, to practice response procedures and enhance coordination.\n\n" +
                        "9. COLLABORATION AND MUTUAL SUPPORT: Foster collaboration between island communities, promoting mutual support in times of crisis, such as sharing resources, personnel, and knowledge.\n\n" +
                        "10. CONTINUOUS MONITORING AND ADAPTATION: Implement a system for continuous monitoring of disaster risks and community readiness, regularly adapting plans based on lessons learned and changing conditions.",

                "https://adra.ph/wp-content/uploads/2020/06/DRR-Kits-Turnover-Levy-1024x683.jpg",
                "https://opengovasia.com/strengthening-disaster-resilience-and-preparedness-in-the-philippines/"
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