package com.example.civicall.Forum

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.databinding.ActivityCommentEditBinding
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CommentEdit: AppCompatActivity() {

    private lateinit var updateButton: Button
    private lateinit var updatePostComment: EditText
    private lateinit var networkUtils: NetworkUtils
    private var text: String = ""
    private var key: String = ""
    private lateinit var databaseReference: DatabaseReference
    private lateinit var binding: ActivityCommentEditBinding

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
            key = bundle.getString("Key")!!
        }
        databaseReference =
            FirebaseDatabase.getInstance().getReference("Forum Post").child(key)

        updateButton.setOnClickListener {
            showUpdateConfirmation()

        }
    }
    private fun saveData() {
        val builder = AlertDialog.Builder(this@CommentEdit)
        builder.setCancelable(false)
        val inflater = layoutInflater
        val loadingLayout = inflater.inflate(R.layout.loading_layout, null)
        builder.setView(loadingLayout)
        val dialog = builder.create()

        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()

            updateData()

    }

    private fun updateData() {
        text = updatePostComment.text?.toString()?.trim() ?: ""

        val user = FirebaseAuth.getInstance().currentUser
        val commenterUID = user?.uid

        if (text != null) {

            val dataClass = DataComment(
                text,
                commenterUID,
                null,
                null,
                0,
                0,
                null,
                false,
                mapOf(),
            )

            databaseReference.setValue(dataClass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@CommentEdit, "Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }.addOnFailureListener { e ->
                    Toast.makeText(this@CommentEdit, e.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
        }
    }

    private var isSaveConfirmationDialogShowing = false

    private fun showUpdateConfirmation() {
        if (isSaveConfirmationDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.dialog_confirmation, null)
        val alertDialog = AlertDialog.Builder(this)
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
            dismissCustomDialog()

            saveData()
        }
        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isSaveConfirmationDialogShowing = false // Reset the flag
            alertDialog.dismiss()
        }
        alertDialog.setOnDismissListener{
            isSaveConfirmationDialogShowing = false
        }

        alertDialog.show()
        isSaveConfirmationDialogShowing =
            true
    }
    private fun dismissCustomDialog() {
        if (isSaveConfirmationDialogShowing) {

            isSaveConfirmationDialogShowing = false
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
}
