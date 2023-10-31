package com.example.civicall.DisasterResponseInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class CommunicationAndInformationInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_communication_and_information_info)




        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "Crisis Communication Technologies: Navigating Emergency Communication Systems",
                "In today's interconnected and unpredictable world, disaster management is paramount. Disasters can disrupt communities and challenge the resilience of societies. System Status Management (SSM) is a revolutionary approach that leverages real-time data and advanced technologies to enhance disaster response and recovery.\n\n" +

                        "1. Communication Network: Establish clear communication among stakeholders, including responders, agencies, and organizations.\n\n" +
                        "2. Data Frameworks: Design comprehensive data plans outlining acquisition and integration protocols.\n\n" +
                        "3. Flexible Plans: Create adaptable response and recovery plans with roles, resources, and activation protocols.\n\n" +
                        "4. Real-Time Data: Continuously collect, analyze, and monitor data sources like weather sensors and social media.\n\n" +
                        "5. Resource Monitoring: Maintain real-time visibility of resources for strategic allocation.\n\n" +
                        "6. Technology Tools: Utilize data visualization tools for informed decision-making.\n\n" +
                        "7. Post-Response Evaluation: Assess the effectiveness of SSM strategies and identify improvements.\n\n" +
                        "8. Integrate Lessons: Incorporate insights from past responses to refine SSM strategies.\n\n" +
                        "9. Update Strategies: Regularly adapt SSM strategies to evolving technologies and scenarios.\n\n" +
                        "10. Embrace Tech: Embrace emerging technologies like AI, predictive analytics, and collaborative platforms for proactive disaster management.\n\n",

                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.linkedin.com%2Fpulse%2Fnavigating-chaos-power-system-status-management-gerlach-mpa-mep&psig=AOvVaw3dC5w_kSoHGSD76ZsCVo0U&ust=1696490147029000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCNDc4bzs24EDFQAAAAAdAAAAABAD",
                "https://www.linkedin.com/pulse/navigating-chaos-power-system-status-management-gerlach-mpa-mep/"
            )
        )
        dataList.add(
            DataItem("Mastering Crisis Communication: Strategies for Disaster Response Organizations",
                "In an emergency, providing timely and factual information to key stakeholders can mean the difference between life and death, order and chaos. Crisis communication focuses on collecting, organizing, and disseminating information for the purpose of mitigating the impact of a crisis and helping communities recover.\n\n" +

                        "1. Establish Clear Communication Protocols: Create well-defined communication pathways and protocols within your organization, specifying roles and responsibilities for disseminating information during a crisis.\n\n" +
                        "2. Develop Crisis Communication Teams: Assemble dedicated crisis communication teams with trained personnel who can efficiently gather, verify, and relay information to stakeholders.\n\n" +
                        "3. Comprehensive Crisis Communication Plans: Develop comprehensive crisis communication plans that encompass various scenarios, ensuring you're prepared to address different types of crises.\n\n" +
                        "4. Real-Time Monitoring: Implement systems for real-time monitoring of news, social media, and other information sources to stay updated on the crisis's evolving nature.\n\n" +
                        "5. Rapid Information Verification: Verify the accuracy of information before disseminating it to prevent the spread of rumors and misinformation.\n\n" +
                        "6. Audience Segmentation: Tailor your communication strategies to different audience segments, considering their unique needs, languages, and communication preferences.\n\n" +
                        "7. Utilize Multiple Communication Channels: Leverage a mix of communication channels, including social media, websites, SMS, press releases, and traditional media, to reach diverse audiences effectively.\n\n" +
                        "8. Crisis-Specific Web Pages: Develop and maintain crisis-specific web pages that provide vital information, resources, and updates, ensuring accessibility and clarity.\n\n" +
                        "9. Timely Updates: Provide timely and regular updates to keep the public informed and engaged, promoting transparency and trust.\n\n" +
                        "10. Training and Drills: Conduct regular training and crisis communication drills to ensure your team is well-prepared to respond effectively when a crisis occurs.\n\n",

                "https://onlinewilder.vcu.edu/wp-content/uploads/sites/3/2021/06/vcu-hsep-blog-crisis-communication.jpeg",
                "https://onlinewilder.vcu.edu/blog/crisis-communication/"
             )
        )
        dataList.add(
            DataItem("Connecting Communities: Effective Information Sharing During Emergencies",
                "Attention, College Students: Unlock the Power of Effective Information Sharing in Emergencies! In times of crisis, seamless communication and data exchange between agencies and communities play a critical role in ensuring public safety and rapid response.\n\n" +
                        "1. Establish Clear Communication Protocols: Define precise guidelines for information sharing within and across communities to ensure seamless coordination during emergencies.\n\n" +
                        "2. Community Information Hubs: Create designated information hubs or platforms where community members can access real-time updates and resources.\n\n" +
                        "3. Multilingual Resources: Develop and provide information in multiple languages to cater to diverse community needs and foster inclusivity.\n\n" +
                        "4. Cross-Agency Collaboration: Encourage collaboration between local agencies, first responders, and community organizations to facilitate data exchange and resource allocation.\n\n" +
                        "5. Rapid Alert Systems: Implement efficient alert systems capable of delivering critical information swiftly to community members via various communication channels.\n\n" +
                        "6. Digital Literacy Initiatives: Promote digital literacy programs to empower community members to access and utilize online information-sharing platforms effectively.\n\n" +
                        "7. Information Verification: Establish mechanisms to verify and authenticate information sources, reducing the spread of rumors and misinformation.\n\n" +
                        "8. Accessibility Standards: Ensure that all shared information adheres to accessibility standards, accommodating individuals with disabilities.\n\n" +
                        "9. Community Feedback Loops: Create channels for community feedback and input, allowing residents to share information, concerns, and suggestions.\n\n" +
                        "10. Regular Training and Drills: Conduct regular drills and training sessions for community leaders and members to familiarize them with information-sharing protocols and platforms.\n\n",

                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.govtech.com%2Fem%2Fsafety%2Finformation-sharing-more-critical-than-ever-amid-the-coronavirus.html&psig=AOvVaw0lpDCAzJAo95Dw5TSa5yzx&ust=1696492938286000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIDdyOr224EDFQAAAAAdAAAAABAE",
                "https://www.govtech.com/em/safety/information-sharing-more-critical-than-ever-amid-the-coronavirus.html"
             )
        )
        dataList.add(
            DataItem("Tweeting Through the Storm: The Vital Role of Social Media in Disaster Response",

                "Brace yourself, college students, for a digital revolution in disaster response! In a world where information moves at the speed of a tweet, social media has transformed the landscape of disaster preparedness, response, and recovery. Gone are the days of relying solely on traditional news outlets; today, platforms like Facebook, Twitter, Google+, and Instagram are at the forefront of delivering real-time updates, connecting communities, and influencing disaster management.\n\n" +

                        "1. Establish Clear Communication Protocols: Define precise guidelines for information sharing within and across communities to ensure seamless coordination during emergencies.\n\n" +
                        "2. Community Information Hubs: Create designated information hubs or platforms where community members can access real-time updates and resources.\n\n" +
                        "3. Multilingual Resources: Develop and provide information in multiple languages to cater to diverse community needs and foster inclusivity.\n\n" +
                        "4. Cross-Agency Collaboration: Encourage collaboration between local agencies, first responders, and community organizations to facilitate data exchange and resource allocation.\n\n" +
                        "5. Rapid Alert Systems: Implement efficient alert systems capable of delivering critical information swiftly to community members via various communication channels.\n\n" +
                        "6. Digital Literacy Initiatives: Promote digital literacy programs to empower community members to access and utilize online information-sharing platforms effectively.\n\n" +
                        "7. Information Verification: Establish mechanisms to verify and authenticate information sources, reducing the spread of rumors and misinformation.\n\n" +
                        "8. Accessibility Standards: Ensure that all shared information adheres to accessibility standards, accommodating individuals with disabilities.\n\n" +
                        "9. Community Feedback Loops: Create channels for community feedback and input, allowing residents to share information, concerns, and suggestions.\n\n" +
                        "10. Regular Training and Drills: Conduct regular drills and training sessions for community leaders and members to familiarize them with information-sharing protocols and platforms.\n\n",

                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.childrenandscreens.com%2Fmedia%2Fpress-releases%2Fsocial-media-meets-social-distancing-ten-expert-tips-for-parents-of-teens-and-tweens-during-the-pandemic%2F&psig=AOvVaw2wZZOd8s33niTm4cFScXPz&ust=1696494033285000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCNDk3PT624EDFQAAAAAdAAAAABAJ",
                "https://www.adjustersinternational.com/resources/news-and-events/social-media-before-during-and-after-a-disaster/#:~:text=Officials%20use%20social%20media%20during,affected%20areas%20and%20identifying%20survivors."
             )
        )
        dataList.add(
            DataItem("\"Alerting the Masses: A Deep Dive into Issuing Emergency Alerts and Warnings to the Public\"",
                "In an era dominated by technology, the issuance of emergency alerts and warnings to the public has become a critical and intricate task. This research explores the technologies and challenges involved in alerting the masses during times of crisis.\n\n" +
                        "1. Risk Assessment: Begin by assessing the nature and severity of the crisis or hazard, considering factors such as location, impact, and potential harm to the public.\n\n" +
                        "2. Message Crafting: Create clear, concise, and informative emergency messages that convey the necessary information, including the type of hazard, recommended actions, and contact details for more information.\n\n" +
                        "3. Audience Segmentation: Segment the target audience based on location, language, and other relevant demographics to ensure messages reach the right people.\n\n" +
                        "4. Channel Selection: Choose appropriate communication channels, such as wireless emergency alerts (WEA), social media, sirens, or broadcast media, considering the preferences and accessibility of the audience.\n\n" +
                        "5. Geotargeting: Utilize geotargeting technologies to deliver alerts specific to affected geographic areas, minimizing unnecessary panic.\n\n" +
                        "6. Multilingual Support: If necessary, provide alerts in multiple languages to cater to the diverse linguistic backgrounds of the population.\n\n" +
                        "7. Accessibility Considerations: Ensure that alerts are accessible to individuals with disabilities by incorporating features like text-to-speech, Braille, or visual alerts.\n\n" +
                        "8. Testing and Drills: Regularly test the alerting system through drills and exercises to identify and address any technical or operational issues.\n\n" +
                        "9. Public Education: Conduct public awareness campaigns to educate the population about the alerting system, how to receive alerts, and appropriate responses during emergencies.\n\n" +
                        "10. Privacy and Security: Implement measures to protect the privacy of individuals while issuing alerts and guard against potential security threats or misinformation.\n\n",


                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.manchestereveningnews.co.uk%2Fnews%2Fgreater-manchester-news%2Fpeople-still-receiving-late-emergency-26769748&psig=AOvVaw29z35IANH-8YSIW4ZqcItT&ust=1696495169148000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCMjwypL_24EDFQAAAAAdAAAAABAE",
                "https://nap.nationalacademies.org/read/24935/chapter/2#17")
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