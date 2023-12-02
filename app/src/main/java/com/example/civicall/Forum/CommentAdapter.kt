package com.example.civicall.Forum

import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.example.civicall.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class CommentAdapter(private val postKey: String, private val commentMap: Map<String, DataComment>) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.forum_respond, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val commentKey = commentMap.keys.toList()[position]
        val comment = commentMap[commentKey]
        comment?.let {
            holder.bind(comment)
            holder.updateTimeText(comment.commentTime)
            holder.updateReactButtons(postKey, commentKey)
        }
    }

    override fun getItemCount(): Int {
        return commentMap.size
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textRespond: TextView = itemView.findViewById(R.id.textRespond)
        private val profilePic: ImageView = itemView.findViewById(R.id.profilePic)
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val timeRec: TextView = itemView.findViewById(R.id.timeRec)
        private val upReact: ImageButton = itemView.findViewById(R.id.upBtn)
        private val downReact: ImageButton = itemView.findViewById(R.id.downBtn)
        private val upCount: TextView = itemView.findViewById(R.id.up_count)
        private val downCount: TextView = itemView.findViewById(R.id.down_count)

        fun bind(comment: DataComment) {
            val commentText = "${comment.commentText}"
            textRespond.text = commentText
            updateReactCountUI(comment.upReactCount, comment.downReactCount)
            val userRef =
                comment.commenterUID?.let {
                    FirebaseDatabase.getInstance().getReference("Users").child(
                        it
                    )
                }
            if (userRef != null) {
                userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(userSnapshot: DataSnapshot) {
                        if (userSnapshot.exists()) {
                            val userData = userSnapshot.getValue(Users::class.java)
                            userData?.let {
                                // Set commenter's profile picture with a placeholder
                                Glide.with(itemView.context)
                                    .load(it.ImageProfile)
                                    .placeholder(R.drawable.user)
                                    .error(R.drawable.user)
                                    .into(profilePic)

                                // Set commenter's full name
                                val fullNameText = "${it.firstname} ${it.lastname}"
                                userName.text = fullNameText
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.e("CommentsAdapter", "User data retrieval cancelled: ${error.message}")
                    }
                })
            }
        }

        fun updateTimeText(commentTime: String?) {
            commentTime?.let {
                val dateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault())
                dateFormat.timeZone = TimeZone.getTimeZone("Asia/Manila")

                try {
                    val date = dateFormat.parse(commentTime)
                    val currentTime = System.currentTimeMillis()

                    val timeAgo = DateUtils.getRelativeTimeSpanString(
                        date?.time ?: 0,
                        currentTime,
                        DateUtils.MINUTE_IN_MILLIS
                    )

                    val formattedTime = when {
                        timeAgo.toString().contains("minute") ->
                            "${timeAgo.toString().split(" ")[0]}m"

                        timeAgo.toString().contains("hour") ->
                            "${timeAgo.toString().split(" ")[0]}h"

                        timeAgo.toString().contains("day") -> {
                            if (timeAgo.toString().contains("Yesterday")) {
                                "1d"
                            } else {
                                "${timeAgo.toString().split(" ")[0]}d"
                            }
                        }
                        timeAgo.toString().contains("week") ->
                            "${timeAgo.toString().split(" ")[0]}w"

                        timeAgo.toString().contains("month") -> {
                            val dateFormat = SimpleDateFormat("MMM dd", Locale.getDefault())
                            date?.let { dateFormat.format(it) } ?: ""
                        }
                        timeAgo.toString().contains("year") -> {
                            val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
                            date?.let { dateFormat.format(it) } ?: ""
                        }

                        else -> timeAgo.toString()
                    }

                    timeRec.text = formattedTime
                } catch (e: ParseException) {
                    e.printStackTrace()
                    Log.e("CommentAdapter", "Error parsing date: ${e.message}")
                }
            }
        }

        fun updateReactButtons(postKey: String, commentKey: String) {
            upReact.setOnClickListener {
                // Handle up react
                handleReact(postKey, commentKey, "up")
            }

            downReact.setOnClickListener {
                // Handle down react
                handleReact(postKey, commentKey, "down")
            }

            updateDrawable(postKey, commentKey)
        }

        private fun handleReact(postKey: String, commentKey: String, reactType: String) {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val currentUserUid = currentUser?.uid

            // Update the reactType and count in the database
            val commentRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
                .child("Comments").child(commentKey)

            currentUserUid?.let {
                val userReactRef = commentRef.child("ReactComment").child(it)

                // Fetch the current reactType to determine whether to set or remove the reaction
                userReactRef.setValue(reactType)

                // Update the counts
                updateReactCounts(commentRef)
            }
        }

        private fun updateDrawable(postKey: String, commentKey: String) {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val currentUserUid = currentUser?.uid

            // Fetch the reactType from the database
            val reactRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
                .child("Comments").child(commentKey).child("ReactComment")

            currentUserUid?.let {
                reactRef.child(it).addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val reactType = snapshot.getValue(String::class.java)
                        // Update the drawable based on the reactType
                        setDrawable(reactType)
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle onCancelled as needed
                    }
                })
            }
        }

        private fun setDrawable(reactType: String?) {
            // Update the drawable based on the reactType
            when (reactType) {
                "up" -> {
                    // Set drawable for up react
                    upReact.setImageResource(R.drawable.upselect)
                    downReact.setImageResource(R.drawable.downreact)
                }
                "down" -> {
                    upReact.setImageResource(R.drawable.upreact)
                    downReact.setImageResource(R.drawable.downselect)
                }
                else -> {
                    upReact.setImageResource(R.drawable.upreact)
                    downReact.setImageResource(R.drawable.downreact)
                }
            }
        }

        private fun updateReactCounts(commentRef: DatabaseReference) {
            commentRef.child("ReactComment").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var upReactCount = 0
                    var downReactCount = 0

                    for (childSnapshot in snapshot.children) {
                        val reactType = childSnapshot.getValue(String::class.java)
                        if (reactType == "up") {
                            upReactCount++
                        } else if (reactType == "down") {
                            downReactCount++
                        }
                    }

                    // Update the up and down react counts in the database
                    commentRef.child("upReactCount").setValue(upReactCount)
                    commentRef.child("downReactCount").setValue(downReactCount)

                    // Update the UI with the new counts
                    updateReactCountUI(upReactCount, downReactCount)
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle onCancelled as needed
                }
            })
        }

        private fun updateReactCountUI(upReactCount: Int, downReactCount: Int) {
            // Format the counts and update the UI
            upCount.text = formatCount(upReactCount)
            downCount.text = formatCount(downReactCount)
        }

        private fun formatCount(count: Int): String {
            return when {
                count < 1000 -> count.toString()
                count < 1000000 -> String.format(Locale.getDefault(), "%.1fk", count / 1000.0)
                else -> String.format(Locale.getDefault(), "%.1fm", count / 1000000.0)
            }
        }
    }
}
