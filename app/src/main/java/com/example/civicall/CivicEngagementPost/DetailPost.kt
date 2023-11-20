package com.example.civicall.CivicEngagementPost

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
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
import android.Manifest
import android.widget.EditText
import com.example.civicall.R
import com.example.civicall.databinding.ActivityDetailPostBinding
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File
import java.io.IOException

class DetailPost : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPostBinding
    private lateinit var detailStartDate: TextView
    private lateinit var detailEndDate: TextView
    private lateinit var detailTitle: TextView
    private lateinit var detailFaciName: TextView
    private lateinit var detailFaciInfo: TextView
    private lateinit var detailLocation: TextView
    private lateinit var detailImage: ImageView
    private lateinit var detailTargetParty: TextView
    private lateinit var detailActivePoints: TextView
    private lateinit var detailObjective: TextView
    private lateinit var detailInstruction: TextView
    private lateinit var detailIntro: TextView
    private lateinit var detailcampus: TextView
    private lateinit var detailCategory: TextView
    private lateinit var detailPaymentMethod: TextView
    private lateinit var detailPaymentRecipient: TextView
    private lateinit var detailFundCollected: TextView
    private lateinit var detailCurrentParty: TextView
    private lateinit var deleteButton: FloatingActionButton
    private lateinit var editButton: FloatingActionButton
    private lateinit var fabMenu: FloatingActionMenu
    private var key = ""
    private var imageUrl = ""
    private var uploadersUID = ""
    private lateinit var joinButton: Button
    private val REQUEST_CAMERA_PERMISSION = 1
    private val FILE_PROVIDER_AUTHORITY = "com.example.civicall.fileprovider"
    private val REQUEST_IMAGE_CAPTURE = 2
    private var capturedImageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid
        detailStartDate = findViewById(R.id.detailStartDate)
        detailEndDate = findViewById(R.id.detailEndDate)
        detailImage = findViewById(R.id.detailImage)
        detailCategory = findViewById(R.id.detailCategory)
        detailPaymentMethod = findViewById(R.id.detailPaymentMethod)
        detailTitle = findViewById(R.id.detailTitle)
        detailTargetParty = findViewById(R.id.detailTargetParty)
        detailActivePoints = findViewById(R.id.detailActivePoints)
        detailFaciName = findViewById(R.id.detailFaciName)
        detailFaciInfo = findViewById(R.id.detailFaciInfo)
        detailObjective = findViewById(R.id.detailDesc)
        detailInstruction = findViewById(R.id.detailInstruction)
        detailPaymentRecipient = findViewById(R.id.detailPaymentRecipient)
        detailFundCollected = findViewById(R.id.detailFundCollected)
        detailIntro = findViewById(R.id.detailIntro)
        deleteButton = findViewById(R.id.deleteButton)
        editButton = findViewById(R.id.editButton)
        detailLocation = findViewById(R.id.detailLocation)
        detailcampus = findViewById(R.id.detailcampus)
        fabMenu = findViewById(R.id.fabicon)
        joinButton = findViewById(R.id.joinButton)
        detailCurrentParty = findViewById(R.id.detailCurrentParty)

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

            Toast.makeText(this@DetailPost, "Copied to clipboard", Toast.LENGTH_SHORT).show()
        }


        val copyIcon: ImageView = findViewById(R.id.copyIcon)
        val paymentRecipient: TextView = findViewById(R.id.detailPaymentRecipient)

        copyIcon.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Payment Recipient", paymentRecipient.text)
            clipboard.setPrimaryClip(clip)

            Toast.makeText(this@DetailPost, "Copied to clipboard", Toast.LENGTH_SHORT).show()
        }

        joinButton.setOnClickListener {
            if (currentUserId != null) {
                // Check if the user is verified
                val userRef = FirebaseDatabase.getInstance().getReference("Users").child(currentUserId)
                userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(userSnapshot: DataSnapshot) {
                        val userVerificationStatus =
                            userSnapshot.child("verificationStatus").getValue(Boolean::class.java) ?: false

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
                                                        // The user hasn't joined, so show the appropriate dialog
                                                        if (detailCategory.text.toString() == "Fund Raising" ||
                                                            detailCategory.text.toString() == "Donations"
                                                        ) {
                                                            // If the category is "Fund Raising" or "Donations", show the image dialog
                                                            showImageDialog()
                                                            checkAndRequestPermissions()
                                                        } else {
                                                            // Otherwise, show the join confirmation dialog
                                                            showJoinConfirmationDialog(reference, currentUserId)
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
            detailStartDate.text = it.getString("StartDate")
            detailEndDate.text = it.getString("EndDate")
            detailLocation.text = it.getString("Location")
            detailcampus.text = it.getString("Campus")
            detailPaymentMethod.text = it.getString("PaymentMethod")
            detailPaymentRecipient.text = it.getString("PaymentRecipient")
            detailFundCollected.text = it.getString("FundCollected")
            detailFaciName.text = it.getString("Facilitator")
            detailFaciInfo.text = it.getString("FacilitatorConEm")
            detailObjective.text = it.getString("Objective")
            detailInstruction.text = it.getString("Instruction")
            detailIntro.text = it.getString("Introduction")
            detailTargetParty.text = it.getString("TargetParticipants")
            detailActivePoints.text = it.getString("ActivePoints")
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
                .putExtra("StartDate", detailStartDate.text.toString())
                .putExtra("EndDate", detailEndDate.text.toString())
                .putExtra("Location", detailLocation.text.toString())
                .putExtra("Image", imageUrl)
                .putExtra("PaymentMethod", detailPaymentMethod.text.toString())
                .putExtra("PaymentRecipient", detailPaymentRecipient.text.toString())
                .putExtra("Facilitator", detailFaciName.text.toString())
                .putExtra("FacilitatorConEm", detailFaciInfo.text.toString())
                .putExtra("Campus", detailcampus.text.toString())
                .putExtra("Objective", detailObjective.text.toString())
                .putExtra("Instruction", detailInstruction.text.toString())
                .putExtra("Introduction", detailIntro.text.toString())
                .putExtra("TargetParticipants", detailTargetParty.text.toString())
                .putExtra("ActivePoints", detailActivePoints.text.toString())
                .putExtra("Key", key)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

    }
    private var isImageDialogShowing = false

    private fun showImageDialog() {
        if (isImageDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.profileedit_popup, null)
        val lytCameraPick = dialogView.findViewById<LinearLayout>(R.id.lytCameraPick)
        val lytGalleryPick = dialogView.findViewById<LinearLayout>(R.id.lytGalleryPick)
        val labelimage = dialogView.findViewById<TextView>(R.id.labelimage)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink


        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        lytCameraPick.setOnClickListener {
            takePicture()
            alertDialog.dismiss()
            isImageDialogShowing = false
        }

        lytGalleryPick.setOnClickListener {
            chooseFromGallery()
            alertDialog.dismiss()

            isImageDialogShowing = false
        }


        alertDialog.setOnDismissListener {

            isImageDialogShowing = false
        }


        alertDialog.show()
        // Set the flag to true when the dialog is displayed
        isImageDialogShowing = true
    }
    private fun takePicture() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (cameraIntent.resolveActivity(packageManager) != null) {

            val photoFile: File? = try {
                createImageFile()
            } catch (ex: IOException) {
                Log.e("UploadVerificationFile", "Error creating image file", ex)
                null
            }
            photoFile?.let {
                val photoURI: Uri = FileProvider.getUriForFile(
                    this,
                    FILE_PROVIDER_AUTHORITY,
                    it
                )
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)

                capturedImageUri = photoURI
                startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
    @Throws(IOException::class)
    private fun createImageFile(): File {
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${System.currentTimeMillis()}_",
            ".jpg",
            storageDir
        )
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            capturedImageUri?.let {

                showImagePreviewDialog(it)
            }
        }
    }
    private fun chooseFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        selectImageLauncher.launch(intent)
    }
    private val selectImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            if (data != null && data.data != null) {
                capturedImageUri = data.data
                showImagePreviewDialog(capturedImageUri!!)
            }
        }
    }
    private fun showImagePreviewDialog(imageUri: Uri) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_contribution, null)
        val dialogIconFlat: ImageView = dialogView.findViewById(R.id.reflect_image)
        val closeButton: ImageView = dialogView.findViewById(R.id.closeIcon)
        val saveButton: Button = dialogView.findViewById(R.id.saveBtn)
        val repickButton: Button = dialogView.findViewById(R.id.cancelBtn)
        val amountEditText: TextInputEditText = dialogView.findViewById(R.id.amount)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogIconFlat.setImageURI(imageUri)

        closeButton.setOnClickListener {
            alertDialog.dismiss()
        }
        saveButton.setOnClickListener {
            val amountText = amountEditText.text.toString().trim()
            if (amountText.isNotEmpty()) {
                alertDialog.dismiss()
                uploadImageToFirebase(capturedImageUri!!, amountText)
            } else {
                Toast.makeText(this, "Please input the amount", Toast.LENGTH_SHORT).show()
            }
        }


        repickButton.setOnClickListener {
            // Dismiss the current dialog
            alertDialog.dismiss()

            // Reopen the image dialog
            showImageDialog()
        }

        alertDialog.show()
    }
    private fun uploadImageToFirebase(imageUri: Uri, amount: String) {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference
        val timestamp = System.currentTimeMillis().toString()

        val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid
        if (currentUserUid == null) {
            // Handle the case where the current user UID is null
            return
        }

        val fileRef = storageRef.child("TransparencyProofImage/$currentUserUid/${timestamp}_image_amount.jpg")

        fileRef.putFile(imageUri)
            .addOnSuccessListener { uploadTask ->
                fileRef.downloadUrl.addOnSuccessListener { downloadUri ->
                    // Image uploaded successfully
                    val database = FirebaseDatabase.getInstance()
                    val engagementsRef = database.getReference("Upload Engagement")
                    val currentUser = engagementsRef.child(key) // Assuming "key" is the current engagement key
                    val transparencyImageRef = currentUser.child("TransparencyImage").child(currentUserUid).child("Proof")

                    val imageData = HashMap<String, Any>()
                    imageData["imageUri"] = downloadUri.toString()
                    imageData["amount"] = amount
                    imageData["timestamp"] = timestamp

                    transparencyImageRef.setValue(imageData)

                    showAlreadyJoin(
                        "Image Uploaded Successfully",
                        3000,
                        "Success",
                        R.drawable.papermani
                    )
                }
            }
            .addOnFailureListener { exception ->
                // Handle unsuccessful uploads
                Toast.makeText(this, "Image upload failed: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }


    private fun checkAndRequestPermissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CAMERA_PERMISSION
            )
        }
    }
    private var isAlreadyJoinDialogShowing = false

    private fun showAlreadyJoin(message: String, durationMillis: Long, customSlideTitle: String?, customDialogImageResId: Int?) {
        if (isAlreadyJoinDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.dialog_happyface, null)
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
            showJoinPopupSuccess()
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
    private var isJoinSuccessDialogShowing = false

    private fun showJoinPopupSuccess() {
        // Check if the pop-up is already showing, and if so, return early
        if (isJoinSuccessDialogShowing) {
            return
        }

        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_success, null)

        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()

        // Set the animation style
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val dialogIconFlat: AppCompatImageView = dialogView.findViewById(R.id.dialog_icon_flat)
        val messageTextView = dialogView.findViewById<TextView>(R.id.dialog_message_flat)
        val okButton = dialogView.findViewById<Button>(R.id.btn_action_flat)

        messageTextView.text = "Looking forward to seeing you there, dedicated volunteer!"

        okButton.setOnClickListener {
            alertDialog.dismiss()
            isJoinSuccessDialogShowing = false // Set the variable to false when the pop-up is dismissed
        }
        dialogIconFlat.setImageResource(R.drawable.handshake)
        dismissCustomDialog()

        alertDialog.show()
        isJoinSuccessDialogShowing = true // Set the variable to true when the pop-up is displayed
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

            val parentLinearLayout = findViewById<LinearLayout>(R.id.paymentDetailsLayout)

            if (detailCategory.text.toString() == "Fund Raising" || detailCategory.text.toString() == "Donations") {
                parentLinearLayout.visibility = View.VISIBLE
            } else {
                parentLinearLayout.visibility = View.GONE
            }
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
        val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Upload Engagement").child(key)

// Add this block to dynamically update joinButton text based on category changes
        reference.child("category").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val category = dataSnapshot.getValue(String::class.java)

                if (category == "Fund Raising" || category == "Donations") {
                    joinButton.text = "Contribute?"
                } else {
                    joinButton.text = "Join Now"
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
        if (isJoinSuccessDialogShowing) {

            isJoinSuccessDialogShowing = false
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
            reference.child(key).removeValue()

            Toast.makeText(this@DetailPost, "Deleted", Toast.LENGTH_SHORT).show()
            finish() // Finish the current activity and go back to the previous one
        })
    }
}
