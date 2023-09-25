package com.example.civicall.CivicEngagementInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class TacticsImpact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tactics_impact)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(DataItem(
            "1. Build a Strong Personal Brand:",
            "Establish yourself as a knowledgeable and trustworthy advocate for your cause by consistently sharing well-researched information and insights. Engage in public speaking engagements, contribute to authoritative publications, and cultivate a reputation for being a reliable source of information and leadership in your field.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "2. Leverage Social Media:",
            "Utilize social media platforms to share informative and engaging content related to your cause. Regularly interact with your audience, respond to comments, and foster a sense of community around your advocacy. Collaborate with influencers and organizations aligned with your mission to extend your reach.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "3. Use Data and Facts",
            "Back your arguments and advocacy efforts with compelling data, research, and facts. Craft data-driven narratives that demonstrate the significance of the issues you're addressing. Statistics and evidence lend credibility to your message and can be a powerful tool for convincing policymakers and the public.",
            R.drawable.love2
        ))
        dataList.add(DataItem(
            "4. Storytelling:",
            "Incorporate storytelling into various mediums, such as social media posts, blog articles, and public speeches. Share stories that not only highlight the challenges but also underscore the potential solutions and positive outcomes that your advocacy can bring about. Encourage others to share their own stories to create a sense of solidarity and unity within your community.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "5. Lobby and Advocate:",
            "Actively engage with elected officials and policymakers by scheduling meetings, attending legislative sessions, and participating in advocacy campaigns. Building relationships with decision-makers can lead to more substantial and lasting policy changes.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "6. Engage with the Media:",
            "Write op-eds, letters to the editor, or press releases to share your perspective in newspapers, magazines, and online publications. Building relationships with journalists and getting featured in the media can significantly increase the visibility of your cause and message.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "7. Host Events and Webinars:",
            "Organize events, webinars, or panel discussions to create opportunities for experts, stakeholders, and the public to engage in meaningful conversations about important issues. These gatherings can serve as platforms for sharing knowledge, raising awareness, and inspiring action.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "8. Use Petitions and Online Campaigns:",
            "Write op-eds, letters to the editor, or press releases on a regular basis to maintain a consistent presence in the media. Building strong relationships with journalists and editors can result in more frequent coverage of your advocacy efforts. Additionally, consider offering to be a resource for reporters covering topics related to your cause, establishing yourself as an expert source.",
            R.drawable.love2
        ))
        dataList.add(DataItem(
            "9. Collaborate with Partner Organizations:",
            "Identify and reach out to organizations that complement your mission, and actively seek opportunities for joint projects and campaigns. Collaborative efforts can pool resources, expand your reach, and amplify the impact of your advocacy. Create Memoranda of Understanding (MOUs) or partnership agreements that outline roles, responsibilities, and shared goals to ensure smooth collaboration.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "10. Educate and Train Others:",
            "Take on a mentorship role to educate and empower others who are passionate about your cause. Offer workshops, training sessions, or educational resources to help individuals become effective advocates themselves. Share your experiences and insights, providing practical guidance on building coalitions, navigating complex issues, and mobilizing grassroots efforts. Encourage collaboration and the sharing of best practices among emerging advocates to create a supportive and informed community.",
            R.drawable.love2
        ))

        val adapter = DataAdapter(dataList)
        recyclerView.adapter = adapter
    }
}