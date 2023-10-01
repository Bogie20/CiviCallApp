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
                "Assess disaster damage and needs.",
                "\"Discover the incredible stories of communities and nations as they embark on the path of recovery and rebuilding after adversity. From natural disasters to economic challenges, witness the resilience and innovation that lead to a brighter future. Explore the strategies that help us not only recover but also thrive in the face of adversity.\n\n" +

                        "1. Program Enrollment: Start by enrolling in the \"Ready to Rebuild\" (R2R) program, a capacity-building initiative jointly developed and implemented by the World Bank and the Philippine government through the National Disaster Risk Reduction and Management Council and the Office of Civil Defense.\n\n" +
                        "2. Assessment and Baseline Data: Utilize the program's tools and templates to assess your region's disaster risks and gather pre-disaster baseline data, crucial for evidence-based response and recovery efforts.\n\n" +
                        "3. Recovery Framework: Develop a responsive pre-disaster and post-disaster recovery framework with a focus on risk-informed planning, using resources like the Philippines' GeoRiskPH integrated multi-hazard database.\n\n" +
                        "4. Stakeholder Identification: Identify key stakeholders, establish institutional arrangements, and determine the modalities for effective collaboration during the recovery phase.\n\n" +
                        "5. Disaster Risk Financing: Formulate a local disaster risk financing strategy, outlining how to fund recovery and reconstruction efforts, including identifying potential funding sources.\n\n" +
                        "6. Pre-Disaster Recovery Plan: Create a local pre-disaster recovery plan, outlining the essential components required for recovery. This plan should be flexible for adjustments based on specific disaster impacts.\n\n" +
                        "7. Technical Expertise: Participate in training sessions conducted by technical experts and practitioners as part of the R2R program, gaining insights into various recovery aspects.\n\n" +
                        "8. Community Involvement: Actively engage with affected communities to gather their input and needs, ensuring that recovery plans are responsive to local priorities and concerns.\n\n" +
                        "9. Output Completion: By the program's conclusion, ensure the completion of three essential outputs:\n\n" +

                        "• Local pre-disaster baseline data, aiding in rapid damage and needs assessment post-disaster.\n\n" +
                        "• Local disaster risk financing strategy, guiding the funding of recovery efforts.\n\n" +
                        "• Local pre-disaster recovery plan, with components ready for swift implementation based on disaster impacts.\n\n" +



                        "10. Implementation and Monitoring: When disaster strikes, execute the recovery plan promptly, closely monitoring progress, and making necessary adaptations to ensure a swift and efficient recovery process.\n\n" +
                        "The importance of Focusing Recovery and Rebuilding Efforts in Disaster response\n\n" +
                        "1. Timely Recovery: Having a structured recovery plan in place, as learned from the R2R program, minimizes the time and confusion associated with post-disaster recovery efforts, accelerating the rebuilding process.\n\n" +
                        "2. Community Resilience: Engaging with communities and involving them in the planning process enhances their resilience, ensuring that their specific needs are addressed during recovery.\n\n" +
                        "3. Resource Efficiency: A well-prepared recovery plan optimizes resource allocation, ensuring that funds and support are efficiently utilized for reconstruction.\n\n" +
                        "4. Disaster Risk Reduction: The program equips local governments to reduce disaster risks, saving lives and safeguarding livelihoods during disasters.\n\n" +
                        "5. Continued Support: As the Philippines continues its journey to resilience, continued partnership with organizations like the World Bank ensures access to tailored and sustainable solutions for long-term disaster preparedness and recovery.\"living document\" underscores the commitment to ongoing improvement. Regular reviews and updates of the guidelines ensure that EMS practices remain aligned with the latest advancements in emergency medical services, enhancing the overall preparedness and effectiveness of ambulance teams.\n\n",



                R.drawable.love2,
                "https://blogs.worldbank.org/eastasiapacific/philippines-ready-rebuild-aftermath-typhoon-rai"
            )
        )
        dataList.add(
            DataItem("Develop a recovery plan.",
                "A disaster recovery plan (DRP) is a vital component of organizational resilience, designed to ensure the swift and effective response to natural or man-made disasters. This comprehensive plan outlines the actions to be taken before, during, and after a disaster to safeguard critical IT infrastructure and facilitate recovery. By setting recovery objectives, identifying essential personnel, and detailing backup procedures, a well-structured DRP plays a pivotal role in minimizing data loss, reducing downtime, and ultimately preserving business continuity.\n\n" +


                        "1. Risk Assessment and Business Impact Analysis:Begin by conducting a comprehensive risk assessment and business impact analysis (BIA). This step helps identify potential disaster scenarios and assess their impact on critical business functions.\n\n" +
                        "2. Identify Critical Needs:Prioritize business operations and functions based on their criticality. Determine which data, applications, hardware, and user accesses are essential for supporting these functions.\n\n" +
                        "3. Set Recovery Objectives:Establish clear recovery objectives, including the Recovery Time Objective (RTO) and Recovery Point Objective (RPO). RTO defines the acceptable downtime after a disaster, while RPO specifies how much data loss is tolerable.\n\n" +
                        "4. Collect Data and Documentation:Collect and document essential information, including contact lists, inventory of IT assets, backup procedures, and disaster recovery procedures. Maintain up-to-date records of hardware, software, and cloud services.\n\n" +
                        "5. Personnel and Responsibilities:Define roles and responsibilities for individuals involved in executing the DRP. Ensure that backups and alternative personnel are designated for key tasks in case of unavailability.\n\n" +
                        "6. Backup Procedures: Clearly outline how each data resource is backed up, including specific locations, devices, and folders. Describe the procedures for recovering each resource from backups.\n\n" +
                        "7. Disaster Recovery Procedures:Develop detailed disaster recovery procedures that cover emergency responses, last-minute backups, mitigation measures, damage limitation, and cybersecurity threat eradication.\n\n" +
                        "8. Disaster Recovery Sites: Designate a hot disaster recovery site, typically located remotely, where critical data and systems can be frequently backed up or replicated. This site serves as an alternative data center for swift operations in case of a disaster.\"living document\" with a framework for updates and revisions. Scheduled reviews will take place every three years to ensure that the guidelines remain aligned with the latest knowledge and skills in emergency medical services.\n\n" +
                        "9. Testing and Revision:Regularly test the DRP based on predefined criteria and procedures. Conduct various types of tests, such as checklist tests, full interruption tests, parallel tests, and simulation tests. Revise the plan as needed to ensure its effectiveness.\n\n" +
                        "10. Documentation and Maintenance:Maintain up-to-date documentation of the DRP, ensuring that it reflects the organization's evolving needs, IT infrastructure changes, and the latest best practices in disaster recovery.\n\n" +
                        "The importance of disaster recovery plan:\n\n" +
                        "1. Minimizing Downtime: A well-prepared DRP reduces downtime during and after a disaster, ensuring that critical business operations can resume swiftly. This minimizes disruptions to productivity and revenue loss.\n\n" +
                        "2. Data Protection: DRPs safeguard data from loss or corruption caused by disasters, whether they are natural (e.g., floods, earthquakes) or man-made (e.g., cyberattacks). This protection is vital for maintaining business continuity and customer trust.\n\n" +
                        "3. Regulatory Compliance: Many industries and organizations are subject to strict regulatory requirements regarding data protection and business continuity. A DRP helps ensure compliance with these regulations, avoiding potential legal issues and penalties.\n\n" +
                        "4. Customer Trust: Reliable disaster recovery measures demonstrate a commitment to customer service and reliability. Customers are more likely to trust businesses that have contingency plans in place to protect their data and maintain uninterrupted services.\n\n" +
                        "5. Cost-Efficiency: While implementing a DRP incurs initial costs, it ultimately leads to cost-efficiency. By preventing data loss, reducing downtime, and streamlining recovery processes, it saves the organization from potentially significant financial losses in the long run.\n\n",







                R.drawable.love2,
                "https://www.druva.com/glossary/what-is-a-disaster-recovery-plan-definition-and-related-faqs")
        )
        dataList.add(
            DataItem("Secure funding and resources.",
                "In the realm of disaster risk management and financial protection, securing the necessary funding and resources is paramount for safeguarding communities and assets from the devastating impact of disasters. This strategic guide outlines ten critical steps to effectively mobilize resources, engage stakeholders, and prioritize investments in disaster risk reduction and response, reinforcing resilience in the face of adversity.\n\n" +



                        "1. Assessment of Funding Needs: Begin by conducting a comprehensive assessment to determine the financial requirements for disaster risk management initiatives, including risk reduction, preparedness, and recovery efforts.\n\n" +
                        "2. Prioritization of Investments: Prioritize funding allocation based on identified risks and vulnerabilities, focusing on the most critical areas that require immediate attention and resources.\n\n" +
                        "3. Development of a Funding Strategy: Create a strategic plan that outlines the sources and mechanisms for securing funding, taking into account both public and private sector contributions.\n\n" +
                        "4. Engagement with Stakeholders: Collaborate with relevant stakeholders, including government agencies, local communities, non-governmental organizations, and the private sector, to garner support and resources for disaster risk management.\n\n" +
                        "5. Identification of Funding Sources: Identify potential funding sources, such as government budgets, international donors, grants, insurance mechanisms, and public-private partnerships.\n\n" +
                        "6. Budget Planning: Develop a detailed budget that clearly outlines how the secured funding will be allocated across different risk reduction and disaster response activities.\n\n" +
                        "7. Policy Advocacy: Advocate for policies and regulations that promote funding and resource mobilization for disaster risk management, including tax incentives and financial incentives for private sector engagement.\n\n" +
                        "8. Capacity Building: Build the capacity of relevant institutions and agencies to effectively manage and utilize the secured funding and resources for disaster risk management.\n\n" +
                        "9. Monitoring and Evaluation: Implement robust monitoring and evaluation mechanisms to track the utilization of funds, measure the impact of risk reduction initiatives, and ensure transparency and accountability.\n\n" +
                        "10. Risk Communication: Continuously engage with the public and stakeholders to communicate the importance of securing funding for disaster risk management and financial protection, fostering a culture of resilience and preparedness.\n\n" +
                        "The importance of Securing funding and resources:\n\n" +
                        "1. Enhanced Resilience: Securing adequate funding and resources allows governments and communities to invest in risk reduction measures, preparedness, and recovery efforts. This, in turn, enhances resilience by reducing vulnerabilities and improving the ability to withstand and recover from disasters.\n\n" +
                        "2. Faster Recovery: Adequate financial resources enable swift and effective disaster response and recovery. This can minimize the economic and social impacts of disasters, helping communities and economies bounce back more quickly.\n\n" +
                        "3. Reduced Fiscal Impact: Proper funding and insurance mechanisms can reduce the fiscal burden on governments when disasters occur. This prevents severe financial shocks to government budgets and allows for continued public service delivery and infrastructure development.\n\n" +
                        "4. Private Sector Engagement: Securing funding often involves collaboration with the private sector, which can bring in expertise, innovation, and financial contributions. Public-private partnerships can result in more robust disaster risk management strategies.\n\n" +
                        "5. Sustainable Development: Investing in disaster risk management contributes to sustainable development by protecting infrastructure, livelihoods, and ecosystems. It ensures that development gains are not eroded by frequent disasters and promotes long-term stability and prosperity.\n\n",






                R.drawable.love2,
                "https://www.financialprotectionforum.org/third-party/microsite_1/subpage02.html")
        )
        dataList.add(
            DataItem("Coordinate with government agencies.",

                "Disasters, whether natural or man-made, require a well-coordinated and timely response to mitigate their effects and aid affected communities. Government agencies are key stakeholders in disaster management, wielding the resources and authority to make a significant impact. In the following sections, we delve into the significance of aligning your disaster preparedness efforts with government agencies and provide a comprehensive guide to ensure effective coordination.\n\n" +




                        "1. Establish a Local Coordination Team: Create a dedicated local coordination team within your organization responsible for liaising with local government agencies and emergency services.\n\n" +
                        "2. Familiarize with Local Emergency Plans: Thoroughly review and understand the local government's emergency management plans, protocols, and contact information.\n\n" +
                        "3. Identify Key Contacts: Establish and maintain relationships with key contacts in local government agencies, including emergency management offices, fire departments, law enforcement, and public health authorities.\n\n" +
                        "4. Participate in Local Drills and Exercises: Actively participate in local disaster preparedness drills and exercises organized by government agencies to ensure seamless coordination during real emergencies.\n\n" +
                        "5. Share Your Resources: Provide local government agencies with information about your organization's resources and capabilities that can be mobilized in times of disaster, such as equipment, personnel, and facilities.\n\n" +
                        "6. Communicate Regularly: Maintain open lines of communication with government agencies through regular meetings, updates, and information sharing. Ensure they have up-to-date contact information for your organization.\n\n" +
                        "7. Align with Government Protocols: Align your disaster response protocols with those of local government agencies to ensure compatibility and smooth collaboration during emergencies.\n\n" +
                        "8. Contribute to Local Emergency Plans: Collaborate with government agencies to contribute to the development and improvement of local emergency plans, including resource allocation and response procedures.\"living document\" with a framework for updates and revisions. Scheduled reviews will take place every three years to ensure that the guidelines remain aligned with the latest knowledge and skills in emergency medical services.\n\n" +
                        "9. Training and Capacity Building: Offer training and capacity-building opportunities to local government agencies to enhance their disaster response capabilities, including the use of specialized equipment or tools.\n\n" +
                        "10. Test Communication Channels: Regularly test communication channels and procedures with government agencies to verify their effectiveness and address any issues that may arise.\n\n" +
                        "The Importance for coordinating with government agencies in disaster preparedness and response:\n\n" +
                        "1. Enhanced Disaster Response: Coordinating with government agencies ensures a more effective and coordinated disaster response. By working together, your organization can tap into government resources, expertise, and support, leading to a faster and more efficient response to emergencies.\n\n" +
                        "2. Access to Critical Information: Government agencies often have access to vital information, including real-time updates on disaster situations, evacuation plans, and hazard assessments. Coordinating with these agencies provides your organization with valuable insights that can inform your response strategy.\n\n" +
                        "3. Resource Mobilization: Collaboration with government agencies facilitates resource mobilization. In times of disaster, access to government-supplied resources, such as personnel, equipment, and supplies, can significantly bolster your organization's capacity to respond effectively.\n\n" +
                        "4. Legal Compliance: Many disaster response activities require compliance with local regulations and emergency orders issued by government authorities. Coordinating with these agencies ensures that your organization operates within the bounds of the law, minimizing legal risks.\n\n" +
                        "5. Community Safety: Ultimately, the primary goal of disaster preparedness and response is to protect and serve the community. Coordinating with government agencies helps ensure a unified and comprehensive approach to disaster management, which translates into better protection for community members and their property.\"\n\n",






                R.drawable.love2,
                "https://blog.grahammedical.com/blog/agencies-involved-in-disaster-management-and-tools-to-help-them")
        )
        dataList.add(
            DataItem("Prioritize infrastructure repairs.",
                "Attention, college students! Dive into the world of Disaster Resilient Infrastructure (DRI) and uncover how it safeguards communities and shapes our future. Join us on this captivating journey where science meets resilience, and be part of an exciting exploration into the realm of DRI.\n\n" +

                        "1. Assess Vulnerabilities: Begin by assessing your community's vulnerabilities to various natural disasters based on its geographic location. Consider the types of disasters that pose the greatest threats, such as hurricanes, floods, earthquakes, or wildfires.\n\n" +
                        "2. Gather Data: Collect comprehensive data on existing infrastructure, including roads, bridges, public buildings, and utilities. This data should include their current condition, age, and resilience to disasters.\n\n" +
                        "3. Risk Analysis: Perform a detailed risk analysis to evaluate the potential impact of infrastructure failures during disasters. Consider factors like the number of residents affected, critical facilities at risk, and economic consequences.\n\n" +
                        "4. Community Needs: Engage with community members to understand their needs and priorities during disaster situations. Their input can help determine which infrastructure repairs should take precedence.\n\n" +
                        "5. Government Funding: Explore available government funding opportunities, such as federal grants and disaster relief programs, to support infrastructure repairs. Prioritize projects that align with these funding sources.\n\n" +
                        "6. Resilience Enhancement: Focus on enhancing the resilience of critical infrastructure. This may involve retrofitting buildings to withstand earthquakes, improving drainage systems to mitigate flooding, or reinforcing power grids against wildfires.\n\n" +
                        "7. Multi-Hazard Approach: Adopt a multi-hazard approach when prioritizing repairs. Infrastructure improvements should address vulnerabilities to various types of disasters, ensuring a comprehensive disaster response strategy.\n\n" +
                        "8. Cost-Benefit Analysis: Conduct a cost-benefit analysis for each repair project. Evaluate the potential cost savings in disaster recovery and response compared to the investment required for repairs.\n\n" +
                        "9. Community Impact: Consider the broader impact of infrastructure repairs on the community's well-being, economic stability, and quality of life. Projects that benefit the majority should be prioritized.\n\n" +
                        "10. Regular Updates: Continuously update and revise the prioritization plan based on changing risks, emerging threats, and lessons learned from previous disasters. Flexibility and adaptability are key in disaster response planning.\n\n" +
                        "The importance of Prioritizing infrastructure repairs for disaster response \n\n" +
                        "1. Enhanced Disaster Response: Prioritizing infrastructure repairs for disaster response ensures that critical assets like hospitals, emergency shelters, and communication networks are functional during emergencies. This rapid response can save lives and reduce the overall impact of disasters.\n\n" +
                        "2. Community Safety: Repairing and upgrading infrastructure elements that are most vulnerable to disasters increases the safety of the community. It helps mitigate risks and prevents potential injuries or casualties during catastrophic events.\n\n" +
                        "3. Economic Resilience: Infrastructure repairs focused on disaster response contribute to economic resilience by minimizing disruptions to businesses and essential services. A quicker recovery means less downtime and economic losses for the community.\n\n" +
                        "4. Resource Optimization: Prioritization allows for the efficient allocation of limited resources, such as funding and labor, to where they are needed most urgently. This prevents resource wastage and ensures a more effective disaster response.\n\n" +
                        "5. Long-Term Resilience: By repairing and reinforcing critical infrastructure, communities are better prepared to withstand future disasters. This long-term resilience minimizes the need for repeated repairs and reduces the overall cost of disaster recovery efforts.\n\n",




                R.drawable.love2,
                "https://www.govpilot.com/blog/what-is-disaster-resilient-infrastructure-why-is-it-needed")
        )
        dataList.add(
            DataItem("Promote community-led recovery. ",
                "\"As you prepare to step into the world beyond college, explore the critical intersection of disaster response and community leadership. Dive into the wisdom of Filipino coastal communities as they navigate the challenges of climate change and disaster risk, and discover how their resilience can inspire a path forward in your senior year of academia.\"\n\n" +


                        "1. Community Needs Assessment: Begin by conducting a thorough assessment of the specific needs and vulnerabilities within a disaster-prone community, involving local residents and experts.\n\n" +
                        "2. Establish Local Partnerships: Forge partnerships with local government agencies, non-profit organizations, and community leaders to create a collaborative disaster response framework.\n\n" +
                        "3. Capacity Building: Develop programs to enhance the skills and knowledge of community members, empowering them to take an active role in disaster preparedness and response.\n\n" +
                        "4. Open Information Channels: Establish transparent communication channels that provide timely and accurate information to the community, fostering trust and understanding.\n\n" +
                        "5. Customized Disaster Plans: Work with the community to create tailored disaster response plans that consider local customs, practices, and resources.\n\n" +
                        "6. Inclusive Decision-Making: Involve community members in the decision-making process for disaster response and recovery efforts, ensuring their voices are heard and respected.\n\n" +
                        "7. Resource Allocation: Secure funding and resources for disaster mitigation, response, and recovery activities, addressing infrastructure improvements and community resilience.\n\n" +
                        "8. Community Engagement Programs: Implement engagement programs that draw upon local customs and traditions, encouraging unity, cooperation, and collective action.\n\n" +
                        "9. Policy Advocacy: Advocate for policies that prioritize community-led disaster response and recovery, promoting stronger government support and leadership.\n\n" +
                        "10. Continuous Evaluation: Regularly assess the effectiveness of disaster response initiatives, making adjustments based on community feedback and evolving needs.\n\n" +
                        "The importance of Promoting community-led recovery for disaster response:\n\n" +
                        "1. Empowering Local Communities: Community-led recovery empowers local residents by involving them directly in disaster response efforts. This approach recognizes that communities are often the first responders and can harness their local knowledge and resources effectively.\n\n" +
                        "2. Customized Solutions: Every community has unique needs, resources, and vulnerabilities. Community-led recovery allows for tailored disaster response plans that consider local customs, practices, and available resources, ensuring more effective and efficient recovery efforts.\n\n" +
                        "3. Enhancing Resilience: By actively engaging community members in disaster preparedness and response, this approach strengthens the overall resilience of communities. It equips them with the knowledge and skills needed to adapt to and recover from disasters more effectively.\n\n" +
                        "4. Fostering Collaboration: Community-led recovery encourages collaboration between various stakeholders, including local government agencies, non-profit organizations, and community leaders. This collaboration enhances the coordination of resources and support for disaster-affected communities.\n\n" +
                        "5. Sustainability and Ownership: When communities actively participate in their recovery, they take ownership of the process. This sense of ownership increases the sustainability of recovery efforts, ensuring that communities continue to thrive long after the disaster has passed.\"\n\n",






                R.drawable.love2,
                "https://knowledge.aidr.org.au/resources/ajem-jan-2019-resilience-in-the-philippines-through-effective-community-engagement/")
        )
        dataList.add(
            DataItem("Supporting in livelihoods for disaster response.",
                "In a world where natural disasters threaten the Philippines' vulnerability, this report highlights the critical need for local-level disaster risk policies. We explore the importance of enhancing preparedness to strengthen community resilience and minimize the impact of disasters in the face of evolving global challenges.\n\n" +

                        "1. Assess Local Preparedness: Begin by conducting a comprehensive assessment of disaster preparedness at the local level, focusing on particularly vulnerable provinces.\n\n" +
                        "2. Analyze Risk Perception: Understand how past disaster experiences influence risk perception. Identify managers who have faced severe storm events and prioritize their needs for preparedness.\n\n" +
                        "3. Review Funding Allocation: Examine the allocation of financial aid across provinces in relation to damages suffered. Shift the focus from response-centric funding to bolstering preparedness and resilience.\n\n" +
                        "4. Capacity-Building: Tailor capacity-building efforts to the specific needs, experiences, and vulnerabilities of local governments, particularly in impoverished regions.\n\n" +
                        "5. Provide Climate Projections: Equip Local Disaster Risk Managers with robust climate projections and evidence-based disaster impact estimates. Ensure these resources are accessible and comprehensible.\n\n" +
                        "6. Enhance Coordination: Foster better national-to-local dialogue and coordination, incorporating the subjective experiences and local knowledge of managers into disaster management strategies.\n\n" +
                        "7. Prioritize Preparedness: Elevate the emphasis on pre-disaster preparedness alongside response and management strategies at both national and local government levels.\n\n" +
                        "8. Support Disaster Response: Encourage overseas aid agencies and donors to maintain support for disaster preparedness and response in the Philippines. Advocate for increased investment in disaster risk reduction and climate change adaptation.\n\n" +
                        "9. Promote Resilience: Promote the concept of resilience-building as a long-term strategy to minimize the potential damage to lives and livelihoods from future typhoons.\n\n" +
                        "10. Community Engagement: Actively involve local communities in disaster preparedness efforts. Ensure they have access to information and resources to enhance their resilience.\n\n" +






                        "The importance of the Philippine healthcare system's coordination with local providers:\n\n" +
                        "1. Enhancing Local Resilience: Supporting livelihoods for disaster response strengthens the resilience of communities by enabling them to withstand the economic shocks caused by disasters.\n\n" +
                        "2. Reducing Vulnerability: By investing in livelihoods, communities can become less vulnerable to the adverse effects of typhoons and other disasters, reducing their dependence on external aid.\n\n" +
                        "3. Sustainable Recovery: Livelihood support ensures that communities have the means to recover more swiftly and sustainably after disasters, reducing the long-term impact on their well-being.\n\n" +
                        "4. Empowering Communities: Enabling communities to rebuild their livelihoods empowers them to take an active role in their recovery and fosters a sense of ownership over their future.\n\n" +
                        "5. Comprehensive Disaster Management: Incorporating livelihood support into disaster response strategies ensures a more comprehensive approach to disaster management, addressing both immediate and long-term needs.\n\n",

                R.drawable.love2,
                "https://www.lse.ac.uk/granthaminstitute/publication/disaster-impacts-and-financing-local-insights-from-the-philippines/")
        )
        dataList.add(
            DataItem("Provide housing assistance.",
                "In the aftermath of disasters, rebuilding lives begins with rebuilding homes. This strategy outlines a five-step solution that leverages technology and collaboration to provide efficient, targeted housing assistance after disasters, ultimately promoting community resilience.\n\n" +


                        "1. Rapid Mapping: Utilize advanced technologies like drones, street cameras, and machine learning algorithms to swiftly map affected neighborhoods and houses.\n\n" +
                        "2. Data Extraction: Employ machine learning to extract vital information from mapped areas, identifying vulnerable structures and assessing risks.\n\n" +
                        "3. Housing Portal: Create a comprehensive housing portal containing actionable data to inform housing plans, construction, credit, and insurance markets.\n\n" +
                        "4. Policy Design: Develop housing subsidy programs tailored to connect affected families with local construction or financial institutions. \n\n" +
                        "5. Financial Partnerships: Leverage international organizations, like the World Bank, to secure financing for resilient housing projects.\n\n" +
                        "6. Retrofitting Solutions: Promote cost-effective retrofitting options to enhance existing housing infrastructure.\n\n" +
                        "7. Economic Analysis: Conduct rapid economic analyses to justify investments in safer housing and incentivize governments.\n\n" +
                        "8. Subsidy Policies: Collaborate with countries, banks, and financial institutions to establish home improvement subsidy policies based on best practices.\n\n" +
                        "9. Homeowner Incentives: Encourage homeowners and the private sector to invest in home improvement programs.\n\n" +
                        "10. Insurance Access: Facilitate the sharing of housing information to help insurers extend coverage, enabling private lenders to offer loans for home improvements.\n\n" +






                        "The Importances of Post-Disaster Housing Assistance:\n\n" +
                        "1. Saving Lives: Rapid, targeted housing assistance protects families from the immediate dangers of disaster-affected homes.\n\n" +
                        "2. Economic Resilience: Resilient housing safeguards families' investments, reduces reconstruction costs, and shields economies from disaster-related expenses.\n\n" +
                        "3. Efficient Financing: Strategic housing subsidy programs and partnerships ensure efficient allocation of resources.\n\n" +
                        "4. Community Recovery: By prioritizing housing, communities can recover faster, preserving their social fabric and stability.\n\n" +
                        "5. Risk Reduction: Investing in resilient housing contributes to long-term disaster risk reduction, creating safer environments for future generations.\n\n",










                R.drawable.love2,
                "https://www.worldbank.org/en/topic/disasterriskmanagement/brief/global-program-for-resilient-housing")
        )
        dataList.add(
            DataItem("Foster long-term resilience.",
                "No person or place is immune from disasters, including natural hazards, infectious disease outbreaks, acts of terrorism, and financial crises. This report explores the concept of resilience and the importance of investing in resilience-building measures to reduce the impacts of disasters on individuals, communities, and the nation.\n\n" +


                        "1. Assessing Risk and Vulnerability: Communities must assess their exposure to various hazards and understand their vulnerabilities to make informed decisions about resilience investments.\n\n" +
                        "2. Engaging the Whole Community: Involving all community stakeholders in disaster policymaking and planning ensures that resilience strategies reflect local conditions and priorities.\n\n" +
                        "3. Infrastructure Enhancement: Communities should invest in infrastructure improvements, including disaster-resistant construction and well-enforced building codes.\n\n" +
                        "4. Risk Communication: Effective risk communication and community engagement are essential for promoting a culture of resilience and preparedness.\n\n" +
                        "5. Land-Use Planning: Sound land-use planning practices, zoning ordinances, and building code enforcement are critical for reducing disaster risks.\n\n" +
                        "6. Measuring Resilience: Develop and implement a consistent framework for measuring resilience, considering factors like infrastructure performance, social factors, and building resilience.\n\n" +
                        "7. Community Coalitions: Establish community coalitions with strong leadership and governance structures to assess risk, communicate it, and enhance community capacity.\n\n" +
                        "8. Policy Coordination: Ensure coordination between local, state, and federal policies to create a comprehensive approach to resilience-building.\n\n" +
                        "9. Research and Technology: Support research, science, and technology policies to improve hazard detection, monitoring, and understanding.\n\n" +
                        "10. Long-Term Shifts: Encourage long-term shifts in both physical and cultural approaches to resilience, fostering systemic strength within communities.\n\n" +






                        "The Importance of Fostering long-term resilience in Disaster Response:\n\n" +
                        "1. Prevention and Preparedness: Investing in resilience measures allows communities to prepare for disasters proactively, reducing loss of life, property damage, and economic costs.\n\n" +
                        "2. Community Engagement: Resilience-building involves engaging the entire community, ensuring that local conditions and priorities are considered.\n\n" +
                        "3. Policy Coordination: Effective policy coordination at all levels of government is crucial for creating a comprehensive and unified approach to resilience.\n\n" +
                        "4. Data and Measurement: Developing a consistent framework for measuring resilience helps communities identify priorities and assess progress.\n\n" +
                        "5. Long-Term Sustainability: Resilience measures contribute to the long-term sustainability of communities, reducing the need for costly disaster response and recovery efforts.\n\n",





                R.drawable.love2,
                "https://nap.nationalacademies.org/read/13457/chapter/2")
        )
        dataList.add(
            DataItem("Continuously evaluate and adapt the plan.",
                "Monitoring and evaluation (M&E) involve establishing systems to consistently review the progress of an emergency communication response. This process assesses what needs improvement and whether program goals are being achieved.\n\n" +




                        "1. Set Clear Objectives: Begin by defining clear and specific objectives for your emergency communication response, including what you aim to achieve and how success will be measured.\n\n" +
                        "2. Develop Key Performance Indicators (KPIs): Identify relevant KPIs that will help track progress and assess the effectiveness of your communication activities.\n\n" +
                        "3. Data Collection: Establish a systematic data collection process to gather information on the implementation of communication activities, audience feedback, and other relevant data points.\n\n" +
                        "4. Data Analysis: Regularly analyze the collected data to gain insights into the performance of your communication efforts. Look for patterns, trends, and areas that require attention.\n\n" +
                        "5. Feedback Mechanisms: Create feedback mechanisms that allow stakeholders, including the affected population, to provide input and raise concerns regarding the communication response.\n\n" +
                        "6. Regular Reporting: Generate and distribute regular reports summarizing the progress, challenges, and achievements of the communication response. Share these reports with relevant stakeholders.\n\n" +
                        "7. Review Meetings: Hold periodic review meetings to discuss the findings from monitoring and evaluation efforts. Use these meetings to make informed decisions and adjustments to the response strategy.\n\n" +
                        "8. Adaptation: Based on the monitoring data and feedback received, be prepared to adapt your communication strategy and tactics as needed to better meet the evolving needs of the affected population.\n\n" +
                        "9. Document Lessons Learned: Keep a record of lessons learned throughout the emergency response. Document what worked well and what could be improved for future reference.\n\n" +
                        "10. Post-Emergency Evaluation: After the crisis has been resolved, conduct a comprehensive post-emergency evaluation. Assess the overall effectiveness of the communication response, gather feedback from stakeholders, and identify areas for improvement in future responses.\n\n" +






                        "The importance of the Philippine healthcare system's coordination with local providers:\n\n" +
                        "1. Tracking Progress: Monitoring helps track the progress of activities against established indicators.\n\n" +
                        "2. Adaptation: It enables the adjustment of strategies to align with program goals and objectives as needed.\n\n" +

                        "3. Accountability: M&E provides accountability to various stakeholders, including audiences, partners, and donors.\n\n" +
                        "4. Assessment: Evaluation assesses the success of communication activities.\n\n" +
                        "5. Learning: It identifies lessons learned and best practices to inform future emergency communication responses.\n\n",






                R.drawable.love2,
                "https://sbccimplementationkits.org/sbcc-in-emergencies/lessons/unit-9-monitoring-and-evaluation/")
        )


        val adapter = DataAdapter(dataList)

        // Set an item click listener for the adapter to open the link when the reference TextView is clicked
        adapter.setOnItemClickListener(object : DataAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val clickedItem = dataList[position]
                val link = clickedItem.link

                // Open the link in a web browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(intent)
            }
        })

        // Set the adapter for the RecyclerView
        recyclerView.adapter = adapter
    }
}