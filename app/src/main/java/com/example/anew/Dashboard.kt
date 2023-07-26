package com.example.anew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import com.example.anew.databinding.ActivityDashboardBinding


class Dashboard : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    private lateinit var homeIconImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)




        homeIconImageView = findViewById(R.id.homeic)

        homeIconImageView.setOnClickListener {
            // Open the "Menu" activity/form
            val intent = Intent(this, lolo::class.java)
            startActivity(intent)
        }

    }
}