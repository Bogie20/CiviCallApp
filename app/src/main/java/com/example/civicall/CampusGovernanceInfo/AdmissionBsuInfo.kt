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

class AdmissionBsuInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admission_bsu_info)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "COLLEGE APPLICANTS",
                "DOCUMENTARY REQUIREMENTS:\n\n" +


                        "• Applicants must have completed high school in a recognized school, or must be enrolled in Senior High School, if not yet completed.\n" +
                        "• Applicants must submit the following:\n\n" +

                        "1. E -copy of Filled–out Application Form\n\n" +
                        "2. E-copy of one (1) recent 2”x2” ID picture with white or plain background\n\n" +
                        "3. Certified e- copy of final grades in Grades 10, and 11 in Math, English and Science\n\n" +



                        "• Grades Form 1 (for Regular Admission) / Grades Form 2 (for ALS)\n\n" +
                        "• Junior High School and Senior High School Form 137\n\n" +
                        "• Certification of completion of SHS and respective strand or enrolment therein, if not completed\n\n" +
                        "• The original hard copy of requirements will be submitted upon request of the Testing and Admission Office, the University Registrar, and/or College.\n\n\n" +


                        "Additional Program-Specific Requirements for Admission\n\n" +

                        "In addition to the general requirements, applicants must satisfy program specific requirements, as follows:\n\n" +

                        "• ENGINEERING PROGRAMS, BS CHEMISTRY, BS COMPUTER SCIENCE, BS BIOLOGY, AND BS MATHEMATICS\n\n\n" +

                        "1. Completion of STEM/ Pre Baccalaureate Maritime strand program in Senior High School, or enrolment in the same program, if not yet completed.\n\n" +
                        "2. Submission of certified copies of final grades from Grade 10 and Grade 11, with marks of at least 80% in Mathematics, Science and English subjects.\n\n\n" +


                        "BS ARCHITECTURE AND BS INTERIOR DESIGN\n\n\n" +

                        "1. Completion of STEM / Pre Baccalaureate Maritime strand / Arts and Design track program in Senior High School, or enrolment in the same program, if not yet completed.\n\n" +
                        "2. Submission of certified copies of final grades from Grade 10 and Grade 11, with marks of at least 80% in Mathematics, Science and English subjects.\n\n\n" +


                        "EDUCATION PROGRAMS AND BS CRIMINOLOGY\n\n" +
                        "1. Completion of any track or strand in any Education and Criminology programs, except BSED Math and BSED Science which require STEM strand/ Pre Baccalaureate Maritimein senior high school or enrolment in the same program, if not yet completed.\n\n" +
                        "2. Submission of certified copies of final grades from Grade 10 and Grade 11, with marks of at least 80% in Mathematics, Science and English subjects.\n\n\n" +


                        "BS ACCOUNTANCY\n\n\n" +
                        "1. Completion of ABM strand program in Senior High School, or enrolment in the same program, if not yet completed.\n\n" +
                        "2. Submission of certified copies of final grades from Grade 10 and Grade 11, with marks of at least 80% in Mathematics, Science and English subjects.\n\n\n" +


                        "BS CUSTOMS ADMINISTRATION\n\n\n" +
                        "1. Completion of ABM/GAS strand program in Senior High School, or enrolment in the same program, if not yet completed.\n\n" +
                        "2. Submission of certified copies of final grades from Grade 10 and Grade 11, with marks of at least 80% in Mathematics, Science and English subjects.\n\n\n" +


                        "BS PSYCHOLOGY\n\n\n" +

                        "1. Completion of STEM/ Pre Baccalaureate Maritime /HUMSS/GAS strand program in Senior High School, or enrolment in the same program, if not yet completed.\n\n" +
                        "2. Submission of certified copies of final grades from Grade 10 and Grade 11, with marks of at least 80% in Mathematics, Science and English subjects.\n\n\n" +

                        "BS NURSING AND BS NUTRITION AND DIETETICS\n\n\n" +

                        "1. Completion of STEM/ Pre Baccalaureate Maritime / GAS strand program in Senior High School, or enrolment in the same program, if not yet completed.\n\n" +
                        "2. Submission of certified copies of final grades from Grade 10 and Grade 11, with marks of at least 80% in Mathematics, Science and English subjects.\n\n\n" +

                        "PASSED RATING ON SCREENING/INTERVIEW BY THE COLLEGE.\n\n\n" +


                        "BS TOURISM MANAGEMENT\n\n\n" +

                        "1. Completion of ABM strand/TVL track Major in Home Economics program in Senior High School, or enrolment in the same program, if not yet completed.\n\n" +
                        "2. Passed rating on screening/interview to be conducted by the College.\n\n\n" +


                        "BS AGRICULTURE, BS FORESTRY, BS FISHERIES AND AQUATIC SCIENCES\n\n\n" +


                        "1. Completion of any track or strand in senior high school or enrolment in the same program, if not yet completed.\n\n" +
                        "2. Bachelor of Fine Arts and Design Major in Visual Communication\n\n\n" +


                        "COMPLETION OF STEM / PRE BACCALAUREATE MARITIME STRAND/ARTS AND DESIGN TRACK IN SENIOR HIGH SCHOOL, OR ENROLMENT IN THE SAME PROGRAM, IF NOT YET COMPLETED.\n\n\n" +
                        "BS INFORMATION TECHNOLOGY\n\n\n" +

                        "1. Completion of STEM / Pre Baccalaureate Maritime strand / TVL track Major in Information and Communication Technology strand program in Senior High School, or enrolment in the same program, if not yet completed.\n\n\n" +

                        "TECHNOLOGY PROGRAMS\n\n\n" +

                        "1. Completion of STEM/ Pre Baccalaureate Maritime /GAS strand/TVL track in Senior High School, or enrolment in the same program, if not yet completed.\n\n\n" +



                        "BS Business Administration, Entrepreneurship and Management Accounting\n\n\n" +
                        "1. Completion of ABM strand program in Senior High School, or enrolment in the same program, if not yet completed.\n\n\n" +

                        "BS PUBLIC ADMINISTRATION\n\n\n" +

                        "1. Completion of ABM/ HUMSS strand program in Senior High School, or enrolment in the same program, if not yet completed.\n" +

                        "BS HOSPITALITY MANAGEMENT\n\n\n" +

                        "1. Completion of ABM strand/TVL track Major in Home Economics program in Senior High School, or enrolment in the same program, if not yet completed.\n\n\n" +

                        "BA COMMUNICATION AND BA ENGLISH LANGUAGE STUDIES\n\n\n" +

                        "1. Completion of gas/humss strand in senior high school, or enrolment in the same program, if not yet completed.\n" +

                        "BS DEVELOPMENT COMMUNICATION\n\n\n" +
                        "1. Completion of GAS/HUMSS/ABM strand in Senior High School, or enrolment in the same program, if not yet completed.\n" +

                        "FOREIGN STUDENTS\n\n\n" +

                        "1. Online interview with the Director for External Affairs, to be scheduled accordingly, with the interview guide and rubric\n" +
                        "2. Academic Essay, to be assessed by the Dean and Program Chairperson of the College concerned, using a rubric\n" +

                        "REQUIREMENTS FOR ADMISSION UNDER AFFIRMATIVE ACTION PROGRAM\n\n" +
                        "Applicants under AAP must submit the requirements, as follow:\n\n" +

                        "INDIGENT STUDENTS\n\n" +
                        "• Certification of indigency from their respective barangay of parent or guardian, if available\n\n" +
                        "• Certificate of Tax Exemption from BIR\n\n\n" +

                        "ALS GRADUATES\n\n" +

                        "•  Certification of completion of ALS program, or enrolment therein, if not completed\n\n\n" +
                        "INDIGENOUS PEOPLE\n\n" +

                        "Certificate of Tribe Membership, or any equivalent certification as belonging to indigenous people/indigenous cultural community\n\n\n" +

                        "• PWD\n\n" +

                        "pwd identification card\n\n\n" +

                        "• ISKOLAR NG BAYAN\n\n" +

                        "Certification from the public high school, duly signed by the school principal, of the rank of the applicant in the Top Ten of the graduating (Grade 12) class.\n\n\n" +

                        "BATSTATEUCAT APPLICATION PROCEDURE\n" +


                        "•  A. Fill out the BatStateU College Application form at the  (https://dione.batstateu.edu.ph/tao/#/application).\n\n" +
                        "•  B. Upload the scanned copy of Certification of Grades of applicant for the following subjects for each grade level.\n\n" +
                        "i. Grade 10 - Mathematics, Science, English\n\n" +
                        "ii. Grade 11, 1st semester (non-STEM) – General Mathematics, Earth Science and Oral Communication\n\n" +
                        "iii. Grade 11, 2nd semester (non-STEM) - Statistics and Probability, Physical Science and Reading & Writing\n\n" +
                        "iv. Grade 11, 1st semester (STEM) – Pre-Calculus, Earth Science, Oral Communication\n\n" +
                        "v. Grade 11, 2nd semester (STEM) – Basic Calculus, General Chemistry I, and Reading & Writing\n\n" +
                        "vi. In case of unavailability of the aforementioned priority subjects, the following alternative subjects may be considered:\n\n" +


                        "• STEM Strand:\n\n" +

                        "ENGLISH:\n\n" +

                        "1. English for Academic Purposes\n\n" +

                        "MATHEMATICS:\n\n" +

                        "1. General Mathematics\n\n" +
                        "2. Statistics and Probability\n\n" +
                        "SCIENCE:\n\n" +

                        "1. General Chemistry II\n\n" +
                        "2. General Physics I\n\n" +
                        "3. General Biology I\n\n" +
                        "4. Disaster Readiness & Risk Reduction\n\n" +


                        "NON-STEM STRAND:\n\n" +

                        "English:\n\n" +

                        "1. English for Academic Purposes\n\n" +
                        "MATHEMATICS:\n\n" +

                        "1. Business Mathematics (for ABM strand)\n\n" +

                        "SCIENCE:\n\n" +

                        "1. Disaster Readiness & Risk Reduction\n\n\n" +


                        "The Certification must be signed and certified correct by the Principal/ School Registrar, or equivalent school officer.\n\n\n" +

                        "C. Wait for the confirmation from Testing and Admission Office (TAO); visit frequently the application tracker: (https://dione.batstate-u.edu.ph/tao/#/application).\n\n" +
                        "D. Once the application is approved, Examination Permit will be issued.\n\n" +
                        "E. Take the BATSTATEUCAT.\n\n" +
                        "F. Wait for the release of the BatStateU College Admission test result; scheduled date of release shall be given by TAO.\n\n" +
                        "G. For qualifiers, a Notice of Admission will be posted in the BatStateUCAT link: https://dione.batstate-u.edu.ph/tao/#/batstateucat/.\n\n" +
                        "H. Wait for the enrollment schedule.\n\n",









                R.drawable.img_392,
                "https://batstate-u.edu.ph/about/",
                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/homepage-webslider-1.jpg"
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