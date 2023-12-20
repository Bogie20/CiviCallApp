package com.example.civicall.EmergencyCon

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import java.util.Locale

class SanJuanCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_san_juan_cont)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()

        val phoneOptionsSanjuan = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437239350"),// pddrrmo
            2 to arrayOf("0439800385"),// incident
            3 to arrayOf("0434250139"),// infirmary
            4 to arrayOf("0434250139"),// security office
            5 to arrayOf("0435755192"),// service office
            6 to arrayOf("0435754166","09156022026"),// bfp
            7 to arrayOf("09178093429","09985855848"),// coast guard
            8 to arrayOf("0435753408"),// divine care
            9 to arrayOf("09171429378"),// redcross
            10 to arrayOf("09153850205","09985985701"),// pnp
            11 to arrayOf("0435753756"),// district host
            12 to arrayOf("0435753138"),// doctors host
            13 to arrayOf("0435753210"),// mdrrmo
            14 to arrayOf("0435753992"),// health unit
        )
        adapter = ContactAdapter(mList, phoneOptionsSanjuan)

        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<ContactData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }
                adapter.setFilteredList(filteredList)
        }
    }

    private fun addDataToList() {
        mList.add(ContactData("NATIONAL EMERGENCY\n"+"HOTLINE", R.drawable.nationalhotline))
        mList.add(ContactData("BATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("BATSTATE U INCIDENT \n" + "COMMANDERS OFFICE /\n" + "EXECUTIVE DIRECTORS\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BATSTATE SAN JUAN\n"+ "INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("BATSTATEU SAN JUAN\n"+ "SECURITY OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BATSTATEU SAN JUAN\n" + "CAMPUS EXTENSION\n" + "SERVICE OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BUREAU OF FIRE\n"+"PROTECTION\n"+"SAN JUAN", R.drawable.bfp))
        mList.add(ContactData("COAST GUARD\n" + "SAN JUAN", R.drawable.pcg))
        mList.add(ContactData("DIVINE CARE\n"+"HOSPITAL", R.drawable.divinecare))
        mList.add(ContactData("PHILIPPINE RED CROSS\n"+ "DISCTRICT 4&6 (LIPA)", R.drawable.redcross))
        mList.add(ContactData("PNP SAN JUAN", R.drawable.pnp))
        mList.add(ContactData("SAN JUAN\n" + "DISTRICT HOSPITAL", R.drawable.sanjuandistrict))
        mList.add(ContactData("SAN JUAN\n" + "DOCTORS HOSPITAL", R.drawable.sanjuandoctors))
        mList.add(ContactData("SAN JUAN MDRRMO", R.drawable.sanjuanmdrrmo))
        mList.add(ContactData("SAN JUAN RURAL\n"+"HEALTH UNIT", R.drawable.hospitallogo))


    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PHONE_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Call the selected number
                // You can implement logic to store the selected number temporarily and call it after permission is granted
            } else {
                Toast.makeText(this, "Phone permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
    companion object {
        private const val REQUEST_PHONE_PERMISSION = 1
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}
