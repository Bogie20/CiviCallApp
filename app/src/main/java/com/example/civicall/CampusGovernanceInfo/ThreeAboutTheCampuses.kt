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
import com.example.civicall.databinding.ActivityThreeAboutTheCampusesBinding

class ThreeAboutTheCampuses : AppCompatActivity() {
    private lateinit var binding:ActivityThreeAboutTheCampusesBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding = ActivityThreeAboutTheCampusesBinding.inflate(layoutInflater)
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

        // Create a SpannableString with a larger text size for the specific portion
        dataList.add(
            DataItem(
                "PABLO BORBON CAMPUS",
                "Pablo Borbon is the oldest campus in the university and serves as the seat of the administration of the institution. It is located at Rizal Avenue, Batangas City, and has a land area of 5.96 hectares. Nestled at the heart of the city, its proximity to the Batangas International Port and convenient access to the Southern Tagalog Arterial Road (STAR), coupled with its strong program offerings in a 21st century environment, makes it an ideal academic destination for students and opens collaboration opportunities with national and international partners.\"\n\n",

                "https://lh3.googleusercontent.com/p/AF1QipO0R1UqV2DNU9o086db7Il4CYwO5q0HTWDqS6tI=s1360-w1360-h1020",
                "https://batstate-u.edu.ph/campuses/pablo-borbon/"

            )
        )
        dataList.add(
            DataItem(
                "LEMERY CAMPUS",
                "BatStateU Lemery is the second smallest campus in the university in terms of land area, located in Brgy. Bagong Sikat, Lemery, Batangas. Despite this, its program offerings, especially in education and business and management, remain strong and in demand. Lemery is a first class municipality that is a growing urban center in Western Batangas. It serves as a provincial urban center for its surrounding rural municipalities, which highlight the growth of businesses, along the establishment of two shopping malls in the area. It also hosts the largest public high school in the first legislative district of Batangas.\"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/campus-lemery-1.jpg",
                "https://batstate-u.edu.ph/campuses/lemery/"

            )
        )

        dataList.add(
            DataItem(
                "ROSARIO CAMPUS",
                "The one-hectare land of the campus in Barangay Namunga, Rosario, Batangas was donated by the generous Inandan and Zuño families of the municipality. As an expression of gratitude to the donors, the first school building of the campus was named after Pedro Inandan, while the campus was named after Jose B. Zuño. Rosario is a first class municipality that has enabled business and industry to flourish, and is host to almost a hundred private and public educational institutions and learning centers.\"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2021/09/Batstateu-Rosario-scaled.jpg",
                "https://batstate-u.edu.ph/campuses/rosario/"

            )
        )


        dataList.add(
            DataItem(
                "ALANGILAN CAMPUS",
                "Acquired by the university in 1984, Alangilan is the second oldest campus in the university. Located in Golden Country Homes, Brgy. Alangilan, Batangas City, it has total land area of 5.62 hectares; the three colleges and research hubs in the campus occupy 2.89 hectares, while 2.73 hectares were recently acquired for the Knowledge, Innovation, and Science Technology (KIST) Park, the first KIST Park registered under the Philippine Economic Zone Authority in the country.\"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/11/Alangilan-entrance-facade.jpg",
                "https://batstate-u.edu.ph/campuses/alangilan/"

            )
        )


        dataList.add(
            DataItem(
                "MABINI CAMPUS",
                "The newest campus in the university is BatStateU Mabini with its operations starting only in 2018. Through the generosity of the local municipal government and the Yu family, the youngest BatStateU campus was established on a four-hectare property with the three-storey Josefina L. Yu Hall as its first academic infrastructure. Mabini, being a first class municipality, has a booming economy and a hub for business industries primarily because of its diving destinations.\"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/Mabini.jpg",
                "https://batstate-u.edu.ph/campuses/mabini/"

            )
        )



        dataList.add(
            DataItem(
                "SAN JUAN CAMPUS",
                "The Batangas State University (also translated in Filipino as Pambansang Pamantasan ng Batangas and abbreviated as BatStateU) is a state university in the province of Batangas. It is established in 1903 as a training school, Batangas State University is the oldest higher education institution in the Region. It was granted a state college status in 1968, renamed Pablo Borbon Memorial Institute of Technology, and was finally elevated into a state university in 2001. In 2000, a memorandum of agreement was signed for the purpose of establishing more extension campuses including San Juan Campus. At present, the university has twelve extension campuses in Batangas.\n" +
                        "\n" +
                        "Batangas State University - San Juan (BatStateU - San Juan), in Talhiban 2.0, is a public satellite campus situated at the municipality of San Juan, Batangas with the land area of 4933 sq. m. near Department of Agriculture. The campus operates under the Batangas State University system and is the second campus among the system that has a few numbers of programs offered next to the Lobo campus.\n" +
                        "\n" +
                        "The existence of Batangas State University last June, 1999 in San Juan, Batangas paved the way of sending students to a nearer institution which cater quality and relevant education. It began to open its doors to college students and had evolved into a more improved and full-pledged tertiary institution.\n" +
                        "\n" +
                        "          With the present population of five hundred nine (514) students enrolled with 21 faculty members in the various degree programs (College of Teacher Education, College of Industrial Technology and College of Business, Economics, and International Hospitality Management), the University will always be true to its vision to be an institutional model for its culture and excellence in higher education as shown in its people and product. The University will remain steadfast in its mission as a premier institution of learning and continue to strengthen its curricular offerings to produce globally competitive graduates.\"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/sanjuan-slider-1.jpg",
                "https://batstate-u.edu.ph/campuses/san-juan/"

            )
        )



        dataList.add(
            DataItem(
                "NASUGBU CAMPUS",
                "With geographical coordinates of 14.0669679943, and 120.626135987, the campus is bounded to the North and East by Nasugbu Poblacion proper, to the South by Brgy.Bucana, and to the West by Nasugbu Bay. Landmarks near the campus includes the Globe Telecom Building and Kainan sa Dalampasigan Restaurant. The school is easily accessible by Public Transport Services coming from PITX, Coastal Road and Pasay bus terminals in Manila. It is also a quick two-hour drive by car through the old road from Southern Luzon Expressway to Tagaytay City then farther ahead to Tagaytay-Nasugbu Highway. Another alternative route is via Cavitex Highway and then through the largest subterranean tunnel in the Philippines that goes through Mount Palay Palay down to the rest of Nasugbu-Ternate Highway, leading to the town proper that is conveniently close to the campus. \n" +
                        "\n" +
                        "The University campus has the expanse of 4.159 hectares. The land area is divided in to two compounds.  Area I as of writing, is the side of the property adjacent to shores of Nasugbu, where majority of the buildings are located, including the admin building which is considered as the oldest structure in the campus dating back to the school’s founding years.\n" +
                        "\n" +
                        "The second half of the site is known to many as the Physical Education School Sports (PESS) Ground or the Roxas-Gargollo Sports Field. Measuring at 1.6849 hectare, this spacious open field is a frequent venue for PE subjects, military trainings, sports events and other outdoor activities. The Batstate U Hostel that serves as a function hall for local events stands proudly at the southern part of the field along side the Higher Education Building where most of the classes of the colleges of different programs are held. \"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/Nasugbu-facade-scaled.jpg",
                "https://batstate-u.edu.ph/campuses/nasugbu/"

            )
        )



        dataList.add(
            DataItem(
                "MALVAR CAMPUS",
                "Malvar Campus is the former Jose P. Laurel Polytechnic College (JPLPC), a largely vocational school located in a 3.26-hectare property in Poblacion, Malvar, Batangas, was incorporated into Batangas State University by virtue of Republic Act 9045 in 2001. It is the third largest campus in the university. Since Malvar is just 68 km south of Manila and is conveniently accessible by STAR tollway, it is part of the Manila conurbation, making it prime for urbanization and shared industrial growth. The LIMA Technology Center is also located in Malvar; it is an industrial park and a potential world-class business hub and commercial destination owned by the real estate arm of the Aboitiz Group, one of the country’s biggest business conglomerates.\n" +
                        "\n" +
                        "The university’s program offerings are recognized by the country’s Commission on Higher Education. These are designed to provide opportunities for students to discover their potential and enhance their technical and creative skills in a vibrant academic environment. Each program offering is anchored on pragmatic, relevant, and socially responsive curricula that train students to be globally competitive by embracing transdisciplinary, social intelligence, new media literacy, design mindset, and physical and virtual collaboration. The university believes that these skills are required in emerging professional and social environments. \"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/malvar-slider-1.jpg",
                "https://batstate-u.edu.ph/campuses/malvar/"

            )
        )



        dataList.add(
            DataItem(
                "LOBO CAMPUS",
                "While BatStateU Lobo has the smallest actual-campus land area at 0.12 ha located in Brgy. Masaguitsuit, it is the location of the only College of Agriculture and Forestry in the province of Batangas, and is one of the very few in CALABARZON. Lobo has white sand beaches and protected mangrove forests, fish sanctuaries, and marine protected areas, while agriculture and food production are its main industries. Its seas are part of the Verde Island Passage, recognized to be the center of the center of marine shorefish biodiversity in the world.\"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/lobo-slider-2.jpg",
                "https://batstate-u.edu.ph/campuses/lobo/"

            )
        )



        dataList.add(
            DataItem(
                "BALAYAN CAMPUS",
                "Batangas State University Balayan is one of the university’s oldest extension campuses located in Brgy. Caloocan, Balayan. Established in 1994, BatStateU Balayan has since been offering technology and technical-vocational education programs to the youth of the community. Balayan is a first-class municipality that hosts a number of industries and small and medium-scale enterprises.\"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/campus-balayan-canteen.jpg",
                "https://batstate-u.edu.ph/campuses/balayan/"

            )
        )


        dataList.add(
            DataItem(
                "LIPA CAMPUS",
                "Located in Brgy. Marawoy, Lipa City, the BatStateU Lipa is named Don Claro M. Recto campus as a tribute to the prominent public servant from Lipa, Batangas. The campus has shown strong academic performance and its programs have established a positive reputation in the community despite the presence of other higher education institutions in the area. Lipa City is a first class city is only 78km south of Manila, easily accessible via STAR Tollway, and has become a key commercial, financial, and medical center in the province.\"\n\n",

                "https://batstate-u.edu.ph/wp-content/uploads/2020/10/lipa-slider-3.jpg",
                "https://batstate-u.edu.ph/campuses/lipa/"

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