package com.example.civicall.PushNotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.civicall.R
import com.example.civicall.SplashActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Handle the received message here
        remoteMessage.notification?.let {
            showNotification(it.title ?: "Title", it.body ?: "Body")
        }
    }
    private fun showNotification(title: String?, body: String?) {
        val channelId = "civic_channel"
        val channelName = "Verification"

        // Create an intent that opens your main activity
        val intent = Intent(this, SplashActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)  // Removes the notification when clicked

        // Check if body is not null or empty before using BigTextStyle
        if (!body.isNullOrBlank()) {
            val bigTextStyle = NotificationCompat.BigTextStyle()
                .bigText(body)
            notificationBuilder.setStyle(bigTextStyle)
        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Always create the NotificationChannel on devices running Android Oreo and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Generate a unique notification ID
        val notificationId = System.currentTimeMillis().toInt()

        // Display the notification
        notificationManager.notify(notificationId, notificationBuilder.build())
    }
    override fun onNewToken(token: String) {

    }
}
