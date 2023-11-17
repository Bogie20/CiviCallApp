package com.example.civicall.AccountVerification

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import android.Manifest
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.example.civicall.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class UploadVerificationFile : AppCompatActivity() {
    private var fileUri: Uri? = null
    private lateinit var filenameTextView: TextView
    private val REQUEST_CAMERA_PERMISSION = 1
    private val FILE_PROVIDER_AUTHORITY = "com.example.civicall.fileprovider"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_verification_file)
        filenameTextView = findViewById(R.id.filename)

        val uploadImage = findViewById<Button>(R.id.uploadcamera)
        val uploadFileButton = findViewById<TextView>(R.id.underlineTextView)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        FirebaseStorage.getInstance()

        val sendBtn = findViewById<TextView>(R.id.sendbtn)

        sendBtn.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(
                    this,
                    "Please select the type of Document that you want to send",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Check if a file has been selected
                val fileName = filenameTextView.text.toString()
                if (fileName.isNotEmpty()) {
                    val selectedCategory = getSelectedCategory()
                    showUploadConfirmationDialog(fileUri!!, fileName, selectedCategory)
                } else {
                    Toast.makeText(this, "Please select a file first", Toast.LENGTH_SHORT).show()
                }
            }
        }
        uploadFileButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(
                    this,
                    "Please select the type of Document to Send",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.type = "*/*"
                intent.putExtra(
                    Intent.EXTRA_MIME_TYPES, arrayOf(
                        "application/pdf",
                        "application/msword",
                        "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                        "image/jpeg",
                        "image/png",
                        "image/jpg"
                    )
                )
                filePicker.launch(intent)
            }
        }
        uploadImage.setOnClickListener {
            showImageDialog()

            checkAndRequestPermissions()
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

    private var capturedImageUri: Uri? = null



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
    private val REQUEST_IMAGE_CAPTURE = 2

    private fun takePicture() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        // Ensure that there is a camera activity to handle the intent
        if (cameraIntent.resolveActivity(packageManager) != null) {
            // Create the File where the photo should go
            val photoFile: File? = try {
                createImageFile()
            } catch (ex: IOException) {
                // Error occurred while creating the File
                Log.e("UploadVerificationFile", "Error creating image file", ex)
                null
            }

            // Continue only if the File was successfully created
            photoFile?.let {
                val photoURI: Uri = FileProvider.getUriForFile(
                    this,
                    FILE_PROVIDER_AUTHORITY,
                    it
                )
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)

                // Save the captured image URI to the class variable
                capturedImageUri = photoURI

                // Start the image capture intent
                startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${System.currentTimeMillis()}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        )
    }

    // Override onActivityResult to handle the result of the camera capture
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            capturedImageUri?.let {
                // The image has been captured successfully, show the preview dialog
                showImagePreviewDialog(it)
            }
        }
    }

    private fun showImagePreviewDialog(imageUri: Uri) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_image, null)
        val dialogIconFlat: AppCompatImageView = dialogView.findViewById(R.id.dialog_icon_flat)
        val cancelButton: MaterialButton = dialogView.findViewById(R.id.cancelBtn)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Load the original image without compression for display
        dialogIconFlat.setImageURI(imageUri)

        cancelButton.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }


    private var isImageDialogShowing = false // Initialize the flag

    private fun showImageDialog() {
        // Check if the dialog is already showing, and if so, return early
        if (isImageDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.profileedit_popup, null)
        val lytCameraPick = dialogView.findViewById<LinearLayout>(R.id.lytCameraPick)
        val lytGalleryPick = dialogView.findViewById<LinearLayout>(R.id.lytGalleryPick)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        lytCameraPick.setOnClickListener {
            takePicture()
            alertDialog.dismiss() // Close the dialog after clicking "Take a photo"
            // Reset the flag when dismissing the dialog
            isImageDialogShowing = false
        }

        lytGalleryPick.setOnClickListener {
            chooseFromGallery()
            alertDialog.dismiss() // Close the dialog after clicking "Choose from gallery"
            // Reset the flag when dismissing the dialog
            isImageDialogShowing = false
        }

        alertDialog.setOnDismissListener {
            // Reset the flag when dismissing the dialog
            isImageDialogShowing = false
        }

        alertDialog.show()
        // Set the flag to true when the dialog is displayed
        isImageDialogShowing = true
    }
    private val filePicker: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                if (data != null) {
                    fileUri = data.data
                    if (fileUri != null) {
                        val fileName = getFileDisplayName(fileUri!!)
                        val sanitizedFileName = sanitizeFileName(fileName)
                        updateSelectedFileName(sanitizedFileName)
                        updateUploadButtonText() // Add this line to update the button text
                    } else {
                        // Handle the case where fileUri is null
                    }
                }
            }
        }

    private fun updateUploadButtonText() {
        val uploadFileButton = findViewById<TextView>(R.id.underlineTextView)
        uploadFileButton.text = "Change File"
    }
    private fun getFileDisplayName(fileUri: Uri): String {
        val cursor = contentResolver.query(fileUri, null, null, null, null)
        var fileName = ""
        try {
            if (cursor != null && cursor.moveToFirst()) {
                val displayName = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                fileName = cursor.getString(displayName)
            }
        } finally {
            cursor?.close()
        }
        return fileName
    }


    private fun sanitizeFileName(fileName: String): String {
        return fileName.replace(".", "_")
    }


    private fun updateSelectedFileName(fileName: String) {
        val filenameTextInputEditText = findViewById<TextView>(R.id.filename)
        filenameTextInputEditText.setText(fileName)
    }


    private fun getSelectedCategory(): String {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(selectedRadioButtonId)
        return radioButton.text.toString()
    }
    private var isUploadConfirmationDialogShowing = false

    private fun showUploadConfirmationDialog(fileUri: Uri, fileName: String, category: String) {
        if (isUploadConfirmationDialogShowing) {
            return
        }
        dismissCustomDialog()
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_engagement, null)
        builder.setView(dialogView)

        val confirmTitle: AppCompatTextView = dialogView.findViewById(R.id.ConfirmTitle)
        val confirmationMessage: AppCompatTextView = dialogView.findViewById(R.id.logoutMsg)
        val uploadBtn: MaterialButton = dialogView.findViewById(R.id.saveBtn)
        val cancelBtn: MaterialButton = dialogView.findViewById(R.id.cancelBtn)
        val dialogIconFlat: AppCompatImageView = dialogView.findViewById(R.id.dialog_icon_flat)

        builder.setCancelable(false)
        val dialog = builder.create()

        // Set window animations and background
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        confirmTitle.text = "Upload Confirmation"
        confirmationMessage.text = "Are you sure you want to upload the file for verification of your Account?"

        uploadBtn.text = "Upload"
        uploadBtn.setOnClickListener {
            dialog.dismiss()
            uploadFileToFirebase(fileUri, fileName, category)
        }

        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isUploadConfirmationDialogShowing = false
            dialog.dismiss()
        }

        dialogIconFlat.setImageResource(R.drawable.verificationimage)

        dialog.setOnDismissListener {
            isUploadConfirmationDialogShowing = false
        }

        if (!isFinishing) {
            dialog.show()
            isUploadConfirmationDialogShowing = true
        }
    }

    private fun dismissCustomDialog() {
        if (isUploadConfirmationDialogShowing) {

            isUploadConfirmationDialogShowing = false
        }

    }
    private fun uploadFileToFirebase(fileUri: Uri, fileName: String, category: String) {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference


        val timestamp = System.currentTimeMillis().toString()
        val fileRef =
            storageRef.child("User_Verification_File/${FirebaseAuth.getInstance().currentUser?.uid ?: ""}/$category/${timestamp}_$fileName")


        // Upload the file to Firebase Storage
        fileRef.putFile(fileUri)
            .addOnSuccessListener { uploadTask ->
                // Get the download URL from the task
                fileRef.downloadUrl.addOnSuccessListener { downloadUri ->
                    // File uploaded successfully
                    val database = FirebaseDatabase.getInstance()
                    val usersRef = database.getReference("User Verification")
                    val currentUser = usersRef.child(
                        FirebaseAuth.getInstance().currentUser?.uid ?: ""
                    )


                    val categoryRef = currentUser.child(category)
                    val fileData = HashMap<String, Any>()
                    fileData["fileUri"] = downloadUri.toString() // Save the download URL
                    fileData["timestamp"] = timestamp // Save the timestamp
                    categoryRef.child(fileName).setValue(fileData)


                    Toast.makeText(this, "File uploaded successfully", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                // Handle unsuccessful uploads
                Toast.makeText(this, "File upload failed: ${exception.message}", Toast.LENGTH_SHORT)
                    .show()
            }
    }
}