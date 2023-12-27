package com.example.civicall.Notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.civicall.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class NotificationFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var notificationList: MutableList<DataClassNotif>

    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        notificationList = mutableListOf()
        notificationAdapter = NotificationAdapter(notificationList)
        recyclerView.adapter = notificationAdapter

        auth = FirebaseAuth.getInstance()
        val currentUserUid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().reference.child("Upload Engagement")

        // Retrieve data from Firebase
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                notificationList.clear()

                for (engagementSnapshot in dataSnapshot.children) {
                    val postKey = engagementSnapshot.key

                    // Check if the current user is a participant in this engagement
                    val participantsRef = engagementSnapshot.child("Participants")
                    if (participantsRef.hasChild(currentUserUid!!)) {
                        // User is a participant, retrieve and display information
                        val category = engagementSnapshot.child("category").value.toString()
                        val title = engagementSnapshot.child("title").value.toString()
                        val startDate = engagementSnapshot.child("startDate").value.toString()
                        val endDate = engagementSnapshot.child("endDate").value.toString()
                        val imageUrl = engagementSnapshot.child("image").value.toString()

                        val notificationItem = DataClassNotif(category, title, startDate, endDate, imageUrl)
                        notificationList.add(notificationItem)
                    }
                }

                notificationAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error
            }
        })

        return view
    }
}
