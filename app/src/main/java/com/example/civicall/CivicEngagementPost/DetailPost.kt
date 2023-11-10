package com.example.civicall.CivicEngagementPost

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class DetailPost : AppCompatActivity() {

    private lateinit var detailDateandTime: TextView
    private lateinit var detailTitle: TextView
    private lateinit var detailFaciName: TextView
    private lateinit var detailFaciInfo: TextView
    private lateinit var detailLocation: TextView
    private lateinit var detailImage: ImageView
    private lateinit var detailTargetParty: TextView
    private lateinit var detailObjective: TextView
    private lateinit var detailInstruction: TextView
    private lateinit var detailIntro: TextView
    private lateinit var detailcampus: TextView
    private lateinit var detailCategory: TextView
    private lateinit var detailCurrentParty: TextView
    private lateinit var deleteButton: FloatingActionButton
    private lateinit var editButton: FloatingActionButton
    private lateinit var fabMenu: FloatingActionMenu
    private var key = ""
    private var imageUrl = ""
    private var uploadersUID = ""
    private lateinit var joinButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_post)
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid
        detailDateandTime = findViewById(R.id.detailDateandTime)
        detailImage = findViewById(R.id.detailImage)
        detailCategory = findViewById(R.id.detailCategory)
        detailTitle = findViewById(R.id.detailTitle)
        detailTargetParty = findViewById(R.id.detailTargetParty)
        detailFaciName = findViewById(R.id.detailFaciName)
        detailFaciInfo = findViewById(R.id.detailFaciInfo)
        detailObjective = findViewById(R.id.detailDesc)
        detailInstruction = findViewById(R.id.detailInstruction)
        detailIntro = findViewById(R.id.detailIntro)
        deleteButton = findViewById(R.id.deleteButton)
        editButton = findViewById(R.id.editButton)
        detailLocation = findViewById(R.id.detailLocation)
        detailcampus = findViewById(R.id.detailcampus)
        fabMenu = findViewById(R.id.fabicon)

        joinButton = findViewById(R.id.joinButton)
        detailCurrentParty = findViewById(R.id.detailCurrentParty)


        joinButton.setOnClickListener {
            if (currentUserId != null) {
                // Check if the user is verified
                val userRef = FirebaseDatabase.getInstance().getReference("Users").child(currentUserId)
                userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(userSnapshot: DataSnapshot) {
                        val userVerificationStatus = userSnapshot.child("verificationStatus").getValue(Boolean::class.java) ?: false

                        if (userVerificationStatus) {
                            // The user is verified, proceed with checking post verification status
                            val reference: DatabaseReference =
                                FirebaseDatabase.getInstance().getReference("Upload Engagement").child(key)

                            // Check if the post is under verification
                            reference.addListenerForSingleValueEvent(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    val verificationStatus =
                                        dataSnapshot.child("verificationStatus").getValue(Boolean::class.java) ?: false

                                    if (verificationStatus) {
                                        // ... rest of the logic for joining or canceling
                                        reference.child("Participants")
                                            .addListenerForSingleValueEvent(object : ValueEventListener {
                                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                                    if (dataSnapshot.hasChild(currentUserId)) {
                                                        // The user has already joined, so ask if they want to cancel
                                                        showCancelConfirmationDialog(reference, currentUserId)
                                                    } else {
                                                        // The user hasn't joined, so ask if they want to join
                                                        showJoinConfirmationDialog(reference, currentUserId)
                                                    }
                                                }

                                                override fun onCancelled(databaseError: DatabaseError) {
                                                    Toast.makeText(
                                                        this@DetailPost,
                                                        "Database error: " + databaseError.message,
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                }
                                            })
                                    } else {
                                        // The post is not verified, show a toast message
                                        Toast.makeText(
                                            this@DetailPost,
                                            "Hold on! This post is currently under verification. Please wait until it's approved by the admin.",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    Toast.makeText(
                                        this@DetailPost,
                                        "Database error: " + databaseError.message,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                        } else {
                            // The user is not verified, show a toast message
                            Toast.makeText(
                                this@DetailPost,
                                "Oops! Your account is not verified. Please verify your account before joining.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        Toast.makeText(
                            this@DetailPost,
                            "Database error: " + databaseError.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
            }
        }

        val bundle = intent.extras
        bundle?.let {
            detailCategory.text = it.getString("Category")
            detailTitle.text = it.getString("Title")
            detailDateandTime.text = it.getString("Date&Time")
            detailLocation.text = it.getString("Location")
            detailcampus.text = it.getString("Campus")
            detailFaciName.text = it.getString("Facilitator")
            detailFaciInfo.text = it.getString("FacilitatorConEm")
            detailObjective.text = it.getString("Objective")
            detailInstruction.text = it.getString("Instruction")
            detailIntro.text = it.getString("Introduction")
            detailTargetParty.text = it.getString("TargetParticipants")
            key = it.getString("Key") ?: ""
            imageUrl = it.getString("Image") ?: ""
            Glide.with(this).load(it.getString("Image")).into(detailImage)
        }

        val databaseReference: DatabaseReference =
            FirebaseDatabase.getInstance().getReference("Upload Engagement")

        databaseReference.child(key).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    uploadersUID = dataSnapshot.child("uploadersUID").value.toString()

                    // Check if the current user is the uploader of the post
                    if (currentUserId != null && currentUserId == uploadersUID) {
                        fabMenu.visibility = View.VISIBLE
                    } else {
                        fabMenu.visibility = View.GONE
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(
                    this@DetailPost,
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
                    this@DetailPost,
                    "Database error: " + databaseError.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })


        deleteButton.setOnClickListener {

            showDeleteConfirmationDialog()
        }

        editButton.setOnClickListener {
            val intent = Intent(this@DetailPost, Update_engagement::class.java)
                .putExtra("Category", detailCategory.text.toString())
                .putExtra("Title", detailTitle.text.toString())
                .putExtra("Date&Time", detailDateandTime.text.toString())
                .putExtra("Location", detailLocation.text.toString())
                .putExtra("Image", imageUrl)
                .putExtra("Facilitator", detailFaciName.text.toString())
                .putExtra("FacilitatorConEm", detailFaciInfo.text.toString())
                .putExtra("Campus", detailcampus.text.toString())
                .putExtra("Objective", detailObjective.text.toString())
                .putExtra("Instruction", detailInstruction.text.toString())
                .putExtra("Introduction", detailIntro.text.toString())
                .putExtra("TargetParticipants", detailTargetParty.text.toString())
                .putExtra("Key", key)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

    }

    private var isJoinConfirmationDialogShowing = false

    private fun showJoinConfirmationDialog(reference: DatabaseReference, currentUserId: String) {
        if (isJoinConfirmationDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.dialog_engagement, null)
        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val confirmTitle: AppCompatTextView = dialogView.findViewById(R.id.ConfirmTitle)
        val logoutMsg: AppCompatTextView = dialogView.findViewById(R.id.logoutMsg)
        val joinBtn: MaterialButton = dialogView.findViewById(R.id.saveBtn)
        val cancelBtn: MaterialButton = dialogView.findViewById(R.id.cancelBtn)
        val dialogIconFlat: AppCompatImageView = dialogView.findViewById(R.id.dialog_icon_flat)

        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        confirmTitle.text = "Join Confirmation"
        logoutMsg.text = "By confirming, you are expressing your commitment to join this engagement. Are you sure you want to proceed?"


        joinBtn.text = "Join"
        joinBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()
            // Add the user's UID to the "Participants" node
            reference.child("Participants").child(currentUserId).setValue(true)

            // Update the button text to "Cancel"
            joinButton.text = "Cancel"

            // Call joinPost() here to update the TotalEngagement count
            joinPost()
        }

        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isJoinConfirmationDialogShowing = false
            alertDialog.dismiss()
        }

        dialogIconFlat.setImageResource(R.drawable.needhelp) // Set the join icon here

        alertDialog.setOnDismissListener {
            isJoinConfirmationDialogShowing = false
        }

        alertDialog.show()
        isJoinConfirmationDialogShowing = true
    }

    private var isCancelConfirmationDialogShowing = false

    private fun showCancelConfirmationDialog(reference: DatabaseReference, currentUserId: String) {
        if (isCancelConfirmationDialogShowing) {
            return
        }

        dismissCustomDialog()

        val dialogView = layoutInflater.inflate(R.layout.dialog_engagement, null)
        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val confirmTitle: AppCompatTextView = dialogView.findViewById(R.id.ConfirmTitle)
        val volunteerMsg: AppCompatTextView = dialogView.findViewById(R.id.logoutMsg)
        val cancelBtn: MaterialButton = dialogView.findViewById(R.id.cancelBtn)
        val joinBtn: MaterialButton = dialogView.findViewById(R.id.saveBtn)
        val dialogIconFlat: AppCompatImageView = dialogView.findViewById(R.id.dialog_icon_flat)

        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        confirmTitle.text = "Cancel Confirmation"
        volunteerMsg.text = "Your participation is valuable to us. Are you sure you want to cancel your engagement?"

        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isCancelConfirmationDialogShowing = false
            alertDialog.dismiss()
        }

        joinBtn.text = "Confirm"
        joinBtn.setOnClickListener {
            isCancelConfirmationDialogShowing = false
            alertDialog.dismiss()

            // Remove the user's UID from the "Participants" node
            reference.child("Participants").child(currentUserId).removeValue()

            // Update the button text to "Join Now"
            joinButton.text = "Join Now"

            cancelPost()
        }

        dialogIconFlat.setImageResource(R.drawable.weneedyou) // Set the cancel icon here

        alertDialog.setOnDismissListener {
            isCancelConfirmationDialogShowing = false
        }

        alertDialog.show()
        isCancelConfirmationDialogShowing = true
    }

    val currentUser = FirebaseAuth.getInstance().currentUser
    val currentUserId = currentUser?.uid
    override fun onResume() {
        super.onResume()

        if (currentUserId != null) {
            val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Upload Engagement").child(key)

            reference.child("Participants").addListenerForSingleValueEvent(object : ValueEventListener {
                @SuppressLint("SetTextI18n")
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.hasChild(currentUserId)) {
                        joinButton.text = "Cancel"
                    } else {
                        joinButton.text = "Join Now"
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Toast.makeText(this@DetailPost, "Database error: " + databaseError.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
        val participantsReference: DatabaseReference =
            FirebaseDatabase.getInstance().getReference("Upload Engagement").child(key).child("Participants")

        participantsReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val participantCount = dataSnapshot.childrenCount.toInt()
                detailCurrentParty.text = "$participantCount"
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("DetailPost", "Database error: " + databaseError.message)
                Toast.makeText(this@DetailPost, "Database error: " + databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun joinPost() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid

        if (currentUserId != null) {
            val userRef = FirebaseDatabase.getInstance().getReference("Users").child(currentUserId)
            userRef.child("CurrentEngagement").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var totalEngagementCount = dataSnapshot.getValue(Int::class.java) ?: 0

                    totalEngagementCount++

                    // Update the TotalEngagement count in the Users node
                    userRef.child("CurrentEngagement").setValue(totalEngagementCount)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    val errorMessage = "Database error: ${databaseError.message}"

                    Log.e("DetailPost", errorMessage)

                    Toast.makeText(this@DetailPost, errorMessage, Toast.LENGTH_SHORT).show()

                }
            })
        }
    }
    private fun cancelPost() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid

        if (currentUserId != null) {
            val userRef = FirebaseDatabase.getInstance().getReference("Users").child(currentUserId)
            userRef.child("CurrentEngagement").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var totalEngagementCount = dataSnapshot.getValue(Int::class.java) ?: 0

                    // Decrement the TotalEngagement count in the Users node
                    if (totalEngagementCount > 0) {
                        totalEngagementCount--
                    }

                    userRef.child("CurrentEngagement").setValue(totalEngagementCount)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    val errorMessage = "Database error: ${databaseError.message}"

                    Log.e("DetailPost", errorMessage)

                    Toast.makeText(this@DetailPost, errorMessage, Toast.LENGTH_SHORT).show()
                }
            })
        }
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
        alertDialog.setOnDismissListener{
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
        if (isJoinConfirmationDialogShowing) {

            isJoinConfirmationDialogShowing = false
        }
    }
    private fun deletePost() {
        val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Upload Engagement")
        val storage: FirebaseStorage = FirebaseStorage.getInstance()

        val storageReference: StorageReference = storage.getReferenceFromUrl(imageUrl)
        storageReference.delete().addOnSuccessListener(OnSuccessListener {
            // Get the current user
            val currentUser = FirebaseAuth.getInstance().currentUser
            val currentUserId = currentUser?.uid

            if (currentUserId != null) {
                val userRef = FirebaseDatabase.getInstance().getReference("Users").child(currentUserId)
                val participantsReference: DatabaseReference = reference.child(key).child("Participants")

                participantsReference.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        // Check if the current user has joined the post
                        if (dataSnapshot.hasChild(currentUserId)) {
                            // If joined, decrement the TotalEngagement count in the Users node
                            userRef.child("CurrentEngagement").addListenerForSingleValueEvent(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    var totalEngagementCount = dataSnapshot.getValue(Int::class.java) ?: 0

                                    // Decrement the TotalEngagement count in the Users node
                                    if (totalEngagementCount > 0) {
                                        totalEngagementCount--
                                    }

                                    userRef.child("CurrentEngagement").setValue(totalEngagementCount)
                                }

                                override fun onCancelled(databaseError: DatabaseError) {
                                    val errorMessage = "Database error: ${databaseError.message}"

                                    Log.e("DetailPost", errorMessage)

                                    Toast.makeText(this@DetailPost, errorMessage, Toast.LENGTH_SHORT).show()
                                }
                            })
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        val errorMessage = "Database error: ${databaseError.message}"

                        Log.e("DetailPost", errorMessage)

                        Toast.makeText(this@DetailPost, errorMessage, Toast.LENGTH_SHORT).show()
                    }
                })
            }

            // Remove the post from the database
            reference.child(key).removeValue()

            Toast.makeText(this@DetailPost, "Deleted", Toast.LENGTH_SHORT).show()
            finish() // Finish the current activity and go back to the previous one
        })
    }
}
