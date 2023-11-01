package com.example.civicall.CampusGovernanceInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.NetworkUtils
import com.example.civicall.R

class FourStudentInitiatives : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_student_initiatives)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "SUPREME STUDENT COUNCIL BATSTATE UNIVERSITY",
                "The highest governing body of all the student organizations in the university and they intend to take an active participation in all schools and community activities and spearhead programs for the welfare of the students.\n\n",

                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/366719821_680180814153627_82160342913688567_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGMZNeiYhG_wnBoNXoa5SNb-aUrM0O4cXP5pSszQ7hxc9K_dziv64VqH27OSoGBazLdi23bo3x5Rck6d9_w19XH&_nc_ohc=VicufJdpb7wAX9fyXWc&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfCemaBysEeSVlGaGbkf9WmytmplqTqrbLx5aq0hyH-mZg&oe=65474633",
                "https://batstate-u.edu.ph/campus-life/student-organizations"

            )
        )
        dataList.add(
            DataItem(
                "JUNIOR MARKETING EXECUTIVES",
                "The Junior Marketing Executive- Malvar Campus envisions itself to be a channel that will nurture the students towards becoming the finest Marketing Professional and Country’s future leader. To lead the business students into the 21st century through marketing excellence.\n\n",

                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/289790637_100250122748215_6706593044014033909_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFnEDvw6fNdzamLdNN4wL0i27KlBI8f82vbsqUEjx_za20POSwjqX_DfR9hRk48vqolbU-gYnVsquLZYdT7__lL&_nc_ohc=cNoNx5bSKVUAX_8GjAe&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfA4g66uyNTqyUfZz5UpEf8G-hHgCWboOu0VKSNfL0i8ew&oe=65464CD8",
                "https://batstate-u.edu.ph/campus-life/student-organizations"

            )
        )

        dataList.add(
            DataItem(
                "JUNIOR PHILIPPINES ASSOCIATION OF MANAGEMENT ACCOUNTANTS",
                "The Junior Philippines Association of Management Accountants is an organization carrying out the development of moral, mental, physical and social growth of Bachelor of Science in Management Accounting students. This organization represents the BSMA students’ populace in the Supreme Student Council and in the National Federation of Junior Philippines Institute of Accountants. The organization stands neutral for the benefit of both students and the institution.\"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2023/05/image49-300x300.jpg",
                "https://batstate-u.edu.ph/campus-life/student-organizations"
            )
        )

        dataList.add(
            DataItem(
                "JUNIOR PHILIPPINE INSTITUTE OF INDUSTRIAL ENGINEERS",
                "The Junior Philippine Institute of Industrial Engineers (JPIIE) - BatStateU Malvar is an alliance of IE Students in Batangas State University that promotes the interest and competence of the IE profession through organized effort by having dynamic programs and activities that focus on enriching every member’s skill in the field of Industrial Engineering.\n\n",

                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/366081923_745446887589435_9103686530284569517_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEc_MzrxAqDoItRCSpP49BeyAt150Pz3Q3IC3XnQ_PdDVf_qg_IVBJBMhWgI4WPeyiWK93HVm3s0NIKHlA76KSO&_nc_ohc=4tHXxtKyilQAX9Keyb6&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfCu7tKLrHbGIhCuszxd_RXQjQxLpQl0pT8KzYGnsDfHFA&oe=6546A1A8",
                "https://batstate-u.edu.ph/campus-life/student-organizations"

            )
        )


        dataList.add(
            DataItem(
                "JUNIOR PEOPLE MANAGEMENT ASSOCIATION OF THE PHILIPPINES",
                "The Junior People Management Association of the Philippines (JPMAP) is an organization that is at the forefront of the college students and graduates of BSBA-Human Resource Management in all activities and related matters and concerns in the department. It is committed to becoming the model grounded on good character, a deep sense of moral values, and good leadership in promoting the rights and welfare of every student, teacher, and organization alike. It is set up along with participatory democracy, responsible servant-leadership, collaboration, unity, accountability, and efficiency in serving as an advocate for the diverse individuals of Batangas State University-Malvar Campus.\n\n",

                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/295110384_355714383399372_2696565999360138651_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeHYZeawT-k0ze7ygU-wq2YE0ojTi82RtjrSiNOLzZG2Oqg9Evj7xuk2tUDkITWkaZQFlTHj2EFnhiWQVwbpN6EN&_nc_ohc=Qht8wb_pCnAAX-CN5eo&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfBgsWwmcUBYZUYHtFNuw4WZ_D-vJoWkg37npbsmFKH9ow&oe=654758F6",
                "https://batstate-u.edu.ph/campus-life/student-organizations"

            )
        )


        dataList.add(
            DataItem(
                "ALLIANCE OF FUTURE PSYCHOLOGIST",
                "The Alliance of Future Psychologists (AFP) is an organization that provides psychology students with adequate training to maximize their potential as future psychometricians. It focuses on the establishment of camaraderie between school officials, educators, personnel, and students; the growth of interest and awareness among psychometricians and; the improvement of student knowledge and skills - which are a bridge to a dynamic and responsive College of Arts and Sciences in the pursuit of transforming into public-serving-based center for excellence.\n\n",

                "https://scontent.fmnl13-1.fna.fbcdn.net/v/t39.30808-6/305457911_448577457293138_1948134041592438845_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFoJ9nTrOIgqD0F9LoJiKLcufh4-lMkO0K5-Hj6UyQ7QgaNcvPplVr3xWe6B7klQym3SHrZ_zLR0-fguyjGqkSf&_nc_ohc=lMIJ3IxAhS8AX9VzqnH&_nc_ht=scontent.fmnl13-1.fna&oh=00_AfBGKGn0JYtWS9TuXYD4hgyXuH_ntSth34F6NNhKBnOIpw&oe=6545F20D",
                "https://batstate-u.edu.ph/campus-life/student-organizations"
            )
        )


        dataList.add(
            DataItem(
                "COLLEGE OF INDUSTRIAL TECHNOLOGY STUDENT COUNCIL",
                "\"The College of Industrial Technology Student Council or CITSC is an organization that envision the College of Industrial Technology of BatStateU-JPLPC as a dynamic and responsive center of excellence and steadfast in developing technology based and globally competitive individuals. The CITSC deeply commits to the mission of continuously upgrade the skills and competencies of student’s thereby producing world class workers, to produce well-rounded industrial technologists with high sense values and responsibilities and to spearhead innovative techniques that will re-engineer technological processes. Our organization aims to promote student’s rights and privileges, develop responsible Filipino citizens, protect the students and institution from intruders that may destroy its good purpose, promote activities that will help the students become well rounded individuals, and encourage the students to pursue and finish the chosen career for the welfare of oneself and the community.\"",

                "https://scontent.fmnl13-1.fna.fbcdn.net/v/t39.30808-6/299291047_446739067500456_65662016232383945_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGrfXU0zq6h_YEP4iIbq-4bly9pvXEwCQCXL2m9cTAJAGNBOT--9tuL0ISaQdFt1r2rMKe-FLtKvoPEEqdulTjs&_nc_ohc=_xM34oinY24AX-CUSbM&_nc_ht=scontent.fmnl13-1.fna&oh=00_AfBNaScvXmuWeVYxPnWTMljn2YlILwKS4VV2QNlJR4d8VQ&oe=65475CF7",
                "https://batstate-u.edu.ph/campus-life/student-organizations"

        )
        )


        dataList.add(
            DataItem(
                "MECHATRONICS ENGINEERING STUDENTS' SOCIETY",
                "\"Established in 2008 as a 29-member student organization, the Mechatronics Engineering Students’ Society - JPLPC-Malvar, also known by “MEXESS,” remains headstrong today in equipping Bachelor of Science in Mechatronics Engineering Students of Batangas State University - JPLPC-Malvar Campus with representations of transcending knowledge and capabilities of a Mechatronics Engineer. From Ambitions turned to Innovations, the MEXESS serves as a platform in service of the Mechatronics Engineering Community. MEXESS continues to hone its constituents with competence and leadership in innovative thinking and developing skill sets revolving around the motto, “We don’t want an easier life; we just want to make life easier.”\"\n\n",

                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/385495801_336252432093422_4522637367835851776_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFKChJ7RGbxSIyu7k-qufzt3wDx1NGJAs_fAPHU0YkCz7Xqh0DEdvaTD7LFF45Ve2bqNzmsVPIHsWZWL3x1jFWJ&_nc_ohc=R3b4VLWC7rAAX_6hz9i&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfDADA5TgBE5-qe2PeZkCXStAExwKMHAORJ84haxor7M9Q&oe=6547B464",

                "https://batstate-u.edu.ph/campus-life/student-organizations",
            )
        )


        dataList.add(
            DataItem(
                "BSU-JPLPC PEER FACILITATOR'S SOCIETY",
                "The Peer Facilitator's Society (PFS) is a co-curricular student organization. A university-wide organization that prioritizes students' psychological health, creates opportunities for them to reach out to their peers who need social connection, encouragement, and support. This is an organization of concerned students who will have missions of reaching out to others, especially their fellow students who have problems that affect their studies.\n\n",
"https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/370418427_788244509970869_1066529243830720279_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGwr47xMMh_7zacfueKQeSMOIY-P5fe7FQ4hj4_l97sVDkpaVdrptX77DPWI7dVW5Aep9Povt6ZPywGqFGIxWle&_nc_ohc=7jiEihBFtSYAX8Ks5lA&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfCc9X55osfQRvboUJgXufF6SxIbVkYqghWl4cYg1yrwWA&oe=6547B203",
                "https://batstate-u.edu.ph/campus-life/student-organizations",

            )
        )



        dataList.add(
            DataItem(
                "CAMPUS CONNECT",
                "\"The Campus Connect Organization is a campus-wide organization that aims to see every student being responsible in every aspect of their lives and to inspire them to allow God to move and shape their future. The organization wants to inspire every student through the word of God and motivate them to excel for their respective careers through leadership training. Also embrace every student and encourage everyone to strengthen the relationships to their family, society and God, to see this nation transform through the people or the students who fear God and love the nation.\"\n\n",
                "https://batstate-u.edu.ph/wp-content/uploads/2023/05/image51-300x210.jpg",
                "https://batstate-u.edu.ph/campus-life/student-organizations"

            )
        )



        dataList.add(
            DataItem(
                "LINGAP MENTAL HEALTH AND PSYCHOSOCIAL SUPPORT",
                "\"The Lingap Mental Health and Psychological Support (Lingap MHPSS) is an organization that envisions a safe, supportive, and inclusive community which is free from stigma by providing mental health services and psychosocial support accessible to everyone. The organization objective is to provide mental health and psychological support for the community.\"\n\n",

                "https://scontent.fmnl4-5.fna.fbcdn.net/v/t39.30808-6/222351149_110836861284361_1404036891290484454_n.png?_nc_cat=106&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEyZo9uMsIBjGf8P242-thr_KLYpr0u8nv8otimvS7yew372UyZIN4vS3vDTdeRp--TGrX3xXwLELLvQCK3OJir&_nc_ohc=tY5BqHgMI6IAX_6eR4I&_nc_ht=scontent.fmnl4-5.fna&oh=00_AfCfvZeMPanTxN3tU-MkO6mqBH2AXFGt-Gx88Uew8W2XQA&oe=65471024",
                "https://batstate-u.edu.ph/campus-life/student-organizations"

            )
        )




        dataList.add(
            DataItem(
                "ALLIANCE OF CRIMINOLOGY STUDENTS",
                "The Alliance of Criminology Students is anchored on the philosophy of establishing a sense of competence and moral righteousness in the minds of the members who would become actively and continually involved in effective and efficient law enforcement. The organization envisions itself as a partner of the institution in developing criminology students who have honor and integrity as future law enforcers so as to promote accountability, candour and nobility, it also focuses on developing future law enforcers who are competent, morally upright, effective and efficient in addressing the problem of criminality in the country and meeting the challenges of mobilization in law enforcement which seeks to establish leadership, integrity, responsibility, and accountability upon the members of the organizations.\n\n",

                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/301548570_1354404361757015_3556160616597595737_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGRM0zvzg_Yf1C_iiyuclVVecmX-CIREyx5yZf4IhETLCwaClftPj89D5KYq8VwUkgE0vjQ2RSAQP5I6IwzQ4Rv&_nc_ohc=1jaUKaGvvC0AX_WM_jh&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfC4VPuIDxd08Mb2cnLQAM6ks3MIk9KbgxVUuWT1S8S8ww&oe=6547D64C",
                "https://batstate-u.edu.ph/campus-life/student-organizations"

            )
        )



        dataList.add(
            DataItem(
                "GOOGLE DEVELOPER STUDENT CLUB BATANGAS STATE UNIVERSITY JPLPC - MALVAR",
                "\"Google Developer Student Clubs (GDSC) are community groups in universities that allow students to learn, connect, and grow. It also provides opportunities to students who are interested in Google developer technologies and create solutions to contribute not just in their community but globally most especially the Sustainable Development Goals. The Google Developer Student Club is trying to bridge the gap between Theory and Practice.\"",

                "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2.0,f_auto,g_center,h_1080,q_100,w_1080/v1/gcs/platform-data-dsc/chapter_banners/GDSC%20NEW_LOGO.jpg",
                "https://batstate-u.edu.ph/campus-life/student-organizations"

            )
        )



        dataList.add(
            DataItem(
                "COLLEGE OF INFORMATICS AND COMPUTING SCIENCE STUDENT COUNCIL",
                "\"The College of Informatics and Computing Sciences Student Council is defined as the independent governing body of the information technology and computer science students of Batangas State University TNEU JPLPC-Malvar. The organization shall develop a higher sense of respect and responsibility that will enable students to maximize their educational opportunities, relative to development among students. Also, facilitate, provide, and support new technologies, with the objective to integrate, foster, and promote the development of imagination, creativity, and innovation in students, professors and faculty.\"\n\n",

                "https://scontent.fmnl4-3.fna.fbcdn.net/v/t39.30808-6/297788294_101117949378583_2730987484628642305_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFt_pQ_nObZIfq7v6xltXgbTTfcq74WhaBNN9yrvhaFoGeveSxFSuJ1nedA6cmsBude_J9LRRRvbTqmDZj7vdHm&_nc_ohc=xYjlpAbA-egAX_60xc-&_nc_ht=scontent.fmnl4-3.fna&oh=00_AfCqG_H9fivTbsPBp1t4h6K0pz2lSfA0AWh3oVFtldbzsA&oe=65478C6B",
                "https://batstate-u.edu.ph/campus-life/student-organizations"

            )
        )







        dataList.add(
            DataItem(
                "JUNIOR HOTELIERS AND RESTAURATEURS ASSOCIATION",
                "\"The Junior Hoteliers and Restaurateurs Association is made up of goal-oriented individuals who come together to learn and support each other. This Organization represents the IHM students' populace in the Supreme Student Council. The organization helps students to create and achieve their goals for better and successful tomorrow. Members establish relationships to expose in the hospitality and tourism industry that will lead to jobs in the field.\"",

                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/306840642_462693292548770_6158911639398120611_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeG80mcoGd4kd_l6kE1eeIAHt-sGuFXbu1u36wa4Vdu7W5JyC28VDP_RPNyWnDlemN0AY3OK5NcKKcp5qEWtD5J7&_nc_ohc=lC9OzB9frGYAX8hvuja&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfC9beTSAjilq_McigPUcUPEjrUbwRoSMWrYvHs4glHLlQ&oe=6547C150",

                "https://batstate-u.edu.ph/campus-life/student-organizations",
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
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}