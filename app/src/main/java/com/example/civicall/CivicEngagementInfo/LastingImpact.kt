package com.example.civicall.CivicEngagementInfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class LastingImpact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lasting_impact)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(DataItem("1.Educate Yourself: Stay Informed and Empower Your Impact", "To make a meaningful difference, continuous education about pressing community and global issues is essential. Delve into local and global news, research reports, and documentaries to gain a comprehensive understanding of these challenges. Informed individuals not only identify effective avenues for change but also inspire others to join in tackling these issues, underscoring the pivotal role of knowledge in driving positive change.\n"))
        dataList.add(DataItem("2. Join Student Organizations: Forge Lasting Bonds and Amplify Impact Through Campus Clubs", "Don't go it alone; join forces with like-minded peers in student organizations dedicated to social causes. These clubs provide a dynamic platform for forming lasting bonds with fellow change-makers who share your passion. Collaboration within these communities magnifies your collective influence, offering fresh perspectives, innovative ideas, and unwavering support for a more substantial impact on society. Together, we're stronger in the pursuit of positive change.\n"))
        dataList.add(DataItem("3. Volunteer: Invest Your Time in Community Service for a Purposeful Contribution", "Devote time to volunteering with local charities, nonprofits, or community events, actively contributing to causes you care about. Gain valuable real-world experiences and insights that extend beyond classroom learning. Your dedication to service brings you closer to creating lasting change in your community.\n"))
        dataList.add(DataItem("4. Advocate for Change: Be a Voice for Transformation through Advocacy, Lobbying, and Peaceful Protests", "Be a catalyst for change by advocating for issues you care about. Use your voice to raise awareness, engage in dialogue, and push for policy changes. Advocacy is a powerful tool for societal transformation; stand up for your beliefs and be the change you wish to see in the world.\n"))
        dataList.add(DataItem("5. Network: Cultivate Meaningful Relationships with Mentors, Professors, and Community Leaders to Fuel Your Initiatives  ", "\"Connect with mentors, professors, and community leaders for guidance in your civic engagement initiatives. Their experience and wisdom help you navigate social causes. Building a strong network provides resources and opportunities to elevate your efforts for lasting change.\"\n"))
        dataList.add(DataItem("6. Start Small: Begin Your Journey with Attainable Projects and Grow Your Impact Over Time", "\"Begin your civic engagement journey with smaller, passion-aligned projects to build experience and resilience. Learn from successes and setbacks to gain confidence and gradually take on larger initiatives. Remember, even significant movements start with a single step, so let dedication and determination guide your path toward lasting impact.\"\n"))
        dataList.add(DataItem("7. Use Social Media: Unleash the Potential of Online Platforms to Spark Awareness and Mobilize Action ", "\"Begin your civic engagement journey with smaller, passion-aligned projects to build experience and resilience. Learn from successes and setbacks to gain confidence and gradually take on larger initiatives. Remember, even significant movements start with a single step, so let dedication and determination guide your path toward lasting impact.\"    \n"))
        dataList.add(DataItem("8. Attend Workshops and Conferences: Empower Your Journey with Expert Insights and Skills", "\"Enhance your civic engagement through relevant workshops and conferences. These events offer expert insights, valuable skills, and inspiration from like-minded peers and thought leaders. Embrace these opportunities for continuous growth, refining strategies, and making your initiatives more effective and sustainable on your journey to lasting impact.\"\n"))
        dataList.add(DataItem("9. Collaborate: Join Forces with Local Businesses, Organizations, and Fellow Students to Magnify Your Influence", "\"Amplify your impact through collaborations with local businesses, nonprofits, and like-minded students. Partnerships offer access to resources and diverse perspectives, expanding the reach of your initiatives. Seek mutually beneficial alliances, as collective efforts often yield greater results. By uniting strengths and networks, you can address complex challenges and create lasting solutions. Collaboration is essential in civic engagement, enabling transformative change beyond individual capabilities. Embrace teamwork in your pursuit of meaningful impact.\"\n"))
        dataList.add(DataItem("10. Persist and Adapt: Embrace the Journey of Change with Resilience and Adaptability", "\"Creating lasting impact is a journey demanding persistence and adaptability. Change unfolds gradually, setbacks are natural. Stay committed, draw strength from your passion, and view challenges as opportunities for growth. Adapt, refine, and embrace resilience and flexibility. With unwavering dedication and a willingness to evolve, you can navigate complexities and make a lasting difference in your community and beyond.\"\n"))


        val adapter = DataAdapter(dataList)
        recyclerView.adapter = adapter
    }
}
