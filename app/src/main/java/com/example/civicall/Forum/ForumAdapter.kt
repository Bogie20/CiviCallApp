package com.example.civicall.Forum

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.FirebaseDatabase

class ForumAdapter(
    private val context: Context,
    private var dataList: List<DataClassForum>,
    private val currentUserUid: String?
) : RecyclerView.Adapter<MyViewHolderForum>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderForum {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forum_post_view, parent, false)
        return MyViewHolderForum(view)
    }

    // Add this variable to your ForumAdapter class
    private var isDeleteConfirmationDialogShowing = false

    // Update the showDeleteConfirmationDialog function
    private fun showDeleteConfirmationDialog(postKey: String) {
        if (isDeleteConfirmationDialogShowing) {
            return
        }

        dismissCustomDialog()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_confirmation, null)
        val alertDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        val confirmTitle: AppCompatTextView = dialogView.findViewById(R.id.ConfirmTitle)
        val logoutMsg: AppCompatTextView = dialogView.findViewById(R.id.logoutMsg)
        val saveBtn: MaterialButton = dialogView.findViewById(R.id.saveBtn)
        val cancelBtn: MaterialButton = dialogView.findViewById(R.id.cancelBtn)

        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        confirmTitle.text = "Confirmation"
        logoutMsg.text = "Are you sure you want to delete your post?"

        saveBtn.text = "Delete"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()

            // Pass the postKey to the deletePost function
            deletePost(postKey)
        }

        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isDeleteConfirmationDialogShowing = false // Reset the flag
            alertDialog.dismiss()
            // User clicked "Cancel," do nothing or provide feedback
        }

        alertDialog.setOnDismissListener {
            isDeleteConfirmationDialogShowing = false
        }

        alertDialog.show()
        isDeleteConfirmationDialogShowing = true
    }

    // Add the dismissCustomDialog function
    private fun dismissCustomDialog() {
        if (isDeleteConfirmationDialogShowing) {
            isDeleteConfirmationDialogShowing = false
        }
    }


    private fun deletePost(postKey: String) {
        val postRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
        postRef.removeValue()

        notifyDataSetChanged()

        Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
    }

    override fun onBindViewHolder(holder: MyViewHolderForum, position: Int) {
        val data = dataList[position]
        Glide.with(context).load(data.postImage).into(holder.forumImage)
        holder.forumText.text = data.postText

        val isCurrentUserPost = data.uploadersUID == currentUserUid || (data.uploadersUID == null && currentUserUid == null)

        holder.editButton.visibility = View.GONE
        holder.deleteButton.visibility = View.GONE
        holder.reportButton.visibility = View.GONE
        holder.hideButton.visibility = View.GONE

        holder.updateFABVisibility(data, isCurrentUserPost)

        Glide.with(context).load(data.postImage).into(holder.forumImage)
        holder.forumText.text = data.postText
        holder.forumCategory.text = "# ${data.category}"
        holder.commentbutton.setOnClickListener {
            val intent = Intent(context, ForumComment::class.java).apply {
                putExtra("PostImage", data.postImage)
                putExtra("Category", data.category)
                putExtra("PostText", data.postText)
                putExtra("Key", data.key)
                putExtra("Campus", data.campus)
            }
            context.startActivity(intent)
        }
        holder.editButton.setOnClickListener {
            // Launch ForumUpdate activity with necessary data
            val intent = Intent(context, ForumUpdate::class.java).apply {
                putExtra("Key", data.key)
                putExtra("PostImage", data.postImage)
                putExtra("Category", data.category)
                putExtra("PostText", data.postText)
                putExtra("Campus", data.campus)
            }
            context.startActivity(intent)
        }
        holder.deleteButton.setOnClickListener {
            // Handle the deletion of the post (e.g., show a confirmation dialog)
            data.key?.let { showDeleteConfirmationDialog(it) }
        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    fun searchDataList(searchList: ArrayList<DataClassForum>) {
        dataList = searchList
        notifyDataSetChanged()
    }
}

class MyViewHolderForum(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val forumImage: ImageView = itemView.findViewById(R.id.postImage)
    val forumCategory: TextView = itemView.findViewById(R.id.hashtag)
    val commentbutton: AppCompatImageButton = itemView.findViewById(R.id.commentBtn)
    val forumText: TextView = itemView.findViewById(R.id.postInputtxt)
    val editButton: FloatingActionButton = itemView.findViewById(R.id.editButton)
    val deleteButton: FloatingActionButton = itemView.findViewById(R.id.deleteButton)
    val reportButton: FloatingActionButton = itemView.findViewById(R.id.reportButton)
    val hideButton: FloatingActionButton = itemView.findViewById(R.id.hideButton)

    fun updateFABVisibility(data: DataClassForum, isCurrentUserPost: Boolean) {
        if (!data.postImage.isNullOrBlank()) {
            forumImage.visibility = View.VISIBLE
            Glide.with(itemView.context).load(data.postImage).into(forumImage)
        } else {
            forumImage.visibility = View.GONE
        }

        editButton.visibility = View.GONE
        deleteButton.visibility = View.GONE
        hideButton.visibility = View.GONE
        reportButton.visibility = View.GONE

        if (isCurrentUserPost) {
            editButton.visibility = View.VISIBLE
            deleteButton.visibility = View.VISIBLE
        } else {
            hideButton.visibility = View.VISIBLE
            reportButton.visibility = View.VISIBLE
        }
    }

    init {
        val cardView: CardView = itemView.findViewById(R.id.recCard)
        val fabMenu: FloatingActionMenu = itemView.findViewById(R.id.fabMenu)

        cardView.setOnClickListener {
            if (fabMenu.isOpened) {
                fabMenu.close(true)
            }
        }

        val reportButton: FloatingActionButton = itemView.findViewById(R.id.reportButton)
        val editButton: FloatingActionButton = itemView.findViewById(R.id.editButton)
        val deleteButton: FloatingActionButton = itemView.findViewById(R.id.deleteButton)

        val fabList = listOf(reportButton, editButton, deleteButton)

        for (fab in fabList) {
            fab.setOnClickListener {
                // Your implementation here
            }
        }
    }
}
