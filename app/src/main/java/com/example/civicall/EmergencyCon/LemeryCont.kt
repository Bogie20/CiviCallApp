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

class LemeryCont : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lemery_cont)
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

        val phoneOptionsLemery = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437239350"),// pddrrmo
            2 to arrayOf("0434250139"),// incident
            3 to arrayOf("0434250139", "09278232295"),// infirmary
            4 to arrayOf("0437402987","09550959026"),// bfp
            5 to arrayOf("091783675520 ", "09985855852"),// coastguard
            6 to arrayOf("09352017156"),// security office
            7 to arrayOf("0434111531"),// lemery doc medical center
            8 to arrayOf("0437400157"),// lgu
            9 to arrayOf("0434090480"),// medical center metro
            10 to arrayOf("0434091888"),// our lady
            11 to arrayOf("09171331427"),// philippineredcross
            12 to arrayOf("09277071191"),// pnp
        )
        adapter = ContactAdapter(mList, phoneOptionsLemery)

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

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(ContactData("NATIONAL EMERGENCY\n"+"HOTLINE", R.drawable.nationalhotline))
        mList.add(ContactData("BATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("BATSTATE U INCIDENT \n" + "COMMANDERS OFFICE /\n" + "EXECUTIVE DIRECTORS\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BATSTATEU LEMERY \n"+"INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("BUREAU OF FIRE\n"+"PROTECTION\n"+"LEMERY", R.drawable.bfp))
        mList.add(ContactData("COAST GUARD\n" + "LEMERY", R.drawable.pcg))
        mList.add(ContactData("LEMERY CAMPUS \n" + "SECURITY OFFICE", R.drawable.batstateu))
        mList.add(ContactData("EMERY DOCTORS \n" + "MEDICAL CENTER", R.drawable.lemerydoctors))
        mList.add(ContactData("LEMERY LGU", R.drawable.lemerylogo))
        mList.add(ContactData("METRO LEMERY\n"+"MEDICAL CENTER", R.drawable.metrolemery))
        mList.add(ContactData("OUR LADY OF CAYSASAY\n"+ "MEDICAL CENTER", R.drawable.ourlady))
        mList.add(ContactData("PHILIPPINE RED CROSS\n"+ "DISTRICT 1 (NASUGBU)", R.drawable.redcross))
        mList.add(ContactData("PNP Lemery", R.drawable.pnp))


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
