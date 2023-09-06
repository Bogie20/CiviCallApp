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

class MalvarCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malvar_cont)

        val backButton: ImageView = findViewById(R.id.backbutton)
        backButton.setOnClickListener {
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
        mList.add(ContactData("\nNATIONAL EMERGENCY\n"+"HOTLINE", R.drawable.nationalhotline))
        mList.add(ContactData("\nBATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("\nBUREAU OF FIRE\n"+"PROTECTION\n"+"MALVAR", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "BATANGAS", R.drawable.pcg))
        mList.add(ContactData("\nC.P. REYES\n"+"HOSPITAL", R.drawable.cpreyes))
        mList.add(ContactData("\nDANIEL O. MERCADO\n"+"MEDICAL CENTER", R.drawable.mercado))
        mList.add(ContactData("\nMALVAR CAMPUS\n" + "HEALTH SERVICES", R.drawable.batstateu))
        mList.add(ContactData("\nMALVAR CAMPUS\n" + "SECURITY SERVICES", R.drawable.batstateu))
        mList.add(ContactData("\nMALVAR INCIDENT \n" + "COMMANDER'S/\n"+"EXECUTIVE DIRECTOR'S\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nMALVAR MDRRMO", R.drawable.mdrrmo))
        mList.add(ContactData("\nPNP MALVAR", R.drawable.pnp))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "DISTRICT 3 (TANAUAN)", R.drawable.redcross))
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
