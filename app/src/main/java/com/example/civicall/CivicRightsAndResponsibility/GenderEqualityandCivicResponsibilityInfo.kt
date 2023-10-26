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

class GenderEqualityandCivicResponsibilityInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gender_equalityand_civic_responsibility_info)







        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "GENDER DISCRIMINATION AND ITS FORMS IN THE PHILIPPINES",
                "Unveiling Gender Discrimination: Exploring the Complex Web of Biases and Prejudices. Dive into the pervasive issue of gender discrimination in the Philippines, where entrenched biases and stereotypes continue to shape the lives of Filipino women.\n\n" +
                        "1. GENDER BIAS AMONG FILIPINO WOMEN: Filipino women exhibit biases against their own gender, often viewing these biases as natural or inevitable.\n" +
                        "2. UNDP STUDY ON GENDER BIAS: A study by the United Nations Development Programme (UNDP) reveals that nearly 99.5% of Filipinos hold biases against women.\n" +
                        "3. SHARED GENDER BIAS: The study found that both Filipino men and women share similar gender biases, suggesting internalized sexism.\n" +
                        "4. INTERNALIZED SEXISM: Internalized sexism occurs when individuals accept and perpetuate gender norms, believing them to be natural or unavoidable.\n" +
                        "5. IMPLICATIONS FOR GENDER EQUALITY STRATEGIES: The data has important implications for gender equality strategies, as it shows that women themselves may reinforce gender biases.\n" +
                        "6. PATRIARCHAL INFLUENCES IN THE PHILIPPINES: The Philippines, despite being considered a gender-equal nation, still grapples with patriarchal influences rooted in culture and religion.\n" +
                        "7. GENDER BIAS IN POLITICS: Gender bias, particularly against women, is most evident in the political dimension, where women are underrepresented in governance.\n" +
                        "8. IMPACT OF POLITICAL LEADERSHIP: Misogynistic attitudes may be perpetuated by political leadership and have far-reaching societal consequences.\n" +
                        "9. GENDER BIAS IN EDUCATION: The study also examines gender bias in education, highlighting the need for safe spaces and addressing issues like sexual harassment.\n" +
                        "10. ADVOCACY FOR GENDER EQUALITY: The article emphasizes the importance of raising critical awareness about gender issues and advocating for legal reforms to combat gender-based violence and promote gender equality.\n",
                R.drawable.img_261,
                "https://www.rappler.com/nation/filipino-women-highly-biased-against-own-gender/",
                "https://www.rappler.com/tachyon/2023/06/Rappler-Talk-women-bias.jpg?resize=1280%2C720&zoom=1"
            )
        )
        dataList.add(
            DataItem("INTERNATIONAL AGREEMENTS ON GENDER EQUALITY RELEVANT TO THE PHILIPPINES",
                "\"In its pursuit of gender equality, the Philippines is committed to a range of international agreements and commitments. These global partnerships underpin the nation's efforts to empower women and girls on a path towards a more equitable society.\n\n" +
                        "1. PHILIPPINE GENDER EQUALITY RANKING: The Philippines ranks 16th in the 2019 Global Gender Gap Index, leading Asia in gender equality.\n" +
                        "2. GENDER GAP CLOSURE: The country has closed 78% of its gender gap, focusing on education, economic participation, and health.\n" +
                        "3. COMMITMENT TO CEDAW: The Philippines is a State party to the Convention on the Elimination of All Forms of Discrimination against Women (CEDAW).\n" +
                        "4. KEY ROLE IN BPFA: The Philippines played a vital role in crafting the Beijing Platform for Action (BPfA), an international document addressing gender equality.\n" +
                        "5. BPFA IMPLEMENTATION: The country actively participates in BPfA implementation assessments every 5 years.\n" +
                        "6. 2030 AGENDA FOR SUSTAINABLE DEVELOPMENT: In 2015, the Philippines adopted the 2030 Agenda for Sustainable Development, including Goal 5 on gender equality.\n" +
                        "7. PARTICIPATION IN UN CSW: The Philippines participates in the UN Commission on the Status of Women (CSW), dedicated to gender equality and women's empowerment.\n" +
                        "8. ASEAN MEMBER: The Philippines is a founding member of the Association of Southeast Asian Nations (ASEAN), promoting gender equality in the region.\n" +
                        "9. APEC PARTICIPATION: The country is also a founding member of the Asia-Pacific Economic Cooperation (APEC) and works on women's economic empowerment.\n" +
                        "10. SIGNATORY TO HUMAN RIGHTS TREATIES: The Philippines is a signatory to various international human rights treaties that protect and promote women's rights.",
                R.drawable.img_262,
                "https://pcw.gov.ph/international-commitments/#:~:text=The%20Philippines%20is%20one%20of,bill%20of%20rights%20of%20women.",
                "https://asiapacific.unwomen.org/sites/default/files/Field%20Office%20ESEAsia/Images/2016/09/philippines-cedaw-main.jpg?la=en")
        )
        dataList.add(
            DataItem("GENDER EMPOWERMENT IN CIVIC PARTICIPATION IN THE PHILIPPINES",
                "In the landscape of Philippine politics, the journey towards gender empowerment in civic participation faces both progress and challenges. While the Philippines has made strides in promoting gender equality, disparities persist, highlighting the ongoing struggle for women's active engagement in political decision-making.\"\n\n" +


                        "1. POLITICAL EMPOWERMENT RANKING: The Philippines ranks 17th globally and 3rd in Asia in terms of political empowerment, a category measuring gender equality in political decision-making.\n" +
                        "2. GENDER DISPARITIES IN ELECTIONS: Over six election cycles from 1998 to 2013, more men than women have participated and been elected in Philippine politics.\n" +
                        "3. LOW FEMALE CANDIDATES: In 1998, only 14.3% of the 63,531 candidates were women, signaling gender disparities in political participation.\n" +
                        "4. SLIGHT INCREASE IN FEMALE CANDIDATES: By 2013, the percentage of women candidates rose to 17.82%, but men still dominated the political landscape.\n" +
                        "5. GENDER GAP IN ELECTED OFFICIALS: Despite some progress, men continue to dominate political roles, with women holding only a fraction of the seats.\n" +
                        "6. SENATE REPRESENTATION: In 2013, only 4 out of 24 senators were women, highlighting the gender imbalance in the country's upper legislative chamber.\n" +
                        "7. HOUSE OF REPRESENTATIVES: Women's representation in the House of Representatives lags significantly behind men, with 60 women compared to 174 men.\n" +
                        "8. LOCAL COUNCIL GENDER GAP: Even at the local level, a significant gender gap persists, with more male councilors compared to their female counterparts.\n" +
                        "9. VOTER TURNOUT: Women have maintained a slight lead in voter turnout compared to men in recent elections.\n" +
                        "10. GENDER EMPOWERMENT LAWS: The Philippines has enacted various laws to promote gender empowerment, but challenges in implementation and gender inequality issues remain.",
                R.drawable.img_263,
                "https://www.rappler.com/moveph/124248-women-politics-governance/",
                "https://www.rappler.com/tachyon/r3-assets/612F469A6EA84F6BAE882D2B94A4B421/img/8E94138A946B4C0D8B6DCB656DFE1184/women-ph-politics-20160301.jpg?resize=640%2C360&zoom=1")
        )

        dataList.add(
            DataItem("GENDER-RESPONSIVE POLICIES IN CIVIC ADVOCACY IN THE PHILIPPINES",
                "In the pursuit of gender equality and responsive civic advocacy, the Philippines grapples with the complexities of addressing gender-related issues and ensuring inclusivity.\"\n" +
                        "1. SOCIAL GOOD SUMMIT DISCOURSE: Advocates at the 2019 Social Good Summit in the Philippines engaged in discussions about mainstreaming gender issues and the importance of gender equality.\n" +
                        "2. INTERSECTIONALITY OF RIGHTS: The summit raised questions about where women's rights intersect with LGBTQ+ rights, emphasizing the interconnectedness of gender inequality and discrimination.\n" +
                        "3. SUSTAINABLE DEVELOPMENT GOAL (SDG): The importance of the SDG on gender equality was highlighted, but concerns were raised about its limitation to women's rights, leaving a gap in addressing broader gender issues.\n" +
                        "4. GENDER AND DEVELOPMENT (GAD) POLICY: The Philippines implements the Gender and Development budget policy, aiming to allocate 5% of local government revenue for gender development projects.\n" +
                        "5. CHALLENGES IN GAD IMPLEMENTATION: Local government units struggle to maximize the GAD budget, often allocating funds to activities of limited relevance to gender issues.\n" +
                        "6. GAD MISUSE: Audits revealed misallocation of GAD budget for non-related activities, highlighting the need for more effective implementation.\n" +
                        "7. LGBTQ+ INCLUSION: Advocates push for the recognition of all genders within the GAD policy, emphasizing the LGBTQ+ community's struggles with discrimination.\n" +
                        "8. SOGIE EQUALITY BILL: The LGBTQ+ community lobbied for a separate bill addressing gender issues specific to LGBTQ+ rights while intersecting with women's rights.\n" +
                        "9. IMPORTANCE OF IMPLEMENTING RULES: Having implementing rules and regulations (IRR) for LGBTQ+ anti-discrimination ordinances is crucial to ensure effective policy enforcement.\n" +
                        "10. EDUCATIONAL APPROACH: Advocates stress the importance of SOGIE education, a bottom-up approach, and the need for a mass cultural change to combat discrimination and close the gender gap.",
                R.drawable.img_264,
                "https://www.rappler.com/moveph/240707-2030-now-advocates-rethink-gender-development-philippines/",
                "https://www.rappler.com/tachyon/r3-assets/85A405943BC64E228B82EE37E751D286/img/5B848761CC27451AA425F763C953543D/social-good-summit-gender-huddle-september-21-2019-008.jpg")
        )

        dataList.add(
            DataItem("THE ROLE OF MEN IN PROMOTING GENDER EQUALITY IN THE PHILIPPINES",
                "In the journey toward gender equality in the Philippines, the role of men as allies and advocates is pivotal. This article explores the essential steps men can take to promote and support gender equality, drawing inspiration from global experiences and principles.\n\n\n" +
                        "1. ACKNOWLEDGE MALE PRIVILEGE: Men must begin by acknowledging the privileges they have inherited due to the patriarchal system, which has historically favored men and excluded women.\n\n" +
                        "2. SHOW SOLIDARITY: Acknowledging male privilege is the first step; men need to actively stand with women and support their fight against discrimination.\n\n" +
                        "3. UNIVERSAL GENDER INEQUALITY CAUSES: While contexts may vary, the root causes of gender discrimination and inequality are the same, making male allies essential.\n\n" +
                        "4. CHALLENGE NEGATIVE MASCULINITIES: Toxic masculinity perpetuates violence, discrimination, and stress; men must challenge and reject such behaviors.\n\n" +
                        "5. HAVE AN INTERSECTIONAL LENS: The pursuit of gender equality should encompass social progress for other marginalized groups, such as the LGBTQ+ community and indigenous people.\n\n" +
                        "6. HELP TRANSFORM POWER DYNAMICS: Promoting equality benefits all and leads to more satisfying relationships and better workplace dynamics.\n\n" +
                        "7. BECOMING ALLIES AGAINST DISCRIMINATION: Men should actively combat all forms of discrimination and promote a new, caring definition of masculinity.\n\n" +
                        "8. SUPPORT WOMEN'S LEADERSHIP: Encourage and create space for women and girls to lead and effect positive change in communities.\n\n" +
                        "9. FUNDAMENTAL HUMAN RIGHT: Gender equality is not only a fundamental right but also the necessary foundation to achieve a peaceful, thriving, and sustainable world.\n\n" +
                        "10. COLLECTIVE FIGHT FOR EQUALITY: Promoting gender equality requires collective action, involving both men and women, to build a more equitable society.",
                R.drawable.img_265,
                "https://www.rappler.com/newsbreak/iq/198603-data-privacy-personal-information-protection-tips/",
                "https://plan-international.org/tachyon/2022/01/GGE-Gonzalo-Activism.jpg?resize=507%2C507&zoom=1")
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