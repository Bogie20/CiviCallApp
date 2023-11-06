package com.example.civicall.CivicEngagementPost

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.civicall.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.text.DateFormat
import java.util.Calendar

class Upload_engagement : AppCompatActivity() {

    private lateinit var uploadImage: ImageView
    private lateinit var saveButton: Button
    private lateinit var uploadTitle: EditText
    private lateinit var uploadDateandTime: EditText
    private lateinit var uploadLocation: EditText
    private var imageURL: String? = null
    private var uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_engagement)

        uploadImage = findViewById(R.id.uploadImage)
        uploadDateandTime = findViewById(R.id.uploadDateandTime)
        uploadTitle = findViewById(R.id.uploadTitle)
        uploadLocation = findViewById(R.id.uploadLocation)
        saveButton = findViewById(R.id.updateButton)

        val activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                uri = data?.data
                uploadImage.setImageURI(uri)
            } else {
                Toast.makeText(this@Upload_engagement, "No Image Selected", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        uploadImage.setOnClickListener {
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }

        saveButton.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val storageReference =
            FirebaseStorage.getInstance().getReference().child("Poster Civic Images")
                .child(uri?.lastPathSegment!!) // Use !! to assert that uri is not null

        val builder = AlertDialog.Builder(this@Upload_engagement)
        builder.setCancelable(false)
        builder.setView(R.layout.loading_layout)
        val dialog = builder.create()
        dialog.show()

        storageReference.putFile(uri!!)
            .addOnSuccessListener { taskSnapshot ->
                val uriTask = taskSnapshot.storage.downloadUrl
                while (!uriTask.isComplete);
                val urlImage = uriTask.result
                imageURL = urlImage.toString()
                uploadData()
                dialog.dismiss()
            }
            .addOnFailureListener { e ->
                dialog.dismiss()
            }
    }

    private fun uploadData() {
        val title = uploadTitle.text.toString()
        val datetime = uploadDateandTime.text.toString()
        val location = uploadLocation.text.toString()

        // Get the UID of the currently logged-in user
        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid

        if (uploadersId != null) {
            val dataClass = DataClass(uploadersId,title, datetime, location, imageURL!!)
            val currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().time)

            FirebaseDatabase.getInstance().getReference("Upload Engagement").child(currentDate)
                .setValue(dataClass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@Upload_engagement, "Saved", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this@Upload_engagement, e.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
        }
    }
}
