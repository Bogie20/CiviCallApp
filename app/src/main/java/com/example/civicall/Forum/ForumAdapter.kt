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
import com.example.civicall.Users
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

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
    private fun updateHiddenState(postKey: String?, isHidden: Boolean) {
        if (postKey != null && currentUserUid != null) {
            // Save hidden state locally
            saveHiddenState(postKey, isHidden)

            // Update hidden state in Firebase
            val userHiddenPostsRef = FirebaseDatabase.getInstance().getReference("UserHiddenPosts").child(currentUserUid)
            userHiddenPostsRef.child(postKey).setValue(isHidden)
        }
    }
    private fun saveHiddenState(postKey: String, isHidden: Boolean) {
        val sharedPreferences = context.getSharedPreferences("HiddenPosts", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("$currentUserUid-$postKey", isHidden)
        editor.apply()
    }
    private fun getHiddenState(postKey: String, callback: (Boolean) -> Unit) {
        // Check local hidden state first
        val hiddenState = getLocalHiddenState(postKey)
        if (hiddenState != null) {
            callback.invoke(hiddenState)
        } else {
            // Fetch from Firebase if not found locally
            val userHiddenPostsRef = FirebaseDatabase.getInstance().getReference("UserHiddenPosts")
            currentUserUid?.let {
                userHiddenPostsRef.child(it)
            }
            userHiddenPostsRef.child(postKey).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val isHidden = snapshot.getValue(Boolean::class.java) ?: false
                    callback.invoke(isHidden)
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle onCancelled as needed
                }
            })
        }
    }

    private fun getLocalHiddenState(postKey: String): Boolean? {
        val sharedPreferences = context.getSharedPreferences("HiddenPosts", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("$currentUserUid-$postKey", false)
    }

    override fun onBindViewHolder(holder: MyViewHolderForum, position: Int) {
        val data = dataList[position]
        Glide.with(context).load(data.postImage).into(holder.forumImage)
        holder.forumText.text = data.postText

        val isCurrentUserPost = data.uploadersUID == currentUserUid || (data.uploadersUID == null && currentUserUid == null)
        val uploaderUid = data.uploadersUID
        if (uploaderUid != null) {
            val userRef = FirebaseDatabase.getInstance().getReference("Users").child(uploaderUid)
            userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val uploaderData = snapshot.getValue(Users::class.java)
                        if (uploaderData != null) {
                            // Set uploader image profile with a placeholder
                            Glide.with(context)
                                .load(uploaderData.ImageProfile)
                                .placeholder(R.drawable.user)
                                .error(R.drawable.user)
                                .into(holder.profilePic)

                            // Set uploader full name
                            val fullName = "${uploaderData.firstname} ${uploaderData.lastname}"
                            holder.userName.text = fullName
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle onCancelled as needed
                }
            })
        }
        getHiddenState(data.key ?: "") { isHidden ->
            data.isHidden = isHidden

            // Update the visibility of forumImage and forumText
            if (data.isHidden) {
                // The post is marked as hidden, hide forumImage and forumText
                holder.forumImage.visibility = View.GONE
                holder.forumText.visibility = View.GONE
            } else {
                // The post is not hidden, set visibility based on other conditions
                if (!data.postImage.isNullOrBlank()) {
                    holder.forumImage.visibility = View.VISIBLE
                    Glide.with(holder.itemView.context).load(data.postImage!!).into(holder.forumImage)
                } else {
                    holder.forumImage.visibility = View.GONE
                }

                if (!data.postText.isNullOrBlank()) {
                    holder.forumText.visibility = View.VISIBLE
                    holder.forumText.text = data.postText
                } else {
                    holder.forumText.visibility = View.GONE
                }
            }
        }
        holder.hideButton.setOnClickListener {
            // Toggle the visibility state of forumImage and forumText
            data.isHidden = !data.isHidden

            // Update the visibility of forumImage and forumText
            if (data.isHidden) {
                holder.forumImage.visibility = View.GONE
                holder.forumText.visibility = View.GONE
            } else {
                // The post is not hidden, set visibility based on other conditions
                if (!data.postImage.isNullOrBlank()) {
                    holder.forumImage.visibility = View.VISIBLE
                    Glide.with(context).load(data.postImage).into(holder.forumImage)
                } else {
                    holder.forumImage.visibility = View.GONE
                }

                if (!data.postText.isNullOrBlank()) {
                    holder.forumText.visibility = View.VISIBLE
                    holder.forumText.text = data.postText
                } else {
                    holder.forumText.visibility = View.GONE
                }
            }

            // Update the visibility of hideButton
            holder.hideButton.visibility = View.VISIBLE

            // Update the hidden state in the Firebase Realtime Database
            updateHiddenState(data.key, data.isHidden)
        }
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
    val profilePic: ImageView = itemView.findViewById(R.id.profilePic)
    val userName: TextView = itemView.findViewById(R.id.userName)

    fun updateFABVisibility(data: DataClassForum, isCurrentUserPost: Boolean) {
        if (data.isHidden) {
            // The post is marked as hidden, hide forumImage and forumText
            forumImage.visibility = View.GONE
            forumText.visibility = View.GONE
        } else {
            // The post is not hidden, set visibility based on other conditions
            if (!data.postImage.isNullOrBlank()) {
                forumImage.visibility = View.VISIBLE
                Glide.with(itemView.context).load(data.postImage).into(forumImage)
            } else {
                forumImage.visibility = View.GONE
            }

            if (!data.postText.isNullOrBlank()) {
                forumText.visibility = View.VISIBLE
                forumText.text = data.postText
            } else {
                forumText.visibility = View.GONE
            }
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
        fun closeFabMenu() {
        val fabMenu: FloatingActionMenu = itemView.findViewById(R.id.fabMenu)
        if (fabMenu.isOpened) {
            fabMenu.close(true)
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
