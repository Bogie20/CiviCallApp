package com.example.civicall.CampusGovernanceInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class EightStudentDevelopment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight_student_development)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "OSAS: Fostering Student Welfare and Development",
                "Brief Description\n\n" +
                        "The Office of Student Affairs and Services (OSAS) aims to mold globally competent and value-laden citizens by striving to enrich students through a holistic approach in providing Student Welfare and Development Programs and Services in consonance with the vision, mission, goals and objectives of Batangas State University and the mandates of the Commission on Higher Education (CHED). These basic services and programs   ensure and promote student well-being and are designed to explore, enhance and     develop the student’s full    potential in leadership and social responsibility through various institutional and student–initiated activities that upholds the core values of the university. \n\n" +
                        "Thrusts and Priorities\n\n" +
                        "The OSAS are the services and programs in the university that are concerned with academic support experiences of students to attain holistic student development. The purpose is to facilitate holistic student growth for active participation in the       collective efforts to develop the community and build a progressive nation. These non-academic services are student-centered and three-pronged:  student welfare services, student development programs and services and institutional student programs and services. \n\n" +
                        "Contact Details \n\n" +
                        "Telephone: (043) 980-0385 loc. 1134 \n\n" +
                        "Email address: osas.central@g.batstate-u.edu.ph\n\n",
                "https://home.interface.edu.ph/images/2018/05/22/sao.png",
                "https://batstate-u.edu.ph/student-affairs-and-services/"
            )
        )
        dataList.add(
            DataItem(
                "FOOD SERVICES\n\n",
                        "In accordance with CHED Memorandum Order No. 09, s. 2013 (Enhanced Policies and Guidelines on Student Affairs and Services) and DEPED Order No.: 8 Series 2007 (Revised Implementing Guidelines On The Operation And Management Of School Canteens In Public Elementary And Secondary Schools), the following guidelines for the Food Services in Batangas State University are hereby adopted for the information, guidance and compliance of all concerned.\n\n" +
                        "Services:\n\n" +
                        "• Monitors the food safety, hygiene and sanitation of all food business operations in the respective campus, makes spot checks and calls the attention of the staff for noted deviations from the policies and procedures of the university.\n\n" +
                        "• Participates in evaluating canteen tenant applicants based on the set criteria and in the committee’s recommendation to the University President for approval.\n\n\n" +
                        "• Assists in providing recommendations or actions on any customers’ issues and concerns with regard to canteen services\n\n\n" +

                        "Contact Details \n\n" +

                        "Telephone: (043) 980-0385 loc. 1134 \n\n" +
                        "Email address: osas.central@g.batstate-u.edu.ph\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/11/Nursing-ND-1.jpg",
                "https://batstate-u.edu.ph/student-affairs-and-services/#"

            )
        )

        dataList.add(
            DataItem(
                "MULTI-FAITH SERVICES\n\n",

                "Pursuant to Section 30 Article IX CHED Memorandum Order No. 09 Series 2013 9 Enhanced Policies and Procedures on  Student Affairs and Services) and in adherence to Section 5 Articles  III 1987 Philippine Constitution, the BatStateU Office of Multi-Faith Services ensures that the students’ right to freedom of religion is respected.  \n\n" +

                        "The University ensures that the right of religion is respected. It is the policy of the University to provide an environment conducive to free expression of one’s religious orientation in accordance with institutional principles and policies. The University provides mechanism for the use of facilities for Multi-faith activities.\n\n" +


                        "Contact Details \n\n" +

                        "Telephone:(043) 980-0385 loc. 1134 \n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2023/01/lemery-student-multi-faith-ministry.jpg",
                "https://batstate-u.edu.ph/student-affairs-and-services/#"

            )
        )
        dataList.add(
            DataItem(
                "NATIONAL SERVICES TRAINING PROGRAM (NSTP)\n\n",

                "Brief Description\n\n" +


                        "The National Service Training Program Office (NSTP Office) is the University unit that manages the implementation of the service training mandated under Republic Act No. 9163 (otherwise known as the NSTP Act of 2001) which provides that all tertiary level students taking baccalaureate or vocational courses must take one of the three components of this service training program, namely, Reserve Officers’ Training Corps (ROTC), Civic Welfare Training Service (CWTS) and Literacy Training Service (LTS).\n\n" +


                        "Committed to provide relevant service training for students, the office oversees military and community-based activities that instills values for development through the 307th NROTC Unit in Gov. Pablo Borbon Campus 1 and Gov. Pablo Borbon Campus 2, Rosario and Malvar and the 401st ROTC Unit in ARASOF-Nasugbu and Balayan Campuses, as well as CWTS and LTS programs in all campuses of the University.\n\n" +


                        "Directly supervised by the VPAA, under OSAS the NSTP Office is headed by the Asst. Director assisted by Heads of campuses and/or coordinators.\n\n" +

                        "FUNCTIONS, DUTIES AND RESPONSIBILITIES\n\n" +

                        "The General Functions of the Office include:\n\n" +

                        "1. Implementation of the mandates of RA 9163, specifically enhancing civic consciousness and defense preparedness in the youth by developing the ethics of service and patriotism while undergoing training in any of the three (3) program components (ROTC, CWTS and LTS) specially designed to enhance the youth’s active contribution to general welfare;\n\n" +

                        "2. Promoting civic consciousness and develop students’ physical, moral, spiritual, intellectual and social well-being;\n\n" +

                        "3. Inculcate the ideals of patriotism, nationalism, and advance students’ involvement in public and civic affairs; and\n\n\n" +


                        "4. Motivate, train, organize and involve the students in military, literacy, civic welfare programs, and other similar endeavors in the service of the nation\n\n\n\n" +


                        "THE DUTIES AND RESPONSIBILITIES INCLUDE:\n\n" +

                        "1. Academic supervision over the design, formulation, adoption and implementation of program of instruction of NSTP components;\n\n\n" +
                        "2. Support to University’s involvement in socio-civic and community affairs;\n\n\n\n" +

                        "VISION, MISSION, GOALS AND OBJECTIVES\n\n" +

                        "1. CIVIC WELFARE TRAINING SERVICE (CWTS) / LITERACY TRAINING SERVICE (LTS)\n\n" +

                        "MISSION:\n\n" +

                        "To conduct enhancement for civic welfare services geared towards strengthening the values, and traits of the youth, develop social entrepreneurs, volunteers, and socio-economic mobilizing force, serving communities as value-driven innovators for progress and development while working closely with a network of organizations within and outside the higher educational institution.\n\n" +

                        "VISION:\n\n" +

                        "Recovery of the youth’s sense of patriotism and national pride, values and habits of discipline and hard work, integrity and accountability for nation building, volunteer in the enhancement of valuable and effective members of the National Service Corps of the Civic Welfare Training Service.:\n\n" +

                        "GOAL:\n\n" +

                        "To promote and integrate values education, transformational leadership and sustainable social mobilization for youth development, community building, national renewal and global solidarity.\n\n" +


                        "OBJECTIVES:\n" +

                        "1. To promote and protect the physical, mental, spiritual, intellectual and social well-being of the youth.:\n" +
                        "2. To inculcate patriotism and nationalism in the youth.\n" +
                        "3. To encourage their involvement in public and civic affairs.\n" +
                        "4. To identify their role as change agents in the community.\n" +
                        "5. To prepare and implement projects that will answer specific needs of the society.\n" +

                        "VALUES:\n" +

                        "1.We are guided by our commitment to:\n" +
                        "2.Love God\n" +
                        "3. Human Dignity\n" +
                        "4. Truth, goodness and social responsibility\n" +
                        "5. Innovation and creativity\n" +
                        "6. Synergy and professionalism\n" +
                        "7. Protection of the environment\n" +
                        "8. Indigenous learning and conservation\n" +
                        "9. Quality service delivery\n" +


                        "We Develop…:\n" +

                        "1. Volunteers, virtuous social entrepreneurs who are result-oriented individual with strong values to contribute national peace, development and security;\n\n" +
                        "2. Individuals, organizations institutions committed to serving people for God’s glory to enhance growth and development in the society.\n\n\n" +

                        "We Serve community by…\n" +


                        "1. Developing an informed and aware community;\n\n" +
                        "2. Encouraging inter-government agency cooperation;\n\n" +
                        "3. Assisting the community in defining and identifying ideas of development;\n\n" +
                        "4. Providing complementary assistance and support to facilitate socio-economic development, environmental and natural resources management and delivery of basic services; and\n\n" +
                        "5. Uplifting the well-being of people.\n\n" +


                        "We pursue our goals through…\n" +

                        "1. Integrative approach to human development that begins with one’s development that begins with one’s self\n\n\n" +
                        "2. Partnership with local officials, civic leaders and non-government organizations;\n\n" +
                        "3. Self-reliant community development supportive of national goals;\n\n" +
                        "4. Community building;\n\n" +
                        "5. Participatory decision-making.\n\n" +





                        "RESERVE OFFICERS’ TRAINING CORPS (ROTC)\n" +
                        "VISION\n\n" +
                        "To organize, train, equip and administer naval reservists in order to provide the Philippine Navy/Army base of expansion in the event of war innovation, rebellion or disaster/calamities, and to assist in the socio-economic development of the country.\n\n\n" +
                        "Unit Vision\n\n" +
                        "To train and develop college students in the rudiments of military training service for capable Philippine Navy/Army in Armed Forces of the Philippines Reservists.\n\n" +



                        "GENERAL OBJECTIVES\n\n" +
                        "1. Administer the National Service Training Program (NSTP) to those who opted to take military service.\n" +
                        "2. Support the environmental protection and civil military operation (CMO) activities of Reserve Cenater Southern Luzon.\n\n\n\n" +

                        "SPECIFIC OBJECTIVES\n\n" +

                        "1. Conduct the basic military training and advance ROTC.\n" +
                        "2. Participate environmental protection and civil military operation activities.\n" +
                        "3. Maintain and operate facilities, equipment and related equipage of the ROTC unit.\n" +


                        "PERSONNEL AND STAFF AT BATSTATEU NSTP MAIN OFFICE\n\n" +
                        "1. Dr. Romeo M. Guillo, Jr., Asst. Director, NSTP\n" +
                        "2. Mr. Alfonso Fredericko V. Gonda, Administrative Staff\n" +





                        "CONTACT DETAILS\n\n" +



                        "Telephone:(043) 980 0385 local 1995 \n\n"+
                        "Facebook Page: http://facebook.com/BatStateUNSTP\n\n"+
                        "Email Address: nstp.main@g.batstate-u.edu.ph\n\n",

                "https://i.ytimg.com/vi/cJT0kuUz0u0/maxresdefault.jpg",
                "https://batstate-u.edu.ph/student-affairs-and-services/#"

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