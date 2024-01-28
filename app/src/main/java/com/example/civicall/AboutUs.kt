package com.example.civicall

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.databinding.ActivityAboutUsBinding

class AboutUs : AppCompatActivity() {
    private lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        val backbtn: ImageView = findViewById(R.id.backbtn)
        backbtn.setOnClickListener {
            super.onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val facebookImageView: ImageView = findViewById(R.id.facebook)
        facebookImageView.setOnClickListener {
            openFacebookPage()
        }
        val twitterImageView: ImageView = findViewById(R.id.twitter)
        twitterImageView.setOnClickListener {
            openTwitterpage()
        }
    }

    private fun openFacebookPage() {
        val facebookPageUrl = "https://www.facebook.com/BatStateUTheNEU/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(facebookPageUrl))
        startActivity(intent)
    }
    private fun openTwitterpage() {
        val twitterPageUrl = "https://twitter.com/BatStateUTheNEU"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(twitterPageUrl))
        startActivity(intent)
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
}
