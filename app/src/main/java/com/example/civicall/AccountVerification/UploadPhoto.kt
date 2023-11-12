package com.example.civicall.AccountVerification

import android.graphics.Paint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.civicall.R
import com.example.civicall.databinding.ActivityUploadPhotoBinding


class UploadPhoto : AppCompatActivity() {
    private lateinit var binding: ActivityUploadPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val underlineTextView: TextView = findViewById(R.id.RetakePhoto)
        underlineTextView.paintFlags = underlineTextView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        }
    }