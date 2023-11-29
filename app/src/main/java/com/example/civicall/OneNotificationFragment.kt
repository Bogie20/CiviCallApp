package com.example.civicall

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.Notification.NotificationAdapter
import com.example.civicall.Notification.NotificationModel
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

class OneNotificationFragment : Fragment(), ValueEventListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var currentUserUid: String

    companion object {
        private const val CHANNEL_ID = "chanelId"
        private const val PERMISSION_REQUEST_CODE = 123
    }

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

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Get the current user UID
        currentUserUid = FirebaseAuth.getInstance().currentUser?.uid ?: ""

        // Create notification channel
        createNotificationChannel()

        // Fetch notification items from Firebase
        getNotificationItems()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel Name"
            val descriptionText = "Channel Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }



    private fun sendDefaultNotification(title: String, text: String) {
        Log.d("OneNotificationFragment", "Sending default notification: $title, $text")
        val builder = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.img_5)
            .setContentTitle(title)
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(requireContext().applicationContext)) {
            notify(1, builder.build())
        }
    }

    private fun sendReminderNotification(title: String, text: String) {
        Log.d("OneNotificationFragment", "Sending reminder notification: $title, $text")
        val builder = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.img_5)
            .setContentTitle("Reminder: $title")
            .setContentText("Your engagement is starting soon on $text")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(requireContext().applicationContext)) {
            notify(2, builder.build()) // Use a different notification ID for reminders
        }
    }



    private fun getNotificationItems() {
        FirebaseApp.initializeApp(requireContext())

        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("Upload Engagement")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val notificationList = mutableListOf<NotificationModel>()

                for (engagementSnapshot in dataSnapshot.children) {
                    val startDate = engagementSnapshot.child("startDate")?.getValue(String::class.java) ?: ""
                    val title = engagementSnapshot.child("title")?.getValue(String::class.java) ?: ""
                    val category = engagementSnapshot.child("category")?.getValue(String::class.java) ?: ""
                    val recImage = engagementSnapshot.child("image")?.getValue(String::class.java) ?: ""

                    val participantsSnapshot = engagementSnapshot.child("Participants")

                    // Participants node might be null, handle it appropriately
                    if (participantsSnapshot != null && participantsSnapshot.hasChild(currentUserUid)) {
                        val status = getStatus(startDate)
                        val notificationModel = NotificationModel("", recImage,"" ,startDate, title, category, status,)

                        // Add notification to the list
                        notificationList.add(notificationModel)
                    } else {
                        // Log engagement information for which the condition is not met
                        Log.d(
                            "OneNotificationFragment",
                            "Engagement not added to notificationList - Title: $title, Participants: $participantsSnapshot"
                        )
                    }
                }

                // Log contents of notificationList
                Log.d("OneNotificationFragment", "Notification List: $notificationList")

                // Check if notificationList is not empty before updating RecyclerView
                if (notificationList.isNotEmpty()) {
                    // Update RecyclerView adapter with the new data
                    notificationAdapter.updateData(notificationList)
                } else {
                    Log.e("OneNotificationFragment", "Notification List is empty.")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e(
                    "OneNotificationFragment",
                    "Error fetching notification items: ${databaseError.message}"
                )
            }
        })
    }



    private fun isBeforeStartDate(startDate: String): Boolean {
        val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        val currentDate = System.currentTimeMillis()

        try {
            val startDateMillis = dateFormat.parse(startDate)?.time ?: return false
            // Adjust the reminder time as needed, e.g., notify 1 hour before startDate
            val reminderTimeMillis = startDateMillis - TimeUnit.HOURS.toMillis(1)

            return currentDate < reminderTimeMillis
        } catch (e: Exception) {
            Log.e("OneNotificationFragment", "Error parsing startDate: ${e.message}")
            return false
        }
    }

    private fun getStatus(startDate: String): String {
        val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        val currentDate = System.currentTimeMillis()

        try {
            val startDateMillis = dateFormat.parse(startDate)?.time ?: return "Unknown Status"

            Log.d("OneNotificationFragment", "currentDate: $currentDate, startDateMillis: $startDateMillis")

            return when {
                currentDate < startDateMillis -> {
                    Log.d("OneNotificationFragment", "Upcoming Engagement")
                    "Upcoming Engagement"
                }
                currentDate >= startDateMillis -> {
                    Log.d("OneNotificationFragment", "Ongoing Engagement")
                    "Ongoing Engagement"
                }
                else -> {
                    Log.d("OneNotificationFragment", "Finished Engagement")
                    "Finished Engagement"
                }
            }
        } catch (e: Exception) {
            Log.e("OneNotificationFragment", "Error parsing startDate: ${e.message}")
            return "Unknown Status"
        }
    }


    override fun onDataChange(dataSnapshot: DataSnapshot) {
        // Implementation of the onDataChange method
        // You can add your custom logic here
    }

    override fun onCancelled(databaseError: DatabaseError) {
        // Implementation of the onCancelled method
        // You can add your custom logic here
    }
}