package com.example.civicall
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.civicall.Notification.Notifications.Companion.CHANNEL_ID
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Handle incoming FCM messages here
        // You can extract data from the message and show notifications
        showNotification(remoteMessage.data)
    }

    private fun showNotification(data: Map<String, String>) {
        val title = data["title"]
        val startDate = data["startDate"]
        Toast.makeText(applicationContext, "Notification received: $title - $startDate", Toast.LENGTH_SHORT).show()

        // Check if the notification permission is granted
        if (isNotificationPermissionGranted()) {
            // Create a notification builder with the specified parameters
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.img_5)
                .setContentTitle("You joined an event: $title")
                .setContentText("Event starts on: $startDate")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            // Notify using the NotificationManager
            with(NotificationManagerCompat.from(applicationContext)) {
                notify(1, builder.build())
            }
        } else {
            // Permission not granted, prompt user to grant notification permission
            requestNotificationPermission()
        }
    }

    private fun isNotificationPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            "android.permission.NOTIFICATION_POLICY_ACCESS_GRANTED"
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestNotificationPermission() {
        // You can implement your logic to request notification permission here
        // For example, you can show a dialog or launch an activity to request permission
    }
}
