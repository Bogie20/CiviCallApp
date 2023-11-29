package com.example.civicall

import android.Manifest
import android.app.NotificationChannel
import android.provider.Settings

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.civicall.Notification.Notifications

import com.example.civicall.databinding.ActivitySettingsBinding
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.atomic.AtomicInteger

class Settings : AppCompatActivity(), ValueEventListener {
    private lateinit var currentUserUid: String
    private lateinit var notificationSwitch: SwitchCompat
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val verificationNotificationCount = AtomicInteger(0)
    companion object {
        private const val CHANNEL_ID = "channelId"
        private const val VERIFICATION_NOTIFICATION_KEY = "verificationNotificationShown"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotificationChannel()


        currentUserUid = FirebaseAuth.getInstance().currentUser?.uid ?: ""
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        binding.backbtn.setOnClickListener {
                super.onBackPressed()
                overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            }

        val changepass = binding.changepass
        changepass.setOnClickListener {
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }
        val otherproblem = binding.otherproblem
        otherproblem.setOnClickListener {
            val intent = Intent(this, Otherproblem::class.java)
            startActivity(intent)
        }
        val termsandsupp = binding.termsandsupp
        termsandsupp.setOnClickListener {
            val intent = Intent(this, PrivacyAndPolicies::class.java)
            startActivity(intent)
        }
        val profilestt = binding.profilesett
        profilestt.setOnClickListener {
            val intent = Intent(this, TermsAndConditions::class.java)
            startActivity(intent)
        }

        val forumsett = binding.forumsett
        forumsett.setOnClickListener {
            val intent = Intent(this, Trial::class.java)
            startActivity(intent)
        }

        notificationSwitch = findViewById(R.id.notificationSwitch)
        // Set the initial state of the switch based on the stored value in SharedPreferences
        notificationSwitch.isChecked = sharedPreferences.getBoolean("notificationSwitchState", false)

        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Enable notifications
                requestNotificationPermission()
                getNotificationItems()
            } else {
                // Disable notifications
                // You may want to cancel existing notifications here
            }
            sendEventNotification("", "")
            // Save the state of the switch to SharedPreferences when it changes
            saveSwitchStateToSharedPreferences(isChecked)
        }

        // Check user verificationStatus and show a one-time notification if verified
        checkAndShowVerificationNotification()
    }

    private fun saveSwitchStateToSharedPreferences(isChecked: Boolean) {
        // Save the state of the switch to SharedPreferences
        val editor = sharedPreferences.edit()
        editor.putBoolean("notificationSwitchState", isChecked)
        editor.apply()
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

    private fun sendEventNotification(title: String, startDate: String) {
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

    // Call this function in onDataChange when the user joins an event
    private fun notifyUserJoinedEvent(title: String, startDate: String) {
        sendEventNotification(title, startDate)
        // You can add additional logic here if needed
    }

    private fun isNotificationPermissionGranted(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this@Settings,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun checkAndShowVerificationNotification() {
        if (!notificationSwitch.isChecked) {
            // If the switch is off, do not show verification notifications
            return
        }
        val database = FirebaseDatabase.getInstance()
        val verificationStatusRef = database.getReference("Users/$currentUserUid/verificationStatus")

        verificationStatusRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val isVerified = snapshot.getValue(Boolean::class.java) ?: false

                // Show a Toast message based on verification status
                if (isVerified) {
                    val currentCount = verificationNotificationCount.incrementAndGet()

                    if (currentCount <= 3) {
                        // Show account verification notification
                        showVerificationNotification()

                        // Set a timer to dismiss the notification after one minute
                        Handler(Looper.getMainLooper()).postDelayed({
                            dismissVerificationNotification()
                        }, 60000) // 60000 milliseconds = 1 minute
                    } else {
                        // Notify the user that the maximum notification limit has been reached
                        Toast.makeText(
                            this@Settings,
                            "Maximum notification limit reached. Your account is verified!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(this@Settings, "Your account is not verified.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Settings, "Error retrieving verification status", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun showVerificationNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.img_3)
            .setContentTitle("Account Verified")
            .setContentText("Congratulations! Your account has been verified.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(applicationContext)) {
            notify(2, builder.build())
        }
    }

    private fun dismissVerificationNotification() {
        // Dismiss the verification notification
        with(NotificationManagerCompat.from(applicationContext)) {
            cancel(2)
        }
    }
///dito nag trigger yung mga Notifications
override fun onDataChange(snapshot: DataSnapshot) {


    for (childSnapshot in snapshot.children) {
        val participantsSnapshot = childSnapshot.child("Participants")
        val title = childSnapshot.child("title").value.toString()
        val startDate = childSnapshot.child("startDate").value.toString()

        if (participantsSnapshot.hasChild(currentUserUid)) {


            // Check if the user has joined an event and trigger a notification
            for (childSnapshot in snapshot.children) {
                val participantsSnapshot = childSnapshot.child("Participants")
                val title = childSnapshot.child("title").value.toString()
                val startDate = childSnapshot.child("startDate").value.toString()

                if (participantsSnapshot.hasChild(currentUserUid)) {
                    // Notify the user about the joined event
                    notifyUserJoinedEvent(title, startDate)
                }
            }

        }
    }
}




    override fun onCancelled(error: DatabaseError) {
        Toast.makeText(this, "Data retrieval cancelled", Toast.LENGTH_SHORT).show()
    }
}