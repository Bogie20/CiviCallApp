package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import com.example.anew.databinding.ActivityDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Dashboard : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    private lateinit var homeIconImageView: ImageView

    // Move bottomNavItemSelectedListener here, outside of onCreate
    private val bottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        // Handle bottom navigation item clicks here
        when (item.itemId) {
            com.example.anew.R.id.menu_item_1 -> {
                // Open the "lolo" activity/form with slide-in animation
                val intent = Intent(this, lolo::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_in)
                return@OnNavigationItemSelectedListener true
            }
            com.example.anew.R.id.menu_item_2 -> {
                // Open the "Feedback" activity/form with slide-in animation
                val intent = Intent(this, Feedback::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            com.example.anew.R.id.menu_item_3 -> {
                // Open the "Feedback" activity/form with slide-in animation
                val intent = Intent(this, Feedback::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false // Return false for other cases
    }

    // Add the click listener for the ImageView
    fun onHomeIconClick(view: View) {
        // Create a PopupMenu
        val popupMenu = PopupMenu(this, view)
        // Inflate the navigation drawer menu
        popupMenu.inflate(R.menu.navigation_drawer_menu)
        // Set a click listener for the menu items
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_item_1 -> {
                    // Handle menu item 1 click
                    // You can open a new activity or perform some action here
                    val intent = Intent(this, lolo::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_in)
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_item_2 -> {
                    // Handle menu item 2 click
                    // You can open a new activity or perform some action here
                    val intent = Intent(this, Feedback::class.java)
                    startActivity(intent)
                    return@setOnMenuItemClickListener true
                }
                R.id.menu_item_3 -> {
                    // Handle menu item 3 click
                    // You can open a new activity or perform some action here
                    val intent = Intent(this, Feedback::class.java)
                    startActivity(intent)
                    return@setOnMenuItemClickListener true
                }
                else -> false
            }
        }
        // Show the PopupMenu
        popupMenu.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the bottomNavItemSelectedListener to the BottomNavigationView
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavItemSelectedListener)
    }
}
