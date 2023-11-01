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

class EightMentalHealthAwareness : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight_mental_health_awareness)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "STIGMA AND CULTURAL PERSPECTIVES ON MENTAL HEALTH",
                "Mental health among Filipinos is deeply intertwined with cultural beliefs and attitudes. This review explores how Filipino cultural beliefs influence their approach to mental health and help-seeking behaviors.\"\n\n" +
                        "1. FILIPINO MENTAL HEALTH CRISIS: The Philippines faces a significant mental health crisis, with high rates of depression, anxiety, and suicide.\n\n" +
                        "2. OVERSEAS FILIPINOS STRUGGLE: Filipinos living abroad, particularly in the US, also experience elevated mental health problems, possibly due to acculturative stress and discrimination.\n\n" +
                        "3. HELP-SEEKING RELUCTANCE: Filipinos, both in their home country and abroad, exhibit a general reluctance to seek formal help for mental health issues.\n\n" +
                        "4. PREFERRED SUPPORT NETWORK: Filipinos prefer seeking help from close family and friends rather than professional mental health services.\n\n" +
                        "5. BARRIERS IN THE PHILIPPINES: Barriers to seeking help in the Philippines include financial constraints and limited accessibility to mental health services.\n\n" +
                        "6. BARRIERS FOR OVERSEAS FILIPINOS: Overseas Filipinos face barriers such as immigration status, lack of health insurance, language difficulties, and experiences of discrimination.\n\n" +
                        "7. STIGMA AND CULTURAL NORMS: Both groups are hindered by self and social stigma associated with mental disorders and cultural norms that make mental illness unacceptable.\n\n" +
                        "8. COPING STRATEGIES: Filipinos often rely on their sense of resilience and self-reliance as coping strategies, especially explored in qualitative studies.\n\n" +
                        "9. LAST RESORT APPROACH: Filipinos tend to use professional mental health services only as a last resort or when their problems become severe.\n\n" +
                        "10. FACILITATORS OF HELP-SEEKING: Factors such as the perception of distress, the influence of social support, financial capacity, and positive prior experiences with formal help can facilitate help-seeking among Filipinos.\n\n",

                "https://mentalhealthph.org/wp-content/uploads/2020/11/Adunay-Paglaum-1-mentalhealthph-org-e1604926694125-768x512.jpg",
                "https://link.springer.com/article/10.1007/s00127-020-01937-2#:~:text=In%20Filipino%20culture%2C%20mental%20illness,by%20mental%20health%20care%20professionals.",

            )
        )
        dataList.add(
            DataItem("MENTAL HEALTH SERVICES AND ACCESSIBILITY",
                "In the Philippines, the landscape of mental health services is marked by challenges in accessibility and resource allocation. Despite recent legislative efforts, the provision of comprehensive mental healthcare remains hindered by shortages of professionals and economic constraints.\n\n\n" +
                        "1. MENTAL HEALTH ACT LEGISLATION: The Philippines recently passed the Mental Health Act, which aims to establish accessible and comprehensive mental health services.\n\n" +
                        "2. RESOURCE ALLOCATION: Only 3–5% of the total health budget in the Philippines is allocated to mental health, with the majority spent on hospital care.\n\n" +
                        "3. HOSPITAL-BASED CARE: Most mental healthcare is provided in hospital settings, and there is a shortage of community mental health services.\n\n" +
                        "4. SHORTAGE OF MENTAL HEALTH SPECIALISTS: The Philippines faces a severe shortage of mental health specialists, with only a few hundred psychiatrists in practice.\n\n" +
                        "5. STIGMA AS A BARRIER: Perceived or internalized stigma is a barrier to help-seeking behavior in Filipinos, similar to Western populations.\n\n" +
                        "6. CULTURAL FACTORS: Filipinos tend to turn to family and peer networks before seeking medical help for mental health issues.\n\n" +
                        "7. EPIDEMIOLOGICAL DATA: Limited epidemiological evidence exists on mental disorders in the Philippines, but there is a prevalence of mental health issues.\n\n" +
                        "8. SUICIDE RATES: Suicide rates have increased in the Philippines, with higher rates in males.\n\n" +
                        "9. ACCESS TO TREATMENT: Economic conditions and inaccessibility of mental health services limit access to mental healthcare in the Philippines.\n\n" +
                        "10. TRAINING AND RECRUITMENT CHALLENGES: Increased investment is needed to improve the training and recruitment of mental health professionals in the Philippines.",

                "https://www.who.int/images/default-source/wpro/countries/philippines/feature-stories/mental-health-care-accessible-at-the-primary-level-in-eastern-visayas.tmb-1200v.jpg?Culture=en&sfvrsn=a3a1462f_3",
                "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6646843/"
        )
        )
        dataList.add(
            DataItem("INITIATIVES TO RAISE AWARENESS AND REDUCE STIGMA",
                "Amid a growing movement to address mental health challenges, three prominent figures are spearheading efforts to boost awareness and dismantle the stigma. Discover their stories and their shared mission to promote mental health awareness and combat prejudice in the Philippines.\"\n\n" +
                        "1. ADVOCACY FOR MENTAL HEALTH: Three notable individuals in the Philippines, Antoinette Taus, Jerika Ejercito, and Kylie Verzosa, are fervent advocates for mental health awareness.\n\n" +
                        "2. LEGISLATION IN PROGRESS: Senator Risa Hontiveros is pushing for the Mental Health Act of 2017 to become a law to provide accessible and affordable mental healthcare.\n\n" +
                        "3. SUPPORT FROM PERSONALITIES: The advocacy has the support of Antoinette Taus, Jerika Ejercito, and Kylie Verzosa, all of whom have faced their mental health struggles.\n\n" +
                        "4. KYLIE VERZOSA'S JOURNEY: Kylie Verzosa, Miss International 2016, was diagnosed with clinical depression before her pageant victory and highlights the importance of seeking help.\n\n" +
                        "5. ELIMINATING THE STIGMA: Kylie's story emphasizes the need to eliminate the stigma associated with mental health conditions.\n\n" +
                        "6. JERIKA EJERCITO'S EXPERIENCE: Jerika Ejercito, daughter of former President Joseph \"Erap\" Estrada, shares her experiences with depression, influenced by her family's political involvement.\n\n" +
                        "7. JERIKA'S HEALING JOURNEY: Jerika's healing was aided by her son and her fiancé, Miquel Aguilar Garcia, who supported her advocacy efforts.\n\n" +
                        "8. ANTOINETTE TAUS'S STRUGGLE: For Antoinette, the issue of mental health has always been something she wanted to talk about. Depression can hit anyone at any age, she said, and she experienced it in her early 20s.\n\n" +
                        "9. THE POWER OF OPENING UP: Antoinette emphasizes the importance of talking about mental health issues and the need for awareness and understanding.\n\n" +
                        "10. ADDRESSING THE STIGMA: The advocates stress the urgency of reducing the stigma around mental health issues and ensuring that those who suffer receive the necessary support.",

                "https://www.rappler.com/tachyon/r3-assets/13A8B4CE5C234611986A950BE6E5B638/img/A9AFE337D85848678A66A8D3D1381573/kylieanthoinettejerika-scaled.jpg?resize=2560%2C1537&zoom=1",
                "https://www.rappler.com/entertainment/168881-kylie-verzosa-jerika-ejercito-antoinette-taus-mental-health-law/"
       )
        )

        dataList.add(
            DataItem("IMPACT OF MENTAL HEALTH ON SOCIETY AND PRODUCTIVITY",
                "In the Philippines, the intersection of mental health and economic well-being is an increasingly urgent concern. This article explores the profound impact of mental health on both society and productivity.\"\n\n" +


                        "1. CRITICAL LINK BETWEEN MENTAL HEALTH AND ECONOMY: The article emphasizes the interdependence of mental health and economic well-being, highlighting how they influence each other.\n\n" +
                        "2. THE UNIQUE FILIPINO CONTEXT: It delves into the cultural and societal factors specific to the Philippines that affect the perception of mental health, such as stigma and varying beliefs.\n\n" +
                        "3. HEALTHCARE ALLOCATION: Only 5% of the healthcare budget is directed towards mental health in the Philippines, leading to a significant mental health crisis in the country.\n\n" +
                        "4. MENTAL HEALTH PREVALENCE: The article reveals that mental disorders are the third most common disability in the Philippines, affecting millions of Filipinos.\n\n" +
                        "5. ECONOMIC IMPACT OF MENTAL ILLNESS: Mental health issues have significant economic implications, contributing to unemployment and decreased productivity among Filipinos.\n\n" +
                        "6. MIGRANT WORKERS' MENTAL HEALTH: The migration of Filipinos in search of better economic opportunities abroad also brings mental health challenges due to various stressors.\n\n" +
                        "7. COMPARISON WITH NORTHWESTERN EUROPE: It draws comparisons with Northwestern European countries, which prioritize mental health as part of their overall well-being strategy.\n\n" +
                        "8. IMPORTANCE OF MENTAL HEALTH LEGISLATION: The article underscores the need for robust mental health policies and legislations in the Philippines to address the crisis effectively.\n\n" +
                        "9. ROLE OF MENTAL HEALTH PROFESSIONALS: Mental health professionals should educate families about mental health to eliminate stigma and discrimination, and promote policies and practices to provide quality care.\n\n" +
                        "10. HOPE FOR THE FUTURE: Ultimately, the article encourages conversations and research to explore the intricate relationship between mental health and economic productivity in the Philippines, with the goal of fostering a healthier society and a more prosperous economy.\n",

                "https://static.dw.com/image/53318600_6.jpg",
                "https://www.frontiersin.org/articles/10.3389/fpsyg.2021.706483/full"
              )
        )

        dataList.add(
            DataItem("GOVERNMENT POLICIES FOR MENTAL HEALTH SUPPORT",
                "Amid the mental health challenges faced by the Philippines, the introduction of the Philippine Mental Health Act reflects a significant stride in government policies for mental health support. Explore how this landmark legislation is reshaping mental healthcare in the country.\n\n\n" +

                        "1. HISTORIC LEGISLATION: The Philippine Mental Health Act, signed into law in 2018, marks the first comprehensive mental health legislation in the Philippines.\n\n" +
                        "2. RIGHTS-BASED APPROACH: This act is founded on a rights-based framework and aims to secure the rights of individuals with mental health conditions.\n\n" +
                        "3. INSUFFICIENT RESOURCES: Mental health services in the Philippines have long been under-resourced, with a limited budget allocation and a lack of mental health professionals.\n\n" +
                        "4. PREVALENCE OF MENTAL DISORDERS: A 2010 census revealed that 200,000 Filipinos suffered from mental disorders, comprising 14% of the population with disabilities.\n\n" +
                        "5. RISING SUICIDE RATES: Over the years, suicide rates have increased, highlighting the need for more robust mental health support.\n\n" +
                        "6. PSYCHIATRIC WORKFORCE: The Philippines faces a shortage of mental health workers, with only 2-3 professionals per 100,000 people.\n\n" +
                        "7. FIRST COMPREHENSIVE MENTAL HEALTH LEGISLATION: Prior to this act, the Philippines had no formal mental health legislation.\n\n" +
                        "8. SCOPE OF MENTAL HEALTH ACT: The law mandates the provision of mental health services in hospitals and community settings, protecting the rights of patients and mental health professionals.\n\n" +
                        "9. INCORPORATING MENTAL HEALTH EDUCATION: The act seeks to integrate mental health into the educational system, starting from elementary schools.\n\n" +
                        "10. UN SIGNATORY: The Philippine Mental Health Act aligns with United Nations principles for the protection of persons with mental illness and the improvement of mental health care.",

                "https://www.who.int/images/default-source/wpro/health-topic/mental-health/f12-06052016-ph-07497.tmb-1200v.jpg?Culture=en&sfvrsn=a35930aa_3",
                "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6646847/#:~:text=1354%3A%20Mental%20Health%20Act%20of,Therefore%20and%20for%20Other%20Purposes."
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