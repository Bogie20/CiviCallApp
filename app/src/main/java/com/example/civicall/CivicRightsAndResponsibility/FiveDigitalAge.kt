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

class FiveDigitalAge : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_digital_age)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "DATA PRIVACY LAWS IN THE PHILIPPINES",
                "Unlocking the Essentials: Data Privacy Laws in the Philippines\" delves into the fundamental aspects of data privacy regulations, shedding light on the importance of privacy notices in maintaining transparency and fairness in data handling.\n\n" +
                        "1. LEGAL LITERACY: This study empowers students with a foundational understanding of data privacy laws, a crucial aspect of legal literacy in the modern digital age.\n" +
                        "2. COMPLIANCE SKILLS: Students will gain insights into compliance elements of data privacy laws, a skill set highly sought after in various professions.\n" +
                        "3. PRIVACY PROTECTION: Understanding privacy notices equips students with the knowledge to protect their own personal data in an increasingly data-driven world.\n" +
                        "4. NATIONAL REGULATION: It highlights the Philippines' Data Privacy Act (DPA) and the role of the National Privacy Commission (NPC), providing students with insights into national regulations.\n" +
                        "5. TRANSPARENCY AND FAIRNESS: Students will grasp the significance of transparency and fairness in data handling, essential principles in data privacy.\n" +
                        "6. RIGHTS AWARENESS: The study emphasizes individuals' rights to be informed about their data processing, promoting awareness among students.\n" +
                        "7. PRIVACY INFORMATICS: It introduces the concept of developing effective privacy notices, relevant for students pursuing careers in informatics, technology, or law.\n" +
                        "8. PRACTICAL KNOWLEDGE: Learning about practical issues encountered when crafting privacy notices offers real-world insights for students.\n" +
                        "9. GLOBAL ALIGNMENT: Exploring the alignment between Philippine data privacy laws and international regulations like the GDPR fosters a global perspective.\n" +
                        "10. EMPOWERMENT: Ultimately, this study empowers students by providing tools for individuals to exercise control over their personal data, making them advocates of data privacy and protection.\n",

                "https://www.rappler.com/tachyon/r3-assets/D7D3D4E51FF74DA8872FA0AF5D7293BC/img/5B7ECB48DD284DDDA5F143C8C0662D01/data-privacy-act-notices.jpg?resize=800%2C450&zoom=1",
                "https://www.rappler.com/technology/features/221542-things-to-know-about-data-privacy-notices/#:~:text=To%20prevent%20or%20at%20least,NPC)%20overseeing%20its%20proper%20implementation."
            )
        )
        dataList.add(
            DataItem("CYBERSECURITY AND CIVIC RESPONSIBILITY",
                "\"Unveiling the Cyber Threat Landscape: Exploring Cybersecurity and Civic Responsibility in the Philippines. Dive into the digital realm where cybersecurity meets civic duty, as we navigate the challenges and responsibilities of safeguarding our connected society.\n\n" +
                        "1. DIGITAL DEFENSE EDUCATION: This study equips students with crucial knowledge about the state of cybersecurity in the Philippines, empowering them to protect themselves and society from online threats.\n" +
                        "2. CIVIC CYBER RESPONSIBILITY: It underscores the importance of cyber responsibility as an essential civic duty in the modern digital age, where individuals play a role in ensuring a secure online environment.\n" +
                        "3. RISING CYBER THREAT AWARENESS: Students will gain a deeper understanding of the evolving landscape of cyber threats and their potential consequences, fostering vigilance and proactive responses.\n" +
                        "4. HACKING AND CIVIC ACTIVISM: Explore the intersection of hacking, hacktivism, and civic concerns, shedding light on the role of technology in shaping social and political discourse.\n" +
                        "5. CYBERATTACKS ON GOVERNMENT: Understand how hackers target government entities, sparking discussions on civic involvement in holding institutions accountable.\n" +
                        "6. VULNERABILITIES IN THE SYSTEM: Students learn about vulnerabilities within the Philippine cybersecurity infrastructure, motivating them to advocate for stronger security measures.\n" +
                        "7. SHORTAGE OF CYBERSECURITY EXPERTS: Highlight the shortage of cybersecurity professionals in the Philippines and the need for more students to pursue careers in this field.\n" +
                        "8. BUSINESS AND PERSONAL PROTECTION: Address the importance of cybersecurity for businesses and individuals alike, as students gain insights into safeguarding their data and online activities.\n" +
                        "9. PREVENTING CYBER THREATS: Encourage proactive cybersecurity measures, emphasizing that preventing threats is just as important as responding to them.\n" +
                        "10. CIVIC ADVOCACY FOR CYBERSECURITY: Empower students to become advocates for cybersecurity awareness, contributing to a safer digital society and fulfilling their civic responsibility.",

                "https://www.rappler.com/tachyon/r3-assets/612F469A6EA84F6BAE882D2B94A4B421/img/83383681AAEE490C9EC13D05C1519960/cybersecurity-philippines-20160426.jpg?resize=640%2C360&zoom=1",
                "https://www.rappler.com/newsbreak/in-depth/130883-state-cybersecurity-philippines/"
            )
        )
        dataList.add(
            DataItem("DIGITAL CITIZENSHIP AND MEDIA LITERACYS",
                "Embark on a journey through the digital landscape, where we explore the essence of digital citizenship and the critical role of media literacy. Uncover the keys to responsible online participation and safeguarding your privacy.\"\n\n" +


                        "1. EMPOWERING DIGITAL RESPONSIBILITY: This study equips students with the knowledge and skills needed to become responsible digital citizens, promoting ethical online behavior.\n" +
                        "2. MEDIA AND INFORMATION LITERACY: Students will gain insights into media literacy, enhancing their ability to critically evaluate online information and make informed decisions.\n" +
                        "3. PRIVACY PROTECTION: Understanding privacy in the digital age becomes paramount, helping students safeguard personal information and protect their online identity.\n" +
                        "4. FIGHTING DISINFORMATION: Students will learn to discern between credible information and disinformation, contributing to a healthier digital information ecosystem.\n" +
                        "5. ONLINE CIVIC ENGAGEMENT: The study encourages students to actively participate in civic activities online, fostering a sense of responsibility in the digital world.\n" +
                        "6. COMMUNITY BUILDING: It highlights the importance of fostering respectful online communities and contributing positively to the digital society.\n" +
                        "7. MEDIA ETHICS: Students gain an understanding of media ethics, encouraging responsible sharing and content creation online.\n" +
                        "8. EMPATHY AND CONNECTION: The study promotes empathy in online interactions, building meaningful connections in the digital realm that transcend surface-level engagement.\n" +
                        "9. INFORMATION ACCESSIBILITY: Students learn the significance of making accurate information accessible to all, fostering a more informed and equitable digital society.\n" +
                        "10. DIGITAL LEADERSHIP: Empowering students to become digital opinion leaders within their circles, inspiring responsible online behavior and influencing others positively.",

                "https://www.rappler.com/tachyon/2023/07/Screen-Shot-2023-07-20-at-4.10.17-PM.png?resize=840%2C629&zoom=1.5",
                "https://www.rappler.com/moveph/understanding-role-citizen-journalism-digital-world-factsfirstph-learning-series-july-2023/"
              )
        )

        dataList.add(
            DataItem("ETHICAL CONSIDERATIONS IN THE DIGITAL AGE",
                "Navigate the complex landscape of digital ethics in the modern age. Explore the ethical responsibilities of influencers and the impact of their actions on public discourse.\"\n" +
                        "1. PROMOTING ETHICAL AWARENESS: This study fosters a sense of ethical awareness, helping students recognize the significance of ethics in their online interactions.\n" +
                        "2. CRITICAL THINKING: Students will develop critical thinking skills to evaluate the ethical implications of various digital actions and decisions.\n" +
                        "3. RESPONSIBLE ONLINE BEHAVIOR: The study emphasizes responsible online behavior, encouraging students to act ethically in their digital lives.\n" +
                        "4. MEDIA LITERACY: Students gain media literacy skills, allowing them to differentiate between credible and unethical sources of information.\n" +
                        "5. INFLUENCER IMPACT: Understanding the ethical responsibilities of influencers helps students assess the credibility of the content they consume.\n" +
                        "6. PUBLIC DISCOURSE: This study highlights the role of influencers in shaping public discourse, making students more informed and engaged citizens.\n" +
                        "7. COMMUNITY LEADERSHIP: Students will recognize that influencers are community leaders and must uphold principles of mutual respect and human dignity.\n" +
                        "8. SOCIAL MEDIA AUTHENTICITY: The importance of authenticity for influencers underscores the need for students to maintain authenticity in their own digital lives.\n" +
                        "9. ACCOUNTABILITY: Students will learn about the accountability of influencers and the consequences of ethical lapses in the digital sphere.\n" +
                        "10. MEDIA ETHICS: This study introduces students to principles of media ethics, inspiring them to reject 'greed-hoarding impulses' and promote ethical practices in the digital age.",

                "https://www.rappler.com/tachyon/2021/09/tl-influencers-1.jpg?resize=1280%2C720&zoom=1",
                "https://www.rappler.com/voices/thought-leaders/opinion-social-media-influencers-ethical-responsibility/"
               )
        )

        dataList.add(
            DataItem("PROTECTING PERSONAL DATA AND CIVIC DUTY",
                "Enter the digital age with confidence and civic responsibility by learning how to safeguard your personal information. Explore the essential steps to protect your data and fulfill your civic duty in the online world.\n\n\n" +
                        "1. EMPOWERMENT IN THE DIGITAL AGE: Students will gain the knowledge and skills needed to protect their personal information, allowing them to navigate the digital landscape with confidence.\n\n" +
                        "2. DATA PRIVACY AWARENESS: The study fosters an understanding of the importance of data privacy, ensuring that students are well-informed about the risks and vulnerabilities associated with sharing personal information online.\n\n" +
                        "3. CIVIC RESPONSIBILITY: By learning how to safeguard personal data, students are better prepared to fulfill their civic duty in the digital world, contributing to a safer and more responsible online community.\n\n" +
                        "4. LEGAL PROTECTIONS: Students will become aware of the legal protections surrounding data privacy, empowering them to advocate for their rights and stay compliant with relevant laws.\n\n" +
                        "5. CYBERSECURITY COMPETENCE: The study equips students with fundamental cybersecurity skills, enabling them to protect not only their data but also contribute to a more secure online environment for everyone.\n\n" +
                        "6. PRIVACY IN SOCIAL MEDIA: Students will understand the risks associated with oversharing personal information on social media and learn how to maintain a safer online presence.\n\n" +
                        "7. LOCATION DATA AWARENESS: By being cautious about sharing location data, students can reduce the risk of physical surveillance, safeguarding their privacy in an interconnected world.\n\n" +
                        "8. SOCIAL MEDIA PRIVACY SETTINGS: The study emphasizes the importance of configuring privacy settings on social media platforms, helping students keep their online profiles secure.\n\n" +
                        "9. SAFE ONLINE PRACTICES: Students will learn safe online practices, such as refraining from participating in dubious quizzes and being mindful of what they download and install.\n\n" +
                        "10. DATA DETOX: The study introduces the concept of a 'Data Detox,' providing students with a practical guide to reduce their digital footprint and protect their personal information.",

                "https://www.rappler.com/tachyon/r3-assets/612F469A6EA84F6BAE882D2B94A4B421/img/C1C1F37CF68C40039C6E5EFF93C3A446/location-social-media-march-20-2018.jpg?resize=640%2C360&zoom=1",
                "https://www.rappler.com/newsbreak/iq/198603-data-privacy-personal-information-protection-tips/"
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