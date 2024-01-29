package com.example.civicall

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class Feedback : AppCompatActivity() {
    private lateinit var backbtn: ImageView
    private lateinit var editTextText2: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var database: FirebaseDatabase
    private lateinit var editTextMultiline: TextView
    private lateinit var none: TextView
    private lateinit var thank: TextView
    private lateinit var very: TextView
    private lateinit var fix: TextView
    private lateinit var error: TextView
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        editTextMultiline = findViewById(R.id.editTextTextMultiLine)
        editTextText2 = findViewById(R.id.editTextText2)
        ratingBar = findViewById(R.id.ratingBar)
        backbtn = findViewById(R.id.backbtn)
        none = findViewById(R.id.none)
        thank = findViewById(R.id.thank)
        very = findViewById(R.id.very)
        fix = findViewById(R.id.fix)
        error = findViewById(R.id.error)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        error.setOnClickListener {
            handleCategorySelection("Great app, but I found a suggestion")
        }
        fix.setOnClickListener {
            handleCategorySelection("Awesome app, just a small improvement idea")
        }
        very.setOnClickListener {
            handleCategorySelection("The App is Very Functional")
        }
        none.setOnClickListener {
            handleCategorySelection("None so far")
        }
        thank.setOnClickListener {
            handleCategorySelection("Thank you for asking")
        }

      backbtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
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

        val submitButton: Button = findViewById(R.id.publishbtn)

        submitButton.setOnClickListener {
            if (networkUtils.isOnline) {
                showConfirmationDialog()
            } else {
                if (!isNoInternetDialogShowing) {
                    dismissCustomDialog()
                    showNoInternetPopup()
                }
            }
        }

        database = FirebaseDatabase.getInstance()
    }
    private var isNoInternetDialogShowing = false
    private fun showNoInternetPopup() {
        isNoInternetDialogShowing = true
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_network, null)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        view.findViewById<Button>(R.id.retryBtn).setOnClickListener {
            dialog.dismiss()
            isNoInternetDialogShowing = false
        }
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        dialog.setOnDismissListener {
            isNoInternetDialogShowing = false
        }
        dialog.show()
    }

    private var isSaveConfirmationDialogShowing = false

    private fun showConfirmationDialog() {
        if (isSaveConfirmationDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.dialog_confirmation, null)
        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val confirmTitle: AppCompatTextView = dialogView.findViewById(R.id.ConfirmTitle)
        val logoutMsg: AppCompatTextView = dialogView.findViewById(R.id.logoutMsg)
        val saveBtn: MaterialButton = dialogView.findViewById(R.id.saveBtn)
        val cancelBtn: MaterialButton = dialogView.findViewById(R.id.cancelBtn)


        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink


        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        confirmTitle.text = "Confirmation"
        logoutMsg.text = "Are you certain you want to send this feedback?"

        saveBtn.text = "Yes"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()
            submitFeedback()
        }
        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isSaveConfirmationDialogShowing = false
            alertDialog.dismiss()
        }
        alertDialog.setOnDismissListener {
            isSaveConfirmationDialogShowing = false
        }

        alertDialog.show()
        isSaveConfirmationDialogShowing =
            true
    }

    private fun dismissCustomDialog() {
        if (isSaveConfirmationDialogShowing) {
            isSaveConfirmationDialogShowing = false
        }
        if (isNoInternetDialogShowing) {
            isNoInternetDialogShowing = false
        }
    }

    private fun handleCategorySelection(category: String) {
        // Your existing logic for handling category selection

        // Set the selected category in the editTextText2 TextView
        editTextMultiline.text = category

    }

    private var isToastShowing = false

    private fun showToast(message: String) {
        if (!isToastShowing) {
            Toast.makeText(this@Feedback, message, Toast.LENGTH_SHORT).show()
            isToastShowing = true

            // Delay resetting the flag to allow the user to dismiss the Toast
            Handler(Looper.getMainLooper()).postDelayed({
                isToastShowing = false
            }, 2000)
        }
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
                        val lastFormattedTimestamp =
                            dataSnapshot.child("DateandTime").getValue(String::class.java)

                        if (lastFormattedTimestamp != null) {
                            val cooldownPeriod =
                                7 * 24 * 60 * 60 * 1000 // Set your cooldown period (each week)
                            val currentTime = System.currentTimeMillis()

                            // Parse the last formatted timestamp to a Date object
                            val sdf = SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault())
                            sdf.timeZone = TimeZone.getTimeZone("Asia/Manila")

                            try {
                                val lastTimestampDate = sdf.parse(lastFormattedTimestamp)

                                if (currentTime - lastTimestampDate.time < cooldownPeriod) {
                                    // User has provided feedback too soon, reject new feedback
                                    showToast(
                                        "You can provide feedback only once a week.",
                                    )
                                } else {
                                    // Proceed with feedback update
                                    dataSnapshot.ref.updateChildren(
                                        mapOf(
                                            "rating" to feedbackRating.toDouble(),
                                            "ratingEquivalent" to feedbackMessage,
                                            "comments" to commenttext,
                                            "DateandTime" to sdf.format(Date()) // Update formatted timestamp
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
                                }
                            } catch (e: ParseException) {
                                // Handle parsing exception
                                e.printStackTrace()
                                Toast.makeText(
                                    this@Feedback,
                                    "Error parsing timestamp",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            // "DateandTime" field is null, proceed with creating a new entry
                            createNewFeedbackEntry(
                                uid,
                                feedbackRating,
                                feedbackMessage,
                                commenttext
                            )
                        }
                    } else {
                        // Feedback doesn't exist, create a new entry without checking for cooldown
                        createNewFeedbackEntry(uid, feedbackRating, feedbackMessage, commenttext)
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                }
            })
        }
    }

    private fun createNewFeedbackEntry(
        uid: String,
        feedbackRating: Float,
        feedbackMessage: String,
        commenttext: String
    ) {
        // Retrieve the user's first name from the "Users" table
        val usersRef = database.reference.child("Users").child(uid)
        usersRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val firstName =
                        dataSnapshot.child("firstName").getValue(String::class.java)

                    val sdf =
                        SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault())
                    sdf.timeZone = TimeZone.getTimeZone("Asia/Manila")

                    val feedbackDataRealtime = hashMapOf(
                        "rating" to feedbackRating.toDouble(),
                        "ratingEquivalent" to feedbackMessage,
                        "firstName" to firstName,
                        "comments" to commenttext,
                        "DateandTime" to sdf.format(Date()) // Add formatted timestamp
                    )
                    database.reference.child("Feedback").child(uid)
                        .setValue(feedbackDataRealtime)
                        .addOnSuccessListener {
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

            }
        })
    }
    override fun onBackPressed() {
        super.onBackPressed()
        dismissCustomDialog()
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }
}