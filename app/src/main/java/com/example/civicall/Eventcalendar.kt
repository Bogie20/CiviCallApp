package com.example.civicall

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivityEventcalendarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Eventcalendar : AppCompatActivity() {
    private lateinit var binding: ActivityEventcalendarBinding
    private val database = FirebaseDatabase.getInstance()
    private val calendarReference = database.getReference("Upload Engagement")
    private val auth = FirebaseAuth.getInstance()
    private val currentUserID = auth.currentUser?.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventcalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Reference to the TextViews with IDs dateandtime and title
        val dateAndTimeTextView = binding.dateandtime
        val titleTextView = binding.title

        // Add a ValueEventListener to fetch data from Firebase
        calendarReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Reset the TextViews content
                dateAndTimeTextView.text = ""
                titleTextView.text = ""

                // Check if there is data available
                if (snapshot.exists()) {
                    // Loop through data from the "Upload Engagement" node
                    for (engagementDataSnapshot in snapshot.children) {
                        // Assuming your dateandTime and title are stored as Strings
                        val dateAndTime = engagementDataSnapshot.child("dateandTime").getValue(String::class.java)
                        val title = engagementDataSnapshot.child("title").getValue(String::class.java)

                        // Parse date and time
                        val dateTimeArray = dateAndTime?.split(",") ?: emptyList()
                        if (dateTimeArray.size == 2) {
                            val date = dateTimeArray[0].trim() // Assuming date is in "month,day,year" format
                            val time = dateTimeArray[1].trim() // Assuming time is in some format

                            // Display date, time, and title in the TextViews
                            dateAndTimeTextView.text = "Date: $date\nTime: $time"
                            titleTextView.text = "Title: $title"

                            // Display a Toast to indicate successful connection
                            val toastMessage = "Data retrieved from Firebase: $title, $date"
                            Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    // Display a Toast to indicate unsuccessful connection (no data available)
                    val toastMessage = "Unable to retrieve data from Firebase."
                    Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors if any
                // Display a Toast to indicate unsuccessful connection (error occurred)
                val toastMessage = "Error retrieving data from Firebase: ${error.message}"
                Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
