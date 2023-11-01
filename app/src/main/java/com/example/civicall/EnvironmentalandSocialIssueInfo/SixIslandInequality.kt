package com.example.civicall.EnvironmentalandSocialIssueInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class SixIslandInequality : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_six_island_inequality)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "EDUCATIONAL DISPARITIES IN RURAL AND URBAN AREAS IN THE PHILIPPINES",
                "In the diverse landscape of the Philippines, educational disparities persist, creating a stark divide between rural and urban areas. This article explores the multifaceted challenges and inequalities faced by students, shedding light on the urgent need for inclusive and equitable education across the nation.\"\n\n" +
                        "1. HISTORICAL COLONIAL INFLUENCE ON EDUCATION: The Philippines' colonial history, particularly Spanish and American influence, has left lasting imprints on its education system.\n\n" +
                        "2. POST-INDEPENDENCE EDUCATION REFORMS: Since gaining independence in 1946, the government has aimed to make education accessible to all Filipinos, irrespective of their socioeconomic status.\n\n" +
                        "3. PERSISTENT ISSUE OF POVERTY: Poverty remains a pervasive issue, limiting access to education for many families, particularly in impoverished communities.\n\n" +
                        "4. GOVERNMENT INITIATIVES TO ADDRESS POVERTY: The government has launched programs like Pantawid Pamilyang Pilipino Program (4Ps) to provide financial assistance to poor families for education-related expenses.\n\n" +
                        "5. MULTI-DIMENSIONAL APPROACH TO POVERTY REDUCTION: Addressing poverty requires a multi-dimensional approach, including investment in education, healthcare, social services, job creation, and income growth.\n\n" +
                        "6. ALTERNATIVE LEARNING SYSTEM (ALS): The ALS provides non-formal education for out-of-school youth and adults, helping those affected by armed conflict and those who cannot access formal education.\n\n" +
                        "7. INTERNATIONAL AND GOVERNMENT PARTNERSHIPS: International organizations like UNICEF, the Global Partnership for Education (GPE), and the World Bank collaborate with the government to improve access to education, especially in conflict-affected areas.\n\n" +
                        "8. LACK OF RESOURCES AND INFRASTRUCTURE: Many schools, especially in rural areas, lack basic amenities like electricity and potable water, affecting the quality of education.\n\n" +
                        "9. GOVERNMENT INVESTMENT IN INFRASTRUCTURE: The government has initiated infrastructure projects and educational programs, like DepEd TV and DepEd Commons, to address resource and infrastructure challenges.\n\n" +
                        "10. THE DIGITAL DIVIDE AND THE IMPACT OF COVID-19: The COVID-19 pandemic has exposed the digital divide, with many students lacking access to technology for online learning, highlighting disparities in education.",

                "https://media.philstar.com/photos/2021/02/17/school2020-08-0221-59-54_2021-02-17_19-06-21.jpg",
                "https://pids.gov.ph/details/news/in-the-news/educational-challenges-in-the-philippines"

            )
        )
        dataList.add(
            DataItem(" CRISIS AREAS IMPACTING QUALITY EDUCATION IN THE PHILIPPINES",
                "Amidst the lush landscapes and rich culture of the Philippines, the pursuit of quality education faces daunting challenges. This report delves into the critical obstacles hindering educational excellence in the nation.\n\n" +
                        "1. LEARNING CRISIS PERSISTS: The Philippines faces a significant learning crisis, with statistics revealing that 9 out of 10 children aged 10 years old are unable to read simple texts.\n\n" +
                        "2. EQUITABLE ACCESS STRUGGLES: Despite constitutional mandates, equitable access to quality education remains elusive. Completion rates drop significantly as students progress through the education system.\n\n" +
                        "3. EROSION OF HIGHER EDUCATION ENROLLMENT: While enrollment rates in Philippine higher education were on par with middle-income countries, they have stagnated, contrasting with rising enrollment in neighboring nations.\n\n" +
                        "4. POOR PERFORMANCE IN INTERNATIONAL ASSESSMENTS: The Philippines ranks poorly in international assessments such as PISA, TIMSS, and SEA-PLM, indicating significant educational challenges.\n\n" +
                        "5. STUNTING RATES AND COGNITIVE DEVELOPMENT: The nation struggles to improve stunting rates, impacting cognitive development in early childhood.\n\n" +
                        "6. IMPACT OF COVID-19 PANDEMIC: The pandemic exacerbated existing challenges, leaving more learners behind and widening learning gaps across all levels of education.\n\n" +
                        "7. ACCESS ISSUES: School closures and transition to blended learning left over a million students unable to enroll, raising concerns about access.\n\n" +
                        "8. LEARNING CHALLENGES PERSIST: Despite efforts, a quarter of parents reported that their children are not learning adequately due to limited resources, poor learning environments, and insufficient teaching staff.\n\n" +
                        "9. WORKFORCE IMPACTS: Beyond the education sector, the pandemic led to a significant increase in unemployment rates, affecting the country's workforce.\n\n" +
                        "10. MASS PROMOTION AND LACK OF PROPER ASSESSMENT: The practice of mass promotion, driven by various factors, has contributed to poor student learning outcomes. Additionally, the lack of proper assessment hinders accurate measurement of student progress.\n",

                "https://files01.pna.gov.ph/ograph/2023/01/04/ybl8412.jpg",
                "https://www.pbed.ph/blogs/47/PBEd/State%20of%20Philippine%20Education%20Report%202023"
         )
        )
        dataList.add(
            DataItem("GOVERNMENT INITIATIVES TO IMPROVE ACCESS TO EDUCATION IN THE PHILIPPINES",
                "In response to the pressing need for education reform in the Philippines, the government is embarking on a transformative journey to improve access to quality education through a series of comprehensive initiatives.\"\n\n" +
                        "1. CHALLENGES IN INFRASTRUCTURE: The Philippines faces significant challenges in building and maintaining education infrastructure, with a shortage of good condition school buildings, impacting over 28 million learners.\n\n" +
                        "2. PROCUREMENT REFORMS: Efforts to improve procurement processes in the education sector are underway, aiming to enhance transparency and efficiency in the delivery of services.\n\n" +
                        "3. ENROLLMENT DISPARITIES: Public schools have seen an increase in enrollment, while private schools have faced a decline, resulting in over 1,600 private schools closing down.\n\n" +
                        "4. CURRICULUM REVIEW: The K-12 curriculum is under review to ensure relevance and practicality, with a focus on essential skills and competencies.\n\n" +
                        "5. TEACHING METHODS: The review revealed the need for improved teaching methods, particularly in critical thinking and problem-solving skills.\n\n" +
                        "6. LEARNING OUTCOMES: PISA results showed that a significant percentage of Filipino learners struggle with math, reading, and science, highlighting the need for improvement.\n\n" +
                        "7. SCHOOL FACILITIES AND SERVICES ACCELERATION: A new School Infrastructure and Facilities Strand has been created to address long-standing issues and ensure better facilities and services.\n\n" +
                        "8. INCLUSIVE EDUCATION: The government is committed to inclusive education and protecting learners from discrimination, including children with disabilities.\n\n" +
                        "9. SUPPORT FOR TEACHERS: Teachers are recognized as essential to education quality, with a focus on providing professional development, reducing administrative burdens, and increasing compensation.\n\n" +
                        "10. HOLISTIC EDUCATION AGENDA: The government's MATATAG Agenda outlines a comprehensive roadmap for improving access to quality education in the Philippines.",

                "https://files01.pna.gov.ph/ograph/2022/08/18/053a0223.jpg",
                "https://ovp.gov.ph/post/basic-education-report-2023-speech"
              )
        )

        dataList.add(
            DataItem("ROLE OF TECHNOLOGY IN EDUCATION IN THE PHILIPPINES",
                "In the Philippines, technology's transformative influence on education is a beacon of progress. With information and communications technology (ICT), the country is forging a brighter future for its learners, bridging gaps, and redefining the role of technology in education.\"\n\n" +

                        "1. NATIONAL ICT MONTH CELEBRATES TECH'S IMPACT: National ICT Month in the Philippines honors the significant influence of technology on daily life.\n\n" +
                        "2. THEME FOR 2023: This year's theme, 'Connecting Communities, Enriching Lives, Forging a Digital Future for the Philippines,' emphasizes the role of ICT in narrowing the digital divide and building a more prosperous future.\n\n" +
                        "3. ICT'S PROFOUND IMPACT: ICT has positively affected the Philippines by enhancing access to education, healthcare, government services, boosting economic growth, and creating jobs.\n\n" +
                        "4. ECONOMIC CONTRIBUTION: The ICT sector contributed 7.5% to the country's GDP in 2022, highlighting its economic significance.\n\n" +
                        "5. EDUCATION TRANSFORMATION: ICT is revolutionizing education through online learning platforms, personalized learning, and improved assessment methods.\n\n" +
                        "6. ENHANCED HEALTHCARE ACCESS: Telemedicine and mobile health apps provide improved healthcare access, even in remote areas, while electronic health records streamline patient care.\n\n" +
                        "7. EFFICIENT GOVERNANCE: ICT is making government more efficient and accessible with online government services that enhance transparency and accountability.\n\n" +
                        "8. BUSINESS GROWTH: ICT is driving economic growth in the Philippines by improving business operations, expanding market reach, and fostering innovation.\n\n" +
                        "9. FUTURE ROLE OF ICT: The article emphasizes that ICT will continue to be vital in the Philippines, requiring investments in infrastructure and human capital.\n\n" +
                        "10. CONNECTING COMMUNITIES AND ENRICHING LIVES: ICT connects communities through online platforms and enriches lives by offering educational opportunities and entertainment, ultimately forging a digital future for the Philippines.",

                "https://mb.com.ph/wp-content/uploads/2021/07/19810.jpeg",
                "https://pia.gov.ph/features/2023/06/07/national-ict-month-2023-celebrating-technologys-power-to-change-lives#:~:text=ICT%20is%20revolutionizing%20education%20in,and%20to%20assess%20student%20progress."
              )
        )

        dataList.add(
            DataItem("SOCIOECONOMIC FACTORS INFLUENCING EDUCATIONAL OPPORTUNITIES IN THE PHILIPPINES",
                "In the Philippines, the intersection of education and socioeconomic factors plays a pivotal role in shaping educational opportunities. This analysis delves into the intricate relationship between socioeconomics and education, uncovering the challenges and disparities that impact learning in the country.\n\n\n" +

                        "1. EDUCATION'S ECONOMIC SIGNIFICANCE: The article emphasizes how a nation's education and health status are essential indicators of its economic wealth and long-term growth potential.\n\n" +
                        "2. THE COMPONENTS OF COUNTRY WEALTH: It identifies the four elements contributing to a country's wealth, emphasizing human capital as the most significant factor and linking it to education and health.\n\n" +
                        "3. THE LEARNING POVERTY RATE: Highlighting a critical issue, it reveals that the Philippine Learning Poverty rate stands at a staggering 90.9%, signifying that more than nine out of ten Filipino children struggle with age-appropriate reading.\n\n" +
                        "4. COMPARING ASEAN-5 COUNTRIES: The article draws comparisons with other ASEAN-5 nations, showcasing how the Philippines' learning poverty rate is considerably higher than countries like Malaysia, Indonesia, Thailand, and Vietnam.\n\n" +
                        "5. EXAMINING EXPENDITURE: It discusses the impact of education expenditure, noting that while the Philippines spends less per child than other countries, this doesn't fully explain the learning poverty disparity.\n\n" +
                        "6. HUMAN CAPITAL INDEX (HCI): The HCI is introduced, indicating that a child born today in the Philippines would only have 52% of the expected productivity due to incomplete education and health, with comparisons to other ASEAN-5 countries.\n\n" +
                        "7. CHALLENGES IN INTERNATIONAL ASSESSMENTS: It highlights the Philippines' poor performance in international assessments like PISA and TIMSS, where it ranks the lowest among all countries assessed.\n\n" +
                        "8. TERTIARY LEVEL LICENSING: The article raises concerns about professional licensure examinations, reporting that only 42% of applicants passed in 2019, impacting the country's future workforce.\n\n" +
                        "9. DECLINE IN UNIVERSITY RANKINGS: The University of the Philippines' fall in world university rankings is noted, signaling challenges within the higher education system.\n\n" +
                        "10. HEALTH STATUS AND UNDERNUTRITION: It addresses health concerns, highlighting the Philippines' high infant and child mortality rates, lower life expectancy, and prevalence of stunting, all of which are influenced by socioeconomic factors.",

                "https://www.rappler.com/tachyon/2023/06/TL-What-they-dont-tell-Philippines-Education-Health-June-6-2023.jpg?resize=1280%2C720&zoom=1",
                "https://www.rappler.com/voices/analysis-what-they-do-not-tell-you-about-education-health-systems-problems-philippines/"
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