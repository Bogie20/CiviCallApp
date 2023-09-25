package com.example.civicall.CivicEngagementInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class YouthEmpowerment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youth_empowerment)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(DataItem(
            "1. Seizing the College Platform: Elevate Your Voice:",
            "College is your platform to make a difference. Actively engage in campus discussions, join student councils, or start your own initiatives. Speak out on issues that matter to you during seminars, workshops, and campus events. Your college years are the perfect time to develop your public speaking skills and build a reputation as a passionate advocate.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "2. Academic Exploration: Knowledge as a Catalyst",
            "Leverage your coursework to enhance your civic engagement. Consider taking classes in political science, sociology, or environmental studies to gain a deeper understanding of societal issues. Engage in research projects that allow you to contribute to solutions. Knowledge acquired in the classroom can be applied directly to real-world problems.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "3. Student Organizations: Joining Forces",
            "Connect with student-led organizations that align with your civic interests. Attend meetings, contribute ideas, and actively participate in their initiatives. Collaborating with diverse groups on campus can introduce you to a wide range of perspectives and strategies for advocacy.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "4. Mentorship and Guidance: Learn from Civic Mentors",
            "Seek out professors, alumni, or community leaders who share your passion for civic engagement. Establish a mentorship relationship to gain insights, advice, and practical wisdom. These mentors can help you navigate challenges, refine your goals, and provide valuable connections in the field.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "5. Campus Projects and Initiatives: Start Local, Think Global:",
            "Begin by addressing issues within your college community. Join or initiate projects that tackle local challenges, whether it's organizing campus clean-ups, promoting sustainable practices, or addressing campus diversity and inclusion. These grassroots efforts can inspire broader civic engagement.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "6. Social Media and Digital Activism: The Modern Soapbox",
            "Use social media platforms strategically to promote your causes. Craft compelling content, share relevant articles, and engage in meaningful discussions. Connect with influential voices in your field and explore online advocacy campaigns. Social media can be a powerful tool to raise awareness and mobilize support.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "7. Community Engagement: Extending Beyond Campus Borders",
            "Extend your impact to the surrounding community by volunteering with local organizations, participating in neighborhood initiatives, or interning with nearby nonprofits. Engaging with the broader community allows you to witness the direct effects of your efforts and build valuable connections.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "8. Leadership Development: Cultivating Effective Leaders",
            "Attend leadership workshops, seminars, and conferences offered by your college. Develop skills such as team management, conflict resolution, and strategic planning. Effective leadership is pivotal in mobilizing fellow students and driving meaningful change.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "9. Civic Responsibility: Voting and Advocacy",
            "Not only should you register to vote but actively encourage your peers to do the same. Organize voter registration drives and candidate forums on campus. Engage in advocacy efforts, whether it's lobbying for student-friendly policies or participating in protests to raise awareness of pressing issues.",
            R.drawable.love2
        ))

        dataList.add(DataItem(
            "10. Sustainable Commitment: Nurturing Lifelong Civic Engagement",
            "Understand that civic engagement is not a transient phase; it's a lifelong commitment. As you graduate, continue your involvement through community organizations, advocacy groups, or even pursuing a career in public service. Keep your passion for making a difference alive, and inspire others to do the same. Your dedication can create enduring change.",
            R.drawable.love2
        ))

        val adapter = DataAdapter(dataList)
        recyclerView.adapter = adapter

    }
}