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

class FourGenderEquality : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_gender_equality)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "GENDER DISPARITIES IN THE WORKPLACE AND SOCIETY",
                "Despite its reputation for gender equality, the Philippines grapples with a persistent issue – the gender wage gap. Women in the country earn only 78% of what men earn, revealing a significant pay disparity that requires urgent attention.\"\n\n" +
                        "1. GENDER WAGE GAP: Women in the Philippines earn only 78% of what men earn, indicating a significant pay disparity.\n\n" +
                        "2. REGIONAL DISPARITIES: The gender wage gap is more pronounced in rural areas, where women earn just 43% of men's earnings.\n\n" +
                        "3. ECONOMIC INEQUALITY: This wage gap highlights unequal societal valuations of women's labor compared to men.\n\n" +
                        "4. GENDER-BASED VIOLENCE: The Philippines reports over 76,000 cases of gender-based violence, affecting women's physical and mental health.\n\n" +
                        "5. MULTIPLE FORMS OF VIOLENCE: Gender-based violence includes physical, sexual, and emotional abuse, with severe consequences.\n\n" +
                        "6. SUPPORT FOR SURVIVORS: Addressing this issue necessitates providing support for survivors, including counseling services and legal aid.\n\n" +
                        "7. PREVENTION STRATEGIES: Preventing violence against women requires comprehensive sex education and awareness campaigns.\n\n" +
                        "8. UNDERREPRESENTATION IN POLITICS: Only 28% of elected officials in the Philippines are female, highlighting barriers to leadership positions.\n\n" +
                        "9. SYSTEMIC CHALLENGES: Systemic barriers prevent women from accessing leadership roles and demand affirmative action.\n\n" +
                        "10. COMPREHENSIVE APPROACH: Addressing gender issues in the Philippines requires a comprehensive approach involving government, civil society, and the private sector.\n",

                "https://media.licdn.com/dms/image/D5612AQFw0NqviBHYhg/article-cover_image-shrink_720_1280/0/1676875770147?e=2147483647&v=beta&t=2F1Yp-1UsNPdvabaIOX16pd_U1MUF91UR8jWptRJ1pU",
                "https://www.linkedin.com/pulse/persistent-challenge-gender-wage-gap-philippines-janvie-amido#:~:text=One%20of%20the%20most%20pressing,%25%20of%20men's%20earnings%5E3."

            )
        )
        dataList.add(
            DataItem("WOMEN'S RIGHTS MOVEMENTS AND ADVOCACY",
                "In the Philippines, the feminist movement has undergone significant transformations and challenges in its pursuit of gender equality and social justice. From mobilizing youth through social media to addressing the impact of political changes, the feminist movement remains resilient and dynamic.\n\n\n" +
                        "1. EQUAL ECONOMIC OPPORTUNITIES: Women have the right to equal economic opportunities, including fair wages and access to higher-paying jobs.\n\n" +
                        "2. PROTECTION FROM GENDER-BASED VIOLENCE: Women have the right to be protected from all forms of gender-based violence, including physical, sexual, and emotional abuse.\n\n" +
                        "3. REPRODUCTIVE HEALTH SERVICES: Women have the right to access comprehensive reproductive health services and information.\n\n" +
                        "4. GENDER EQUALITY IN POLITICS: Women have the right to equal representation and participation in political leadership.\n\n" +
                        "5. FREEDOM FROM MISOGYNY: Women have the right to live free from misogynistic language and actions in public and private life.\n\n" +
                        "6. RIGHTS OF VULNERABLE SECTORS: Women, especially those from vulnerable sectors, have the right to protection, support, and empowerment.\n\n" +
                        "7. YOUTH INVOLVEMENT: Young women have the right to be engaged in feminist causes and social justice.\n\n" +
                        "8. RECOGNITION OF INTERSECTIONALITY: Women have the right to recognition of their diverse experiences, acknowledging the intersection of gender with other identities.\n\n" +
                        "9. HUMAN RIGHTS ADVOCACY: Women have the right to advocate for human rights, including the right to life, dignity, and justice.\n\n" +
                        "10. TRUTH AND DEMOCRACY: Women have the right to pursue truth and demand change based on facts and logic for a flourishing democracy.",

                "https://asia.fes.de/fileadmin/_processed_/9/e/csm_Philippines_91403162f1.jpg",
                "https://asia.fes.de/news/feminism-and-the-womens-movement-in-the-philippines"
               )
        )
        dataList.add(
            DataItem("ADVANCING GENDER EQUALITY INITIATIVES IN THE PHILIPPINES",
                "In the pursuit of gender equality in the Philippines, government policies play a pivotal role. This article delves into the progress and challenges of implementing policies that empower women and promote gender parity.\"\n\n" +
                        "1. THE IMPERATIVE OF GENDER EQUALITY: Achieving gender equality is essential for addressing historical injustices and promoting development effectiveness.\n\n" +
                        "2. ECONOMIC BENEFITS OF WOMEN'S EQUALITY: Advancing women's equality could add trillions to the global GDP and make economies more resilient.\n\n" +
                        "3. UNPAID CARE WORK: Lockdowns during the COVID-19 pandemic highlighted the disproportionate burden of unpaid care and domestic work on women.\n\n" +
                        "4. UNDERREPRESENTATION IN COVID-19 RESPONSE: Women's representation in COVID-19 task forces remains low, especially in conflict-affected countries.\n\n" +
                        "5. EXCLUSION IN PEACE PROCESSES: Women's voices have been systematically excluded from peace negotiations and mediations for decades.\n\n" +
                        "6. GROWTH OF GENDER PROVISIONS IN PEACE AGREEMENTS: The proportion of peace agreements with gender equality provisions has increased, but aid dedicated to gender equality has decreased.\n\n" +
                        "7. EMPOWERING WOMEN IN LEADERSHIP: Initiatives empower women in leadership, strengthening democratic processes and promoting inclusive governance.\n\n" +
                        "8. WOMEN-FRIENDLY SPACES: Providing safe spaces for women, including survivors of gender-based violence, with psycho-social support and human rights education.\n\n" +
                        "9. WOMEN MEDIATORS: Community-based women mediators aim to change attitudes, resolve conflicts peacefully, and enhance women's leadership in peace processes.\n\n" +
                        "10. DISENGAGEMENT OF CHILDREN FROM ARMED GROUPS: Women played a crucial role in disengaging children from non-state armed groups in the region, promoting their reintegration.",

                "https://external-preview.redd.it/wJxzxiVFmEWNY36ujMB5oKZjfuruZJ6hxYDl8Kcrexk.jpg?auto=webp&s=1918f07cefd56b5f1d16ca9c341f47de7a068450",
                "https://news.abs-cbn.com/blogs/opinions/03/20/21/gender-equalityour-unfinished-business"
            )
        )

        dataList.add(
            DataItem("THE ROLE OF WOMEN IN SUSTAINABLE DEVELOPMENT",
                "In the realm of sustainable development, women are powerful catalysts of change, driving progress and promoting gender equality. Their contributions in the Philippines and globally underscore the vital role of women in shaping a more sustainable and equitable future.\"\n\n\n" +

                        "1. PROGRESS IN GENDER EQUALITY: The Philippines has made significant strides in closing the gender gap and ranks high in global gender equality rankings.\n" +
                        "2. ROLE OF WOMEN IN SUSTAINABLE DEVELOPMENT: Women play a crucial role in promoting sustainable development and inclusive growth.\n" +
                        "3. GLOBAL SIGNIFICANCE OF INTERNATIONAL WOMEN'S DAY: International Women's Day is a global platform to celebrate and advocate for gender equality.\n" +
                        "4. IMPACT OF GENDER EQUALITY ON GDP: Women's equal rights and participation can contribute trillions to the global GDP.\n" +
                        "5. EMPOWERING WOMEN IN CLIMATE ACTION: Gender equality is essential in climate change adaptation and mitigation, recognizing women's vulnerability and leadership.\n" +
                        "6. LOCALIZING SUSTAINABLE DEVELOPMENT GOALS: The Philippines is actively working to achieve the SDGs by monitoring indicators and fostering government cooperation.\n" +
                        "7. NATIONAL WOMEN'S MONTH CELEBRATION: The National Women's Month in the Philippines acknowledges women's contributions and empowerment.\n" +
                        "8. LEGISLATIVE SUPPORT FOR GENDER EQUALITY: Various laws and proclamations emphasize gender equality and women's rights in the Philippines.\n" +
                        "9. CHALLENGES IN ACHIEVING FULL GENDER EQUALITY: While progress has been made, the Philippines still faces gender-related data gaps and work toward full equality.\n" +
                        "10. SUSTAINABLE DEVELOPMENT AS A COLLECTIVE GOAL: Gender equality is integral to achieving sustainable development, emphasizing the need for global unity and transformation.\n",

                "https://asiapacific.unwomen.org/sites/default/files/2022-11/ph-Philippines-weps-2022-1679px.jpg",
                "https://www.cdp.org.ph/news-1/gender-equality-towards-sustainable-development"
       )
        )

        dataList.add(
            DataItem("CHALLENGES AND PROGRESS IN ACHIEVING GENDER EQUALITY IN THE PHILIPPINES",
                "In the Philippines, the journey toward gender equality has seen remarkable achievements and enduring challenges. While the nation ranks high in global gender equality, persistent barriers to women's participation in the labor force underscore the ongoing quest for full gender equality.\n\n\n" +

                        "1. GENDER EQUALITY PROGRESS: The Philippines demonstrates commendable progress in achieving gender equality, ranking 17th globally in closing gender gaps.\n\n" +
                        "2. PERSISTENT LABOR FORCE GENDER GAP: Despite its global gender ranking, the Philippines faces a significant gender gap in labor force participation, with only 49% of women engaged in the workforce.\n\n" +
                        "3. ECONOMIC OPPORTUNITY MISSED: The low labor force participation of women represents a missed opportunity for economic growth, with potential GDP per capita increases by 2040 and 2050.\n\n" +
                        "4. CHILDCARE AND GENDER NORMS: The report identifies childcare and traditional gender norms as significant barriers to women's participation in the labor market.\n\n" +
                        "5. CONSTRAINTS ON SKILL DEVELOPMENT: Women in the Philippines are often concentrated in low-skill or high-skill positions, with limited opportunities for skill development.\n\n" +
                        "6. WAGE DISPARITIES: Women in low-skill positions earn significantly less than men, contributing to income disparities within households.\n\n" +
                        "7. CARE RESPONSIBILITIES IMPACT: Women's employment is reduced with an increasing number of children and young child-rearing responsibilities.\n\n" +
                        "8. NORMS AND BELIEFS: Social attitudes and beliefs play a critical role in deterring women from participating in the labor market.\n\n" +
                        "9. POLICY RECOMMENDATIONS: The article highlights policy recommendations, including providing alternatives to childcare, promoting flexible work arrangements, and addressing gendered social norms.\n\n" +
                        "10. GLOBAL COMMITMENT TO GENDER EQUALITY: The World Bank reaffirms its commitment to supporting gender equality in the Philippines, emphasizing the importance of increasing women's access to paid labor.",

                "https://blogs.worldbank.org/sites/default/files/styles/hero/public/2022-04/woman_cleans_handrail_at_a_mall_in_taguig_city_philippines_ezra_acayan_world_bank.jpg.webp?itok=M9_l2chZ",
                "https://blogs.worldbank.org/eastasiapacific/overcoming-barriers-womens-work-philippines"
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