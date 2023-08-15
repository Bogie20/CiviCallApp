package com.example.anew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class add_engagement : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_engagement)
        val campusSpinner = findViewById<Spinner>(R.id.campusSpinner)
        val campusOptions = resources.getStringArray(R.array.allowed_campuses)

        val campusSpinner2 = findViewById<Spinner>(R.id.campusSpinner2) // Define the new spinner
        val NSTPOptions = resources.getStringArray(R.array.NSTP)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, campusOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        campusSpinner.adapter = adapter
        campusSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCampus = campusOptions[position]
                // Handle the selected campus
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected
            }
        }

        // Set up the adapter and item selection listener for campusSpinner2
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, NSTPOptions)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        campusSpinner2.adapter = adapter2
        campusSpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCampus = NSTPOptions[position]
                // Handle the selected campus for the second spinner
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected for the second spinner
            }
        }
    }
}





