package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityFivemakeyourvoiceheardBinding

class FiveMakeYourVoiceHeard : AppCompatActivity() {
    private lateinit var binding:ActivityFivemakeyourvoiceheardBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityFivemakeyourvoiceheardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, CivicMenu::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }


        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "IMPORTANCE OF COLLEGE VOTER ENGAGEMENT",
                "\"Discover the Student's Guide to Civic Participation: Empowering Your Voice\" and explore the pivotal role of college voter engagement in shaping tomorrow's civic leaders. Unleash your potential to drive change and strengthen democracy on campus and beyond.\"Comprehensive Disaster Preparedness Kits: A Guide to Effective Disaster Response\" and equip yourself with the knowledge to safeguard your community and ensure a brighter, more resilient future.\"\"\n\n" +
                        "1. ASSESS YOUR CIVIC AWARENESS: Start by evaluating your current knowledge of civic issues and your level of engagement. Identify areas where you'd like to make a difference.\n\n" +
                        "2. EXPLORE CAMPUS RESOURCES: Research the resources available on your college campus for civic engagement, including clubs, organizations, and events related to voter registration and political activism.\n\n" +
                        "3. REGISTER TO VOTE: If you're eligible to vote, register to vote in local, state, and national elections. Familiarize yourself with voter registration deadlines and requirements in your state.\n\n" +
                        "4. GET INFORMED: Stay updated on current events, policies, and candidates. Read newspapers, follow reputable news sources, and attend campus discussions or lectures on civic topics.\n\n" +
                        "5. ENGAGE IN POLITICAL DISCUSSIONS: Participate in discussions and debates on campus to better understand different perspectives and develop your own informed opinions.\n\n" +
                        "6. JOIN CIVIC CLUBS: Join student clubs or organizations focused on civic engagement and voter participation. These groups often organize voter registration drives and events.\n\n" +
                        "7. VOLUNTEER: Contribute to community service projects or political campaigns that align with your values. Volunteer work can provide hands-on experience and connections in the field.\n\n" +
                        "8. ADVOCATE FOR ISSUES: Identify key issues that matter to you and your community. Write letters to elected officials, attend town hall meetings, and advocate for policy changes.\n\n" +
                        "9. EDUCATE OTHERS: Share your knowledge and passion for civic engagement with fellow students. Host workshops or informational sessions to educate others about the importance of voting and civic participation.\n\n" +
                        "10. PARTICIPATE IN ELECTIONS: Encourage voter turnout among your peers by organizing on-campus election events, promoting early voting, and assisting with absentee ballot requests. Your involvement can have a significant impact on the democratic process.\n\n",

                "https://media.philstar.com/images/articles/gen17-barangay-sk-polls_2018-07-08_21-40-54.jpg",
                "https://www.forbes.com/sites/civicnation/2022/11/01/community-colleges-are-key-to-promote-voter-engagement/?sh=505452ee31ff/"
            )
        )
        dataList.add(
            DataItem("ELECTION PREPAREDNESS FOR STUDENTS",
                "Prepare for the future of democracy with \"Election Preparedness for Students.\" Explore how civic education and values can empower the next generation of voters, fostering a society where leadership is the norm, not the exception.\n\n" +
                        "1. CIVIC EDUCATION INTEGRATION: Advocate for the integration of comprehensive civic education into school curricula, emphasizing democratic values, responsibilities, and the importance of informed voting.\n\n" +
                        "2. VOTER REGISTRATION DRIVES: Organize voter registration drives within educational institutions to ensure students are registered and eligible to vote when the time comes.\n\n" +
                        "3. YOUTH-LED CIVIC CLUBS: Establish student-led civic clubs or organizations that promote active participation in the democratic process and provide a platform for discussion.\n\n" +
                        "4. CIVIC VALUES CURRICULUM: Develop a curriculum that instills civic values, critical thinking, and open dialogue to encourage students to engage in constructive political discourse.\n\n" +
                        "5. DEMOCRACY WORKSHOPS: Conduct workshops that educate students about the electoral process, candidates, and the impact of their votes on local and national issues.\n\n" +
                        "6. ACTIVE CITIZENSHIP PROJECTS: Encourage students to initiate projects that address community issues, allowing them to experience the positive impact of civic engagement.\n\n" +
                        "7. COLLABORATE WITH CIVIL SOCIETY: Partner with civil society organizations to provide resources and expertise in voter education and civic engagement initiatives.\n\n" +
                        "8. YOUTH-LED CAMPAIGNS: Empower students to create and lead nonpartisan voter awareness campaigns targeting their peers, emphasizing the importance of informed voting.\n\n" +
                        "9. DEBATE AND DISCUSSION FORUMS: Organize regular debates and discussion forums where students can exchange ideas, challenge perspectives, and refine their understanding of civic issues.\n\n" +
                        "10. MENTORSHIP PROGRAMS: Establish mentorship programs that connect experienced civic-minded individuals with students, offering guidance and inspiration for active citizenship.\n\n",

                "https://wp.atenews.ph/wp-content/uploads/2022/05/Graphics-Atenean-Profile.png",
                "https://www.samuelcohn.net/development-1/everything-you-need-to-know-about-how-to-create-a-successful-student-led-social-movement",)
        )
        dataList.add(
            DataItem("POLITICAL ACTIVISM AND YOUTH",
                "\"Empowering Tomorrow's Leaders: Political Activism and Youth\" unveils the transformative role young minds play in shaping our political landscape. Dive into their passion for change, driving a brighter future for all.\n\n" +
                        "1. YOUTH-LED INITIATIVES: Encourage and support young people in initiating their own community projects and campaigns focused on pressing global and local issues.\n\n" +
                        "2. CIVIC EDUCATION ENHANCEMENT: Advocate for comprehensive civic education in schools, emphasizing global issues, critical thinking, and active participation in democratic processes.\n\n" +
                        "3. INTERCONNECTED LEARNING: Foster intercultural understanding and cooperation by providing opportunities for students to engage with different cultures, both locally and globally.\n\n" +
                        "4. GLOBAL-MINDED CURRICULUM: Develop curricula that target the competencies required for effective global citizenship, including empathy, responsibility, and a sense of duty to the planet and humanity.\n\n" +
                        "5. CIVIC AND POLITICAL COMPETENCE: Promote competences such as critical thinking, communication skills, and civic-mindedness to empower young people to engage effectively in political and civic action.\n\n" +
                        "6. ENCOURAGE INTERCULTURAL CONTACT: Create platforms for meaningful intercultural contact, cooperation, and dialogue among young individuals, enhancing tolerance and appreciation of cultural diversity.\n\n" +
                        "7. SUPPORT FOR CIVIC AND POLITICAL PARTICIPATION: Establish organizations and platforms that provide resources, guidance, and opportunities for young people to participate in civic and political activities.\n\n" +
                        "8. PARENTAL AND COMMUNITY INVOLVEMENT: Encourage parents and communities to engage in civic and political actions, setting positive examples for young individuals.\n\n" +
                        "9. PEER ENGAGEMENT: Cultivate a sense of solidarity among peers, promoting commitment to civic and political goals and values within school and community settings.\n\n" +
                        "10. GLOBAL AWARENESS: Inspire young people to explore and critically understand global issues, allowing them to channel their passions into global citizenship activities.\n\n",

                "https://eu.boell.org/sites/default/files/grid/2021/12/06/Young%20voices%20on%20the%20rise%201960x784px.jpg",
                "https://www.un.org/en/chronicle/article/young-peoples-civic-and-political-engagement-and-global-citizenship",)
        )

        dataList.add(
            DataItem("ADVOCATING FOR VOTING RIGHTS",
                "\"In a world of unprecedented challenges, college students stand at the threshold of making their voices heard. Discover how these young changemakers are turning their passion into powerful civic action, fueling a wave of transformation on campuses and beyond.\"\n\n" +
                        "1. FACULTY-LED INITIATIVES: Encourage professors to actively promote voter registration within their classrooms, fostering civic responsibility among students.\n\n" +
                        "2. STUDENT-LED ENGAGEMENT: Empower student leaders to spearhead voter registration efforts, creating a relatable and engaging experience for their peers.\n\n" +
                        "3. REGISTRATION PRESENTATIONS: Implement concise and impactful voter registration presentations during classes, simplifying the registration process for students.\n\n" +
                        "4. UTILIZE NORMS: Harness the influence of peer norms to make voter registration a common practice among college students.\n\n" +
                        "5. COMPLIANCE WITH LEGAL OBLIGATIONS: Ensure universities comply with legal requirements for voter registration to safeguard federal student-aid funds.\n\n" +
                        "6. TAILORED MESSAGING: Customize registration messages to address the unique challenges and motivations of college students.\n\n" +
                        "7. OVERCOME PSYCHOLOGICAL HURDLES: Address psychological barriers that may deter college students from participating in electoral politics.\n\n" +
                        "8. DATA-DRIVEN APPROACH: Utilize data and voter information to monitor registration rates and voter turnout, allowing institutions to measure their impact.\n\n" +
                        "9. EFFICIENT CLASSROOM OUTREACH: Develop efficient methods for classroom-based voter registration presentations, optimizing time and engagement.\n\n" +
                        "10. WIDESPREAD ADOPTION: Encourage more universities to adopt these strategies, transforming the legal mandate into a successful program for engaging students in the electoral process.\n\n",

                "https://files01.pna.gov.ph/ograph/2023/01/11/comelec-seminars-registration-in-schoolscomelec-photo.jpg",
                "https://www.cambridge.org/core/journals/ps-political-science-and-politics/article/i-will-register-and-vote-if-you-teach-me-how-a-field-experiment-testing-voter-registration-in-college-classrooms/2752048B2D7F6E703553306C5EF8AB4D",)
        )

        dataList.add(
            DataItem("FOSTERING CIVIC ENGAGEMENT CLASSROOM VOTER REGISTRATION INITIATIVES",
                "\"As the midterm elections draw near, the spotlight on voter engagement intensifies, but one crucial demographic often overlooked is the youth vote. In a world of growing political apathy accusations, schools emerge as the frontline for cultivating informed, enthusiastic young voters.\"\n\n" +

                        "1. EARLY CIVIC EDUCATION: Start civic education early, incorporating 'everyday civics' concepts even in elementary grades. Create a democratic school environment that encourages students to voice their opinions and participate in decision-making.\n\n" +
                        "2. CULTIVATE A CULTURE OF PARTICIPATION: In middle and high school, establish more formal structures for participation, such as student governance and mock elections. Encourage students to get involved in these activities to develop their leadership and civic engagement skills.\n\n" +
                        "3. COMPREHENSIVE CIVICS CURRICULUM: Ensure that the civics curriculum goes beyond U.S. history and government. Include discussions on social issues, the workings of democratic processes, taking informed action to address concerns, and news media literacy.\n\n" +
                        "4. EDUCATING FOR AMERICAN DEMOCRACY (EAD): Utilize resources like the Educating for American Democracy Roadmap, a cross-ideological initiative designed to enhance civics and history education. It provides guides and resources that educators can adapt to fit their specific needs.\n\n" +
                        "5. INCORPORATE CIVIC LEARNING ACROSS SUBJECTS: Infuse civic learning throughout various subjects to provide students with multiple opportunities to learn about elections and democracy in different contexts.\n\n" +
                        "6. INVOLVE THE WHOLE COMMUNITY: Recognize that civic education shouldn't be limited to the classroom. Collaborate with community organizations, parents, and young people to create a comprehensive civic education ecosystem. Work with local elections offices, grassroots organizations, libraries, and museums to offer diverse civic education experiences.\n\n" +
                        "7. FORMAL AND INFORMAL PARTNERSHIPS: Establish formal or informal partnerships with elections offices to facilitate voter registration initiatives or youth involvement as poll workers. Collaborate with local organizations working on issues that students care about.\n\n" +
                        "8. STUDENT INVOLVEMENT: Involve students in the process by seeking their input on what they want and need to learn about elections and voting. Encourage them to participate actively in civic education initiatives.\n\n" +
                        "9. ASSESS AND MAP EXISTING ASSETS: Use tools like the CIRCLE Growing Voters report's asset mapping guide to assess existing resources, capacities, and relationships within the school and community that can support civic education and voter registration efforts.\n\n" +
                        "10. SUSTAINED COMMITMENT: Recognize that fostering civic engagement and voter registration initiatives is an ongoing process. Maintain a sustained commitment to civic education and continue to adapt and expand initiatives to meet the evolving needs of students and the community.\n\n",

                "https://assets2.rappler.com/186BBB6087E243DAA2BBC782442E45D0/img/838349FD3FF44BD2B3D16FA39E01813C/Voters_registration_in_Quezon_City-Sept-25-2018-01.jpg",
                "https://www.nationalcivicleague.org/ncr-article/growing-voters-in-the-classroom-and-beyond/")
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
    override fun onDestroy() {
        super.onDestroy()

        networkUtils.cleanup()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)}
}