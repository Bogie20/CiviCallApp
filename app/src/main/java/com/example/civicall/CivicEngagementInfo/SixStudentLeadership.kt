package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.NetworkUtils
import com.example.civicall.R

class SixStudentLeadership : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixstudentleadership)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "YOUTH ACTIVISM'S INFLUENCE ON STUDENT LEADERS",
                "In the realm of youth activism, the profound impact on student leaders is undeniable. This exploration delves into how the fervor of youth activism molds and empowers the next generation of student leaders, igniting their passion for change and driving them to become influential forces in society.\"Comprehensive Disaster Preparedness Kits: A Guide to Effective Disaster Response\" and equip yourself with the knowledge to safeguard your community and ensure a brighter, more resilient future.\"\"\n\n" +
                        "1. YOUTH ACTIVISM AWARENESS CAMPAIGNS: Organize awareness campaigns within educational institutions to highlight the significance of youth activism, inspiring students to engage in meaningful causes.\n\n" +
                        "2. STUDENT ACTIVIST NETWORKS: Establish student activist networks or clubs that provide a platform for students to learn about and actively participate in youth activism efforts.\n\n" +
                        "3. GUEST SPEAKER SERIES: Invite youth activists to share their experiences and insights with students, emphasizing the transformative power of activism.\n\n" +
                        "4. LEADERSHIP WORKSHOPS: Conduct workshops that focus on leadership skills and ethical activism, equipping student leaders with the tools needed to drive change responsibly.\n\n" +
                        "5. COLLABORATIVE PROJECTS: Encourage student-led initiatives that collaborate with youth activists, allowing students to work alongside experienced change-makers on real-world issues.\n\n" +
                        "6. COMMUNITY ENGAGEMENT: Facilitate opportunities for student leaders to engage with their local communities, enabling them to witness firsthand the impact of activism.\n\n" +
                        "7. ADVOCACY TRAINING: Offer training programs that equip students with effective advocacy skills, teaching them how to raise awareness, mobilize support, and drive change.\n\n" +
                        "8. MENTORSHIP PROGRAMS: Create mentorship programs where youth activists can guide and inspire student leaders, nurturing their passion for activism.\n\n" +
                        "9. LEADERSHIP RECOGNITION: Acknowledge and celebrate student leaders who actively engage in youth activism, reinforcing the idea that their efforts can make a significant impact.\n\n" +
                        "10. YOUTH-LED INITIATIVES: Encourage student leaders to initiate their own youth-led projects, allowing them to apply their activism knowledge and drive positive change in their communities.\n\n",

                "https://www.edgeip.com/images/FCK/Image/202111/Swansea-ClimateActivists.jpg",
                "https://www.rappler.com/moveph/27023-youth-activism-organized-action/"

            )
        )
        dataList.add(
            DataItem("SUCCESS FACTORS IN STUDENT-LED MOVEMENTS",
                "In the realm of student-led movements, understanding the keys to success is vital. This exploration delves into the core principles that empower student leaders and drive tangible results in civic engagement.\n\n" +
                        "1. FOCUS ON CLEAR OBJECTIVES: Define specific, achievable goals for your movement, ensuring clarity of purpose and direction.\n\n" +
                        "2. EFFECTIVE ORGANIZATIONAL STRUCTURE: Establish a well-structured organization with defined roles, responsibilities, and leadership positions.\n\n" +
                        "3. STRATEGIC PLANNING: Develop a strategic plan that outlines the steps, timeline, and resources required to achieve your objectives.\n\n" +
                        "4. BUILDING ALLIANCES: Collaborate with other student organizations, community groups, or like-minded individuals to expand your network and leverage collective strength.\n\n" +
                        "5. ENGAGE IN OUTREACH: Actively reach out to students, faculty, and the broader community to raise awareness and garner support for your cause.\n\n" +
                        "6. ADVOCACY AND LOBBYING: Develop advocacy skills to engage with policymakers, administrators, and relevant authorities to influence change.\n\n" +
                        "7. RESOURCE MOBILIZATION: Secure funding and resources through various means, such as grants, donations, or crowdfunding, to sustain your movement's activities.\n\n" +
                        "8. EFFECTIVE COMMUNICATION: Craft compelling messages and utilize multiple communication channels, including social media and traditional media, to amplify your message.\n\n" +
                        "9. STRATEGIC NONVIOLENT ACTION: Employ nonviolent strategies and tactics that align with your goals, such as protests, demonstrations, or awareness campaigns.\n\n" +
                        "10. EVALUATION AND ADAPTATION: Continuously assess your progress, adapt to changing circumstances, and refine your approach based on lessons learned.\n\n",

                "https://mcm.edu.ph/wp-content/uploads/2022/07/IMG_1661-scaled-1.jpeg",
                "https://www.samuelcohn.net/development-1/everything-you-need-to-know-about-how-to-create-a-successful-student-led-social-movement"
             )
        )
        dataList.add(
            DataItem("STRATEGIES FOR CAMPUS SOCIAL CHANGE LEADERSHIP",
                "In our ever-changing world, where challenges like poverty, injustice, and environmental crises abound, the demand for a fresh breed of leaders is crystal clear. Here, we dive into how colleges play a crucial role in shaping these leaders by fostering students' integrative leadership, a powerful blend of teamwork, civic involvement, and cross-cultural understanding, to take on these global issues head-on.\n\n" +
                        "1. COMPILE EMERGENCY CONTACT INFORMATION: Gather essential contact numbers, including fire, police, ambulance, and medical professionals, and store them in your cell phone and near your home phone.\n\n" +
                        "2. DESIGNATE FAMILY MEETING PLACES: Identify both local and out-of-town meeting places for your family to gather in case you're separated during a disaster or can't return home.\n\n" +
                        "3. SET UP 'I.C.E.' CONTACTS: Program 'In Case of Emergency' (I.C.E.) numbers in your phone and your family members' phones to provide crucial information to emergency responders.\n\n" +
                        "4. CREATE A FAMILY CONTACT SHEET: Develop a comprehensive contact sheet with names, addresses, and phone numbers of important contacts, including an out-of-town contact for times when local communication is disrupted.\n\n" +
                        "5. PREPARE CONTACT CARDS: Create contact cards for each family member containing emergency contact information, an out-of-town contact, a designated meeting place, and other vital details. Keep these cards in accessible places like purses, wallets, or backpacks.\n\n" +
                        "6. ENSURE EVERY FAMILY MEMBER HAS A PHONE: Ensure that all family members have access to a mobile phone or a way to communicate during emergencies.\n\n" +
                        "7. TEACH 911 PROTOCOL: Educate children on when and how to call 911 for assistance in emergencies.\n\n" +
                        "8. FAMILIARIZE WITH TEXT MESSAGING: Ensure that everyone in your family knows how to send text messages, which can be more reliable during network disruptions than phone calls.\n\n" +
                        "9. SUBSCRIBE TO ALERT SERVICES: Sign up for local alert services that send text messages and emails with crucial information during disasters.\n\n" +
                        "10. PRIORITIZE COMMUNICATION METHODS: In times of crisis, use phone calls sparingly for life-threatening emergencies and rely on text messages, email, and social media for non-emergency communication to prevent network congestion.\n\n",

                "https://www.waldenu.edu/media/4894/seo-1354-bs-volunteering-problem-cheerful-243564697-1200x675",
                "https://journalofleadershiped.org/jole_articles/strengthening-college-students-integrative-leadership-orientation-by-building-a-foundation-for-civic-engagement-and-multicultural-competence/"
                )
        )

        dataList.add(
            DataItem("Turning Passion into Civic Action",
                "\"In a world of unprecedented challenges, college students stand at the threshold of making their voices heard. Discover how these young changemakers are turning their passion into powerful civic action, fueling a wave of transformation on campuses and beyond.\"\n\n" +
                        "1. IDENTIFY YOUR PASSION: Reflect on the issues or causes that ignite your passion and resonate with you personally.\n\n" +
                        "2. EDUCATE YOURSELF: Dive deep into research, news, and resources related to your chosen cause to gain a comprehensive understanding of the topic.\n\n" +
                        "3. CONNECT WITH LIKE-MINDED PEERS: Seek out student organizations, clubs, or online communities that share your passion and values.\n\n" +
                        "4. ENGAGE IN DIALOGUE: Participate in open discussions, debates, or forums to exchange ideas, learn from others, and refine your perspective.\n\n" +
                        "5. SET CLEAR GOALS: Define specific, measurable, and achievable goals for the change you want to create in your community or on campus.\n\n" +
                        "6. PLAN AND ORGANIZE: Create a strategic plan that outlines the steps, actions, and resources required to achieve your goals.\n\n" +
                        "7. LEVERAGE TECHNOLOGY: Utilize social media, online platforms, and digital tools to raise awareness, mobilize support, and amplify your message.\n\n" +
                        "8. COLLABORATE AND NETWORK: Build partnerships with local organizations, activists, and influencers who can support your cause and expand your reach.\n\n" +
                        "9. TAKE ACTION: Execute your plan, organize events, campaigns, or initiatives, and actively work toward your goals.\n\n" +
                        "10. MEASURE IMPACT AND ADAPT: Continuously assess the impact of your actions, gather feedback, and be open to adapting your strategies for greater effectiveness.\n\n",

                "https://blog.polco.us/hubfs/Polco%20Live%20Event-2.png",
                "https://www.gse.harvard.edu/ideas/news/20/09/turning-passion-civic-action"
                )
        )

        dataList.add(
            DataItem("High-Impact College Volunteer Opportunities",
                "In the dynamic world of higher education, college students are increasingly driven by a passion for community service that goes beyond the pursuit of knowledge in the classroom. This Study delves into the pivotal role of high-impact volunteer opportunities tailored for college students, offering not only personal growth but also a chance to actively contribute to the betterment of society.\n\n" +

                        "1. SELF-REFLECTION: Begin by reflecting on your passions, interests, and the causes that resonate with you. Consider what kind of impact you want to make in your community or beyond.\n\n" +
                        "2. RESEARCH: Investigate local nonprofit organizations, community groups, and volunteer programs that align with your interests. Explore their missions, volunteer needs, and the impact they create.\n\n" +
                        "3. EVALUATE COMMITMENT: Assess your availability and commitment level. Determine whether you can volunteer regularly, for specific events, or remotely, depending on your schedule and preferences.\n\n" +
                        "4. SKILLS ASSESSMENT: Identify your strengths and skills that could benefit volunteer organizations. This includes both hard skills (e.g., web design, teaching) and soft skills (e.g., communication, teamwork).\n\n" +
                        "5. CONNECT WITH PEERS: Discuss your intentions with fellow students who share similar interests. They may have insights, recommendations, or even want to join you in your volunteer efforts.\n\n" +
                        "6. CONTACT ORGANIZATIONS: Reach out to the organizations or programs you're interested in. Inquire about volunteer opportunities, application processes, and any training or orientation required.\n\n" +
                        "7. ATTEND INFO SESSIONS: Attend information sessions or orientations offered by volunteer organizations. These sessions can provide deeper insights into their work and help you make an informed decision.\n\n" +
                        "8. SET GOALS: Define clear goals for your volunteer experience. Determine what you hope to achieve personally and how you aim to contribute to the organization's mission.\n\n" +
                        "9. BEGIN VOLUNTEERING: Start your volunteer work with enthusiasm and dedication. Whether it's mentoring, organizing events, or providing essential services, give your best effort.\n\n" +
                        "10. REFLECT AND ADAPT: Regularly reflect on your volunteer experiences. Assess the impact you've made, evaluate your goals, and adapt your volunteer efforts as needed. This ongoing process ensures your service remains high-impact and meaningful.\n\n",

                "https://discover.abre.com/wp-content/uploads/2022/11/FI_-Intro-to-Service-Learning-1024x576-1.jpeg",
                "https://www.indeed.com/career-advice/career-development/community-service-ideas-college-students"
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
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}