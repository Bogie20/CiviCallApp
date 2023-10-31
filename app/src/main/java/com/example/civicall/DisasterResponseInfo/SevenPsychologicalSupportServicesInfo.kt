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

class SevenPsychologicalSupportServicesInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven_psychological_support_services_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(
            DataItem(
                "Equipping Mental Health Professionals for Effective Disaster Response",
                "\"Welcome, college students, to our exploration of 'Equipping Mental Health Professionals for Effective Disaster Response.' In these two sentences, we'll delve into the crucial role of psychologists and mental health experts in preparing for and responding to disasters, ensuring the well-being of affected individuals and communities.\n\n" +


                        "1. DISASTER MENTAL HEALTH TRAINING: Mental health professionals should undergo specialized training in disaster response to effectively support individuals and communities during and after disasters.\n\n" +
                        "2. REGISTRATION WITH RESPONSE ORGANIZATIONS: Psychologists should register with disaster response agencies in advance, ensuring they are part of the volunteer roster and can be deployed quickly when needed.\n\n" +
                        "3. COMMUNITY ENGAGEMENT: Participate in community disaster planning meetings, drills, and exercises to familiarize themselves with local disaster preparedness efforts.\n\n" +
                        "4. PSYCHOEDUCATIONAL PROGRAMMING: Offer psychoeducational programs to community groups on common mental health challenges that can arise months or years after a disaster.\n\n" +
                        "5. RESOURCE DISSEMINATION: Work with psychological associations to disseminate resources within communities, promoting community support and resilience building.\n\n" +
                        "6. PSYCHOLOGICAL FIRST AID (PFA): Provide Psychological First Aid (PFA) to disaster survivors, focusing on promoting safety, stabilization, and connecting individuals to appropriate resources.\n\n" +
                        "7. VIRTUAL VOLUNTEERING: Offer mental health support remotely through phone and web-based efforts, ensuring mental health providers screen potential volunteers for fit.\n\n" +
                        "8. EXPERTISE FOR MEDIA: Serve as an expert for local media, providing insights into the psychological aspects of disasters and their impact on communities.\n\n" +
                        "9. RESOURCE DEVELOPMENT: Collaborate with state or territorial psychological associations to develop resources on disaster preparedness and trauma coping strategies.\n\n" +
                        "10. RESILIENCE ENHANCEMENT: Help survivors and response workers enhance their resilience skills, empowering them to cope with the psychological impact of disasters effectively.\n\n",

                "https://www.apa.org/images/disaster-mental-health-tile_tcm7-319090.jpg",
                "https://www.apa.org/topics/disasters-response/disaster-mental-health-psychologists"
            )
        )
        dataList.add(
            DataItem("Healing Communities: Transforming Care Through Trauma-Informed Principles",
                "Welcome to the exploration of \"Healing Communities: Transforming Care Through Trauma-Informed Principles.\" In the aftermath of natural disasters, such as wildfires in rural areas, and amidst the challenges of addressing trauma, healthcare providers, educators, and communities are embracing trauma-informed care to facilitate healing and resilience.\n\n" +
                        "1. NEEDS ASSESSMENT: Conduct a comprehensive assessment of trauma needs within communities, including the impact of natural disasters, to identify vulnerable populations and specific trauma-related issues.\n\n" +
                        "2. ESTABLISHING TRAUMA-INFORMED EDUCATION: Implement trauma-informed education programs in schools, workplaces, and community organizations to raise awareness and provide tools for recognizing and addressing trauma.\n\n" +
                        "3. INTERDISCIPLINARY COLLABORATION: Foster collaboration among healthcare providers, educators, social services, and community organizations to create a network of support for individuals affected by trauma.\n\n" +
                        "4. PROMOTING TRAUMA-INFORMED CARE IN HEALTHCARE FACILITIES: Integrate trauma-informed care practices within healthcare facilities, ensuring that all staff, from receptionists to clinicians, are trained in recognizing and responding to trauma.\n\n" +
                        "5. TELEHEALTH FOR TRAUMA SUPPORT: Utilize telehealth services to expand access to trauma-informed care in remote or underserved areas, offering support to individuals who may not have easy access to in-person services.\n\n" +
                        "6. TRAUMA SCREENING TOOLS: Implement evidence-based trauma screening tools in healthcare settings to identify trauma exposure and its effects on physical and mental health.\n\n" +
                        "7. COMMUNITY-WIDE TRAUMA AWARENESS CAMPAIGNS: Launch public awareness campaigns to reduce the stigma associated with trauma and promote community-wide understanding and support.\n\n" +
                        "8. TRAUMA-INFORMED LAW ENFORCEMENT: Collaborate with law enforcement agencies to implement trauma-informed policing practices, including \"Handle With Care\" initiatives to support children exposed to trauma.\n\n" +
                        "9. SELF-CARE FOR HEALTHCARE PROVIDERS: Develop self-care programs and support mechanisms for healthcare providers to prevent burnout and secondary trauma, ensuring they can continue to offer trauma-informed care effectively.\n\n" +
                        "10. CONTINUOUS TRAINING AND EVALUATION: Regularly update and assess trauma-informed care practices, incorporating the latest research and feedback from communities to enhance the quality of care provided.\n\n",

                "https://www.ruralhealthinfo.org/rural-monitor/wp-content/uploads/2019/04/gilmartin-bird.jpg",
                "https://www.ruralhealthinfo.org/rural-monitor/trauma-informed-care"
              )
        )
        dataList.add(
            DataItem("Building Resilience: Strengthening Crisis Counseling and Disaster Response",
                "Within the domain of disaster response and crisis counseling, the imperative to \"Building Resilience: Strengthening Crisis Counseling and Disaster Response\" assumes paramount significance. This comprehensive guide is dedicated to exploring the strategies, techniques, and support mechanisms essential for augmenting resilience in the context of traumatic events. By doing so, it sets the stage for the establishment of more effective crisis counseling centers and disaster response initiatives.\n\n" +
                        "1. COMPREHENSIVE TRAINING PROGRAMS: Develop and implement comprehensive training programs for crisis counseling and disaster response teams, equipping them with the skills and knowledge necessary to provide effective support in the aftermath of traumatic events.\n\n" +
                        "2. COMMUNITY NEEDS ASSESSMENT: Conduct thorough community needs assessments to identify vulnerabilities, gaps in services, and specific challenges faced by disaster-affected populations, enabling tailored response efforts.\n\n" +
                        "3. CRISIS COUNSELING CENTERS ESTABLISHMENT: Establish dedicated crisis counseling centers strategically located within disaster-prone regions, providing accessible and specialized support for individuals and communities in distress.\n\n" +
                        "4. INTERDISCIPLINARY COLLABORATION: Foster interdisciplinary collaboration among healthcare providers, mental health experts, social workers, and community organizations to create a network of comprehensive care and support.\n\n" +
                        "5. TRAUMA-INFORMED CARE INTEGRATION: Integrate trauma-informed care principles into all aspects of crisis counseling and disaster response, ensuring that all responders are equipped to recognize and address trauma effectively.\n\n" +
                        "6. PSYCHOLOGICAL FIRST AID (PFA): Implement Psychological First Aid (PFA) as a standard practice, equipping responders with the skills to provide immediate emotional support to survivors and help them regain a sense of control and safety.\n\n" +
                        "7. RESILIENCE-BUILDING WORKSHOPS: Conduct resilience-building workshops and programs within communities, empowering individuals with coping strategies and psychological tools to enhance their resilience in the face of adversity.\n\n" +
                        "8. COMMUNITY OUTREACH AND EDUCATION: Launch community outreach and education campaigns to reduce stigma associated with seeking help, raising awareness about available crisis counseling services, and promoting mental well-being.\n\n" +
                        "9. SUPERVISION AND SELF-CARE: Provide ongoing supervision and support for crisis counselors, emphasizing self-care practices to prevent burnout and compassion fatigue, ensuring their sustained effectiveness.\n\n" +
                        "10. CONTINUOUS EVALUATION AND IMPROVEMENT: Establish mechanisms for continuous evaluation and improvement of crisis counseling and disaster response efforts, incorporating feedback from survivors and communities to enhance the quality of services provided.\n\n",
                "https://www.samhsa.gov/sites/default/files/dtac-banner.jpg",
                "https://www.samhsa.gov/dtac/disaster-response-template-toolkit/disaster-responder-stress-management"
            )
        )
        dataList.add(
            DataItem("Building Resilience Through Community Unity: Lessons from Disaster Response.",
                "In the realm of disaster response and resilience-building, the essence of \"Building Resilience Through Community Unity: Lessons from Disaster Response\" takes center stage. This comprehensive exploration delves into the pivotal role of community unity in fostering resilience, drawing insights from real-world experiences to shed light on effective disaster response strategies.\n\n" +

                        "IMPORTANCE OF LESSONS:\n\n" +
                        "1. EMPOWER COMMUNITY-BASED ORGANIZATIONS: Strengthening and empowering community-based organizations enhances their capacity to serve as vital hubs for social capital development, resource coordination, and community resilience.\n\n" +
                        "2. PRE-DISASTER ORGANIZATION: Emphasizing pre-disaster social organization, planning, and relationship-building contributes significantly to post-disaster preparedness, fostering more effective and coordinated response efforts.\n\n" +
                        "3. COLLABORATIVE NETWORKS: Partnerships between faith-based organizations, universities, and communities create collaborative networks that expand access to essential resources and expertise, strengthening overall resilience.\n\n" +
                        "4. STRATEGIC SOCIAL CAPITAL UTILIZATION: Deliberately leveraging social capital aligns its potential with disaster resilience goals, optimizing its role in supporting communities during crises.\n\n" +
                        "5. BONDING SOCIAL CAPITAL: Promoting community gatherings and events that cultivate bonding social capital fosters community unity and solidarity, essential foundations for collective disaster response and recovery.\n\n" +

                        "PROCEDURES:\n\n" +
                        "1. NEEDS ASSESSMENT: Conduct a comprehensive needs assessment to identify areas and communities most vulnerable to typhoons, earthquakes, and other natural disasters.\n\n" +
                        "2. PROJECT FUNDING ALLOCATION: Allocate funding for addressing climate-related disasters, including typhoons, based on the identified needs and priorities of communities.\n\n" +
                        "3. DISASTER-RESILIENT INITIATIVES: Implement disaster-resilient initiatives in urban areas, addressing institutional and investment gaps in disaster preparedness and response.\n\n" +
                        "4. CLIMATE RESILIENCE INTEGRATION: Develop and implement strategies to integrate climate resilience into national and regional development planning, aligning policies with disaster risk reduction.\n\n" +
                        "5. WATERSHED RESILIENCE PROMOTION: Execute projects in critical watersheds to promote climate resilience, emphasizing green growth measures and ecosystem restoration.\n\n",

                "https://hazards.colorado.edu/uploads/freeform/option1.jpeg",
                "https://hazards.colorado.edu/news/research-counts/unity-is-strength-community-resilience-in-puerto-rico-after-hurricane-maria"
              )
        )

        dataList.add(
            DataItem("Nurturing Resilience: Delivering Children's Mental Health Services in Disaster Response",
                "Amidst the complexities of disaster response and the intricate web of challenges it presents, the well-being and mental health of children and adolescents stand out as crucial concerns.\n\n" +
                        "1. NEEDS ASSESSMENT AND SCREENING: Begin with a thorough assessment to identify children and adolescents who may require mental health support. Screen for trauma-related symptoms and emotional distress.\n\n" +
                        "2. EMERGENCY PREPAREDNESS TRAINING: Equip mental health professionals with specialized training in disaster response and trauma-informed care to effectively address the unique needs of young individuals.\n\n" +
                        "3. ESTABLISH SAFE SPACES: Create safe, child-friendly environments where children and teens can express their thoughts and emotions freely without fear or judgment.\n\n" +
                        "4. PSYCHOLOGICAL FIRST AID (PFA): Implement Psychological First Aid protocols to provide immediate emotional support, comfort, and stabilization to children and adolescents affected by disasters.\n\n" +
                        "5. TRAUMA-INFORMED COUNSELING: Offer trauma-focused counseling and therapy, tailoring interventions to the developmental stages and individual needs of each child or teen.\n\n" +
                        "6. PSYCHOEDUCATION PROGRAMS: Develop educational programs to help children and adolescents understand their emotional responses to disasters, coping strategies, and the importance of seeking help when needed.\n\n" +
                        "7. SUPPORT FOR PARENTS AND CAREGIVERS: Provide guidance and resources for parents and caregivers to help them support their children's mental health during and after disasters.\n\n" +
                        "8. COMMUNITY OUTREACH: Collaborate with community organizations and schools to reach children who may not have immediate access to mental health services and offer support within their familiar environments.\n\n" +
                        "9. PEER SUPPORT GROUPS: Facilitate peer support groups to allow children and adolescents to connect with their peers, share experiences, and learn from one another in a supportive setting.\n\n" +
                        "10. CONTINUOUS EVALUATION AND RESEARCH: Continuously assess the effectiveness of mental health services, gather feedback from children and their families, and contribute to research on best practices for children's mental health in disaster response.\n\n",

                "https://www.unicef.org/drcongo/sites/unicef.org.drcongo/files/styles/hero_tablet/public/PETRONIE%202.jpg?itok=RNbl1uS7",
                "https://www.samhsa.gov/dtac/disaster-survivors/children-and-disaster"
            )
        )
        dataList.add(
            DataItem("REVITALIZING RESCUERS: PROMOTING SELF-CARE IN DISASTER RESPONSE.",
                "In the challenging realm of disaster response, the mental and emotional resilience of emergency responders is paramount. \"Revitalizing Rescuers: Promoting Self-Care in Disaster Response\" explores crucial self-care strategies to sustain the well-being and effectiveness of these dedicated professionals.\n\n" +


                        "1. PREPARATION AND ROLE CLARITY: Prior to deployment, ensure responders have a clear understanding of their roles and responsibilities, reducing uncertainty and stress during the mission.\n\n" +
                        "2. Effective Communication: Establish open channels for communication among responders, enabling them to share experiences, feelings, and concerns with peers, supervisors, and support networks.\n\n" +
                        "3. BUDDY SYSTEM: Implement a buddy system where responders partner to monitor each other's stress levels, workload, and safety, providing emotional support and encouragement.\n\n" +
                        "4. SCHEDULED BREAKS: Enforce limited working hours with shifts no longer than 12 hours, ensuring responders have regular opportunities for rest and recuperation.\n\n" +
                        "5. JOURNALING: Encourage responders to maintain a journal to process their experiences, thoughts, and emotions, offering an outlet for reflection and catharsis.\n\n" +
                        "6. SOCIAL SUPPORT: Promote open conversations about feelings and experiences with family, friends, supervisors, and teammates, creating a network of emotional support.\n\n" +
                        "7. STRESS MANAGEMENT: Teach and practice stress reduction techniques, including deep breathing, relaxation exercises, and physical activity, to cope with high-pressure situations.\n\n" +
                        "8. BALANCED LIFESTYLE: Emphasize maintaining a balanced lifestyle with adequate sleep, nutrition, and exercise, supporting overall physical and mental health.\n\n" +
                        "9. SETTING BOUNDARIES: Remind responders that it's acceptable to set boundaries and say 'no' when necessary, preventing burnout and exhaustion.\n\n" +
                        "10. CAFFEINE AND ALCOHOL AWARENESS: Advise responders to limit caffeine intake and avoid excessive alcohol use, as these substances can exacerbate stress and disrupt sleep patterns.\n\n",

                "https://www.sane.org/media/k2/items/cache/f8680441f99906edbba69bc4df69b57e_XL.jpg",
                "https://emergency.cdc.gov/coping/responders.asp"
              )
        )
        dataList.add(
            DataItem("Healing Beyond the Horizons: Addressing Post-Disaster Stressors in Response Efforts",
                "In a world where disasters are an enduring reality, their consequences reverberating through the lives of individuals, communities, and economies, the imperative of disaster resilience remains paramount. While disaster preparedness, response, and recovery plans strive to bolster resilience, they often neglect a critical factor in long-term disaster impact—stress. Stress, whether acute, chronic, or cumulative, can lead to a host of adverse health effects, ranging from mental health disorders to physical ailments. \n\n" +
                        "1. STRENGTHEN EXISTING HEALTH PROGRAMS: Enhance disaster behavioral and physical health programs to effectively address, coordinate, and allocate resources for stress reduction, relief, and treatment in disaster planning and response.\n\n" +
                        "2. COLLECT HEALTH-RELATED DATA: Prioritize the pre- and post-disaster collection of relevant biomarker and health-related data. This data will serve as a baseline for assessing health status in the aftermath of disasters and inform ongoing monitoring efforts.\n\n" +
                        "3. EMPOWER EARLY RESPONDERS: Build the capacity of science and public health early-responders to identify and address stress-related health issues promptly.\n\n" +
                        "4. LEVERAGE NATURAL INFRASTRUCTURE: Utilize natural infrastructure to minimize disaster damage, thereby reducing stressors on affected communities.\n\n" +
                        "5. INCORPORATE DISPLACEMENT: Expand the geographical scope of disaster response and relief efforts to effectively address the displacement of affected individuals and communities.\n\n" +
                        "6. NATURE-BASED TREATMENT: Integrate nature-based treatment approaches to alleviate pre- and post-disaster stress effects on health, recognizing the therapeutic value of natural environments.\n\n" +
                        "7. REVIEW POLICIES AND REGULATIONS: Conduct a comprehensive review of disaster laws, policies, and regulations to identify opportunities for strengthening public health preparedness and responses, including addressing stress-related impacts and engaging affected communities.\n\n" +
                        "8. COMMUNITY PARTICIPATION: Foster community participation in developing equitable processes for damage assessments, litigation, payments, and housing in the pre-disaster phase.\n\n" +
                        "9. MONITOR HEALTH INDICATORS: Implement ongoing monitoring of relevant health indicators to assess recovery and resilience-building progress.\n\n" +
                        "10. PROMOTE MENTAL AND SOCIAL WELL-BEING: Prioritize strategies that promote mental and social well-being as integral components of disaster resilience.\n\n",

                "https://www.ready.gov/sites/default/files/Coping%20with%20Disaster%201.7.4.0%20Tab%203%20of%204_0.jpg",
                "https://www.frontiersin.org/articles/10.3389/fpubh.2018.00373/full"
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