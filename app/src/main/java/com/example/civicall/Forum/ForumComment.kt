package com.example.civicall.Forum

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.SubAdminAcc
import com.example.civicall.SuperAdminAcc
import com.example.civicall.Users
import com.example.civicall.databinding.ActivityForumCommentBinding
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
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
    private lateinit var commentKey: String
    private lateinit var commentCountTextView: TextView
    private lateinit var upReactCountRef: DatabaseReference
    private lateinit var downReactCountRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForumCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid

        loadCommentsFromDatabaseWithDelay(1000)

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
        commentCountTextView = findViewById(R.id.commentcount)


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
            commentKey = it.getString("CommentKey") ?: ""
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
            upReactCountRef =
                FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
                    .child("upReactCount")
            downReactCountRef =
                FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
                    .child("downReactCount")

            // Add listeners for real-time updates
            addUpReactCountListener()
            addDownReactCountListener()
        }
        commentEditText = findViewById(R.id.comment_editText)
        sendIcon = findViewById(R.id.comment_send_icon)
        commentsRecyclerView = findViewById(R.id.comments_recyclerView)

        sendIcon.setOnClickListener {
            if (networkUtils.isOnline) {
                val commentText = commentEditText.text.toString().trim()

                // Check if the user is verified before allowing them to comment
                val currentUser = FirebaseAuth.getInstance().currentUser
                if (currentUser != null) {
                    val userRef =
                        FirebaseDatabase.getInstance().getReference("Users").child(currentUser.uid)
                    userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                val verificationStatus =
                                    snapshot.child("verificationStatus").getValue(Boolean::class.java)
                                if (verificationStatus == true) {
                                    // User is verified, allow commenting
                                    if (commentText.isNotEmpty()) {
                                        addCommentToDatabase(commentText)
                                    }
                                } else {
                                    Toast.makeText(
                                        this@ForumComment,
                                        "Please verify your account before joining the discussion.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {

                        }
                    })
                }
            } else {
                if (!isNoInternetDialogShowing) {
                    dismissCustomDialog()
                    showNoInternetPopup()
                }
            }
        }


        commentsAdapter = CommentAdapter(this, postKey, commentList)
        commentsRecyclerView.layoutManager = LinearLayoutManager(this)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        commentsRecyclerView.layoutManager = layoutManager
        commentsRecyclerView.adapter = commentsAdapter

        val nestedScrollView: NestedScrollView = findViewById(R.id.nestedScroll)
        nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            // Iterate through all visible items in the RecyclerView
            for (i in 0 until commentsRecyclerView.childCount) {
                val viewHolder =
                    commentsRecyclerView.getChildViewHolder(commentsRecyclerView.getChildAt(i))
                if (viewHolder is CommentAdapter.CommentViewHolder) {
                    viewHolder.closeFabMenu()
                }
            }
        })
    }
    private var isNoInternetDialogShowing = false
    private fun showNoInternetPopup() {
        isNoInternetDialogShowing = true
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_network, null)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        view.findViewById<Button>(R.id.retryBtn).setOnClickListener {
            dialog.dismiss()
            isNoInternetDialogShowing = false
        }
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        dialog.setOnDismissListener {
            isNoInternetDialogShowing = false
        }
        dialog.show()
    }
    private fun dismissCustomDialog() {
        if (isNoInternetDialogShowing) {

            isNoInternetDialogShowing = false
        }

    }

    private fun formatCount(count: Int): String {
        return when {
            count < 1000 -> count.toString()
            count < 1000000 -> String.format(Locale.getDefault(), "%.1fk", count / 1000.0)
            else -> String.format(Locale.getDefault(), "%.1fm", count / 1000000.0)
        }
    }

    private fun addUpReactCountListener() {
        upReactCountRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val upReactCount = snapshot.getValue(Int::class.java)
                    // Update your UI or perform any actions with the formatted upReactCount
                    binding.upcount.text = formatCount(upReactCount ?: 0)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    private fun addDownReactCountListener() {
        downReactCountRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val downReactCount = snapshot.getValue(Int::class.java)
                    // Update your UI or perform any actions with the formatted downReactCount
                    binding.downcount.text = formatCount(downReactCount ?: 0)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    private fun addCommentToDatabase(commentText: String) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val commenterUID = currentUser?.uid ?: ""
        val commentTime = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
            .apply {
                timeZone = TimeZone.getTimeZone("Asia/Manila")
            }
            .format(Calendar.getInstance().time)

        val commentsRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
            .child("Comments")
        val commentKey = commentsRef.push().key

        val comment = DataComment(commentText, commenterUID, commentTime, commentKey)

        val commentData: MutableMap<String, Any?> = mutableMapOf()
        commentKey?.let { key ->
            commentData[key] = comment
        }

        val itemCount = commentsAdapter.itemCount
        commentsRef.updateChildren(commentData).addOnSuccessListener {
            commentEditText.text.clear()

            // Update comment count in the post node
            val postRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
            postRef.child("commentCount").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val currentCount = snapshot.getValue(Int::class.java) ?: 0
                    postRef.child("commentCount").setValue(currentCount + 1)
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle error if needed
                }
            })

            commentsRecyclerView.scrollToPosition(itemCount)
        }.addOnFailureListener {
            // Handle failure if needed
            Log.e("ForumComment", "Failed to add comment: ${it.message}")
        }
    }


    private val mHandler = Handler()

    private fun loadCommentsFromDatabaseWithDelay(delayMillis: Long) {
        mHandler.postDelayed({
            loadCommentsFromDatabase()
        }, delayMillis)
    }

    private fun loadCommentsFromDatabase() {
        val commentsRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
            .child("Comments")

        commentsRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                val newCommentList: MutableList<DataComment> = mutableListOf()
                for (commentSnapshot in snapshot.children) {
                    val commentKey = commentSnapshot.key
                    val comment = commentSnapshot.getValue(DataComment::class.java)
                    commentKey?.let { key ->
                        comment?.let {
                            newCommentList.add(it)
                        }
                    }
                }
                newCommentList.sortBy { it.commentTime }

                // Update the CommentCount in real-time with formatted count
                commentCountTextView.text = formatCount(newCommentList.size)

                // Update the visibility of noimage based on the comment count
                if (newCommentList.isEmpty()) {
                    binding.noimage.visibility = View.VISIBLE
                } else {
                    binding.noimage.visibility = View.GONE
                }

                commentList.clear()
                commentList.addAll(newCommentList)
                commentsAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error if needed
            }
        })
    }


    private fun loadUploaderData(postKey: String) {
        val postRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
        postRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists() && !isDestroyed) {
                    val uploaderUID = snapshot.child("uploadersUID").getValue(String::class.java)
                    uploaderUID?.let { uid ->
                        val userRef = FirebaseDatabase.getInstance().getReference("Users").child(uid)
                        userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(userSnapshot: DataSnapshot) {
                                if (userSnapshot.exists() && !isDestroyed) {
                                    val uploaderData = userSnapshot.getValue(Users::class.java)
                                    uploaderData?.let { data ->
                                        Glide.with(this@ForumComment)
                                            .load(data.ImageProfile)
                                            .placeholder(R.drawable.user)
                                            .error(R.drawable.user)
                                            .into(profilePic)

                                        val fullNameText = "${data.firstname} ${data.lastname}"
                                        fullName.text = fullNameText

                                        if (imageUrl.isNullOrBlank()) {
                                            detailImage.visibility = View.GONE
                                        } else {
                                            detailImage.visibility = View.VISIBLE
                                            Glide.with(this@ForumComment).load(imageUrl)
                                                .into(detailImage)
                                        }
                                    }
                                } else {
                                    val superAdminRef = FirebaseDatabase.getInstance().getReference("SuperAdminAcc")
                                        .child(uid)
                                    val subAdminRef = FirebaseDatabase.getInstance().getReference("SubAdminAcc")
                                        .child(uid)
                                    superAdminRef.addListenerForSingleValueEvent(object : ValueEventListener {
                                        override fun onDataChange(superAdminSnapshot: DataSnapshot) {
                                            if (superAdminSnapshot.exists() && !isDestroyed) {
                                                val superAdminData = superAdminSnapshot.getValue(SuperAdminAcc::class.java)
                                                superAdminData?.let {
                                                    Glide.with(this@ForumComment)
                                                        .load(it.ImageProfile)
                                                        .placeholder(R.drawable.user)
                                                        .error(R.drawable.user)
                                                        .into(profilePic)

                                                    val fullNameText = "Admin: ${it.firstname} ${it.lastname}"
                                                    fullName.text = fullNameText

                                                    if (imageUrl.isNullOrBlank()) {
                                                        detailImage.visibility = View.GONE
                                                    } else {
                                                        detailImage.visibility = View.VISIBLE
                                                        Glide.with(this@ForumComment).load(imageUrl)
                                                            .into(detailImage)
                                                    }
                                                }
                                            } else {
                                                subAdminRef.addListenerForSingleValueEvent(object :
                                                    ValueEventListener {
                                                    override fun onDataChange(subAdminSnapshot: DataSnapshot) {
                                                        if (subAdminSnapshot.exists() && !isDestroyed) {
                                                            val subAdminData = subAdminSnapshot.getValue(
                                                                SubAdminAcc::class.java
                                                            )
                                                            subAdminData?.let {
                                                                Glide.with(this@ForumComment)
                                                                    .load(it.ImageProfile)
                                                                    .placeholder(R.drawable.user)
                                                                    .error(R.drawable.user)
                                                                    .into(profilePic)

                                                                val fullNameText =
                                                                    "Admin: ${it.firstname} ${it.lastname}"
                                                                fullName.text = fullNameText

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

                                                    override fun onCancelled(subAdminError: DatabaseError) {
                                                        // Handle onCancelled for SubAdminAcc
                                                    }
                                                })
                                            }
                                        }

                                        override fun onCancelled(superAdminError: DatabaseError) {
                                            // Handle onCancelled for SuperAdminAcc
                                        }
                                    })
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                // Handle onCancelled
                            }
                        })
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}
