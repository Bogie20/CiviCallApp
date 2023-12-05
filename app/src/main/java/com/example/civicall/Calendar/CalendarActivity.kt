package com.example.civicall.Calendar

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.MainMenu
import com.example.civicall.R
import com.google.firebase.auth.FirebaseAuth
import com.example.civicall.databinding.ActivityCalendarBinding
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalendarBinding
    private lateinit var calendarView: CalendarView
    private lateinit var recyclerView: RecyclerView
    private lateinit var calendarAdapter: CalendarAdapter
    private lateinit var engagementList: MutableList<CalendarData>

    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private var childEventListener: ChildEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calendarView = findViewById(R.id.calendarView)
        recyclerView = findViewById(R.id.recyclerView)
        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        auth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().reference.child("Upload Engagement")

        engagementList = mutableListOf()
        calendarAdapter = CalendarAdapter(engagementList)

        recyclerView.adapter = calendarAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Highlight the current date
        val currentDate = Calendar.getInstance()
        calendarView.date = currentDate.timeInMillis

        // Load engagements for the current date
        val formattedCurrentDate = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(currentDate.time)
        loadEngagements(formattedCurrentDate)

        // Set the OnDateChangeListener
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
                    val postKey = FirebaseDatabase.getInstance().getReference("Upload Engagement").push().key ?: ""
                    val engagementData = CalendarData(
                        snapshot.child("image").value.toString(),
                        snapshot.child("title").value.toString(),
                        snapshot.child("location").value.toString(),
                        "$startDate - $endDate",
                        postKey
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
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }
}
