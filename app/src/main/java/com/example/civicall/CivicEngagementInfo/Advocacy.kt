package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class Advocacy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advocacy)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()
        dataList.add(DataItem(
            "1. Find Your Cause: Follow Your Passion",
            "Begin your journey by discovering the social or political issue that truly resonates with you. Effective advocacy is fueled by genuine passion and commitment. When you align your efforts with a cause that speaks to your heart, your voice becomes a powerful force for change.",
            R.drawable.love2,
            "https://www.youtube.com/watch?v=xtJ4BtEcOfg&ab_channel=CCFAlabang"))
        dataList.add(DataItem("2. Educate Yourself: Empower Your Advocacy",
            "Delve into comprehensive research to gather facts, strengthen your arguments, and expand your knowledge base. Informed advocacy is a potent tool in making your voice heard on key issues, as it lends credibility and depth to your perspective, enabling you to engage in constructive dialogues and drive meaningful change.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("3. Craft Your Message: Persuasive Communication",
            "Create concise and compelling messages that effectively convey your stance and persuade others. The art of crafting a persuasive message is a key tool in making your voice heard on critical issues, enabling you to inspire action and engage in meaningful discussions that drive positive change.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("4. Networking: Amplify Your Influence",
            "Forge connections with like-minded individuals and organizations to expand your sphere of influence and amplify your impact in the realm of civic engagement and advocacy. Collaborative networking enhances your ability to address critical issues effectively, fostering a supportive community that can propel your advocacy efforts forward.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("5. Meet with Officials: Advocate for Change",
            "Arrange meetings with policymakers to discuss your concerns, share insights, and propose constructive solutions. Engaging directly with officials is a pivotal way to make your voice heard on key issues, as it enables you to advocate for change at the policy level. Building relationships with decision-makers fosters a platform for open dialogue and collaboration. By consistently meeting with officials and maintaining a constructive rapport, you can effectively influence policies that address critical matters in your community and beyond.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("6. Leverage Social Media: Amplify Your Reach",
            "Harness the power of social media platforms to raise awareness, mobilize support, and connect with a broader audience. Utilizing these digital channels is a modern and effective way to make your voice heard on key issues, as it allows you to engage with a wide range of individuals who share your concerns and passions. By strategically leveraging social media, you can magnify your impact and create a ripple effect of positive change.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("7. Collaborate: Unite for Greater Impact",
            "Team up with individuals and organizations that share your goals, recognizing that collective action often achieves more significant results in advocacy and civic engagement. Collaboration strengthens your efforts by pooling resources, expertise, and networks, making it a potent strategy for addressing key issues. Embracing collaboration allows you to tap into diverse perspectives and innovative ideas, ultimately leading to more comprehensive and effective solutions.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("8. Advocate Locally: Drive Change in Your Community",
            "Begin your advocacy efforts at the community level, where change can often occur more swiftly and have a tangible impact on people's lives. Focusing on local advocacy allows you to address immediate needs and build a strong foundation for broader change. By starting within your community, you can inspire others to join your cause and create a ripple effect of positive transformation.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("9. Nonviolent Protest: Raise Your Voice Peacefully",
            "Consider organizing or participating in peaceful protests and demonstrations as a means to draw attention to your cause and advocate for change. Nonviolent protests have a long history of driving social and political transformation. By standing up for your beliefs in a peaceful and respectful manner, you can send a powerful message and inspire others to join your movement for key issues.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("10. Stay Resilient: Your Voice Matters",
            "Advocacy can be challenging, but persistence is key to making a difference. Remember that your voice matters, and lasting change is within reach when you remain resilient and committed to your cause. In the face of obstacles, your determination and passion can drive meaningful transformation on critical issues.",
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