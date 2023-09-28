package com.example.civicall.DisasterResponseInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class EmergencyPreparednessInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_preparedness_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        // Create a SpannableString with a larger text size for the specific portion

        dataList.add(DataItem(
            "1. Creating Your Personal Emergency Kit",
            "Include non-perishable snacks like granola bars and a reusable water bottle in your kit to sustain you during emergencies. Don't forget essential personal items like prescription medications, a copy of your ID, and a portable phone charger.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "2. Building Your Emergency Contacts List",
            "Ensure all roommates or close friends have each other's contact information and designate a specific out-of-town contact to coordinate communication. Discuss the importance of texting rather than calling during emergencies to avoid overloading the network.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "3. Crafting a Communication Strategy",
            "Establish a meeting point on or off-campus in case you're separated from your group, ensuring everyone knows its location. Learn how to use the university's emergency notification system and download relevant emergency apps.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "4. Mastering Evacuation Plans",
            "Walk the evacuation routes with your roommates or friends to familiarize yourselves with the paths and alternative exits. Consider practicing a mock evacuation to ensure everyone understands the process.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "5. Utilizing Campus Emergency Resources",
            "Contact campus security or emergency services to inquire about emergency resources available in your specific dorm or apartment complex. Locate the nearest AED (Automated External Defibrillator) and learn how to use it.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "6. Safety in Your Living Space",
            "Discuss cooking safety and the importance of not leaving stovetops or ovens unattended. Conduct regular fire drills with your roommates to ensure everyone knows how to exit safely.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "7. Preparedness for Severe Weather",
            "Create a severe weather kit with items like a weather radio, flashlight, and blankets for weathering storms in your safe space. Familiarize yourself with the campus's designated severe weather shelter locations.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "8. Earthquake Readiness",
            "Secure heavy furniture and objects in your living space with earthquake straps or putty to prevent them from falling during a quake. Practice the \"Drop, Cover, and Hold On\" drill regularly with your roommates or neighbors.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "9. Managing Medical Information",
            "Keep a physical copy of your medical information card in your emergency kit and take a photo to store on your phone. Discuss any specific medical needs with your roommates or neighbors, so they can assist if necessary.",
            R.drawable.love2,
            "https://libguides.umn.edu/c.php?g=964128"))

        dataList.add(DataItem(
            "10. Engaging in Campus and Community Preparedness",
            "Join the university's emergency response team or volunteer for community disaster preparedness programs to  gain valuable skills. Attend disaster preparedness workshops and seminars hosted by your college or local community organizations to enhance your knowledge and abilities.\"\n",
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