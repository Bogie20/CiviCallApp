package com.example.civicall

import android.app.Activity
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivityOtherproblemBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ServerValue
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class Otherproblem : AppCompatActivity() {
    private lateinit var binding: ActivityOtherproblemBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var storageReference: StorageReference
    private lateinit var databaseReference: FirebaseDatabase
    private lateinit var problemEditText: EditText
    private var imageUrl: String = ""
    private var lastReportTimestamp: Long = 0

    private val PICK_IMAGE_REQUEST = 1
    private val desiredCardViewWidth = 300 // Adjust as needed
    private val desiredCardViewHeight = 200 // Adjust as needed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherproblemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Firebase initialization
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        FirebaseStorage.getInstance().reference
        storageReference = FirebaseStorage.getInstance().getReference("SettingsReport")
        databaseReference = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        binding.UploadPhoto.setOnClickListener {
            openImagePicker()
        }

        binding.profileburger.setOnClickListener {
            onBackPressed()
        }

        problemEditText = findViewById(R.id.ProblemText)

        binding.sendbutton.setOnClickListener {
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
                    // Both radio button and EditText have valid input, show a confirmation dialog before sending the report
                    showSendConfirmationDialog()
                }
            }
        }

        binding.RemoveButton.setOnClickListener {
            showRemovePhotoConfirmationDialog()
        }
    }

    private fun openImagePicker() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri = data.data
            // Resize the selected image and set it to the ImageView in the CardView
            resizeAndSetImage(selectedImageUri)
        }
    }

    private fun resizeAndSetImage(selectedImageUri: Uri?) {
        selectedImageUri?.let {
            try {
                val inputStream = contentResolver.openInputStream(selectedImageUri)
                val options = BitmapFactory.Options()
                options.inJustDecodeBounds = true
                BitmapFactory.decodeStream(inputStream, null, options)
                inputStream?.close()

                val imageWidth = options.outWidth
                val imageHeight = options.outHeight

                val widthRatio = desiredCardViewWidth.toFloat() / imageWidth
                val heightRatio = desiredCardViewHeight.toFloat() / imageHeight

                // Use the maximum ratio to ensure the entire CardView is covered by the image
                val scaleFactor = if (widthRatio > heightRatio) widthRatio else heightRatio

                val scaledBitmap = BitmapFactory.Options().run {
                    inSampleSize = scaleFactor.toInt()
                    inJustDecodeBounds = false
                    contentResolver.openInputStream(selectedImageUri)?.use { stream ->
                        BitmapFactory.decodeStream(stream, null, this)
                    }
                }

                binding.showimage.scaleType = ImageView.ScaleType.CENTER_CROP
                binding.showimage.setImageBitmap(scaledBitmap)

                // Upload image to Firebase
                uploadImageToFirebase(selectedImageUri, scaledBitmap)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun uploadImageToFirebase(selectedImageUri: Uri, bitmap: Bitmap?) {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Uploading")
        progressDialog.setMessage("Please wait...")
        progressDialog.show()

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val dateFormat = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
                val currentDate = Date()
                val imageName = dateFormat.format(currentDate) + ".png"

                val byteArrayOutputStream = ByteArrayOutputStream()
                bitmap?.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
                val data = byteArrayOutputStream.toByteArray()

                // Upload image to Firebase Storage in the background
                withContext(Dispatchers.IO) {
                    val imageRef = storageReference.child(imageName)
                    imageRef.putBytes(data).await()
                    imageUrl = imageRef.downloadUrl.await().toString()
                }

                // Save the image URL to Firebase Realtime Database
                // (Note: The actual saving will be done in the sendDataToFirebase function)

            } finally {
                progressDialog.dismiss()
            }
        }
    }

    private fun showSendConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmation")
            .setMessage("Are you sure you want to send the report?")
            .setPositiveButton("Yes") { _, _ ->
                // User clicked Yes, proceed with sending the report
                sendDataToFirebase(imageUrl)
            }
            .setNegativeButton("No") { _, _ ->
                // User clicked No, do nothing
            }
            .show()
    }

    private fun sendDataToFirebase(imageUrl: String) {
        // The logic for sending data to Firebase is here
        // (Note: This function is now called from the binding.sendbutton.setOnClickListener)
        // Get the selected radio button ID
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
        val firstName = user?.displayName ?: "Unknown"

        // Get the message from the EditText
        val userMessage = problemEditText.text.toString().trim()

        // Save data to Firebase Realtime Database
        val databaseRef = databaseReference.reference
        val problemRef = databaseRef.child("ReportedProblems").child(category).push()

        // Check if the user has already reported a problem today
        checkIfAlreadyReported(uid, category) { alreadyReported ->
            if (!alreadyReported) {
                // User hasn't reported a problem today, proceed with saving data
                val problemData = mapOf(
                    "imageUrl" to imageUrl,
                    "message" to userMessage,
                    "timestamp" to ServerValue.TIMESTAMP,
                    "uid" to uid,
                    "firstName" to firstName
                )

                problemRef.updateChildren(problemData)
                    .addOnSuccessListener {
                        // Image and data uploaded successfully
                        // Show a success message
                        Toast.makeText(this@Otherproblem, "Report sent successfully", Toast.LENGTH_SHORT).show()

                        // Delayed execution to clear UI components after the toast message
                        Handler(Looper.getMainLooper()).postDelayed({
                            clearReportForm()
                        }, 2000) // Delay for 2000 milliseconds (adjust as needed)
                    }
                    .addOnFailureListener { e ->
                        e.printStackTrace()
                    }
            } else {
                // User has already reported a problem today, show a message
                Toast.makeText(this@Otherproblem, "You have already reported a problem today", Toast.LENGTH_SHORT).show()
            }
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
}
