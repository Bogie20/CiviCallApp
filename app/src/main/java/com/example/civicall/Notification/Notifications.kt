package com.example.civicall.Notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

class Notifications : AppCompatActivity() {

    companion object {
        const val CHANNEL_ID = "channelId"
        private const val REQUEST_CODE_NOTIFICATION_PERMISSION = 123
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var currentUserUid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificationss)

        // Request push notification permission
        requestNotificationPermission()

        // Initialize currentUserUid
        currentUserUid = FirebaseAuth.getInstance().currentUser?.uid ?: ""

        // Create notification channel and send default notification
        createNotificationChannel()
        sendDefaultNotification()

        // Initialize recyclerView
        initializeRecyclerView()

        // Get notification items
        getNotificationItems()
    }

    private fun requestNotificationPermission() {
        if (ActivityCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.RECEIVE_BOOT_COMPLETED
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request the permission
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.RECEIVE_BOOT_COMPLETED),
                REQUEST_CODE_NOTIFICATION_PERMISSION
            )
        } else {
            // Permission already granted, continue with initialization
            initializeApp()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_NOTIFICATION_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, continue with initialization
                initializeApp()
            } else {
                // Permission denied, handle accordingly
                Toast.makeText(
                    this,
                    "Notification permission denied. Some features may not work.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun initializeApp() {
        // Initialize recyclerView
        initializeRecyclerView()

        // Get notification items
        getNotificationItems()
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

    private fun sendDefaultNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Hello") // Set the title
            .setContentText("CiviCall") // Set the text
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(applicationContext)) {
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(1, builder.build())
        }
    }

    private fun initializeRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)

        // Remove the recyclerView from its current parent if it has one
        val parent = recyclerView.parent as? ViewGroup
        parent?.removeView(recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        notificationAdapter = NotificationAdapter(this, emptyList())
        recyclerView.adapter = notificationAdapter
    }

    private fun getNotificationItems() {
        FirebaseApp.initializeApp(this)

        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("Upload Engagement")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val notificationList = mutableListOf<NotificationModel>()
                val currentDate = Date()
                val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mma", Locale("en", "PH"))
                for (engagementSnapshot in dataSnapshot.children) {
                    val startDateStr = engagementSnapshot.child("startDate")?.getValue(String::class.java) ?: ""

                    // Parse the startDate string into a Date object
                    val startDate = dateFormat.parse(startDateStr)

                    // Check if the startDate is in the future
                    if (startDate != null && startDate.after(currentDate)) {
                        val title = engagementSnapshot.child("title")?.getValue(String::class.java) ?: ""

                        val participantsSnapshot = engagementSnapshot.child("Participants")

                        if (participantsSnapshot.hasChild(currentUserUid)) {
                            val category = engagementSnapshot.child("category")?.getValue(String::class.java) ?: ""
                            val status = engagementSnapshot.child("status")?.getValue(String::class.java) ?: ""

                            val notificationModel = NotificationModel("", "", "", startDateStr, title, category, status)
                            notificationList.add(notificationModel)
                        }
                    }
                }


                // Update the adapter with the new data
                notificationAdapter.updateData(notificationList)


        }



            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        })
    }
}