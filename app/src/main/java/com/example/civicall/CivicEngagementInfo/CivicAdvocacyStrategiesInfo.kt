package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class CivicAdvocacyStrategiesInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youth_empowerment)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "EFFECTIVE ADVOCACY STRATEGIES",
                "In the realm of civic engagement, the art of advocacy stands as a powerful catalyst for change and progress. It is through effective advocacy strategies that individuals and groups can champion their causes, address societal inequities, and work towards a more just and inclusive society.\"Comprehensive Disaster Preparedness Kits: A Guide to Effective Disaster Response\" and equip yourself with the knowledge to safeguard your community and ensure a brighter, more resilient future.\"\"\n\n" +

                        "1. Issue Identification: Begin by identifying the specific issue or cause that requires advocacy. Research and understand the problem thoroughly, including its root causes and impact on the community.\n\n" +
                        "2. Goal Setting: Define clear and achievable advocacy goals. Determine what change or outcome you aim to achieve through your advocacy efforts, whether it's policy reform, increased awareness, or tangible improvements in your community.\n\n" +
                        "3. Stakeholder Mapping: Identify key stakeholders involved in or affected by the issue. This includes individuals, organizations, policymakers, and community members who can influence or support your advocacy campaign.\n\n" +
                        "4. Build Alliances: Cultivate partnerships and alliances with like-minded organizations and individuals who share your advocacy goals. Collaborative efforts can amplify your impact and provide diverse perspectives and resources.\n\n" +
                        "5. Research and Data: Gather relevant data, statistics, and research to substantiate your advocacy claims. Strong evidence enhances your credibility and reinforces the importance of your cause.\n\n" +
                        "6. Messaging and Communication: Craft compelling messages that resonate with your target audience. Utilize various communication channels, including social media, community meetings, and traditional media, to spread your message effectively.\n\n" +
                        "7. Advocacy Tools: Develop a toolkit of advocacy resources, such as fact sheets, petitions, and educational materials, to support your campaign and engage stakeholders.\n\n" +
                        "8. Mobilize Support: Mobilize community members and supporters to take action. Encourage them to participate in advocacy activities, attend meetings, and advocate alongside you.\n\n" +
                        "9. Advocacy Tactics: Employ a range of advocacy tactics, such as grassroots organizing, lobbying, public demonstrations, and storytelling, to influence decision-makers and create awareness.\n\n" +
                        "10. Evaluation and Adaptation: Continuously evaluate the progress and impact of your advocacy efforts. Be open to adapting your strategies based on feedback and changing circumstances, ensuring your advocacy remains effective and relevant.\n\n",

                "https://www.jocrf.org/wp-content/uploads/2021/12/college.jpg",
                "https://organizingengagement.org/principles/advocacy/?print=print"
            )
        )
        dataList.add(
            DataItem("HARNESSING SOCIAL MEDIA FOR CHANGE",
                "Unlocking the Civic Potential of Social Media: A Journey through Impact and Challenges. Explore how it drives transformative change and overcomes hurdles.\"\n\n" +
                        "1. Identify Your Cause: Clearly define the social or civic issue you are passionate about and want to address through social media activism.\n\n" +
                        "2. Research Your Audience: Understand the demographics and interests of your target audience to tailor your messaging effectively.\n\n" +
                        "3. Choose the Right Platforms: Select social media platforms where your target audience is most active and where your message is likely to have the greatest impact.\n\n" +
                        "4. Create Engaging Content: Develop compelling and shareable content, including visuals, videos, and well-crafted messages that resonate with your audience.\n\n" +
                        "5. Leverage Hashtags: Use relevant and trending hashtags to increase the visibility of your posts and join larger conversations.\n\n" +
                        "6. Engage and Interact: Respond promptly to comments, messages, and mentions to build a community and maintain engagement.\n\n" +
                        "7. Collaborate and Amplify: Partner with like-minded individuals, organizations, or influencers to amplify your message and reach a broader audience.\n\n" +
                        "8. Monitor and Measure: Track the performance of your social media campaigns using analytics tools to assess reach, engagement, and impact.\n\n" +
                        "9. Adapt and Learn: Continuously adapt your strategies based on the feedback and data you gather to improve your effectiveness.\n\n" +
                        "10. Translate Online Action to Real-World Impact: Encourage your online community to take tangible actions, such as attending events, signing petitions, or volunteering, to translate digital support into real-world change.\n\n",

                "https://media.licdn.com/dms/image/D5612AQFcDIrE1snjiQ/article-cover_image-shrink_720_1280/0/1686582368650?e=2147483647&v=beta&t=Ku_V-ot24BJQrZFymZdj07Xdx5UFXccWYZeej3rWMEg",
                "https://www.linkedin.com/pulse/harnessing-power-social-media-activism-bryan-marroquin/"
                )
        )
        dataList.add(
            DataItem("BUILDING COMMUNITY PARTNERSHIPS",
                "Unlocking Potential, Building Futures: Forge Strong Community Partnerships for Civic Engagement. Discover how colleges and universities can empower students to make a lasting impact on their communities and shape a brighter future.\n\n" +
                        "1. Compile Emergency Contact Information: Gather essential contact numbers, including fire, police, ambulance, and medical professionals, and store them in your cell phone and near your home phone.\n\n" +
                        "2. Designate Family Meeting Places: Identify both local and out-of-town meeting places for your family to gather in case you're separated during a disaster or can't return home.\n\n" +
                        "3. Set Up 'I.C.E.' Contacts: Program 'In Case of Emergency' (I.C.E.) numbers in your phone and your family members' phones to provide crucial information to emergency responders.\n\n" +
                        "4. Create a Family Contact Sheet: Develop a comprehensive contact sheet with names, addresses, and phone numbers of important contacts, including an out-of-town contact for times when local communication is disrupted.\n\n" +
                        "5. Prepare Contact Cards: Create contact cards for each family member containing emergency contact information, an out-of-town contact, a designated meeting place, and other vital details. Keep these cards in accessible places like purses, wallets, or backpacks.\n\n" +
                        "6. Ensure Every Family Member Has a Phone: Ensure that all family members have access to a mobile phone or a way to communicate during emergencies.\n\n" +
                        "7. Teach 911 Protocol: Educate children on when and how to call 911 for assistance in emergencies.\n\n" +
                        "8. Familiarize with Text Messaging: Ensure that everyone in your family knows how to send text messages, which can be more reliable during network disruptions than phone calls.\n\n" +
                        "9. Subscribe to Alert Services: Sign up for local alert services that send text messages and emails with crucial information during disasters.\n\n" +
                        "10. Prioritize Communication Methods: In times of crisis, use phone calls sparingly for life-threatening emergencies and rely on text messages, email, and social media for non-emergency communication to prevent network congestion.\n\n",

                "https://img.freepik.com/free-photo/diverse-people-doing-fist-bump-park_53876-104387.jpg",
                "https://learn.givepulse.com/blog/how-civic-engagement-can-transform-community-relationships")
        )

        dataList.add(
            DataItem("CREATING ENGAGING AWARENESS CAMPAIGNS",
                "\"\"Unlock the Power of Civic Engagement: Dive into the Art of Crafting Compelling Awareness Campaigns. Discover the strategies that will not only captivate your audience but also drive meaningful civic participation in your mission.\"\"\n\n" +
                        "1. Define Clear Objectives: Start by setting specific goals for your awareness campaign, such as increasing your organization's visibility, expanding your supporter base, or educating the public about your mission.\n\n" +
                        "2. Identify Target Audiences: Determine the key demographics and interests of your intended audience to tailor your messaging effectively.\n\n" +
                        "3. Select Campaign Timing: Choose the right time to launch your campaign, considering national awareness days or creating standalone campaigns that suit your goals.\n\n" +
                        "4. Establish Key Performance Indicators (KPIs): Define measurable KPIs to track the success of your awareness campaign, including audience growth and engagement rates.\n\n" +
                        "5. Craft a Compelling Message: Create a message that connects with your mission, focusing on a specific aspect to engage both current donors and new supporters effectively.\n\n" +
                        "6. Engage Ambassadors: Mobilize enthusiastic supporters, including board members, volunteers, and those with significant social media followings, to amplify your campaign's reach.\n\n" +
                        "7. Secure Sponsors and Partners: Collaborate with local businesses, influencers, or larger corporations to expand your campaign's visibility and reach.\n\n" +
                        "8. Build an Online Presence: Create a dedicated microsite for your campaign with impactful visuals, clear mission statements, and donation tools.\n\n" +
                        "9. Implement Multichannel Marketing: Utilize various channels, such as social media, email, website content, text messaging, and direct mailings, to engage supporters and direct them to your campaign's microsite.\n\n" +
                        "10. Celebrate Milestones: Highlight and celebrate significant achievements throughout your campaign, concluding with an event to thank donors and emphasize their impact on your mission.\n\n",

                "https://probonoaustralia.com.au/wp-content/uploads/2016/10/campaign.jpg",
                "https://www.onecause.com/blog/awareness-campaigns/"
                )
        )

        dataList.add(
            DataItem("NAVIGATING THE WORLD OF NONPROFITS",
                "\"Unlocking Civic Power: How Nonprofits Drive Social Change. Delve into the dynamic world of nonprofits, where passion meets action to create lasting civic engagement.\"\n\n" +

                        "1. Self-Reflection: Begin by reflecting on your passions, interests, and the causes that resonate with you. Consider what kind of impact you want to make in your community or beyond.\n\n" +
                        "2. Research: Investigate local nonprofit organizations, community groups, and volunteer programs that align with your interests. Explore their missions, volunteer needs, and the impact they create.\n\n" +
                        "3. Evaluate Commitment: Assess your availability and commitment level. Determine whether you can volunteer regularly, for specific events, or remotely, depending on your schedule and preferences.\n\n" +
                        "4. Skills Assessment: Identify your strengths and skills that could benefit volunteer organizations. This includes both hard skills (e.g., web design, teaching) and soft skills (e.g., communication, teamwork).\n\n" +
                        "5. Connect with Peers: Discuss your intentions with fellow students who share similar interests. They may have insights, recommendations, or even want to join you in your volunteer efforts.\n\n" +
                        "6. Contact Organizations: Reach out to the organizations or programs you're interested in. Inquire about volunteer opportunities, application processes, and any training or orientation required.\n\n" +
                        "7. Attend Info Sessions: Attend information sessions or orientations offered by volunteer organizations. These sessions can provide deeper insights into their work and help you make an informed decision.\n\n" +
                        "8. Set Goals: Define clear goals for your volunteer experience. Determine what you hope to achieve personally and how you aim to contribute to the organization's mission.\n\n" +
                        "9. Begin Volunteering: Start your volunteer work with enthusiasm and dedication. Whether it's mentoring, organizing events, or providing essential services, give your best effort.\n\n" +
                        "10. Reflect and Adapt: Regularly reflect on your volunteer experiences. Assess the impact you've made, evaluate your goals, and adapt your volunteer efforts as needed. This ongoing process ensures your service remains high-impact and meaningful.\n\n",

                "https://johnsoncenter.org/wp-content/uploads/2020/10/shutterstock_169040624-1.jpg",
                "https://johnsoncenter.org/blog/nonprofits-are-playing-a-vital-role-in-civic-engagement/"
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