package com.example.civicall.Forum

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityCommentEditBinding
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CommentEdit : AppCompatActivity() {

    private lateinit var binding: ActivityCommentEditBinding
    private lateinit var updateButton: Button
    private lateinit var updatePostComment: EditText
    private lateinit var networkUtils: NetworkUtils
    private lateinit var databaseReference: DatabaseReference
    private var progressDialog: ProgressDialog? = null

    private var text: String = ""
    private var commentKey: String = ""
    private var postKey: String = ""
    private var commentTime: String = ""
    private var upReact: Int = 0
    private var downReact: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateButton = binding.updateButton
        updatePostComment = binding.updatePostComment
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        binding.backbtn.setOnClickListener {
            super.onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val bundle = intent.extras
        if (bundle != null) {
            updatePostComment.setText(bundle.getString("CommentText"))
            commentKey = bundle.getString("CommentKey")!!
            commentTime = bundle.getString("CommentTime")!!
            upReact = bundle.getInt("UpCount", 0)
            downReact = bundle.getInt("DownCount", 0)
            postKey = CommentAdapter.DataRepository.currentPostKey ?: ""
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Forum_Post")
            .child(postKey).child("Comments").child(commentKey)

        updateButton.setOnClickListener {
            if (networkUtils.isOnline) {
                showUpdateConfirmation()
            } else {
                if (!isNoInternetDialogShowing) {
                    dismissCustomDialog()
                    showNoInternetPopup()
                }
            }
        }
    }
    private fun dismissCustomDialog() {
        if (isNoInternetDialogShowing) {

            isNoInternetDialogShowing = false
        }

    }

    private var isNoInternetDialogShowing = false
    private fun showNoInternetPopup() {
        isNoInternetDialogShowing = true
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_network, null)
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        view.findViewById<Button>(R.id.retryBtn).setOnClickListener {
            dialog.dismiss()
            isNoInternetDialogShowing = false
        }
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
        dialog.setOnDismissListener {
            isNoInternetDialogShowing = false
        }
        dialog.show()
    }

    private fun saveData() {
        val builder = AlertDialog.Builder(this@CommentEdit)
        builder.setCancelable(false)
        val loadingLayout = layoutInflater.inflate(R.layout.loading_layout, null)
        builder.setView(loadingLayout)
        val dialog = builder.create()

        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()

        text = updatePostComment.text.toString().trim()

        val user = FirebaseAuth.getInstance().currentUser
        val commenterUID = user?.uid

        if (text.isNotEmpty()) {
            val dataClass = DataComment(
                text,
                commenterUID,
                commentTime,
                commentKey,
                upReact,
                downReact,
                null,
                false,
                mapOf()
            )

            databaseReference.setValue(dataClass)
                .addOnCompleteListener { task ->
                    dialog.dismiss()
                    if (task.isSuccessful) {
                        Toast.makeText(this@CommentEdit, "Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(
                            this@CommentEdit,
                            task.exception?.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        } else {
            Toast.makeText(this@CommentEdit, "Please enter a valid comment", Toast.LENGTH_SHORT)
                .show()
            dialog.dismiss()
        }
    }


    private fun showUpdateConfirmation() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_confirmation, null)
        val alertDialog = AlertDialog.Builder(this@CommentEdit)
            .setView(dialogView)
            .create()

        val confirmTitle: AppCompatTextView = dialogView.findViewById(R.id.ConfirmTitle)
        val logoutMsg: AppCompatTextView = dialogView.findViewById(R.id.logoutMsg)
        val saveBtn: MaterialButton = dialogView.findViewById(R.id.saveBtn)
        val cancelBtn: MaterialButton = dialogView.findViewById(R.id.cancelBtn)

        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        confirmTitle.text = "Confirmation"
        logoutMsg.text = "Are you sure you want to update this post?"

        saveBtn.text = "Update"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            saveData()
        }

        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.setOnDismissListener {
            // Handle dismissal if needed
        }

        alertDialog.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        progressDialog?.dismiss()
        networkUtils.cleanup()
    }
}
