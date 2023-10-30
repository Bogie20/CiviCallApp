package com.example.civicall.PublicHealtAwarenessInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.Dashboard
import com.example.civicall.R
import com.example.civicall.databinding.ActivityEmpoweringCommunitiesInfoBinding

class EnvironmentalHealthinthePhilippinesInfo : AppCompatActivity() {

    private lateinit var binding: ActivityEmpoweringCommunitiesInfoBinding  // De
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_environmental_healthinthe_philippines_info)

        binding = ActivityEmpoweringCommunitiesInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Now, you can use 'binding' to reference your views in the layout
        binding.back1.setOnClickListener {
            val intent = Intent(this, healtawarenessinfoMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "ENVIRONMENTAL HEALTH RISKS: NAVIGATING THE PERILS WE FACE",
                "Amidst the breathtaking landscapes of the Philippines lies a pressing concern: environmental health risks. Discover how air pollution, plastic pollution, marine contamination, and sea level rise threaten the well-being of its people in 2023.\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. AIR POLLUTION CRISIS: The Philippines faces a severe air pollution crisis, with an annual mean of fine particulate matter far exceeding recommended levels, largely due to burning fossil fuels and vehicular emissions.\n\n" +
                        "2. PLASTIC POLLUTION CHALLENGE: The country grapples with staggering plastic pollution, generating 2.7 million tons of plastic waste annually, primarily because of inefficient waste management and heavy reliance on single-use plastics.\n\n" +
                        "3. MARINE POLLUTION CONUNDRUM: The Philippines is the third-largest contributor to marine plastic pollution globally, with 20% of its plastic waste ending up in the sea, endangering marine life and biodiversity.\n\n" +
                        "4. SEA LEVEL RISE THREAT: Frequent floods in 2022, coupled with rising sea levels, pose a significant threat to coastal regions. The capital city, Manila, faces displacement by 2100 if current trends persist.\n\n" +
                        "5. GOVERNMENT INITIATIVES: The Department of Environment and Natural Resources (DENR) is taking steps to combat air pollution spikes due to factors like increased vehicle traffic and firecracker use.\n\n" +
                        "6. EXTENDED PRODUCER RESPONSIBILITY ACT (EPRA): In 2022, the government introduced EPRA, obligating companies to create programs for plastic waste reduction, with an 80% offset or recovery target by 2028.\n\n" +
                        "7. EFFORTS TO CURB MARINE POLLUTION: The government partners with organizations like the World Wide Fund for Nature (WWF) to address marine pollution around ports and implement a National Plan of Action on Marine Litter.\n\n" +
                        "8. INCOMPLETE SEA LEVEL RISE MITIGATION: While measures like seawalls have been taken, experts argue that more comprehensive strategies are needed to protect coastal regions from sea level rise.\n\n" +
                        "9. PUBLIC AWARENESS AND COMMITMENT: Successful solutions to these environmental challenges require not only government actions but also the commitment and participation of the public.\n\n" +
                        "10. COLLABORATIVE GLOBAL EFFORTS: The Philippines' environmental issues highlight the need for global cooperation to address climate change and environmental health risks.",
                R.drawable.img_366,
                "https://earth.org/environmental-issues-in-the-philippines/",
                "https://u4d2z7k9.rocketcdn.me/wp-content/uploads/2022/11/11290331484_fd8538ba22_k-1536x908.jpg.webp"
            )
        )
        dataList.add(
            DataItem("POLLUTION: THE LOOMING THREAT TO OUR ECOSYSTEM",
                "Amidst the scenic beauty of the Philippines lies a looming threat to its ecosystem – pollution. From tainted air to contaminated waters and plastic waste, the country grapples with environmental challenges that demand urgent attention and action.\n\n" +
                        "1. AIR POLLUTION IN THE PHILIPPINES: The Philippines faces significant air pollution problems, with air quality often exceeding recommended levels, leading to severe health impacts.\n\n" +
                        "2. CONSEQUENCES OF FOSSIL FUEL USAGE: Air pollution, primarily caused by fossil fuel consumption, results in approximately 27,000 premature deaths annually, with an economic cost of 1.9% of GDP.\n\n" +
                        "3. WATER POLLUTION IN PASIG RIVER: The Pasig River, a crucial water system in Metro Manila, has suffered from pollution, impacting its potential for fisheries, recreation, and manufacturing.\n\n" +
                        "4. PLASTIC POLLUTION IN RIVERS: The Philippines, particularly the Pasig River, ranks as a major contributor to riverine plastic emissions into the ocean, affecting Laguna de Bay and Manila Bay.\n\n" +
                        "5. CHALLENGES IN LAGUNA DE BAY: Laguna de Bay, a vital natural asset, faces issues such as eutrophication, harmful algal blooms, and pollution, impacting fishing, agriculture, and domestic supply.\n\n" +
                        "6. SOLID WASTE MANAGEMENT ISSUES: The Philippines struggles with solid waste management, generating millions of tonnes of waste, leading to pollution in water bodies and urban areas.\n\n" +
                        "7. PLASTIC POLLUTION CRISIS: The Philippines is a top global generator of plastic waste, contributing to ocean pollution, exacerbated by the surge in single-use plastics due to the COVID-19 pandemic.\n\n" +
                        "8. HISTORICAL EVOLUTION OF POLLUTION POLICIES: The country has recognized pollution as a major issue, with policies dating back to 1964, leading to the formation of environmental agencies such as DENR.\n\n" +
                        "9. KEY ENVIRONMENTAL LAWS: Laws like the Clean Air Act, Clean Water Act, and Ecological Solid Waste Management Act have been enacted to address pollution and environmental concerns.\n\n" +
                        "10. CHALLENGES IN POLICY IMPLEMENTATION: Despite these policies, challenges persist in implementing pollution control measures due to enforcement issues, inadequate resources, and low public awareness.",
                        R.drawable.img_367,
                "https://dicf.unepgrid.ch/philippines/pollution#:~:text=Air%2C%20waste%20and%20water%20pollution,rapid%20development%2C%20industrialization%20and%20urbanization.",
                "https://www.flipscience.ph/wp-content/uploads/2018/06/FS.Covers.Oct-Nov2018-2.jpg")
        )
        dataList.add(
            DataItem("CLIMATE CHANGE IMPACT: ADAPTING TO A CHANGING WORLD",
                "Amidst the growing threats of climate change, the Philippines finds itself on the frontline of environmental challenges, with rising sea levels and extreme weather events becoming increasingly disruptive. In this dynamic landscape, the nation must adapt to ensure its resilience and take bold steps towards mitigating the effects of a changing world.\"\n\n" +
                        "1. WARNING ON RISING SEA LEVELS: The Philippines warns that rising sea levels pose a threat to its boundaries and coastal areas.\n\n" +
                        "2. VULNERABILITY TO SEA LEVEL RISE: With over half of its cities and communities along coasts, the Philippines is highly vulnerable to sea level rise due to climate change.\n\n" +
                        "3. OBSERVATIONS OF SEA LEVEL RISE: The Philippines has seen sea levels rise by 60 centimeters, significantly higher than the global average.\n\n" +
                        "4. NATIONAL SECURITY IMPACT: Sea level rise endangers national security, affecting sovereignty, well-being, and the way of life, particularly for coastal communities.\n\n" +
                        "5. PEOPLE-CENTERED APPROACH: Discussions on the implications of sea level rise on peace and security should prioritize people's well-being.\n\n" +
                        "6. PREVENTING CONFLICT: Stability in boundaries is essential to prevent conflict, and a focus on certainty and predictability is crucial.\n\n" +
                        "7. UN'S ROLE: The United Nations, including the Security Council, should consider the Intergovernmental Panel on Climate Change's findings and recommendations.\n\n" +
                        "8. ACCELERATED GLOBAL SEA LEVEL RISE: Global sea levels have risen faster since 1900 than in the past 3,000 years, even with limited global warming.\n\n" +
                        "9. RISK TO UN MEMBER STATES: Sea level rise poses a real risk to over two-thirds of UN member states, impacting maritime zones and resource access.\n\n" +
                        "10. MASS DISPLACEMENT THREAT: Nearly 900 million people living in low-lying coastal zones face the risk of displacement, resource competition, and a potential mass exodus.",
                R.drawable.img_368,
                "https://www.philstar.com/headlines/2023/02/20/2246224/rising-sea-level-threatens-stability-boundaries-philippines-warns",
                "https://icsc.ngo/wp-content/uploads/2020/03/AFP_manila-residents-flooding-storm.jpg")
        )

        dataList.add(
            DataItem("GREEN INITIATIVES: PAVING THE WAY FOR A SUSTAINABLE FUTURE",
                "In the lush archipelago of the Philippines, a green revolution is underway. As the nation confronts the challenges of environmental sustainability, innovative green initiatives are paving the way for a more sustainable and eco-conscious future.\"\n" +

                        "1. CLIMATE CHANGE'S VISIBLE IMPACT: The Philippines faces the stark reality of climate change, with rising sea levels, more frequent typhoons, and destructive storms making the effects increasingly visible.\n\n" +
                        "2. ENVIRONMENTAL VULNERABILITY: Due to its geographical location, the Philippines is among the most vulnerable nations to climate change, posing threats to both human life and the economy.\n\n" +
                        "3. BIODIVERSITY HOTSPOT: The country boasts a remarkable biodiversity, holding two-thirds of the world's species. It depends on this diverse ecosystem for essential resources and tourism-driven economic growth.\n\n" +
                        "4. CLIMATE CHANGE LEGISLATION: The Philippine government enacted the Climate Change Act in 2009 to foster climate resilience, low-carbon growth, and global climate engagement.\n\n" +
                        "5. RENEWABLE ENERGY CHALLENGES: While over 70% of the country's energy comes from fossil fuels, the Philippines aims to increase renewable energy's share to 35% by 2030, focusing on overcoming obstacles to adoption.\n\n" +
                        "6. FOREIGN INVESTMENTS IN GREEN ENERGY: Foreign companies like GE and Arran Investment are partnering with local entities to promote renewable energy sources, including concentrated solar power and photovoltaic systems.\n\n" +
                        "7. SUSTAINABLE TOURISM: The tourism sector, while a significant economic driver, poses environmental challenges. The Department of Tourism is working to rehabilitate tourist destinations with a focus on sustainability.\n\n" +
                        "8. GRASSROOTS ENVIRONMENTAL INITIATIVES: Marginalized communities and NGOs are driving social enterprises that protect the environment, assist small-scale agricultural producers, and bolster communities against climate change.\n\n" +
                        "9. YOUTH CLIMATE ACTIVISM: Filipino youth are taking up the mantle of climate activism, demanding climate justice and advocating for solutions to combat the climate crisis.\n\n" +
                        "10. SUSTAINABLE DEVELOPMENT GOALS: The Philippines is actively working to improve its ranking in the United Nations Sustainable Development Report, aiming for a future where sustainability and environmental conservation thrive.",
                R.drawable.img_369,
                "https://priorityconsultants.com/blog/green-is-in-the-rise-of-environmental-sustainability-in-the-philippines/",
                "http://new.priorityconsultants.com/wp-content/uploads/2021/05/PC-Green-blogpost4-1024x538.jpg")
        )

        dataList.add(
            DataItem("ECO-AWARENESS: FOSTERING ENVIRONMENTAL CONSCIOUSNESS",
                "In the face of the COVID-19 pandemic, addressing vaccine hesitancy in the Philippines is paramount. This article explores the challenges, historical concerns, and legal aspects surrounding vaccine hesitancy, emphasizing the need for transparent policy responses.\n\n\n" +
                        "1. BREEZE'S ECOPROJECT: Breeze's ongoing EcoProject campaign focuses on nurturing eco-awareness among young children.\n\n" +
                        "2. ENVIRONMENTAL PROTECTION: The campaign aims to raise awareness about environmental protection, particularly in the Global South.\n\n" +
                        "3. BEHAVIORAL CHANGE: Breeze recognizes the need for behavioral change in caring for the environment and believes that children play a key role in this transformation.\n\n" +
                        "4. ECO-FRIENDLY FORMULATION: Breeze has introduced an eco-friendly formulation for its laundry powder, incorporating naturally derived stain removers and biodegradable ingredients.\n\n" +
                        "5. REDUCTION IN CRUDE-OIL BASED INGREDIENTS: This formulation uses 25% less crude-oil based ingredients compared to the 2013 version of the product.\n\n" +
                        "6. LEARNING THROUGH GETTING DIRTY: Breeze believes that children can learn and create a positive impact by getting involved in environmental activities, even if it means getting dirty.\n\n" +
                        "7. EMPOWERING CHILDREN: The campaign empowers children to take action and feel they can make a difference when they see something wrong.\n\n" +
                        "8. PARTNERSHIPS WITH KNOWLEDGE CHANNEL: Breeze collaborates with Knowledge Channel, Department of Education, and School District Officers to engage third graders in eco-missions.\n\n" +
                        "9. ECODIARY AND PRIZES: Students participate in educational videos and eco-missions, documenting their experiences in EcoDiaries for a chance to win prizes.\n\n" +
                        "10. ECOLLECT PROGRAM: Breeze's Ecollect program collects plastic waste from schools and upcycles it, reinforcing the message that small actions can make a significant impact on the environment.",
                R.drawable.img_370,
                "https://www.cnnphilippines.com/lifestyle/2022/12/12/getting-dirty-for-good-breeze-ecoproject.html",
                "https://www.cnnphilippines.com/.imaging/default/dam/cnn/2022/12/12/ADVERTORIAL%20BREEZE%20ECOPROJECT/BREEZE-ECOPROJECT-1.png/jcr:content.png?width=750&height=450&crop:1:1,smart")
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