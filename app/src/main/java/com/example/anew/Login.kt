package com.example.anew

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.anew.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait...")
        progressDialog.setCanceledOnTouchOutside(false)


        binding.signUpTextView.setOnClickListener {
            startActivity(Intent(this, Register1::class.java))
        }
        binding.btnlogin.setOnClickListener {
            validateData()
        }
    }
    private var email = ""
    private var password = ""

    private fun validateData() {
        email = binding.emailLogin.text.toString().trim()
        password = binding.passwordText.text.toString().trim()
        if (email.isEmpty()){
            binding.emailLogin.setError("Please Input your Email")
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailLogin.setError("Invalid Email")
        }
        else if(password.isEmpty()){
            binding.passwordText.setError("Please Enter Password")
        }else{
            loginUser()
        }
    }
    private fun loginUser() {
       progressDialog.setMessage("Logging In...")
        progressDialog.show()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                checkUser()
            }
            .addOnFailureListener{e->
                progressDialog.dismiss()
                Toast.makeText(this, "Login Failed due to $e.message", Toast.LENGTH_LONG).show()

            }
    }

    private fun checkUser() {
        progressDialog.setMessage("Checking User...")

        val firebaseUser = firebaseAuth.currentUser!!
        val ref = FirebaseDatabase.getInstance().getReference("Users")

        ref.child(firebaseUser.uid)
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    startActivity(Intent(this@Login , Dashboard::class.java))
                    finish()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
    }
}












