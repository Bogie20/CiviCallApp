package com.example.civicall.Forum

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ParseException
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityForumCommentBinding
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class ForumComment : AppCompatActivity() {
    private lateinit var binding: ActivityForumCommentBinding
    private lateinit var detailTitle: TextView
    private lateinit var detailImage: ImageView
    private lateinit var detailcampus: TextView
    private lateinit var detailCategory: TextView
    private lateinit var deleteButton: FloatingActionButton
    private lateinit var editButton: FloatingActionButton
    private lateinit var fabMenu: FloatingActionMenu
    private var key = ""
    private var imageUrl = ""
    private var uploadersUID = ""
    private lateinit var joinButton: Button
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForumCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid
        detailImage = findViewById(R.id.detailImage)
        detailCategory = findViewById(R.id.detailCategory)
        detailTitle = findViewById(R.id.detailTitle)
        deleteButton = findViewById(R.id.deleteButton)
        editButton = findViewById(R.id.editButton)
        detailcampus = findViewById(R.id.detailcampus)
        fabMenu = findViewById(R.id.fabicon)
        joinButton = findViewById(R.id.joinButton)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        binding.backbtn.setOnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        val copyInq: ImageView = findViewById(R.id.copyinq)
        val facilitatorInfo: TextView = findViewById(R.id.detailFaciInfo)

        copyInq.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Facilitator Information", facilitatorInfo.text)
            clipboard.setPrimaryClip(clip)

            Toast.makeText(this@ForumComment, "Copied to clipboard", Toast.LENGTH_SHORT).show()
        }


        val copyIcon: ImageView = findViewById(R.id.copyIcon)
        val paymentRecipient: TextView = findViewById(R.id.detailPaymentRecipient)

        copyIcon.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Payment Recipient", paymentRecipient.text)
            clipboard.setPrimaryClip(clip)

            Toast.makeText(this@ForumComment, "Copied to clipboard", Toast.LENGTH_SHORT).show()
        }

        val bundle = intent.extras
        bundle?.let {
            detailCategory.text = it.getString("Category")
            detailTitle.text = it.getString("PostText")
            detailcampus.text = it.getString("Campus")
            key = it.getString("Key") ?: ""
            imageUrl = it.getString("PostImage") ?: ""
            Glide.with(this).load(it.getString("PostImage")).into(detailImage)
        }

        val databaseReference: DatabaseReference =
            FirebaseDatabase.getInstance().getReference("Forum Post")

        databaseReference.child(key).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    uploadersUID = dataSnapshot.child("uploadersUID").value.toString()

                    if (currentUserId != null && currentUserId == uploadersUID) {
                        fabMenu.visibility = View.VISIBLE
                    } else {
                        fabMenu.visibility = View.GONE
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(
                    this@ForumComment,
                    "Database error: " + databaseError.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        databaseReference.child(key).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    uploadersUID = dataSnapshot.child("uploadersUID").value.toString()
                    val verificationStatus =
                        dataSnapshot.child("verificationStatus").getValue(Boolean::class.java)
                            ?: false

                    // Check if the current user is the uploader of the post and verificationStatus is false
                    if (currentUserId != null && currentUserId == uploadersUID && !verificationStatus) {
                        fabMenu.visibility = View.VISIBLE
                    } else {
                        fabMenu.visibility = View.GONE
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(
                    this@ForumComment,
                    "Database error: " + databaseError.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })


        deleteButton.setOnClickListener {

            showDeleteConfirmationDialog()
        }

        editButton.setOnClickListener {
            val intent = Intent(this@ForumComment, ForumUpdate::class.java)
                .putExtra("Category", detailCategory.text.toString())
                .putExtra("PostText", detailTitle.text.toString())
                .putExtra("PostImage", imageUrl)
                .putExtra("Campus", detailcampus.text.toString())
                .putExtra("Key", key)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
    }

    private fun showDatabaseErrorMessage(databaseError: DatabaseError) {
        Toast.makeText(
            this@ForumComment,
            "Database error: " + databaseError.message,
            Toast.LENGTH_SHORT
        ).show()
    }


    private var isAlreadyJoinDialogShowing = false

    private fun showMessage(
        message: String,
        durationMillis: Long,
        customSlideTitle: String?,
        customDialogImageResId: Int?,
        customDialogLayoutResId: Int?
    ) {
        if (isAlreadyJoinDialogShowing) {
            return
        }
        dismissCustomDialog()

        // Use the custom layout resource ID if provided, otherwise use the default
        val dialogView =
            layoutInflater.inflate(customDialogLayoutResId ?: R.layout.dialog_happyface, null)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val slideTitle: AppCompatTextView = dialogView.findViewById(R.id.dialog_title_emotion)
        val dialogImage: AppCompatImageView = dialogView.findViewById(R.id.img_icon_emotion)
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationSlideLeft
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Use custom slideTitle if provided, otherwise use the default
        slideTitle.text = customSlideTitle ?: "Verifying Account"

        val messageTextView = dialogView.findViewById<TextView>(R.id.dialog_message)
        messageTextView.text = message
        alertDialog.show()

        // Use custom dialogImage if provided, otherwise use the default
        dialogImage.setImageResource(customDialogImageResId ?: R.drawable.papermani)

        isAlreadyJoinDialogShowing = true
        alertDialog.setOnDismissListener {
            isAlreadyJoinDialogShowing = false
        }
        Handler(Looper.getMainLooper()).postDelayed({
            alertDialog.dismiss()
            isAlreadyJoinDialogShowing = false
        }, durationMillis)
    }


    private var isSaveConfirmationDialogShowing = false // Add this variable

    private fun showDeleteConfirmationDialog() {
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
        logoutMsg.text = "Are you sure you want to delete this post?"

        saveBtn.text = "Delete"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()

            deletePost()
        }
        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isSaveConfirmationDialogShowing = false // Reset the flag
            alertDialog.dismiss()
            // User clicked "Cancel," do nothing or provide feedback
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
    }

    private fun deletePost() {
        val reference: DatabaseReference =
            FirebaseDatabase.getInstance().getReference("Forum Post")

        // Get the current user
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid

        if (currentUserId != null) {
            // Retrieve the engagement node
            val engagementReference: DatabaseReference = reference.child(key)

            // Retrieve the participants node
            val participantsReference: DatabaseReference = engagementReference.child("Participants")

            // Check if the current user has joined the post
            participantsReference.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.hasChild(currentUserId)) {
                        // If joined, decrement the CurrentEngagement count in the Users node
                        val userRef = FirebaseDatabase.getInstance().getReference("Users")
                            .child(currentUserId)

                        userRef.child("CurrentEngagement")
                            .addListenerForSingleValueEvent(object : ValueEventListener {
                                override fun onDataChange(userEngagementSnapshot: DataSnapshot) {
                                    val currentEngagementCount =
                                        userEngagementSnapshot.getValue(Int::class.java) ?: 0

                                    // Ensure the count is greater than 0 before decrementing
                                    if (currentEngagementCount > 0) {
                                        // Decrement the CurrentEngagement count in the Users node
                                        userRef.child("CurrentEngagement")
                                            .setValue(currentEngagementCount - 1)
                                    }
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    handleDatabaseError(databaseError)
                                }
                            })
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    handleDatabaseError(databaseError)
                }
            })
        }

        reference.child(key).removeValue()
            .addOnSuccessListener {
                Toast.makeText(this@ForumComment, "Deleted", Toast.LENGTH_SHORT).show()
                finish() // Finish the current activity and go back to the previous one
            }
            .addOnFailureListener { exception ->
                // Handle unsuccessful deletion from Firebase
                Toast.makeText(
                    this@ForumComment,
                    "Deletion failed: ${exception.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun handleDatabaseError(databaseError: DatabaseError) {
        val errorMessage = "Database error: ${databaseError.message}"

        Log.e("DetailPost", errorMessage)

        Toast.makeText(this@ForumComment, errorMessage, Toast.LENGTH_SHORT).show()
    }
}