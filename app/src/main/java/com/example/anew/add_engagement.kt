package com.example.anew

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.anew.databinding.ActivityAddEngagementBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso

class add_engagement : AppCompatActivity() {
    private lateinit var binding: ActivityAddEngagementBinding
    private lateinit var database: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth
    private var imageUri: Uri? = null
    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_engagement)
            binding = ActivityAddEngagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setCanceledOnTouchOutside(false)

        binding.back100.setOnClickListener {
            onBackPressed()
        }
        binding.clear.setOnClickListener {
            clearInputs()
        }

        binding.addprofile.setOnClickListener {
            showImageSourcesDialog()
        }

        binding.buttonadd.setOnClickListener {
            checkUser()
        }
        binding.buttonadd.setOnClickListener {
            navigateToAddActivities2()
        }

        retrieveAndPopulateUserData()
    }
    private fun navigateToAddActivities2() {
        val intent = Intent(this, Add_activities2::class.java)
        startActivity(intent)
    }
    private fun clearInputs() {
        binding.pic1.setImageResource(0) // Clear the image
        binding.Title.text.clear() // Clear title EditText
        binding.Title2.text.clear() // Clear location EditText
        binding.Title3.text.clear() // Clear introduction EditText

        // Show the TextView and FloatingActionButton
        binding.hintText.visibility = View.VISIBLE
        binding.addprofile.visibility = View.VISIBLE
    }

    private fun showImageSourcesDialog() {
        val options = arrayOf("Camera", "Gallery")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose an option")
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> pickImageCamera()
                1 -> pickImageGallery()
            }
        }
        builder.show()
    }
    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryActivityResultLauncher.launch(intent)


    }

    private fun pickImageCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "Temp_Title")
        values.put(MediaStore.Images.Media.DESCRIPTION, "Temp_Description")

        imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        cameraActivityResultLauncher.launch(intent)
    }
    private val cameraActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                //imageUri = data!!.data

                binding.pic1.setImageURI(imageUri)
            } else {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    )
    private val galleryActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                imageUri = data!!.data

                binding.pic1.setImageURI(imageUri)
            } else {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    )
    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            startActivity(Intent(this, Login::class.java))
            finish()
        } else {
            val uid = firebaseUser.uid // Get the uid of the current user

            if (imageUri == null) {
                updateData(uid, "") // Pass an empty string here
            } else {
                uploadImage(uid)
            }
        }
    }


    private fun uploadImage(uid: String) {
        progressDialog.setMessage("Uploading Profile Image")
        progressDialog.show()

        val filePathAndName = "Poster/$uid.jpg"

        val reference = FirebaseStorage.getInstance().getReference(filePathAndName)
        reference.putFile(imageUri!!)
            .addOnSuccessListener { taskSnapshot ->
                reference.downloadUrl.addOnSuccessListener { uri ->
                    val uploadImageUrl = uri.toString()
                    updateData(uid, uploadImageUrl)

                    // Hide the TextView and FloatingActionButton after successful upload
                    binding.hintText.visibility = View.GONE
                    binding.addprofile.visibility = View.GONE

                    progressDialog.dismiss()
                }
            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(this, "Failed to Upload due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }


    private fun Poster(uploadImageUrl: String) {
        progressDialog.setMessage("Updating Poster...")

        val hashMap: HashMap<String, Any> = HashMap()
        hashMap["poster"] = uploadImageUrl

        val reference = FirebaseDatabase.getInstance().getReference("Users")
        reference.child(firebaseAuth.uid!!)
            .updateChildren(hashMap)
            .addOnSuccessListener {
                progressDialog.dismiss()
                startActivity(Intent(this, Add_activities2::class.java))
                finish()
                Toast.makeText(this, "Success to Update", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(
                    this,
                    "Failed to update Profile due to ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
    private fun updateData(uid: String, uploadImageUrl: String) {
        progressDialog.setMessage("Updating Profile...")

        val title = binding.Title.text.toString()
        val location = binding.Title2.text.toString()
        val introduction = binding.Title3.text.toString()


        val user = mutableMapOf<String, Any>(
            "Title" to title,
            "location" to location,
            "Introduction" to introduction,

        )


        if (uploadImageUrl.isNotEmpty()) {
            user["Poster"] = uploadImageUrl
        }

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uid).updateChildren(user).addOnSuccessListener {
            progressDialog.dismiss()
            startActivity(Intent(this, myprofile1::class.java))
            finish()
            Toast.makeText(this, "Success to Update", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            progressDialog.dismiss()
            Toast.makeText(this, "Failed to Update", Toast.LENGTH_SHORT).show()
        }
    }

    private fun retrieveAndPopulateUserData() {
        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser != null) {
            val uid = firebaseUser.uid
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(uid).get().addOnSuccessListener { dataSnapshot ->
                if (dataSnapshot.exists()) {
                    val title = dataSnapshot.child("Title").value
                    val location = dataSnapshot.child("location").value
                    val introduction = dataSnapshot.child("Introduction").value

                    val PosterUrl =
                        dataSnapshot.child("Poster").value // Retrieve profile image URL

                    // Set retrieved data in EditText fields
                    binding.Title.setText(title.toString())
                    binding.Title2.setText(location.toString())
                    binding.Title3.setText(introduction.toString())

                    // Load profile image using Picasso if the profileImageUrl is not null
                    if (PosterUrl != null && PosterUrl.toString().isNotEmpty()) {
                        // Load profile image using Picasso
                        Picasso.get().load(PosterUrl.toString()).into(binding.pic1)

                        // Hide the TextView and FloatingActionButton
                        binding.hintText.visibility = View.GONE
                        binding.addprofile.visibility = View.GONE
                    }
                }
            }
        }
    }

}











