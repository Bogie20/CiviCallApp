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
import com.example.civicall.databinding.ActivityThreeEnvironmentalResponsibilityBinding

class ThreeEnvironmentalResponsibility : AppCompatActivity() {
    private lateinit var binding:ActivityThreeEnvironmentalResponsibilityBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityThreeEnvironmentalResponsibilityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }
        val dataList = ArrayList<DataItem>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        dataList.add(
            DataItem(
                "ENSURING THE RIGHT TO CLEAN WATER",
                "Water, a fundamental human right, is essential for life. In the Philippines, ensuring clean and accessible water is at the heart of environmental well-being.\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. AWARENESS OF HUMAN RIGHTS: This study highlights the importance of recognizing water as a fundamental human right, promoting awareness among students about the significance of access to clean water for human well-being.\n\n" +
                        "2. UNDERSTANDING GOVERNMENT OBLIGATIONS: Students will learn about the responsibilities of the Philippine government in providing safe and affordable water, fostering a better understanding of governance and public services.\n\n" +
                        "3. ENVIRONMENTAL ADVOCACY: The study encourages students to become advocates for clean water and environmental sustainability, recognizing the interplay between access to clean water and a healthy environment.\n\n" +
                        "4. SOCIAL JUSTICE: Students can explore the concept of social justice in the context of access to clean water, understanding how it impacts different segments of society.\n\n" +
                        "5. IMPACT OF PRIVATIZATION: By examining the effects of water privatization, students can assess the pros and cons of such arrangements, developing a critical perspective on public-private partnerships.\n\n" +
                        "6. GOVERNMENT ACCOUNTABILITY: The study underscores the importance of holding the government accountable when it comes to fulfilling its obligations in ensuring access to clean water, a valuable lesson in civic responsibility.\n\n" +
                        "7. HUMAN RIGHTS EDUCATION: It contributes to human rights education by incorporating the right to water into the discourse on civil and political rights, broadening students' awareness of diverse human rights issues.\n\n" +
                        "8. SUSTAINABLE DEVELOPMENT: Students can connect the study to the broader concept of sustainable development, emphasizing that access to clean water is a pivotal element in achieving sustainability.\n\n" +
                        "9. COMMUNITY INVOLVEMENT: Understanding the role of the public in decision-making processes related to water services, students can learn about the importance of community involvement in environmental issues.\n\n" +
                        "10. ADVOCACY AND POLICY INFLUENCE: This study empowers students to engage in advocacy for water rights and may inspire future policymakers to shape regulations that ensure access to clean water for all Filipinos.\n\n",

                "https://www.rappler.com/tachyon/r3-assets/B1F8D5430D78478F90EF00BEDDB3BE21/img/6D2324C049104709919382B1DBDC8473/water-human-right-may-12-2019.jpg?resize=640%2C360&zoom=1",
                "https://www.rappler.com/voices/thought-leaders/230328-water-human-right/"

            )
        )
        dataList.add(
            DataItem("RIGHTS OF INDIGENOUS COMMUNITIES AND ENVIRONMENTAL CONSERVATION IN THE PHILIPPINES",
                "In the heart of the Philippines, the rights of indigenous communities intersect with the imperative of environmental conservation. This story unveils the pivotal role played by these communities in safeguarding the country's unique biodiversity.\n\n" +
                        "1. CULTURAL AWARENESS: This study offers students a chance to delve into the rich cultural heritage of indigenous communities in the Philippines, fostering a deeper understanding of their traditions and values.\n" +
                        "2. ENVIRONMENTAL STEWARDSHIP: Students will gain insights into the importance of environmental conservation and how indigenous communities serve as custodians of critical biodiversity sites.\n" +
                        "3. LEGAL EDUCATION: The study provides an opportunity to learn about Indigenous Peoples' rights and the legal frameworks in place to protect their interests, contributing to a well-rounded legal education.\n" +
                        "4. SUSTAINABLE PRACTICES: Students can explore the sustainable resource management methods employed by indigenous communities, offering valuable lessons in sustainability.\n" +
                        "5. SOCIAL RESPONSIBILITY: Understanding the challenges faced by indigenous communities in protecting their ancestral lands encourages students to be socially responsible advocates for their rights.\n" +
                        "6. CULTURAL PRESERVATION: This study underscores the significance of preserving indigenous cultures and languages, promoting cultural diversity and heritage preservation.\n" +
                        "7. ENVIRONMENTAL EDUCATION: It serves as a platform for environmental education, focusing on the importance of biodiversity and ecosystem preservation.\n" +
                        "8. EMPOWERMENT: Learning about the successful advocacy and empowerment of indigenous communities can inspire students to actively engage in social and environmental causes.\n" +
                        "9. GLOBAL PERSPECTIVE: The study connects local issues with global conservation efforts, fostering a broader perspective on environmental conservation and Indigenous Peoples' rights.\n" +
                        "10. FUTURE LEADERSHIP: By studying the achievements and challenges of indigenous leaders, students are encouraged to become future leaders in environmental conservation and cultural preservation in the Philippines.\n",

                "https://www.thegef.org/sites/default/files/styles/main_image_content_width/public/undp_philippines_indigenous_peoples_news.jpg?h=e85f6c07&itok=Mo2o2YVL",
                "https://www.thegef.org/newsroom/feature-stories/indigenous-peoples-philippines-leading-conservation-efforts"
         )
        )
        dataList.add(
            DataItem("ENVIRONMENTAL JUSTICE AND CIVIC RESPONSIBILITY IN THE PHILIPPINES",
                "In the Philippines, environmental justice relies on the active engagement of civil society. This article explores the imperative of civic responsibility in addressing climate challenges and advancing sustainable development.\"\n\n" +
                        "1. CIVIC ENGAGEMENT: This study empowers students to actively engage in civic matters related to climate action and environmental justice, fostering a sense of responsibility towards their community and the planet.\n" +
                        "2. DEMOCRATIC PARTICIPATION: It underscores the role of civic responsibility as a cornerstone of democracy, encouraging students to participate in decision-making processes and advocate for environmental policies.\n" +
                        "3. TRANSPARENCY AND ACCOUNTABILITY: Students learn how civic engagement promotes government transparency and accountability in addressing climate challenges, ensuring responsible governance.\n" +
                        "4. ECOLOGICAL AWARENESS: It raises ecological awareness among students, helping them understand the importance of preserving the environment and its impact on the well-being of society.\n" +
                        "5. LEGAL LITERACY: It provides students with knowledge of environmental laws and regulations, enabling them to be informed citizens who can hold authorities accountable for environmental protection.\n" +
                        "6. COLLABORATIVE SOLUTIONS: Students explore the potential for collaborative efforts between civil society and the government in addressing environmental issues, emphasizing the importance of unity in achieving sustainability.\n" +
                        "7. ADVOCACY SKILLS: This study equips students with the skills necessary for effective environmental advocacy, including communication, networking, and grassroots mobilization.\n" +
                        "8. GLOBAL CITIZENSHIP: It promotes the idea of global citizenship by emphasizing that environmental issues transcend borders and require collective responsibility.\n" +
                        "9. SOCIAL RESPONSIBILITY: Students develop a sense of social responsibility towards vulnerable communities affected by environmental injustices and climate change, fostering empathy and solidarity.\n" +
                        "10. SUSTAINABLE FUTURE: Ultimately, this study inspires students to become champions of environmental justice and civic responsibility, contributing to a more sustainable and equitable future for the Philippines and the world.\n",

                "https://www.rappler.com/tachyon/2022/11/civil-society-climate-policymaking-november-18-2022.jpg?resize=1280%2C900&zoom=1",
                "https://www.rappler.com/voices/imho/opinion-philippine-government-must-involve-civil-society-more-climate-policymaking/"
              )
        )

        dataList.add(
            DataItem("ENVIRONMENTAL ACTIVISM AND CIVIC ENGAGEMENT IN THE PHILIPPINES",
                "In the heart of the Philippines, a silent battle rages on, led by environmental defenders who risk their lives to protect the nation's natural treasures. This story unveils their courageous efforts and explores the vital link between environmental activism and civic engagement.\"\n" +

                        "1. AWARENESS AND ACTION: This study cultivates awareness among students about the vital role of environmental defenders, inspiring them to take action in preserving their own natural surroundings.\n" +
                        "2. CIVIC ENGAGEMENT: Students learn the power of civic engagement as they delve into the stories of these brave individuals who make a difference in their communities.\n" +
                        "3. CONSERVATION VALUES: The study fosters a sense of responsibility for the environment, helping students value the conservation of nature.\n" +
                        "4. INSPIRATION FOR CHANGE: Environmental defenders' stories inspire students to become advocates for a more sustainable future, motivating them to initiate positive change.\n" +
                        "5. HUMAN RIGHTS DEFENSE: It highlights the importance of human rights in the context of environmental activism, encouraging students to defend both environmental and human rights.\n" +
                        "6. LOCAL COMMUNITY IMPACT: The study demonstrates the significant local impact of environmental activism, motivating students to engage in community-level change.\n" +
                        "7. GOVERNMENT ACCOUNTABILITY: Students understand how civic engagement can hold governments accountable for environmental policies, promoting responsible governance.\n" +
                        "8. CONFLICT RESOLUTION: It offers insights into peaceful conflict resolution methods employed by environmental defenders, which can serve as examples for students in resolving environmental disputes.\n" +
                        "9. INTERSECTIONS OF ACTIVISM: Students explore the overlap of environmental and civic activism, recognizing the interconnectedness of these movements.\n" +
                        "10. GRASSROOTS CHANGE: The study empowers students to recognize that they, too, can drive grassroots change, making a meaningful impact on their local environment and society.\n",

                "https://www.rappler.com/tachyon/2023/04/Environmental-Defenders-our-heroes.jpg?resize=1280%2C720&zoom=1",
                "https://www.rappler.com/voices/thought-leaders/opinion-environmental-defenders-our-heroes/"
              )
        )

        dataList.add(
            DataItem("ENVIRONMENTAL POLICIES AND CIVIC ADVOCACY IN THE PHILIPPINES",
                "In the Philippines, the call for robust environmental policies echoes through the nation's diverse landscapes. This story unveils the challenges faced by environmental advocates and their civic advocacy efforts to protect vulnerable watersheds.\n\n\n" +
                        "1. ENVIRONMENTAL STEWARDSHIP: This study fosters a sense of environmental responsibility among students, empowering them to actively participate in preserving vital watersheds.\n" +
                        "2. LEGAL LITERACY: Students gain insights into Philippine environmental laws and the need for clear-cut policies, enhancing their legal literacy for informed citizenship.\n" +
                        "3. COMMUNITY ENGAGEMENT: It inspires students to engage in community-level advocacy, helping protect their local watersheds and fostering a sense of civic responsibility.\n" +
                        "4. POLICY ADVOCACY: The study equips students with the knowledge and skills needed to advocate for improved environmental policies, promoting effective civic engagement.\n" +
                        "5. SOCIAL JUSTICE: Students understand the impact of watershed protection on indigenous communities, encouraging them to stand up for social and environmental justice.\n" +
                        "6. CONSERVATION AWARENESS: It raises awareness about the value of watersheds and their crucial role in sustaining ecosystems, cultivating a culture of conservation.\n" +
                        "7. LOBBYING AND ADVOCACY: Students learn about effective lobbying and advocacy techniques, preparing them to influence policy changes and protect natural resources.\n" +
                        "8. ECONOMIC AND ENVIRONMENTAL BALANCE: The study highlights the delicate balance between economic development and environmental preservation, encouraging students to explore sustainable solutions.\n" +
                        "9. PUBLIC INVOLVEMENT: It emphasizes the significance of public participation in decision-making processes, fostering an understanding of civic advocacy in a democratic society.\n" +
                        "10. ENVIRONMENTAL EDUCATION: This study promotes environmental education, making students more conscious of the broader issues related to environmental policies and civic advocacy.",

                "https://www.rappler.com/tachyon/r3-assets/21AA3697628844BD94E5C8C70B1A8E1B/img/40EC0749252C4F8EAB668978231EBD4D/youth-climate-strike-may-24-2019-007-May-25-2019-011-scaled.jpg",
                "https://www.rappler.com/nation/environmental-advocates-seek-policies-protect-watersheds/"
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