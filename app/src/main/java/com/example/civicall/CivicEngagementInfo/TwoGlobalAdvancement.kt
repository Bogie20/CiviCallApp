package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityThreeEffectiveadvocacyBinding

class TwoGlobalAdvancement : AppCompatActivity() {
    private lateinit var binding:ActivityThreeEffectiveadvocacyBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityThreeEffectiveadvocacyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, CivicMenu::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }


        val dataList = ArrayList<DataItem>()
        dataList.add(
            DataItem(
                "UNDERSTANDING GLOBAL ISSUES",
                "\"In the dynamic landscape of civic engagement, understanding global issues is the key to impactful change. Explore the profound relevance of 'Understanding Global Issues in Civic Engagement' and discover the tools to navigate this transformative journey.\"\"Comprehensive Disaster Preparedness Kits: A Guide to Effective Disaster Response\" and equip yourself with the knowledge to safeguard your community and ensure a brighter, more resilient future.\"\"\n\n" +
                        "1. Promote Understanding: Strive to understand various perspectives on global issues, fostering empathy and consensus-building among diverse viewpoints.\n\n" +
                        "2. Respect Cultural Diversity: Embrace the value of cultural diversity and work to connect leaders from different cultural backgrounds to collaborate on global problem-solving.\n\n" +
                        "3. Build Global Relationships: Actively seek opportunities to build relationships with people from different countries and cultures, both in person and through online networks.\n\n" +
                        "4. Acknowledge Interdependence: Recognize the interconnectedness and interdependence of people and countries worldwide, understanding how global issues affect local communities.\n\n" +
                        "5. Study Global Issues: Commit to learning about major global issues that affect your lives, including resource scarcity, wealth distribution, conflict resolution, population growth, and environmental challenges.\n\n" +
                        "6. Advocate International Cooperation: Encourage your nation to engage in international cooperation and partnerships when addressing global issues, rather than pursuing unilateral actions.\n\n" +
                        "7. Support International Agreements: Advocate for your country to ratify and implement international agreements, conventions, and treaties related to global issues.\n\n" +
                        "8. Promote Global Equity and Justice: Work collaboratively with others to advocate for global standards of justice and equity in various domains, such as military spending, technology access, and immigration policies.\n\n" +
                        "9. Raise Awareness: Use your voice and influence to raise awareness about global issues among your peers, community, and policymakers.\n\n" +
                        "10. Take Informed Action: Take informed and responsible actions to address global challenges, including participating in civic activities, volunteering, and supporting initiatives that contribute to positive change on a global scale.\n\n",

                "https://www.worldbank.org/content/dam/photos/1440x600/2021/jun/Cambodia__Social_Accountability__1440x600.jpg",
                "https://www.theglobalcitizensinitiative.org/the-rights-and-responsibilities-of-global-citizenship/"
            )
        )
        dataList.add(
            DataItem("INTERNATIONAL VOLUNTEERING OPPORTUNITIES",
                "\"Unlock the Global Impact of Volunteering: Explore International Volunteering Opportunities for Civic Engagement. Join us on a journey that transcends borders, connecting individuals to meaningful service experiences worldwide, while fostering community bonds and driving positive change.\"\n\n" +
                        "1. Research Opportunities: Begin by researching international volunteering programs that align with your interests and skills. Look for organizations and projects that resonate with your passion for civic engagement.\n\n" +
                        "2. Evaluate Program Suitability: Assess the suitability of each program, considering factors like location, duration, and required commitments. Ensure that the program aligns with your goals and availability.\n\n" +
                        "3. Financial Planning: Develop a budget to cover expenses related to international volunteering, including travel costs, accommodation, and daily expenses. Seek funding opportunities, scholarships, or grants if needed.\n\n" +
                        "4. Application Process: Complete the application process for your chosen program, which may include submitting resumes, essays, or recommendations. Pay close attention to deadlines and requirements.\n\n" +
                        "5. Training and Preparation: Participate in any pre-departure training or orientation provided by the volunteering organization. This will equip you with the necessary skills and cultural awareness for your placement.\n\n" +
                        "6. Travel Arrangements: Make travel arrangements, including booking flights, obtaining necessary visas, and ensuring you have valid travel documents. Prepare a detailed itinerary for your journey.\n\n" +
                        "7. Health and Safety: Prioritize your health and safety by researching any required vaccinations or health precautions for your destination. Purchase travel insurance and familiarize yourself with local emergency procedures.\n\n" +
                        "8. Cultural Sensitivity: Educate yourself about the culture, customs, and language of the host country. Show respect for local traditions and be open to learning from the community.\n\n" +
                        "9. Engage Actively: During your volunteering placement, actively engage with the local community and project objectives. Collaborate with fellow volunteers and community members to maximize your impact.\n\n" +
                        "10. Reflect and Share: After your volunteering experience, take time to reflect on your journey and the impact you've made. Share your experiences with your home community to inspire others to engage in international civic service.\n\n",

                "https://d1y8sb8igg2f8e.cloudfront.net/images/shutterstock_636225116.width-800.jpg",
                "https://www.newamerica.org/political-reform/co-governance-project/civic-engagement/volunteering-civic-engagement-home-and-abroad/"
                )
        )
        dataList.add(
            DataItem("BUILDING CROSS-CULTURAL BRIDGES",
                "\"Unlocking Unity: Pioneering Cross-Cultural Bridges for Civic Engagement. Discover how effective cross-cultural communication can bridge divides, celebrate diversity, and empower communities to drive positive change.\"\n\n" +
                        "1. Cultural Competence Training: Begin with comprehensive cultural competence training for individuals and organizations to foster understanding, empathy, and respect for diverse cultures.\n\n" +
                        "2. Active Listening and Empathy: Encourage active listening and empathy as foundational skills for effective cross-cultural communication. These skills bridge gaps and build rapport.\n\n" +
                        "3. Cultural Awareness: Promote cultural awareness by educating individuals about the nuances, norms, and customs of different cultures within the community.\n\n" +
                        "4. Communication Styles: Understand how culture influences communication styles, including nonverbal cues and decision-making processes, to adapt and avoid misunderstandings.\n\n" +
                        "5. Education Initiatives: Prioritize cross-cultural education initiatives in schools and universities to prepare citizens for meaningful interactions in a multicultural society.\n\n" +
                        "6. Training for Multicultural Environments: Implement training programs in both public and private sectors to enhance cultural competence among employees working in diverse environments.\n\n" +
                        "7. Inclusive Practices: Foster inclusive practices in workplaces, institutions, and public spaces to create environments where all individuals feel valued and respected.\n\n" +
                        "8. Celebrating Diversity: Encourage the celebration of diversity through cultural events, festivals, and community gatherings that promote understanding and appreciation of different cultures.\n\n" +
                        "9. Cross-Cultural Collaboration: Facilitate cross-cultural collaboration and partnerships, both locally and internationally, to leverage cultural insights for innovation and growth.\n\n" +
                        "10. Promoting Civic Engagement: Use effective cross-cultural communication as a tool for promoting civic engagement by breaking down barriers, enhancing trust, and empowering communities to drive positive change.\n\n",

                "https://media.licdn.com/dms/image/D4D12AQGSbNkqnqAdrw/article-cover_image-shrink_600_2000/0/1687874888995?e=1701907200&v=beta&t=kxoyU2M1Tn9bBlVzgYC_fKo3DvyS4u2WUl-kJ71E7g4",
                "https://www.linkedin.com/pulse/building-bridges-exploring-cross-cultural-training-workplace-bitar/"
                )
        )

        dataList.add(
            DataItem("ADVOCATING FOR GLOBAL EQUALITY",
                "\"\"Unleash the Power of Equality: Championing Global Unity for Civic Change. Explore how advocating for global equality can break down barriers, foster inclusivity, and empower individuals and communities to drive positive, transformative actions worldwide.\"\"\n\n" +
                        "1. Research Global Inequality: Start by researching and understanding the various dimensions of global inequality, including income, gender, race, and access to resources. Stay informed about current global disparities.\n\n" +
                        "2. Identify Key Issues: Identify specific areas of global inequality that resonate with your civic engagement goals, whether it's poverty reduction, gender equality, climate justice, or other pressing concerns.\n\n" +
                        "3. Engage with Advocacy Groups: Connect with local and international advocacy organizations that focus on global equality issues. Join their efforts, attend meetings, and collaborate on initiatives.\n\n" +
                        "4. Educate Yourself: Continuously educate yourself about the root causes and consequences of global inequality. Stay updated on research, reports, and data related to these issues.\n\n" +
                        "5. Raise Awareness: Use your voice and platform to raise awareness about global inequality. Organize awareness campaigns, seminars, or workshops in your community to educate others.\n\n" +
                        "6. Advocate for Policy Change: Engage with policymakers at local and global levels to advocate for policies that address global inequality. Write letters, participate in advocacy events, and support relevant legislation.\n\n" +
                        "7. Foster Inclusivity: Promote inclusivity and diversity in all your civic engagement efforts. Ensure that marginalized communities are heard and included in decision-making processes.\n\n" +
                        "8. Collaborate Globally: Collaborate with individuals and organizations from different countries and backgrounds. Share best practices, resources, and experiences to create a global network for change.\n\n" +
                        "9. Support Grassroots Movements: Offer support to grassroots movements and organizations working on the front lines of global equality issues. Volunteer your time, skills, or resources.\n\n" +
                        "10. Measure Impact: Regularly assess the impact of your advocacy efforts. Collect data, stories, and feedback to understand the positive changes you're contributing to on a global scale.",

                "https://philippineembassy-dc.org/wp-content/uploads/2023/06/Picture1pid.jpg",
                "https://www.un.org/sustainabledevelopment/inequality/"
                )
        )

        dataList.add(
            DataItem("STUDY ABROAD AND CIVIC ENGAGEMENT",
                "\"Unlocking Global Horizons: How Studying Abroad Empowers Civic Engagement. Explore the transformative journey of students who venture abroad, gaining not just cultural experiences but also a heightened sense of civic responsibility and engagement.\"\n\n" +

                        "1. Choose a Study Abroad Program: Select a study abroad program that aligns with your academic and personal interests. Consider locations and courses that expose you to diverse cultures and perspectives.\n\n" +
                        "2. Preparation and Research: Prior to departure, research the culture, history, and current events of your host country. Familiarize yourself with local customs, languages, and traditions.\n\n" +
                        "3. Engage with Locals: While abroad, actively engage with local communities, make friends, and immerse yourself in the culture. Participate in cultural events, festivals, and traditions to gain a deeper understanding of the host country.\n\n" +
                        "4. Volunteer Opportunities: Seek out volunteer opportunities or community service projects in your host country. Contributing to local initiatives allows you to connect with the community and make a positive impact.\n\n" +
                        "5. Civic Education: Attend lectures, workshops, or courses related to civic engagement and social issues in your host country. Learn about local challenges and opportunities for civic involvement.\n\n" +
                        "6. Cross-Cultural Dialogue: Engage in open dialogues with locals and fellow students. Share your perspectives and listen to theirs, fostering cross-cultural understanding and empathy.\n\n" +
                        "7. Networking: Build a network of international friends, mentors, and contacts. These connections can provide insights into global issues and opportunities for collaborative civic projects.\n\n" +
                        "8. Participate in Local Initiatives: Join or support local civic organizations, community groups, or NGOs that address social and environmental issues in your host country.\n\n" +
                        "9. Reflect and Apply: Regularly reflect on your experiences and how they have shaped your civic perspective. Consider how you can apply your newfound insights and skills to create positive change.\n\n" +
                        "10. Share Your Story: After returning home, share your study abroad experiences and insights with your local community. Raise awareness about global issues and inspire others to engage in civic activities.\n\n",

                "https://news.uchicago.edu/sites/default/files/styles/full_width/public/images/2023-01/shutterstock_374240509.jpg?itok=yAWygw_E",
                "https://news.uchicago.edu/story/students-who-study-abroad-are-more-civically-engaged"
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
    override fun onBackPressed() {
        super.onBackPressed()
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)}
}