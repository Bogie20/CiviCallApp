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

class MalvarCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malvar_cont)
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

        val phoneOptionsMalvar = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437239350"),// pdrrmo
            2 to arrayOf("09364228755","09156016752"),// bfp
            3 to arrayOf("09178426633"),// coast guard
            4 to arrayOf("0437845401"),// cp reyes host
            5 to arrayOf("0437781810"),// mercado host
            6 to arrayOf("0437792170"),//malvar health serv
            7 to arrayOf("0437782170"),// security servi
            8 to arrayOf("0437782170"),// incident
            9 to arrayOf("0434063166","09067019540","09215468364"),//mdrrmo
            10 to arrayOf("0437782019","09985985695"),// pnp
            11 to arrayOf("09157537587","09303583051"), // red cross
        )
        adapter = ContactAdapter(mList, phoneOptionsMalvar)

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
        mList.add(ContactData("BUREAU OF FIRE\n"+"PROTECTION\n"+"MALVAR", R.drawable.bfp))
        mList.add(ContactData("COAST GUARD\n" + "BATANGAS", R.drawable.pcg))
        mList.add(ContactData("C.P. REYES\n"+"HOSPITAL", R.drawable.cpreyes))
        mList.add(ContactData("DANIEL O. MERCADO\n"+"MEDICAL CENTER", R.drawable.mercado))
        mList.add(ContactData("MALVAR CAMPUS\n" + "HEALTH SERVICES", R.drawable.batstateu))
        mList.add(ContactData("MALVAR CAMPUS\n" + "SECURITY SERVICES", R.drawable.batstateu))
        mList.add(ContactData("MALVAR INCIDENT \n" + "COMMANDER'S/\n"+"EXECUTIVE DIRECTOR'S\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("MALVAR MDRRMO", R.drawable.mdrrmo))
        mList.add(ContactData("PNP MALVAR", R.drawable.pnp))
        mList.add(ContactData("PHILIPPINE RED CROSS\n"+ "DISTRICT 3 (TANAUAN)", R.drawable.redcross))
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
