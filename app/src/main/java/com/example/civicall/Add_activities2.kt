package com.example.civicall

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.civicall.databinding.ActivityAddActivities2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage


class Add_activities2 : AppCompatActivity() {
  private lateinit var database: FirebaseDatabase
  private lateinit var reference: DatabaseReference
  private lateinit var auth: FirebaseAuth

   private lateinit var binding : ActivityAddActivities2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddActivities2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance()
        reference = database.reference.child("Activities")
        auth = FirebaseAuth.getInstance()



        binding.savebtn.setOnClickListener{
            if (validateInputs()) {
                addactivities()
            }
        }
        binding.back1.setOnClickListener{
            onBackPressed()
        }



        val campusSpinner = findViewById<Spinner>(R.id.campusSpinner)
        val campusOptions = resources.getStringArray(R.array.allowed_campuses)

        val campusSpinner2 = findViewById<Spinner>(R.id.campusSpinner2) // Define the new spinner
        val NSTPOptions = resources.getStringArray(R.array.NSTP)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, campusOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        campusSpinner.adapter = adapter
        campusSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedCampus = campusOptions[position]
                // Handle the selected campus
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected
            }
        }

        // Set up the adapter and item selection listener for campusSpinner2
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, NSTPOptions)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        campusSpinner2.adapter = adapter2
        campusSpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedCampus = NSTPOptions[position]
                // Handle the selected campus for the second spinner
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected for the second spinner
            }
        }
    }
    private fun validateInputs(): Boolean {
        val description = binding.Description.text.toString()
        val guardianName = binding.guardianname.text.toString()
        val emergency = binding.emergency.text.toString()

        if (description.isEmpty()) {
            binding.Description.error = "Description is required"
            return false
        }

        if (guardianName.isEmpty()) {
            binding.guardianname.error = "Guardian name is required"
            return false
        }

        if (emergency.isEmpty()) {
            binding.emergency.error = "Emergency contact is required"
            return false
        }

        // All validations passed
        return true
    }

    private fun addactivities() {
        val currentuser = auth.currentUser
        val uid = currentuser?.uid

        val title = intent.getStringExtra("title").toString()
        val introduction = intent.getStringExtra("introduction").toString()
        val location = intent.getStringExtra("location").toString()
        val imageUriString = intent.getStringExtra("imageUri")

        val description = binding.Description.text.toString()
        val guardianName = binding.guardianname.text.toString()
        val emergency = binding.emergency.text.toString()
        val campus = binding.campusSpinner.selectedItem.toString()
        val nstp = binding.campusSpinner2.selectedItem.toString()
        val timestamp = System.currentTimeMillis().toString()

        uid?.let {
            val newpostActivities = reference.push()
            val postId = newpostActivities.key // Generate a unique key for the post

            // Upload image to Firebase Storage
            val imageUri = Uri.parse(imageUriString)
            val storageRef = FirebaseStorage.getInstance().reference
            val imageRef = storageRef.child("images/${postId}.jpg") // Use the generated postId for image reference

            val uploadTask = imageRef.putFile(imageUri)

            uploadTask.addOnSuccessListener {
                // Image upload successful
                imageRef.downloadUrl.addOnSuccessListener { uri ->
                    val imageUrl = uri.toString()

                    // Now you have the image URL, you can save it along with other data in the database
                    val activities = mapOf(
                        "title" to title,
                        "introduction" to introduction,
                        "location" to location,
                        "description" to description,
                        "guardianName" to guardianName,
                        "emergency" to emergency,
                        "campus" to campus,
                        "nstp" to nstp,
                        "timestamp" to timestamp,
                        "uid" to uid,
                        "image" to imageUrl // Store the image URL
                    )

                    newpostActivities.setValue(activities)
                        .addOnSuccessListener {
                            newpostActivities.child("ActivityID").setValue(postId)

                            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                        }
                        .addOnFailureListener { exception ->
                            Toast.makeText(this, "Error: ${exception.message}", Toast.LENGTH_LONG).show()
                        }
                }
            }
                .addOnFailureListener { exception ->
                    // Handle image upload failure
                }
        }
    }





}
