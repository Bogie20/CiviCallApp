package com.example.civicall.Notification

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.example.civicall.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import nl.joery.animatedbottombar.AnimatedBottomBar
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class NotificationFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var notificationList: MutableList<DataClassNotif>
    private lateinit var noPostsImage: ImageView
    private lateinit var nestedScrollView: NestedScrollView
    private lateinit var noPostsText: TextView
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)
        noPostsImage = view.findViewById(R.id.noPostsImage)
        noPostsText = view.findViewById(R.id.noPostsText)
        recyclerView = view.findViewById(R.id.recyclerView)
        nestedScrollView = view.findViewById(R.id.nestedRecycler)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        notificationList = mutableListOf()
        progressBar = view.findViewById(R.id.progressBar)
        notificationAdapter = NotificationAdapter(notificationList)
        recyclerView.adapter = notificationAdapter
        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        view.startAnimation(anim)
        auth = FirebaseAuth.getInstance()
        val currentUserUid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().reference.child("Upload Engagement")

        databaseReference.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                notificationList.clear()

                for (engagementSnapshot in dataSnapshot.children) {
                    val postKey = engagementSnapshot.key ?: ""

                    // Check if the current user is a participant in this engagement
                    val participantsRef = engagementSnapshot.child("Participants")
                    if (participantsRef.hasChild(currentUserUid!!)) {
                        // User is a participant, retrieve and display information

                        // Retrieve start date and time from the database
                        val startDateStr = engagementSnapshot.child("startDate").value.toString()
                        val endDateStr = engagementSnapshot.child("endDate").value.toString()

                        // Check if the engagement is within 24 hours from the current date and time
                        if (isWithin24Hours(startDateStr)) {
                            // User is a participant, retrieve and display information
                            val category = engagementSnapshot.child("category").value.toString()
                            val title = engagementSnapshot.child("title").value.toString()
                            val startDate = engagementSnapshot.child("startDate").value.toString()
                            val endDate = engagementSnapshot.child("endDate").value.toString()
                            val imageUrl = engagementSnapshot.child("image").value.toString()

                            // Calculate the timestamp 24 hours before the start date
                            val timestamp24HoursBefore = calculateTimestamp24HoursBefore(startDate)

                            val notificationItem = DataClassNotif(
                                postKey,
                                category,
                                title,
                                startDate,
                                endDate,
                                imageUrl,
                                timestamp24HoursBefore
                            )
                            val currentDate = Date()
                            val endDateTime = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(endDateStr)

                            val calendar = Calendar.getInstance()
                            calendar.time = endDateTime
                            calendar.add(Calendar.MONTH, 1)

                            if (currentDate.after(calendar.time)) {
                                // Skip this item as it's more than 1 month after the engagement has ended
                                continue
                            }


                            notificationList.add(0, notificationItem)
                        }
                    }
                }

                notificationAdapter.notifyDataSetChanged()

                // Check if the notificationList is empty
                if (notificationList.isEmpty()) {
                    // If empty, show the "noPostsImage" and "noPostsText"
                    noPostsImage.visibility = View.VISIBLE
                    noPostsText.visibility = View.VISIBLE
                } else {
                    // If not empty, hide the "noPostsImage" and "noPostsText"
                    noPostsImage.visibility = View.GONE
                    noPostsText.visibility = View.GONE
                }
                progressBar.visibility = View.GONE
            }

            override fun onCancelled(databaseError: DatabaseError) {
                progressBar.visibility = View.GONE
            }
        })


        val animatedBottomBar = requireActivity().findViewById<AnimatedBottomBar>(R.id.bottom_bar)
        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        val faback = requireActivity().findViewById<FloatingActionButton>(R.id.faback)

        nestedScrollView.setOnScrollChangeListener(View.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            // Scroll down
            if (scrollY > oldScrollY) {
                if (animatedBottomBar.isShown) {
                    animatedBottomBar.visibility = View.GONE
                }
                if (fab.isShown) {
                    fab.hide()
                }
                if (faback.isShown) {
                    faback.hide()
                }
            } else if (scrollY < oldScrollY) {
                // Scroll up
                if (!animatedBottomBar.isShown) {
                    animatedBottomBar.visibility = View.VISIBLE
                }
                if (!fab.isShown) {
                    fab.show()
                }
                if (!faback.isShown) {
                    faback.show()
                }
            }
        })

        return view

    }
    companion object {
        const val DATE_FORMAT = "MM/dd/yyyy hh:mm a"
    }
    private fun isWithin24Hours(startDateStr: String): Boolean {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        try {
            val startDate = dateFormat.parse(startDateStr)
            val currentDate = Date()

            // Calculate the difference in milliseconds
            val timeDifference = startDate.time - currentDate.time

            // Check if the time difference is less than 24 hours
            return timeDifference <= 24 * 60 * 60 * 1000
        } catch (e: ParseException) {
            // Handle the parsing exception
            e.printStackTrace()
        }
        return false
    }
    // Modify the calculateTimestamp24HoursBefore function
    private fun calculateTimestamp24HoursBefore(startDateStr: String): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        try {
            val startDate = dateFormat.parse(startDateStr)
            val currentDate = Calendar.getInstance().time

            // If the engagement has started, use the start date directly
            return if (currentDate.after(startDate)) {
                startDateStr
            } else {
                // Subtract 24 hours from the start date
                val calendar = Calendar.getInstance()
                calendar.time = startDate
                calendar.add(Calendar.HOUR_OF_DAY, -24)

                // Format the result as a timestamp
                dateFormat.format(calendar.time)
            }
        } catch (e: ParseException) {
            // Handle the parsing exception
            e.printStackTrace()
        }
        // Default to an empty string in case of errors
        return ""
    }
}