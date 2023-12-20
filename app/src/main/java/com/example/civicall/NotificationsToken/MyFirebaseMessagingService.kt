package com.example.civicall.NotificationsToken

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.civicall.Notification.Notifications.Companion.CHANNEL_ID
import com.example.civicall.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private fun isNotificationPermissionGranted(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestNotificationPermission() {
        val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
        startActivity(intent)
        Toast.makeText(
            this,
            "Please grant notification permission for the app",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d("MyFirebaseMessaging", "From: ${remoteMessage.from}")

        remoteMessage.data.isNotEmpty().let {
            Log.d("MyFirebaseMessaging", "Message data payload: ${remoteMessage.data}")

            // Extract data from the payload
            val title = remoteMessage.data["title"]

            // Check the type of notification based on the data
            when (title) {
                "Event Joined" -> {
                    val eventTitle = remoteMessage.data["eventTitle"]
                    val eventStartDate = remoteMessage.data["eventStartDate"]
                    sendEventNotification(eventTitle, eventStartDate)
                }
                "Account Verified" -> showVerificationNotification()
                else -> {
                    // Handle other types of notifications if needed
                }
            }
        }
    }

    override fun onNewToken(token: String) {
        // Handle token refresh
        Log.d("MyFirebaseMessaging", "Refreshed token: $token")
        // You may need to send the new token to your server.
    }

    private fun sendEventNotification(title: String?, startDate: String?) {
        // Check if the notification permission is granted
        if (isNotificationPermissionGranted()) {
            // Create a notification builder with the specified parameters
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.img_5)
                .setContentTitle("You joined an event: $title")
                .setContentText("Event starts on: $startDate")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            // Show the notification
            with(NotificationManagerCompat.from(this)) {
                notify(1, builder.build())
            }
        } else {
            // Permission not granted, prompt user to grant notification permission
            requestNotificationPermission()
        }
    }

    private fun showVerificationNotification() {
        Log.d("NotificationDebug", "Showing verification notification")

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.img_3)
            .setContentTitle("Account Verified")
            .setContentText("Congratulations! Your account has been verified.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Show the notification
        with(NotificationManagerCompat.from(this)) {
            notify(2, builder.build())
        }
    }
}