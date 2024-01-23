package com.example.civicall.Forum

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
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
import android.widget.CheckBox
import android.widget.EditText
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
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.SplashActivity
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
    private val REQUEST_CAMERA_PERMISSION = 2
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
            checkAndRequestPermissions(true)
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
                handleDatabaseError(error)
                }
            })
        }
        val selectCampus: RelativeLayout = findViewById(R.id.relativeSelect)
        selectCampus.setOnClickListener {
            showCheckBoxCampus()
        }

        val categoryDropdown = binding.uploadCategory
        val categoryArray = resources.getStringArray(R.array.engagement_category)
        val adaptercategory = ArrayAdapter(this, R.layout.dropdown_item, categoryArray)
        (categoryDropdown as? AutoCompleteTextView)?.setAdapter(adaptercategory)


        val fabGallery = findViewById<FloatingActionButton>(R.id.galleryButton)

        fabGallery.setOnClickListener {
            checkAndRequestPermissions(false)
        }

        saveButton.setOnClickListener {
            if (networkUtils.isOnline) {
                // Check verification status or perform other actions
                val auth = FirebaseAuth.getInstance()
                val currentUser = auth.currentUser
                if (currentUser != null) {
                    val uid = currentUser.uid

                    val currentUserRef =
                        FirebaseDatabase.getInstance().getReference("Users").child(uid)

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
                          handleDatabaseError(error)
                        }
                    })
                }
            } else {
                if (!isNoInternetDialogShowing) {
                    dismissCustomDialog()
                    showNoInternetPopup()
                }
            }
        }
    }
    private fun handleDatabaseError(databaseError: DatabaseError) {
        val errorMessage = "Database error: ${databaseError.message}"

        Log.e("ForumUpload", errorMessage)

        Toast.makeText(this@ForumUpload, errorMessage, Toast.LENGTH_SHORT).show()
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

    private fun launchGalleryIntent() {
        val photoPicker = Intent(Intent.ACTION_GET_CONTENT)
        photoPicker.type = "image/*"
        activityResultLauncher.launch(photoPicker)
    }
    private val activityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
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

    private fun checkAndRequestPermissions(isCameraRequest: Boolean) {
        val requestCode =
            if (isCameraRequest) REQUEST_CAMERA_PERMISSION else REQUEST_IMAGE_PICK

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
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                requestCode
            )
        } else {
            // Permission already granted, proceed with launching the appropriate intent
            if (isCameraRequest) {
                takePicture()
            } else {
                launchGalleryIntent()
            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CAMERA_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Camera permission granted, proceed with taking a picture
                    takePicture()
                } else {
                    // Camera permission denied, handle accordingly
                    Toast.makeText(
                        this,
                        "Camera Permission denied. Go to your Phone Setting to Allow it.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            REQUEST_IMAGE_PICK -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Gallery permission granted, proceed with launching the gallery intent
                    launchGalleryIntent()
                } else {
                    // Gallery permission denied, handle accordingly
                    Toast.makeText(
                        this,
                        "Camera Permission denied. Go to your Phone Setting to Allow it.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
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
    private var isCampusDialogShowing = false

    private fun showCheckBoxCampus() {
        if (isCampusDialogShowing) {
            return
        }

        val dialogView = layoutInflater.inflate(R.layout.multiple_checkbox_selection, null)
        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val btnSelectCampus = dialogView.findViewById<Button>(R.id.btnSelectCampus)
        val closeIcon = dialogView.findViewById<ImageView>(R.id.closeIcon) // Add this line

        val checkBoxes = ArrayList<CheckBox>()

        // Iterate from 1 to 11 (excluding checkBox12)
        for (i in 1 until 12) {
            val checkBoxId = resources.getIdentifier("checkBox$i", "id", packageName)
            val checkBox = dialogView.findViewById<CheckBox>(checkBoxId)
            checkBoxes.add(checkBox)
        }

        // Find the checkBox12 by ID
        val checkBox12 = dialogView.findViewById<CheckBox>(R.id.checkBox12)

        // Set a listener for checkBox12 to select all checkboxes
        checkBox12.setOnCheckedChangeListener { _, isChecked ->
            checkBoxes.forEach { it.isChecked = isChecked }
        }

        // Check previously selected campuses and update the checkboxes
        val selectedCampuses = binding.campusPick.text.toString().split(", ")
        for (checkBox in checkBoxes) {
            checkBox.isChecked = selectedCampuses.contains(checkBox.text.toString())
        }

        btnSelectCampus.setOnClickListener {
            val selectedCampuses = checkBoxes.filter { it.isChecked }.map { it.text.toString() }
            val selectedCampusesText = selectedCampuses.joinToString(", ")

            // Set the selected campuses in the AutoCompleteTextView
            binding.campusPick.setText(selectedCampusesText)

            alertDialog.dismiss()
        }

        // Add click listener to closeIcon to dismiss the dialog
        closeIcon.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialog.setOnDismissListener {
            isCampusDialogShowing = false
        }
        alertDialog.show()
        isCampusDialogShowing = true
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
        if (isNoInternetDialogShowing) {
            isNoInternetDialogShowing = false
        }
    }

    private fun saveData() {
        if (isFinishing) {
            // Activity is finishing, do not proceed with saving data
            return
        }

        if (uploadPostText.text.isNullOrBlank() || binding.uploadCategory.text.isNullOrBlank()) {
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
            val fileName = System.currentTimeMillis().toString() + "_forumImage"
            val storageReference = FirebaseStorage.getInstance().getReference()
                .child("Forum Post Images").child(fileName)

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
                    if (isFinishing) {
                        // Activity is finishing, do not proceed
                        dialog.dismiss()
                        return@addOnSuccessListener
                    }

                    val uriTask = taskSnapshot.storage.downloadUrl
                    while (!uriTask.isComplete);
                    val urlImage = uriTask.result
                    val imageUrl = urlImage.toString()

                    // Proceed to upload other data along with the image URL
                    uploadData(imageUrl)
                    dialog.dismiss()
                }
                .addOnFailureListener { e ->
                    if (isFinishing) {
                        // Activity is finishing, do not proceed
                        dialog.dismiss()
                        return@addOnFailureListener
                    }

                    dialog.dismiss()
                    Toast.makeText(
                        this@ForumUpload,
                        "Failed to upload image: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }

    private fun sendPushNotification(category: String) {
        val title = "You Successfully Posted in Forum"
        val body = "About: $category"

        val notificationId = System.currentTimeMillis().toInt()

        // Create an intent that opens your main activity
        val intent = Intent(this, SplashActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        val channelId = "confirm_channel"
        val channelName = "Confirmation"

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)  // Removes the notification when clicked

        // Check if body is not null or empty before using BigTextStyle
        if (!body.isNullOrBlank()) {
            val bigTextStyle = NotificationCompat.BigTextStyle()
                .bigText(body)
            notificationBuilder.setStyle(bigTextStyle)
        }

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Always create the NotificationChannel on devices running Android Oreo and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Display the notification
        notificationManager.notify(notificationId, notificationBuilder.build())
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
                    0,
                    null,
                    0,
                    0
                )

                FirebaseDatabase.getInstance().getReference("Forum Post").child(postKey)
                    .setValue(dataClass)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this@ForumUpload, "Success", Toast.LENGTH_SHORT)
                                .show()
                            finish()
                            sendPushNotification(uploadCategory.text.toString())
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
        val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        simpleDateFormat.timeZone = timeZone
        return simpleDateFormat.format(Date())
    }

    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
}