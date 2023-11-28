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

class PabloBorbon2Cont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pablo_borbon2_cont)
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
        val phoneOptionsPablo2 = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437023902","09228010776"),// cddrrmo
            2 to arrayOf("0437408303"),// medical center
            3 to arrayOf("0437239350"),// pdrrmo
            4 to arrayOf("0437237299"),// bfp
            5 to arrayOf("09178426633"),// coastguard
            6 to arrayOf("0433413112"),// golden gate
            7 to arrayOf("0434250139"),// incident
            8 to arrayOf("0434250139"),// infirmary
            9 to arrayOf("0434250139"),// security office
            10 to arrayOf("0437233027","09171356219","09177734912"),// red cross
            11 to arrayOf("0439800382","0439800340","0437232030"),// pnp
            12 to arrayOf("0439800400"),// pnp provincial
            13 to arrayOf("0437231605"),// st.patrick
        )
        adapter = ContactAdapter(mList, phoneOptionsPablo2)

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
        mList.add(ContactData("BATANGAS CDRRMO", R.drawable.batangcdrrmo))
        mList.add(ContactData("BATANGAS MEDICAL\n"+"CENTER", R.drawable.batangmedical))
        mList.add(ContactData("BATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("BUREAU OF FIRE\n"+"PROTECTION\n"+"BATANGAS CITY", R.drawable.bfp))
        mList.add(ContactData("COAST GUARD\n" + "BATANGAS", R.drawable.pcg))
        mList.add(ContactData("GOLDEN GATE\n"+"HOSPITAL", R.drawable.batanggolden))
        mList.add(ContactData("MAIN 2 INCIDENT \n" + "COMMANDERS OFFICE /\n" + "EXECUTIVE OFFICE", R.drawable.batstateu))
        mList.add(ContactData("MAIN 2 INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("MAIN 2 SECURITY\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("PHILIPPINE RED CROSS\n"+ "BATANGAS CITY", R.drawable.redcross))
        mList.add(ContactData("PNP BATANGAS CITY", R.drawable.pnp))
        mList.add(ContactData("PNP BATANGAS\n"+"PROVINCIAL\n"+"OFFICE", R.drawable.batangpnp))
        mList.add(ContactData("ST.PATRICK'S\n"+"HOSPITAL", R.drawable.batangsaintpat))


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
