package com.example.civicall

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
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
    private lateinit var networkUtils: NetworkUtils
    private lateinit var binding: ActivitySplashactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        // Load the animation
        val anim = AnimationUtils.loadAnimation(this, R.anim.animate_splash)

        // Apply the animation to the root view
        binding.root.startAnimation(anim)

        firebaseAuth = FirebaseAuth.getInstance()
        lifecycleScope.launch {
            delay(2000)
            checkuser()
        }
    }

    private fun checkuser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {

            val intent = Intent(this, StartSplash::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.fade_out).toBundle()
            startActivity(intent, options)
            finish()
        } else {
            val ref = FirebaseDatabase.getInstance().getReference("Users")

            ref.child(firebaseUser.uid)
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

    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup() // Clean up when the activity is destroyed
    }
}
