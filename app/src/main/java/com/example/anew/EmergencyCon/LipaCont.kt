package com.example.anew.EmergencyCon

import android.os.Bundle
import android.widget.ImageView
import android.Manifest
import android.net.Uri
import android.widget.Toast
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anew.R
import androidx.core.content.ContextCompat
import java.util.*

class LipaCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lipa_cont)

        val backButton: ImageView = findViewById(R.id.backbutton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()

        val phoneOptionsLipa = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437239350"),// pddrrmo
            2 to arrayOf("0437782170"),// incident
            3 to arrayOf("0437574618","092757558065","09156022011"),// bfp
            4 to arrayOf("09178426633"),// coastguard
            5 to arrayOf("0434048617"),// district hospital
            6 to arrayOf("0437023832","09777449692"),// pnp
            7 to arrayOf("0434250139"),// dean infirmary
            8 to arrayOf("0437742526"),// operation center
            9 to arrayOf("0437575164","0437560127"),// cdrrmo
            10 to arrayOf("0437562342","0437562372","09285261578"), // medix
            11 to arrayOf("0437736800"),// mediatrix
            12 to arrayOf("0437025561","0437028198","0437025443"),// metro
            13 to arrayOf("09171429378"),// redcross
        )
        adapter = ContactAdapter(mList, phoneOptionsLipa)


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
        mList.add(ContactData("BATSTATE U INCIDENT \n" + "COMMANDERS OFFICE /\n" + "EXECUTIVE DIRECTORS\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BUREAU OF FIRE\n"+"PROTECTION\n"+"LIPA CITY", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "BATANGAS", R.drawable.pcg))
        mList.add(ContactData("\nLIPA CITY  \n"+"DISTRICT HOSPITAL", R.drawable.lipadistrict))
        mList.add(ContactData("\nLIPA CITY\n"+"POLICE STATION (PNP)", R.drawable.pnp))
        mList.add(ContactData("LIPA CAMPUS\n"+"DEAN’S OFFICE /\n"+"INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("LIPA CAMPUS EMERGENCY\n" + "OPERATIONS CENTER", R.drawable.batstateu))
        mList.add(ContactData("\nLIPA CITY \n" + "CDRRMO", R.drawable.lipacdrrmo))
        mList.add(ContactData("\nLIPA MEDIX\n"+"MEDICAL CENTER", R.drawable.lipamedix))
        mList.add(ContactData("\nMARY MEDIATRIX \n"+"MEDICAL CENTER", R.drawable.lipamediatrix))
        mList.add(ContactData("\nMETRO LIPA \n"+ "MEDICAL CENTER", R.drawable.lipametro))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "DISTRICT 4 & 6 (LIPA)", R.drawable.redcross))
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
