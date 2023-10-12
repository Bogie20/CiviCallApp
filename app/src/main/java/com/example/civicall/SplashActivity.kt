package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.civicall.databinding.ActivitySplashactivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var binding: ActivitySplashactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        lifecycleScope.launch {
            delay(2000)
            checkuser()
        }
    }

    private fun checkuser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            // The user is not logged in, so redirect to the Login activity
            startActivity(Intent(this, Login::class.java))
            finish()
        } else {
            val ref = FirebaseDatabase.getInstance().getReference("Users")

            ref.child(firebaseUser!!.uid)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            // User data exists, go to the Dashboard
                            startActivity(Intent(this@SplashActivity, Dashboard::class.java))
                        } else {
                            // User data does not exist, log out and redirect to the Login activity
                            firebaseAuth.signOut()
                            startActivity(Intent(this@SplashActivity, Login::class.java))
                        }
                        finish()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle database error if needed
                    }
                })
        }
    }
}