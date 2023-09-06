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

class LoboCont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobo_cont)

        val backButton: ImageView = findViewById(R.id.backbutton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()

        val phoneOptionsLobo = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437239350"),// pddrrmo
            2 to arrayOf("0439800385"),// incident
            3 to arrayOf("0434250138"),// infirmary
            4 to arrayOf("0434250139"),// security office
            5 to arrayOf("09156022046", "09167194904"),// bfp
            6 to arrayOf("09178016001","09985855850"),// coastguard
            7 to arrayOf("09399252443"),// operation center
            8 to arrayOf("09171349235"),// mdrrmo
            9 to arrayOf("0434047131"), // municipal hostpital
            10 to arrayOf(" 0437233027","09171356219","09177734912"),// red cross
            11 to arrayOf("09167194906","09985985693"),// pnp
        )
        adapter = ContactAdapter(mList, phoneOptionsLobo)

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
        mList.add(ContactData("\nBATSTATEU LOBO \n"+"INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("\nBATSTATEU LOBO \n" + "SECURITY OFFICE", R.drawable.batstateu))
        mList.add(ContactData("\nBUREAU OF FIRE\n"+"PROTECTION\n"+"LOBO", R.drawable.bfp))
        mList.add(ContactData("\nCOAST GUARD\n" + "LOBO", R.drawable.pcg))
        mList.add(ContactData("\nLOBO CAMPUS\n"+"EMERGENCY\n"+"OPERATIONS CENTER", R.drawable.batstateu))
        mList.add(ContactData("\nLOBO MDRRMO", R.drawable.lobomdrrmo))
        mList.add(ContactData("\nLOBO MUNICIPAL\n"+"HOSPITAL", R.drawable.hospitallogo))
        mList.add(ContactData("\nPHILIPPINE RED CROSS\n"+ "BATANGAS CITY", R.drawable.redcross))
        mList.add(ContactData("\n PNP LOBO", R.drawable.pnp))


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
