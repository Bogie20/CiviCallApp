package com.example.anew.EmergencyCon

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anew.R
import java.util.*

class LemeryCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lemery_cont)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = ContactAdapter(mList)
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
        mList.add(ContactData("\nBATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("BATSTATE U INCIDENT \n" + "COMMANDERS OFFICE /\n" + "EXECUTIVE DIRECTORS\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nBATSTATEU LEMERY \n"+"INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("\nBFP LEMERY", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "LEMERY", R.drawable.pcg))
        mList.add(ContactData("\nLEMERY CAMPUS\n"+"INFIRMARY", R.drawable.hospitallogo))
        mList.add(ContactData("\nLEMERY CAMPUS \n" + "SECURITY OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nLEMERY DOCTORS \n" + "MEDICAL CENTER", R.drawable.hospitallogo))
        mList.add(ContactData("\nLEMERY LGU", R.drawable.lemerylogo))
        mList.add(ContactData("\nMETRO LEMERY\n"+"MEDICAL CENTER", R.drawable.metrolemery))
        mList.add(ContactData("\nOUR LADY OF CAYSASAY\n"+ "MEDICAL CENTER", R.drawable.ourlady))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "DISTRICT 1 (NASUGBU)", R.drawable.redcross))
        mList.add(ContactData("\n PNP Lemery", R.drawable.pnp))


    }
}
