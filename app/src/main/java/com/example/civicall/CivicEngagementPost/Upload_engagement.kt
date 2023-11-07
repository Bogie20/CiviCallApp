package com.example.civicall.CivicEngagementPost

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
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
    private lateinit var uploadObjective: EditText
    private lateinit var uploadIntro: EditText
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
        uploadTitle = binding.uploadTitle
        uploadLocation = binding.uploadLocation
        saveButton = binding.updateButton
        uploadObjective = binding.uploadObjective
        uploadIntro = binding.uploadIntro

        val campusDropdown = binding.uploadCampus
        val campusArray = resources.getStringArray(R.array.allowed_campuses)
        val adaptercampus = ArrayAdapter(this, R.layout.dropdown_item, campusArray)
        (campusDropdown as? AutoCompleteTextView)?.setAdapter(adaptercampus)

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
        val storageReference =
            FirebaseStorage.getInstance().getReference().child("Poster Civic Images")
                .child(uri?.lastPathSegment!!) // Use !! to assert that uri is not null

        val builder = AlertDialog.Builder(this@Upload_engagement)
        builder.setCancelable(false)
        builder.setView(R.layout.loading_layout)
        val dialog = builder.create()
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
        val campus = binding.uploadCampus.text.toString()
        val objective = uploadObjective.text.toString()
        val introduction = uploadIntro.text.toString()
        val verificationStatus = false

        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid

        if (uploadersId != null) {
            val dataClass = DataClass(
                uploadersId,
                title,
                datetime,
                location,
                imageURL!!,
                campus,
                objective,
                introduction,
                verificationStatus
            )

            // Generate the current date and time using DateFormat and Calendar and use it as the key for the post
            val currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().time)

            // Upload the DataClass object to the "Upload Engagement" node in Firebase Realtime Database with the current date and time as the key
            FirebaseDatabase.getInstance().getReference("Upload Engagement").child(currentDate)
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