package com.example.civicall.Forum

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.Users
import com.example.civicall.databinding.ActivityForumUploadBinding
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class ForumUpload : AppCompatActivity() {
    private val REQUEST_CAMERA_PERMISSION = 1
    private val FILE_PROVIDER_AUTHORITY = "com.example.civicall.fileprovider"
    private var capturedImageUri: Uri? = null
    private val REQUEST_IMAGE_CAPTURE = 2
    private val REQUEST_IMAGE_PICK = 3
    private lateinit var uploadPostImage: ImageView
    private lateinit var saveButton: Button
    private lateinit var cardImage: CardView
    private lateinit var fabMenu: FloatingActionMenu
    private lateinit var uploadPostText: EditText
    private lateinit var uploadCategory: AutoCompleteTextView
    private var imageURL: String? = null
    private var uri: Uri? = null
    private lateinit var binding: ActivityForumUploadBinding
    private lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForumUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uploadPostImage = binding.uploadPostImage
        cardImage = binding.cardImage
        uploadCategory = binding.uploadCategory
        uploadPostText = binding.uploadPostText
        saveButton = binding.uploadButton
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        fabMenu = findViewById(R.id.fabMenu)
        cardImage.visibility = View.GONE
        val bodyLayout: LinearLayout = findViewById(R.id.linearbody)

        bodyLayout.setOnClickListener {
            fabMenu.close(true)
        }
        binding.backbtn.setOnClickListener {
            super.onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        val profilePic: ImageView = findViewById(R.id.profilePic)
        val uploaderName: TextView = findViewById(R.id.uploaderName)
        val fabCamera: FloatingActionButton = findViewById(R.id.cameraButton)

        fabCamera.setOnClickListener {
            takePicture()
            checkAndRequestPermissions()
        }
        val auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val uid = currentUser.uid
            val currentUserRef = FirebaseDatabase.getInstance().getReference("Users").child(uid)
            currentUserRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val userData = snapshot.getValue(Users::class.java)
                        if (userData != null) {
                            Glide.with(this@ForumUpload)
                                .load(userData.ImageProfile)
                                .placeholder(R.drawable.user)
                                .error(R.drawable.user)
                                .into(profilePic)
                            // Set firstname with lastname
                            val fullName = "${userData.firstname} ${userData.lastname}"
                            uploaderName.text = fullName
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle the error as needed
                }
            })
        }
        val selectCampus: RelativeLayout = findViewById(R.id.relativeSelect)
        val campusPickTextView: TextView = findViewById(R.id.campusPick)
        val campusArray = resources.getStringArray(R.array.allowed_campuses)
        val popupMenu = PopupMenu(this, selectCampus)
        campusArray.forEach { campus ->
            popupMenu.menu.add(campus)
        }
        selectCampus.setOnClickListener {
            popupMenu.setOnMenuItemClickListener { menuItem ->
                campusPickTextView.text = menuItem.title
                true
            }
            popupMenu.show()
        }

        val categoryDropdown = binding.uploadCategory
        val categoryArray = resources.getStringArray(R.array.engagement_category)
        val adaptercategory = ArrayAdapter(this, R.layout.dropdown_item, categoryArray)
        (categoryDropdown as? AutoCompleteTextView)?.setAdapter(adaptercategory)

        val activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                uri = data?.data
                if (uri != null) {
                    uploadPostImage.setImageURI(uri)
                    cardImage.visibility = View.VISIBLE
                }
            } else {
                Toast.makeText(this@ForumUpload, "No Image Selected", Toast.LENGTH_SHORT).show()
            }
        }


        val fabIcon = findViewById<FloatingActionButton>(R.id.fabicon)

        fabIcon.setOnClickListener {
            val photoPicker = Intent(Intent.ACTION_GET_CONTENT)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }

        saveButton.setOnClickListener {
            val auth = FirebaseAuth.getInstance()
            val currentUser = auth.currentUser
            if (currentUser != null) {
                val uid = currentUser.uid

                // Now you can use the uid in your Firebase Database reference
                val currentUserRef = FirebaseDatabase.getInstance().getReference("Users").child(uid)

                currentUserRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val verificationStatus =
                            snapshot.child("verificationStatus").getValue(Boolean::class.java)

                        if (verificationStatus == false) {
                            showMessage(
                                "Please verify your account before uploading",
                                4000,
                                "Oops!",
                                R.drawable.notverifiedshield,
                                R.layout.dialog_sadface
                            )
                        } else {
                            showConfirmationDialog()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // Handle the error as needed
                    }
                })
            } else {
                // Handle the case where the user is not signed in
                // You might want to redirect the user to the login screen or perform some other action
            }
        }
    }
    private fun checkAndRequestPermissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CAMERA_PERMISSION
            )
        }
    }
    private fun takePicture() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (cameraIntent.resolveActivity(packageManager) != null) {

            val photoFile: File? = try {
                createImageFile()
            } catch (ex: IOException) {
                Log.e("UploadVerificationFile", "Error creating image file", ex)
                null
            }
            photoFile?.let {
                val photoURI: Uri = FileProvider.getUriForFile(
                    this,
                    FILE_PROVIDER_AUTHORITY,
                    it
                )
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)

                capturedImageUri = photoURI
                startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Check if the capturedImageUri is not null
            capturedImageUri?.let {
                // The image has been captured successfully, load it into the uploadPostImage ImageView
                Glide.with(this).load(it).into(uploadPostImage)
                cardImage.visibility = View.VISIBLE
                // Assign capturedImageUri to uri
                uri = it
            }
        }
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK) {
            data?.data?.let {
                uri = it
                // Load the selected image into the uploadPostImage ImageView
                Glide.with(this).load(uri).into(uploadPostImage)
                cardImage.visibility = View.VISIBLE
            }
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${System.currentTimeMillis()}_",
            ".jpg",
            storageDir
        )
    }
    private var isAlreadyJoinDialogShowing = false

    private fun showMessage(
        message: String,
        durationMillis: Long,
        customSlideTitle: String?,
        customDialogImageResId: Int?,
        customDialogLayoutResId: Int?
    ) {
        if (isAlreadyJoinDialogShowing) {
            return
        }
        dismissCustomDialog()

        // Use the custom layout resource ID if provided, otherwise use the default
        val dialogView =
            layoutInflater.inflate(customDialogLayoutResId ?: R.layout.dialog_happyface, null)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val slideTitle: AppCompatTextView = dialogView.findViewById(R.id.dialog_title_emotion)
        val dialogImage: AppCompatImageView = dialogView.findViewById(R.id.img_icon_emotion)
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationSlideLeft
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // Use custom slideTitle if provided, otherwise use the default
        slideTitle.text = customSlideTitle ?: "Verifying Account"

        val messageTextView = dialogView.findViewById<TextView>(R.id.dialog_message)
        messageTextView.text = message
        alertDialog.show()

        // Use custom dialogImage if provided, otherwise use the default
        dialogImage.setImageResource(customDialogImageResId ?: R.drawable.papermani)

        isAlreadyJoinDialogShowing = true
        alertDialog.setOnDismissListener {
            isAlreadyJoinDialogShowing = false
        }
        Handler(Looper.getMainLooper()).postDelayed({
            alertDialog.dismiss()
            isAlreadyJoinDialogShowing = false
        }, durationMillis)
    }

    private var isSaveConfirmationDialogShowing = false

    private fun showConfirmationDialog() {
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
        logoutMsg.text = "Are you certain you want to proceed with this upload?"

        saveBtn.text = "Yes"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()
            saveData()
        }
        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isSaveConfirmationDialogShowing = false
            alertDialog.dismiss()
        }
        alertDialog.setOnDismissListener {
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

    private fun saveData() {
        if (uploadPostText.text.isNullOrBlank() ||
            binding.uploadCategory.text.isNullOrBlank()
        ) {
            Toast.makeText(
                this@ForumUpload,
                "Please fill in all the required information",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        // Check if the campus is selected
        if (binding.campusPick.text.toString().equals("Select a Campus", ignoreCase = true)) {
            Toast.makeText(
                this@ForumUpload,
                "Please select a campus",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        // Check if an image is selected
        if (uri == null) {
            // No image selected, proceed without uploading an image
            uploadData(null)
        } else {
            // Image is selected, proceed with image upload
            val storageReference = FirebaseStorage.getInstance().getReference()
                .child("Forum Post Images").child(uri?.lastPathSegment!!)

            val builder = AlertDialog.Builder(this@ForumUpload)
            builder.setCancelable(false)
            val inflater = layoutInflater
            val loadingLayout = inflater.inflate(R.layout.loading_layout, null)
            builder.setView(loadingLayout)
            val dialog = builder.create()

            dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.show()

            storageReference.putFile(uri!!)
                .addOnSuccessListener { taskSnapshot ->
                    val uriTask = taskSnapshot.storage.downloadUrl
                    while (!uriTask.isComplete);
                    val urlImage = uriTask.result
                    imageURL = urlImage.toString()

                    // Proceed to upload other data along with the image URL
                    uploadData(imageURL)
                }
                .addOnFailureListener { e ->
                    dialog.dismiss()
                    Toast.makeText(
                        this@ForumUpload,
                        "Failed to upload image: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }

    private fun uploadData(imageUrl: String?) {
        val postText = uploadPostText.text.toString()
        val campus = binding.campusPick.text.toString()
        val category = binding.uploadCategory.text.toString()

        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid

        if (uploadersId != null) {
            val postKey =
                FirebaseDatabase.getInstance().getReference("Forum Post").push().key

            if (postKey != null) {
                val postTime = getCurrentDateTime()
                val dataClass = DataClassForum(
                    uploadersId,
                    category,
                    postText,
                    imageUrl.orEmpty(),
                    campus,
                    false,
                    postTime,
                    0
                )

                FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
                    .setValue(dataClass)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this@ForumUpload, "Success", Toast.LENGTH_SHORT)
                                .show()
                            finish()
                        }
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(
                            this@ForumUpload,
                            e.message.toString(),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
            }
        }
    }
    private fun getCurrentDateTime(): String {
        val timeZone = TimeZone.getTimeZone("Asia/Manila")
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        simpleDateFormat.timeZone = timeZone
        return simpleDateFormat.format(Date())
    }

    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
}