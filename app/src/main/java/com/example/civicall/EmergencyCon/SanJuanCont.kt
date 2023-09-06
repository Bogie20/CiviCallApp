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
class SanJuanCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_san_juan_cont)

        val backButton: ImageView = findViewById(R.id.backbutton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()

        val phoneOptionsSanjuan = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437239350"),// pddrrmo
            2 to arrayOf("0439800385"),// incident
            3 to arrayOf("0434250139"),// infirmary
            4 to arrayOf("0434250139"),// security office
            5 to arrayOf("0435755192"),// service office
            6 to arrayOf("0435754166","09156022026"),// bfp
            7 to arrayOf("09178093429","09985855848"),// coast guard
            8 to arrayOf("0435753408"),// divine care
            9 to arrayOf("09171429378"),// redcross
            10 to arrayOf("09153850205","09985985701"),// pnp
            11 to arrayOf("0435753756"),// district host
            12 to arrayOf("0435753138"),// doctors host
            13 to arrayOf("0435753210"),// mdrrmo
            14 to arrayOf("0435753992"),// health unit
        )
        adapter = ContactAdapter(mList, phoneOptionsSanjuan)

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
        mList.add(ContactData("\nBATSTATE SAN JUAN\n"+ "INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("\nBATSTATEU SAN JUAN\n"+ "SECURITY OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BATSTATEU SAN JUAN\n" + "CAMPUS EXTENSION\n" + "SERVICE OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nBUREAU OF FIRE\n"+"PROTECTION\n"+"SAN JUAN", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "SAN JUAN", R.drawable.pcg))
        mList.add(ContactData("\nDIVINE CARE\n"+"HOSPITAL", R.drawable.divinecare))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "DISCTRICT 4&6 (LIPA)", R.drawable.redcross))
        mList.add(ContactData("\nPNP SAN JUAN", R.drawable.pnp))
        mList.add(ContactData("\nSAN JUAN\n" + "DISTRICT HOSPITAL", R.drawable.sanjuandistrict))
        mList.add(ContactData("\nSAN JUAN\n" + "DOCTORS HOSPITAL", R.drawable.sanjuandoctors))
        mList.add(ContactData("\nSAN JUAN MDRRMO", R.drawable.sanjuanmdrrmo))
        mList.add(ContactData("\nSAN JUAN RURAL\n"+"HEALTH UNIT", R.drawable.hospitallogo))


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