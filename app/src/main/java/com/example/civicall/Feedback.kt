package com.example.civicall

import PopupFragment
import android.content.Intent
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
    private lateinit var editTextMultiline: TextView
    private lateinit var none: TextView
    private lateinit var thank: TextView
    private lateinit var very: TextView
    private lateinit var fix: TextView
    private lateinit var error: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        BackClick = findViewById(R.id.profileburger)
        editTextMultiline = findViewById(R.id.editTextTextMultiLine)
        editTextText2 = findViewById(R.id.editTextText2)
        ratingBar = findViewById(R.id.ratingBar)
       none = findViewById(R.id.none)
        thank = findViewById(R.id.thank)
        very = findViewById(R.id.very)
        fix = findViewById(R.id.fix)
        error = findViewById(R.id.error)
        error.setOnClickListener {
            handleCategorySelection("Fix Error")
        }
        fix.setOnClickListener {
            handleCategorySelection("Fix bug")
        }
        very.setOnClickListener {
            handleCategorySelection("The App is Very Functional")
        }
        none.setOnClickListener {
            handleCategorySelection("none")
        }
        thank.setOnClickListener {
            handleCategorySelection("Thank you for asking")
        }

        ratingBar.setOnRatingBarChangeListener { _, rating: Float, _ ->
            when (rating.toInt()) {
                0 -> editTextText2.setText(R.string.very_dissatisfied)
                1 -> editTextText2.setText(R.string.dissatisfied)
                2, 3 -> editTextText2.setText(R.string.ok)
                4 -> editTextText2.setText(R.string.satisfied)
                5 -> editTextText2.setText(R.string.very_satisfied)
                else -> editTextText2.text = ""
            }
        }

        BackClick.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val popupButton: Button = findViewById(R.id.publishbtn)
        popupButton.setOnClickListener {
            // Show the popup when the button is clicked
            val popupFragment = PopupFragment()
            popupFragment.show(supportFragmentManager, "popup")
        }

        val submitButton: Button = findViewById(R.id.publishbtn)
        submitButton.setOnClickListener {
            // Handle the feedback submission here
            submitFeedback()
        }

        // Initialize the Realtime Database instance
        database = FirebaseDatabase.getInstance()
    }

    private fun handleCategorySelection(category: String) {
        // Your existing logic for handling category selection

        // Set the selected category in the editTextText2 TextView
        editTextMultiline.text = category

    }

    private fun submitFeedback() {
        // Check if the user is authenticated
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            val commenttext = editTextMultiline.text.toString()
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
                                "message" to feedbackMessage,
                                "Comments" to commenttext
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
                                        "firstName" to firstName,
                                        "comments" to commenttext
                                    )
                                    feedbackRef.setValue(feedbackDataRealtime).addOnSuccessListener {
                                        // Feedback added successfully to the Realtime Database
                                        Toast.makeText(
                                            this@Feedback,
                                            "Feedback submitted successfully",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }.addOnFailureListener { e ->
                                        // Handle the error if feedback submission fails
                                        Toast.makeText(
                                            this@Feedback,
                                            "Failed to submit feedback",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }

                            override fun onCancelled(databaseError: DatabaseError) {
                                // Handle the error if the database operation is cancelled
                                Toast.makeText(
                                    this@Feedback,
                                    "Database operation cancelled",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle the error if the database operation is cancelled
                    Toast.makeText(
                        this@Feedback,
                        "Database operation cancelled",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
    }
}
