package com.example.civicall.Notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.civicall.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class Notifications : AppCompatActivity() {

    companion object {
        const val CHANNEL_ID = "channelId"
    }

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
            Toast.makeText(this, "Connected to Firebase\nUser UID: $uid\nEmail: $email", Toast.LENGTH_SHORT).show()
        }

        createNotificationChannel()

        val currentUser = FirebaseAuth.getInstance().currentUser
        val uid = currentUser?.uid

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Test Title")
            .setContentText("User UID: $uid")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }

            notify(1, builder.build())
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

            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}