package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class DigitalToolsforCivicEngagementInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigatingtips)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "Social Media Activism",
                "\"Social media activism fuels global movements, connecting virtual and physical worlds for change. Explore 'Comprehensive Disaster Preparedness Kits' to empower your community and build resilience.\"" +
                        "1. Identify Your Cause: Begin by clearly defining the social or civic issue you want to address. Whether it's environmental conservation, human rights, or local community development, a well-defined cause is essential.\n\n" +
                        "2. Set Clear Goals: Establish specific, measurable, achievable, relevant, and time-bound (SMART) goals for your activism campaign. These goals will help you stay focused and track your progress.\n\n" +
                        "3. Choose the Right Platforms: Research which social media platforms are most effective for your cause and target audience. Consider platforms like Twitter, Facebook, Instagram, or TikTok, depending on your objectives.\n\n" +
                        "4. Create Compelling Content: Craft engaging and shareable content that resonates with your audience. Use visuals, videos, and impactful storytelling to convey your message effectively.\n\n" +
                        "5. Build an Online Community: Foster a supportive and engaged community around your cause. Encourage discussions, respond to comments, and acknowledge your supporters.\n\n" +
                        "6. Collaborate with Influencers: Partner with social media influencers or advocates who share your passion. Their reach and credibility can amplify your message.\n\n" +
                        "7. Utilize Hashtags: Create and promote relevant hashtags to make your campaign discoverable and encourage participation. Monitor trending hashtags to join relevant conversations.\n\n" +
                        "8. Implement Online Campaigns: Launch online campaigns such as petition drives, fundraisers, or awareness challenges. Leverage the power of social media to mobilize support.\n\n" +
                        "9. Measure Impact: Use analytics tools provided by social media platforms to track the reach, engagement, and impact of your campaigns. Adjust your strategies based on data insights.\n\n" +
                        "10. Advocate Offline: While social media is a potent tool, remember that real-world action is often essential for change. Encourage your online community to participate in offline activities like rallies, volunteering, or contacting policymakers.\n\n",

                R.drawable.img_141,
                "https://su.edu.ph/2008-social-media-activism/",
                "https://assets2.rappler.com/2020/07/1595408971-collage_CE09D7C6348A49BE93CC55CFD81382D3-1.jpg"
            )
        )
        dataList.add(
            DataItem("Online Petitions and Campaigns",
                "In the age of digital empowerment, 'Online Petitions and Campaigns for Civic Engagement' emerge as a formidable force, bridging the gap between citizens and social change. Harnessing the power of digital platforms, these online initiatives propel individuals to actively shape the future of their communities and nations\n\n" +
                        "1. Identify the Cause: Begin by clearly defining the civic or social issue you want to address with your online petition or campaign. A well-defined cause is essential to rally support.\n\n" +
                        "2. Set Clear Objectives: Establish specific and achievable goals for your online campaign, whether it's gathering a certain number of signatures, raising funds, or influencing policy changes.\n\n" +
                        "3. Choose the Right Platform: Select a suitable online platform for hosting your petition or campaign. Platforms like Change.org, Avaaz, or dedicated campaign websites offer user-friendly tools for creating and sharing petitions.\n\n" +
                        "4. Craft Compelling Content: Create a persuasive and emotionally resonant message that highlights the urgency and significance of your cause. Use compelling visuals, videos, and storytelling to engage your audience.\n\n" +
                        "5. Target Your Audience: Identify the key demographic or interest groups that are most likely to support your cause. Tailor your campaign's messaging to resonate with these specific audiences.\n\n" +
                        "6. Leverage Social Media: Promote your online petition or campaign on social media platforms to maximize visibility. Utilize relevant hashtags and encourage supporters to share your content.\n\n" +
                        "7. Build a Coalition: Collaborate with like-minded organizations, influencers, or activists who can amplify your message and broaden your reach. Coalition-building strengthens your campaign's impact.\n\n" +
                        "8. Engage Supporters: Maintain open communication with your supporters. Keep them informed about campaign updates, milestones, and the impact of their involvement.\n\n" +
                        "9. Monitor Progress: Regularly track the performance of your online petition or campaign. Analyze metrics such as the number of signatures, shares, and engagement to assess its effectiveness.\n\n" +
                        "10. Take Offline Action: While your campaign is online, remember that real-world actions often drive change. Organize events, meetings, or advocacy efforts that complement your online efforts and translate support into tangible results.\n\n",


                R.drawable.img_142,
                "https://www.pewresearch.org/internet/2013/04/25/civic-engagement-in-the-digital-age/",
                "https://149519988.v2.pressablecdn.com/wp-content/uploads/IMG_5330-crop-800.jpg")
        )
        dataList.add(
            DataItem("Data Privacy in Civic Engagement",
                "As communities increasingly rely on online platforms to interact with governments and organizations, safeguarding the confidentiality of personal information becomes not just a preference but a vital necessity for ensuring the security and trustworthiness of these digital interactions.\n\n" +
                        "1. Clear Privacy Policies: Develop and prominently display transparent privacy policies that detail how personal data is collected, used, stored, and shared during civic engagement activities.\n\n" +
                        "2. Data Encryption: Implement strong data encryption protocols to protect sensitive information from unauthorized access or interception.\n\n" +
                        "3. Access Control: Utilize access controls to ensure that only authorized individuals have access to personal data, reducing the risk of data breaches.\n\n" +
                        "4. Anonymous Participation: Offer options for anonymous or pseudonymous participation to provide community members with a sense of security and privacy.\n\n" +
                        "5. Verification Process: Implement a verification process for community members to enhance accountability and trust within the engagement platform.\n\n" +
                        "6. User Permissions: Utilize user permissions and access management systems to control who can view, edit, or manage sensitive data, minimizing the risk of unauthorized leaks.\n\n" +
                        "7. Data Minimization: Collect only necessary and relevant data to limit the amount of personal information stored, reducing exposure to potential breaches.\n\n" +
                        "8. Regular Audits: Conduct regular audits of data handling processes and security measures to identify and rectify vulnerabilities proactively.\n\n" +
                        "9. User Education: Educate community members about data privacy practices, their rights, and how to report concerns regarding their personal information.\n\n" +
                        "10. Responsive Support: Establish channels for community members to ask questions, voice concerns, and request modifications or deletion of their personal data, ensuring their privacy preferences are respected.\n\n",
                R.drawable.img_144,
                "https://www.socialpinpoint.com/data-protection-and-privacy-in-communityengagement/",
                "https://venturebeat.com/wp-content/uploads/2021/03/business-meeting.GettyImages-607477465.jpg?fit=2114%2C1207&strip=all")
        )

        dataList.add(
            DataItem("Digital Civic Platforms and Apps",
                "\"In the era of Digital Civic Platforms and Apps, technology empowers citizens to be active participants in shaping the future of their communities and addressing pressing environmental concerns. Explore how these innovative digital tools are revolutionizing civic engagement and environmental protection.\"\n\n" +
                        "1. Research and Choose the Right Platform: Begin by researching and selecting a digital civic platform or app that aligns with your community engagement goals and environmental initiatives.\n\n" +
                        "2. User-Friendly Interface: Ensure the chosen platform offers a user-friendly interface to maximize accessibility for citizens of all backgrounds and ages.\n\n" +
                        "3. Define Clear Objectives: Establish clear and specific objectives for your engagement project, whether it's addressing environmental issues, gathering feedback, or promoting community involvement.\n\n" +
                        "4. Engage Stakeholders: Collaborate with key stakeholders, including local government agencies, environmental organizations, and community members, to build a supportive network for your digital engagement efforts.\n\n" +
                        "5. Data Privacy and Security: Prioritize data protection and security measures to safeguard users' personal information and maintain their trust in the platform.\n\n" +
                        "6. Training and Support: Provide training and support for users to ensure they can effectively navigate and utilize the platform to participate in civic and environmental activities.\n\n" +
                        "7. Feedback Mechanisms: Implement feedback mechanisms that allow citizens to report environmental concerns, suggest improvements, and communicate directly with relevant authorities.\n\n" +
                        "8. Data Analytics: Utilize data analytics tools within the platform to gather insights, track progress, and make informed decisions based on community input.\n\n" +
                        "9. Promote Transparency: Maintain transparency by sharing information about the platform's operations, including its environmental impact and the actions taken based on citizen input.\n\n" +
                        "10. Continuous Improvement: Continuously assess the platform's effectiveness, gather user feedback, and adapt your strategies to enhance civic engagement and environmental protection efforts.\n\n",



                R.drawable.img_145,
                "https://en.reset.org/what-is-civic-tech/",
                "https://en.reset.org/app/uploads/2021/09/Civic-Tech-1536x1024.jpg")
        )

        dataList.add(
            DataItem("Cybersecurity for Activists",
                "\"In the age of digital activism and civic engagement, safeguarding your mission against cyber threats is paramount. Explore the essential guide to 'Cybersecurity for Activists,' where we unveil the vital practices that will protect your digital initiatives and fortify your impact.\"\n\n" +

                        "1. Conduct Threat Assessments: Regularly evaluate the potential threats and risks to your digital assets, including data breaches, phishing attacks, and surveillance attempts.\n\n" +
                        "2. Implement Strong Passwords: Use complex, unique passwords for each online account, and consider using a trusted password manager to generate and store them securely.\n\n" +
                        "3. Enable Two-Factor Authentication (2FA): Activate 2FA wherever possible to add an extra layer of security to your online accounts, making it more challenging for unauthorized access.\n\n" +
                        "4. Keep Software Updated: Ensure that all your devices and software applications are regularly updated with the latest security patches and fixes.\n\n" +
                        "5. Encrypt Your Devices: Encrypt your mobile devices and computers to protect sensitive data from unauthorized access in case of theft or loss.\n\n" +
                        "6. Use Secure Messaging Apps: Communicate using encrypted messaging apps like Signal to keep your conversations private and protected from eavesdropping.\n\n" +
                        "7. Secure Public Wi-Fi Usage: When using public Wi-Fi networks, employ a Virtual Private Network (VPN) to encrypt your internet traffic and protect against potential data interception.\n\n" +
                        "8. Educate Your Team: Train your team or fellow activists on cybersecurity best practices to create a collective security culture.\n\n" +
                        "9. Regular Backups: Backup important data and documents regularly to prevent data loss in case of ransomware or other cyberattacks.\n\n" +
                        "10. Stay Informed: Keep up-to-date with cybersecurity news and emerging threats to adapt your security practices accordingly.\n\n",
                R.drawable.img_146,
                "https://activisthandbook.org/tools/security",
                "https://www.arabnews.com/sites/default/files/styles/n_670_395/public/main-image/2018/11/17/1371496-492058900.jpg?itok=jSFLUFlz")
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