package com.example.civicall.Forum

import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.example.civicall.Users
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class CommentAdapter(private val commentList: List<Comment>) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.forum_respond, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = commentList[position]
        holder.bind(comment)
        holder.updateTimeText(comment.commentTime)
    }


    override fun getItemCount(): Int {
        return commentList.size
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textRespond: TextView = itemView.findViewById(R.id.textRespond)
        private val profilePic: ImageView = itemView.findViewById(R.id.profilePic)
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val timeRec: TextView = itemView.findViewById(R.id.timeRec)

        fun bind(comment: Comment) {
            // Set the comment text
            val commentText = "${comment.commentText}"
            textRespond.text = commentText

            val userRef =
                FirebaseDatabase.getInstance().getReference("Users").child(comment.commenterUID)
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
                        timeAgo.toString().contains("minute") -> "${
                            timeAgo.toString().split(" ")[0]
                        }m"

                        timeAgo.toString().contains("hour") -> "${
                            timeAgo.toString().split(" ")[0]
                        }h"

                        timeAgo.toString().contains("day") -> "${timeAgo.toString().split(" ")[0]}d"
                        timeAgo.toString().contains("week") -> "${
                            timeAgo.toString().split(" ")[0]
                        }w"

                        timeAgo.toString().contains("month") -> "${
                            timeAgo.toString().split(" ")[0]
                        }month"

                        timeAgo.toString().contains("year") -> "${
                            timeAgo.toString().split(" ")[0]
                        }y"

                        else -> timeAgo.toString()
                    }

                    timeRec.text = formattedTime
                } catch (e: ParseException) {
                    e.printStackTrace()
                    Log.e("CommentAdapter", "Error parsing date: ${e.message}")
                }
            }
        }
    }
    }