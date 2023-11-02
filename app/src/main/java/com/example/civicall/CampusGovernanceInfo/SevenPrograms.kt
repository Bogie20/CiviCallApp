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
import com.example.civicall.databinding.ActivitySevenProgramsBinding


class SevenPrograms : AppCompatActivity() {
    private lateinit var binding:ActivitySevenProgramsBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivitySevenProgramsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, CampusGovernanceMenu::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "PROGRAMS",



                "The university’s program offerings are recognized by the country’s Commission on Higher Education. These are designed to provide opportunities for students to discover their potentials and enhance their technical and creative skills in a vibrant academic environment.\n" +
                        "\n" +
                        "Each program offering is anchored on pragmatic, relevant, and socially responsive curricula that train students to be globally competitive by embracing transdisciplinarity, social intelligence, new media literacy, design mindset, and physical and virtual collaboration. The university believes that these skills are required in the emerging professional and social environments. \n" +
                        "\n" +
                        "Graduate programs are also offered to provide advanced learning in specialized disciplines. These provide professionals more opportunities for career advancement, increase their prospects, and nurture greater intellectual curiosity and passion for inquiry, thus molding them to become leaders, managers, and innovators by developing transformative solutions to real world problems.\n\n" ,


                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/2nd-Student-Leaders-General-Assembly.jpg",
                "https://batstate-u.edu.ph/programs/"
            )
        )



        dataList.add(
            DataItem(
                "ENGINEERING, ARCHITECTURE AND FINE ARTS\n\n",

                "Engineering programs remain the flagship in the university and are the most popular choice among student applicants, which is why these programs have the largest student population. With the full implementation of outcomes-based teaching and learning and the integration of Technopreneuship in the curricula, engineering programs train future engineers and engineering professionals to develop cutting-edge technologies towards inclusive and sustainable development.  \n\n" +

                        "PROGRAMS OFFERED:\n\n\n" +

                        "Doctor of Philosophy in Electronics Engineering\n\n" +
                        "Doctor of Philosophy in Engineering Management\n\n" +
                        "Doctor of Philosophy in Engineering Education\n\n" +
                        "Master of Science in Electronics Engineering\n\n" +
                        "Master of Science in Computer Engineering\n\n" +
                        "Master of Science in Artificial Intelligence\n\n" +
                        "Master of Science in Advanced Manufacturing\n\n" +
                        "Master of Science in Energy Engineering\n\n" +
                        "Master of Science in Construction Management\n\n" +
                        "Master of Science in Earthquake Engineering\n\n" +
                        "Master of Science in Data Science\n\n" +
                        "Master of Science in Transportation Engineering\n\n" +
                        "Master of Science in Material Science and Engineering\n\n" +
                        "Master in Urban Planning and Design\n\n" +
                        "Master of Science in Engineering Management\n\n\n" +

                        "MASTER OF ENGINEERING\n\n\n" +
                        "Major in Civil Engineering\n\n" +
                        "Major in Chemical Engineering\n\n" +
                        "Major in Computer Engineering\n\n" +
                        "Major in Electrical Engineering\n\n" +
                        "Major in Electronics Engineering\n\n" +
                        "Major in Environmental Engineering\n\n" +
                        "Major in Industrial Engineering\n\n" +
                        "Major in Mechanical Engineering\n\n\n" +

                        "Straight Bachelor to Master in Electronics Engineering\n\n" +
                        "Straight Master to Doctoral in Electronics Engineering\n\n" +
                        "Bachelor of Science in Chemical Engineering*\n\n" +
                        "Bachelor of Science in Civil Engineering*\n\n" +
                        "Bachelor of Science in Computer Engineering*\n\n" +
                        "Bachelor of Science in Electrical Engineering\n\n\n" +

                        "BACHELOR OF SCIENCE IN ELECTRONICS ENGINEERING*\n\n\n" +
                        "Major in Computer Communications\n\n" +
                        "Major in Microelectronics\n\n" +
                        "Major in Telecommunications and Building Infrastructure\n\n\n" +

                        "Bachelor of Science in Food Engineering\n\n" +
                        "Bachelor of Science in Industrial Engineering*\n\n" +
                        "Bachelor of Science in Instrumentation & Control Engineering\n\n" +
                        "Bachelor of Science in Mechanical Engineering*\n\n" +
                        "Bachelor of Science in Mechatronics Engineering\n\n" +
                        "Bachelor of Science in Petroleum Engineering\n\n" +
                        "Bachelor of Science in Sanitary Engineering*\n\n" +
                        "Bachelor of Science in Automotive Engineering\n\n" +
                        "Bachelor of Science in Aerospace Engineering\n\n" +
                        "Bachelor of Science in Transportation Engineering\n\n" +
                        "Bachelor of Science in Biomedical Engineering\n\n" +
                        "Bachelor of Science in Geodetic Engineering\n\n" +
                        "Bachelor of Science in Geological Engineering\n\n" +
                        "Bachelor of Science in Ceramics Engineering\n\n" +
                        "Bachelor of Science in Metallurgical Engineering\n\n" +
                        "Bachelor of Science in Naval Architecture and Marine Engineering\n\n" +
                        "Bachelor of Science in Architecture\n\n" +
                        "Bachelor of Fine Arts and Design major in Visual Communication\n\n" +
                        "Bachelor of Science in Interior Design\n\n\n",



                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/ceafa.jpg",
                "https://batstate-u.edu.ph/programs/engineering/"

            )
        )

        dataList.add(
            DataItem(
                "ARTS AND SCIENCES\n\n",

                "Academic programs under the Arts and Science uphold their scholarly tradition in instruction, research, and community service. Its Development Communication program, in particular, is a designated Center of Development by the Commission on Higher Education. Research conducted in these programs focus on natural sciences, languages, environment and biodiversity, mathematics, humanities, and the social sciences. \n\n" +

                        "PROGRAMS OFFERED:\n\n\n" +

                        "  Doctor of Philosophy in English major in Language and Literature\n\n" +
                        "   Doctor of Philosophy in English\n\n" +
                        "   Master of Arts in English major in Language and Literature\n\n" +
                        "   Master of Science in Mathematics\n\n" +
                        "   Master of Chemistry\n\n" +
                        "   Master of Arts Development Studies\n\n" +
                        "   Master of Science in Marine Biology\n\n" +
                        "   Master of Development Communication\n\n" +
                        "   Bachelor of Arts in English Language Studies\n\n" +
                        "   Bachelor of Arts in Communication\n\n" +
                        "   Bachelor of Science in Biology\n\n" +
                        "   Bachelor of Science in Chemistry\n\n" +
                        "   Bachelor of Science in Criminology\n\n" +
                        "   Bachelor of Science in Development Communication\n\n" +
                        "   Bachelor of Science in Mathematics\n\n" +
                        "   Bachelor of Science in Psychology\n\n" +
                        "   Bachelor of Science in Fisheries and Aquatic Sciences\n\n\n" ,

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/arts.jpg",
                "https://batstate-u.edu.ph/programs/arts-and-sciences"

            )
        )


        dataList.add(
            DataItem(
                "ACCOUNTANCY, BUSINESS, AND INTERNATIONAL HOSPITALITY\n\n",

                "These programs are the second most sought-after programs after engineering. The university has been a prominent producer of licensed professionals in accountancy and customs administration, as well as world-class graduates in the fields of business, entrepreneurship, management accounting, hospitality and tourism management, public administration, and disaster risk management. \n\n\n" +

                        "PROGRAMS OFFERED:\n\n\n" +

                        "   Doctor of Business Administration\n\n" +
                        "   Doctor of Public Administration\n\n" +
                        "   Master of Business Administration\n\n" +
                        "   Master of Public Administration\n\n" +
                        "   Master in Disaster Risk Management\n\n" +
                        "   master in port management\n\n" +
                        "   Master in Supply Chain Management\n\n" +
                        "   Diploma in Disaster Risk Management (Non-Degree)\n\n" +
                        "   Bachelor of Science in Accountancy\n\n" +
                        "   BACHELOR OF SCIENCE IN BUSINESS ADMINISTRATION:\n\n" +
                        "* Major in Business Economics\n\n" +
                        "* Major in Financial Management\n\n" +
                        "* Major in Human Resource Management\n\n" +
                        "* Major in Marketing Management\n\n" +
                        "* Major in Operations Management\n\n" +
                        "   Bachelor of Science in Hospitality Management\n\n" +
                        "   Bachelor of Science in Tourism Management\n\n" +
                        "   Bachelor in Public Administration\n\n" +
                        "   Bachelor of Science in Customs Administration\n\n" +
                        "   Bachelor of Science in Entrepreneurship\n\n\n" ,

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/hrm.jpg",
                "https://batstate-u.edu.ph/programs/accountancy-business-and-international-hospitality/"

            )
        )
        dataList.add(
            DataItem(
                "INFORMATICS AND COMPUTING SCIENCES\n\n",

                "The university offers ITE graduate and undergraduate programs with emphasis on the technical aspects and real-world application of artificial intelligence, machine learning, deep learning and security. BatStateU is the only state university in the Philippines that has Information Technology and Computer Science programs accredited by the US-based Accreditation Board for Engineering and Technology - Computing Accreditation Commission (ABET-CAC). \n\n" +

                        "PROGRAMS OFFERED:\n\n\n" +

                        "Master of Science in Computer Science\n\n" +
                        "Master of Science in Information Technology\n\n" +
                        "Master of Science in Data Science and Analytics\n\n" +
                        "Master in Information Technology\n\n" +
                        "Bachelor of Science in Computer Science\n\n" +
                        "Bachelor of Science in Information Technology\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/cics-1-edited-scaled.jpg",
                "https://batstate-u.edu.ph/programs/informatics-and-computing-sciences/"

            )
        )

        dataList.add(
            DataItem(
                "NURSING, NUTRITION AND DIETETICS\n\n",

                "\n" +
                        "These programs have national accreditation and produce qualified nursing and nutrition & dietetics professionals and leaders in clinical care and health promotion in the country. The faculty and students of these programs conduct research on food development, school health, and nutrition status. \n\n" +

                        "PROGRAMS OFFERED:\n\n\n" +

                        "   Bachelor of Science in Nursing\n\n" +
                        "   Bachelor of Science in Nutrition and Dietetics\n\n" +
                        "   Bachelor of Science in Public Health (Disaster Response)\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/nurse.jpg",
                "https://batstate-u.edu.ph/programs/nursing-nutrition-and-dietetics/"

            )
        )


        dataList.add(
            DataItem(
                "INDUSTRIAL TECHNOLOGY\n\n",

                "Industrial Technology programs are the oldest programs offered in the university, with the institution initially established as a manual training school for men in 1903. Ever since, the university’s graduates on industrial technology have proven to be well-rounded and globally competitive professionals who meet local and international demands for skilled workers and industry leaders. \n\n" +

                        "PROGRAMS OFFERED:\n\n\n" +

                        "Doctor of Technology\n\n" +
                        "Master of Technology\n\n" +
                        "BACHELOR OF INDUSTRIAL TECHNOLOGY: \n\n" +
                        "Major in Automotive Technology\n\n" +
                        "Major in Civil Technology\n\n" +
                        "Major in Computer Technology\n\n" +
                        "Major in Drafting Technology\n\n" +
                        "Major in Electrical Technology\n\n" +
                        "Major in Electronics Technology\n\n" +
                        "Major in Food Technology\n\n" +
                        "Major in Instrumentation and Control Technology\n\n" +
                        "Major in Mechanical Technology\n\n" +
                        "Major in Mechatronics Technology\n\n" +
                        "Major in Welding and Fabrication Technology\n\n\n" ,


                "https://www.ttiasia.com/content/ttiasia/en/resources/marketeye/categories/new-technology/me-apte-20210312/_jcr_content/centerParsys/image_copy.coreimg.jpeg/1615569685963/tti-marketeye-apte-iiot-digital-transformation-800x500.jpeg",
                "https://batstate-u.edu.ph/programs/industrial-technology/"

            )
        )

        dataList.add(
            DataItem(
                "LAW\n\n",

                "The Bachelor of Laws program is under the College of Law, which is steadfast in its vision of academic excellence and is committed in the maintenance of academic standards, with its faculty members consisting of trial judges and seasoned practitioners and law scholars. The college has already produced competent and upright law practitioners who are making their distinct make in the local and national scene.\n\n" +

                        "PHILOSOPHY OR RATIONALE OF THE PROGRAM\n\n\n" +
                        "The College of Law is a young department established in 2005. Guided by its vision of academic excellence, it caters to the aspirations of professionals mostly from Region IV to become part of the legal profession.  To achieve its aim of developing competent and morally upright lawyers, the College is composed of faculty members who are trial judges, seasoned practitioners and scholars who possess the work ethic of a dedicated law professor.  It is steadfast in its resolve to contribute to the achievement of the Batangas State University’s vision and mission of producing leaders for the 21st century.\n\n" ,

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/law.jpg",
                "https://batstate-u.edu.ph/programs/law/"

            )
        )

        dataList.add(
            DataItem(
                "AGRICULTURE AND FORESTRY\n\n",

                "BatStateU is the only university in the province, and one of the very few in the region, that offers agriculture and forestry programs. The faculty and students of these programs produce high impact studies on agro-ecosystems, natural resources conservation, sustainable agricultural farming systems, ecosystem interconnectivities, and sustainable natural resources management. \n\n" +

                        "PROGRAMS OFFERED:\n\n\n" +

                        "Bachelor of Science in Agriculture\n\n" +
                        "Bachelor of Science in Forestry\n\n" ,

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/lobo-agriculture.jpg",
                "https://batstate-u.edu.ph/programs/agriculture-and-forestry/"

            )
        )


        dataList.add(
            DataItem(
                "INFORMATICS AND COMPUTING SCIENCES\n\n",

                "The university has an Integrated School (IS) in its Main Campus and a Laboratory School in its Nasugbu campus, offering pre-elementary, elementary, junior high school, and senior high school (STEM Track for the IS and STEM and ABM strands for the Laboratory School). Basic education in the university follows the K-12 basic education curriculum framework, and puts premium to science, mathematics, and technology courses. A wide array of co- and extra-curricular activities are provided to maximize the students’ potentials for holistic development.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/11/Basic-Education-1-edited.jpg",
                "https://batstate-u.edu.ph/programs/basic-education/"

            )
        )

        dataList.add(
            DataItem(
                "TEACHER EDUCATION\n\n",

                "The university’s Teacher Education program is designated by the Commission on Higher Education as a national Center of Development. The university remains to be one of the largest producers of licensed professional teachers and educational leaders and supervisors in the region. The teacher education program offerings focus on teaching pedagogies, curriculum development, assessment of learning, instructional materials development, 21st century education, virtual learning, and other emerging trends in different fields of specialization. \n\n" +

                        "PROGRAMS OFFERED:\n\n\n" +

                        "Doctor of Education in Educational Management\n\n" +
                        "Doctor of Philosophy in Educational Management\n\n" +
                        "Doctor of Philosophy in Mathematics Education \n\n" +
                        "MASTER OF ARTS IN EDUCATION:\n\n" +
                        "* Major in Educational Management (Thesis/ Non-Thesis Program)\n\n" +
                        "* Major in Mathematics Teaching\n\n" +
                        "* Major in Science Teaching\n\n" +
                        "* Major in English Language Teaching\n\n" +
                        "* Major in Filipino Language Teaching\n\n" +
                        "* Major in Physical Education\n\n" +
                        "* Major in Psychology\n\n" +
                        "* Major in Social Studies Teaching\n\n" +
                        "* Major in Technology and Livelihood Education Teaching\n\n" +
                        "Bachelor of Elementary Education\n\n" +
                        "Bachelor of Early Childhood Education\\nn" +
                        "BACHELOR OF SECONDARY EDUCATION:\n\n" +
                        "* Major in Science\n\n" +
                        "* Major in English\n\n" +
                        "* Major in Filipino\n\n" +
                        "* Major in Mathematics\n\n" +
                        "* Major in Social Studies\n\n" +
                        "BACHELOR OF TECHNOLOGY & LIVELIHOOD EDUCATION:\n\n" +
                        "* Major in Home Economics\n\n" +
                        "BACHELOR OF TECHNICAL-VOCATIONAL TEACHER EDUCATION:\n\n" +
                        "* Major in Garments, Fashion and Design\n\n" +
                        "* Major in Electronics Technology\n\n" +
                        "Bachelor of Physical Education\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/teacher.jpg",
                "https://batstate-u.edu.ph/programs/teacher-education/"

            )
        )


        dataList.add(
            DataItem(
                "COLLEGE OF MEDICINE\n\n",

                "HISTORY\n" +
                        "The Batangas State University College of Medicine began its operation in August of academic year 2021-2022. The plan for its establishment was finalized and approved by the Batangas State University Board of Regents in December 2020. The program reflects the University’s commitment to achieve the Sustainable Development Goals of ensuring healthy lives for all at all ages. The principal aim is to develop holistic and technology-oriented medical graduates. It is envisioned that graduates will be able to pursue various medical career options in order to become leader physicians and managers who can improve healthcare and advance biomedical research in the clinical and community healthcare delivery system at local, national, and global levels. The Batangas State University College of Medicine aspires to mold students to be change agents in implementing community-oriented medicine for diverse populations with various conditions that plague the province of Batangas and the nation using innovative technological solutions.\n" +
                        "\n" +
                        "The program is also a response to Republic Act 11509 “Doktor Para sa Bayan Act”; An Act Establishing Medical Scholarship and Return Service Program for Deserving Medical Students.” By providing training steeped with multiple opportunities for immersion in the community, the program aims to produce physicians responsive to the current and emerging needs of the community especially the poor and marginalized and help make quality medical care accessible and affordable for all.\n" +
                        "\n" +
                        "The curriculum developed for implementation by August 2021 adapts a traditional framework of four years and includes community health related courses, medical informatics, interprofessional education, basic biomedical engineering concepts, research related subjects in addition to the basic and clinical sciences prescribed by the Commission on Higher Education with learning objectives aligned with the CHED ten-program outcomes and the university’s sustainable development goals and institutional graduate attributes.\n" +
                        "\n" +
                        "All courses employ varied teaching-learning large and small group strategies as well as traditional and non-traditional assessment methods. As the school opened amid the challenges of the pandemic, the first year of implementation utilized the online synchronous and asynchronous mode of delivery. This gradually transitioned to blended delivery with calibrated and planned scheduling of face-to-face sessions.\n" +
                        "\n" +
                        "Since news of its opening, the College of Medicine has received several applicants to its program from the various municipalities of the province and even from other parts of the country. To date, the pioneer batch has 24 students enrolled in the sophomore year and 31 students in the freshman year.\n" +
                        "\n" +
                        "At present, the COM utilizes the University Wellness Center and Higher Education Building at the Pablo Borbon campus. It will soon transfer to the new College of Medicine Building also located within the campus.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "VISION\n" +
                        "Batangas State University College of Medicine envisions to transform lives through its innovative & socially-accountable healthcare service delivery in the community.\n" +
                        "\n" +
                        "MISSION\n" +
                        "To provide affordable medical education to students who will contribute in accelerating progress towards Universal Health Care and sustainable development goals.\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2023/02/com-programs-scaled.jpg",
                "https://batstate-u.edu.ph/programs/college-of-medicine/"

            )
        )



        dataList.add(
            DataItem(
                "ETEEAP\n\n",

                "The ETEEAP is an alternative education that promotes access to continuing quality higher education. It is an effective system of academic equivalency and accreditation of prior learning from relevant work  experiences and formal/non-formal educational training.\n\n" +

                        "PROGRAMS OFFERED:\n\n\n" +

                        "Bachelor of Science in Mechanical Engineering\n" +
                        "Bachelor of Science in Electronics Engineering\n" +
                        "Bachelor of Science in Sanitary Engineering\n" +
                        "Bachelor of Science in Industrial Engineering\n" +
                        "Bachelor of Science in Computer Engineering\n" +
                        "Bachelor of Science in Civil Engineering\n" +
                        "Bachelor of Science in Chemical Engineering\n" +
                        "Bachelor of Science in Electrical Engineering\n" +
                        "Bachelor of Science in Business Administration\n" +
                        "* Major in Human Resource Management\n" +
                        "* Major in Financial Management\n" +
                        "* Major in Business Economics\n" +
                        "* Major in Marketing Management\n" +
                        "Bachelor of Science in Accountancy\n" +
                        "Bachelor of Science in Computer Science\n" +
                        "Bachelor of Science in Information Technology\n" +
                        "Bachelor of Industrial Technology\n" +
                        "* Major in Welding and Fabrication Technology\n" +
                        "* Major in Mechatronics Technology\n" +
                        "* Major in Mechanical Technology\n" +
                        "* Major in Instrumentation and Control Technology\n" +
                        "* Major in Food Technology\n" +
                        "* Major in Electronics Technology\n" +
                        "* Major in Electrical Technology\n" +
                        "* Major in Drafting Technology\n" +
                        "* Major in Computer Technology\n" +
                        "* Major in Civil Technology\n" +
                        "* Major in Automotive Technology\n\n\n" ,

                "https://batstate-u.edu.ph/wp-content/uploads/2023/01/ETEEAP-pic-1.jpeg",
                "https://batstate-u.edu.ph/programs/eteeap/",

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
    override fun onBackPressed() {
        super.onBackPressed()
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)}
}