package com.example.civicall.DisasterResponseInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityTwoFireSafetyInfoBinding

class TwoFireSafetyInfo : AppCompatActivity() {
    private lateinit var binding:ActivityTwoFireSafetyInfoBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityTwoFireSafetyInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dataList = ArrayList<DataItem>()

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

                "https://villaflorhospital.com.ph/wp-content/uploads/2019/02/FireBrigade-1024x683.jpg",
                "https://www.facebook.com/watch/live/?ref=watch_permalink&v=1110126603163215"

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

                "https://chmsu.edu.ph/wp-content/uploads/2023/03/DSC_0065-1024x683.jpg",
            "https://issuu.com/hofstra/docs/living-factor-calendar_32413209ada772/s/16589034"
              )
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

                "https://i.pinimg.com/736x/51/ab/8b/51ab8bfc6a49945f22750df5fdd4ad35.jpg",
            "https://www.firesafe.org.uk/fire-emergency-evacuation-plan-or-fire-procedure/"
              )
        )
        dataList.add(
            DataItem("Culinary Fire Safety: A Recipe for Dormitory Security",

            "Spice up your dorm life without the drama! 'Culinary Fire Safety: A Recipe for Dormitory Security' is your go-to guide for safe and delicious cooking in shared spaces. Discover the recipe for kitchen peace of mind in these pages.\n\n" +

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

                "https://i.ytimg.com/vi/JAzFIpET9mg/mqdefault.jpg",
            "https://www.redcross.org/get-help/how-to-prepare-for-emergencies/types-of-emergencies/fire.html#:~:text=Top%20Tips%20for%20Fire%20Safety,the%20plan%20twice%20a%20year."
             )
        )
        dataList.add(
            DataItem("Navigating the Current: Safeguarding Against Electrical Fires",
            "\"Dive into 'Navigating the Current: Safeguarding Against Electrical Fires' to ride the waves of electrical safety like a pro! This guide offers essential insights and precautions to keep you and your home safe from electrical hazards.\"\n\n" +

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

                "https://www.lancsfirerescue.org.uk/wp-content/uploads/2021/01/Untitled-design.png",
            "https://fens.sabanciuniv.edu/tr/laboratory-safety/general-laboratory-safety/preventing-electrical-hazards"
               )
        )
        dataList.add(
            DataItem("The Flame and the Forbidden: Candle and Open Flame Safety",
            "Unlock the secrets of 'The Flame and the Forbidden: Candle and Open Flame Safety' to bring a warm and cozy ambiance to your space without risking safety. This guide provides essential tips and precautions to ensure that candlelit moments remain enchanting, not hazardous.\n\n" +


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

                "https://internationalfireandsafetyjournal.com/wp-content/uploads/2022/10/shutterstock_1544840762.jpg",
            "https://www.hamilton.edu/offices/epss/open-flame-candle-safety"
          )
        )
          dataList.add(
            DataItem("Mastery of Fire Extinguisher Use: The PASS to Safety",
            "Embark on the path to 'Mastery of Fire Extinguisher Use: The PASS to Safety' and equip yourself with life-saving knowledge. This guide is your key to confidently handling fire emergencies with the PASS technique.\n\n" +


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

                "https://www.emssafetyservices.com/wp-content/uploads/2019/10/How-to-use-a-fire-extinguisher-header.jpg",
                "https://www.sc.edu/ehs/training/Fire/08_howto.htm")
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

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
}