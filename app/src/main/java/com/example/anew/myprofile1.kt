package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.anew.databinding.ActivityMyprofile1Binding
import com.example.anew.databinding.ActivityMyprofileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso // Import Picasso for image loading

class myprofile1 : AppCompatActivity() {
    private lateinit var binding: ActivityMyprofile1Binding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize binding before setting the content view
        binding = ActivityMyprofile1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Edit.setOnClickListener {
            startActivity(Intent(this, Myprofile::class.java))

        }

        // Initialize Firebase authentication instance
        firebaseAuth = FirebaseAuth.getInstance()

        // Check if the user is logged in
        checkUser()

        // Set up click listeners for UI elements


        binding.back100.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)        }


    }

    // Function to check if a user is logged in or not
    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            // If the user is not logged in, redirect to the login screen
            startActivity(Intent(this, Login::class.java))
            finish()
        } else {
            // If the user is logged in, fetch and display user data
            val uid = firebaseUser.uid
            readData(uid)
        }
    }

    // Function to fetch and display user data from Firebase
    private fun readData(uid: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uid).get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val firstName1 = snapshot.child("firstname").value
                val lastName2 = snapshot.child("lastname").value
                val address = snapshot.child("address").value
                val email2 = snapshot.child("email").value
                val birthday = snapshot.child("birthday").value
                val gender = snapshot.child("gender").value
                val contact = snapshot.child("contactno").value
                val imageProfile = snapshot.child("ImageProfile").value
                val campus = snapshot.child("campus").value
                val emergencyContact = snapshot.child("emergencyContact").value

                // Set the fetched data to respective TextViews
                binding.FirstName1.text = firstName1.toString()
                binding.LastName2.text = lastName2.toString()
                binding.ContactNum.text = contact.toString()
                binding.useraddress.text = address.toString()
                binding.Email2.text = email2.toString()
                binding.userbday.text = birthday.toString()
                binding.usergender.text = gender.toString()
                binding.Campus1.text = campus.toString()
                binding.EmergencyContact.text = emergencyContact.toString()
                val profileImage =
                    binding.profileImage // Replace with your ImageView ID in the layout
                // Load the profile image using Picasso library
                if (imageProfile != null && imageProfile.toString().isNotEmpty()) {
                    Picasso.get().load(imageProfile.toString()).into(profileImage)
                }
                }
                else {
                    Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()

                }

            }.addOnFailureListener {
                        // Show a toast if there's a failure in fetching data
                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                    }
            }
        }



