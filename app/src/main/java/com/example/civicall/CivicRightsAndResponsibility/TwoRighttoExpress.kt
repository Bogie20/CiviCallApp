package com.example.civicall.CivicRightsAndResponsibility

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
import com.example.civicall.databinding.ActivityTwoRighttoExpressBinding

class TwoRighttoExpress : AppCompatActivity() {
    private lateinit var binding:ActivityTwoRighttoExpressBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityTwoRighttoExpressBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, CivicRightsAndResponsibilityMenu::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "THE PHILIPPINE BILL OF RIGHTS AND FREEDOM OF EXPRESSION",
                "Unveiling the Pillars of Freedom: The Philippine Bill of Rights and Freedom of Expression\" delves into the historical foundations and legal intricacies that shape the cherished freedom of expression in the Philippines. \"\"\n\n" +
                        "1. UNDERSTANDING CONSTITUTIONAL FOUNDATIONS: This study provides students with a deep understanding of the Philippine Bill of Rights, the legal framework that underpins essential freedoms, including freedom of expression.\n\n" +
                        "2. GLOBAL PERSPECTIVE: Students gain insights into how issues related to freedom of expression resonate not just in the Philippines but also on a global scale, offering a broader perspective on human rights.\n\n" +
                        "3. REAL-WORLD RELEVANCE: Studying this topic equips students to comprehend the real-world implications and challenges faced by individuals like Maria Ressa in upholding freedom of expression.\n\n" +
                        "4. DEMOCRACY AND CIVIC ENGAGEMENT: It reinforces the role of freedom of expression as a cornerstone of democracy and active civic participation, inspiring students to engage in democratic processes.\n\n" +
                        "5. JOURNALISTIC INTEGRITY: Students interested in journalism can learn from the experiences of Nobel laureates like Maria Ressa and Dmitry Muratov, understanding the importance of upholding journalistic integrity.\n\n" +
                        "6. LEGAL AND ETHICAL DILEMMAS: This study delves into the legal and ethical dilemmas related to freedom of expression, preparing students to critically analyze and navigate complex issues.\n\n" +
                        "7. CHAMPIONING HUMAN RIGHTS: It encourages students to become advocates for human rights and defenders of freedom of expression, promoting a more just and equitable society.\n\n" +
                        "8. FACING CHALLENGES: As attacks on freedom of expression continue to rise, students learn the importance of resilience, unity, and teamwork in defending fundamental rights.\n\n" +
                        "9. CIVIC RESPONSIBILITY: This study emphasizes the civic responsibility of safeguarding constitutional freedoms, preparing students to be active participants in upholding these rights.\n\n" +
                        "10. INSPIRATION AND EMPOWERMENT: Maria Ressa's journey and achievements serve as an inspiration to students, empowering them to make informed decisions, speak their minds, and defend freedom of expression in their own lives and society.\n\n",

                "https://i.ytimg.com/vi/1MtYlPtOFCE/maxresdefault.jpg",
                "https://www.rappler.com/world/global-affairs/nobel-peace-prize-maria-ressa-message-youth-freedom-expression/"

            )
        )
        dataList.add(
            DataItem("LIMITATIONS ON FREEDOM OF SPEECH",
                "\"Unveiling Speech Limits: Navigating Freedom's Borders.\" Delve into the complexities of freedom of speech, where power and responsibility intersect.\n\n" +
                        "1. BALANCING POWER: This study helps students understand the delicate balance between the power of free speech and the responsibility that comes with it.\n" +
                        "2. ACCOUNTABILITY IN GOVERNMENT: Students learn how freedom of speech limits a government's ability to manipulate information, promoting accountability and transparency.\n" +
                        "3. DEMOCRACY'S SAFEGUARD: Freedom of speech is a fundamental safeguard of democracy, and students explore how it serves as a check on government actions.\n" +
                        "4. MEDIA LITERACY: Studying limitations on freedom of speech promotes media literacy, enabling students to discern between credible information and false news.\n" +
                        "5. ONLINE DISCOURSE: In the age of social media, students gain insights into the challenges of regulating online discourse while respecting free speech.\n" +
                        "6. CRITICALLY ANALYZING INFORMATION: It equips students with the critical thinking skills needed to evaluate the accuracy of information and question false narratives.\n" +
                        "7. CIVIC ENGAGEMENT: Students are encouraged to actively engage in political discourse and participate in defending democratic principles.\n" +
                        "8. UNDERSTANDING VIRTÙ: The concept of virtù becomes a tool for students to maintain their values and beliefs, even in the face of flattery and manipulation.\n" +
                        "9. LEGAL IMPLICATIONS: Understanding speech limitations provides students with knowledge of the legal implications of spreading false information and hate speech.\n" +
                        "10. FUTURE ADVOCATES: This study inspires students to become advocates for responsible free speech, contributing to a society that values freedom of expression while maintaining ethical boundaries.\n",

                "https://www.rappler.com/tachyon/r3-assets/B7CF108E4EF44264A485AD9F28E9A7DD/img/C4AED0A1B41846A48DC7429472FB7ACF/media-democracy-forum-nov282017-082.jpg?resize=1620%2C1080&zoom=1",
                "https://www.rappler.com/moveph/189805-freedom-speech-limits-government-power-lie/"
             )
        )
        dataList.add(
            DataItem("BALANCING FREE SPEECH WITH SOCIAL RESPONSIBILITY",
                "Striking the Right Balance: Navigating Freedom of Speech and Social Responsibility. Explore the delicate equilibrium between the cherished freedom of speech and the imperative to protect individual privacy in the digital age.\"\n\n" +
                        "1. UNDERSTANDING THE DIGITAL LANDSCAPE: This study equips students with a profound understanding of how freedom of speech and data privacy intersect in the digital era, a crucial aspect of modern life.\n" +
                        "2. LEGAL AWARENESS: Students gain insights into the legal framework surrounding freedom of speech and data privacy, preparing them to navigate these complexities as informed citizens.\n" +
                        "3. ETHICAL JOURNALISM: The study highlights the ethical responsibilities of media professionals when handling sensitive information, promoting responsible journalism and media ethics.\n" +
                        "4. PRIVACY RIGHTS: Students learn about the importance of individual privacy rights in a digital world, fostering respect for personal boundaries and ethical conduct.\n" +
                        "5. TRANSPARENCY IN MEDIA: Understanding the principles of transparency and proportionality in journalism promotes responsible reporting and a more informed public.\n" +
                        "6. GOVERNMENT AND PRIVACY: The study underscores the need for responsible disclosure of personal information, even concerning public officials, ensuring responsible governance and safeguarding individuals' rights.\n" +
                        "7. RESPONSIBLE DATA HANDLING: Students discover the importance of handling data responsibly and transparently, relevant in various fields, from journalism to business.\n" +
                        "8. RIGHT TO ERASURE: Exploring the 'right to be forgotten' concept empowers students to appreciate the significance of personal growth and second chances, both online and offline.\n" +
                        "9. FOI AND DATA PRIVACY: Students learn how freedom of information requests should be balanced with data privacy rights, enhancing their grasp of the evolving legal landscape.\n" +
                        "10. SELF-REGULATION: Encouraging media self-regulation and adherence to standards for responsible journalism fosters a more accountable and ethical media industry.\n",

                "https://www.rappler.com/tachyon/r3-assets/612F469A6EA84F6BAE882D2B94A4B421/img/2DF130FF176D4F058E424DEE7385A798/npc-dpo6-ivy-patdu-media-privacy-20170829.jpg?resize=640%2C360&zoom=1",
                "https://www.rappler.com/nation/180500-npc-reminds-media-balance-freedom-press-right-privacy/"
                )
        )

        dataList.add(
            DataItem("INTERNATIONAL PERSPECTIVES ON FREE SPEECH",
                "Explore the dynamic landscape of free speech from a global standpoint. This module delves into international principles and challenges shaping freedom of expression.\"\n" +

                        "1. GLOBAL AWARENESS: This study fosters a global perspective on free speech, making students aware of its principles and challenges worldwide.\n\n" +

                        "2. FOUNDATIONS OF FREEDOM: Students learn about the fundamental principles underpinning freedom of expression, which are essential for informed citizenship.\n\n" +

                        "3. VARIED FORMS OF EXPRESSION: Understanding that free speech covers verbal and non-verbal communication in various media empowers students to navigate modern communication effectively.\n\n" +

                        "4. BALANCING RIGHTS AND DUTIES: Students learn how free speech, while a fundamental right, comes with responsibilities, offering a balanced view of rights and duties.\n\n" +

                        "5. LEGAL FRAMEWORK: This study equips students with knowledge of the legal framework protecting free speech, crucial in a world governed by laws.\n\n" +

                        "6. ONLINE FREEDOM: In the digital age, students grasp that free speech extends to online platforms, ensuring a broad understanding of its reach.\n\n" +

                        "7. AFRICAN PERSPECTIVES: Students explore how Africa recognizes the importance of freedom of expression in the digital age, aligning with the continent's principles.\n\n" +

                        "8. ACCESS TO INFORMATION: The study emphasizes the significance of access to information and the role of universal internet access in free expression.\n\n" +

                        "9. CONTENT REGULATION: Students learn about the complexities of content removal requests and personal information protection, vital in an online society.\n\n" +

                        "10. CUSTOMARY INTERNATIONAL LAW: This study highlights how the principle of freedom of expression is embedded in international law, emphasizing its importance worldwide.\n",

                "https://cdn-wordpress-info.futurelearn.com/wp-content/uploads/ED03065F-F0FA-41DE-B902-4036A9A94883.jpeg.optimal.jpeg",
                "https://www.mediadefence.org/ereader/publications/introductory-modules-on-digital-rights-and-freedom-of-expression-online/module-1-key-principles-of-international-law-and-freedom-of-expression/the-right-to-freedom-of-expression-under-international-law/"
              )
        )

        dataList.add(
            DataItem("THE ROLE OF MEDIA IN SAFEGUARDING FREE SPEECH",
                "Explore the vital nexus between media and the preservation of free speech. This article delves into the indispensable role of journalism in safeguarding democratic values and human rights.\n\n\n" +
                        "1. DEMOCRACY'S GUARDIAN: This study underscores the media's pivotal role in upholding democratic values, inspiring students to appreciate the significance of a free and responsible press in a functioning democracy.\n\n" +
                        "2. VERIFYING TRUTH: Students learn how the media serves as a watchdog, verifying facts and dispelling misinformation, which nurtures critical thinking and informed citizenship.\n\n" +
                        "3. AMPLIFYING VOICES: Media provides a platform for marginalized voices to be heard. Students grasp how diverse perspectives are essential for a vibrant democracy.\n\n" +
                        "4. DEBATING IDEAS: The study encourages students to engage in open discussions, fostering tolerance and respect for differing viewpoints, vital in a democratic society.\n\n" +
                        "5. EXPOSING INJUSTICES: Journalism exposes wrongdoing and social injustices. Students are empowered to be advocates for positive change in their communities.\n\n" +
                        "6. CHAMPIONING TRANSPARENCY: Media transparency cultivates a culture of accountability. Students recognize the value of transparency in governance and public institutions.\n\n" +
                        "7. BALANCING POWER: Understanding how media holds power accountable, students appreciate the crucial balance between authority and citizen rights.\n\n" +
                        "8. INFORMATION LITERACY: Media literacy is emphasized, helping students critically assess the credibility and bias in news, equipping them to be discerning consumers of information.\n\n" +
                        "9. INSPIRING FUTURE JOURNALISTS: Aspiring journalists gain insight into the ethics and responsibilities of their future profession, preparing them for careers in media.\n\n" +
                        "10. DEFENDING DEMOCRACY: The study inspires students to defend press freedom and free speech as vital cornerstones of a just and democratic society.",

                "https://images.csmonitor.com/csm/2022/07/0725%20PHILIPPINES_PRESS_FREEDOM.1.jpg?alias=standard_900x600",
                "https://mb.com.ph/2023/5/6/safeguarding-the-freedom-of-the-press-is-protecting-the-human-rights-of-all"
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