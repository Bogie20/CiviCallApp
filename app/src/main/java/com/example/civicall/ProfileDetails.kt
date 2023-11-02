package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.example.civicall.databinding.ActivityProfiledetailsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso

class ProfileDetails : AppCompatActivity() {
    private lateinit var binding: ActivityProfiledetailsBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize binding before setting the content view
        binding = ActivityProfiledetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()


        binding.edit.setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        // Initialize Firebase authentication instance
        firebaseAuth = FirebaseAuth.getInstance()

        // Check if the user is logged in
        checkUser()
        // Set up click listeners for UI elements
        val backButton: ImageView = findViewById(R.id.backbtn)
        backButton.setOnClickListener {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }


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

    private fun readData(uid: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uid).get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val firstName = snapshot.child("firstname").value
                val lastName = snapshot.child("lastname").value
                val email = snapshot.child("email").value
                val contact = snapshot.child("phoneno").value
                val Emecontact = snapshot.child("ContactEme").value
                val address = snapshot.child("address").value
                val birthday = snapshot.child("birthday").value
                val gender = snapshot.child("gender").value
                val imageProfile = snapshot.child("ImageProfile").value
                val usertype = snapshot.child("userType").value
                val campus = snapshot.child("campus").value
                val nstp = snapshot.child("nstp").value

                binding.firstName.text = firstName.toString()
                binding.lastName.text = lastName.toString()
                binding.email1.text = email.toString()
                binding.mobilenumtxt.text = contact.toString()
                binding.emergencynumtxt.text = Emecontact.toString()
                binding.addresstxt.text = address.toString()
                binding.dateofbirthtxt.text = birthday.toString()
                binding.gendertxt.text = gender.toString()
                binding.usertypetxt.text = usertype.toString()
                binding.campustxt.text = campus.toString()
                binding.nstpnumtxt.text = nstp.toString()

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
    override fun onDestroy() {
        super.onDestroy()

        // Cleanup to unregister the network callback
        networkUtils.cleanup()
    }
}



