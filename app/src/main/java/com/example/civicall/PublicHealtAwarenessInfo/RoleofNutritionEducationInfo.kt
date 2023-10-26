package com.example.civicall.PublicHealtAwarenessInfo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataAdapter
import com.example.civicall.CivicEngagementInfo.DataItem
import com.example.civicall.R

class RoleofNutritionEducationInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roleof_nutrition_education_info)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Create a list of data to display in the RecyclerView
        val dataList = ArrayList<DataItem>()

        dataList.add(
            DataItem(
                "NUTRITION PROGRAMS: NURTURING PUBLIC HEALTH THROUGH EDUCATIONAL INITIATIVES",
                "As schools prepare for the return of students, the importance of proper nutrition cannot be overstated. Ensuring that students have access to nutritious meals is not only a matter of their well-being but also a fundamental aspect of educational initiatives designed to nurture public health.\"\"\n\n" +
                        "1. CALL FOR NUTRITIONAL FORTIFICATION: Emphasis on the need for nutritional fortification in preparation for full face-to-face classes.\n\n" +
                        "2. NUTRITION SURVEY FINDINGS: Highlights from the Expanded National Nutrition Survey (ENNS) regarding the nutritional status of Filipino children and the prevalence of undernutrition.\n\n" +
                        "3. STUNTED GROWTH AND VULNERABILITY: Discussing the impact of stunted growth on the vulnerability of children to diseases, including COVID-19.\n\n" +
                        "4. PERSISTENT UNDERNUTRITION: Addressing the persistence of undernutrition among populations in rural areas and low-income households.\n\n" +
                        "5. SLOW PROGRESS TOWARDS SDGs: Discussing the slow progress in achieving the United Nations Sustainable Development Goals (SDGs) related to nutrition.\n\n" +
                        "6. MALNUTRITION AND IMMUNE SYSTEM: Exploring how malnutrition weakens the immune system and its implications for battling health threats.\n\n" +
                        "7. MULTI-STAKEHOLDER INITIATIVES: Advocating for the involvement of schools, families, local government units, and national agencies in addressing malnutrition.\n\n" +
                        "8. GOVERNMENT-SCHOOL COLLABORATION: Discussing the collaborative efforts between DOST-FNRI and the Department of Education (DepEd) to integrate nutritious products in school feeding programs.\n\n" +
                        "9. COMPLEMENTARY FOOD DEVELOPMENT: Highlighting efforts to develop complementary foods for children aged 6 to 24 months to address their energy needs.\n\n" +
                        "10. IMPORTANCE OF NUTRITION EDUCATION: Stressing the importance of nutrition education and the role of parents, teachers, and influencers in promoting good nutrition.",
                R.drawable.img_336,
                "https://www.rappler.com/bulletin-board/dost-fnri-says-nutrition-critical-students-health-face-to-face-classes-implementation/",
                "https://www.rappler.com/tachyon/2022/11/face-to-face-class-pinyahan-elementary-november-2-2022-001.jpg?resize=1400%2C934&zoom=1"
            )
        )
        dataList.add(
            DataItem("INTEGRATING NUTRITION INTO THE SCHOOL CURRICULUM FOR HEALTHIER GENERATIONS",
                "For a decade, Nestlé Philippines has been dedicated to shaping healthier generations through its Nestlé Wellness Campus program. This initiative integrates nutrition education into the school curriculum, reaching millions of students and teachers to promote healthier lifestyles.\n\n" +
                        "1. ALARMING MALNUTRITION RATES: Highlighting the alarming rates of malnutrition, with one in four Filipino school-aged children suffering from stunted growth.\n" +
                        "2. GOVERNMENT PRIORITIZING MALNUTRITION: The government's commitment to addressing malnutrition, starting with the Philippine Multisectoral Nutrition Project (PMNP).\n" +
                        "3. NESTLÉ'S TEN-YEAR JOURNEY: Nestlé Philippines' decade-long commitment to combating malnutrition through the Nestlé Wellness Campus program.\n" +
                        "4. PROMOTING HEALTH AND WELLNESS EDUCATION: Explaining the objectives and activities of the Nestlé Wellness Campus program.\n" +
                        "5. STARTING IN 2013: Discussing the program's origins and initial goals in promoting nutrition and physical activity.\n" +
                        "6. EDUCATIONAL RESOURCES FOR BALANCED HABITS: Highlighting the development of educational materials, modules, and flexible learning resources.\n" +
                        "7. PROMOTING ACTIVE LIFESTYLES: Discussing the dancercise program and flexible learning materials for both in-person and distance education.\n" +
                        "8. FOSTERING COMMUNITIES OF HEALTH-CONSCIOUSNESS: Describing the role of Facebook communities, inter-school contests, and inter-region events in promoting the program's goals.\n" +
                        "9. IMPACTING MILLIONS OF STUDENTS AND TEACHERS: Showcasing the widespread reach of the Nestlé Wellness Campus program, covering seven regions in the Philippines.\n" +
                        "10. ASSESSING KNOWLEDGE AND BEHAVIOR CHANGE: How the program has led to improved nutrition knowledge and healthier habits among students, parents, and teachers.",
                R.drawable.img_337,
                "https://globalnation.inquirer.net/213920/a-decade-of-helping-filipino-children-lead-happier-healthier-lives-through-nutrition-education",
                "https://www.rappler.com/tachyon/r3-assets/612F469A6EA84F6BAE882D2B94A4B421/img/F64BBBFA77AE405E8721DE8429EA3A9C/dswd-supplementary-feeding-program-20140130.jpg")
        )
        dataList.add(
            DataItem("FOOD SECURITY AND ITS CONNECTION TO PUBLIC HEALTH NUTRITION",
                "In the Philippines, the struggle for food security is deeply entwined with public health nutrition. As hunger and food insecurity persist, understanding the link between food access, affordability, and health becomes a pressing concern.\"\n\n" +
                        "1. FOOD SECURITY CRISIS: The Philippines grapples with a food security crisis, marked by increasing hunger and food insecurity, raising concerns about the welfare of its citizens.\n" +
                        "2. ALARMING HUNGER RATES: A stark rise in hunger incidence from 9.3% to 21.1% during the fourth quarter of 2020 reveals the severity of the issue, affecting millions of households.\n" +
                        "3. RISING SEVERE HUNGER: The rate of severe hunger surged from 1.4% to 5% in the same period, emphasizing the urgent need for action to address this growing problem.\n" +
                        "4. CHALLENGES IN FOOD ACCESS: Lack of access to food, especially among low-income Filipinos, is evident through long lines at community pantries and dwindling supplies of affordable rice.\n" +
                        "5. THREAT TO CHILD NUTRITION: Malnutrition, affecting nearly a third of children under five, is largely attributed to the absence of nutritious food, posing a long-term health risk.\n" +
                        "6. DISAPPEARING AFFORDABLE RICE: Low-priced National Food Authority rice has vanished from the market, causing financial strain on consumers as the price of commercial rice surges.\n" +
                        "7. GOVERNMENT INTERVENTIONS: Initiatives, such as direct purchase of farm produce for community pantries and the promotion of backyard and community food production, aim to alleviate food scarcity.\n" +
                        "8. PLIGHT OF PALAY FARMERS: Low prices have pushed palay farmers into hardship, with some rice millers becoming importers due to attractive trading margins.\n" +
                        "9. COMPLEX FOOD SECURITY DEFINITION: Achieving a common understanding of food security is challenging due to multifaceted components, including availability, access, utilization, and stability of food.\n" +
                        "10. NEED FOR COMPREHENSIVE APPROACH: To improve food security, it's essential to address not only rice but other staples, encourage local production, and involve all stakeholders, emphasizing the importance of competitiveness in various food items.",
                R.drawable.img_338,
                "https://newsinfo.inquirer.net/1431945/food-security-in-ph-a-task-for-everyone",
                "https://newsinfo.inquirer.net/files/2023/09/529587.jpeg")
        )

        dataList.add(
            DataItem("TRANSFORMING DIETARY HABITS: A PATHWAY TO IMPROVED PUBLIC HEALTH",
                "In the pursuit of food security and public health in the Philippines, reevaluating dietary choices is paramount. This article explores the transformative power of sustainable diets as a pathway to improved public health and food security.\"\n" +

                        "1. RETHINKING DIETARY CHOICES: To ensure food security and public health, the Philippines must reconsider dietary habits and their impact on the environment.\n" +
                        "2. HUNGER AND FOOD SECURITY: A growing population faces hunger and food insecurity, highlighting the urgency of reevaluating food production and consumption.\n" +
                        "3. HEALTH IMPACTS OF CURRENT DIETS: Unhealthy diets are linked to noncommunicable diseases, one of the leading causes of death in the country.\n" +
                        "4. FOOD PRODUCTION METHODS: The current focus on providing necessary food disregards biodiversity and climate stability, leading to food waste while millions go hungry.\n" +
                        "5. FOOD WASTE AND HUNGER: Paradoxically, the Philippines witnesses both food waste and involuntary hunger, emphasizing the need for a balanced food system.\n" +
                        "6. SUSTAINABLE DIET RECOMMENDATIONS: A WWF study advocates for sustainable diets that reduce food waste and promote nature-positive production methods.\n" +
                        "7. ENVIRONMENTAL BENEFITS: Shifting to sustainable diets can significantly reduce greenhouse gas emissions, wildlife loss, and agricultural land use while promoting human health.\n" +
                        "8. COUNTRY-SPECIFIC APPROACHES: Sustainable diets will vary by country, with some needing to reduce certain food consumption and others maintaining traditional dietary patterns.\n" +
                        "9. FOOD SOVEREIGNTY CONNECTION: Sustainable diets align with the concept of food sovereignty, emphasizing people's right to culturally acceptable and ecosystem-friendly food production.\n" +
                        "10. POLICY RECOMMENDATIONS: Revising national dietary guidelines to reflect sustainable diets can be a pivotal step toward achieving food security and public health improvements.",
                R.drawable.img_339,
                "https://opinion.inquirer.net/166118/rethinking-filipino-diet-can-help-ensure-food-security-and-healthy-lifestyle",
                "https://newsinfo.inquirer.net/files/2022/10/WhatsApp-Image-2022-10-17-at-11.02.13-AM.jpeg")
        )

        dataList.add(
            DataItem("COMBATTING MALNUTRITION: A CRUCIAL CHALLENGE FOR PUBLIC HEALTH ADVOCATES",
                "In the fight against malnutrition in the Philippines, a five-year plan has emerged as a crucial challenge for public health advocates. The \"Philippine Plan of Action for Nutrition 2023 - 2028\" emphasizes collective efforts to ensure access to nutritious food and improve feeding practices.\n\n\n" +
                        "1. WHOLE-OF-SOCIETY APPROACH: The Philippines' five-year nutrition plan calls for comprehensive interventions involving various sectors to combat malnutrition.\n" +
                        "2. OFFICIAL LAUNCH OF PPAN: Health Secretary Teodoro Herbosa and Science Secretary Renato Solidum Jr. lead the official launch of the Philippine Plan of Action for Nutrition (PPAN) for 2023-2028.\n" +
                        "3. CRITICAL NUTRITION IN FIRST 1,000 DAYS: Nutrition is most critical in the first 1,000 days of life, from pregnancy to the second year of a child's life, as poor nutrition can lead to irreversible stunting and hinder brain development.\n" +
                        "4. 11TH NATIONAL PLAN: The PPAN represents the 11th national plan to address malnutrition in the Philippines since 1974.\n" +
                        "5. FOCUS ON MULTIPLE MALNUTRITION FORMS: The new plan targets various forms of malnutrition, including stunting, wasting, overweight, obesity, poor infant and young child feeding practices, and micronutrient deficiencies.\n" +
                        "6. CHILD STUNTING PREVALENCE: The Philippines still faces high child stunting rates, with 26.4% of children under five years being short for their age.\n" +
                        "7. CONSEQUENCES OF STUNTED GROWTH: Children with stunted development are at higher risk of mortality, reduced intelligence quotient, and decreased earning potential.\n" +
                        "8. ECONOMIC IMPACT: On a macroeconomic level, the country loses about 1.5 to 3 percent of its GDP annually due to child stunting.\n" +
                        "9. MAJOR INTERVENTIONS: The PPAN includes interventions to increase access to nutritious food, promote behavioral change in feeding practices, and enhance access to quality nutrition services.\n" +
                        "10. NUTRITION INITIATIVES: Specific interventions involve food gardens, Kadiwa stores, dietary supplementation, support for breastfeeding, growth monitoring, and adolescent health programs.",
                R.drawable.img_340,
                "https://newsinfo.inquirer.net/1826601/5-year-plan-to-fight-malnutrition-formed",
                "https://newsinfo.inquirer.net/files/2023/09/529588-620x454.jpeg")
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