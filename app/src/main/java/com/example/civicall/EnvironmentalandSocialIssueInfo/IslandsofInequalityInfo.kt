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

class IslandsofInequalityInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_islandsof_inequality_info)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "DEFORESTATION IN THE PHILIPPINES",
                "In the Philippines, deforestation remains a pressing environmental concern, with significant forest loss despite conservation efforts. This article delves into the ongoing challenges of deforestation in the country, its consequences, and the need for comprehensive policies to address this critical issue.\"\n\n" +
                        "1. PERSISTENT DEFORESTATION: Despite efforts, deforestation rates remain alarming in the Philippines, posing a significant threat to the nation's ecosystems.\n\n" +
                        "2. FOREST COVER DECLINE: The country's forest cover has dramatically decreased from its historical levels, raising concerns about biodiversity and climate impacts.\n\n" +
                        "3. HISTORICAL LAND CONVERSION: Land conversion for agriculture and settlements has been a major driver of deforestation, transforming natural landscapes.\n\n" +
                        "4. ENVIRONMENTAL CONSEQUENCES: Massive floods and ecological crises have been attributed to deforestation, impacting communities and wildlife.\n\n" +
                        "5. BIODIVERSITY LOSS: Iconic species, such as the tamaraw and Mindoro bleeding-heart pigeons, face habitat loss and endangerment.\n\n" +
                        "6. REFORESTATION EFFORTS: Despite reforestation programs, challenges persist, and criticisms arise regarding their effectiveness.\n\n" +
                        "7. DEFORESTATION RATE: Recent years, particularly during the Duterte administration, have seen a peak in primary forest loss, surpassing previous figures.\n\n" +
                        "8. IMPACT ON CLIMATE CHANGE: The exclusion of forest mitigation from the Paris Agreement commitments raises questions about the Philippines' role in addressing climate change.\n\n" +
                        "9. PENDING LEGISLATION: Urgent 'green bills,' including the National Land Use Act and Sustainable Forest Management Act, are needed to address legal gaps.\n\n" +
                        "10. POLICY FRAMEWORK: Experts emphasize the necessity of comprehensive forest management policies to safeguard the Philippines' invaluable but endangered forests.\n",
                R.drawable.img_296,
                "https://www.rappler.com/environment/hectares-land-philippines-forested//",
                "https://www.rappler.com/tachyon/2021/05/deforestation-carousel.jpg?resize=1280%2C720&zoom=1"
            )
        )
        dataList.add(
            DataItem("BALANCING CONSERVATION AND ECONOMIC REALITIES IN SOUTHEAST ASIA",
                "In the Philippines, indigenous territories grapple with biodiversity loss. Explore the challenges they face in preserving their unique natural heritage.\n\n" +
                        "1. SOUTHEAST ASIAN NATIONS AND 30X30 PLEDGE: Only Cambodia from Southeast Asia has embraced the 30x30 conservation goal, highlighting the need for greater regional commitment to safeguarding biodiversity.\n" +
                        "2. MEGADIVERSE SOUTHEAST ASIA: Despite covering only 3% of the Earth's surface, Southeast Asia hosts three of the world's \"megadiverse\" countries—Indonesia, Malaysia, and the Philippines, known for their extraordinary species richness.\n" +
                        "3. BIODIVERSITY IN PERIL: High deforestation rates in countries like Indonesia, Malaysia, Laos, and Cambodia threaten the biodiversity of mangrove forests, coral reefs, and numerous plant and animal species.\n" +
                        "4. GLOBAL CONSERVATION TREATY: The 30x30 goal is integral to a forthcoming global treaty for the protection of the planet's ecosystems and biodiversity.\n" +
                        "5. COVID-19 AND CONSERVATION: Southeast Asian nations have faced the challenge of balancing nature conservation with pandemic response, with intact ecosystems crucial for preventing future infectious disease outbreaks.\n" +
                        "6. ECONOMIC BENEFITS OF CONSERVATION: Investing in nature and adopting green recovery policies could generate millions of jobs and trillions in business opportunities by 2030, yet many Southeast Asian leaders remain unconvinced of these benefits.\n" +
                        "7. ECONOMIC IMPLICATIONS: ASEAN countries are cautious about the economic repercussions of the 30x30 pledge, primarily when they rely on natural resources for poverty reduction and development.\n" +
                        "8. SECURING FUNDING: Delayed support from Southeast Asian nations for the 30x30 target may be a strategic move to secure additional funding from wealthier countries.\n" +
                        "9. INDIGENOUS RIGHTS AND CONSERVATION: Respecting the rights of indigenous groups in protected areas is a vital aspect of the 30x30 pledge, acknowledging their crucial role in conservation efforts.\n" +
                        "10. GREEN GRABBING CONCERNS: While addressing biodiversity loss is essential, care must be taken not to displace indigenous communities through initiatives like 30x30 and overlook sustainable coexistence with nature.\n",
                R.drawable.img_297,
                "https://news.abs-cbn.com/spotlight/06/30/21/philippines-among-southeast-asian-nations-missing-from-push-to-protect-30-of-planet",
                "https://sa.kapamilya.com/absnews/abscbnnews/media/2021/reuters/06/30/philippines-environment-river.jpg")
        )
        dataList.add(
            DataItem("SUSTAINABLE FOREST MANAGEMENT IN THE PHILIPPINES",
                "In the pursuit of sustainable forest management, the Philippines has undertaken a transformative journey. Through its National Greening Program, the nation is rejuvenating degraded forests, expanding forest cover, and fostering environmental resilience.\"\n\n" +
                        "1. PROGRAM OBJECTIVES: The National Greening Program aims to expand forest cover, mitigate climate change impacts, conserve biodiversity, alleviate poverty, and promote inclusive growth while adhering to principles of good governance.\n" +
                        "2. PROGRAM EXTENSION: The program's extension until 2028 aligns with the Philippine Master Plan for Forestry Development and the National Development Plan.\n" +
                        "3. IMPRESSIVE ACHIEVEMENTS: The success of the program has already led to the rehabilitation of 1.8 million hectares of forests in seven years.\n" +
                        "4. COMMUNITY INVOLVEMENT: Over 600,000 people from upland communities have found employment through the program, emphasizing the role of local communities in sustainable forest management.\n" +
                        "5. FOREST COVER INCREASE: Forest cover has increased from 23% to 28%, demonstrating substantial progress in the rejuvenation of forested areas.\n" +
                        "6. RESILIENCE AND EMPOWERMENT: The program results in more resilient, empowered, and productive citizens, contributing to both environmental and social well-being.\n" +
                        "7. UN STRATEGIC PLAN FOR FORESTS 2030: The Philippines commits to aligning its efforts with the United Nations Strategic Plan for Forests 2030, emphasizing sustainable forest management and integrated development policies.\n" +
                        "8. GOOD GOVERNANCE: Strict adherence to good governance principles and inclusive growth is pivotal to the success of the country's forest management programs.\n" +
                        "9. UN FORUM ON FORESTS: The Philippines' participation in the UN Forum on Forests highlights its dedication to global cooperation and the pursuit of sustainable forest management.\n" +
                        "10. COMMITMENT TO SUSTAINABILITY: The Philippines remains committed to promoting sustainable forest management, reflecting its dedication to environmental conservation and responsible governance.",
                R.drawable.img_298,
                "https://forestry.denr.gov.ph/index.php/ph-affirms-commitment-to-promote-sustainable-forest-managment",
                "https://goharibon.files.wordpress.com/2015/09/frb-main-img.jpg")
        )

        dataList.add(
            DataItem("INDIGENOUS LAND RIGHTS AND PRESERVATION",
                "The Indigenous Peoples Rights Act of 1997, Republic Act No. 8371, is a pivotal piece of legislation that recognizes and safeguards the land rights of Indigenous Cultural Communities/Indigenous Peoples (ICCs/IPs) in the Philippines. This act ensures equal rights, cultural integrity, and the preservation of indigenous ancestral domains.\"\n" +

                        "1. LEGAL RECOGNITION OF INDIGENOUS RIGHTS: The act recognizes and promotes the rights of ICCs/IPs in the Philippines.\n" +
                        "2. PRESERVATION OF CULTURE: It aims to preserve the rich cultures, traditions, and institutions of ICCs/IPs.\n" +
                        "3. DEFINITION OF ANCESTRAL DOMAINS: It defines 'ancestral domain' and 'ancestral land,' providing a legal basis for land and resource claims by ICCs/IPs.\n" +
                        "4. CERTIFICATE OF ANCESTRAL DOMAIN TITLE: Once ancestral domains are delineated, the communities receive a certificate of ancestral domain title (CADT) that confirms their ownership and control.\n" +
                        "5. COMPREHENSIVE RIGHTS: ICCs/IPs are granted various rights, including ownership, resource management, the right to stay in their territories, and the right to clean air and water.\n" +
                        "6. RESETTLEMENT RIGHTS: The act safeguards the right of resettlement for ICCs/IPs in case of displacement from their ancestral lands.\n" +
                        "7. REGULATION OF IMMIGRATION: ICCs/IPs have the authority to regulate the entry of immigrants into their territories.\n" +
                        "8. LAND CONFLICT RESOLUTION: The act allows for the resolution of land conflicts based on customary laws within the community, promoting traditional conflict resolution.\n" +
                        "9. NATIONAL COMMISSION ON INDIGENOUS PEOPLES (NCIP): The NCIP serves as the primary government agency to assist ICCs/IPs, implementing policies, and issuing ancestral land/domain titles.\n" +
                        "10. ANCESTRAL DOMAINS FUND: The creation of the Ancestral Domains Fund covers compensation, delineation, and development of ancestral domains, ensuring communities' economic well-being.\n",
                R.drawable.img_299,
                "https://www.fao.org/faolex/results/details/en/c/LEX-FAOC013930/#:~:text=Philippines-,Indigenous%20Peoples%20Rights%20Act%201997%20(Republic%20Act%20No.,therefor%2C%20and%20for%20other%20purposes.",
                "https://theowp.org/wp-content/uploads/2021/08/PHIL2770a.jpg")
        )

        dataList.add(
            DataItem("UNLOCKING THE ECONOMIC POTENTIAL OF RAINFORESTS",
                "In the world's tropical rainforests, a crucial resource for economic growth is at risk. With deforestation and degradation threatening these ecosystems, the global community must recognize the economic value of rainforests and take action to restore and protect them.\n\n\n" +

                        "1. ENVIRONMENTAL STEWARDSHIP: This study fosters a sense of environmental responsibility among students, empowering them to actively participate in preserving vital watersheds.\n" +
                        "2. LEGAL LITERACY: Students gain insights into Philippine environmental laws and the need for clear-cut policies, enhancing their legal literacy for informed citizenship.\n" +
                        "3. COMMUNITY ENGAGEMENT: It inspires students to engage in community-level advocacy, helping protect their local watersheds and fostering a sense of civic responsibility.\n" +
                        "4. POLICY ADVOCACY: The study equips students with the knowledge and skills needed to advocate for improved environmental policies, promoting effective civic engagement.\n" +
                        "5. SOCIAL JUSTICE: Students understand the impact of watershed protection on indigenous communities, encouraging them to stand up for social and environmental justice.\n" +
                        "6. CONSERVATION AWARENESS: It raises awareness about the value of watersheds and their crucial role in sustaining ecosystems, cultivating a culture of conservation.\n" +
                        "7. LOBBYING AND ADVOCACY: Students learn about effective lobbying and advocacy techniques, preparing them to influence policy changes and protect natural resources.\n" +
                        "8. ECONOMIC AND ENVIRONMENTAL BALANCE: The study highlights the delicate balance between economic development and environmental preservation, encouraging students to explore sustainable solutions.\n" +
                        "9. PUBLIC INVOLVEMENT: It emphasizes the significance of public participation in decision-making processes, fostering an understanding of civic advocacy in a democratic society.\n" +
                        "10. ENVIRONMENTAL EDUCATION: This study promotes environmental education, making students more conscious of the broader issues related to environmental policies and civic advocacy.",
                R.drawable.img_300,
                "https://www.rappler.com/environment/234683-restore-tropical-rainforests-around-world-map/",
                "https://www.rappler.com/tachyon/2023/03/rafflesia-propagation-group.jpg?fit=1024%2C1024")
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