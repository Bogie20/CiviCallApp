package com.example.civicall.AccountVerification




import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.civicall.R
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage


class UploadVerificationFile : AppCompatActivity() {


    private val filePicker: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                if (data != null) {
                    val fileUri: Uri? = data.data
                    if (fileUri != null) {
                        val fileName = getFileDisplayName(fileUri)
                        val sanitizedFileName = sanitizeFileName(fileName)
                        updateSelectedFileName(sanitizedFileName)
                        val selectedCategory = getSelectedCategory()
                        uploadFileToFirebase(
                            fileUri,
                            sanitizedFileName,
                            selectedCategory
                        ) // Upload the file to Firebase with the selected category
                    } else {
                        // Handle the case where fileUri is null
                    }
                }
            }
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_verification_file)


        val uploadFileButton = findViewById<TextView>(R.id.underlineTextView)
        val openCameraButton = findViewById<Button>(R.id.uploadcamera)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val storage = FirebaseStorage.getInstance()


        openCameraButton.setOnClickListener {
            val cameraIntent = Intent(this, UploadPhoto::class.java)
            startActivity(cameraIntent)
        }
        uploadFileButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(
                    this,
                    "Please select Certificate of Registration or Certificate of Graduation",
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
                        "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
                    )
                )
                filePicker.launch(intent)
            }
        }
    }


    private fun uploadFileToFirebase(fileUri: Uri, fileName: String, category: String) {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference


        // Create a reference to the file in Firebase Storage with a timestamp
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
