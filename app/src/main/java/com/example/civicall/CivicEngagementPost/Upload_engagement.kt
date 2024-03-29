package com.example.civicall.CivicEngagementPost

import android.Manifest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.civicall.Dashboard
import com.example.civicall.NetworkUtils
import com.example.civicall.R
import com.example.civicall.SplashActivity
import com.example.civicall.databinding.ActivityUploadEngagementBinding
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class Upload_engagement : AppCompatActivity() {

    private lateinit var uploadImage: ImageView
    private lateinit var saveButton: Button
    private lateinit var uploadTitle: EditText
    private lateinit var uploadFacilitator: EditText
    private lateinit var uploadFacilitatorInfo: EditText
    private lateinit var uploadPaymentRecipient: EditText
    private lateinit var uploadTargetParty: EditText
    private lateinit var uploadActivePoints: EditText
    private lateinit var uploadObjective: EditText
    private lateinit var uploadInstruction: EditText
    private lateinit var uploadIntro: EditText
    private lateinit var uploadCategory: AutoCompleteTextView
    private lateinit var uploadPaymentMethod: AutoCompleteTextView
    private lateinit var uploadFundCollected: EditText
    private lateinit var uploadStartDate: AutoCompleteTextView
    private lateinit var uploadLocation: EditText
    private lateinit var uploadEndDate: EditText
    private var imageURL: String? = null
    private var uri: Uri? = null
    private val REQUEST_CAMERA_PERMISSION = 2
    private lateinit var binding: ActivityUploadEngagementBinding
    private lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadEngagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uploadImage = binding.uploadImage
        uploadStartDate = binding.uploadStartDate
        uploadEndDate = binding.uploadEndDate
        uploadCategory = binding.uploadCategory
        uploadPaymentMethod = binding.uploadPaymentMethod
        uploadTitle = binding.uploadTitle
        uploadPaymentRecipient = binding.uploadPaymentRecipient
        uploadTargetParty = binding.uploadTargetParty
        uploadFundCollected = binding.uploadFundCollected
        uploadTargetParty.inputType = InputType.TYPE_CLASS_NUMBER
        uploadActivePoints = binding.uploadActivePoints
        uploadActivePoints.inputType = InputType.TYPE_CLASS_NUMBER
        uploadFacilitator = binding.uploadFacilitator
        uploadFacilitatorInfo = binding.uploadFacilitatorInfo
        uploadLocation = binding.uploadLocation
        saveButton = binding.uploadButton
        uploadObjective = binding.uploadObjective
        uploadInstruction = binding.uploadInstruction
        uploadIntro = binding.uploadIntro
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        binding.backbtn.setOnClickListener {
            dismissCustomDialog()
            super.onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        val campusAuto = binding.uploadCampus
        campusAuto.setOnClickListener {
            showCheckBoxCampus()
        }
        val paymentDropdown = binding.uploadPaymentMethod
        val paymentArray = resources.getStringArray(R.array.payment_category)
        val adapterpayment = ArrayAdapter(this, R.layout.dropdown_item, paymentArray)
        (paymentDropdown as? AutoCompleteTextView)?.setAdapter(adapterpayment)

        val categoryDropdown = binding.uploadCategory
        val categoryArray = resources.getStringArray(R.array.engagement_category)
        val adaptercategory = ArrayAdapter(this, R.layout.dropdown_item, categoryArray)
        (categoryDropdown as? AutoCompleteTextView)?.setAdapter(adaptercategory)

        val paymentMethodLayout = binding.PaymentTextInputLayout
        val paymentRecipientLayout = binding.PaymentRecepientTextInputLayout

        categoryDropdown.setOnItemClickListener { _, _, position, _ ->
            val selectedCategory = categoryArray[position]

            if (selectedCategory == "Fund Raising" || selectedCategory == "Donation") {
                paymentMethodLayout.visibility = View.VISIBLE
                paymentRecipientLayout.visibility = View.VISIBLE

            } else {
                paymentMethodLayout.visibility = View.GONE
                paymentRecipientLayout.visibility = View.GONE
            }
        }

        uploadStartDate.setOnClickListener {
            showDateTimePicker(uploadStartDate, null)
        }

        uploadEndDate.setOnClickListener {
            // Parse the start date to a Calendar object for comparison
            val startDateCalendar = Calendar.getInstance()
            try {
                val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US)
                startDateCalendar.time = dateFormat.parse(uploadStartDate.text.toString())
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            showDateTimePicker(uploadEndDate, startDateCalendar)
        }

        uploadImage.setOnClickListener {
            checkAndRequestPermissions()
        }

        saveButton.setOnClickListener {
            if (networkUtils.isOnline) {
                val auth = FirebaseAuth.getInstance()
                val currentUser = auth.currentUser
                if (currentUser != null) {
                    val uid = currentUser.uid

                    // Now you can use the uid in your Firebase Database reference
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
                            val errorMessage = "Database error: ${error.message}"

                            Log.e("Upload_engagement", errorMessage)

                            Toast.makeText(this@Upload_engagement, errorMessage, Toast.LENGTH_SHORT).show()
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

    private var isCampusDialogShowing = false

    private fun showCheckBoxCampus() {
        if (isCampusDialogShowing) {
            return
        }

        getCurrentUserCampus { currentUserCampus ->
            if (currentUserCampus != null) {
                val dialogView = layoutInflater.inflate(R.layout.multiple_checkbox_selection, null)
                val alertDialog = AlertDialog.Builder(this)
                    .setView(dialogView)
                    .create()

                val btnSelectCampus = dialogView.findViewById<Button>(R.id.btnSelectCampus)
                val closeIcon = dialogView.findViewById<ImageView>(R.id.closeIcon) // Add this line

                val checkBoxes = ArrayList<CheckBox>()

                // Iterate from 1 to 11 (excluding checkBox12)
                // Iterate from 1 to 11 (excluding checkBox12)
                for (i in 1 until 12) {
                    val checkBoxId = resources.getIdentifier("checkBox$i", "id", packageName)
                    val checkBox = dialogView.findViewById<CheckBox>(checkBoxId)

                    // Assign an identifier to each checkbox based on the campus name
                    val campusName = checkBox.text.toString()

                    // Check if the current checkbox corresponds to the user's default campus
                    val isCurrentUserCampus = campusName == currentUserCampus

                    if (isCurrentUserCampus) {
                        // Use ViewTreeObserver to delay setting isChecked until the view is fully initialized
                        checkBox.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
                            override fun onPreDraw(): Boolean {
                                checkBox.isChecked = true
                                checkBox.isEnabled = false
                                checkBox.viewTreeObserver.removeOnPreDrawListener(this)
                                return true
                            }
                        })
                    }

                    checkBoxes.add(checkBox)
                }

                val checkBox12 = dialogView.findViewById<CheckBox>(R.id.checkBox12)

                // Set a listener for checkBox12 to select all checkboxes
                checkBox12.setOnCheckedChangeListener { _, isChecked ->
                    checkBoxes.forEach { it.isChecked = isChecked }
                }

                // Check previously selected campuses and update the checkboxes
                val selectedCampuses = binding.uploadCampus.text.toString().split(", ")
                for (checkBox in checkBoxes) {
                    checkBox.isChecked = selectedCampuses.contains(checkBox.text.toString())
                }

                btnSelectCampus.setOnClickListener {
                    val selectedCampuses = checkBoxes.filter { it.isChecked }.map { it.text.toString() }
                    val selectedCampusesText = selectedCampuses.joinToString(", ")

                    // Set the selected campuses in the AutoCompleteTextView
                    binding.uploadCampus.setText(selectedCampusesText)

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
            } else {
                // Handle error or show a message if unable to fetch user's campus
                Toast.makeText(this, "Unable to fetch user's campus information", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getCurrentUserCampus(callback: (String?) -> Unit) {
        val auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val uid = currentUser.uid

            val currentUserRef = FirebaseDatabase.getInstance().getReference("Users").child(uid)
            currentUserRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val campus = snapshot.child("campus").getValue(String::class.java)
                    callback(campus)
                }

                override fun onCancelled(error: DatabaseError) {
                    callback(null)
                }
            })
        } else {
            callback(null)
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
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                REQUEST_CAMERA_PERMISSION
            )
        } else {
            launchGalleryIntent()
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
                    launchGalleryIntent()
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
                    uploadImage.setImageURI(uri)
                }
            } else {
                Toast.makeText(this@Upload_engagement, "No Image Selected", Toast.LENGTH_SHORT).show()
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
        if (isCampusDialogShowing) {
            isCampusDialogShowing = false

        }
        if (isAlreadyJoinDialogShowing) {
            isAlreadyJoinDialogShowing = false

        }
        if (isDateTimePickerShowing) {
            isDateTimePickerShowing = false

        }
    }
    private fun sendEngagementNotification(engagementTitle: String) {
        val title = "You Request an Engagement"
        val body = "Title: '$engagementTitle'\nPlease wait for approval"

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

    private var isDateTimePickerShowing = false

    private fun showDateTimePicker(editText: EditText, startDate: Calendar?) {
        if (isDateTimePickerShowing) {
            return
        }

        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US)
        dateFormat.timeZone = TimeZone.getTimeZone("Asia/Manila")

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val timePickerDialog = TimePickerDialog(
                    this,
                    { _, hourOfDay, minute ->
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                        calendar.set(Calendar.MINUTE, minute)

                        // Check if the selected end date is after the start date
                        if (startDate != null && calendar.time.before(startDate.time)) {
                            Toast.makeText(
                                this@Upload_engagement,
                                "End date must be after the start date",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            // Set the selected date and time text in the appropriate EditText
                            val formattedDateTime = dateFormat.format(calendar.time)
                            editText.setText(formattedDateTime)
                        }
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    false
                )
                timePickerDialog.show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.setOnDismissListener {
            isDateTimePickerShowing = false
        }

        datePickerDialog.show()
        isDateTimePickerShowing = true
    }


    private fun saveData() {
        // Validate if any of the required fields is empty
        if (uploadTitle.text.isNullOrBlank() ||
            uploadStartDate.text.isNullOrBlank() ||
            uploadLocation.text.isNullOrBlank() ||
            uploadFacilitator.text.isNullOrBlank() ||
            uploadFacilitatorInfo.text.isNullOrBlank() ||
            uploadTargetParty.text.isNullOrBlank() ||
            binding.uploadCampus.text.isNullOrBlank() ||
            binding.uploadCategory.text.isNullOrBlank() ||
            uploadObjective.text.isNullOrBlank() ||
            uploadInstruction.text.isNullOrBlank() ||
            uploadIntro.text.isNullOrBlank() ||
            uri == null
        ) {
            Toast.makeText(
                this@Upload_engagement,
                "Please fill in all the required information",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        val fileName = System.currentTimeMillis().toString() + "_civicImage"

        // Create a reference to the Firebase Storage with the generated file name
        val storageReference = FirebaseStorage.getInstance().getReference()
            .child("Poster_Civic_Images").child(fileName)

        val builder = AlertDialog.Builder(this@Upload_engagement)
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

                // Check if the selected date and time are in the past
                if (!isDateTimeInPast(uploadStartDate.text.toString())) {
                    // If the date and time are not in the past, proceed with data upload
                    uploadData()
                    dialog.dismiss()
                } else {
                    dialog.dismiss()
                    Toast.makeText(
                        this@Upload_engagement,
                        "Selected date and time are in the past",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            .addOnFailureListener { e ->
                dialog.dismiss()
                Toast.makeText(
                    this@Upload_engagement,
                    "Failed to upload image: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun isDateTimeInPast(dateTimeString: String): Boolean {
        try {
            val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US)
            dateFormat.timeZone = TimeZone.getTimeZone("Asia/Manila")
            val selectedDateTime = dateFormat.parse(dateTimeString)
            val currentDateTime = Calendar.getInstance().time

            return selectedDateTime != null && selectedDateTime.before(currentDateTime)
        } catch (e: ParseException) {
            e.printStackTrace()
            return true
        }
    }

    private fun uploadData() {
        val titleEvent = uploadTitle.text.toString()
        val startdate = uploadStartDate.text.toString()
        val enddate = uploadEndDate.text.toString()
        val location = uploadLocation.text.toString()
        val facilitator = uploadFacilitator.text.toString()
        val facilitatorinfo = uploadFacilitatorInfo.text.toString()
        val targetparty = uploadTargetParty.text.toString().toInt()
        val activepoints = uploadActivePoints.text.toString().toInt()
        val campus = binding.uploadCampus.text.toString()
        val category = binding.uploadCategory.text.toString()
        val fundcollected =
            if (uploadFundCollected.text.isNullOrBlank()) 0.0 else uploadFundCollected.text.toString()
                .toDouble()

        val formattedFundCollected = String.format("%.2f", fundcollected)
        val paymentmethod = binding.uploadPaymentMethod.text.toString()
        val paymentrecipient = uploadPaymentRecipient.text.toString()
        val objective = uploadObjective.text.toString()
        val instruction = uploadInstruction.text.toString()
        val introduction = uploadIntro.text.toString()
        val verificationStatus = false

        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid

        if (uploadersId != null) {
            val postKey =
                FirebaseDatabase.getInstance().getReference("Upload_Engagement").push().key

            if (postKey != null) {
                val dataClass = DataClass(
                    uploadersId,
                    category,
                    titleEvent,
                    startdate,
                    enddate,
                    location,
                    imageURL!!,
                    campus,
                    objective,
                    introduction,
                    facilitator,
                    facilitatorinfo,
                    instruction,
                    targetparty,
                    activepoints,
                    paymentmethod,
                    paymentrecipient,
                    formattedFundCollected.toDouble(),
                    verificationStatus
                )

                FirebaseDatabase.getInstance().getReference("Upload_Engagement").child(postKey)
                    .setValue(dataClass)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this@Upload_engagement, "Success", Toast.LENGTH_SHORT)
                                .show()
                            finish()
                            val intent = Intent(this@Upload_engagement, Dashboard::class.java)
                            intent.putExtra("navigate_to_civic_fragment", true)
                            startActivity(intent)
                            sendEngagementNotification(uploadTitle.text.toString())
                        }
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(
                            this@Upload_engagement,
                            e.message.toString(),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
    override fun onPause() {
        super.onPause()
        dismissCustomDialog()
    }
}