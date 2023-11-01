package com.example.civicall.PublicHealtAwarenessInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R
import com.example.civicall.databinding.ActivityFourHealthcareTechnologyBinding

class FourHealthcareTechnology : AppCompatActivity() {



    private lateinit var binding: ActivityFourHealthcareTechnologyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFourHealthcareTechnologyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Now, you can use 'binding' to reference your views in the layout
        binding.backbtn.setOnClickListener {
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
                "HEALTH TECH: PIONEERING INNOVATIONS IN HEALTHCARE",
                "Explore the cutting-edge realm of health tech as we delve into the top 10 healthcare technology trends for 2023. Discover how innovation is reshaping the future of healthcare delivery and advancing medical advancements\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. ADDRESSING WORKFORCE SHORTAGES: Healthcare leaders are turning to AI and automation to combat critical staffing shortages and prevent burnout.\n\n" +
                        "2. DIGITAL UPSKILLING: Continuous training and education are vital to keep healthcare professionals updated with technological advancements.\n\n" +
                        "3. VIRTUAL COLLABORATION: Remote guidance and collaboration between healthcare professionals enable quality care in underserved areas.\n\n" +
                        "4. INTEROPERABLE INFORMATICS: Vendor-neutral solutions will connect disparate systems and improve healthcare experiences.\n\n" +
                        "5. CLOUD INTEGRATION: Cloud-based solutions support integrated healthcare infrastructures and improve access to patient data.\n\n" +
                        "6. SEAMLESS PATIENT MONITORING: Cloud-based digital solutions facilitate patient care across different settings and offer proactive insights.\n\n" +
                        "7. EQUITABLE HEALTHCARE: The focus on inclusive healthcare aims to address disparities and expand access for underserved populations.\n\n" +
                        "8. CIRCULARITY FOR SUSTAINABILITY: Sustainable healthcare models and circular practices can reduce waste, cut costs, and lower emissions.\n\n" +
                        "9. DECARBONIZING THE INDUSTRY: Healthcare leaders are taking steps to reduce their carbon footprint through energy-efficient technology and responsible sourcing.\n\n" +
                        "10. ENVIRONMENTAL HEALTH: Awareness is growing about the impact of environmental factors on human health, driving health systems to address broader environmental impacts.",

                "https://www.philips.com.ph/c-dam/corporate/newscenter/global/standard/resources/healthcare/2023/10-healthcare-technology-trends-for-2023/9-decarbonizing.jpg",
                "https://www.philips.com.ph/a-w/about/news/archive/standard/news/articles/2023/20230116-10-healthcare-technology-trends-for-2023.html"

            )
        )
        dataList.add(
            DataItem("MHEALTH (MOBILE HEALTH): YOUR HEALTH IN YOUR POCKET",
                "In an era where over 5 billion people possess mobile devices, the adoption of mobile health technology (mHealth) is transforming the healthcare landscape. Discover the compelling benefits of mHealth, from improving patient access to healthcare providers to enhancing medication management and coordination.\n\n" +
                        "1. FASTER ACCESS TO CARE: Mobile health technology offers patients quick, 24/7 access to healthcare providers, especially through the growing use of telemedicine apps.\n\n" +
                        "2. ENHANCED MEDICATION ADHERENCE: Mobile apps provide automated reminders and educational resources to ensure patients take medications properly.\n\n" +
                        "3. STREAMLINED REMOTE MONITORING: Wearable devices and mobile technology facilitate remote patient monitoring, especially for chronic conditions.\n\n" +
                        "4. IMPROVED MEDICATION RECONCILIATION: Mobile solutions like Cureatr Meds 360 enhance patient safety by ensuring accurate medication records.\n\n" +
                        "5. ENHANCED PROVIDER COMMUNICATION: Secure messaging and mobile health records improve communication among healthcare providers and streamline care coordination.\n\n" +
                        "6. PATIENT-PREFERRED ACCESS: Patients prefer MHEALTH APPS for their convenience in accessing healthcare services.\n\n" +
                        "7. REDUCED TRAVEL REQUIREMENTS: Telemedicine eliminates the need for patients to travel to healthcare facilities, making care more accessible.\n\n" +
                        "8. IMPACT ON MEDICATION MANAGEMENT: Mobile apps can provide detailed medication histories, reducing the risk of drug interactions.\n\n" +
                        "9. BOOST TO REMOTE PATIENT MONITORING: The Center for Medicare and Medicaid Services (CMS) now covers remote patient monitoring, creating new revenue streams for healthcare organizations.\n\n" +
                        "10. COORDINATION OF CARE: Mobile health solutions like Clinical Event Notifications improve care transitions and coordination across healthcare settings.",

                "https://cdn2.hubspot.net/hubfs/4184981/images/blog/Cureatr-Blog-Sep%202019-3.jpg",
                "https://blog.cureatr.com/benefits-of-mobile-health-technology"
                )
        )
        dataList.add(
            DataItem("EHEALTH: BRIDGING THE DIGITAL DIVIDE IN HEALTHCARE",
                "In a nation grappling with healthcare disparities, eHealth emerges as the digital remedy. Discover how technology is bridging the gap in Philippine healthcare, providing digital solutions to revolutionize access and improve patient outcomes.\"\n\n" +
                        "1. EHEALTH REVOLUTION: The Philippines faces challenges in healthcare accessibility, with the digital divide as a key concern.\n\n" +
                        "2. GROWING POPULATION DEMANDS: A rising and ageing population drives the need for improved healthcare services.\n\n" +
                        "3. INADEQUATE HEALTHCARE INFRASTRUCTURE: Lack of healthcare personnel, outdated technology, and inequity persist in the healthcare system.\n\n" +
                        "4. TELEMEDICINE SOLUTIONS: Telemedicine offers remote healthcare services, helping overcome geographic barriers and reduce costs.\n\n" +
                        "5. TECH-DRIVEN MEDICAL ADVANCES: The rise of telemedicine companies and mobile apps provides convenient healthcare services.\n\n" +
                        "6. MOBILE CLINICAL COMMUNICATION: Medical apps empower patients with information, clinical communication, and remote monitoring tools.\n\n" +
                        "7. AI AND HEALTHCARE: Artificial intelligence, robots, and high-tech sensors are transforming healthcare delivery.\n\n" +
                        "8. DISEASE MANAGEMENT: Technology is aiding in the management and even curing of previously incurable diseases.\n\n" +
                        "9. DRONES IN HEALTHCARE: Remote areas benefit from drone deliveries of medicines and health accessories.\n\n" +
                        "10. THE DIGITAL HEALTHCARE DIVIDE: The Philippines must embrace eHealth and ensure its benefits outweigh the costs to bridge healthcare disparities.",

                "https://lh4.googleusercontent.com/PWk6JpQnZ2V5hDd4Br-LeJYGdRH17zxY15Cda6AiCwc9P3MN7ojvZAoy_iWP94Zv3WCgtqsKliH3ilwicx5WKnkaL85hWL1UIOffRFiHV9UPFo9Q6QHDE4xMAeW8oyGdFkBOJt9Z",
                "https://www.pwc.com/ph/en/publications/ph-columns/pwc-needles-in-a-haystack/embracing-new-healthcare-technologies-that-empower-Filipinos.html"
            )
        )

        dataList.add(
            DataItem("TELEHEALTH: HEALTHCARE AT YOUR FINGERTIPS",
                "Experience healthcare like never before with the power of telehealth at your fingertips. Discover how remote medical consultations are revolutionizing access to healthcare services in the Philippines.\"\n" +

                        "1. TELEHEALTH POST-PANDEMIC: Telehealth services continue to benefit Filipinos, even after the pandemic, enhancing access to healthcare.\n\n" +
                        "2. DEFINING TELEHEALTH: Telehealth, involving contactless consultation through technology, plays a pivotal role in modern healthcare.\n\n" +
                        "3. TELEHEALTH VS. TELEMEDICINE: While these terms are often used interchangeably, TELEMEDICINE is a subset of the broader TELEHEALTH category.\n\n" +
                        "4. TELEHEALTH ADVANTAGES: Telehealth offers convenience, access, cost savings, reduced anxiety, better rapport, and lower institutional costs.\n\n" +
                        "5. MEDIFI: Medifi, available 24/7, connects users with online doctors for a consultation fee.\n\n" +
                        "6. KONSULTAMD: KonsultaMD is a 24/7 hotline service offering various health plans and medical assistance over the phone.\n\n" +
                        "7. HEALTHNOW: HealthNow distinguishes itself with 24/7 video consultations, enabling easy access to doctors.\n\n" +
                        "8. AIDE: AIDE offers robust telehealth services, including laboratory testing and nursing care, in addition to online consultations.\n\n" +
                        "9. DOCTOR ANYWHERE: Doctor Anywhere's app provides online video consultations with licensed doctors for various medical specialties.\n\n" +
                        "10. GENERIKA LIBRENG TELEKONSULTA: Generika Drugstore offers free medical consultations over the phone to cater to Filipinos' healthcare needs.",

                "https://25174313.fs1.hubspotusercontent-eu1.net/hub/25174313/hubfs/assets_moneymax/woman-in-a-video-call-with-a-covid-19-patient-4031710.jpg?width=1013&height=674&name=woman-in-a-video-call-with-a-covid-19-patient-4031710.jpg",
                "https://www.moneymax.ph/lifestyle/articles/telehealth-online-medical-consultation"
              )
        )
        dataList.add(
            DataItem("DIGITAL HEALTH SOLUTIONS: TRANSFORMING THE PATIENT EXPERIENCE",
                "Unlocking the Future of Healthcare: Digital solutions are revolutionizing the patient experience in the Philippines. Explore how technology and innovation are enhancing patient engagement and reshaping the healthcare landscape.\n\n\n" +
                        "1. DIGITALIZATION IN THE PHILIPPINES: The country embraces digital healthcare, opening new avenues for healthcare delivery.\n\n" +
                        "2. THE POWER OF DIGITAL TRANSFORMATION: Experts emphasize that digital healthcare goes beyond technology, sparking innovation and a holistic healthcare shift.\n\n" +
                        "3. JOBS AND OPPORTUNITIES: Digital healthcare is poised to create numerous jobs and substantial revenue, debunking concerns about job loss.\n\n" +
                        "4. EDUCATIONAL INTEGRATION: Integrating digital health into curricula will broaden opportunities and create diverse roles in the healthcare sector.\n\n" +
                        "5. ADDRESSING BANDWIDTH CHALLENGES: Overcoming connectivity issues is vital for expanding telehealth services, especially in remote areas.\n\n" +
                        "6. CONVERGENCE OF GOVERNMENT: Effective collaboration between national and local governments is necessary to meet citizens' healthcare needs.\n\n" +
                        "7. PHILIPPINE ID AS ELIGIBILITY: The Philippine ID plays a pivotal role in granting citizens access to a range of services and healthcare solutions.\n\n" +
                        "8. RESEARCH AND DEVELOPMENT (R&D): R&D in digital health is multifaceted, involving policies, services, and interventions to improve the healthcare system.\n\n" +
                        "9. ADOPTION OF DIGITAL TECHNOLOGIES: Adapting and integrating digital healthcare technologies is crucial for advancing healthcare in the country.\n\n" +
                        "10. DIGITAL HEALTHCARE ECOSYSTEM: A comprehensive approach, combining internet accessibility, innovation, inclusion, and a robust R&D backbone, will shape the future of healthcare in the Philippines.",

                "https://www.pchrd.dost.gov.ph/wp-content/uploads/2023/03/RJC03428.jpg",
                "https://www.pchrd.dost.gov.ph/news_and_updates/what-the-future-of-digital-healthcare-would-look-like-in-the-philippines/"
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