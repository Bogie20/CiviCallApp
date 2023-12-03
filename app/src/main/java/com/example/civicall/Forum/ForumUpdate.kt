package com.example.civicall.Forum

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.civicall.NetworkUtils
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.example.civicall.databinding.ActivityForumUpdateBinding
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class ForumUpdate: AppCompatActivity() {

    private lateinit var updateImage: ImageView
    private lateinit var updateButton: Button
    private lateinit var updatePostText: EditText
    private lateinit var cardImage: CardView
    private lateinit var updateCampus: AutoCompleteTextView
    private lateinit var updateCategory: AutoCompleteTextView
    private lateinit var networkUtils: NetworkUtils
    private var text: String = ""
    private var imageUrl: String = ""
    private var key: String = ""
    private var oldImageURL: String = ""
    private var campus: String = ""
    private var category: String = ""
    private var uri: Uri? = null
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var binding: ActivityForumUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForumUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateButton = binding.updateButton
        updateImage = binding.updateImage
        updatePostText = binding.updatePostText
        updateCampus = binding.updateCampus
        cardImage = binding.cardImage
        updateCategory = binding.updateCategory
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        binding.backbtn.setOnClickListener {
            super.onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        updateCategory.setOnClickListener {
            showCategorySelectionDialog()
        }
        updateCampus.setOnClickListener {
            showCampusSelectionDialog()
        }

        val activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                uri = data?.data
                updateImage.setImageURI(uri)
            } else {
                Toast.makeText(this@ForumUpdate, "No Image Selected", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        val bundle = intent.extras
        if (bundle != null) {
            Glide.with(this@ForumUpdate).load(bundle.getString("PostImage")).into(updateImage)
            updateCategory.setText(bundle.getString("Category"))
            updateCampus.setText(bundle.getString("Campus"))
            updatePostText.setText(bundle.getString("PostText"))
            key = bundle.getString("Key")!!
            oldImageURL = bundle.getString("PostImage")!!

            if (oldImageURL.isNotEmpty()) {
                Glide.with(this@ForumUpdate).load(bundle.getString("PostImage")).into(updateImage)
            } else {
                cardImage.visibility = View.GONE
            }
        }
        databaseReference =
            FirebaseDatabase.getInstance().getReference("Forum Post").child(key)

        updateImage.setOnClickListener {
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }
        updateButton.setOnClickListener {
            showUpdateConfirmation()

        }
    }
    private fun saveData() {
        val builder = AlertDialog.Builder(this@ForumUpdate)
        builder.setCancelable(false)
        val inflater = layoutInflater
        val loadingLayout = inflater.inflate(R.layout.loading_layout, null)
        builder.setView(loadingLayout)
        val dialog = builder.create()

        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()

        if (uri != null) {
            storageReference = FirebaseStorage.getInstance().reference.child("Forum Post Images")
                .child(uri?.lastPathSegment!!)

            storageReference.putFile(uri!!)
                .addOnSuccessListener { taskSnapshot ->
                    // Use the new method to get the download URL
                    taskSnapshot.storage.downloadUrl.addOnSuccessListener { url ->
                        imageUrl = url.toString()
                        updateData()
                    }
                }
                .addOnFailureListener { e ->
                    dialog.dismiss()
                    // Handle the image upload failure, e.g., show an error message
                    Toast.makeText(
                        this@ForumUpdate,
                        "Image upload failed: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        } else {
            updateData()
        }

    }
    private fun showCampusSelectionDialog() {
        val campuscategoryArray = resources.getStringArray(R.array.allowed_campuses)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select Campus")
        builder.setItems(campuscategoryArray) { _, which ->
            val selectedCampus = campuscategoryArray[which]
            updateCampus.setText(selectedCampus)
        }

        val alertDialog = builder.create()

        // Apply window animations and background styling here
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        alertDialog.show()
    }

    private fun showCategorySelectionDialog() {
        val categoryArray = resources.getStringArray(R.array.engagement_category)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select Category")
        builder.setItems(categoryArray) { _, which ->
            val selectedCategory = categoryArray[which]
            updateCategory.setText(selectedCategory)
        }

        val alertDialog = builder.create()

        // Apply window animations and background styling here
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        alertDialog.show()
    }
    private fun updateData() {
        text = updatePostText.text.toString().trim()
        campus = updateCampus.text.toString()
        category = updateCategory.text.toString()

        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid
        val postTime = getCurrentDateTime()
        if (uri != null) {

            val dataClass = DataClassForum(
                uploadersId,
                category,
                text,
                imageUrl,
                campus,
                false,
                postTime,
                0,
                null,
                0,
                0

            )

            databaseReference.setValue(dataClass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        if (oldImageURL.isNotEmpty() && imageUrl != oldImageURL) {
                            // Delete the old image
                            val reference =
                                FirebaseStorage.getInstance().getReferenceFromUrl(oldImageURL)
                            reference.delete()
                        }
                        Toast.makeText(this@ForumUpdate, "Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }.addOnFailureListener { e ->
                    Toast.makeText(this@ForumUpdate, e.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
        } else {

            val dataClass = DataClassForum(
                uploadersId,
                category,
                text,
                oldImageURL,
                campus,
                false,
                postTime,
                0,
                null,
                0,
                0
            )
            databaseReference.setValue(dataClass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@ForumUpdate, "Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }.addOnFailureListener { e ->
                    Toast.makeText(this@ForumUpdate, e.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
        }
    }
    private fun getCurrentDateTime(): String {
        val timeZone = TimeZone.getTimeZone("Asia/Manila")
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        simpleDateFormat.timeZone = timeZone
        return simpleDateFormat.format(Date())
    }
    private var isSaveConfirmationDialogShowing = false // Add this variable

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
