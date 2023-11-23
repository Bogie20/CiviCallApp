package com.example.civicall.Forum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import de.hdodenhof.circleimageview.CircleImageView

class ForumAdapter(
    private val forumPosts: List<Forummodel>,
    private val onCommentClickListener: (Forummodel) -> Unit // Change to take the post ID or any relevant data
) : RecyclerView.Adapter<ForumAdapter.ForumViewHolder>() {

    // Inner ViewHolder class
    class ForumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: CircleImageView = itemView.findViewById(R.id.userImage)
        val usernameTextView: TextView = itemView.findViewById(R.id.username)
        val postOptionsBtn: ImageButton = itemView.findViewById(R.id.postOptionsBtn)
        val view2: View = itemView.findViewById(R.id.view2)
        val bookQuoteTextView: TextView = itemView.findViewById(R.id.bookQuoteTextView)
        val view3: View = itemView.findViewById(R.id.view3)
        val likeBtn: ImageButton = itemView.findViewById(R.id.likeBtn)
        val likeCountTextView: TextView = itemView.findViewById(R.id.like_count_textView)
        val downloadButton: ImageButton = itemView.findViewById(R.id.downloadButton)
    }

    // Create new ViewHolders (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForumViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.forum_post_view, parent, false)

        return ForumViewHolder(itemView)
    }

    // Replace the contents of a ViewHolder (invoked by the layout manager)
    override fun onBindViewHolder(holder: ForumViewHolder, position: Int) {
        val currentPost = forumPosts[position]

        // Set the data to the views
        holder.usernameTextView.text = currentPost.author
        holder.bookQuoteTextView.text = currentPost.quote
        // ... set other data

        // Set click listener for the comment button
        holder.downloadButton.setOnClickListener {
            // Pass the post ID or any relevant data to the listener
            onCommentClickListener(currentPost.postId)
        }
    }

    private fun onCommentClickListener(postId: Int) {
        TODO("Not yet implemented")
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return forumPosts.size
    }
}
