package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityNineCampusinitiativeBinding
import com.example.civicall.databinding.ActivityTenSustainableGoalsBinding

class TenSustainableGoals : AppCompatActivity() {

    private  lateinit var binding:ActivityTenSustainableGoalsBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ten_sustainable_goals)

        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityTenSustainableGoalsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dataList = ArrayList<DataItem>()
        dataList.add(
            DataItem(
                "Goal 1: End poverty in all its forms everywhere",
                "Dive into the challenge of a generation: 'Breaking Chains, Building Futures!' Uncover the harsh realities and staggering figures behind Goal 1—ending poverty by 2030. Join the movement, take action, and let's rewrite the narrative together!\"\"\n\n" +
                        "1. \"The Urgent Battle Against Extreme Poverty\"\n" +
                        "   - Point: The 2030 Agenda targets the eradication of extreme poverty, defined as living on less than $2.15 per day at 2017 purchasing power parity.\n\n" +
                        "2. \"COVID-19's Impact: A Reversal of Progress\"\n" +
                        "   - Point: The pandemic has increased the number of individuals living in extreme poverty by almost 90 million, undoing decades of gains.\n\n" +
                        "3. \"Alarming Projection: 575 Million in Extreme Poverty by 2030\"\n" +
                        "   - Point: If current trends persist, an estimated 7% of the global population, around 575 million people, could remain in extreme poverty by 2030.\n\n" +
                        "4. \"Resurgence of Hunger: A Backtrack to 2005 Levels\"\n" +
                        "   - Point: Hunger levels have surged to those last observed in 2005, posing a serious challenge to global well-being.\n\n" +
                        "5. \"The Dual Challenge: Poverty and Food Insecurity\"\n" +
                        "   - Point: The simultaneous rise in poverty and food prices poses a critical global concern, demanding multifaceted solutions.\n\n" +
                        "6. \"Roots of Poverty: Unemployment, Social Exclusion, and Vulnerability\"\n" +
                        "   - Point: Poverty has many dimensions, with causes including unemployment, social exclusion, and the vulnerability of certain populations to disasters and diseases.\n\n" +
                        "7. \"Interconnected Well-being: Why We Should Care\"\n" +
                        "   - Point: Growing inequality is detrimental to economic growth and social cohesion, linking our well-being as human beings.\n\n" +
                        "8. \"The Vital Role of Social Protection\"\n" +
                        "   - Point: Strong social protection systems are crucial for preventing people from falling into poverty, especially in the aftermath of events like the COVID-19 pandemic.\n\n" +
                        "9. \"Policy Engagement: A Call to Action\"\n" +
                        "   - Point: Active engagement in policymaking can make a difference in addressing poverty, ensuring rights are promoted, voices are heard, and innovation is encouraged.\n\n" +
                        "10. \"Science's Impact: Access to Safe Drinking Water and Health Improvements\"\n" +
                        "    - Point: Science has significantly contributed to poverty alleviation, enabling access to safe drinking water, reducing water-borne diseases, and improving hygiene.\n\n",

                "https://www.isglobal.org/documents/10179/6939455/SDG+1+grande+en.jpg/4f7e1dee-fdd5-4c34-914e-6759ccbf4544?t=1539616787000",
                "https://www.un.org/sustainabledevelopment/poverty/"
            )
        )
        dataList.add(
            DataItem(
                "Goal 2: Zero Hunger",
                "Dive into the mission of a hunger-free world: 'Nourishing Tomorrow!' Unveil the stark reality of global hunger exacerbated by pandemics, conflict, and climate change. Join the movement, let's tackle this crisis together and create a future where no one goes to bed hungry!\n\n" +
                        "1. \"World Hunger Surge: A Global Crisis\"\n" +
                        "   - Point: Since 2015, global hunger and food insecurity have alarmingly increased, reaching approximately 735 million people, or 9.2% of the world's population by 2022, fueled by factors like the pandemic, conflict, and climate change.\n\n" +
                        "2. \"Rising Food Insecurity: A Growing Humanitarian Challenge\"\n" +
                        "   - Point: In 2022, an estimated 2.4 billion people faced moderate to severe food insecurity, a staggering increase of 391 million people compared to 2019, demanding urgent global attention and coordinated efforts.\n\n" +
                        "3. \"Hunger's Impact on Sustainable Development\"\n" +
                        "   - Point: Extreme hunger and malnutrition act as barriers to sustainable development, hindering individuals from escaping poverty, reducing productivity, and increasing susceptibility to diseases.\n\n" +
                        "4. \"Stark Statistics: Hunger's Toll on Children\"\n" +
                        "   - Point: In 2022, 148 million children experienced stunted growth, and 45 million children under the age of 5 suffered from wasting, emphasizing the dire consequences of hunger on the youngest and most vulnerable.\n\n" +
                        "5. \"Projected Global Hunger in 2030: A Daunting Challenge\"\n" +
                        "   - Point: Projections indicate that more than 600 million people worldwide will face hunger in 2030, underscoring the immense challenge in achieving the zero hunger target.\n\n" +
                        "6. \"Root Causes: Conflict, Climate Shocks, and Rising Food Prices\"\n" +
                        "   - Point: The return to hunger levels not seen since 2005 is attributed to factors such as conflict, climate shocks, civil insecurity, and rising food prices, creating a complex and challenging scenario.\n\n" +
                        "7. \"The Crucial Role of Agriculture Investment\"\n" +
                        "   - Point: Investment in the agriculture sector is identified as critical for reducing hunger and poverty, improving food security, creating employment, and building resilience to disasters and shocks.\n\n" +
                        "8. \"Global Impact of Zero Hunger\"\n" +
                        "   - Point: A world with zero hunger positively impacts economies, health, education, equality, and social development, playing a key role in building a better future for everyone.\n\n" +
                        "9. \"Multi-dimensional Approach to Food Security\"\n" +
                        "   - Point: Achieving zero hunger requires a multi-dimensional approach, encompassing social protection, transforming food systems, and investing in both rural and urban areas to ensure access to safe and nutritious food.\n\n" +
                        "10. \"Empowerment through Action: Tackling Hunger Together\"\n" +
                        "    - Point: Individuals can contribute by supporting local farmers, making sustainable food choices, fighting food waste, and using their influence as consumers and voters to demand businesses and governments work towards achieving zero hunger. Join the conversation and be part of the solution.\n\n",

                "https://www.isglobal.org/documents/10179/6939455/SDG+2+grande+en.jpg/09f80787-9980-4013-9053-81a53d313017?t=1539617604000",
                "https://www.un.org/sustainabledevelopment/hunger/"
            )
        )
        dataList.add(
            DataItem(
                "Goal 3: Ensure healthy lives and promote well-being for all at all ages",
                "Embark on the journey for global well-being: 'Health Unleashed!' While significant strides have improved health worldwide, persistent inequalities and recent setbacks, notably during the COVID-19 pandemic, underscore the urgency for universal health coverage. Join the call to action, let's bridge gaps, ensure access for all, and strive for a healthier, more resilient future together!\n\n" +
                        "1. \"Global Health Progress: A Bittersweet Tale\"\n" +
                        "   - Remarkable progress has been made, with 146 out of 200 countries meeting or on track to meet the SDG target on under-5 mortality, and a 52% reduction in global AIDS-related deaths since 2010.\n\n" +
                        "2. \"Challenges Amid Achievements: Pandemic Setbacks\"\n" +
                        "   - Despite strides, the COVID-19 pandemic and ongoing crises have hindered Goal 3 progress, leading to the largest decline in childhood vaccinations in three decades and increased tuberculosis and malaria deaths.\n\n" +
                        "3. \"Urgent Commitment: Ending Epidemics by 2030\"\n" +
                        "   - The Sustainable Development Goals commit to ending epidemics of AIDS, tuberculosis, malaria, and other communicable diseases by 2030, emphasizing universal health coverage and access to safe and affordable medicines.\n\n" +
                        "4. \"Disparities in Healthcare Access\"\n" +
                        "   - Inequalities persist as a significant portion of the global population lacks access to vital healthcare services, emphasizing the need to address disparities for achieving Health for All and SDG targets.\n\n" +
                        "5. \"Investment for Resilience: Strengthening Health Systems\"\n" +
                        "   - To overcome setbacks and address health care shortcomings, increased investment in health systems is crucial to support countries in recovery and build resilience against future health threats.\n\n" +
                        "6. \"Immunization Decline: A Cause for Concern\"\n" +
                        "   - The alarming decline in childhood vaccination, the largest sustained decline in 30 years, poses a risk to millions of children, highlighting the importance of one of the world's most successful health interventions.\n\n" +
                        "7. \"Universal Health Coverage (UHC): Addressing Inequalities\"\n" +
                        "   - While efforts to combat infectious diseases expanded service coverage, progress has slowed, and inequalities remain a challenge for UHC, especially in reproductive, maternal, child, and adolescent health services.\n\n" +
                        "8. \"Personal Responsibility: Promoting Good Health\"\n" +
                        "   - Individuals can contribute by making well-informed choices, practicing safe sex, vaccinating children, and promoting awareness about good health and the right to quality healthcare services.\n\n" +
                        "9. \"Community Advocacy: Amplifying Health Awareness\"\n" +
                        "   - Raising awareness in communities about good health, healthy lifestyles, and the right to quality healthcare services, especially for vulnerable groups, empowers individuals to become advocates for change.\n\n" +
                        "10. \"Government Accountability: Ensuring Access for All\"\n" +
                        "    - Holding governments, local leaders, and decision-makers accountable to their commitments is crucial for improving people's access to health and healthcare, fostering a collective responsibility for global health.\n\n",
                "https://www.isglobal.org/documents/10179/6939455/sdg+3+grande+en.jpg/93092481-5a7a-4ef7-ad09-67fc4da33e34?t=1539619047000",
                "https://www.un.org/sustainabledevelopment/health/"
            )
        )


        dataList.add(
            DataItem(
                "Goal 4: Quality Education",
                "Embark on the journey to empower minds: 'Education Unleashed!While strides have been made, the COVID-19 pandemic has exacerbated challenges, risking the education of millions. Join the call for universal access, equal opportunities, and quality education as the key to breaking the cycle of poverty and unlocking a brighter future for all!\n\n" +
                        "1. Global Learning Losses Amid Pandemic:\n" +
                        "   - Point: COVID-19 has caused learning losses in four out of five countries studied, impacting education globally.\n\n" +
                        "2. Projected Educational Gaps by 2030:\n" +
                        "   - Point: Without additional measures, an estimated 84 million children may be out of school, and 300 million students might lack basic skills by 2030.\n\n" +
                        "3. Educational Impact on Sustainable Development:\n" +
                        "   - Point: Education is a key catalyst for achieving various Sustainable Development Goals (SDGs), breaking the cycle of poverty, reducing inequalities, and promoting sustainable lives.\n\n" +
                        "4. Challenges in Achieving 2030 Targets:\n" +
                        "   - Point: Progress towards 2030 education targets is slower than needed, with economic constraints, learning outcomes, and dropout rates posing persistent challenges.\n\n" +
                        "5. Global Disparities in Education:\n" +
                        "   - Point: Sub-Saharan Africa faces significant challenges, with less than half of schools having basic resources. Inequalities and the digital divide need urgent attention.\n\n" +
                        "6. Gender Disparities in Education:\n" +
                        "   - Point: About 40% of countries have not achieved gender parity in primary education, impacting women and girls' access to skills and opportunities in the labor market.\n\n" +
                        "7. Importance of Education Financing:\n" +
                        "   - Point: Education financing must become a national investment priority to achieve Goal 4. Measures like free education, increased teachers, and digital transformation are crucial.\n\n" +
                        "8. Persistent Challenges in Marginalized Areas:\n" +
                        "   - Point: Marginalized areas face challenges like low ICT skills, emphasizing the need for continued global commitment to inclusive and equitable education.\n\n" +
                        "9. Call for Immediate Actions:\n" +
                        "   - Point: Urgent and decisive actions are needed worldwide to predict and counteract health challenges, safeguard vulnerable populations, and strengthen health systems.\n\n" +
                        "10. Advocacy for Education Priority:\n" +
                        "    - Point: Individuals can advocate for education as a priority, urging governments to commit to providing free primary school education for all, especially vulnerable or marginalized groups.\n\n",
                "https://www.isglobal.org/documents/10179/6939455/SDG+4+grande+en.jpg/6ff8e7db-cb48-4213-b721-91ec54130589?t=1539682384000",
                "https://www.un.org/sustainabledevelopment/education/"
            )
        )

        dataList.add(
            DataItem(
                "Goal 5: Achieve gender equality and empower all women and girls",
                "Embark on the journey towards equality with 'EmpowerHer!' While progress has been made, gender inequality persists globally, threatening the potential of half the world's population. Join the call for political leadership, investments, and comprehensive policy reforms to dismantle systemic barriers, empowering women and girls and achieving Sustainable Development Goal 5 for a peaceful, prosperous, and sustainable world.\n\n" +
                        "1. Global Gender Gap:\n" +
                        "   - Despite progress, gender equality by 2030 is uncertain, with persisting disparities in earnings, domestic work, and societal roles.\n\n" +
                        "2. Pandemic's Impact:\n" +
                        "   - COVID-19 worsened gender inequalities, increasing sexual violence, intensifying care work, and affecting women's economic and social status.\n\n" +
                        "3. Protracted Timeline:\n" +
                        "   - At the current pace, it may take 300 years to end child marriage, 286 years to close legal protection gaps, and 140 years for equal representation in leadership roles.\n\n" +
                        "4. Systemic Barriers:\n" +
                        "   - Achieving Goal 5 requires political leadership, investments, and policy reforms to address discrimination, violence, and harmful practices like FGM.\n\n" +
                        "5. Global Health Impact:\n" +
                        "   - Violence against women, limited reproductive rights, and intimate partner violence hinder women's overall well-being and societal participation.\n\n" +
                        "6. Decisions and Rights:\n" +
                        "   - Nearly half of married women lack decision-making power over their sexual and reproductive health, hindering progress in achieving gender equality.\n\n" +
                        "7. Violence's Toll:\n" +
                        "   - 35% of women aged 15-49 have experienced intimate partner violence, impacting their quality of life and societal involvement.\n\n" +
                        "8. Universal Relevance:\n" +
                        "   - Gender equality is a fundamental human right critical to reducing poverty, promoting health, education, and fostering a healthy society for all.\n\n" +
                        "9. Individual Actions:\n" +
                        "   - Girls can champion education, women can address biases, and men can work alongside women to promote equality, embracing healthy relationships.\n\n" +
                        "10. Spotlight Initiative:\n" +
                        "    - The EU/UN partnership, the Spotlight Initiative, aims to eliminate all forms of violence against women and girls globally, contributing to SDG 5.\n\n",
                "https://www.ormazabal.com/wp-content/uploads/2023/09/SDG-5-grande-en-1-2.jpg",
                "https://www.un.org/sustainabledevelopment/gender-equality/"
            )
        )




        dataList.add(
            DataItem(
                "Goal 6: Ensure access to water and sanitation for all\n",
                "Embark on the journey for vital well-being with 'WaterWorks!' Despite progress, billions still lack access to safe water and sanitation, posing threats to health and sustainability by 2030. Join the call for increased investments, innovative solutions, and collective action to ensure universal access, preserve ecosystems, and address the challenges of water scarcity and pollution.\n\n" +
                        "1. Global Water Scarcity Crisis:\n" +
                        "   - Point: Demand for water is escalating, with half the world facing severe water scarcity for at least one month annually, and climate change is projected to exacerbate the situation.\n\n" +
                        "2. Positive Drinking Water Progress:\n" +
                        "   - Point: Between 2015 and 2022, the proportion of the global population with access to safely managed drinking water increased from 69% to 73%.\n\n" +
                        "3. Challenges in Sanitation:\n" +
                        "   - Point: In 2022, 2.2 billion people lacked safely managed drinking water, 3.5 billion lacked safely managed sanitation, and 2 billion lacked basic handwashing facilities.\n\n" +
                        "4. Link Between Water and Climate Change:\n" +
                        "   - Point: Water availability is becoming less predictable, and droughts are worsening water scarcity, impacting health, productivity, biodiversity, and sustainable development.\n\n" +
                        "5. Critical Role of Water in Society:\n" +
                        "   - Point: Water is essential not only to health but also to poverty reduction, food security, peace, human rights, ecosystems, and education.\n\n" +
                        "6. Urgent Need for Sustainable Water Management:\n" +
                        "   - Point: Effective water management is crucial to mitigate climate change, reduce water-related diseases, and prevent losses in biodiversity and ecosystem resilience.\n\n" +
                        "7. Civil Society's Accountability Role:\n" +
                        "   - Point: Civil society organizations should hold governments accountable, invest in water research, and promote the inclusion of women, youth, and indigenous communities in water resource governance.\n\n" +
                        "8. Role of World Water Day and World Toilet Day:\n" +
                        "   - Point: Participation in awareness campaigns, such as World Water Day and World Toilet Day, is essential to drive action on hygiene issues and promote sustainable water practices.\n\n" +
                        "9. Water-Related Deaths and Biodiversity Loss:\n" +
                        "   - Point: Without improved infrastructure and management, millions will die yearly from water-related diseases, leading to biodiversity loss and undermining sustainability efforts.\n\n" +
                        "10. Call for Collective Action:\n" +
                        "    - Point: Join the call for collective action, emphasizing the importance of universal access to water and sanitation, sustainable water-use efficiency, and the protection of water-related ecosystems for human and ecological well-being.\n\n",


                "https://www.isglobal.org/documents/10179/6939455/sdg+6+grande+en.jpg/2ce9861b-4bdd-4e19-9f59-750d52acc3c3?t=1539683454000",
                "https://www.un.org/sustainabledevelopment/water-and-sanitation/"
            )
        )

        dataList.add(
            DataItem(
                "Goal 7: Ensure access to affordable, reliable, sustainable and modern energy\n",
                "Embark on the journey towards sustainable power with 'PowerUp!' Goal 7 focuses on ensuring access to clean, affordable energy—an essential catalyst for global development. Join the call for investing in renewable sources, advancing technology, and accelerating universal access to modern energy services for a healthier planet and prosperous future.\n\n" +
                        "1. Global Energy Disparities Persist:\n" +
                        "   - Point: Despite progress, about 660 million people may lack electricity, and nearly 2 billion rely on polluting fuels for cooking by 2030.\n\n" +
                        "2. Dominant Contributor to Climate Change:\n" +
                        "   - Point: Energy consumption, responsible for 60% of global greenhouse gas emissions, is a major factor in climate change.\n\n" +
                        "3. Positive Strides: Access to Electricity Increases:\n" +
                        "   - Point: From 2015 to 2021, global access to electricity rose from 87% to 91%, showcasing positive strides.\n\n" +
                        "4. Clean Energy Investments for Universal Access:\n" +
                        "   - Point: Ensuring universal access to affordable electricity by 2030 necessitates investments in clean sources like solar and wind.\n\n" +
                        "5. Energy's Crucial Role in All Sectors:\n" +
                        "   - Point: A robust energy system is vital for sectors such as business, healthcare, education, agriculture, and technology.\n\n" +
                        "6. Challenges in Clean Cooking Solutions:\n" +
                        "   - Point: Despite improvements, 2.3 billion people lack access to clean and safe cooking fuels, demanding more focused attention.\n\n" +
                        "7. Global Impact of Fossil Fuels:\n" +
                        "   - Point: Traditional fossil fuels contribute to climate change, affecting well-being and the environment globally.\n\n" +
                        "8. Consequences of Energy Poverty:\n" +
                        "   - Point: Lack of electricity hampers various activities, impacting women, children, healthcare, education, and business competitiveness.\n\n" +
                        "9. Accelerating Transition to Sustainable Energy:\n" +
                        "   - Point: Countries and businesses can expedite the shift to sustainable energy through investments, efficient practices, and clean technologies.\n\n" +
                        "10. Individual Actions for Energy Conservation:\n" +
                        "    - Point: Individuals can contribute by saving electricity, adopting energy-efficient practices, and supporting businesses committed to renewable sources.\n\n",


                "https://www.isglobal.org/documents/10179/6939455/sdg+7+grande+en.jpg/89c1504a-8c51-4705-a389-c937d407f97f?t=1539683789000",
                "https://www.un.org/sustainabledevelopment/water-and-sanitation/"
            )
        )



        dataList.add(
            DataItem(
                "Goal 8: Promote inclusive and sustainable economic growth, employment and decent work for all \n",
                "Empower economies, jobs, and well-being with 'WorkWell!' Goal 8 focuses on fostering inclusive and sustainable economic growth, ensuring decent work for all. Join the call for diverse, innovative policies that create opportunities, tackle unemployment, and promote safe, empowering workplaces, driving progress towards a more equitable and prosperous world.\n\n" +
                        "1. Global Real GDP Slowdown:\n" +
                        "   - Point: Economic threats loom as global real GDP per capita growth is forecasted to slow down in 2023, impacting workers and informal employment.\n\n" +
                        "2. Informal Employment Rise:\n" +
                        "   - Point: Challenging economic conditions lead more workers towards informal employment, emphasizing the need for sustainable job opportunities.\n\n" +
                        "3. Progress in Labour Productivity:\n" +
                        "   - Point: While global labour productivity has increased, achieving Goal 8 requires more efforts to increase employment, especially for young people, and reduce labour market inequality.\n\n" +
                        "4. Decrease in Unemployment Rate:\n" +
                        "   - Point: The global unemployment rate declined to 5.4% in 2022, showing recovery from the COVID-19 shock, but challenges persist, particularly for young people.\n\n" +
                        "5. Definition of 'Decent Work':\n" +
                        "   - Point: 'Decent work' means providing productive employment, fair income, workplace security, social protection, and personal development prospects, underlining the importance of a social contract.\n\n" +
                        "6. Challenges in Job Creation:\n" +
                        "   - Point: Persistent lack of decent work opportunities and under-consumption pose challenges to creating quality jobs, requiring financial system reform and equitable pay.\n\n" +
                        "7. Global Unemployment Statistics:\n" +
                        "   - Point: In 2022, estimated global unemployment was 192 million, with projections indicating a further decrease to 5.3% in 2023.\n\n" +
                        "8. Impact of the Pandemic:\n" +
                        "   - Point: The pandemic disproportionately affected women and youth, emphasizing the need for strategies to address gender and age-related employment challenges.\n\n" +
                        "9. Investing in Youth Opportunities:\n" +
                        "   - Point: Investing in education, training, and leveling the playing field is crucial to providing youth with opportunities for decent employment.\n\n" +
                        "10. Ensuring Safe Working Environments:\n" +
                        "    - Point: Implementing health and safety measures, promoting supportive working environments, and protecting labour rights are essential for a sustainable and inclusive workforce.\n\n",

                "https://www.dlsl.edu.ph/wp-content/uploads/2019/11/E_SDG-goals_icons-individual-rgb-08.png",
                "https://www.un.org/sustainabledevelopment/economic-growth"
            )
        )
        dataList.add(
            DataItem(
                "Goal 9: Build resilient infrastructure, promote sustainable industrialization and foster innovation\n \n",
                "Embark on the path of progress with 'InnoBuild!' Goal 9 focuses on building resilient infrastructure, fostering sustainable industrialization, and driving innovation. Join the movement for inclusive economic development, technological advancement, and global connectivity to create a more resilient and equitable future.\n\n" +
                        "1. Global Manufacturing Decline and Trade Tensions:\n" +
                        "   - Industry Challenges Amid Global Economic Shifts:\n" +
                        "     The decline in global manufacturing, exacerbated by trade tensions, poses a threat to overall economic growth.\n\n" +
                        "2. Impact of COVID-19 on Manufacturing:\n" +
                        "   - Pandemic Fallout: Manufacturing's Struggles:\n" +
                        "     The pandemic-induced disruptions, including supply chain issues and economic shocks, have intensified challenges in the manufacturing sector.\n\n" +
                        "3. High Inflation, Energy Shocks, and Economic Deceleration:\n" +
                        "   - Economic Headwinds: Navigating Inflation and Shocks:\n" +
                        "     Factors like high inflation, energy price shocks, and economic deceleration contribute to the complexities faced by industries globally.\n\n" +
                        "4. Progress and Challenges in Mobile Connectivity:\n" +
                        "   - On the Grid: Advancements and Gaps in Mobile Connectivity:\n" +
                        "     While progress is seen with 97% global mobile coverage, some areas remain underserved, highlighting the need for comprehensive mobile broadband access.\n\n" +
                        "5. Investment in Research and Development:\n" +
                        "   - Fuelling Progress: Global Rise in R&D Investments:\n" +
                        "     Increased investments in research and development play a pivotal role in fostering technological progress and sustainable development.\n\n" +
                        "6. Role of Infrastructure Investments:\n" +
                        "   - Building Blocks of Progress: Infrastructure Investments:\n" +
                        "     Crucial to sustainable development, investments in infrastructure - from transport to ICT - empower communities and drive economic growth.\n\n" +
                        "7. Importance of Inclusive Industrialization:\n" +
                        "   - Empowering Growth: Inclusive Industrialization:\n" +
                        "     Inclusive and sustainable industrialization plays a key role in creating employment, driving economic forces, and introducing new technologies.\n\n" +
                        "8. Challenges in Industry's Role in Poverty Eradication:\n" +
                        "   - Industry's Dilemma: Balancing Growth and Poverty Eradication:\n" +
                        "     The industry's role in eradicating poverty and promoting sustainable development is critical, but challenges persist in achieving this balance.\n\n" +
                        "9. Costs of Inaction:\n" +
                        "   - Steep Consequences: The Price of Inaction:\n" +
                        "     Inaction in improving infrastructure and promoting technological innovation could lead to poor healthcare, inadequate sanitation, and limited access to education.\n\n" +
                        "10. Advocacy for Sustainable Industry Practices:\n" +
                        "    - Voices for Change: Advocating Sustainable Industry Practices:\n" +
                        "      Establishing standards, collaborating with NGOs, and promoting sustainable growth are essential steps towards a resilient and innovative industrial future.\n\n",
                "https://www.isglobal.org/documents/10179/6939455/SDG+9+grande+en.jpg/75d7c21e-f341-4d7d-8296-8c35bfa736ae?t=1539685336000",
                "https://www.un.org/sustainabledevelopment/infrastructure-industrialization/"
            )
        )


        dataList.add(
            DataItem(
                "Goal 10: Reduce inequality within and among countries \n",
                "Join the quest for a fairer world with 'Equalize!' Goal 10 focuses on reducing inequalities within and among countries. Explore the imperative of inclusive policies, global cooperation, and targeted measures to empower marginalized communities, eradicate discrimination, and foster a more equitable and sustainable future.\n\n" +
                        "1. Global Economic Shifts and Inequality Threats:\n" +
                        "   - Inequality's Impact on Development: Inequality poses a threat to long-term social and economic development, undermining poverty reduction and individual well-being.\n\n" +
                        "2. COVID-19's Disruptive Effect on Inequality Trends:\n" +
                        "   - Pandemic Challenges: Inequality Amidst COVID-19:    Emerging evidence suggests that the COVID-19 pandemic has disrupted the positive trend of falling within-country inequality, impacting the incomes of the poorest populations.\n\n" +
                        "3. Unprecedented Rise in Between-Country Inequality:\n" +
                        "   - Pandemic Fallout: Surging Global Inequality:    The pandemic has led to the largest rise in between-country inequality in three decades, emphasizing the need for comprehensive measures to address both within- and between-country disparities.\n\n" +
                        "4. Equitable Resource Distribution and Social Protection:\n" +
                        "   - Key to Reducing Inequality: Resource Equity and Social Protection:     Achieving equality demands equitable resource distribution, investments in education, social protection measures, and combating discrimination, fostering a holistic approach.\n\n" +
                        "5. Persisting Inequalities Worldwide:\n" +
                        "   - Inequality Across Dimensions: Inequalities based on income, gender, age, disability, and other factors persist globally, threatening social progress, fostering crime, and contributing to environmental degradation.\n\n" +
                        "6. Discrimination's Varied Forms:\n" +
                        "   - Intersecting Discrimination: Discrimination spans various forms, from religion and ethnicity to gender and sexual preference, underscoring the urgent need for measures to address discriminatory practices and hate speech.\n\n" +
                        "7. Global Interconnectedness and Shared Challenges:\n" +
                        "   - Interconnected World: Shared Challenges:Global challenges like poverty, climate change, and economic crises are interconnected, affecting countries worldwide, necessitating collaborative efforts for effective solutions.\n\n" +
                        "8. Transformative Change for Equality:\n" +
                        "   - Tackling Inequality Requires Transformation:To reduce inequality, transformative change is essential, encompassing efforts to eradicate extreme poverty, invest in health, education, social protection, and empower vulnerable communities.\n\n" +
                        "9. Empowering Social and Economic Growth:\n" +
                        "   - Inclusive Policies for Equality:Empowering social and economic growth within countries requires inclusive policies that eliminate discriminatory laws, promote equal opportunities, and reduce income inequalities.\n\n" +
                        "10. Global Representation and Fair Migration Policies:\n" +
                        "   - Global Cooperation for Equality:Ensuring fair representation of developing countries in global decision-making and promoting safe, regular, and responsible migration policies are crucial steps toward achieving global equality.\n\n",

                "https://www.isglobal.org/documents/10179/6939455/sdg+10+grande+en.jpg",
                "https://www.un.org/sustainabledevelopment/inequality"
            )
        )


        dataList.add(
            DataItem(
                "Goal 11:  Make cities inclusive, safe, resilient and sustainable \n",
                "Step into the future of urban living with 'CityVibe!' Goal 11 envisions inclusive, safe, resilient, and sustainable cities. Embrace the journey towards accessible housing, efficient transport, and green public spaces, ensuring the well-being of urban populations.\n\n" +
                        "1. Urbanization Challenges and Inequality:\n" +
                        "   - City Dilemma: Rapid Urbanization Outpacing Development: Cities globally grapple with rapid urbanization, leading to housing shortages, inadequate infrastructure, and the rise of slums, exacerbating inequality.\n\n" +
                        "2. COVID-19 Impact on Urban Inequality:\n" +
                        "   - Pandemic Fallout: Strain on Urban Development Gains: COVID-19 disrupts positive trends in within-country inequality, causing the largest surge in between-country inequality in three decades, emphasizing the need for resilient and adaptable urban planning.\n\n" +
                        "3. Global Urban Growth and Inadequate Infrastructure:\n" +
                        "   - Urban Challenges: Balancing Growth and Infrastructure: As urban populations surge, many cities struggle to keep pace, resulting in urban sprawl, air pollution, and limited public spaces, highlighting the urgency for sustainable urban development.\n\n" +
                        "4. Growth of Slums and Slum-Like Conditions:\n" +
                        "   - Settlement Struggles: Alarming Rise in Slum Populations: Over 1.1 billion people currently live in urban slums, with projections indicating an additional 2 billion in the next 30 years, underscoring the challenges of informal settlements.\n\n" +
                        "5. Energy Consumption and Pollution in Cities:\n" +
                        "   - Urban Impact: High Energy Consumption and Pollution: Despite occupying only 3% of the Earth's land, cities contribute significantly to energy consumption and carbon emissions, emphasizing the need for environmentally conscious urban practices.\n\n" +
                        "6. Vulnerability of Cities to Climate Change:\n" +
                        "   - Climate Peril: Building Resilience for Urban Centers: Concentrated populations in cities make them vulnerable to climate change and natural disasters, necessitating strategies for urban resilience to prevent human, social, and economic losses.\n\n" +
                        "7. Global Impact of Urban Inequality:\n" +
                        "   - Inequality's Reach: A Global Concern: Urban inequalities, including energy consumption and pollution levels, reverberate globally, affecting citizens' health, productivity, and lifestyles, emphasizing the interconnected nature of urban challenges.\n\n" +
                        "8. Role of Citizens in Urban Development:\n" +
                        "   - Empowering Change: Citizen Engagement for Urban Progress: Active citizen participation in governance and community development is pivotal, ensuring inclusive, safe, and sustainable cities by advocating for necessary changes and improvements.\n\n" +
                        "9. Cost-Benefit of Sustainable Urban Practices:\n" +
                        "   - Sustainable Urban Choices: Minimal Cost, Maximum Benefits: Implementing sustainable practices in urban development might incur costs, but the long-term benefits in terms of economic activity, improved quality of life, and environmental conservation outweigh the expenses.\n\n" +
                        "10. Vision for Inclusive and Quality Urban Life:\n" +
                        "    - Building Better Cities: Local Action for Global Impact: Individuals can contribute to goal attainment by envisioning and actively participating in the creation of communities with equal opportunities, improved living conditions, and enhanced public spaces.\n\n",


                "https://www.isglobal.org/documents/10179/6939455/sdg+11+grande+en.jpg/5f746206-b453-4630-a100-3a4a156248a4?t=1539693061000",
                "https://www.un.org/sustainabledevelopment/cities/"
            )
        )





        dataList.add(
            DataItem(
                "Goal 12:  Make cities inclusive, safe, resilient and sustainable \n",
                "Step into the future of urban living with 'CityVibe!' Goal 11 envisions inclusive, safe, resilient, and sustainable cities. Embrace the journey towards accessible housing, efficient transport, and green public spaces, ensuring the well-being of urban populations.\n\n" +
                        "1. Resource Depletion and Growing Populations:\n" +
                        "   - Balancing Act: With a global population projected to reach 9.8 billion by 2050, sustainable consumption becomes crucial to avoid depleting natural resources and ensure a balanced coexistence.\n\n" +
                        "2. Fossil Fuel Subsidies Surge Amid Global Crises:\n" +
                        "   - Energy Challenges: Despite a need for sustainable energy sources, fossil fuel subsidies nearly doubled from 2020 to 2021, highlighting the challenges in transitioning to more sustainable consumption patterns.\n\n" +
                        "3. Rise in Sustainability Reporting in Industries:\n" +
                        "   - Business Commitment: Industries witness a positive shift with a tripling trend in sustainability reporting, indicating increased awareness and commitment to integrating sustainability into core business practices.\n\n" +
                        "4. Urgency in Tackling Food Waste:\n" +
                        "   - Food Consumption Dilemma: Despite 931 million tons of annual food waste, millions go hungry globally, emphasizing the urgent need for policies, technologies, and education to address food loss.\n\n" +
                        "5. Environmental Degradation and Economic Progress:\n" +
                        "   - Unseen Costs: Economic and social progress over the last century has led to environmental degradation, emphasizing the need for a successful transition with improved resource efficiency and multilateral environmental agreements.\n\n" +
                        "6. Government Policies for Sustainable Practices:\n" +
                        "   - Policy Mandates: Governments play a crucial role in fostering sustainable consumption and production by enforcing policies that set waste reduction targets, promote circular economy practices, and support sustainable procurement.\n\n" +
                        "7. Transitioning to a Circular Economy:\n" +
                        "   - Designing for Sustainability: A shift to a circular economy involves designing products for longevity, repairability, and recyclability, promoting practices like reusing, refurbishing, and recycling to minimize waste.\n\n" +
                        "8. Individual Contributions to Sustainable Lifestyles:\n" +
                        "   - Empowering Change: Individuals can contribute by consuming less, choosing products with lower environmental impacts, reducing carbon footprints, and actively participating in sustainable lifestyles.\n\n" +
                        "9. Businesses Driving Sustainable Solutions:\n" +
                        "   - Corporate Responsibility: Businesses can drive change by understanding and mitigating the environmental and social impacts of their products, promoting innovation, and adopting sustainable practices in reporting cycles.\n\n" +
                        "10. Consumer Empowerment Through Informed Choices:\n" +
                        "    - Making a Difference: Consumers can make informed choices by reducing waste, choosing sustainable options, and influencing businesses to adopt environmentally conscious practices for a positive impact on society.\n\n",

                "https://www.isglobal.org/documents/10179/6939455/sdg+12+grande+en.jpg/9864261e-0751-4036-903e-b951a5bcae92?t=1539694206000",
                "https://www.un.org/sustainabledevelopment/sustainable-consumption-production/"
            )
        )






        dataList.add(
            DataItem(
                "Goal 13: Take urgent action to combat climate change and its impacts \n",
                "Join the global movement for climate action with 'ClimatePulse!' Goal 13 urges urgent and transformative measures to combat climate change and its far-reaching impacts. From rising temperatures to extreme weather events, it's time to act collectively to secure a sustainable future for all.\n\n" +
                        "1. Global Climate Crisis and Urgent Action:\n" +
                        "   - Climate Cataclysm Looming: Immediate Measures Required:\n" +
                        "     A looming climate crisis, caused by human activities, demands urgent and transformative action to combat escalating impacts, from extreme weather patterns to rising sea levels.\n\n" +
                        "2. Human-Induced Climate Change Threats:\n" +
                        "   - Human Activities as Culprits: Accelerated Climate Change:\n" +
                        "     Climate change, propelled by rising greenhouse gas emissions, poses a severe threat to life on Earth, occurring at rates faster than anticipated and leading to devastating consequences.\n\n" +
                        "3. Development Progress at Risk:\n" +
                        "   - Climate Change Undoing Progress: Devastating Effects on Development:\n" +
                        "     Unchecked climate change not only jeopardizes recent development progress but also triggers mass migrations, instability, and potential conflicts, underscoring the critical need for immediate and comprehensive action.\n\n" +
                        "4. Global Warming Targets and Urgency:\n" +
                        "   - Limiting Global Warming: Drastic Emission Cuts Required:\n" +
                        "     To limit global warming to 1.5°C above pre-industrial levels, emissions must be drastically reduced by almost half by 2030, necessitating urgent and transformative measures to ensure a sustainable future.\n\n" +
                        "5. Climate Crisis Impact on Economies:\n" +
                        "   - Disrupting Economies and Lives: Climate Change Consequences:\n" +
                        "     Climate change disrupts national economies, affecting lives, livelihoods, and vulnerable populations, with highly vulnerable regions experiencing significantly higher human mortality rates from climate-related disasters.\n\n" +
                        "6. Impending Climate Catastrophes:\n" +
                        "   - Unabated Climate Crisis: Escalating Disasters Worldwide:\n" +
                        "     The decade from 2010 to 2019 marked the warmest ever recorded, witnessing massive wildfires, hurricanes, droughts, and floods globally, signaling the urgent need for comprehensive and committed global efforts.\n\n" +
                        "7. Need for Vastly Raised Ambition:\n" +
                        "   - Ambition Gap in Climate Action: Moving Beyond Plans:\n" +
                        "     Addressing climate change requires a substantial increase in ambition across all levels, transcending plans and promises. Transformation in energy, industry, transport, and more is crucial for limiting temperature rise and achieving global climate goals.\n\n" +
                        "8. Business and Investor Role in Emission Reduction:\n" +
                        "   - Economic Sense of Emission Reduction: Business Responsibility:\n" +
                        "     Businesses and investors play a vital role in lowering emissions, aligning with economic sense. Understanding the environmental and social impacts and implementing sustainable practices are imperative for a resilient and sustainable future.\n\n" +
                        "9. Global Climate Finance and Adaptation Progress:\n" +
                        "   - Climate Finance Shortfall and Adaptation Efforts:\n" +
                        "     Despite global climate finance reaching $803 billion in 2019–2020, an increase from previous years, it falls short of levels needed. Progress in adaptation, disaster risk reduction, and climate resilience needs acceleration.\n\n" +
                        "10. Individual Action for Climate Change:\n" +
                        "    - Every Action Counts: Individual Steps for Change:\n" +
                        "      Individuals can contribute by reducing waste, making informed purchases, and supporting sustainable practices. Climate action at the individual level is essential to collectively combat climate change and secure a sustainable future.\n\n",

                "https://www.isglobal.org/documents/10179/6939455/sdg+13+grande+en.jpg/7c68b896-2993-41a3-b61c-f2080b2ac7a1?t=1539694700000",
                "https://www.un.org/sustainabledevelopment/sustainable-consumption-production/"
            )
        )








        dataList.add(
            DataItem(
                "Goal 14:Conserve and sustainably use the oceans, seas and marine resources\n",
                "\"Dive into Goal 14: Conserve and sustainably use the oceans, seas, and marine resources. Discover why healthy oceans are vital to human existence and the urgent actions needed to protect these essential ecosystems for a sustainable future.\"\n\n" +
                        "1. Ocean's Crucial Role in Life:\n" +
                        "   - Essential Ecosystem: Supporting Life on Earth:\n" +
                        "     Goal 14 emphasizes the paramount importance of conserving oceans, which cover three-quarters of the Earth's surface, provide key resources, and serve as a vital ecosystem crucial for human existence.\n\n" +
                        "2. Alarming Marine Pollution Levels:\n" +
                        "   - Plastic Threat: Doubling by 2040:\n" +
                        "     The article highlights the severe threat of marine pollution, with over 17 million metric tons in 2021, projected to double or triple by 2040, emphasizing the urgency to address plastic pollution, a major ocean pollutant.\n\n" +
                        "3. Ocean's Role in Climate Regulation:\n" +
                        "   - Climate Mitigation Hub: Absorbing CO2 and Heat:\n" +
                        "     Emphasizing the ocean's role as a climate regulator, it absorbs 23% of annual CO2 emissions and over 90% of excess heat. The article underscores the need for urgent climate action to protect marine ecosystems.\n\n" +
                        "4. Ongoing Ocean Degradation:\n" +
                        "   - Irresponsible Exploitation Impact:\n" +
                        "     Despite oceans' critical importance, decades of irresponsible exploitation have led to alarming degradation. The article stresses the urgent need for conservation efforts to safeguard this essential global resource.\n\n" +
                        "5. Economic Impact of Ocean Debris:\n" +
                        "   - Economic and Environmental Toll:\n" +
                        "     Highlighting the economic impact, the article notes that 5 to 12 million metric tonnes of plastic enter the ocean annually, costing approximately $13 billion per year. The majority of ocean floor litter comprises single-use plastic items.\n\n" +
                        "6. Tourism and Coastal Impact:\n" +
                        "   - Tourism's Double-Edged Sword:\n" +
                        "     The article addresses the impact of ocean-related tourism, supporting a $134 billion industry but also posing threats to natural resources and local culture if not carefully managed.\n\n" +
                        "7. Ocean's Connection to Health:\n" +
                        "   - Biodiversity for Pharmaceuticals:\n" +
                        "     Underscoring the intimate connection between ocean health and human health, the diverse marine species offer potential for pharmaceuticals, while marine fisheries support 57 million jobs globally.\n\n" +
                        "8. Global Cooperation for Ocean Conservation:\n" +
                        "   - International Efforts Needed:\n" +
                        "     Calling for increased international cooperation, the article emphasizes the importance of protecting vulnerable habitats through systems of government-protected areas, promoting biodiversity conservation.\n\n" +
                        "9. Urgent Action Against Ocean Acidification:\n" +
                        "   - Threats to Marine Life: Ocean Acidification:\n" +
                        "     Addressing the urgent issue of ocean acidification, the article stresses its threat to marine life, disrupting the food web and undermining vital services, emphasizing the need for enhanced scientific cooperation.\n\n" +
                        "10. Individual Choices for Ocean-Friendly Living:\n" +
                        "    - Sustainable Choices Matter: Reduce Plastic Use:\n" +
                        "      Encouraging individual responsibility, the article advocates ocean-friendly choices, including sustainable product purchases, reduced plastic usage, and a commitment to consume only what is needed for a healthier ocean.\n\n",

                "https://www.isglobal.org/documents/10179/6939455/sdg+14+grande+en.jpg/b026ed21-2e56-48ef-8b13-f33007285526?t=1539695930000",
                "https://www.un.org/sustainabledevelopment/oceans/"
            )
        )





        dataList.add(
            DataItem(
                "Goal 15 :Sustainably manage forests, combat desertification, halt and reverse land degradation, halt biodiversity loss\n",
                "Explore Goal 15: Sustainably manage forests, combat desertification, and halt biodiversity loss to protect and restore terrestrial ecosystems. Learn why preserving land is crucial for human existence, combating climate change, and preserving biodiversity, and discover the urgent actions needed for a sustainable future on Earth.\n\n" +
                        "1. Preserving Terrestrial Ecosystems:\n" +
                        "   - Goal 15 Overview: Sustainably Manage Land for a Sustainable Future:\n" +
                        "     Goal 15 focuses on conserving and restoring terrestrial ecosystems, managing forests sustainably, combating desertification, and halting biodiversity loss to ensure a balanced and sustainable planet.\n\n" +
                        "2. Triple Crisis Impacting Land:\n" +
                        "   - Climate Change, Pollution, and Biodiversity Loss:\n" +
                        "     The world faces a triple crisis involving climate change, pollution, and biodiversity loss, contributing to the degradation of at least 100 million hectares of land annually between 2015 and 2019.\n\n" +
                        "3. Agricultural Expansion and Deforestation:\n" +
                        "   - Direct Link to Food Systems: Agricultural Impact on Land:\n" +
                        "     Nearly 90% of deforestation is directly driven by agricultural expansion, posing a significant threat to global forests. Oil palm harvesting alone accounted for 7% of global deforestation from 2000 to 2018.\n\n" +
                        "4. Global Efforts for Forest Sustainability:\n" +
                        "   - Critical Need for Forest Ecosystem Preservation:\n" +
                        "     Global and regional efforts are crucial for sustaining forest ecosystems and their socio-economic functions, particularly in developing countries and tropical regions. Shifting humanity's relationship with nature is essential to achieving Goal 15.\n\n" +
                        "5. Kunming-Montreal Global Biodiversity Framework:\n" +
                        "   - Renewed Impetus for Goal 15: 2050 and 2030 Targets:\n" +
                        "     The recently adopted Kunming-Montreal Global Biodiversity Framework outlines outcome-oriented goals by 2050 and targets for 2030, providing renewed impetus for Goal 15 and emphasizing the need to shift humanity's relationship with nature.\n\n" +
                        "6. Biodiversity Decline:\n" +
                        "   - Alarming Biodiversity Decline: Urgency for Action:\n" +
                        "     Biodiversity is declining at an unprecedented rate, impacting the Earth's ecosystems. One-fifth of the Earth's land area is degraded, equivalent to the combined size of India and the Russian Federation, intensifying climate change and driving species to extinction.\n\n" +
                        "7. Loss of Forests and Its Consequences:\n" +
                        "   - Forests' Disappearance and Consequences:\n" +
                        "     The loss of forests results in the disappearance of livelihoods, increased carbon emissions, diminished biodiversity, and land degradation. While forest loss remains high, efforts in 2020 showed an increase or stability in the proportion of forests within protected areas globally.\n\n" +
                        "8. Species Extinction and Fragile Ecosystems:\n" +
                        "   - Irreversible Impact on Ecosystems: Species Extinction:\n" +
                        "     Human activities drive irreversible species extinction, upsetting the balance of nature and making ecosystems more fragile. Approximately 1 million animal and plant species are threatened with extinction, posing a significant challenge to ecosystem resilience.\n\n" +
                        "9. Zoonotic Diseases and Environmental Impact:\n" +
                        "   - Zoonotic Diseases and Environmental Degradation:\n" +
                        "     Increased demand for animal protein, unsustainable farming, wildlife exploitation, and the climate crisis contribute to the emergence of zoonotic diseases, affecting both human health and economic losses in livestock populations.\n\n" +
                        "10. Individual Actions for Land Conservation:\n" +
                        "    - Empowering Change: Individual Contributions to Land Conservation:\n" +
                        "      Individuals can contribute to land conservation by recycling, adopting locally-based and sustainably sourced diets, reducing plastic use, and supporting responsible ecotourism. Well-managed protected areas involving local communities are crucial for healthy ecosystems and human well-being.\n\n",

                "https://www.isglobal.org/documents/10179/6939455/SDG+15+grande+en.jpg/9cb6fee4-a078-4dda-8c2a-b60b22ea59bf?t=1539858509000",
                "https://www.un.org/sustainabledevelopment/biodiversity/"
            )
        )





        dataList.add(
            DataItem(
                "Goal 16 : Promote just, peaceful and inclusive societies\n\n",
                "Dive into Goal 16: Promote just, peaceful, and inclusive societies. Discover the imperative of fostering safety, justice, and inclusive governance worldwide, free from violence and discrimination for a harmonious and accountable global community.\n\n" +
                        "1. Global Surge in Conflict-Related Deaths in 2022:\n" +
                        "   - Alarming Escalation: The year 2022 witnessed a shocking 50% increase in conflict-related civilian deaths, marking a concerning setback in the global pursuit of peace, notably attributed to the war in Ukraine.\n\n" +
                        "2. Destructive Impact of Armed Violence on Development:\n" +
                        "   - Development Undermined: High levels of armed violence and insecurity profoundly hinder a country's development, perpetuating conflicts, violence, and instability, ultimately impeding progress and causing significant loss of life and resources.\n\n" +
                        "3. The Role of Rule of Law and Human Rights:\n" +
                        "   - Key to Lasting Solutions: Strengthening the rule of law and promoting human rights are crucial elements in finding lasting solutions to conflict and insecurity. These efforts involve reducing illicit arms flow, combating corruption, and ensuring inclusive participation.\n\n" +
                        "4. Peace as a Prerequisite for Social and Economic Progress:\n" +
                        "   - Fundamental Condition: Goal 16 aligns with the broader human rights framework by emphasizing societies that respect individual rights, privacy, freedom of expression, and access to information. Peace is identified as a fundamental precondition for social and economic development.\n\n" +
                        "5. Equal Access to Justice for Individual Rights:\n" +
                        "   - Justice for All: Equal access to justice is deemed essential for protecting individual rights, resolving disputes, and preventing the marginalization or mistreatment of vulnerable populations.\n\n" +
                        "6. Impact of Crimes on Peaceful Societies:\n" +
                        "   - Threats to Peace: Crimes such as homicides, trafficking, and organized crimes pose significant threats to peaceful societies, affecting countries globally. Discriminatory laws and practices also contribute to unrest.\n\n" +
                        "7. Negative Consequences of Armed Violence:\n" +
                        "   - Development Impairment: Armed violence negatively impacts a country's development, leading to economic setbacks and fostering long-standing grievances among communities. Additionally, violence adversely affects children's health, well-being, and overall development.\n\n" +
                        "8. Lack of Access to Justice and Institutional Dysfunction:\n" +
                        "   - Unresolved Conflicts: Lack of access to justice results in unresolved conflicts and prevents people from obtaining protection and redress. Institutions operating outside legitimate laws are susceptible to abuse of power and hinder effective public service delivery.\n\n" +
                        "9. Exclusion, Discrimination, and Potential Violence:\n" +
                        "   - Human Rights Violations: Exclusion and discrimination violate human rights, fostering resentment and animosity that could escalate into violence. Inclusive and respectful practices are essential for building a harmonious society.\n\n" +
                        "10. Individual Empowerment for Inclusive Governance:\n" +
                        "    - Exercise Your Rights: Individuals can contribute by exercising their rights to hold elected officials accountable, promoting freedom of information, and advocating for inclusion and respect across diverse backgrounds.\n\n",
                "https://www.isglobal.org/documents/10179/6939455/sdg+16+grande+en.jpg/a4580173-2324-4ba1-83d8-418cec10e4e6?t=1539859284000",
                "https://www.un.org/sustainabledevelopment/peace-justice"
            )
        )


        dataList.add(
            DataItem(
                "Goal 17 :Revitalize the global partnership for sustainable development\n\n",
                "Dive into Goal 17: Revitalize the global partnership for sustainable development. Explore the imperative of fostering collaboration among countries, private sectors, and civil society to ensure universal commitment and action toward achieving the 2030 Agenda and leaving no one behind in our collective journey to sustainable development\n\n" +
                        "1. Global Surge in Conflict-Related Deaths in 2022:\n" +
                        "   - Alarming Escalation: The year 2022 witnessed a shocking 50% increase in conflict-related civilian deaths, marking a concerning setback in the global pursuit of peace, notably attributed to the war in Ukraine.\n\n" +
                        "2. Destructive Impact of Armed Violence on Development:\n" +
                        "   - Development Undermined: High levels of armed violence and insecurity profoundly hinder a country's development, perpetuating conflicts, violence, and instability, ultimately impeding progress and causing significant loss of life and resources.\n\n" +
                        "3. The Role of Rule of Law and Human Rights:\n" +
                        "   - Key to Lasting Solutions: Strengthening the rule of law and promoting human rights are crucial elements in finding lasting solutions to conflict and insecurity. These efforts involve reducing illicit arms flow, combating corruption, and ensuring inclusive participation.\n\n" +
                        "4. Peace as a Prerequisite for Social and Economic Progress:\n" +
                        "   - Fundamental Condition: Goal 16 aligns with the broader human rights framework by emphasizing societies that respect individual rights, privacy, freedom of expression, and access to information. Peace is identified as a fundamental precondition for social and economic development.\n\n" +
                        "5. Equal Access to Justice for Individual Rights:\n" +
                        "   - Justice for All: Equal access to justice is deemed essential for protecting individual rights, resolving disputes, and preventing the marginalization or mistreatment of vulnerable populations.\n\n" +
                        "6. Impact of Crimes on Peaceful Societies:\n" +
                        "   - Threats to Peace: Crimes such as homicides, trafficking, and organized crimes pose significant threats to peaceful societies, affecting countries globally. Discriminatory laws and practices also contribute to unrest.\n\n" +
                        "7. Negative Consequences of Armed Violence:\n" +
                        "   - Development Impairment: Armed violence negatively impacts a country's development, leading to economic setbacks and fostering long-standing grievances among communities. Additionally, violence adversely affects children's health, well-being, and overall development.\n\n" +
                        "8. Lack of Access to Justice and Institutional Dysfunction:\n" +
                        "   - Unresolved Conflicts: Lack of access to justice results in unresolved conflicts and prevents people from obtaining protection and redress. Institutions operating outside legitimate laws are susceptible to abuse of power and hinder effective public service delivery.\n\n" +
                        "9. Exclusion, Discrimination, and Potential Violence:\n" +
                        "   - Human Rights Violations: Exclusion and discrimination violate human rights, fostering resentment and animosity that could escalate into violence. Inclusive and respectful practices are essential for building a harmonious society.\n\n" +
                        "10. Individual Empowerment for Inclusive Governance:\n" +
                        "    - Exercise Your Rights: Individuals can contribute by exercising their rights to hold elected officials accountable, promoting freedom of information, and advocating for inclusion and respect across diverse backgrounds.\n\n",
                "https://www.isglobal.org/documents/10179/6939455/sdg+17+grande+en.jpg/1a042b03-7f43-4381-bdd5-fc7facda1f1d?t=1539860106000",
                "https://www.un.org/sustainabledevelopment/globalpartnerships/"
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

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    override fun onDestroy() {
        super.onDestroy()

        networkUtils.cleanup()

    }
}