package com.example.civicall

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.civicall.Notification.Notifications.Companion.CHANNEL_ID
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class NotificationService : Service() {

    private lateinit var currentUserUid: String
    private lateinit var database: FirebaseDatabase
    private val notificationHandler = Handler(Looper.getMainLooper())

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        database = FirebaseDatabase.getInstance()
        currentUserUid = FirebaseAuth.getInstance().currentUser?.uid ?: ""
        startForeground(1, NotificationCompat.Builder(this, "dummy").build())
        // Use a dummy notification to keep the service in the foreground and prevent it from being killed
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Set up a listener to fetch data when it changes in Firebase
        val ref = database.getReference("Upload Engagement")
        ref.addValueEventListener(notificationListener)

        // Set up a listener to fetch verification status when it changes in Firebase
        val verificationStatusRef = database.getReference("Users/$currentUserUid/verificationStatus")
        verificationStatusRef.addValueEventListener(verificationStatusListener)

        return START_STICKY
    }

    private val notificationListener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            for (childSnapshot in snapshot.children) {
                val participantsSnapshot = childSnapshot.child("Participants")
                val title = childSnapshot.child("title").value.toString()
                val startDate = childSnapshot.child("startDate").value.toString()

                if (participantsSnapshot.hasChild(currentUserUid)) {
                    // Notify the user about the joined event
                    sendEventNotification(title, startDate)
                }
            }
        }

        override fun onCancelled(error: DatabaseError) {
            // Handle onCancelled if needed
        }
    }

    private val verificationStatusListener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val isVerified = snapshot.getValue(Boolean::class.java) ?: false

            if (isVerified) {
                // Notify the user about the account verification
                sendVerificationNotification()
            }
        }

        override fun onCancelled(error: DatabaseError) {
            // Handle onCancelled if needed
        }
    }

    private fun sendEventNotification(title: String, startDate: String) {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.img_5)
            .setContentTitle("You joined an event: $title")
            .setContentText("Event starts on: $startDate")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(applicationContext)) {
            notify(1, builder.build())
        }
    }

    private fun sendVerificationNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.img_3)
            .setContentTitle("Account Verified")
            .setContentText("Congratulations! Your account has been verified.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(applicationContext)) {
            notify(2, builder.build())
        }
    }

    override fun onDestroy() {
        // Remove the listener when the service is stopped
        val ref = database.getReference("Upload Engagement")
        ref.removeEventListener(notificationListener)

        // Remove the verification status listener
        val verificationStatusRef = database.getReference("Users/$currentUserUid/verificationStatus")
        verificationStatusRef.removeEventListener(verificationStatusListener)

        super.onDestroy()
    }
}
