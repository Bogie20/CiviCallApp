package com.example.civicall.CivicEngagementPost


import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask

class Update_engagement : AppCompatActivity() {

    private lateinit var updateImage: ImageView
    private lateinit var updateButton: Button
    private lateinit var updateDesc: EditText
    private lateinit var updateTitle: EditText
    private lateinit var updateIntro: EditText
    private lateinit var title: String
    private lateinit var desc: String
    private lateinit var intro: String
    private lateinit var imageUrl: String
    private lateinit var key: String
    private lateinit var oldImageURL: String
    private var uri: Uri? = null
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_engagement)

        updateButton = findViewById(R.id.updateButton)
        updateDesc = findViewById(R.id.updateDesc)
        updateImage = findViewById(R.id.updateImage)
        updateIntro = findViewById(R.id.updateIntro)
        updateTitle = findViewById(R.id.updateTitle)

        val activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data = result.data
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
            updateDesc.setText(bundle.getString("Description"))
            updateIntro.setText(bundle.getString("Introduction"))
            key = bundle.getString("Key")!!
            oldImageURL = bundle.getString("Image")!!
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("Upload Engagement").child(key)

        updateImage.setOnClickListener {
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }

        updateButton.setOnClickListener {
            saveData()
            val intent = Intent(this@Update_engagement, CivicPostFragment::class.java)
            startActivity(intent)
        }
    }

    private fun saveData() {
        storageReference =
            FirebaseStorage.getInstance().getReference().child("Android Images")
                .child(uri?.lastPathSegment!!)

        val builder = AlertDialog.Builder(this@Update_engagement)
        builder.setCancelable(false)
        builder.setView(R.layout.loading_layout)
        val dialog = builder.create()
        dialog.show()

        storageReference.putFile(uri!!)
            .addOnSuccessListener(OnSuccessListener<UploadTask.TaskSnapshot> { taskSnapshot ->
                val uriTask = taskSnapshot.storage.downloadUrl
                while (!uriTask.isComplete);
                val urlImage = uriTask.result
                imageUrl = urlImage.toString()
                updateData()
                dialog.dismiss()
            }).addOnFailureListener(OnFailureListener { e ->
                dialog.dismiss()
            })
    }

    private fun updateData() {
        title = updateTitle.text.toString().trim()
        desc = updateDesc.text.toString().trim()
        intro = updateIntro.text.toString()

        val dataClass = DataClass(title, desc, intro, imageUrl)

        databaseReference.setValue(dataClass)
            .addOnCompleteListener(OnCompleteListener<Void> { task ->
                if (task.isSuccessful) {
                    val reference = FirebaseStorage.getInstance().getReferenceFromUrl(oldImageURL)
                    reference.delete()
                    Toast.makeText(this@Update_engagement, "Updated", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }).addOnFailureListener(OnFailureListener { e ->
                Toast.makeText(this@Update_engagement, e.message.toString(), Toast.LENGTH_SHORT)
                    .show()
            })
    }
}
