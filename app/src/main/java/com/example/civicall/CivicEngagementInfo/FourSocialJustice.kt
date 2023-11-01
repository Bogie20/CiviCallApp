package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.NetworkUtils
import com.example.civicall.R

class FourSocialJustice : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foursocialjustice)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion
        dataList.add(
            DataItem(
                "FIGHTING FOR RACIAL EQUALITY",
                "Join us on a journey to explore the vital topic of racial equality in the realm of college student civic engagement. In this enlightening discussion, we delve into the significance of advocating for racial equality and why it's a cause that resonates deeply with students.\"\n\n\n" +
                        "1. EDUCATE YOURSELF: Start by gaining a comprehensive understanding of racial equality issues, including their historical context and current manifestations. Read books, articles, and watch documentaries to deepen your knowledge.\n\n" +
                        "2. PARTICIPATE IN CAMPUS DISCUSSIONS: Engage in open and respectful dialogues about racial equality on your college campus. Attend seminars, workshops, and forums to exchange ideas and perspectives with your peers.\n\n" +
                        "3. JOIN STUDENT ORGANIZATIONS: Become a member of or support student groups dedicated to promoting racial equality and social justice. These organizations often lead initiatives and events on campus.\n\n" +
                        "4. ADVOCATE FOR INCLUSIVE POLICIES: Collaborate with student government or relevant authorities to advocate for policies that foster diversity and inclusion in academic settings. This may involve proposing reforms or supporting existing efforts.\n\n" +
                        "5. ATTEND DIVERSITY TRAINING: Participate in diversity and inclusion training programs to develop cultural competence and enhance your ability to address racial equality issues effectively.\n\n" +
                        "6. ORGANIZE AWARENESS CAMPAIGNS: Plan and execute awareness campaigns, events, and rallies that highlight racial equality concerns. Use creative approaches to educate and engage the broader student community.\n\n" +
                        "7. SUPPORT MINORITY COMMUNITIES: Stand in solidarity with minority communities on and off-campus. Attend their events, amplify their voices, and be an ally in the fight against racial discrimination.\n\n" +
                        "8. PROMOTE INCLUSIVE CURRICULUM: Advocate for a more diverse and inclusive curriculum that reflects a variety of perspectives and experiences. Work with faculty and administrators to integrate these changes.\n\n" +
                        "9. VOTE AND MOBILIZE: Encourage voter registration and participation among your peers. Mobilize students to support political candidates and policies that prioritize racial equality.\n\n" +
                        "10. CONTINUOUS SELF-REFLECTION: Regularly reflect on your own biases, privileges, and contributions to racial equality efforts. Stay committed to lifelong learning and improvement in this important cause.\n\n",

                "https://i.guim.co.uk/img/media/f76a3b0a63df5a9bd38da97f3e66b09e3a5b6ca9/0_3_6000_3602/master/6000.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=d70febd9b542e8b59de11529b64ece2f",
                "https://www.kaplanpathways.com/blog/why-is-racial-equality-important/"

            )
        )
        dataList.add(
            DataItem("GENDER EQUALITY ",
                "\"Unlocking the Power of Gender Equality: Empowering Youth Activism in Civic Engagement. Delve into the intricate tapestry of gender dynamics as we explore how youth worldwide are shaping the future of civic engagement, dissecting gender differences in activism, and redefining the path to equality.\"\n\n" +
                        "1. EDUCATE AND RAISE AWARENESS: Organize workshops, seminars, and awareness campaigns to educate young people about gender equality issues and their role in activism.\n\n" +
                        "2. FOSTER INCLUSIVE LEADERSHIP: Encourage and support young leaders of all genders to take on leadership roles in civic and community initiatives.\n\n" +
                        "3. AMPLIFY DIVERSE VOICES: Create platforms for marginalized and underrepresented voices, allowing them to share their experiences and perspectives.\n\n" +
                        "4. PROMOTE INTERSECTIONALITY: Emphasize the intersectionality of gender with other identities (e.g., race, ethnicity, sexuality) to address the unique challenges faced by individuals.\n\n" +
                        "5. ONLINE ACTIVISM: Harness the power of digital platforms for activism, ensuring that online spaces are inclusive, safe, and accessible to all.\n\n" +
                        "6. ADVOCATE FOR POLICY CHANGE: Mobilize youth to advocate for policies that promote gender equality, both at the local and national levels.\n\n" +
                        "7. MENTORSHIP PROGRAMS: Establish mentorship programs that connect experienced activists with young individuals, providing guidance and support.\n\n" +
                        "8. COMMUNITY ENGAGEMENT: Encourage youth to actively engage with their local communities, addressing gender-based issues and collaborating on solutions.\n\n" +
                        "9. DATA-DRIVEN INITIATIVES: Collect and analyze data on gender disparities and activism impact to guide evidence-based strategies.\n\n" +
                        "10. CELEBRATE ACHIEVEMENTS: Recognize and celebrate the achievements of youth activists working towards gender equality, inspiring others to join the cause.\n\n",

                "https://knowlaw.in/wp-content/uploads/2021/06/Gender-Equality01.jpg",
                "https://spb.psychopen.eu/index.php/spb/article/view/3887/3887.html")
        )
            dataList.add(
                DataItem("PROMOTING INDIGENOUS RIGHTS AND CULTURAL INCLUSIVITY ON CAMPUS",
                    "In the Philippines, a cultural revolution is unfolding within the education system. The Department of Education is leading the charge, empowering Indigenous Peoples through culture-based learning, fostering inclusivity, and igniting a renewed sense of heritage on campuses.\n\n" +
                            "1. ASSESS CAMPUS NEEDS: Begin by conducting a thorough assessment of your campus to identify the specific needs and challenges related to indigenous rights and cultural inclusivity.\n\n" +
                    "2. ENGAGE WITH INDIGENOUS COMMUNITIES: Establish sustained dialogue and collaboration with Indigenous Peoples (IP) communities in your region. This could involve meetings with IP elders, leaders, culture bearers, and community representatives to understand their perspectives and aspirations.\n\n" +
                    "3. CURRICULUM CONTEXTUALIZATION: Work on adapting the existing curriculum to be more culture-sensitive and inclusive. Develop indigenized lesson plans that reflect the cultural heritage and knowledge of IP communities.\n\n" +
                    "4. CAPACITY BUILDING: Organize training and retooling sessions for teachers, school heads, and other personnel involved in IP education. Ensure they have the necessary skills to engage effectively with IP communities and implement the contextualized curriculum.\n\n" +
                    "5. CULTURAL WORKSHOPS: Conduct consultative and curriculum development workshops with key IP elders, leaders, and culture bearers. This will help in gathering insights and validating the content of the curriculum.\n\n" +
                    "6. QUALITY ASSURANCE: Ensure that all learning materials and content are duly validated by concerned IP communities and have undergone quality assurance processes.\n\n" +
                    "7. ALLOCATE RESOURCES: Establish a budget for supporting these initiatives. Allocate resources for curriculum development, training, and workshops.\n\n" +
                    "8. REGIONAL SUPPORT: Implement a system of providing support to regional and school division offices through an Indigenous Peoples Education Program Support Fund (PSF). This fund should be used for activities that align with the goals of IP education.\n\n" +
                    "9. COMMUNITY ENGAGEMENT: Organize sessions on community engagement and partnership-building for IP education. Encourage collaboration between schools and local IP communities.\n\n" +
                    "10. MONITORING AND EVALUATION: Continuously monitor the progress of your initiatives. Collect feedback from IP communities, students, and educators to assess the impact of your efforts. Adjust your programs and strategies as needed to ensure they remain effective.\n\n",


                "https://assets.change.org/photos/8/ly/tf/QalYTfPtyjcysqs-1600x900-noPad.jpg?1521994361",
                    "https://www.deped.gov.ph/2017/01/31/deped-sustains-support-for-culture-based-education-for-ip-learners/",)
        )

        dataList.add(
                DataItem("RESHAPING EDUCATION IN THE CITY",
                "Unlock the Power of Education: Bridging the Divide Against Inequality. Join us on a journey to explore how education can be a powerful force in dismantling deep-seated inequalities, equipping students with the tools to challenge injustice and pave the way for a more equitable society.\n\n" +



                        "1. EDUCATIONAL CHALLENGES IN METRO MANILA: Overcrowded classrooms, low teacher salaries, and inadequate facilities pose significant challenges to education in Metro Manila.\n\n" +
                        "2. IMPACT OF COVID-19: The pandemic exacerbated educational issues, leading to a shift to online learning and leaving many students out of school.\n\n" +
                        "3. LEARNING POVERTY: A World Bank study revealed that a large proportion of Filipino children suffer from 'learning poverty,' emphasizing the need for educational improvements.\n\n" +
                        "4. COLLABORATION AND GOVERNANCE: Collaboration among different cities and good governance are essential to address educational challenges and share best practices.\n\n" +
                        "5. INNOVATIONS IN REMOTE LEARNING: Initiatives like free Wi-Fi and providing gadgets for students have been adopted to facilitate remote learning during the pandemic.\n\n" +
                        "6. SUPPORT FROM LOCAL GOVERNMENTS: Local government units partnered with private companies to enhance resources for remote learning.\n\n" +
                        "7. QUALITY EDUCATION FOR URBAN POOR COMMUNITIES: Improving access to quality education for urban poor communities is a priority, including reducing overcrowding and enhancing resources.\n\n" +
                        "8. GOVERNMENT INITIATIVES: Programs like the Universal Access to Quality Tertiary Education Act (UAQTEA) have been implemented to provide free tuition and additional support at universities and colleges.\n\n" +
                        "9. PARTNERSHIPS AND COLLABORATION: Collaboration between public and private institutions, sharing resources like textbooks and facilities, promotes equal access to quality education.\n\n" +
                        "10. HOLISTIC APPROACH: A holistic approach, considering social and economic factors, is crucial to reduce income inequality, promote inclusion, and drive sustainable development for a better quality of life in Metro Manila.",

                    "https://btf.rappler.com/tachyon/sites/9/2023/01/327035535_566891875334320_3462293533200080570_n-1.jpg?resize=1080%2C810&zoom=1",
                "https://btf.rappler.com/161/scattered-flickers-of-light-the-education-outlook-of-the-megacity-of-metro-manila"
             )
        )

        dataList.add(
            DataItem("INCLUSIVE CAMPUS INITIATIVES",
                "Unlocking Equal Opportunities: Pioneering INCLUSIVE CAMPUS INITIATIVES for Civic Engagement. Join us on a journey to explore how our campuses are becoming bastions of inclusivity, where every student's voice is heard, every talent is nurtured, and every individual is empowered to engage actively in shaping a more equitable society.\n\n" +

                        "1. DIVERSITY AND INCLUSION TRAINING: Implement mandatory diversity and inclusion training programs for all students, faculty, and staff to foster a more inclusive campus culture.\n\n" +
                        "2. ACCESSIBLE FACILITIES: Ensure that all campus facilities are wheelchair accessible and equipped with necessary accommodations for students with disabilities.\n\n" +
                        "3. INCLUSIVE CURRICULUM: Review and update the curriculum to include diverse perspectives, voices, and experiences, reflecting the richness of the student body.\n\n" +
                        "4. STUDENT-LED INCLUSIVITY CLUBS: Support the formation of student-led clubs and organizations focused on promoting inclusivity, diversity, and social justice on campus.\n\n" +
                        "5. MENTORSHIP PROGRAMS: Establish mentorship programs that pair incoming students with experienced peers, fostering a sense of belonging and support.\n\n" +
                        "6. ACCESSIBLE RESOURCES: Provide accessible learning materials and resources, such as captioned videos, screen readers, and alternative formats for students with disabilities.\n\n" +
                        "7. CULTURAL COMPETENCY TRAINING: Offer workshops and training sessions on cultural competency and sensitivity for faculty and staff to create a more welcoming environment.\n\n" +
                        "8. INCLUSIVE EVENTS: Organize campus events and activities that celebrate different cultures, identities, and backgrounds, promoting cross-cultural understanding.\n\n" +
                        "9. BIAS REPORTING SYSTEM: Implement a confidential reporting system for incidents of bias, discrimination, or harassment and take proactive measures to address such issues.\n\n" +
                        "10. COLLABORATIVE DIALOGUE: Encourage open and respectful dialogue among students, faculty, and staff, fostering a campus culture where diverse viewpoints are valued and heard.\n\n",

                "https://www.teacherph.com/wp-content/uploads/2022/08/Inclusive-Education-in-the-Philippines.png",
                "https://www.teacherph.com/inclusive-education-philippines/#:~:text=Making%20Inclusive%20Education%20a%20Reality%20in%20the%20Philippines,-The%20Philippines%20is&text=This%20includes%20having%20ramps%20and,deaf%20or%20hard%20of%20hearing.",)
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

}