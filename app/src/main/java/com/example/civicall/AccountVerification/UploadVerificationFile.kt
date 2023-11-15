package com.example.civicall.AccountVerification

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.civicall.R
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage


class UploadVerificationFile : AppCompatActivity() {
    private var fileUri: Uri? = null
    private lateinit var filenameTextView: TextView


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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_verification_file)
        filenameTextView = findViewById(R.id.filename)

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