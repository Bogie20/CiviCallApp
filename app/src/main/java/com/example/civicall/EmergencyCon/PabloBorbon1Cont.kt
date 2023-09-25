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
class PabloBorbon1Cont : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<ContactData>()
    private lateinit var adapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pablo_borbon1_cont)

        val backButton: ImageView = findViewById(R.id.backbutton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        val phoneOptionsPablo1 = mapOf(

            0 to arrayOf("911"),// hotline
            1 to arrayOf("0437023902","09228010776"),// cddrrmo
            2 to arrayOf("0437408303"),// medical center
            3 to arrayOf("0437239350"),// pdrrmo
            4 to arrayOf("0439800385"),// incident
            5 to arrayOf("0439800385"),// infirmary
            6 to arrayOf("09159715893"),// action center
            7 to arrayOf("09493905682"),// chief security
            8 to arrayOf("0437237299"),// bfp
            9 to arrayOf("09178426633"),// coastguard
            10 to arrayOf("0433413112"),// golden gate
            11 to arrayOf("0437231511","0437232930"),// mayor
            12 to arrayOf("0437233027","09171356219","09177734912"),// red cross
            13 to arrayOf("0439800382","0439800340","0437232030"),// pnp
            14 to arrayOf("0439800400"),// pnp provincial
            15 to arrayOf("0437231605"),// st.patrick
        )
        adapter = ContactAdapter(mList, phoneOptionsPablo1)

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
        mList.add(ContactData("BATANGAS CDRRMO", R.drawable.batangcdrrmo))
        mList.add(ContactData("BATANGAS MEDICAL\n"+"CENTER", R.drawable.batangmedical))
        mList.add(ContactData("BATANGAS PDRRMO", R.drawable.pdrrmobats))
        mList.add(ContactData("BATSTATE U INCIDENT \n" + "COMMANDERS OFFICE", R.drawable.batstateu))
        mList.add(ContactData("BATSTATEU\n"+"INFIRMARY", R.drawable.batstateu))
        mList.add(ContactData("BATSTATE U\n" + "ACTION CENTER", R.drawable.batstateu))
        mList.add(ContactData("BATSTATE U\n"+"CHIEF SECURITY\n"+"OFFICER", R.drawable.batstateu))
        mList.add(ContactData("BUREAU OF FIRE\n"+"PROTECTION\n"+"BATANGAS CITY", R.drawable.bfp))
        mList.add(ContactData("COAST GUARD\n" + "BATANGAS", R.drawable.pcg))
        mList.add(ContactData("GOLDEN GATE\n"+"HOSPITAL", R.drawable.batanggolden))
        mList.add(ContactData("MAYOR'S ACTION\n"+"CENTER", R.drawable.batangamayor))
        mList.add(ContactData("PHILIPPINE RED CROSS\n"+ "BATANGAS CITY", R.drawable.redcross))
        mList.add(ContactData("PNP BATANGAS CITY", R.drawable.pnp))
        mList.add(ContactData("PNP BATANGAS\n"+"PROVINCIAL\n"+"OFFICE", R.drawable.batangpnp))
        mList.add(ContactData("ST.PATRICK'S\n"+"HOSPITAL", R.drawable.batangsaintpat))


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
