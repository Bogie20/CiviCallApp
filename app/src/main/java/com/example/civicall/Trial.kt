package com.example.civicall

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ValueEventListener

class Trial : AppCompatActivity(), ValueEventListener {
    private lateinit var currentUserUid: String
    private lateinit var notificationSwitch: SwitchCompat

    companion object {
        private const val CHANNEL_ID = "channelId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trial)

        // Get the current user UID
        currentUserUid = FirebaseAuth.getInstance().currentUser?.uid ?: ""

        // Create notification channel
        createNotificationChannel()

        // Find the Switch widget in the layout
        notificationSwitch = findViewById(R.id.notificationSwitch)
        notificationSwitch.isChecked = false

        // Set up a listener for the Switch to detect changes
        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Enable notifications
                requestNotificationPermission()
            } else {
                // Disable notifications
                // You may want to cancel existing notifications here
            }
        }
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
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun requestNotificationPermission() {
        // Ask the user to grant notification permission
        val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
        startActivity(intent)
        Toast.makeText(
            this,
            "Please grant notification permission for the app",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        // Implement the logic for handling data changes in the Firebase database
    }

    override fun onCancelled(error: DatabaseError) {
        // Handle the error when data retrieval from Firebase database is cancelled
    }

    private fun sendDefaultNotification(title: String, text: String) {
        // Check if the notification switch is on
        if (!notificationSwitch.isChecked) {
            // If the switch is off, do not show notifications
            return
        }

        // Check if the notification permission is granted
        if (isNotificationPermissionGranted()) {
            // Create a notification builder with the specified parameters
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.img_5)
                .setContentTitle("You Join on: $title")
                .setContentText("See You on $text")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            // Notify using the NotificationManager
            with(NotificationManagerCompat.from(applicationContext)) {
                notify(1, builder.build())
            }

            // Call the function to add notification to the database
            //addNotificationToDatabase(currentUserUid, title, "See You on $text")
        } else {
            // Permission not granted, prompt user to grant notification permission
            requestNotificationPermission()
        }
    }

    // Function to check if notification permission is granted
    private fun isNotificationPermissionGranted(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this@Trial,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    }


    private fun getNotificationItems() {
        // If the switch is off, do not fetch notifications
        if (!notificationSwitch.isChecked) {
            return
        }

        // Initialize Firebase
        FirebaseApp.initializeApp(this)

        // Get a reference to the Firebase database
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("Upload Engagement")

        // Set up a listener to fetch data when it changes in Firebase
        ref.addValueEventListener(this)
    }
}