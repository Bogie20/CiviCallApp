package com.example.civicall


import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.civicall.CivicEngagementPost.CivicPostFragment
import com.example.civicall.CivicEngagementPost.Upload_engagement
import com.example.civicall.Forum.ForumFragment
import com.example.civicall.Forum.ForumUpload
import com.example.civicall.databinding.ActivityDashboardBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import nl.joery.animatedbottombar.AnimatedBottomBar


class Dashboard : AppCompatActivity() {
    private lateinit var bottomSheetFragment: BottomSheetDialogFragment

    private lateinit var reference: DatabaseReference
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var userDataViewModel: UserDataViewModel
    private lateinit var networkUtils: NetworkUtils
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        userDataViewModel = ViewModelProvider(this).get(UserDataViewModel::class.java)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()
        replaceFragment(CivicPostFragment())


        binding.bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when (newIndex) {
                    0 -> {
                        binding.titleLarge.text = "Take Action: Join the Cause"
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
                        replaceFragment(CivicPostFragment())
                    }
                    1 -> {
                        binding.titleLarge.text = "Information Resources"
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
                        replaceFragment(InformationFragment())
                    }
                    2 -> {
                        binding.titleLarge.text = ""
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
                    }
                    3 -> {
                        binding.titleLarge.text = "Forum"
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
                        replaceFragment(ForumFragment())
                    }
                    4 -> {
                        binding.titleLarge.text = "Notifications"
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
                        replaceFragment(OneNotificationFragment())
                    }
                }

            }

            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
            }
        })

        binding.profileburger.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        binding.fab.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }

        binding.fab.setOnClickListener {
            showOptionDialog()
        }
    }
    private var isOptionDialogShowing = false // Add this variable

    private fun showOptionDialog() {
        if (isOptionDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.bottom_sheet_filter, null)
        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationSlideUp
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Set the dialog position to the bottom
        val layoutParams = alertDialog.window?.attributes
        layoutParams?.gravity = Gravity.BOTTOM
        layoutParams?.width = WindowManager.LayoutParams.MATCH_PARENT
        alertDialog.window?.attributes = layoutParams

        val civicpost: LinearLayout = dialogView.findViewById(R.id.CivicEngagement)

        alertDialog.setOnDismissListener {
            isOptionDialogShowing = false
        }

        civicpost.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, Upload_engagement::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        val forum: LinearLayout = dialogView.findViewById(R.id.Forum)
        forum.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, ForumUpload::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        alertDialog.show()
        isOptionDialogShowing = true
    }

    private fun dismissCustomDialog() {
        if (isOptionDialogShowing) {

            isOptionDialogShowing = false
        }
    }
    private fun readData(uid: String) {
        reference = FirebaseDatabase.getInstance().getReference("Users")
        reference.child(uid).get()
            .addOnSuccessListener { snapshot ->
                if (snapshot.exists()) {
                    val userId = snapshot.child("uid").value as? String
                    val fname = snapshot.child("firstname").value as? String
                    val lname = snapshot.child("lastname").value as? String
                    val email = snapshot.child("email").value as? String

                    userDataViewModel.uid = userId
                    userDataViewModel.fname = fname
                    userDataViewModel.lname = lname
                    userDataViewModel.email = email
                } else {
                    Toast.makeText(this, "User Not Existed", Toast.LENGTH_LONG).show()
                }
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
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

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment1, fragment)
            .commit()
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup() // Clean up when the activity is destroyed
    }
}