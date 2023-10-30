package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class TechforGoodsinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_techfor_goodsinfo)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "TECH SOLUTIONS FOR CIVIC CHALLENGES",
                "In the fast-paced world of college academics, mastering effective study strategies is the key to unlocking success. From setting precise goals to embracing active learning, this guide unveils ten proven procedures tailored to help college students conquer their academic challenges and excel in their studies.\n\n\n" +

                        "1. PROBLEM IDENTIFICATION: Begin by clearly defining the civic challenge or problem that needs to be addressed. Understand the root causes and the specific needs of the community.\n\n" +
                        "2. COMMUNITY ENGAGEMENT: Involve citizens, community leaders, and stakeholders in the process. Gather their insights, feedback, and input to ensure that the solution is community-driven.\n\n" +
                        "3. NEEDS ASSESSMENT: Conduct a comprehensive needs assessment to determine the specific technology requirements for addressing the civic challenge. Consider factors like accessibility, scalability, and usability.\n\n" +
                        "4. COLLABORATIVE PARTNERSHIPS: Form partnerships between government agencies, nonprofit organizations, tech developers, and local communities. Collaboration can bring together diverse expertise and resources.\n\n" +
                        "5. DATA COLLECTION AND ANALYSIS: Gather relevant data through surveys, research, and open data sources. Analyze the data to gain insights into the challenge and potential solutions.\n\n" +
                        "6. TECHNOLOGY DEVELOPMENT: Develop technology solutions such as mobile apps, web platforms, or data-driven tools that address the identified civic challenge. Ensure that these solutions are user-friendly and accessible.\n\n" +
                        "7. TESTING AND ITERATION: Test the technology solutions in a real-world setting. Gather feedback from users and stakeholders and iterate on the solutions to improve their effectiveness.\n\n" +
                        "8. PRIVACY AND SECURITY: Prioritize data privacy and security in the technology solutions to protect sensitive information and build trust within the community.\n\n" +
                        "9. COMMUNITY EDUCATION: Provide training and education to community members on how to use and benefit from the technology solutions. Empower them to become active users and advocates.\n\n" +
                        "10. SUSTAINABILITY AND SCALABILITY: Develop a plan for the long-term sustainability of the technology solutions. Consider how to scale the solutions to other communities facing similar challenges.\n\n",

                R.drawable.img_152,
                "https://www.govtech.com/dc/articles/4-cities-jumpstart-civic-tech-solutions-with-citycamp.html",
                "https://1.bp.blogspot.com/-tPl2KNcLous/X1sGyC1IFRI/AAAAAAAAABc/gzo4lnVhtO0R5dp46BaprPmsFP3xd5dLQCLcBGAsYHQ/s640/headway-5QgIuuBxKwM-unsplash.jpg"
            )
        )
        dataList.add(
            DataItem("CODING FOR SOCIAL IMPACT",
                "Coding is not just lines of text; it's a potent force driving social transformation. In this digital age, discover how coding harnesses innovation to empower communities, tackle global challenges, and shape a brighter, more equitable future.\n\n" +
                        "1. IDENTIFY SOCIAL CHALLENGES: Begin by identifying pressing social challenges that coding can address, such as poverty, education inequality, or environmental issues.\n\n" +
                        "2. COMMUNITY INVOLVEMENT: Engage with local communities, stakeholders, and experts to understand the specific needs and nuances of the issues you aim to tackle.\n\n" +
                        "3. CODING EDUCATION: Promote coding education and digital literacy, ensuring that individuals from all backgrounds have the opportunity to learn and apply these skills.\n\n" +
                        "4. EMPOWER MARGINALIZED GROUPS: Focus on empowering marginalized communities by providing access to technology, coding resources, and job opportunities in the tech industry.\n\n" +
                        "5. INNOVATIVE SOLUTIONS: Develop innovative coding solutions tailored to address social challenges, whether through apps, platforms, or data analysis tools.\n\n" +
                        "6. COLLABORATIVE PARTNERSHIPS: Form partnerships with nonprofits, government agencies, and other organizations to leverage collective expertise and resources.\n\n" +
                        "7. DATA-DRIVEN INSIGHTS: Utilize coding and data analysis to gain insights into social issues and inform evidence-based solutions.\n\n" +
                        "8. CIVIC ENGAGEMENT: Promote civic engagement by using coding to facilitate communication, organize grassroots movements, and advocate for social change.\n\n" +
                        "9. SUSTAINABLE IMPACT: Ensure the sustainability of your coding initiatives by considering long-term plans and scalability.\n\n" +
                        "10. MEASURE IMPACT: Continuously measure and evaluate the impact of coding solutions on addressing social challenges, adapting strategies as needed.\n\n",

                R.drawable.img_153,
                "https://medium.com/@vishalsuthar264/the-role-of-coding-in-creating-social-change-and-impact-4b8e333d634a",
                "https://miro.medium.com/v2/resize:fit:828/format:webp/0*oVdO0Mm4gJRKkCc8.jpg")
        )
        dataList.add(
            DataItem("STARTUPS WITH A PURPOSE",
                "\"In a digital age where civic participation is evolving, Voterfied, a groundbreaking tech startup, empowers registered voters to directly influence policy decisions and candidate interactions, redefining how communities engage in shaping their future.\"\n\n" +
                        "1. INTERACTIVE STEM LEARNING APPS FOR UNDERPRIVILEGED STUDENTS: Develop interactive STEM learning apps tailored for underprivileged students to improve their access to quality education in science and technology.\n\n" +
                        "2. TELEMEDICINE PLATFORM FOR RURAL HEALTHCARE: Create a telemedicine platform for remote rural healthcare, ensuring online access to medical consultations and services.\n\n" +
                        "3. URBAN GREEN SPACES OPTIMIZATION TOOL: Build a software tool for optimizing urban green spaces to enhance urban livability and sustainability.\n\n" +
                        "4. REAL-TIME DISASTER RESPONSE DASHBOARD: Design a real-time disaster response dashboard for better coordination during natural disasters and humanitarian crises.\n\n" +
                        "5. POLICE ACCOUNTABILITY APP: Develop a mobile app for reporting police misconduct and promoting transparency in law enforcement.\n\n" +
                        "6. ASSISTIVE COMMUNICATION DEVICE FOR NON-VERBAL INDIVIDUALS: Create a portable assistive communication device using machine learning to aid non-verbal individuals in expressing themselves.\n\n" +
                        "7. CROP HEALTH MONITORING AI: Build an AI-powered app for crop health monitoring to reduce crop loss and promote sustainable agriculture.\n\n" +
                        "8. ONLINE CIVIC ENGAGEMENT PLATFORM: Develop an online civic engagement platform for citizens to participate in local government decisions and improve transparency.\n\n" +
                        "9. NONPROFIT MANAGEMENT SYSTEM: Create a comprehensive nonprofit management system to streamline operations, from donor management to impact measurement.\n\n" +
                        "10. PUBLIC HEALTH DATA ANALYTICS DASHBOARD: Design a public health data analytics dashboard to visualize disease trends and inform policymaking and healthcare decisions.",
                R.drawable.img_154,
                "https://www.govtech.com/civic/tech-startup-tries-to-boost-civic-engagement-in-california.html",
                "https://startup.info/wp-content/uploads/2023/06/594090.jpg")
        )

        dataList.add(
            DataItem("HACKATHONS AND INNOVATION IN CIVIC ENGAGEMENT",
                "In a digital era where collaboration and innovation drive civic progress, hackathons emerge as catalysts for transformative civic engagement. Discover how hackathons are transforming communities, bridging the government-tech divide, and fueling innovation for a more connected world.\n\n\n" +
                        "1. HACKATHON HOSTING: Organize hackathons that focus on civic engagement and innovation, bringing together government officials, tech enthusiasts, and entrepreneurs.\n\n" +
                        "2. DATA LIBERATION: Release government data, such as crime statistics or public health information, as part of an Open Data Initiative to foster transparency and encourage civic app development.\n\n" +
                        "3. CO-WORKING COLLABORATION: Collaborate with co-working spaces and tech incubators, sharing municipal data sets and partnering with innovators to develop applications that address government challenges.\n\n" +
                        "4. COMMUNITY ENGAGEMENT: Actively engage citizens and encourage their participation in hackathons and civic tech initiatives to improve the quality of life in the city.\n\n" +
                        "5. LOCAL ECONOMIC GROWTH: Support and retain civic-minded hackathon participants and social entrepreneurs within the community to create jobs and stimulate the local economy.\n\n" +
                        "6. INNOVATION IN GOVERNANCE: Embrace hackathons as platforms for generating innovative solutions to government problems, including the development of civic apps for public services.\n\n" +
                        "7. OPEN GOVERNMENT ADVOCACY: Foster a culture of open government and open data, aligning with the principles of transparency and accessibility for citizens.\n\n" +
                        "8. COLLABORATIVE PLATFORMS: Develop collaborative platforms for government officials, tech communities, and citizens to interact and work together to address civic challenges.\n\n" +
                        "9. TECH COMMUNITY ENGAGEMENT: Actively engage with the local tech community to encourage their involvement in civic innovation and civic hackathons.\n\n" +
                        "10. ECONOMIC AND SOCIAL IMPACT: Recognize the economic and social impact of civic tech initiatives, emphasizing how they create opportunities, improve quality of life, and benefit the community as a whole.",



                R.drawable.img_156,
                "https://www.govtech.com/archive/inside-the-civic-hacking-movement.html",
                "https://miro.medium.com/v2/resize:fit:1400/1*xXup-KWLsXCV9ad8La_TlA.jpeg")
        )

        dataList.add(
            DataItem("DIGITAL ADVOCACY CAMPAIGNS",
                "\"Unlock the power of civic engagement with 'Magnify Your Voice,' a groundbreaking digital platform that transforms fleeting moments into meaningful actions. Explore how micro-volunteering through quick texts and emails is redefining community involvement, one small step at a time.\"\n\n" +
                        "1. PLATFORM REGISTRATION: Start by signing up on 'Magnify Your Voice' or a similar digital civic engagement platform, providing your basic information and preferences.\n\n" +
                        "2. PROFILE SETUP: Create a comprehensive user profile, including your interests, skills, and availability for micro-volunteering activities.\n\n" +
                        "3. BROWSE CAMPAIGNS: Explore the various ongoing campaigns and projects available on the platform, ranging from local announcements to advocacy efforts.\n\n" +
                        "4. JOIN OR START A CAMPAIGN: Join existing campaigns that align with your interests or initiate your grassroots campaign to address a local issue.\n\n" +
                        "5. MICRO-VOLUNTEERING: Participate in micro-volunteering tasks, dedicating small moments to send emails, texts, or support community initiatives.\n\n" +
                        "6. COMMUNITY ANNOUNCEMENTS: Share announcements about local events, meetings, or initiatives, ensuring your community stays informed and engaged.\n\n" +
                        "7. COLLABORATE AND NETWORK: Connect with like-minded individuals and community groups, enhancing the impact of your collective efforts.\n\n" +
                        "8. ADVOCACY AND FEEDBACK: Use the platform to advocate for specific causes or provide feedback to local governments or organizations, amplifying your civic voice.\n\n" +
                        "9. GAMIFIED ENGAGEMENT: Explore gamification features within the platform, earning rewards or recognition for your contributions to encourage ongoing involvement.\n\n" +
                        "10. MOBILE ACCESSIBILITY: Download the native mobile app for added convenience, allowing you to engage with your community and campaigns while on the go.\n\n",
                R.drawable.img_158,
                "https://www.govtech.com/civic/civic-tech-platform-turns-social-media-time-into-advocacy.html",
                "https://ctb.ku.edu/sites/default/files/chapter_files/using_social_media_for_digital_advocacy.jpg")
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
