package com.example.civicall.CivicEngagementPost

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.app.AlertDialog
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
import android.widget.Toast
import com.example.civicall.Dashboard
import com.example.civicall.R
import com.example.civicall.databinding.ActivityUploadEngagementBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.text.DateFormat
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
    private lateinit var uploadDateandTime: AutoCompleteTextView
    private lateinit var uploadLocation: EditText
    private var imageURL: String? = null
    private var uri: Uri? = null
    private lateinit var binding: ActivityUploadEngagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadEngagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        uploadImage = binding.uploadImage
        uploadDateandTime = binding.uploadDateandTime
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

        binding.backbtn.setOnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val campusDropdown = binding.uploadCampus
        val campusArray = resources.getStringArray(R.array.allowed_campuses)
        val adaptercampus = ArrayAdapter(this, R.layout.dropdown_item, campusArray)
        (campusDropdown as? AutoCompleteTextView)?.setAdapter(adaptercampus)

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

            if (selectedCategory == "Fund Raising" || selectedCategory == "Donations") {
                paymentMethodLayout.visibility = View.VISIBLE
                paymentRecipientLayout.visibility = View.VISIBLE
            } else {
                paymentMethodLayout.visibility = View.GONE
                paymentRecipientLayout.visibility = View.GONE
            }
        }

        uploadDateandTime.setOnClickListener {
            showDateTimePicker()
        }

        val activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                uri = data?.data
                uploadImage.setImageURI(uri)
            } else {
                Toast.makeText(this@Upload_engagement, "No Image Selected", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        uploadImage.setOnClickListener {
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }

        saveButton.setOnClickListener {
            saveData()
        }
    }

    private fun showDateTimePicker() {
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
                        val startCalendar = calendar.clone() as Calendar
                        startCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                        startCalendar.set(Calendar.MINUTE, minute)

                        val finishTimePickerDialog = TimePickerDialog(
                            this,
                            { _, finishHourOfDay, finishMinute ->
                                val finishCalendar = startCalendar.clone() as Calendar
                                finishCalendar.set(Calendar.HOUR_OF_DAY, finishHourOfDay)
                                finishCalendar.set(Calendar.MINUTE, finishMinute)

                                // Check if finish time is later than start time
                                if (finishCalendar.after(startCalendar)) {
                                    val formattedStartTime = dateFormat.format(startCalendar.time)
                                    val formattedFinishTime = SimpleDateFormat(
                                        "hh:mm a",
                                        Locale.US
                                    ).format(finishCalendar.time)

                                    // Set the selected date and time text in the uploadDateandTime EditText
                                    uploadDateandTime.setText("$formattedStartTime to $formattedFinishTime")
                                } else {
                                    Toast.makeText(
                                        this@Upload_engagement,
                                        "Finish time must be later than start time",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            },
                            calendar.get(Calendar.HOUR_OF_DAY),
                            calendar.get(Calendar.MINUTE),
                            false
                        )
                        finishTimePickerDialog.show()
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

        datePickerDialog.show()
    }


    private fun saveData() {
        // Validate if any of the required fields is empty
        if (uploadTitle.text.isNullOrBlank() ||
            uploadDateandTime.text.isNullOrBlank() ||
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

        val storageReference = FirebaseStorage.getInstance().getReference()
            .child("Poster Civic Images").child(uri?.lastPathSegment!!)

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
                if (!isDateTimeInPast(uploadDateandTime.text.toString())) {
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

            // Check if the selected date and time are in the past
            return selectedDateTime != null && selectedDateTime.before(currentDateTime)
        } catch (e: ParseException) {
            e.printStackTrace()
            return true  // Handle the error as per your requirements
        }
    }

    private fun uploadData() {
        val title = uploadTitle.text.toString()
        val datetime = uploadDateandTime.text.toString()
        val location = uploadLocation.text.toString()
        val facilitator = uploadFacilitator.text.toString()
        val facilitatorinfo = uploadFacilitatorInfo.text.toString()
        val targetparty = uploadTargetParty.text.toString()
        val activepoints = uploadActivePoints.text.toString()
        val campus = binding.uploadCampus.text.toString()
        val category = binding.uploadCategory.text.toString()
        val fundcollected = if (uploadFundCollected.text.isNullOrBlank()) "0" else uploadFundCollected.text.toString()
        val paymentmethod = binding.uploadPaymentMethod.text.toString()
        val paymentrecipient = uploadPaymentRecipient.text.toString()
        val objective = uploadObjective.text.toString()
        val instruction = uploadInstruction.text.toString()
        val introduction = uploadIntro.text.toString()
        val verificationStatus = false

        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid

        if (uploadersId != null) {
            val dataClass = DataClass(
                uploadersId,
                category,
                title,
                datetime,
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
                fundcollected,
                verificationStatus
            )

            val baseKey = uploadTitle.text.toString()

            val timestamp = System.currentTimeMillis().toString()

            val postKey = "$baseKey-$timestamp"

            FirebaseDatabase.getInstance().getReference("Upload Engagement").child(postKey)
                .setValue(dataClass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@Upload_engagement, "Saved", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this@Upload_engagement, e.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }

        }
    }
}
