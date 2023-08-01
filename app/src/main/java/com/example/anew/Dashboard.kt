package com.example.anew
import android.view.MenuItem
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import androidx.fragment.app.Fragment
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
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_in)
                return@OnNavigationItemSelectedListener true
            }
            // Add other menu items handling here if needed
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        homeIconImageView = findViewById(R.id.homeic2)
        homeIconImageView.setOnClickListener {
            val intent = Intent(this, lolo::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_in)
        }

        // Set up the bottom navigation view listener using an instance of OnNavigationItemSelectedListener
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            bottomNavItemSelectedListener.onNavigationItemSelected(item)
        }
    }
}
