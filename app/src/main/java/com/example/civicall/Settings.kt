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
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.civicall.NotificationsToken.TokenRegistration
import com.example.civicall.databinding.ActivitySettingsBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.concurrent.atomic.AtomicInteger

class Settings : AppCompatActivity(), ValueEventListener {

    private lateinit var currentUserUid: String
    private lateinit var notificationSwitch: SwitchCompat
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val verificationNotificationCount = AtomicInteger(0)
    private val notificationList =
        mutableListOf<NotificationCompat.Builder>() // List to store notifications

    private lateinit var tokenRegistration: TokenRegistration

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

        tokenRegistration = TokenRegistration()

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val changepass = binding.changepass
        changepass.setOnClickListener {
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
        }
        val otherproblem = binding.otherproblem
        otherproblem.setOnClickListener {
            val intent = Intent(this, ReportProblem::class.java)
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
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)
        }

        notificationSwitch = findViewById(R.id.notificationSwitch)
        notificationSwitch.isChecked =
            sharedPreferences.getBoolean("notificationSwitchState", false)

        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                requestNotificationPermission()
                getNotificationItems()
                tokenRegistration.registerToken()
            } else {
                // Disable notifications
                // You may want to cancel existing notifications here
            }
            // Save the state of the switch to SharedPreferences when it changes
            saveSwitchStateToSharedPreferences(isChecked)
        }

        checkAndShowVerificationNotification()
    }

    private fun saveSwitchStateToSharedPreferences(isChecked: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("notificationSwitchState", isChecked)
        editor.apply()
    }

    private fun getNotificationItems() {
        if (!notificationSwitch.isChecked) {
            return
        }

        FirebaseApp.initializeApp(this)
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("Upload Engagement")
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

            // Add the builder to the list
            notificationList.add(builder)
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
        val verificationStatusRef =
            database.getReference("Users/$currentUserUid/verificationStatus")

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
                    Toast.makeText(
                        this@Settings,
                        "Your account is not verified.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@Settings,
                    "Error retrieving verification status",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun showVerificationNotification() {
        Log.d("NotificationDebug", "Showing verification notification")

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.img_3)
            .setContentTitle("Account Verified")
            .setContentText("Congratulations! Your account has been verified.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Add the builder to the list
        notificationList.add(builder)

        // Show verification notification immediately
        showAllNotifications()
    }

    private fun dismissVerificationNotification() {
        // Dismiss the verification notification
        // (This method is not needed since we're showing notifications simultaneously)
    }

    // dito nag-trigger yung mga Notifications
    override fun onDataChange(snapshot: DataSnapshot) {
        for (childSnapshot in snapshot.children) {
            val participantsSnapshot = childSnapshot.child("Participants")
            val title = childSnapshot.child("title").value.toString()
            val startDate = childSnapshot.child("startDate").value.toString()

            if (participantsSnapshot.hasChild(currentUserUid)) {
                notifyUserJoinedEvent(title, startDate)
            }
        }

        // Show all notifications after processing the data
        showAllNotifications()
    }

    override fun onCancelled(error: DatabaseError) {
        Toast.makeText(this, "Data retrieval cancelled", Toast.LENGTH_SHORT).show()
    }

    private var totalNotificationsShown = 0

    // Function to show all notifications at once
    private fun showAllNotifications() {
        // Notify using the NotificationManager for each notification in the list
        with(NotificationManagerCompat.from(applicationContext)) {
            notificationList.forEachIndexed { index, builder ->
                if (totalNotificationsShown < 2) { // Change to 2 for two times
                    notify(index + 1, builder.build())
                    totalNotificationsShown++
                }
            }
        }

        // Clear the list after showing notifications
        notificationList.clear()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }
}
