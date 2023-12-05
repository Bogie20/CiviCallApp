package com.example.civicall.Calendar

import android.os.Bundle
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private lateinit var calendarView: CalendarView
    private lateinit var recyclerView: RecyclerView
    private lateinit var calendarAdapter: CalendarAdapter
    private lateinit var engagementList: MutableList<CalendarData>

    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private var childEventListener: ChildEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarView = findViewById(R.id.calendarView)
        recyclerView = findViewById(R.id.recyclerView)

        auth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().reference.child("Upload Engagement")

        engagementList = mutableListOf()
        calendarAdapter = CalendarAdapter(engagementList)

        recyclerView.adapter = calendarAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = "${month + 1}/$dayOfMonth/$year"
            loadEngagements(selectedDate)
        }
    }

    private fun loadEngagements(selectedDate: String) {
        val currentUserUid = auth.currentUser?.uid ?: return

        // Clear the existing list before adding new data
        engagementList.clear()
        calendarAdapter.notifyDataSetChanged()

        // Remove the existing child event listener to avoid duplication
        childEventListener?.let {
            databaseReference.removeEventListener(it)
        }

        childEventListener = databaseReference.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val participantsSnapshot = snapshot.child("Participants")
                val startDate = snapshot.child("startDate").value.toString()
                val endDate = snapshot.child("endDate").value.toString()

                if (participantsSnapshot.hasChild(currentUserUid) && isDateInRange(selectedDate, startDate, endDate)) {
                    val engagementData = CalendarData(
                        snapshot.child("image").value.toString(),
                        snapshot.child("title").value.toString(),
                        snapshot.child("location").value.toString(),
                        "$startDate - $endDate"
                    )
                    engagementList.add(engagementData)
                    calendarAdapter.notifyItemInserted(engagementList.size - 1)
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                // Handle changes if necessary
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                // Handle removal if necessary
                // You may want to remove the corresponding item from the list and notify the adapter
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                // Handle movement if necessary
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled
            }
        })
    }

    private fun isDateInRange(selectedDate: String, startDate: String, endDate: String): Boolean {
        // Convert selectedDate, startDate, and endDate to Date objects or another suitable format
        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("Asia/Manila")

        val selectedDateTime = sdf.parse(selectedDate)
        val startDateTime = sdf.parse(startDate)
        val endDateTime = sdf.parse(endDate)

        // Check if selectedDate is within the range
        return selectedDateTime in startDateTime..endDateTime
    }
}
