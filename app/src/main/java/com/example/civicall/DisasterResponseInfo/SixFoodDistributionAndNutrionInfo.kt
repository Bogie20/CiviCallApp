package com.example.civicall.DisasterResponseInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivitySixFoodDistributionAndNutrionInfoBinding

class SixFoodDistributionAndNutrionInfo : AppCompatActivity() {
    private lateinit var binding:ActivitySixFoodDistributionAndNutrionInfoBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivitySixFoodDistributionAndNutrionInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, DisasterResponseMenu::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "Safeguarding Sustenance: Stockpiling Emergency Food Supplies for Disaster Response",
                "\"In times of crisis, having access to a reliable emergency food supply can make a significant difference in ensuring the well-being and survival of individuals and families. Preparing for emergencies and natural disasters should include careful planning for food storage.\n\n" +

                        "1. ASSESS HOUSEHOLD NEEDS: Begin by evaluating the specific needs of your household, including the number of family members, dietary restrictions, and any health considerations.\n\n" +
                        "2. SELECT NON-PERISHABLE FOODS: Choose non-perishable foods that can be stored safely at room temperature. These should include items that require little or no cooking and minimal water for preparation.\n\n" +
                        "3. GATHER ESSENTIAL SUPPLIES: Alongside food, assemble other emergency essentials such as water, personal hygiene items, flashlights, blankets, and any necessary cooking equipment.\n\n" +
                        "4. CREATE A THREE-DAY SUPPLY: Prepare a three-day emergency supply kit. Ensure it includes a variety of non-perishable foods, clean water, and necessary utensils or cooking devices.\n\n" +
                        "5. CHOOSE COMPACT AND LIGHTWEIGHT FOODS: Select foods that are compact and lightweight for ease of storage and transportation. This will help you manage your supply more effectively.\n\n" +
                        "6. INCLUDE A VARIETY OF FOODS: Your short-term disaster supplies kit should consist of a diverse range of foods, including ready-to-eat canned meats, fruits, and vegetables, as well as high-energy foods like peanut butter, granola bars, and trail mix.\n\n" +
                        "7. CONSIDER SPECIAL DIETARY NEEDS: Take into account the dietary needs of infants, elderly family members, or individuals with specific health conditions such as diabetes or allergies.\n\n" +
                        "8. PACK ESSENTIALS AND TOOLS: Ensure you have necessary tools such as a can opener, scissors, or a knife for opening food packaging, as well as disposable plates, cups, and utensils. Pack these items in airtight plastic bags to keep them dry.\n\n" +
                        "9. MONITOR AND ROTATE SUPPLIES: Keep a list of dates for food items to be inspected and potentially rotated (used and replaced). Regularly review and update your emergency food supply to maintain freshness.\n\n" +
                        "10. STORE FOOD SAFELY: Keep your emergency food supply in a cool, dry location. If possible, store it in airtight containers to prevent exposure to moisture and pests.\n\n",

                "https://www.theinstantpottable.com/wp-content/uploads/2023/06/71acafab-4caa-4ac0-9fbd-c944f09ba935.png",
                "https://www.fcs.uga.edu/extension/preparing-an-emergency-food-supply-short-term-food-storage"
            )
        )
        dataList.add(
            DataItem("Feeding Hope: Planning Mass Food Distribution for Disaster Response",
                "Amidst the backdrop of a global pandemic that has challenged societies worldwide, the grassroots efforts of local NGOs and community volunteers in Cebu, Philippines, stand as a powerful testament to the resilience and compassion of humanity.\n\n" +


                        "1. LOCAL NEEDS ASSESSMENT: Conduct a thorough assessment to identify communities and individuals most in need of food assistance, taking into account factors like income levels and access to resources.\n\n" +
                        "2. COLLABORATIVE PARTNERSHIP BUILDING: Establish partnerships with local NGOs, community groups, and volunteers to leverage their knowledge, resources, and networks.\n\n" +
                        "3. RESOURCE MOBILIZATION: Diversify funding sources, including private donors and local businesses, to ensure a sustainable food distribution operation.\n\n" +
                        "4. LOGISTICS AND DISTRIBUTION PLANNING: Develop a logistical plan that outlines the procurement, storage, and distribution of food supplies, considering safety protocols.\n\n" +
                        "5. COMMUNITY ENGAGEMENT AND EDUCATION: Engage with the affected communities, raising awareness about safety measures like social distancing, hygiene practices, and the importance of cooperation.\n\n" +
                        "6. CONTINUOUS DATA COLLECTION: Implement a system for ongoing data collection to monitor the impact of food relief efforts and identify evolving needs.\n\n" +
                        "7. SCALABILITY: Design the food distribution plan with scalability in mind, anticipating the potential need for long-term assistance.\n\n" +
                        "8. COORDINATION WITH AUTHORITIES: Collaborate with local government agencies to ensure a coordinated response and facilitate access to affected areas.\n\n" +
                        "9. LONG-TERM RESILIENCE BUILDING: Integrate strategies for long-term resilience building in vulnerable communities, such as skill development and income-generation programs.\n\n" +
                        "10. COMMUNICATION AND PUBLIC OUTREACH: Utilize social media and other communication channels to maintain transparency, mobilize volunteers, and secure additional support.\n\n",

                "https://www.feedingtexas.org/wp-content/uploads/2019/06/DSC4921-1024x681.jpg",
                "https://reliefweb.int/report/philippines/local-ngos-and-community-volunteers-mobilise-deliver-emergency-food-relief"
            )
        )
        dataList.add(
            DataItem("Safe and Inclusive Relief: Addressing Dietary Restrictions and Allergies in Disaster Response",
                "As disaster response and preparedness become increasingly critical in our ever-changing world, it is paramount to consider every facet of emergency relief, including dietary restrictions and allergies. While disasters can strike at any time, understanding and accommodating common food allergies, such as those prevalent among individuals in the Philippines, is essential for ensuring the safety and well-being of affected populations during times of crisis.\n\n" +


                        "1. ALLERGEN AWARENESS: Understanding common food allergies in the region, such as shellfish, eggs, dairy, and peanuts, is crucial for disaster response teams. In the aftermath of a disaster, providing food that may trigger allergies could exacerbate health issues among affected individuals.\n\n" +
                        "2. FOOD RELIEF PLANNING: Disaster response teams must take into account the dietary restrictions and allergies of affected populations when planning food relief efforts. This includes ensuring that relief packages do not contain allergens that could harm those with allergies.\n\n" +
                        "3. LABELING AND COMMUNICATION: Proper food labeling and clear communication are essential. Relief organizations should label food items accurately, highlighting potential allergens, to prevent accidental consumption by individuals with food allergies.\n\n" +
                        "4. CUSTOMIZED RELIEF: Considering dietary restrictions and allergies, disaster response teams may need to provide customized relief packages for individuals with specific dietary needs. For example, individuals with dairy allergies may require dairy-free alternatives.\n\n" +
                        "5. EMERGENCY MEDICATIONS: In disaster situations, it's crucial to have emergency medications on hand, as mentioned in the original article (e.g., antihistamines like Loratadine). Individuals with known allergies should carry their medications, and disaster response teams should be aware of these needs.\n\n" +
                        "6. EMERGENCY MEDICAL RESPONSE: Being prepared for severe allergic reactions (anaphylaxis) is essential. Disaster response teams should have protocols in place for administering epinephrine and arranging for immediate medical care when necessary.\n\n" +
                        "7. EDUCATION AND AWARENESS: Both responders and affected individuals should be educated about the potential risks of allergen exposure in emergency situations. This includes recognizing the symptoms of allergic reactions and knowing how to respond.\n\n" +
                        "8. ALLERGEN-FREE FOOD OPTIONS: When providing meals in emergency shelters or distributing food aid, consider offering allergen-free options to accommodate individuals with known food allergies.\n\n" +
                        "9. COLLABORATION WITH HEALTHCARE PROVIDERS: Collaborate with local healthcare providers and organizations that specialize in food allergies to ensure a coordinated approach to managing food-related health concerns during disasters.\n\n" +
                        "10. EMERGENCY CONTACT INFORMATION: Maintain updated contact information for medical facilities and professionals who can provide assistance in cases of severe allergic reactions.\n\n",

                "https://www.earlystartgroup.com/wp-content/uploads/2022/05/Food-Allergy.png",
                "https://www.claritin.com.ph/living-allergies/more-questions-about-allergies/common-food-allergies-philippines"
              )
        )
        dataList.add(
            DataItem("Guarding Health at Every Bite: Ensuring Food Safety and Sanitation in Disaster Response",

                "Food safety is a paramount concern in the modern world, influenced by factors like global food production shifts, public expectations, and international trade policies. As a member of the World Trade Organization (WTO), the Philippines adheres to agreements such as the Uruguay Round, the Sanitary and Phytosanitary Agreement, and Technical Barriers to Trade.\n\n" +

                        "1. REVIEW OF FOOD SAFETY CHALLENGES: Conduct a comprehensive review of existing food safety challenges, considering geographic, atmospheric, demographic, and economic factors that contribute to these challenges\n\n" +
                        "2. ANALYSIS OF FOOD LAWS: Scrutinize food laws, regulations, and policies in the Philippines to understand the legal framework governing food safety.\n\n" +
                        "3. INSTITUTIONAL RESPONSIBILITIES: Identify the roles and responsibilities of government agencies involved in strengthening the food safety framework.\n\n" +
                        "4. GAP ANALYSIS: Assess the implementation of food safety control strategies, highlighting gaps and inadequacies in areas such as food inspection, analytical capability, governance, and response to food safety issues.\n\n" +
                        "5. INCIDENCE RECORDS: Collect data on foodborne disease incidences and outbreaks to gauge the current state of food safety issues in the country.\n\n" +
                        "6. FOOD RECALL DATA: Gather information on food recalls to understand how the regulatory system addresses safety concerns.\n\n" +
                        "7. DEFINITION OF RISK: Explore different definitions of risk in the context of food safety, considering international standards and frameworks.\n\n" +
                        "8. RISK ANALYSIS FRAMEWORK: Examine the risk analysis framework employed by the Philippines, as mandated by the Food Safety Act of 2013, and assess its effectiveness.\n\n" +
                        "9. RISK PROFILING: Investigate the process of defining food safety risks through risk profiling and its role in preliminary risk management.\n\n" +
                        "10. RECOMMENDATIONS: Develop recommendations based on the findings to enhance the Philippine food safety framework, particularly in terms of risk analysis and consumer protection.\n\n",

                "https://www.maggiesovenservices.co.uk/blog/wp-content/uploads/2016/12/food-safety-cover-image.png",
                "http://www.foodandnutritionjournal.org/volume9number1/defining-risk-in-food-safety-in-the-philippines/#:~:text=The%20food%20safety%20framework%20in,safety%20to%20the%20general%20public."
               )
        )
        dataList.add(
            DataItem("Building Food Safety Heroes: Training Food Handling Personnel for Disaster Response",
                "Food safety is a paramount concern in the modern world, influenced by factors like global food production shifts, public expectations, and international trade policies. As a member of the World Trade Organization (WTO), the Philippines adheres to agreements such as the Uruguay Round, the Sanitary and Phytosanitary Agreement, and Technical Barriers to Trade. \n\n" +



                        "1. REVIEW OF FOOD SAFETY CHALLENGES: Conduct a comprehensive review of existing food safety challenges, considering geographic, atmospheric, demographic, and economic factors that contribute to these challenges.\n\n" +
                        "2. ANALYSIS OF FOOD LAWS: Scrutinize food laws, regulations, and policies in the Philippines to understand the legal framework governing food safety.\n\n" +
                        "3. INSTITUTIONAL RESPONSIBILITIES: Identify the roles and responsibilities of government agencies involved in strengthening the food safety framework.\n\n" +
                        "4. GAP ANALYSIS: Assess the implementation of food safety control strategies, highlighting gaps and inadequacies in areas such as food inspection, analytical capability, governance, and response to food safety issues.\n\n" +
                        "5. INCIDENCE RECORDS: Collect data on foodborne disease incidences and outbreaks to gauge the current state of food safety issues in the country.\n\n" +
                        "6. FOOD RECALL DATA: Gather information on food recalls to understand how the regulatory system addresses safety concerns.\n\n" +
                        "7. DEFINITION OF RISK: Explore different definitions of risk in the context of food safety, considering international standards and frameworks.\n\n" +
                        "8. RISK ANALYSIS FRAMEWORK: Examine the risk analysis framework employed by the Philippines, as mandated by the Food Safety Act of 2013, and assess its effectiveness.\n\n" +
                        "9. RISK PROFILING: Investigate the process of defining food safety risks through risk profiling and its role in preliminary risk management.\n\n" +
                        "10. RECOMMENDATIONS: Develop recommendations based on the findings to enhance the Philippine food safety framework, particularly in terms of risk analysis and consumer protection.\n\n",

                "https://foodsafetystandard.files.wordpress.com/2022/08/level-3-supervising-food-safety-in-catering-1.png",
                "https://www.youtube.com/watch?v=b5DqFNH5c84"
              )
        )
        dataList.add(
            DataItem("Preserving Health and Quality: Monitoring Food in Disaster Response",
                "In the wake of natural disasters like hurricanes, floods, wildfires, and earthquakes, ensuring food safety becomes crucial. These calamities can disrupt food systems, risking foodborne illnesses and contamination. Monitoring and maintaining food quality during disaster response is not only vital for public health but also for the resilience of affected regions.\n\n" +

                        "1. ASSESS DAMAGE AND INVENTORY: Immediately assess the extent of damage to food production facilities, storage areas, and transportation infrastructure. Take inventory of available food supplies and identify any compromised or contaminated items.\n\n" +
                        "2. ENHANCED LABELING AND STORAGE: Implement a robust labeling system to identify the source, date of receipt, and condition of food ingredients and products. Properly segregate and store food items, especially those from different sources, to prevent cross-contamination.\n\n" +
                        "3. INTENSIFY TRAINING: Conduct specialized training sessions for personnel involved in food handling during disaster response. Emphasize food safety protocols, personal hygiene, and the importance of following regulatory guidelines even in crisis situations.\n\n" +
                        "4. PATHOGEN IDENTIFICATION: Utilize microbiological testing to identify potential pathogens in food products and production environments. This proactive approach helps prevent the release of contaminated food during or after a disaster.\n\n" +
                        "5. ENVIRONMENTAL MONITORING PROGRAMS: Establish comprehensive environmental monitoring programs to regularly test food processing facilities and equipment for cleanliness and potential sources of contamination.\n\n" +
                        "6. PREVENTIVE CONTROLS: Implement preventive measures such as Hazard Analysis Critical Control Point (HACCP) systems to identify and address potential hazards in food production. This proactive approach reduces the risk of foodborne illnesses.\n\n" +
                        "7. CUSTOM PROBIOTIC BLENDS: Consider the use of custom probiotic blends like Log10®'s Pre-Liminate™ to provide an added layer of protection against common foodborne pathogens. These probiotics can help remediate issues within food processing facilities.\n\n" +
                        "8. CONTINGENCY PLANNING: Develop contingency plans specifically tailored to address food quality and safety concerns in disaster situations. Ensure these plans include rapid response protocols for addressing potential foodborne outbreaks. \n\n" +
                        "9. SUPPLY CHAIN RESILIENCE: Strengthen supply chain resilience by identifying alternative transportation routes and storage facilities. Establish communication channels with suppliers and logistics partners to ensure the timely delivery of safe food resources.\n\n" +
                        "10. REGULAR INSPECTIONS: Conduct frequent inspections of food production and distribution points throughout the disaster response efforts. Ensure that safety protocols are maintained, and any deviations are promptly addressed.\n\n",

                "https://shpbeds.org/wp-content/uploads/2023/03/naatural-disaster-assistance.png",
                "https://log10.com/natural-disasters-impact-food-quality/"
             )
        )
        dataList.add(
            DataItem("Strengthening Partnerships: Collaborating with Food Banks and Suppliers in Disaster Response",
                "To all you college students out there, ever wondered how to navigate the chaos of unexpected disasters? Well, in this presentation, we'll unravel the secrets of disaster readiness. In the process, we'll also walk through the formal steps of crafting a comprehensive disaster response plan, with a special spotlight on the crucial role that food banks play in disaster relief efforts.\n\n" +

                        "1. IDENTIFY POTENTIAL DISASTERS: Begin by identifying the types of disasters that your community may face. This knowledge is essential for tailoring your response plan to specific scenarios.\n\n" +
                        "2. BUILD A CONTACT SHEET: Develop a comprehensive contact sheet that includes contact information for staff, board members, key volunteers, and community officials. Ensure that this contact information is regularly updated and readily accessible.\n\n" +
                        "3. DEFINE CRITICAL SERVICES: Determine the critical services your organization will provide during and after a disaster. Consider whether you will offer food assistance to disaster survivors while continuing to serve your regular clients.\n\n" +
                        "4. COLLABORATE WITH OTHER ORGANIZATIONS: Explore partnerships with other community organizations to provide food assistance. Collaboration ensures a coordinated response and avoids fragmented efforts.\n\n" +
                        "5. KEEP PLANS PRACTICAL: When developing your disaster response plan, keep it focused, practical, and simple. Recognize that a one-size-fits-all approach may not be suitable for all disaster scenarios.\n\n" +
                        "6. MAINTAIN FLEXIBILITY: Understand that every disaster is unique, and flexibility is essential. Be prepared to adapt your response based on the specific circumstances of each disaster event.\n\n" +
                        "7. PRINT AND SHARE PLANS: Keep printed and electronic copies of your disaster response plan available. Share these copies with staff, board members, and key volunteers to ensure everyone is aware of their roles and responsibilities.\n\n" +
                        "8. JOIN REGIONAL DISASTER RESPONSE NETWORKS: Consider becoming part of regional disaster response networks like the Food Bank Regional Disaster Response Network. These networks provide increased readiness, additional resources, and expertise for disaster response efforts.\n\n" +
                        "9. FOLLOW THE PHASES OF DISASTER RESPONSE: Recognize the three phases of disaster response: initial response, sustained response, and long-term recovery. Tailor your actions and resources to each phase's specific needs.\n\n" +
                        "10. RECRUIT AND ORGANIZE VOLUNTEERS: Be prepared to recruit and organize volunteers as needed, especially in the aftermath of a disaster. Volunteers play a crucial role in providing assistance to affected communities.\n\n",

                "https://www.abbott.com/content/dam/corp/abbott/en-us/hub/disaster-relief-packaging-960x430.jpg",
                "https://www.youtube.com/watch?v=vkvvhWj6JTY&ab_channel=regionalfoodbank"
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
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)}
}