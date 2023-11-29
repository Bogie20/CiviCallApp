package com.example.civicall.Forum

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
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textRespond: TextView = itemView.findViewById(R.id.textRespond)
        private val profilePic: ImageView = itemView.findViewById(R.id.profilePic)
        private val userName: TextView = itemView.findViewById(R.id.userName)

        fun bind(comment: Comment) {
            // Set the comment text
            val commentText = "${comment.commentText}"
            textRespond.text = commentText

            val userRef = FirebaseDatabase.getInstance().getReference("Users").child(comment.commenterUID)
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
}