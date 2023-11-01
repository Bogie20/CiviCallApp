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

class ZeroEmergencyPreparednessInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zero_emergency_preparedness_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "Comprehensive Disaster Preparedness Kits: A Guide to Effective Disaster Response",
                "Attention, college students! In a world where readiness matters more than ever, join us on a journey to unlock the secrets of disaster preparedness and response. Explore the essential procedures outlined in \"Comprehensive Disaster Preparedness Kits: A Guide to Effective Disaster Response\" and equip yourself with the knowledge to safeguard your community and ensure a brighter, more resilient future.\"\"\n\n" +
                        "1. Assess Vulnerabilities: Conduct a thorough assessment of your healthcare facility to identify vulnerabilities to various types of disasters, such as earthquakes, hurricanes, or pandemics.\n\n" +
                        "2. Develop a Comprehensive Emergency Plan: Create a detailed emergency management plan that includes communication strategies, roles and responsibilities, evacuation procedures, and resource allocation.\n\n" +
                        "3. Invest in Training and Drills: Provide regular training sessions and emergency drills for all healthcare staff to ensure they are well-prepared to respond effectively during a disaster.\n\n" +
                        "4. Community Collaboration: Collaborate with local emergency services, ambulance providers, and other healthcare facilities to establish clear roles and responsibilities during a disaster and ensure a coordinated response.\n\n" +
                        "5. Asset Inventory: Maintain an up-to-date inventory of essential assets, including medical equipment, supplies, and medication, and establish protocols for their management during emergencies.\n\n" +
                        "6. Backup Power and Technology: Implement failsafe measures for critical technology systems, medical records, and power sources to ensure uninterrupted healthcare services in the event of power outages or system failures.\n\n" +
                        "7. Patient Evacuation and Relocation: Develop a patient evacuation and relocation plan, considering the needs of vulnerable populations and coordinating with transportation services.\n\n" +
                        "8. Communication Strategy: Establish a robust communication strategy that includes internal and external communication channels to keep patients, staff, and the community informed during a disaster.\n\n" +
                        "9. Resource Allocation: Plan for resource allocation and allocation of staff roles in advance, ensuring that critical resources are distributed efficiently during emergencies.\n\n" +
                        "10. Leadership Commitment: Secure commitment from healthcare facility leadership to prioritize disaster preparedness efforts and allocate necessary resources to maintain operations and provide crucial care during and after a disaster.\n\n",

                "https://www.makatimed.net.ph/wp-content/uploads/2021/08/Disaster-Preparedness-Plan-What-to-Do-in-Case-of-an-Emergency.jpg",
                "https://www.corporatewellnessmagazine.com/article/5-key-components-effective-disaster-preparedness"
            )
        )
        dataList.add(
            DataItem("Crucial Evacuation Plans: Home & Workplace Safety",
                "Hey there, students! Imagine a real-life adventure where you need to be the hero of your own story. In this guide, we're going to dive into Crucial Evacuation Plans for Home & Workplace Safety, helping you prepare for unexpected emergencies like a pro!\n\n" +
                        "1. Identify Potential Threats: First, understand the potential hazards that could require evacuation, whether it's a natural disaster or workplace emergency.\n\n" +
                        "2. Prepare a Disaster Supply Kit: Ensure you have essential supplies like food, water, first aid, and flashlights readily available.\n\n" +
                        "3. Establish a Family Communications Plan: Create a plan to stay connected with family members if you get separated during an evacuation.\n\n" +
                        "4. Include Pets in Your Plan: Don't forget your furry friends; have a plan in place to evacuate them safely.\n\n" +
                        "5. Know Your Community's Warning System: Familiarize yourself with how emergency information will be communicated in your area, whether it's through text messages, sirens, or other means.\n\n" +
                        "6. Designate Meeting Points: Choose locations both within and outside your neighborhood where your family can reunite in case of evacuation.\n\n" +
                        "7. Plan Multiple Evacuation Destinations: Select various evacuation destinations in different directions to give you options during an emergency.\n\n" +
                        "8. Identify Alternative Evacuation Routes: Know different ways to leave your area safely, as primary routes may become blocked.\n\n" +
                        "9. Maintain Adequate Fuel: Keep your vehicle's gas tank at least half full to ensure you can evacuate on short notice.\n\n" +
                        "10. Plan for Those Without Transportation: If you don't have a car, arrange transportation with friends, family, neighbors, or local authorities.\n\n",

                "https://cachevalleyfamilymagazine.com/wp-content/uploads/2022/02/AdobeStock_446004809-scaled.jpeg",
                "https://www.habitat.org/our-work/disaster-response/disaster-preparedness-homeowners/family-evacuation-plan"
           )
        )
        dataList.add(
            DataItem("Emergency Family Communication Strategies",
                "Hey there, college folks! When chaos strikes, staying connected with your loved ones can be your superpower. Welcome to 'Emergency Family Communication Strategies,' where we'll delve into the crucial methods and tips for establishing effective communication plans that will keep your family safe and informed in the face of disasters. From creating contact lists to leveraging technology, we've got you covered.\n\n" +
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

                "https://readysouthflorida.org/wp-content/uploads/2013/04/escapeplanas2_17.jpg",
                "https://www.habitat.org/our-work/disaster-response/disaster-preparedness-homeowners/family-communications-plan#:~:text=Prepare%20a%20family%20contact%20sheet,distance%20calls%20than%20local%20calls./"
              )
        )

        dataList.add(
            DataItem("Fireproofing Your World: Tips for Fire Safety",
                "Fire Safety 101: Your Ultimate College Guide to Staying Hot and Safe! In just a few scrolls, discover essential fire safety tips and guidelines to keep you, your friends, and your living space protected from fire-related emergencies.\n\n" +
                        "1. Install Smoke Alarms: Ensure smoke alarms are installed on every level of your living space, outside each sleeping area, and inside sleeping areas. Regularly test and replace batteries as needed.\n\n" +
                        "2. Plan Your Escape From Fire: Develop an escape plan with your roommates or family, identifying at least two unobstructed exits from every room. Practice this plan at least twice a year.\n\n" +
                        "3. Keep an Eye on Smokers: Encourage responsible smoking habits, never allowing smoking in bed or when drowsy. Provide non-tip ashtrays and dispose of butts safely.\n\n" +
                        "4. Cook Carefully: Never leave cooking unattended, especially if you're tired or have consumed alcohol. Keep cooking areas clear of combustibles and use timers to remind you of cooking food.\n\n" +
                        "5. Give Space Heaters Space: Keep portable heaters at least three feet away from flammable materials, children, and pets. Never leave them unattended or on when you leave home or go to bed.\n\n" +
                        "6. Portable Air Conditioner Safety: Avoid using extension cords or surge protectors with portable air conditioners. Plug them directly into a wall outlet and ensure cords are not placed under rugs or near flammable materials.\n\n" +
                        "7. Matches and Lighters Safety: Store matches and lighters out of reach of children, preferably in a locked cabinet. Teach children that matches and lighters are tools, not toys.\n\n" +
                        "8. Stop, Drop, and Roll: In case your clothes catch fire, remember to stop, drop to the ground, cover your face with your hands, and roll over to smother the flames.\n\n" +
                        "9. Use Electricity Safely: If you notice an electrical appliance smoking or smelling unusual, unplug it immediately and have it serviced. Replace damaged electrical cords and avoid overloading extension cords.\n\n" +
                        "10. Crawl Low Under Smoke: During a fire, smoke rises, and the air near the floor is cleaner. If you must escape through smoke, crawl on your hands and knees to the nearest exit.\n\n",

                "https://damiaglobalservices.com/wp-content/uploads/2022/06/FIRE-SAFETY-INSTALLATION-COMPANIES-IN-INDIA-re-sized.webp",
                "https://www.nwcg.gov/ad-positions/srtl"
             )
        )

        dataList.add(
            DataItem("Financial Resilience: Safeguarding Your Money in Emergencies",
                "Welcome to 'Financial Resilience: Safeguarding Your Money in Emergencies.' In an unpredictable world, ensuring the safety and stability of your finances is paramount. This guide offers valuable insights and strategies to help you protect your hard-earned money during unexpected situations and build financial resilience for a secure future.\n\n" +

                        "1. Financial Planning: Start by creating a comprehensive financial plan that includes saving a portion of your income each month and establishing an emergency fund. This solid foundation will safeguard your finances against unexpected setbacks.\n\n" +
                        "2. Improve Financial Literacy: Invest in your financial education by expanding your knowledge of money management, investments, and financial planning. Stay informed by reading trusted sources and financial news to make informed decisions.\n\n" +
                        "3. Protect Your Savings: Prevent dipping into your savings by analyzing your spending habits and practicing mindful spending. Avoid impulse purchases and minimize credit card usage unless necessary to maintain the integrity of your savings.\n\n" +
                        "4. Get Insured: Explore various insurance options to shield yourself from financial losses resulting from critical illnesses, accidents, or unfortunate events. Life and health insurance provide financial security for you and your loved ones.\n\n" +
                        "5. Be Prepared: Anticipate unforeseen situations that could disrupt your income stream, such as disability or death. Consider income protection plans like Cash for Income Loss to ensure financial stability in times of crisis.\n\n" +
                        "6. Emergency Fund: Build and maintain an emergency fund that covers at least three to six months of living expenses. This financial cushion will help you weather unexpected financial storms without depleting your savings.\n\n" +
                        "7. Debt Management: Manage and reduce high-interest debts strategically to free up more financial resources for emergencies. Prioritize paying off debts to alleviate financial stress during tough times.\n\n" +
                        "8. Invest Wisely: Diversify your investments to minimize risk and potentially grow your wealth over time. Consult with financial advisors to create an investment portfolio aligned with your long-term financial goals.\n\n" +
                        "9. Budgeting: Create a budget that outlines your income, expenses, and savings goals. Stick to this budget to maintain financial discipline and allocate funds for emergencies.\n\n" +
                        "10. Regular Review: Periodically review and update your financial plan, insurance coverage, and investment strategies to adapt to changing circumstances. Stay proactive in safeguarding your financial well-being.\n\n",

                "https://6rt99wqv.media.zestyio.com/CMS---June-2021-Blogs_Blog-4-boost.png",
                "https://singlife.com.ph/about/blog/5-ways-to-safeguard-your-finances/#:~:text=Insurance%20is%20a%20way%20of,in%20the%20worst%20case%2C%20death."
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