package com.example.civicall.Notification

import NotificationAdapter
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class Notifications : AppCompatActivity() {

    companion object {
        const val CHANNEL_ID = "channelId"
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificationss)

        FirebaseApp.initializeApp(this)

        // Check if connected to Firebase
        if (FirebaseApp.getApps(this).isEmpty()) {
            Toast.makeText(this, "Not connected to Firebase", Toast.LENGTH_SHORT).show()
        } else {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val uid = currentUser?.uid
            val email = currentUser?.email
            val currentEngagement = "CurrentEngagement" // Replace this with the actual data from the database
            Toast.makeText(
                this,
                "Connected to Firebase\nUser UID: $uid\nEmail: $email\nCurrent Engagement: $currentEngagement",
                Toast.LENGTH_SHORT
            ).show()
        }

        createNotificationChannel()

        val currentUser = FirebaseAuth.getInstance().currentUser
        val uid = currentUser?.uid
        val email = currentUser?.email
        val currentEngagement = "CurrentEngagement" // Replace this with the actual data from the database
        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        notificationAdapter = NotificationAdapter(getNotificationItems()) // Implement this function
        recyclerView.adapter = notificationAdapter

        val engagements = getNotificationItems()
        for ((index, engagement) in engagements.withIndex()) {
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Engagement: ${engagement.title}")
                .setContentText("Starts on: ${engagement.startDate}")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            with(NotificationManagerCompat.from(this)) {
                notify(index, builder.build())
            }
        }
    }

    // Replace this function with your actual data retrieval logic
    private fun getNotificationItems(): List<NotificationModel> {
        val notificationList = mutableListOf<NotificationModel>()
        val currentUser = FirebaseAuth.getInstance().currentUser
        val uid = currentUser?.uid
        val email = currentUser?.email
        val profileImageUrl = "https://example.com/profile.jpg" // Replace with the actual URL of the user's profile image

        // Populate notificationList with your data
        // Example:
        notificationList.add(NotificationModel(uid ?: "", email ?: "",  profileImageUrl))
        notificationList.add(NotificationModel(uid ?: "", email ?: "",  profileImageUrl))
        // Add more items as needed
        return notificationList
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel Name"
            val descriptionText = "Channel Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
