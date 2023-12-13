package com.example.civicall.Calendar

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
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
    private fun updateNoItemViewsVisibility() {
        if (engagementList.isEmpty()) {
            // No items in the list, make the views visible
            binding.noimage.visibility = View.VISIBLE
            binding.noimagetext.visibility = View.VISIBLE
        } else {
            // There are items in the list, make the views gone
            binding.noimage.visibility = View.GONE
            binding.noimagetext.visibility = View.GONE
        }
    }

    @SuppressLint("NotifyDataSetChanged")
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
                    val postKey = snapshot.key ?: ""
                    val hasAttended = participantsSnapshot.child(currentUserUid).getValue(Boolean::class.java) ?: false

                    val engagementData = CalendarData(
                        snapshot.child("image").value.toString(),
                        snapshot.child("title").value.toString(),
                        snapshot.child("location").value.toString(),
                        startDate,
                        endDate,
                        postKey,
                        hasAttended
                    )
                    engagementList.add(engagementData)
                    calendarAdapter.notifyItemInserted(engagementList.size - 1)
                }

                // Update visibility based on the presence of items in the RecyclerView
                updateNoItemViewsVisibility()
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                val participantsSnapshot = snapshot.child("Participants")
                val currentUserUid = auth.currentUser?.uid

                if (currentUserUid != null && participantsSnapshot.hasChild(currentUserUid)) {
                    val hasAttended = participantsSnapshot.child(currentUserUid).getValue(Boolean::class.java) ?: false
                    val startDate = snapshot.child("startDate").value.toString()
                    val endDate = snapshot.child("endDate").value.toString()

                    if (isDateInRange(selectedDate, startDate, endDate)) {
                        // Find the position of the changed item in the list
                        val position = engagementList.indexOfFirst { it.postKey == snapshot.key }

                        if (position != -1) {
                            // Update the engagement data and notify the adapter
                            engagementList[position].apply {
                                // Update the hasAttended value
                                this.hasAttended = hasAttended
                            }
                            calendarAdapter.notifyItemChanged(position)
                        }
                    }
                }
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                updateNoItemViewsVisibility()
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                // Handle movement if necessary
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled
            }
        })

        // Update visibility initially
        updateNoItemViewsVisibility()
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
