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

class UnderstandingCivicRightsInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_understanding_civic_rights_info)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "THE BASICS OF CIVIC RIGHTS",
                "Dive into the essence of Philippine civic rights, where fundamental freedoms flourish, and justice prevails. Discover the rights that define Filipino citizenship.\"\"\n\n" +
                        "1. PROTECTION OF INDIVIDUAL LIBERTIES: The Bill of Rights safeguards the fundamental rights and freedoms of every Filipino citizen, ensuring their individual autonomy and protection.\n\n" +
                        "2. RULE OF LAW: it upholds the principle of 'due process of law,' which means that no one can be deprived of life, liberty, or property without fair and legal procedures.\n\n" +
                        "3. FREEDOM OF SPEECH AND PRESS: These rights allow citizens to voice their opinions and ideas without fear of censorship, contributing to a vibrant and informed society.\n\n" +
                        "4. PRIVACY AND SECURITY: The Bill of Rights protects citizens from unwarranted intrusion into their personal lives and property.\n\n" +
                        "5. RELIGIOUS FREEDOM: It ensures that citizens have the right to practice their religion without discrimination or preference.\n\n" +
                        "6. RIGHT TO LEGAL COUNSEL: The right to have an attorney is fundamental to a fair legal process.\n\n" +
                        "7. RIGHT TO BAIL: It ensures that individuals charged with a crime can be released under certain conditions before their trial.\n\n" +
                        "8. PRESUMPTION OF INNOCENCE: This principle safeguards the rights of the accused, ensuring they are considered innocent until proven guilty.\n\n" +
                        "9. HABEAS CORPUS: This right prevents unlawful detention and protects against arbitrary imprisonment.\n\n" +
                        "10. LIMITATIONS ON GOVERNMENT POWER: The Bill of Rights acts as a check on government authority, preventing the abuse of power and protecting the rights of the people.\n\n",

                "https://asiapacific.unwomen.org/sites/default/files/Field%20Office%20ESEAsia/Images/2019/01/ph-IMG_0323-960px.jpg",
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-iii/#:~:text=No%20person%20shall%20be%20deprived,equal%20protection%20of%20the%20laws."

            )
        )
        dataList.add(
            DataItem("HISTORICAL EVOLUTION OF CIVIC RIGHTS",
                "\"Discover the Philippines' rich history of civic rights and political activism, shaped by iconic protests and courageous figures. Join us on a journey through key milestones in the nation's path toward democracy.\n\n" +
                        "1. HISTORICAL PERSPECTIVE: Gain a deeper understanding of the historical context and evolution of civic rights and political activism in the Philippines, providing essential insights into the nation's democratic journey.\n" +
                        "2. CIVIC ENGAGEMENT: Be inspired to engage actively in civic and political issues, encouraging you to be an informed and responsible citizen.\n" +
                        "3. SOCIAL AWARENESS: Learn about the struggles and achievements of historical figures in the Philippines' political protests, fostering social awareness and empathy.\n" +
                        "4. DEMOCRATIC VALUES: Appreciate the core values of democracy, including freedom, justice, and equality, through the study of the Philippines' history of civic rights.\n" +
                        "5. INSPIRATIONAL FIGURES: Historical figures like Corazon C. Aquino and Benigno S. Aquino Jr. serve as role models for your aspirations and activism.\n" +
                        "6. HISTORICAL MILESTONES: Gain insight into significant events like the People Power Revolution and the First Quarter Storm, contributing to your knowledge of key historical milestones.\n" +
                        "7. POLITICAL SCIENCE EDUCATION: Apply academic knowledge to real-world situations, aligning with the field of political science.\n" +
                        "8. CIVIC RESPONSIBILITY: Understand the importance of civic rights and the role of political activism, encouraging you to take your civic responsibilities seriously.\n" +
                        "9. CRITICAL THINKING: Sharpen your critical thinking skills by analyzing the context and impact of historical protests and assessing the consequences of political actions.\n" +
                        "10. GLOBAL CITIZENSHIP: Contribute to your development as a responsible global citizen by gaining insights into the challenges and triumphs of democracy in the Philippines, which can be relevant to similar movements worldwide.",

                "https://upload.wikimedia.org/wikipedia/commons/7/71/PH3c-070416.jpg",
                "https://www.officialgazette.gov.ph/edsa/the-ph-protest/"
     )
        )
        dataList.add(
            DataItem("INTERNATIONAL COMPARISON OF CIVIC RIGHTS:",
                "In a world shaped by diverse perspectives and priorities, the international landscape of civic rights unfolds as a tapestry of contrasts. As nations engage in peer-to-peer evaluations, the divergent lenses through which they view human rights intricately weave a unique narrative of global citizenship.\n\n" +
                        "1. GLOBAL AWARENESS: Understanding the international landscape of civic rights fosters global awareness, encouraging students to become informed, responsible global citizens.\n\n" +
                        "2. CULTURAL SENSITIVITY: It promotes cultural sensitivity and appreciation, enabling students to recognize the importance of respecting diverse perspectives and values.\n\n" +
                        "3. LEGAL AND POLITICAL INSIGHT: Studying civic rights offers valuable insights into the legal and political structures of different countries, providing students with a broader perspective on governance.\n\n" +
                        "4. HUMAN RIGHTS ADVOCACY: It equips students with knowledge to become advocates for human rights, empowering them to address social injustices on an international scale.\n\n" +
                        "5. CRITICAL THINKING: Exploring variations in civic rights encourages critical thinking as students evaluate the societal and historical factors influencing these differences.\n\n" +
                        "6. DIPLOMACY AND NEGOTIATION: It highlights the role of diplomacy and negotiation in international relations, offering lessons on conflict resolution and cooperation.\n\n" +
                        "7. CAREER OPPORTUNITIES: Understanding global civic rights is essential for students considering careers in international law, diplomacy, human rights organizations, and global politics.\n\n" +
                        "8. CIVIC ENGAGEMENT: It encourages students to participate actively in civic life, emphasizing the significance of voting, community involvement, and advocacy.\n\n" +
                        "9. EMPATHY AND TOLERANCE: This study fosters empathy and tolerance by shedding light on the struggles faced by individuals in different parts of the world.\n\n" +
                        "10. PREPARATION FOR AN INTERCONNECTED WORLD: In our interconnected world, knowing how civic rights vary across countries is crucial for adapting to an ever-evolving global landscape.\n\n",

                "https://ishr.ch/wp-content/uploads/2021/06/philippines-1394508copy_0.jpg",
                "https://www.pewresearch.org/short-reads/2019/03/20/countries-have-different-priorities-when-they-review-each-others-human-rights-records/"
)
        )

        dataList.add(
            DataItem("KEY FIGURES IN CIVIC RIGHTS HISTORY:",
                "\"\n" +
                        "In 1986, a sea of brave Filipinos took to the streets in the historic People Power Revolution, toppling a decades-long dictatorship. This extraordinary uprising, led by figures like Corazon Aquino and Cardinal Jaime Sin, stands as an iconic chapter in civic rights history, a testament to the indomitable spirit of the people in their fight for democracy and justice.\"\n\n\n" +
                        "1. INSPIRATION FOR CIVIC ENGAGEMENT: The People Power Revolution serves as a powerful example of how ordinary citizens can come together to bring about meaningful change and defend their civic rights.\n\n" +
                        "2. DEMOCRACY IN ACTION: It showcases the effectiveness of nonviolent resistance in reclaiming democracy, making it a valuable case study for students interested in the dynamics of democracy and governance.\n\n" +
                        "3. LEADERSHIP AND ACTIVISM: Corazon Aquino's leadership and the role of key figures like Cardinal Jaime Sin highlight the influence of individuals in leading civic movements.\n\n" +
                        "4. GLOBAL IMPACT: The revolution's resonance beyond the Philippines illustrates how civic rights movements can have international implications and inspire others worldwide.\n\n" +
                        "5. HISTORICAL CONTEXT: It offers students a deeper understanding of the historical background of the Philippines and the consequences of authoritarian rule.\n\n" +
                        "6. THE ROLE OF MEDIA: Radio Veritas' role in facilitating communication during the revolution emphasizes the media's significance in mobilizing civic movements.\n\n" +
                        "7. LESSONS FROM PEACEFUL PROTESTS: The revolution demonstrates that peaceful protests and civil resistance can be effective tools for enacting change without resorting to violence.\n\n" +
                        "8. CHALLENGES OF DEMOCRACY: The post-revolution challenges, such as coup attempts and political divisions, shed light on the complexities of establishing and maintaining democracy.\n\n" +
                        "9. MEMORY AND LEGACY: It highlights the importance of historical memory and the need to critically examine the legacy of civic rights movements.\n\n" +
                        "10. CONTEMPORARY RELEVANCE: Given the resurgence of authoritarianism in some regions, studying this revolution provides valuable insights into contemporary struggles for civic rights and democracy.\n",

                "https://manilatoday.net/wp-content/uploads/2016/11/untitled-91-1024x687.jpg",
                "https://origins.osu.edu/milestones/people-power-revolution-philippines-1986?language_content_entity=en"
        )
        )

        dataList.add(
            DataItem("THE PRACTICAL APPLICATION OF CIVIC RIGHTS IN DAILY LIFE:",
                "In a world where democracy's vitality depends on informed and engaged citizens, the journey begins with education. Dive into a transformative exploration of civic rights, as we bridge the gap between the classroom and active community participation.\"\n\n\n" +
                        "1. EMPOWERING INFORMED CITIZENSHIP: This study equips students with the knowledge and skills essential for active participation in democratic processes, fostering a new generation of informed citizens.\n\n" +
                        "2. STRENGTHENING CIVIC ENGAGEMENT: By emphasizing the practical application of civic rights, students are better prepared to engage in community initiatives and civic activities that drive positive change.\n\n" +
                        "3. DEFENDING HUMAN DIGNITY: The study reinforces the significance of individual rights and responsibilities, instilling a deep respect for human dignity and equality in the minds of students.\n\n" +
                        "4. FOSTERING CRITICAL THINKERS: Through an exploration of political processes and governmental systems, students develop the critical thinking skills necessary to navigate complex issues and make informed decisions.\n\n" +
                        "5. ENCOURAGING CIVIC LEADERSHIP: This study promotes leadership qualities among students, inspiring them to assume active roles in their communities and become agents of positive transformation.\n\n" +
                        "6. ENHANCING ETHICAL AWARENESS: Students gain a heightened sense of moral responsibility, recognizing the impact of their actions on society, and the importance of ethical decision-making.\n\n" +
                        "7. PROMOTING GLOBAL CITIZENSHIP: Understanding the role of the United States in international affairs cultivates global awareness and the capacity to contribute to a more interconnected world.\n\n" +
                        "8. BALANCING RIGHTS AND RESPONSIBILITIES: Students learn to strike a balance between individual rights and collective well-being, fostering a sense of social responsibility in a democratic society.\n\n" +
                        "9. SAFEGUARDING CONSTITUTIONAL PRINCIPLES: The study reinforces the importance of adhering to constitutional values, ensuring the endurance of democratic institutions, and the rule of law.\n\n" +
                        "10. EMPOWERING CHANGE-MAKERS: Equipped with the knowledge and values, students emerge as active contributors to their communities, driving meaningful change, and preserving the essence of democracy in their daily lives.",

                "https://freedomhouse.org/sites/default/files/styles/768x400_fp_scale_crop_/public/2019-10/Philippines_fotn2019_country-hero.jpg?h=deee9842&itok=_xSX6eR6",
                "https://civiced.org/papers/articles_role.html"
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