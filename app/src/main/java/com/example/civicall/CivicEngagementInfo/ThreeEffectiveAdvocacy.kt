package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.NetworkUtils
import com.example.civicall.R

class ThreeEffectiveAdvocacy: AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_effectiveadvocacy)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion
        dataList.add(
            DataItem(
                "PUBLIC SPEAKING AND CIVIC ENGAGEMENT",
                "Unlocking the Power of the Spoken Word: Public Speaking as the Catalyst for Civic Engagement. In a world where voices shape the future, discover how the art of public speaking fuels advocacy, empowers change, and drives civic participation like never before.\n\n\n" +
                        "1. IDENTIFY YOUR CAUSE: Begin by choosing a cause or issue that you are passionate about and want to advocate for through public speaking.\n\n" +
                        "2. RESEARCH AND KNOWLEDGE: Deepen your understanding of the chosen cause by conducting thorough research. Stay informed about relevant facts, statistics, and current events.\n\n" +
                        "3. CRAFT YOUR MESSAGE: Develop a clear and compelling message that conveys the importance of your cause and resonates with your target audience.\n\n" +
                        "4. KNOW YOUR AUDIENCE: Understand the perspectives, concerns, and values of your audience. Tailor your message to address their needs and interests.\n\n" +
                        "5. PRACTICE AND PREPARATION: Hone your public speaking skills through practice. Rehearse your speech multiple times to build confidence and ensure a smooth delivery.\n\n" +
                        "6. EFFECTIVE STORYTELLING: Use storytelling techniques to make your message relatable and memorable. Share personal anecdotes or real-life examples that illustrate the impact of your cause.\n\n" +
                        "7. ENGAGE AND PERSUADE: Employ persuasive speaking techniques, such as ethos, pathos, and logos, to engage your audience emotionally and logically.\n\n" +
                        "8. UTILIZE VISUAL AIDS: Enhance your message with visual aids, such as slides or props, to reinforce key points and make your presentation more impactful.\n\n" +
                        "9. HANDLE QUESTIONS AND OBJECTIONS: Be prepared to address questions, objections, or opposing viewpoints from the audience with poise and evidence-based responses.\n\n" +
                        "10. CALL TO ACTION: Conclude your speech with a compelling call to action, encouraging your audience to take concrete steps in support of your cause, whether it's signing a petition, volunteering, or spreading awareness.\n\n",

                "https://www.ohchr.org/sites/default/files/styles/hero_5_image_desktop/public/2022-10/oxfid_youth_challenge.jpg?itok=B8Qrzsaz",
                "https://courses.lumenlearning.com/wm-publicspeaking/chapter/speaking-as-civic-engagement/")
        )
        dataList.add(
            DataItem("STORYTELLING FOR CHANGE",
                "Unleashing the Power of Narratives: Harnessing Storytelling as a Catalyst for Civic Transformation. Explore the art of storytelling and its pivotal role in driving meaningful change, amplifying unheard voices, and fostering civic engagement\n\n" +
                        "1. IDENTIFY YOUR STORY'S PURPOSE: Begin by clarifying the purpose of your story, whether it's to raise awareness, inspire action, or shift perspectives within civic engagement.\n\n" +
                        "2. UNDERSTAND YOUR TARGET AUDIENCE: Analyze the interests, needs, and challenges of your audience to tailor your story to resonate with them effectively.\n\n" +
                        "3. CRAFT A COMPELLING NARRATIVE: Develop a well-structured story that introduces characters, context, and challenges, building tension and resolving it with a meaningful takeaway.\n\n" +
                        "4. EMBRACE DIVERSITY IN STORIES: Showcase a range of stories to highlight the diversity and complexity of experiences related to your civic engagement cause.\n\n" +
                        "5. LEVERAGE DIFFERENT STORYTELLING FORMATS: Choose the appropriate format for your story, whether it's through blogs, podcasts, videos, or social media, based on your audience and goals.\n\n" +
                        "6. UTILIZE DESCRIPTIVE LANGUAGE: Paint vivid pictures with words, using descriptive language to immerse your audience in the story.\n\n" +
                        "7. INCORPORATE QUOTES AND TESTIMONIALS: Enhance your story's credibility and emotional impact by including quotes and testimonials from those directly affected by the civic issue.\n\n" +
                        "8. ENCOURAGE ENGAGEMENT: Prompt your audience to engage with your story, whether it's by sharing, commenting, or taking specific actions related to your advocacy.\n\n" +
                        "9. MEASURE IMPACT: Utilize web analytics, surveys, and other data sources to measure the impact of your storytelling on awareness, engagement, attitude change, and learning.\n\n" +
                        "10. CONTINUOUS IMPROVEMENT: Continuously refine your storytelling skills by seeking feedback, experimenting with different approaches, and learning from both successes and challenges.\n\n",
                "https://atdph.org/wp-content/uploads/2018/03/20180120-SL-Norzagaray08-Crisal-1.jpg",
                "https://www.linkedin.com/advice/1/how-can-you-amplify-patient-voices-storytelling")
        )
        dataList.add(
            DataItem("ART AND CREATIVITY IN ADVOCACY",
                "Amplifying Change Through Art: Empowering Advocacy with Creativity. Explore the dynamic synergy of \"ART AND CREATIVITY IN ADVOCACY\" and unleash the potential of artistic expression to drive civic engagement and foster innovation.\n\n" +
                        "1. ART DISPLAY COLLABORATIONS: Partner with local venues, such as restaurants, coffee shops, or businesses, to display student artwork. Use these displays to showcase the impact of arts education and raise funds for your art program.\n\n" +
                        "2. ON-CAMPUS ART EXHIBITIONS: Host art shows within your school to highlight student work. Invite local media and the school district's communication department to promote the event, and include educational descriptions of the projects.\n\n" +
                        "3. DIGITAL OUTREACH: Utilize digital platforms, such as school newsletters, social media pages, and digital portfolios, to share students' art beyond the school walls. Educate the school community about the art being created and any material needs.\n\n" +
                        "4. ADVOCATE FOR LEGISLATIVE SUPPORT: Stay informed about legislative policies related to education, especially those impacting art education funding. Advocate for the allocation of funds, such as Title I and 21st Century Community Learning Center grants, to support art programs in need.\n\n" +
                        "5. ENGAGE WITH REPRESENTATIVES: Reach out to local and state officials to emphasize the importance of arts in schools. Use emails and phone calls to express your views and encourage peers to do the same, creating a collective voice for advocacy.\n\n" +
                        "6. ART IN A WELL-ROUNDED EDUCATION: Promote art and music as crucial components of a well-rounded education. Highlight their benefits in fostering cognitive development and artistic self-expression.\n\n" +
                        "7. EDUCATIONAL DISPLAYS: Enhance art displays with descriptions that include project standards, vocabulary, and techniques, educating viewers about the educational value of the artwork.\n\n" +
                        "8. LEVERAGE FUNDING OPPORTUNITIES: Explore funding opportunities available through legislative policies, such as the Every Student Succeeds Act and Student Support and Academic Enrichment Grants, and ensure they are utilized for art education.\n\n" +
                        "9. SUPPORT TITLE I SCHOOLS: Advocate for art education in Title I schools, emphasizing its significance for students in need of arts education opportunities.\n\n" +
                        "10. COMMUNITY PARTNERSHIPS: Seek partnerships with hospitals, coffee shops, local businesses, and more to display student artwork and generate funds for your art program, ensuring art's accessibility to all.\n\n",
                "https://theartofeducation.edu/wp-content/uploads/2017/11/IMG_3132-1024x754.jpg",
                "https://theartofeducation.edu/2017/11/4-effective-ways-can-advocate-arts/")
        )

        dataList.add(
            DataItem("MEDIA LITERACY FOR INFORMED CITIZENSHIP",
                "\"Navigating the Digital Age: Empowering Informed Citizens through Media Literacy. Explore the critical role of media literacy in equipping individuals with the skills to discern truth in a world filled with information, promoting informed citizenship.\"\n\n" +
                        "1. DIGITAL SKILLS WORKSHOPS: Organize workshops to teach practical digital skills, including fact-checking, source verification, and critical analysis of online content.\n\n" +
                        "2. CRITICAL THINKING CURRICULUM: Develop and implement a curriculum that encourages critical thinking, emphasizing the evaluation of information sources and media messages.\n\n" +
                        "3. SOURCE RELIABILITY ASSESSMENT: Educate individuals on how to assess the reliability of information sources, recognizing credible journalism from unreliable sources.\n\n" +
                        "4. MEDIA LITERACY RESOURCES: Provide access to media literacy resources, including online courses, articles, and videos, to help individuals stay informed about digital media literacy.\n\n" +
                        "5. FACT-CHECKING TOOLS: Promote the use of fact-checking tools and websites to verify the accuracy of news and information circulating online.\n\n" +
                        "6. ONLINE SAFETY EDUCATION: Include online safety and privacy topics in media literacy education, teaching individuals how to protect themselves in the digital space.\n\n" +
                        "7. CRITICAL MEDIA CONSUMPTION: Encourage mindful media consumption by emphasizing the importance of diverse perspectives and responsible sharing of information.\n\n" +
                        "8. DISCUSSION AND DEBATE: Foster open discussions and debates about media-related topics, allowing individuals to exchange ideas and viewpoints.\n\n" +
                        "9. CRITICAL ANALYSIS PROJECTS: Assign projects that require critical analysis of media content, encouraging individuals to deconstruct messages and identify potential biases.\n\n" +
                        "10. COMMUNITY ENGAGEMENT: Promote community engagement through media literacy initiatives, empowering individuals to share their knowledge and advocate for informed citizenship.\n\n",

                "https://blog.gale.com/wp-content/uploads/2023/09/iStock-1517463468.jpg",
                "https://edmo.eu/media-literacy/the-importance-of-media-literacy-in-fighting-disinformation/")
        )

        dataList.add(
            DataItem("EMPOWERING UNDERREPRESENTED VOICES",
                "\"Empowerment Grants: Unleashing Unheard Voices. Explore how Empowerment Grants pave the way for marginalized communities to rise, break barriers, and claim their space in society.\"\n\n" +

                        "1. Identify Community Needs: Begin by conducting a comprehensive assessment of the needs and challenges faced by marginalized and discriminated groups within your community.\n\n" +
                        "2. Form Collaborative Partnerships: Establish partnerships with registered/accredited organizations or grassroots organizations that can help facilitate access to Empowerment Grants.\n\n" +
                        "3. Target-Led Governance: Ensure that organizations seeking grants are governed and managed by members of the target groups themselves, following the principle of 'Nothing About Us Without Us.'\n\n" +
                        "4. Project Conceptualization: Collaborate closely with the target groups to conceptualize projects that address their specific needs and aspirations.\n\n" +
                        "5. Capacity Building: Prioritize the capacity development of small organizations and their members to effectively plan, implement, and monitor projects.\n\n" +
                        "6. Awareness and Education: Develop initiatives that raise awareness within families and communities, fostering a deeper understanding of the challenges faced by marginalized sectors.\n\n" +
                        "7. Promote Positive Images: Create campaigns and activities that promote positive images and narratives about marginalized communities, combating stereotypes and misconceptions.\n\n" +
                        "8. Enhance Political Participation: Strengthen the advocacy and influencing capacity of target groups, empowering them to engage in decision-making processes.\n\n" +
                        "9. Link and Learn: Actively participate in facilitated meetings and gatherings to share experiences and learnings with other grant recipients, documenting insights for broader dissemination.\n\n" +
                        "10. Embrace Diversity: Emphasize the value of diversity and inclusion within the community, ensuring that all voices are heard and respected.\n\n",
                "https://www.cipe.org/wp-content/uploads/2018/10/Philippines-Youth_Image-3.jpg",
                "https://voice.global/call-for-proposal/empowering-the-unheard-philippines-empowerment-grant-v-19105-ph-em/")
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