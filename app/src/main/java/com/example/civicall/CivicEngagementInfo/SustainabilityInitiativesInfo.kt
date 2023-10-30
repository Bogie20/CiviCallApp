package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class SustainabilityInitiativesInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lasting_impact)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion
        dataList.add(
            DataItem(
                "ENVIRONMENTAL ACTIVISM ON CAMPUS",
                "\"Amidst the bustling academic corridors of college campuses, a silent but potent revolution is brewing—the rise of environmental activism. Driven by passion, experience, and an unwavering commitment to sustainability, college students are emerging as the vanguards of change, propelling us towards a greener, more conscious future.\"\"Comprehensive Disaster Preparedness Kits: A Guide to Effective Disaster Response\" and equip yourself with the knowledge to safeguard your community and ensure a brighter, more resilient future.\"\"\n\n" +
                        "1. IDENTIFY ENVIRONMENTAL CHAMPIONS: Seek out students who are passionate about environmental causes and willing to take a leadership role in campus activism.\n\n" +
                        "2. Create Environmental Awareness: Organize awareness campaigns, workshops, and seminars to educate students about pressing environmental issues, their impact, and the importance of activism.\n\n" +
                        "3. ESTABLISH STUDENT-LED ENVIRONMENTAL GROUPS: Encourage the formation of student-led environmental organizations or clubs where like-minded individuals can collaborate on projects and initiatives.\n\n" +
                        "4. PROVIDE RESOURCES: Ensure access to resources like meeting spaces, funding, and materials to support environmental activism efforts.\n\n" +
                        "5. COLLABORATE WITH FACULTY: Engage faculty members who are experts in environmental fields to mentor and guide student activists, enhancing the academic dimension of activism.\n\n" +
                        "6. ADVOCATE FOR SUSTAINABLE CAMPUS POLICIES: Work with university administration to implement eco-friendly policies, such as reducing single-use plastics, promoting renewable energy sources, and sustainable waste management.\n\n" +
                        "7. COMMUNITY OUTREACH: Extend environmental initiatives to the local community, fostering collaboration and creating a broader impact beyond the campus.\n\n" +
                        "8. ENGAGE IN PRACTICAL PROJECTS: Encourage hands-on projects like tree planting, campus cleanups, and sustainability audits that demonstrate tangible results and motivate more students to get involved.\n\n" +
                        "9. LEVERAGE TECHNOLOGY: Utilize social media, websites, and digital platforms to connect with a wider audience, share information, and mobilize support for environmental causes.\n\n" +
                        "10. CELEBRATE ACHIEVEMENTS: Recognize and celebrate the achievements of student activists and their contributions to environmental sustainability through awards, events, and acknowledgments.\n\n",

                R.drawable.img_164,
                "https://www.mdpi.com/2076-0760/6/4/134",
                "https://samoaconservationsociety.files.wordpress.com/2017/07/rse-workers.jpg?w=820"
            )
        )
        dataList.add(
            DataItem("GREEN INITIATIVES FOR STUDENTS: CATALYSTS OF CIVIC ENGAGEMENT",
                "\"Welcome to the forefront of change! In the dynamic landscape of academia, 'Green Initiatives for Students: Catalysts of Civic Engagement' embarks on an inspiring journey, illuminating how students are driving environmental action, igniting a passion for sustainability, and redefining the future of our planet through active civic engagement.\"\n\n" +
                        "1. CATALYST FOR CHANGE: Green initiatives empower students to be catalysts for positive environmental change in their communities.\n\n" +
                        "2. LEADERSHIP DEVELOPMENT: Engaging in environmental activism fosters leadership skills, allowing students to take charge and make a difference.\n\n" +
                        "3. GLOBAL PERSPECTIVE: Students gain a broader understanding of global environmental issues and the interconnectedness of the world.\n\n" +
                        "4. COMMUNITY ENGAGEMENT: Green initiatives promote active involvement in the local community, strengthening bonds and creating a sense of responsibility.\n\n" +
                        "5. SUSTAINABLE MINDSET: Students develop a sustainable mindset that influences their lifestyle choices and career paths.\n\n" +
                        "6. ADVOCACY SKILLS: Engaging in environmental activism hones advocacy and communication skills, enabling students to effectively convey their message.\n\n" +
                        "7. NETWORKING OPPORTUNITIES: Green initiatives provide opportunities to connect with like-minded individuals, organizations, and experts in the field.\n\n" +
                        "8. POSITIVE IMPACT: Students witness the tangible impact of their actions, reinforcing the belief that collective efforts can bring about positive change.\n\n" +
                        "9. ENVIRONMENTAL STEWARDSHIP: By participating in green initiatives, students become stewards of the environment, responsible for its protection and preservation.\n\n" +
                        "10. FUTURE LEADERS: Students involved in environmental activism are poised to become future leaders committed to sustainability and civic engagement.\n\n",


                R.drawable.img_165,
                "https://www.ilo.org/global/about-the-ilo/history/centenary/WCMS_467270/lang--en/index.htm",
                "https://www.licas.news/wp-content/uploads/2020/03/2018.04.21-Eco-Walk-For-the-Environment-JC-1.jpg")
        )
        dataList.add(
            DataItem("SUSTAINABILITY IN EDUCATION",
                "\"Unlocking a Sustainable Future: Empowering Minds Through Education and Civic Engagement in Asia. Join us on a transformative journey where civic engagement meets sustainability, illuminating the path to a brighter, more environmentally conscious tomorrow.\"\n\n\n" +
                        "1. EMPOWERING CURRICULAR INNOVATION: Integrate sustainability principles into educational curricula, promoting an environmentally conscious mindset from an early age.\n\n" +
                        "2. CULTIVATING ECO-CITIZENS: Encourage students to become active eco-citizens by participating in local environmental initiatives and projects.\n\n" +
                        "3. TEACHER TRAINING AND DEVELOPMENT: Provide educators with training and resources to effectively teach sustainability concepts and practices.\n\n" +
                        "4. CROSS-DISCIPLINARY COLLABORATION: Promote collaboration between different academic disciplines to address complex sustainability challenges comprehensively.\n\n" +
                        "5. COMMUNITY ENGAGEMENT: Facilitate partnerships between educational institutions and local communities to work together on sustainability projects.\n\n" +
                        "6. STUDENT-LED INITIATIVES: Empower students to take the lead in designing and implementing sustainability initiatives within their schools and communities.\n\n" +
                        "7. CIVIC EDUCATION: Incorporate civic education components into sustainability programs, teaching students the importance of active citizenship in shaping a sustainable future.\n\n" +
                        "8. RESOURCE OPTIMIZATION: Implement sustainable practices within educational institutions, such as energy conservation, waste reduction, and eco-friendly campus designs.\n\n" +
                        "9. RESEARCH AND INNOVATION: Encourage research on sustainability issues and support innovative solutions developed by students and faculty.\n\n" +
                        "10. GLOBAL COLLABORATION: Foster international partnerships and exchanges to share knowledge and best practices in sustainability education and civic engagement.\n\n",
                R.drawable.img_455,
                "https://www.apn-gcr.org/bulletin/article/venturing-sustainability-political-lessons-from-civic-engagement-and-transformative-learning-in-asia/",
                "https://sustainability.batstate-u.edu.ph/wp-content/uploads/slider4/SDGPhotoslide1.jpeg")
        )

        dataList.add(
            DataItem("CREATING ECO-FRIENDLY COMMUNITIES",
                "\"Embark on a journey of transformation and community empowerment as we delve into the heart of eco-friendly civic engagement. Discover how dedicated individuals and organizations are paving the way for sustainable, eco-conscious communities in the Philippines and beyond.\"\"\n\n" +
                        "1. COMMUNITY NEEDS ASSESSMENT: Start by conducting a thorough assessment of the community's environmental needs and challenges to identify areas where eco-friendly initiatives can make the most impact.\n\n" +
                        "2. ENGAGE LOCAL LEADERS: Collaborate with local government officials, community leaders, and influencers to gain their support and involvement in eco-friendly projects.\n\n" +
                        "3. RAISE ENVIRONMENTAL AWARENESS: Organize awareness campaigns and educational programs within the community to inform residents about the importance of eco-friendly practices and their benefits.\n\n" +
                        "4. ESTABLISH RECYCLING PROGRAMS: Set up recycling initiatives, including collection points and education on proper waste separation, to reduce landfill waste and promote recycling.\n\n" +
                        "5. GREEN INFRASTRUCTURE DEVELOPMENT: Advocate for and participate in the creation of green spaces, parks, and sustainable infrastructure projects that enhance the community's eco-friendliness.\n\n" +
                        "6. PROMOTE RENEWABLE ENERGY: Explore renewable energy options such as solar panels and wind turbines, and work to implement these technologies within the community.\n\n" +
                        "7. ENCOURAGE SUSTAINABLE TRANSPORTATION: Promote biking, walking, and carpooling as eco-friendly transportation alternatives, and advocate for bike lanes and pedestrian-friendly infrastructure.\n\n" +
                        "8. COMMUNITY GARDENS: Establish community gardens and urban farming projects to promote locally sourced, sustainable food production.\n\n" +
                        "9. WASTE REDUCTION INITIATIVES: Implement strategies to reduce single-use plastics and packaging within the community, such as promoting reusable bags and containers.\n\n" +
                        "10. MEASURE AND CELEBRATE PROGRESS: Continuously monitor and measure the environmental impact of your initiatives, and celebrate milestones and successes to inspire further engagement and commitment.\n\n",



                R.drawable.img_168,
                "https://www.peopleandthesea.org/community-engagement-philippines/",
                "https://ik.imagekit.io/tvlk/blog/2019/01/Greenpeace-Philippines.jpg")
        )

        dataList.add(
            DataItem("CAREERS IN ENVIRONMENTAL ADVOCACY",
                "Explore exciting career opportunities in environmental advocacy! Dive into seven impactful fields, from environmental law to wildlife conservation, and be part of the solution for a sustainable future.\n\n" +
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
                R.drawable.img_169,
                "https://www.idealist.org/en/careers/environment-advocate-7-ways",
                "https://jobs.naaee.org/sites/default/files/styles/hero_wide/public/eepro/careers/images/science-symposium.jpg?h=a1e1a043&itok=uRp3bS3A")
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