package com.example.civicall.EnvironmentalandSocialIssueInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class BreakingtheChainsInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakingthe_chains_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "HUMAN TRAFFICKING ISSUES AND VULNERABLE POPULATIONS",
                "In the fight against human trafficking, the Philippines has made strides but still faces challenges. This article explores the country's efforts to combat human trafficking and its impact on vulnerable populations.\"\n\n" +
                        "1. TIER 1 STATUS: The Philippines maintains its Tier 1 status in the US Trafficking in Persons Report for the eighth consecutive year, indicating compliance with minimum requirements in combating human trafficking.\n\n" +
                        "2. INVESTIGATION GAPS: Despite Tier 1 status, the US State Department notes that the Philippines has not vigorously investigated or prosecuted labor trafficking crimes within its borders.\n\n" +
                        "3. ANTI-TRAFFICKING EFFORTS: The Philippines receives praise for investigating more trafficking victims, amending its anti-trafficking law, and increasing funding to combat human trafficking.\n\n" +
                        "4. REDUCED VICTIM IDENTIFICATION: The government of the Philippines identified fewer trafficking victims, a concerning trend.\n\n" +
                        "5. CORRUPTION CONCERNS: The report highlights ongoing concerns about corruption and official complicity in trafficking crimes within the country.\n\n" +
                        "6. CRYPTOCURRENCY SCAM HUBS: The 2023 Trafficking in Persons Report underscores the rise of cryptocurrency scam hubs, where Filipinos are lured into working under false pretenses in other Southeast Asian countries.\n\n" +
                        "7. SENATE INVESTIGATION: The Philippine Senate initiated an investigation into cryptocurrency scam hubs following reports of exploitation of Filipino workers.\n\n" +
                        "8. EXPLOITATIVE PRACTICES: Testimonies reveal the extent of exploitation, including extortionate fees to Philippine immigration and collusion at the Manila airport.\n\n" +
                        "9. FOREIGN VICTIMS: Thousands of individuals, including foreigners from Indonesia, China, Vietnam, and Malaysia, have been victims of trafficking within the Philippines.\n\n" +
                        "10. INTERNATIONAL PERSPECTIVE: The report emphasizes that even Tier 1 countries like the Philippines face challenges, underlining the need for continuous improvements and recommendations to address human trafficking effectively.\n",

                "https://www.rappler.com/tachyon/2023/01/human-trafficking-migrant-workers-senate-hearing-january-25-2023-001.jpg?resize=1400%2C933&zoom=1",
                "https://www.rappler.com/nation/philippines-yet-to-vigorously-investigate-prosecute-labor-trafficking-us-state-department/"
            )
        )
        dataList.add(
            DataItem("EFFORTS TO COMBAT TRAFFICKING AND EXPLOITATION",
                "In the battle against human trafficking, innovative solutions and revised guidelines emerge, aiming to combat exploitation while sparing travelers from excessive paperwork. Explore the evolving efforts to combat trafficking and their impact on the travel experience.\n\n" +
                        "1. REVISED TRAVEL GUIDELINES: The Inter-Agency Council Against Trafficking (IACAT) in the Philippines releases revised travel guidelines aimed at combating human trafficking, taking effect on September 3, 2023.\n" +
                        "2. PUBLIC CONCERNS: Filipino travelers express concerns about increased document requirements for travel, fearing longer lines at airports.\n" +
                        "3. DEPARTMENT OF JUSTICE CLARIFICATION: The Department of Justice (DOJ) clarifies that the revised guidelines will mainly apply to first-time travelers who may be profiled as potential workers abroad.\n" +
                        "4. STREAMLINED REQUIREMENTS: The IACAT's revised guidelines streamline travel requirements into categories of travelers, emphasizing that many travelers would only need to present basic documents.\n" +
                        "5. REACTIONS ON SOCIAL MEDIA: Social media users suggest alternatives for combating human trafficking, such as reallocating funds from non-security agencies and providing better training to immigration officers.\n" +
                        "6. POTENTIAL MISUSE: Concerns arise that the revised guidelines could be misused to harass government critics and lead to power trips by immigration officers.\n" +
                        "7. BUREAU OF IMMIGRATION'S ASSURANCE: The Bureau of Immigration (BI) reassures tourists that there are no new policies for departing travelers and that the guidelines are merely a streamlined version of existing procedures.\n" +
                        "8. BETTER IMMIGRATION OFFICER TRAINING: Some suggest that immigration authorities should receive proper training to distinguish first-time travelers from potential trafficking victims, reducing the need for excessive documentation.\n" +
                        "9. AIRPORT IMPROVEMENTS: Calls for improving the country's airports are made, given that the Ninoy Aquino International Airport (NAIA) has faced criticism for its stressful environment and queuing times.\n" +
                        "10. CHALLENGES IN SECURING DOCUMENTS: Travelers share challenges in obtaining required documents to prove their financial capability for international travel, emphasizing the need to be well-prepared when facing immigration procedures.\n",

                "https://media.philstar.com/photos/2023/05/28/jpeg-optimizerimg5277jpeg_2023-05-28_18-57-30.jpg",
                "https://www.rappler.com/nation/filipinos-online-reaction-revised-guidelines-immigration-fight-human-trafficking/"
               )
        )
        dataList.add(
            DataItem("REHABILITATION AND SUPPORT FOR SURVIVORS",
                "In the pursuit of sustainable forest management, the Philippines has undertaken a transformative journey. Through its National Greening Program, the nation is rejuvenating degraded forests, expanding forest cover, and fostering environmental resilience.\"\n\n" +
                        "1. SAFE HAVENS FOR SURVIVOR HEALING: Love146 operates two safe homes in the Philippines, dedicated to providing holistic care for child trafficking survivors.\n" +
                        "2. HEALING THROUGH THERAPEUTIC ACTIVITIES: These safe homes offer therapy sessions, counseling, and creative activities such as art, music, and gardening to support survivors in their journey to recovery.\n" +
                        "3. EDUCATIONAL OPPORTUNITIES: Children at the safe homes receive education and skill-building opportunities, fostering their personal growth and development.\n" +
                        "4. PHYSICAL AND PSYCHOLOGICAL SAFETY: Love146 prioritizes both the physical and psychological safety of survivors, creating an environment where they can feel protected and secure.\n" +
                        "5. EMOTIONAL WELL-BEING: Regular counseling and a supportive atmosphere help survivors cope with their emotional traumas and build resilience.\n" +
                        "6. EXPRESSION AND ENERGY RELEASE: Survivors are encouraged to express themselves through art and music, providing them with positive outlets for their energy.\n" +
                        "7. AFFIRMATION AND PRAISE: Constant praise for good behavior and the recognition of talents instill confidence in survivors, reminding them of their potential for good.\n" +
                        "8. RESTORATION AND DIGNITY: Love146 focuses on restoring a sense of dignity, freedom, and peace in the lives of survivors.\n" +
                        "9. HOLISTIC GROWTH: The safe homes offer various activities, from tending gardens to raising farm animals, which promote reflection and personal growth.\n" +
                        "10. EMPOWERING SURVIVOR FUTURES: The ultimate goal is to empower survivors to recognize their worth, discover new purposes in life, and become valued, productive members of society.",

                "https://2012-2017.usaid.gov/sites/default/files/styles/732_width/public/success_story/Post%20primal%20meet-blur.jpg?itok=mys6RNU0",
                "https://love146.org/philippines-survivor-care/"
    )
        )

        dataList.add(
            DataItem("LEGISLATIVE MEASURES AND INTERNATIONAL COOPERATION",
                "In the realm of legislative measures and international cooperation, the Philippines takes a stand against human trafficking. Discover the multifaceted approach the nation employs to combat this egregious violation of human rights.\"\n" +

                        "1. DEFINING HUMAN TRAFFICKING: Human trafficking is a complex violation involving acts, means, and purposes such as recruitment, use of force, and exploitation for prostitution, labor, or organ removal.\n" +
                        "2. PUNISHABLE ACTS: Various acts, including recruitment for prostitution, use of tampered documents, and preventing victim redress, are punishable under the Anti-Trafficking in Persons Act.\n" +
                        "3. ACTORS BEHIND TRAFFICKING: Human traffickers may face imprisonment and substantial fines for their involvement in these illegal activities.\n" +
                        "4. USING TRAFFICKED PERSONS: Individuals who engage in trafficking victims' services for prostitution face imprisonment and fines, with foreigners subject to deportation.\n" +
                        "5. QUALIFIED TIP OFFENSES: Qualified human trafficking involves specific circumstances, leading to life imprisonment and substantial fines.\n" +
                        "6. ATTEMPTED TIP: Even failed attempts to initiate trafficking offenses can lead to imprisonment and fines.\n" +
                        "7. LEGAL PROTECTION: Trafficked persons are granted legal protection, including free legal assistance and privacy rights.\n" +
                        "8. WITNESS PROTECTION: Measures like the Witness Protection Program offer safeguards to those providing testimony against traffickers.\n" +
                        "9. VICTIM COMPENSATION: Victims may seek compensation for the harms they have endured.\n" +
                        "10. FILING COMPLAINTS: Various parties, including victims, family members, and witnesses, can file complaints against trafficking offenders.",

                "https://pcw.gov.ph/assets/files/2022/07/RA-9208-2-500x458-1.jpg",
                "https://pcw.gov.ph/faq-republic-act-9208/#:~:text=Use%20of%20Trafficked%20Persons%20%E2%80%93%20any,thousand%20to%205%20million%20pesos."
               )
        )

        dataList.add(
            DataItem("THE ROLE OF NGOS IN ADDRESSING HUMAN TRAFFICKING",
                "In the relentless battle against human trafficking, the vital role of Non-Governmental Organizations (NGOs) shines brightly. Explore how NGOs in the Philippines are actively engaged in the fight against human trafficking, working alongside the government to combat this global issue.\n\n\n" +

                        "1. THE GRIM REALITY OF HUMAN TRAFFICKING: Human trafficking ranks as the second-largest criminal enterprise globally, and it significantly plagues the Philippines with a high victim population.\n" +
                        "2. PHILIPPINES' TIER 1 STATUS: The Philippines is recognized as a Tier 1 country by the US Department of State, indicating its commitment to combat trafficking.\n" +
                        "3. DIVERSE VICTIM DEMOGRAPHICS: Human trafficking affects men, women, and children, particularly those from Indigenous communities, conflict zones, and urban areas.\n" +
                        "4. ONLINE SEXUAL EXPLOITATION: The Philippines is a major source of online sexual exploitation of children, impacting an alarming number of minors.\n" +
                        "5. ROOT PERPETRATORS: Native Filipinos often play a role in recruitment, while organized crime groups oversee smuggling networks.\n" +
                        "6. LABOR AND SEX TRAFFICKING: The Philippines is a source for both labor and sex trafficking, with male workers exploited in various industries.\n" +
                        "7. CHILD LABOR ISSUES: Weak labor laws sometimes allow children to work at a young age, leading to forced labor and servitude.\n" +
                        "8. CHILD SOLDIER RECRUITMENT: Certain areas in the Philippines see child soldiers being recruited by extremist groups.\n" +
                        "9. COMMON RECRUITMENT METHODS: Traffickers frequently use deceit, debt, or promises of employment to lure victims, exploiting them in various sectors.\n" +
                        "10. IMPACT OF COVID-19: The pandemic increased online child sexual exploitation, but the Filipino government continues to fight trafficking with NGOs' support.",

                "https://theexodusroad.com/wp-content/uploads/2022/03/philippines-street_web.jpg",
                "https://theexodusroad.com/human-trafficking-in-the-philippines/#:~:text=Organizations%20like%20Together%20in%20Hope,being%20exploited%20in%20sex%20trafficking."
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