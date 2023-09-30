package com.example.civicall

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.civicall.databinding.ActivityLoloBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso

class lolo : AppCompatActivity() {

    private lateinit var BackClick: ImageView
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var binding: ActivityLoloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoloBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        BackClick = findViewById(R.id.back1)

        BackClick.setOnClickListener {
            // Open the "Menu" activity/form

            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        val setting: TextView = findViewById(R.id.Setting)
        val calendar: TextView = findViewById(R.id.calendar)
        val profile1: TextView = findViewById(R.id.Profile)
        val verification1: TextView = findViewById(R.id.verification)
        val AboutUs1: TextView = findViewById(R.id.AboutUs1)
        val feedback1: TextView = findViewById(R.id.feedback)
        val editProfileCardView:TextView= findViewById(R.id.editprofile)

        profile1.setOnClickListener {
            // Handle click for menu item 1
            val intent = Intent(this, myprofile1::class.java)
            startActivity(intent)
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
            // Open the "Edit Profile" activity/form
            val intent = Intent(this, myprofile1::class.java)
            startActivity(intent)
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
                    binding.lastName.text = lname.toString()
                    binding.email1.text = email.toString()

                    val profileImage =
                        binding.profileImage // Replace with your ImageView ID in the layout
                    // Load the profile image using Picasso library
                    if (imageProfile != null && imageProfile.toString().isNotEmpty()) {
                        Picasso.get().load(imageProfile.toString()).into(profileImage)
                    }
                    Toast.makeText(this, "Successfully Retrieved", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()
                }
            }.addOnFailureListener{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
    }


    }



