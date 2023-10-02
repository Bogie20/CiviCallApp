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

class FireSafetyInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_safety_info)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "Understanding and Adhering to Your Campus's Fire Safety Guidelines",
                "Familiarizing yourself with your college or university's fire safety guidelines, which cover prohibited items, evacuation procedures, and fire prevention, is essential for ensuring the safety of both yourself and your peers.\n\n" +

                        "1. ESSENTIAL TO KNOW: Familiarize yourself with your college's fire safety guidelines.\n\n" +
                        "2. OFFICIAL SOURCE: Visit the college website for access to these guidelines.\n\n" +
                        "3. NAVIGATE RESOURCES: Look under \"Student Handbook\" or \"Campus Safety\" sections.\n\n" +
                        "4. GUIDELINES CLARITY: Read and comprehend the fire safety rules thoroughly.\n\n" +
                        "5. NO IGNITION HAZARDS: Pay heed to bans on items like candles and certain electronics.\n\n" +
                        "6. EVACUATION AWARENESS: Understand evacuation procedures, exits, and muster points.\n\n" +
                        "7. PREVENTIVE MEASURES: Take note of recommended fire prevention steps.\n\n" +
                        "8. STRICT COMPLIANCE: Respect and strictly adhere to the guidelines you've learned.\n\n" +
                        "9. PROHIBITED ITEMS: Avoid bringing banned items into your living quarters.\n\n" +
                        "10. REPORTING MATTERS: Report guideline violations to campus authorities promptly.\n\n",

                R.drawable.love2,
                "https://www.facebook.com/watch/live/?ref=watch_permalink&v=1110126603163215",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"
            )
        )
        dataList.add(
            DataItem("Mastery of Fire Prevention Equipment in Your Residence Hall",
            "It's crucial to understand the location and proper use of fire prevention equipment in your residence hall. Fire extinguishers, smoke detectors, and fire alarms are essential tools in case of a fire. Regularly inspect and test these devices to ensure they are in working condition.\n\n" +
                    "1. STUDY THE PLAN: Carefully read and understand your dormitory's fire evacuation plan, which should be available in your residence hall handbook or on the college's website.\"PASS\" technique (Pull, Aim, Squeeze, Sweep).\n\n" +
                    "2. FIRE EXIT LOCATIONS: Familiarize yourself with the locations of fire exits on your floor and throughout the building.\n\n" +
                    "3. EVACUATION ROUTES: Learn the designated evacuation routes and the primary and secondary exits you should use during a fire emergency.\n" +
                    "4. MUSTER POINTS: Identify the muster points where residents gather after evacuating the building, and understand their importance for accountability.\n\n" +
                    "5. PARTICIPATE IN DRILLS: Actively participate in fire drills if they are conducted by your college. These drills provide valuable practice for real emergencies.\n\n" +
                    "6. EMERGENCY EQUIPMENT: Know the location of emergency equipment such as fire extinguishers and emergency lighting along your evacuation routes.\n\n" +
                    "7. ASSIST OTHERS: Be prepared to assist anyone who may require help during an evacuation, such as individuals with disabilities or mobility issues.\n\n" +
                    "8. STAY INFORMED: Stay informed about any updates or changes to the evacuation plan, and attend orientation sessions or meetings related to fire safety.\n\n" +
                    "9. PRACTICE CAUTION: During a fire alarm, always assume it's a real emergency and evacuate immediately. Don't use elevators, and follow the established evacuation procedures.\n\n" +

                    "10. REPORTING CONCERNS: If you have concerns about the effectiveness of the evacuation plan or notice any obstacles along the evacuation routes, report them to campus authorities to ensure a safer environment for all residents.\n\n",


                R.drawable.love2,
            "https://issuu.com/hofstra/docs/living-factor-calendar_32413209ada772/s/16589034",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Thoroughly Navigating Your Dormitory's Fire Evacuation Plan",
            "In the event of a fire, knowing your dormitory's evacuation plan is vital for a safe escape. Familiarize yourself with the nearest fire exits, evacuation routes, and muster points where residents gather after evacuating. Participate in fire drills if your college conducts them to practice these procedures.\n\n" +
                        "1. Plan Familiarization: Carefully read and understand your dormitory's fire evacuation plan, often available in your residence hall handbook or on the college website.\"PASS\" technique (Pull, Aim, Squeeze, Sweep).\n\n" +
                        "2. Exit Locations: Identify the locations of fire exits on your dormitory floor and within the building.\n\n" +
                        "3. Evacuation Routes: Learn the designated evacuation routes, including primary and secondary exits, for use during fire emergencies.\n" +
                        "4. Muster Points: Understand the predetermined muster points where residents should gather after evacuating the building.\n\n" +
                        "5. Participate in Drills: Actively participate in fire drills when your college conducts them, as they provide valuable practice.\n\n" +
                        "6. Emergency Equipment: Know the location of emergency equipment like fire extinguishers and emergency lighting along evacuation routes.\n\n" +
                        "7. Assist Others: Be prepared to assist individuals who may require help during an evacuation, such as those with disabilities.\n\n" +
                        "8. Stay Informed: Attend orientation sessions or meetings related to fire safety and stay informed about updates to the evacuation plan.\n\n" +
                        "9. Immediate Evacuation: Always treat a fire alarm as a real emergency and evacuate promptly. Avoid using elevators during evacuations.\n\n" +
                        "10. Reporting Concerns: Report any concerns about the effectiveness of the evacuation plan or obstacles along evacuation routes to campus authorities for improvement.\n\n",

            R.drawable.love2,
            "https://www.lsu.edu/ehs/files/Section_IV_Part_A_Fire_Safety_in_Dormitories.pdf",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Culinary Fire Safety: A Recipe for Dormitory Security",

            "Differentiate between a tornado watch, which means tornadoes are possible in your area, and a tornado warning, indicating a tornado has been sighted or detected. Familiarize yourself with designated safe shelter locations both on and off-campus to seek refuge during tornadoes. Stay informed through weather alerts and local news and have a tornado emergency kit ready, including essentials like a flashlight, batteries, and a battery-powered weather radio.\n\n" +






                    "1. COOKING VIGILANCE: Never leave cooking appliances unattended, as uncontrolled heat sources can lead to fires.\"PASS\" technique (Pull, Aim, Squeeze, Sweep).\n\n" +
                    "2. FLAMMABLE MATERIALS: Keep flammable materials like kitchen towels and curtains far away from stoves, hotplates, and open flames.\n\n" +
                    "3. NO OPEN FLAMES: Many dormitories prohibit the use of candles and open flames due to the high fire risk.\n" +
                    "4. CANDLE CAUTION: If allowed, use candles with caution, placing them on heat-resistant surfaces and always extinguishing them before leaving the room\n\n" +
                    "5. SMOKE-FREE COOKING: If your dormitory is designated as smoke-free, adhere to the policy by not smoking in prohibited areas.\n\n" +
                    "6. PROPER DISPOSAL: Discard cigarette butts and ashes in designated containers to prevent fire hazards.\n\n" +
                    "7. COOKING SAFETY GUIDELINES: Follow cooking safety guidelines provided by your college's housing department or residential life office.\n\n" +
                    "8. ELECTRICAL APPLIANCE SAFETY: Use cooking appliances with care, ensuring they are in good working condition and not damaged.\n\n" +
                    "9. EMERGENCY RESPONSE: Familiarize yourself with the location of fire extinguishers and fire blankets in communal kitchens.\n\n" +
                    "10. EDUCATE ROOMMATES: Communicate fire safety practices with your roommates to ensure collective awareness and adherence.\n\n",





            R.drawable.love2,
            "https://www.redcross.org/get-help/how-to-prepare-for-emergencies/types-of-emergencies/fire.html#:~:text=Top%20Tips%20for%20Fire%20Safety,the%20plan%20twice%20a%20year.",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Navigating the Current: Safeguarding Against Electrical Fires",
            "Flash floods result from sudden heavy rainfall, dam failures, or rapid snowmelt, causing rapid inundation. River floods develop gradually due to prolonged rainfall, snowmelt, or dam releases, causing rivers to overflow. To ensure campus safety, identify flood-prone areas like basements, low-lying lots, and nearby water bodies during extreme weather.\n\n" +

                    "1. Outlet Overloading: Avoid overloading electrical outlets with multiple devices, as it can lead to overheating and fires.\n\n" +
                    "2. Surge Protectors: Use surge protectors to safeguard your electronics and prevent electrical fires during power surges.\n\n" +
                    "3. Cord Safety: Refrain from using damaged or frayed cords, which can pose significant fire hazards.\n" +
                    "4. Unplugging Devices: Always unplug electrical devices when they are not in use to reduce the risk of electrical malfunctions.\n\n" +
                    "5. Space Heaters: Exercise caution when using space heaters, ensuring they are placed away from flammable materials and never left unattended.\n\n" +
                    "6. Extension Cords: Use extension cords sparingly and only when necessary, and never daisy-chain them.\n\n" +
                    "7. Appliance Safety: Inspect and maintain appliances regularly to ensure they are in good working condition.\n\n" +
                    "8. Electrical Inspections: Consider requesting electrical inspections in your residence hall to identify potential hazards.\n\n" +
                    "9. Emergency Procedures: Familiarize yourself with the location of fire extinguishers and emergency shutdowns in case of electrical fires.\n\n" +
                    "10. Roommates' Awareness: Educate your roommates about electrical safety practices to promote collective safety and responsibility.\n\n",





            R.drawable.love2,
            "https://fens.sabanciuniv.edu/tr/laboratory-safety/general-laboratory-safety/preventing-electrical-hazards",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("The Flame and the Forbidden: Candle and Open Flame Safety",
            " Wildfires spread rapidly due to dry conditions, strong winds, and ignition sources like lightning or human activities. To safeguard your dorm or apartment in fire-prone areas, establish a defensible space by clearing dead vegetation, maintaining a safe distance from flammable materials, and having fire-resistant roofing and siding.\n\n" +


                    "1. Respect Prohibitions: Adhere to your dormitory's rules regarding the use of candles and open flames; many places prohibit them due to fire risks.\n\n" +
                    "2. Alternatives: Explore alternative sources of lighting, such as battery-operated LED candles or string lights, which provide ambiance without fire hazards.\n\n" +
                    "3. Safe Placement: If allowed, use candles with caution, placing them on heat-resistant surfaces and away from flammable materials.\n" +
                    "4. Extinguish Before Leaving: Always extinguish candles and open flames before leaving your room to prevent unattended fires.\n\n" +
                    "5. Candle Holders: Use appropriate candle holders to prevent dripping wax and stabilize candles.\n\n" +
                    "6. Supervision: Never leave burning candles or open flames unattended; assign someone to watch them if necessary.\n\n" +
                    "7. Smoke Detectors: Ensure that smoke detectors are functioning properly in your room, as they are critical in alerting you to potential fire hazards.\n\n" +
                    "8. Fire Extinguisher: Learn how to use a fire extinguisher in case of an emergency involving open flames.\n\n" +
                    "9. Educate Roommates: Communicate candle and open flame safety practices with your roommates to ensure collective awareness.\n\n" +
                    "10. Emergency Response: Know the location of fire alarms and evacuation procedures, and act swiftly if a fire does occur.\n\n",





            R.drawable.love2,
            "https://www.hamilton.edu/offices/epss/open-flame-candle-safety",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Respecting the Smoke-Free Environment: A Breath of Fire Safety",
            "To safeguard yourself in volcanic-prone areas, become well-versed in recognizing early warning signs such as heightened seismic activity and gas emissions. It's equally important to acquaint yourself with the designated evacuation routes and locate nearby shelters for timely and safe evacuation during a volcanic event. Being prepared can make a crucial difference in protecting yourself and your community.\n\n" +

                    "1. Policy Adherence: Strictly adhere to your college's smoke-free policy, which prohibits smoking in designated areas.\n\n" +
                    "2. Designated Smoking Zones: If designated smoking areas exist on campus, use them responsibly and dispose of cigarette butts in designated containers.\n\n" +
                    "3. No Indoor Smoking: Never smoke indoors, as it poses significant fire and health risks.\n" +
                    "4. Fire-Safe Disposal: Always use proper receptacles for cigarette disposal to prevent fires caused by discarded butts.\n\n" +
                    "5. Educate Peers: Encourage your peers to respect the smoke-free policy and promote a culture of fire safety.\n\n" +
                    "6. Smoking Alternatives: Consider using smoking alternatives such as e-cigarettes or vaping only in designated areas, following campus regulations.\n\n" +
                    "7. Emergency Response: Familiarize yourself with the location of fire alarms and emergency exits in case of fire emergencies.\n\n" +
                    "8. Cigarette Fire Hazards: Be aware that cigarettes can ignite fires if not properly extinguished.\n\n" +
                    "9. Cigarette Butt Containers: Ensure that designated containers for cigarette butts are available and regularly emptied.\n\n" +
                    "10. Reporting Violations: Report any violations of the smoke-free policy to campus authorities for enforcement and fire safety.\n\n",

                R.drawable.love2,
            "https://www.hobartcity.com.au/Council/News-publications-and-announcements/Latest-news/smoke-free-parks",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("8. Mastery of Fire Extinguisher Use: The PASS to Safety",
            "Tsunamis are frequently triggered by underwater earthquakes, making it essential to understand their origins. When a tsunami warning is issued, recognizing the critical need to move to higher ground swiftly can be a life-saving response, as it reduces the risk of being affected by the powerful and destructive waves.\n\n" +


                    "1. Understanding Fire Extinguishers: Familiarize yourself with the types of fire extinguishers and their specific uses (e.g., Class A, B, C, or ABC extinguishers).\n\n" +
                    "2. The PASS Technique: Learn the PASS acronym: Pull, Aim, Squeeze, and Sweep, which is the proper method for using a fire extinguisher effectively.\n\n" +
                    "3. Pull: Begin by pulling the pin or safety clip from the extinguisher to prepare it for use.\n" +
                    "4. Aim: Aim the nozzle or hose at the base of the fire where the fuel source is burning, not at the flames themselves.\n\n" +
                    "5. Squeeze: Squeeze the handle or lever to release the extinguishing agent (typically a fire-suppressing chemical or foam).\n\n" +
                    "6. Sweep: Sweep the extinguisher from side to side in a controlled manner, directing the extinguishing agent at the base of the fire while continuing to aim at the source.\n\n" +
                    "7. Stand at a Safe Distance: Maintain a safe distance from the fire, usually about 6 to 8 feet, and approach it cautiously.\n\n" +
                    "8. Use for Small Fires: Fire extinguishers are designed for small, manageable fires. Do not attempt to extinguish large or uncontrollable fires.\n\n" +
                    "9. Emergency Alert: Always alert others about the fire, activate the building's fire alarm system, and call emergency services before attempting to use a fire extinguisher.\n\n" +
                    "10. Regular Inspection: Periodically check the pressure gauge on the extinguisher to ensure it is in the green \"ready\" zone and ready for use. Report any issues to maintenance.\n\n",














            R.drawable.love2,
            "https://www.sc.edu/ehs/training/Fire/08_howto.htm",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("9. Vigilant Reporting: Safeguarding Your Community",
            "Droughts have profound, long-term impacts on water sources and agriculture, often leading to reduced water availability and crop failures. To mitigate these effects, it is vital to adopt water conservation practices in your daily life, such as fixing leaks, using water-efficient appliances, and minimizing water waste, contributing to resource preservation and sustainability.\"Drop, Cover, and Hold On\" drill regularly with your roommates or neighbors.\n\n" +


                    "1. Awareness of Hazards: Stay vigilant and be observant of potential fire hazards in your surroundings.\n\n" +
                    "2. Malfunctioning Equipment: Report any malfunctioning fire safety equipment, such as fire extinguishers, smoke detectors, or fire alarms, immediately to campus authorities.\n\n" +
                    "3. Violations of Fire Safety Rules: If you notice violations of fire safety rules or guidelines by yourself or others, report them to the appropriate authorities promptly.\n" +
                    "4. Designated Reporting Channels: Utilize designated reporting channels, which may include contacting your resident advisor, housing office, or campus security, to report safety concerns.\n\n" +
                    "5. Timely Reporting: Report hazards and violations promptly to ensure quick responses and necessary actions to address safety issues.\n\n" +
                    "6. Communication: Encourage open communication among your fellow residents about the importance of reporting hazards to maintain a safe living environment.\n\n" +
                    "7. Emergency Numbers: Keep a list of emergency contacts and important numbers handy in case of fire-related incidents.\n\n" +
                    "8. Fire Alarm Activation: In case of a fire, pull the fire alarm to alert others and activate the building's fire alarm system.\n\n" +
                    "9. Follow Protocols: Familiarize yourself with your college's fire safety reporting protocols, which may include specific procedures to follow when reporting hazards or violations.\n\n" +
                    "10. Collective Responsibility: Remember that vigilance and reporting are collective responsibilities that contribute to the safety and well-being of your entire community.\n\n",








            R.drawable.love2,
            "https://worldguardian.ca/neighborhood-patrol-security-safeguarding-cochranes-community-with-vigilance-and-trust/",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("10.The Role of Campus Security in Fire Safety: What You Should Know.",
            "\"Attention Spartan college students, your journey towards academic excellence and personal growth has just begun. As you navigate the halls of higher education, remember that knowledge is your most formidable weapon. Join us on a quest for success, where every challenge is an opportunity to conquer, and every day is a chance to become a true Spartan scholar.\n\n" +






                    "1. Emergency Response: Campus security plays a vital role in responding to fire emergencies and coordinating with local fire departments.\n\n" +
                    "2. 24/7 Availability: Campus security is typically available 24/7 to respond to emergencies and enforce fire safety protocols.\n\n" +
                    "3. Fire Drills: They may coordinate and oversee fire drills to ensure the campus community is well-prepared in case of a fire.\n" +
                    "4. Evacuation Assistance: Campus security personnel are trained to assist in the orderly evacuation of buildings during fire alarms.\n\n" +
                    "5. Fire Alarm Maintenance: They are responsible for maintaining and testing fire alarm systems to ensure they function correctly.\n\n" +
                    "6. Fire Extinguisher Inspection: They may conduct regular inspections of fire extinguishers and ensure they are in proper working order.\n\n" +
                    "7. Reporting Hazards: Campus security should be informed of any fire hazards or violations of fire safety rules so they can take appropriate action.\n\n" +
                    "8. First Responders: In some cases, security personnel may serve as first responders to small fires before the arrival of the fire department.\n\n" +
                    "9. Safety Education: They often participate in fire safety education programs for students and staff.\n\n" +
                    "10. Collaboration: Campus security works in collaboration with other emergency response teams to ensure a coordinated and effective response in the event of a fire or other emergencies.\n\n",





            R.drawable.love2,
            "https://resources.impactfireservices.com/fire-prevention-and-preparedness-on-college-campuses",
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