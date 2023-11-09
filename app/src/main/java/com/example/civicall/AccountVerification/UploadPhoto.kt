package com.example.civicall.AccountVerification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.civicall.R
import com.google.firebase.database.FirebaseDatabase

class UploadPhoto : AppCompatActivity() {
    private lateinit var idPictureImageView: ImageView
    private lateinit var uploadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_photo)

        idPictureImageView = findViewById(R.id.idpicture)
        uploadButton = findViewById(R.id.uploadbutton)

        uploadButton.setOnClickListener {
            // Get the ID picture from the ImageView
            val idPicture = idPictureImageView.drawable // Replace this with the actual ID picture data

            // Store the ID picture in the Firebase Realtime Database
            val userId = "user_id" // Replace this with the actual user ID
            val database = FirebaseDatabase.getInstance()
            val verificationFilesRef = database.getReference("verificationFiles")
            val schoolIdCategoryRef = verificationFilesRef.child("School ID")
            val categoryNameRef = schoolIdCategoryRef.child("categoryName")
            val userIdPictureRef = categoryNameRef.child(userId)
            userIdPictureRef.setValue(idPicture)

            // Display the ID picture in the ImageView
            idPictureImageView.setImageDrawable(idPicture)
        }
    }
}