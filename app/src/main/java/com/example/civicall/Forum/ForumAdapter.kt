package com.example.civicall.Forum

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.os.Looper
import android.text.format.DateUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.example.civicall.SubAdminAcc
import com.example.civicall.SuperAdminAcc
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
    private val currentUserUid: String?,
    private val forumFragment: ForumFragment
) : RecyclerView.Adapter<MyViewHolderForum>() {

    fun updateData(newDataList: List<DataClassForum>) {
        val diffCallback = ForumDiffCallBack(dataList, newDataList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        dataList = newDataList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderForum {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.forum_post_view, parent, false)
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

    private fun fetchCommentCount(postKey: String?, holder: MyViewHolderForum) {
        if (postKey != null) {
            if (holder.adapterPosition != RecyclerView.NO_POSITION && holder.adapterPosition < dataList.size) {
                val commentsRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
                    .child("Comments")

                commentsRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val commentCount = snapshot.childrenCount.toInt()

                        // Check if dataList is not empty and if the adapter position is within its bounds
                        if (dataList.isNotEmpty() && holder.adapterPosition != RecyclerView.NO_POSITION && holder.adapterPosition < dataList.size) {
                            val data = dataList[holder.adapterPosition]
                            data.commentCount = commentCount

                            holder.updateCommentCount(commentCount)

                            val postRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)

                            // Check if the post exists before updating the comment count in the database
                            postRef.addListenerForSingleValueEvent(object : ValueEventListener {
                                override fun onDataChange(postSnapshot: DataSnapshot) {
                                    if (postSnapshot.exists()) {
                                        // Only update the comment count in the database if the post exists
                                        postRef.child("commentCount").setValue(commentCount)
                                    }
                                }

                                override fun onCancelled(error: DatabaseError) {
                                    // Handle onCancelled as needed
                                }
                            })
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle onCancelled as needed
                    }
                })
            }
        }
    }



    private var isOptionDialogShowing = false

    private fun showReportDialog(postKey: String) {
        if (isOptionDialogShowing) {
            return
        }

        dismissCustomDialog()

        val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid

        // Check if the current user is authenticated
        if (currentUserUid != null) {
            // Get a reference to the current user's verification status
            val userRef = FirebaseDatabase.getInstance().getReference("Users").child(currentUserUid)

            userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // Check if the user exists and if their verification status is true
                    val verificationStatus = snapshot.child("verificationStatus").getValue(Boolean::class.java)
                    if (verificationStatus == true) {
                        // User is verified, proceed to show the report dialog
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
                        val closeButton: ImageView = dialogView.findViewById(R.id.closeIcon)

                        alertDialog.setOnDismissListener {
                            isOptionDialogShowing = false
                        }
                        closeButton.setOnClickListener {
                            alertDialog.dismiss()
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
                            showConfirmationDialog(postKey, "Not Relevant")
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
                    } else {
                        // User is not verified, show a toast indicating they can't report
                        Toast.makeText(context, "Only Verified User can Report", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle onCancelled as needed
                }
            })
        } else {
            // User is not authenticated, handle accordingly (e.g., show login screen)
        }
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
        val postReportRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
            .child("PostReport")
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
        val postRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
        postRef.removeValue()
            .addOnSuccessListener {
                // Trigger the database listener again from the ForumFragment instance
                forumFragment.fetchForumPosts()
                Toast.makeText(context, "Deleted; refresh to see changes", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(context, "Failed to delete post: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateHiddenState(postKey: String?, isHidden: Boolean) {
        if (postKey != null && currentUserUid != null) {
            // Update hidden state in Firebase under each post
            val userHiddenPostsRef =
                FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
                    .child("UserHiddenPosts").child(currentUserUid)
            userHiddenPostsRef.child("hidden").setValue(isHidden)
        }
    }

    private fun getHiddenState(postKey: String, callback: (Boolean) -> Unit) {
        val userHiddenPostsRef =
            FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
                .child("UserHiddenPosts").child(currentUserUid ?: "")

        userHiddenPostsRef.child("hidden")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val isHidden = snapshot.getValue(Boolean::class.java) ?: false
                    callback.invoke(isHidden)
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle onCancelled as needed
                }
            })
    }

    override fun onBindViewHolder(holder: MyViewHolderForum, position: Int) {
        val data = dataList[position]
        Glide.with(context)
            .load(data.postImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(holder.forumImage)
        holder.forumText.text = data.postText

        val isCurrentUserPost =
            data.uploadersUID == currentUserUid || (data.uploadersUID == null && currentUserUid == null)

        val uploaderUid = data.uploadersUID
        if (uploaderUid != null) {
            val userRef = FirebaseDatabase.getInstance().getReference("Users").child(uploaderUid)
            userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        // User exists in Users node
                        val uploaderData = snapshot.getValue(Users::class.java)
                        if (uploaderData != null) {
                            // Set uploader image profile with a placeholder
                            Glide.with(context)
                                .load(uploaderData.ImageProfile)
                                .placeholder(R.drawable.user)
                                .error(R.drawable.user)
                                .into(holder.profilePic)

                            // Set uploader full name
                            val fullName = "${uploaderData.firstname ?: ""} ${uploaderData.lastname ?: ""}"
                            holder.userName.text = fullName.trim()
                        }
                    } else {
                        // Check if uploader exists in SuperAdminAcc or SubAdminAcc node
                        val superAdminRef = FirebaseDatabase.getInstance().getReference("SuperAdminAcc").child(uploaderUid)
                        val subAdminRef = FirebaseDatabase.getInstance().getReference("SubAdminAcc").child(uploaderUid)
                        superAdminRef.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(superAdminSnapshot: DataSnapshot) {
                                if (superAdminSnapshot.exists()) {
                                    // Uploader is a SuperAdmin
                                    val superAdminData = superAdminSnapshot.getValue(SuperAdminAcc::class.java)
                                    if (superAdminData != null) {
                                        // Set uploader image profile with a placeholder
                                        Glide.with(context)
                                            .load(superAdminData.ImageProfile)
                                            .placeholder(R.drawable.user)
                                            .error(R.drawable.user)
                                            .into(holder.profilePic)

                                        // Set uploader full name
                                        val fullName = "Admin: ${superAdminData.firstname ?: ""} ${superAdminData.lastname ?: ""}"
                                        holder.userName.text = fullName.trim()
                                    }
                                } else {
                                    // Uploader is not a SuperAdmin, check in SubAdminAcc
                                    subAdminRef.addListenerForSingleValueEvent(object : ValueEventListener {
                                        override fun onDataChange(subAdminSnapshot: DataSnapshot) {
                                            if (subAdminSnapshot.exists()) {
                                                // Uploader is a SubAdmin
                                                val subAdminData = subAdminSnapshot.getValue(
                                                    SubAdminAcc::class.java)
                                                if (subAdminData != null) {
                                                    // Set uploader image profile with a placeholder
                                                    Glide.with(context)
                                                        .load(subAdminData.ImageProfile)
                                                        .placeholder(R.drawable.user)
                                                        .error(R.drawable.user)
                                                        .into(holder.profilePic)

                                                    // Set uploader full name
                                                    val fullName = "Admin: ${subAdminData.firstname ?: ""} ${subAdminData.lastname ?: ""}"
                                                    holder.userName.text = fullName.trim()
                                                }
                                            } else {
                                                // If user does not exist in any node, handle it here
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
                    // Handle onCancelled for Users
                }
            })
        }

    getHiddenState(data.key ?: "") { isHidden ->
            data.isHidden = isHidden
            if (data.isHidden) {
                // The post is marked as hidden, hide forumImage and forumText
                holder.forumImage.visibility = View.GONE
                holder.forumText.visibility = View.GONE
            } else {
                // The post is not hidden, set visibility based on other conditions
                if (!data.postImage.isNullOrBlank()) {
                    holder.forumImage.visibility = View.VISIBLE
                    Glide.with(holder.itemView.context).load(data.postImage!!)
                        .into(holder.forumImage)
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
            data.isHidden = !data.isHidden

            if (data.isHidden) {
                holder.hideButton.setImageResource(R.drawable.unhide)
                holder.forumImage.visibility = View.GONE
                holder.forumText.visibility = View.GONE
            } else {
                holder.hideButton.setImageResource(R.drawable.hideye)
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
            holder.hideButton.visibility = View.VISIBLE
            updateHiddenState(data.key, data.isHidden)
        }
        holder.editButton.visibility = View.GONE
        holder.deleteButton.visibility = View.GONE
        holder.reportButton.visibility = View.GONE
        holder.hideButton.visibility = View.GONE

        holder.updateFABVisibility(data, isCurrentUserPost, data.uploadersUID)


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
                putExtra("PostTime", data.postTime)
                putExtra("CommentCount", data.commentCount)
                putExtra("UpReactCount", data.upReactCount)
                putExtra("DownReactCount", data.downReactCount)
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
        holder.updateCommentCount(data.commentCount)
        holder.updateTimeText(data.postTime)

        fetchCommentCount(data.key, holder)


        holder.updateReactButtons(data.key ?: "")
        holder.updateReactCountUI(data.upReactCount, data.downReactCount)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun searchDataList(searchList: ArrayList<DataClassForum>) {
        val diffResult = DiffUtil.calculateDiff(ForumDiffCallBack(dataList, searchList))
        dataList = searchList
        diffResult.dispatchUpdatesTo(this)
    }
}
class MyViewHolderForum(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val forumImage: ImageView = itemView.findViewById(R.id.postImage)
    val forumCategory: TextView = itemView.findViewById(R.id.hashtag)
    val commentbutton: AppCompatImageButton = itemView.findViewById(R.id.commentBtn)
    val forumText: TextView = itemView.findViewById(R.id.postInputtxt)
    val fabMenu: FloatingActionMenu = itemView.findViewById(R.id.fabMenu)
    val editButton: FloatingActionButton = itemView.findViewById(R.id.editButton)
    val deleteButton: FloatingActionButton = itemView.findViewById(R.id.deleteButton)
    val reportButton: FloatingActionButton = itemView.findViewById(R.id.reportButton)
    val hideButton: FloatingActionButton = itemView.findViewById(R.id.hideButton)
    val profilePic: ImageView = itemView.findViewById(R.id.profilePic)
    val userName: TextView = itemView.findViewById(R.id.userName)
    val timeRec: TextView = itemView.findViewById(R.id.timeRec)
    val commentCountTextView: TextView = itemView.findViewById(R.id.commentcount)
    val upReact: ImageButton = itemView.findViewById(R.id.upBtn)
    val downReact: ImageButton = itemView.findViewById(R.id.downBtn)
    val upCount: TextView = itemView.findViewById(R.id.up_count)
    val downCount: TextView = itemView.findViewById(R.id.down_count)
    fun updateFABVisibility(data: DataClassForum, isCurrentUserPost: Boolean, uploaderUid: String?) {
        if (isCurrentUserPost) {
            // Show edit and delete buttons for the current user's post
            editButton.visibility = View.VISIBLE
            deleteButton.visibility = View.VISIBLE
            hideButton.visibility = View.GONE
            reportButton.visibility = View.GONE
            fabMenu.visibility = View.VISIBLE // Always ensure FAB menu is visible
        } else {
            uploaderUid?.let { uid ->
                // Check if the uploader's UID exists
                val userRef = FirebaseDatabase.getInstance().getReference("Users").child(uid)
                userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            // Uploader exists in Users node
                            showReportAndHideButtons() // Show report and hide buttons
                        } else {
                            // Uploader doesn't exist in Users node, check SuperAdminAcc and SubAdminAcc
                            checkAdminAccNodes(uid)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle onCancelled as needed
                    }
                })
            }
        }
    }

    private fun showReportAndHideButtons() {
        hideButton.visibility = View.VISIBLE
        reportButton.visibility = View.VISIBLE
        fabMenu.visibility = View.VISIBLE // Always ensure FAB menu is visible
    }

    private fun checkAdminAccNodes(uid: String) {
        val superAdminRef = FirebaseDatabase.getInstance().getReference("SuperAdminAcc").child(uid)
        superAdminRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(superAdminSnapshot: DataSnapshot) {
                if (!superAdminSnapshot.exists()) {
                    // Uploader is not a SuperAdmin, check in SubAdminAcc
                    val subAdminRef = FirebaseDatabase.getInstance().getReference("SubAdminAcc").child(uid)
                    subAdminRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(subAdminSnapshot: DataSnapshot) {
                            if (!subAdminSnapshot.exists()) {
                                // Uploader is neither SuperAdmin nor SubAdmin, show report and hide buttons
                                showReportAndHideButtons()
                            } else {
                                // Uploader is a SubAdmin, hide FAB menu
                                fabMenu.visibility = View.GONE
                            }
                        }

                        override fun onCancelled(subAdminError: DatabaseError) {
                            // Handle onCancelled for SubAdminAcc
                        }
                    })
                } else {
                    // Uploader is a SuperAdmin, hide FAB menu
                    fabMenu.visibility = View.GONE
                }
            }

            override fun onCancelled(superAdminError: DatabaseError) {
                // Handle onCancelled for SuperAdminAcc
            }
        })
    }


    fun updateReactButtons(postKey: String) {
        upReact.setOnClickListener {
            // Handle up react
            handleReact(postKey, "up")
        }

        downReact.setOnClickListener {
            // Handle down react
            handleReact(postKey, "down")
        }
        updateDrawable(postKey)
    }
    private fun handleReact(postKey: String, reactType: String) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserUid = currentUser?.uid

        // Check if the user has verificationStatus set to true
        currentUserUid?.let {
            val userRef = FirebaseDatabase.getInstance().getReference("Users").child(it)
            userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val verificationStatus = snapshot.child("verificationStatus").getValue(Boolean::class.java) ?: false

                    if (verificationStatus) {

                        updateReact(postKey, reactType)
                    } else {
                        // If verificationStatus is false, show a message or take appropriate action
                        Toast.makeText(itemView.context, "You need to be verified to react.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle onCancelled as needed
                }
            })
        }
    }

    private fun updateReact(postKey: String, reactType: String) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserUid = currentUser?.uid

        // Update the reactType in the database
        val reactRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey).child("React")
        currentUserUid?.let {
            val userReactRef = reactRef.child(it)

            // Fetch the current reactType to determine whether to set or remove the reaction
            userReactRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val currentReactType = snapshot.getValue(String::class.java)

                    if (currentReactType == reactType) {
                        userReactRef.removeValue()
                    } else {
                        userReactRef.setValue(reactType)
                    }
                    updateDrawable(postKey)
                    updateReactCounts(postKey)
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle onCancelled as needed
                }
            })
        }
    }

    private fun updateDrawable(postKey: String) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserUid = currentUser?.uid

        val reactRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey).child("React")
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
    private val updateHandler = Handler(Looper.getMainLooper())
    private var isUpdatePending = false

    fun updateReactCountUI(upReactCount: Int, downReactCount: Int) {
        if (!isUpdatePending) {
            isUpdatePending = true
            updateHandler.postDelayed({
                // Format the counts
                val formattedUpCount = formatCount(upReactCount)
                val formattedDownCount = formatCount(downReactCount)

                // Update the UI with a single setText call
                upCount.text = formattedUpCount
                downCount.text = formattedDownCount

                isUpdatePending = false
            }, 400)  // Delay in milliseconds
        }
    }


    private fun formatCount(count: Int): String {
        return when {
            count < 1000 -> count.toString()
            count < 1000000 -> String.format(Locale.getDefault(), "%.1fk", count / 1000.0)
            else -> String.format(Locale.getDefault(), "%.1fm", count / 1000000.0)
        }
    }
    private fun updateReactCounts(postKey: String) {
        val reactRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey).child("React")
        reactRef.addListenerForSingleValueEvent(object : ValueEventListener {
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
                val postRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
                postRef.child("upReactCount").setValue(upReactCount)
                postRef.child("downReactCount").setValue(downReactCount)
                updateReactCountUI(upReactCount, downReactCount)
            }
            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled if needed
            }
        })
    }
    fun updateCommentCount(commentCount: Int) {
        commentCountTextView.text = formatCount(commentCount)
    }
    fun updateTimeText(postTime: String?) {
        postTime?.let {
            val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())

            dateFormat.timeZone = TimeZone.getTimeZone("Asia/Manila")
            val date = dateFormat.parse(postTime)
            val currentTime = System.currentTimeMillis()

            val timeAgo = DateUtils.getRelativeTimeSpanString(date?.time ?: 0, currentTime, DateUtils.MINUTE_IN_MILLIS)

            val formattedTime = when {
                timeAgo.toString().contains("minute") -> "${timeAgo.toString().split(" ")[0]}m"
                timeAgo.toString().contains("hour") -> "${timeAgo.toString().split(" ")[0]}h"
                timeAgo.toString().contains("day") -> {
                    // Check if it's Yesterday and replace it with "1d"
                    if (timeAgo.toString().contains("Yesterday")) {
                        "1d"
                    } else {
                        "${timeAgo.toString().split(" ")[0]}d"
                    }
                }
                timeAgo.toString().contains("week") -> "${timeAgo.toString().split(" ")[0]}w"
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