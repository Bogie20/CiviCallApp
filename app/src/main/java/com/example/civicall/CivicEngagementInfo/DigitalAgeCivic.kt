    package com.example.civicall.CivicEngagementInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class DigitalAgeCivic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_digital_age_civic)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(DataItem("1.Define Your Cause: Ignite Your Passion, Unleash Your Purpose", "Clearly articulate the social or political issue that fuels your passion and advocacy. Develop a comprehensive understanding of the issue, including its history, impact, and current state. Establish specific, measurable goals that you aim to achieve through your social media advocacy efforts, such as raising awareness, influencing policy changes, or mobilizing support for a cause.\n"))
        dataList.add(DataItem("2.Know Your Platforms: Navigating the Digital Landscape", "Conduct thorough research to identify the most suitable social media platforms for your advocacy campaign. Consider the demographic characteristics, user behavior, and communication style of each platform's audience. Tailor your content and engagement strategies to align with the platform's strengths and user expectations. For example, visual platforms like Instagram may require more graphics and storytelling, while Twitter may focus on concise messaging and real-time updates.\n"))
        dataList.add(DataItem("3.Create Compelling Content: Crafting Digital Narratives for Change", "Craft engaging and visually appealing content that resonates with your target audience. Develop a content calendar to ensure consistency in your messaging and maintain your campaign's momentum. Use a variety of content types, such as videos, infographics, personal stories, and user-generated content, to convey your message from different angles. Incorporate emotionally compelling narratives and data-driven insights to capture your audience's attention and drive action.\n"))
        dataList.add(DataItem(" 4.Leverage Hashtags: Tagging Your Cause for Visibility", "Dive deep into hashtag research to discover the most relevant and impactful tags for your cause. Explore both trending and niche hashtags related to your advocacy. Create custom hashtags that reflect your campaign's unique identity and encourage user participation. Implement a hashtag strategy that incorporates a mix of popular and specific tags to maximize your content's discoverability and engagement.\n"))
        dataList.add(DataItem("5.Engage Your Audience: Fostering Digital Conversations for Change", "\" Actively foster engagement with your audience by responding to comments, messages, and mentions in a timely and personalized manner. Create a sense of community by acknowledging and appreciating your supporters, and provide informative responses to inquiries or concerns. Implement engagement tactics such as polls, surveys, and Q&A sessions to encourage two-way communication and empower your audience to participate actively.\"\n"))
        dataList.add(DataItem("6.Stay Informed: Navigating the Digital Tide of Information", "\"Commit to ongoing education about your advocacy issue by immersing yourself in relevant news, research reports, and expert opinions. Develop expertise in your field to provide credible information and perspectives. Continuously verify and fact-check the information you share on social media to maintain your credibility and combat the spread of misinformation.\"\n"))
        dataList.add(DataItem("7.Collaborate with Influencers: Amplifying Impact Through Digital Alliances", "\"Identify and collaborate with social media influencers or activists who align with your cause and have an established following. Build genuine relationships with these influencers, and leverage their endorsement and support to amplify your campaign's reach and impact. Collaborations can include co-hosting live events, participating in joint campaigns, or featuring influencers in your content to reach new audiences effectively.\"    \n"))
        dataList.add(DataItem("8.Advocate Responsibly: Navigating Digital Activism with Integrity", "\"Uphold a respectful and constructive tone in your online interactions, even when engaging with individuals who hold opposing viewpoints. Constructive dialogue fosters a positive image for your cause and encourages open-mindedness among your audience. Implement moderation and content guidelines to maintain a safe and inclusive online environment that promotes productive discussions.\"\n"))
        dataList.add(DataItem("9.Mobilize for Action: Uniting Digital Voices for Real-world Change", "\"Encourage your followers to take concrete actions in support of your cause. Clearly outline the steps they can take, whether it's signing petitions, contacting elected officials, attending rallies or events, or making donations. Provide accessible resources, guides, and templates that simplify the process of engagement and empower your audience to contribute meaningfully to your advocacy.\"\n"))
        dataList.add(DataItem("10. Stay Resilient: Your Voice Matters", "\"Utilize the analytics tools available on social media platforms to monitor the performance of your advocacy campaigns. Analyze key metrics such as engagement rates, reach, click-through rates, and conversion rates to evaluate the effectiveness of your efforts. Regularly review your data insights to identify trends, strengths, and areas for improvement. Adjust your strategy based on these insights to maximize your impact and refine your approach over time.\"\n"))


        val adapter = DataAdapter(dataList)
        recyclerView.adapter = adapter
    }
}