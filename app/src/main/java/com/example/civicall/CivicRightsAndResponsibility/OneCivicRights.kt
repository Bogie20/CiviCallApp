package com.example.civicall.CivicRightsAndResponsibility

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityOneCivicRightsBinding

class OneCivicRights : AppCompatActivity() {
    private lateinit var binding:ActivityOneCivicRightsBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityOneCivicRightsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dataList = ArrayList<DataItem>()
        dataList.add(
            DataItem(
                "THE LEGAL FRAMEWORK OF ELECTIONS",
                "Unlocking the Essence of Democratic Participation: Dive into the intricate web of election laws and regulations that shape the heartbeat of any democracy. In this exploration, we uncover the pivotal role citizens play as they exercise their voting rights and uphold the very foundations of a thriving democracy.\"\"\n\n" +
                        "1. NURTURING INFORMED CITIZENSHIP: By examining the legal framework of elections, students gain the knowledge required to be actively engaged and informed citizens in a democratic society.\n\n" +
                        "2. EMPOWERING CIVIC RESPONSIBILITY: This study instills in students a sense of civic duty, emphasizing the importance of voting as a fundamental act of participation in democracy.\n\n" +
                        "3. DEFENDING DEMOCRACY'S PILLARS: Students learn how election laws and regulations safeguard democratic principles, ensuring that each vote counts and each voice is heard.\n\n" +
                        "4. PROMOTING ACCOUNTABILITY: Exploring the legal aspects of elections underscores the importance of transparency, accountability, and integrity in the electoral process.\n\n" +
                        "5. INSPIRING FUTURE LEADERS: Students are encouraged to consider public service as a meaningful way to contribute to their communities and nation, fostering the next generation of leaders.\n\n" +
                        "6. ENHANCING CRITICAL THINKING: By understanding the legal intricacies of voting and elections, students develop critical thinking skills necessary to evaluate political processes and make informed decisions.\n\n" +
                        "7. VALUING EQUAL PARTICIPATION: This study highlights the significance of equal opportunity for public service and elections, promoting a more inclusive and representative democracy.\n\n" +
                        "8. BALANCING CHECKS AND BALANCES: Students explore the checks and balances within the legal framework that ensure fairness and impartiality, reinforcing democracy's core values.\n\n" +
                        "9. LEGAL REFORM FOR PROGRESS: This study presents the potential for legal reforms to catalyze significant positive changes in electoral systems and integrity, as demonstrated in various democracies.\n\n" +
                        "10. PRESERVING DEMOCRACY'S ESSENCE: Ultimately, this exploration reinforces the crucial role citizens play in preserving the essence of democracy, where voting is not just a right but a civic responsibility that shapes the future.\n\n",

                "https://pia.gov.ph/uploads/2021/07/22861e35df4176a09ca6c4c986cdaf62-800-1200.jpg",
                "https://aceproject.org/main/english/ei/eic.htm"

            )
        )
        dataList.add(
            DataItem("ACTIVE PARTICIPATION IN CIVIC DISCOURSE",
                "\"In the storm-battered Philippines, community engagement becomes the beacon of resilience and change. Uncover the power of active participation in civic discourse in confronting climate challenges and disasters.\n\n" +
                        "1. REAL-WORLD RELEVANCE: This study provides a real-world example of civic engagement in the face of climate change and disasters, illustrating its practical importance.\n" +
                        "2. CLIMATE CHANGE AWARENESS: Students can gain a deeper understanding of the link between climate change and disaster risk management, becoming more aware of this pressing global issue.\n" +
                        "3. DISASTER RESILIENCE: The study highlights the critical role that community engagement plays in building disaster resilience, a topic of increasing importance in today's world.\n" +
                        "4. LOCAL AND GLOBAL CONTEXT: Students can learn how the issues discussed in this study apply not only to the Philippines but also to similar problems in their own local and global contexts.\n" +
                        "5. POLICY IMPLICATIONS: Understanding how policy, both strong and weak, can affect community engagement can help students appreciate the broader implications of civic discourse.\n" +
                        "6. ENVIRONMENTAL SUSTAINABILITY: The study emphasizes the need for sustainable practices to protect the environment. Students can apply these principles in their daily lives.\n" +
                        "7. CULTURAL RELEVANCE: The mention of incorporating Filipino cultural practices like bayanihan showcases the significance of cultural context in civic discourse, which is valuable for students.\n" +
                        "8. LEADERSHIP AND GOVERNANCE: The importance of effective leadership and good governance in driving community engagement is a lesson that can be applied to various fields and situations.\n" +
                        "9. INTERDISCIPLINARY LEARNING: Students from various disciplines can find value in this study, as it touches on environmental science, social science, governance, and community development.\n" +
                        "10. CRITICAL THINKING: This study encourages critical thinking by presenting challenges and recommendations, inspiring students to think about solutions to real-world problems.\n" ,

                "https://i0.wp.com/www.skills.com.ph/wp-content/uploads/2019/07/Skills_Be_a_Community_Engagement_Partner.jpg?fit=951%2C637&ssl=1",
                "https://knowledge.aidr.org.au/resources/ajem-jan-2019-resilience-in-the-philippines-through-effective-community-engagement/"
            )
        )
        dataList.add(
            DataItem("THE SIGNIFICANCE OF CIVIC ENGAGEMENT",
                "Unlock the power of civic engagement and discover its profound impact on democracy, communities, and equity. Dive into the significance of active participation in shaping a just and equitable society.\"\n\n" +
                        "1. CULTIVATING CIVIC RESPONSIBILITY: This study emphasizes the importance of civic engagement in empowering young people to take an active role in shaping their communities and nation.\n\n" +
                        "2. BUILDING LIFELONG CIVIC HABITS: Like any habit, early engagement in civic activities forms a lifelong commitment to active participation, fostering a stronger democracy.\n\n" +
                        "3. REPRESENTATIVE DEMOCRACY: Youth involvement brings diverse perspectives to important issues, ensuring that decision-making is more representative and truly serves all citizens.\n\n" +
                        "4. INNOVATIVE IDEAS: Young people often bring fresh ideas to the table, invigorating civic discussions and driving progress in areas such as education, healthcare, and the environment.\n\n" +
                        "5. ENERGY FOR CHANGE: Youth participation infuses civic initiatives with boundless energy and passion for social change, which is essential for addressing pressing societal issues.\n\n" +
                        "6. STAKE IN NATIONAL DECISIONS: With youth disproportionately affected by issues like education, healthcare, and foreign policy, their active involvement is crucial for shaping their own future.\n\n" +
                        "7. COMMUNITY EMPOWERMENT: Youth are integral to local communities, and their participation strengthens community resilience and social cohesion.\n\n" +
                        "8. ACADEMIC AND PERSONAL GROWTH: Engaging in civic activities enhances academic performance and fosters social-emotional well-being, providing students with valuable skills and networks.\n\n" +
                        "9. ECONOMIC MOBILITY: Civic engagement equips young people with skills and networks that are highly valued in the workplace, offering a pathway to economic mobility.\n\n" +
                        "10. PROMOTING EQUITY: By focusing on youth civic engagement, this study contributes to the vital work of promoting a more just and equitable society by addressing opportunity gaps and inequities.\n\n",

                "https://3blaws.s3.amazonaws.com/styles/carousel_2x/s3/images/Children_International_Youth.jpg",
                "https://circle.tufts.edu/understanding-youth-civic-engagement/why-it-important"
        )
        )

        dataList.add(
            DataItem("CIVIC RESPONSIBILITY AND SOCIAL CHANGE",
                "Civic Responsibility and Social Change\" explores the vital role of civic duties in driving positive transformations within society. Justice Antonio T. Carpio highlights the importance of seeking the truth, participating in governance, and opposing corruption, providing a compelling call to action.\"\n" +
                        "1. UNDERSTANDING CIVIC DUTY: This study emphasizes the importance of understanding one's civic duties, which are essential for creating positive social change.\n\n" +

                        "2. TRUTH AS THE FOUNDATION: Seeking and upholding the truth is a fundamental civic duty. It underpins good governance and public trust.\n\n" +

                        "3. PARTICIPATION IN GOVERNANCE: Active participation in governance, including voting, is a crucial civic duty that ensures honest and efficient leadership.\n\n" +

                        "4. THE POWER OF THE CITIZENRY: The study illustrates how ordinary citizens, when organized and motivated, can bring about significant change in their nation's leadership and policies.\n\n" +

                        "5. HOLDING LEADERS ACCOUNTABLE: Citizens have a duty to hold public officials accountable for their actions, preventing the abuse of public trust.\n\n" +

                        "6. RESPECT FOR DIVERSITY: Civic duty includes respecting the rights and perspectives of fellow citizens, fostering harmony in a diverse society.\n\n" +

                        "7. FAIRNESS AND TRUSTWORTHINESS: Citizens must act with fairness and integrity in both public and private roles, combating greed and corruption that erode trust.\n\n" +

                        "8. LEAVING A LEGACY: It is a civic duty to contribute to the long-term development of the nation, ensuring it progresses and prospers for future generations.\n\n" +

                        "9. ATENEO GRADUATES' UNIQUE ROLE: Ateneo graduates, with their exceptional education, have an added civic duty to question, analyze, and act on their convictions for the betterment of society.\n\n" +

                        "10. REJECTING DEAD IDEAS: This study encourages citizens to challenge outdated concepts and practices (Dead Ideas) that hinder progress and to embrace innovative solutions that can drive the nation forward.\n",

                "https://pagcor.ph/images/news/PAGCOR-reaches-out-to-Bicol-communities-hit-by-super-typhoon-Rolly-1.jpg",
                "https://news.abs-cbn.com/views-and-analysis/03/25/09/know-your-civic-duties-justice-antonio-t-carpio"
               )
        )

        dataList.add(
            DataItem("DIGITAL DEMOCRACY AND CIVIC INVOLVEMENT",
                "Unlocking the Power of Digital Democracy: Navigating the Impact of Social Media\" delves into the dynamic relationship between social media, democracy, and civic participation in the Philippines. Explore the opportunities and challenges of the digital age as we unravel the evolving role of technology in shaping civic involvement.\"\n\n\n" +
                        "1. DIGITAL DEMOCRACY UNVEILED: This study provides a comprehensive look at the evolving landscape of digital democracy, offering insights into how social media has become a pivotal platform for civic engagement.\n\n" +
                        "2. CONSTITUTIONAL RIGHTS IN THE DIGITAL AGE: It underscores the crucial importance of constitutional rights like free speech and press freedom in the digital realm, emphasizing their role in sustaining democracy.\n\n" +
                        "3. THE PHILIPPINE CONTEXT: Given the Philippines' remarkable social media usage and the approaching 2022 presidential election, this study is highly relevant for understanding the local implications of digital democracy.\n\n" +
                        "4. ROLE OF SOCIAL MEDIA: This study sheds light on how social media has enabled under-resourced citizens to engage in politics, presenting an opportunity for students to learn about grassroots political participation.\n\n" +
                        "5. BRIDGE TO POLITICAL SUCCESS: Students will gain valuable insights into whether a strong presence on social media translates into electoral success, as exemplified by case studies of popular online personalities.\n\n" +
                        "6. THE ECHO CHAMBER CHALLENGE: It discusses the phenomenon of echo chambers in social media and how it influences voter behavior, encouraging students to critically analyze the impact of online polarization.\n\n" +
                        "7. TOXICITY IN ONLINE DISCOURSE: The study highlights the toxic nature of online political discussions, an important consideration for students studying the implications of uncivil discourse on democracy.\n\n" +
                        "8. NEGATIVE CAMPAIGNING: This research touches upon the prevalence of negative campaigning on social media and the potential consequences for political discourse, prompting students to consider the role of disinformation in modern politics.\n\n" +
                        "9. REGULATING ONLINE POLITICAL ADVOCACIES: It raises the question of whether more stringent regulations are needed to curb disinformation on social media, challenging students to explore the balance between free speech and responsible discourse.\n\n" +
                        "10. CITIZEN ENGAGEMENT: This study ultimately emphasizes the potential of social media to enhance civic involvement and democratic growth, prompting students to consider the future of political engagement in the digital era.",

                "https://mb.com.ph/media/DSC_0554_9090e9a816/DSC_0554_9090e9a816.jpg",
                "https://blogs.griffith.edu.au/asiainsights/social-media-and-democracy-in-the-philippines/"
             )
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

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
}