package com.example.anew.EmergencyCon

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ImageView
import android.net.Uri
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anew.R
import android.Manifest
import java.util.*

class LemeryCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lemery_cont)

        val backButton: ImageView = findViewById(R.id.backbutton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()

        val phoneOptionsLemery = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437239350"),// pddrrmo
            2 to arrayOf("0434250139"),// incident
            3 to arrayOf("0434250139", "09278232295"),// infirmary
            4 to arrayOf("0437402987","09550959026"),// bfp
            5 to arrayOf("091783675520 ", "09985855852"),// coastguard
            6 to arrayOf("09352017156"),// security office
            7 to arrayOf("0434111531"),// lemery doc medical center
            8 to arrayOf("0437400157"),// lgu
            9 to arrayOf("0434090480"),// medical center metro
            10 to arrayOf("0434091888"),// our lady
            11 to arrayOf("09171331427"),// philippineredcross
            12 to arrayOf("09277071191"),// pnp
        )
        adapter = ContactAdapter(mList, phoneOptionsLemery)

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
        mList.add(ContactData("\nBATSTATEU LEMERY \n"+"INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("BUREAU OF FIRE\n"+"PROTECTION\n"+"LEMERY", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "LEMERY", R.drawable.pcg))
        mList.add(ContactData("\nLEMERY CAMPUS \n" + "SECURITY OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nLEMERY DOCTORS \n" + "MEDICAL CENTER", R.drawable.lemerydoctors))
        mList.add(ContactData("\nLEMERY LGU", R.drawable.lemerylogo))
        mList.add(ContactData("\nMETRO LEMERY\n"+"MEDICAL CENTER", R.drawable.metrolemery))
        mList.add(ContactData("\nOUR LADY OF CAYSASAY\n"+ "MEDICAL CENTER", R.drawable.ourlady))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "DISTRICT 1 (NASUGBU)", R.drawable.redcross))
        mList.add(ContactData("\nPNP Lemery", R.drawable.pnp))


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
