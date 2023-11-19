package com.example.civicall

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.civicall.databinding.ActivityProfiledetailsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso

class ProfileDetails : AppCompatActivity() {
    private lateinit var binding: ActivityProfiledetailsBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var networkUtils: NetworkUtils
    private lateinit var totalEngagementTextView: TextView
    private var postsListener: ValueEventListener? = null
    private lateinit var activePtsTextView: TextView
    private lateinit var finishactTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfiledetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        activePtsTextView = findViewById(R.id.activepts)
        finishactTextView = findViewById(R.id.finishact)
        totalEngagementTextView = findViewById(R.id.totaleng)

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
        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }
    }

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
                val verificationStatus = snapshot.child("verificationStatus").getValue(Boolean::class.java) ?: false
                val activePts = snapshot.child("activepts").value
                val finishact = snapshot.child("finishactivity").value
                finishactTextView.text = finishact.toString()
                activePtsTextView.text = activePts.toString()
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

                val profileImage = binding.profileImage // Replace with your ImageView ID in the layout

                // Load the profile image using Picasso library with a placeholder
                if (imageProfile != null && imageProfile.toString().isNotEmpty()) {
                    Picasso.get()
                        .load(imageProfile.toString())
                        .placeholder(R.drawable.three)
                        .into(profileImage)
                } else {
                    profileImage.setImageResource(R.drawable.three)
                }
                if (verificationStatus) {
                    // If verificationStatus is true, set a drawable for a verified account
                    binding.email1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.verificationtrue_icon, 0, 0, 0)
                    // Tint the drawable for verified accounts
                    binding.email1.compoundDrawables[0]?.setColorFilter(ContextCompat.getColor(this, R.color.verified), PorterDuff.Mode.SRC_IN)
                } else {
                    // If verificationStatus is false, set a drawable for an unverified account
                    binding.email1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.verificationfalse_icon, 0, 0, 0)
                    // Tint the drawable for unverified accounts
                    binding.email1.compoundDrawables[0]?.setColorFilter(ContextCompat.getColor(this, R.color.unverifiedyellow), PorterDuff.Mode.SRC_IN)
                }
            } else {
                Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()
            }


        }.addOnFailureListener {
            // Show a toast if there's a failure in fetching data
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
        val userRef = FirebaseDatabase.getInstance().getReference("Users").child(uid)
        userRef.child("CurrentEngagement").addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val totalEngagementCount = dataSnapshot.getValue(Int::class.java) ?: 0
                totalEngagementTextView.text = totalEngagementCount.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                val errorMessage = "Database error: ${databaseError.message}"
                Log.e("ProfileDetails", errorMessage)
                Toast.makeText(this@ProfileDetails, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
    override fun onDestroy() {
        super.onDestroy()

        // Cleanup to unregister the network callback
        networkUtils.cleanup()
    }
}