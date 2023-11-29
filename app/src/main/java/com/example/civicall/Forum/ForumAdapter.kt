package com.example.civicall.Forum

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.format.DateUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.CivicEngagementPost.Upload_engagement
import com.example.civicall.R
import com.example.civicall.Users
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

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
    private var isOptionDialogShowing = false

    private fun showReportDialog(postKey: String) {
        if (isOptionDialogShowing) {
            return
        }

        dismissCustomDialog()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_report_user, null)
        val alertDialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationSlideUp
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val layoutParams = alertDialog.window?.attributes
        layoutParams?.gravity = Gravity.BOTTOM
        layoutParams?.width = WindowManager.LayoutParams.MATCH_PARENT
        alertDialog.window?.attributes = layoutParams

        val Spam: LinearLayout = dialogView.findViewById(R.id.spam)
        val HateSpeech: LinearLayout = dialogView.findViewById(R.id.hateSpeech)
        val FalseInfo: LinearLayout = dialogView.findViewById(R.id.falseInfo)
        val Harassment: LinearLayout = dialogView.findViewById(R.id.harassment)
        val NotConnect: LinearLayout = dialogView.findViewById(R.id.notConnected)
        val Nudity: LinearLayout = dialogView.findViewById(R.id.nudity)
        val Violence: LinearLayout = dialogView.findViewById(R.id.violence)
        val Other: LinearLayout = dialogView.findViewById(R.id.other)

        alertDialog.setOnDismissListener {
            isOptionDialogShowing = false
        }

        Spam.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(postKey, "Spam")
        }

        HateSpeech.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(postKey, "Hate Speech")
        }

        FalseInfo.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(postKey, "False Information")
        }

        Harassment.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(postKey, "Harassment")
        }

        NotConnect.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(postKey, "Not Connected")
        }

        Nudity.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(postKey, "Nudity")
        }

        Violence.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(postKey, "Violence")
        }

        Other.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(postKey, "Other")
        }

        alertDialog.show()
        isOptionDialogShowing = true
    }

    private fun showConfirmationDialog(postKey: String, reportType: String) {
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
        logoutMsg.text = "Are you sure you want to report this post as $reportType?"

        saveBtn.text = "Report"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()

            // Pass the postKey and reportType to the reportPost function
            reportPost(postKey, reportType)
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
    private fun dismissCustomDialog() {
        if (isDeleteConfirmationDialogShowing) {
            isDeleteConfirmationDialogShowing = false
        }
        if (isOptionDialogShowing) {
            isOptionDialogShowing = false
        }
    }
    private fun reportPost(postKey: String, reportType: String) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserUid = currentUser?.uid

        val postReportRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey).child("PostReport")

        val userReportRef = currentUserUid?.let { postReportRef.child(it) }

        userReportRef?.setValue(reportType)
            ?.addOnSuccessListener {
                Toast.makeText(context, "Reported successfully", Toast.LENGTH_SHORT).show()
            }
            ?.addOnFailureListener {
                Toast.makeText(context, "Failed to report", Toast.LENGTH_SHORT).show()
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
        holder.reportButton.setOnClickListener {
            // Handle the deletion of the post (e.g., show a confirmation dialog)
            data.key?.let { showReportDialog(it) }
        }
        holder.updateTimeText(data.postTime)
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
    val timeRec: TextView = itemView.findViewById(R.id.timeRec)
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
    fun updateTimeText(postTime: String?) {
        postTime?.let {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

            dateFormat.timeZone = TimeZone.getTimeZone("Asia/Manila")

            val date = dateFormat.parse(postTime)
            val currentTime = System.currentTimeMillis()

            val timeAgo = DateUtils.getRelativeTimeSpanString(date?.time ?: 0, currentTime, DateUtils.MINUTE_IN_MILLIS)

            val formattedTime = when {
                timeAgo.toString().contains("minute") -> "${timeAgo.toString().split(" ")[0]}m"
                timeAgo.toString().contains("hour") -> "${timeAgo.toString().split(" ")[0]}h"
                timeAgo.toString().contains("day") -> "${timeAgo.toString().split(" ")[0]}d"
                timeAgo.toString().contains("week") -> "${timeAgo.toString().split(" ")[0]}w"
                timeAgo.toString().contains("month") -> "${timeAgo.toString().split(" ")[0]}month"
                timeAgo.toString().contains("year") -> "${timeAgo.toString().split(" ")[0]}y"
                else -> timeAgo.toString()
            }

            // Set the formatted time to your TextView
            timeRec.text = formattedTime
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
