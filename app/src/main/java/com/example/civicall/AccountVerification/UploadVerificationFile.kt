package com.example.civicall.AccountVerification

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
import android.provider.OpenableColumns
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.civicall.MainMenu
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.SplashActivity
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

class UploadVerificationFile : AppCompatActivity() {
    private var fileUri: Uri? = null
    private lateinit var filenameTextView: TextView
    private val REQUEST_CAMERA_PERMISSION = 1
    private val FILE_PROVIDER_AUTHORITY = "com.example.civicall.fileprovider"
    private var hasUserUploadedVerification = false
    private val REQUEST_IMAGE_CAPTURE = 2
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_verification_file)
        filenameTextView = findViewById(R.id.filename)
        val uploadImage = findViewById<Button>(R.id.uploadcamera)
        val uploadFileButton = findViewById<TextView>(R.id.underlineTextView)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val backbtn = findViewById<ImageView>(R.id.backbtn)
        FirebaseStorage.getInstance()
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        val sendBtn = findViewById<TextView>(R.id.sendbtn)
        sendBtn.setOnClickListener {
            // Get the ID of the selected radio button from the radio group
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId

            // Check if no radio button is selected
            if (selectedRadioButtonId == -1) {
                // Show a message if no radio button is selected
                showMessage(
                    "Select a Type of Document to Upload",
                    3000,
                    "Select First",
                    R.drawable.selectdocu,
                    R.layout.dialog_sadface
                )
            } else {
                // Check if a file has been selected
                val fileName = filenameTextView.text.toString()
                if (fileName.isNotEmpty()) {
                    // If a file is selected, get the selected category

                    // Replace this line with your actual logic to get the selected category
                    val selectedCategory = getSelectedCategory()

                    // Check if the device is online
                    if (networkUtils.isOnline) {
                        // If online, show upload confirmation dialog
                        showUploadConfirmationDialog(fileUri!!, fileName, selectedCategory)
                    } else {
                        // If offline, show a message indicating no internet
                        showNoInternetPopup()
                    }

                } else {
                    // Show a message if no file is selected
                    showMessage(
                        "Select a File First",
                        3000,
                        "Select First",
                        R.drawable.civicalllogo,
                        R.layout.dialog_sadface
                    )
                }
            }

            // Dismiss any custom dialog (move this line outside of the else block to ensure dismissal)
            dismissCustomDialog()
        }


        uploadFileButton.setOnClickListener {
            if (hasUserUploadedVerification) {
                showMessage(
                    "Requirement submitted already",
                    4000,
                    "Already Submitted",
                    R.drawable.papermani,
                    R.layout.dialog_happyface
                )
            } else {
                val selectedRadioButtonId = radioGroup.checkedRadioButtonId
                if (selectedRadioButtonId == -1) {
                    showMessage(
                        "Specify your file type for account verification.",
                        4000,
                        "Select First",
                        R.drawable.selectdocu,
                        R.layout.dialog_sadface
                    )
                } else {
                    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                    intent.addCategory(Intent.CATEGORY_OPENABLE)
                    intent.type = "*/*"
                    intent.putExtra(
                        Intent.EXTRA_MIME_TYPES, arrayOf(
                            "application/pdf",
                            "application/msword",
                            "application/vnd.openxmlformats-officedocument.wordprocessingml.document"

                        )
                    )
                    filePicker.launch(intent)
                }
            }
        }

        uploadImage.setOnClickListener {
            if (hasUserUploadedVerification) {
                showMessage(
                    "Requirement submitted already",
                    4000,
                    "Already Submit",
                    R.drawable.papermani,
                    R.layout.dialog_happyface
                )
            } else {
                val selectedRadioButtonId = radioGroup.checkedRadioButtonId
                if (selectedRadioButtonId == -1) {
                    showMessage(
                        "Specify your file type for account verification.",
                        4000,
                        "Select a Type",
                        R.drawable.selectdocu,
                        R.layout.dialog_sadface

                    )
                } else {

                    checkAndRequestPermissions()
                }
            }
        }
       backbtn.setOnClickListener {
           dismissCustomDialog()
           val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        onResume()
    }
    private fun sendPushNotification() {
        val title = "Confirmation"
        val body = "You have already submitted credentials for the verification of your account. Please wait until the admin verifies your account."

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

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

        // Always create the NotificationChannel on devices running Android Oreo and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        // Generate a unique notification ID
        val notificationId = System.currentTimeMillis().toInt()

        // Display the notification
        notificationManager.notify(notificationId, notificationBuilder.build())
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
    private fun checkVerificationStatus() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            val userId = currentUser.uid
            val database = FirebaseDatabase.getInstance()
            val usersRef = database.getReference("User Verification")
            val currentUserRef = usersRef.child(userId)

            currentUserRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        showMessage(
                            "Verification submitted already. Pending admin approval",
                            4000,
                            "Pending",
                            R.drawable.papermani,
                            R.layout.dialog_happyface
                        )
                        hasUserUploadedVerification = true
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    Log.e("UploadVerificationFile", "Error checking user verification status: ${error.message}")
                }
            })
        }
    }
    override fun onResume() {
        super.onResume()
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            val userId = currentUser.uid
            val database = FirebaseDatabase.getInstance()
            val usersRef = database.getReference("Users")
            val currentUserRef = usersRef.child(userId)

            currentUserRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val verificationStatus = snapshot.child("verificationStatus").getValue(Boolean::class.java)

                        if (verificationStatus != null && verificationStatus) {
                            // User is already verified, show the appropriate dialog
                            showMessage(
                                "Your Account already verified",
                                4000,
                                "Already Verified",
                                R.drawable.verifyacc,
                                R.layout.dialog_happyface
                            )
                            hasUserUploadedVerification = true
                        } else {

                            hasUserUploadedVerification = false
                        }
                    }
                    checkVerificationStatus()
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("UploadVerificationFile", "Error checking user verification status: ${error.message}")
                }
            })
        }
    }

    private var isAlreadyJoinDialogShowing = false

    private fun showMessage(
        message: String,
        durationMillis: Long,
        customSlideTitle: String?,
        customDialogImageResId: Int?,
        customDialogLayoutResId: Int?
    ) {
        if (isFinishing || isDestroyed) {
            return
        }
        if (isAlreadyJoinDialogShowing) {
            return
        }
        dismissCustomDialog()

        // Use the custom layout resource ID if provided, otherwise use the default
        val dialogView = layoutInflater.inflate(customDialogLayoutResId ?: R.layout.dialog_happyface, null)

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
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                REQUEST_CAMERA_PERMISSION
            )
        } else {
            // Permission already granted, proceed with taking a picture
            showImageDialog()
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
                    showImageDialog()
                } else {
                    // Camera permission denied, handle accordingly
                    Toast.makeText(
                        this,
                        "Camera permission denied. Go to your Phone Setting to Allow it.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }


    private var capturedImageUri: Uri? = null

    private fun chooseFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        selectImageLauncher.launch(intent)
    }

    private val selectImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            if (data != null && data.data != null) {
                capturedImageUri = data.data
                showImagePreviewDialog(capturedImageUri!!)
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


    @Throws(IOException::class)
    private fun createImageFile(): File {
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${System.currentTimeMillis()}_",
            ".jpg",
            storageDir
        )
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            capturedImageUri?.let {
                // The image has been captured successfully, show the preview dialog
                showImagePreviewDialog(it)
            }
        }
    }
    private fun showImagePreviewDialog(imageUri: Uri) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_image, null)
        val dialogIconFlat: ImageView = dialogView.findViewById(R.id.reflect_image)
        val closeButton: ImageView = dialogView.findViewById(R.id.closeIcon)
        val saveButton: Button = dialogView.findViewById(R.id.saveBtn)
        val repickButton: Button = dialogView.findViewById(R.id.cancelBtn)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogIconFlat.setImageURI(imageUri)

        closeButton.setOnClickListener {
            alertDialog.dismiss()
        }
        saveButton.setOnClickListener {
            alertDialog.dismiss()

            if (networkUtils.isOnline) {
                uploadImageToFirebase(capturedImageUri!!, getSelectedCategory())
            } else {
                if (!isNoInternetDialogShowing) {
                    dismissCustomDialog()
                    showNoInternetPopup()
                }
            }
        }
        repickButton.setOnClickListener {
            // Dismiss the current dialog
            alertDialog.dismiss()

            // Reopen the image dialog
            showImageDialog()
        }

        alertDialog.show()
    }
    private fun uploadImageToFirebase(imageUri: Uri, category: String) {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference

        val timestamp = System.currentTimeMillis().toString()
        val fileRef =
            storageRef.child("User_Verification_File/${FirebaseAuth.getInstance().currentUser?.uid ?: ""}/$category/${timestamp}_image.jpg")

        fileRef.putFile(imageUri)
            .addOnSuccessListener { uploadTask ->

                fileRef.downloadUrl.addOnSuccessListener { downloadUri ->
                    // Image uploaded successfully
                    val database = FirebaseDatabase.getInstance()
                    val usersRef = database.getReference("User Verification")
                    val currentUser = usersRef.child(
                        FirebaseAuth.getInstance().currentUser?.uid ?: ""
                    )
                    val categoryRef = currentUser.child(category)
                    val imageData = HashMap<String, Any>()
                    imageData["imageUri"] = downloadUri.toString() // Save the download URL
                    imageData["timestamp"] = timestamp // Save the timestamp
                    categoryRef.child("image").setValue(imageData)

                    sendPushNotification()
                    showMessage(
                        "Image Uploaded Successfully",
                        3000,
                        "Success",
                        R.drawable.papermani,
                        R.layout.dialog_happyface
                    )
                }
            }
            .addOnFailureListener { exception ->
                // Handle unsuccessful uploads
                Toast.makeText(this, "Image upload failed: ${exception.message}", Toast.LENGTH_SHORT)
                    .show()
            }
    }

    private var isImageDialogShowing = false // Initialize the flag

    private fun showImageDialog() {
        // Check if the dialog is already showing, and if so, return early
        if (isImageDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.profileedit_popup, null)
        val lytCameraPick = dialogView.findViewById<LinearLayout>(R.id.lytCameraPick)
        val lytGalleryPick = dialogView.findViewById<LinearLayout>(R.id.lytGalleryPick)


        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink


        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        lytCameraPick.setOnClickListener {
            takePicture()
            alertDialog.dismiss()
            isImageDialogShowing = false
        }

        lytGalleryPick.setOnClickListener {
            chooseFromGallery()
            alertDialog.dismiss()

            isImageDialogShowing = false
        }


        alertDialog.setOnDismissListener {

            isImageDialogShowing = false
        }


        alertDialog.show()
        // Set the flag to true when the dialog is displayed
        isImageDialogShowing = true
    }
    private val filePicker: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                if (data != null) {
                    fileUri = data.data
                    if (fileUri != null) {
                        val fileName = getFileDisplayName(fileUri!!)
                        val sanitizedFileName = sanitizeFileName(fileName)
                        updateSelectedFileName(sanitizedFileName)
                        updateUploadButtonText() // Add this line to update the button text
                    } else {
                        // Handle the case where fileUri is null
                    }
                }
            }
        }

    private fun updateUploadButtonText() {
        val uploadFileButton = findViewById<TextView>(R.id.underlineTextView)
        uploadFileButton.text = "Change File"
    }
    private fun getFileDisplayName(fileUri: Uri): String {
        val cursor = contentResolver.query(fileUri, null, null, null, null)
        var fileName = ""
        try {
            if (cursor != null && cursor.moveToFirst()) {
                val displayName = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                fileName = cursor.getString(displayName)
            }
        } finally {
            cursor?.close()
        }
        return fileName
    }




    private fun sanitizeFileName(fileName: String): String {
        return fileName.replace(".", "_")
    }




    private fun updateSelectedFileName(fileName: String) {
        val filenameTextInputEditText = findViewById<TextView>(R.id.filename)
        filenameTextInputEditText.setText(fileName)
    }


    private fun getSelectedCategory(): String {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(selectedRadioButtonId)
        return radioButton.text.toString()
    }
    private var isUploadConfirmationDialogShowing = false


    private fun showUploadConfirmationDialog(fileUri: Uri, fileName: String, category: String) {
        if (isUploadConfirmationDialogShowing) {
            return
        }
        dismissCustomDialog()
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog_engagement, null)
        builder.setView(dialogView)


        val confirmTitle: AppCompatTextView = dialogView.findViewById(R.id.ConfirmTitle)
        val confirmationMessage: AppCompatTextView = dialogView.findViewById(R.id.logoutMsg)
        val uploadBtn: MaterialButton = dialogView.findViewById(R.id.saveBtn)
        val cancelBtn: MaterialButton = dialogView.findViewById(R.id.cancelBtn)
        val dialogIconFlat: AppCompatImageView = dialogView.findViewById(R.id.dialog_icon_flat)


        builder.setCancelable(false)
        val dialog = builder.create()


        // Set window animations and background
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        confirmTitle.text = "Upload Confirmation"
        confirmationMessage.text = "Are you sure you want to upload the file for verification of your Account?"

        uploadBtn.text = "Upload"
        uploadBtn.setOnClickListener {
            dialog.dismiss()
            uploadFileToFirebase(fileUri, fileName, category)
        }

        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isUploadConfirmationDialogShowing = false
            dialog.dismiss()
        }


        dialogIconFlat.setImageResource(R.drawable.verificationimage)


        dialog.setOnDismissListener {
            isUploadConfirmationDialogShowing = false
        }


        if (!isFinishing) {
            dialog.show()
            isUploadConfirmationDialogShowing = true
        }
    }


    private fun dismissCustomDialog() {
        if (isUploadConfirmationDialogShowing) {


            isUploadConfirmationDialogShowing = false
        }
        if (isAlreadyJoinDialogShowing) {


            isAlreadyJoinDialogShowing = false
        }
        if (isNoInternetDialogShowing) {


            isNoInternetDialogShowing = false
        }

    }
    private fun uploadFileToFirebase(fileUri: Uri, fileName: String, category: String) {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference

        val timestamp = System.currentTimeMillis()
        val formattedTimestamp = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault()).format(
            Date(timestamp)
        )

        // Update the reference structure
        val fileRef =
            storageRef.child("User_Verification/${FirebaseAuth.getInstance().currentUser?.uid ?: ""}/$category/$fileName")

        // Upload the file to Firebase Storage
        fileRef.putFile(fileUri)
            .addOnSuccessListener { uploadTask ->
                // Get the download URL from the task
                fileRef.downloadUrl.addOnSuccessListener { downloadUri ->
                    // File uploaded successfully
                    val database = FirebaseDatabase.getInstance()
                    val usersRef = database.getReference("User Verification")
                    val currentUser = usersRef.child(
                        FirebaseAuth.getInstance().currentUser?.uid ?: ""
                    )

                    // Update the data structure
                    val categoryRef = currentUser.child(category)
                    val fileData = HashMap<String, Any>()
                    fileData["fileUri"] = downloadUri.toString() // Save the download URL
                    fileData["timestamp"] = formattedTimestamp // Save the formatted timestamp
                    categoryRef.child("file").setValue(fileData)
                    sendPushNotification()
                    showMessage(
                        "File Uploaded Successfully",
                        3000,
                        "Success",
                        R.drawable.papermani,
                        R.layout.dialog_happyface
                    )
                }
            }
            .addOnFailureListener { exception ->
                // Handle unsuccessful uploads
                Toast.makeText(this, "File upload failed: ${exception.message}", Toast.LENGTH_SHORT)
                    .show()
            }
    }

    override fun onBackPressed() {
        if (isAlreadyJoinDialogShowing) {
            dismissCustomDialog()
        } else {
            super.onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
    }

    override fun onPause() {
        super.onPause()
        dismissCustomDialog()
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}