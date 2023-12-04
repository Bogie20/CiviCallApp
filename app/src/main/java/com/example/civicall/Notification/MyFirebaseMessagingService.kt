package com.example.civicall.Notification

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(newToken: String) {
        super.onNewToken(newToken)

        // Handle token refresh, you can send the new token to your server
        // or perform any necessary actions when the token changes.
        // For example, you might want to update the user's FCM token in your backend.

        // TODO: Implement your logic for handling token changes
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Handle FCM message here
        if (remoteMessage.notification != null) {
            // Handle notification payload
            val title = remoteMessage.notification!!.title
            val body = remoteMessage.notification!!.body

            // Customize the notification as needed and show it
            // You can use the NotificationCompat.builder as you did in your Settings activity
        }

        // Handle data payload if any
        if (remoteMessage.data.isNotEmpty()) {
            val data = remoteMessage.data
            // Process data payload as needed
        }
    }
}