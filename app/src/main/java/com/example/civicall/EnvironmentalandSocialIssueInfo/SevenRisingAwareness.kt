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

class SevenRisingAwareness : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven_rising_awareness)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "COASTAL EROSION AND SEA-LEVEL RISE IN THE PHILIPPINES",
                "In the Philippines, rising sea levels are eroding the very foundations of coastal communities, spelling a grim future for those on the frontlines of climate change. As coastal erosion and sea-level rise accelerate, the survival of these vulnerable regions hangs in the balance.\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. THREATENED EXISTENCE: Coastal community in the Philippines battles sea-level rise.\n   - Coastal communities in the Philippines, such as Isla Pamarawan, are under threat from rising sea levels, impacting their survival.\n\n" +
                        "2. GLOBAL CHALLENGE: The Philippines faces a sea-level rise exceeding the global average threefold.\n   - The Philippines is experiencing a significant sea-level rise that is three times the global average.\n\n" +
                        "3. VULNERABLE COMMUNITIES: Fisherfolk bear the brunt of climate change in the Philippines.\n   - Fisherfolk in the Philippines, the poorest sector in the country, face the devastating impacts of sea-level rise and more intense storms.\n\n" +
                        "4. CHILDREN AT RISK: Young people in coastal areas are most vulnerable to sea-level rise.\n   - Children living in coastal communities, like Isla Pamarawan, face increased risks due to sea-level rise.\n\n" +
                        "5. DAILY STRUGGLES: Students wade through knee-deep waters to attend school.\n   - Students in affected areas must navigate flooded streets daily to reach their schools.\n\n" +
                        "6. ECONOMIC IMPACT: The construction of a new airport intensifies flooding in coastal areas.\n   - The building of the New Manila International Airport has exacerbated flooding and adverse effects on local fishing communities.\n\n" +
                        "7. ENVIRONMENTAL CONSEQUENCES: Reclamation projects threaten marine life and food security.\n   - Reclamation activities in Bulacan jeopardize both marine ecosystems and the nation's food security.\n\n" +
                        "8. LOCAL CONCERNS: Fisherfolk receive inadequate compensation for the airport's construction.\n   - Local fishermen affected by airport development receive minimal compensation and express concerns about their livelihoods.\n\n" +
                        "9. URGENT CALL FOR ACTION: Experts emphasize the need for revised development plans.\n   - Experts stress the importance of proactive measures and higher elevation development plans to mitigate the dangers of sea-level rise.\n\n" +
                        "10. HOPES FOR RESILIENCE: Coastal residents hold onto dreams of a sustainable way of life.\n    - Despite the challenges, coastal residents like Sarah and Benny hope for government support to sustain their way of life in the face of coastal erosion and sea-level rise.",

                "https://www.rappler.com/tachyon/2023/06/IMG_8073-scaled.jpg?resize=2560%2C1920&zoom=1",
                "https://www.rappler.com/environment/in-troubled-waters-rising-sea-levels-threaten-sinking-town-survival/"

            )
        )
        dataList.add(
            DataItem("IMPACT ON URBAN COMMUNITIES IN THE PHILIPPINES",
                "In Metro Manila, rapid urbanization is reshaping the city's landscape. This article explores the profound impact on urban communities in the Philippines' bustling capital\n\n" +
                        "1. CHALLENGES OF RAPID URBANIZATION: Metro Manila faces challenges in becoming a global power city due to rapid urbanization, including climate change effects, unequal livability, job creation, and poverty reduction.\n\n" +
                        "2. DEFINING THE CITY'S IDENTITY: The article emphasizes the importance of defining the city's identity and fostering a sense of 'lovability' among residents to enhance societal bonds and strengthen urban development.\n\n" +
                        "3. SUSTAINABLE DEVELOPMENT FOR QUALITY OF LIFE: Successful sustainable urban development should enhance people's quality of life, focusing on low-carbon targets, human scale, inclusivity, and quality of life improvement.\n\n" +
                        "4. MIXED-USE PLANNING FOR ACCESSIBILITY: Metro Manila needs mixed-use planning and coastal developments to provide accessible living conditions for residents across all social classes, promoting a healthy, affordable, and sustainable lifestyle.\n\n" +
                        "5. GREEN SPACES FOR HEALTH: The city lacks green spaces, with only 5 square meters per person, below the WHO's recommended 9 square meters. Accessible green areas can improve air quality, biodiversity, and overall well-being.\n\n" +
                        "6. ENHANCING HUMAN HEALTH AND WELLBEING: Well-planned cities with healthcare facilities, health coverage, and well-being infrastructure contribute to prosperous societies, but urbanization challenges impact the health sector in Metro Manila.\n\n" +
                        "7. BUILDING RESILIENT COMMUNITIES: Resilience is vital in the face of climate change and natural disasters. Proper urban designs, bike lanes, walkable streets, and technology-based solutions can enhance safety and adaptability.\n\n" +
                        "8. GLOBAL COMPETITIVENESS: Metro Manila, as a growth driver, can follow global models for integrated cities and coastal developments, fostering economic activities, tourism, and inclusive communities.\n\n" +
                        "9. INCLUSIVE GROWTH CENTERS: Inclusive development with well-designed master plans can energize communities, making the urban landscape an extension of their home and unlocking future potential.\n\n" +
                        "10. TOWARDS A COMPETITIVE AND VIBRANT FUTURE: Embracing history, celebrating milestones, and responding to residents' aspirations can make Metro Manila a competitive and vibrant city with a promising future.\n\n",

                "https://www.rappler.com/tachyon/2023/04/SM-Supermalls-reverb-2.jpg?resize=1920%2C1440&zoom=1",
                "https://www.rappler.com/brandrap/urban-development-goals-metro-manila/"
              )
        )
        dataList.add(
            DataItem("ADAPTATION AND MITIGATION STRATEGIES IN THE PHILIPPINES",
                "In the face of rising seas and climate change challenges, the Philippines is at a critical juncture, calling for robust adaptation and mitigation strategies. This article explores the complex landscape of coastal resilience and sustainable development in the country.\"\n\n" +
                        "1. COASTAL VULNERABILITY: Coastal communities in Metro Manila face existential threats from rising seas, affecting their homes and livelihoods.\n\n" +
                        "2. COMPLEX CLIMATE ADAPTATION: Planning for long-term climate adaptation, particularly sea level rise, is crucial for safeguarding the metropolis, but often overlooked due to its less dramatic nature.\n\n" +
                        "3. IMPACT ON VULNERABLE SECTORS: The most vulnerable groups, including fishers, are disproportionately affected, and their voices must be heard in adaptation efforts.\n\n" +
                        "4. INEQUALITIES IN URBAN PLANNING: Poor urban planning and land use policies contribute to Metro Manila's vulnerability to climate change, exacerbating existing inequalities among its residents.\n\n" +
                        "5. HOLISTIC SOLUTIONS NEEDED: Conventional disaster risk reduction measures do not adequately address the complexity of climate change and rapid urbanization, calling for more comprehensive strategies.\n\n" +
                        "6. ENGINEERING AND NATURE-BASED APPROACHES: Combining engineering solutions like sea walls with nature-based measures such as mangrove planting is essential to effectively mitigate climate impacts.\n\n" +
                        "7. SYSTEMIC THINKING: Viewing Metro Manila as an interconnected whole is critical to avoid passing climate-related problems from one city to another.\n\n" +
                        "8. COMPREHENSIVE RELOCATION PLANNING: Relocating coastal communities should be thoroughly studied and implemented to ensure the resilience of vulnerable populations.\n\n" +
                        "9. COMMUNITY ENGAGEMENT: Involving communities in dialogues and decisions is essential for effective adaptation and mitigation efforts.\n\n" +
                        "10. BROAD IMPACT ON DEVELOPMENT: Addressing sea level rise extends beyond environmental concerns, as it has far-reaching effects on various development indicators in the Philippines.\n\n",

                "https://newsinfo.inquirer.net/files/2021/09/08-SLR-story-AC-Dimatatac-Navotas1-14-July-2021-2048x1269.jpg",
                "https://newsinfo.inquirer.net/1493135/long-term-plans-needed-to-protect-metro-manilas-most-vulnerable-from-rising-seas"
             )
        )

        dataList.add(
            DataItem("EFFECTS ON LOCAL ECONOMIES IN THE PHILIPPINES",
                "Unlocking Economic Growth: A New Fisheries Initiative in the Philippines. The Philippines embarks on a transformative fisheries project set to empower local economies, bolster food security, and uplift coastal communities\"\n\n\n" +

                        "1. REVOLUTIONIZING PHILIPPINE FISHERIES: The article introduces a significant project, 'FISHCORE,' aimed at transforming the fisheries sector and local economies in the Philippines.\n\n" +
                        "2. OVER A MILLION BENEFICIARIES: FISHCORE is expected to positively impact over 1.15 million fisherfolk, businesses, and coastal residents.\n\n" +
                        "3. CHALLENGES IN THE FISHERIES SECTOR: The fisheries sector contributes 1.3 percent to the Philippines' GDP and has faced declining fish stocks and challenges such as over-exploitation and habitat degradation.\n\n" +
                        "4. IMPORTANCE OF FISHERIES: The sector provides 1.6 million jobs, a source of protein for over 50 percent of Filipino families, and a significant portion of the labor force.\n\n" +
                        "5. PROJECT OBJECTIVES: FISHCORE aims to improve fisheries management, elevate incomes, and enhance the value of fisheries production in coastal communities.\n\n" +
                        "6. GOVERNMENT COMMITMENT: The Philippine government is committed to sustainable fishing practices, aquaculture expansion, and poverty reduction within the industry.\n\n" +
                        "7. COMMUNITY RESILIENCE: FISHCORE's long-term goal is to promote community resilience through thriving fish stocks, food security, and reduced poverty.\n\n" +
                        "8. DOMESTIC AND INTERNATIONAL OPPORTUNITIES: The project seeks to expand opportunities for fishery products, ensuring a reliable fish supply for national food security and boosting competitiveness in small and medium fishery enterprises.\n\n" +
                        "9. WIDESPREAD IMPACT: Beyond fisherfolk, various industry stakeholders such as equipment providers, processors, and exporters are expected to benefit.\n\n" +
                        "10. FISHERIES MANAGEMENT AND SUSTAINABILITY: FISHCORE will support the creation of improved fisheries management systems, environmental conservation, and infrastructure development in selected coastal areas.",

                "https://cms-image-bucket-production-ap-northeast-1-a7d2.s3.ap-northeast-1.amazonaws.com/images/7/6/6/3/38473667-1-eng-GB/2021-07-09T034227Z_1538337702_RC2REO9V2145_RTRMADP_3_PHILIPPINES-CHINA-SOUTHCHINASEAre.jpg",
                "https://www.worldbank.org/en/news/press-release/2023/05/31/new-fisheries-initiative-will-benefit-over-a-million-people-in-the-phi#:~:text=The%20fisheries%20sector%20currently%20contributes,Filipino%20families'%20sources%20of%20protein."
                )
        )

        dataList.add(
            DataItem("COASTAL RESILIENCE INITIATIVES IN THE PHILIPPINES",
                "In a warming world with rising sea levels threatening coastal communities, the Philippines faces a pressing need for innovative solutions to enhance coastal resilience. This article explores policy implications and initiatives addressing climate resilience in the Philippines.\n\n\n" +
                        "1. URGENT CLIMATE THREAT: The Philippines faces a growing threat from climate change, with rising sea levels projected to affect millions of Filipinos by the end of the century.\n\n" +
                        "2. CLIMATE RESILIENCE CHALLENGE: A competition, known as the Climate Resilience Challenge, seeks innovative ideas to bolster the country's resilience in the face of climate change.\n\n" +
                        "3. 2022 FOCUS: The 2022 challenge centers on strategies for enhancing climate resilience in coastal communities.\n\n" +
                        "4. PRIORITY AREAS: The competition focuses on three priority areas, including climate-resilient livelihoods for vulnerable communities.\n\n" +
                        "5. LIVELIHOOD SOLUTIONS: Winning proposals should develop strategies and business models to secure sustainable livelihoods for coastal populations.\n\n" +
                        "6. ECOSYSTEM RESILIENCE: The competition seeks solutions to protect and enhance the resilience of marine and coastal ecosystems.\n\n" +
                        "7. SEA LEVEL RISE: Addressing sea-level rise and related coastal hazards is a crucial element of the challenge.\n\n" +
                        "8. MANAGEMENT TECHNIQUES: Proposals should include both hard and soft coastal management techniques to mitigate the impacts of sea-level rise.\n\n" +
                        "9. INCLUSIVE DESIGN: Preference is given to proposals that emphasize inclusivity and nature-based solutions for conservation and restoration.\n\n" +
                        "10. AWARDS: The most impactful solutions will be awarded 150,000PHP each, with finalists receiving 50,000PHP, and top solutions will be showcased in a public event organized by the OML Center.",

                "https://www.omlopezcenter.org/wp-content/uploads/2022/09/iStock-1316819108-640x480.jpg",
                "https://www.omlopezcenter.org/2022-0912-climate-resilience-challenge-toward-coastal-resilience-2022/"
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