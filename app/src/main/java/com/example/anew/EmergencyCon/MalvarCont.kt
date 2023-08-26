package com.example.anew.EmergencyCon

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anew.R
import java.util.*

class MalvarCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malvar_cont)

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
        mList.add(ContactData("\nBUREAU OF FIRE\n"+"PROTECTION\n"+"MALVAR", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "BATANGAS", R.drawable.pcg))
        mList.add(ContactData("\nC.P. REYES\n"+"HOSPITAL", R.drawable.cpreyes))
        mList.add(ContactData("\nDANIEL O. MERCADO\n"+"MEDICAL CENTER", R.drawable.mercado))
        mList.add(ContactData("\nMALVAR CAMPUS\n" + "MABINI ADMIN\n" + "OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nMALVAR CAMPUS\n"+"INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("\nMALVAR INCIDENT \n" + "COMMANDER'S/\n"+"EXECUTIVE DIRECTOR'S\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nMALVAR MDRRMO", R.drawable.mdrrmo))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "DISTRICT 3 (TANAUAN)", R.drawable.redcross))
        mList.add(ContactData("\nPNP MALVAR", R.drawable.pnp))
    }
}
