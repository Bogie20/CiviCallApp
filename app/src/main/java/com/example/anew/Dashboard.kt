package com.example.anew

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


class Dashboard : AppCompatActivity() {
    private lateinit var reference: DatabaseReference
    private lateinit var homeIconImageView: ImageView
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var userDataViewModel: UserDataViewModel


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userDataViewModel = ViewModelProvider(this).get(UserDataViewModel::class.java)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        firebaseAuth= FirebaseAuth.getInstance()
        checkUser()
        replaceFragment(SearchFragment())

        // Set the bottomNavItemSelectedListener to the BottomNavigationView
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            // Handle bottom navigation item clicks here
            when (item.itemId) {
                R.id.menu_item_1 ->{
                    binding.titleLarge.text = "Civic Engagement"
                    replaceFragment(SearchFragment())
                }
                R.id.menu_item_2 -> {
                    binding.titleLarge.text = "Information Resources"
                    replaceFragment(Infofragment())
                }
                R.id.menu_item_3 -> {
                    binding.titleLarge.text = "Forum"
                    replaceFragment(ForumsFragment())
                }
                R.id.menu_item_4 -> {
                    binding.titleLarge.text = "Notifications"
                    replaceFragment(notificationFragment())

                }
            }
            true // Return true for other cases, false if you don't want to change the selection.
        }

        // Replace the default fragment with the initial fragment here if needed
        // For example, to display SearchFragment as the initial fragment
        //replaceFragment(SearchFragment())
        binding.profileburger.setOnClickListener{
            launchLoloActivity()
        }
    }

    private fun readData(uid: String) {
        reference = FirebaseDatabase.getInstance().getReference("Users")
        reference.child(uid).get()
            .addOnSuccessListener {
                if (it.exists()){
                    val uid = it.child("uid").value
                    val fname=it.child("firstname").value
                    val lname=it.child("lastname").value
                    val email = it.child("email").value

                    userDataViewModel.uid = uid as? String
                    userDataViewModel.fname = fname as? String
                    userDataViewModel.lname = lname as? String
                    Toast.makeText(this, "Successfull Retrieved", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()
                }

            }.addOnFailureListener{
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
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

    private fun performSearch() {
        // Add your search logic here
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment1, fragment)
        fragmentTransaction.commit()
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

