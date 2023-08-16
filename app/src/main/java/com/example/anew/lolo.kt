package com.example.anew

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.anew.databinding.ActivityLoloBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso

class lolo : AppCompatActivity() {

    private lateinit var BackClick: ImageView
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var binding: ActivityLoloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoloBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        BackClick = findViewById(R.id.back1)

        BackClick.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in1, R.anim.fade_out2)
        }





        val menuItem1: TextView = findViewById(R.id.menuItem1)
        val menuItem2: TextView = findViewById(R.id.menuItem2)
        val AboutUs1: TextView = findViewById(R.id.AboutUs1)
        val menuItem9: TextView = findViewById(R.id.menuItem9)

        menuItem1.setOnClickListener {
            val intent = Intent(this, myprofile1::class.java)
            startActivity(intent)
        }

        menuItem2.setOnClickListener {
            val intent = Intent(this, Accountverification::class.java)
            startActivity(intent)
        }

        AboutUs1.setOnClickListener {
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)
        }

        menuItem9.setOnClickListener {
            val intent = Intent(this, Feedback::class.java)
            startActivity(intent)
        }

        val logoutIcon: ImageView = findViewById(R.id.logout1)
        logoutIcon.setOnClickListener {
            showLogoutConfirmationDialog()
        }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            startActivity(Intent(this, Login::class.java))
            finish()
        } else {
            val uid = firebaseUser.uid
            readData(uid)
        }
    }

    private fun readData(uid: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uid).get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val uid = it.child("uid").value
                    val fname = it.child("firstname").value
                    val lname = it.child("lastname").value
                    val email = it.child("email").value
                    val imageProfile = it.child("ImageProfile").value

                    binding.firstName.text = fname.toString()
                    binding.lastName.text = lname.toString()
                    binding.email1.text = email.toString()

                    val profileImage = binding.profileImage
                    if (imageProfile != null && imageProfile.toString().isNotEmpty()) {
                        Picasso.get().load(imageProfile.toString()).into(profileImage)
                    }
                    Toast.makeText(this, "Successfully Retrieved", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()
                }
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
    }

    private fun showLogoutConfirmationDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Logout")
        alertDialogBuilder.setMessage("Are you sure you want to logout?")
        alertDialogBuilder.setPositiveButton("Yes") { _, _ ->
            logoutUser()
        }
        alertDialogBuilder.setNegativeButton("Cancel") { _, _ ->
            // Do nothing, simply close the dialog
        }
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun logoutUser() {
        firebaseAuth.signOut()
        startActivity(Intent(this, Login::class.java))
        finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
    }

}