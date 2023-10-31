package com.example.civicall.EmergencyCon

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import java.util.Locale

class NasugbuCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nasugbu_cont)

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            onBackPressed()
        }

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        val phoneOptionsNasugbu = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437239350"),// pdrrmo
            2 to arrayOf("0439800385"),// incident
            3 to arrayOf("09156021998","09069582122"),// bfp
            4 to arrayOf("09178428063","09985855849"),// coast guard
            5 to arrayOf("0434160349","09150623889"),// executive office
            6 to arrayOf("0434160446"),// jabez medical
            7 to arrayOf("0436964374"),// metropolitan
            8 to arrayOf("09175089911","09196292599"),// mdrrmo
            9 to arrayOf("09171331427","09989509663"),// red cross
            10 to arrayOf("09275001199","09985985698"),// pnp
        )
        adapter = ContactAdapter(mList, phoneOptionsNasugbu)

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
        mList.add(ContactData("BATSTATE U INCIDENT\n" + "COMMANDER OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BUREAU OF FIRE\n"+"PROTECTION\n"+"NASUGBU", R.drawable.bfp))
        mList.add(ContactData("COAST GUARD\n" + "NASUGBU", R.drawable.pcg))
        mList.add(ContactData("EXECUTIVE DIRECTOR'S\n" + "OFFICE", R.drawable.batstateu))
        mList.add(ContactData("JABEZ MEDICAL\n"+"CENTER", R.drawable.jabez))
        mList.add(ContactData("METROPOLITAN\n"+"MEDICAL CENTER", R.drawable.metrohospital))
        mList.add(ContactData("NASUGBU MDRRMO", R.drawable.nasugbumdrrmo))
        mList.add(ContactData("PHILIPPINE RED CROSS\n"+ "DISTRICT 1 (NASUGBU)", R.drawable.redcross))
        mList.add(ContactData("PNP NASUGBU", R.drawable.pnp))

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
}