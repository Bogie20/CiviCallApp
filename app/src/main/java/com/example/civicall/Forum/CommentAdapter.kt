package com.example.civicall.Forum

import android.content.Context
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.format.DateUtils
import android.util.Log
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
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
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
import com.google.firebase.database.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class CommentAdapter(
    private val context: Context,
    private val postKey: String,
    private var commentList: List<DataComment>
) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    private val currentUser = FirebaseAuth.getInstance().currentUser
    private val currentUserUid = currentUser?.uid


    private var isDeleteConfirmationDialogShowing = false

    // Update the showDeleteConfirmationDialog function
    private fun showDeleteConfirmationDialog(commentKey: String) {
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

            deleteComment(commentKey)
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

    private fun showReportDialog(commentKey: String) {
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
            showConfirmationDialog(commentKey, "Spam")
        }

        HateSpeech.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(commentKey, "Hate Speech")
        }

        FalseInfo.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(commentKey, "False Information")
        }

        Harassment.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(commentKey, "Harassment")
        }

        NotConnect.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(commentKey, "Not Relevant")
        }

        Nudity.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(commentKey, "Nudity")
        }

        Violence.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(commentKey, "Violence")
        }

        Other.setOnClickListener {
            alertDialog.dismiss()
            isOptionDialogShowing = false
            showConfirmationDialog(commentKey, "Other")
        }

        alertDialog.show()
        isOptionDialogShowing = true
    }

    private fun showConfirmationDialog(commentKey: String, reportType: String) {
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
            reportPost(commentKey, reportType)
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
    private fun reportPost(commentKey: String, reportType: String) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserUid = currentUser?.uid

        val commentReportRef = FirebaseDatabase.getInstance().getReference("Forum_Post")
            .child(postKey)
            .child("Comments")
            .child(commentKey)
            .child("CommentReport")

        val userReportRef = currentUserUid?.let { commentReportRef.child(it) }

        userReportRef?.setValue(reportType)
            ?.addOnSuccessListener {
                Toast.makeText(context, "Reported successfully", Toast.LENGTH_SHORT).show()
            }
            ?.addOnFailureListener {
                Toast.makeText(context, "Failed to report", Toast.LENGTH_SHORT).show()
            }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteComment(commentKey: String) {
        val commentRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
            .child("Comments").child(commentKey)

        // Get a reference to the post node to update commentCount
        val postRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)

        commentRef.removeValue()
            .addOnSuccessListener {
                // Comment successfully deleted from the database
                // Update the commentCount value in the post node
                postRef.child("commentCount").addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val currentCommentCount = snapshot.getValue(Int::class.java) ?: 0
                        if (currentCommentCount > 0) {
                            // Decrease the comment count by 1
                            postRef.child("commentCount").setValue(currentCommentCount - 1)
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        // Handle onCancelled as needed
                    }
                })
                notifyDataSetChanged()
                Toast.makeText(context, "Comment Deleted", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                // Failed to delete the comment
                Toast.makeText(context, "Failed to delete comment", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateHiddenState(postKey: String, commentKey: String?, isHidden: Boolean) {
        if (commentKey != null) {
            val userHiddenCommentsRef = FirebaseDatabase.getInstance().getReference("Forum_Post")
                .child(postKey)
                .child("Comments")
                .child(commentKey)
                .child("UserHiddenComments")
                .child(currentUserUid ?: "")
                .child("hiddenComment")

            userHiddenCommentsRef.setValue(isHidden)
        }
    }

    object DataRepository {
        var currentPostKey: String? = null
    }

    private fun getHiddenState(postKey: String, commentKey: String, callback: (Boolean) -> Unit) {
        val userHiddenCommentsRef = FirebaseDatabase.getInstance().getReference("Forum_Post")
            .child(postKey)
            .child("Comments")
            .child(commentKey)
            .child("UserHiddenComments")
            .child(currentUserUid ?: "")
            .child("hiddenComment")

        userHiddenCommentsRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val isHidden = snapshot.getValue(Boolean::class.java) ?: false
                callback.invoke(isHidden)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled as needed
            }
        })
    }

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return commentList[position].commentKey?.hashCode()?.toLong() ?: 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<DataComment>) {
        if (commentList.isEmpty()) {
            notifyItemRangeRemoved(0, itemCount)
        }
        val diffResult = DiffUtil.calculateDiff(CommentDiffCallback(commentList, newData))
        commentList = newData
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forum_respond, parent, false)
        return CommentViewHolder(view)
    }


    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = commentList[position]


        comment?.let {
            val commentKey = comment.commentKey.orEmpty()
            holder.bind(comment)
            holder.updateTimeText(comment.commentTime)
            holder.updateReactButtons(postKey, commentKey)
            holder.editButton.visibility = View.GONE
            holder.deleteButton.visibility = View.GONE
            holder.reportButton.visibility = View.GONE
            holder.hideButton.visibility = View.GONE
            holder.upReact.isPressed = holder.isUpSelected
            holder.downReact.isPressed = holder.isDownSelected
            if (currentUserUid == comment.commenterUID) {
                holder.editButton.visibility = View.VISIBLE
                holder.deleteButton.visibility = View.VISIBLE
            } else {
                holder.reportButton.visibility = View.VISIBLE
                holder.hideButton.visibility = View.VISIBLE
            }
            getHiddenState(postKey, comment.commentKey ?: "") { isHidden ->
                comment.isHidden = isHidden

                // Update the visibility of forumImage and forumText
                if (comment.isHidden) {
                    holder.commentText.visibility = View.GONE
                } else {
                    if (!comment.commentText.isNullOrBlank()) {
                        holder.commentText.visibility = View.VISIBLE
                        holder.commentText.text = comment.commentText
                    } else {
                        holder.commentText.visibility = View.GONE
                    }
                }
            }

            holder.hideButton.setOnClickListener {
                comment.isHidden = !comment.isHidden

                if (comment.isHidden) {
                    holder.hideButton.setImageResource(R.drawable.unhide)
                    holder.commentText.visibility = View.GONE
                } else {
                    holder.hideButton.setImageResource(R.drawable.hideye)
                    if (!comment.commentText.isNullOrBlank()) {
                        holder.commentText.visibility = View.VISIBLE
                        holder.commentText.text = comment.commentText
                    } else {
                        holder.commentText.visibility = View.GONE
                    }
                }
                holder.hideButton.visibility = View.VISIBLE

                // Update the hidden state in the Firebase Realtime Database
                updateHiddenState(postKey, comment.commentKey, comment.isHidden)

                // Hide the reportButton when hideButton is clicked

            }


            holder.editButton.setOnClickListener {
                // Set the current post key before launching the CommentEdit activity
                DataRepository.currentPostKey = postKey

                val intent = Intent(context, CommentEdit::class.java).apply {
                    putExtra("CommentKey", comment.commentKey)
                    putExtra("CommentText", comment.commentText)
                    putExtra("CommentTime", comment.commentTime)
                    putExtra("UpCount", comment.upReactCount)
                    putExtra("DownCount", comment.downReactCount)
                }
                context.startActivity(intent)
            }
            holder.deleteButton.setOnClickListener {
                comment.commentKey?.let {
                    showDeleteConfirmationDialog(it)
                }
            }
            holder.reportButton.setOnClickListener {
                // Handle the deletion of the post (e.g., show a confirmation dialog)
                comment.commentKey?.let {
                    showReportDialog(it)
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return commentList.size
    }


    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textRespond: TextView = itemView.findViewById(R.id.textRespond)
        private val cardView: CardView = itemView.findViewById(R.id.recCard)
        private val profilePic: ImageView = itemView.findViewById(R.id.profilePic)
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val Campus: TextView = itemView.findViewById(R.id.campus)
        private val timeRec: TextView = itemView.findViewById(R.id.timeRec)
        val upReact: ImageButton = itemView.findViewById(R.id.upBtn)
        val downReact: ImageButton = itemView.findViewById(R.id.downBtn)
        private val upCount: TextView = itemView.findViewById(R.id.up_count)
        private val downCount: TextView = itemView.findViewById(R.id.down_count)
        val editButton: FloatingActionButton = itemView.findViewById(R.id.editButton)
        val fabMenu: FloatingActionMenu = itemView.findViewById(R.id.fabMenu)
        val deleteButton: FloatingActionButton = itemView.findViewById(R.id.deleteButton)
        var reportButton: FloatingActionButton = itemView.findViewById(R.id.reportBtn)
        val hideButton: FloatingActionButton = itemView.findViewById(R.id.hideButton)
        val commentText: TextView = itemView.findViewById(R.id.textRespond)
        var isUpSelected = false
        var isDownSelected = false
        init {
            cardView.setOnClickListener {
                closeFabMenu()
            }
        }
        fun closeFabMenu() {
            val fabMenu: FloatingActionMenu = itemView.findViewById(R.id.fabMenu)
            if (fabMenu.isOpened) {
                fabMenu.close(true)
            }
        }
        fun bind(comment: DataComment) {
            val currentUserReact = comment.currentUserReact // Replace with the actual variable that stores the user's reaction
            isUpSelected = currentUserReact == "up"
            isDownSelected = currentUserReact == "down"

            updateReactCountUI(comment.upReactCount, comment.downReactCount)

            val currentUser = FirebaseAuth.getInstance().currentUser
            val currentUserUid = currentUser?.uid

            if (currentUserUid == comment.commenterUID) {
                editButton.visibility = View.VISIBLE
                deleteButton.visibility = View.VISIBLE
                reportButton.visibility = View.GONE
                hideButton.visibility = View.GONE
            } else {
                editButton.visibility = View.GONE
                deleteButton.visibility = View.GONE
                reportButton.visibility = View.VISIBLE
                hideButton.visibility = View.VISIBLE
            }

            val commentText = "${comment.commentText}"
            textRespond.text = commentText
            updateReactCountUI(comment.upReactCount, comment.downReactCount)
            val userRef = comment.commenterUID?.let {
                FirebaseDatabase.getInstance().getReference("Users").child(it)
            }

            val superAdminRef = comment.commenterUID?.let {
                FirebaseDatabase.getInstance().getReference("SuperAdminAcc").child(it)
            }

            val subAdminRef = comment.commenterUID?.let {
                FirebaseDatabase.getInstance().getReference("SubAdminAcc").child(it)
            }

            userRef?.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(userSnapshot: DataSnapshot) {
                    if (userSnapshot.exists()) {
                        // User exists in Users node
                        val userData = userSnapshot.getValue(Users::class.java)
                        userData?.let {
                            // Set user data
                            setUserData(it)
                        }
                    } else {
                        // User doesn't exist in Users node, check SuperAdminAcc
                        superAdminRef?.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(superAdminSnapshot: DataSnapshot) {
                                if (superAdminSnapshot.exists()) {
                                    // User exists in SuperAdminAcc
                                    val superAdminData = superAdminSnapshot.getValue(SuperAdminAcc::class.java)
                                    superAdminData?.let {
                                        // Set super admin data
                                        setSuperAdminData(it)
                                        fabMenu.visibility = View.GONE
                                    }
                                } else {
                                    // User doesn't exist in SuperAdminAcc, check SubAdminAcc
                                    subAdminRef?.addListenerForSingleValueEvent(object : ValueEventListener {
                                        override fun onDataChange(subAdminSnapshot: DataSnapshot) {
                                            if (subAdminSnapshot.exists()) {
                                                // User exists in SubAdminAcc
                                                val subAdminData = subAdminSnapshot.getValue(SubAdminAcc::class.java)
                                                subAdminData?.let {
                                                    // Set sub admin data
                                                    setSubAdminData(it)
                                                    fabMenu.visibility = View.GONE

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
                    // Handle onCancelled for Users
                }
            })
        }

        private fun setUserData(userData: Users) {
                // Set user data
                Glide.with(itemView.context.applicationContext)
                    .asBitmap()
                    .load(userData.ImageProfile)
                    .placeholder(R.drawable.user)
                    .error(R.drawable.user)
                    .into(profilePic)

                val fullNameText = "${userData.firstname} ${userData.lastname}"
                val campus = userData.campus
                userName.text = fullNameText
                Campus.text = campus
            }

            private fun setSuperAdminData(superAdminData: SuperAdminAcc) {
                // Set super admin data
                Glide.with(itemView.context.applicationContext)
                    .asBitmap()
                    .load(superAdminData.ImageProfile)
                    .placeholder(R.drawable.user)
                    .error(R.drawable.user)
                    .into(profilePic)

                val fullName = "Admin: ${superAdminData.firstname} ${superAdminData.lastname}"

                userName.text = fullName

            }

            private fun setSubAdminData(subAdminData: SubAdminAcc) {
                // Set sub admin data
                Glide.with(itemView.context.applicationContext)
                    .asBitmap()
                    .load(subAdminData.ImageProfile)
                    .placeholder(R.drawable.user)
                    .error(R.drawable.user)
                    .into(profilePic)

                val fullName = "Admin: ${subAdminData.firstname} ${subAdminData.lastname}"
                val campus = subAdminData.campus
                userName.text = fullName
                Campus.text = campus
            }

            fun updateTimeText(commentTime: String?) {
            commentTime?.let {
                val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
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
                handleReact(postKey, commentKey, "up")
            }

            downReact.setOnClickListener {
                handleReact(postKey, commentKey, "down")
            }

            updateDrawable(postKey, commentKey)
        }


        private fun handleReact(postKey: String, commentKey: String, reactType: String) {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val currentUserUid = currentUser?.uid

            // Check if the user has verificationStatus set to true
            currentUserUid?.let {
                val userRef = FirebaseDatabase.getInstance().getReference("Users").child(it)
                userRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val verificationStatus = snapshot.child("verificationStatus").getValue(Boolean::class.java) ?: false

                        if (verificationStatus) {
                            // If verificationStatus is true, allow the user to react
                            updateReact(postKey, commentKey, reactType)
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

        private fun updateReact(postKey: String, commentKey: String, reactType: String) {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val currentUserUid = currentUser?.uid

            // Update the reactType and count in the database
            val commentRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
                .child("Comments").child(commentKey)

            currentUserUid?.let {
                val userReactRef = commentRef.child("ReactComment").child(it)

                // Fetch the current reactType to determine whether to set or remove the reaction
                userReactRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val currentReactType = snapshot.getValue(String::class.java)

                        // Toggle the state based on the current reactType
                        when (currentReactType) {
                            reactType -> {
                                // If the current reactType is the same as the new one, remove the reaction
                                userReactRef.removeValue()
                                updateReactCounts(commentRef)
                            }
                            else -> {
                                // If the current reactType is different, set the new reaction
                                userReactRef.setValue(reactType)
                                updateReactCounts(commentRef)
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle onCancelled as needed
                    }
                })
            }
        }

        private fun updateDrawable(postKey: String, commentKey: String) {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val currentUserUid = currentUser?.uid

            // Fetch the reactType from the database
            val reactRef = FirebaseDatabase.getInstance().getReference("Forum_Post").child(postKey)
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