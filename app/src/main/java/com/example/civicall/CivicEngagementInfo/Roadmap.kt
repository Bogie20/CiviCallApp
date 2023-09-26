package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class Roadmap : AppCompatActivity() {
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
        setContentView(R.layout.activity_roadmap)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(DataItem(
            "1. Discovering Your Civic Compass:",
            "Your civic journey begins with self-discovery. Identify the causes, values, and issues that profoundly resonate with you. What stirs your emotions? What do you deeply care about? Understanding your passions will serve as the guiding light throughout your civic engagement.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem(
            "2. Crafting Your Civic Vision:",
            "Chart a clear and achievable course for your civic engagement. Whether your mission centers on environmental sustainability, social justice, or community development, delineating your objectives will keep you on a focused and motivated path.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "3. The Power of Informed Engagement:",
            "Delve into research and immerse yourself in learning about the issues that fuel your passion. Arm yourself with facts, historical context, and a comprehensive understanding to advocate effectively and make informed decisions.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "4. Building Bridges, Not Barriers:",
            "Forge connections with individuals from diverse backgrounds and viewpoints. A diverse network offers unique insights, unwavering support, and an expansive platform for your advocacy endeavors.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "5. The Impact of Civic Action:",
            "Translate your commitment into tangible actions by participating in volunteer work and hands-on experiences related to your cause. Practical involvement will deepen your understanding, enhance your credibility, and connect you with kindred spirits.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "6. Speaking Truth to Power:",
            "Champion your cause through various avenues, from engaging with elected representatives to joining rallies and protests. Your voice is a potent instrument for raising awareness and instigating transformative change.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "7. The Diplomacy of Civic Engagement:",
            "Recognize that compromise often plays a pivotal role in civic engagement. Seek common ground, cultivate coalitions, and collaborate with those whose perspectives may differ but share your common goals.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "8. The Resilient Civic Warrior:",
            "Brace yourself for challenges and setbacks along your civic journey. Your ability to maintain resilience will empower you to persevere through adversity, preserving your passion and determination.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "9. Recognizing Your Civic Impact:",
            "Acknowledge and commemorate your achievements, regardless of their scale. Recognizing your progress and milestones will kindle your motivation and inspire others to rally to your cause.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "10. Legacy of Civic Engagement:",
            "As your civic journey progresses, assume the role of a mentor, guiding and educating the next generation of advocates. By bequeathing your knowledge and fervor, you contribute to the enduring legacy of civic engagement.",
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