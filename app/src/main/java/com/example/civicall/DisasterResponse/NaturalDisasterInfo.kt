package com.example.civicall.DisasterResponse

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class NaturalDisasterInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_natural_disaster_info)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(DataItem("1. Earthquakes: Being Ready for the Ground Shaker", " Recognize early signs like unusual animal behavior and minor tremors, which can indicate an impending earthquake. Understand your local earthquake-prone areas and the 'Drop, Cover, and Hold On' technique for safety. Whether indoors or outdoors, stay informed through emergency alerts, have an earthquake emergency kit, and ensure everyone knows your emergency plan and contacts.\n",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("2. Hurricanes: Know the Categories & Prepare for Safety",
            "Stay vigilant for early signs like changes in weather patterns and rising humidity, which could indicate an approaching hurricane. Understand hurricane categories and potential impacts, secure your home, create an emergency kit, stay informed through alerts, and coordinate with your community for safety during hurricanes.\n",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("3. Tornadoes: Watch vs. Warning & Safe Shelter",
            "Differentiate between a tornado watch, which means tornadoes are possible in your area, and a tornado warning, indicating a tornado has been sighted or detected. Familiarize yourself with designated safe shelter locations both on and off-campus to seek refuge during tornadoes. Stay informed through weather alerts and local news and have a tornado emergency kit ready, including essentials like a flashlight, batteries, and a battery-powered weather radio.\n",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("4. Flash Floods and River Floods: Causes and Campus Prone Areas",
            "Flash floods result from sudden heavy rainfall, dam failures, or rapid snowmelt, causing rapid inundation. River floods develop gradually due to prolonged rainfall, snowmelt, or dam releases, causing rivers to overflow. To ensure campus safety, identify flood-prone areas like basements, low-lying lots, and nearby water bodies during extreme weather.\n",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("5. Wildfires: Spread and Defensible Spaces in Fire-Prone Areas",
            " Wildfires spread rapidly due to dry conditions, strong winds, and ignition sources like lightning or human activities. To safeguard your dorm or apartment in fire-prone areas, establish a defensible space by clearing dead vegetation, maintaining a safe distance from flammable materials, and having fire-resistant roofing and siding.\n",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("6. Wildfires: Spread and Defensible Spaces in Fire-Prone Areas",
            "To safeguard yourself in volcanic-prone areas, become well-versed in recognizing early warning signs such as heightened seismic activity and gas emissions. It's equally important to acquaint yourself with the designated evacuation routes and locate nearby shelters for timely and safe evacuation during a volcanic event. Being prepared can make a crucial difference in protecting yourself and your community.\"\n",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("7. Tsunamis: Causes and the Vital Importance of High Ground",
            "Tsunamis are frequently triggered by underwater earthquakes, making it essential to understand their origins. When a tsunami warning is issued, recognizing the critical need to move to higher ground swiftly can be a life-saving response, as it reduces the risk of being affected by the powerful and destructive waves.\"    \n",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("8. Droughts: Long-Term Effects and Water Conservation",
            "Droughts have profound, long-term impacts on water sources and agriculture, often leading to reduced water availability and crop failures. To mitigate these effects, it is vital to adopt water conservation practices in your daily life, such as fixing leaks, using water-efficient appliances, and minimizing water waste, contributing to resource preservation and sustainability.\"Drop, Cover, and Hold On\" drill regularly with your roommates or neighbors.\"\n",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("9. Winter Storms: Preparedness and Safety in Cold Weather",
            "When facing winter storms, ensure you are well-prepared with cold-weather clothing and emergency supplies to handle potential power outages. Additionally, understanding how to stay warm and safe when stranded in extreme cold conditions, such as by using blankets, conserving body heat, and seeking shelter, is crucial for your well-being during severe winter weather events.\"\n",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))
        dataList.add(DataItem("10. Heatwaves: Identifying Risks and Staying Safe",
            "Heatwaves can pose significant health risks. Familiarize yourself with the signs of heat-related illnesses and preventative measures. Stay hydrated, limit outdoor activities during extreme heat, and seek shade or air-conditioned spaces when necessary to protect yourself from heat-related health issues.\"\n",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        val adapter = DataAdapter(dataList)

        // Set an item click listener for the adapter to open the link when the reference TextView is clicked
        adapter.setOnItemClickListener(object : DataAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val clickedItem = dataList[position]
                val link = clickedItem.link

                // Open the link in a web browser
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(intent)
            }
        })

        // Set the adapter for the RecyclerView
        recyclerView.adapter = adapter
    }
}