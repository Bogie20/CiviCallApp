package com.example.civicall.CalendarView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CalendarEvents : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var eventAdapter: EventAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_events)

        database = FirebaseDatabase.getInstance().reference.child("Upload Engagements")

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val calendarView: CalendarView = findViewById(R.id.calendarView2)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        eventAdapter = EventAdapter(ArrayList())
        recyclerView.adapter = eventAdapter

        // Set up CalendarView listener
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = "$month/$dayOfMonth/$year"
            fetchEvents(selectedDate)
        }

        // Check Firebase connection
        checkFirebaseConnection()
    }

    private fun checkFirebaseConnection() {
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // Firebase connection successful
                Toast.makeText(
                    this@CalendarEvents,
                    "Connected to Firebase",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onCancelled(error: DatabaseError) {
                // Firebase connection failed
                Toast.makeText(
                    this@CalendarEvents,
                    "Failed to connect to Firebase",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
    private fun fetchEvents(selectedDate: String?) {
        val query = database.orderByChild("startDate").equalTo(selectedDate)

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val events = ArrayList<Event>()

                for (engagementSnapshot in snapshot.children) {
                    // Get the necessary data from each engagement
                    val title = engagementSnapshot.child("title").getValue(String::class.java) ?: "DefaultTitle"
                    val startDate = engagementSnapshot.child("startDate").getValue(String::class.java) ?: "DefaultStartDate"

                    // Assuming Event is a data class with appropriate properties
                    val event = Event(title, startDate)
                    events.add(event)
                }

                // Update your RecyclerView with the collected events
                eventAdapter.updateData(events)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }}
