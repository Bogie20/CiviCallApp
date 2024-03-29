package com.example.civicall

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.civicall.AccountVerification.UploadVerificationFile
import com.example.civicall.Calendar.CalendarActivity
import com.example.civicall.Recognition.RecognitionLeaderBoard
import com.example.civicall.databinding.ActivityMainmenuBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso

class MainMenu : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var binding: ActivityMainmenuBinding
    private var isLogoutDialogShown = false
    private lateinit var networkUtils: NetworkUtils
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val setting: TextView = findViewById(R.id.Setting)
        val calendar: TextView = findViewById(R.id.calendar)
        val logout: TextView = findViewById(R.id.logout)
        val verification1: TextView = findViewById(R.id.verification)
        val leaderboard: TextView = findViewById(R.id.Recognition)

        val feedback1: TextView = findViewById(R.id.feedback)
        val editProfileCardView:TextView= findViewById(R.id.editprofile)

        logout.setOnClickListener {
            if (networkUtils.isOnline) {

                if (!isLogoutDialogShown) {
                    isLogoutDialogShown = true

                    val dialogView = layoutInflater.inflate(R.layout.dialog_confirmation, null)
                    val dialogBuilder = AlertDialog.Builder(this)
                        .setView(dialogView)
                    val dialog = dialogBuilder.create()

                    dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
                    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                    val title: AppCompatTextView = dialogView.findViewById(R.id.ConfirmTitle)
                    val message: AppCompatTextView = dialogView.findViewById(R.id.logoutMsg)
                    val logout: MaterialButton = dialogView.findViewById(R.id.saveBtn)
                    val cancelBtn: MaterialButton = dialogView.findViewById(R.id.cancelBtn)

                    title.text = "Logout"
                    message.text = "Are you sure you want to Logout?"

                    logout.text = "Yes"
                    logout.setOnClickListener {
                        firebaseAuth.signOut()

                        val googleSignInClient =
                            GoogleSignIn.getClient(this, GoogleSignInOptions.DEFAULT_SIGN_IN)
                        googleSignInClient.signOut().addOnCompleteListener {
                            // Redirect to the login screen after successful sign-out
                            val intent = Intent(this, Login::class.java)
                            startActivity(intent)
                            finish()
                            dialog.dismiss()
                        }
                    }

                    cancelBtn.text = "Cancel"
                    cancelBtn.setOnClickListener {
                        // Handle click for the "Cancel" button
                        dialog.dismiss()
                    }

                    dialog.setOnDismissListener {
                        isLogoutDialogShown = false
                    }

                    dialog.show()
                }
            }else {
                if (!isNoInternetDialogShowing) {
                    dismissCustomDialog()
                    showNoInternetPopup()
                }
            }
        }

        verification1.setOnClickListener {
            // Handle click for menu item 2
            val intent = Intent(this, UploadVerificationFile::class.java)
            startActivity(intent)
        }
        setting.setOnClickListener {
            // Handle click for menu item 2
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }

        feedback1.setOnClickListener {
            // Handle click for Feedback menu item
            val intent = Intent(this, Feedback::class.java)
            startActivity(intent)
        }
        calendar.setOnClickListener {
            // Handle click for Feedback menu item
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }
        editProfileCardView.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        leaderboard.setOnClickListener {
            val intent = Intent(this, RecognitionLeaderBoard::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

    }


    private var isNoInternetDialogShowing = false
    private fun showNoInternetPopup() {
        isNoInternetDialogShowing = true
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_network, null)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        view.findViewById<Button>(R.id.retryBtn).setOnClickListener {
            dialog.dismiss()
            isNoInternetDialogShowing = false
        }
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        dialog.setOnDismissListener {
            isNoInternetDialogShowing = false
        }
        dialog.show()
    }
    private fun dismissCustomDialog() {
        if (isNoInternetDialogShowing) {


            isNoInternetDialogShowing = false
        }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null){
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
                    val verificationStatus = it.child("verificationStatus").value
                    val imageProfile = it.child("ImageProfile").value

                    val fullNameTextView: TextView = findViewById(R.id.fullName)

                    if (fname != null && lname != null) {
                        val fullName = "$fname $lname"
                        fullNameTextView.text = fullName
                    }

                    binding.email1.text = email.toString()

                    val profileImage = binding.profileImage

                    // Load the profile image using Picasso library
                    if (imageProfile != null && imageProfile.toString().isNotEmpty()) {
                        Picasso.get()
                            .load(imageProfile.toString())
                            .placeholder(R.drawable.three)
                            .into(profileImage)
                    } else {
                        profileImage.setImageResource(R.drawable.three)
                    }

                    if (verificationStatus == true) {
                        binding.email1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.verifiedalready, 0, 0, 0)
                        binding.email1.compoundDrawables[0]?.setColorFilter(ContextCompat.getColor(this, R.color.verified), PorterDuff.Mode.SRC_IN)
                    } else {
                        binding.email1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.verificationfalse_icon, 0, 0, 0)
                        binding.email1.compoundDrawables[0]?.setColorFilter(ContextCompat.getColor(this, R.color.unverifiedyellow), PorterDuff.Mode.SRC_IN)
                    }

                } else {
                    Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()
                }
            }.addOnFailureListener{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
    }


    override fun onDestroy() {
        super.onDestroy()

        networkUtils.cleanup()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Dashboard::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }
}