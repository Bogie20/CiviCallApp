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

class ZeroSurvivingEarthquakes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zero_earthquakes_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "SECURING FURNITURE AND OBJECTS",
                "In the earthquake-prone Philippines, safeguarding your home against seismic threats is paramount. Discover practical and effective ways to protect your loved ones and possessions by securing heavy furniture and objects with these simple yet impactful measures.\"Comprehensive Disaster Preparedness Kits: A Guide to Effective Disaster Response\" and equip yourself with the knowledge to safeguard your community and ensure a brighter, more resilient future.\"\"\n\n" +
                        "1. ANCHOR HEAVY FURNITURE AND OBJECTS: Use brackets or straps to firmly attach heavy items like bookshelves and cabinets to the walls, preventing them from toppling over during tremors.\n\n" +
                        "2. UTILIZE EARTHQUAKE PUTTY OR ADHESIVE: Apply earthquake putty or adhesive to secure smaller objects such as vases and picture frames to surfaces, keeping them in place during shaking.\n\n" +
                        "3. REINFORCE FOUNDATION: Strengthen your home's foundation by ensuring proper drainage to prevent soil erosion, a potential cause of foundation weakening. Repair any existing foundation cracks.\n\n" +
                        "4. SECURE GAS AND WATER LINES: Install flexible gas and water lines to prevent breakage during an earthquake. Use automatic gas shut-off valves that activate when seismic activity is detected to minimize gas leaks and fire risks.\n\n" +
                        "5. STRENGTHEN WALLS AND ROOFS: Brace unreinforced masonry walls with plywood or similar materials to offer additional support. Reinforce roof trusses and rafters to prevent roof collapse.\n\n" +
                        "6. ENSURE LIGHT FIXTURES AND CEILING FANS ARE SECURE: Properly secure light fixtures and ceiling fans to the ceiling using safety cables or straps to prevent them from falling during an earthquake.\n\n" +
                        "7. INSTALL CABINET DOOR LATCHES: Attach latches to cabinet doors to prevent them from swinging open and spilling their contents during seismic events.\n\n" +
                        "8. CREATE AN EMERGENCY KIT: Assemble an emergency kit with essential supplies including water, non-perishable food, flashlights, batteries, a first aid kit, and important documents. Keep it in an easily accessible location.\n\n" +
                        "9. EDUCATE YOUR FAMILY: Teach your family members earthquake safety procedures, including 'Drop, Cover, and Hold On.' Conduct regular earthquake drills to practice these safety measures.\n\n" +
                        "10. SECURE GLASS WINDOWS AND MIRRORS: Apply safety film to glass windows and mirrors to prevent them from shattering during an earthquake, reducing the risk of injury and damage.",

                "https://www.lumina.com.ph/assets/news-and-blogs-photos/Earthquake-Preparedness-Plan/OG-Earthquake-Preparedness-Plan-Tips-Safe-places-to-put-furniture-at-home.webp",
                "https://www.linkedin.com/pulse/ideas-secure-your-house-against-earthquakes-simple-steps-gerry-bongon/"
            )
        )
        dataList.add(
            DataItem("EARTHQUAKE EMERGENCY KIT ESSENTIALS",
                "Prepare for the unexpected with confidence by assembling your Earthquake Emergency Kit Essentials. In this guide, we'll walk you through the must-have items that will keep you and your loved ones safe and well-equipped during seismic events.\n\n" +
                        "1. PLAN AND PREPARE: Assess your family's needs, including dietary and medical requirements, to determine the necessary supplies for your emergency kit.\n\n" +
                        "2. FOOD AND WATER: Stock a three-day supply of non-perishable food items and one gallon of water per person per day. Ensure you have a manual can opener.\n\n" +
                        "3. FIRST AID KIT: Assemble a comprehensive first aid kit with bandages, antiseptics, medications, and medical supplies tailored to your family's needs.\n\n" +
                        "4. TOOLS AND SUPPLIES: Include essential tools like flashlights, extra batteries, a multi-tool, duct tape, work gloves, and a manual can opener.\n\n" +
                        "5. COMMUNICATION: Keep battery-powered or hand-crank radios for emergency information and extra batteries for devices and flashlights.\n\n" +
                        "6. PERSONAL DOCUMENTS: Safeguard copies of important documents such as identification, insurance policies, medical records, and contact information in a waterproof container.\n\n" +
                        "7. CLOTHING AND BEDDING: Pack extra clothing, sturdy shoes, and blankets or sleeping bags suitable for your climate.\n\n" +
                        "8. SANITATION AND HYGIENE: Include hygiene items, toilet paper, sanitary supplies, soap, hand sanitizer, trash bags, and personal hygiene products.\n\n" +
                        "9. PET SUPPLIES: If you have pets, assemble a separate kit for them with food, water, leashes, carriers, medications, and copies of their medical records.\n\n" +
                        "10. EMERGENCY PLAN: Develop a family emergency plan outlining evacuation routes, rendezvous points, and contact information. Ensure everyone in your household is familiar with the plan.",

                "https://s.w-x.co/disaster_supply_kit.jpg",
                "https://www.earthquakeauthority.com/Blog/2019/How-to-Make-an-Earthquake-Emergency-Kit"
              )
        )
        dataList.add(
            DataItem("EVACUATION PLANS AND SAFE ZONES",
                "\"In the face of earthquake threats, meticulous planning is paramount to safeguard lives and ensure a swift response. Explore the critical elements of \"EVACUATION PLANS AND SAFE ZONES in earthquakes\" to prepare for seismic events with precision and protect your community.\"\n\n" +
                        "In the face of earthquake threats, meticulous planning is paramount to safeguard lives and ensure a swift response. Explore the critical elements of \"EVACUATION PLANS AND SAFE ZONES in earthquakes\" to prepare for seismic events with precision and protect your community.\n\n" +
                        "1. STRATEGIC LOCATION SELECTION: Choose evacuation points uphill and upwind from buildings, considering potential hazards like hazardous materials, fires, or incendiary devices. Ensure these locations are clearly visible, easy to describe, and safely distanced from the building (preferably 150 - 200 yards away).\n\n" +
                        "2. SAFETY FIRST: Opt for locations away from secondary risk factors such as dumpsters (which may contain explosive devices), gas mains, high voltage wires, and sewer main access covers. Ensure proximity to access routes for vehicular evacuation and easy accessibility.\n\n" +
                        "3. ROUTE CONSIDERATION: Avoid blocking access routes or staging areas for responders. Be mindful of hydrants, utility shut-off valves, and access points. Steer clear of major traffic arteries unless traffic control measures like traffic lights are present.\n\n" +
                        "4. STRUCTURAL SAFETY: Assess potential building damage risks, such as structures at risk of collapse due to blasts or other damages like high unsupported walls, large windows, towers, or antennas.\n\n" +
                        "5. CROWD MANAGEMENT: Prevent bottlenecks or confined areas like tunnels and dead-ends, which can lead to crushing. Ensure safe terrain to avoid tripping hazards.\n\n" +
                        "6. SPECIAL NEEDS: Consider the needs of individuals with hearing, mobility, and developmental impairments who may require special assistance during evacuations.\n\n" +
                        "7. ACCOUNTABILITY: Develop procedures to account for evacuated individuals and facilitate their transfer to indoor shelters as they become available.\n\n" +
                        "8. COMMUNICATION ACCESS: Ensure radio and cell phone availability by avoiding evacuation points in areas with impaired or inaccessible communications.\n\n" +
                        "9. CRIMINAL ACTS: Be prepared for the possibility of criminal acts such as bombings or arson. Responders should control the area and maintain the integrity of the crime scene if such incidents occur.\n\n" +
                        "10. CONTINUOUS REVIEW: Regularly review and update evacuation plans and safe zones to adapt to changing circumstances, improve safety measures, and enhance preparedness for earthquake scenarios.",

                "https://i0.wp.com/www.up.edu.ph/wp-content/uploads/2019/02/IMG_5171.jpg?resize=640%2C427&ssl=1",
                "https://www.colorado.edu/firelifesafety/fire-drills/selecting-evacuation-locations#:~:text=Try%20to%20Locate%20Evacuation%20Point%3A&text=At%20a%20safe%20distance%20from,and%20sewer%20main%20access%20covers."
             )
        )

        dataList.add(
            DataItem("POST-QUAKE FIRST AID",
                "\"In the aftermath of a seismic event, immediate and effective first aid can make all the difference. Explore the essential guidelines for 'Post-Quake First Aid in earthquakes' to ensure you're prepared to provide crucial assistance when it's needed most.\"\n\n\n" +
                        "1. PRIORITIZE PERSONAL SAFETY: After an earthquake, ensure your own safety first. Beware of aftershocks and potential falling objects. Move to a secure location, taking your disaster supplies kit with you.\n\n" +
                        "2. ASSIST TRAPPED INDIVIDUALS: If someone is trapped by debris or falling items, advise them to protect their mouth, nose, and eyes from dust. If there's bleeding, apply pressure to the wound and elevate the injured area. Signal for help using an emergency whistle, cell phone, or by knocking on solid surfaces.\n\n" +
                        "3. PROVIDE RESCUE SIGNALS: Use loud knocking or other audible signals to alert rescue personnel to your location. Continue to make noise every few minutes to increase the chances of being heard and rescued.\n\n" +
                        "4. WEAR PROTECTIVE GEAR: Equip yourself with sturdy shoes, work gloves, dust masks, and eye protection before assessing damage. This gear will help prevent injuries from broken glass and debris.\n\n" +
                        "5 STAY CALM: Contrary to the myth of panic, research shows that people generally take protective actions and assist others during and after earthquakes. Maintain composure and focus on helping those in need.\n\n" +
                        "6. CHECK FOR INJURIES: Assess individuals for injuries and follow first aid guidelines. Use your first aid kit or reference the front pages of your telephone book for detailed instructions.\n\n" +
                        "7. CONTROL BLEEDING: Apply direct pressure to bleeding wounds using clean gauze or cloth if available. This helps staunch the bleeding and minimize the risk of infection.\n\n" +
                        "8. ADMINISTER RESCUE BREATHING: If someone is not breathing, perform rescue breathing to restore their breathing. Learn and practice proper rescue breathing techniques.\n\n" +
                        "9. INITIATE CPR (CARDIOPULMONARY RESUSCITATION): In cases of cardiac arrest with no pulse, start CPR immediately. Familiarize yourself with CPR procedures and perform them effectively.\n\n" +
                        "10. ENSURE WARMTH AND MEDICAL ATTENTION: Keep injured individuals warm by covering them with blankets or additional clothing. Seek medical assistance for serious injuries promptly. Pay special attention to the well-being of children and individuals requiring special assistance.",

                "https://staging.imanilahost.com/redcross/wp-content/uploads/2019/07/FOR-PR.jpg",
                "http://scecinfo.usc.edu/eqcountry/roots/step6.html"
             )
        )

        dataList.add(
            DataItem("PSYCHOLOGICAL SUPPORT AFTER AN EARTHQUAKE",
                "\"Following recent devastating earthquakes, survivors are grappling with significant psychological challenges. This piece examines the crucial role of psychosocial support programs in aiding earthquake survivors on their journey towards mental recovery and resilience.\"\n\n" +
                        "1. PLATFORM REGISTRATION: Start by signing up on 'Magnify Your Voice' or a similar digital civic engagement platform, providing your basic information and preferences.\n\n" +
                        "2. PROFILE SETUP: Create a comprehensive user profile, including your interests, skills, and availability for micro-volunteering activities.\n\n" +
                        "3. BROWSE CAMPAIGNS: Explore the various ongoing campaigns and projects available on the platform, ranging from local announcements to advocacy efforts.\n\n" +
                        "4. JOIN OR START A CAMPAIGN: Join existing campaigns that align with your interests or initiate your grassroots campaign to address a local issue.\n\n" +
                        "5. MICRO-VOLUNTEERING: Participate in micro-volunteering tasks, dedicating small moments to send emails, texts, or support community initiatives.\n\n" +
                        "6. COMMUNITY ANNOUNCEMENTS: Share announcements about local events, meetings, or initiatives, ensuring your community stays informed and engaged.\n\n" +
                        "7. COLLABORATE AND NETWORK: Connect with like-minded individuals and community groups, enhancing the impact of your collective efforts.\n\n" +
                        "8. ADVOCACY AND FEEDBACK: Use the platform to advocate for specific causes or provide feedback to local governments or organizations, amplifying your civic voice.\n\n" +
                        "9. GAMIFIED ENGAGEMENT: Explore gamification features within the platform, earning rewards or recognition for your contributions to encourage ongoing involvement.\n\n" +
                        "10. MOBILE ACCESSIBILITY: Download the native mobile app for added convenience, allowing you to engage with your community and campaigns while on the go.\n\n",

                "https://www.xu.edu.ph/images/2017/img/march/Surigao1.jpg",
                "https://bonyan.ngo/blog/psychosocial-support-for-earthquake-victims/"
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