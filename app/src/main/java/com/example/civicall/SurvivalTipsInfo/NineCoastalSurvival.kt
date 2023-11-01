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

class NineCoastalSurvival : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nine_coastal_survival_info)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "SAFE COASTAL NAVIGATION TECHNIQUES",
                "Navigating the coastal waters presents a unique challenge for mariners, requiring a keen understanding of both traditional techniques and modern technologies. From ancient sextant angles to cutting-edge GPS systems, coastal navigation is a dynamic blend of old-world wisdom and cutting-edge precision.\"\"\n\n" +
                        "1. CHART INTERPRETATION: Begin by analyzing nautical charts, identifying landmarks, lighthouses, and buoys crucial for coastal navigation.\n\n" +
                        "2. LAND BEARINGS: Use a compass to take bearings of prominent onshore objects, transferring these angles to the chart to establish your vessel's position.\n\n" +
                        "3. RUNNING FIXES: In areas with limited identifiable landmarks, utilize running fixes by recording multiple bearings and projecting your position as you proceed.\n\n" +
                        "4. VERTICAL SEXTANT ANGLES: Measure the vertical angle to a known object, like a lighthouse, to determine your distance from the shore.\n\n" +
                        "5. HORIZONTAL SEXTANT ANGLES: Calculate position lines by measuring horizontal angles between two visible objects, helping you pinpoint your location as their arcs intersect.\n\n" +
                        "6. GPS NAVIGATION: Incorporate the accuracy and flexibility of GPS for precise positioning in coastal waters, using satellite signals to your advantage.\n\n" +
                        "7. RADAR ASSISTANCE: Rely on radar when visibility is compromised, using it to obtain bearings and ranges to known objects, even though ranges may be less accurate.\n\n" +
                        "8. MONITORING BUOYS: While buoys can be helpful, never rely on them completely; remember that they might shift from their moorings.\n\n" +
                        "9. TIDE CONSIDERATION: Factor in the influence of tides and currents on your vessel's course, ensuring accurate navigation along the coastline.\n\n" +
                        "10. CONTINUOUS MONITORING: Continuously update your position as you navigate, employing a combination of traditional methods and modern technology to ensure safe and efficient coastal navigation.",

                "https://cdn.britannica.com/09/93609-050-6773B246/Officers-passenger-ship-charts-navigation.jpg",
                "https://www.oxfordreference.com/display/10.1093/oi/authority.20110803095620181#:~:text=Satellite%20navigation%20systems%20such%20as,less%20accurate%20than%20the%20ranges)."

            )
        )
        dataList.add(
            DataItem("BUILDING COASTAL SHELTERS",
                "\"Designing shelters for coastal environments is a delicate art and science. This article explores the essential elements of creating structures that harmonize with the coastal surroundings while standing strong against nature's forces.\n\n" +
                        "1. SITE ASSESSMENT: Begin with a comprehensive evaluation of the coastal site, considering factors like flood zones, wind exposure, and proximity to the shoreline.\n\n" +
                        "2. MATERIAL SELECTION: Choose materials that are corrosion-resistant and capable of withstanding the harsh coastal environment, including salt spray and humidity.\n\n" +
                        "3. NATURAL LIGHT INTEGRATION: Design shelters with ample access to natural light, utilizing features like skylights and high windows to create a bright and airy atmosphere.\n\n" +
                        "4. INDOOR-OUTDOOR CONNECTIVITY: Foster a seamless connection between indoor and outdoor spaces, incorporating elements like outdoor kitchens and decks for residents to enjoy the coastal surroundings.\n\n" +
                        "5. ELEVATED CONSTRUCTION: Consider elevating structures to mitigate flood risks, especially in areas prone to occasional flooding.\n\n" +
                        "6. WIND-RESISTANT DESIGN: Design structures to deflect and withstand powerful coastal winds, ensuring safety and comfort for occupants.\n\n" +
                        "7. SUSTAINABLE LANDSCAPING: Incorporate sustainable landscaping with native plants and trees to enhance the coastal atmosphere and protect against erosion.\n\n" +
                        "8. FLOOD ZONE COMPLIANCE: Adhere to building codes and standards for flood-prone areas, including additional ties, straps, anchors, and elevated structures.\n\n" +
                        "9. OUTDOOR SPACE PROTECTION: Safeguard outdoor spaces from the elements by using weatherproof materials and proper maintenance to prevent corrosion and damage.\n\n" +
                        "10. RESPECTFUL AESTHETICS: Prioritize aesthetics that respect the natural surroundings, blending architecture with the coastal landscape for a harmonious and visually appealing shelter design.",

                "https://www.bworldonline.com/wp-content/uploads/2022/01/Odette-reconstruction-easternvisayas-PHILIPPINE-ARMY.jpg",
                "https://www.re-thinkingthefuture.com/rtf-fresh-perspectives/a2106-10-things-to-remember-while-designing-in-coastal-areas/"
          )
        )
        dataList.add(
            DataItem("FISHING AND GATHERING COASTAL RESOURCES",
                "Discover the art of sustainable coastal fishing in the Philippines, where tradition and innovation unite. From ancient spearfishing techniques to innovative resource conservation methods, we unveil the essence of sustainable coastal fishing.\n\n" +
                        "1. COMMUNITY-BASED RESOURCE MANAGEMENT: Engage coastal communities in managing their local fishing resources. Establish community-led initiatives for sustainable fishing practices and resource conservation.\n\n" +
                        "2. SEASONAL FISHING PRACTICES: Promote seasonal fishing patterns that align with the natural breeding and migration cycles of marine species. This helps maintain healthy fish populations.\n\n" +
                        "3. FISH SANCTUARIES: Create designated fish sanctuaries within coastal waters to serve as protected breeding and nursery grounds for fish and other marine life.\n\n" +
                        "4. ECO-FRIENDLY GEAR AND TECHNIQUES: Encourage the use of sustainable fishing gear and methods, such as hook-and-line fishing, which reduces bycatch and minimizes environmental impact.\n\n" +
                        "5. MANGROVE REFORESTATION: Implement mangrove reforestation projects to protect coastal areas and provide habitat for various marine species, including juvenile fish.\n\n" +
                        "6. REGULATION AND MONITORING: Establish regulations for fishing activities, including size limits and catch quotas. Implement monitoring systems to ensure compliance.\n\n" +
                        "7. EDUCATION AND TRAINING: Provide education and training programs for local fishermen on sustainable fishing practices, resource management, and ecosystem conservation.\n\n" +
                        "8. RESTOCKING INITIATIVES: Support restocking programs for threatened or overexploited species, helping to replenish their populations.\n\n" +
                        "9. REDUCING PLASTIC POLLUTION: Raise awareness about the importance of reducing plastic pollution in coastal areas to protect marine ecosystems.\n\n" +
                        "10. COLLABORATIVE RESEARCH: Encourage collaborative research efforts between local communities, scientists, and environmental organizations to develop innovative, sustainable fishing techniques and conservation strategies.\n\n",

                "https://www.divescotty.com/images/pictures/blog/fishing/768/aquaculture_768.jpg",
                "https://www.divescotty.com/underwater-blog/fishing-in-philippines.php#:~:text=Marine%20Capture%20Fisheries%20in%20the%20Philippines&text=The%20group%20of%20fishers%20uses,bodies%20of%20water%2C%20etc.)"
            )
        )

        dataList.add(
            DataItem("WATER PURIFICATION BY THE SEA",
                "\"Unveiling Pristine Waters: Coastal Secrets to Pure Sips - Discover the Philippines' coastal wonders and sustainable technologies, where we explore natural filtration methods, revealing a source of pristine, drinkable water by the sea.\"\n\n\n" +
                        "1. ECO-FRIENDLY FILTRATION SYSTEMS: Implement cutting-edge eco-friendly filtration systems that harness natural materials like sand, gravel, and aquatic plants to naturally filter seawater, ensuring the removal of impurities.\n\n" +
                        "2. TIDAL ENERGY DESALINATION: Develop desalination technologies that utilize tidal energy to power the filtration process, making it a sustainable and energy-efficient approach to obtain pure water.\n\n" +
                        "3. MANGROVE RESTORATION: Promote mangrove reforestation along coastlines, as mangroves act as natural filters, improving water quality by trapping sediments and pollutants.\n\n" +
                        "4. SOLAR DISTILLATION: Harness the abundant sunlight in coastal areas to power solar distillation systems that evaporate seawater and condense it into fresh, pure drinking water.\n\n" +
                        "5. WAVE-POWERED FILTRATION: Innovate wave-powered filtration devices that harness the kinetic energy of waves to drive the water through natural filtering materials, ensuring a constant supply of clean water.\n\n" +
                        "6. SEASHELL FILTRATION: Explore the potential of seashell-based filtration systems, as they have shown promise in adsorbing contaminants and heavy metals from seawater.\n\n" +
                        "7. FLOATING WETLANDS: Develop floating wetlands using native aquatic plants, creating natural filtration islands that enhance water quality and promote biodiversity.\n\n" +
                        "8. BEACH CLEANUP INITIATIVES: Encourage regular beach cleanup programs to remove plastics and debris that can degrade coastal water quality, keeping the sea and shores cleaner.\n\n" +
                        "9. SALINITY GRADIENT POWER: Investigate salinity gradient power generation, which simultaneously produces renewable energy while desalinating seawater.\n\n" +
                        "10. COMMUNITY EDUCATION: Conduct educational programs within coastal communities to raise awareness about the importance of natural filtration methods, fostering community involvement in preserving their coastal water resources.\n",

                "https://www.aquatech.com/wp-content/uploads/pps26-img2-e1426078487797.jpg",
                "https://www.ctc-n.org/technologies/seawater-desalination#:~:text=Evaporation%3A%20A%20method%20to%20obtain,through%20which%20seawater%20cannot%20pass."
              )
        )

        dataList.add(
            DataItem("COMMUNITY COOPERATION IN COASTAL AREAS",
                "Amidst the ebb and flow of challenges in the coastal Asia Pacific, a beacon of hope shines through community cooperation. As coastal communities face economic shocks, natural hazards, and environmental shifts, they are forging resilience through collective action, creating a brighter, more sustainable future by working hand in hand.\"\n\n\n" +
                        "1. COMMUNITY NEEDS ASSESSMENT: Begin with a comprehensive assessment of the unique needs and vulnerabilities of coastal communities, involving local residents and stakeholders.\n\n" +
                        "2. MULTI-LEVEL COLLABORATION: Foster partnerships between local communities, governmental bodies, and non-governmental organizations, ensuring a coordinated approach.\n\n" +
                        "3. COMMUNITY CLUSTERS: Create community clusters or associations for mutual support and shared decision-making among fisherfolk, farmers, and residents.\n\n" +
                        "4. CUSTOMIZED SPATIAL PLANNING: Develop spatial plans tailored to each coastal area's challenges, including land access and tenure.\n\n" +
                        "5. WATER RESOURCE MANAGEMENT: Prioritize sustainable water resource management, addressing issues like water shortages in Pacific Islands.\n\n" +
                        "6. FOOD SECURITY FOCUS: Focus on policies and research for food security among fishing-based households, addressing disruptions in value chains.\n\n" +
                        "7. DIVERSE LIVELIHOODS: Encourage diverse, sustainable livelihood options suited to the local ecology.\n\n" +
                        "8. STRUCTURAL DRIVERS RECOGNITION: Address the complex structural factors influencing coastal livelihoods.\n\n" +
                        "9. LONG-TERM RESILIENCE PLANNING: Develop a long-term strategy for resilience to counter short-term interventions.\n\n" +
                        "10. COMMUNITY-LED ADAPTATION: Empower coastal communities to lead their own adaptation efforts, leveraging local knowledge and solutions.",

                "https://mb.com.ph/wp-content/uploads/2022/03/73579.jpeg",
                "https://www.eastasiaforum.org/2020/11/25/building-resilient-coastal-communities-in-the-asia-pacific/"
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