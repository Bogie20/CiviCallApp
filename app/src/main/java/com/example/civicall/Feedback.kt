package com.example.civicall


import PopupFragment
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener




class Feedback : AppCompatActivity() {
    private lateinit var BackClick: ImageView
    private lateinit var editTextText2: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var database: FirebaseDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        setContentView(R.layout.activity_feedback)
        BackClick = findViewById(R.id.backbtn)


        editTextText2 = findViewById(R.id.editTextText2)
        ratingBar = findViewById(R.id.ratingBar)


        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            when (rating.toInt()) {
                0 -> editTextText2.text = "Very Dissatisfied"
                1 -> editTextText2.text = "Dissatisfied"
                2, 3 -> editTextText2.text = "Ok"
                4 -> editTextText2.text = "Satisfied"
                5 -> editTextText2.text = "Very Satisfied"
                else -> editTextText2.text = ""
            }
        }


        BackClick.setOnClickListener {
            // Open the "Menu" activity/form
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }


        val popupButton: Button = findViewById(R.id.button2)
        popupButton.setOnClickListener {
            // Show the popup when the button is clicked
            val popupFragment = PopupFragment()
            popupFragment.show(supportFragmentManager, "popup")
        }


        val submitButton: Button = findViewById(R.id.button2)
        submitButton.setOnClickListener {
            // Handle the feedback submission here
            submitFeedback()
        }


        // Initialize the Realtime Database instance
        database = FirebaseDatabase.getInstance()
    }
    // ...


    private fun submitFeedback() {
        // Check if the user is authenticated
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            // User is authenticated, proceed with feedback submission
            val feedbackRating = ratingBar.rating
            val feedbackMessage = editTextText2.text.toString()
            val uid = currentUser.uid // Get the UID of the current user


            // Create a reference to the Realtime Database node where you want to store the feedback
            val feedbackRef = database.reference.child("Feedback").child(uid)


            feedbackRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // Feedback already exists, update it
                        dataSnapshot.ref.updateChildren(
                            mapOf(
                                "rating" to feedbackRating.toDouble(),
                                "message" to feedbackMessage


                            )
                        ).addOnSuccessListener {
                            // Feedback updated successfully
                            Toast.makeText(
                                this@Feedback,
                                "Feedback updated successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        }.addOnFailureListener { e ->
                            // Handle the error if feedback update fails
                            Toast.makeText(
                                this@Feedback,
                                "Failed to update feedback",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        // Feedback doesn't exist, create a new entry
                        // Retrieve the user's first name from the "Users" table
                        val usersRef = database.reference.child("Users").child(uid)
                        usersRef.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(dataSnapshot: DataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    val firstName = dataSnapshot.child("firstName").getValue(String::class.java)


                                    // Create a feedback data model for the Realtime Database
                                    val feedbackDataRealtime = hashMapOf(
                                        "rating" to feedbackRating.toDouble(),
                                        "message" to feedbackMessage,
                                        "firstName" to firstName
                                    )


                                    feedbackRef.setValue(feedbackDataRealtime).addOnSuccessListener {
                                        // Feedback added successfully to the Realtime Database
                                        Toast.makeText(
                                            this@Feedback,
                                            "Feedback submitted successfully",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }.addOnFailureListener { e ->
                                        // Handle the error if feedback storage to the Realtime Database fails
                                        Toast.makeText(
                                            this@Feedback,
                                            "Failed to submit feedback",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                } else {
                                    // Handle the case where the user's first name is not found
                                    Toast.makeText(
                                        this@Feedback,
                                        "User's first name not found",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }


                            override fun onCancelled(databaseError: DatabaseError) {
                                // Handle any database error
                                Toast.makeText(
                                    this@Feedback,
                                    "Failed to retrieve user data",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
                    }
                }


                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle any database error
                    Toast.makeText(
                        this@Feedback,
                        "Failed to check existing feedback",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        } else {
            // User is not authenticated, show an error message or redirect to the login screen
            Toast.makeText(this, "User not authenticated. Please sign in.", Toast.LENGTH_SHORT).show()
            // Example: Redirect to the login screen
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }
}
