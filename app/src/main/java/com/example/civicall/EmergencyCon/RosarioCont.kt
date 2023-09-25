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
class RosarioCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rosario_cont)

        val backButton: ImageView = findViewById(R.id.backbutton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        val phoneOptionsRosario = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437239350"),// pddrrmo
            2 to arrayOf("0434250139"),// incident
            3 to arrayOf("0434250139"),// infirmary
            4 to arrayOf("0434250139"),// security office
            5 to arrayOf("0439800385"),// opt center
            6 to arrayOf("09156024435"),// bfp
            7 to arrayOf("09178426633"),// coast guard
            8 to arrayOf("0437064137"),// virgen maria
            9 to arrayOf("0437784811","0433211410"),// palma
            10 to arrayOf("0437233027","09171356219","09177734912"),// redcross
            11 to arrayOf("0437247026","09152542577"),// pnp
            12 to arrayOf("0437401338"),// lgu
            13 to arrayOf("0433211025"),// sto rosario host
        )
        adapter = ContactAdapter(mList, phoneOptionsRosario)

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
        mList.add(ContactData("BATSTATE U INCIDENT\n" + "COMMANDER/\n"+"EXECUTIVE DIRECTOR'S\n"+"OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BATSTATEU ROSARIO\n"+ "INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("BATSTATEU ROSARIO\n"+ "SECURITY OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BATSTATEU ROSARIO\n" + "EMERGENCY\n" + "OPERATIONS CENTER", R.drawable.batstateu))
        mList.add(ContactData("BUREAU OF FIRE\n"+"PROTECTION\n"+"ROSARIO", R.drawable.bfp))
        mList.add(ContactData("COAST GUARD\n" + "BATANGAS", R.drawable.pcg))
        mList.add(ContactData("MAHAL NA VIRGEN \n"+"MARIA SANTO ROSARIO\n" + "DISTRICT HOSPITAL", R.drawable.mahalnavirhen))
        mList.add(ContactData("PALMA-MALALUAN\n"+"HOSPITAL", R.drawable.palma))
        mList.add(ContactData("PHILIPPINE RED CROSS\n"+ "BATANGAS CITY", R.drawable.redcross))
        mList.add(ContactData("PNP ROSARIO", R.drawable.pnp))
        mList.add(ContactData("ROSARIO LGU OFFICE\n"+"ON HEALTH SERVICES", R.drawable.rosariolgu))
        mList.add(ContactData("STO.ROSARIO\n"+"HOSPITAL", R.drawable.storosario))


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
