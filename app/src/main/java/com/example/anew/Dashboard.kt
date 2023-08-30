package com.example.anew
import android.content.res.ColorStateList

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.example.anew.databinding.ActivityDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.view.animation.AnimationUtils
import nl.joery.animatedbottombar.AnimatedBottomBar



class Dashboard : AppCompatActivity() {
    private lateinit var reference: DatabaseReference
    private lateinit var homeIconImageView: ImageView
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var userDataViewModel: UserDataViewModel

    private var currentItemId: Int = R.id.menu_item_1

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        userDataViewModel = ViewModelProvider(this).get(UserDataViewModel::class.java)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()
        replaceFragment(SearchFragment())

        binding.bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when (newIndex) {
                    0 -> {
                        binding.titleLarge.text = "Civic Engagement"
                        replaceFragment(SearchFragment())
                    }
                    1 -> {
                        binding.titleLarge.text = "Information Resources"
                        replaceFragment(InformationFragment())
                    }
                    2 -> {
                        binding.titleLarge.text = "Forum"
                        launchAddEngagementActivity()
                    }
                    3 -> {
                        binding.titleLarge.text = "Notifications"
                        replaceFragment(ForumsFragment())
                    }
                    4 -> {
                        binding.titleLarge.text = "Notifications"
                        replaceFragment(notificationFragment())
                    }
                }

            }

            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
                // Handle reselected tab if needed
            }
        })

        binding.profileburger.setOnClickListener {
            val intent = Intent(this, lolo::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }


    }
    private fun launchAddEngagementActivity() {
        val intent = Intent(this, add_engagement::class.java)
        startActivity(intent)
        // Add any animation transition if needed
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
                    Toast.makeText(this, "Successfully Retrieved", Toast.LENGTH_LONG).show()
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

    private fun launchLoloActivity() {
        val intent = Intent(this, lolo::class.java)
        startActivity(intent)
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.filter_menu) // Replace with your menu resource
        // Add menu item click listeners here if needed
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.filter_option_1 -> {
                    // Handle menu item click for item 1
                    true
                }

                R.id.filter_option_2 -> {
                    // Handle menu item click for item 2
                    true
                }
                // Add other menu item click cases if needed
                else -> false
            }
        }
        popupMenu.show()
    }
}