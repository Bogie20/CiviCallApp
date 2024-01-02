package com.example.civicall

import android.app.Application
import com.google.firebase.database.FirebaseDatabase

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        // Enable Firebase persistence
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }
}