package com.example.civicall


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.civicall.databinding.ActivityChangePasswordBinding
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class ChangePassword : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordBinding
    private lateinit var auth: FirebaseAuth
    private var user: FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        auth = FirebaseAuth.getInstance()
        binding.btnchange.setOnClickListener {
            changePassword()
        }
    }


    private fun changePassword() {
        if (binding.CurrentPassword.text?.isNotEmpty() == true &&
            binding.newpassword.text?.isNotEmpty() == true &&
            binding.retypenewpassword.text?.isNotEmpty() == true
        ) {
            if (binding.newpassword.text.toString()
                    .equals(binding.retypenewpassword.text.toString())
            ) {
                user = auth.currentUser
                if (user?.email != null) {
                    val credential = EmailAuthProvider
                        .getCredential(user?.email!!, binding.CurrentPassword.text.toString())


                    user?.reauthenticate(credential)
                        ?.addOnCompleteListener { reauthTask ->
                            if (reauthTask.isSuccessful) {
                                Toast.makeText(
                                    this,
                                    "Re-Authentication Success!!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                user?.updatePassword(binding.newpassword.text.toString())
                                    ?.addOnCompleteListener { updateTask ->
                                        if (updateTask.isSuccessful) {
                                            Toast.makeText(
                                                this,
                                                "Password Successfully Changed",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                            auth.signOut()
                                            startActivity(Intent(this, Dashboard::class.java))
                                            finish()
                                        }
                                    }
                            } else {
                                Toast.makeText(
                                    this,
                                    "Re-Authentication Failed!!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                } else {
                    startActivity(Intent(this, Dashboard::class.java))
                    finish()
                }
            } else {
                Toast.makeText(this, "Password Mismatching", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please Enter all the Fields", Toast.LENGTH_SHORT).show()
        }
    }
}
