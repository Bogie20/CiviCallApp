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

class FirstAidInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_aid_info)



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "STOCK BASIC FIRST AID SUPPLIES.",
                "\"Greetings, college comrades! Today, we're diving into a critical aspect of your academic journey—being prepared for unforeseen situations. As responsible scholars, it's vital to equip ourselves with the skills and resources we need. And in this session, we'll focus on a must-have: a customized first aid kit tailored to your unique college experiences.\n\n" +

                        "1. SELECTING ESSENTIAL SUPPLIES: Choose basic first aid supplies like bandages, gauze, antiseptics, and medications that are relevant to your travel plans and potential needs.\n\n" +
                        "2. ORGANIZING BY USAGE: Categorize and organize the supplies based on common injuries or ailments you may encounter during your specific type of travel.\n\n" +
                        "3. ASSEMBLING THE KIT: Place the selected items in a suitable container or bag, ensuring they are well-organized and easy to access.\n\n" +
                        "4. LABELING AND DOCUMENTATION: Clearly label the kit and include a quick reference card detailing the contents and their uses for quick access during emergencies.\n\n" +
                        "5. REGULAR INSPECTION: Periodically check the kit to replace expired or used items, ensuring that it remains fully functional and ready for use.\n\n" +
                        "6. IMMEDIATE RESPONSE: Having a well-stocked first aid kit ensures you can respond promptly to injuries or medical issues, providing vital care until professional help is available.\n\n" +
                        "7. TAILORED PREPAREDNESS: Customize your first aid supplies based on the type of travel you undertake, whether it's for road trips, outdoor adventures, or international journeys.\n\n" +
                        "8. INJURY PREVENTION: Anticipating common travel-related injuries or illnesses allows for proactive measures, reducing the risk of complications and disruptions to your plans.\n\n" +
                        "9. PEACE OF MIND: Knowing you have a properly stocked first aid kit provides peace of mind and promotes self-sufficiency in handling minor emergencies, enhancing your travel experience.\n\n" +
                        "10. SAFETY AND RESPONSIBILITY: Stocking basic first aid supplies reflects your commitment to personal safety and the well-being of fellow travelers, contributing to a safer and more responsible travel environment.\n\n",

                R.drawable.img_94,
                "https://www.youtube.com/watch?v=dYKdWsVtbaE&ab_channel=IndependenceBlueCross",
                "https://www.youtube.com/watch?v=dYKdWsVtbaE&pp=ygUmSG93IHRvIHN0b2NrIHRoZSBwZXJmZWN0IGZpcnN0IGFpZCBraXQ%3D"
            )
        )
        dataList.add(
            DataItem("TRAIN STAFF IN FIRST AID PROCEDURES.",
                "In the context of workplace safety, staff training in first aid procedures is indispensable. Today, we'll focus on mastering the primary survey, following the DR ABC protocol, to ensure our team can respond effectively in situations where someone has collapsed, potentially saving lives and minimizing workplace medical incidents' impact.\n\n" +
                        "1. PRIMARY SURVEY (DR ABC): Staff should be trained in conducting the primary survey, following the DR ABC protocol outlined in the script. This involves assessing for Danger, checking for Response, ensuring an open Airway, monitoring Breathing, and evaluating Circulation, as described in the provided script.\n\n" +
                        "2. ASSESSING DANGER AND RESPONSE: Employees should learn to recognize potential dangers in emergency situations and ensure their safety before approaching the casualty, as emphasized in the script. They should also know how to communicate with an unresponsive casualty to elicit a response.\n\n" +
                        "3. AIRWAY AND BREATHING ASSESSMENT: Staff should be trained in opening an unresponsive casualty's airway and assessing normal breathing, as described in the script. They should be prepared to initiate CPR and call for emergency help if necessary.\n\n" +
                        "4. TRAINING ON EQUIPMENT USE: Ensure that SAR team members are trained in the proper use and care of all equipment. Training should cover storage, handling, and emergency troubleshooting procedures.\n\n" +
                        "5. CIRCULATION AND BLEEDING CONTROL: After addressing the airway and breathing, responders should check for signs of severe bleeding and take steps to control it to prevent life-threatening shock. If bleeding is present, calling for emergency assistance and providing appropriate first aid measures are essential.\n\n" +
                        "6. RAPID RESPONSE: Conducting a primary survey allows responders to initiate assistance quickly and make critical decisions in a time-sensitive manner. The structured approach ensures that life-threatening conditions are identified and addressed promptly.\n\n" +
                        "7. INCREASED SURVIVAL RATES: Training in the primary survey empowers individuals to recognize and respond to medical emergencies effectively. This can significantly increase the chances of survival for the casualty, especially in situations like cardiac arrest or severe bleeding.\n\n" +
                        "8. MINIMIZING COMPLICATIONS: By following the DR ABC protocol, responders can identify and manage potential complications early. For example, opening the airway and ensuring normal breathing can prevent oxygen deprivation and brain damage.\n\n" +
                        "9. EFFECTIVE COMMUNICATION: The script emphasizes the importance of introducing oneself and asking questions to elicit a response from the casualty. Effective communication not only aids in assessing the casualty's condition but also provides reassurance and support during a stressful situation.\n\n" +

                        "10. COORDINATION WITH EMERGENCY SERVICES: The script highlights the importance of calling for emergency help (999/112) when necessary. This step ensures that professional medical assistance is on the way, and the responder can focus on immediate care until help arrives.\n\n",


                R.drawable.img_95,
                "https://www.youtube.com/watch?v=ea1RJUOiNfQ&ab_channel=StJohnAmbulance",
                "https://www.youtube.com/watch?v=ea1RJUOiNfQ&pp=ygVFSG93IHRvIGRvIHRoZSBQcmltYXJ5IFN1cnZleSAtIEZpcnN0IEFpZCBUcmFpbmluZyAtIFN0IEpvaG4gQW1idWxhbmNl")
        )
        dataList.add(
            DataItem("PROVIDE EMERGENCY MEDICAL CONTACT INFO.",
                "Hey college students, in today's tech-savvy world, quick access to emergency medical info on smartphones is a game-changer. But it's not just for techies – healthcare pros and emergency responders, this one's for you too. Join us as we explore the vital skill of efficiently retrieving smartphone emergency medical ID info on both Android and Apple iPhones.\n\n" +
                        "1. EASY ACCESS FOR CRITICAL INFORMATION: accessing smartphone emergency medical id information is a straightforward process for both android and apple iphones, as demonstrated in the video. healthcare providers and responders can quickly retrieve essential medical details when needed.\n\n" +
                        "2. EDUCATIONAL OUTREACH: The Kessler Trauma Center's proactive educational program emphasizes the significance of utilizing smartphone emergency medical ID features. Healthcare providers with direct patient care responsibilities are encouraged to be well-versed in accessing this information in emergency situations.\n\n" +
                        "3. ANDROID ACCESS: On locked Android phones, simply swipe up on the screen, tap \"Emergency\" at the bottom of the lock screen, and select \"Emergency Information\" to view the patient's medical and emergency contact details. This process ensures timely access to critical information.\n\n" +
                        "4. APPLE IPHONE ACCESS (NEWER MODELS): For newer iPhones without a home button (e.g., iPhone X series, 11, or newer), simultaneously press and hold the side button and volume up button to activate the emergency screen. Swipe the \"Medical ID\" slider to the right to access important medical information.\n\n" +
                        "5. APPLE IPHONE ACCESS (OLDER MODELS): On older iPhone models with a home button, press the home button to open the lock screen. Tap \"Emergency\" in the lower-left corner, and then select \"Medical ID.\" This grants healthcare providers access to vital medical and contact information.\n\n" +
                        "6. LIFE-SAVING POTENTIAL: Rapid access to smartphone emergency medical ID information holds the potential to save lives in critical situations. It allows healthcare providers and responders to make informed decisions and provide appropriate care promptly.\n\n" +
                        "7. PATIENT COMMUNICATION CHALLENGES: The importance of this feature becomes evident when patients are unable to communicate due to injury, illness, or loss of consciousness. Having access to their medical history and emergency contacts is invaluable in such scenarios.\n\n" +
                        "8. TRANSPORTATION CONSIDERATIONS: Healthcare professionals responsible for transporting patients to medical facilities should consider bringing the patient's smartphone with them, especially if the patient is unresponsive. The information stored on the device could significantly aid in the patient's care.\n\n" +
                        "9. SIMPLE AND QUICK PROCESS: The video demonstrates that the process of accessing emergency medical information on smartphones is straightforward and does not consume much time. It is a minimal effort that can yield substantial benefits in terms of patient care.\n\n" +
                        "10. PROMOTING AWARENESS: Encouraging the practice of checking for smartphone emergency medical ID activation should be an integral part of healthcare training and protocols. This awareness ensures that healthcare providers are prepared to utilize this valuable resource when needed.\n\n",

                R.drawable.img_457,
                "https://www.youtube.com/watch?v=SXwXjw1Q-88&ab_channel=URKesslerTrauma",
                "https://www.youtube.com/watch?v=SXwXjw1Q-88&pp=ygUvU21hcnRwaG9uZSBFbWVyZ2VuY3kgTWVkaWNhbCBJRCBBY2Nlc3MgVHV0b3JpYWw%3D")
        )
        dataList.add(
                DataItem("Maintain an AED (Automated External Defibrillator).",

                "For all you college students out there, ever wondered how a life-saving device can restart a stopped heart? Well, here's the scoop on Automated External Defibrillators, or AEDs. But, hey, healthcare pros and emergency responders, this one's for you too. Join us as we dive into the world of AEDs, learning not only how to use them but also how to keep them primed for action.\n\n" +






                        "1. EMERGENCY CALL: In the event of an unresponsive individual not breathing normally, the first step is to call 999 or 112 for emergency assistance and request an AED if available.\n\n" +
                        "2. CPR INITIATION: If alone, immediately initiate CPR with chest compressions while waiting for the AED to arrive. It's crucial not to leave the casualty to search for the AED at this stage.\n\n" +
                        "3. AED ACTIVATION: Once the AED arrives, ensure it is switched on while CPR is continued. The AED provides a series of visual and verbal prompts to guide users through the process.\n\n" +
                        "4. PAD APPLICATION: Follow the AED's instructions, which typically include removing clothing from the patient's chest, placing the pads on bare skin as indicated in the pictures, and pressing them firmly.\n\n" +
                        "5. SHOCK DELIVERY: After pad application, the AED analyzes the heart rhythm and may instruct users to stand clear while it delivers a shock if necessary. Following the shock, users are guided to provide chest compressions and rescue breaths.\n\n" +
                        "6. TIMELY INTERVENTION: Using an AED in the crucial minutes before an ambulance arrives can be a life-saving intervention, as it helps restore a normal heart rhythm during cardiac arrest.\n\n" +
                        "7. USER-FRIENDLY DESIGN: AEDs are designed to be user-friendly, ensuring that even individuals without medical training can confidently and effectively use them to aid a person in distress.\n\n" +
                        "8. MINIMIZING ERROR: The AED's ability to analyze the casualty's heart rhythm and provide clear, step-by-step instructions minimizes the risk of errors during a high-stress situation.\n\n" +
                        "9. ACCESSIBLE TO ALL: Anyone, including bystanders, can use an AED, making it a valuable resource in locations where immediate medical assistance may not be readily available.\n\n" +
                        "10. INCREASED SURVIVAL RATES: The use of AEDs, as demonstrated in the video, contributes significantly to increasing the chances of survival during cardiac arrest incidents, emphasizing their critical role in saving lives.\n\n",





                R.drawable.img_97,
                "https://www.youtube.com/watch?v=UFvL7wTFzl0&ab_channel=StJohnAmbulance",
                    "https://www.youtube.com/watch?v=UFvL7wTFzl0&pp=ygVJSG93IHRvIFVzZSBhIERlZmlicmlsbGF0b3IgKEFFRCkgLSBGaXJzdCBBaWQgVHJhaW5pbmcgLSBTdCBKb2huIEFtYnVsYW5jZQ%3D%3D")
        )
        dataList.add(
            DataItem("Establish triage and medical treatment areas.",
                "Amidst the chaos of emergencies and disasters, when resources are stretched thin, mastering triage and creating medical treatment areas are absolute musts. Join us in this video, led by Beth Beam from UNMC's College of Nursing, as we explore the core principles of triage and gain valuable insights on establishing and managing medical treatment zones efficiently. Together, we'll ensure a methodical and well-organized response to mass casualties.\n\n" +

                        "1. IDENTIFY AND ANNOUNCE YOURSELF: Begin by identifying yourself and your role. Clear communication is vital in emergency situations.\n\n" +
                        "2. VOICE TRIAGE: Initiate voice triage by announcing your presence and instructing those who can walk to come to your location. Assign someone to tag individuals who respond to voice triage.\n\n" +
                        "3. EVALUATE REMAINING VICTIMS: Systematically evaluate each remaining victim, assessing their condition and tagging them based on their triage category. Tags can be simple colored strips or comprehensive cards with relevant data fields.\n\n" +
                        "• Green (Minor): Injuries treatable with basic first-aid.\n\n" +
                        "• Yellow (Delayed): Injuries requiring medical treatment but not life-threatening.\n\n" +
                        "• Red (Immediate): Life-threatening injuries necessitating rapid treatment.\n\n" +
                        "• Black (Deceased): Victims not spontaneously breathing and considered deceased unless additional resources arrive.\n\n" +
                        "5. Triage Steps: Follow these essential triage steps:\n\n" +
                        "Step 1 - AIRWAY AND BREATHING: Open the airway and check for breathing. Over 30 breaths per minute indicate shock, requiring immediate tagging and shock treatment.\n\n" +
                        "step 2 - CIRCULATION AND BLEEDING: check circulation using the blanch test. if color takes more than two seconds to return, tag the victim as immediate. control severe bleeding promptly.\n\n" +




                        "6. RESOURCE OPTIMIZATION: Triage and medical treatment areas ensure that limited resources are allocated efficiently, maximizing the impact of available medical assistance.\n\n" +
                        "7. CLEAR COMMUNICATION: Effective triage allows responders to communicate their roles clearly, reducing confusion and enhancing coordination.\n\n" +
                        "8. PRIORITIZING CARE: The triage process prioritizes care based on the severity of injuries, ensuring that immediate attention is given to those in critical condition.\n\n" +
                        "9. SWIFT DECISION-MAKING: Triage enables swift decision-making, allowing responders to focus on providing life-saving interventions promptly.\n\n" +
                        "10. ADAPTABILITY: Triage protocols, as demonstrated in the video, provide a flexible framework that can be adjusted based on the unique characteristics of each emergency event and the available resources, ensuring an efficient response to mass casualties.\n\n",





                R.drawable.img_98,
                "https://www.youtube.com/watch?v=9QHDs10e-G0&ab_channel=UNMCHEROES",
                "https://www.youtube.com/watch?v=9QHDs10e-G0&pp=ygUTU1RBUlQgVHJpYWdlIEJhc2ljcw%3D%3D")
        )
        dataList.add(
            DataItem("Ambulance Services Standards and Guidelines",
                "In the Philippines, the provision of ambulance services is essential for ensuring the timely and effective care of individuals facing medical emergencies. The Philippine Red Cross has established comprehensive standards and guidelines for ambulance operations, as well as emergency dispatch procedures. This video serves as a reference and educational resource for ambulance crews and EMS providers, outlining the critical protocols that must be followed during medical emergencies and patient transport.\n\n" +


                        "1. COMPREHENSIVE FRAMEWORK: The Philippine Red Cross's Ambulance Services Standards and Guidelines serve as a consolidated reference, encompassing all relevant institutional memoranda, operational standards, and standing orders related to ambulance use and management. It establishes a unified framework for consistent practices across different Red Cross chapters in the Philippines.\n\n" +
                        "2. OPERATIONAL GUIDELINES: These guidelines cover a wide range of topics, including the proper administration and maintenance of ambulance vehicles and equipment, qualifications and responsibilities of EMS personnel, and the coordination of communication between ambulance teams and the emergency dispatch unit.\n\n" +
                        "3. REGULATORY ALIGNMENT: The standards and guidelines adhere to government regulatory standards, ensuring that the qualifications and practices of EMS personnel align with national regulations. This alignment helps maintain a high level of care and professionalism in the field.\n\n" +
                        "4. EMERGENCY DISPATCH: The guidebook provides detailed instructions for establishing and maintaining communication with the emergency dispatch unit throughout the ambulance team's shift. Effective communication is vital for efficient emergency response and patient care.\n\n" +
                        "5. PATIENT CARE PROTOCOLS: It outlines procedures for completing pre-hospital patient care reports, emphasizing the importance of accurate documentation in patient care. The guidelines also address handling special scenarios, such as non-initiation during crime scenes and responding to communicable diseases.\n\n" +
                        "6. SCOPE OF PRACTICE: The document defines the scope of practice for ambulance teams, ensuring that they are well-prepared to handle various medical scenarios and emergencies.\n\n" +
                        "7. CONTINUITY OF CARE: A core principle emphasized throughout the guidebook is the continuity of care. From the initial ground response to the application of pre-hospital care, safe ambulance transport, and handoff to appropriate medical facilities, the document underscores the importance of seamless care.\n\n" +
                        "8. CONTINUOUS IMPROVEMENT: The Ambulance Services Standards and Guidelines are considered a \"living document\" with a framework for updates and revisions. Scheduled reviews will take place every three years to ensure that the guidelines remain aligned with the latest knowledge and skills in emergency medical services.\n\n" +
                        "8. OPTIMAL PATIENT CARE: Ultimately, these protocols are designed to optimize patient care, uphold professionalism, and ensure that all ambulance-related assets and resources are properly maintained and accounted for by Philippine Red Cross EMS personnel.\n\n" +
                        "10. TARGET AUDIENCE: These standards and guidelines primarily serve EMS providers and ambulance teams within the Philippine Red Cross, helping them deliver high-quality pre-hospital care and medical transportation services in compliance with established protocols and regulatory standards.\n\n",





                R.drawable.img_99,
                "https://www.youtube.com/watch?v=Xu9zdIwnJ0U&ab_channel=Etactics",
                "https://www.youtube.com/watch?v=Xu9zdIwnJ0U&pp=ygVENSBSZWFsLVdvcmxkIEV4YW1wbGVzIG9mIE1lZGljYWwgQXBwb2ludG1lbnQgVHJhbnNwb3J0YXRpb24gU2VydmljZXM%3D")
        )
        dataList.add(
            DataItem("Coordinate with local healthcare providers.",
                "Hey there, college students! Get ready for a captivating exploration of the Philippine healthcare system. As we venture into this fascinating world, we'll break down its complex structure into six crucial building blocks. Join us on this educational journey as we unveil the strengths and challenges of a healthcare system that impacts millions of lives in the Philippines. Whether you're studying medicine or simply curious, this insight-packed presentation is sure to broaden your horizons.\n\n" +

                        "1. COMPREHENSIVE FRAMEWORK: The Philippine Red Cross's Ambulance Services Standards and Guidelines serve as a consolidated reference, encompassing all relevant institutional memoranda, operational standards, and standing orders related to ambulance use and management. It establishes a unified framework for consistent practices across different Red Cross chapters in the Philippines.\n\n" +
                        "2. SPECIALIZATION AND REFERRAL: Patients can choose from various providers depending on their healthcare needs. For complex cases, patients are referred to hospitals, with the choice of the facility depending on the severity and complexity of the condition.\n\n" +
                        "3. HUMAN RESOURCES: The Philippines has a significant number of healthcare workers, including nurses, doctors, midwives, and medical technologists. However, there is still a shortage of healthcare professionals, leading to challenges in providing adequate care.\n\n" +
                        "4. MEDICATIONS AND MEDICAL DEVICES: The availability of essential medicines and medical devices varies, with some facilities experiencing shortages. Patients may need to purchase these items from private pharmacies and medical device resellers.\n\n" +
                        "5. HEALTH INFORMATION SYSTEMS: The healthcare system collects data to monitor diseases, epidemics, and pandemics. Efforts to modernize and digitize health information systems have been made, with a growing adoption of telemedicine, especially during the pandemic.\n\n" +

                        "The importance of the Philippine healthcare system's coordination with local providers:\n\n" +
                        "1. ACCESSIBILITY: The presence of a network of local healthcare providers, including barangay health stations and rural health units, ensures that healthcare services are accessible to people in both urban and remote areas of the Philippines.\n\n" +
                        "2. CUSTOMIZED CARE: Patients have the flexibility to choose healthcare providers based on their specific needs, from routine check-ups at local health stations to specialized treatments at hospitals, improving the quality and customization of healthcare services.\n\n" +
                        "3. EFFICIENT REFERRAL SYSTEM: The tiered structure of healthcare facilities, from primary care centers to tertiary hospitals, allows for efficient referrals based on the severity and complexity of medical conditions, ensuring patients receive appropriate care promptly.\n\n" +
                        "4. HUMAN RESOURCES: The healthcare system benefits from a diverse workforce of healthcare professionals, including nurses, doctors, and midwives, enhancing the capacity to address a wide range of health concerns.\n\n" +
                        "5. DATA-DRIVEN HEALTHCARE: The collection of health data and the adoption of telemedicine contribute to better disease monitoring, early detection of outbreaks, and improved healthcare delivery, which are crucial for public health and well-being.\n\n",

                R.drawable.img_101,
                "https://www.youtube.com/watch?v=J25bd7mpgr8&ab_channel=LakanCortezMD",
                "https://www.youtube.com/watch?v=J25bd7mpgr8&pp=ygUyQSBCcmllZiBSZXZpZXcgb2YgdGhlIFBoaWxpcHBpbmUgSGVhbHRoY2FyZSBTeXN0ZW0%3D")
        )
        dataList.add(
            DataItem("MONITOR PUBLIC HEALTH DURING DISASTERS.",
                " Welcome, college students, to the critical subject of public health emergency preparedness. In this discussion, we will delve into the essential procedures and significance of monitoring public health during disasters, whether they are natural or man-made. Join us as we explore the fundamental aspects of this field.\n\n" +

                        "1. PRE-PLANNING: Comprehensive preparation for a wide range of emergencies, from infectious disease outbreaks to natural disasters, including coordination among all relevant sectors and stakeholders.\n\n" +
                        "2. COORDINATED RESPONSE: Ensuring that various entities, including emergency services, utility companies, and government systems, respond in a coordinated manner during emergencies.\n\n" +
                        "3. MASS HEALTH CARE: Establishing systems capable of managing a surge in patients during mass casualty incidents, potentially involving hundreds or thousands of individuals.\n\n" +
                        "4. LABORATORY SUPPORT: Ensuring the availability of laboratories to conduct necessary tests for identifying environmental contamination and infectious diseases during emergencies.\n\n" +
                        "5. SUPPLY CHAIN MANAGEMENT: Establishing a robust supply chain to ensure that essential equipment and materials are readily available in the areas most affected by emergencies, reducing response time.\n\n" +

                        "The Importance of Monitoring public health during disasters.\n\n" +
                        "1. TIMELY RESPONSE: Public health emergency preparedness enables a rapid and well-coordinated response to crises, saving lives and minimizing the impact of disasters.\n\n" +
                        "2. COMMUNITY ENGAGEMENT: Keeping the public informed about the situation without causing unnecessary panic, fostering trust, and encouraging appropriate actions during emergencies.\n\n" +
                        "3. RESOURCE ALLOCATION: Efficiently managing resources, including supplies and personnel, to ensure they reach the areas that need them most urgently.\n\n" +
                        "4. SKILLED WORKFORCE: Having a trained and expert workforce familiar with emergency preparedness procedures ensures effective decision-making and response, even in high-stress situations.\n\n" +
                        "5. ACCOUNTABILITY: Regular testing, measurement, and evaluation of emergency response systems and expenditures to ensure they are effective, efficient, and focused on public health priorities during crises.\n\n",













                R.drawable.img_458,
                "https://www.youtube.com/watch?v=Lnoph21Je6I&ab_channel=JonathanNoel",
                "https://hazards.colorado.edu/uploads/freeform/Nurse.jpeg")
        )
        dataList.add(
            DataItem("ENSURE MEDICATION ACCESS AND STORAGE.",
                "College students, let's dive into the crucial realm of medication safety. Often, medications that are meant to heal can inadvertently harm us if mishandled. In this discussion, we'll explore key aspects of ensuring the safe use and storage of medications, a topic vital to everyone's well-being. Join us as we delve into everything you should know to keep your medication regimen safe and effective.\n\n" +

                        "1. CAREFUL LABEL READING: Always read medication labels thoroughly, focusing on essential details like the medicine's name, its intended recipient, purpose, and correct dosage. Additionally, check for any specific administration instructions.\n\n" +
                        "2. PROPER ADMINISTRATION: Follow the prescribed method of administering the medication precisely. For capsules, ensure you swallow them with water to avoid choking, or consider crushing them if advised. When dealing with liquid medications, use an accurate measuring device and double-check measurements before consumption.\n\n" +
                        "3. SAFE STORAGE PRACTICES: Abide by the storage guidelines provided on medication labels. Never remove labels, and store medications separately, using color codes if necessary. Avoid the bathroom as a storage location due to humidity and warmth. Keep all medications out of children's reach.\n\n" +
                        "4. CHILD MEDICATION SAFETY: When administering medication to children, adhere to the prescribed dosage instructions from healthcare professionals. Ensure that medication containers are securely sealed and inaccessible to children. Never mix medication with candy, and maintain vigilant supervision.\n\n" +
                        "5. DISPOSAL OF EXPIRED MEDICATIONS: Dispose of expired medications responsibly. You can discard them in the trash, flush them down the toilet (if appropriate), return them to a local pharmacy (if accepted), or hand them over to hazardous waste collection facilities (if available).\n\n" +

                        "The Importance of Monitoring public health during disasters.\n\n" +
                        "1. PREVENTING HARM: Proper medication handling prevents accidental overdose, mix-ups, or unsafe concoctions, reducing the risk of harm to individuals.\n\n" +
                        "2. OPTIMAL MEDICATION EFFICACY: Following correct administration procedures ensures that medications work as intended, leading to better health outcomes.\n\n" +
                        "3. AVOIDING MEDICATION ERRORS: Thorough label reading minimizes the chances of taking the wrong medication or incorrect doses, preventing potential complications.\n\n" +
                        "4. SAFE CHILD MEDICATION USE: Implementing child safety measures safeguards young ones from accidental medication ingestion, which can have severe consequences.\n\n" +
                        "5. ENVIRONMENTAL RESPONSIBILITY: Proper disposal of expired medications helps protect the environment and prevents these substances from entering water supplies or ecosystems.\n\n",








                R.drawable.img_459,
                "https://www.youtube.com/watch?v=iQozgr7XnoY&ab_channel=MedicalCentric",
                "https://pphealthcaresolutions.co.uk/wp-content/uploads/2023/04/A-Guide-to-the-Proper-Storage-of-Medication-in-Hospitals.jpg")
        )
        dataList.add(
            DataItem("SET UP INFECTION CONTROL MEASURES.",
                "Are you ready to dive into the world of infection prevention and control? In this enlightening video, we'll explore the critical aspects of this essential field, brought to you by the experts at the Mid and South Essex Hospital. Whether you're a curious college student or a healthcare enthusiast, understanding infection control is vital. So, let's embark on this educational journey together.\n\n" +




                        "1. CHAIN OF INFECTION: Explore the six stages of the chain of infection, from infectious agents to susceptible hosts, to understand how germs spread and how to break the cycle.\n\n" +
                        "2. PREVENTING HEALTHCARE-ASSOCIATED INFECTIONS (HAIS): Discover the legal duty of healthcare providers to protect patients, staff, and visitors from HAIs, and learn how to reduce the risk through consistent prevention practices.\n\n" +
                        "3. SCREENING AND MANAGING MRSA: Uncover the importance of screening patients for Methicillin-Resistant Staphylococcus Aureus (MRSA) and the measures taken to prevent its spread in healthcare settings.\n\n" +
                        "4. CONTROLLING CLOSTRIDIUM DIFFICILE (C. DIFF): Understand how C. diff infections occur, and learn the procedures for isolation, specimen collection, and patient care to prevent its transmission.\n\n" +
                        "5. HAND HYGIENE AND PERSONAL PROTECTIVE EQUIPMENT (PPE): Master the \"Five Moments of Hand Hygiene\" and the proper use of PPE, including gloves, aprons, goggles, and respiratory protection, to shield against harmful microorganisms.\n\n" +

                        "Importance of Setting Up Infection Control Measures:\n\n" +
                        "1. PATIENT SAFETY: Infection control measures safeguard patients, ensuring their protection from healthcare-associated infections during their hospital stay.\n\n" +
                        "2. HEALTHCARE COST REDUCTION: By preventing HAIs, healthcare institutions can save significant costs associated with prolonged hospital stays and treatments.\n\n" +
                        "3. PREVENTING ANTIBIOTIC RESISTANCE: Proper infection control helps prevent the spread of antibiotic-resistant bacteria, preserving the effectiveness of these crucial medications.\n\n" +
                        "4. SAFE CHILD MEDICATION USE: Implementing child safety measures safeguards young ones from accidental medication ingestion, which can have severe consequences.\n\n" +
                        "5. ENVIRONMENTAL RESPONSIBILITY: Proper disposal of expired medications helps protect the environment and prevents these substances from entering water supplies or ecosystems.\n\n",






                R.drawable.img_104,
                "https://www.youtube.com/watch?v=U_J7UOy5euo&ab_channel=MidEssexHospitalServicesNHSTrust",
                "https://i.ytimg.com/vi/U_J7UOy5euo/hqdefault.jpg?sqp=-oaymwEcCOADEI4CSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAj_8zwFsp3HAaX1caOZTiCCNgUIw")
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