package com.example.civicall

import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View

import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.civicall.databinding.ActivityAddEngagementBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class add_engagement : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils
    private lateinit var binding: ActivityAddEngagementBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private var imageUri: Uri? = null
    private var savedInputData: Bundle? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEngagementBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        savedInputData = savedInstanceState?.getBundle("inputData")

        database = FirebaseDatabase.getInstance()
        reference = database.reference.child("Activities")
        auth = FirebaseAuth.getInstance()

        binding.clear.setOnClickListener {
            clearInputs()
        }

        binding.addprofile.setOnClickListener {
            showImageSourcesDialog()
        }

        binding.buttonadd.setOnClickListener {
            if (validateInputs()) {
                val title = binding.Title.text.toString()
                val introductiom = binding.introduction.text.toString()
                val location = binding.location.text.toString()

                val intent = Intent(this, Add_activities2::class.java)
                intent.putExtra("title", title)
                intent.putExtra("introduction", introductiom)
                intent.putExtra("location", location)

                imageUri?.let {
                    intent.putExtra("imageUri", it.toString())
                }

                startActivity(intent)
            } else {
                // Validation failed, show error messages and don't proceed
            }
        }

        binding.back20.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
    private fun navigateToAddActivities2() {
        val intent = Intent(this, Add_activities2::class.java)
        startActivity(intent)
    }
    private fun validateInputs(): Boolean {
        val title = binding.Title.text.toString()
        val introductiom = binding.introduction.text.toString()
        val location = binding.location.text.toString()

        if (title.isEmpty()) {
            binding.Title.error = "Title is required"
            return false
        }

        if (introductiom.isEmpty()) {
            binding.introduction.error = "Introduction is required"
            return false
        }

        if (location.isEmpty()) {
            binding.location.error = "Location is required"
            return false
        }

        if (imageUri == null) {
            Toast.makeText(this, "Please select an image", Toast.LENGTH_SHORT).show()
            return false
        }

        // All validations passed
        return true
    }

    private fun clearInputs() {
        binding.pic1.setImageResource(0) // Clear the image
        binding.Title.text.clear() // Clear title EditText
        binding.location.text.clear() // Clear location EditText
        binding.introduction.text.clear() // Clear introduction EditText

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


    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}











