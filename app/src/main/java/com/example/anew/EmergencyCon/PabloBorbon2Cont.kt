package com.example.anew.EmergencyCon

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anew.R
import java.util.*
class PabloBorbon2Cont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pablo_borbon2_cont)

        val backButton: ImageView = findViewById(R.id.backbutton)
        backButton.setOnClickListener {
            onBackPressed()
        }

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
        mList.add(ContactData("\nBATANGAS CDRRMO", R.drawable.batangcdrrmo))
        mList.add(ContactData("\nBATANGAS MEDICAL\n"+"CENTER", R.drawable.batangmedical))
        mList.add(ContactData("\nBATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("\nBUREAU OF FIRE\n"+"PROTECTION\n"+"BATANGAS CITY", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "BATANGAS", R.drawable.pcg))
        mList.add(ContactData("\nGOLDEN GATE\n"+"HOSPITAL", R.drawable.batanggolden))
        mList.add(ContactData("\nMAIN 2 INCIDENT \n" + "COMMANDERS OFFICE /\n" + "EXECUTIVE OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nMAIN 2 INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("\nMAIN 2 SECURITY\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "BATANGAS CITY", R.drawable.redcross))
        mList.add(ContactData("\nPNP BATANGAS CITY", R.drawable.pnp))
        mList.add(ContactData("\nPNP BATANGAS\n"+"PROVINCIAL\n"+"OFFICE", R.drawable.batangpnp))
        mList.add(ContactData("\nST.PATRICK'S\n"+"HOSPITAL", R.drawable.batangsaintpat))


    }
}
