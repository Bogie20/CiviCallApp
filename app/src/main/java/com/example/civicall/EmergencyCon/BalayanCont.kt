package com.example.civicall.EmergencyCon

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.Manifest
import android.content.Intent
import androidx.core.content.ContextCompat
import com.example.civicall.R
import java.util.*

class BalayanCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balayan_cont)

        val backButton: ImageView = findViewById(R.id.backbutton)
        backButton.setOnClickListener {
            onBackPressed() // Simulate back button press
        }

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()

        val phoneOptionsBalayan = mapOf(

            0 to arrayOf("911"),//hotline
            1 to arrayOf("0432116734", "09365852893"),//balayan bay view
            2 to arrayOf("0434257158", "0434257159"),// balayan campus emergency operation
            3 to arrayOf("0432113755", "09156022053"),// balyan mdrrmo
            4 to arrayOf("0437239350"),// batangas pdrrmo
            5 to arrayOf("0434250143"),// batstate incident
            6 to arrayOf("0434250139"),// batstate infirmary
            7 to arrayOf("0434250139"),// batstate security
            8 to arrayOf("0432114619", "09179920192"),//batelec 1
            9 to arrayOf("09156022053"),// bfp
            10 to arrayOf("09178428047", "09985855844"),//coastguard
            11 to arrayOf("0432114169"),// dr.manuel
            12 to arrayOf("0434071103", "09157846521", "09082426971"),// western medical center
            13 to arrayOf("0437401350", "0432116633"),// metro balayan
            14 to arrayOf("09171331427"),//red cross
            15 to arrayOf("0432113637", "09274348008"),//pnp
        )
        adapter = ContactAdapter(mList, phoneOptionsBalayan)

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
        mList.add(ContactData("\nBALAYAN BAYVIEW\n" + "HOSPITAL", R.drawable.balayanbayview))
        mList.add(ContactData("BALAYAN CAMPUS\n" + "EMERGENCY\n" + "OPERATIONS CENTER", R.drawable.batstateu))
        mList.add(ContactData("\nBALAYAN MDRRMO", R.drawable.balayanmdrrmo))
        mList.add(ContactData("\nBATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("BATSTATE U INCIDENT\n" + "COMMANDER/\n" + "EXECUTIVE\n" + "DIRECTORS OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nBATSTATEU BALAYAN\n"+ "INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("\nBATSTATEU BALAYAN\n"+ "SECURITY OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nBATELEC I", R.drawable.batelec1))
        mList.add(ContactData("\nBUREAU OF FIRE\n"+"PROTECTION\n"+"BALAYAN", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "BALAYAN", R.drawable.pcg))
        mList.add(ContactData("DR. MANUEL LOPEZ\n"+ "DISTRICT MEMORIAL\n" + "HOSPITAL", R.drawable.donmanuel))
        mList.add(ContactData("\nMEDICAL CENTER\n" + "WESTERN BATANGAS", R.drawable.medwes))
        mList.add(ContactData("\nMETRO BALAYAN\n" + "MEDICAL CENTER", R.drawable.metrobalayan))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "DISTRICT 1 (NASUGBU)", R.drawable.redcross))
        mList.add(ContactData("\n PNP BALAYAN", R.drawable.pnp))


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