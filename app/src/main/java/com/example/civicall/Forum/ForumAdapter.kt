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
    import android.widget.ImageButton
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
                val commentsRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
                    .child("Comments")

                commentsRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val commentCount = snapshot.childrenCount.toInt()

                        // Assuming holder.adapterPosition is the position of the item in the adapter
                        if (holder.adapterPosition != RecyclerView.NO_POSITION) {
                            val data = dataList[holder.adapterPosition]
                            data.commentCount = commentCount

                            // Update the UI in the corresponding ViewHolder
                            holder.updateCommentCount(commentCount)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle onCancelled as needed
                    }
                })
            }
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
            holder.updateTimeText(data.postTime)
            fetchCommentCount(data.key, holder)
            holder.updateReactButtons(data.key ?: "")
            holder.updateReactCountUI(data.upReactCount, data.downReactCount)
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
        val commentCountTextView: TextView = itemView.findViewById(R.id.commentcount)
        val upReact: ImageButton = itemView.findViewById(R.id.upBtn)
        val downReact: ImageButton = itemView.findViewById(R.id.downBtn)
        val upCount: TextView = itemView.findViewById(R.id.up_count)
        val downCount: TextView = itemView.findViewById(R.id.down_count)
        fun updateFABVisibility(data: DataClassForum, isCurrentUserPost: Boolean) {
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
        fun updateReactButtons(postKey: String) {
            upReact.setOnClickListener {
                // Handle up react
                handleReact(postKey, "up")
            }

            downReact.setOnClickListener {
                // Handle down react
                handleReact(postKey, "down")
            }

            // Update the drawable based on the reactType
            updateDrawable(postKey)
        }
        private fun handleReact(postKey: String, reactType: String) {
            val currentUser = FirebaseAuth.getInstance().currentUser
            val currentUserUid = currentUser?.uid

            // Update the reactType in the database
            val reactRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey).child("React")
            currentUserUid?.let {
                val userReactRef = reactRef.child(it)

                // Fetch the current reactType to determine whether to set or remove the reaction
                userReactRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val currentReactType = snapshot.getValue(String::class.java)

                        // Check if the user has already reacted with the same type
                        if (currentReactType == reactType) {
                            // User wants to unselect the reaction, so remove the reactType from the database
                            userReactRef.removeValue()
                        } else {
                            // User wants to select a new reaction or change the current one
                            userReactRef.setValue(reactType)
                        }

                        // Update the drawable after successful update
                        updateDrawable(postKey)

                        // Update the react counts
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

            // Fetch the reactType from the database
            val reactRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey).child("React")
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
        fun updateReactCountUI(upReactCount: Int, downReactCount: Int) {
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

        private fun updateReactCounts(postKey: String) {
            val reactRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey).child("React")

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

                    // Update the up and down react counts in the database
                    val postRef = FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
                    postRef.child("upReactCount").setValue(upReactCount)
                    postRef.child("downReactCount").setValue(downReactCount)

                    // Update the UI with the new counts
                    updateReactCountUI(upReactCount, downReactCount)
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle onCancelled as needed
                }
            })
        }
        fun updateCommentCount(commentCount: Int) {
            commentCountTextView.text = formatCount(commentCount)
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
