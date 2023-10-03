package com.example.civicall.DisasterResponseInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class NaturalDisasterInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_natural_disaster_info)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "Typhoon Resilience: Enhancing Disaster Response Strategies in the Philippines",
                "College students, today we delve into the vital topic of enhancing typhoon resilience and disaster response strategies in the Philippines. This archipelago, situated in the Pacific 'Ring of Fire,' faces the constant threat of typhoons, earthquakes, and volcanic activity, making it a crucial case study in disaster management.\n\n" +
                        "1. NEEDS ASSESSMENT: Conduct a comprehensive needs assessment to identify areas and communities in the Philippines most vulnerable to typhoons, earthquakes, and other natural disasters.\n\n" +
                        "2. PROJECT FUNDING ALLOCATION: Allocate funding, like the $112 million provided by ADB, for addressing climate-related disasters, including typhoons, in the Philippines.\n\n" +
                        "3. DISASTER-RESILIENT METRO MANILA INITIATIVE: Implement the Disaster-resilient Metro Manila initiative, focusing on addressing institutional and investment gaps in disaster preparedness and response.\n\n" +
                        "4. CLIMATE RESILIENCE MAINSTREAMING: Develop and implement strategies for mainstreaming climate resilience into national and regional development planning.\n\n" +
                        "5. WATERSHED RESILIENCE PROJECTS: Execute projects in critical watersheds, such as those in Camarines Sur and Davao Oriental, to promote climate resilience and green growth measures.\n\n" +
                        "6. COASTAL ZONE MANAGEMENT: Implement non-structural resilience measures like coastal zone management to protect coastal populations from typhoons and other climate-related hazards.\n\n" +
                        "7. FOREST REHABILITATION: Launch forest rehabilitation and reforestation projects in critical watersheds to improve ecological resilience and reduce the risk of landslides during typhoons.\n\n" +
                        "8. GIS-BASED CLIMATE RISK ATLAS: Develop a GIS-based climate risk atlas to better understand and prepare for the impact of extreme weather events.\n\n" +
                        "9. INTEGRATED ADAPTATION PLANS: Create integrated adaptation and climate risk management plans for watersheds to enhance resilience and disaster response.\n\n" +
                        "10. CLIMATE-PROOFING INFRASTRUCTURE: Climate-proof essential infrastructure, including transport, irrigation, energy, and tourism facilities, to withstand the impact of typhoons and other natural disasters.\n\n",
                R.drawable.img_67,
                "https://www.adb.org/features/mitigating-natural-risks-philippines-adbs-take",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"
            )
        )

        dataList.add(
            DataItem(
                "Safety Precautions for Earthquake Response and Recovery in the Philippines",
                "College students, welcome to our exploration of 'Safety Precautions for Earthquake Response and Recovery in the Philippines.' Earthquakes, a common natural disaster in this region, often result in collapsed structures and require the immediate response of rescue workers and emergency responders. In this discussion, we will delve into the crucial guidelines and safety measures that these dedicated individuals follow when assessing and cleaning up after an earthquake. Join us as we navigate the challenges they face and the precautions they take to ensure their safety and the well-being of their communities.\n\n" +

                        "1. ASSESSMENT OF STRUCTURAL DAMAGE: Begin by assessing the extent of structural damage caused by the earthquake, focusing on collapsed buildings and infrastructure.\n\n" +
                        "2. INCIDENT COMMAND SYSTEM: Establish an incident command system at the collapsed structure site to ensure accountability for all response personnel, with a designated safety officer responsible for monitoring safety aspects.\n\n" +
                        "3. IDENTIFICATION OF ENTRANTS: Determine who enters the collapsed structure, with roles ranging from rescue workers and emergency responders to Urban Search and Rescue Teams.\n\n" +
                        "4. HAZARDS IDENTIFICATION: Identify and evaluate potential hazards, including water system breaks, exposed electrical wiring, airborne contaminants, and hazardous materials, among others.\n\n" +
                        "5. STRUCTURAL STABILITY ASSESSMENT: Assess the structural stability of the collapsed building to ensure the safety of rescue workers and responders before entry.\n\n" +
                        "6. SAFETY PRECAUTIONS: Implement safety precautions, such as wearing appropriate protective clothing, avoiding contact with sharp objects, and using safety measures when operating equipment.\n\n" +
                        "7. HAZARD REPORTING: Report identified hazards, including gas leaks, structural instability, or downed power lines, to local authorities or utilities promptly.\n\n" +
                        "8. CONFINED SPACE AWARENESS: Maintain awareness of confined spaces within the collapsed structure and follow safety protocols for entering such spaces.\n\n" +
                        "9. PREVENTION OF SECONDARY COLLAPSE: Take precautions to prevent secondary collapses due to aftershocks, vibrations, or explosions.\n\n" +
                        "10. ENVIRONMENTAL CONSIDERATIONS: Be mindful of environmental conditions, such as adverse weather, noise, and the potential for workplace violence, when carrying out response and recovery operations.\n\n",
                R.drawable.img_68,
                "https://www.osha.gov/earthquakes/response-recovery",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"
            )
        )

        dataList.add(
            DataItem(
                "Addressing Flood Disasters: Philippines' Approach to Disaster Response",
                "Welcome to our exploration of the Philippines' approach to managing flood disasters. In this discussion, we'll examine the multifaceted strategies and initiatives employed by the Philippines, particularly in Metro Manila, to combat the recurring threat of floods and enhance disaster response.\n\n" +

                        "1. FLOOD VULNERABILITY ASSESSMENT: Begin with a comprehensive assessment of flood-prone areas, identifying regions at high risk and vulnerable communities.\n\n" +
                        "2. INFRASTRUCTURE MODERNIZATION: Prioritize the modernization and construction of robust pumping stations and drainage systems to improve floodwater management.\n\n" +
                        "3. SOLID WASTE CONTROL: Implement effective solid waste management strategies, including community awareness programs and improved waste collection services, to prevent clogging of waterways.\n\n" +
                        "4. RESETTLEMENT PLANNING: Develop resettlement plans for affected residents, providing transitory and permanent housing options near their places of employment.\n\n" +
                        "5. RENTAL SUBSIDY PROGRAM: Establish a rental subsidy program to ensure affordability of resettlement options for families impacted by drainage improvements.\n\n" +
                        "6. INCLUSIVE RELOCATION SUPPORT: Collaborate with Civil Society Organizations to support vulnerable groups, including people with disabilities, during the relocation process, ensuring accessibility and inclusivity.\n\n" +
                        "7. GENDER-RESPONSIVE APPROACHES: Utilize gender analytical tools and consult with women from various economic groups to address the specific needs of both females and males throughout the project.\n\n" +
                        "8. LIVELIHOOD RESTORATION: Implement livelihood restoration programs to help affected communities regain economic stability after relocation.\n\n" +
                        "9. DATA-DRIVEN DECISION-MAKING: Continuously collect gender-disaggregated data and conduct surveys to inform project adjustments and ensure inclusivity.\n\n" +
                        "10. COMMUNITY ENGAGEMENT: Foster community engagement and awareness, involving residents in flood risk reduction efforts and disaster response planning.\n\n",
                R.drawable.img_69,
                "https://www.preventionweb.net/news/philippines-managing-floods-inclusive-and-resilient-development-metro-manila",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"
            )
        )

        dataList.add(
            DataItem("Volcano Eruptions and Disaster Management: Lessons from the Philippines",
                "Welcome to our exploration of disaster management in the Philippines, specifically focusing on the preparedness and response strategies for volcanic eruptions. With 23 active volcanoes scattered across this archipelago nation, communities here have learned valuable lessons in disaster preparedness. In this discussion, we delve into the proactive measures and coordination efforts taken by local authorities and organizations to mitigate the risks posed by volcanic activity.\n\n" +

                        "1. VOLCANO RISK ASSESSMENT: Conduct comprehensive risk assessments to evaluate the potential hazards and vulnerabilities associated with active volcanoes, considering historical eruption patterns, proximity to populated areas, and potential damage.\n\n" +

                        "2. COMMUNITY PREPAREDNESS PROGRAMS: Develop and implement community-based preparedness programs to raise awareness about eruption risks, evacuation plans, and emergency response procedures among residents in volcanic hazard zones.\n\n" +

                        "3. REGULAR EMERGENCY DRILLS: Organize and conduct regular emergency response drills involving local authorities, residents, and relevant agencies to ensure a well-coordinated and efficient response in the event of a volcanic eruption.\n\n" +

                        "4. GEOGRAPHIC INFORMATION SYSTEMS (GIS) MAPPING: Implement GIS mapping systems to accurately identify and map at-risk areas, enabling the quick identification of residents who may need immediate evacuation during an eruption.\n\n" +

                        "5. EARLY WARNING SYSTEMS: Establish effective early warning systems that utilize real-time data and monitoring to provide timely alerts to communities at risk of volcanic activity.\n\n" +

                        "6. EMERGENCY EVACUATION PLANS: Develop and communicate clear and detailed emergency evacuation plans that specify safe routes, assembly points, and transportation arrangements for affected residents.\n\n" +

                        "7. EMERGENCY SHELTER PREPAREDNESS: Ensure that adequate emergency shelters are identified, equipped, and readily available for evacuated residents, with a focus on providing safe and hygienic conditions.\n\n" +

                        "8. MEDICAL RESPONSE READINESS: Prepare and maintain medical response teams and facilities capable of addressing health issues, injuries, and respiratory problems resulting from volcanic eruptions.\n\n" +

                        "9. PUBLIC INFORMATION AND COMMUNICATION: Establish effective communication channels to disseminate information, updates, and instructions to the public, keeping them informed and engaged in the disaster response process.\n\n" +

                        "10. INTERNATIONAL COOPERATION: Foster international cooperation and partnerships with organizations and countries experienced in volcanic disaster management to exchange knowledge, resources, and best practices for enhanced disaster preparedness and response.\n\n",
                R.drawable.img_70,
                "https://www.preventionweb.net/news/philippines-preparing-volcanoes",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )

        dataList.add(
            DataItem("Climate Change in the Philippines: Challenges, Adaptation, and Solutions",
                "Welcome, college students, to our discussion on Climate Change in the Philippines. In this exploration, we'll uncover the unique challenges posed by climate change in this nation and the proactive measures being taken to address them.\n\n" +


                        "1. RISK ASSESSMENT AND VULNERABILITY ANALYSIS: Conduct comprehensive risk assessments to identify regions and communities vulnerable to the impacts of tropical storms exacerbated by climate change.\n\n" +
                        "2. HISTORICAL DATA ANALYSIS: Analyze historical storm data to understand changing patterns and trends, enabling better preparedness and response planning.\n\n" +
                        "3. CLIMATE MODELING AND PROJECTION: Utilize climate models to project future storm scenarios, considering variables like sea surface temperatures and atmospheric conditions.\n\n" +
                        "4. EARLY WARNING SYSTEMS ENHANCEMENT: Strengthen early warning systems to provide timely alerts and evacuation instructions to vulnerable communities ahead of tropical storms.\n\n" +
                        "5. INFRASTRUCTURE RESILIENCE PLANNING: Develop strategies to enhance the resilience of critical infrastructure, including flood control systems and coastal defenses, in the face of rising storm risks.\n\n" +
                        "6. COMMUNITY EDUCATION AND ENGAGEMENT: Conduct educational campaigns to raise awareness about climate change and storm-related risks, involving local communities in disaster preparedness and resilience-building efforts.\n\n" +
                        "7. NATURAL RESOURCE CONSERVATION: Implement conservation measures for natural resources, such as mangrove forests and coral reefs, to mitigate storm impacts and protect coastal areas.\n\n" +
                        "8. EMERGENCY RESPONSE CAPACITY BUILDING: Train response teams and volunteers in disaster response and relief efforts, ensuring efficient and coordinated responses during and after storms.\n\n" +
                        "9. CLIMATE-RESILIENT AGRICULTURE: Promote climate-resilient agricultural practices to safeguard food security and livelihoods in storm-prone regions.\n\n" +
                        "10. INTERNATIONAL COLLABORATION: Foster international partnerships for knowledge exchange, resource sharing, and joint research on climate change adaptation and tropical storm management.\n\n",






                R.drawable.img_71,
                "https://www.pagasa.dost.gov.ph/information/climate-change-in-the-philippines",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Disaster Risk Reduction in Coastal Communities: A Focus on the Philippines  ",
                "Welcome, college students, to our exploration of \"Disaster Risk Reduction in Coastal Communities: A Focus on the Philippines.\" In this discussion, we'll delve into the critical issue of disaster preparedness and mitigation strategies, particularly in the context of coastal regions in the Philippines. With the country's vulnerability to natural disasters like typhoons and storm surges, understanding the importance of disaster risk reduction is paramount for safeguarding lives, property, and sustainable development.\n\n" +


                        "1. LIFESAVING MEASURES: Effective disaster risk reduction measures save lives by minimizing the impact of natural disasters such as typhoons, tsunamis, and storm surges.\n\n" +
                        "2. PROTECTION OF COASTAL ECOSYSTEMS: DRR strategies help preserve vital coastal ecosystems like mangroves and coral reefs, which act as natural barriers against coastal hazards.\n\n" +
                        "3. INFRASTRUCTURE RESILIENCE: DRR enhances the resilience of critical infrastructure, ensuring that essential facilities like hospitals, schools, and water supply systems can withstand disasters.\n\n" +
                        "4. COMMUNITY EMPOWERMENT: It empowers coastal communities by involving them in planning and decision-making processes, promoting a sense of ownership in disaster preparedness.\n\n" +
                        "5. ECONOMIC SUSTAINABILITY: Disaster risk reduction safeguards livelihoods by preventing damage to fisheries, agriculture, and tourism sectors, all of which are essential for coastal communities.\n\n" +
                        "6. REDUCTION IN DISASTER RECOVERY COSTS: Investments in DRR significantly reduce the costs associated with post-disaster recovery, relief, and reconstruction efforts.\n\n" +
                        "7. CLIMATE ADAPTATION: DRR efforts align with climate change adaptation strategies, as coastal regions are increasingly vulnerable to climate-related impacts.\n\n" +
                        "8. EDUCATION AND AWARENESS: DRR initiatives raise awareness and educate community members about disaster risks, evacuation procedures, and preparedness measures.\n\n" +
                        "9. GOVERNMENT CAPACITY BUILDING: Governments develop the capacity to respond efficiently to disasters and emergencies, ensuring a coordinated and effective response.\n\n" +
                        "10. LONG-TERM SUSTAINABILITY: By reducing disaster risks, DRR measures contribute to the long-term sustainability and resilience of coastal communities, protecting both current and future generations.\n\n",







                R.drawable.img_72,
                "https://climate-laws.org/document/philippine-disaster-reduction-and-management-act-ra-10121_eda4",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("The Role of Technology in Disaster Response and Recovery in the Philippines",
                "\"Welcome, college students, to our exploration of 'The Role of Technology in Disaster Response and Recovery in the Philippines.' In this discussion, we'll delve into the innovative use of technology to enhance disaster preparedness and response efforts in a country prone to various natural calamities.\"\n\n" +


                        "1. INTEGRATED DATA COLLECTION: Implement integrated data collection systems that leverage technology to gather real-time information on disaster impacts, including weather conditions, infrastructure damage, and affected populations.\n\n" +
                        "2. EARLY WARNING SYSTEMS: Develop and maintain advanced early warning systems that utilize sensors, satellite imagery, and communication networks to provide timely alerts and forecasts for impending disasters.\n\n" +
                        "3. GIS AND MAPPING: Utilize Geographic Information Systems (GIS) and mapping technologies to create detailed disaster risk maps, aiding in disaster response planning and resource allocation.\n\n" +
                        "4. SOCIAL MEDIA MONITORING: Employ social media monitoring tools to track disaster-related conversations, identify emerging needs, and engage with affected communities for rapid response and support.\n\n" +
                        "5. REMOTE SENSING: Utilize remote sensing technologies, such as drones and satellite imagery, to assess disaster-affected areas, identify critical needs, and plan response strategies.\n\n" +
                        "6. MOBILE APPS FOR REPORTING: Develop and promote mobile applications that allow citizens to report incidents, request assistance, and access critical information during disasters.\n\n" +
                        "7. DISASTER RECOVERY PLANNING SOFTWARE: Implement disaster recovery planning software to facilitate efficient resource allocation, logistics management, and coordination among response agencies.\n\n" +
                        "8. COMMUNICATION INFRASTRUCTURE: Strengthen communication infrastructure, including satellite-based and resilient networks, to ensure uninterrupted connectivity for disaster response teams.\n\n" +
                        "9. COMMUNITY ENGAGEMENT PLATFORMS: Establish online platforms for community engagement, where citizens can access disaster preparedness resources, share local knowledge, and participate in disaster risk reduction initiatives.\n\n" +
                        "10. DATA ANALYTICS FOR DECISION-MAKING: Utilize data analytics and artificial intelligence to process large datasets from various sources, enabling informed decision-making and resource optimization during disaster response and recovery.\n\n",



                R.drawable.img_73,
                "https://www.ictworks.org/philippines-ict4d-solutions-disaster-risk-reduction/#:~:text=ICT4D%20can%20play%20a%20vital,and%20mapping%20of%20affected%20areas%2C",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
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