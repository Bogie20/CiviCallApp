package com.example.civicall

import PopupFragment
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class Feedback : AppCompatActivity() {

    private lateinit var BackClick: ImageView
    private lateinit var editTextText2: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        setContentView(R.layout.activity_feedback)
        BackClick = findViewById(R.id.back100)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        editTextText2 = findViewById(R.id.editTextText2)
        ratingBar = findViewById(R.id.ratingBar)

        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            when (rating.toInt()) {
                0 -> editTextText2.text = "Very Dissatisfied"
                1 -> editTextText2.text = "Dissatisfied"
                2, 3 -> editTextText2.text = "Ok"
                4 -> editTextText2.text = "Satisfied"
                5 -> editTextText2.text = "Very Satisfied"
                else -> editTextText2.text = ""
            }
        }

        BackClick.setOnClickListener {
            // Open the "Menu" activity/form
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

        val popupButton: Button = findViewById(R.id.button2)
        popupButton.setOnClickListener(View.OnClickListener {
            // Show the popup when the button is clicked
            val popupFragment = PopupFragment()
            popupFragment.show(supportFragmentManager, "popup")
        })
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}




















