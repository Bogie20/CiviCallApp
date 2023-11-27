package com.example.civicall.Forum

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityForumUploadBinding
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class ForumUpload : AppCompatActivity() {

    private lateinit var uploadPostImage: ImageView
    private lateinit var saveButton: Button
    private lateinit var uploadPostText: EditText
    private lateinit var uploadCategory: AutoCompleteTextView
    private var imageURL: String? = null
    private var uri: Uri? = null
    private lateinit var binding: ActivityForumUploadBinding
    private lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForumUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uploadPostImage = binding.uploadPostImage
        uploadCategory = binding.uploadCategory
        uploadPostText = binding.uploadPostText
        saveButton = binding.uploadButton
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        binding.backbtn.setOnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val campusDropdown = binding.uploadCampus
        val campusArray = resources.getStringArray(R.array.allowed_campuses)
        val adaptercampus = ArrayAdapter(this, R.layout.dropdown_item, campusArray)
        (campusDropdown as? AutoCompleteTextView)?.setAdapter(adaptercampus)

        val categoryDropdown = binding.uploadCategory
        val categoryArray = resources.getStringArray(R.array.engagement_category)
        val adaptercategory = ArrayAdapter(this, R.layout.dropdown_item, categoryArray)
        (categoryDropdown as? AutoCompleteTextView)?.setAdapter(adaptercategory)

        val activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                uri = data?.data
                uploadPostImage.setImageURI(uri)
            } else {
                Toast.makeText(this@ForumUpload, "No Image Selected", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        uploadPostImage.setOnClickListener {
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }

        saveButton.setOnClickListener {
            val auth = FirebaseAuth.getInstance()
            val currentUser = auth.currentUser
            if (currentUser != null) {
                val uid = currentUser.uid

                // Now you can use the uid in your Firebase Database reference
                val currentUserRef = FirebaseDatabase.getInstance().getReference("Users").child(uid)

                currentUserRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val verificationStatus =
                            snapshot.child("verificationStatus").getValue(Boolean::class.java)

                        if (verificationStatus == false) {
                            showMessage(
                                "Please verify your account before uploading",
                                4000,
                                "Oops!",
                                R.drawable.notverifiedshield,
                                R.layout.dialog_sadface
                            )
                        } else {
                            showConfirmationDialog()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle the error as needed
                    }
                })
            } else {
                // Handle the case where the user is not signed in
                // You might want to redirect the user to the login screen or perform some other action
            }
        }
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
        logoutMsg.text = "Are you certain you want to proceed with this upload?"

        saveBtn.text = "Yes"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()
            saveData()
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
    }

    private fun saveData() {
        if (uploadPostText.text.isNullOrBlank() ||
            binding.uploadCampus.text.isNullOrBlank() ||
            binding.uploadCategory.text.isNullOrBlank() ||
            uri == null
        ) {
            Toast.makeText(
                this@ForumUpload,
                "Please fill in all the required information",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val storageReference = FirebaseStorage.getInstance().getReference()
            .child("Forum Post Images").child(uri?.lastPathSegment!!)

        val builder = AlertDialog.Builder(this@ForumUpload)
        builder.setCancelable(false)
        val inflater = layoutInflater
        val loadingLayout = inflater.inflate(R.layout.loading_layout, null)
        builder.setView(loadingLayout)
        val dialog = builder.create()

        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()

        storageReference.putFile(uri!!)
            .addOnSuccessListener { taskSnapshot ->
                val uriTask = taskSnapshot.storage.downloadUrl
                while (!uriTask.isComplete);
                val urlImage = uriTask.result
                imageURL = urlImage.toString()

                uploadData()
            }
            .addOnFailureListener { e ->
                dialog.dismiss()
                Toast.makeText(
                    this@ForumUpload,
                    "Failed to upload image: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun uploadData() {
        val postText = uploadPostText.text.toString()
        val campus = binding.uploadCampus.text.toString()
        val category = binding.uploadCategory.text.toString()
        val verificationStatus = false

        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid

        if (uploadersId != null) {
            val postKey =
                FirebaseDatabase.getInstance().getReference("Forum Post").push().key

            if (postKey != null) {
                val dataClass = DataClassForum(
                    uploadersId,
                    category,
                    postText,
                    imageURL!!,
                    campus,
                    verificationStatus
                )

                FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
                    .setValue(dataClass)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this@ForumUpload, "Success", Toast.LENGTH_SHORT)
                                .show()
                            finish()
                        }
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(
                            this@ForumUpload,
                            e.message.toString(),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
}