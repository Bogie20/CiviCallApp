package com.example.anew

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.anew.databinding.ActivityLoloBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


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

        firebaseAuth= FirebaseAuth.getInstance()
        checkUser()



        BackClick = findViewById(R.id.back1)

        BackClick.setOnClickListener {
            // Open the "Menu" activity/form
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        val menuItem1: TextView = findViewById(R.id.menuItem1)
        val menuItem2: TextView = findViewById(R.id.menuItem2)

        val AboutUs1: TextView = findViewById(R.id.AboutUs1)
        val menuItem9: TextView = findViewById(R.id.menuItem9)
        menuItem1.setOnClickListener {
            // Handle click for menu item 1
            val intent = Intent(this, Myprofile::class.java)
            startActivity(intent)

            }
        menuItem2.setOnClickListener {
            // Handle click for menu item 1
            val intent = Intent(this, Accountverification::class.java)
            startActivity(intent)

        }
        AboutUs1.setOnClickListener {
            // Handle click for menu item 1
            val intent = Intent(this, AboutUs::class.java)
            startActivity(intent)

        }
        menuItem9.setOnClickListener {
            // Handle click for menu item 1
            val intent = Intent(this, Feedback::class.java)
            startActivity(intent)

        }

    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null){
            startActivity(Intent(this, Login::class.java))
            finish()
        }
        else {
            val uid = firebaseUser.uid
            readData(uid)
        }
    }

    private fun readData(uid: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uid).get()
            .addOnSuccessListener {
                if (it.exists()){
                    val uid = it.child("uid").value
                    val fname=it.child("firstname").value
                    val lname=it.child("lastname").value
                    val email = it.child("email").value

                    binding.firstName.text = "$fname"
                    binding.lastName.text = "$lname"

                    Toast.makeText(this, "Successfull Retrieved", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()
                }

            }.addOnFailureListener{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }

    }
}
