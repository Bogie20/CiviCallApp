package com.example.civicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.civicall.databinding.ActivityTermsAndConditionsBinding

class TermsAndConditions : AppCompatActivity() {
    private lateinit var binding: ActivityTermsAndConditionsBinding
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsAndConditionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        binding.backbtn.setOnClickListener {
                super.onBackPressed()
                overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            }
        }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}
