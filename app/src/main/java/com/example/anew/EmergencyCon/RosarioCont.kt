package com.example.anew.EmergencyCon

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anew.R
import java.util.*
class RosarioCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rosario_cont)

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
        mList.add(ContactData("\nNATIONAL EMERGENCY\n"+"HOTLINE", R.drawable.nationalhotline))
        mList.add(ContactData("\nBATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("BATSTATE U INCIDENT\n" + "COMMANDER/\n"+"EXECUTIVE DIRECTOR'S\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nBATSTATEU ROSARIO\n"+ "INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("\nBATSTATEU ROSARIO\n"+ "SECURITY OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BATSTATEU ROSARIO\n" + "EMERGENCY\n" + "OPERATIONS CENTER", R.drawable.batstateu))
        mList.add(ContactData("\nBUREAU OF FIRE\n"+"PROTECTION\n"+"ROSARIO", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "BATANGAS", R.drawable.pcg))
        mList.add(ContactData("\nMAHAL NA VIRGEN \n"+"MARIA SANTO ROSARIO\n" + "DISTRICT HOSPITAL", R.drawable.mahalnavirhen))
        mList.add(ContactData("\nPALMA-MALALUAN\n"+"HOSPITAL", R.drawable.palma))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "BATANGAS CITY", R.drawable.redcross))
        mList.add(ContactData("\nPNP ROSARIO", R.drawable.pnp))
        mList.add(ContactData("\nROSARIO LGU OFFICE\n"+"ON HEALTH SERVICES", R.drawable.rosariolgu))
        mList.add(ContactData("\nSTO.ROSARIO\n"+"HOSPITAL", R.drawable.storosario))


    }
}
