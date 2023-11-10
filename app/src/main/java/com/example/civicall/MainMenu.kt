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
import androidx.appcompat.widget.AppCompatTextView
import com.example.civicall.databinding.ActivityMainmenuBinding
import com.google.android.material.button.MaterialButton
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

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
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
                val dialogView = layoutInflater.inflate(R.layout.dialog_confirmation, null)
                val dialogBuilder = AlertDialog.Builder(this)
                    .setView(dialogView)
                val dialog = dialogBuilder.create()

                dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)


                val title: AppCompatTextView = dialogView.findViewById(R.id.ConfirmTitle)
                val message: AppCompatTextView = dialogView.findViewById(R.id.logoutMsg)
                val logout: MaterialButton = dialogView.findViewById(R.id.saveBtn)
                val cancelBtn: MaterialButton = dialogView.findViewById(R.id.cancelBtn)

                title.text = "Logout"
                message.text = "Are you sure you want to Logout?"

                logout.text = "Yes"
                logout.setOnClickListener {
                    // Handle click for the "Yes, Logout" button
                    firebaseAuth.signOut()
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                    finish()
                    dialog.dismiss()
                }
                cancelBtn.text = "Cancel"
                cancelBtn.setOnClickListener {
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
                    val verificationStatus = it.child("verificationStatus").value
                    val imageProfile = it.child("ImageProfile").value

                    binding.firstName.text = fname.toString()
                    binding.lastName.text = lname.toString()
                    binding.email1.text = email.toString()

                    val profileImage = binding.profileImage // Replace with your ImageView ID in the layout

                    // Load the profile image using Picasso library
                    if (imageProfile != null && imageProfile.toString().isNotEmpty()) {
                        Picasso.get()
                            .load(imageProfile.toString())
                            .placeholder(R.drawable.three) // Replace with the resource ID of your placeholder image
                            .into(profileImage)
                    } else {
                        // If no image URL is available, set the placeholder directly
                        profileImage.setImageResource(R.drawable.three)
                    }

                    // Check verification status and set drawable accordingly
                    if (verificationStatus == true) {
                        // If verificationStatus is true, set a drawable for a verified account
                        binding.email1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.verificationtrue_icon, 0, 0, 0)
                    } else {
                        // If verificationStatus is false, set a drawable for an unverified account
                        binding.email1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.verificationfalse_icon, 0, 0, 0)
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



