package com.example.civicall.Forum

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.Users
import com.example.civicall.databinding.ActivityForumCommentBinding
import com.github.clans.fab.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class ForumComment : AppCompatActivity() {
    private lateinit var binding: ActivityForumCommentBinding
    private lateinit var detailText: TextView
    private lateinit var detailImage: ImageView
    private lateinit var detailCategory: TextView
    private lateinit var profilePic: ImageView
    private lateinit var fullName: TextView
    private lateinit var campusTxt: TextView
    private var key = ""
    private var imageUrl = ""
    private lateinit var postKey: String
    private lateinit var networkUtils: NetworkUtils
    private lateinit var commentEditText: EditText
    private lateinit var sendIcon: ImageView
    private lateinit var commentsRecyclerView: RecyclerView
    private lateinit var commentsAdapter: CommentAdapter
    private lateinit var postMain: ConstraintLayout
    private lateinit var hideButton: FloatingActionButton
    private var isPostMainVisible: Boolean = true
    private val commentList: MutableList<DataComment> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForumCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid
        detailImage = findViewById(R.id.detailImage)
        detailCategory = findViewById(R.id.detailCategory)
        detailText = findViewById(R.id.detailText)
        profilePic = findViewById(R.id.profilePic)
        campusTxt = findViewById(R.id.campustxt)
        fullName = findViewById(R.id.username)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        hideButton = findViewById(R.id.hideButton)
        postMain = findViewById(R.id.postMain)

        hideButton.setOnClickListener {
            isPostMainVisible = !isPostMainVisible

            if (isPostMainVisible) {
                postMain.visibility = View.VISIBLE
                hideButton.setImageResource(R.drawable.hideye)
            } else {
                postMain.visibility = View.GONE
                hideButton.setImageResource(R.drawable.unhide)
            }
        }
        binding.backbtn.setOnClickListener {
            super.onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        val bundle = intent.extras
        bundle?.let {
            detailCategory.text = "# ${it.getString("Category")}"
            detailText.text = it.getString("PostText")
            campusTxt.text = " " + it.getString("Campus")
            key = it.getString("Key") ?: ""
            postKey = it.getString("Key") ?: ""
            imageUrl = it.getString("PostImage") ?: ""
            Glide.with(this).load(it.getString("PostImage")).into(detailImage)
            val commentCount = it.getInt("CommentCount", 0)
            val upReactCount = it.getInt("UpReactCount", 0)
            val downReactCount = it.getInt("DownReactCount", 0)
            binding.commentcount.text = commentCount.toString()
            binding.upcount.text = upReactCount.toString()
            binding.downcount.text = downReactCount.toString()
            loadUploaderData(postKey)
        }
        commentEditText = findViewById(R.id.comment_editText)
        sendIcon = findViewById(R.id.comment_send_icon)
        commentsRecyclerView = findViewById(R.id.comments_recyclerView)

        sendIcon.setOnClickListener {
            val commentText = commentEditText.text.toString().trim()

            // Check if the user is verified before allowing them to comment
            val currentUser = FirebaseAuth.getInstance().currentUser
            if (currentUser != null) {
                val userRef = FirebaseDatabase.getInstance().getReference("Users").child(currentUser.uid)
                userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            val verificationStatus = snapshot.child("verificationStatus").getValue(Boolean::class.java)
                            if (verificationStatus == true) {
                                // User is verified, allow commenting
                                if (commentText.isNotEmpty()) {
                                    addCommentToDatabase(commentText)
                                }
                            } else {
                                Toast.makeText(
                                    this@ForumComment,
                                    "Please verify your account before commenting.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.e("ForumComment", "User data retrieval cancelled: ${error.message}")
                    }
                })
            }
        }



        commentsAdapter = CommentAdapter(postKey, emptyMap())
        commentsRecyclerView.layoutManager = LinearLayoutManager(this)
        commentsRecyclerView.adapter = commentsAdapter

// Load existing comments
        loadCommentsFromDatabase()


        // Load existing comments
        loadCommentsFromDatabase()


    }

    private fun addCommentToDatabase(commentText: String) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val commenterUID = currentUser?.uid ?: ""
        val commentTime = SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault())
            .apply {
                timeZone = TimeZone.getTimeZone("Asia/Manila")
            }
            .format(Calendar.getInstance().time)

        val comment = DataComment(commentText, commenterUID, commentTime)

        // Assuming you have a reference to the comments node under each post
        val commentsRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
            .child("Comments")
        val commentKey = commentsRef.push().key

        // Use the generated key to store the comment
        val commentData: MutableMap<String, Any?> = mutableMapOf()
        commentKey?.let { key ->
            commentData[key] = comment
        }

        commentsRef.updateChildren(commentData).addOnSuccessListener {
            commentEditText.text.clear()
        }.addOnFailureListener {
            // Handle failure if needed
            Log.e("ForumComment", "Failed to add comment: ${it.message}")
        }
    }


    private fun loadCommentsFromDatabase() {
        val commentsRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
            .child("Comments")

        commentsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val commentMap: MutableMap<String, DataComment> = mutableMapOf()
                for (commentSnapshot in snapshot.children) {
                    val commentKey = commentSnapshot.key
                    val comment = commentSnapshot.getValue(DataComment::class.java)
                    commentKey?.let { key ->
                        comment?.let {
                            commentMap[key] = it
                        }
                    }
                }

                // Update the existing adapter with the new data
                commentsAdapter.updateData(commentMap)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ForumComment", "Comments data retrieval cancelled: ${error.message}")
            }
        })
    }


    private fun loadUploaderData(postKey: String) {
        val postRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
        postRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val uploaderUID = snapshot.child("uploadersUID").getValue(String::class.java)
                    uploaderUID?.let { uid ->
                        // Fetch user data based on uploaderUID
                        val userRef =
                            FirebaseDatabase.getInstance().getReference("Users").child(uid)
                        userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(userSnapshot: DataSnapshot) {
                                if (userSnapshot.exists()) {
                                    val uploaderData = userSnapshot.getValue(Users::class.java)
                                    if (uploaderData != null) {
                                        // Set uploader image profile with a placeholder
                                        Glide.with(this@ForumComment)
                                            .load(uploaderData.ImageProfile)
                                            .placeholder(R.drawable.user)
                                            .error(R.drawable.user)
                                            .into(profilePic)

                                        // Set uploader full name
                                        val fullNameText =
                                            "${uploaderData.firstname} ${uploaderData.lastname}"
                                        fullName.text = fullNameText

                                        // Hide detailImage if there is no image URL
                                        if (imageUrl.isNullOrBlank()) {
                                            detailImage.visibility = View.GONE
                                        } else {
                                            detailImage.visibility = View.VISIBLE
                                            Glide.with(this@ForumComment).load(imageUrl)
                                                .into(detailImage)
                                        }
                                    }
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                Log.e(
                                    "ForumComment",
                                    "User data retrieval cancelled: ${error.message}"
                                )
                            }
                        })
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ForumComment", "Post data retrieval cancelled: ${error.message}")
            }
        })
    }
}
