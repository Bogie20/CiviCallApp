package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class ParticipantTips: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_participant_tips)




        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion
        dataList.add(DataItem(
            "1. Passion Ignition:",
            "Start by exploring your own interests and values. Consider what issues resonate deeply with you, and how your passion can drive meaningful change. The more connected you are to your chosen cause, the more determined and effective you'll be in your efforts.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128",
            "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"))

        dataList.add(DataItem(
            "2. Local Impact Quest:",
            "Dive into your community with enthusiasm. Seek out local nonprofit organizations, community events, and campus clubs that align with your cause. Making a difference close to home can be incredibly rewarding and allow you to witness the immediate impact of your actions.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128",
            "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"))

        dataList.add(DataItem(
            "3. Time Mastery:",
            "Time management is the key to balancing your academic responsibilities and your civic engagement. Create a well-structured schedule that includes study time, volunteer work, and self-care to ensure you stay productive without burning out.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128",
            "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"))

        dataList.add(DataItem(
            "4. Networking Nirvana:",
            "Building a network of like-minded individuals is a powerful asset. Connect with fellow students who share your passion, seek guidance from supportive professors, and engage with community leaders. Collaborative efforts often yield greater results and valuable mentorship opportunities.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128",
            "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"))

        dataList.add(DataItem(
            "5. Informed Influence:",
            "Knowledge is your most potent tool in advocacy. Stay informed by keeping up with current events, reading policy updates, and delving into research related to your cause. Being well-informed enables you to advocate effectively and make informed decisions.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128",
            "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"))

        dataList.add(DataItem(
            "6. Digital Dynamo:",
            "Leverage the power of social media and online platforms to amplify your message. Use these tools to create and share compelling content, launch petitions, and connect with a wider audience. The digital realm can be a game-changer in spreading awareness and mobilizing support.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128",
            "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"))

        dataList.add(DataItem(
            "7. Advocacy Artistry:",
            "Cultivate your advocacy skills to become a persuasive communicator. Practice public speaking, refine your writing, and develop your online communication techniques. The ability to convey your message effectively is essential for inspiring action.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128",
            "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"))

        dataList.add(DataItem(
            "8. Volunteer Ventures:",
            "Be selective in your volunteer roles. Look for opportunities that align with your skills and passions, ensuring that your contributions are not only valuable to the cause but also personally fulfilling.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128",
            "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"))

        dataList.add(DataItem(
            "9. Vote Your Voice:",
            "Registering to vote and encouraging others to do the same is a fundamental aspect of civic engagement. Participating in elections gives you a direct say in shaping policies and the future of your community and country.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128",
            "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"))

        dataList.add(DataItem(
            "10. Progressive Reflection:",
            "Regularly assess your efforts and adapt your approach as needed. Reflect on your experiences to ensure that your civic engagement journey remains effective and personally satisfying. Embrace change and growth as you continue to make a positive impact on the world around you.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128",
            "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"))

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