package com.example.civicall.CivicRightsAndResponsibility

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class NineGlobalCitizen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nine_global_citizen)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "BEING A RESPONSIBLE GLOBAL CITIZEN",
                "In an increasingly globalized world with Filipinos scattered across the globe, redefining what it means to be a responsible global citizen is essential. This article delves into the complexities of Filipino citizenship, identity, and the need for a more liberal approach in recognizing global Filipinos.\n\n" +
                        "1. DEBATES AROUND FILIPINO CITIZENSHIP\n\n" +
                        "   - The article highlights ongoing debates about Filipino citizenship and what defines a united nation.\n\n" +
                        "2. CONFLICT IN MINDANAO\n\n" +
                        "   - Amid debates about citizenship, the conflict in Marawi, Mindanao, exemplifies the challenges of unity and identity in the Philippines.\n\n" +
                        "3. DUAL CITIZENSHIP CONTROVERSIES\n\n" +
                        "   - Recent cases, including former Foreign Affairs Secretary Perfecto Yasay Jr., Senators Alan Cayetano and Grace Poe, bring attention to issues surrounding dual citizenship.\n\n" +
                        "4. RIGHTS OF GLOBAL FILIPINOS\n\n" +
                        "   - The article raises questions about whether global Filipinos should have the same rights as other citizens, especially in political and governance matters.\n\n" +
                        "5. LIBERAL APPROACH TO CITIZENSHIP\n\n" +
                        "   - Should the Philippines adopt a more liberal approach to citizenship, such as eliminating the natural-born citizenship requirement for many government positions?\n\n" +
                        "6. CITIZENSHIP OF ALAN CAYETANO\n\n" +
                        "   - Senator Alan Cayetano's appointment as foreign affairs secretary sparked a debate about his citizenship status.\n\n" +
                        "7. GRACE POE'S CITIZENSHIP\n\n" +
                        "   - The Supreme Court's decision on Grace Poe's citizenship and eligibility to run for president had significant implications for the country.\n\n" +
                        "8. LOIDA NICOLAS LEWIS\n\n" +
                        "   - Prominent Filipino-American, Loida Nicolas Lewis, faced criticism for her involvement in Philippine politics and was wrongly accused of foreign interference.\n\n" +
                        "9. THE REALITY OF DUAL CITIZENSHIP\n\n" +
                        "   - The article emphasizes the legal framework for dual citizenship in the Philippines and the distinction between naturalized and natural-born Filipinos.\n\n" +
                        "10. PROMOTING INCLUSIVITY\n\n" +
                        "   - As global Filipinos become more common, the need for a more inclusive definition of Filipino identity and a liberal approach to citizenship is emphasized.\n\n",

                "https://beta-planet.gvi.co.uk/wp-content/uploads/2018/10/1366966659-2019-dec-20-11-54-44-000000-21588244544_9946d0aab3_o_gvi_cape-town-1024x513.jpg",
                "https://www.rappler.com/voices/thought-leaders/172675-citizenship-identity-global-filipinos/"
            )
        )
        dataList.add(
            DataItem("GLOBAL SOLIDARITY AND CIVIC ACTION",
                "\"In an era marked by global solidarity and civic action, the Philippines grapples with the criminalization of human rights defenders. This article sheds light on their plight and the urgent need for safeguarding their rights.\n\n" +
                        "1. CRIMINALIZATION OF HUMAN RIGHTS DEFENDERS:\n\n" +
                        "   - The article underscores the unjust criminalization of human rights defenders in the Philippines.\n\n" +
                        "2. LEGAL CHARGES AND RETALIATION:\n\n" +
                        "   - Ten prominent activists, including Elisa Tita Lubi and Cristina Palabay, face perjury charges in retaliation for their human rights work.\n\n" +
                        "3. LEGAL ACTIONS FOR PROTECTION:\n\n" +
                        "   - These defenders initially sought legal protection through a writ of amparo and habeas data, which was denied by the Philippine Court of Appeals.\n\n" +
                        "4. RETALIATORY COMPLAINT BY AUTHORITIES:\n\n" +
                        "   - General Hermogenes Esperon, a government official named in the petition, filed a perjury complaint against the activists, alleging they provided false information.\n\n" +
                        "5. CONTROVERSIAL PERJURY CHARGES:\n\n" +
                        "   - Although the initial perjury complaint was dismissed, it was later revived, leading to charges against the activists.\n\n" +
                        "6. INTERNATIONAL CONDEMNATION:\n\n" +
                        "   - The charges against these human rights defenders have drawn criticism from regional and global civil society organizations and the UN Special Rapporteur on Human Rights Defenders.\n\n" +
                        "7. BROADER SUPPRESSION OF ACTIVISM:\n\n" +
                        "   - Beyond these cases, the Department of Justice has charged numerous individuals, including nuns, with financing terrorism, underlining a broader crackdown on activism.\n\n" +
                        "8. DETERIORATING CLIMATE FOR DEFENDERS:\n\n" +
                        "   - Since President Duterte's tenure began in 2016, human rights defenders in the Philippines have faced escalating attacks, arbitrary detention, and judicial harassment.\n\n" +
                        "9. ANTI-TERRORISM ACT IMPACT:\n\n" +
                        "   - The Anti-Terrorism Act, passed in 2020, exacerbated the situation by legitimizing the practice of \"red-tagging\" defenders.\n\n" +
                        "10. CALLS FOR INTERNATIONAL INVESTIGATION:\n\n" +
                        "   - The article underscores the urgent need for an international, independent investigation into human rights violations in the Philippines and calls for the protection of defenders' rights.\n\n",

                "https://intdevalliance.scot/wp-content/uploads/2023/08/Diversity.jpg",
                "https://www.omct.org/en/resources/statements/philippines-global-solidarity-with-filipino-human-rights-defenders"
             )
        )
        dataList.add(
            DataItem("TRANSNATIONAL CHALLENGES AND CIVIC ENGAGEMENT",
                "In an age of transnational challenges and digital engagement, 'Ikaw Mismo!' offers a gamified solution to empower Filipino youth with civic knowledge and inspire them to become active citizens. Join us on a journey to transform the future of civic engagement and foster informed, resilient, and digitally savvy youth.\n\n" +

                        "1. YOUTH CIVIC DISENGAGEMENT\n\n" +
                        "   - The article delves into the issue of disengagement among Filipino youth in civic affairs, highlighting its consequences.\n\n" +
                        "2. RISE IN YOUTH CIVIC ENGAGEMENT\n\n" +
                        "   - The recent 2022 national elections marked a shift, with a significant increase in youth participation, especially in voting.\n\n" +
                        "3. CHANGING DYNAMICS\n\n" +
                        "   - The youth actively engaged in both online and offline civic activities during the election season, signifying evolving civic dynamics.\n\n" +
                        "4. ENTHUSING YOUTH FOR CHANGE\n\n" +
                        "   - The 'Ikaw Mismo!' platform seeks to rekindle the enthusiasm of over 33 million Filipino youth for civic engagement beyond elections.\n\n" +
                        "5. CIVIC EDUCATION GAP\n\n" +
                        "   - The absence of comprehensive civic education in schools contributes to the disinterest in civic action.\n\n" +
                        "6. A GAMIFIED APPROACH\n\n" +
                        "   - 'Ikaw Mismo!' offers gamified short online modules called Quests to make civic education engaging and accessible for youth.\n\n" +
                        "7. REWARDING LEARNING\n\n" +
                        "   - Users are rewarded with experience points and online incentives after completing tasks and quests, aligning with youth's tech-savvy behavior.\n\n" +
                        "8. EMPOWERING FUTURE VOTERS\n\n" +
                        "   - By 18, youth gain the right to vote, and 'Ikaw Mismo!' aims to equip them with the skills and knowledge to make informed civic decisions.\n\n" +
                        "9. DIGITAL RESILIENCE\n\n" +
                        "   - In an era of social media and information overload, the platform aims to build digital resilience among the youth.\n\n" +
                        "10. AGENTS OF CHANGE\n\n" +
                        "   - Ultimately, 'Ikaw Mismo!' seeks to nurture well-informed, engaged, and digitally resilient future voters and agents of change.\n\n",

                "https://oliviaalfath.files.wordpress.com/2018/05/img_7085-e1526795534138.jpg?w=820&h=312&crop=1",
                "https://solve.mit.edu/challenges/learning-for-civic-action-challenge/solutions/72419"
              )
        )
        dataList.add(
            DataItem("INTERNATIONAL AGREEMENTS AND CIVIC DUTIES",
                "Exploring the intricate interplay of international agreements and civic duties within the evolving global landscape, we delve into the responsibilities of nations and individuals on the world stage.  \n\n" +
                        "1. GLOBALIZATION'S IMPACT ON SOCIAL POLICY: The article discusses the evolving concept of 'globalization' and its impact on social policy, emphasizing the need to move beyond slogans and engage in intelligent debate about the changing world order.\n\n" +
                        "2. HISTORICAL CONTEXT OF SOCIAL POLICY: It underlines the historical context of social policy, particularly in relation to 19th-century open economies, and reflects on the enduring relevance of social policies.\n\n" +
                        "3. LINK BETWEEN SOCIAL POLICY AND POLITICAL INSTITUTIONS: The article stresses that social policy cannot be divorced from political institutions, highlighting that the evolution of social policies is intricately linked to the specific historical development of Western societies.\n\n" +
                        "4. ROLE OF THE WELFARE STATE: The article mentions the evolution of the welfare state in response to the dark side of progress, acknowledging that political changes at the national level played a vital role in shaping social policies.\n\n" +
                        "5. NATIONAL VS. INTERNATIONAL POLITICS: It draws a contrast between national and international politics, pointing out that while national political changes can influence social policies, international mechanisms for global social balance remain elusive.\n\n" +
                        "6. TRANSNATIONAL SOCIAL POLICIES: The article discusses the challenge of designing transnational social policies to achieve social balance in countries with different political and economic histories.\n\n" +
                        "7. SHIFT IN SOCIAL POLICY PARADIGM: It highlights a shift in the social policy paradigm from macroeconomic stability to social development, driven by the effects of globalization and rapid technological changes.\n\n" +
                        "8. SUSTAINABLE SOCIAL POLICIES: The article points out that many developing countries face difficulties in identifying sustainable social policies, given constraints related to external debt, international aid, and national wealth distribution.\n\n" +
                        "9. ROLE OF GLOBALIZATION IN SOCIAL POLICY: The impact of globalization on shaping the social policy agenda is emphasized, with an increasing focus on market liberalization and competition as tools for poverty reduction.\n\n" +
                        "10. SOCIAL EXCLUSION AND POLICY REFORM: The article touches on the emergence of social exclusion and the necessity for policy reforms, indicating that public-policy changes are often introduced without systematic assessment of outcomes.",

                "https://www.rappler.com/tachyon/2022/09/Bello-state-of-the-world-September-17-2022.jpg",
                "https://idrc-crdi.ca/sites/default/files/openebooks/854-6/index.html"
          )
        )

        dataList.add(
            DataItem("STUDENTS AS GLOBAL CITIZENS AND AGENTS OF CHANGE",
                "n an increasingly interconnected world, students are being empowered to become global citizens and agents of positive change through global education. This article explores the significance of global education in nurturing intercultural understanding, critical thinking, and social responsibility, equipping students to make a difference on a global scale.\n\n\n" +
                        "1. FOSTERING GLOBAL CITIZENSHIP: The article emphasizes the role of global education in nurturing global citizenship and preparing students to address complex global challenges.\n\n" +
                        "2. COMPREHENSIVE LEARNING APPROACH: Global education goes beyond traditional academic subjects, focusing on concepts like sustainable development, human rights, and cultural diversity.\n\n" +
                        "3. INTERCULTURAL UNDERSTANDING: Students gain exposure to diverse cultures and perspectives, promoting intercultural understanding and empathy.\n\n" +
                        "4. CRITICAL THINKING SKILLS: Global education encourages critical thinking and problem-solving, essential for analyzing complex global issues and developing innovative solutions.\n\n" +
                        "5. AWARENESS OF ENVIRONMENTAL ISSUES: Students learn about environmental challenges, such as climate change and biodiversity loss, fostering environmental and sustainable awareness.\n\n" +
                        "6. EFFECTIVE COMMUNICATION: Emphasis on effective communication and collaboration skills, preparing students for the globalized workforce and promoting harmony among cultures.\n\n" +
                        "7. PREPARATION FOR GLOBALIZED WORKFORCE: Global education equips students with the skills needed to thrive in a global job market, including intercultural communication and adaptability.\n\n" +
                        "8. ROLE OF EDUCATIONAL INSTITUTIONS: Schools and universities are urged to integrate global education into their curricula by incorporating global issues and experiential learning.\n\n" +
                        "9. TEACHER TRAINING: Teachers should receive training in global education pedagogy to effectively impart global perspectives in their teaching.\n\n" +
                        "10. PARTNERSHIPS AND TECHNOLOGY: Collaboration, partnerships, and the integration of technology play a crucial role in promoting global education, fostering connections across borders.",

                "https://www.mcgill.ca/medhealthsci/files/medhealthsci/styles/fullwidth_breakpoints_theme_moriarty_small_1x/public/channels/image/global_health_students_lightened.jpg?itok=Dr_x4DR1&timestamp=1608149724",
                "https://www.linkedin.com/pulse/global-education-empowering-citizens-sustainable-future-bathina"
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