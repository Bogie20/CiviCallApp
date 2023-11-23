package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityOnetechnologyforcivicBinding

class OneTechnologyforCivic : AppCompatActivity() {
    private lateinit var binding:ActivityOnetechnologyforcivicBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityOnetechnologyforcivicBinding.inflate(layoutInflater)
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
            DataItem("LEARNING ABOUT DATA PRIVACY IN THE PHILIPPINES",
                "As businesses and industries continue to embrace technology and digital solutions, understanding the concept of data privacy becomes increasingly important. In this lesson, we'll explore data privacy in the Philippines, its significance, and the legal framework that governs it.\n" +
                        "\nWhat is Data Privacy?\n\n" +
                        "Data privacy is the fundamental right that allows individuals to control how their personal information is collected, accessed, and utilized. It encompasses various forms of personal data, including health records, financial information, and personally identifiable information (PII). Businesses leverage this data to make informed decisions, such as customer feedback, proprietary research, and much more.\n" +
                        "\nThe Importance of Data Privacy\n\n" +
                        "As entrepreneurs, safeguarding the privacy and security of your customers' information should be a top priority. Data breaches and leaks can lead to various risks, including identity theft, discrimination, and reputational damage. Understanding why data privacy is crucial can help protect both your customers and your business.\n" +
                        "\nData Privacy in the Philippines\n\n" +
                        "In 2012, the Philippines introduced the Data Privacy Act of 2012 (DPA) to ensure the protection of personal and sensitive information in both public and private communication systems. The National Privacy Commission (NPC) was established to oversee the implementation of DPA, aligning the country's data protection practices with international standards. The NPC acts as a watchdog, upholding data privacy standards.\n" +
                        "\nKey Terms and Provisions\n\n" +
                        "The DPA encompasses several key terms and provisions that govern data privacy. These include the legal definition of consent, parameters for processing personal information, subcontracting data processing, the rights of data subjects, security and accountability measures, government entity responsibilities, and the application to government contractors. Understanding these terms and provisions is crucial for ensuring compliance.\n" +
                        "\nGuidelines for Data Processing\n\n" +
                        "To ensure proper compliance with data privacy laws, the Data Privacy Act's Implementing Rules and Regulations (IRR) provide guidelines for data processing. This includes obtaining consent from data subjects, securely storing their information, and properly disposing of personal data to prevent unauthorized access or disclosure.\n" +
                        "\nEnsuring Compliance with Data Privacy Laws\n\n" +
                        "Understanding data privacy rules is essential for protecting customer privacy and avoiding legal penalties. To navigate these complexities effectively, businesses may seek the expertise of specialized corporate law firms, which can provide guidance on implementing data privacy laws and ensuring compliance.\n",

                "https://carpolaw.com/wp-content/uploads/2022/12/BLOGS-IMAGES-CLA-min.png",
                "https://carpolaw.com/data-privacy-philippines/"
            )
        )

        dataList.add(
            DataItem(
                "SOCIAL MEDIA ACTIVISM",
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

                "https://assets2.rappler.com/2020/07/1595408971-collage_CE09D7C6348A49BE93CC55CFD81382D3-1.jpg",
                "https://su.edu.ph/2008-social-media-activism/"

            )
        )
        dataList.add(
            DataItem("ONLINE PETITIONS AND CAMPAIGNS",
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

                "https://media.istockphoto.com/id/1167409896/photo/mans-hand-holding-cell-phone-with-blank-screen.jpg?s=612x612&w=0&k=20&c=8Uum-r5M5Sc_pY1zGxrvlSBuGt1UHnrPh6FXltPxAl8=",
                "https://www.pewresearch.org/internet/2013/04/25/civic-engagement-in-the-digital-age/"

            )
        )
        dataList.add(
            DataItem("DIGITAL CIVIC PLATFORMS AND APPS",
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

                "https://en.reset.org/app/uploads/2021/09/Civic-Tech-1536x1024.jpg",
                "https://en.reset.org/what-is-civic-tech/"
             )
        )

        dataList.add(
            DataItem("CYBERSECURITY FOR ACTIVISTS",
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

                "https://www.arabnews.com/sites/default/files/styles/n_670_395/public/main-image/2018/11/17/1371496-492058900.jpg?itok=jSFLUFlz",
                "https://activisthandbook.org/tools/security"
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