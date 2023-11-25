package com.example.civicall

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.Notification.NotificationAdapter
import com.example.civicall.Notification.NotificationModel
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class OneNotificationFragment : Fragment(), ValueEventListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var currentUserUid: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_one_notification, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize and set up the adapter
        notificationAdapter = NotificationAdapter(requireContext(), emptyList())
        recyclerView.adapter = notificationAdapter

        // Fetch notification items from Firebase
        getNotificationItems()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Get the current user UID
        currentUserUid = FirebaseAuth.getInstance().currentUser?.uid ?: ""
    }

    private fun getNotificationItems() {
        FirebaseApp.initializeApp(requireContext())

        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("Upload Engagement") // Replace "engagement" with the appropriate path to your data

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val notificationList = mutableListOf<NotificationModel>()

                for (engagementSnapshot in dataSnapshot.children) {
                    val startDate = engagementSnapshot.child("startDate").getValue(String::class.java) ?: ""
                    val title = engagementSnapshot.child("title").getValue(String::class.java) ?: ""

                    // Check if the user's UID is in the participants list
                    val participantsSnapshot = engagementSnapshot.child("Participants")

                    if (participantsSnapshot.hasChild(currentUserUid)) {
                        // Always create a NotificationModel object with the retrieved values
                        val notificationModel = NotificationModel(title, startDate)
                        notificationList.add(notificationModel)
                    }
                }

                // Update the adapter with the new data
                notificationAdapter.updateData(notificationList)

                // Check if the user's VerificationStatus is true
                val usersRef = database.getReference("Users")
                usersRef.child(currentUserUid).addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val verificationStatus = snapshot.child("VerificationStatus").getValue(Boolean::class.java)
                        if (verificationStatus == true) {
                            // Show toast message
                            Toast.makeText(requireContext(), "Verification status is true", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.e("FirebaseData", "Error retrieving user data: ${error.message}")
                    }
                })
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("FirebaseData", "Error retrieving data: ${databaseError.message}")
            }
        })
    }

    override fun onDataChange(dataSnapshot: DataSnapshot) {
        // Implementation of onDataChange method
        // This method is called when the data in the Firebase database changes.
        // You can add your code here to handle the updated data.
    }

    override fun onCancelled(databaseError: DatabaseError) {
        // Implementation of onCancelled method
        // This method is called when the database operation is cancelled.
        // You can add your code here to handle the cancelled operation.
    }
}