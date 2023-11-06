package com.example.civicall.CivicEngagementPost

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class Update_engagement: AppCompatActivity() {

    private lateinit var updateImage: ImageView
    private lateinit var updateButton: Button
    private lateinit var updateDateandTime: EditText
    private lateinit var updateTitle: EditText
    private lateinit var updateLocation: EditText
    private var title: String = ""
    private var dateandtime: String = ""
    private var location: String = ""
    private var imageUrl: String = ""
    private var key: String = ""
    private var oldImageURL: String = ""
    private var uri: Uri? = null
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_engagement)

        updateButton = findViewById(R.id.updateButton)
        updateDateandTime = findViewById(R.id.updateDateandTime)
        updateImage = findViewById(R.id.updateImage)
        updateLocation = findViewById(R.id.updateLocation)
        updateTitle = findViewById(R.id.updateTitle)

        val activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                uri = data?.data
                updateImage.setImageURI(uri)
            } else {
                Toast.makeText(this@Update_engagement, "No Image Selected", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        val bundle = intent.extras
        if (bundle != null) {
            Glide.with(this@Update_engagement).load(bundle.getString("Image")).into(updateImage)
            updateTitle.setText(bundle.getString("Title"))
            updateDateandTime.setText(bundle.getString("Date&Time"))
            updateLocation.setText(bundle.getString("Location"))
            key = bundle.getString("Key")!!
            oldImageURL = bundle.getString("Image")!!
        }
        databaseReference =
            FirebaseDatabase.getInstance().getReference("Upload Engagement").child(key)

        updateImage.setOnClickListener {
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }

        updateButton.setOnClickListener {
            saveData()

        }
    }

    private fun saveData() {
        val builder = AlertDialog.Builder(this@Update_engagement)
        builder.setCancelable(false)
        builder.setView(R.layout.loading_layout)
        val dialog = builder.create()
        dialog.show()

        if (uri != null) {
            storageReference = FirebaseStorage.getInstance().reference.child("Poster Civic Images")
                .child(uri?.lastPathSegment!!)

            storageReference.putFile(uri!!).addOnSuccessListener { taskSnapshot ->
                val uriTask = taskSnapshot.storage.downloadUrl
                while (!uriTask.isComplete);
                val urlImage = uriTask.result
                imageUrl = urlImage.toString()
                updateData()
                dialog.dismiss()
            }.addOnFailureListener { e ->
                dialog.dismiss()
            }
        } else {
            // No new image selected, just update the data
            updateData()
            dialog.dismiss()
        }
    }

    private fun updateData() {
        title = updateTitle.text.toString().trim()
        dateandtime = updateDateandTime.text.toString().trim()
        location = updateLocation.text.toString()

        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid
        if (uri != null) {
            // A new image is selected, update the data and imageUrl
            val dataClass = DataClass(uploadersId, title, dateandtime, location, imageUrl)

            databaseReference.setValue(dataClass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        if (oldImageURL.isNotEmpty() && imageUrl != oldImageURL) {
                            // Delete the old image
                            val reference =
                                FirebaseStorage.getInstance().getReferenceFromUrl(oldImageURL)
                            reference.delete()
                        }
                        Toast.makeText(this@Update_engagement, "Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }.addOnFailureListener { e ->
                    Toast.makeText(this@Update_engagement, e.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
        } else {
            // No new image is selected, retain the existing image URL
            val dataClass = DataClass(uploadersId, title, dateandtime, location, oldImageURL)

            databaseReference.setValue(dataClass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@Update_engagement, "Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }.addOnFailureListener { e ->
                    Toast.makeText(this@Update_engagement, e.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
        }
    }
}
