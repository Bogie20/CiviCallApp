package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class SkillsandOpportunitiesinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_started)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion
        dataList.add(
            DataItem(
                "LEADERSHIP SKILLS FOR COLLEGE STUDENTS",
                "Join us on a journey as we delve into the uncharted territory where leadership skills for college students converge with the transformative power of civic involvement, illuminating new horizons for personal growth and societal impact.\"\"\n\n" +
                        "1. Curriculum Integration: Seamlessly integrate leadership principles into academic courses, infusing civic engagement themes to nurture socially responsible leaders.\n\n" +
                        "2. Experiential Learning: Provide immersive, hands-on experiences that allow students to apply leadership concepts in real-world civic contexts, promoting active learning and skill development.\n\n" +
                        "3. Community Partnerships: Forge robust partnerships with local communities, enabling students to collaborate on projects addressing community needs while honing their leadership abilities.\n\n" +
                        "4. Diversity and Inclusion: Emphasize the value of diverse perspectives, encouraging students to engage with individuals from different backgrounds and fostering inclusive leadership practices.\n\n" +
                        "5. Reflection and Critical Thinking: Incorporate structured reflection activities to help students analyze their civic experiences, encouraging critical thinking and self-awareness.\n\n" +
                        "6. Service-Learning: Implement service-learning initiatives that combine community service with academic study, allowing students to explore social issues and develop leadership skills simultaneously.\n\n" +
                        "7. Leadership Seminars: Host leadership seminars, workshops, and guest speaker events that expose students to inspiring leaders who have made a difference through civic engagement.\n\n" +
                        "8. Mentorship Programs: Establish mentorship programs where experienced civic leaders guide and inspire college students, providing valuable insights and support.\n\n" +
                        "9. Leadership Assessment: Utilize leadership assessment tools to help students identify their strengths and areas for growth, empowering them to become more effective civic leaders.\n\n" +
                        "10. Civic Leadership Capstone: Culminate the educational journey with a civic leadership capstone project, where students design and execute initiatives that address pressing societal challenges, solidifying their leadership and civic engagement skills.",

                R.drawable.img_135,
                "https://journalofleadershiped.org/jole_articles/the-role-of-civic-engagement-in-undergraduate-leadership-courses/",
                "https://pwc.edu.ph/wp-content/uploads/2017/12/image053.jpg"
            )
        )
        dataList.add(
            DataItem("BECOMING A CAMPUS CHANGE AGENT",
                "\"Empowering Tomorrow's Change Agents: Unleashing the Civic Force on Campus. Join us on a journey to mold students into passionate and effective advocates for societal change, as we explore the dynamic world of campus activism.\"\n\n" +
                        "1. Focus on Clear Objectives: Define specific, achievable goals for your movement, ensuring clarity of purpose and direction.\n\n" +
                        "2. Effective Organizational Structure: Establish a well-structured organization with defined roles, responsibilities, and leadership positions.\n\n" +
                        "3. Strategic Planning: Develop a strategic plan that outlines the steps, timeline, and resources required to achieve your objectives.\n\n" +
                        "4. Building Alliances: Collaborate with other student organizations, community groups, or like-minded individuals to expand your network and leverage collective strength.\n\n" +
                        "5. Engage in Outreach: Actively reach out to students, faculty, and the broader community to raise awareness and garner support for your cause.\n\n" +
                        "6. Advocacy and Lobbying: Develop advocacy skills to engage with policymakers, administrators, and relevant authorities to influence change.\n\n" +
                        "7. Resource Mobilization: Secure funding and resources through various means, such as grants, donations, or crowdfunding, to sustain your movement's activities.\n\n" +
                        "8. Effective Communication: Craft compelling messages and utilize multiple communication channels, including social media and traditional media, to amplify your message.\n\n" +
                        "9. Strategic Nonviolent Action: Employ nonviolent strategies and tactics that align with your goals, such as protests, demonstrations, or awareness campaigns.\n\n" +
                        "10. Evaluation and Adaptation: Continuously assess your progress, adapt to changing circumstances, and refine your approach based on lessons learned.\n\n",


                R.drawable.img_136,
                "https://www.ascd.org/blogs/empowering-students-as-change-agents",
                "https://ecowebph.org/wp-content/uploads/2019/10/IMG_4694-scaled.jpg")
        )
        dataList.add(
            DataItem("MENTORSHIP AND CIVIC GROWTH",
                "\"Unlocking the Full Potential of Civic Engagement: Embrace the Power of Mentorship. Dive into a transformative journey where mentorship paves the way for students to not only participate in civic activities but also foster their personal and civic growth.\"\n\n" +
                        "1. Needs Assessment: Begin by conducting a comprehensive needs assessment to understand the specific civic engagement inclinations and goals of your student body.\n\n" +
                        "2. Building a Coalition: Assemble a formal coalition of civic engagement programs that span both academic and co-curricular environments to create a unified approach.\n\n" +
                        "3. Catalog of Opportunities: Develop a catalog of available civic engagement opportunities for students, showcasing a diverse range of options.\n\n" +
                        "4. Diagnostic Tool: Create a diagnostic tool that assesses students' civic motivations and goals, helping to match them with suitable opportunities.\n\n" +
                        "5. Mentorship Protocol: Establish a civic mentoring protocol that pairs students with experienced mentors who guide them in building a progressive portfolio of civic engagement experiences.\n\n" +
                        "6. Mentor Selection: Carefully select mentors with expertise in civic engagement and a commitment to fostering students' growth.\n\n" +
                        "7. Goal Setting: Encourage students and mentors to collaboratively set clear, achievable civic engagement goals that align with the students' interests.\n\n" +
                        "8. Regular Check-Ins: Implement a system for regular check-ins between mentors and students to track progress, provide guidance, and offer support.\n\n" +
                        "9. Assessment and Feedback: Continuously assess the outcomes of the program, focusing on students' sense of institutional belonging and civic growth, and gather feedback for improvement.\n\n" +
                        "10. Personalized Education: Ensure that the Pathways for Civic Growth project contributes to a personalized educational experience, allowing students to tailor their learning journey through community engagement.\n\n",
                R.drawable.img_137,
                "https://www.studentsuccess.pitt.edu/content/pathways-civic-growth-implementing-model-civic-mentoring",
                "https://tciurbanhealth.org/wp-content/uploads/2020/11/phil-fix2.jpeg")
        )

        dataList.add(
            DataItem("EMPOWERING STUDENT LEADERS",
                "\"\"Unlocking the Potential: Nurturing Tomorrow's Civic Leaders Today. In the world of education, the journey to empower student leaders for civic engagement begins with building essential qualities and providing transformative experiences.\"\"\n\n" +
                        "1. Leadership Workshops: Conduct workshops that focus on building leadership skills, emphasizing qualities like accountability, responsibility, and effective communication.\n\n" +
                        "2. Self-Advocacy Development: Encourage students to develop self-advocacy skills through proposal writing. This can start as early as elementary school and empower students to voice their ideas and concerns.\n\n" +
                        "3. Peer-Led Leadership Conferences: Host leadership conferences where students can learn from their peers and local professionals. This not only imparts knowledge but also provides opportunities for high school students to organize and lead events.\n\n" +
                        "4. Real Responsibilities: Give students real responsibilities within the school community, such as leading morning announcements, mentoring younger students, or organizing events like career fairs and tournaments.\n\n" +
                        "5. Mentorship Programs: Establish mentorship programs that connect students with role models who can guide them in developing leadership qualities, including respect and compassion.\n\n" +
                        "6. Community Service Initiatives: Engage students in community service projects, fostering a sense of responsibility and a broader perspective. Encourage them to actively contribute to making positive changes in their communities.\n\n" +
                        "7. Kindness Challenges: Organize kindness challenges to promote positive behavior and attitudes among students, reinforcing the importance of positivity even in the face of adversity.\n\n" +
                        "8. Service Learning Projects: Implement service learning projects that offer students practical experiences in addressing real-world issues, enhancing their problem-solving and critical-thinking skills.\n\n" +
                        "9. Reflective Practices: Incorporate mechanisms for reflection into leadership activities, helping students analyze their actions and decisions to continuously improve their leadership abilities.\n\n" +
                        "10. Recognition and Celebration: Acknowledge and celebrate student leaders who demonstrate consistent dedication and perseverance in their leadership roles. This recognition reinforces their commitment to making a difference.\n\n",



                R.drawable.img_139,
                "https://www.mhskids.org/blog/5-tips-for-empowering-student-leaders/",
                "https://images.squarespace-cdn.com/content/v1/5e20c70a7802d9509b9aeff2/1660252674363-6B2QEJYYOO8BBXXQV9VY/unsplash-image-zFSo6bnZJTw.jpg")
        )

        dataList.add(
            DataItem("LEADERSHIP DEVELOPMENT WORKSHOPS",
                "In the realm of civic engagement, effective leadership development programs serve as the catalysts for transformative change. Explore the science-backed strategies and practical insights that drive the success of leadership development workshops, shaping the leaders of today and tomorrow for a brighter civic future.\n\n" +

                        "1. Needs Analysis: Begin by conducting a thorough needs analysis to identify the specific leadership skills and competencies required for effective civic engagement in your community or organization.\n\n" +
                        "2. Diverse Delivery Methods: Utilize a variety of delivery methods, including practice-based approaches such as action learning projects, role-play, simulations, and collaborative exercises, to enhance participants' learning experiences.\n\n" +
                        "3. Strategic Feedback: Incorporate feedback mechanisms into the program, ensuring that feedback is constructive, timely, and focused on skill development. Consider the use of feedback tools that are effective for leadership development.\n\n" +
                        "4. Spaced Learning Sessions: Design the program with multiple sessions spread over time rather than intensive, massed training. This approach enhances participants' ability to transfer their learning to real-world situations and achieve meaningful results.\n\n" +
                        "5. Face-to-Face Interaction: Incorporate a face-to-face delivery component, as research suggests that in-person leadership training tends to be more effective than purely virtual programs. Face-to-face interactions provide opportunities for practice, demonstration, and deeper engagement.\n\n" +
                        "6. Soft Skills Emphasis: Prioritize the development of soft skills, including leadership, interpersonal, and intrapersonal competencies, as these skills have a significant impact on organizational and community outcomes.\n\n" +
                        "7. Evidence-Based Curriculum: Ensure that the program's curriculum is based on evidence and aligns with the specific needs and challenges of civic engagement. Collaborate with experts to validate the program's theoretical foundations.\n\n" +
                        "8. Outcome-Oriented Design: Design the program with clear, measurable outcomes in mind, aligning it with the desired leadership competencies and the overarching goals of civic engagement.\n\n" +
                        "9. External Collaboration: Seek input and collaboration from external stakeholders, including experts and practitioners in the field of civic engagement, to ensure the program's relevance and effectiveness.\n\n" +
                        "10. Online Program Optimization: If transitioning to online formats, design programs specifically for the online environment rather than merely transferring in-person content. Follow best practices for online program design to maximize engagement and effectiveness.\n\n",
                R.drawable.img_140,
                "https://www.linkedin.com/pulse/8-evidence-based-practices-designing-leadership-development-duns/",
                "https://www.purdue.edu/vpsl/leadership/images/Website-CELD.jpg")
        )

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