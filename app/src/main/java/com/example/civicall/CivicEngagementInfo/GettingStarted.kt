package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class GettingStarted : AppCompatActivity() {
    val referenceLinks = arrayOf(
        "https://www.youtube.com/watch?v=tPNxVTtAT5w&ab_channel=Young%26Free",
        "https://www.youtube.com/watch?v=tPNxVTtAT5w&ab_channel=Young%26Free",
        "https://www.youtube.com/watch?v=tPNxVTtAT5w&ab_channel=Young%26Free",
        "https://www.youtube.com/watch?v=tPNxVTtAT5w&ab_channel=Young%26Free",
        "https://www.youtube.com/watch?v=tPNxVTtAT5w&ab_channel=Young%26Free",
        "https://www.youtube.com/watch?v=tPNxVTtAT5w&ab_channel=Young%26Free",
        "https://www.youtube.com/watch?v=tPNxVTtAT5w&ab_channel=Young%26Free",
        "https://www.youtube.com/watch?v=tPNxVTtAT5w&ab_channel=Young%26Free",
        "https://www.youtube.com/watch?v=tPNxVTtAT5w&ab_channel=Young%26Free",
        "https://www.youtube.com/watch?v=tPNxVTtAT5w&ab_channel=Young%26Free",
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_started)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(DataItem("1. Understand Your Motivation: Find Your Cause, Discover Your Passion",
            "Civic engagement begins with understanding why you want to get involved. Take time to reflect on your values and the issues that matter most to you. Whether it's climate change, social justice, education, or healthcare, knowing your motivation will guide your journey in civic engagement.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("2. Research the Issues: Knowledge as Your Catalyst for Change:",
            "Dive deep into the issues you care about. Read books, articles, and research reports, and follow reputable news sources to stay informed. Understanding the complexities of the problems you want to address is essential for effective civic engagement. Being well-informed will allow you to articulate your position, engage in meaningful conversations, and contribute constructively to finding solutions.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("3. Find Your Niche: Tailoring Your Civic Engagement to Your Strengths",
            "Civic engagement comes in many forms, from volunteering and advocacy to running for office. Identify the methods that align with your strengths, interests, and available time. Your niche could be organizing events, joining a community group, or even using your creative skills for awareness campaigns. Choosing the right niche ensures you stay engaged and make the most impact with your efforts.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("4. Register to Vote: Empower Your Voice in the Democratic Process",
            "One of the fundamental aspects of civic engagement is participating in the democratic process. Ensure you are registered to vote in local and national elections. Your vote is your voice, and it's a powerful tool for change. Voting allows you to directly influence policy and elect leaders who share your values.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("5. Connect with Community Groups: Joining Forces for Impactful Civic Engagement",
            "Seek out local community organizations and grassroots movements that align with your interests. These groups often have a wealth of knowledge and experience to share, making it easier for newcomers to get involved and make a difference. Building connections within your community can provide valuable support and networking opportunities.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("6. Attend Town Hall Meetings: Engaging with Local Government for Change",
            "Attend town hall meetings, city council sessions, and other local government gatherings. These meetings provide insights into how decisions are made and allow you to voice your concerns or support for specific policies.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("7. Use Social Media for Advocacy: Mobilize Through Digital Channels",
            "Leverage social media platforms to amplify your message. Share informative content, engage in discussions, and connect with activists and organizations online. Social media can be a powerful tool for raising awareness and mobilizing support. Your online presence can help you reach a broader audience and inspire others to get involved.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("8. Volunteer Your Time: Making a Tangible Difference in Your Community",
            "Volunteering is a tangible way to make a positive impact on your community. Look for volunteer opportunities with nonprofit organizations, schools, shelters, or community centers. Your time and skills are valuable resources. Volunteering allows you to see the immediate effects of your efforts and build relationships with those you're helping.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("9. Stay Informed About Current Events: Acknowledging Civic Achievements",
            "Civic engagement requires ongoing learning. Stay informed about current events, policy changes, and emerging issues related to your interests. Subscribe to newsletters, follow relevant news outlets, and engage in discussions with experts and peers. Continuous education ensures that your advocacy remains relevant and effective.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("10. Build a Support Network: Strength in Numbers for Your Civic Engagement Journey",
            "Surround yourself with a supportive network of friends, family, and fellow activists. The journey of civic engagement can be challenging at times, and having a strong support system will help you stay motivated and resilient. Your support network can provide encouragement, advice, and a sense of belonging as you work towards positive change in your community.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

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