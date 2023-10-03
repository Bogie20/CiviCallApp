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

    class VolunteerandDonationsManagementInfo : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_volunteerand_donations_management_info)

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager

            // Create a list of data to display in the RecyclerView
            val dataList = ArrayList<DataItem>()

            // Create a SpannableString with a larger text size for the specific portion

            dataList.add(
                DataItem(
                    "Building the Response Team: Recruiting and Training Volunteers for Disaster Response",
                    "Attention, aspiring disaster response leaders! In our ever-changing world, the role of volunteers in disaster management is more crucial than ever. Join us on a journey to explore the ins and outs of recruiting and training volunteers for effective disaster response in 'Building the Response Team.' Let's dive in!\n\n" +

                            "1. NEEDS ASSESSMENT: Begin with a comprehensive needs assessment to identify the specific requirements and areas that require volunteer support during disaster response efforts.\n\n" +
                            "2. CLEAR JOB DESCRIPTIONS: Develop clear and detailed job descriptions for different volunteer roles, outlining their responsibilities and expectations.\n\n" +
                            "3. RECRUITMENT STRATEGY: Implement a strategic recruitment plan, targeting various sources such as colleges, universities, local organizations, churches, and the private sector to attract a diverse pool of volunteers.\n\n" +
                            "4. TRAINING PROGRAMS: Establish training programs tailored to the specific roles volunteers will undertake, ensuring they are well-prepared for disaster situations.\n\n" +
                            "5. BACKGROUND CHECKS: Prioritize safety by conducting background checks on volunteers who may work in sensitive or critical situations.\n\n" +
                            "6. DATABASE MANAGEMENT: Create and maintain a comprehensive database of volunteers, including their skills, training, and availability for efficient deployment.\n\n" +
                            "7. ENGAGEMENT ACTIVITIES: Keep volunteers engaged between emergencies by organizing various activities and training sessions to maintain their skills and commitment.\n\n" +
                            "8. AFFILIATION WITH ORGANIZATIONS: Collaborate with statewide or local organizations to tap into additional resources and support when needed.\n\n" +
                            "9. LIABILITY UNDERSTANDING: Ensure volunteer coordinators understand liability laws in their state, addressing insurance and waivers as necessary.\n\n" +
                            "10. APPRECIATION AND RECOGNITION: Show appreciation and recognition to volunteers regularly, fostering a positive and supportive environment that encourages their dedication.\n\n",

                    R.drawable.img_81,
                    "https://www.govtech.com/em/disaster/how-to-recruit-retain-organize-volunteers.html",
                    "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"
                )
            )
            dataList.add(
                DataItem("Connecting Hearts and Hands: Establishing Volunteer Coordination Centers for Disaster Response",
                    "\"Attention, compassionate hearts and helping hands! In a world where disasters strike unexpectedly, the connection between volunteers and disaster response coordination is paramount. Join us on a journey to explore the vital role of volunteer coordination centers in disaster response as we delve into 'Connecting Hearts and Hands.' Let's embark on this meaningful exploration.\"\n\n" +



                            "1. ASSESS LOCAL NEEDS: Begin by conducting a thorough assessment of the specific disaster-related needs within your community. Identify areas where volunteers can make a significant impact.\n\n" +
                            "2. ESTABLISH VOLUNTEER COORDINATION CENTERS: Set up dedicated volunteer coordination centers strategically located to facilitate the recruitment, organization, and deployment of volunteers during disaster response efforts.\n\n" +
                            "3. COLLABORATE WITH VOADS: Forge partnerships with Volunteer Organizations Active in Disasters (VOADs) and faith-based groups known for their rapid volunteer mobilization. These organizations can provide valuable support and resources.\n\n" +
                            "4. VOLUNTEER ROLES AND TRAINING: Define clear volunteer roles and responsibilities and develop specialized training programs to prepare volunteers for various disaster response tasks.\n\n" +
                            "5. SAFETY MEASURES: Prioritize safety by implementing Occupational Safety and Health Administration (OSHA) guidelines. Ensure that volunteers are briefed on safety measures and equipped with appropriate safety gear.\n\n" +
                            "6. RESOURCE MANAGEMENT: Establish efficient resource management systems to request and distribute essential supplies, such as safety equipment, tools, and personal protective gear, to volunteers in the field.\n\n" +
                            "7. DOCUMENTATION AND REPORTING: Maintain thorough documentation of volunteer activities, including sign-in records and resource requests. Report all work-related accidents and incidents to the appropriate authorities.\n\n" +
                            "8. TRAINING FOR VOLUNTEER COORDINATORS: Provide comprehensive training for volunteer coordinators, including courses in the Incident Command System (ICS) and other relevant certifications.\n\n" +
                            "9. PUBLIC INFORMATION AND OUTREACH: Collaborate with public information officers to disseminate information about the volunteer coordination centers, needed skills, and volunteer opportunities. Ensure the public is aware of how to get involved.\n\n" +
                            "10. ADAPT AND ADJUST: Continuously assess and adjust volunteer coordination efforts based on the evolving needs of the disaster response. Flexibility and adaptability are key to successful volunteer management.\n\n",




                    R.drawable.img_82,
                    "http://extension.msstate.edu/publications/managing-volunteers-times-disaster-the-local-volunteer-coordinator%E2%80%99s-role",
                    "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
            )
            dataList.add(
                DataItem("Skills at the Service of Needs: Matching Expertise for Effective Disaster Response",
                    "\"Hello, future change-makers! Today, we embark on a journey of impactful volunteerism in disaster response. It's not just about lending a hand; it's about matching your unique skills with the pressing needs of communities in crisis. Join us as we explore how to harness your commitment, compassion, and communication abilities to make a real difference in times of disaster.\"\n\n" +


                            "1. IDENTIFY POTENTIAL DISASTERS: Begin by identifying the types of disasters that your community may face. This knowledge is essential for tailoring your response plan to specific scenarios.\n\n" +
                            "2. BUILD A CONTACT SHEET: Develop a comprehensive contact sheet that includes contact information for staff, board members, key volunteers, and community officials. Ensure that this contact information is regularly updated and readily accessible.\n\n" +
                            "3. DEFINE CRITICAL SERVICES: Determine the critical services your organization will provide during and after a disaster. Consider whether you will offer food assistance to disaster survivors while continuing to serve your regular clients.\n\n" +
                            "4. COLLABORATE WITH OTHER ORGANIZATIONS: Explore partnerships with other community organizations to provide food assistance. Collaboration ensures a coordinated response and avoids fragmented efforts.\n\n" +
                            "5. KEEP PLANS PRACTICAL: When developing your disaster response plan, keep it focused, practical, and simple. Recognize that a one-size-fits-all approach may not be suitable for all disaster scenarios.\n\n" +
                            "6. MAINTAIN FLEXIBILITY: Understand that every disaster is unique, and flexibility is essential. Be prepared to adapt your response based on the specific circumstances of each disaster event.\n\n" +
                            "7. PRINT AND SHARE PLANS: Keep printed and electronic copies of your disaster response plan available. Share these copies with staff, board members, and key volunteers to ensure everyone is aware of their roles and responsibilities.\n\n" +
                            "8. JOIN REGIONAL DISASTER RESPONSE NETWORKS: Consider becoming part of regional disaster response networks like the Food Bank Regional Disaster Response Network. These networks provide increased readiness, additional resources, and expertise for disaster response efforts.\n\n" +
                            "9. FOLLOW THE PHASES OF DISASTER RESPONSE: Recognize the three phases of disaster response: initial response, sustained response, and long-term recovery. Tailor your actions and resources to each phase's specific needs.\n\n" +
                            "10. RECRUIT AND ORGANIZE VOLUNTEERS: Be prepared to recruit and organize volunteers as needed, especially in the aftermath of a disaster. Volunteers play a crucial role in providing assistance to affected communities.\n\n",


                    R.drawable.love2,
                    "https://www.indeed.com/career-advice/resumes-cover-letters/skills-for-volunteering",
                    "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
            )
            dataList.add(
                DataItem("Ensuring Trust and Capability: Screening and Credentialing Volunteers in Disaster Response",

                    "In the dynamic world of non-profit and community organizations, where our youngest members deserve nothing but the best, we recognize that child safety is paramount. Regardless of your connection with the community or your role, every college volunteer must undergo a robust screening process to ensure that our children remain secure. This commitment to safeguarding extends to all adult volunteers and employees, as it's our collective responsibility to protect our most vulnerable.\n\n" +



                            "1. IDENTIFY POTENTIAL DISASTERS: Begin by identifying the types of disasters that your community may face. This knowledge is essential for tailoring your response plan to specific scenarios.\n\n" +
                            "2. BUILD A CONTACT SHEET: Develop a comprehensive contact sheet that includes contact information for staff, board members, key volunteers, and community officials. Ensure that this contact information is regularly updated and readily accessible.\n\n" +
                            "3. DEFINE CRITICAL SERVICES: Determine the critical services your organization will provide during and after a disaster. Consider whether you will offer food assistance to disaster survivors while continuing to serve your regular clients.\n\n" +
                            "4. COLLABORATE WITH OTHER ORGANIZATIONS: Explore partnerships with other community organizations to provide food assistance. Collaboration ensures a coordinated response and avoids fragmented efforts.\n\n" +
                            "5. KEEP PLANS PRACTICAL: When developing your disaster response plan, keep it focused, practical, and simple. Recognize that a one-size-fits-all approach may not be suitable for all disaster scenarios.\n\n" +
                            "6. MAINTAIN FLEXIBILITY: Understand that every disaster is unique, and flexibility is essential. Be prepared to adapt your response based on the specific circumstances of each disaster event.\n\n" +
                            "7. PRINT AND SHARE PLANS: Keep printed and electronic copies of your disaster response plan available. Share these copies with staff, board members, and key volunteers to ensure everyone is aware of their roles and responsibilities.\n\n" +
                            "8. JOIN REGIONAL DISASTER RESPONSE NETWORKS: Consider becoming part of regional disaster response networks like the Food Bank Regional Disaster Response Network. These networks provide increased readiness, additional resources, and expertise for disaster response efforts.\n\n" +
                            "9. FOLLOW THE PHASES OF DISASTER RESPONSE: Recognize the three phases of disaster response: initial response, sustained response, and long-term recovery. Tailor your actions and resources to each phase's specific needs.\n\n" +
                            "10. RECRUIT AND ORGANIZE VOLUNTEERS: Be prepared to recruit and organize volunteers as needed, especially in the aftermath of a disaster. Volunteers play a crucial role in providing assistance to affected communities.\n\n",
                    R.drawable.love2,
                    "https://www.thesilverlining.com/safety-tips/volunteer-screening-best-practices#:~:text=A%20thorough%20screening%20will%20include%20many%20of%20the%20following%3A&text=Interviews%20(in%20person%20and%20via,National%20Sex%20Offender%20Public%20Registry",
                    "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
            )
            dataList.add(
                DataItem("Efficient Giving: Managing Donations Effectively in Disaster Response",
                    "Unlock the power of meaningful giving and make your college years count! Effective donation management isn't just about handling funds; it's about creating a ripple of positive change that resonates with the community.\" In a world where generosity knows no bounds, where individuals come together to contribute a staggering \$122.9 billion in 2021 alone, the art of managing donations stands as the bridge between intent and impact. Join us on this journey as we delve into the dynamic realm of donation management, where your expertise can transform goodwill into tangible outcomes.\n\n" +


                            "1. IDENTIFY POTENTIAL DISASTERS: Begin by identifying the types of disasters that your community may face. This knowledge is essential for tailoring your response plan to specific scenarios.\n\n" +
                            "2. BUILD A CONTACT SHEET: Develop a comprehensive contact sheet that includes contact information for staff, board members, key volunteers, and community officials. Ensure that this contact information is regularly updated and readily accessible.\n\n" +
                            "3. DEFINE CRITICAL SERVICES: Determine the critical services your organization will provide during and after a disaster. Consider whether you will offer food assistance to disaster survivors while continuing to serve your regular clients.\n\n" +
                            "4. COLLABORATE WITH OTHER ORGANIZATIONS: Explore partnerships with other community organizations to provide food assistance. Collaboration ensures a coordinated response and avoids fragmented efforts.\n\n" +
                            "5. KEEP PLANS PRACTICAL: When developing your disaster response plan, keep it focused, practical, and simple. Recognize that a one-size-fits-all approach may not be suitable for all disaster scenarios.\n\n" +
                            "6. MAINTAIN FLEXIBILITY: Understand that every disaster is unique, and flexibility is essential. Be prepared to adapt your response based on the specific circumstances of each disaster event.\n\n" +
                            "7. PRINT AND SHARE PLANS: Keep printed and electronic copies of your disaster response plan available. Share these copies with staff, board members, and key volunteers to ensure everyone is aware of their roles and responsibilities.\n\n" +
                            "8. JOIN REGIONAL DISASTER RESPONSE NETWORKS: Consider becoming part of regional disaster response networks like the Food Bank Regional Disaster Response Network. These networks provide increased readiness, additional resources, and expertise for disaster response efforts.\n\n" +
                            "9. FOLLOW THE PHASES OF DISASTER RESPONSE: Recognize the three phases of disaster response: initial response, sustained response, and long-term recovery. Tailor your actions and resources to each phase's specific needs.\n\n" +
                            "10. RECRUIT AND ORGANIZE VOLUNTEERS: Be prepared to recruit and organize volunteers as needed, especially in the aftermath of a disaster. Volunteers play a crucial role in providing assistance to affected communities.\n\n",




                    R.drawable.love2,
                    "https://www.tatlerasia.com/power-purpose/philanthropy/5-tips-when-donating-to-charities-in-the-philippines",
                    "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
            )
            dataList.add(
                DataItem("Empowering Response: Prioritizing Cash Donations for Effective Disaster Relief. ",
                    "In the Philippines, the provision of ambulance services is essential for ensuring the timely and effective care of individuals facing medical emergencies. The Philippine Red Cross has established comprehensive standards and guidelines for ambulance operations, as well as emergency dispatch procedures. This video serves as a reference and educational resource for ambulance crews and EMS providers, outlining the critical protocols that must be followed during medical emergencies and patient transport.\n\n" +


                            "1. IDENTIFY POTENTIAL DISASTERS: Begin by identifying the types of disasters that your community may face. This knowledge is essential for tailoring your response plan to specific scenarios.\n\n" +
                            "2. BUILD A CONTACT SHEET: Develop a comprehensive contact sheet that includes contact information for staff, board members, key volunteers, and community officials. Ensure that this contact information is regularly updated and readily accessible.\n\n" +
                            "3. DEFINE CRITICAL SERVICES: Determine the critical services your organization will provide during and after a disaster. Consider whether you will offer food assistance to disaster survivors while continuing to serve your regular clients.\n\n" +
                            "4. COLLABORATE WITH OTHER ORGANIZATIONS: Explore partnerships with other community organizations to provide food assistance. Collaboration ensures a coordinated response and avoids fragmented efforts.\n\n" +
                            "5. KEEP PLANS PRACTICAL: When developing your disaster response plan, keep it focused, practical, and simple. Recognize that a one-size-fits-all approach may not be suitable for all disaster scenarios.\n\n" +
                            "6. MAINTAIN FLEXIBILITY: Understand that every disaster is unique, and flexibility is essential. Be prepared to adapt your response based on the specific circumstances of each disaster event.\n\n" +
                            "7. PRINT AND SHARE PLANS: Keep printed and electronic copies of your disaster response plan available. Share these copies with staff, board members, and key volunteers to ensure everyone is aware of their roles and responsibilities.\n\n" +
                            "8. JOIN REGIONAL DISASTER RESPONSE NETWORKS: Consider becoming part of regional disaster response networks like the Food Bank Regional Disaster Response Network. These networks provide increased readiness, additional resources, and expertise for disaster response efforts.\n\n" +
                            "9. FOLLOW THE PHASES OF DISASTER RESPONSE: Recognize the three phases of disaster response: initial response, sustained response, and long-term recovery. Tailor your actions and resources to each phase's specific needs.\n\n" +
                            "10. RECRUIT AND ORGANIZE VOLUNTEERS: Be prepared to recruit and organize volunteers as needed, especially in the aftermath of a disaster. Volunteers play a crucial role in providing assistance to affected communities.\n\n",






                    R.drawable.love2,
                    "https://www.youtube.com/watch?v=Xu9zdIwnJ0U&ab_channel=Etactics",
                    "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
            )
            dataList.add(
                DataItem("\"Transparent Compassion: Ensuring Accountability in Disaster Response Donations\"",
                    "Hey there, college students! Get ready for a captivating exploration of the Philippine healthcare system. As we venture into this fascinating world, we'll break down its complex structure into six crucial building blocks. Join us on this educational journey as we unveil the strengths and challenges of a healthcare system that impacts millions of lives in the Philippines. Whether you're studying medicine or simply curious, this insight-packed presentation is sure to broaden your horizons.\n\n" +


                            "1. IDENTIFY POTENTIAL DISASTERS: Begin by identifying the types of disasters that your community may face. This knowledge is essential for tailoring your response plan to specific scenarios.\n\n" +
                            "2. BUILD A CONTACT SHEET: Develop a comprehensive contact sheet that includes contact information for staff, board members, key volunteers, and community officials. Ensure that this contact information is regularly updated and readily accessible.\n\n" +
                            "3. DEFINE CRITICAL SERVICES: Determine the critical services your organization will provide during and after a disaster. Consider whether you will offer food assistance to disaster survivors while continuing to serve your regular clients.\n\n" +
                            "4. COLLABORATE WITH OTHER ORGANIZATIONS: Explore partnerships with other community organizations to provide food assistance. Collaboration ensures a coordinated response and avoids fragmented efforts.\n\n" +
                            "5. KEEP PLANS PRACTICAL: When developing your disaster response plan, keep it focused, practical, and simple. Recognize that a one-size-fits-all approach may not be suitable for all disaster scenarios.\n\n" +
                            "6. MAINTAIN FLEXIBILITY: Understand that every disaster is unique, and flexibility is essential. Be prepared to adapt your response based on the specific circumstances of each disaster event.\n\n" +
                            "7. PRINT AND SHARE PLANS: Keep printed and electronic copies of your disaster response plan available. Share these copies with staff, board members, and key volunteers to ensure everyone is aware of their roles and responsibilities.\n\n" +
                            "8. JOIN REGIONAL DISASTER RESPONSE NETWORKS: Consider becoming part of regional disaster response networks like the Food Bank Regional Disaster Response Network. These networks provide increased readiness, additional resources, and expertise for disaster response efforts.\n\n" +
                            "9. FOLLOW THE PHASES OF DISASTER RESPONSE: Recognize the three phases of disaster response: initial response, sustained response, and long-term recovery. Tailor your actions and resources to each phase's specific needs.\n\n" +
                            "10. RECRUIT AND ORGANIZE VOLUNTEERS: Be prepared to recruit and organize volunteers as needed, especially in the aftermath of a disaster. Volunteers play a crucial role in providing assistance to affected communities.\n\n",

                    R.drawable.love2,
                    "https://www.youtube.com/watch?v=J25bd7mpgr8&ab_channel=LakanCortezMD",
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