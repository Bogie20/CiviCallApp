package com.example.civicall.EmergencyCon

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ImageView
import android.Manifest
import android.net.Uri
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import androidx.core.content.ContextCompat
import java.util.*

class MabiniCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mabini_cont)

        val backButton: ImageView = findViewById(R.id.backbutton)
        backButton.setOnClickListener {
            onBackPressed()
        }
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        val phoneOptionsMabini = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0434253099"),// batelec 2
            2 to arrayOf("0437239350"),// pddrrmo
            3 to arrayOf("0434250143"),// mabini admin
            4 to arrayOf("0434250139"),// infirmary
            5 to arrayOf("09156034246"),// bfp
            6 to arrayOf("09178149204","09985855854"),// coastguard
            7 to arrayOf("0434250143"),// emergency operation
            8 to arrayOf("0434253197","0434253204","09228543400"),// general hospital
            9 to arrayOf("0434870873"),// mdrrmo
            10 to arrayOf("0437233027","09171356219","09177734912"),// red cross
            11 to arrayOf("09162700837"), // pnp
            12 to arrayOf("0434870645"),// zigzag
        )
        adapter = ContactAdapter(mList, phoneOptionsMabini)

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
        mList.add(ContactData("BATELEC II", R.drawable.batelec2))
        mList.add(ContactData("BATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("BATSTATE U\n" + "MABINI ADMIN\n" + "OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BATSTATEU MABINI \n"+"INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("BUREAU OF FIRE\n"+"PROTECTION\n"+"MABINI", R.drawable.bfp))
        mList.add(ContactData("COAST GUARD\n" + "MABINI", R.drawable.pcg))
        mList.add(ContactData("MABINI CAMPUS\n"+"EMERGENCY OPT.CENTER", R.drawable.batstateu))
        mList.add(ContactData("MABINI GENERAL\n"+"HOSPITAL", R.drawable.hospitallogo))
        mList.add(ContactData("MABINI MDRRMO", R.drawable.mdrrmo))
        mList.add(ContactData("PHILIPPINE RED CROSS\n"+ "BATANGAS CITY", R.drawable.redcross))
        mList.add(ContactData("PNP MABINI", R.drawable.pnp))
        mList.add(ContactData("ZIGZAG\n"+"HOSPITAL", R.drawable.hospitallogo))

    }
    private fun makePhoneCall(phoneNumber: String) {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        } else {
            // Request the CALL_PHONE permission
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                REQUEST_PHONE_PERMISSION
            )
        }
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
