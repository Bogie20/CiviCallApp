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

class JunglerInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_la_nina_info)




        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "NAVIGATION TECHNIQUES IN DENSE RAINFORESTS",
                "Navigating through the lush and unforgiving rainforests of the Philippines demands a unique set of skills and strategies. In this jungle wilderness, where dense vegetation conceals nature's secrets and operations require precision, mastering the art of jungle navigation becomes a paramount endeavor.\"\"\n\n" +
                        "1. STUDY THE TERRAIN: Begin by thoroughly studying the specific rainforest terrain you'll be navigating. Understand the local flora, fauna, and the distinct characteristics of the Philippine rainforests.\n\n" +
                        "2. CARRY ESSENTIAL GEAR: Equip yourself with the necessary gear, including a reliable compass, maps (if available), a machete or knife for cutting through thick vegetation, appropriate clothing, insect repellent, and a first aid kit.\n\n" +
                        "3. CREATE A PERSONAL PACE TABLE: Develop a personal pace table that records your average pace count per 100 meters for different types of terrain within the rainforest.\n\n" +
                        "4. PLAN YOUR ROUTE: Plan your route carefully, considering natural features like rivers or clearings that can act as navigational aids.\n\n" +
                        "5. USE DEAD RECKONING: Rely on dead reckoning for navigation due to the limited visibility in dense rainforests. Maintain a constant heading and track your distance using your pace count.\n\n" +
                        "6. IMPLEMENT RESECTION TECHNIQUES: In cases of uncertainty about your location, employ resection by calling for mortar or artillery fire at two widely separated grids and use the sound to determine your position.\n\n" +
                        "7. EMPLOY AREA/POINT NAVIGATION: Combine compass-based dead reckoning with terrain association to reach an easily identifiable intermediate objective in the rainforest, then navigate with point-to-point precision to your final destination.\n\n" +
                        "8. MAINTAIN STRICT PACE: Maintain a strict pace to avoid overestimating the distance traveled within the rainforest. Use the guidelines for maximum distances in different terrains to pace yourself accurately.\n\n" +
                        "9. STAY INFORMED ABOUT WEATHER: Stay informed about local weather patterns, as rainforests can experience heavy rainfall and high humidity. Adjust your navigation and gear accordingly.\n\n" +
                        "10. EXERCISE CAUTION AND PATIENCE: Exercise caution, patience, and vigilance when navigating the challenging and unpredictable Philippine rainforests. Always be prepared for unexpected encounters with wildlife or challenging terrain.\n\n",

                "https://www.mountainsafety.org.nz/assets/Uploads/Hunter-in-High-vis-Kerry-Adams__FillMaxWzEyMDAsNjMwXQ.jpg",
                "https://www.survivaliq.com/navigation/navigation-in-different-types-of-terrain_par3.htm"

            )
        )
        dataList.add(
            DataItem("SURVIVAL SKILLS FOR JUNGLE EXPLORATION",
                "\"Embark on a riveting journey into the heart of the Philippine rainforest, where survival skills are the key to thriving amidst lush wilderness. Join us as we delve into the world of jungle exploration and uncover the ancient secrets of thriving in one of Earth's most challenging environments.\n\n" +
                        "1. MASTERING BAMBOO CRAFTSMANSHIP: Learn to craft essential tools like spoons, forks, and cups from bamboo, a versatile material readily available in the Philippine jungle. These tools are invaluable for jungle survival.\n\n" +
                        "2. FORAGING SKILLS: Discover the edible plants, fruits, and roots native to the Philippines. A deep understanding of which plants are safe to eat can make the difference in a survival situation.\n\n" +
                        "3. WATER SOURCING: Acquire the knowledge and techniques for finding, purifying, and utilizing water sources in the jungle. Boiling spring water can be a life-saving skill.\n\n" +
                        "4. FIRE-MAKING TECHNIQUES: Understand the various methods of creating fire using natural resources found in the jungle, like dried leaves, wood shavings, and friction from bamboo. Fire provides warmth, protection, and a means of cooking.\n\n" +
                        "5. AETAS SURVIVAL TRADITIONS: Embrace the wisdom of the indigenous Aetas tribe. Learn their time-tested practices, which have been passed down through generations, and gain insights into their hunting, fishing, and survival skills.\n\n" +
                        "6. CULTURAL ADAPTATION: Develop a deeper understanding of the local culture and customs, which can be essential for building rapport and receiving help in a survival situation.\n\n" +
                        "7. BUSHCRAFT: Hone your bushcraft skills, focusing on shelter construction using jungle materials like leaves and branches. A well-built shelter offers protection from the elements.\n\n" +
                        "8. NAVIGATION: Learn to navigate the jungle terrain using natural signs and landmarks. Developing your sense of direction can help prevent getting lost.\n\n" +
                        "9. FIRST AID AND HERBAL MEDICINES: Familiarize yourself with jungle first aid and herbal remedies. Knowing how to treat injuries and illnesses with local flora is vital.\n\n" +
                        "10. RESPECT FOR NATURE: Cultivate a profound respect for the environment. Leave no trace, practice sustainable foraging, and ensure that your presence in the jungle has a minimal impact on the delicate ecosystem.\n\n",

                "https://discoveringalifejourney.files.wordpress.com/2015/12/12208488_10156209104380553_8796861032418703206_n.jpg",
                "https://discoveringalifejourney.wordpress.com/2015/12/11/jungle-survival-in-subic-zambales-philippines/"
              )
        )
        dataList.add(
            DataItem("MEDICINAL PLANTS AND FIRST AID IN THE JUNGLE",
                "\"Amidst the Philippine jungle's vibrant greenery, an extraordinary tradition unfolds – the Manobo Indigenous group's reliance on nature's medicinal plants for jungle first aid. Discover the secrets of \"Medicinal Plants and First Aid in the Philippines\" as this ancient practice gains wider recognition.\"\n\n" +
                        "1. PLANT IDENTIFICATION: Learn to identify indigenous medicinal plants in the Philippine jungle to distinguish their unique properties and uses.\n\n" +
                        "2. HARVESTING TECHNIQUES: Master the art of sustainably harvesting medicinal plants, ensuring the preservation of these vital resources.\n\n" +
                        "3. HERBAL REMEDY PREPARATION: Acquire skills in preparing herbal remedies from jungle plants for common ailments such as fever, diarrhea, and skin diseases.\n\n" +
                        "4. TRADITIONAL HEALING RITUALS: Explore the cultural significance of the Manobo Indigenous group's traditional healing rituals, including invoking permission from their deity.\n\n" +
                        "5. SNAKEBITE TREATMENT: Understand how to utilize specific plants for first aid in the event of snakebites, such as using piper vines soaked in coconut oil.\n\n" +
                        "6. INSECT BITE REMEDIES: Learn how to treat insect bites and stings using local plant-based solutions for immediate relief.\n\n" +
                        "7. ASTHMA AND COUGH RELIEF: Discover remedies from plants for conditions like asthma and coughs, mirroring the effectiveness of Western medicine.\n\n" +
                        "8. WOUND CARE: Master techniques for treating wounds, ulcers, and infections using herbal treatments from the jungle.\n\n" +
                        "9. KNOWLEDGE TRANSFER: Explore how the Manobo tribe passes down knowledge of medicinal plants to younger generations to ensure continuity of this ancient tradition.\n\n" +
                        "10. CONSERVATION EFFORTS: Understand the importance of preserving these medicinal plants, contributing to the conservation of the Manobo Indigenous group's lands and heritage.",

                "https://imgs.mongabay.com/wp-content/uploads/sites/20/2020/10/02070440/herbal6-1200x800.jpg",
                "https://news.mongabay.com/2020/10/a-philippine-tribes-plant-based-medical-tradition-gets-its-moment/"
             )
        )

        dataList.add(
            DataItem("COOKING WITH WILD INGREDIENTS IN THE JUNGLE",
                "\"In the heart of the Philippine jungle, a culinary revival unfolds as indigenous Negrito communities reignite their age-old tradition of 'Cooking with Wild Ingredients.' Journey into the lush wilderness of the Philippines to discover the vibrant flavors and culinary secrets of these forest specialists, preserving their heritage through delectable dishes.\"\n\n\n" +
                        "1. HARVESTING WILD BOUNTY: Venture into the jungle with experienced Negrito foragers to learn the art of sustainably gathering wild ingredients, from succulent mushrooms to exotic palm hearts.\n\n" +
                        "2. TRADITIONAL COOKING TECHNIQUES: Discover the ancient culinary methods handed down through generations as Negrito chefs demonstrate how to prepare delicious dishes over open flames using forest resources.\n\n" +
                        "3. FLAVORS OF THE JUNGLE: Explore the diverse tastes of the wild as you're introduced to unique ingredients such as wild banana, ferns, and forest honey, each contributing to the rich tapestry of jungle cuisine.\n\n" +
                        "4. CULINARY STORYTELLING: Engage with Negrito elders who share their cultural heritage and knowledge of traditional recipes, as stories blend with flavors, creating a profound connection to the jungle's culinary legacy.\n\n" +
                        "5. BUSHMEAT AND FRESHWATER DELIGHTS: Learn the delicate art of hunting and fishing, and understand the role of bushmeat, fish, clams, and crabs in Negrito cuisine, ensuring a deeper appreciation for these forest specialties.\n\n" +
                        "6. WILD INGREDIENT PRESERVATION: Explore techniques for preserving wild ingredients, from sun-drying mushrooms to creating unique marinades and sauces, allowing you to savor the jungle's bounty year-round.\n\n" +
                        "7. RECIPE EXCHANGES: Participate in recipe exchanges with Negrito communities, sharing your culinary traditions and gaining insights into the preparation of dishes that have sustained these communities for centuries.\n\n" +
                        "8. SUSTAINABLE HARVESTING: Master sustainable harvesting practices, ensuring that the jungle's resources are protected and continue to provide for future generations.\n\n" +
                        "9. HEALTH AND NUTRITION: Delve into the nutritional aspects of wild ingredients and how they contribute to the well-being of Negrito communities, understanding the profound connection between food and health.\n\n" +
                        "10. CULINARY RESILIENCE: Embrace the spirit of resilience as you leave with a deeper appreciation for the Negrito's enduring food traditions, a testament to the strength of indigenous cultures in preserving their culinary heritage.",

                "https://images.squarespace-cdn.com/content/v1/5ca2d827aadd343de55a408b/d8afdefd-e1bf-4127-8231-647f29d2042e/_10A0032.jpg?format=1500w",
                "https://www.peopleandplants.org/traditional-foodways/the-philippines"
            )
        )

        dataList.add(
            DataItem("COMMUNITY AND INDIGENOUS WISDOM ",
                "Immerse yourself in the heart of the Philippines, where ancient wisdom and community spirit thrive amidst the lush Cordillera Mountains. Explore the intricate tapestry of indigenous knowledge that has sustained the Ifugaos for generations, shaping their harmonious relationship with the jungle in this captivating journey.\"" +
                        "1. MUYONG CONSERVATION: Indigenous communities practice the conservation of 'muyongs,' traditional woodlots, which serve as sources of biodiversity, water supply, and cultural heritage preservation.\n\n" +
                        "2. SPIRITUAL CONNECTION: Indigenous peoples believe in the spiritual significance of trees, associating them with ancestral spirits, leading to the protection and conservation of these sacred trees.\n\n" +
                        "3. TERRACING EXPERTISE: Indigenous communities have mastered the art of building rice terraces, which not only sustain their agricultural needs but also protect the jungle's ecosystem.\n\n" +
                        "4. COMMUNITY-BASED GOVERNANCE: Indigenous governance systems are rooted in community decisions and customary laws, which promote sustainable land use and resource management.\n\n" +
                        "5. ETHICAL HUNTING AND GATHERING: Indigenous hunting and gathering practices emphasize ethical and sustainable resource utilization, ensuring minimal impact on the jungle's flora and fauna.\n\n" +
                        "6. TRADITIONAL MEDICINE: Indigenous knowledge of medicinal plants and herbs is passed down through generations, providing effective and sustainable healthcare solutions.\n\n" +
                        "7. LOW-IMPACT FARMING: Indigenous agricultural techniques focus on low-impact swidden farming, preserving the jungle's biodiversity while meeting food and economic needs.\n\n" +
                        "8. FOREST RITUALS: Indigenous rituals and ceremonies are intertwined with jungle conservation, reinforcing the belief in the interconnectedness of all living things.\n\n" +
                        "9. ORAL TRADITIONS: Indigenous wisdom is passed down through oral traditions, ensuring the preservation of cultural practices and ecological knowledge.\n\n" +
                        "10. ELDERS' GUIDANCE: Indigenous elders serve as repositories of traditional wisdom, offering guidance on jungle conservation and sustainability.\n\n",

                "https://businessmirror.com.ph/wp-content/uploads/2019/01/bio01-011418.jpg",
                "https://www.tandfonline.com/doi/full/10.1080/21513732.2015.1124453"
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