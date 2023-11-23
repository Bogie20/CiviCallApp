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
    import com.example.civicall.databinding.ActivityEightVolunteerandDonationsManagementInfoBinding

    class EightVolunteerandDonationsManagementInfo : AppCompatActivity() {
        private lateinit var binding:ActivityEightVolunteerandDonationsManagementInfoBinding
        private lateinit var networkUtils: NetworkUtils
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            networkUtils = NetworkUtils(this)
            networkUtils.initialize()
            binding = ActivityEightVolunteerandDonationsManagementInfoBinding.inflate(layoutInflater)
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

                    "https://as2.ftcdn.net/v2/jpg/00/32/03/29/1000_F_32032949_XiIpVwVLdjYMXbwxzGW1NUq3PXGgJlPg.jpg",
                    "https://www.govtech.com/em/disaster/how-to-recruit-retain-organize-volunteers.html"
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

                    "https://www.allhandsandhearts.org/wp-content/uploads/2018/05/Volunteer.webp",
                    "http://extension.msstate.edu/publications/managing-volunteers-times-disaster-the-local-volunteer-coordinator%E2%80%99s-role"
                  )
            )
            dataList.add(
                DataItem("Volunteer Skills: Bridging the Gap Between Community Needs and Career Advancement",
                    "\"Unlock the Power of Your Skills: Discover how your volunteer experiences can not only enrich your college life but also provide a strong foundation for future career success in our article 'Volunteer Skills: Bridging the Gap Between Community Needs and Career Advancement.\"\n\n" +


                            "1. TEAMWORK: There are many things in life that can be achieved more efficiently with combined efforts of a team. As a volunteer, you will often get to work alongside with others and also under different managers. In order to pull off any projects, you will learn to be responsible for your task and also collaborate with others.\n\n" +
                            "2. LEADERSHIP: Leaders are not born but are made with knowledge and experience. Volunteerism will expose you to opportunities to lead projects and manage people working under it.\n\n" +
                            "3. COMMUNICATION: Working in a team requires a lot of communication – verbal and written. More often than not, volunteers and beneficiaries come from a range of ages and backgrounds. You will get to practice effective communication outside your usual circle.\n\n" +
                            "4. ORGANIZATION AND PLANNING: There are many stages and processes towards completion of a project. You will learn to plan the timeline and organize resources well to carry out projects efficiently.\n\n" +
                            "5. TIME-MANAGEMENT: Juggling tasks and deadlines are prevalent in many aspects of our lives – studies, work, and even social. As a volunteer, you may get the chance to deliver time-bound projects. By learning to prioritize tasks assigned, you will get to hone your time-management skills and work more effectively.\n\n" +
                            "6. PROBLEM-SOLVING AND CRITICAL THINKING: Many non-profit organizations usually have to carry out projects and solve problems with limited resources. Therefore, volunteering with them gives you opportunities to think critically and creatively and be resourceful in order to achieve goals.\n\n" +
                            "7. RELATIONSHIP BUILDING: Being able to build meaningful relationships is important in many areas of life. You will never know how the people we meet can support us in different ways – emotionally or professionally. Volunteering will introduce us to people who are outside our usual social circle and broaden our horizons with different perspectives.\n\n" +
                            "8. EMPATHY: When working with beneficiaries of organizations, it allows us to have a chance at practicing empathy with those who are in different shoes. Being able to see from different perspectives can help us communicate better with those from different backgrounds and reduce the chances of conflict and misunderstanding in the future.\n\n" +
                            "9. SELF-AWARENESS: As you receive feedback from other volunteers and managers, you will get to understand yourself more. Being self-aware and able to reflect is the key to self-improvement. Consider keeping a journal to track what you have learned and also how the volunteering experiences make you feel.\n\n" +
                            "10. ABILITY TO LEARN: The skills required in volunteering can be very diverse. Volunteers also have a chance to play multiple roles. Each new role is a chance to learn new skills. Change is the new constant especially in this rapidly-changing era. The ability to learn will help us to adapt and keep up with the future. We will also never know how certain skills we gain from volunteering will eventually come to use.\n\n",

                    "https://res.cloudinary.com/grand-canyon-university/image/fetch/w_750,h_564,c_fill,g_faces,q_auto/https://www.gcu.edu/sites/default/files/media/GettyImages-135538080.jpg",
                    "https://empower2free.com/hacks-on-building-life-skills-by-volunteering/"
                  )
            )
            dataList.add(
                DataItem("Ensuring Trust and Capability: Screening and Credentialing Volunteers in Disaster Response",

                    "In the dynamic world of non-profit and community organizations, where our youngest members deserve nothing but the best, we recognize that child safety is paramount. Regardless of your connection with the community or your role, every college volunteer must undergo a robust screening process to ensure that our children remain secure. This commitment to safeguarding extends to all adult volunteers and employees, as it's our collective responsibility to protect our most vulnerable.\n\n" +


                            "1. DEVELOP COMPREHENSIVE SCREENING PROTOCOLS: Establish clear and comprehensive screening protocols that outline the steps and requirements for vetting potential volunteers.\n\n" +
                            "2. PRIORITIZE VULNERABLE POPULATIONS: Recognize the importance of prioritizing the safety and protection of vulnerable populations, such as children, the elderly, and individuals with special needs, when screening volunteers.\n\n" +
                            "3. CREATE A WRITTEN VOLUNTEER APPLICATION: Design a thorough volunteer application form that collects essential information, including personal details, qualifications, and areas of expertise.\n\n" +
                            "4. VERIFY APPLICATION INFORMATION: Conduct a meticulous verification process for the information provided on the volunteer applications. Check for accuracy and consistency.\n\n" +
                            "5. CONDUCT INTERVIEWS: Conduct in-person and phone interviews with potential volunteers to assess their qualifications, motivations, and alignment with the organization's mission and values.\n\n" +
                            "6. REQUIRE REFERENCES: Request a minimum of three confirmed, non-related references for each volunteer applicant. Contact these references to gain insights into the candidate's character and suitability for the role.\n\n" +
                            "7. PERFORM BACKGROUND CHECKS: Conduct comprehensive background checks, including criminal background checks, to identify any past criminal activity that may pose a risk to disaster response efforts.\n\n" +
                            "8. UTILIZE NATIONAL DATABASES: Use national databases, such as the National Sex Offender Public Registry (NSOPR), to identify applicants registered as sex offenders.\n\n" +
                            "9. EMPHASIZE TRAINING AND PREPAREDNESS: Prioritize training and preparedness among volunteers, ensuring they are well-equipped to respond effectively and safely in disaster situations.\n\n" +
                            "10. MONITOR AND SUPERVISE: Continuously monitor and supervise volunteers, especially during their initial probationary period. Regularly review their performance and adherence to the organization's code of conduct.\n\n",

                    "https://www.waldenu.edu/media/4543/seo-860-bs-127823438-1200x675?h=484&w=860",
                    "https://www.galaxydigital.com/blog/the-role-of-volunteers-in-disasters")
            )
            dataList.add(
                DataItem("Smart and Safe Giving: Tips for Donating to Charities in the Philippines",
                    "In times of disaster, every donation counts. Whether it's a natural calamity or a humanitarian crisis, your generous contributions can make a significant impact. However, ensuring that your donations reach those in need efficiently and effectively is crucial. Here, we offer guidance on how to manage your donations wisely in disaster response situations.\" In a world where generosity knows no bounds, where individuals come together to contribute a staggering \$122.9 billion in 2021 alone, the art of managing donations stands as the bridge between intent and impact. Join us on this journey as we delve into the dynamic realm of donation management, where your expertise can transform goodwill into tangible outcomes.\n\n" +

                            "1. RESEARCH TRUSTED ORGANIZATIONS: Begin by researching reputable organizations actively involved in disaster response efforts. Look for organizations with a proven track record of transparency and accountability.\n\n" +
                            "2. SPECIFY DONATION PURPOSE: Clearly define the purpose of your donation. Whether it's for food, medical supplies, shelter, or other specific needs, specifying your donation helps ensure it is used as intended.\n\n" +
                            "3. DONATE FINANCIALLY: Whenever possible, donate money rather than physical goods. Financial donations allow organizations to purchase exactly what is needed, avoiding the logistical challenges of handling physical donations.\n\n" +
                            "4. USE SECURE DONATION CHANNELS: Ensure that you use secure and official channels for making donations. Visit the organization's official website or contact them directly to verify the legitimacy of the donation process.\n\n" +
                            "5. CHECK ADMINISTRATIVE COSTS: Inquire about the administrative costs associated with your donation. Reputable organizations strive to keep overhead costs low, ensuring more of your donation goes directly to those in need.\n\n" +
                            "6. FOLLOW REPORTING AND UPDATES: Stay informed about the organization's activities and the impact of your donation. Reputable organizations provide regular updates on their disaster response efforts.\n\n" +
                            "7. CONSIDER LONG-TERM SUSTAINABILITY: While immediate relief is crucial, consider supporting organizations that also focus on long-term recovery and rebuilding efforts in disaster-affected areas.\n\n" +
                            "8. VERIFY TAX DEDUCTIBILITY: If you want to claim a tax deduction for your donation, confirm that the organization is a registered charity and provides the necessary documentation for tax purposes.\n\n" +
                            "9. AVOID UNSOLICITED REQUESTS: Be cautious of unsolicited donation requests, especially through emails or phone calls. Scammers often take advantage of disaster situations to solicit funds fraudulently.\n\n" +
                            "10. SPREAD AWARENESS: Encourage others to contribute to disaster response efforts by sharing information about trusted organizations and the importance of responsible giving.\n\n",

                    "https://cdn.tatlerasia.com/tatlerasia/i/2021/08/05130123-joel-muniz-a4ax1apccfa-unsplash_cover_2000x1333.jpg",
                    "https://www.tatlerasia.com/power-purpose/philanthropy/5-tips-when-donating-to-charities-in-the-philippines"
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