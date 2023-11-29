package com.example.civicall.Forum

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityForumCommentBinding
import com.google.firebase.auth.FirebaseAuth

class ForumComment : AppCompatActivity() {
    private lateinit var binding: ActivityForumCommentBinding
    private lateinit var detailText: TextView
    private lateinit var detailImage: ImageView
    private lateinit var detailcampus: TextView
    private lateinit var detailCategory: TextView
    private var key = ""
    private var imageUrl = ""
    private var uploadersUID = ""
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForumCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid
        detailImage = findViewById(R.id.detailImage)
        detailCategory = findViewById(R.id.detailCategory)
        detailText = findViewById(R.id.detailText)
        detailcampus = findViewById(R.id.detailcampus)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        binding.backbtn.setOnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        val bundle = intent.extras
        bundle?.let {
            detailCategory.text = it.getString("Category")
            detailText.text = it.getString("PostText")
            detailcampus.text = it.getString("Campus")
            key = it.getString("Key") ?: ""
            imageUrl = it.getString("PostImage") ?: ""
            Glide.with(this).load(it.getString("PostImage")).into(detailImage)
        }
    }
}