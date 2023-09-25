package com.example.civicall.CivicEngagementInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class Roadmap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roadmap)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(DataItem("1.Discovering Your Civic Compass: Define Your Values and Passions:", "Your civic journey begins with self-discovery. Identify the causes, values, and issues that profoundly resonate with you. What stirs your emotions? What do you deeply care about? Understanding your passions will serve as the guiding light throughout your civic engagement.\n\n"))
        dataList.add(DataItem("2.Crafting Your Civic Vision: Set Clear Goals", "Chart a clear and achievable course for your civic engagement. Whether your mission centers on environmental sustainability, social justice, or community development, delineating your objectives will keep you on a focused and motivated path.\n"))
        dataList.add(DataItem("3.The Power of Informed Engagement: Educate Yourself ", "Delve into research and immerse yourself in learning about the issues that fuel your passion. Arm yourself with facts, historical context, and a comprehensive understanding to advocate effectively and make informed decisions.\n"))
        dataList.add(DataItem("4.Building Bridges, Not Barriers: Build a Diverse Network ", "Forge connections with individuals from diverse backgrounds and viewpoints. A diverse network offers unique insights, unwavering support, and an expansive platform for your advocacy endeavors.\n\n"))
        dataList.add(DataItem("5.The Impact of Civic Action: Volunteer and Gain Experience", "\"Translate your commitment into tangible actions by participating in volunteer work and hands-on experiences related to your cause. Practical involvement will deepen your understanding, enhance your credibility, and connect you with kindred spirits.\n\"\n"))
        dataList.add(DataItem("6. Speaking Truth to Power: Advocate for Change ", "\"Champion your cause through various avenues, from engaging with elected representatives to joining rallies and protests. Your voice is a potent instrument for raising awareness and instigating transformative change.\n\"\n"))
        dataList.add(DataItem("7.The Diplomacy of Civic Engagement: Master the Art of Compromise:", "\"Recognize that compromise often plays a pivotal role in civic engagement. Seek common ground, cultivate coalitions, and collaborate with those whose perspectives may differ but share your common goals.\"    \n"))
        dataList.add(DataItem("8. The Resilient Civic Warrior: Stay Resilient", "\"Brace yourself for challenges and setbacks along your civic journey. Your ability to maintain resilience will empower you to persevere through adversity, preserving your passion and determination.\"\n"))
        dataList.add(DataItem("9. Recognizing Your Civic Impact: Celebrate Your Successes ", "\"Acknowledge and commemorate your achievements, regardless of their scale. Recognizing your progress and milestones will kindle your motivation and inspire others to rally to your cause.\"\n"))
        dataList.add(DataItem("10. Legacy of Civic Engagement: Nurturing Future Leaders", "\"As your civic journey progresses, assume the role of a mentor, guiding and educating the next generation of advocates. By bequeathing your knowledge and fervor, you contribute to the enduring legacy of civic engagement.\"\n"))


        val adapter = DataAdapter(dataList)
        recyclerView.adapter = adapter

    }
}