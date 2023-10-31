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

class civicRightsConstitutionrepublicInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civic_rights_constitutionrepublic_info)









        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()



        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE I",


                "ARTICLE I\n\n" +

                        "NATIONAL TERRITORY\n\n" +

                        "The national territory comprises the Philippine archipelago, with all the islands and waters embraced therein, and all other territories over which the Philippines has sovereignty or jurisdiction, consisting of its terrestrial, fluvial and aerial domains, including its territorial sea, the seabed, the subsoil, the insular shelves, and other submarine areas. The waters around, between, and connecting the islands of the archipelago, regardless of their breadth and dimensions, form part of the internal waters of the Philippines.\n\n",




                R.drawable.img_260,
                "https://i.ytimg.com/vi/AuHQvtQSbyQ/maxresdefault.jpg",
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-i/")
        )




        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE II",


                "ARTICLE II\n\n" +

                        "DECLARATION OF PRINCIPLES AND STATE POLICIES\n\n" +
                        "The 1987 Constitution of the Republic of the Philippines, specifically Article II, Declaration of Principles and State Policies, lays the foundational principles that guide the governance of the Philippines. These principles encompass the country's commitment to democracy, international relations, social justice, human rights, and sustainable development, reflecting the core values and aspirations of the nation.\n\n" +

                        "PRINCIPLES\n\n" +

                        "The 1987 Constitution of the Republic of the Philippines, specifically Article II, Declaration of Principles and State Policies, lays the foundational principles that guide the governance of the Philippines. These principles encompass the country's commitment to democracy, international relations, social justice, human rights, and sustainable development, reflecting the core values and aspirations of the nation.\n\n" +

                        "SECTION 1. The Philippines is a democratic and republican State. Sovereignty resides in the people and all government authority emanates from them.\n" +
                        "\n" +
                        "SECTION 2. The Philippines renounces war as an instrument of national policy, adopts the generally accepted principles of international law as part of the law of the land and adheres to the policy of peace, equality, justice, freedom, cooperation, and amity with all nations.\n" +
                        "\n" +
                        "SECTION 3. Civilian authority is, at all times, supreme over the military. The Armed Forces of the Philippines is the protector of the people and the State. Its goal is to secure the sovereignty of the State and the integrity of the national territory.\n" +
                        "\n" +
                        "SECTION 4. The prime duty of the Government is to serve and protect the people. The Government may call upon the people to defend the State and, in the fulfillment thereof, all citizens may be required, under conditions provided by law, to render personal, military or civil service.\n" +
                        "\n" +
                        "SECTION 5. The maintenance of peace and order, the protection of life, liberty, and property, and promotion of the general welfare are essential for the enjoyment by all the people of the blessings of democracy.\n" +
                        "\n" +
                        "SECTION 6. The separation of Church and State shall be inviolable.\n\n" +


                        "STATE POLICIES\n\n" +

                        "Section 7. The State shall pursue an independent foreign policy. In its relations with other states, the paramount consideration shall be national sovereignty, territorial integrity, national interest, and the right to self-determination.\n" +
                        "\n" +
                        "Section 8. The Philippines, consistent with the national interest, adopts and pursues a policy of freedom from nuclear weapons in its territory.\n" +
                        "\n" +
                        "Section 9. The State shall promote a just and dynamic social order that will ensure the prosperity and independence of the nation and free the people from poverty through policies that provide adequate social services, promote full employment, a rising standard of living, and an improved quality of life for all.\n" +
                        "\n" +
                        "Section 10. The State shall promote social justice in all phases of national development.\n" +
                        "\n" +
                        "Section 11. The State values the dignity of every human person and guarantees full respect for human rights.\n" +
                        "\n" +
                        "Section 12. The State recognizes the sanctity of family life and shall protect and strengthen the family as a basic autonomous social institution. It shall equally protect the life of the mother and the life of the unborn from conception. The natural and primary right and duty of parents in the rearing of the youth for civic efficiency and the development of moral character shall receive the support of the Government.\n" +
                        "\n" +
                        "Section 13. The State recognizes the vital role of the youth in nation-building and shall promote and protect their physical, moral, spiritual, intellectual, and social well-being. It shall inculcate in the youth patriotism and nationalism, and encourage their involvement in public and civic affairs.\n" +
                        "\n" +
                        "Section 14. The State recognizes the role of women in nation-building, and shall ensure the fundamental equality before the law of women and men.\n" +
                        "\n" +
                        "Section 15. The State shall protect and promote the right to health of the people and instill health consciousness among them.\n" +
                        "\n" +
                        "Section 16. The State shall protect and advance the right of the people to a balanced and healthful ecology in accord with the rhythm and harmony of nature.\n" +
                        "\n" +
                        "Section 17. The State shall give priority to education, science and technology, arts, culture, and sports to foster patriotism and nationalism, accelerate social progress, and promote total human liberation and development.\n" +
                        "\n" +
                        "Section 18. The State affirms labor as a primary social economic force. It shall protect the rights of workers and promote their welfare.\n" +
                        "\n" +
                        "Section 19. The State shall develop a self-reliant and independent national economy effectively controlled by Filipinos.\n" +
                        "\n" +
                        "Section 20. The State recognizes the indispensable role of the private sector, encourages private enterprise, and provides incentives to needed investments.\n" +
                        "\n" +
                        "Section 21. The State shall promote comprehensive rural development and agrarian reform.\n" +
                        "\n" +
                        "Section 22. The State recognizes and promotes the rights of indigenous cultural communities within the framework of national unity and development.\n" +
                        "\n" +
                        "Section 23. The State shall encourage non-governmental, community-based, or sectoral organizations that promote the welfare of the nation.\n" +
                        "\n" +
                        "Section 24. The State recognizes the vital role of communication and information in nation-building.\n" +
                        "\n" +
                        "Section 25. The State shall ensure the autonomy of local governments.\n" +
                        "\n" +
                        "Section 26. The State shall guarantee equal access to opportunities for public service, and prohibit political dynasties as may be defined by law.\n" +
                        "\n" +
                        "Section 27. The State shall maintain honesty and integrity in the public service and take positive and effective measures against graft and corruption.\n" +
                        "\n" +
                        "Section 28. Subject to reasonable conditions prescribed by law, the State adopts and implements a policy of full public disclosure of all its transactions involving public interest.\n",










                R.drawable.img_260,
                "https://i.ytimg.com/vi/AuHQvtQSbyQ/maxresdefault.jpg",
                "https://image.slidesharecdn.com/dumaugarticle2-150427085745-conversion-gate01/85/dumaug-article-2-declaration-of-principles-and-state-policies-1-320.jpg")
        )



        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE III",


                "ARTICLE III\n\n" +

                        "BILL OF RIGHTS\n\n" +
                        "Article III of the 1987 Constitution of the Republic of the Philippines, known as the Bill of Rights, enshrines the fundamental liberties and protections afforded to every Filipino citizen. This pivotal section of the Constitution safeguards individual rights, judicial fairness, and the principles of justice and democracy that are the cornerstone of the nation's legal framework.\n\n" +

                        "Section 1. No person shall be deprived of life, liberty, or property without due process of law, nor shall any person be denied the equal protection of the laws.\n" +
                        "\n" +
                        "Section 2. The right of the people to be secure in their persons, houses, papers, and effects against unreasonable searches and seizures of whatever nature and for any purpose shall be inviolable, and no search warrant or warrant of arrest shall issue except upon probable cause to be determined personally by the judge after examination under oath or affirmation of the complainant and the witnesses he may produce, and particularly describing the place to be searched and the persons or things to be seized.\n" +
                        "\n" +
                        "Section 3. (1) The privacy of communication and correspondence shall be inviolable except upon lawful order of the court, or when public safety or order requires otherwise, as prescribed by law.\n" +
                        "\n" +
                        "(2) Any evidence obtained in violation of this or the preceding section shall be inadmissible for any purpose in any proceeding.\n" +
                        "\n" +
                        "Section 4. No law shall be passed abridging the freedom of speech, of expression, or of the press, or the right of the people peaceably to assemble and petition the government for redress of grievances.\n" +
                        "\n" +
                        "Section 5. No law shall be made respecting an establishment of religion, or prohibiting the free exercise thereof. The free exercise and enjoyment of religious profession and worship, without discrimination or preference, shall forever be allowed. No religious test shall be required for the exercise of civil or political rights.\n" +
                        "\n" +
                        "Section 6. The liberty of abode and of changing the same within the limits prescribed by law shall not be impaired except upon lawful order of the court. Neither shall the right to travel be impaired except in the interest of national security, public safety, or public health, as may be provided by law.\n" +
                        "\n" +
                        "Section 7. The right of the people to information on matters of public concern shall be recognized. Access to official records, and to documents and papers pertaining to official acts, transactions, or decisions, as well as to government research data used as basis for policy development, shall be afforded the citizen, subject to such limitations as may be provided by law.\n" +
                        "\n" +
                        "Section 8. The right of the people, including those employed in the public and private sectors, to form unions, associations, or societies for purposes not contrary to law shall not be abridged.\n" +
                        "\n" +
                        "Section 9. Private property shall not be taken for public use without just compensation.\n" +
                        "\n" +
                        "Section 10. No law impairing the obligation of contracts shall be passed.\n" +
                        "\n" +
                        "Section 11. Free access to the courts and quasi-judicial bodies and adequate legal assistance shall not be denied to any person by reason of poverty.\n" +
                        "\n" +
                        "Section 12. (1) Any person under investigation for the commission of an offense shall have the right to be informed of his right to remain silent and to have competent and independent counsel preferably of his own choice. If the person cannot afford the services of counsel, he must be provided with one. These rights cannot be waived except in writing and in the presence of counsel.\n" +
                        "\n" +
                        "(2) No torture, force, violence, threat, intimidation, or any other means which vitiate the free will shall be used against him. Secret detention places, solitary, incommunicado, or other similar forms of detention are prohibited.\n" +
                        "\n" +
                        "(3) Any confession or admission obtained in violation of this or Section 17 hereof shall be inadmissible in evidence against him.\n" +
                        "\n" +
                        "(4) The law shall provide for penal and civil sanctions for violations of this section as well as compensation to and rehabilitation of victims of torture or similar practices, and their families.\n" +
                        "\n" +
                        "Section 13. All persons, except those charged with offenses punishable by reclusion perpetua when evidence of guilt is strong, shall, before conviction, be bailable by sufficient sureties, or be released on recognizance as may be provided by law. The right to bail shall not be impaired even when the privilege of the writ of habeas corpus is suspended. Excessive bail shall not be required.\n" +
                        "\n" +
                        "Section 14. (1) No person shall be held to answer for a criminal offense without due process of law.\n" +
                        "\n" +
                        "(2) In all criminal prosecutions, the accused shall be presumed innocent until the contrary is proved, and shall enjoy the right to be heard by himself and counsel, to be informed of the nature and cause of the accusation against him, to have a speedy, impartial, and public trial, to meet the witnesses face to face, and to have compulsory process to secure the attendance of witnesses and the production of evidence in his behalf. However, after arraignment, trial may proceed notwithstanding the absence of the accused provided that he has been duly notified and his failure to appear is unjustifiable.\n" +
                        "\n" +
                        "Section 15. The privilege of the writ of habeas corpus shall not be suspended except in cases of invasion or rebellion when the public safety requires it.\n" +
                        "\n" +
                        "Section 16. All persons shall have the right to a speedy disposition of their cases before all judicial, quasi-judicial, or administrative bodies.\n" +
                        "\n" +
                        "Section 17. No person shall be compelled to be a witness against himself.\n" +
                        "\n" +
                        "Section 18. (1) No person shall be detained solely by reason of his political beliefs and aspirations.\n" +
                        "\n" +
                        "(2) No involuntary servitude in any form shall exist except as a punishment for a crime whereof the party shall have been duly convicted.\n" +
                        "\n" +
                        "Section 19. (1) Excessive fines shall not be imposed, nor cruel, degrading or inhuman punishment inflicted. Neither shall the death penalty be imposed, unless, for compelling reasons involving heinous crimes, the Congress hereafter provides for it. Any death penalty already imposed shall be reduced to reclusion perpetua.\n" +
                        "\n" +
                        "(2) The employment of physical, psychological, or degrading punishment against any prisoner or detainee or the use of substandard or inadequate penal facilities under subhuman conditions shall be dealt with by law.\n" +
                        "\n" +
                        "Section 20. No person shall be imprisoned for debt or non-payment of a poll tax.\n" +
                        "\n" +
                        "Section 21. No person shall be twice put in jeopardy of punishment for the same offense. If an act is punished by a law and an ordinance, conviction or acquittal under either shall constitute a bar to another prosecution for the same act.\n" +
                        "\n" +
                        "Section 22. No ex post facto law or bill of attainder shall be enacted.\n\n",

















                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-iii/",
                "https://image.slidesharecdn.com/article3sec6-9-151108092228-lva1-app6892/75/article-3-sec-69-1-2048.jpg")
        )

        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE IV",


                "ARTICLE IV\n\n" +

                        "CITIZENSHIP\n\n" +
                        "Article IV of the 1987 Constitution of the Republic of the Philippines addresses the pivotal topic of citizenship, defining who qualifies as a Filipino citizen and outlining the conditions for acquisition, loss, or retention of this status. This section plays a crucial role in shaping the identity and legal rights of individuals within the Philippines.\n\n" +



                        "Section 1. The following are citizens of the Philippines:\n" +
                        "\n" +
                        "[1] Those who are citizens of the Philippines at the time of the adoption of this Constitution;\n" +
                        "\n" +
                        "[2] Those whose fathers or mothers are citizens of the Philippines;\n" +
                        "\n" +
                        "[3] Those born before January 17, 1973, of Filipino mothers, who elect Philippine citizenship upon reaching the age of majority; and\n" +
                        "\n" +
                        "[4] Those who are naturalized in accordance with law.\n" +
                        "\n" +
                        "Section 2. Natural-born citizens are those who are citizens of the Philippines from birth without having to perform any act to acquire or perfect their Philippine citizenship. Those who elect Philippine citizenship in accordance with paragraph (3), Section 1 hereof shall be deemed natural-born citizens.\n" +
                        "\n" +
                        "Section 3. Philippine citizenship may be lost or reacquired in the manner provided by law.\n" +
                        "\n" +
                        "Section 4. Citizens of the Philippines who marry aliens shall retain their citizenship, unless by their act or omission, they are deemed, under the law, to have renounced it.\n" +
                        "\n" +
                        "Section 5. Dual allegiance of citizens is inimical to the national interest and shall be dealt with by law.\n\n" ,



                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-iv/",
                "https://i.ytimg.com/vi/bZaTH_6of_o/maxresdefault.jpg")
        )


        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE V",


                "ARTICLE V\n\n" +

                        "SUFFRAGE\n\n" +
                        "Article V of the 1987 Constitution of the Republic of the Philippines is dedicated to the crucial topic of suffrage, defining the principles and regulations governing the right to vote for all Filipino citizens. This article underscores the principles of inclusivity, ballot secrecy, and accessibility in the electoral process, affirming the democratic values that underpin the nation's political system.\n\n" +



                        "Section 1. The following are citizens of the Philippines:\n" +
                     "Section 1. Suffrage may be exercised by all citizens of the Philippines not otherwise disqualified by law, who are at least eighteen years of age, and who shall have resided in the Philippines for at least one year, and in the place wherein they propose to vote, for at least six months immediately preceding the election. No literacy, property, or other substantive requirement shall be imposed on the exercise of suffrage.\n" +
                        "\n" +
                        "Section 2. The Congress shall provide a system for securing the secrecy and sanctity of the ballot as well as a system for absentee voting by qualified Filipinos abroad.\n" +
                        "\n" +
                        "The Congress shall also design a procedure for the disabled and the illiterates to vote without the assistance of other persons. Until then, they shall be allowed to vote under existing laws and such rules as the Commission on Elections may promulgate to protect the secrecy of the ballot.\n\n" ,





                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-v/",
                "https://www.rappler.com/tachyon/r3-assets/612F469A6EA84F6BAE882D2B94A4B421/img/13F0B7ED10F54DAABAB9F88584187722/2013-elections.jpg")
        )


        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE VI",


                "ARTICLE VI\n\n" +

                        "THE LEGISLATIVE DEPARTMENT\n\n" +
                        "Article VI of the 1987 Constitution of the Republic of the Philippines establishes the structure and functions of the legislative department, which comprises the Congress of the Philippines, consisting of the Senate and the House of Representatives. This article delineates the roles, responsibilities, and limitations of these legislative bodies in the Philippine government, outlining important procedures related to lawmaking and taxation while emphasizing transparency and accountability.\n\n" +


                        "Section 1. The legislative power shall be vested in the Congress of the Philippines which shall consist of a Senate and a House of Representatives, except to the extent reserved to the people by the provision on initiative and referendum.\n" +
                        "\n" +
                        "Section 2. The Senate shall be composed of twenty-four Senators who shall be elected at large by the qualified voters of the Philippines, as may be provided by law.\n" +
                        "\n" +
                        "Section 3. No person shall be a Senator unless he is a natural-born citizen of the Philippines and, on the day of the election, is at least thirty-five years of age, able to read and write, a registered voter, and a resident of the Philippines for not less than two years immediately preceding the day of the election.\n" +
                        "\n" +
                        "Section 4. The term of office of the Senators shall be six years and shall commence, unless otherwise provided by law, at noon on the thirtieth day of June next following their election. No Senator shall serve for more than two consecutive terms. Voluntary renunciation of the office for any length of time shall not be considered as an interruption in the continuity of his service for the full term of which he was elected.\n" +
                        "\n" +
                        "Section 5. (1) The House of Representatives shall be composed of not more than two hundred and fifty members, unless otherwise fixed by law, who shall be elected from legislative districts apportioned among the provinces, cities, and the Metropolitan Manila area in accordance with the number of their respective inhabitants, and on the basis of a uniform and progressive ratio, and those who, as provided by law, shall be elected through a party-list system of registered national, regional, and sectoral parties or organizations.\n" +
                        "\n" +
                        "(2) The party-list representatives shall constitute twenty per centum of the total number of representatives including those under the party list. For three consecutive terms after the ratification of this Constitution, one-half of the seats allocated to party-list representatives shall be filled, as provided by law, by selection or election from the labor, peasant, urban poor, indigenous cultural communities, women, youth, and such other sectors as may be provided by law, except the religious sector.\n" +
                        "\n" +
                        "(3) Each legislative district shall comprise, as far as practicable, contiguous, compact, and adjacent territory. Each city with a population of at least two hundred fifty thousand, or each province, shall have at least one representative.\n" +
                        "\n" +
                        "(4) Within three years following the return of every census, the Congress shall make a reapportionment of legislative districts based on the standards provided in this section.\n" +
                        "\n" +
                        "Section 6. No person shall be a Member of the House of Representatives unless he is a natural-born citizen of the Philippines and, on the day of the election, is at least twenty-five years of age, able to read and write, and, except the party-list representatives, a registered voter in the district in which he shall be elected, and a resident thereof for a period of not less than one year immediately preceding the day of the election.\n" +
                        "\n" +
                        "Section 7. The Members of the House of Representatives shall be elected for a term of three years which shall begin, unless otherwise provided by law, at noon on the thirtieth day of June next following their election. No Member of the House of Representatives shall serve for more than three consecutive terms. Voluntary renunciation of the office for any length of time shall not be considered as an interruption in the continuity of his service for the full term for which he was elected.\n" +
                        "\n" +
                        "Section 8. Unless otherwise provided by law, the regular election of the Senators and the Members of the House of Representatives shall be held on the second Monday of May.\n" +
                        "\n" +
                        "Section 9. In case of vacancy in the Senate or in the House of Representatives, a special election may be called to fill such vacancy in the manner prescribed by law, but the Senator or Member of the House of Representatives thus elected shall serve only for the unexpired term.\n" +
                        "\n" +
                        "Section 10. The salaries of Senators and Members of the House of Representatives shall be determined by law. No increase in said compensation shall take effect until after the expiration of the full term of all the Members of the Senate and the House of Representatives approving such increase.\n" +
                        "\n" +
                        "Section 11. A Senator or Member of the House of Representatives shall, in all offenses punishable by not more than six years imprisonment, be privileged from arrest while the Congress is in session. No Member shall be questioned nor be held liable in any other place for any speech or debate in the Congress or in any committee thereof.\n" +
                        "\n" +
                        "Section 12. All Members of the Senate and the House of Representatives shall, upon assumption of office, make a full disclosure of their financial and business interests. They shall notify the House concerned of a potential conflict of interest that may arise from the filing of a proposed legislation of which they are authors.\n" +
                        "\n" +
                        "Section 13. No Senator or Member of the House of Representatives may hold any other office or employment in the Government, or any subdivision, agency, or instrumentality thereof, including government-owned or controlled corporations or their subsidiaries, during his term without forfeiting his seat. Neither shall he be appointed to any office which may have been created or the emoluments thereof increased during the term for which he was elected.\n" +
                        "\n" +
                        "Section 14. No Senator or Member of the House of Representatives may personally appear as counsel before any court of justice or before the Electoral Tribunals, or quasi-judicial and other administrative bodies. Neither shall he, directly or indirectly, be interested financially in any contract with, or in any franchise or special privilege granted by the Government, or any subdivision, agency, or instrumentality thereof, including any government-owned or controlled corporation, or its subsidiary, during his term of office. He shall not intervene in any matter before any office of the Government for his pecuniary benefit or where he may be called upon to act on account of his office.\n" +
                        "\n" +
                        "Section 15. The Congress shall convene once every year on the fourth Monday of July for its regular session, unless a different date is fixed by law, and shall continue to be in session for such number of days as it may determine until thirty days before the opening of its next regular session, exclusive of Saturdays, Sundays, and legal holidays. The President may call a special session at any time.\n" +
                        "\n" +
                        "SECTION 16. (1) The Senate shall elect its President and the House of Representatives its Speaker, by a majority vote of all its respective Members.\n" +
                        "\n" +
                        "Each House shall choose such other officers as it may deem necessary.\n" +
                        "\n" +
                        "(2) A majority of each House shall constitute a quorum to do business, but a smaller number may adjourn from day to day and may compel the attendance of absent Members in such manner, and under such penalties, as such House may provide.\n" +
                        "\n" +
                        "(3) Each House may determine the rules of its proceedings, punish its Members for disorderly behavior, and, with the concurrence of two-thirds of all its Members, suspend or expel a Member. A penalty of suspension, when imposed, shall not exceed sixty days.\n" +
                        "\n" +
                        "(4) Each House shall keep a Journal of its proceedings, and from time to time publish the same, excepting such parts as may, in its judgment, affect national security; and the yeas and nays on any question shall, at the request of one-fifth of the Members present, be entered in the Journal.\n" +
                        "\n" +
                        "Each House shall also keep a Record of its proceedings.\n" +
                        "\n" +
                        "(5) Neither House during the sessions of the Congress shall, without the consent of the other, adjourn for more than three days, nor to any other place than that in which the two Houses shall be sitting.\n" +
                        "\n" +
                        "SECTION 17. The Senate and the House of Representatives shall each have an Electoral Tribunal, which shall be the sole judge of all contests relating to the election, returns, and qualifications of their respective Members. Each Electoral Tribunal shall be composed of nine Members, three of whom shall be Justices of the Supreme Court to be designated by the Chief Justice, and the remaining six shall be Members of the Senate or the House of Representatives, as the case may be, who shall be chosen on the basis of proportional representation from the political parties and the parties or organizations registered under the party-list system represented therein. The senior Justice in the Electoral Tribunal shall be its Chairman.\n" +
                        "\n" +
                        "SECTION 18. There shall be a Commission on Appointments consisting of the President of the Senate, as ex officio Chairman, twelve Senators and twelve Members of the House of Representatives, elected by each House on the basis of proportional representation from the political parties and parties or organizations registered under the party-list system represented therein. The Chairman of the Commission shall not vote, except in case of a tie. The Commission shall act on all appointments submitted to it within thirty session days of the Congress from their submission. The Commission shall rule by a majority vote of all the Members.\n" +
                        "\n" +
                        "SECTION 19. The Electoral Tribunals and the Commission on Appointments shall be constituted within thirty days after the Senate and the House of Representatives shall have been organized with the election of the President and the Speaker. The Commission on Appointments shall meet only while the Congress is in session, at the call of its Chairman or a majority of all its Members, to discharge such powers and functions as are herein conferred upon it.\n" +
                        "\n" +
                        "SECTION 20. The records and books of accounts of the Congress shall be preserved and be open to the public in accordance with law, and such books shall be audited by the Commission on Audit which shall publish annually an itemized list of amounts paid to and expenses incurred for each Member.\n" +
                        "\n" +
                        "SECTION 21. The Senate or the House of Representatives or any of its respective committees may conduct inquiries in aid of legislation in accordance with its duly published rules of procedure. The rights of persons appearing in or affected by such inquiries shall be respected.\n" +
                        "\n" +
                        "SECTION 22. The heads of departments may upon their own initiative, with the consent of the President, or upon the request of either House, as the rules of each House shall provide, appear before and be heard by such House on any matter pertaining to their departments. Written questions shall be submitted to the President of the Senate or the Speaker of the House of Representatives at least three days before their scheduled appearance. Interpellations shall not be limited to written questions, but may cover matters related thereto. When the security of the State or the public interest so requires and the President so states in writing, the appearance shall be conducted in executive session.\n" +
                        "\n" +
                        "SECTION 23. (1) The Congress, by a vote of two-thirds of both Houses in joint session assembled, voting separately, shall have the sole power to declare the existence of a state of war.\n" +
                        "\n" +
                        "(2) In times of war or other national emergency, the Congress may, by law, authorize the President, for a limited period and subject to such restrictions as it may prescribe, to exercise powers necessary and proper to carry out a declared national policy. Unless sooner withdrawn by resolution of the Congress, such powers shall cease upon the next adjournment thereof.\n" +
                        "\n" +
                        "SECTION 24. All appropriation, revenue or tariff bills, bills authorizing increase of the public debt, bills of local application, and private bills shall originate exclusively in the House of Representatives, but the Senate may propose or concur with amendments.\n" +
                        "\n" +
                        "SECTION 25. (1) The Congress may not increase the appropriations recommended by the President for the operation of the Government as specified in the budget. The form, content, and manner of preparation of the budget shall be prescribed by law.\n" +
                        "\n" +
                        "(2) No provision or enactment shall be embraced in the general appropriations bill unless it relates specifically to some particular appropriation therein. Any such provision or enactment shall be limited in its operation to the appropriation to which it relates.\n" +
                        "\n" +
                        "(3) The procedure in approving appropriations for the Congress shall strictly follow the procedure for approving appropriations for other departments and agencies.\n" +
                        "\n" +
                        "(4) A special appropriations bill shall specify the purpose for which it is intended, and shall be supported by funds actually available as certified by the National Treasurer, or to be raised by a corresponding revenue proposed therein.\n" +
                        "\n" +
                        "(5) No law shall be passed authorizing any transfer of appropriations; however, the President, the President of the Senate, the Speaker of the House of Representatives, the Chief Justice of the Supreme Court, and the heads of Constitutional Commissions may, by law, be authorized to augment any item in the general appropriations law for their respective offices from savings in other items of their respective appropriations.\n" +
                        "\n" +
                        "(6) Discretionary funds appropriated for particular officials shall be disbursed only for public purposes to be supported by appropriate vouchers and subject to such guidelines as may be prescribed by law.\n" +
                        "\n" +
                        "(7) If, by the end of any fiscal year, the Congress shall have failed to pass the general appropriations bill for the ensuing fiscal year, the general appropriations law for the preceding fiscal year shall be deemed reenacted and shall remain in force and effect until the general appropriations bill is passed by the Congress.\n" +
                        "\n" +
                        "SECTION 26. (1) Every bill passed by the Congress shall embrace only one subject which shall be expressed in the title thereof.\n" +
                        "\n" +
                        "(2) No bill passed by either House shall become a law unless it has passed three readings on separate days, and printed copies thereof in its final form have been distributed to its Members three days before its passage, except when the President certifies to the necessity of its immediate enactment to meet a public calamity or emergency. Upon the last reading of a bill, no amendment thereto shall be allowed, and the vote thereon shall be taken immediately thereafter, and the yeas and nays entered in the Journal.\n" +
                        "\n" +
                        "SECTION 27. (1) Every bill passed by the Congress shall, before it becomes a law, be presented to the President. If he approves the same, he shall sign it; otherwise, he shall veto it and return the same with his objections to the House where it originated, which shall enter the objections at large in its Journal and proceed to reconsider it. If, after such reconsideration, two-thirds of all the Members of such House shall agree to pass the bill, it shall be sent, together with the objections, to the other House by which it shall likewise be reconsidered, and if approved by two-thirds of all the Members of that House, it shall become a law. In all such cases, the votes of each House shall be determined by yeas or nays, and the names of the Members voting for or against shall be entered in its Journal. The President shall communicate his veto of any bill to the House where it originated within thirty days after the date of receipt thereof; otherwise, it shall become a law as if he had signed it.\n" +
                        "\n" +
                        "(2) The President shall have the power to veto any particular item or items in an appropriation, revenue, or tariff bill, but the veto shall not affect the item or items to which he does not object.\n" +
                        "\n" +
                        "SECTION 28. (1) The rule of taxation shall be uniform and equitable. The Congress shall evolve a progressive system of taxation.\n" +
                        "\n" +
                        "(2) The Congress may, by law, authorize the President to fix within specified limits, and subject to such limitations and restrictions as it may impose, tariff rates, import and export quotas, tonnage and wharfage dues, and other duties or imposts within the framework of the national development program of the Government.\n" +
                        "\n" +
                        "(3) Charitable institutions, churches and parsonages or convents appurtenant thereto, mosques, non-profit cemeteries, and all lands, buildings, and improvements, actually, directly, and exclusively used for religious, charitable, or educational purposes shall be exempt from taxation.\n" +
                        "\n" +
                        "(4) No law granting any tax exemption shall be passed without the concurrence of a majority of all the Members of the Congress.\n" +
                        "\n" +
                        "SECTION 29. (1) No money shall be paid out of the Treasury except in pursuance of an appropriation made by law.\n" +
                        "\n" +
                        "(2) No public money or property shall be appropriated, applied, paid, or employed, directly or indirectly, for the use, benefit, or support of any sect, church, denomination, sectarian institution, or system of religion, or of any priest, preacher, minister, or other religious teacher, or dignitary as such, except when such priest, preacher, minister, or dignitary is assigned to the armed forces, or to any penal institution, or government orphanage or leprosarium.\n" +
                        "\n" +
                        "(3) All money collected on any tax levied for a special purpose shall be treated as a special fund and paid out for such purpose only. If the purpose for which a special fund was created has been fulfilled or abandoned, the balance, if any, shall be transferred to the general funds of the Government.\n" +
                        "\n" +
                        "SECTION 30. No law shall be passed increasing the appellate jurisdiction of the Supreme Court as provided in this Constitution without its advice and concurrence.\n" +
                        "\n" +
                        "SECTION 31. No law granting a title of royalty or nobility shall be enacted.\n" +
                        "\n" +
                        "SECTION 32. The Congress shall, as early as possible, provide for a system of initiative and referendum, and the exceptions therefrom, whereby the people can directly propose and enact laws or approve or reject any act or law or part thereof passed by the Congress or local legislative body after the registration of a petition therefor signed by at least ten per centum of the total number of registered voters, of which every legislative district must be represented by at least three per centum of the registered voters thereof.\n\n" ,












                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-vi/",
                "https://www.rappler.com/tachyon/r3-assets/612F469A6EA84F6BAE882D2B94A4B421/img/84CAAED020344338A3FCCB1540A2BE79/congress-senate-20160724-001.jpg")
        )








        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE VII",


                "ARTICLE VII\n\n" +

                        "EXECUTIVE DEPARTMENT\n\n" +
                        "Article VII of the 1987 Constitution of the Republic of the Philippines delineates the powers, qualifications, and responsibilities of the Executive Department of the Philippines. This article primarily focuses on the role of the President, the second-highest official, the Vice-President, and their respective powers and limitations, as well as matters pertaining to presidential succession, martial law, and other crucial aspects of the country's executive branch.\n\n" +


                        "Section 1. The executive power shall be vested in the President of the Philippines.\n" +
                        "\n" +
                        "Section 2. No person may be elected President unless he is a natural-born citizen of the Philippines, a registered voter, able to read and write, at least forty years of age on the day of the election, and a resident of the Philippines for at least ten years immediately preceding such election.\n" +
                        "\n" +
                        "Section 3. There shall be a Vice-President who shall have the same qualifications and term of office and be elected with, and in the same manner, as the President. He may be removed from office in the same manner as the President.\n" +
                        "\n" +
                        "The Vice-President may be appointed as a Member of the Cabinet. Such appointment requires no confirmation.\n" +
                        "\n" +
                        "Section 4. The President and the Vice-President shall be elected by direct vote of the people for a term of six years which shall begin at noon on the thirtieth day of June next following the day of the election and shall end at noon of the same date, six years thereafter. The President shall not be eligible for any re-election. No person who has succeeded as President and has served as such for more than four years shall be qualified for election to the same office at any time.\n" +
                        "\n" +
                        "No Vice-President shall serve for more than two successive terms. Voluntary renunciation of the office for any length of time shall not be considered as an interruption in the continuity of the service for the full term for which he was elected.\n" +
                        "\n" +
                        "Unless otherwise provided by law, the regular election for President and Vice-President shall be held on the second Monday of May.\n" +
                        "\n" +
                        "The returns of every election for President and Vice-President, duly certified by the board of canvassers of each province or city, shall be transmitted to the Congress, directed to the President of the Senate. Upon receipt of the certificates of canvass, the President of the Senate shall, not later than thirty days after the day of the election, open all the certificates in the presence of the Senate and the House of Representatives in joint public session, and the Congress, upon determination of the authenticity and due execution thereof in the manner provided by law, canvass the votes.\n" +
                        "\n" +
                        "The person having the highest number of votes shall be proclaimed elected, but in case two or more shall have an equal and highest number of votes, one of them shall forthwith be chosen by the vote of a majority of all the Members of both Houses of the Congress, voting separately.\n" +
                        "\n" +
                        "The Congress shall promulgate its rules for the canvassing of the certificates.\n" +
                        "\n" +
                        "The Supreme Court, sitting en banc, shall be the sole judge of all contests relating to the election, returns, and qualifications of the President or Vice-President, and may promulgate its rules for the purpose.\n" +
                        "\n" +
                        "Section 5. Before they enter on the execution of their office, the President, the Vice-President, or the Acting President shall take the following oath or affirmation:\n" +
                        "\n" +
                        "“I do solemnly swear [or affirm] that I will faithfully and conscientiously fulfill my duties as President [or Vice-President or Acting President] of the Philippines, preserve and defend its Constitution, execute its laws, do justice to every man, and consecrate myself to the service of the Nation. So help me God.” [In case of affirmation, last sentence will be omitted].\n" +
                        "\n" +
                        "Section 6. The President shall have an official residence. The salaries of the President and Vice-President shall be determined by law and shall not be decreased during their tenure. No increase in said compensation shall take effect until after the expiration of the term of the incumbent during which such increase was approved. They shall not receive during their tenure any other emolument from the Government or any other source.\n" +
                        "\n" +
                        "Section 7. The President-elect and the Vice President-elect shall assume office at the beginning of their terms.\n" +
                        "\n" +
                        "If the President-elect fails to qualify, the Vice President-elect shall act as President until the President-elect shall have qualified.\n" +
                        "\n" +
                        "If a President shall not have been chosen, the Vice President-elect shall act as President until a President shall have been chosen and qualified.\n" +
                        "\n" +
                        "If at the beginning of the term of the President, the President-elect shall have died or shall have become permanently disabled, the Vice President-elect shall become President.\n" +
                        "\n" +
                        "Where no President and Vice-President shall have been chosen or shall have qualified, or where both shall have died or become permanently disabled, the President of the Senate or, in case of his inability, the Speaker of the House of Representatives, shall act as President until a President or a Vice-President shall have been chosen and qualified.\n" +
                        "\n" +
                        "The Congress shall, by law, provide for the manner in which one who is to act as President shall be selected until a President or a Vice-President shall have qualified, in case of death, permanent disability, or inability of the officials mentioned in the next preceding paragraph.\n" +
                        "\n" +
                        "Section 8. In case of death, permanent disability, removal from office, or resignation of the President, the Vice-President shall become the President to serve the unexpired term. In case of death, permanent disability, removal from office, or resignation of both the President and Vice-President, the President of the Senate or, in case of his inability, the Speaker of the House of Representatives, shall then act as President until the President or Vice-President shall have been elected and qualified.\n" +
                        "\n" +
                        "The Congress shall, by law, provide who shall serve as President in case of death, permanent disability, or resignation of the Acting President. He shall serve until the President or the Vice-President shall have been elected and qualified, and be subject to the same restrictions of powers and disqualifications as the Acting President.\n" +
                        "\n" +
                        "Section 9. Whenever there is a vacancy in the Office of the Vice-President during the term for which he was elected, the President shall nominate a Vice-President from among the Members of the Senate and the House of Representatives who shall assume office upon confirmation by a majority vote of all the Members of both Houses of the Congress, voting separately.\n" +
                        "\n" +
                        "Section 10. The Congress shall, at ten o’clock in the morning of the third day after the vacancy in the offices of the President and Vice-President occurs, convene in accordance with its rules without need of a call and within seven days, enact a law calling for a special election to elect a President and a Vice-President to be held not earlier than forty-five days nor later than sixty days from the time of such call. The bill calling such special election shall be deemed certified under paragraph 2, Section 26, Article VI of this Constitution and shall become law upon its approval on third reading by the Congress. Appropriations for the special election shall be charged against any current appropriations and shall be exempt from the requirements of paragraph 4, Section 25, Article VI of this Constitution. The convening of the Congress cannot be suspended nor the special election postponed. No special election shall be called if the vacancy occurs within eighteen months before the date of the next presidential election.\n" +
                        "\n" +
                        "Section 11. Whenever the President transmits to the President of the Senate and the Speaker of the House of Representatives his written declaration that he is unable to discharge the powers and duties of his office, and until he transmits to them a written declaration to the contrary, such powers and duties shall be discharged by the Vice-President as Acting President.\n" +
                        "\n" +
                        "Whenever a majority of all the Members of the Cabinet transmit to the President of the Senate and to the Speaker of the House of Representatives their written declaration that the President is unable to discharge the powers and duties of his office, the Vice-President shall immediately assume the powers and duties of the office as Acting President.\n" +
                        "\n" +
                        "Thereafter, when the President transmits to the President of the Senate and to the Speaker of the House of Representatives his written declaration that no inability exists, he shall reassume the powers and duties of his office. Meanwhile, should a majority of all the Members of the Cabinet transmit within five days to the President of the Senate and to the Speaker of the House of Representatives, their written declaration that the President is unable to discharge the powers and duties of his office, the Congress shall decide the issue. For that purpose, the Congress shall convene, if it is not in session, within forty-eight hours, in accordance with its rules and without need of call.\n" +
                        "\n" +
                        "If the Congress, within ten days after receipt of the last written declaration, or, if not in session, within twelve days after it is required to assemble, determines by a two-thirds vote of both Houses, voting separately, that the President is unable to discharge the powers and duties of his office, the Vice-President shall act as President; otherwise, the President shall continue exercising the powers and duties of his office.\n" +
                        "\n" +
                        "Section 12. In case of serious illness of the President, the public shall be informed of the state of his health. The members of the Cabinet in charge of national security and foreign relations and the Chief of Staff of the Armed Forces of the Philippines, shall not be denied access to the President during such illness.\n" +
                        "\n" +
                        "Section 13. The President, Vice-President, the Members of the Cabinet, and their deputies or assistants shall not, unless otherwise provided in this Constitution, hold any other office or employment during their tenure. They shall not, during said tenure, directly or indirectly, practice any other profession, participate in any business, or be financially interested in any contract with, or in any franchise, or special privilege granted by the Government or any subdivision, agency, or instrumentality thereof, including government-owned or controlled corporations or their subsidiaries. They shall strictly avoid conflict of interest in the conduct of their office.\n" +
                        "\n" +
                        "The spouse and relatives by consanguinity or affinity within the fourth civil degree of the President shall not, during his tenure, be appointed as Members of the Constitutional Commissions, or the Office of the Ombudsman, or as Secretaries, Undersecretaries, chairmen or heads of bureaus or offices, including government-owned or controlled corporations and their subsidiaries.\n" +
                        "\n" +
                        "Section 14. Appointments extended by an Acting President shall remain effective, unless revoked by the elected President, within ninety days from his assumption or reassumption of office.\n" +
                        "\n" +
                        "Section 15. Two months immediately before the next presidential elections and up to the end of his term, a President or Acting President shall not make appointments, except temporary appointments to executive positions when continued vacancies therein will prejudice public service or endanger public safety.\n" +
                        "\n" +
                        "Section 16. The President shall nominate and, with the consent of the Commission on Appointments, appoint the heads of the executive departments, ambassadors, other public ministers and consuls, or officers of the armed forces from the rank of colonel or naval captain, and other officers whose appointments are vested in him in this Constitution. He shall also appoint all other officers of the Government whose appointments are not otherwise provided for by law, and those whom he may be authorized by law to appoint. The Congress may, by law, vest the appointment of other officers lower in rank in the President alone, in the courts, or in the heads of departments, agencies, commissions, or boards.\n" +
                        "\n" +
                        "The President shall have the power to make appointments during the recess of the Congress, whether voluntary or compulsory, but such appointments shall be effective only until disapproved by the Commission on Appointments or until the next adjournment of the Congress.\n" +
                        "\n" +
                        "Section 17. The President shall have control of all the executive departments, bureaus, and offices. He shall ensure that the laws be faithfully executed.\n" +
                        "\n" +
                        "Section 18. The President shall be the Commander-in-Chief of all armed forces of the Philippines and whenever it becomes necessary, he may call out such armed forces to prevent or suppress lawless violence, invasion or rebellion. In case of invasion or rebellion, when the public safety requires it, he may, for a period not exceeding sixty days, suspend the privilege of the writ of habeas corpus or place the Philippines or any part thereof under martial law. Within forty-eight hours from the proclamation of martial law or the suspension of the privilege of the writ of habeas corpus, the President shall submit a report in person or in writing to the Congress. The Congress, voting jointly, by a vote of at least a majority of all its Members in regular or special session, may revoke such proclamation or suspension, which revocation shall not be set aside by the President. Upon the initiative of the President, the Congress may, in the same manner, extend such proclamation or suspension for a period to be determined by the Congress, if the invasion or rebellion shall persist and public safety requires it.\n" +
                        "\n" +
                        "The Congress, if not in session, shall, within twenty-four hours following such proclamation or suspension, convene in accordance with its rules without need of a call.\n" +
                        "\n" +
                        "The Supreme Court may review, in an appropriate proceeding filed by any citizen, the sufficiency of the factual basis of the proclamation of martial law or the suspension of the privilege of the writ of habeas corpus or the extension thereof, and must promulgate its decision thereon within thirty days from its filing.\n" +
                        "\n" +
                        "A state of martial law does not suspend the operation of the Constitution, nor supplant the functioning of the civil courts or legislative assemblies, nor authorize the conferment of jurisdiction on military courts and agencies over civilians where civil courts are able to function, nor automatically suspend the privilege of the writ of habeas corpus.\n" +
                        "\n" +
                        "The suspension of the privilege of the writ of habeas corpus shall apply only to persons judicially charged for rebellion or offenses inherent in, or directly connected with, invasion.\n" +
                        "\n" +
                        "During the suspension of the privilege of the writ of habeas corpus, any person thus arrested or detained shall be judicially charged within three days, otherwise he shall be released.\n" +
                        "\n" +
                        "Section 19. Except in cases of impeachment, or as otherwise provided in this Constitution, the President may grant reprieves, commutations, and pardons, and remit fines and forfeitures, after conviction by final judgment.\n" +
                        "\n" +
                        "He shall also have the power to grant amnesty with the concurrence of a majority of all the Members of the Congress.\n" +
                        "\n" +
                        "Section 20. The President may contract or guarantee foreign loans on behalf of the Republic of the Philippines with the prior concurrence of the Monetary Board, and subject to such limitations as may be provided by law. The Monetary Board shall, within thirty days from the end of every quarter of the calendar year, submit to the Congress a complete report of its decision on applications for loans to be contracted or guaranteed by the Government or government-owned and controlled corporations which would have the effect of increasing the foreign debt, and containing other matters as may be provided by law.\n" +
                        "\n" +
                        "Section 21. No treaty or international agreement shall be valid and effective unless concurred in by at least two-thirds of all the Members of the Senate.\n" +
                        "\n" +
                        "Section 22. The President shall submit to the Congress, within thirty days from the opening of every regular session as the basis of the general appropriations bill, a budget of expenditures and sources of financing, including receipts from existing and proposed revenue measures.\n" +
                        "\n" +
                        "Section 23. The President shall address the Congress at the opening of its regular session. He may also appear before it at any other time.\n" ,




























                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-vii/",
                "https://i.ytimg.com/vi/B1AcPo9Vyc8/maxresdefault.jpg")
        )




        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE VII",


                "ARTICLE VIII\n\n" +

                        "JUDICIAL DEPARTMENT\n\n" +
                        "Article VIII of the 1987 Constitution of the Republic of the Philippines establishes the framework for the country's judicial branch, outlining the structure and powers of the judiciary, and the criteria for appointing judges. This article is vital in ensuring the separation of powers and maintaining the integrity and independence of the Philippine judicial system.\n\n" +


                        "Section 1. The judicial power shall be vested in one Supreme Court and in such lower courts as may be established by law.\n" +
                        "\n" +
                        "Judicial power includes the duty of the courts of justice to settle actual controversies involving rights which are legally demandable and enforceable, and to determine whether or not there has been a grave abuse of discretion amounting to lack or excess of jurisdiction on the part of any branch or instrumentality of the Government.\n" +
                        "\n" +
                        "Section 2. The Congress shall have the power to define, prescribe, and apportion the jurisdiction of the various courts but may not deprive the Supreme Court of its jurisdiction over cases enumerated in Section 5 hereof.\n" +
                        "\n" +
                        "No law shall be passed reorganizing the Judiciary when it undermines the security of tenure of its Members.\n" +
                        "\n" +
                        "Section 3. The Judiciary shall enjoy fiscal autonomy. Appropriations for the Judiciary may not be reduced by the legislature below the amount appropriated for the previous year and, after approval, shall be automatically and regularly released.\n" +
                        "\n" +
                        "Section 4. (1) The Supreme Court shall be composed of a Chief Justice and fourteen Associate Justices. It may sit en banc or in its discretion, in division of three, five, or seven Members. Any vacancy shall be filled within ninety days from the occurrence thereof.\n" +
                        "\n" +
                        "(2) All cases involving the constitutionality of a treaty, international or executive agreement, or law, which shall be heard by the Supreme Court en banc, and all other cases which under the Rules of Court are required to be heard en banc, including those involving the constitutionality, application, or operation of presidential decrees, proclamations, orders, instructions, ordinances, and other regulations, shall be decided with the concurrence of a majority of the Members who actually took part in the deliberations on the issues in the case and voted thereon.\n" +
                        "\n" +
                        "(3) Cases or matters heard by a division shall be decided or resolved with the concurrence of a majority of the Members who actually took part in the deliberations on the issues in the case and voted thereon, and in no case without the concurrence of at least three of such Members. When the required number is not obtained, the case shall be decided en banc: Provided, that no doctrine or principle of law laid down by the court in a decision rendered en banc or in division may be modified or reversed except by the court sitting en banc.\n" +
                        "\n" +
                        "Section 5. The Supreme Court shall have the following powers:\n" +
                        "\n" +
                        "(1) Exercise original jurisdiction over cases affecting ambassadors, other public ministers and consuls, and over petitions for certiorari, prohibition, mandamus, quo warranto, and habeas corpus.\n" +
                        "\n" +
                        "(2) Review, revise, reverse, modify, or affirm on appeal or certiorari, as the law or the Rules of Court may provide, final judgments and orders of lower courts in:\n" +
                        "\n" +
                        "(a) All cases in which the constitutionality or validity of any treaty, international or executive agreement, law, presidential decree, proclamation, order, instruction, ordinance, or regulation is in question.\n" +
                        "\n" +
                        "(b) All cases involving the legality of any tax, impost, assessment, or toll, or any penalty imposed in relation thereto.\n" +
                        "\n" +
                        "(c) All cases in which the jurisdiction of any lower court is in issue.\n" +
                        "\n" +
                        "(d) All criminal cases in which the penalty imposed is reclusion perpetua or higher.\n" +
                        "\n" +
                        "(e) All cases in which only an error or question of law is involved.\n" +
                        "\n" +
                        "(3) Assign temporarily judges of lower courts to other stations as public interest may require. Such temporary assignment shall not exceed six months without the consent of the judge concerned.\n" +
                        "\n" +
                        "(4) Order a change of venue or place of trial to avoid a miscarriage of justice.\n" +
                        "\n" +
                        "(5) Promulgate rules concerning the protection and enforcement of constitutional rights, pleading, practice, and procedure in all courts, the admission to the practice of law, the integrated bar, and legal assistance to the underprivileged. Such rules shall provide a simplified and inexpensive procedure for the speedy disposition of cases, shall be uniform for all courts of the same grade, and shall not diminish, increase, or modify substantive rights. Rules of procedure of special courts and quasi-judicial bodies shall remain effective unless disapproved by the Supreme Court.\n" +
                        "\n" +
                        " (6) Appoint all officials and employees of the Judiciary in accordance with the Civil Service Law.\n" +
                        "\n" +
                        "Section 6. The Supreme Court shall have administrative supervision over all courts and the personnel thereof.\n" +
                        "\n" +
                        "Section 7. (1) No person shall be appointed Member of the Supreme Court or any lower collegiate court unless he is a natural-born citizen of the Philippines. A Member of the Supreme Court must be at least forty years of age, and must have been for fifteen years or more, a judge of a lower court or engaged in the practice of law in the Philippines.\n" +
                        "\n" +
                        "(2) The Congress shall prescribe the qualifications of judges of lower courts, but no person may be appointed judge thereof unless he is a citizen of the Philippines and a member of the Philippine Bar.\n" +
                        "\n" +
                        "(3) A Member of the Judiciary must be a person of proven competence, integrity, probity, and independence.\n" +
                        "\n" +
                        "Section 8. (1) A Judicial and Bar Council is hereby created under the supervision of the Supreme Court composed of the Chief Justice as ex officio Chairman, the Secretary of Justice, and a representative of the Congress as ex officio Members, a representative of the Integrated Bar, a professor of law, a retired Member of the Supreme Court, and a representative of the private sector.\n" +
                        "\n" +
                        "(2) The regular members of the Council shall be appointed by the President for a term of four years with the consent of the Commission on Appointments. Of the Members first appointed, the representative of the Integrated Bar shall serve for four years, the professor of law for three years, the retired Justice for two years, and the representative of the private sector for one year.\n" +
                        "\n" +
                        "(3) The Clerk of the Supreme Court shall be the Secretary ex officio of the Council and shall keep a record of its proceedings.\n" +
                        "\n" +
                        "(4) The regular Members of the Council shall receive such emoluments as may be determined by the Supreme Court. The Supreme Court shall provide in its annual budget the appropriations for the Council.\n" +
                        "\n" +
                        "(5) The Council shall have the principal function of recommending appointees to the Judiciary. It may exercise such other functions and duties as the Supreme Court may assign to it.\n" +
                        "\n" +
                        "Section 9. The Members of the Supreme Court and judges of the lower courts shall be appointed by the President from a list of at least three nominees prepared by the Judicial and Bar Council for every vacancy. Such appointments need no confirmation.\n" +
                        "\n" +
                        "For the lower courts, the President shall issue the appointments within ninety days from the submission of the list.\n" +
                        "\n" +
                        "Section 10. The salary of the Chief Justice and of the Associate Justices of the Supreme Court, and of judges of lower courts, shall be fixed by law. During their continuance in office, their salary shall not be decreased.\n" +
                        "\n" +
                        "Section 11. The Members of the Supreme Court and judges of lower courts shall hold office during good behavior until they reach the age of seventy years or become incapacitated to discharge the duties of their office. The Supreme Court en banc shall have the power to discipline judges of lower courts, or order their dismissal by a vote of a majority of the Members who actually took part in the deliberations on the issues in the case and voted thereon.\n" +
                        "\n" +
                        "Section 12. The Members of the Supreme Court and of other courts established by law shall not be designated to any agency performing quasi-judicial or administrative functions.\n" +
                        "\n" +
                        "Section 13. The conclusions of the Supreme Court in any case submitted to it for decision en banc or in division shall be reached in consultation before the case is assigned to a Member for the writing of the opinion of the Court. A certification to this effect signed by the Chief Justice shall be issued and a copy thereof attached to the record of the case and served upon the parties. Any Member who took no part, or dissented, or abstained from a decision or resolution, must state the reason therefor. The same requirements shall be observed by all lower collegiate courts.\n" +
                        "\n" +
                        "Section 14. No decision shall be rendered by any court without expressing therein clearly and distinctly the facts and the law on which it is based.\n" +
                        "\n" +
                        "No petition for review or motion for reconsideration of a decision of the court shall be refused due course or denied without stating the legal basis therefor.\n" +
                        "\n" +
                        "Section 15. (1) All cases or matters filed after the effectivity of this Constitution must be decided or resolved within twenty-four months from date of submission for the Supreme Court, and, unless reduced by the Supreme Court, twelve months for all lower collegiate courts, and three months for all other lower courts.\n" +
                        "\n" +
                        "(2) A case or matter shall be deemed submitted for decision or resolution upon the filing of the last pleading, brief, or memorandum required by the Rules of Court or by the court itself.\n" +
                        "\n" +
                        "(3) Upon the expiration of the corresponding period, a certification to this effect signed by the Chief Justice or the presiding judge shall forthwith be issued and a copy thereof attached to the record of the case or matter, and served upon the parties. The certification shall state why a decision or resolution has not been rendered or issued within said period.\n" +
                        "\n" +
                        "(4) Despite the expiration of the applicable mandatory period, the court, without prejudice to such responsibility as may have been incurred in consequence thereof, shall decide or resolve the case or matter submitted thereto for determination, without further delay.\n" +
                        "\n" +
                        "Section 16. The Supreme Court shall, within thirty days from the opening of each regular session of the Congress, submit to the President and the Congress an annual report on the operations and activities of the Judiciary.\n",


                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-viii/",
                "https://i.ytimg.com/vi/goppgyKPUWg/maxresdefault.jpg")
        )












        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE IX",


                "ARTICLE IX\n\n" +

                        "Constitutional Commissions\n\n" +
                        "The common provisions outlined in this section of the 1987 Constitution of the Republic of the Philippines define the roles and responsibilities of three independent constitutional commissions: the Civil Service Commission, the Commission on Elections, and the Commission on Audit. These commissions play essential roles in upholding government integrity, regulating elections, and ensuring financial transparency and accountability.\n\n" +


                        "A. COMMON PROVISIONS\n" +
                        "\n" +
                        "Section 1. The Constitutional Commissions, which shall be independent, are the Civil Service Commission, the Commission on Elections, and the Commission on Audit.\n" +
                        "\n" +
                        "Section 2. No member of a Constitutional Commission shall, during his tenure, hold any other office or employment. Neither shall he engage in the practice of any profession or in the active management or control of any business which, in any way, may be affected by the functions of his office, nor shall he be financially interested, directly or indirectly, in any contract with, or in any franchise or privilege granted by the Government, any of its subdivisions, agencies, or instrumentalities, including government-owned or controlled corporations or their subsidiaries.\n" +
                        "\n" +
                        "Section. 3. The salary of the Chairman and the Commissioners shall be fixed by law and shall not be decreased during their tenure.\n" +
                        "\n" +
                        "Section 4. The Constitutional Commissions shall appoint their officials and employees in accordance with law.\n" +
                        "\n" +
                        "Section 5. The Commission shall enjoy fiscal autonomy. Their approved annual appropriations shall be automatically and regularly released.\n" +
                        "\n" +
                        "Section 6. Each Commission en banc may promulgate its own rules concerning pleadings and practice before it or before any of its offices. Such rules, however, shall not diminish, increase, or modify substantive rights.\n" +
                        "\n" +
                        "Section 7. Each Commission shall decide by a majority vote of all its Members, any case or matter brought before it within sixty days from the date of its submission for decision or resolution. A case or matter is deemed submitted for decision or resolution upon the filing of the last pleading, brief, or memorandum required by the rules of the Commission or by the Commission itself. Unless otherwise provided by this Constitution or by law, any decision, order, or ruling of each Commission may be brought to the Supreme Court on certiorari by the aggrieved party within thirty days from receipt of a copy thereof.\n" +
                        "\n" +
                        "Section 8. Each Commission shall perform such other functions as may be provided by law.\n" +
                        "\n" +
                        "B. THE CIVIL SERVICE COMMISSION\n" +
                        "\n" +
                        "Section 1. (1) The civil service shall be administered by the Civil Service Commission composed of a Chairman and two Commissioners who shall be natural-born citizens of the Philippines and, at the time of their appointment, at least thirty-five years of age, with proven capacity for public administration, and must not have been candidates for any elective position in the elections immediately preceding their appointment.\n" +
                        "\n" +
                        "(2) The Chairman and the Commissioners shall be appointed by the President with the consent of the Commission on Appointments for a term of seven years without reappointment. Of those first appointed, the Chairman shall hold office for seven years, a Commissioner for five years, and another Commissioner for three years, without reappointment. Appointment to any vacancy shall be only for the unexpired term of the predecessor. In no case shall any Member be appointed or designated in a temporary or acting capacity.\n" +
                        "\n" +
                        "Section 2. (1) The civil service embraces all branches, subdivisions, instrumentalities, and agencies of the Government, including government-owned or controlled corporations with original charters.\n" +
                        "\n" +
                        "(2) Appointments in the civil service shall be made only according to merit and fitness to be determined, as far as practicable, and, except to positions which are policy-determining, primarily confidential, or highly technical, by competitive examination.\n" +
                        "\n" +
                        "(3) No officer or employee of the civil service shall be removed or suspended except for cause provided by law.\n" +
                        "\n" +
                        "(4) No officer or employee in the civil service shall engage, directly or indirectly, in any electioneering or partisan political campaign.\n" +
                        "\n" +
                        "(5) The right to self-organization shall not be denied to government employees.\n" +
                        "\n" +
                        "(6) Temporary employees of the Government shall be given such protection as may be provided by law.\n" +
                        "\n" +
                        "Section 3. The Civil Service Commission, as the central personnel agency of the Government, shall establish a career service and adopt measures to promote morale, efficiency, integrity, responsiveness, progressiveness, and courtesy in the civil service. It shall strengthen the merit and rewards system, integrate all human resources development programs for all levels and ranks, and institutionalize a management climate conducive to public accountability. It shall submit to the President and the Congress an annual report on its personnel programs.\n" +
                        "\n" +
                        "Section 4. All public officers and employees shall take an oath or affirmation to uphold and defend this Constitution.\n" +
                        "\n" +
                        "Section 5. The Congress shall provide for the standardization of compensation of government officials and employees, including those in government-owned or controlled corporations with original charters, taking into account the nature of the responsibilities pertaining to, and the qualifications required for, their positions.\n" +
                        "\n" +
                        "Section 6. No candidate who has lost in any election shall, within one year after such election, be appointed to any office in the Government or any Government-owned or controlled corporations or in any of their subsidiaries.\n" +
                        "\n" +
                        "Section 7. No elective official shall be eligible for appointment or designation in any capacity to any public office or position during his tenure.\n" +
                        "\n" +
                        "Unless otherwise allowed by law or by the primary functions of his position, no appointive official shall hold any other office or employment in the Government or any subdivision, agency or instrumentality thereof, including Government-owned or controlled corporations or their subsidiaries.\n" +
                        "\n" +
                        "Section 8. No elective or appointive public officer or employee shall receive additional, double, or indirect compensation, unless specifically authorized by law, nor accept without the consent of the Congress, any present, emolument, office, or title of any kind from any foreign government.\n" +
                        "\n" +
                        "Pensions or gratuities shall not be considered as additional, double, or indirect compensation.\n" +
                        "\n" +
                        "C. THE COMMISSION ON ELECTIONS\n" +
                        "\n" +
                        "Section 1. (1) There shall be a Commission on Elections composed of a Chairman and six Commissioners who shall be natural-born citizens of the Philippines and, at the time of their appointment, at least thirty-five years of age, holders of a college degree, and must not have been candidates for any elective positions in the immediately preceding elections. However, a majority thereof, including the Chairman, shall be members of the Philippine Bar who have been engaged in the practice of law for at least ten years.\n" +
                        "\n" +
                        "(2) The Chairman and the Commissioners shall be appointed by the President with the consent of the Commission on Appointments for a term of seven years without reappointment. Of those first appointed, three Members shall hold office for seven years, two Members for five years, and the last Members for three years, without reappointment. Appointment to any vacancy shall be only for the unexpired term of the predecessor. In no case shall any Member be appointed or designated in a temporary or acting capacity.\n" +
                        "\n" +
                        "Sec. 2. The Commission on Elections shall exercise the following powers and functions:\n" +
                        "\n" +
                        "(1) Enforce and administer all laws and regulations relative to the conduct of an election, plebiscite, initiative, referendum, and recall.\n" +
                        "\n" +
                        "(2) Exercise exclusive original jurisdiction over all contests relating to the elections, returns, and qualifications of all elective regional, provincial, and city officials, and appellate jurisdiction over all contests involving elective municipal officials decided by trial courts of general jurisdiction, or involving elective barangay officials decided by trial courts of limited jurisdiction.\n" +
                        "\n" +
                        "Decisions, final orders, or rulings of the Commission on election contests involving elective municipal and barangay offices shall be final, executory, and not appealable.\n" +
                        "\n" +
                        "(3) Decide, except those involving the right to vote, all questions affecting elections, including determination of the number and location of polling places, appointment of election officials and inspectors, and registration of voters.\n" +
                        "\n" +
                        "(4) Deputize, with the concurrence of the President, law enforcement agencies and instrumentalities of the Government, including the Armed Forces of the Philippines, for the exclusive purpose of ensuring free, orderly, honest, peaceful, and credible elections.\n" +
                        "\n" +
                        "(5) Register, after sufficient publication, political parties, organizations, or coalitions which, in addition to other requirements, must present their platform or program of government; and accredit citizens’ arms of the Commission on Elections. Religious denominations and sects shall not be registered. Those which seek to achieve their goals through violence or unlawful means, or refuse to uphold and adhere to this Constitution, or which are supported by any foreign government shall likewise be refused registration.\n" +
                        "\n" +
                        "Financial contributions from foreign governments and their agencies to political parties, organizations, coalitions, or candidates related to elections, constitute interference in national affairs, and, when accepted, shall be an additional ground for the cancellation of their registration with the Commission, in addition to other penalties that may be prescribed by law.\n" +
                        "\n" +
                        "(6) File, upon a verified complaint, or on its own initiative, petitions in court for inclusion or exclusion of voters; investigate and, where appropriate, prosecute cases of violations of election laws, including acts or omissions constituting election frauds, offenses, and malpractices.\n" +
                        "\n" +
                        "(7) Recommend to the Congress effective measures to minimize election spending, including limitation of places where propaganda materials shall be posted, and to prevent and penalize all forms of election frauds, offenses, malpractices, and nuisance candidates.\n" +
                        "\n" +
                        "(8) Recommend to the President the removal of any officer or employee it has deputized, or the imposition of any other disciplinary action, for violation or disregard of, or disobedience to, its directive, order, or decision.\n" +
                        "\n" +
                        "(9) Submit to the President and the Congress, a comprehensive report on the conduct of each election, plebiscite, initiative, referendum, or recall.\n" +
                        "\n" +
                        "Section 3. The Commission on Elections may sit en banc or in two divisions, and shall promulgate its rules of procedure in order to expedite disposition of election cases, including pre-proclamation controversies. All such election cases shall be heard and decided in division, provided that motions for reconsideration of decisions shall be decided by the Commission en banc.\n" +
                        "\n" +
                        "Section 4. The Commission may, during the election period, supervise or regulate the enjoyment or utilization of all franchises or permits for the operation of transportation and other public utilities, media of communication or information, all grants, special privileges, or concessions granted by the Government or any subdivision, agency, or instrumentality thereof, including any government-owned or controlled corporation or its subsidiary. Such supervision or regulation shall aim to ensure equal opportunity, time, and space ,and the right to reply, including reasonable, equal rates therefor, for public information campaigns and forums among candidates in connection with the objective of holding free, orderly, honest, peaceful, and credible elections.\n" +
                        "\n" +
                        "Section 5. No pardon, amnesty, parole, or suspension of sentence for violation of election laws, rules, and regulations shall be granted by the President without the favorable recommendation of the Commission.\n" +
                        "\n" +
                        "Section 6. A free and open party system shall be allowed to evolve according to the free choice of the people, subject to the provisions of this Article.\n" +
                        "\n" +
                        "Section 7. No votes cast in favor of a political party, organization, or coalition shall be valid, except for those registered under the party-list system as provided in this Constitution.\n" +
                        "\n" +
                        "Section 8. Political parties, or organizations or coalitions registered under the party-list system, shall not be represented in the voters’ registration boards, boards of election inspectors, boards of canvassers, or other similar bodies. However, they shall be entitled to appoint poll watchers in accordance with law.\n" +
                        "\n" +
                        "Section 9. Unless otherwise fixed by the Commission in special cases, the election period shall commence ninety days before the day of election and shall end thirty days thereafter.\n" +
                        "\n" +
                        "Section 10. Bona fide candidates for any public office shall be free from any form of harassment and discrimination.\n" +
                        "\n" +
                        "Section 11. Funds certified by the Commission as necessary to defray the expenses for holding regular and special elections, plebiscites, initiatives, referenda, and recalls, shall be provided in the regular or special appropriations and, once approved, shall be released automatically upon certification by the Chairman of the Commission.\n" +
                        "\n" +
                        "D. THE COMMISSION ON AUDIT\n" +
                        "Section 1. (1) There shall be a Commission on Audit composed of a Chairman and two Commissioners, who shall be natural-born citizens of the Philippines and, at the time of their appointment, at least thirty-five years of age, Certified Public Accountants with not less than ten years of auditing experience, or members of the Philippine Bar who have been engaged in the practice of law for at least ten years, and must not have been candidates for any elective position in the elections immediately preceding their appointment. At no time shall all Members of the Commission belong to the same profession.\n" +
                        "\n" +
                        "(2) The Chairman and the Commissioners shall be appointed by the President with the consent of the Commission on Appointments for a term of seven years without reappointment. Of those first appointed, the Chairman shall hold office for seven years, one Commissioner for five years, and the other Commissioner for three years, without reappointment. Appointment to any vacancy shall be only for the unexpired portion of the term of the predecessor. In no case shall any Member be appointed or designated in a temporary or acting capacity.\n" +
                        "\n" +
                        "Section 2. (1) The Commission on Audit shall have the power, authority, and duty to examine, audit, and settle all accounts pertaining to the revenue and receipts of, and expenditures or uses of funds and property, owned or held in trust by, or pertaining to, the Government, or any of its subdivisions, agencies, or instrumentalities, including government-owned or controlled corporations with original charters, and on a post-audit basis: (a) constitutional bodies, commissions and offices that have been granted fiscal autonomy under this Constitution; (b) autonomous state colleges and universities; (c) other government-owned or controlled corporations and their subsidiaries; and (d) such non-governmental entities receiving subsidy or equity, directly or indirectly, from or through the Government, which are required by law or the granting institution to submit to such audit as a condition of subsidy or equity. However, where the internal control system of the audited agencies is inadequate, the Commission may adopt such measures, including temporary or special pre-audit, as are necessary and appropriate to correct the deficiencies. It shall keep the general accounts of the Government and, for such period as may be provided by law, preserve the vouchers and other supporting papers pertaining thereto.\n" +
                        "\n" +
                        "(2) The Commission shall have exclusive authority, subject to the limitations in this Article, to define the scope of its audit and examination, establish the techniques and methods required therefor, and promulgate accounting and auditing rules and regulations, including those for the prevention and disallowance of irregular, unnecessary, excessive, extravagant, or unconscionable expenditures or uses of government funds and properties.\n" +
                        "\n" +
                        "Section 3. No law shall be passed exempting any entity of the Government or its subsidiaries in any guise whatever, or any investment of public funds, from the jurisdiction of the Commission on Audit.\n" +
                        "\n" +
                        "Section 4. The Commission shall submit to the President and the Congress, within the time fixed by law, an annual report covering the financial condition and operation of the Government, its subdivisions, agencies, and instrumentalities, including government-owned or controlled corporations, and non-governmental entities subject to its audit, and recommend measures necessary to improve their effectiveness and efficiency. It shall submit such other reports as may be required by law.\n" ,









                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-ix/",
                "https://i.ytimg.com/vi/Cvelg_Qbobc/sddefault.jpg")
        )





        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE IX",


                "ARTICLE IX\n\n" +

                        "Constitutional Commissions\n\n" +
                        "The common provisions outlined in this section of the 1987 Constitution of the Republic of the Philippines define the roles and responsibilities of three independent constitutional commissions: the Civil Service Commission, the Commission on Elections, and the Commission on Audit. These commissions play essential roles in upholding government integrity, regulating elections, and ensuring financial transparency and accountability.\n\n" +


                        "A. COMMON PROVISIONS\n" +
                        "\n" +
                        "Section 1. The Constitutional Commissions, which shall be independent, are the Civil Service Commission, the Commission on Elections, and the Commission on Audit.\n" +
                        "\n" +
                        "Section 2. No member of a Constitutional Commission shall, during his tenure, hold any other office or employment. Neither shall he engage in the practice of any profession or in the active management or control of any business which, in any way, may be affected by the functions of his office, nor shall he be financially interested, directly or indirectly, in any contract with, or in any franchise or privilege granted by the Government, any of its subdivisions, agencies, or instrumentalities, including government-owned or controlled corporations or their subsidiaries.\n" +
                        "\n" +
                        "Section. 3. The salary of the Chairman and the Commissioners shall be fixed by law and shall not be decreased during their tenure.\n" +
                        "\n" +
                        "Section 4. The Constitutional Commissions shall appoint their officials and employees in accordance with law.\n" +
                        "\n" +
                        "Section 5. The Commission shall enjoy fiscal autonomy. Their approved annual appropriations shall be automatically and regularly released.\n" +
                        "\n" +
                        "Section 6. Each Commission en banc may promulgate its own rules concerning pleadings and practice before it or before any of its offices. Such rules, however, shall not diminish, increase, or modify substantive rights.\n" +
                        "\n" +
                        "Section 7. Each Commission shall decide by a majority vote of all its Members, any case or matter brought before it within sixty days from the date of its submission for decision or resolution. A case or matter is deemed submitted for decision or resolution upon the filing of the last pleading, brief, or memorandum required by the rules of the Commission or by the Commission itself. Unless otherwise provided by this Constitution or by law, any decision, order, or ruling of each Commission may be brought to the Supreme Court on certiorari by the aggrieved party within thirty days from receipt of a copy thereof.\n" +
                        "\n" +
                        "Section 8. Each Commission shall perform such other functions as may be provided by law.\n" +
                        "\n" +
                        "B. THE CIVIL SERVICE COMMISSION\n" +
                        "\n" +
                        "Section 1. (1) The civil service shall be administered by the Civil Service Commission composed of a Chairman and two Commissioners who shall be natural-born citizens of the Philippines and, at the time of their appointment, at least thirty-five years of age, with proven capacity for public administration, and must not have been candidates for any elective position in the elections immediately preceding their appointment.\n" +
                        "\n" +
                        "(2) The Chairman and the Commissioners shall be appointed by the President with the consent of the Commission on Appointments for a term of seven years without reappointment. Of those first appointed, the Chairman shall hold office for seven years, a Commissioner for five years, and another Commissioner for three years, without reappointment. Appointment to any vacancy shall be only for the unexpired term of the predecessor. In no case shall any Member be appointed or designated in a temporary or acting capacity.\n" +
                        "\n" +
                        "Section 2. (1) The civil service embraces all branches, subdivisions, instrumentalities, and agencies of the Government, including government-owned or controlled corporations with original charters.\n" +
                        "\n" +
                        "(2) Appointments in the civil service shall be made only according to merit and fitness to be determined, as far as practicable, and, except to positions which are policy-determining, primarily confidential, or highly technical, by competitive examination.\n" +
                        "\n" +
                        "(3) No officer or employee of the civil service shall be removed or suspended except for cause provided by law.\n" +
                        "\n" +
                        "(4) No officer or employee in the civil service shall engage, directly or indirectly, in any electioneering or partisan political campaign.\n" +
                        "\n" +
                        "(5) The right to self-organization shall not be denied to government employees.\n" +
                        "\n" +
                        "(6) Temporary employees of the Government shall be given such protection as may be provided by law.\n" +
                        "\n" +
                        "Section 3. The Civil Service Commission, as the central personnel agency of the Government, shall establish a career service and adopt measures to promote morale, efficiency, integrity, responsiveness, progressiveness, and courtesy in the civil service. It shall strengthen the merit and rewards system, integrate all human resources development programs for all levels and ranks, and institutionalize a management climate conducive to public accountability. It shall submit to the President and the Congress an annual report on its personnel programs.\n" +
                        "\n" +
                        "Section 4. All public officers and employees shall take an oath or affirmation to uphold and defend this Constitution.\n" +
                        "\n" +
                        "Section 5. The Congress shall provide for the standardization of compensation of government officials and employees, including those in government-owned or controlled corporations with original charters, taking into account the nature of the responsibilities pertaining to, and the qualifications required for, their positions.\n" +
                        "\n" +
                        "Section 6. No candidate who has lost in any election shall, within one year after such election, be appointed to any office in the Government or any Government-owned or controlled corporations or in any of their subsidiaries.\n" +
                        "\n" +
                        "Section 7. No elective official shall be eligible for appointment or designation in any capacity to any public office or position during his tenure.\n" +
                        "\n" +
                        "Unless otherwise allowed by law or by the primary functions of his position, no appointive official shall hold any other office or employment in the Government or any subdivision, agency or instrumentality thereof, including Government-owned or controlled corporations or their subsidiaries.\n" +
                        "\n" +
                        "Section 8. No elective or appointive public officer or employee shall receive additional, double, or indirect compensation, unless specifically authorized by law, nor accept without the consent of the Congress, any present, emolument, office, or title of any kind from any foreign government.\n" +
                        "\n" +
                        "Pensions or gratuities shall not be considered as additional, double, or indirect compensation.\n" +
                        "\n" +
                        "C. THE COMMISSION ON ELECTIONS\n" +
                        "\n" +
                        "Section 1. (1) There shall be a Commission on Elections composed of a Chairman and six Commissioners who shall be natural-born citizens of the Philippines and, at the time of their appointment, at least thirty-five years of age, holders of a college degree, and must not have been candidates for any elective positions in the immediately preceding elections. However, a majority thereof, including the Chairman, shall be members of the Philippine Bar who have been engaged in the practice of law for at least ten years.\n" +
                        "\n" +
                        "(2) The Chairman and the Commissioners shall be appointed by the President with the consent of the Commission on Appointments for a term of seven years without reappointment. Of those first appointed, three Members shall hold office for seven years, two Members for five years, and the last Members for three years, without reappointment. Appointment to any vacancy shall be only for the unexpired term of the predecessor. In no case shall any Member be appointed or designated in a temporary or acting capacity.\n" +
                        "\n" +
                        "Sec. 2. The Commission on Elections shall exercise the following powers and functions:\n" +
                        "\n" +
                        "(1) Enforce and administer all laws and regulations relative to the conduct of an election, plebiscite, initiative, referendum, and recall.\n" +
                        "\n" +
                        "(2) Exercise exclusive original jurisdiction over all contests relating to the elections, returns, and qualifications of all elective regional, provincial, and city officials, and appellate jurisdiction over all contests involving elective municipal officials decided by trial courts of general jurisdiction, or involving elective barangay officials decided by trial courts of limited jurisdiction.\n" +
                        "\n" +
                        "Decisions, final orders, or rulings of the Commission on election contests involving elective municipal and barangay offices shall be final, executory, and not appealable.\n" +
                        "\n" +
                        "(3) Decide, except those involving the right to vote, all questions affecting elections, including determination of the number and location of polling places, appointment of election officials and inspectors, and registration of voters.\n" +
                        "\n" +
                        "(4) Deputize, with the concurrence of the President, law enforcement agencies and instrumentalities of the Government, including the Armed Forces of the Philippines, for the exclusive purpose of ensuring free, orderly, honest, peaceful, and credible elections.\n" +
                        "\n" +
                        "(5) Register, after sufficient publication, political parties, organizations, or coalitions which, in addition to other requirements, must present their platform or program of government; and accredit citizens’ arms of the Commission on Elections. Religious denominations and sects shall not be registered. Those which seek to achieve their goals through violence or unlawful means, or refuse to uphold and adhere to this Constitution, or which are supported by any foreign government shall likewise be refused registration.\n" +
                        "\n" +
                        "Financial contributions from foreign governments and their agencies to political parties, organizations, coalitions, or candidates related to elections, constitute interference in national affairs, and, when accepted, shall be an additional ground for the cancellation of their registration with the Commission, in addition to other penalties that may be prescribed by law.\n" +
                        "\n" +
                        "(6) File, upon a verified complaint, or on its own initiative, petitions in court for inclusion or exclusion of voters; investigate and, where appropriate, prosecute cases of violations of election laws, including acts or omissions constituting election frauds, offenses, and malpractices.\n" +
                        "\n" +
                        "(7) Recommend to the Congress effective measures to minimize election spending, including limitation of places where propaganda materials shall be posted, and to prevent and penalize all forms of election frauds, offenses, malpractices, and nuisance candidates.\n" +
                        "\n" +
                        "(8) Recommend to the President the removal of any officer or employee it has deputized, or the imposition of any other disciplinary action, for violation or disregard of, or disobedience to, its directive, order, or decision.\n" +
                        "\n" +
                        "(9) Submit to the President and the Congress, a comprehensive report on the conduct of each election, plebiscite, initiative, referendum, or recall.\n" +
                        "\n" +
                        "Section 3. The Commission on Elections may sit en banc or in two divisions, and shall promulgate its rules of procedure in order to expedite disposition of election cases, including pre-proclamation controversies. All such election cases shall be heard and decided in division, provided that motions for reconsideration of decisions shall be decided by the Commission en banc.\n" +
                        "\n" +
                        "Section 4. The Commission may, during the election period, supervise or regulate the enjoyment or utilization of all franchises or permits for the operation of transportation and other public utilities, media of communication or information, all grants, special privileges, or concessions granted by the Government or any subdivision, agency, or instrumentality thereof, including any government-owned or controlled corporation or its subsidiary. Such supervision or regulation shall aim to ensure equal opportunity, time, and space ,and the right to reply, including reasonable, equal rates therefor, for public information campaigns and forums among candidates in connection with the objective of holding free, orderly, honest, peaceful, and credible elections.\n" +
                        "\n" +
                        "Section 5. No pardon, amnesty, parole, or suspension of sentence for violation of election laws, rules, and regulations shall be granted by the President without the favorable recommendation of the Commission.\n" +
                        "\n" +
                        "Section 6. A free and open party system shall be allowed to evolve according to the free choice of the people, subject to the provisions of this Article.\n" +
                        "\n" +
                        "Section 7. No votes cast in favor of a political party, organization, or coalition shall be valid, except for those registered under the party-list system as provided in this Constitution.\n" +
                        "\n" +
                        "Section 8. Political parties, or organizations or coalitions registered under the party-list system, shall not be represented in the voters’ registration boards, boards of election inspectors, boards of canvassers, or other similar bodies. However, they shall be entitled to appoint poll watchers in accordance with law.\n" +
                        "\n" +
                        "Section 9. Unless otherwise fixed by the Commission in special cases, the election period shall commence ninety days before the day of election and shall end thirty days thereafter.\n" +
                        "\n" +
                        "Section 10. Bona fide candidates for any public office shall be free from any form of harassment and discrimination.\n" +
                        "\n" +
                        "Section 11. Funds certified by the Commission as necessary to defray the expenses for holding regular and special elections, plebiscites, initiatives, referenda, and recalls, shall be provided in the regular or special appropriations and, once approved, shall be released automatically upon certification by the Chairman of the Commission.\n" +
                        "\n" +
                        "D. THE COMMISSION ON AUDIT\n" +
                        "Section 1. (1) There shall be a Commission on Audit composed of a Chairman and two Commissioners, who shall be natural-born citizens of the Philippines and, at the time of their appointment, at least thirty-five years of age, Certified Public Accountants with not less than ten years of auditing experience, or members of the Philippine Bar who have been engaged in the practice of law for at least ten years, and must not have been candidates for any elective position in the elections immediately preceding their appointment. At no time shall all Members of the Commission belong to the same profession.\n" +
                        "\n" +
                        "(2) The Chairman and the Commissioners shall be appointed by the President with the consent of the Commission on Appointments for a term of seven years without reappointment. Of those first appointed, the Chairman shall hold office for seven years, one Commissioner for five years, and the other Commissioner for three years, without reappointment. Appointment to any vacancy shall be only for the unexpired portion of the term of the predecessor. In no case shall any Member be appointed or designated in a temporary or acting capacity.\n" +
                        "\n" +
                        "Section 2. (1) The Commission on Audit shall have the power, authority, and duty to examine, audit, and settle all accounts pertaining to the revenue and receipts of, and expenditures or uses of funds and property, owned or held in trust by, or pertaining to, the Government, or any of its subdivisions, agencies, or instrumentalities, including government-owned or controlled corporations with original charters, and on a post-audit basis: (a) constitutional bodies, commissions and offices that have been granted fiscal autonomy under this Constitution; (b) autonomous state colleges and universities; (c) other government-owned or controlled corporations and their subsidiaries; and (d) such non-governmental entities receiving subsidy or equity, directly or indirectly, from or through the Government, which are required by law or the granting institution to submit to such audit as a condition of subsidy or equity. However, where the internal control system of the audited agencies is inadequate, the Commission may adopt such measures, including temporary or special pre-audit, as are necessary and appropriate to correct the deficiencies. It shall keep the general accounts of the Government and, for such period as may be provided by law, preserve the vouchers and other supporting papers pertaining thereto.\n" +
                        "\n" +
                        "(2) The Commission shall have exclusive authority, subject to the limitations in this Article, to define the scope of its audit and examination, establish the techniques and methods required therefor, and promulgate accounting and auditing rules and regulations, including those for the prevention and disallowance of irregular, unnecessary, excessive, extravagant, or unconscionable expenditures or uses of government funds and properties.\n" +
                        "\n" +
                        "Section 3. No law shall be passed exempting any entity of the Government or its subsidiaries in any guise whatever, or any investment of public funds, from the jurisdiction of the Commission on Audit.\n" +
                        "\n" +
                        "Section 4. The Commission shall submit to the President and the Congress, within the time fixed by law, an annual report covering the financial condition and operation of the Government, its subdivisions, agencies, and instrumentalities, including government-owned or controlled corporations, and non-governmental entities subject to its audit, and recommend measures necessary to improve their effectiveness and efficiency. It shall submit such other reports as may be required by law.\n" ,


                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-ix/",
                "https://i.ytimg.com/vi/Cvelg_Qbobc/sddefault.jpg")
        )


        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE X",


                "ARTICLE X\n\n" +

                        "LOCAL GOVERNMENT\n\n" +
                        "Article X of the 1987 Constitution of the Republic of the Philippines outlines provisions related to local government. This article establishes the structure of local government units, emphasizes local autonomy, and introduces the concept of autonomous regions within the Philippines, each with its unique historical and cultural characteristics.\n\n" +


                        "GENERAL PROVISIONS\n" +
                        "\n" +
                        "Section 1. The territorial and political subdivisions of the Republic of the Philippines are the provinces, cities, municipalities, and barangays. There shall be autonomous regions in Muslim Mindanao and the Cordilleras as hereinafter provided.\n" +
                        "\n" +
                        "Section 2. The territorial and political subdivisions shall enjoy local autonomy.\n" +
                        "\n" +
                        "Section 3. The Congress shall enact a local government code which shall provide for a more responsive and accountable local government structure instituted through a system of decentralization with effective mechanisms of recall, initiative, and referendum, allocate among the different local government units their powers, responsibilities, and resources, and provide for the qualifications, election, appointment and removal, term, salaries, powers and functions and duties of local officials, and all other matters relating to the organization and operation of the local units.\n" +
                        "\n" +
                        "Section 4. The President of the Philippines shall exercise general supervision over local governments. Provinces with respect to component cities and municipalities, and cities and municipalities with respect to component barangays, shall ensure that the acts of their component units are within the scope of their prescribed powers and functions.\n" +
                        "\n" +
                        "Section 5. Each local government unit shall have the power to create its own sources of revenues and to levy taxes, fees and charges subject to such guidelines and limitations as the Congress may provide, consistent with the basic policy of local autonomy. Such taxes, fees, and charges shall accrue exclusively to the local governments.\n" +
                        "\n" +
                        "Section 6. Local government units shall have a just share, as determined by law, in the national taxes which shall be automatically released to them.\n" +
                        "\n" +
                        "Section 7. Local governments shall be entitled to an equitable share in the proceeds of the utilization and development of the national wealth within their respective areas, in the manner provided by law, including sharing the same with the inhabitants by way of direct benefits.\n" +
                        "\n" +
                        "Section 8. The term of office of elective local officials, except barangay officials, which shall be determined by law, shall be three years and no such official shall serve for more than three consecutive terms. Voluntary renunciation of the office for any length of time shall not be considered as an interruption in the continuity of his service for the full term for which he was elected.\n" +
                        "\n" +
                        "Section 9. Legislative bodies of local governments shall have sectoral representation as may be prescribed by law.\n" +
                        "\n" +
                        "Section 10. No province, city, municipality, or barangay may be created, divided, merged, abolished, or its boundary substantially altered, except in accordance with the criteria established in the local government code and subject to approval by a majority of the votes cast in a plebiscite in the political units directly affected.\n" +
                        "\n" +
                        "Section 11. The Congress may, by law, create special metropolitan political subdivisions, subject to a plebiscite as set forth in Section 10 hereof. The component cities and municipalities shall retain their basic autonomy and shall be entitled to their own local executive and legislative assemblies. The jurisdiction of the metropolitan authority that will thereby be created shall be limited to basic services requiring coordination.\n" +
                        "\n" +
                        "Section 12. Cities that are highly urbanized, as determined by law, and component cities whose charters prohibit their voters from voting for provincial elective officials, shall be independent of the province. The voters of component cities within a province, whose charters contain no such prohibition, shall not be deprived of their right to vote for elective provincial officials.\n" +
                        "\n" +
                        "Section 13. Local government units may group themselves, consolidate or coordinate their efforts, services, and resources for purposes commonly beneficial to them in accordance with law.\n" +
                        "\n" +
                        "Section 14. The President shall provide for regional development councils or other similar bodies composed of local government officials, regional heads of departments and other government offices, and representatives from non-governmental organizations within the regions for purposes of administrative decentralization to strengthen the autonomy of the units therein and to accelerate the economic and social growth and development of the units in the region.\n" +
                        "\n" +
                        "AUTONOMOUS REGIONS\n" +
                        "\n" +
                        "Section 15. There shall be created autonomous regions in Muslim Mindanao and in the Cordilleras consisting of provinces, cities, municipalities, and geographical areas sharing common and distinctive historical and cultural heritage, economic and social structures, and other relevant characteristics within the framework of this Constitution and the national sovereignty as well as territorial integrity of the Republic of the Philippines.\n" +
                        "\n" +
                        "Section 16. The President shall exercise general supervision over autonomous regions to ensure that laws are faithfully executed.\n" +
                        "\n" +
                        "Section 17. All powers, functions, and responsibilities not granted by this Constitution or by law to the autonomous regions shall be vested in the National Government.\n" +
                        "\n" +
                        "Section 18. The Congress shall enact an organic act for each autonomous region with the assistance and participation of the regional consultative commission composed of representatives appointed by the President from a list of nominees from multisectoral bodies. The organic act shall define the basic structure of government for the region consisting of the executive department and legislative assembly, both of which shall be elective and representative of the constituent political units. The organic acts shall likewise provide for special courts with personal, family, and property law jurisdiction consistent with the provisions of this Constitution and national laws.\n" +
                        "\n" +
                        "The creation of the autonomous region shall be effective when approved by majority of the votes cast by the constituent units in a plebiscite called for the purpose, provided that only provinces, cities, and geographic areas voting favorably in such plebiscite shall be included in the autonomous region.\n" +
                        "\n" +
                        "Section 19. The first Congress elected under this Constitution shall, within eighteen months from the time of organization of both Houses, pass the organic acts for the autonomous regions in Muslim Mindanao and the Cordilleras.\n" +
                        "\n" +
                        "Section 20. Within its territorial jurisdiction and subject to the provisions of this Constitution and national laws, the organic act of autonomous regions shall provide for legislative powers over:\n" +
                        "\n" +
                        "(1) Administrative organization;\n" +
                        "\n" +
                        "(2) Creation of sources of revenues;\n" +
                        "\n" +
                        "(3) Ancestral domain and natural resources;\n" +
                        "\n" +
                        "(4) Personal, family, and property relations;\n" +
                        "\n" +
                        "(5) Regional urban and rural planning development;\n" +
                        "\n" +
                        "(6) Economic, social, and tourism development;\n" +
                        "\n" +
                        "(7) Educational policies;\n" +
                        "\n" +
                        "(8) Preservation and development of the cultural heritage; and\n" +
                        "\n" +
                        "(9) Such other matters as may be authorized by law for the promotion of the general welfare of the people of the region.\n" +
                        "\n" +
                        "Section 21. The preservation of peace and order within the regions shall be the responsibility of the local police agencies which shall be organized, maintained, supervised, and utilized in accordance with applicable laws. The defense and security of the regions shall be the responsibility of the National Government.\n" ,








                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-x/",
                "https://image.slidesharecdn.com/article10-141116025134-conversion-gate02/75/the-1987-constitution-of-the-republic-of-the-philippines-article-x-1-2048.jpg")
        )




        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XI",


                "ARTICLE XI\n\n" +

                        "ACCOUNTABILITY OF PUBLIC OFFICERS\n\n" +
                        "Article XI of the 1987 Constitution of the Republic of the Philippines outlines the principles of accountability for public officers and establishes the mechanisms for their removal in cases of misconduct. It emphasizes the concept that public office is a public trust and that those in public service must serve with integrity, loyalty, and efficiency, with a strong focus on preventing corruption and abuse of power.\n\n" +


                        "Section 1. Public office is a public trust. Public officers and employees must, at all times, be accountable to the people, serve them with utmost responsibility, integrity, loyalty, and efficiency; act with patriotism and justice, and lead modest lives.\n" +
                        "\n" +
                        "Section 2. The President, the Vice-President, the Members of the Supreme Court, the Members of the Constitutional Commissions, and the Ombudsman may be removed from office on impeachment for, and conviction of, culpable violation of the Constitution, treason, bribery, graft and corruption, other high crimes, or betrayal of public trust. All other public officers and employees may be removed from office as provided by law, but not by impeachment.\n" +
                        "\n" +
                        "Section 3. (1) The House of Representatives shall have the exclusive power to initiate all cases of impeachment.\n" +
                        "\n" +
                        "(2) A verified complaint for impeachment may be filed by any Member of the House of Representatives or by any citizen upon a resolution or endorsement by any Member thereof, which shall be included in the Order of Business within ten session days, and referred to the proper Committee within three session days thereafter. The Committee, after hearing, and by a majority vote of all its Members, shall submit its report to the House within sixty session days from such referral, together with the corresponding resolution. The resolution shall be calendared for consideration by the House within ten session days from receipt thereof.\n" +
                        "\n" +
                        "(3) A vote of at least one-third of all the Members of the House shall be necessary either to affirm a favorable resolution with the Articles of Impeachment of the Committee, or override its contrary resolution. The vote of each Member shall be recorded.\n" +
                        "\n" +
                        "(4) In case the verified complaint or resolution of impeachment is filed by at least one-third of all the Members of the House, the same shall constitute the Articles of Impeachment, and trial by the Senate shall forthwith proceed.\n" +
                        "\n" +
                        "(5) No impeachment proceedings shall be initiated against the same official more than once within a period of one year.\n" +
                        "\n" +
                        "(6) The Senate shall have the sole power to try and decide all cases of impeachment. When sitting for that purpose, the Senators shall be on oath or affirmation. When the President of the Philippines is on trial, the Chief Justice of the Supreme Court shall preside, but shall not vote. No person shall be convicted without the concurrence of two-thirds of all the Members of the Senate.\n" +
                        "\n" +
                        "(7) Judgment in cases of impeachment shall not extend further than removal from office and disqualification to hold any office under the Republic of the Philippines, but the party convicted shall nevertheless be liable and subject to prosecution, trial, and punishment, according to law.\n" +
                        "\n" +
                        "(8) The Congress shall promulgate its rules on impeachment to effectively carry out the purpose of this section.\n" +
                        "\n" +
                        "Section 4. The present anti-graft court known as the Sandiganbayan shall continue to function and exercise its jurisdiction as now or hereafter may be provided by law.\n" +
                        "\n" +
                        "Section 5. There is hereby created the independent Office of the Ombudsman, composed of the Ombudsman to be known as Tanodbayan, one overall Deputy and at least one Deputy each for Luzon, Visayas, and Mindanao. A separate Deputy for the military establishment may likewise be appointed.\n" +
                        "\n" +
                        "Section 6. The officials and employees of the Office of the Ombudsman, other than the Deputies, shall be appointed by the Ombudsman, according to the Civil Service Law.\n" +
                        "\n" +
                        "Section 7. The existing Tanodbayan shall hereafter be known as the Office of the Special Prosecutor. It shall continue to function and exercise its powers as now or hereafter may be provided by law, except those conferred on the Office of the Ombudsman created under this Constitution.\n" +
                        "\n" +
                        "Section 8. The Ombudsman and his Deputies shall be natural-born citizens of the Philippines, and at the time of their appointment, at least forty years old, of recognized probity and independence, and members of the Philippine Bar, and must not have been candidates for any elective office in the immediately preceding election. The Ombudsman must have, for ten years or more, been a judge or engaged in the practice of law in the Philippines.\n" +
                        "\n" +
                        "During their tenure, they shall be subject to the same disqualifications and prohibitions as provided for in Section 2 of Article IX-A of this Constitution.\n" +
                        "\n" +
                        "Section 9. The Ombudsman and his Deputies shall be appointed by the President from a list of at least six nominees prepared by the Judicial and Bar Council, and from a list of three nominees for every vacancy thereafter. Such appointments shall require no confirmation. All vacancies shall be filled within three months after they occur.\n" +
                        "\n" +
                        "Section 10. The Ombudsman and his Deputies shall have the rank of Chairman and Members, respectively, of the Constitutional Commissions, and they shall receive the same salary which shall not be decreased during their term of office.\n" +
                        "\n" +
                        "Section 11. The Ombudsman and his Deputies shall serve for a term of seven years without reappointment. They shall not be qualified to run for any office in the election immediately succeeding their cessation from office.\n" +
                        "\n" +
                        "Section 12. The Ombudsman and his Deputies, as protectors of the people, shall act promptly on complaints filed in any form or manner against public officials or employees of the Government, or any subdivision, agency or instrumentality thereof, including government-owned or controlled corporations, and shall, in appropriate cases, notify the complainants of the action taken and the result thereof.\n" +
                        "\n" +
                        "Section 13. The Office of the Ombudsman shall have the following powers, functions, and duties:\n" +
                        "\n" +
                        "(1) Investigate on its own, or on complaint by any person, any act or omission of any public official, employee, office or agency, when such act or omission appears to be illegal, unjust, improper, or inefficient.\n" +
                        "\n" +
                        "(2) Direct, upon complaint or at its own instance, any public official or employee of the Government, or any subdivision, agency or instrumentality thereof, as well as of any government-owned or controlled corporation with original charter, to perform and expedite any act or duty required by law, or to stop, prevent, and correct any abuse or impropriety in the performance of duties.\n" +
                        "\n" +
                        "(3) Direct the officer concerned to take appropriate action against a public official or employee at fault, and recommend his removal, suspension, demotion, fine, censure, or prosecution, and ensure compliance therewith.\n" +
                        "\n" +
                        "(4) Direct the officer concerned, in any appropriate case, and subject to such limitations as may be provided by law, to furnish it with copies of documents relating to contracts or transactions entered into by his office involving the disbursement or use of public funds or properties, and report any irregularity to the Commission on Audit for appropriate action.\n" +
                        "\n" +
                        "(5) Request any government agency for assistance and information necessary in the discharge of its responsibilities, and to examine, if necessary, pertinent records and documents.\n" +
                        "\n" +
                        "(6) Publicize matters covered by its investigation when circumstances so warrant and with due prudence.\n" +
                        "\n" +
                        "(7) Determine the causes of inefficiency, red tape, mismanagement, fraud, and corruption in the Government and make recommendations for their elimination and the observance of high standards of ethics and efficiency.\n" +
                        "\n" +
                        "(8) Promulgate its rules of procedure and exercise such other powers or perform such functions or duties as may be provided by law.\n" +
                        "\n" +
                        "Section 14. The Office of the Ombudsman shall enjoy fiscal autonomy. Its approved annual appropriations shall be automatically and regularly released.\n" +
                        "\n" +
                        "Section 15. The right of the State to recover properties unlawfully acquired by public officials or employees, from them or from their nominees or transferees, shall not be barred by prescription, laches, or estoppel.\n" +
                        "\n" +
                        "Section 16. No loan, guaranty, or other form of financial accommodation for any business purpose may be granted, directly or indirectly, by any government-owned or controlled bank or financial institution to the President, the Vice-President, the Members of the Cabinet, the Congress, the Supreme Court, and the Constitutional Commissions, the Ombudsman, or to any firm or entity in which they have controlling interest, during their tenure.\n" +
                        "\n" +
                        "Section 17. A public officer or employee shall, upon assumption of office and as often thereafter as may be required by law, submit a declaration under oath of his assets, liabilities, and net worth. In the case of the President, the Vice-President, the Members of the Cabinet, the Congress, the Supreme Court, the Constitutional Commissions and other constitutional offices, and officers of the armed forces with general or flag rank, the declaration shall be disclosed to the public in the manner provided by law.\n" +
                        "\n" +
                        "Section 18. Public officers and employees owe the State and this Constitution allegiance at all times and any public officer or employee who seeks to change his citizenship or acquire the status of an immigrant of another country during his tenure shall be dealt with by law.\n" ,

                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xi/",
                "https://i.ytimg.com/vi/3R-yVSsR0zQ/maxresdefault.jpg")
        )



        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XII",


                "ARTICLE XII\n\n" +

                        "NATIONAL ECONOMY AND PATRIMONY\n\n" +
                        "Article XI of the 1987 Constitution of the Republic of the Philippines outlines the principles of accountability for public officers and establishes the mechanisms for their removal in cases of misconduct. It emphasizes the concept that public office is a public trust and that those in public service must serve with integrity, loyalty, and efficiency, with a strong focus on preventing corruption and abuse of power.\n\n" +


                        "Section 1. The goals of the national economy are a more equitable distribution of opportunities, income, and wealth; a sustained increase in the amount of goods and services produced by the nation for the benefit of the people; and an expanding productivity as the key to raising the quality of life for all, especially the underprivileged.\n" +
                        "\n" +
                        "The State shall promote industrialization and full employment based on sound agricultural development and agrarian reform, through industries that make full and efficient use of human and natural resources, and which are competitive in both domestic and foreign markets. However, the State shall protect Filipino enterprises against unfair foreign competition and trade practices.\n" +
                        "\n" +
                        "In the pursuit of these goals, all sectors of the economy and all regions of the country shall be given optimum opportunity to develop. Private enterprises, including corporations, cooperatives, and similar collective organizations, shall be encouraged to broaden the base of their ownership.\n" +
                        "\n" +
                        "Section 2. All lands of the public domain, waters, minerals, coal, petroleum, and other mineral oils, all forces of potential energy, fisheries, forests or timber, wildlife, flora and fauna, and other natural resources are owned by the State. With the exception of agricultural lands, all other natural resources shall not be alienated. The exploration, development, and utilization of natural resources shall be under the full control and supervision of the State. The State may directly undertake such activities, or it may enter into co-production, joint venture, or production-sharing agreements with Filipino citizens, or corporations or associations at least sixty per centum of whose capital is owned by such citizens. Such agreements may be for a period not exceeding twenty-five years, renewable for not more than twenty-five years, and under such terms and conditions as may be provided by law. In cases of water rights for irrigation, water supply fisheries, or industrial uses other than the development of water power, beneficial use may be the measure and limit of the grant.\n" +
                        "\n" +
                        "The State shall protect the nation’s marine wealth in its archipelagic waters, territorial sea, and exclusive economic zone, and reserve its use and enjoyment exclusively to Filipino citizens.\n" +
                        "\n" +
                        "The Congress may, by law, allow small-scale utilization of natural resources by Filipino citizens, as well as cooperative fish farming, with priority to subsistence fishermen and fishworkers in rivers, lakes, bays, and lagoons.\n" +
                        "\n" +
                        "The President may enter into agreements with foreign-owned corporations involving either technical or financial assistance for large-scale exploration, development, and utilization of minerals, petroleum, and other mineral oils according to the general terms and conditions provided by law, based on real contributions to the economic growth and general welfare of the country. In such agreements, the State shall promote the development and use of local scientific and technical resources.\n" +
                        "\n" +
                        "The President shall notify the Congress of every contract entered into in accordance with this provision, within thirty days from its execution.\n" +
                        "\n" +
                        "Section 3. Lands of the public domain are classified into agricultural, forest or timber, mineral lands and national parks. Agricultural lands of the public domain may be further classified by law according to the uses to which they may be devoted. Alienable lands of the public domain shall be limited to agricultural lands. Private corporations or associations may not hold such alienable lands of the public domain except by lease, for a period not exceeding twenty-five years, renewable for not more than twenty-five years, and not to exceed one thousand hectares in area. Citizens of the Philippines may lease not more than five hundred hectares, or acquire not more than twelve hectares thereof, by purchase, homestead, or grant.\n" +
                        "\n" +
                        "Taking into account the requirements of conservation, ecology, and development, and subject to the requirements of agrarian reform, the Congress shall determine, by law, the size of lands of the public domain which may be acquired, developed, held, or leased and the conditions therefor.\n" +
                        "\n" +
                        "Section 4. The Congress shall, as soon as possible, determine, by law, the specific limits of forest lands and national parks, marking clearly their boundaries on the ground. Thereafter, such forest lands and national parks shall be conserved and may not be increased nor diminished, except by law. The Congress shall provide for such period as it may determine, measures to prohibit logging in endangered forests and watershed areas.\n" +
                        "\n" +
                        "Section 5. The State, subject to the provisions of this Constitution and national development policies and programs, shall protect the rights of indigenous cultural communities to their ancestral lands to ensure their economic, social, and cultural well-being.\n" +
                        "\n" +
                        "The Congress may provide for the applicability of customary laws governing property rights or relations in determining the ownership and extent of ancestral domain.\n" +
                        "\n" +
                        "Section 6. The use of property bears a social function, and all economic agents shall contribute to the common good. Individuals and private groups, including corporations, cooperatives, and similar collective organizations, shall have the right to own, establish, and operate economic enterprises, subject to the duty of the State to promote distributive justice and to intervene when the common good so demands.\n" +
                        "\n" +
                        "Section 7. Save in cases of hereditary succession, no private lands shall be transferred or conveyed except to individuals, corporations, or associations qualified to acquire or hold lands of the public domain.\n" +
                        "\n" +
                        "Section 8. Notwithstanding the provisions of Section 7 of this Article, a natural-born citizen of the Philippines who has lost his Philippine citizenship may be a transferee of private lands, subject to limitations provided by law.\n" +
                        "\n" +
                        "Section 9. The Congress may establish an independent economic and planning agency headed by the President, which shall, after consultations with the appropriate public agencies, various private sectors, and local government units, recommend to Congress, and implement continuing integrated and coordinated programs and policies for national development.\n" +
                        "\n" +
                        "Until the Congress provides otherwise, the National Economic and Development Authority shall function as the independent planning agency of the government.\n" +
                        "\n" +
                        "Section 10. The Congress shall, upon recommendation of the economic and planning agency, when the national interest dictates, reserve to citizens of the Philippines or to corporations or associations at least sixty per centum of whose capital is owned by such citizens, or such higher percentage as Congress may prescribe, certain areas of investments. The Congress shall enact measures that will encourage the formation and operation of enterprises whose capital is wholly owned by Filipinos.\n" +
                        "\n" +
                        "In the grant of rights, privileges, and concessions covering the national economy and patrimony, the State shall give preference to qualified Filipinos.\n" +
                        "\n" +
                        "The State shall regulate and exercise authority over foreign investments within its national jurisdiction and in accordance with its national goals and priorities.\n" +
                        "\n" +
                        "Section 11. No franchise, certificate, or any other form of authorization for the operation of a public utility shall be granted except to citizens of the Philippines or to corporations or associations organized under the laws of the Philippines, at least sixty per centum of whose capital is owned by such citizens; nor shall such franchise, certificate, or authorization be exclusive in character or for a longer period than fifty years. Neither shall any such franchise or right be granted except under the condition that it shall be subject to amendment, alteration, or repeal by the Congress when the common good so requires. The State shall encourage equity participation in public utilities by the general public. The participation of foreign investors in the governing body of any public utility enterprise shall be limited to their proportionate share in its capital, and all the executive and managing officers of such corporation or association must be citizens of the Philippines.\n" +
                        "\n" +
                        "Section 12. The State shall promote the preferential use of Filipino labor, domestic materials and locally produced goods, and adopt measures that help make them competitive.\n" +
                        "\n" +
                        "Section 13. The State shall pursue a trade policy that serves the general welfare and utilizes all forms and arrangements of exchange on the basis of equality and reciprocity.\n" +
                        "\n" +
                        "Section 14. The sustained development of a reservoir of national talents consisting of Filipino scientists, entrepreneurs, professionals, managers, high-level technical manpower and skilled workers and craftsmen in all fields shall be promoted by the State. The State shall encourage appropriate technology and regulate its transfer for the national benefit.\n" +
                        "\n" +
                        "The practice of all professions in the Philippines shall be limited to Filipino citizens, save in cases prescribed by law.\n" +
                        "\n" +
                        "Section 15. The Congress shall create an agency to promote the viability and growth of cooperatives as instruments for social justice and economic development.\n" +
                        "\n" +
                        "Section 16. The Congress shall not, except by general law, provide for the formation, organization, or regulation of private corporations. Government-owned or controlled corporations may be created or established by special charters in the interest of the common good and subject to the test of economic viability.\n" +
                        "\n" +
                        "Section 17. In times of national emergency, when the public interest so requires, the State may, during the emergency and under reasonable terms prescribed by it, temporarily take over or direct the operation of any privately-owned public utility or business affected with public interest.\n" +
                        "\n" +
                        "Section 18. The State may, in the interest of national welfare or defense, establish and operate vital industries and, upon payment of just compensation, transfer to public ownership utilities and other private enterprises to be operated by the Government.\n" +
                        "\n" +
                        "Section 19. The State shall regulate or prohibit monopolies when the public interest so requires. No combinations in restraint of trade or unfair competition shall be allowed.\n" +
                        "\n" +
                        "Section 20. The Congress shall establish an independent central monetary authority, the members of whose governing board must be natural-born Filipino citizens, of known probity, integrity, and patriotism, the majority of whom shall come from the private sector. They shall also be subject to such other qualifications and disabilities as may be prescribed by law. The authority shall provide policy direction in the areas of money, banking, and credit. It shall have supervision over the operations of banks and exercise such regulatory powers as may be provided by law over the operations of finance companies and other institutions performing similar functions.\n" +
                        "\n" +
                        "Until the Congress otherwise provides, the Central Bank of the Philippines operating under existing laws, shall function as the central monetary authority.\n" +
                        "\n" +
                        "Section 21. Foreign loans may only be incurred in accordance with law and the regulation of the monetary authority. Information on foreign loans obtained or guaranteed by the Government shall be made available to the public.\n" +
                        "\n" +
                        "Section 22. Acts which circumvent or negate any of the provisions of this Article shall be considered inimical to the national interest and subject to criminal and civil sanctions, as may be provided by law.\n" ,



                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xii/",
                "https://i.ytimg.com/vi/RClqVnAPyxc/sddefault.jpg")
        )


        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XII",


                "ARTICLE XII\n\n" +

                        "NATIONAL ECONOMY AND PATRIMONY\n\n" +
                        "Article XI of the 1987 Constitution of the Republic of the Philippines outlines the principles of accountability for public officers and establishes the mechanisms for their removal in cases of misconduct. It emphasizes the concept that public office is a public trust and that those in public service must serve with integrity, loyalty, and efficiency, with a strong focus on preventing corruption and abuse of power.\n\n" +


                        "Section 1. The goals of the national economy are a more equitable distribution of opportunities, income, and wealth; a sustained increase in the amount of goods and services produced by the nation for the benefit of the people; and an expanding productivity as the key to raising the quality of life for all, especially the underprivileged.\n" +
                        "\n" +
                        "The State shall promote industrialization and full employment based on sound agricultural development and agrarian reform, through industries that make full and efficient use of human and natural resources, and which are competitive in both domestic and foreign markets. However, the State shall protect Filipino enterprises against unfair foreign competition and trade practices.\n" +
                        "\n" +
                        "In the pursuit of these goals, all sectors of the economy and all regions of the country shall be given optimum opportunity to develop. Private enterprises, including corporations, cooperatives, and similar collective organizations, shall be encouraged to broaden the base of their ownership.\n" +
                        "\n" +
                        "Section 2. All lands of the public domain, waters, minerals, coal, petroleum, and other mineral oils, all forces of potential energy, fisheries, forests or timber, wildlife, flora and fauna, and other natural resources are owned by the State. With the exception of agricultural lands, all other natural resources shall not be alienated. The exploration, development, and utilization of natural resources shall be under the full control and supervision of the State. The State may directly undertake such activities, or it may enter into co-production, joint venture, or production-sharing agreements with Filipino citizens, or corporations or associations at least sixty per centum of whose capital is owned by such citizens. Such agreements may be for a period not exceeding twenty-five years, renewable for not more than twenty-five years, and under such terms and conditions as may be provided by law. In cases of water rights for irrigation, water supply fisheries, or industrial uses other than the development of water power, beneficial use may be the measure and limit of the grant.\n" +
                        "\n" +
                        "The State shall protect the nation’s marine wealth in its archipelagic waters, territorial sea, and exclusive economic zone, and reserve its use and enjoyment exclusively to Filipino citizens.\n" +
                        "\n" +
                        "The Congress may, by law, allow small-scale utilization of natural resources by Filipino citizens, as well as cooperative fish farming, with priority to subsistence fishermen and fishworkers in rivers, lakes, bays, and lagoons.\n" +
                        "\n" +
                        "The President may enter into agreements with foreign-owned corporations involving either technical or financial assistance for large-scale exploration, development, and utilization of minerals, petroleum, and other mineral oils according to the general terms and conditions provided by law, based on real contributions to the economic growth and general welfare of the country. In such agreements, the State shall promote the development and use of local scientific and technical resources.\n" +
                        "\n" +
                        "The President shall notify the Congress of every contract entered into in accordance with this provision, within thirty days from its execution.\n" +
                        "\n" +
                        "Section 3. Lands of the public domain are classified into agricultural, forest or timber, mineral lands and national parks. Agricultural lands of the public domain may be further classified by law according to the uses to which they may be devoted. Alienable lands of the public domain shall be limited to agricultural lands. Private corporations or associations may not hold such alienable lands of the public domain except by lease, for a period not exceeding twenty-five years, renewable for not more than twenty-five years, and not to exceed one thousand hectares in area. Citizens of the Philippines may lease not more than five hundred hectares, or acquire not more than twelve hectares thereof, by purchase, homestead, or grant.\n" +
                        "\n" +
                        "Taking into account the requirements of conservation, ecology, and development, and subject to the requirements of agrarian reform, the Congress shall determine, by law, the size of lands of the public domain which may be acquired, developed, held, or leased and the conditions therefor.\n" +
                        "\n" +
                        "Section 4. The Congress shall, as soon as possible, determine, by law, the specific limits of forest lands and national parks, marking clearly their boundaries on the ground. Thereafter, such forest lands and national parks shall be conserved and may not be increased nor diminished, except by law. The Congress shall provide for such period as it may determine, measures to prohibit logging in endangered forests and watershed areas.\n" +
                        "\n" +
                        "Section 5. The State, subject to the provisions of this Constitution and national development policies and programs, shall protect the rights of indigenous cultural communities to their ancestral lands to ensure their economic, social, and cultural well-being.\n" +
                        "\n" +
                        "The Congress may provide for the applicability of customary laws governing property rights or relations in determining the ownership and extent of ancestral domain.\n" +
                        "\n" +
                        "Section 6. The use of property bears a social function, and all economic agents shall contribute to the common good. Individuals and private groups, including corporations, cooperatives, and similar collective organizations, shall have the right to own, establish, and operate economic enterprises, subject to the duty of the State to promote distributive justice and to intervene when the common good so demands.\n" +
                        "\n" +
                        "Section 7. Save in cases of hereditary succession, no private lands shall be transferred or conveyed except to individuals, corporations, or associations qualified to acquire or hold lands of the public domain.\n" +
                        "\n" +
                        "Section 8. Notwithstanding the provisions of Section 7 of this Article, a natural-born citizen of the Philippines who has lost his Philippine citizenship may be a transferee of private lands, subject to limitations provided by law.\n" +
                        "\n" +
                        "Section 9. The Congress may establish an independent economic and planning agency headed by the President, which shall, after consultations with the appropriate public agencies, various private sectors, and local government units, recommend to Congress, and implement continuing integrated and coordinated programs and policies for national development.\n" +
                        "\n" +
                        "Until the Congress provides otherwise, the National Economic and Development Authority shall function as the independent planning agency of the government.\n" +
                        "\n" +
                        "Section 10. The Congress shall, upon recommendation of the economic and planning agency, when the national interest dictates, reserve to citizens of the Philippines or to corporations or associations at least sixty per centum of whose capital is owned by such citizens, or such higher percentage as Congress may prescribe, certain areas of investments. The Congress shall enact measures that will encourage the formation and operation of enterprises whose capital is wholly owned by Filipinos.\n" +
                        "\n" +
                        "In the grant of rights, privileges, and concessions covering the national economy and patrimony, the State shall give preference to qualified Filipinos.\n" +
                        "\n" +
                        "The State shall regulate and exercise authority over foreign investments within its national jurisdiction and in accordance with its national goals and priorities.\n" +
                        "\n" +
                        "Section 11. No franchise, certificate, or any other form of authorization for the operation of a public utility shall be granted except to citizens of the Philippines or to corporations or associations organized under the laws of the Philippines, at least sixty per centum of whose capital is owned by such citizens; nor shall such franchise, certificate, or authorization be exclusive in character or for a longer period than fifty years. Neither shall any such franchise or right be granted except under the condition that it shall be subject to amendment, alteration, or repeal by the Congress when the common good so requires. The State shall encourage equity participation in public utilities by the general public. The participation of foreign investors in the governing body of any public utility enterprise shall be limited to their proportionate share in its capital, and all the executive and managing officers of such corporation or association must be citizens of the Philippines.\n" +
                        "\n" +
                        "Section 12. The State shall promote the preferential use of Filipino labor, domestic materials and locally produced goods, and adopt measures that help make them competitive.\n" +
                        "\n" +
                        "Section 13. The State shall pursue a trade policy that serves the general welfare and utilizes all forms and arrangements of exchange on the basis of equality and reciprocity.\n" +
                        "\n" +
                        "Section 14. The sustained development of a reservoir of national talents consisting of Filipino scientists, entrepreneurs, professionals, managers, high-level technical manpower and skilled workers and craftsmen in all fields shall be promoted by the State. The State shall encourage appropriate technology and regulate its transfer for the national benefit.\n" +
                        "\n" +
                        "The practice of all professions in the Philippines shall be limited to Filipino citizens, save in cases prescribed by law.\n" +
                        "\n" +
                        "Section 15. The Congress shall create an agency to promote the viability and growth of cooperatives as instruments for social justice and economic development.\n" +
                        "\n" +
                        "Section 16. The Congress shall not, except by general law, provide for the formation, organization, or regulation of private corporations. Government-owned or controlled corporations may be created or established by special charters in the interest of the common good and subject to the test of economic viability.\n" +
                        "\n" +
                        "Section 17. In times of national emergency, when the public interest so requires, the State may, during the emergency and under reasonable terms prescribed by it, temporarily take over or direct the operation of any privately-owned public utility or business affected with public interest.\n" +
                        "\n" +
                        "Section 18. The State may, in the interest of national welfare or defense, establish and operate vital industries and, upon payment of just compensation, transfer to public ownership utilities and other private enterprises to be operated by the Government.\n" +
                        "\n" +
                        "Section 19. The State shall regulate or prohibit monopolies when the public interest so requires. No combinations in restraint of trade or unfair competition shall be allowed.\n" +
                        "\n" +
                        "Section 20. The Congress shall establish an independent central monetary authority, the members of whose governing board must be natural-born Filipino citizens, of known probity, integrity, and patriotism, the majority of whom shall come from the private sector. They shall also be subject to such other qualifications and disabilities as may be prescribed by law. The authority shall provide policy direction in the areas of money, banking, and credit. It shall have supervision over the operations of banks and exercise such regulatory powers as may be provided by law over the operations of finance companies and other institutions performing similar functions.\n" +
                        "\n" +
                        "Until the Congress otherwise provides, the Central Bank of the Philippines operating under existing laws, shall function as the central monetary authority.\n" +
                        "\n" +
                        "Section 21. Foreign loans may only be incurred in accordance with law and the regulation of the monetary authority. Information on foreign loans obtained or guaranteed by the Government shall be made available to the public.\n" +
                        "\n" +
                        "Section 22. Acts which circumvent or negate any of the provisions of this Article shall be considered inimical to the national interest and subject to criminal and civil sanctions, as may be provided by law.\n" ,



                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xii/",
                "https://i.ytimg.com/vi/RClqVnAPyxc/sddefault.jpg")
        )

        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XIII",


                "ARTICLE XIII\n\n" +

                        "SOCIAL JUSTICE AND HUMAN RIGHTS\n\n" +
                        "Article XIII of the 1987 Constitution of the Republic of the Philippines is dedicated to the principles of social justice and human rights. It outlines the state's commitment to promoting equitable economic opportunities, labor protection, agrarian and natural resources reform, urban land reform and housing, healthcare, and the safeguarding of human rights, reflecting the nation's dedication to improving the well-being and rights of its citizens.\n\n" +



                        "\n" +
                        "Section 1. The Congress shall give highest priority to the enactment of measures that protect and enhance the right of all the people to human dignity, reduce social, economic, and political inequalities, and remove cultural inequities by equitably diffusing wealth and political power for the common good.\n" +
                        "\n" +
                        "To this end, the State shall regulate the acquisition, ownership, use, and disposition of property and its increments.\n" +
                        "\n" +
                        "Section 2. The promotion of social justice shall include the commitment to create economic opportunities based on freedom of initiative and self-reliance.\n" +
                        "\n" +
                        "LABOR\n" +
                        "\n" +
                        "Section 3. The State shall afford full protection to labor, local and overseas, organized and unorganized, and promote full employment and equality of employment opportunities for all.\n" +
                        "\n" +
                        "It shall guarantee the rights of all workers to self-organization, collective bargaining and negotiations, and peaceful concerted activities, including the right to strike in accordance with law. They shall be entitled to security of tenure, humane conditions of work, and a living wage. They shall also participate in policy and decision-making processes affecting their rights and benefits as may be provided by law.\n" +
                        "\n" +
                        "The State shall promote the principle of shared responsibility between workers and employers and the preferential use of voluntary modes in settling disputes, including conciliation, and shall enforce their mutual compliance therewith to foster industrial peace.\n" +
                        "\n" +
                        "The State shall regulate the relations between workers and employers, recognizing the right of labor to its just share in the fruits of production and the right of enterprises to reasonable returns to investments, and to expansion and growth.\n" +
                        "\n" +
                        "AGRARIAN AND NATURAL RESOURCES REFORM\n" +
                        "\n" +
                        "Section 4. The State shall, by law, undertake an agrarian reform program founded on the right of farmers and regular farmworkers who are landless, to own directly or collectively the lands they till or, in the case of other farmworkers, to receive a just share of the fruits thereof. To this end, the State shall encourage and undertake the just distribution of all agricultural lands, subject to such priorities and reasonable retention limits as the Congress may prescribe, taking into account ecological, developmental, or equity considerations, and subject to the payment of just compensation. In determining retention limits, the State shall respect the right of small landowners. The State shall further provide incentives for voluntary land-sharing.\n" +
                        "\n" +
                        "Section 5. The State shall recognize the right of farmers, farmworkers, and landowners, as well as cooperatives, and other independent farmers’ organizations to participate in the planning, organization, and management of the program, and shall provide support to agriculture through appropriate technology and research, and adequate financial, production, marketing, and other support services.\n" +
                        "\n" +
                        "Section 6. The State shall apply the principles of agrarian reform or stewardship, whenever applicable in accordance with law, in the disposition or utilization of other natural resources, including lands of the public domain under lease or concession suitable to agriculture, subject to prior rights, homestead rights of small settlers, and the rights of indigenous communities to their ancestral lands.\n" +
                        "\n" +
                        "The State may resettle landless farmers and farmworkers in its own agricultural estates which shall be distributed to them in the manner provided by law.\n" +
                        "\n" +
                        "Section 7. The State shall protect the rights of subsistence fishermen, especially of local communities, to the preferential use of the communal marine and fishing resources, both inland and offshore. It shall provide support to such fishermen through appropriate technology and research, adequate financial, production, and marketing assistance, and other services. The State shall also protect, develop, and conserve such resources. The protection shall extend to offshore fishing grounds of subsistence fishermen against foreign intrusion. Fishworkers shall receive a just share from their labor in the utilization of marine and fishing resources.\n" +
                        "\n" +
                        "Section 8. The State shall provide incentives to landowners to invest the proceeds of the agrarian reform program to promote industrialization, employment creation, and privatization of public sector enterprises. Financial instruments used as payment for their lands shall be honored as equity in enterprises of their choice.\n" +
                        "\n" +
                        "URBAN LAND REFORM AND HOUSING\n" +
                        "\n" +
                        "Section 9. The State shall, by law, and for the common good, undertake, in cooperation with the private sector, a continuing program of urban land reform and housing which will make available at affordable cost, decent housing and basic services to underprivileged and homeless citizens in urban centers and resettlement areas. It shall also promote adequate employment opportunities to such citizens. In the implementation of such program the State shall respect the rights of small property owners.\n" +
                        "\n" +
                        "Section 10. Urban or rural poor dwellers shall not be evicted nor their dwelling demolished, except in accordance with law and in a just and humane manner.\n" +
                        "\n" +
                        "No resettlement of urban or rural dwellers shall be undertaken without adequate consultation with them and the communities where they are to be relocated.\n" +
                        "\n" +
                        "HEALTH\n" +
                        "\n" +
                        "Section 11. The State shall adopt an integrated and comprehensive approach to health development which shall endeavor to make essential goods, health and other social services available to all the people at affordable cost. There shall be priority for the needs of the underprivileged, sick, elderly, disabled, women, and children. The State shall endeavor to provide free medical care to paupers.\n" +
                        "\n" +
                        "Section 12. The State shall establish and maintain an effective food and drug regulatory system and undertake appropriate health, manpower development, and research, responsive to the country’s health needs and problems.\n" +
                        "\n" +
                        "Section 13. The State shall establish a special agency for disabled persons for their rehabilitation, self-development, and self-reliance, and their integration into the mainstream of society.\n" +
                        "\n" +
                        "WOMEN\n" +
                        "\n" +
                        "Section 14. The State shall protect working women by providing safe and healthful working conditions, taking into account their maternal functions, and such facilities and opportunities that will enhance their welfare and enable them to realize their full potential in the service of the nation.\n" +
                        "\n" +
                        "ROLE AND RIGHTS OF PEOPLE’S ORGANIZATIONS\n" +
                        "\n" +
                        "Section 15. The State shall respect the role of independent people’s organizations to enable the people to pursue and protect, within the democratic framework, their legitimate and collective interests and aspirations through peaceful and lawful means.\n" +
                        "\n" +
                        "People’s organizations are bona fide associations of citizens with demonstrated capacity to promote the public interest and with identifiable leadership, membership, and structure.\n" +
                        "\n" +
                        "Section 16. The right of the people and their organizations to effective and reasonable participation at all levels of social, political, and economic decision-making shall not be abridged. The State shall, by law, facilitate the establishment of adequate consultation mechanisms.\n" +
                        "\n" +
                        "HUMAN RIGHTS\n" +
                        "\n" +
                        "Section 17. (1) There is hereby created an independent office called the Commission on Human Rights.\n" +
                        "\n" +
                        "(2) The Commission shall be composed of a Chairman and four Members who must be natural-born citizens of the Philippines and a majority of whom shall be members of the Bar. The term of office and other qualifications and disabilities of the Members of the Commission shall be provided by law.\n" +
                        "\n" +
                        "(3) Until this Commission is constituted, the existing Presidential Committee on Human Rights shall continue to exercise its present functions and powers.\n" +
                        "\n" +
                        "(4) The approved annual appropriations of the Commission shall be automatically and regularly released.\n" +
                        "\n" +
                        "Section 18. The Commission on Human Rights shall have the following powers and functions:\n" +
                        "\n" +
                        "(1) Investigate, on its own or on complaint by any party, all forms of human rights violations involving civil and political rights;\n" +
                        "\n" +
                        "(2) Adopt its operational guidelines and rules of procedure, and cite for contempt for violations thereof in accordance with the Rules of Court;\n" +
                        "\n" +
                        "(3) Provide appropriate legal measures for the protection of human rights of all persons within the Philippines, as well as Filipinos residing abroad, and provide for preventive measures and legal aid services to the underprivileged whose human rights have been violated or need protection;\n" +
                        "\n" +
                        "(4) Exercise visitorial powers over jails, prisons, or detention facilities;\n" +
                        "\n" +
                        "(5) Establish a continuing program of research, education, and information to enhance respect for the primacy of human rights;\n" +
                        "\n" +
                        "(6) Recommend to Congress effective measures to promote human rights and to provide for compensation to victims of violations of human rights, or their families;\n" +
                        "\n" +
                        "(7) Monitor the Philippine Government’s compliance with international treaty obligations on human rights;\n" +
                        "\n" +
                        "(8) Grant immunity from prosecution to any person whose testimony or whose possession of documents or other evidence is necessary or convenient to determine the truth in any investigation conducted by it or under its authority;\n" +
                        "\n" +
                        "(9) Request the assistance of any department, bureau, office, or agency in the performance of its functions;\n" +
                        "\n" +
                        "(10) Appoint its officers and employees in accordance with law; and\n" +
                        "\n" +
                        "(11) Perform such other duties and functions as may be provided by law.\n" +
                        "\n" +
                        "Section 19. The Congress may provide for other cases of violations of human rights that should fall within the authority of the Commission, taking into account its recommendations.\n",







                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xiii/",
                "https://i.ytimg.com/vi/1ho4cYTzd1A/sddefault.jpg")
        )



        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XIII",


                "ARTICLE XIII\n\n" +

                        "SOCIAL JUSTICE AND HUMAN RIGHTS\n\n" +
                        "Article XIII of the 1987 Constitution of the Republic of the Philippines is dedicated to the principles of social justice and human rights. It outlines the state's commitment to promoting equitable economic opportunities, labor protection, agrarian and natural resources reform, urban land reform and housing, healthcare, and the safeguarding of human rights, reflecting the nation's dedication to improving the well-being and rights of its citizens.\n\n" +



                        "\n" +
                        "Section 1. The Congress shall give highest priority to the enactment of measures that protect and enhance the right of all the people to human dignity, reduce social, economic, and political inequalities, and remove cultural inequities by equitably diffusing wealth and political power for the common good.\n" +
                        "\n" +
                        "To this end, the State shall regulate the acquisition, ownership, use, and disposition of property and its increments.\n" +
                        "\n" +
                        "Section 2. The promotion of social justice shall include the commitment to create economic opportunities based on freedom of initiative and self-reliance.\n" +
                        "\n" +
                        "LABOR\n" +
                        "\n" +
                        "Section 3. The State shall afford full protection to labor, local and overseas, organized and unorganized, and promote full employment and equality of employment opportunities for all.\n" +
                        "\n" +
                        "It shall guarantee the rights of all workers to self-organization, collective bargaining and negotiations, and peaceful concerted activities, including the right to strike in accordance with law. They shall be entitled to security of tenure, humane conditions of work, and a living wage. They shall also participate in policy and decision-making processes affecting their rights and benefits as may be provided by law.\n" +
                        "\n" +
                        "The State shall promote the principle of shared responsibility between workers and employers and the preferential use of voluntary modes in settling disputes, including conciliation, and shall enforce their mutual compliance therewith to foster industrial peace.\n" +
                        "\n" +
                        "The State shall regulate the relations between workers and employers, recognizing the right of labor to its just share in the fruits of production and the right of enterprises to reasonable returns to investments, and to expansion and growth.\n" +
                        "\n" +
                        "AGRARIAN AND NATURAL RESOURCES REFORM\n" +
                        "\n" +
                        "Section 4. The State shall, by law, undertake an agrarian reform program founded on the right of farmers and regular farmworkers who are landless, to own directly or collectively the lands they till or, in the case of other farmworkers, to receive a just share of the fruits thereof. To this end, the State shall encourage and undertake the just distribution of all agricultural lands, subject to such priorities and reasonable retention limits as the Congress may prescribe, taking into account ecological, developmental, or equity considerations, and subject to the payment of just compensation. In determining retention limits, the State shall respect the right of small landowners. The State shall further provide incentives for voluntary land-sharing.\n" +
                        "\n" +
                        "Section 5. The State shall recognize the right of farmers, farmworkers, and landowners, as well as cooperatives, and other independent farmers’ organizations to participate in the planning, organization, and management of the program, and shall provide support to agriculture through appropriate technology and research, and adequate financial, production, marketing, and other support services.\n" +
                        "\n" +
                        "Section 6. The State shall apply the principles of agrarian reform or stewardship, whenever applicable in accordance with law, in the disposition or utilization of other natural resources, including lands of the public domain under lease or concession suitable to agriculture, subject to prior rights, homestead rights of small settlers, and the rights of indigenous communities to their ancestral lands.\n" +
                        "\n" +
                        "The State may resettle landless farmers and farmworkers in its own agricultural estates which shall be distributed to them in the manner provided by law.\n" +
                        "\n" +
                        "Section 7. The State shall protect the rights of subsistence fishermen, especially of local communities, to the preferential use of the communal marine and fishing resources, both inland and offshore. It shall provide support to such fishermen through appropriate technology and research, adequate financial, production, and marketing assistance, and other services. The State shall also protect, develop, and conserve such resources. The protection shall extend to offshore fishing grounds of subsistence fishermen against foreign intrusion. Fishworkers shall receive a just share from their labor in the utilization of marine and fishing resources.\n" +
                        "\n" +
                        "Section 8. The State shall provide incentives to landowners to invest the proceeds of the agrarian reform program to promote industrialization, employment creation, and privatization of public sector enterprises. Financial instruments used as payment for their lands shall be honored as equity in enterprises of their choice.\n" +
                        "\n" +
                        "URBAN LAND REFORM AND HOUSING\n" +
                        "\n" +
                        "Section 9. The State shall, by law, and for the common good, undertake, in cooperation with the private sector, a continuing program of urban land reform and housing which will make available at affordable cost, decent housing and basic services to underprivileged and homeless citizens in urban centers and resettlement areas. It shall also promote adequate employment opportunities to such citizens. In the implementation of such program the State shall respect the rights of small property owners.\n" +
                        "\n" +
                        "Section 10. Urban or rural poor dwellers shall not be evicted nor their dwelling demolished, except in accordance with law and in a just and humane manner.\n" +
                        "\n" +
                        "No resettlement of urban or rural dwellers shall be undertaken without adequate consultation with them and the communities where they are to be relocated.\n" +
                        "\n" +
                        "HEALTH\n" +
                        "\n" +
                        "Section 11. The State shall adopt an integrated and comprehensive approach to health development which shall endeavor to make essential goods, health and other social services available to all the people at affordable cost. There shall be priority for the needs of the underprivileged, sick, elderly, disabled, women, and children. The State shall endeavor to provide free medical care to paupers.\n" +
                        "\n" +
                        "Section 12. The State shall establish and maintain an effective food and drug regulatory system and undertake appropriate health, manpower development, and research, responsive to the country’s health needs and problems.\n" +
                        "\n" +
                        "Section 13. The State shall establish a special agency for disabled persons for their rehabilitation, self-development, and self-reliance, and their integration into the mainstream of society.\n" +
                        "\n" +
                        "WOMEN\n" +
                        "\n" +
                        "Section 14. The State shall protect working women by providing safe and healthful working conditions, taking into account their maternal functions, and such facilities and opportunities that will enhance their welfare and enable them to realize their full potential in the service of the nation.\n" +
                        "\n" +
                        "ROLE AND RIGHTS OF PEOPLE’S ORGANIZATIONS\n" +
                        "\n" +
                        "Section 15. The State shall respect the role of independent people’s organizations to enable the people to pursue and protect, within the democratic framework, their legitimate and collective interests and aspirations through peaceful and lawful means.\n" +
                        "\n" +
                        "People’s organizations are bona fide associations of citizens with demonstrated capacity to promote the public interest and with identifiable leadership, membership, and structure.\n" +
                        "\n" +
                        "Section 16. The right of the people and their organizations to effective and reasonable participation at all levels of social, political, and economic decision-making shall not be abridged. The State shall, by law, facilitate the establishment of adequate consultation mechanisms.\n" +
                        "\n" +
                        "HUMAN RIGHTS\n" +
                        "\n" +
                        "Section 17. (1) There is hereby created an independent office called the Commission on Human Rights.\n" +
                        "\n" +
                        "(2) The Commission shall be composed of a Chairman and four Members who must be natural-born citizens of the Philippines and a majority of whom shall be members of the Bar. The term of office and other qualifications and disabilities of the Members of the Commission shall be provided by law.\n" +
                        "\n" +
                        "(3) Until this Commission is constituted, the existing Presidential Committee on Human Rights shall continue to exercise its present functions and powers.\n" +
                        "\n" +
                        "(4) The approved annual appropriations of the Commission shall be automatically and regularly released.\n" +
                        "\n" +
                        "Section 18. The Commission on Human Rights shall have the following powers and functions:\n" +
                        "\n" +
                        "(1) Investigate, on its own or on complaint by any party, all forms of human rights violations involving civil and political rights;\n" +
                        "\n" +
                        "(2) Adopt its operational guidelines and rules of procedure, and cite for contempt for violations thereof in accordance with the Rules of Court;\n" +
                        "\n" +
                        "(3) Provide appropriate legal measures for the protection of human rights of all persons within the Philippines, as well as Filipinos residing abroad, and provide for preventive measures and legal aid services to the underprivileged whose human rights have been violated or need protection;\n" +
                        "\n" +
                        "(4) Exercise visitorial powers over jails, prisons, or detention facilities;\n" +
                        "\n" +
                        "(5) Establish a continuing program of research, education, and information to enhance respect for the primacy of human rights;\n" +
                        "\n" +
                        "(6) Recommend to Congress effective measures to promote human rights and to provide for compensation to victims of violations of human rights, or their families;\n" +
                        "\n" +
                        "(7) Monitor the Philippine Government’s compliance with international treaty obligations on human rights;\n" +
                        "\n" +
                        "(8) Grant immunity from prosecution to any person whose testimony or whose possession of documents or other evidence is necessary or convenient to determine the truth in any investigation conducted by it or under its authority;\n" +
                        "\n" +
                        "(9) Request the assistance of any department, bureau, office, or agency in the performance of its functions;\n" +
                        "\n" +
                        "(10) Appoint its officers and employees in accordance with law; and\n" +
                        "\n" +
                        "(11) Perform such other duties and functions as may be provided by law.\n" +
                        "\n" +
                        "Section 19. The Congress may provide for other cases of violations of human rights that should fall within the authority of the Commission, taking into account its recommendations.\n",







                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xiii/",
                "https://i.ytimg.com/vi/1ho4cYTzd1A/sddefault.jpg")
        )




        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XIV\n",


                "ARTICLE XIV\n\n" +

                        "EDUCATION, SCIENCE AND TECHNOLOGY, ARTS, CULTURE AND SPORTS\n\n" +
                        "Article XIII of the 1987 Constitution of the Republic of the Philippines is dedicated to the principles of social justice and human rights. It outlines the state's commitment to promoting equitable economic opportunities, labor protection, agrarian and natural resources reform, urban land reform and housing, healthcare, and the safeguarding of human rights, reflecting the nation's dedication to improving the well-being and rights of its citizens.\n\n" +




                        "EDUCATION\n" +
                        "\n\n" +


                        "Section 1. The State shall protect and promote the right of all citizens to quality education at all levels, and shall take appropriate steps to make such education accessible to all.\n" +
                        "\n" +
                        "Section 2. The State shall:\n" +
                        "\n" +
                        "(1) Establish, maintain, and support a complete, adequate, and integrated system of education relevant to the needs of the people and society;\n" +
                        "\n" +
                        "(2) Establish and maintain a system of free public education in the elementary and high school levels. Without limiting the natural right of parents to rear their children, elementary education is compulsory for all children of school age;\n" +
                        "\n" +
                        "(3) Establish and maintain a system of scholarship grants, student loan programs, subsidies, and other incentives which shall be available to deserving students in both public and private schools, especially to the underprivileged;\n" +
                        "\n" +
                        "(4) Encourage non-formal, informal, and indigenous learning systems, as well as self-learning, independent, and out-of-school study programs particularly those that respond to community needs; and\n" +
                        "\n" +
                        "(5) Provide adult citizens, the disabled, and out-of-school youth with training in civics, vocational efficiency, and other skills.\n" +
                        "\n" +
                        "Section 3. (1) All educational institutions shall include the study of the Constitution as part of the curricula.\n" +
                        "\n" +
                        "(2) They shall inculcate patriotism and nationalism, foster love of humanity, respect for human rights, appreciation of the role of national heroes in the historical development of the country, teach the rights and duties of citizenship, strengthen ethical and spiritual values, develop moral character and personal discipline, encourage critical and creative thinking, broaden scientific and technological knowledge, and promote vocational efficiency.\n" +
                        "\n" +
                        "(3) At the option expressed in writing by the parents or guardians, religion shall be allowed to be taught to their children or wards in public elementary and high schools within the regular class hours by instructors designated or approved by the religious authorities of the religion to which the children or wards belong, without additional cost to the Government.\n" +
                        "\n" +
                        "Section 4.(1) The State recognizes the complementary roles of public and private institutions in the educational system and shall exercise reasonable supervision and regulation of all educational institutions.\n" +
                        "\n" +
                        "(2) Educational institutions, other than those established by religious groups and mission boards, shall be owned solely by citizens of the Philippines or corporations or associations at least sixty per centum of the capital of which is owned by such citizens. The Congress may, however, require increased Filipino equity participation in all educational institutions.\n" +
                        "\n" +
                        "The control and administration of educational institutions shall be vested in citizens of the Philippines.\n" +
                        "\n" +
                        "No educational institution shall be established exclusively for aliens and no group of aliens shall comprise more than one-third of the enrollment in any school. The provisions of this subsection shall not apply to schools established for foreign diplomatic personnel and their dependents and, unless otherwise provided by law, for other foreign temporary residents.\n" +
                        "\n" +
                        "(3) All revenues and assets of non-stock, non-profit educational institutions used actually, directly, and exclusively for educational purposes shall be exempt from taxes and duties. Upon the dissolution or cessation of the corporate existence of such institutions, their assets shall be disposed of in the manner provided by law.\n" +
                        "\n" +
                        "Proprietary educational institutions, including those cooperatively owned, may likewise be entitled to such exemptions, subject to the limitations provided by law, including restrictions on dividends and provisions for reinvestment.\n" +
                        "\n" +
                        "(4) Subject to conditions prescribed by law, all grants, endowments, donations, or contributions used actually, directly, and exclusively for educational purposes shall be exempt from tax.\n" +
                        "\n" +
                        "Section 5. (1) the State shall take into account regional and sectoral needs and conditions and shall encourage local planning in the development of educational policies and programs.\n" +
                        "\n" +
                        "(2) Academic freedom shall be enjoyed in all institutions of higher learning.\n" +
                        "\n" +
                        "(3) Every citizen has a right to select a profession or course of study, subject to fair, reasonable, and equitable admission and academic requirements.\n" +
                        "\n" +
                        "(4) The State shall enhance the right of teachers to professional advancement. Non-teaching academic and non-academic personnel shall enjoy the protection of the State.\n" +
                        "\n" +
                        "(5) The State shall assign the highest budgetary priority to education and ensure that teaching will attract and retain its rightful share of the best available talents through adequate remuneration and other means of job satisfaction and fulfillment.\n" +
                        "\n" +
                        "LANGUAGE\n" +
                        "\n" +
                        "Section 6. The national language of the Philippines is Filipino. As it evolves, it shall be further developed and enriched on the basis of existing Philippine and other languages.\n" +
                        "\n" +
                        "Subject to provisions of law and as the Congress may deem appropriate, the Government shall take steps to initiate and sustain the use of Filipino as a medium of official communication and as language of instruction in the educational system.\n" +
                        "\n" +
                        "Section 7. For purposes of communication and instruction, the official languages of the Philippines are Filipino and, until otherwise provided by law, English.\n" +
                        "\n" +
                        "The regional languages are the auxiliary official languages in the regions and shall serve as auxiliary media of instruction therein.\n" +
                        "\n" +
                        "Spanish and Arabic shall be promoted on a voluntary and optional basis.\n" +
                        "\n" +
                        "Section 8. This Constitution shall be promulgated in Filipino and English and shall be translated into major regional languages, Arabic, and Spanish.\n" +
                        "\n" +
                        "Section 9. The Congress shall establish a national language commission composed of representatives of various regions and disciplines which shall undertake, coordinate, and promote researches for the development, propagation, and preservation of Filipino and other languages.\n" +
                        "\n" +
                        "SCIENCE AND TECHNOLOGY\n" +
                        "\n" +
                        "Section 10. Science and technology are essential for national development and progress. The State shall give priority to research and development, invention, innovation, and their utilization; and to science and technology education, training, and services. It shall support indigenous, appropriate, and self-reliant scientific and technological capabilities, and their application to the country’s productive systems and national life.\n" +
                        "\n" +
                        "Section 11. The Congress may provide for incentives, including tax deductions, to encourage private participation in programs of basic and applied scientific research. Scholarships, grants-in-aid, or other forms of incentives shall be provided to deserving science students, researchers, scientists, inventors, technologists, and specially gifted citizens.\n" +
                        "\n" +
                        "Section 12. The State shall regulate the transfer and promote the adaptation of technology from all sources for the national benefit. It shall encourage the widest participation of private groups, local governments, and community-based organizations in the generation and utilization of science and technology.\n" +
                        "\n" +
                        "Section 13. The State shall protect and secure the exclusive rights of scientists, inventors, artists, and other gifted citizens to their intellectual property and creations, particularly when beneficial to the people, for such period as may be provided by law.\n" +
                        "\n" +
                        "ARTS AND CULTURE\n" +
                        "\n" +
                        "Section 14. The State shall foster the preservation, enrichment, and dynamic evolution of a Filipino national culture based on the principle of unity in diversity in a climate of free artistic and intellectual expression.\n" +
                        "\n" +
                        "Section 15. Arts and letters shall enjoy the patronage of the State. The State shall conserve, promote, and popularize the nation’s historical and cultural heritage and resources, as well as artistic creations.\n" +
                        "\n" +
                        "Section 16. All the country’s artistic and historic wealth constitutes the cultural treasure of the nation and shall be under the protection of the State which may regulate its disposition.\n" +
                        "\n" +
                        "Section 17. The State shall recognize, respect, and protect the rights of indigenous cultural communities to preserve and develop their cultures, traditions, and institutions. It shall consider these rights in the formulation of national plans and policies.\n" +
                        "\n" +
                        "Section 18. (1) The State shall ensure equal access to cultural opportunities through the educational system, public or private cultural entities, scholarships, grants and other incentives, and community cultural centers, and other public venues.\n" +
                        "\n" +
                        "(2) The State shall encourage and support researches and studies on the arts and culture.\n" +
                        "\n" +
                        "SPORTS\n" +
                        "\n" +
                        "Section 19. (1) The State shall promote physical education and encourage sports programs, league competitions, and amateur sports, including training for international competitions, to foster self-discipline, teamwork, and excellence for the development of a healthy and alert citizenry.\n" +
                        "\n" +
                        "(2) All educational institutions shall undertake regular sports activities throughout the country in cooperation with athletic clubs and other sectors.\n",











                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xiv/",
                "https://i.ytimg.com/vi/fQdoKCva7nE/maxresdefault.jpg")
        )

        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XV\n",


                "ARTICLE XV\n\n\n" +

                        "THE FAMILY\n\n" +
                        "Section 1. The State recognizes the Filipino family as the foundation of the nation. Accordingly, it shall strengthen its solidarity and actively promote its total development.\n" +
                        "\n" +
                        "Section 2. Marriage, as an inviolable social institution, is the foundation of the family and shall be protected by the State.\n" +
                        "\n" +
                        "Section 3. The State shall defend:\n" +
                        "\n" +
                        "(1) The right of spouses to found a family in accordance with their religious convictions and the demands of responsible parenthood;\n" +
                        "\n" +
                        "(2) The right of children to assistance, including proper care and nutrition, and special protection from all forms of neglect, abuse, cruelty, exploitation and other conditions prejudicial to their development;\n" +
                        "\n" +
                        "(3) The right of the family to a family living wage and income; and\n" +
                        "\n" +
                        "(4) The right of families or family associations to participate in the planning and implementation of policies and programs that affect them.\n" +
                        "\n" +
                        "Section 4. The family has the duty to care for its elderly members but the State may also do so through just programs of social security.\n\n",
     R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xv/",
                "https://i.ytimg.com/vi/_2DVzGky6Ic/maxresdefault.jpg")
        )


        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XVI\n",


                "ARTICLE XVI\n\n\n" +

                        "GENERAL PROVISIONS\n\n" +
                        "Section 1. The flag of the Philippines shall be red, white, and blue, with a sun and three stars, as consecrated and honored by the people and recognized by law.\n" +
                        "\n" +
                        "Section 2. The Congress may, by law, adopt a new name for the country, a national anthem, or a national seal, which shall all be truly reflective and symbolic of the ideals, history, and traditions of the people. Such law shall take effect only upon its ratification by the people in a national referendum.\n" +
                        "\n" +
                        "Section 3. The State may not be sued without its consent.\n" +
                        "\n" +
                        "Section 4. The Armed Forces of the Philippines shall be composed of a citizen armed force which shall undergo military training and serve as may be provided by law. It shall keep a regular force necessary for the security of the State.\n" +
                        "\n" +
                        "Section 5. (1) All members of the armed forces shall take an oath or affirmation to uphold and defend this Constitution.\n" +
                        "\n" +
                        "(2) The State shall strengthen the patriotic spirit and nationalist consciousness of the military, and respect for people’s rights in the performance of their duty.\n" +
                        "\n" +
                        "(3) Professionalism in the armed forces and adequate remuneration and benefits of its members shall be a prime concern of the State. The armed forces shall be insulated from partisan politics.\n" +
                        "\n" +
                        "No member of the military shall engage, directly or indirectly, in any partisan political activity, except to vote.\n" +
                        "\n" +
                        "(4) No member of the armed forces in the active service shall, at any time, be appointed or designated in any capacity to a civilian position in the Government, including government-owned or controlled corporations or any of their subsidiaries.\n" +
                        "\n" +
                        "(5) Laws on retirement of military officers shall not allow extension of their service.\n" +
                        "\n" +
                        "(6) The officers and men of the regular force of the armed forces shall be recruited proportionately from all provinces and cities as far as practicable.\n" +
                        "\n" +
                        "(7) The tour of duty of the Chief of Staff of the armed forces shall not exceed three years. However, in times of war or other national emergency declared by the Congress, the President may extend such tour of duty.\n" +
                        "\n" +
                        "Section 6. The State shall establish and maintain one police force, which shall be national in scope and civilian in character, to be administered and controlled by a national police commission. The authority of local executives over the police units in their jurisdiction shall be provided by law.\n" +
                        "\n" +
                        "Section 7. The State shall provide immediate and adequate care, benefits, and other forms of assistance to war veterans and veterans of military campaigns, their surviving spouses and orphans. Funds shall be provided therefor and due consideration shall be given them in the disposition of agricultural lands of the public domain and, in appropriate cases, in the utilization of natural resources.\n" +
                        "\n" +
                        "Section 8. The State shall, from time to time, review to increase the pensions and other benefits due to retirees of both the government and the private sectors.\n" +
                        "\n" +
                        "Section 9. The State shall protect consumers from trade malpractices and from substandard or hazardous products.\n" +
                        "\n" +
                        "Section 10. The State shall provide the policy environment for the full development of Filipino capability and the emergence of communication structures suitable to the needs and aspirations of the nation and the balanced flow of information into, out of, and across the country, in accordance with a policy that respects the freedom of speech and of the press.\n" +
                        "\n" +
                        "Section 11. (1) The ownership and management of mass media shall be limited to citizens of the Philippines, or to corporations, cooperatives or associations, wholly-owned and managed by such citizens.\n" +
                        "\n" +
                        "The Congress shall regulate or prohibit monopolies in commercial mass media when the public interest so requires. No combinations in restraint of trade or unfair competition therein shall be allowed.\n" +
                        "\n" +
                        "(2) The advertising industry is impressed with public interest, and shall be regulated by law for the protection of consumers and the promotion of the general welfare.\n" +
                        "\n" +
                        "Only Filipino citizens or corporations or associations at least seventy per centum of the capital of which is owned by such citizens shall be allowed to engage in the advertising industry.\n" +
                        "\n" +
                        "The participation of foreign investors in the governing body of entities in such industry shall be limited to their proportionate share in the capital thereof, and all the executive and managing officers of such entities must be citizens of the Philippines.\n" +
                        "\n" +
                        "Section 12. The Congress may create a consultative body to advise the President on policies affecting indigenous cultural communities, the majority of the members of which shall come from such communities.\n" ,


                        R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xvi/",
                "https://i.ytimg.com/vi/wtezWjVvZTc/maxresdefault.jpg")
        )


        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XVI\n",


                "ARTICLE XVI\n\n\n" +

                        "GENERAL PROVISIONS\n\n" +
                        "Section 1. The flag of the Philippines shall be red, white, and blue, with a sun and three stars, as consecrated and honored by the people and recognized by law.\n" +
                        "\n" +
                        "Section 2. The Congress may, by law, adopt a new name for the country, a national anthem, or a national seal, which shall all be truly reflective and symbolic of the ideals, history, and traditions of the people. Such law shall take effect only upon its ratification by the people in a national referendum.\n" +
                        "\n" +
                        "Section 3. The State may not be sued without its consent.\n" +
                        "\n" +
                        "Section 4. The Armed Forces of the Philippines shall be composed of a citizen armed force which shall undergo military training and serve as may be provided by law. It shall keep a regular force necessary for the security of the State.\n" +
                        "\n" +
                        "Section 5. (1) All members of the armed forces shall take an oath or affirmation to uphold and defend this Constitution.\n" +
                        "\n" +
                        "(2) The State shall strengthen the patriotic spirit and nationalist consciousness of the military, and respect for people’s rights in the performance of their duty.\n" +
                        "\n" +
                        "(3) Professionalism in the armed forces and adequate remuneration and benefits of its members shall be a prime concern of the State. The armed forces shall be insulated from partisan politics.\n" +
                        "\n" +
                        "No member of the military shall engage, directly or indirectly, in any partisan political activity, except to vote.\n" +
                        "\n" +
                        "(4) No member of the armed forces in the active service shall, at any time, be appointed or designated in any capacity to a civilian position in the Government, including government-owned or controlled corporations or any of their subsidiaries.\n" +
                        "\n" +
                        "(5) Laws on retirement of military officers shall not allow extension of their service.\n" +
                        "\n" +
                        "(6) The officers and men of the regular force of the armed forces shall be recruited proportionately from all provinces and cities as far as practicable.\n" +
                        "\n" +
                        "(7) The tour of duty of the Chief of Staff of the armed forces shall not exceed three years. However, in times of war or other national emergency declared by the Congress, the President may extend such tour of duty.\n" +
                        "\n" +
                        "Section 6. The State shall establish and maintain one police force, which shall be national in scope and civilian in character, to be administered and controlled by a national police commission. The authority of local executives over the police units in their jurisdiction shall be provided by law.\n" +
                        "\n" +
                        "Section 7. The State shall provide immediate and adequate care, benefits, and other forms of assistance to war veterans and veterans of military campaigns, their surviving spouses and orphans. Funds shall be provided therefor and due consideration shall be given them in the disposition of agricultural lands of the public domain and, in appropriate cases, in the utilization of natural resources.\n" +
                        "\n" +
                        "Section 8. The State shall, from time to time, review to increase the pensions and other benefits due to retirees of both the government and the private sectors.\n" +
                        "\n" +
                        "Section 9. The State shall protect consumers from trade malpractices and from substandard or hazardous products.\n" +
                        "\n" +
                        "Section 10. The State shall provide the policy environment for the full development of Filipino capability and the emergence of communication structures suitable to the needs and aspirations of the nation and the balanced flow of information into, out of, and across the country, in accordance with a policy that respects the freedom of speech and of the press.\n" +
                        "\n" +
                        "Section 11. (1) The ownership and management of mass media shall be limited to citizens of the Philippines, or to corporations, cooperatives or associations, wholly-owned and managed by such citizens.\n" +
                        "\n" +
                        "The Congress shall regulate or prohibit monopolies in commercial mass media when the public interest so requires. No combinations in restraint of trade or unfair competition therein shall be allowed.\n" +
                        "\n" +
                        "(2) The advertising industry is impressed with public interest, and shall be regulated by law for the protection of consumers and the promotion of the general welfare.\n" +
                        "\n" +
                        "Only Filipino citizens or corporations or associations at least seventy per centum of the capital of which is owned by such citizens shall be allowed to engage in the advertising industry.\n" +
                        "\n" +
                        "The participation of foreign investors in the governing body of entities in such industry shall be limited to their proportionate share in the capital thereof, and all the executive and managing officers of such entities must be citizens of the Philippines.\n" +
                        "\n" +
                        "Section 12. The Congress may create a consultative body to advise the President on policies affecting indigenous cultural communities, the majority of the members of which shall come from such communities.\n" ,


                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xvi/",
                "https://i.ytimg.com/vi/wtezWjVvZTc/maxresdefault.jpg")
        )




        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XVII\n",


                "ARTICLE XVII\n\n\n" +

                        "AMENDMENTS OR REVISIONS\n\n" +


                        "Section 1. Any amendment to, or revision of, this Constitution may be proposed by:\n" +
                        "\n" +
                        "(1) The Congress, upon a vote of three-fourths of all its Members; or\n" +
                        "\n" +
                        "(2) A constitutional convention.\n" +
                        "\n" +
                        "Section 2. Amendments to this Constitution may likewise be directly proposed by the people through initiative upon a petition of at least twelve per centum of the total number of registered voters, of which every legislative district must be represented by at least three per centum of the registered voters therein. No amendment under this section shall be authorized within five years following the ratification of this Constitution nor oftener than once every five years thereafter.\n" +
                        "\n" +
                        "The Congress shall provide for the implementation of the exercise of this right.\n" +
                        "\n" +
                        "Section 3. The Congress may, by a vote of two-thirds of all its Members, call a constitutional convention, or by a majority vote of all its Members, submit to the electorate the question of calling such a convention.\n" +
                        "\n" +
                        "Section 4. Any amendment to, or revision of, this Constitution under Section 1 hereof shall be valid when ratified by a majority of the votes cast in a plebiscite which shall be held not earlier than sixty days nor later than ninety days after the approval of such amendment or revision.\n" +
                        "\n" +
                        "Any amendment under Section 2 hereof shall be valid when ratified by a majority of the votes cast in a plebiscite which shall be held not earlier than sixty days nor later than ninety days after the certification by the Commission on Elections of the sufficiency of the petition.\n" ,







                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xvii/",
                "https://i.ytimg.com/vi/buOdXkuGC9M/sddefault.jpg")
        )




        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XVIII\n",


                "ARTICLE XVIII\n\n\n\n" +

                        "TRANSITORY PROVISIONS\n\n" +


                        "Section 1. The first elections of Members of the Congress under this Constitution shall be held on the second Monday of May, 1987.\n" +
                        "\n" +
                        "The first local elections shall be held on a date to be determined by the President, which may be simultaneous with the election of the Members of the Congress. It shall include the election of all Members of the city or municipal councils in the Metropolitan Manila area.\n" +
                        "\n" +
                        "Section 2. The Senators, Members of the House of Representatives, and the local officials first elected under this Constitution shall serve until noon of June 30, 1992.\n" +
                        "\n" +
                        "Of the Senators elected in the elections in 1992, the first twelve obtaining the highest number of votes shall serve for six years and the remaining twelve for three years.\n" +
                        "\n" +
                        "Section 3. All existing laws, decrees, executive orders, proclamations, letters of instructions, and other executive issuances not inconsistent with this Constitution shall remain operative until amended, repealed, or revoked.\n" +
                        "\n" +
                        "Section 4. All existing treaties or international agreements which have not been ratified shall not be renewed or extended without the concurrence of at least two-thirds of all the Members of the Senate.\n" +
                        "\n" +
                        "Section 5. The six-year term of the incumbent President and Vice-President elected in the February 7, 1986 election is, for purposes of synchronization of elections, hereby extended to noon of June 30, 1992.\n" +
                        "\n" +
                        "The first regular elections for the President and Vice-President under this Constitution shall be held on the second Monday of May, 1992.\n" +
                        "\n" +
                        "Section 6. The incumbent President shall continue to exercise legislative powers until the first Congress is convened.\n" +
                        "\n" +
                        "Section 7. Until a law is passed, the President may fill by appointment from a list of nominees by the respective sectors, the seats reserved for sectoral representation in paragraph (2), Section 5 of Article VI of this Constitution.\n" +
                        "\n" +
                        "Section 8. Until otherwise provided by the Congress, the President may constitute the Metropolitan Manila Authority to be composed of the heads of all local government units comprising the Metropolitan Manila area.\n" +
                        "\n" +
                        "Section 9. A sub-province shall continue to exist and operate until it is converted into a regular province or until its component municipalities are reverted to the mother province.\n" +
                        "\n" +
                        "Section 10. All courts existing at the time of the ratification of this Constitution shall continue to exercise their jurisdiction, until otherwise provided by law. The provisions of the existing Rules of Court, judiciary acts, and procedural laws not inconsistent with this Constitution shall remain operative unless amended or repealed by the Supreme Court or the Congress.\n" +
                        "\n" +
                        "Section 11. The incumbent Members of the Judiciary shall continue in office until they reach the age of seventy years or become incapacitated to discharge the duties of their office or are removed for cause.\n" +
                        "\n" +
                        "Section 12. The Supreme Court shall, within one year after the ratification of this Constitution, adopt a systematic plan to expedite the decision or resolution of cases or matters pending in the Supreme Court or the lower courts prior to the effectivity of this Constitution. A similar plan shall be adopted for all special courts and quasi-judicial bodies.\n" +
                        "\n" +
                        "Section 13. The legal effect of the lapse, before the ratification of this Constitution, of the applicable period for the decision or resolution of the cases or matters submitted for adjudication by the courts, shall be determined by the Supreme Court as soon as practicable.\n" +
                        "\n" +
                        "Section 14. The provisions of paragraphs (3) and (4), Section 15 of Article VIII of this Constitution shall apply to cases or matters filed before the ratification of this Constitution, when the applicable period lapses after such ratification.\n" +
                        "\n" +
                        "Section 15. The incumbent Members of the Civil Service Commission, the Commission on Elections, and the Commission on Audit shall continue in office for one year after the ratification of this Constitution, unless they are sooner removed for cause or become incapacitated to discharge the duties of their office or appointed to a new term thereunder. In no case shall any Member serve longer than seven years including service before the ratification of this Constitution.\n" +
                        "\n" +
                        "Section 16. Career civil service employees separated from the service not for cause but as a result of the reorganization pursuant to Proclamation No. 3 dated March 25, 1986 and the reorganization following the ratification of this Constitution shall be entitled to appropriate separation pay and to retirement and other benefits accruing to them under the laws of general application in force at the time of their separation. In lieu thereof, at the option of the employees, they may be considered for employment in the Government or in any of its subdivisions, instrumentalities, or agencies, including government-owned or controlled corporations and their subsidiaries. This provision also applies to career officers whose resignation, tendered in line with the existing policy, had been accepted.\n" +
                        "\n" +
                        "Section 17. Until the Congress provides otherwise, the President shall receive an annual salary of three hundred thousand pesos; the Vice-President, the President of the Senate, the Speaker of the House of Representatives, and the Chief Justice of the Supreme Court, two hundred forty thousand pesos each; the Senators, the Members of the House of Representatives, the Associate Justices of the Supreme Court, and the Chairmen of the Constitutional Commissions, two hundred four thousand pesos each; and the Members of the Constitutional Commissions, one hundred eighty thousand pesos each.\n" +
                        "\n" +
                        "Section 18. At the earliest possible time, the Government shall increase the salary scales of the other officials and employees of the National Government.\n" +
                        "\n" +
                        "Section 19. All properties, records, equipment, buildings, facilities, and other assets of any office or body abolished or reorganized under Proclamation No. 3 dated March 25, 1986 or this Constitution shall be transferred to the office or body to which its powers, functions, and responsibilities substantially pertain.\n" +
                        "\n" +
                        "Section 20. The first Congress shall give priority to the determination of the period for the full implementation of free public secondary education.\n" +
                        "\n" +
                        "Section 21. The Congress shall provide efficacious procedures and adequate remedies for the reversion to the State of all lands of the public domain and real rights connected therewith which were acquired in violation of the Constitution or the public land laws, or through corrupt practices. No transfer or disposition of such lands or real rights shall be allowed until after the lapse of one year from the ratification of this Constitution.\n" +
                        "\n" +
                        "Section 22. At the earliest possible time, the Government shall expropriate idle or abandoned agricultural lands as may be defined by law, for distribution to the beneficiaries of the agrarian reform program.\n" +
                        "\n" +
                        "Section 23. Advertising entities affected by paragraph (2), Section 11 of Article XVI of this Constitution shall have five years from its ratification to comply on a graduated and proportionate basis with the minimum Filipino ownership requirement therein.\n" +
                        "\n" +
                        "Section 24. Private armies and other armed groups not recognized by duly constituted authority shall be dismantled. All paramilitary forces including Civilian Home Defense Forces not consistent with the citizen armed force established in this Constitution, shall be dissolved or, where appropriate, converted into the regular force.\n" +
                        "\n" +
                        "Section 25. After the expiration in 1991 of the Agreement between the Republic of the Philippines and the United States of America concerning military bases, foreign military bases, troops, or facilities shall not be allowed in the Philippines except under a treaty duly concurred in by the Senate and, when the Congress so requires, ratified by a majority of the votes cast by the people in a national referendum held for that purpose, and recognized as a treaty by the other contracting State.\n" +
                        "\n" +
                        "Section 26. The authority to issue sequestration or freeze orders under Proclamation No. 3 dated March 25, 1986 in relation to the recovery of ill-gotten wealth shall remain operative for not more than eighteen months after the ratification of this Constitution. However, in the national interest, as certified by the President, the Congress may extend such period.\n" +
                        "\n" +
                        "A sequestration or freeze order shall be issued only upon showing of a prima facie case. The order and the list of the sequestered or frozen properties shall forthwith be registered with the proper court. For orders issued before the ratification of this Constitution, the corresponding judicial action or proceeding shall be filed within six months from its ratification. For those issued after such ratification, the judicial action or proceeding shall be commenced within six months from the issuance thereof.\n" +
                        "\n" +
                        "The sequestration or freeze order is deemed automatically lifted if no judicial action or proceeding is commenced as herein provided.\n" +
                        "\n" +
                        "Section 27. This Constitution shall take effect immediately upon its ratification by a majority of the votes cast in a plebiscite held for the purpose and shall supersede all previous Constitutions.\n" +
                        "\n" +
                        "The foregoing proposed Constitution of the Republic of the Philippines was approved by the Constitutional Commission of 1986 on the twelfth day of October, Nineteen hundred and eighty-six, and accordingly signed on the fifteenth day of October, Nineteen hundred and eighty-six at the Plenary Hall, National Government Center, Quezon City, by the Commissioners whose signatures are hereunder affixed.\n" ,











                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xviii/",
                "https://i.ytimg.com/vi/TtVsOO8ZFag/maxresdefault.jpg")
        )

        dataList.add(
            DataItem("THE 1987 CONSTITUTION OF THE REPUBLIC OF THE PHILIPPINES – ARTICLE XVIII\n",


                "ARTICLE XVIII\n\n\n\n" +

                        "TRANSITORY PROVISIONS\n\n" +


                        "Section 1. The first elections of Members of the Congress under this Constitution shall be held on the second Monday of May, 1987.\n" +

                           "The foregoing proposed Constitution of the Republic of the Philippines was approved by the Constitutional Commission of 1986 on the twelfth day of October, Nineteen hundred and eighty-six, and accordingly signed on the fifteenth day of October, Nineteen hundred and eighty-six at the Plenary Hall, National Government Center, Quezon City, by the Commissioners whose signatures are hereunder affixed.\n" ,











                R.drawable.img_260,
                "https://www.officialgazette.gov.ph/constitutions/the-1987-constitution-of-the-republic-of-the-philippines/the-1987-constitution-of-the-republic-of-the-philippines-article-xviii/",
                "https://i.ytimg.com/vi/TtVsOO8ZFag/maxresdefault.jpg")
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