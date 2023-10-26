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

class RecoveryandRebuildingEffortsInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recoveryand_rebuilding_efforts_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "Surveying the Aftermath: Assessing Disaster Damage and Needs in Response Efforts",
                "\"Discover the incredible stories of communities and nations as they embark on the path of recovery and rebuilding after adversity. From natural disasters to economic challenges, witness the resilience and innovation that lead to a brighter future. Explore the strategies that help us not only recover but also thrive in the face of adversity.\n\n" +

                        "1. PROGRAM ENROLLMENT: Start by enrolling in the \"Ready to Rebuild\" (R2R) program, a capacity-building initiative jointly developed and implemented by the World Bank and the Philippine government through the National Disaster Risk Reduction and Management Council and the Office of Civil Defense.\n\n" +
                        "2. ASSESSMENT AND BASELINE DATA: Utilize the program's tools and templates to assess your region's disaster risks and gather pre-disaster baseline data, crucial for evidence-based response and recovery efforts.\n\n" +
                        "3. RECOVERY FRAMEWORK: Develop a responsive pre-disaster and post-disaster recovery framework with a focus on risk-informed planning, using resources like the Philippines' GeoRiskPH integrated multi-hazard database.\n\n" +
                        "4. STAKEHOLDER IDENTIFICATION: Identify key stakeholders, establish institutional arrangements, and determine the modalities for effective collaboration during the recovery phase.\n\n" +
                        "5. DISASTER RISK FINANCING: Formulate a local disaster risk financing strategy, outlining how to fund recovery and reconstruction efforts, including identifying potential funding sources.\n\n" +
                        "6. PRE-DISASTER RECOVERY PLAN: Create a local pre-disaster recovery plan, outlining the essential components required for recovery. This plan should be flexible for adjustments based on specific disaster impacts.\n\n" +
                        "7. TECHNICAL EXPERTISE: Participate in training sessions conducted by technical experts and practitioners as part of the R2R program, gaining insights into various recovery aspects.\n\n" +
                        "8. COMMUNITY INVOLVEMENT: Actively engage with affected communities to gather their input and needs, ensuring that recovery plans are responsive to local priorities and concerns.\n\n" +
                        "9. OUTPUT COMPLETION: By the program's conclusion, ensure the completion of three essential outputs:\n\n" +

                        "• Local pre-disaster baseline data, aiding in rapid damage and needs assessment post-disaster.\n\n" +
                        "• Local disaster risk financing strategy, guiding the funding of recovery efforts.\n\n" +
                        "• Local pre-disaster recovery plan, with components ready for swift implementation based on disaster impacts.\n\n" +



                        "10. IMPLEMENTATION AND MONITORING: When disaster strikes, execute the recovery plan promptly, closely monitoring progress, and making necessary adaptations to ensure a swift and efficient recovery process.\n\n",


                R.drawable.img_56,
                "https://blogs.worldbank.org/eastasiapacific/philippines-ready-rebuild-aftermath-typhoon-rai",
                "https://recovery.preventionweb.net/sites/default/files/styles/landscape_16_9/public/2021-12/PDNA%20Mini%20page_4.jpg?h=b555fb61&itok=JB2iN5X4"
            )
        )
        dataList.add(
            DataItem("Charting the Path to Resilience: Developing a Recovery Plan for Disaster Response.",
                "Hey, college students, ever wondered how organizations ensure they bounce back from disasters? Well, let's dive into the world of Disaster Recovery Plans (DRP). These plans are the secret sauce for swift responses, safeguarding IT systems, and keeping the business wheels turning, even in the face of calamity.\n\n" +


                        "1. RISK ASSESSMENT AND BUSINESS IMPACT ANALYSIS:Begin by conducting a comprehensive risk assessment and business impact analysis (BIA). This step helps identify potential disaster scenarios and assess their impact on critical business functions.\n\n" +
                        "2. IDENTIFY CRITICAL NEEDS:Prioritize business operations and functions based on their criticality. Determine which data, applications, hardware, and user accesses are essential for supporting these functions.\n\n" +
                        "3. SET RECOVERY OBJECTIVES:Establish clear recovery objectives, including the Recovery Time Objective (RTO) and Recovery Point Objective (RPO). RTO defines the acceptable downtime after a disaster, while RPO specifies how much data loss is tolerable.\n\n" +
                        "4. COLLECT DATA AND DOCUMENTATION:Collect and document essential information, including contact lists, inventory of IT assets, backup procedures, and disaster recovery procedures. Maintain up-to-date records of hardware, software, and cloud services.\n\n" +
                        "5. PERSONNEL AND RESPONSIBILITIES:define roles and responsibilities for individuals involved in executing the drp. ensure that backups and alternative personnel are designated for key tasks in case of unavailability.\n\n" +
                        "6. BACKUP PROCEDURES: clearly outline how each data resource is backed up, including specific locations, devices, and folders. Describe the procedures for recovering each resource from backups.\n\n" +
                        "7. DISASTER RECOVERY PROCEDURES:Develop detailed disaster recovery procedures that cover emergency responses, last-minute backups, mitigation measures, damage limitation, and cybersecurity threat eradication.\n\n" +
                        "8. DISASTER RECOVERY SITES: Designate a hot disaster recovery site, typically located remotely, where critical data and systems can be frequently backed up or replicated. This site serves as an alternative data center for swift operations in case of a disaster.\"living document\" with a framework for updates and revisions. Scheduled reviews will take place every three years to ensure that the guidelines remain aligned with the latest knowledge and skills in emergency medical services.\n\n" +
                        "9. TESTING AND REVISION:Regularly test the DRP based on predefined criteria and procedures. Conduct various types of tests, such as checklist tests, full interruption tests, parallel tests, and simulation tests. Revise the plan as needed to ensure its effectiveness.\n\n" +
                        "10. DOCUMENTATION AND MAINTENANCE:Maintain up-to-date documentation of the DRP, ensuring that it reflects the organization's evolving needs, IT infrastructure changes, and the latest best practices in disaster recovery.\n\n" ,






                R.drawable.img_58,
                "https://www.druva.com/glossary/what-is-a-disaster-recovery-plan-definition-and-related-faqs",
                "https://recovery.preventionweb.net/sites/default/files/styles/landscape_16_9/public/2021-12/PDNA%20Mini%20page_4.jpg?h=b555fb61&itok=JB2iN5X4")
        )
        dataList.add(
            DataItem("Empowering Disaster Response: Securing Funding and Resources for Resilient Recovery",
                "In the realm of disaster risk management and financial protection, securing the necessary funding and resources is paramount for safeguarding communities and assets from the devastating impact of disasters. This strategic guide outlines ten critical steps to effectively mobilize resources, engage stakeholders, and prioritize investments in disaster risk reduction and response, reinforcing resilience in the face of adversity.\n\n" +



                        "1. ASSESSMENT OF FUNDING NEEDS: Begin by conducting a comprehensive assessment to determine the financial requirements for disaster risk management initiatives, including risk reduction, preparedness, and recovery efforts.\n\n" +
                        "2. PRIORITIZATION OF INVESTMENTS: Prioritize funding allocation based on identified risks and vulnerabilities, focusing on the most critical areas that require immediate attention and resources.\n\n" +
                        "3. DEVELOPMENT OF A FUNDING STRATEGY: Create a strategic plan that outlines the sources and mechanisms for securing funding, taking into account both public and private sector contributions.\n\n" +
                        "4. ENGAGEMENT WITH STAKEHOLDERS: Collaborate with relevant stakeholders, including government agencies, local communities, non-governmental organizations, and the private sector, to garner support and resources for disaster risk management.\n\n" +
                        "5. IDENTIFICATION OF FUNDING SOURCES: Identify potential funding sources, such as government budgets, international donors, grants, insurance mechanisms, and public-private partnerships.\n\n" +
                        "6. BUDGET PLANNING: Develop a detailed budget that clearly outlines how the secured funding will be allocated across different risk reduction and disaster response activities.\n\n" +
                        "7. POLICY ADVOCACY: Advocate for policies and regulations that promote funding and resource mobilization for disaster risk management, including tax incentives and financial incentives for private sector engagement.\n\n" +
                        "8. CAPACITY BUILDING: Build the capacity of relevant institutions and agencies to effectively manage and utilize the secured funding and resources for disaster risk management.\n\n" +
                        "9. MONITORING AND EVALUATION: Implement robust monitoring and evaluation mechanisms to track the utilization of funds, measure the impact of risk reduction initiatives, and ensure transparency and accountability.\n\n" +
                        "10. RISK COMMUNICATION: Continuously engage with the public and stakeholders to communicate the importance of securing funding for disaster risk management and financial protection, fostering a culture of resilience and preparedness.\n\n" ,




                R.drawable.img_59,
                "https://www.financialprotectionforum.org/third-party/microsite_1/subpage02.html",
                "https://www.eaglenews.ph/wp-content/uploads/2015/06/DSWD.jpg")
        )
        dataList.add(
            DataItem("Synergizing Disaster Response: Collaborating with Government Agencies for Effective Coordination",

                "Effective disaster response, whether natural or man-made, relies on well-coordinated efforts with government agencies. In this guide, we'll delve into the importance of aligning your disaster preparedness initiatives with these agencies and provide a comprehensive roadmap for seamless coordination.\n\n" +




                        "1. ESTABLISH A LOCAL COORDINATION TEAM: Create a dedicated local coordination team within your organization responsible for liaising with local government agencies and emergency services.\n\n" +
                        "2. FAMILIARIZE WITH LOCAL EMERGENCY PLANS: Thoroughly review and understand the local government's emergency management plans, protocols, and contact information.\n\n" +
                        "3. IDENTIFY KEY CONTACTS: Establish and maintain relationships with key contacts in local government agencies, including emergency management offices, fire departments, law enforcement, and public health authorities.\n\n" +
                        "4. PARTICIPATE IN LOCAL DRILLS AND EXERCISES: Actively participate in local disaster preparedness drills and exercises organized by government agencies to ensure seamless coordination during real emergencies.\n\n" +
                        "5. SHARE YOUR RESOURCES: Provide local government agencies with information about your organization's resources and capabilities that can be mobilized in times of disaster, such as equipment, personnel, and facilities.\n\n" +
                        "6. COMMUNICATE REGULARLY: Maintain open lines of communication with government agencies through regular meetings, updates, and information sharing. Ensure they have up-to-date contact information for your organization.\n\n" +
                        "7. ALIGN WITH GOVERNMENT PROTOCOLS: Align your disaster response protocols with those of local government agencies to ensure compatibility and smooth collaboration during emergencies.\n\n" +
                        "8. CONTRIBUTE TO LOCAL EMERGENCY PLANS: Collaborate with government agencies to contribute to the development and improvement of local emergency plans, including resource allocation and response procedures.\"living document\" with a framework for updates and revisions. Scheduled reviews will take place every three years to ensure that the guidelines remain aligned with the latest knowledge and skills in emergency medical services.\n\n" +
                        "9. TRAINING AND CAPACITY BUILDING: Offer training and capacity-building opportunities to local government agencies to enhance their disaster response capabilities, including the use of specialized equipment or tools.\n\n" +
                        "10. TEST COMMUNICATION CHANNELS: Regularly test communication channels and procedures with government agencies to verify their effectiveness and address any issues that may arise.\n\n" ,



                R.drawable.img_60,
                "https://blog.grahammedical.com/blog/agencies-involved-in-disaster-management-and-tools-to-help-them",
                "https://www.pids.gov.ph/details/news/press-releases/pids-study-calls-for-a-more-bottom-up-approach-to-ph-s-drrm-landscape")
        )
        dataList.add(
            DataItem("Rebuilding the Foundation: Prioritizing Infrastructure Repairs in Disaster Response.",
                "Attention, college students! Dive into the world of Disaster Resilient Infrastructure (DRI) and uncover how it safeguards communities and shapes our future. Join us on this captivating journey where science meets resilience, and be part of an exciting exploration into the realm of DRI.\n\n" +

                        "1. ASSESS VULNERABILITIES: Begin by assessing your community's vulnerabilities to various natural disasters based on its geographic location. Consider the types of disasters that pose the greatest threats, such as hurricanes, floods, earthquakes, or wildfires.\n\n" +
                        "2. GATHER DATA: Collect comprehensive data on existing infrastructure, including roads, bridges, public buildings, and utilities. This data should include their current condition, age, and resilience to disasters.\n\n" +
                        "3. RISK ANALYSIS: Perform a detailed risk analysis to evaluate the potential impact of infrastructure failures during disasters. Consider factors like the number of residents affected, critical facilities at risk, and economic consequences.\n\n" +
                        "4. COMMUNITY NEEDS: Engage with community members to understand their needs and priorities during disaster situations. Their input can help determine which infrastructure repairs should take precedence.\n\n" +
                        "5. GOVERNMENT FUNDING: Explore available government funding opportunities, such as federal grants and disaster relief programs, to support infrastructure repairs. Prioritize projects that align with these funding sources.\n\n" +
                        "6. RESILIENCE ENHANCEMENT: Focus on enhancing the resilience of critical infrastructure. This may involve retrofitting buildings to withstand earthquakes, improving drainage systems to mitigate flooding, or reinforcing power grids against wildfires.\n\n" +
                        "7. MULTI-HAZARD APPROACH: Adopt a multi-hazard approach when prioritizing repairs. Infrastructure improvements should address vulnerabilities to various types of disasters, ensuring a comprehensive disaster response strategy.\n\n" +
                        "8. COST-BENEFIT ANALYSIS: Conduct a cost-benefit analysis for each repair project. Evaluate the potential cost savings in disaster recovery and response compared to the investment required for repairs.\n\n" +
                        "9. COMMUNITY IMPACT: Consider the broader impact of infrastructure repairs on the community's well-being, economic stability, and quality of life. Projects that benefit the majority should be prioritized.\n\n" +
                        "10. REGULAR UPDATES: Continuously update and revise the prioritization plan based on changing risks, emerging threats, and lessons learned from previous disasters. Flexibility and adaptability are key in disaster response planning.\n\n" ,

                R.drawable.img_61,
                "https://www.govpilot.com/blog/what-is-disaster-resilient-infrastructure-why-is-it-needed",
                "https://tao-pilipinas.org/wp-content/uploads/2020/08/ruby-northern-samar.jpg")
        )
        dataList.add(
            DataItem("Fostering Resilient Communities: Promoting Community-Led Recovery in Disaster Response ",
                "\"As you prepare to step into the world beyond college, explore the critical intersection of disaster response and community leadership. Dive into the wisdom of Filipino coastal communities as they navigate the challenges of climate change and disaster risk, and discover how their resilience can inspire a path forward in your senior year of academia.\"\n\n" +


                        "1. COMMUNITY NEEDS ASSESSMENT: Begin by conducting a thorough assessment of the specific needs and vulnerabilities within a disaster-prone community, involving local residents and experts.\n\n" +
                        "2. ESTABLISH LOCAL PARTNERSHIPS: Forge partnerships with local government agencies, non-profit organizations, and community leaders to create a collaborative disaster response framework.\n\n" +
                        "3. CAPACITY BUILDING: Develop programs to enhance the skills and knowledge of community members, empowering them to take an active role in disaster preparedness and response.\n\n" +
                        "4. OPEN INFORMATION CHANNELS: Establish transparent communication channels that provide timely and accurate information to the community, fostering trust and understanding.\n\n" +
                        "5. CUSTOMIZED DISASTER PLANS: Work with the community to create tailored disaster response plans that consider local customs, practices, and resources.\n\n" +
                        "6. INCLUSIVE DECISION-MAKING: Involve community members in the decision-making process for disaster response and recovery efforts, ensuring their voices are heard and respected.\n\n" +
                        "7. RESOURCE ALLOCATION: Secure funding and resources for disaster mitigation, response, and recovery activities, addressing infrastructure improvements and community resilience.\n\n" +
                        "8. COMMUNITY ENGAGEMENT PROGRAMS: Implement engagement programs that draw upon local customs and traditions, encouraging unity, cooperation, and collective action.\n\n" +
                        "9. POLICY ADVOCACY: Advocate for policies that prioritize community-led disaster response and recovery, promoting stronger government support and leadership.\n\n" +
                        "10. CONTINUOUS EVALUATION: Regularly assess the effectiveness of disaster response initiatives, making adjustments based on community feedback and evolving needs.\n\n" ,




                R.drawable.img_62,
                "https://knowledge.aidr.org.au/resources/ajem-jan-2019-resilience-in-the-philippines-through-effective-community-engagement/",
                "https://www.pdrf.org/wp-content/uploads/2021/03/What-We-Do-Community-Resilience.jpg")
        )
        dataList.add(
            DataItem("Sustaining Livelihoods: Support Initiatives in Disaster Response",
                "In a world where natural disasters threaten the Philippines' vulnerability, this report highlights the critical need for local-level disaster risk policies. We explore the importance of enhancing preparedness to strengthen community resilience and minimize the impact of disasters in the face of evolving global challenges.\n\n" +

                        "1. ASSESS LOCAL PREPAREDNESS: Begin by conducting a comprehensive assessment of disaster preparedness at the local level, focusing on particularly vulnerable provinces.\n\n" +
                        "2. ANALYZE RISK PERCEPTION: Understand how past disaster experiences influence risk perception. Identify managers who have faced severe storm events and prioritize their needs for preparedness.\n\n" +
                        "3. REVIEW FUNDING ALLOCATION: Examine the allocation of financial aid across provinces in relation to damages suffered. Shift the focus from response-centric funding to bolstering preparedness and resilience.\n\n" +
                        "4. CAPACITY-BUILDING: Tailor capacity-building efforts to the specific needs, experiences, and vulnerabilities of local governments, particularly in impoverished regions.\n\n" +
                        "5. PROVIDE CLIMATE PROJECTIONS: Equip Local Disaster Risk Managers with robust climate projections and evidence-based disaster impact estimates. Ensure these resources are accessible and comprehensible.\n\n" +
                        "6. ENHANCE COORDINATION: Foster better national-to-local dialogue and coordination, incorporating the subjective experiences and local knowledge of managers into disaster management strategies.\n\n" +
                        "7. PRIORITIZE PREPAREDNESS: Elevate the emphasis on pre-disaster preparedness alongside response and management strategies at both national and local government levels.\n\n" +
                        "8. SUPPORT DISASTER RESPONSE: Encourage overseas aid agencies and donors to maintain support for disaster preparedness and response in the Philippines. Advocate for increased investment in disaster risk reduction and climate change adaptation.\n\n" +
                        "9. PROMOTE RESILIENCE: Promote the concept of resilience-building as a long-term strategy to minimize the potential damage to lives and livelihoods from future typhoons.\n\n" +
                        "10. COMMUNITY ENGAGEMENT: Actively involve local communities in disaster preparedness efforts. Ensure they have access to information and resources to enhance their resilience.\n\n" ,







                R.drawable.img_63,
                "https://www.lse.ac.uk/granthaminstitute/publication/disaster-impacts-and-financing-local-insights-from-the-philippines/",
                "https://www.pdrf.org/wp-content/uploads/2021/03/What-We-Do-Community-Resilience.jpg")
        )
        dataList.add(
            DataItem("Rebuilding Homes and Hope: Providing Housing Assistance in Disaster Response",
                "In the aftermath of disasters, rebuilding lives begins with rebuilding homes. This strategy outlines a five-step solution that leverages technology and collaboration to provide efficient, targeted housing assistance after disasters, ultimately promoting community resilience.\n\n" +


                        "1. RAPID MAPPING: Utilize advanced technologies like drones, street cameras, and machine learning algorithms to swiftly map affected neighborhoods and houses.\n\n" +
                        "2. DATA EXTRACTION: Employ machine learning to extract vital information from mapped areas, identifying vulnerable structures and assessing risks.\n\n" +
                        "3. HOUSING PORTAL: Create a comprehensive housing portal containing actionable data to inform housing plans, construction, credit, and insurance markets.\n\n" +
                        "4. POLICY DESIGN: Develop housing subsidy programs tailored to connect affected families with local construction or financial institutions. \n\n" +
                        "5. FINANCIAL PARTNERSHIPS: Leverage international organizations, like the World Bank, to secure financing for resilient housing projects.\n\n" +
                        "6. RETROFITTING SOLUTIONS: Promote cost-effective retrofitting options to enhance existing housing infrastructure.\n\n" +
                        "7. ECONOMIC ANALYSIS: Conduct rapid economic analyses to justify investments in safer housing and incentivize governments.\n\n" +
                        "8. SUBSIDY POLICIES: Collaborate with countries, banks, and financial institutions to establish home improvement subsidy policies based on best practices.\n\n" +
                        "9. HOMEOWNER INCENTIVES: Encourage homeowners and the private sector to invest in home improvement programs.\n\n" +
                        "10. INSURANCE ACCESS: Facilitate the sharing of housing information to help insurers extend coverage, enabling private lenders to offer loans for home improvements.\n\n" ,













                R.drawable.img_64,
                "https://www.worldbank.org/en/topic/disasterriskmanagement/brief/global-program-for-resilient-housing",
                "https://files01.pna.gov.ph/category-list/2022/03/12/galvez.jpeg")
        )
        dataList.add(
            DataItem("Nurturing Enduring Strength: Fostering Long-Term Resilience in Disaster Response",
                "No person or place is immune from disasters, including natural hazards, infectious disease outbreaks, acts of terrorism, and financial crises. This report explores the concept of resilience and the importance of investing in resilience-building measures to reduce the impacts of disasters on individuals, communities, and the nation.\n\n" +


                        "1. ASSESSING RISK AND VULNERABILITY: Communities must assess their exposure to various hazards and understand their vulnerabilities to make informed decisions about resilience investments.\n\n" +
                        "2. ENGAGING THE WHOLE COMMUNITY: Involving all community stakeholders in disaster policymaking and planning ensures that resilience strategies reflect local conditions and priorities.\n\n" +
                        "3. INFRASTRUCTURE ENHANCEMENT: Communities should invest in infrastructure improvements, including disaster-resistant construction and well-enforced building codes.\n\n" +
                        "4. RISK COMMUNICATION: Effective risk communication and community engagement are essential for promoting a culture of resilience and preparedness.\n\n" +
                        "5. LAND-USE PLANNING: Sound land-use planning practices, zoning ordinances, and building code enforcement are critical for reducing disaster risks.\n\n" +
                        "6. MEASURING RESILIENCE: Develop and implement a consistent framework for measuring resilience, considering factors like infrastructure performance, social factors, and building resilience.\n\n" +
                        "7. COMMUNITY COALITIONS: Establish community coalitions with strong leadership and governance structures to assess risk, communicate it, and enhance community capacity.\n\n" +
                        "8. POLICY COORDINATION: Ensure coordination between local, state, and federal policies to create a comprehensive approach to resilience-building.\n\n" +
                        "9. RESEARCH AND TECHNOLOGY: Support research, science, and technology policies to improve hazard detection, monitoring, and understanding.\n\n" +
                        "10. LONG-TERM SHIFTS: Encourage long-term shifts in both physical and cultural approaches to resilience, fostering systemic strength within communities.\n\n" ,







                R.drawable.img_65,
                "https://nap.nationalacademies.org/read/13457/chapter/2",
                "https://static.timesofisrael.com/njjewishnews/uploads/2018/12/GOA-Nechama.jpg")
        )
        dataList.add(
            DataItem("Adaptive Preparedness: Continuously Evaluating and Refining Disaster Response Plans.",
                "Monitoring and evaluation (M&E) involve establishing systems to consistently review the progress of an emergency communication response. This process assesses what needs improvement and whether program goals are being achieved.\n\n" +




                        "1. SET CLEAR OBJECTIVES: Begin by defining clear and specific objectives for your emergency communication response, including what you aim to achieve and how success will be measured.\n\n" +
                        "2. DEVELOP KEY PERFORMANCE INDICATORS (KPIS): Identify relevant KPIs that will help track progress and assess the effectiveness of your communication activities.\n\n" +
                        "3. DATA COLLECTION: Establish a systematic data collection process to gather information on the implementation of communication activities, audience feedback, and other relevant data points.\n\n" +
                        "4. DATA ANALYSIS: Regularly analyze the collected data to gain insights into the performance of your communication efforts. Look for patterns, trends, and areas that require attention.\n\n" +
                        "5. FEEDBACK MECHANISMS: Create feedback mechanisms that allow stakeholders, including the affected population, to provide input and raise concerns regarding the communication response.\n\n" +
                        "6. REGULAR REPORTING: Generate and distribute regular reports summarizing the progress, challenges, and achievements of the communication response. Share these reports with relevant stakeholders.\n\n" +
                        "7. REVIEW MEETINGS: Hold periodic review meetings to discuss the findings from monitoring and evaluation efforts. Use these meetings to make informed decisions and adjustments to the response strategy.\n\n" +
                        "8. ADAPTATION: Based on the monitoring data and feedback received, be prepared to adapt your communication strategy and tactics as needed to better meet the evolving needs of the affected population.\n\n" +
                        "9. DOCUMENT LESSONS LEARNED: Keep a record of lessons learned throughout the emergency response. Document what worked well and what could be improved for future reference.\n\n" +
                        "10. POST-EMERGENCY EVALUATION: After the crisis has been resolved, conduct a comprehensive post-emergency evaluation. Assess the overall effectiveness of the communication response, gather feedback from stakeholders, and identify areas for improvement in future responses.\n\n" ,








                R.drawable.img_66,
                "https://sbccimplementationkits.org/sbcc-in-emergencies/lessons/unit-9-monitoring-and-evaluation/",
                "https://www.davaocity.gov.ph/wp-content/uploads/2019/07/CIO_3875.jpg")
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