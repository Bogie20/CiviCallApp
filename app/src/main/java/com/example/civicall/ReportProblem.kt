package com.example.civicall

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.civicall.databinding.ActivityReportProblemBinding
import com.google.android.gms.tasks.Task
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ReportProblem : AppCompatActivity() {
    private lateinit var binding: ActivityReportProblemBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var storageReference: StorageReference
    private lateinit var databaseReference: FirebaseDatabase
    private lateinit var problemEditText: EditText
    private var imageUrl: String = ""
    private var lastReportTimestamp: Long = 0
    private val REQUEST_CAMERA_PERMISSION = 2
    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageUri: Uri? = null
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportProblemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        // Firebase initialization
        auth = FirebaseAuth.getInstance()
        storageReference = FirebaseStorage.getInstance().getReference("SettingsReport")
        databaseReference = FirebaseDatabase.getInstance()

        binding.UploadPhoto.setOnClickListener {
            checkAndRequestPermissions()
        }

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        problemEditText = findViewById(R.id.ProblemText)

        binding.sendbutton.setOnClickListener {
            if (networkUtils.isOnline) {
                // Check if a radio button is selected
                if (binding.radioGroup.checkedRadioButtonId == -1) {
                    // No radio button is selected, show a message or take appropriate action
                    Toast.makeText(this, "Please select a category", Toast.LENGTH_SHORT).show()
                } else {
                    // A radio button is selected, check if the EditText has text
                    val userMessage = problemEditText.text.toString().trim()
                    if (userMessage.isEmpty()) {
                        // EditText is empty, show a message or take appropriate action
                        Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
                    } else {
                        // Check user verification status before proceeding
                        checkUserVerificationStatus {
                            if (it) {
                                // User is verified, show confirmation dialog
                                showConfirmationDialog()
                            } else {

                                showToast("Your account needs to be verified first.")
                            }
                        }
                    }
                }
            } else {
                if (!isNoInternetDialogShowing) {
                    dismissCustomDialog()
                    showNoInternetPopup()
                }
            }
        }

        binding.RemoveButton.setOnClickListener {
            showRemovePhotoConfirmationDialog()
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this@ReportProblem, message, Toast.LENGTH_SHORT).show()
    }

    private fun checkUserVerificationStatus(callback: (Boolean) -> Unit) {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val uid = currentUser.uid
            val usersRef = databaseReference.reference.child("Users").child(uid)
            usersRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val verificationStatus = dataSnapshot.child("verificationStatus").getValue(Boolean::class.java)
                    callback(verificationStatus == true)
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle database error if necessary
                    callback(false)
                }
            })
        } else {
            // No current user, treat as not verified
            callback(false)
        }
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
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                REQUEST_CAMERA_PERMISSION
            )
        } else {
            openImagePicker()
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CAMERA_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Camera permission granted, proceed with taking a picture
                    openImagePicker()
                } else {
                    // Camera permission denied, handle accordingly
                    Toast.makeText(
                        this,
                        "Camera permission denied. Go to your Phone Setting to Allow it.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }
    private fun openImagePicker() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            selectedImageUri = data.data
            selectedImageUri?.let {
                binding.showimage.setImageURI(it)
                uploadImageToFirebase(it)
            }
        } else {
            Toast.makeText(this, "Failed to retrieve image", Toast.LENGTH_SHORT).show()
        }
    }


    private fun uploadImageToFirebase(imageUri: Uri) {
        val builder = AlertDialog.Builder(this@ReportProblem)
        builder.setCancelable(false)
        val inflater = layoutInflater
        val loadingLayout = inflater.inflate(R.layout.loading_layout, null)
        builder.setView(loadingLayout)
        val dialog = builder.create()

        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val imageName = "${System.currentTimeMillis()}" // Use timestamp as image name

                val imageRef = storageReference.child(imageName)
                imageRef.putFile(imageUri).await()
                imageUrl = imageRef.downloadUrl.await().toString() // Update imageUrl here
            } finally {
                dialog.dismiss()
            }
        }
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
        logoutMsg.text = "Are you certain you want to proceed with this Report?"

        saveBtn.text = "Yes"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()

            selectedImageUri?.let {
                uploadImageToFirebase(it)
            }
            sendDataToFirebase(imageUrl)
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

    private fun sendDataToFirebase(imageUrl: String) {
        val selectedRadioButtonId = binding.radioGroup.checkedRadioButtonId

        // Determine the category based on the selected radio button
        val category = when (selectedRadioButtonId) {
            R.id.radioTechnicalIssue -> "Technical Issue"
            R.id.radioUIIssue -> "User Interface Issue"
            R.id.radioOther -> "Other"
            else -> "Default Category"
        }

        // Get the UID and first name of the current user
        val user = auth.currentUser
        val uid = user?.uid ?: "YOUR_UID_HERE"

        // Get the message from the EditText
        val userMessage = problemEditText.text.toString().trim()

        val databaseRef = databaseReference.reference
        val userReportRef = databaseRef.child("ReportedProblems").child(uid).push() // Store under UID

        val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone("Asia/Manila")
        val formattedDate = dateFormat.format(System.currentTimeMillis())

        val problemData = mapOf(
            "imageUrl" to imageUrl,
            "message" to userMessage,
            "issue" to category, // Add issue category
            "timestamp" to formattedDate
        )

        userReportRef.setValue(problemData)
            .addOnSuccessListener {
                Toast.makeText(this@ReportProblem, "Report sent successfully", Toast.LENGTH_SHORT).show()
                clearReportForm()
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
    }



    private fun clearReportForm() {
        // Clear the image
        binding.showimage.setImageBitmap(null)

        // Clear the message EditText
        problemEditText.text.clear()

        // Clear the radio button selection
        binding.radioGroup.clearCheck()
    }

    private fun checkIfAlreadyReported(uid: String, category: String, callback: (Boolean) -> Unit) {
        // Check if the user has already reported today based on the last report timestamp
        val currentTime = System.currentTimeMillis()
        val oneDayInMillis = 24 * 60 * 60 * 1000 // One day in milliseconds

        val alreadyReported = currentTime - lastReportTimestamp < oneDayInMillis
        callback(alreadyReported)
    }

    private suspend fun <T> Task<T>.await(): T = suspendCoroutine { continuation ->
        addOnSuccessListener { result -> continuation.resume(result) }
        addOnFailureListener { e -> continuation.resumeWithException(e) }
    }

    private fun showRemovePhotoConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Remove Photo")
            .setMessage("Are you sure you want to remove the uploaded photo?")
            .setPositiveButton("Yes") { _, _ ->
                // User clicked Yes, remove the photo
                removeUploadedPhoto()
            }
            .setNegativeButton("No") { _, _ ->
                // User clicked No, do nothing
            }
            .show()
    }

    private fun removeUploadedPhoto() {
        // Clear the image view
        binding.showimage.setImageBitmap(null)

        // Reset the imageUrl
        imageUrl = ""
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Settings::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}
