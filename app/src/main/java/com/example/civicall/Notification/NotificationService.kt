package com.example.civicall.Notification

import android.app.Service
import android.content.Intent
import android.os.IBinder

class NotificationService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            val title = intent.getStringExtra("title") ?: ""
            val startDate = intent.getStringExtra("startDate") ?: ""

            val broadcastIntent = Intent("com.example.civicall.SHOW_NOTIFICATION")
            broadcastIntent.putExtra("title", title)
            broadcastIntent.putExtra("startDate", startDate)
            sendBroadcast(broadcastIntent)
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
