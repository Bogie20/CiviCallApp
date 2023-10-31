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

class NavigatingMountainInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigating_mountain_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "HIGH-ALTITUDE GEAR AND CLOTHING",
                "Navigating through the lush and unforgiving rainforests of the Philippines demands a unique set of skills and strategies. In this jungle wilderness, where dense vegetation conceals nature's secrets and operations require precision, mastering the art of jungle navigation becomes a paramount endeavor.\"\"\n\n" +
                        "1. GEAR SELECTION: Choose the right gear for the terrain, including mountaineering boots, crampons, and ice axes for stability and traction.\n\n" +
                        "2. LAYERING: Dress in layers to adapt to changing weather conditions. Start with moisture-wicking base layers, add insulating layers for warmth, and finish with a waterproof and breathable outer layer.\n\n" +
                        "3. CRAMPON COMPATIBILITY: Ensure your boots are compatible with crampons, and practice attaching them securely for glacier crossings and icy slopes.\n\n" +
                        "4. HELMET USE: Always wear a climbing helmet to protect against rockfall and falls on steep terrain.\n\n" +
                        "5. ICE AXE TECHNIQUES: Learn proper ice axe techniques for self-arrest and balance when traversing snow and ice.\n\n" +
                        "6. ROPE HANDLING: Master the skills of rope handling, essential for glacier travel and technical rock climbing.\n\n" +
                        "7. PACKING EFFICIENCY: Organize your backpack efficiently, with gear like headlamps, hydration systems, and the Ten Essentials readily accessible.\n\n" +
                        "8. 4-SEASON TENT: Invest in a 4-season tent designed to withstand high winds and snow loads for overnight trips.\n\n" +
                        "9. SLEEPING GEAR: Choose sleeping bags and pads rated for low temperatures and ensure they provide insulation from the cold ground.\n\n" +
                        "10. WATER MANAGEMENT: Carry equipment for melting snow or purifying water, including stoves, fuel, and water treatment options, as water sources may be limited in high-altitude areas.\n\n",

                "https://primer.com.ph/blog/wp-content/uploads/sites/14/2018/07/pexels-photo-1076081-e1531379652879.jpeg",
                "https://www.rei.com/learn/expert-advice/mountaineering-gear-essentials.html"

            )
        )
        dataList.add(
            DataItem("SURVIVAL SKILLS FOR JUNGLE EXPLORATION",
                "\"Embark on an extraordinary journey into the heart of the rainforests, where survival skills have taken Negrito tribesmen from instructors to expert guides. Explore the essential skills you need for jungle exploration.\n\n" +
                        "1. JUNGLE NAVIGATION: Master the art of navigating through dense rainforests using natural landmarks and a keen sense of direction.\n\n" +
                        "2. SHELTER BUILDING: Learn to construct makeshift shelters from jungle materials to protect yourself from the elements and wildlife.\n\n" +
                        "3. WATER SOURCING: Acquire the skills to find, purify, and store water safely, ensuring a reliable supply in the jungle.\n\n" +
                        "4. FIRE CRAFT: Develop the ability to start fires using indigenous methods, a vital skill for warmth, cooking, and signaling for rescue.\n\n" +
                        "5. EDIBLE PLANT IDENTIFICATIOn: Familiarize yourself with local plant species to distinguish edible from poisonous options for sustenance.\n\n" +
                        "6. WILDLIFE INTERACTION: Understand the behavior of jungle wildlife to avoid dangerous encounters and make the most of resources they offer.\n\n" +
                        "7. FIRST AID IN THE WILD: Equip yourself with basic first aid knowledge to address common injuries and ailments in the jungle.\n\n" +
                        "8. SURVIVAL TOOLS AND EQUIPMENT: Know how to use essential tools like machetes and ropes for various tasks, from clearing paths to crafting tools.\n\n" +
                        "9. WEATHER RESILIENCE: Be prepared for unpredictable weather conditions, equipping yourself with waterproof gear and clothing.\n\n" +
                        "10. CULTURAL AND ENVIRONMENTAL RESPECT: Show respect for the rainforest and indigenous cultures by minimizing your impact on the environment and local communities.\n\n",

                "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/a1/e4/40.jpg",
                "https://www.latimes.com/archives/la-xpm-1994-08-21-mn-29437-story.html"
           )
        )
        dataList.add(
            DataItem("SHELTER CONSTRUCTION IN THE HILLS",
                "\"Venturing into the rugged hills, your hike may take an unexpected turn, leaving you facing the wild elements and the need for a shelter. In this guide, we delve into the art of 'Shelter Construction in the Hills,' a skill that can be a lifesaver when nature's challenges put you to the test.\"\n\n" +
                        "1. SITE SELECTION: Choose a shelter location away from potential hazards and consider natural features like caves or overhangs for added protection.\n\n" +
                        "2. MATERIALS GATHERING: Collect dry and insect-free natural materials like branches, leaves, and logs for building your shelter.\n\n" +
                        "3. FRAME CONSTRUCTION: Create a sturdy frame using branches or logs, forming an A-frame or lean-to structure depending on your needs.\n\n" +
                        "4. ROOFING: Layer the frame with waterproof materials such as leafy branches and moss to create an effective rainproof roof.\n\n" +
                        "5. FLOORING: Clear the shelter interior of debris and insulate it with leaves or moss to stay off the cold ground.\n\n" +
                        "6. ENTRANCE SEAL: Use additional materials to partially close the entrance, balancing ventilation with weather protection.\n\n" +
                        "7. HEAT REFLECTORS: Position rocks or logs to reflect heat back into your shelter, maintaining warmth.\n\n" +
                        "8. INTERIOR INSULATION: Line the interior with soft materials like leaves, grass, or moss for a comfortable bedding area.\n\n" +
                        "9. EMERGENCY SIGNALING: Create a visible signal to alert potential rescuers in case of emergencies.\n\n" +
                        "10. REGULAR MAINTENANCE: Periodically inspect and reinforce your shelter, making necessary improvements for lasting durability and protection.",

                "https://www.trailhiking.com.au/wp-content/uploads/2021/02/A-frame-Debris-Shelter.jpg",
                "https://www.trailhiking.com.au/safety/how-to-build-a-survival-shelter/"
           )
        )

        dataList.add(
            DataItem("WILDERNESS COOKING AT HIGH ALTITUDES",
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
            DataItem("ACCLIMATIZATION AND ALTITUDE SICKNESS PREVENTION",
                "In the majestic realm of high-altitude adventures, acclimatization and altitude sickness prevention are your steadfast companions. Journey with us as we unravel the secrets of acclimatization and unveil the strategies to conquer altitude sickness, ensuring your mountaineering and trekking endeavors reach breathtaking heights safely.\"\n\n\n" +
                        "1. GRADUAL ASCENT: Begin your journey with a slow, gradual ascent, allowing your body time to acclimatize to the decreasing oxygen levels as you ascend to higher altitudes.\n\n" +
                        "2. HYDRATION HABITS: Maintain a consistent hydration routine, ensuring you drink an ample amount of water to combat the effects of altitude and prevent dehydration.\n\n" +
                        "3. ADEQUATE REST: Incorporate rest days into your itinerary to allow your body to adjust to the reduced oxygen and physical exertion of high altitudes.\n\n" +
                        "4. PROPER NUTRITION: Fuel your body with a balanced diet rich in carbohydrates to provide the necessary energy for your high-altitude adventures.\n\n" +
                        "5. ALTITUDE MEDICATIONS: Consult with a healthcare provider about altitude sickness prevention medications like acetazolamide, which can assist in acclimatization.\n\n" +
                        "6. SLOW ASCENT TECHNIQUE: Practice the 'climb high, sleep low' technique, where you spend your days at higher elevations but descend to sleep at a lower altitude to aid acclimatization.\n\n" +
                        "7. OXYGEN SUPPLEMENTATION: Carry supplemental oxygen for emergencies, especially at extreme altitudes where oxygen levels are critically low.\n\n" +
                        "8. SYMPTOM AWARENESS: Educate yourself on the early symptoms of altitude sickness, including headaches, nausea, and shortness of breath, to take timely action if they occur.\n\n" +
                        "9. WEATHER MONITORING: Keep a close watch on weather conditions, as extreme cold and storms can exacerbate altitude sickness; be prepared to seek shelter or descend.\n\n" +
                        "10. EMERGENCY PLAN: Develop a clear emergency plan and share it with your expedition team, including evacuation procedures in case of severe altitude sickness.",

                "https://images.hive.blog/0x0/https://files.peakd.com/file/peakd-hive/ybanezkim26/EoyN8Q1tiM7CAVMpukq5eJci7PFYojv9KosCEcevFSDtccfbAw9xCGuiCZf2ANM7NhZ.jpg",
                "https://my.clevelandclinic.org/health/diseases/15111-altitude-sickness"
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