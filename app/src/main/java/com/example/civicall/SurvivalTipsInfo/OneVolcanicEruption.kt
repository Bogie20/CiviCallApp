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
import android.widget.ImageView
import com.example.civicall.databinding.ActivityOneVolcanicEruptionInfoBinding

class OneVolcanicEruption : AppCompatActivity() {
    private lateinit var binding:ActivityOneVolcanicEruptionInfoBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityOneVolcanicEruptionInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }
        val dataList = ArrayList<DataItem>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        dataList.add(
            DataItem(
                "MONITORING VOLCANIC ACTIVITY",
                "The Philippines now boasts a state-of-the-art volcanic lake monitoring system from Belgium, bolstering its defenses against volcanic eruptions. This advanced technology, focusing on Taal Volcano, offers a vital early warning mechanism by tracking carbon dioxide changes in its crater lake.\"\"\n\n" +
                        "1. INSTALLATION OF MONITORING EQUIPMENT: Begin by installing the specialized monitoring equipment provided by Belgium at a strategic location near Taal Volcano's main crater lake.\n\n" +
                        "2. CALIBRATION AND TESTING: Ensure that all monitoring instruments are properly calibrated and rigorously tested to ensure accuracy in measuring carbon dioxide levels and other relevant parameters.\n\n" +
                        "3. DATA COLLECTION: Establish a data collection schedule to continuously monitor the volcanic lake. This should include the real-time tracking of carbon dioxide levels and other crucial data.\n\n" +
                        "4. DATA ANALYSIS: Employ volcanologists and experts to analyze the collected data, looking for trends and patterns that may indicate changes in volcanic activity.\n\n" +
                        "5. EARLY WARNING CRITERIA: Define specific criteria and thresholds for early warning signs of increased volcanic activity, such as significant rises in carbon dioxide levels.\n\n" +
                        "6. ALERT LEVELS: Develop a system of alert levels (e.g., Green, Yellow, Orange, Red) to communicate the level of volcanic risk to the public based on the data analysis.\n\n" +
                        "7. PUBLIC AWARENESS AND COMMUNICATION: Establish a communication plan to disseminate information to local communities, government agencies, and the media regarding the monitoring system and its findings.\n\n" +
                        "8. EMERGENCY RESPONSE PLAN: Collaborate with local authorities to develop an emergency response plan outlining evacuation routes, shelters, and disaster preparedness measures in case of an impending eruption.\n\n" +
                        "9. TRAINING AND CAPACITY BUILDING: Train local personnel, including scientists and emergency responders, in the operation of the monitoring system and in interpreting its data.\n\n" +
                        "10. REGULAR MAINTENANCE AND UPDATES: Implement a schedule for routine maintenance and system updates to ensure the continuous operation and accuracy of the monitoring system.\n\n",

                "https://pia.gov.ph/uploads/2022/03/bfac4568dff0f7f58358a8a3297595cf-800-1200.jpg",
                "https://www.pna.gov.ph/articles/1071549"

            )
        )
        dataList.add(
            DataItem("CREATING A VOLCANIC ERUPTION EMERGENCY KIT",
                "Prepare for the unexpected fury of a volcanic eruption with a well-equipped \"Volcanic Eruption Survival Kit.\" In this guide, we'll outline the essential items to stash in your car, ensuring you're ready to tackle ashfall and volcanic hazards head-on.\n\n" +
                        "1. PLAN AND PREPARE: Assess your family's needs, including dietary and medical requirements, to determine the necessary supplies for your emergency kit.\n\n" +
                        "2. FOOD AND WATER: Stock a three-day supply of non-perishable food items and one gallon of water per person per day. Ensure you have a manual can opener.\n\n" +
                        "3. FIRST AID KIT: Assemble a comprehensive first aid kit with bandages, antiseptics, medications, and medical supplies tailored to your family's needs.\n\n" +
                        "4. TOOLS AND SUPPLIES: Include essential tools like flashlights, extra batteries, a multi-tool, duct tape, work gloves, and a manual can opener.\n\n" +
                        "5. COMMUNICATION: Keep battery-powered or hand-crank radios for emergency information and extra batteries for devices and flashlights.\n\n" +
                        "6. PERSONAL DOCUMENTS: Safeguard copies of important documents such as identification, insurance policies, medical records, and contact information in a waterproof container.\n\n" +
                        "7. CLOTHING AND BEDDING: Pack extra clothing, sturdy shoes, and blankets or sleeping bags suitable for your climate.\n\n" +
                        "8. SANITATION AND HYGIENE: Include hygiene items, toilet paper, sanitary supplies, soap, hand sanitizer, trash bags, and personal hygiene products.\n\n" +
                        "9. PET SUPPLIES: If you have pets, assemble a separate kit for them with food, water, leashes, carriers, medications, and copies of their medical records.\n\n" +
                        "10. EMERGENCY PLAN: Develop a family emergency plan outlining evacuation routes, rendezvous points, and contact information. Ensure everyone in your household is familiar with the plan.\n\n" +
                        "11. WATER (CONTAINER SOLD SEPARATELY): Carry both drinking and washing water. Drinking water should be in a reusable container, while washing water helps clear your windshield.\n\n" +
                        "12. EXTRA CASH: Keep extra money on hand in case ATM machines become inoperable during an emergency.\n\n" +
                        "13. DUST MASK: Protect your respiratory system with N95 dust masks, designed to shield against fine volcanic ash particles.\n\n" +
                        "14. TOWEL, WET WIPES, TISSUES, OR PAPER TOWELS: These items are versatile for cleaning, cooling down, and makeshift masks.\n\n" +
                        "15. PORTABLE VACUUM CLEANER: Consider a portable vacuum cleaner in your car's trunk for cleaning ash from your vehicle or surroundings.\n\n",

                "https://i.ytimg.com/vi/qR3C6nJeYOs/maxresdefault.jpg",
                "https://www.autodeal.com.ph/articles/car-features/volcanic-eruption-survival-kit-what-bring-in-your-car"
)
        )
        dataList.add(
            DataItem("EVACUATION ROUTES AND SAFETY ZONES",
                "\"\"Amidst the towering threat of volcanic eruptions in the Philippines, understanding the dynamics of evacuation routes and safety zones becomes paramount. This study delves into the intricate tapestry of evacuation strategies and safety measures in the face of volcanic fury.\"\"EVACUATION PLANS AND SAFE ZONES in earthquakes\" to prepare for seismic events with precision and protect your community.\"\n\n" +
                        "1. RISK ASSESSMENT AND MAPPING: Conduct a thorough risk assessment to identify vulnerable areas and potential hazards associated with specific volcanoes. Create detailed hazard maps indicating lava flow, pyroclastic flows, ashfall, and other potential dangers.\n\n" +
                        "2. ESTABLISH EVACUATION ROUTES: Designate primary and alternative evacuation routes that lead residents away from high-risk zones. Ensure these routes are well-marked and easily accessible.\n\n" +
                        "3. SAFETY ZONES IDENTIFICATION: Define safe zones or evacuation centers that are strategically located outside the danger zones. These areas should have adequate infrastructure, such as shelters, medical facilities, and water sources.\n\n" +
                        "4. PUBLIC AWARENESS AND EDUCATION: Launch public awareness campaigns to educate communities about volcanic hazards, evacuation procedures, and the importance of following official advisories. Conduct regular drills and simulations.\n\n" +
                        "5. EARLY WARNING SYSTEMS: Implement effective early warning systems that provide real-time information about volcanic activity. Ensure that warnings reach vulnerable communities promptly through various communication channels.\n\n" +
                        "6. COLLABORATION WITH LOCAL AUTHORITIES: Foster collaboration between local governments, disaster management agencies, and community leaders to streamline evacuation efforts. Establish clear lines of authority during emergencies.\n\n" +
                        "7. EVACUATION COORDINATION: Develop a robust coordination mechanism for evacuations, involving local authorities, first responders, and volunteers. Pre-position necessary resources near evacuation routes.\n\n" +
                        "8. TRANSPORTATION AND LOGISTICS: Arrange transportation options, including buses, trucks, and boats, to facilitate the evacuation of residents, especially those with limited mobility. Stockpile emergency supplies in safety zones.\n\n" +
                        "9. EVACUATION DRILLS AND TRAINING: Conduct regular evacuation drills and training sessions for both residents and responders. Ensure that everyone knows their roles and responsibilities during an evacuation.\n\n" +
                        "10. CONTINUOUS MONITORING: Establish a system for continuous monitoring of volcanic activity, including seismic data and gas emissions. Update hazard assessments and evacuation plans as needed based on the latest information.",

                "https://www.arabnews.com/sites/default/files/styles/660x371_watermarksaudi/public/main-image/2023/06/11/3860426-2067169154.jpg?itok=owK3pFTT",
                "https://appliedvolc.biomedcentral.com/articles/10.1186/s13617-021-00109-4"
             )
        )

        dataList.add(
            DataItem("PROTECTION FROM ASHFALL AND PYROCLASTIC FLOWS",
                "\"Welcome to a comprehensive guide on 'PROTECTION FROM ASHFALL AND PYROCLASTIC FLOWS,' where we unveil the strategies and precautions you need to weather these volcanic tempests and emerge unscathed.\"\n\n\n" +
                        "1. STAY INDOORS, STAY SAFE: When ashfall or pyroclastic flows are imminent, seek shelter indoors immediately. Keep all windows and doors closed to prevent ash from entering your living space.\n\n" +
                        "2. COVER UP: Wear long-sleeved shirts and long pants to minimize skin exposure to volcanic ash. This clothing provides an additional layer of protection against skin irritation.\n\n" +
                        "3. EYE PROTECTION: Use goggles or safety glasses to shield your eyes from ash particles. Protecting your eyes is crucial as ash can cause irritation and damage to your vision.\n\n" +
                        "4. LISTEN TO AUTHORITIES: Follow official guidance and instructions. If ashfall continues for an extended period, local authorities will provide advice on whether it's safe to remain indoors or if evacuation is necessary.\n\n" +
                        "5. RESPIRATORY PROTECTION: Consider wearing a disposable N-95 respirator mask to safeguard your respiratory system from inhaling fine ash particles. These masks can be purchased at hardware stores and provide effective protection.\n\n" +
                        "6. PROPER MASK USAGE: If using a respirator, ensure you follow the manufacturer's instructions for correct usage. A well-fitted mask is essential for effective protection.\n\n" +
                        "7. NUISANCE DUST MASK: As a last resort, if you don't have a respirator, you can use a nuisance dust mask. However, these provide limited protection, so limit outdoor exposure when wearing one.\n\n" +
                        "8. VEHICLE PRECAUTIONS: Keep your car or truck engine switched off during ashfall. Avoid driving in heavy ashfall conditions as it can damage engines and reduce visibility.\n\n" +
                        "9. SAFE DRIVING PRACTICES: If driving becomes necessary, keep car windows closed and avoid using the air conditioning system. Driving in ashfall stirs up ash, potentially causing engine issues and stalling vehicles.\n\n" +
                        "10. SPECIALIZED PROTECTION: Emergency and cleanup workers may require specialized respiratory protection based on their tasks. Ensure that workers have appropriate equipment for their activities.",

                "https://media.cnn.com/api/v1/images/stellar/prod/140214121124-indonesia-volcano-evacuee-mount-kelud.jpg?q=w_3504,h_2336,x_0,y_0,c_fill",
                "https://www.cdc.gov/disasters/volcanoes/during.html#:~:text=Protecting%20yourself%20during%20ashfall&text=Wear%20long%2Dsleeved%20shirts%20and,air%20intakes%20into%20the%20building."
             )
        )

        dataList.add(
            DataItem("DEALING WITH RESPIRATORY ISSUES FROM VOLCANIC ASH",
                "\"Uncover crucial insights on safeguarding your respiratory well-being when dealing with volcanic ash. Learn how to protect your lungs from the hazards of ashfall with our expert guidance.\"\n\n" +
                        "1. STAY INDOORS: Remain indoors until the volcanic ash has settled. Keep doors, windows, and fireplace dampers shut. Seal any drafty areas with damp towels and tape.\n\n" +
                        "2. USE AIR CONDITIONERS WISELY: Set air conditioners to recirculation mode, preventing outside air from entering your home. Ensure that air conditioners and air cleaners are clean and functioning correctly.\n\n" +
                        "3. EXTRA PRECAUTION FOR VULNERABLE GROUPS: Take additional precautions for children, older adults, pregnant women, individuals with chronic lung disease (such as asthma or COPD), cardiovascular disease, diabetes, and anyone who must work outdoors.\n\n" +
                        "4. AVOID DRIVING: If possible, avoid driving in areas affected by volcanic ash. If you must drive, keep windows and vents closed, and use the \"recirculate\" setting for air conditioning.\n\n" +
                        "5. BE CAUTIOUS WITH DUST MASKS: Ordinary dust masks are not effective against fine ash particles. Consider using a dust mask with an N-95 rating for better protection, but consult your physician before use, especially if you have a lung disease.\n\n" +
                        "6. OUTDOOR EXERCISE: Refrain from outdoor exercise if the air quality forecast indicates unhealthy conditions (code red or higher).\n\n" +
                        "7. MEDICATIONS: Ensure you have your medications readily available. Continue taking your prescribed medicines, and consult your physician if you have concerns about your lung condition.\n\n" +
                        "8. ASTHMA OR COPD TRAVEL PACK: Create a portable pack containing all your essential medicines and instructions, making it easily accessible in case of emergencies.\n\n" +
                        "9. SEEK MEDICAL ATTENTION: If your pulmonary symptoms persist despite medication, seek immediate medical attention. Watch for symptoms like wheezing, shortness of breath, chest heaviness, lightheadedness, or dizziness.\n\n" +
                        "10. CLEAN-UP SAFETY: If involved in clean-up activities, use caution. Avoid areas with dust and soot if you have lung or heart problems. Wet dusty areas before cleaning to reduce airborne particulates, and wear an appropriate dust mask during clean-up.\n\n",

                "https://sa.kapamilya.com/absnews/abscbnnews/media/2020/life/01/14/20200113-taal-eruption-lemery-jc-5.jpg",
                "https://www.lung.org/clean-air/emergencies-and-natural-disasters/volcanic-ash"
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


        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}