package com.example.anew

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)




        homeIconImageView = findViewById(R.id.homeic2)

        homeIconImageView.setOnClickListener {
            // Open the "lolo" activity/form with slide-in animation
            val intent = Intent(this, lolo::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_from_left, R.anim.fade_in)
        }

    }



}





