package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class navigatingtips : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigatingtips)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion
        dataList.add(DataItem("Dos:",
            "",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("1. Work To Understand The Community.",
            "Conduct windshield tours or walking tours with community leadership. Have informal conversations with community members. Give and take. Over time, share aspects of your life on an appropriate level. Show sincere interest in their lives without being invasive. Embrace the value of every community member through these conversations.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("2. Engage Community Members In Every Aspect Of The Advocacy Work ",
            "If community members are to be surveyed on an issue, seek guidance on how to phrase questions. Circle back to the community to help you understand research findings (ask, what does this really mean?), to understand gaps in research (no research is perfect), and to determine next steps.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("3. Involve Community Members In Every Step Of Research.",
            "Create avenues for young individuals to assume leadership roles within community organizations, clubs, or advocacy groups. By offering these opportunities, you empower the next generation to take charge and drive positive change in their communities. Encouraging youth leadership fosters a sense of ownership and responsibility, ensuring that their voices are heard and their contributions valued.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("4. Celebrate Accomplishments, Big and Small",
            "Advocacy work can create weariness. Seek opportunities to rejoice reinvigorate and renew with the community. Encourage team members to share their successes and milestones, creating a positive and supportive atmosphere that boosts morale and motivation.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("5. Make Changes In Your Own Organization In Order To Resist Internal Traditional Power Structures.",
            "Focus staff development on building capacity within traditionally marginalized communities (e.g., people of color, LGBTQ groups, women, youth, immigrants, poor and working class communities, etc.) ; rather than have the staff take the lead on work within the community, have them support community members in developing strategies, directing resources and executing plans for community change.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("Don't:",
            "",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("1. Don't Dominate Conversations:  ",
            "Refrain from dominating discussions or taking center stage. Instead, prioritize community voices. Encourage community members to actively participate by writing op-ed pieces, sharing their opinions at public hearings, or town hall meetings. When engaging with the media, ensure their perspectives are accurately represented. Emphasize that the community's work is at the forefront.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("2. Don't Push Personal Agendas:",
            "Resist the temptation to push for projects or initiatives that solely align with your interests. Early in your engagement, assess your organization's resources and objectives, ensuring they align with the genuine needs and goals of the community.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("3. Avoid Overstepping Boundaries:",
            "Do not cross healthy boundaries, such as lending personal funds. If you encounter a situation that requires financial assistance, consult your organization's leader and community leaders for guidance. Remember that the objective is to empower the community rather than providing charity.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("4. Provide Closure and Continuity",
            "Don't conclude your involvement abruptly. Assess if the community feels that the issue has been adequately addressed. Explore opportunities for ongoing collaboration or identify the next steps, either related to the same issue or different concerns. Facilitate connections between community members and other resources to address additional issues effectively.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("5. Don't Overlook Community Voices",
            "Ensure that community members' perspectives are not overshadowed or marginalized. Actively seek their input, listen to their concerns, and prioritize their needs and goals throughout the advocacy process.",
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