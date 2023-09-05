package com.example.anew.EmergencyCon

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anew.R
import java.util.*

class MainEmergencyContact : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: MainContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_emergency_contact)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = MainContactAdapter(mList)
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
        mList.add(ContactData("BALAYAN CAMPUS", R.drawable.balayansymbol))
        mList.add(ContactData("LEMERY CAMPUS", R.drawable.lemerysymbol))
        mList.add(ContactData("LIPA CAMPUS", R.drawable.lipasymbol))
        mList.add(ContactData("LOBO CAMPUS", R.drawable.lobosymbol))
        mList.add(ContactData("MABINI CAMPUS", R.drawable.mabinisymbol))
        mList.add(ContactData("MALVAR CAMPUS", R.drawable.malvarsymbol))
        mList.add(ContactData("NASUGBU CAMPUS", R.drawable.nasugbusymbol))
        mList.add(ContactData("PABLO BORBON I", R.drawable.batangasymbol))
        mList.add(ContactData("PABLO BORBON II", R.drawable.batangasymbol))
        mList.add(ContactData("ROSARIO CAMPUS", R.drawable.rosariosymbol))
        mList.add(ContactData("SAN JUAN CAMPUS", R.drawable.sanjuansymbol))
    }
}
