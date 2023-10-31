package com.example.civicall.CivicRightsAndResponsibility

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class CivicResponsibilityandtheRuleofLawInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civic_responsibilityandthe_ruleof_law_info)





        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "Legal Systems in the Philippines",
                "The legal system in the Philippines is a unique blend of various legal influences, including civil law (Roman), common law (Anglo-American), Islamic law (Muslim), and indigenous law. To provide a more detailed overview of the legal systems in the Philippines, let's break down some key aspects:\n\n" +
                        "HYBRID LEGAL SYSTEM: The Philippines' legal system is best described as a hybrid system that incorporates elements of different legal traditions. This hybridity is a result of historical influences, including Spanish and American colonial rule.\n\n" +
                        "PRIMARY SOURCES OF LAW:\n" +
                        "   - Statutes or Statutory Law: Statutes are written enactments of the legislative branch, including the Constitution, treaties, statutes proper, municipal charters, municipal legislation, court rules, administrative rules and orders, legislative rules, and presidential issuances.\n" +
                        "   - Jurisprudence or Case Law: This includes cases decided by courts and persons performing judicial functions. It encompasses rulings in administrative and legislative tribunals, such as decisions made by the Presidential, Senate, or House Electoral Tribunals.\n\n" +
                        "CLASSIFICATION BY AUTHORITY:\n" +
                        "   - Legislature: The legislative branch promulgates statutes, which can take the form of Acts, Commonwealth Acts, Republic Acts, and Batas Pambansa.\n" +
                        "   - Executive: The executive branch issues presidential issuances, such as Presidential Decrees, Executive Orders, Memorandum Circulars, and Administrative Orders.\n" +
                        "   - Judiciary: The judiciary promulgates judicial doctrines through decisions.\n\n" +
                        "CLASSIFICATION BY SOURCE:\n" +
                        "   - Primary Sources: These sources are published by the issuing agency or the official repository. For example, Republic Acts and other laws or statutes are published in the Official Gazette and the Laws and Resolutions by Congress.\n" +
                        "   - Secondary Sources: These sources are unofficial and are typically commercially published or not published by government agencies.\n\n" +
                        "The Philippines' legal system is not confined to a single legal tradition but rather represents a convergence of legal principles and sources. This unique blend serves as the foundation for the country's legal framework and practice.\n\n" +
                        "To gain a comprehensive understanding of the legal systems in the Philippines, further exploration of specific legal principles, regulations, and their applications in various areas of law is necessary.",
                R.drawable.img_250,
                "https://www.tradechakra.com/economy/philippines/legal-system-in-philippines-235.php",
                "https://www.rappler.com/tachyon/r3-assets/612F469A6EA84F6BAE882D2B94A4B421/img/8CB7336112F64A74BBACBA5F4D38CD83/the-failure-of-the-legal-system-aug-7-2017.jpg"
            )
        )
        dataList.add(
            DataItem("THE JUDICIARY'S ROLE IN PROTECTING CIVIC RIGHTS",
                "\"Ensuring the independence of the judiciary is paramount to safeguarding civic rights. These basic principles lay the foundation for a just and impartial legal system.\n\n" +
                        "1. GUARANTEE OF INDEPENDENCE: The state must ensure and protect the independence of the judiciary, as enshrined in the constitution or national law.\n" +
                        "2. IMPARTIALITY: Judges must make decisions based on facts and the law, free from improper influences, pressures, or interferences.\n" +
                        "3. EXCLUSIVE JURISDICTION: The judiciary has authority over all judicial matters, and its competence is defined by law.\n" +
                        "4. NON-INTERFERENCE: There should be no inappropriate interference in the judicial process, and judicial decisions should generally not be subject to revision.\n" +
                        "5. RIGHT TO FAIR TRIAL: Everyone has the right to be tried in ordinary courts using established legal procedures.\n" +
                        "6. JUDICIAL INDEPENDENCE: Judges must conduct themselves to preserve the dignity and independence of the judiciary.\n" +
                        "7. QUALIFICATIONS AND SELECTION: Judges should be individuals of integrity with proper legal qualifications, and judicial appointments should be free from discrimination.\n" +
                        "8. CONDITIONS OF SERVICE AND TENURE: Judges should have secure tenure, adequate remuneration, and conditions of service, and a mandatory retirement age or term of office should be defined by law.\n" +
                        "9. PROFESSIONAL SECRECY AND IMMUNITY: Judges are bound by professional secrecy and enjoy personal immunity from civil suits for acts in their judicial functions.\n" +
                        "10. DISCIPLINE AND REMOVAL: Charges against judges should be processed fairly and confidentially, and suspension or removal should occur only for specific reasons.\n",
                R.drawable.img_251,
                "https://lawphil.net/international/treaties/bpij.html",
                "https://cdn.factsasia.org/medium_eu_8da0fba43e.png")
        )





        dataList.add(
            DataItem("THE INTERSECTION OF ETHICS AND LAW",
                "Explore the intricate interplay between ethics and law in the Grace Poe case, where questions of citizenship and constitutional interpretation converge, casting a spotlight on fundamental human rights and the broader implications for the Filipino people.\"\n" +
                        "1. CITIZENSHIP AND IDENTITY: The Grace Poe case serves as a real-world example of the ethical and legal complexities of defining one's citizenship and identity, offering students a practical insight into these vital concepts.\n\n" +

                        "2. HUMAN RIGHTS: Understanding the case helps students grasp the profound impact of citizenship on human rights and underscores the ethical responsibility of upholding these rights.\n\n" +

                        "3. CONSTITUTIONAL INTERPRETATION: It provides an opportunity for students to delve into the interpretation of constitutional provisions and the ethical obligations of ensuring justice and fairness in such matters.\n\n" +

                        "4. LEGAL PRESUMPTIONS: Exploring legal presumptions in this case encourages students to think critically about the ethical implications of legal standards and how they affect individuals.\n\n" +

                        "5. BURDEN OF PROOF: The case raises questions about the burden of proof in legal matters, which can lead to discussions about ethical obligations in providing evidence to support one's claims.\n\n" +

                        "6. CITIZENSHIP AND OPPORTUNITY: The study highlights how citizenship status can significantly impact an individual's opportunities and rights, making it a crucial ethical and legal consideration.\n\n" +

                        "7. STATELESSNESS: Examining the possibility of foundlings being classified as stateless citizens prompts discussions on the ethical dimensions of human rights and the legal responsibility of the state.\n\n" +

                        "8. FAIRNESS AND JUSTICE: The case encourages students to consider the ethical principles of fairness and justice in decision-making, particularly when it affects millions of people.\n\n" +

                        "9. POLITICAL IMPLICATIONS: By understanding that the Senate Electoral Tribunal is a political body, students can explore the ethical responsibilities of public officials in making decisions that serve the greater good.\n\n" +

                        "10. GLOBAL PERSPECTIVE: Finally, this case raises questions about the global implications of decisions regarding citizenship and residency, connecting the study to broader discussions on international human rights and ethics.\n",
                R.drawable.img_253,
                "https://www.rappler.com/voices/thought-leaders/112339-law-ethics-politics-grace-poe/",
                "https://2.bp.blogspot.com/-vxvgyVSBKfs/WeR_dlnOJSI/AAAAAAAALTI/7xkU9uNPhyEQl8xZx261wIbdv-JYLPvIgCLcBGAs/s1600/1.jpg")
        )

        dataList.add(
            DataItem("LEGAL ETHICS IN THE PHILIPPINES",
                "Delving into the realm of legal ethics and civic responsibility, this exploration sheds light on the critical role of lawyers in upholding justice in the Philippines. Discover the ethical standards and the broader impact on society in the realm of law.\n\n\n" +
                        "1. UNDERSTANDING LEGAL ETHICS: This study equips students with a deep understanding of the ethical standards that lawyers must adhere to, fostering a sense of professional responsibility.\n\n" +
                        "2. PROMOTING JUSTICE: By exploring the ethical obligations of lawyers, students gain insights into how the legal profession plays a pivotal role in promoting justice and fairness in society.\n\n" +
                        "3. CIVIC RESPONSIBILITY: Students learn that lawyers have a civic duty to ensure access to justice and protect the rights of citizens, aligning legal practice with broader societal needs.\n\n" +
                        "4. UPHOLDING THE RULE OF LAW: The study underscores the significance of lawyers in upholding the rule of law, which is essential for a just and orderly society.\n\n" +
                        "5. ACCOUNTABILITY IN LEGAL PRACTICE: Students grasp the importance of lawyers being held accountable for their actions and decisions, fostering transparency and trust.\n\n" +
                        "6. PROTECTING INDIVIDUAL RIGHTS: Legal ethics ensure that individual rights and liberties are safeguarded, emphasizing the vital role of lawyers in this protection.\n\n" +
                        "7. PREVENTING INJUSTICE: By instilling ethical values, students are prepared to prevent injustices and unethical behavior in the legal field.\n\n" +
                        "8. LEGAL EDUCATION: This study highlights the importance of legal education as it pertains to ethical conduct, thereby contributing to the development of ethical legal professionals.\n\n" +
                        "9. RESPECTING CONSTITUTIONAL RIGHTS: Students discover how lawyers are instrumental in preserving and respecting constitutional rights, which are the bedrock of civic responsibility.\n\n" +
                        "10. IMPROVING SOCIETY: Understanding legal ethics and civic responsibility empowers students to actively contribute to a just and equitable society by engaging with the law ethically and responsibly.",
                R.drawable.img_474,
                "https://kanaans.se/what-is-legal-ethics-philippines/",
                "https://www.peace-ed-campaign.org/wp-content/uploads/2018/05/teach-peace.jpg")
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