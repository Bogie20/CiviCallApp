package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.civicall.databinding.ActivityEditProfileBinding
import com.example.civicall.databinding.ActivityProfiledetailsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso

class EditProfile : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize binding before setting the content view
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.savebtn.setOnClickListener {
            startActivity(Intent(this, ProfileDetails::class.java))

        }

        // Initialize Firebase authentication instance
        firebaseAuth = FirebaseAuth.getInstance()

        // Check if the user is logged in
        checkUser()

        // Set up click listeners for UI elements


        binding.back1.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)        }


    }

    // Function to check if a user is logged in or not
    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            // If the user is not logged in, redirect to the login screen
            startActivity(Intent(this, Login::class.java))
            finish()
        } else {
            // If the user is logged in, fetch and display user data
            val uid = firebaseUser.uid
            readData(uid)
        }
    }

    private fun readData(uid: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uid).get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val firstName = snapshot.child("firstname").value
                val middleName = snapshot.child("middlename").value
                val lastName = snapshot.child("lastname").value
                val email = snapshot.child("email").value
                val contact = snapshot.child("phoneno").value
                val address = snapshot.child("address").value
                val birthday = snapshot.child("birthday").value
                val gender = snapshot.child("gender").value
                val imageProfile = snapshot.child("ImageProfile").value
                val usertype = snapshot.child("userType").value
                val campus = snapshot.child("campus").value

                binding.fname.text = Editable.Factory.getInstance().newEditable(firstName.toString())
                binding.mname.text = Editable.Factory.getInstance().newEditable(middleName.toString())
                binding.Lname.text = Editable.Factory.getInstance().newEditable(lastName.toString())
                binding.address.text = Editable.Factory.getInstance().newEditable(address.toString())
                binding.Contactline.text = Editable.Factory.getInstance().newEditable(contact.toString())
                binding.campus.text = Editable.Factory.getInstance().newEditable(campus.toString())
                binding.usercategory.text = Editable.Factory.getInstance().newEditable(usertype.toString())
                binding.birthdate.text = Editable.Factory.getInstance().newEditable(birthday.toString())
                binding.spinnerSex.text = Editable.Factory.getInstance().newEditable(gender.toString())

                val profileImage =
                    binding.userPhoto // Replace with your ImageView ID in the layout
                // Load the profile image using Picasso library
                if (imageProfile != null && imageProfile.toString().isNotEmpty()) {
                    Picasso.get().load(imageProfile.toString()).into(profileImage)
                }
            }
            else {
                Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()

            }

        }.addOnFailureListener {
            // Show a toast if there's a failure in fetching data
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}



