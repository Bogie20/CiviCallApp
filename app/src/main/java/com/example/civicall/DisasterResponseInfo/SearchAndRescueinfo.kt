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

class SearchAndRescueinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchandrescueinfo)




        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "Procedure for Training Search and Rescue Teams",
                "Search and Rescue Operations, or SAR, are a vital element of emergency response efforts. This guide offers a detailed overview of the key components involved in SAR, including team training, equipment maintenance, and coordination with local authorities. It serves as an essential resource for those dedicated to preserving lives and communities during crises.\"\"\n\n" +

                        "1. Needs Assessment: Begin by assessing the specific needs and requirements of your search and rescue team. Identify the types of disasters or emergencies they may encounter, the skills needed, and the available resources.\n\n" +
                        "2. Recruitment and Selection: Recruit individuals with relevant backgrounds, skills, and a commitment to the mission. Consider physical fitness, medical training, communication skills, and teamwork abilities during the selection process.\n\n" +
                        "3. Orientation and Induction: Provide a comprehensive orientation program to familiarize new team members with the organization's structure, goals, and operational procedures.\n\n" +
                        "4. Basic Training: Conduct foundational training that covers basic first aid, navigation, wilderness survival, and team coordination. This ensures that all team members have a fundamental skillset.\n\n" +
                        "5. Specialized Training: Depending on the team's mission and responsibilities, provide specialized training such as swift water rescue, urban search and rescue, or technical rope rescue. Ensure that team members are certified in these areas.\n\n" +
                        "6. Continuous Education: Emphasize the importance of continuous learning. Encourage team members to attend regular training sessions, workshops, and courses to stay up-to-date with the latest techniques and equipment.\n\n" +
                        "7. Resource Optimization: Properly trained teams make efficient use of resources, including equipment, personnel, and time, maximizing the impact of their efforts.\n\n" +
                        "8. Effective Coordination: Training enhances teamwork and communication, which is essential for coordinating efforts during complex SAR operations involving multiple agencies and responders.\n\n" +
                        "9. Efficiency: Trained teams work more efficiently, reducing the time it takes to locate and assist individuals in need. This efficiency can save critical minutes during emergencies.\n\n" +
                        "10. Safety: Training ensures that SAR team members can operate safely in challenging environments, minimizing the risk to themselves and others during rescue missions.\n\n",

                R.drawable.love2,
                "http://www.lifesafety.com/emergency-training/search-rescue-training/",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863"
            )
        )
        dataList.add(
            DataItem("Maintain Necessary Equipment",
                "The maintenance of necessary equipment is a fundamental component of search and rescue (SAR) operations. Ensuring that equipment is in optimal condition is vital for the safety and effectiveness of SAR teams during emergencies. This guide outlines procedures for maintaining SAR equipment and highlights its critical importance in successful search and rescue missions.\n\n" +
                        "1. Regular Inspections: Conduct routine inspections of all SAR equipment to identify wear, damage, or defects. This includes ropes, harnesses, medical supplies, communication devices, and specialized tools.\n\n" +
                        "2. Scheduled Maintenance: Establish a maintenance schedule based on equipment manufacturer recommendations. Regularly service and repair equipment to prevent breakdowns during critical operations.\n\n" +
                        "3. Inventory Management: Keep a detailed inventory of all SAR equipment, including serial numbers, purchase dates, and maintenance history. This helps track equipment condition and plan for replacements.\n" +
                        "4. Training on Equipment Use: Ensure that SAR team members are trained in the proper use and care of all equipment. Training should cover storage, handling, and emergency troubleshooting procedures.\n\n" +
                        "5. Emergency Equipment Checks: Before each mission, perform final equipment checks to verify that all gear is in working order. This step is crucial for readiness and to avoid equipment failures during critical moments.\n\n" +
                        "6. Operational Reliability: Properly maintained equipment is more reliable during SAR missions, reducing the risk of equipment failure that could jeopardize rescue efforts.\n\n" +
                        "7. Safety: Regular inspections and maintenance help prevent accidents and injuries caused by faulty equipment, ensuring the safety of SAR team members and those they are rescuing.\n\n" +
                        "8. Mission Success: Maintaining equipment readiness contributes to the overall success of SAR operations by minimizing disruptions and delays due to equipment malfunctions.\n\n" +
                        "9. Cost-Efficiency: Routine maintenance is cost-effective compared to replacing damaged or worn-out equipment. It extends the lifespan of equipment, saving resources in the long run.\n\n" +

                        "10. Professionalism: A well-maintained and organized equipment inventory reflects professionalism and commitment, instilling confidence in team members and stakeholders during SAR missions.\n\n",


                R.drawable.love2,
                "https://www.ukfrs.com/guidance/search/personal-protective-equipment-ppe-rescues",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Establish Search Protocols.",
                "Establishing search protocols is a critical foundation for effective search and rescue (SAR) operations. These protocols define the systematic procedures and guidelines that SAR teams follow when conducting searches. This guide outlines procedures for establishing search protocols and emphasizes their importance in achieving successful SAR outcomes.\n\n" +
                        "1. Risk Assessment: Begin by conducting a thorough risk assessment of the search area, considering factors like terrain, weather conditions, and potential hazards. This assessment helps determine the scope and approach of the search.\n\n" +
                        "2. Team Coordination: Establish clear lines of communication and coordination among SAR team members. Define roles and responsibilities for team leaders, searchers, navigators, and support personnel\n\n" +
                        "3. Search Area Definition: Define the boundaries and parameters of the search area based on available information, including the last known location of the missing person or the incident site.\n" +
                        "4. Search Methodology: Select and document the search methodology to be used, such as grid searches, line searches, or area searches. Ensure that team members understand and adhere to the chosen method.\n\n" +
                        "5. Resource Allocation: Determine the necessary resources, including personnel, equipment, and support, required for the search. Allocate resources effectively to cover the search area efficiently.\n\n" +
                        "6. Systematic Approach: Search protocols provide a systematic and organized approach to SAR missions, reducing the risk of overlooking critical areas or details during searches.\n\n" +
                        "7. Safety: Protocols prioritize the safety of SAR team members by providing guidelines for assessing and mitigating risks associated with the search area.\n\n" +
                        "8. Efficiency: By defining roles and responsibilities and specifying search methods, protocols enhance the efficiency of SAR operations, saving time and resources.\n\n" +
                        "9. Coordination: Clear protocols improve coordination and communication among team members, ensuring a cohesive and effective response to the situation.\n\n" +
                        "10. Accountability: Protocols establish a framework for accountability, helping SAR teams document their actions, findings, and decisions throughout the search process, which can be essential for debriefing and analysis.\n\n",

                R.drawable.love2,
                "https://safety4sea.com/emergency-procedures-how-search-and-rescue-works/",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Coordinate with Local Authorities.",

                "Effective coordination with local authorities is a fundamental aspect of successful search and rescue (SAR) operations. Collaboration between SAR teams and local government agencies is essential for optimizing resources, ensuring safety, and achieving efficient response to emergencies. This guide outlines procedures for coordinating with local authorities and underscores the importance of this partnership in SAR efforts.\n\n" +






                        "1. Establish Contact: Initiate communication with local authorities as soon as a SAR operation is initiated. Identify the relevant agencies, such as law enforcement, fire departments, emergency management, and municipal or county government.\n\n" +
                        "2. Share Information: Exchange critical information with local authorities, including the nature of the emergency, the search area, and any available details about missing persons or incident specifics.\n\n" +
                        "3. Request Permissions: Seek necessary permissions or approvals from local authorities to access private property or restricted areas within the search area. Ensure compliance with local laws and regulations.\n" +
                        "4. Resource Coordination: Collaborate with local authorities to coordinate resources, such as personnel, equipment, and transportation, to support SAR operations effectively.\n\n" +
                        "5. Incident Command: Establish clear lines of incident command and communication protocols between SAR teams and local authorities. Define roles and responsibilities to ensure seamless coordination during the operation.\n\n" +
                        "6. Resource Mobilization: Local authorities can provide additional resources and support, including manpower, specialized equipment, and logistical assistance, which are often crucial in SAR missions.\n\n" +
                        "7. Legal and Regulatory Compliance: Coordinating with local authorities ensures compliance with legal and regulatory requirements, such as search and rescue jurisdiction and property access rights.\n\n" +
                        "8. Safety: Collaboration with local authorities enhances safety by facilitating access to critical information, warnings about potential hazards, and guidance on safety protocols.\n\n" +
                        "9. Efficiency: Coordinated efforts result in more efficient SAR operations, as resources are allocated strategically, reducing redundancy and optimizing response times.\n\n" +
                        "10. Public Trust: Collaboration with local authorities fosters public trust by demonstrating a unified and organized response to emergencies, instilling confidence in the community's emergency response capabilities.\n\n",





                R.drawable.love2,
                "https://www.unisdr.org/campaign/resilientcities/home/article/essential-nine-ensure-effective-disaster-response.html",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Assign Team Leaders.",
                "Assigning team leaders is a crucial element in the organization and success of search and rescue (SAR) operations. Team leaders provide direction, coordination, and decision-making capabilities during emergencies. This guide outlines procedures for assigning team leaders and emphasizes their importance in ensuring effective SAR missions.\n\n" +

                        "1. Assess Leadership Skills: Identify team members with strong leadership qualities, including experience, communication skills, problem-solving abilities, and a calm demeanor under pressure.\n\n" +
                        "2. Role Definition: Clearly define the roles and responsibilities of team leaders, including decision-making authority, communication protocols, and their relationship with incident command.\n\n" +
                        "3. Appointment Process: Designate team leaders based on their qualifications, experience, and suitability for the specific SAR mission. Ensure that team leaders have the necessary training and certifications.\n" +
                        "4. Training and Briefing: Provide team leaders with specialized training in leadership, incident management, and SAR procedures. Conduct mission briefings to ensure they are well-informed about the operation's objectives and details.\n\n" +
                        "5. Continual Evaluation: Continually evaluate team leaders' performance during SAR operations and provide feedback for improvement. Rotate leadership roles periodically to provide growth opportunities.\n\n" +
                        "6. Clear Direction: Team leaders provide clear direction and decision-making authority during SAR missions, ensuring that tasks are executed efficiently and effectively.\n\n" +
                        "7. Coordination: Effective leadership fosters coordination among team members, improving overall teamwork and communication.\n\n" +
                        "8. Safety: Team leaders prioritize the safety of SAR team members by assessing risks, making informed decisions, and implementing safety protocols.\n\n" +
                        "9. Adaptability: Experienced team leaders can adapt to evolving situations and make real-time adjustments to SAR strategies, enhancing the chances of a successful outcome.\n\n" +
                        "10. Accountability: Assigning team leaders ensures accountability for actions and decisions made during SAR operations, which is essential for post-mission analysis and improvement.\n\n",





                R.drawable.love2,
                "https://www.nwcg.gov/ad-positions/srtl",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Conduct Damage Assessments ",
                "Conducting damage assessments is a critical step in the aftermath of disasters or emergencies. These assessments help evaluate the extent of damage to infrastructure, properties, and the environment, enabling authorities to make informed decisions regarding response and recovery efforts. This guide outlines procedures for conducting damage assessments and underscores the importance of this process in effective disaster management.\n\n" +


                        "1. Safety First: Prioritize safety for assessment teams by ensuring they have the necessary personal protective equipment (PPE) and are aware of potential hazards in the affected area.\n\n" +
                        "2. Assessment Team Formation: Assemble assessment teams comprising trained personnel with expertise in various fields, such as engineering, architecture, and environmental science\n\n" +
                        "3. Pre-Assessment Planning: Develop an assessment plan that outlines the objectives, data collection methods, and assessment areas. Assign specific teams or individuals to assess different types of damage.\n" +
                        "4. Field Data Collection: Deploy assessment teams to the affected areas to collect data on damage to buildings, infrastructure, utilities, and natural resources. Use standardized assessment forms to record findings.\n\n" +
                        "5. Damage Classification: Categorize the extent of damage into predefined levels (e.g., minor, moderate, severe) for each type of asset or area, based on established criteria and guidelines.\n\n" +
                        "6. Informed Decision-Making: Damage assessments provide accurate and timely information to decision-makers, allowing them to allocate resources and prioritize response efforts effectively.\n\n" +
                        "7. Resource Allocation: By assessing the extent of damage, authorities can allocate resources such as search and rescue teams, medical personnel, and equipment to areas with the greatest need.\n\n" +
                        "8. Rescue Prioritization: Damage assessments help prioritize rescue operations by identifying areas with the most significant structural damage or the highest concentration of affected individuals.\n\n" +
                        "9. Infrastructure Restoration: Assessments guide the restoration and repair of critical infrastructure, ensuring that essential services like water, electricity, and transportation are restored as quickly as possible.\n\n" +
                        "10. Resource Planning: Damage assessments aid in long-term resource planning for recovery and reconstruction efforts, including securing funding and support from government agencies and organizations.\n\n",





                R.drawable.love2,
                "https://slideplayer.com/slide/6949533/",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Prioritize Life-Saving Operations",
                "Prioritizing life-saving operations is a fundamental principle in emergency management and search and rescue (SAR) efforts. When responding to disasters or crises, it is essential to focus on activities that directly save lives and protect individuals from immediate harm. This guide outlines procedures for prioritizing life-saving operations and highlights the critical importance of this approach in emergency response.\n\n" +

                        "1. Initial Assessment: Begin by conducting an initial assessment of the emergency situation to identify immediate threats to human life, such as trapped individuals, injuries, or those in imminent danger.\n\n" +
                        "2. Triage: Implement a triage system to assess and categorize the injured or affected individuals based on the severity of their injuries or conditions. Prioritize treatment and evacuation accordingly.\n\n" +
                        "3. Resource Allocation: Allocate resources, including medical personnel, equipment, and first aid supplies, to address life-threatening situations first. Ensure that these resources are readily available and mobilized.\n" +
                        "4. Clear Communication: Maintain clear communication channels among SAR teams, medical responders, and incident command to coordinate life-saving efforts effectively.\n\n" +
                        "5. Evacuation Planning: Develop evacuation plans that prioritize the safe and rapid evacuation of individuals in immediate danger. Assign teams to assist with evacuations and provide medical care as needed.\n\n" +
                        "6. Maximize Lives Saved: Prioritizing life-saving operations ensures that resources and efforts are directed toward actions that have the greatest potential to save lives during the critical early stages of an emergency.\n\n" +
                        "7. Effective Resource Utilization: By focusing on immediate life-saving actions, resources are used efficiently, and response efforts are optimized to address the most urgent needs.\n\n" +
                        "8. Reduced Casualties: A swift and effective response to life-threatening situations can significantly reduce casualties and prevent the worsening of injuries or conditions.\n\n" +
                        "9. Public Confidence: Demonstrating a commitment to saving lives in emergencies builds public trust and confidence in the capabilities of emergency responders and authorities.\n\n" +
                        "10. Humanitarian Imperative: Prioritizing life-saving operations aligns with the humanitarian imperative to protect and preserve human life during times of crisis, reflecting a moral and ethical duty.\n\n",

                R.drawable.love2,
                "https://www.hobartcity.com.au/Council/News-publications-and-announcements/Latest-news/smoke-free-parks",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Share Information with the Public.",
                "Sharing information with the public is a fundamental component of effective emergency management and response. During crises, disseminating timely and accurate information to the public helps inform and guide individuals, enhances their safety, and builds trust in emergency response efforts. This guide outlines procedures for sharing information with the public and underscores the vital importance of transparent and accessible communication.\n\n" +


                        "1. Establish a Public Information Officer (PIO): Designate a trained Public Information Officer to serve as the official spokesperson and coordinator for public communication during emergencies.\n\n" +
                        "2. Assess Information Needs: Identify the information needs and preferences of the affected population, including languages spoken, accessibility requirements, and communication channels preferred (e.g., social media, radio, websites).\n\n" +
                        "3. Message Development: Create clear and concise messages that provide relevant information, including the nature of the emergency, safety instructions, evacuation routes, and contact information for authorities.\n" +
                        "4. Timely Updates: Provide regular updates to the public regarding the evolving situation, response efforts, and any changes in safety recommendations or instructions.\n\n" +
                        "5. Multichannel Communication: Utilize a variety of communication channels to reach a broad audience, including social media, websites, press releases, public address systems, and emergency alert systems.\n\n" +
                        "6. Safety: Timely and accurate information empowers the public to make informed decisions about their safety and well-being during emergencies, reducing the risk of harm.\n\n" +
                        "7. Mitigating Panic: Transparent communication helps mitigate panic and confusion by providing clear guidance and dispelling rumors or misinformation.\n\n" +
                        "8. Community Resilience: Informed communities are better prepared to respond to emergencies, take appropriate actions, and support one another during crises.\n\n" +
                        "9. Coordination: Public communication fosters coordination among responders, organizations, and agencies involved in emergency response, ensuring a unified and efficient effort.\n\n" +
                        "10. Accountability: Transparent communication holds authorities accountable for their actions and decisions during emergencies, fostering transparency and public scrutiny.\n\n",














                R.drawable.love2,
                "https://www.sciencedirect.com/science/article/pii/S0925753520302927",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Consider K-9 units for Search Operations.",
                "Considering K-9 units for search operations is a valuable strategy in enhancing the effectiveness of search and rescue (SAR) efforts. Specially trained dogs and their handlers play a crucial role in locating missing persons, detecting survivors in disaster scenarios, and assisting SAR teams in a variety of environments. This guide outlines procedures for incorporating K-9 units into search operations and emphasizes the importance of their unique capabilities.\n\n" +


                        "1.Needs Assessment: Begin by assessing the specific needs and requirements of the SAR operation, considering factors such as the terrain, type of search (wilderness, urban, disaster), and the expertise of available K-9 teams.\n\n" +
                        "2. Team Selection: Identify trained K-9 teams with the appropriate skills and certifications for the type of search needed. These teams consist of a handler and a search dog, such as a tracking dog or a cadaver dog.\n\n" +
                        "3. Training and Certification: Ensure that K-9 teams have undergone rigorous training and are certified for SAR operations. Training should cover search techniques, obedience, and the ability to work in various environments.\n" +
                        "4. Integration into SAR Teams: Integrate K-9 teams seamlessly into SAR operations, ensuring that they collaborate effectively with other searchers, communicate with incident command, and follow established search protocols.\n\n" +
                        "5. Safety Measures: Implement safety measures to protect the well-being of K-9 teams, including providing appropriate gear, monitoring their health, and addressing any environmental hazards.\n\n" +
                        "6. Enhanced Scent Detection: Dogs have an exceptional sense of smell, allowing them to detect scents from missing persons or disaster survivors that may be undetectable to humans or equipment.\n\n" +
                        "7.Speed and Efficiency: K-9 teams can cover large areas quickly, expediting search efforts and increasing the likelihood of locating missing individuals or victims.\n\n" +
                        "8. Versatility: K-9 units are versatile and can be deployed in various SAR scenarios, from locating lost hikers in the wilderness to finding disaster survivors in collapsed structures.\n\n" +
                        "9. Non-Invasive Search: Dogs provide a non-invasive method of search, reducing the risk of further harm to survivors or disturbing evidence in forensic searches.\n\n" +
                        "10. Team Collaboration: K-9 units enhance collaboration within SAR teams, working alongside human searchers and providing valuable support in locating individuals in challenging conditions.\n\n",








                R.drawable.love2,
                "https://www.corinthiansgroup.com/importance-of-k-9-units-in-security/",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
        )
        dataList.add(
            DataItem("Document and Report Findings.",
                "Documenting and reporting findings is a crucial step in search and rescue (SAR) operations and emergency response efforts. Accurate and detailed documentation ensures that critical information about the operation, including discoveries, conditions, and actions taken, is preserved for analysis, decision-making, and future reference. This guide outlines procedures for documenting and reporting findings and underscores the importance of this process in effective SAR operations.\n\n" +






                        "1. Record Keeping: Establish a systematic record-keeping system to document all aspects of the SAR operation. This includes mission objectives, team assignments, equipment use, and timelines.\n\n" +
                        "2. Field Notes: SAR team members should maintain field notebooks or digital devices to record observations, discoveries, locations, and any relevant details during search and rescue activities.\n\n" +
                        "3. Photographic Evidence: Capture photographs and videos as needed to document conditions, locations, evidence, and any findings related to the operation. Ensure that images are time-stamped and labeled appropriately.\n" +
                        "4. Sample Collection: If the situation requires it, collect samples or evidence following proper procedures. Label and document the collection process thoroughly, including chain of custody details.\n\n" +
                        "5. Incident Reports: Generate detailed incident reports that summarize the SAR operation, including objectives, actions taken, discoveries made, resources used, and any challenges encountered.\n\n" +
                        "6. Accountability: Documentation provides a clear and accountable record of actions taken during SAR operations, which is essential for assessing performance and decision-making.\n\n" +
                        "7. Lessons Learned: Analyzing documentation helps identify strengths, weaknesses, and areas for improvement in SAR procedures, leading to continuous improvement in emergency response.\n\n" +
                        "8. Legal and Regulatory Compliance: Proper documentation ensures compliance with legal and regulatory requirements, which may be essential for liability, insurance, or legal purposes.\n\n" +
                        "9. Resource Allocation: Reports on findings help incident commanders allocate resources effectively and make informed decisions regarding resource needs for ongoing or future SAR operations.\n\n" +
                        "10. Effective Communication: Documented findings facilitate communication with other response agencies, law enforcement, medical personnel, and affected individuals, ensuring that all stakeholders have access to critical information.\n\n",





                R.drawable.love2,
                "https://www.imo.org/en/OurWork/Safety/Pages/IMO-documents-relevant-to-SAR.aspx",
                "https://www.facebook.com/photo/?fbid=202035005941846&set=a.111221511689863")
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