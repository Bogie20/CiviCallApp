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

class CommunicationAndInformationInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communication_and_information_info)




        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "Develop a communication plan.",
                "Are you ready to make a real impact with your nonprofit organization? One of the key factors in achieving your vision is assembling a dedicated team of volunteers who share your passion. In this informative context, we'll explore three easy yet powerful ways to get volunteers excited about joining your cause, ensuring your nonprofit's success.\n\n" +


                        "1. Create Detailed Job Descriptions: Craft comprehensive job descriptions for your volunteer opportunities. Clearly outline the roles and responsibilities, allowing potential volunteers to understand what they're signing up for and attracting individuals who align with your nonprofit's mission.\n\n" +
                        "2. Host Volunteer Orientations: Once you've identified potential volunteers, invest in their onboarding experience. Conduct volunteer orientations where you introduce them to your organization, its mission, vision, and values. This alignment will inspire motivation and commitment among your volunteers.\n\n" +
                        "3. Invest in Personal Development: Recognize that your volunteers are individuals with their own aspirations. Take the time to understand their personal goals and dreams. Find opportunities to add value to their lives, whether through networking, resume-building experiences, or personal mentorship.\n\n" +

                        "The Importance of Monitoring public health during disasters.\n\n" +
                        "1. Team Expansion: Volunteers significantly expand your nonprofit's capacity to execute projects and initiatives, allowing you to achieve your mission more effectively.\n\n" +
                        "2. Alignment and Motivation: Volunteer orientations foster alignment with your organization's goals, motivating volunteers to actively contribute to your cause.\n\n" +
                        "3. Long-Term Commitment: By investing in your volunteers' personal development, you cultivate long-term commitment, ensuring their continued support and dedication.\n\n" +
                        "4. Community Engagement: Engaged and motivated volunteers become powerful advocates, helping your nonprofit connect with the community, attract donors, and expand its reach.\n\n" +
                        "5. Sustainability: Building a team of passionate volunteers ensures the sustainability of your nonprofit, as they become an integral part of your mission, working together to make a lasting impact.\n\n",



                R.drawable.love2,
                "https://www.youtube.com/watch?v=mZfwoA1aZJk&ab_channel=ChisholmLawFirm"
            )
        )
        dataList.add(
            DataItem("Set up an emergency operations center.",
                "Ensuring that staff members are trained in first aid procedures and first aid medical care is vital, especially when faced with situations where someone has collapsed. This training equips employees with the knowledge and skills needed to perform an initial assessment, known as the primary survey, following the DR ABC protocol. By understanding and implementing these procedures, staff can respond effectively to emergencies, potentially saving lives and minimizing the impact of injuries or medical incidents within the workplace.\n\n" +

                        "1. Pre-Planning: Comprehensive preparation for a wide range of emergencies, from infectious disease outbreaks to natural disasters, including coordination among all relevant sectors and stakeholders.\n\n" +
                        "2. Coordinated Response: Ensuring that various entities, including emergency services, utility companies, and government systems, respond in a coordinated manner during emergencies.\n\n" +
                        "3. Mass Health Care: Establishing systems capable of managing a surge in patients during mass casualty incidents, potentially involving hundreds or thousands of individuals.\n\n" +
                        "4. Laboratory Support: Ensuring the availability of laboratories to conduct necessary tests for identifying environmental contamination and infectious diseases during emergencies.\n\n" +
                        "5. Supply Chain Management: Establishing a robust supply chain to ensure that essential equipment and materials are readily available in the areas most affected by emergencies, reducing response time.\n\n" +

                        "The Importance of Monitoring public health during disasters.\n\n" +
                        "1. Timely Response: Public health emergency preparedness enables a rapid and well-coordinated response to crises, saving lives and minimizing the impact of disasters.\n\n" +
                        "2. Community Engagement: Keeping the public informed about the situation without causing unnecessary panic, fostering trust, and encouraging appropriate actions during emergencies.\n\n" +
                        "3. Resource Allocation: Efficiently managing resources, including supplies and personnel, to ensure they reach the areas that need them most urgently.\n\n" +
                        "4. Skilled Workforce: Having a trained and expert workforce familiar with emergency preparedness procedures ensures effective decision-making and response, even in high-stress situations.\n\n" +
                        "5. Accountability: Regular testing, measurement, and evaluation of emergency response systems and expenditures to ensure they are effective, efficient, and focused on public health priorities during crises.\n\n",




                R.drawable.love2,
                "https://www.youtube.com/watch?v=ea1RJUOiNfQ&ab_channel=StJohnAmbulance")
        )
        dataList.add(
            DataItem("Establish redundant communication channels.",
                "Ensuring that emergency medical contact information is readily accessible on smartphones has become a critical component of modern first aid and medical care. In this digital age, being able to swiftly access vital medical details on a patient's smartphone can be a lifesaving practice for healthcare providers and emergency responders. This video from the Kessler Trauma Center serves as a valuable resource, guiding healthcare professionals on how to retrieve smartphone emergency medical ID information efficiently. Let's delve into the importance and methods of accessing this information on both Android and Apple iPhones.\n\n" +

                        "1. Pre-Planning: Comprehensive preparation for a wide range of emergencies, from infectious disease outbreaks to natural disasters, including coordination among all relevant sectors and stakeholders.\n\n" +
                        "2. Coordinated Response: Ensuring that various entities, including emergency services, utility companies, and government systems, respond in a coordinated manner during emergencies.\n\n" +
                        "3. Mass Health Care: Establishing systems capable of managing a surge in patients during mass casualty incidents, potentially involving hundreds or thousands of individuals.\n\n" +
                        "4. Laboratory Support: Ensuring the availability of laboratories to conduct necessary tests for identifying environmental contamination and infectious diseases during emergencies.\n\n" +
                        "5. Supply Chain Management: Establishing a robust supply chain to ensure that essential equipment and materials are readily available in the areas most affected by emergencies, reducing response time.\n\n" +

                        "The Importance of Monitoring public health during disasters.\n\n" +
                        "1. Timely Response: Public health emergency preparedness enables a rapid and well-coordinated response to crises, saving lives and minimizing the impact of disasters.\n\n" +
                        "2. Community Engagement: Keeping the public informed about the situation without causing unnecessary panic, fostering trust, and encouraging appropriate actions during emergencies.\n\n" +
                        "3. Resource Allocation: Efficiently managing resources, including supplies and personnel, to ensure they reach the areas that need them most urgently.\n\n" +
                        "4. Skilled Workforce: Having a trained and expert workforce familiar with emergency preparedness procedures ensures effective decision-making and response, even in high-stress situations.\n\n" +
                        "5. Accountability: Regular testing, measurement, and evaluation of emergency response systems and expenditures to ensure they are effective, efficient, and focused on public health priorities during crises.\n\n",



                R.drawable.love2,
                "https://www.youtube.com/watch?v=SXwXjw1Q-88&ab_channel=URKesslerTrauma")
        )
        dataList.add(
            DataItem("Monitor weather and disaster alerts.",

                "An Automated External Defibrillator, or AED, is a remarkable life-saving device that plays a pivotal role in responding to cardiac arrest situations. Its ability to deliver electric shocks to the heart can potentially restart it when it has stopped. In this context, maintaining an AED in top working condition is of utmost importance. This video from St John Ambulance provides valuable insights into not only how to use an AED but also how to ensure it remains ready for action at all times. Let's explore the essential aspects of AED maintenance that are critical in first aid and medical care.\n\n" +





                        "1. Pre-Planning: Comprehensive preparation for a wide range of emergencies, from infectious disease outbreaks to natural disasters, including coordination among all relevant sectors and stakeholders.\n\n" +
                        "2. Coordinated Response: Ensuring that various entities, including emergency services, utility companies, and government systems, respond in a coordinated manner during emergencies.\n\n" +
                        "3. Mass Health Care: Establishing systems capable of managing a surge in patients during mass casualty incidents, potentially involving hundreds or thousands of individuals.\n\n" +
                        "4. Laboratory Support: Ensuring the availability of laboratories to conduct necessary tests for identifying environmental contamination and infectious diseases during emergencies.\n\n" +
                        "5. Supply Chain Management: Establishing a robust supply chain to ensure that essential equipment and materials are readily available in the areas most affected by emergencies, reducing response time.\n\n" +

                        "The Importance of Monitoring public health during disasters.\n\n" +
                        "1. Timely Response: Public health emergency preparedness enables a rapid and well-coordinated response to crises, saving lives and minimizing the impact of disasters.\n\n" +
                        "2. Community Engagement: Keeping the public informed about the situation without causing unnecessary panic, fostering trust, and encouraging appropriate actions during emergencies.\n\n" +
                        "3. Resource Allocation: Efficiently managing resources, including supplies and personnel, to ensure they reach the areas that need them most urgently.\n\n" +
                        "4. Skilled Workforce: Having a trained and expert workforce familiar with emergency preparedness procedures ensures effective decision-making and response, even in high-stress situations.\n\n" +
                        "5. Accountability: Regular testing, measurement, and evaluation of emergency response systems and expenditures to ensure they are effective, efficient, and focused on public health priorities during crises.\n\n",






                R.drawable.love2,
                "https://www.youtube.com/watch?v=UFvL7wTFzl0&ab_channel=StJohnAmbulance")
        )
        dataList.add(
            DataItem("Train staff in emergency communication.",
                "In the face of emergencies and disasters, where the number of victims may exceed the available resources, effective triage and the establishment of medical treatment areas become critical. This video, presented by Beth Beam from UNMC's College of Nursing, provides insights into the fundamental concepts of triage and offers valuable guidance on how to efficiently set up and manage medical treatment areas. Let's delve into the essential aspects of this process, ensuring a systematic and organized response to mass casualties.\n\n" +

                        "1. Identify and Announce Yourself: Begin by identifying yourself and your role. Clear communication is vital in emergency situations.\n\n" +
                        "2. Voice Triage: Initiate voice triage by announcing your presence and instructing those who can walk to come to your location. Assign someone to tag individuals who respond to voice triage.\n\n" +
                        "3. Evaluate Remaining Victims: Systematically evaluate each remaining victim, assessing their condition and tagging them based on their triage category. Tags can be simple colored strips or comprehensive cards with relevant data fields.\n\n" +
                        "• Green (Minor): Injuries treatable with basic first-aid.\n\n" +
                        "• Yellow (Delayed): Injuries requiring medical treatment but not life-threatening.\n\n" +
                        "• Red (Immediate): Life-threatening injuries necessitating rapid treatment.\n\n" +
                        "• Black (Deceased): Victims not spontaneously breathing and considered deceased unless additional resources arrive.\n\n" +
                        "5. Triage Steps: Follow these essential triage steps:\n\n" +
                        "Step 1 - Airway and Breathing: Open the airway and check for breathing. Over 30 breaths per minute indicate shock, requiring immediate tagging and shock treatment.\n\n" +
                        "Step 2 - Circulation and Bleeding: Check circulation using the blanch test. If color takes more than two seconds to return, tag the victim as immediate. Control severe bleeding promptly.\n\n" +




                        "6. Resource Optimization: Triage and medical treatment areas ensure that limited resources are allocated efficiently, maximizing the impact of available medical assistance.\n\n" +
                        "7. Clear Communication: Effective triage allows responders to communicate their roles clearly, reducing confusion and enhancing coordination.\n\n" +
                        "8. Prioritizing Care: The triage process prioritizes care based on the severity of injuries, ensuring that immediate attention is given to those in critical condition.\n\n" +
                        "9. Swift Decision-Making: Triage enables swift decision-making, allowing responders to focus on providing life-saving interventions promptly.\n\n" +
                        "10. Adaptability: Triage protocols, as demonstrated in the video, provide a flexible framework that can be adjusted based on the unique characteristics of each emergency event and the available resources, ensuring an efficient response to mass casualties.\n\n",





                R.drawable.love2,
                "https://www.youtube.com/watch?v=9QHDs10e-G0&ab_channel=UNMCHEROES")
        )
        dataList.add(
            DataItem("Create a public information strategy. ",
                "In the Philippines, the provision of ambulance services is essential for ensuring the timely and effective care of individuals facing medical emergencies. The Philippine Red Cross has established comprehensive standards and guidelines for ambulance operations, as well as emergency dispatch procedures. This video serves as a reference and educational resource for ambulance crews and EMS providers, outlining the critical protocols that must be followed during medical emergencies and patient transport.\n\n" +


                        "1. Comprehensive Framework: The Philippine Red Cross's Ambulance Services Standards and Guidelines serve as a consolidated reference, encompassing all relevant institutional memoranda, operational standards, and standing orders related to ambulance use and management. It establishes a unified framework for consistent practices across different Red Cross chapters in the Philippines.\n\n" +
                        "2. Operational Guidelines: These guidelines cover a wide range of topics, including the proper administration and maintenance of ambulance vehicles and equipment, qualifications and responsibilities of EMS personnel, and the coordination of communication between ambulance teams and the emergency dispatch unit.\n\n" +
                        "3. Regulatory Alignment: The standards and guidelines adhere to government regulatory standards, ensuring that the qualifications and practices of EMS personnel align with national regulations. This alignment helps maintain a high level of care and professionalism in the field.\n\n" +
                        "4. Emergency Dispatch: The guidebook provides detailed instructions for establishing and maintaining communication with the emergency dispatch unit throughout the ambulance team's shift. Effective communication is vital for efficient emergency response and patient care.\n\n" +
                        "5. Patient Care Protocols: It outlines procedures for completing pre-hospital patient care reports, emphasizing the importance of accurate documentation in patient care. The guidelines also address handling special scenarios, such as non-initiation during crime scenes and responding to communicable diseases.\n\n" +
                        "6. Scope of Practice: The document defines the scope of practice for ambulance teams, ensuring that they are well-prepared to handle various medical scenarios and emergencies.\n\n" +
                        "7. Continuity of Care: A core principle emphasized throughout the guidebook is the continuity of care. From the initial ground response to the application of pre-hospital care, safe ambulance transport, and handoff to appropriate medical facilities, the document underscores the importance of seamless care.\n\n" +
                        "8. Continuous Improvement: The Ambulance Services Standards and Guidelines are considered a \"living document\" with a framework for updates and revisions. Scheduled reviews will take place every three years to ensure that the guidelines remain aligned with the latest knowledge and skills in emergency medical services.\n\n" +
                        "8. Optimal Patient Care: Ultimately, these protocols are designed to optimize patient care, uphold professionalism, and ensure that all ambulance-related assets and resources are properly maintained and accounted for by Philippine Red Cross EMS personnel.\n\n" +
                        "10. Target Audience: These standards and guidelines primarily serve EMS providers and ambulance teams within the Philippine Red Cross, helping them deliver high-quality pre-hospital care and medical transportation services in compliance with established protocols and regulatory standards.\n\n" +
                        "The importance of the Ambulance Services Standards and Guidelines:\n\n" +
                        "1. Enhancing Patient Care: The standards and guidelines play a pivotal role in elevating the quality of patient care during medical emergencies. By establishing clear protocols and procedures, EMS personnel can provide timely and effective care to individuals in need, ultimately improving patient outcomes.\n\n" +
                        "2. Uniform Practices: These guidelines serve as a unifying framework for ambulance operations across different Red Cross chapters in the Philippines. Standardized practices ensure that every patient receives consistent and reliable care, regardless of their location within the country.\n\n" +
                        "3. Regulatory Compliance: Adherence to government regulatory standards is critical for maintaining the integrity of ambulance services. These guidelines help EMS providers align their qualifications and practices with national regulations, ensuring that the highest standards of professionalism are met.\n\n" +
                        "4. Effective Communication: Proper communication between ambulance teams and emergency dispatch units is essential for swift and coordinated responses. The guidelines emphasize the importance of establishing and maintaining communication channels, enabling EMS personnel to receive critical information and assistance promptly.\n\n" +
                        "5. Continuous Improvement: The concept of a \"living document\" underscores the commitment to ongoing improvement. Regular reviews and updates of the guidelines ensure that EMS practices remain aligned with the latest advancements in emergency medical services, enhancing the overall preparedness and effectiveness of ambulance teams.\n\n",






                R.drawable.love2,
                "https://www.youtube.com/watch?v=Xu9zdIwnJ0U&ab_channel=Etactics")
        )
        dataList.add(
            DataItem("Use social media for updates.",
                "Hey there, college students! Get ready for a captivating exploration of the Philippine healthcare system. As we venture into this fascinating world, we'll break down its complex structure into six crucial building blocks. Join us on this educational journey as we unveil the strengths and challenges of a healthcare system that impacts millions of lives in the Philippines. Whether you're studying medicine or simply curious, this insight-packed presentation is sure to broaden your horizons.\n\n" +

                        "1. Comprehensive Framework: The Philippine Red Cross's Ambulance Services Standards and Guidelines serve as a consolidated reference, encompassing all relevant institutional memoranda, operational standards, and standing orders related to ambulance use and management. It establishes a unified framework for consistent practices across different Red Cross chapters in the Philippines.\n\n" +
                        "2. Specialization and Referral: Patients can choose from various providers depending on their healthcare needs. For complex cases, patients are referred to hospitals, with the choice of the facility depending on the severity and complexity of the condition.\n\n" +
                        "3. Human Resources: The Philippines has a significant number of healthcare workers, including nurses, doctors, midwives, and medical technologists. However, there is still a shortage of healthcare professionals, leading to challenges in providing adequate care.\n\n" +
                        "4. Medications and Medical Devices: The availability of essential medicines and medical devices varies, with some facilities experiencing shortages. Patients may need to purchase these items from private pharmacies and medical device resellers.\n\n" +
                        "5. Health Information Systems: The healthcare system collects data to monitor diseases, epidemics, and pandemics. Efforts to modernize and digitize health information systems have been made, with a growing adoption of telemedicine, especially during the pandemic.\n\n" +

                        "The importance of the Philippine healthcare system's coordination with local providers:\n\n" +
                        "1. Accessibility: The presence of a network of local healthcare providers, including barangay health stations and rural health units, ensures that healthcare services are accessible to people in both urban and remote areas of the Philippines.\n\n" +
                        "2. Customized Care: Patients have the flexibility to choose healthcare providers based on their specific needs, from routine check-ups at local health stations to specialized treatments at hospitals, improving the quality and customization of healthcare services.\n\n" +
                        "3. Efficient Referral System: The tiered structure of healthcare facilities, from primary care centers to tertiary hospitals, allows for efficient referrals based on the severity and complexity of medical conditions, ensuring patients receive appropriate care promptly.\n\n" +
                        "4. Human Resources: The healthcare system benefits from a diverse workforce of healthcare professionals, including nurses, doctors, and midwives, enhancing the capacity to address a wide range of health concerns.\n\n" +
                        "5. Data-Driven Healthcare: The collection of health data and the adoption of telemedicine contribute to better disease monitoring, early detection of outbreaks, and improved healthcare delivery, which are crucial for public health and well-being.\n\n",

                R.drawable.love2,
                "https://www.youtube.com/watch?v=J25bd7mpgr8&ab_channel=LakanCortezMD")
        )
        dataList.add(
            DataItem("Implement a mass notification system.",
                " Welcome, college students, to the critical subject of public health emergency preparedness. In this discussion, we will delve into the essential procedures and significance of monitoring public health during disasters, whether they are natural or man-made. Join us as we explore the fundamental aspects of this field.\n\n" +

                        "1. Pre-Planning: Comprehensive preparation for a wide range of emergencies, from infectious disease outbreaks to natural disasters, including coordination among all relevant sectors and stakeholders.\n\n" +
                        "2. Coordinated Response: Ensuring that various entities, including emergency services, utility companies, and government systems, respond in a coordinated manner during emergencies.\n\n" +
                        "3. Mass Health Care: Establishing systems capable of managing a surge in patients during mass casualty incidents, potentially involving hundreds or thousands of individuals.\n\n" +
                        "4. Laboratory Support: Ensuring the availability of laboratories to conduct necessary tests for identifying environmental contamination and infectious diseases during emergencies.\n\n" +
                        "5. Supply Chain Management: Establishing a robust supply chain to ensure that essential equipment and materials are readily available in the areas most affected by emergencies, reducing response time.\n\n" +

                        "The Importance of Monitoring public health during disasters.\n\n" +
                        "1. Timely Response: Public health emergency preparedness enables a rapid and well-coordinated response to crises, saving lives and minimizing the impact of disasters.\n\n" +
                        "2. Community Engagement: Keeping the public informed about the situation without causing unnecessary panic, fostering trust, and encouraging appropriate actions during emergencies.\n\n" +
                        "3. Resource Allocation: Efficiently managing resources, including supplies and personnel, to ensure they reach the areas that need them most urgently.\n\n" +
                        "4. Skilled Workforce: Having a trained and expert workforce familiar with emergency preparedness procedures ensures effective decision-making and response, even in high-stress situations.\n\n" +
                        "5. Accountability: Regular testing, measurement, and evaluation of emergency response systems and expenditures to ensure they are effective, efficient, and focused on public health priorities during crises.\n\n",













                R.drawable.love2,
                "https://www.youtube.com/watch?v=Lnoph21Je6I&ab_channel=JonathanNoel")
        )
        dataList.add(
            DataItem("Provide multi-lingual information.",
                "College students, let's dive into the crucial realm of medication safety. Often, medications that are meant to heal can inadvertently harm us if mishandled. In this discussion, we'll explore key aspects of ensuring the safe use and storage of medications, a topic vital to everyone's well-being. Join us as we delve into everything you should know to keep your medication regimen safe and effective.\n\n" +

                        "1. Careful Label Reading: Always read medication labels thoroughly, focusing on essential details like the medicine's name, its intended recipient, purpose, and correct dosage. Additionally, check for any specific administration instructions.\n\n" +
                        "2. Proper Administration: Follow the prescribed method of administering the medication precisely. For capsules, ensure you swallow them with water to avoid choking, or consider crushing them if advised. When dealing with liquid medications, use an accurate measuring device and double-check measurements before consumption.\n\n" +
                        "3. Safe Storage Practices: Abide by the storage guidelines provided on medication labels. Never remove labels, and store medications separately, using color codes if necessary. Avoid the bathroom as a storage location due to humidity and warmth. Keep all medications out of children's reach.\n\n" +
                        "4. Child Medication Safety: When administering medication to children, adhere to the prescribed dosage instructions from healthcare professionals. Ensure that medication containers are securely sealed and inaccessible to children. Never mix medication with candy, and maintain vigilant supervision.\n\n" +
                        "5. Disposal of Expired Medications: Dispose of expired medications responsibly. You can discard them in the trash, flush them down the toilet (if appropriate), return them to a local pharmacy (if accepted), or hand them over to hazardous waste collection facilities (if available).\n\n" +

                        "The Importance of Monitoring public health during disasters.\n\n" +
                        "1. Preventing Harm: Proper medication handling prevents accidental overdose, mix-ups, or unsafe concoctions, reducing the risk of harm to individuals.\n\n" +
                        "2. Optimal Medication Efficacy: Following correct administration procedures ensures that medications work as intended, leading to better health outcomes.\n\n" +
                        "3. Avoiding Medication Errors: Thorough label reading minimizes the chances of taking the wrong medication or incorrect doses, preventing potential complications.\n\n" +
                        "4. Safe Child Medication Use: Implementing child safety measures safeguards young ones from accidental medication ingestion, which can have severe consequences.\n\n" +
                        "5. Environmental Responsibility: Proper disposal of expired medications helps protect the environment and prevents these substances from entering water supplies or ecosystems.\n\n",








                R.drawable.love2,
                "https://www.youtube.com/watch?v=iQozgr7XnoY&ab_channel=MedicalCentric")
        )
        dataList.add(
            DataItem("Address rumors and misinformation.",
                "Are you ready to dive into the world of infection prevention and control? In this enlightening video, we'll explore the critical aspects of this essential field, brought to you by the experts at the Mid and South Essex Hospital. Whether you're a curious college student or a healthcare enthusiast, understanding infection control is vital. So, let's embark on this educational journey together.\n\n" +




                        "1. Chain of Infection: Explore the six stages of the chain of infection, from infectious agents to susceptible hosts, to understand how germs spread and how to break the cycle.\n\n" +
                        "2. Preventing Healthcare-Associated Infections (HAIs): Discover the legal duty of healthcare providers to protect patients, staff, and visitors from HAIs, and learn how to reduce the risk through consistent prevention practices.\n\n" +
                        "3. Screening and Managing MRSA: Uncover the importance of screening patients for Methicillin-Resistant Staphylococcus Aureus (MRSA) and the measures taken to prevent its spread in healthcare settings.\n\n" +
                        "4. Controlling Clostridium difficile (C. diff): Understand how C. diff infections occur, and learn the procedures for isolation, specimen collection, and patient care to prevent its transmission.\n\n" +
                        "5. Hand Hygiene and Personal Protective Equipment (PPE): Master the \"Five Moments of Hand Hygiene\" and the proper use of PPE, including gloves, aprons, goggles, and respiratory protection, to shield against harmful microorganisms.\n\n" +

                        "Importance of Setting Up Infection Control Measures:\n\n" +
                        "1. Patient Safety: Infection control measures safeguard patients, ensuring their protection from healthcare-associated infections during their hospital stay.\n\n" +
                        "2. Healthcare Cost Reduction: By preventing HAIs, healthcare institutions can save significant costs associated with prolonged hospital stays and treatments.\n\n" +
                        "3. Preventing Antibiotic Resistance: Proper infection control helps prevent the spread of antibiotic-resistant bacteria, preserving the effectiveness of these crucial medications.\n\n" +
                        "4. Safe Child Medication Use: Implementing child safety measures safeguards young ones from accidental medication ingestion, which can have severe consequences.\n\n" +
                        "5. Environmental Responsibility: Proper disposal of expired medications helps protect the environment and prevents these substances from entering water supplies or ecosystems.\n\n",






                R.drawable.love2,
                "https://www.youtube.com/watch?v=U_J7UOy5euo&ab_channel=MidEssexHospitalServicesNHSTrust")
        )


        val adapter = DataAdapter(dataList)

        // Set an item click listener for the adapter to open the link when the reference TextView is clicked
        adapter.setOnItemClickListener(object : DataAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val clickedItem = dataList[position]
                val link = clickedItem.link

                // Open the link in a web browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(intent)
            }
        })

        // Set the adapter for the RecyclerView
        recyclerView.adapter = adapter
    }
}