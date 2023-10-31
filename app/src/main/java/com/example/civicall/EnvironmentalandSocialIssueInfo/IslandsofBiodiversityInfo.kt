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

class IslandsofBiodiversityInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_islandsof_biodiversity_info)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "THREATS TO UNIQUE ECOSYSTEMS IN THE PHILIPPINES",
                "Amidst the natural beauty of the Philippines lies a pressing concern: threats to unique ecosystems. This article delves into the environmental challenges faced by the country and initiatives to safeguard its exceptional biodiversity.\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. ECOLOGICAL VULNERABILITY: The Philippines faces environmental challenges, particularly the vulnerability of its unique ecosystems.\n\n" +
                        "2. RESOURCE DEGRADATION: Ineffective management has led to the degradation of significant biodiversity resources.\n\n" +
                        "3. POLLUTION LEVELS: Water and air pollution exceed healthy standards, impacting both the environment and public health.\n\n" +
                        "4. CLIMATE CHANGE IMPACT: Greenhouse gas emissions are rising, with adverse effects from the transport and power sectors.\n\n" +
                        "5. RESILIENCE NECESSITY: To ensure stability and prosperity, the Philippines must enhance its environmental resilience.\n\n" +
                        "6. ECONOMIC SIGNIFICANCE: Natural resources contribute substantially to the country's economy.\n\n" +
                        "7. RESOURCE DEPENDENCY: Agriculture, fisheries, and forestry represent a significant portion of GDP and employment.\n\n" +
                        "8. ECOSYSTEM SERVICES: Natural capital provides crucial services such as energy, water supply, and flood control.\n\n" +
                        "9. CONSERVATION EFFORTS: Initiatives like the U.S. Forest Service program focus on sustainable forest management.\n\n" +
                        "10. BIODIVERSITY PROTECTION: Programs like 'Protect Wildlife' aim to safeguard the country's rich biodiversity.\n\n",

                "https://owt-thephilippines.weebly.com/uploads/2/4/5/9/24599948/807291_orig.jpg",
                "https://www.usaid.gov/philippines/environment#:~:text=The%20Philippines'%20rich%20biodiversity%20is,fishing%20and%20illicit%20wildlife%20trade."

            )
        )
        dataList.add(
            DataItem("CONSERVATION EFFORTS AND SUCCESSES IN THE PHILIPPINES",
                "In the Philippines, rich biodiversity is at risk, with overexploitation and environmental degradation threatening its natural treasures. This article explores the critical need for conservation efforts and successes to safeguard the country's unique ecosystems and resources.\n\n" +
                        "1. IMPORTANCE OF BIODIVERSITY CONSERVATION IN THE PHILIPPINES\n" +
                        "   - The Philippines is one of the world's mega-biodiverse countries, with extraordinary natural wealth.\n\n" +
                        "2. THREATS TO BIODIVERSITY IN THE PHILIPPINES\n" +
                        "   - Overexploitation, pollution, and climate change are causing alarming rates of biodiversity loss in the Philippines.\n\n" +
                        "3. ECOLOGICAL SIGNIFICANCE OF PHILIPPINE BIODIVERSITY\n" +
                        "   - The country's marine waters are considered the epicenter of marine biodiversity on Earth.\n\n" +
                        "4. ECONOMIC AND SOCIAL IMPACT OF BIODIVERSITY CONSERVATION\n" +
                        "   - Biodiversity management can reduce poverty, preserve livelihoods, and contribute to national economic growth in the Philippines.\n\n" +
                        "5. DEPENDENCE ON NATURAL RESOURCES\n" +
                        "   - Nearly 70% of the Philippines' population depends on the environment and natural resources for their livelihoods.\n\n" +
                        "6. ECONOMIC VALUE OF GENETIC RESOURCES\n" +
                        "   - Global sales of pharmaceuticals derived from the Philippines' genetic resources account for billions of dollars.\n\n" +
                        "7. REVENUE FROM MARINE COASTAL RESOURCES\n" +
                        "   - Marine coastal resources in the Philippines generate over $556 million annually.\n\n" +
                        "8. LINK BETWEEN BIODIVERSITY AND TOURISM\n" +
                        "   - Conserving natural beauty in the Philippines is directly linked to generating significant revenue from tourism.\n\n" +
                        "9. CIRCULAR NATURE OF BIODIVERSITY MANAGEMENt\n" +
                        "   - Effective biodiversity management can create revenue to further support conservation efforts.\n\n" +
                        "10. URGENT NEED FOR INCREASED BIODIVERSITY SPENDING\n" +
                        "    - The article calls for increased government spending on biodiversity, securement of remaining biodiversity pockets, and incentives for research and development in genetic biodiversity areas.\n\n",

                "http://static.rappler.com/images/greenseaturtle-20120120.jpg",
                "https://www.rappler.com/voices/thought-leaders/133722-investing-biodiversity-future-undp/"
             )
        )
        dataList.add(
            DataItem("THE ROLE OF INDIGENOUS COMMUNITIES IN BIODIVERSITY CONSERVATION",
                "Amidst the unpredictable shifts in weather patterns and the growing challenges posed by modern agricultural practices, indigenous communities are embarking on a remarkable journey of rediscovery. They are delving into the wisdom of age-old traditions to safeguard their natural heritage, all while nurturing the ecological balance that has sustained them for generations.\"\n\n" +
                        "1. CULTURAL REVIVAL: Indigenous communities are rediscovering traditional practices to protect their natural heritage.\n\n" +
                        "2. SUSTAINABLE FARMING: The focus is on sustainable agriculture without synthetic chemicals or fertilizers.\n\n" +
                        "3. DIVERSE CROP VARIETIES: Farmers are cultivating a rich variety of traditional crops, including heirloom rice.\n\n" +
                        "4. COMMUNAL COOPERATION: The spirit of bayanihan is uniting these communities towards a common goal.\n\n" +
                        "5. SEED PRESERVATION: Efforts are made to collect and document heirloom seeds for future generations.\n\n" +
                        "6. ENVIRONMENTAL DIVERSITY: Traditional farming practices enhance ecological diversity and resilience.\n\n" +
                        "7. CHALLENGES FROM CLIMATE CHANGE: Communities face challenges from extreme weather patterns due to climate change.\n\n" +
                        "8. HYBRID CROP COMPETITION: High-yield hybrid crops and herbicides hinder traditional farming.\n\n" +
                        "9. PRESERVING INDIGENOUS KNOWLEDGE: The focus is on restoring not just crops but also indigenous practices.\n\n" +
                        "10. CULTURAL CELEBRATIONS: Festivals like the Pinipig Festival help revive lost traditions and knowledge.\n\n",

                "https://www.rappler.com/tachyon/2023/08/Tboli-farmers.jpeg?resize=1632%2C1224&zoom=1",
                "https://www.rappler.com/nation/mindanao/tboli-indigenous-crops-methods-soccsksargen-august-2023/"
              )
        )

        dataList.add(
            DataItem("ECOTOURISM AND ITS IMPACT ON BIODIVERSITY IN THE PHILIPPINES",
                "In the picturesque landscapes of the Philippines, the delicate balance between ecotourism and biodiversity conservation is a pressing concern. As the country's natural treasures attract visitors, the need to protect these unique ecosystems takes center stage.\"\n\n\n" +
                        "1. GROWING ECOTOURISM: The Philippines experiences a surge in ecotourism, drawing nature enthusiasts from around the world.\n\n" +
                        "2. NATURAL TREASURES: The country boasts unique landscapes, islands, and biodiversity, making it a prime ecotourism destination.\n\n" +
                        "3. CHALLENGES OF ECOTOURISM: Balancing the demands of ecotourism with biodiversity conservation poses a significant challenge.\n\n" +
                        "4. BIODIVERSITY HOTSPOT: The Philippines is renowned for its exceptional biodiversity, which faces increasing pressure due to ecotourism.\n\n" +
                        "5. ENVIRONMENTAL IMPACT: The influx of tourists has led to concerns about water quality, biodiversity loss, and unregulated business growth.\n\n" +
                        "6. GOVERNMENT INITIATIVES: The Department of Environment and Natural Resources is taking measures to mitigate the environmental impact of ecotourism.\n\n" +
                        "7. PROTECTING NATURAL WONDERS: Limitations on tourist entry and activities in certain areas aim to preserve the natural integrity of key locations.\n\n" +
                        "8. REGULATING BUSINESS GROWTH: Efforts include enforcing building restrictions near shorelines to prevent pollution.\n\n" +
                        "9. SEWAGE MANAGEMENT: The implementation of septage management and centralized sewage treatment aims to improve water quality.\n\n" +
                        "10. PLANNING FOR SUSTAINABLE GROWTH: Authorities are working on urban masterplans and land reclassification to ensure the responsible development of ecotourism.\n\n",

                "https://www.rappler.com/tachyon/r3-assets/612F469A6EA84F6BAE882D2B94A4B421/img/F90DF594A5DB4FDE8AA72C8E5C7D79F1/20130727-el-nido-01.jpg",
                "https://www.rappler.com/environment/194936-el-nido-tourism-environment-management/"
             )
        )

        dataList.add(
            DataItem("INTERNATIONAL COLLABORATION IN BIODIVERSITY PRESERVATION IN THE PHILIPPINES",
                "In the heart of the Philippines, international collaboration blooms to safeguard its precious biodiversity. Discover the collective efforts shaping the future of biodiversity preservation in this island nation.\n\n\n" +
                        "1. BIODIVERSITY PARTNERSHIPS PROJECT (BPP): The Philippines is engaged in the Biodiversity Partnerships Project, a collaborative effort to enhance local government involvement in biodiversity conservation.\n\n" +
                        "2. FINANCIAL GRANT FOR CONSERVATION: The project received a financial grant from the Global Environmental Facility (GEF) and United Nations Development Programme, emphasizing international cooperation for biodiversity preservation.\n\n" +
                        "3. HABITAT FRAGMENTATION: Inadequate policies, tools, and local government participation have led to habitat fragmentation, a key concern addressed by the project.\n\n" +
                        "4. LOCAL GOVERNMENT EMPOWERMENT: The BPP aims to build the capacity of local government units (LGUs) to integrate biodiversity conservation in agricultural landscapes, fostering sustainable resource management.\n\n" +
                        "5. THREE-PRONGED APPROACH: The project utilizes a three-pronged approach: strengthening national-level policies, enhancing LGU capacities, and demonstrating improvements in pilot sites.\n\n" +
                        "6. COLLABORATIVE PARTNERSHIPS: BPP collaborates with national government agencies, LGUs, and conservation NGOs, pooling resources and expertise.\n\n" +
                        "7. NATIONAL-LEVEL SUPPORT: Outcome 1 focuses on implementing national-level systems and policies to bolster LGU biodiversity conservation efforts.\n\n" +
                        "8. LOCAL GOVERNMENT CAPACITY: Outcome 2 empowers LGUs across 1.6 million hectares in critical regions to incorporate sustainable management into decentralized government structures.\n\n" +
                        "9. LANDSCAPE-LEVEL CONSERVATION: Outcome 3 promotes the application of systems, policies, and capacities for landscape-level biodiversity conservation across eight pilot sites covering 700,000 hectares.\n\n" +
                        "10. MULTI-STAKEHOLDER ENGAGEMENT: The project involves collaboration between the Biodiversity Management Bureau, national and local government agencies, NGOs, indigenous communities, and various stakeholders, highlighting international cooperation for biodiversity preservation in the Philippines.",

                "https://2017-2020.usaid.gov/sites/default/files/pressreleases/Protect_Wildlife_Launch_1-1.jpg",
                "https://www.philchm.ph/partnerships-for-biodiversity-conservation-biodiversity-partnerships-project-bpp/"
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