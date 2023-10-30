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

class TsunamiInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tsunami_info)






        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "TSUNAMI WARNING SYSTEMS AND ALERTS",
                "Prepare for the unexpected as we dive into the heart of tsunami readiness in the Philippines. Discover the cutting-edge warning systems and rapid-alert mechanisms that stand guard against the unpredictable wrath of seismic sea waves.\"\"\n\n" +
                        "1. STAY INFORMED: Keep yourself updated with the latest information from official sources, such as the Philippine Institute of Volcanology and Seismology (Phivolcs), regarding earthquake activity and tsunami warnings.\n\n" +
                        "2. RECOGNIZE NATURE'S SIGNS: Be aware of natural signs like ground shaking, sudden sea-level changes, and unusual sounds from the sea, which can indicate an impending tsunami. Act quickly if you notice these warning signs.\n\n" +
                        "3. REACT IMMEDIATELY: In the event of an earthquake, particularly if it occurs near the coast, don't wait for official alerts. Head to high ground or inland areas as fast as possible. Time is of the essence.\n\n" +
                        "4. WORLD TSUNAMI AWARENESS DAY (WTAD): Participate in tsunami awareness events and initiatives, like those organized by Phivolcs on World Tsunami Awareness Day (WTAD) on November 5th. Learn about the risks and preparedness measures.\n\n" +
                        "5. KNOW VULNERABLE AREAS: Familiarize yourself with the coastal areas that are most vulnerable to tsunamis. Understand the potential risks in your region.\n\n" +
                        "6. MAGNITUDE AND DEPTH: Pay attention to earthquake reports, especially those with a magnitude of 6.5 or stronger and occurring at depths of up to 100 km, as these can trigger tsunamis.\n\n" +
                        "7. MONITOR PHIVOLCS' ADVISORIES: Stay tuned to Phivolcs' tsunami advisories and alerts. These are critical for receiving official information about tsunami threats.\n\n" +
                        "8. EDUCATE YOURSELF: Understand the Sendai Framework for Disaster Risk Reduction, which aims to reduce economic losses from disasters. Learning about this framework can help you better prepare for tsunamis.\n\n" +
                        "9. EARLY WARNING SYSTEMS: Familiarize yourself with the early warning systems in your area. Know how to access and interpret alerts from these systems.\n\n" +
                        "10. LEARN FROM HISTORY: Study past tsunami incidents in the Philippines, such as the 1976 Cotabato Trench tsunami. Understanding historical events can provide valuable insights into preparedness.\n\n",

                R.drawable.img_191,
                "https://www.preventionweb.net/news/philippines-heed-natures-tsunami-warnings-expert#:~:text=Ground%20shaking%20due%20to%20tsunami,and%20Seismology%20(Phivolcs)%20science%20research",
                "https://go.rappler.com/images/tsunami-warning-system01-carousel-20131030.jpg"
            )
        )
        dataList.add(
            DataItem("IDENTIFYING HIGH GROUND AND SAFE ZONES",
                "\"Unlocking the Secret to Survival: Navigating Tsunami Risks in the Philippines. Delve into the unseen dangers lurking beneath the serene coastal landscapes of Puerto Princesa City, Palawan, and discover how identifying high ground and safe zones can be the key to outsmarting nature's fury.\n\n" +
                        "1. KNOW YOUR RISK: Understand that even in seemingly low-risk coastal areas, tsunamis can pose a threat. Recognize that the perception of safety may not always align with the actual risk.\n\n" +
                        "2. STAY INFORMED: Keep updated with official sources and scientific data regarding potential hazards, including tsunamis. Trust expert assessments rather than relying solely on local perceptions.\n\n" +
                        "3. RECOGNIZE WARNING SIGNS: Familiarize yourself with warning signs, such as unusual sea behavior, tremors, or official tsunami alerts. Don't ignore these indicators, even if you believe your area is safe.\n\n" +
                        "4. RAPID RESPONSE: In the event of an earthquake or tsunami warning, act swiftly. Head to higher ground or safe zones without delay. Tsunamis can strike within minutes of an earthquake.\n\n" +
                        "5. COMMUNITY EDUCATION: Promote disaster awareness and educate your community about potential hazards, especially if there hasn't been a recent disaster event. Share knowledge about past incidents in other regions to emphasize preparedness.\n\n" +
                        "6. UNDERSTAND HAZARDS: Learn about the specific hazards your community faces, whether it's storm surges, tsunamis, or other coastal threats. Knowledge is a powerful tool for preparedness.\n\n" +
                        "7. SURVEY TOPOGRAPHY: Conduct topographical surveys to identify the elevation levels in your area. Determine how high a storm surge or tsunami could reach and plan evacuation routes accordingly.\n\n" +
                        "8. ENGAGE LOCAL AUTHORITIES: Collaborate with local government and community leaders to enhance disaster response capabilities. Ensure efficient coordination and communication channels are in place.\n\n" +
                        "9. GIS TOOLS: Utilize Geographic Information System (GIS) tools to map out hazard-prone areas and safe zones. Use technology to facilitate disaster risk reduction strategies.\n\n" +
                        "10. PREPARE FOR THE FUTURE: Recognize that climate change can alter hazard patterns. Plan for the long term by considering potential shifts in risk and the effects of increased population density on vulnerability.\n\n",
                R.drawable.img_192,
                "https://dims.apnews.com/dims4/default/9fd69be/2147483647/strip/false/crop/3000x1688+0+157/resize/1200x675!/quality/90/?url=https%3A%2F%2Fstorage.googleapis.com%2Fafs-prod%2Fmedia%2Fffbb49222e6f487fb0fab44283e8a8c1%2F3000.jpeg",
                "https://i.ytimg.com/vi/qR3C6nJeYOs/maxresdefault.jpg")
        )
        dataList.add(
            DataItem("IMMEDIATE TSUNAMI RESPONSE",
                "\"Dive into the Depths of Survival: Mastering Immediate Tsunami Response Strategies. Uncover the crucial steps to safeguarding lives and property when faced with the relentless force of a tsunami in this comprehensive guide.\"\n\n" +
                        "1. NATURAL WARNING SIGNS: Pay attention to natural indicators like strong or prolonged earthquakes, sudden changes in water levels, and unusual water noises. If any of these signs occur, take immediate action.\n\n" +
                        "2. EARTHQUAKE SAFETY: During an earthquake, drop, cover, and hold to protect yourself. Once the shaking stops, act swiftly.\n\n" +
                        "3. SWIFT EVACUATION: If you feel a strong or prolonged earthquake, or observe any natural warning signs, don't wait for official warnings. Move immediately to the nearest high ground or as far inland as possible.\n\n" +
                        "4. EFFICIENT TRANSPORTATION: If evacuating, walk, run, or cycle if possible. This reduces the risk of getting stuck due to damaged roads or traffic congestion. Use vehicles only if necessary.\n\n" +
                        "5. AWARENESS OF HAZARDS: While evacuating, stay alert to other hazards such as damaged powerlines, bridges, liquefaction, and landslides, which may result from a large local earthquake.\n\n" +
                        "6. OFFICIAL TSUNAMI WARNINGS: Pay attention to official tsunami warnings issued by relevant authorities. These warnings will provide critical information and guidance.\n\n" +
                        "7. STAY INFORMED: Listen to the radio and/or TV for updates, follow local Civil Defence Emergency Management Group websites and social media, and check @NZCivilDefence Twitter for the latest information.\n\n" +
                        "8. EVACUATION ROUTES: Familiarize yourself with tsunami evacuation route signs and maps. Follow designated evacuation routes to reach safety.\n\n" +
                        "9. PET AND ANIMAL SAFETY: If you have pets, consider their safety too. Assemble a kit with pet supplies, and bring them with you if it won't delay your evacuation.\n\n" +
                        "10. POST-TSUNAMI CAUTION: After evacuating, do not return until an official all-clear message is given. Tsunami activity can persist for hours, and aftershocks may trigger more tsunami events.",
                R.drawable.img_461,
                "https://www.civildefence.govt.nz/cdem-sector/consistent-messages/tsunami/response-what-to-do-during-a-tsunami/",
                "https://www.undrr.org/sites/default/files/styles/landscape_16_9/public/2022-11/wtad-mauirtius.jpg?h=f30a3440&itok=KiFJL1pg")
        )

        dataList.add(
            DataItem("EVACUATION PLANS FOR COASTAL COMMUNITIES",
                "\"Dive into the Crucial Blueprint: Ensuring Coastal Survival in the Philippines' Tsunami Battleground. Discover the strategic evacuation plans and life-saving measures meticulously designed to protect coastal communities from the relentless force of tsunamis.\"\n\n\n" +
                        "1. TSUNAMI HAZARD ASSESSMENT: Conduct a comprehensive hazard assessment considering local geography and potential tsunami scenarios to understand the risks involved.\n\n" +
                        "2. TSUNAMI HAZARD ZONE MAPPING: Create detailed hazard zone maps identifying areas susceptible to flooding during tsunamis of various sizes and sources.\n\n" +
                        "3. ASSET AND POPULATION RISK ASSESSMENT: Determine the location of critical community assets and vulnerable populations within hazard zones to prioritize protection efforts.\n\n" +
                        "4. RESPONSE PLANNING AND DRILLS: Develop and regularly practice response plans tailored specifically for tsunamis, involving residents and local authorities.\n\n" +
                        "5. PUBLIC WARNING SYSTEMS: Establish effective public warning systems capable of rapidly disseminating tsunami alerts through various communication channels.\n\n" +
                        "6. EVACUATION ROUTE PLANNING: Designate and clearly mark evacuation routes, ensuring they lead to safe zones and are accessible to all community members.\n\n" +
                        "7. TSUNAMI EVACUATION STRUCTURES: Construct tsunami evacuation structures strategically, designed to withstand tsunamis and accommodate residents and visitors.\n\n" +
                        "8. COMMUNITY EDUCATION: Conduct public awareness campaigns and educational programs to inform residents and tourists about tsunamis and safety measures.\n\n" +
                        "9. LAND USE PLANNING: Implement land-use planning, limiting new development in tsunami hazard zones, and adopting building codes that consider tsunamis.\n\n" +
                        "10. INFRASTRUCTURE PROTECTION: Strengthen critical infrastructure and existing structures that, if damaged, could hinder response and recovery efforts.",

                R.drawable.img_194,
                "https://www.noaa.gov/jetstream/prep-com",
                "https://reliefweb.int/sites/default/files/styles/large/public/images/reports/c4/0f/c40f567d-96bc-3734-a39c-ee0ee7a45973.jpg")
        )

        dataList.add(
            DataItem("COASTAL INFRASTRUCTURE RESILIENCE",
                "In the relentless face of natural disasters, coastal communities must stand strong and resilient. Explore the innovative strategies and grassroots initiatives that safeguard both lives and infrastructure from the devastating impact of tsunamis in our quest for \"Coastal Infrastructure Resilience: Building a Fortress Against Tsunami Fury.\"" +
                        "1. SITE ASSESSMENT AND ZONING: Conduct a comprehensive site assessment to identify tsunami-prone areas and implement zoning regulations to restrict new development in high-risk zones.\n\n" +
                        "2. ELEVATED CONSTRUCTION: Encourage construction of buildings and infrastructure in safer, elevated locations away from inundation areas.\n\n" +
                        "3. NATURAL BARRIERS: Consider implementing natural barriers such as forests, ditches, slopes, and berms to slow down tsunami waves and filter out debris.\n\n" +
                        "4. STRATEGIC WATER STEERING: Explore strategies for steering water away from vulnerable areas using angled walls, ditches, and paved roads.\n\n" +
                        "5. WAVE BLOCKING STRUCTURES: Construct resilient structures like walls, terraces, berms, and parking facilities to block and divert tsunami waves.\n\n" +
                        "6. COMMUNITY ENGAGEMENT: Foster community involvement in disaster preparedness and mitigation efforts to build resilience.\n\n" +
                        "7. DISASTER ACTION TEAMS: Form community-based disaster action teams equipped to respond effectively during and after a tsunami.\n\n" +
                        "8. MITIGATION STRUCTURES: Collaborate with local volunteers and organizations to build mitigation structures like seawalls and evacuation centers.\n\n" +
                        "9. MULTI-PURPOSE PROJECTS: Explore multi-purpose projects that combine disaster mitigation efforts with other community needs like housing, agriculture, and healthcare.\n\n" +
                        "10. LOCAL LEADERSHIP: Identify natural leaders within the community who can facilitate disaster mitigation projects, utilizing local knowledge and resources for cost-effective solutions.\n\n",
                R.drawable.img_195,
                "http://courses.washington.edu/larescue/precedents/prevention.htm",
                "https://www.thoughtco.com/thmb/YlnCWVQv4dYRcq2lVjOfhUYh_Fk=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/tsunami-525540464-57afba9d3df78cd39c4d7a56.jpg")
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