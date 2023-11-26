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
import java.util.Locale
import java.util.TimeZone

class ForumUpdate: AppCompatActivity() {

    private lateinit var updateImage: ImageView
    private lateinit var updateButton: Button
    private lateinit var updateTitle: EditText
    private lateinit var updateFundCollected: EditText
    private lateinit var updateActivePoints: EditText
    private lateinit var updateCampus: AutoCompleteTextView
    private lateinit var updateCategory: AutoCompleteTextView
    private lateinit var networkUtils: NetworkUtils
    private var title: String = ""
    private var activepoints: Int = 0
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
        updateTitle = binding.updateTitle
        updateFundCollected = binding.updateFundCollected
        updateActivePoints = binding.updateActivePoints
        updateActivePoints.inputType = InputType.TYPE_CLASS_NUMBER
        updateCampus = binding.updateCampus
        updateCategory = binding.updateCategory
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        binding.backbtn.setOnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        val paymentDropdown = binding.updatePaymentMethod
        val paymentArray = resources.getStringArray(R.array.payment_category)
        val adapterpayment = ArrayAdapter(this, R.layout.dropdown_item, paymentArray)
        (paymentDropdown as? AutoCompleteTextView)?.setAdapter(adapterpayment)

        val categoryDropdown = binding.updateCategory
        val categoryArray = resources.getStringArray(R.array.engagement_category)
        val adaptercategory = ArrayAdapter(this, R.layout.dropdown_item, categoryArray)
        (categoryDropdown as? AutoCompleteTextView)?.setAdapter(adaptercategory)

        val paymentMethodLayout = binding.PaymentTextInputLayout
        val paymentRecipientLayout = binding.PaymentRecepientTextInputLayout

        categoryDropdown.setOnItemClickListener { _, _, position, _ ->
            val selectedCategory = categoryArray[position]

            if (selectedCategory == "Fund Raising" || selectedCategory == "Donations") {
                paymentMethodLayout.visibility = View.VISIBLE
                paymentRecipientLayout.visibility = View.VISIBLE
            } else {
                paymentMethodLayout.visibility = View.GONE
                paymentRecipientLayout.visibility = View.GONE
            }
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
            updateTitle.setText(bundle.getString("PostText"))
            updateActivePoints.setText(bundle.getString("ActivePoints"))
            key = bundle.getString("Key")!!
            oldImageURL = bundle.getString("PostImage")!!
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

            storageReference.putFile(uri!!).addOnSuccessListener { taskSnapshot ->
                val uriTask = taskSnapshot.storage.downloadUrl
                while (!uriTask.isComplete);
                val urlImage = uriTask.result
                imageUrl = urlImage.toString()

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
        }
        updateData()
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


    private fun updateData() {
        title = updateTitle.text.toString().trim()
        campus = updateCampus.text.toString()
        activepoints = updateActivePoints.text.toString().toInt()
        category = updateCategory.text.toString()
        val fundcollected = if (updateFundCollected.text.isNullOrBlank()) 0.0 else updateFundCollected.text.toString().toDouble()


        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid
        if (uri != null) {

            val dataClass = DataClassForum(
                uploadersId,
                category,
                title,
                imageUrl,
                campus,
                activepoints,
                fundcollected,
                false
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
                title,
                oldImageURL,
                campus,
                activepoints,
                fundcollected,
                false
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
            // User clicked "Cancel," do nothing or provide feedback
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
