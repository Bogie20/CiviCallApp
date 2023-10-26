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

class EmpoweringStudentInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empowering_student_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "SUPREME STUDENT COUNCIL BATSTATE MALVAR",
                "The highest governing body of all the student organizations in the university and they intend to take an active participation in all schools and community activities and spearhead programs for the welfare of the students.\n\n",
                             R.drawable.img_377,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/366719821_680180814153627_82160342913688567_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGvxcSa5TDXI0FFscyAZTqq-aUrM0O4cXP5pSszQ7hxc9SXBYlSbm5eLBcPVu3-pS5WXQBVUFGuC1fZfhVANlue&_nc_ohc=Zt5PmoEGCOcAX_BvZBD&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfAr1yS03MYLXkNkUlQRSE2xloMDsAEkE21ke3dlXrMgKA&oe=653B68B3"
            )
        )
        dataList.add(
            DataItem(
                "JUNIOR MARKETING EXECUTIVES",
                "The Junior Marketing Executive- Malvar Campus envisions itself to be a channel that will nurture the students towards becoming the finest Marketing Professional and Country’s future leader. To lead the business students into the 21st century through marketing excellence.\n\n",
                R.drawable.img_378,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-1.fna.fbcdn.net/v/t39.30808-6/341508685_1213788782834344_4468458434966064894_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFmUb6VwYFGqEeLn2-Fq6RarLZzpERf8DWstnOkRF_wNUXSowu5-ly_lqe_3VWbr-qHvY9jvoTZ8ofn5R1Ar_Vs&_nc_ohc=coeW7Jiaym0AX_OWt1Q&_nc_ht=scontent.fmnl13-1.fna&oh=00_AfB9R5HD-5pWXl1toNz0fZbBlilgDgcpwFKk6_BZAPCG0Q&oe=653BB0E7"
            )
        )

        dataList.add(
            DataItem(
                "JUNIOR PHILIPPINES ASSOCIATION OF MANAGEMENT ACCOUNTANTS",
                "The Junior Philippines Association of Management Accountants is an organization carrying out the development of moral, mental, physical and social growth of Bachelor of Science in Management Accounting students. This organization represents the BSMA students’ populace in the Supreme Student Council and in the National Federation of Junior Philippines Institute of Accountants. The organization stands neutral for the benefit of both students and the institution.\"\n\n",
                R.drawable.img_379,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/293814881_503560974861905_7213387321878991538_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeG7OMFEdNCYsPskaBJJtZ3g4rYoUZA6JRfitihRkDolF5QzE3z98AO-3QDr2HeKr64UUu88kRwqRUgiKbCmVW4G&_nc_ohc=SCMDQV4v6poAX-jeuR_&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfCykJ9IIIJ44ou49gL5SBhrjOe61cZ0_Al3dXKdxWbDOg&oe=653C1739"
            )
        )

        dataList.add(
            DataItem(
                "JUNIOR PHILIPPINE INSTITUTE OF INDUSTRIAL ENGINEERS - BATSTATEU MALVAR",
                "The Junior Philippine Institute of Industrial Engineers (JPIIE) - BatStateU Malvar is an alliance of IE Students in Batangas State University that promotes the interest and competence of the IE profession through organized effort by having dynamic programs and activities that focus on enriching every member’s skill in the field of Industrial Engineering.\n\n",
                R.drawable.img_380,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-1.fna.fbcdn.net/v/t39.30808-6/279019856_527574645708904_9000107538305312290_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeF00hFzbdQjTmqMHhDsRJy0OJ8FX8K_ccY4nwVfwr9xxmfc_m9SkOAUVR2qOiQlv62_fJmKQorqUlNL5NlCGzYw&_nc_ohc=eAZ0iBtRIXEAX8YYi37&_nc_ht=scontent.fmnl13-1.fna&oh=00_AfAaQWnc3ZkLSucPqV4c5rOC18do1reuPIO6oIrgpHxhJA&oe=653AE394"
            )
        )


        dataList.add(
            DataItem(
                "JUNIOR PEOPLE MANAGEMENT ASSOCIATION OF THE PHILIPPINES",
                "The Junior People Management Association of the Philippines (JPMAP) is an organization that is at the forefront of the college students and graduates of BSBA-Human Resource Management in all activities and related matters and concerns in the department. It is committed to becoming the model grounded on good character, a deep sense of moral values, and good leadership in promoting the rights and welfare of every student, teacher, and organization alike. It is set up along with participatory democracy, responsible servant-leadership, collaboration, unity, accountability, and efficiency in serving as an advocate for the diverse individuals of Batangas State University-Malvar Campus.\n\n",
                R.drawable.img_381,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/295110384_355714383399372_2696565999360138651_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEbKDk8ObStoi2Uo74VBtOe0ojTi82RtjrSiNOLzZG2OrfTqYoUEeek0deLMxUGTb9c5Y3eNldeBLPzu_f7MO5j&_nc_ohc=rxYBWjuCnE8AX9qhMDO&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfDKWODmIAtyEXX4lOtFmI2MRevehSiy1d_pgGUOA6ORCw&oe=653B7B76"
            )
        )



        dataList.add(
            DataItem(
                "ALLIANCE OF FUTURE PSYCHOLOGIST",
                "The Alliance of Future Psychologists (AFP) is an organization that provides psychology students with adequate training to maximize their potential as future psychometricians. It focuses on the establishment of camaraderie between school officials, educators, personnel, and students; the growth of interest and awareness among psychometricians and; the improvement of student knowledge and skills - which are a bridge to a dynamic and responsive College of Arts and Sciences in the pursuit of transforming into public-serving-based center for excellence.\n\n",
                R.drawable.img_382,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/305192758_448577453959805_6798980443996863280_n.png?_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFbIN6MJwo2THRajQ-fam2I9ghLO7PGLFX2CEs7s8YsVdBdPqkfzwVnkN1clirV6mTlc1hodJWMrxh0Q_qfadZ6&_nc_ohc=T-q2S0E06lUAX_dekhc&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfDfmtzpAz8MZt_EJ24hvn9J63qM3f1GBdTgZbhf83tOaA&oe=653B72D7"
            )
        )


        dataList.add(
            DataItem(
                "COLLEGE OF INDUSTRIAL TECHNOLOGY STUDENT COUNCIL",
                "\"The College of Industrial Technology Student Council or CITSC is an organization that envision the College of Industrial Technology of BatStateU-JPLPC as a dynamic and responsive center of excellence and steadfast in developing technology based and globally competitive individuals. The CITSC deeply commits to the mission of continuously upgrade the skills and competencies of student’s thereby producing world class workers, to produce well-rounded industrial technologists with high sense values and responsibilities and to spearhead innovative techniques that will re-engineer technological processes. Our organization aims to promote student’s rights and privileges, develop responsible Filipino citizens, protect the students and institution from intruders that may destroy its good purpose, promote activities that will help the students become well rounded individuals, and encourage the students to pursue and finish the chosen career for the welfare of oneself and the community.\"",
                R.drawable.img_383,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/366719821_680180814153627_82160342913688567_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGvxcSa5TDXI0FFscyAZTqq-aUrM0O4cXP5pSszQ7hxc9SXBYlSbm5eLBcPVu3-pS5WXQBVUFGuC1fZfhVANlue&_nc_ohc=Zt5PmoEGCOcAX_BvZBD&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfAr1yS03MYLXkNkUlQRSE2xloMDsAEkE21ke3dlXrMgKA&oe=653B68B3"
            )
        )


        dataList.add(
            DataItem(
                "MECHATRONICS ENGINEERING STUDENTS' SOCIETY",
                "\"Established in 2008 as a 29-member student organization, the Mechatronics Engineering Students’ Society - JPLPC-Malvar, also known by “MEXESS,” remains headstrong today in equipping Bachelor of Science in Mechatronics Engineering Students of Batangas State University - JPLPC-Malvar Campus with representations of transcending knowledge and capabilities of a Mechatronics Engineer. From Ambitions turned to Innovations, the MEXESS serves as a platform in service of the Mechatronics Engineering Community. MEXESS continues to hone its constituents with competence and leadership in innovative thinking and developing skill sets revolving around the motto, “We don’t want an easier life; we just want to make life easier.”\"\n\n",
                R.drawable.img_384,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/366719821_680180814153627_82160342913688567_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGvxcSa5TDXI0FFscyAZTqq-aUrM0O4cXP5pSszQ7hxc9SXBYlSbm5eLBcPVu3-pS5WXQBVUFGuC1fZfhVANlue&_nc_ohc=Zt5PmoEGCOcAX_BvZBD&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfAr1yS03MYLXkNkUlQRSE2xloMDsAEkE21ke3dlXrMgKA&oe=653B68B3"
            )
        )




        dataList.add(
            DataItem(
                "BSU-JPLPC PEER FACILITATOR'S SOCIETY",
                "The Peer Facilitator's Society (PFS) is a co-curricular student organization. A university-wide organization that prioritizes students' psychological health, creates opportunities for them to reach out to their peers who need social connection, encouragement, and support. This is an organization of concerned students who will have missions of reaching out to others, especially their fellow students who have problems that affect their studies.\n\n",
                R.drawable.img_385,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/370418427_788244509970869_1066529243830720279_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeHF9c2hSnCNXdmWJmXADzTrOIY-P5fe7FQ4hj4_l97sVOi6ZxGNpsvBBkkR57b6nJh1-Zp1q8WaWOTMfHCF3mcJ&_nc_ohc=AVxth7bKEJcAX9l-oEF&_nc_oc=AQl3dzfxJKj2RV8tgLMgWUpu5tm5LeEe8P3jBcOi1XMRWvWxNNzDg9H4K_vAvEvMloV36yppe61z3AUkz-MLBHXz&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfBifQHM_7DCUHq-lj3ZyNnfIlM96QMdFIXPtUqL1HGpNw&oe=653BD483"
            )
        )



        dataList.add(
            DataItem(
                "CAMPUS CONNECT",
                "\"The Campus Connect Organization is a campus-wide organization that aims to see every student being responsible in every aspect of their lives and to inspire them to allow God to move and shape their future. The organization wants to inspire every student through the word of God and motivate them to excel for their respective careers through leadership training. Also embrace every student and encourage everyone to strengthen the relationships to their family, society and God, to see this nation transform through the people or the students who fear God and love the nation.\"\n\n",
                R.drawable.img_386,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/277004638_102399755769594_4324128706905523058_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeHmWgwfz8F43Jrt9-SjJQQ76PgVirJNECPo-BWKsk0QI5MuigHG8wmeidJR5LYXIV_y-xlQtxmc4gHofZDk_esG&_nc_ohc=GGM-gBSCcYIAX84r79A&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfAZxvS3TmkP1j0JMH1sCq2q6LuCLCacJ8as8ZRTOJbmyw&oe=653B3B41"
            )
        )



        dataList.add(
            DataItem(
                "LINGAP MENTAL HEALTH AND PSYCHOSOCIAL SUPPORT",
                "\"The Lingap Mental Health and Psychological Support (Lingap MHPSS) is an organization that envisions a safe, supportive, and inclusive community which is free from stigma by providing mental health services and psychosocial support accessible to everyone. The organization objective is to provide mental health and psychological support for the community.\"\n\n",
                R.drawable.img_387,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-1.fna.fbcdn.net/v/t39.30808-6/222304606_110806227954091_6103416302207298151_n.png?_nc_cat=104&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeG0e45kgqxT9kdaTkJdUFticE0VZ-imMFZwTRVn6KYwVisnD5mO11cpOc_zlhkumtfxW-FZex5hg9ErJxtR6yf3&_nc_ohc=zLLogPP18x0AX8r14Mt&_nc_ht=scontent.fmnl13-1.fna&oh=00_AfDzUkZHyEdhYUHG2q4F7ug37-UuU-3ykTUProRKpHXcVQ&oe=653BE348"
            )
        )




        dataList.add(
            DataItem(
                "ALLIANCE OF CRIMINOLOGY STUDENTS",
                "The Alliance of Criminology Students is anchored on the philosophy of establishing a sense of competence and moral righteousness in the minds of the members who would become actively and continually involved in effective and efficient law enforcement. The organization envisions itself as a partner of the institution in developing criminology students who have honor and integrity as future law enforcers so as to promote accountability, candour and nobility, it also focuses on developing future law enforcers who are competent, morally upright, effective and efficient in addressing the problem of criminality in the country and meeting the challenges of mobilization in law enforcement which seeks to establish leadership, integrity, responsibility, and accountability upon the members of the organizations.\n\n",
                R.drawable.img_388,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-1.fna.fbcdn.net/v/t39.30808-6/297826701_1341251326405652_8589720022709154126_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeH0Gzy4yysAl0dl9QthgV-3f5KuKp-X6n1_kq4qn5fqfVUIKLsHUQ3Ma1VWojOnaTGV-pN82Z9HKPyVp5TuKW3E&_nc_ohc=jod9CmmXwy0AX8KXWU8&_nc_oc=AQmnQV0LEpw3chAyZjvrRVrKPI4Y0JUBVFHt8udc9CkTlgEZnPeh6NwYyk8dJGog0PHIN694H2ZG4vA405Xv6J3_&_nc_ht=scontent.fmnl13-1.fna&oh=00_AfCBCALkbAoqObObG4eMRPm07vVEBeZs7DOwma4mFtvg0A&oe=653B655E"
            )
        )



        dataList.add(
            DataItem(
                "GOOGLE DEVELOPER STUDENT CLUB BATANGAS STATE UNIVERSITY JPLPC - MALVAR",
                "\"Google Developer Student Clubs (GDSC) are community groups in universities that allow students to learn, connect, and grow. It also provides opportunities to students who are interested in Google developer technologies and create solutions to contribute not just in their community but globally most especially the Sustainable Development Goals. The Google Developer Student Club is trying to bridge the gap between Theory and Practice.\"",
                R.drawable.img_389,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://res.cloudinary.com/startup-grind/image/fetch/c_scale,w_2560/c_crop,h_650,w_2560,y_0.49_mul_h_sub_0.49_mul_650/c_crop,h_650,w_2560/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/https://res.cloudinary.com/startup-grind/image/upload/c_fill%2Cdpr_2.0%2Cf_auto%2Cg_center%2Cq_auto:good/v1/gcs/platform-data-dsc/chapter_banners/FB%2520Cover-Recovered-Recovered.jpg"
            )
        )



        dataList.add(
            DataItem(
                "COLLEGE OF INFORMATICS AND COMPUTING SCIENCE STUDENT COUNCIL",
                "\"The College of Informatics and Computing Sciences Student Council is defined as the independent governing body of the information technology and computer science students of Batangas State University TNEU JPLPC-Malvar. The organization shall develop a higher sense of respect and responsibility that will enable students to maximize their educational opportunities, relative to development among students. Also, facilitate, provide, and support new technologies, with the objective to integrate, foster, and promote the development of imagination, creativity, and innovation in students, professors and faculty.\"\n\n",
                R.drawable.img_390,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-2.fna.fbcdn.net/v/t39.30808-6/297759803_101114722712239_3450050817318209503_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEKPmJe3fKHF10J7SPLJO2wxulXoL_A5BPG6Vegv8DkEwWI2RqeWaz4C6uJHkjFm45qKtpNbcQJkOfuEwLnnj4m&_nc_ohc=spgS48XgCmoAX-ylq0G&_nc_ht=scontent.fmnl13-2.fna&oh=00_AfAN8AqgVrzsNGEkfdx29rvRd5dAKj-sWhI5iHGYidt8Lg&oe=653AC705"
            )
        )







        dataList.add(
            DataItem(
                "JUNIOR HOTELIERS AND RESTAURATEURS ASSOCIATION",
                "\"The Junior Hoteliers and Restaurateurs Association is made up of goal-oriented individuals who come together to learn and support each other. This Organization represents the IHM students' populace in the Supreme Student Council. The organization helps students to create and achieve their goals for better and successful tomorrow. Members establish relationships to expose in the hospitality and tourism industry that will lead to jobs in the field.\"",
                R.drawable.img_391,
                "https://batstate-u.edu.ph/campus-life/student-organizations",
                "https://scontent.fmnl13-1.fna.fbcdn.net/v/t39.30808-6/307460731_462693295882103_8931085909524855370_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEs4c63QwGOTAWxV4yFrVozKCdF20Re008oJ0XbRF7TT_9MRzcV4fd5uZfDm7iAf9HWJCoWRW0gdchGAgj3v3ZM&_nc_ohc=Mjj4juf4TSgAX_nWlPA&_nc_ht=scontent.fmnl13-1.fna&oh=00_AfBItUsx6-aybER_SLLmM3vbKT-Pdz_sbEdxexw63KFb2g&oe=653C60B9"
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