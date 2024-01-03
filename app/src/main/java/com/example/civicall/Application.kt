package com.example.civicall

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessaging

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)

        // Enable Firebase persistence for Realtime Database (if needed)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)

        // Subscribe to a topic if needed
        FirebaseMessaging.getInstance().subscribeToTopic("CiviCall_Topic")
    }
}
