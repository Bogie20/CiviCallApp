package com.example.civicall.CivicRightsAndResponsibility

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class CivicResponsibilityandEducationinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civic_responsibilityand_educationinfo)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "CIVIC EDUCATION PROGRAMS IN THE PHILIPPINES",
                "Enhancing Civic Education in the Philippines: Bridging Gaps and Nurturing Future Leaders. Discover the critical need for improving civic education in the Philippines and the strategies to empower the youth for a more resilient future.\n\n" +
                        "1. CIVIC EDUCATION SHORTCOMINGS\n" +
                        "   - Recognizing the deficiencies in the existing civic education curriculum is the first step toward improvement.\n" +
                        "2. YOUTHLED PROJECT'S ASSESSMENT\n" +
                        "   - The YouthLed project, funded by The Asia Foundation and USAID, assessed civic education programs in Philippine private schools and NGO-driven nonformal education.\n" +
                        "3. CONTENT AND DELIVERY GAPS\n" +
                        "   - Gaps were identified both in the content and delivery methods of civic education programs, emphasizing the need for comprehensive reforms.\n" +
                        "4. MODIFIED CONTENT AREAS\n" +
                        "   - The junior high school curriculum introduced modified content areas, including civic engagement models, human rights, and connections to Sustainable Development Goals.\n" +
                        "5. DIVERSE TEACHING APPROACHES\n" +
                        "   - Various teaching approaches, such as case studies, practical research, and role-playing, were observed in curricular modules.\n" +
                        "6. INADEQUATE SENIOR HIGH SCHOOL COVERAGE\n" +
                        "   - Senior high school students receive limited civic education, and further integration is needed into all senior high school strands.\n" +
                        "7. LAST EXPOSURE TO CIVIC EDUCATION\n" +
                        "   - SHS students not pursuing Humanities and Social Sciences strands may have their last exposure to civic education, making it vital to expand the coverage.\n" +
                        "8. DISCREPANCIES IN MODULE CONTENTS\n" +
                        "   - Differences in module contents that deviate from civic education were noticed, necessitating standardized materials.\n" +
                        "9. TEACHER STRUGGLES\n" +
                        "   - Teachers encountered challenges in preparing materials and curriculum development, highlighting the importance of support and training.\n" +
                        "10. PARTNERSHIPS FOR IMPROVEMENT\n" +
                        "    - Building strong partnerships between schools and NGOs can help bridge the civic education gaps and enhance the delivery of programs.\n",

                 "https://kabayanremit-8120.kxcdn.com/blog/wp-content/uploads/2021/04/A-guide-to-the-education-system-in-the-Philippines.jpg",
                "https://www.pids.gov.ph/details/news/press-releases/civic-education-in-the-philippines-must-be-improved-dlsu-professor"

            )
        )
        dataList.add(
            DataItem("EDUCATIONAL INSTITUTIONS FOSTERING CIVIC ENGAGEMENT",
                "\"Empowering Learners for Active Citizenship: The Role of Civic Education in Philippine Schools. Explore the pivotal role of civic education in shaping responsible citizens and fostering civic engagement within educational institutions as advocated by the Philippine Business for Education (PBEd).\n\n" +
                        "1. CIVIC EDUCATION FOR CRITICAL THINKING:\n" +
                        "   - An advocacy group emphasizes the integration of civic education into all subjects to promote critical thinking, civic engagement, and social responsibility among Filipino learners.\n" +
                        "2. SIBIKA.PH PROMOTES CIVIC EDUCATION:\n" +
                        "   - The Philippine Business for Education (PBEd) utilizes the online platform Sibika.ph to provide teachers with free and accessible resources for teaching civic education.\n" +
                        "3. HOLISTIC APPROACH TO EDUCATION:\n" +
                        "   - Civic education is seen as a means to prepare students not only for employment but also to develop their character and sense of civic responsibility.\n" +
                        "4. EDUCATIONAL RESOURCES:\n" +
                        "   - Sibika.ph offers Department of Education (DepEd)-certified modules, educational videos, and curated materials on civic education.\n" +
                        "5. YOUTHLED CIVIC EDUCATION SUMMIT:\n" +
                        "   - The Youth Leadership for Democracy (YouthLed PH) Civic Education Summit 2023, organized by The Asia Foundation and the United States Agency for International Development, focuses on developing civic knowledge and skills among teachers and youth.\n" +
                        "6. PEDAGOGICAL INNOVATIONS:\n" +
                        "   - Special sessions during the summit explore innovative teaching methods to deliver civic education effectively.\n" +
                        "7. COLLABORATIVE TEACHING:\n" +
                        "   - Teachers use methods like small group discussions, immersion programs, and metaphors to instill social responsibility and integrity in students while addressing community issues.\n" +
                        "8. CIVIC EDUCATION AS ESSENTIAL:\n" +
                        "   - The panel discussion highlights the significance of civic education in teaching students about their rights and responsibilities.\n" +
                        "9. INTEGRATION INTO ALL SUBJECTS:\n" +
                        "   - Civic education is recognized as an integral part of every student's education and is encouraged to be integrated into all subjects and grade levels.\n" +
                        "10. YOUTH FOR NATION-BUILDING:\n" +
                        "   - Civic education plays a critical role in shaping the youth into responsible citizens who contribute to nation-building, aligning with ongoing curriculum reviews and educational commissions.\n",
                "https://mb.com.ph/media/Photo_2_eb09f3979a/Photo_2_eb09f3979a.jpg",
                "https://mb.com.ph/2023/5/3/advocacy-group-highlights-importance-of-integrating-civic-education-in-all-subjects"
            )
        )
        dataList.add(
            DataItem("EDUCATING FOR CIVIC ENGAGEMENT IN SOCIAL RESPONSIBILITY",
                "Discover the Bayanihan Spirit: Nurturing Civic Engagement and Social Responsibility. Explore the essence of Bayanihan, turning ordinary individuals into heroes, and how this cultural tradition exemplifies civic engagement and social responsibility in the Philippines.\"\n\n" +

                        "1. BAYANIHAN: A CULTURAL HEROISM\n" +
                        "   - Bayanihan is a Filipino tradition where communities unite to help those in need, exemplifying civic engagement and social responsibility.\n" +
                        "2. TULUNGAN AND DAMAYAN\n" +
                        "   - Other Filipino words for Bayanihan, emphasizing the culture of helping others without expecting anything in return.\n" +
                        "3. SHARED FILIPINO VALUES\n" +
                        "   - Bayanihan is inspired by values such as malasakit, pagdadamayan, pakikipagkapwa-tao, and kusang-palo, all promoting empathy and unity.\n" +
                        "4. COMMUNITY AID IN TIMES OF CRISIS\n" +
                        "   - Filipinos come together during calamities, providing assistance even to strangers.\n" +
                        "5. A HERO DEFINED\n" +
                        "   - In the Filipino context, a hero is someone who loves their people, with 'pakikipagkapwa-tao' meaning considering others as another self.\n" +
                        "6. RESILIENCE THROUGH UNITY\n" +
                        "   - Despite facing typhoons, volcanic eruptions, and earthquakes, Filipinos remain resilient and maintain a positive spirit, knowing they can rely on each other.\n" +
                        "7. THE LIPAT-BAHAY TRADITION\n" +
                        "   - Bayanihan is often demonstrated when a community helps relocate a family, a symbolic act of shared responsibility.\n" +
                        "8. BAYANIHAN'S LINGUISTIC ROOTS\n" +
                        "   - The term comes from 'bayan' (community) and 'bayani' (hero), representing heroism for the community.\n" +
                        "9. BAYANIHAN SPIRIT DURING COVID-19\n" +
                        "   - The COVID-19 pandemic saw Filipinos coming together to help those in need, showcasing the enduring spirit of bayanihan.\n" +
                        "10. BAYANIHAN TODAY\n" +
                        "    - This cultural tradition continues with initiatives like 'Angat Buhay' and individuals like Angel Locsin practicing and inspiring bayanihan for social good.\n",

                "https://cambridge.com.ph/wp-content/uploads/2017/04/ccdc-hq-teachers-training-2017_image02.jpg",
                "https://jefmenguin.com/bayanihan/"
             )
        )

        dataList.add(
            DataItem("DEVELOPING CIVIC COMPETENCIES IN SCHOOLS",
                "Unlocking Civic Potential: The Philippines' K to 12 Program\" revolutionizes education by fostering civic competencies in students through its comprehensive framework, from early childhood development to specialized high school tracks, creating socially responsible and engaged citizens. \"\n" +
                        "1. Civic Competence from Early Years (Universal Kindergarten): The K to 12 Program initiates civic engagement by offering universal kindergarten to children aged five, gradually introducing them to formal education.\n" +
                        "2. Relevant Curriculum for Lifelong Civic Learning (Contextualization and Enhancement): The curriculum is designed to incorporate local culture, making it more accessible and relatable, while including subjects like Disaster Risk Reduction (DRR) and Climate Change Adaptation.\n" +
                        "3. Language as a Tool for Civic Mastery (Mother Tongue-Based Multilingual Education): Students learn in their mother tongue and later, English and Filipino, fostering multilingualism for effective communication.\n" +
                        "4. Spiral Progression for In-Depth Civic Knowledge (Spiral Progression): The curriculum employs a spiral progression method, ensuring students acquire comprehensive knowledge, including areas like science, mathematics, and humanities.\n" +
                        "5. Customized Tracks for Civic Choices (Senior High School): The Senior High School segment offers tracks for academic, technical-vocational-livelihood, sports, and arts, allowing students to tailor their education for specific careers and interests.\n" +
                        "6. Development of Critical Civic Skills (21st Century Skills): The program equips graduates with information, media, technology, and communication skills, making them prepared for future civic and professional roles.\n" +
                        "7. Comprehensive Learning Curriculum (K to 12 Curriculum): The curriculum provides a holistic learning experience that encourages mastery of knowledge and skills in preparation for higher education, employment, or entrepreneurship.\n" +
                        "8. Flexibility in Education (Private SHS Implementation): Private schools have the flexibility to offer Senior High School ahead of the official program rollout in 2016-2017.\n" +
                        "9. Government Support and Resources (Implementation and Transition Management): The government has constructed classrooms, hired teachers, and provided necessary resources to ensure a smooth transition and full implementation of the program.\n" +
                        "10. Long-Term Civic Benefits (Nurturing the Holistically Developed Filipino): K to 12 graduates are equipped with essential civic skills, helping them succeed in higher education, employment, and entrepreneurship, ultimately contributing to the betterment of the Philippines.",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/cte-2.jpg",
                "https://www.officialgazette.gov.ph/k-12/"
              )
        )

        dataList.add(
            DataItem("CHALLENGES AND OPPORTUNITIES IN CIVIC EDUCATION",
                "As the Philippines gears up for the 2022 elections, the importance of civic education is paramount. This article explores the challenges and opportunities in civic education, emphasizing the need for deeper civic competencies among citizens in a changing world.\n\n\n" +
                        "1. IMPORTANCE OF VOTER EDUCATION PROGRAMS: Civic groups prepare for the 2022 elections with campaigns focused on encouraging voter registration and implementing voter education programs.\n\n" +
                        "2. DEEPER CIVIC COMPETENCIES NEEDED: While basic voter education is crucial, it falls short in developing the deeper civic competencies required for active and responsible citizenship.\n\n" +
                        "3. CIVIC ENGAGEMENT FOR INCLUSIVE SOCIETIES: Civic attitudes and behavior play a vital role in maintaining socially inclusive and secure democratic societies.\n\n" +
                        "4. YOUTH CIVIC ENGAGEMENT CHALLENGES: A 2016 Civic Education study involving 94,000 students across 24 countries examined the challenges of educating youth in the context of evolving democracy and civic participation.\n\n" +
                        "5. PROMOTING DEMOCRATIC VALUES: European countries emphasized the importance of promoting democratic values, fundamental rights, social inclusion, non-discrimination, and active citizenship among young people.\n\n" +
                        "6. IMPACT OF CIVIC EDUCATION: The study found a strong link between civic education and increased interest and participation in democratic activities.\n\n" +
                        "7. CIVIC EDUCATION IN THE PHILIPPINES: The K-to-12 Senior High School (SHS) curriculum in the Philippines includes a core subject, 'Understanding Culture, Society, and Politics,' which explores civic education.\n\n" +
                        "8. SCOPE OF CIVIC EDUCATION TOPICS: Among the 31 topics in the core subject, only one discusses active citizen participation, while others cover various aspects of culture, society, and politics.\n\n" +
                        "9. ENHANCING CIVIC LEARNING: Initiatives like 'Boto Mo Bukas Ko,' 'Sibika.ph,' and community immersion programs aim to enhance civic education and participation among students.\n\n" +
                        "10. LONG-TERM VISION FOR CIVIC EDUCATION: The article emphasizes the need to integrate civic education, values, and democratic attitudes into the core education system to prepare future generations for responsible citizenship and leadership.",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/cics-pic.jpg",
                "https://news.abs-cbn.com/focus/05/08/15/philippine-education-reform-program-faces-challenges"
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


        // Set the adapter for the RecyclerView
        recyclerView.adapter = adapter

    }
}