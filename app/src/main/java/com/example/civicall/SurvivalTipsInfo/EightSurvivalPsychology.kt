package com.example.civicall.SurvivalTipsInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class EightSurvivalPsychology : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight_survival_psychology_info)




        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "COPING WITH TRAUMA AND LOSS",
                "Recovery Through Resilience: Post-Disaster Counseling and Healing Workshops. Discover the power of healing and renewal in the aftermath of trauma and loss. Explore the world of post-disaster counseling and transformative workshops as we navigate the path to recovery.\"\"\n\n" +
                        "1. ASSESSMENT AND NEEDS IDENTIFICATION: Begin by assessing the emotional and psychological needs of survivors to determine the most effective counseling approach.\n\n" +
                        "2. ESTABLISHING SAFE SPACES: Create safe and welcoming environments where survivors can freely express their emotions and experiences without judgment.\n\n" +
                        "3. PSYCHOLOGICAL FIRST AID: Provide immediate psychological support to address acute stress and emotional turmoil in the aftermath of a disaster.\n\n" +
                        "4. INDIVIDUAL AND GROUP COUNSELING: Offer both one-on-one counseling sessions and group therapy to accommodate varying comfort levels and needs.\n\n" +
                        "5. TRAUMA-INFORMED CARE: Train counselors and workshop facilitators in trauma-informed approaches, ensuring sensitivity to survivors' experiences.\n\n" +
                        "6. ART THERAPY AND EXPRESSIVE ARTS: Utilize creative outlets like art, music, and drama to help survivors process their emotions and experiences.\n\n" +
                        "7. MINDFULNESS AND RELAXATION TECHNIQUES: Teach relaxation methods and mindfulness practices to help survivors manage anxiety and stress.\n\n" +
                        "8. CRISIS RESPONSE WORKSHOPS: Conduct workshops on crisis management, equipping survivors with coping skills and strategies to deal with ongoing challenges.\n\n" +
                        "9. REINTEGRATION AND COMMUNITY SUPPORT: Assist survivors in reintegrating into their communities and provide information on local support resources.\n\n" +
                        "10. MONITORING AND FOLLOW-UP: Maintain contact with survivors over time to ensure their ongoing well-being and provide additional support as needed.",

                "https://go.rappler.com/images/typhoon-yolanda-red-cross-volunteers-20131126-001.jpg",
                "https://www.samhsa.gov/find-help/disaster-distress-helpline/coping-tips"

            )
        )
        dataList.add(
            DataItem("CULTURAL RESILIENCE PRACTICES",
                "\"Unlocking the Power of Indigenous Traditions: Harnessing Cultural Resilience for Healing and Well-Being. In the rich tapestry of Indigenous spirituality and cultural practices lies a profound source of resilience, offering hope and restoration in the face of adversity.\n\n" +
                        "1. CULTURAL IMMERSION WORKSHOPS: Organize immersive workshops that allow participants to deeply engage with Indigenous cultures, learn about their rituals, and understand the significance of these traditions in fostering resilience.\n\n" +
                        "2. ELDERS' WISDOM CIRCLES: Facilitate intergenerational knowledge sharing by creating spaces where Indigenous elders pass down their cultural wisdom, rituals, and resilience traditions to younger community members.\n\n" +
                        "3. TRADITIONAL HEALING CEREMONIES: Incorporate traditional healing ceremonies into therapeutic practices to promote physical, emotional, and spiritual well-being, drawing from Indigenous rituals that have been used for generations.\n\n" +
                        "4. STORYTELLING AND ORAL TRADITION: Encourage the preservation of resilience stories through storytelling and oral tradition, allowing community members to share their experiences of overcoming challenges using cultural practices.\n\n" +
                        "5. CONNECTION TO THE LAND: Emphasize the importance of the connection between Indigenous communities and their ancestral lands, highlighting the role of the land in fostering resilience and well-being.\n\n" +
                        "6. CULTURAL RECLAMATION WORKSHOPS: Offer programs that help community members reconnect with their roots, languages, and cultural practices, empowering them to rebuild their resilience through cultural reclamation.\n\n" +
                        "7. ARTISTIC EXPRESSION: Provide platforms for artistic expression that incorporate Indigenous art forms, such as dance, music, and visual arts, as a means of self-expression and healing.\n\n" +
                        "8. SACRED MEDICINAL PLANT KNOWLEDGE: Share knowledge of sacred plants and their use in Indigenous rituals and healing practices, emphasizing the holistic benefits for mental and physical health.\n\n" +
                        "9. COMMUNITY BUILDING THROUGH RITUALS: Encourage the practice of communal rituals and ceremonies that strengthen social bonds and provide emotional support during challenging times.\n\n" +
                        "10. RESILIENCE ASSESSMENT: Develop culturally sensitive tools for assessing the impact of Indigenous rituals and resilience traditions on the well-being of individuals and communities, allowing for continuous improvement and adaptation.",

                "https://www.yesmagazine.org/wp-content/uploads/2020/04/1.-healing-the-soul-indigenous-leaders-resilience.jpg",
                "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC2956755/"
              )
        )
        dataList.add(
            DataItem("COMMUNITY SUPPORT SYSTEMS",
                "In the spirit of community resilience, we delve into the core of \"Community Support Systems: Barangay-Based Disaster Preparedness.\" Here, amidst flood-prone barangays, we explore the role of Barangay Disaster Risk Reduction and Management Committees (BDRRMCs) in bolstering our defenses against the forces of nature.\n\n" +
                        "1. RISK ASSESSMENT: Conduct regular assessments to identify potential hazards, their impact, and vulnerability of the community.\n\n" +
                        "2. DEVELOPMENT OF COMPREHENSIVE PLANS: Create well-structured disaster preparedness plans that cover mitigation, response, and recovery strategies.\n\n" +
                        "3. PUBLIC AWARENESS AND EDUCATION: Implement educational programs to raise community awareness and ensure that residents know how to respond during disasters.\n\n" +
                        "4. EARLY WARNING SYSTEMS: Establish efficient early warning systems for timely notification of potential disasters.\n\n" +
                        "5. COMMUNITY DRILLS AND TRAINING: Organize frequent disaster drills and training sessions to familiarize residents with emergency procedures.\n\n" +
                        "6. RESOURCE ALLOCATION: Allocate resources, including manpower and financial means, to support disaster preparedness and response initiatives.\n\n" +
                        "7. COORDINATION WITH LOCAL AUTHORITIES: Collaborate closely with local government and relevant authorities to ensure a unified and well-coordinated disaster management approach.\n\n" +
                        "8. COMMUNICATION AND REPORTING: Develop a communication strategy to facilitate swift information dissemination during emergencies and ensure the reporting of incidents.\n\n" +
                        "9. PARTNERSHIP BUILDING: Forge partnerships with local organizations, businesses, and NGOs to enhance support systems for disaster preparedness.\n\n" +
                        "10. RECOVERY AND REHABILITATION PLANS: Develop post-disaster recovery and rehabilitation plans that focus on rebuilding a resilient community.\n\n",

                "https://tvird.com.ph/wp-content/uploads/AMVI-Disaster-Preparedness-Training_1.jpg",
                "https://www.scirp.org/journal/paperinformation.aspx?paperid=77520"
              )
        )

        dataList.add(
            DataItem("STORYTELLING FOR COMFORT AND UNITY",
                "\"In the aftermath of Typhoon Haiyan, stories of survival serve as resilient threads weaving communities together. Through compelling oral narratives, families like the Wynns and Abapos find solace and create a testament to strength in the face of nature's fury.\"\n\n\n" +
                        "1. IDENTIFY KEY NARRATORS: Identify individuals or families with firsthand experiences of survival in the aftermath of natural disasters like Typhoon Haiyan.\n\n" +
                        "2. INTERVIEW PREPARATION: Develop a set of structured questions and topics to guide the interviews. Questions should encourage narrators to share their experiences, emotions, and the challenges they faced.\n\n" +
                        "3. RECORDING EQUIPMENT: Ensure access to recording equipment, whether it's audio or video recording devices. Ensure they are functional and have sufficient battery life and storage capacity.\n\n" +
                        "4. CONSENT AND PRIVACY: Obtain informed consent from the narrators, explaining the purpose of the interviews and how the stories will be used. Respect their privacy and preferences for anonymity.\n\n" +
                        "5. CONDUCT INTERVIEWS: Conduct interviews with the narrators, allowing them to share their stories in their own words. Encourage them to provide details about their experiences, emotions, and coping strategies.\n\n" +
                        "6. TRANSCRIPTION AND TRANSLATION: Transcribe the interviews accurately, and if necessary, translate them into the desired language for wider dissemination.\n\n" +
                        "7. VERIFICATION AND FACT-CHECKING: Verify the details of the narratives as much as possible to ensure accuracy and authenticity.\n\n" +
                        "8. ARCHIVING AND DOCUMENTATION: Store the collected oral histories in a secure and organized manner, making them easily accessible for researchers, historians, and future generations.\n\n" +
                        "9. NARRATIVE SHARING: Share these narratives through various channels, such as local publications, community meetings, online platforms, and social media, in line with the narrator's preferences and consent.\n\n" +
                        "10. COMMUNITY ENGAGEMENT: Engage the community in discussions and storytelling events, where narratives of survival can be shared and discussed to promote comfort and unity among community members.\n",

                "https://peace.gov.ph/wp-content/uploads/2016/11/Agusan-Storytelling-2.jpg",
                "https://www.jacksonville.com/story/news/2013/12/01/relatives-share-typhoon-survival-stories-philippines/15807393007/"
            )
        )

        dataList.add(
            DataItem("SPIRITUAL AND EMOTIONAL WELL-BEING",
                "Amidst the complexities of life, faith and belief systems have always been guiding lights for communities worldwide. In examining the profound impact of spirituality on emotional and spiritual well-being, we embark on a captivating journey through the lens of the Filipino people's unwavering faith, illustrating its role as a pillar of resilience.\"\n\n\n" +
                        "1. LITERATURE REVIEW: Initiate a comprehensive review of existing research and literature to understand the multifaceted relationship between faith and emotional well-being across diverse cultures.\n\n" +
                        "2. DATA COLLECTION: Collect qualitative and quantitative data through interviews, surveys, and observations to explore how faith and belief systems shape emotional and spiritual well-being in specific communities.\n\n" +
                        "3. COMMUNITY ENGAGEMENT: Establish connections with diverse communities to gain insights into their unique faith-based practices and the impact on their emotional and spiritual health.\n\n" +
                        "4. CULTURAL ANALYSIS: Dive into the cultural dimensions that influence the expression of faith and belief systems, uncovering the intersections with emotional and spiritual well-being.\n\n" +
                        "5. QUANTITATIVE ASSESSMENT: Develop measures to quantify the influence of faith on emotional well-being, considering factors like stress reduction, resilience, and overall life satisfaction.\n\n" +
                        "6. QUALITATIVE EXPLORATION: Conduct in-depth qualitative research to capture personal narratives and stories that showcase the emotional and spiritual significance of faith and belief systems.\n\n" +
                        "7. COMPARATIVE STUDY: Compare and contrast different faiths and belief systems within specific cultural contexts to analyze their unique contributions to emotional well-being.\n\n" +
                        "8. PSYCHOLOGICAL ANALYSIS: Collaborate with psychologists and experts in mental health to delve into the psychological mechanisms through which faith influences emotional and spiritual well-being.\n\n" +
                        "9. COMMUNITY INITIATIVES: Investigate faith-based community initiatives, such as support groups and counseling services, that play a role in enhancing emotional and spiritual health.\n\n" +
                        "10. RECOMMENDATIONS: Conclude the study with recommendations for promoting the positive impact of faith and belief systems on emotional and spiritual well-being, while addressing potential challenges or conflicts.",

                "https://images.squarespace-cdn.com/content/v1/596c0cd63e00beb869b40668/1554918484818-OEE5YTVDQWM5OJT030SG/ben-white-139141-unsplash.jpg?format=1500w",
                "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC7989222/"
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