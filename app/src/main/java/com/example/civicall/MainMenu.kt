package com.example.civicall

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivityMainmenuBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso

class MainMenu : AppCompatActivity() {

    private lateinit var BackClick: ImageView
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var binding: ActivityMainmenuBinding
    private var isLogoutDialogShown = false
    private lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        BackClick = findViewById(R.id.backbtn)

        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }

        val setting: TextView = findViewById(R.id.Setting)
        val calendar: TextView = findViewById(R.id.calendar)
        val logout: TextView = findViewById(R.id.logout)
        val verification1: TextView = findViewById(R.id.verification)
        val AboutUs1: TextView = findViewById(R.id.AboutUs1)
        val feedback1: TextView = findViewById(R.id.feedback)
        val editProfileCardView:TextView= findViewById(R.id.editprofile)

        logout.setOnClickListener {
            if (!isLogoutDialogShown) { // Check if the dialog is not already shown
                isLogoutDialogShown = true // Set the flag to true
                // Create a custom logout confirmation dialog
                val dialogView = layoutInflater.inflate(R.layout.dialog_logout, null)
                val dialogBuilder = AlertDialog.Builder(this)
                    .setView(dialogView)
                val dialog = dialogBuilder.create()

                dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                val yesButton = dialogView.findViewById<Button>(R.id.logoutBtn)
                val cancelButton = dialogView.findViewById<Button>(R.id.cancelBtn)

                yesButton.setOnClickListener {
                    // Handle click for the "Yes, Logout" button
                    firebaseAuth.signOut()
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                    finish()
                    dialog.dismiss()
                }

                cancelButton.setOnClickListener {
                    // Handle click for the "Cancel" button
                    dialog.dismiss()
                }

                dialog.setOnDismissListener {
                    isLogoutDialogShown = false // Reset the flag when the dialog is dismissed
                }

                dialog.show()
            }
        }

        verification1.setOnClickListener {
            // Handle click for menu item 2
            val intent = Intent(this, Accountverification::class.java)
            startActivity(intent)
        }
        setting.setOnClickListener {
            // Handle click for menu item 2
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }

        AboutUs1.setOnClickListener {
            // Handle click for About Us menu item
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)
        }

        feedback1.setOnClickListener {
            // Handle click for Feedback menu item
            val intent = Intent(this, Feedback::class.java)
            startActivity(intent)
        }
        calendar.setOnClickListener {
            // Handle click for Feedback menu item
            val intent = Intent(this, Eventcalendar::class.java)
            startActivity(intent)
        }
        editProfileCardView.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

    }



    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null){
            startActivity(Intent(this, Login::class.java))
            finish()
        } else {
            val uid = firebaseUser.uid
            readData(uid)
        }
    }

    private fun readData(uid: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uid).get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val uid = it.child("uid").value
                    val fname = it.child("firstname").value
                    val lname = it.child("lastname").value
                    val email = it.child("email").value
                    val imageProfile = it.child("ImageProfile").value
                    // Add space between first name and last name

                    binding.firstName.text = fname.toString()
                    binding.firstName.text = fname.toString()
                    binding.lastName.text = lname.toString()
                    binding.email1.text = email.toString()

                    val profileImage =
                        binding.profileImage // Replace with your ImageView ID in the layout
                    // Load the profile image using Picasso library
                    if (imageProfile != null && imageProfile.toString().isNotEmpty()) {
                        Picasso.get().load(imageProfile.toString()).into(profileImage)
                    }
                } else {
                    Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()
                }
            }.addOnFailureListener{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onDestroy() {
        super.onDestroy()

        // Cleanup to unregister the network callback
        networkUtils.cleanup()
    }
    }



