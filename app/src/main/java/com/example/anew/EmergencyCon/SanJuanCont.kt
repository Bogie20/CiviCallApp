package com.example.anew.EmergencyCon

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anew.R
import java.util.*
class SanJuanCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_san_juan_cont)

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
        mList.add(ContactData("\nBALAYAN BAYVIEW\n" + "HOSPITAL", R.drawable.hospitallogo))
        mList.add(ContactData("BALAYAN CAMPUS\n" + "EMERGENCY\n" + "OPERATIONS CENTER", R.drawable.batstateu))
        mList.add(ContactData("\nBALAYAN MDRRMO", R.drawable.mdrrmo))
        mList.add(ContactData("\nBATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("\nBATSTATEU BALAYAN\n"+ "INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("\nBATSTATEU BALAYAN\n"+ "SECURITY OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BATSTATE U INCIDENT\n" + "COMMANDER/\n" + "EXECUTIVE\n" + "DIRECTORS OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nBATELEC I", R.drawable.batelec1))
        mList.add(ContactData("\nBFP BALAYAN", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "BALAYAN", R.drawable.pcg))
        mList.add(ContactData("DR. MANUEL LOPEZ\n"+ "DISTRICT MEMORIAL\n" + "HOSPITAL", R.drawable.hospitallogo))
        mList.add(ContactData("\nMEDICAL CENTER\n" + "WESTERN BATANGAS", R.drawable.medwes))
        mList.add(ContactData("\nMETRO BALAYAN\n" + "MEDICAL CENTER", R.drawable.metrobalayan))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "DISTRICT 1 (NASUGBU)", R.drawable.redcross))
        mList.add(ContactData("\n PNP BALAYAN", R.drawable.pnp))


    }
}
