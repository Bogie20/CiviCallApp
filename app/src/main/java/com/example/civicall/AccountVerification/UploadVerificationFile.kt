package com.example.civicall.AccountVerification


import android.graphics.Paint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.R
import com.example.civicall.databinding.ActivityUploadVerificationFileBinding

class UploadVerificationFile : AppCompatActivity() {
    private lateinit var binding: ActivityUploadVerificationFileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadVerificationFileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val underlineTextView: TextView = findViewById(R.id.underlineTextView)
        underlineTextView.paintFlags = underlineTextView.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        }

}