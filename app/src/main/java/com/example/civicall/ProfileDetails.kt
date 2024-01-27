package com.example.civicall

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.civicall.CurrentEngagementList.CurrentEngagements
import com.example.civicall.FinishActivityList.FinishActivity
import com.example.civicall.ActivePoints.ActivePointsEarned
import com.example.civicall.databinding.ActivityProfiledetailsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

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

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        binding.finishLinear.setOnClickListener {
            val intent = Intent(this, FinishActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        binding.activePtsLinear.setOnClickListener {
            val intent = Intent(this, ActivePointsEarned::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        binding.CurrentLinear.setOnClickListener {
            val intent = Intent(this, CurrentEngagements::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
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
    fun formatNumber(number: Int): String {
        return when {
            number < 10000 -> number.toString()
            number < 1000000 -> String.format("%.1fK", number / 1000.0)
            else -> String.format("%.1fM", number / 1000000.0)
        }
    }

    private fun isDateMatched(currentDate: String, endDate: String): Boolean {
        val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        val currentDateTime = sdf.parse(currentDate)
        val endDateTime = sdf.parse(endDate)

        return currentDateTime.after(endDateTime) || currentDateTime.equals(endDateTime)
    }
    private fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }


    private fun readData(uid: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.keepSynced(true)
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
                val course = snapshot.child("course").value
                val yearandSection = snapshot.child("yearandSection").value
                val srcode = snapshot.child("srcode").value
                val verificationStatus =
                    snapshot.child("verificationStatus").getValue(Boolean::class.java) ?: false
                val activePts = snapshot.child("activepts").value
                activePtsTextView.text = formatNumber(activePts.toString().toInt())
                val fullNameTextView: TextView = findViewById(R.id.fullName)
                fullNameTextView.text = "$firstName $lastName"
                binding.email1.text = email.toString()
                binding.mobilenumtxt.text = contact.toString()
                binding.emergencynumtxt.text = Emecontact?.toString() ?: ""
                binding.addresstxt.text = address.toString()
                binding.coursetxt.text = course?.toString() ?: ""
                binding.yearandsecttxt.text = yearandSection?.toString() ?: ""
                binding.srCodetxt.text = srcode?.toString() ?: ""
                binding.dateofbirthtxt.text = birthday.toString()
                binding.gendertxt.text = gender.toString()
                binding.usertypetxt.text = usertype.toString()
                binding.campustxt.text = campus.toString()
                binding.nstpnumtxt.text = nstp?.toString() ?: ""
                val badgeImageView: ImageView = findViewById(R.id.badge_25)
                val userRef = FirebaseDatabase.getInstance().getReference("Upload_Engagement")
                val currentUserId = FirebaseAuth.getInstance().currentUser?.uid

                userRef.orderByChild("Participants/$currentUserId/joined").equalTo(true)
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            val currentDate = getCurrentDate()
                            var finishactCount = 0

                            for (engagementSnapshot in dataSnapshot.children) {
                                val endDateString = engagementSnapshot.child("endDate").getValue(String::class.java)

                                // Check if endDateString is not null before using it
                                if (endDateString != null && isDateMatched(currentDate, endDateString)) {
                                    // Increment the count only for engagements with matched endDate
                                    finishactCount++
                                }
                            }

                            val userNodeRef = FirebaseDatabase.getInstance().getReference("Users/$currentUserId")
                            userNodeRef.child("finishactivity").setValue(finishactCount)
                            finishactTextView.text = formatNumber(finishactCount)
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            val errorMessage = "Database error: ${databaseError.message}"
                            Log.e("ProfileDetails", errorMessage)
                            Toast.makeText(this@ProfileDetails, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    })


                val activePtsInt = activePts.toString().toInt()

                when {
                    activePtsInt in 0..99 -> {
                        badgeImageView.setImageResource(R.drawable.bronzes)
                    }

                    activePtsInt in 100..499 -> {
                        badgeImageView.setImageResource(R.drawable.silver)
                    }

                    activePtsInt in 500..1999 -> {
                        badgeImageView.setImageResource(R.drawable.gold)
                    }

                    else -> {
                        badgeImageView.setImageResource(R.drawable.platinum)
                    }
                }
                val profileImage = binding.profileImage

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
                    binding.email1.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.verifiedalready,
                        0,
                        0,
                        0
                    )
                    // Tint the drawable for verified accounts
                    binding.email1.compoundDrawables[0]?.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.verified
                        ), PorterDuff.Mode.SRC_IN
                    )
                } else {
                    // If verificationStatus is false, set a drawable for an unverified account
                    binding.email1.setCompoundDrawablesWithIntrinsicBounds(
                        R.drawable.verificationfalse_icon,
                        0,
                        0,
                        0
                    )
                    // Tint the drawable for unverified accounts
                    binding.email1.compoundDrawables[0]?.setColorFilter(
                        ContextCompat.getColor(
                            this,
                            R.color.unverifiedyellow
                        ), PorterDuff.Mode.SRC_IN
                    )
                }
            } else {
                Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()
            }


        }.addOnFailureListener {
            // Show a toast if there's a failure in fetching data
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
        val userRef = FirebaseDatabase.getInstance().getReference("Upload_Engagement")
        val currentUserId = FirebaseAuth.getInstance().currentUser?.uid

// Use addValueEventListener instead of addListenerForSingleValueEvent
        userRef.orderByChild("Participants/$currentUserId/joined").equalTo(false)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val currentDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Manila")).time
                    var totalEngagementCount = 0

                    for (engagementSnapshot in dataSnapshot.children) {
                        val endDateString =
                            engagementSnapshot.child("endDate").getValue(String::class.java)

                        // Parse endDateString to Date
                        val endDate =
                            SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US).parse(endDateString)

                        // Compare Date objects
                        if (endDate != null && endDate.after(currentDate)) {
                            // Increment the count only for engagements with future end dates
                            totalEngagementCount++
                        }
                    }

                    // Set the totalEngagementTextView after processing all engagements
                    totalEngagementTextView.text = formatNumber(totalEngagementCount)

                    // Update the CurrentEngagement count in the Users node
                    val userNodeRef = FirebaseDatabase.getInstance().getReference("Users/$currentUserId")
                    userNodeRef.child("CurrentEngagement").setValue(totalEngagementCount)
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

        networkUtils.cleanup()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }
}