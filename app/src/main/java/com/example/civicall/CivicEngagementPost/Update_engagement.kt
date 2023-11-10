package com.example.civicall.CivicEngagementPost

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.example.civicall.databinding.ActivityUpdateEngagementBinding
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

class Update_engagement: AppCompatActivity() {

    private lateinit var updateObjective: EditText
    private lateinit var updateInstruction: EditText
    private lateinit var updateIntro: EditText
    private lateinit var updateImage: ImageView
    private lateinit var updateButton: Button
    private lateinit var updateDateandTime: AutoCompleteTextView
    private lateinit var updateTitle: EditText
    private lateinit var updateFacilitator: EditText
    private lateinit var updateTargetParty: EditText
    private lateinit var updateFacilitatorInfo: EditText
    private lateinit var updateLocation: EditText
    private lateinit var updateCampus: AutoCompleteTextView
    private lateinit var updateCategory: AutoCompleteTextView
    private var title: String = ""
    private var objective: String = ""
    private var instruction: String = ""
    private var introduction: String = ""
    private var facilitator: String = ""
    private var facilitatorinfo: String = ""
    private var dateandtime: String = ""
    private var location: String = ""
    private var targetparty: String = ""
    private var imageUrl: String = ""
    private var key: String = ""
    private var oldImageURL: String = ""
    private var campus: String = ""
    private var category: String = ""
    private var uri: Uri? = null
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var binding: ActivityUpdateEngagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateEngagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateButton = binding.updateButton
        updateDateandTime = binding.updateDateandTime
        updateImage = binding.updateImage
        updateLocation = binding.updateLocation
        updateTitle = binding.updateTitle
        updateTargetParty = binding.updateTargetParty
        updateFacilitator = binding.updateFacilitator
        updateFacilitatorInfo = binding.updateFacilitatorInfo
        updateCampus = binding.updateCampus
        updateCategory = binding.updateCategory
        updateObjective = binding.updateObjective
        updateInstruction = binding.updateInstruction
        updateIntro = binding.updateIntro

        val categoryDropdown = binding.updateCategory
        val categoryArray = resources.getStringArray(R.array.engagement_category)
        val adaptercategory = ArrayAdapter(this, R.layout.dropdown_item, categoryArray)
        (categoryDropdown as? AutoCompleteTextView)?.setAdapter(adaptercategory)

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
                Toast.makeText(this@Update_engagement, "No Image Selected", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        val bundle = intent.extras
        if (bundle != null) {
            Glide.with(this@Update_engagement).load(bundle.getString("Image")).into(updateImage)
            updateCategory.setText(bundle.getString("Category"))
            updateTitle.setText(bundle.getString("Title"))
            updateDateandTime.setText(bundle.getString("Date&Time"))
            updateLocation.setText(bundle.getString("Location"))
            updateCampus.setText(bundle.getString("Campus"))
            updateObjective.setText(bundle.getString("Objective"))
            updateInstruction.setText(bundle.getString("Instruction"))
            updateIntro.setText(bundle.getString("Introduction"))
            updateTargetParty.setText(bundle.getString("TargetParticipants"))
            updateFacilitator.setText(bundle.getString("Facilitator"))
            updateFacilitatorInfo.setText(bundle.getString("FacilitatorConEm"))
            key = bundle.getString("Key")!!
            oldImageURL = bundle.getString("Image")!!
        }
        databaseReference =
            FirebaseDatabase.getInstance().getReference("Upload Engagement").child(key)

        updateImage.setOnClickListener {
            val photoPicker = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }

        updateButton.setOnClickListener {
            showUpdateConfirmation()

        }
        updateDateandTime.setOnClickListener {
            showDateTimePicker()
        }
    }
    private fun saveData() {
        val builder = AlertDialog.Builder(this@Update_engagement)
        builder.setCancelable(false)
        val inflater = layoutInflater
        val loadingLayout = inflater.inflate(R.layout.loading_layout, null)
        builder.setView(loadingLayout)
        val dialog = builder.create()

        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()

        if (uri != null) {
            storageReference = FirebaseStorage.getInstance().reference.child("Poster Civic Images")
                .child(uri?.lastPathSegment!!)

            storageReference.putFile(uri!!).addOnSuccessListener { taskSnapshot ->
                val uriTask = taskSnapshot.storage.downloadUrl
                while (!uriTask.isComplete);
                val urlImage = uriTask.result
                imageUrl = urlImage.toString()

                if (!isDateTimeInPast(updateDateandTime.text.toString())) {
                    // If the date and time are not in the past, proceed with data upload
                    updateData()
                    dialog.dismiss()
                } else {
                    dialog.dismiss()
                    Toast.makeText(
                        this@Update_engagement,
                        "Selected date and time are in the past",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.addOnFailureListener { e ->
                dialog.dismiss()
                // Handle the image upload failure, e.g., show an error message
                Toast.makeText(
                    this@Update_engagement,
                    "Image upload failed: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            // No new image selected, just update the data
            if (!isDateTimeInPast(updateDateandTime.text.toString())) {
                updateData()
                dialog.dismiss()
            } else {
                dialog.dismiss()
                Toast.makeText(
                    this@Update_engagement,
                    "Selected date and time are in the past",
                    Toast.LENGTH_SHORT
                ).show()
            }
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

                                    // Set the selected date and time text in the updateDateandTime AutoCompleteTextView
                                    updateDateandTime.setText("$formattedStartTime to $formattedFinishTime")
                                } else {
                                    Toast.makeText(
                                        this@Update_engagement,
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
    private fun updateData() {
        title = updateTitle.text.toString().trim()
        dateandtime = updateDateandTime.text.toString().trim()
        location = updateLocation.text.toString()
        campus = updateCampus.text.toString()
        targetparty = updateTargetParty.text.toString()
        category = updateCategory.text.toString()
        facilitator = updateFacilitator.text.toString()
        facilitatorinfo = updateFacilitatorInfo.text.toString()
        objective = updateObjective.text.toString()
        instruction = updateInstruction.text.toString()
        introduction = updateIntro.text.toString()

        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid
        if (uri != null) {

            val dataClass = DataClass(
                uploadersId,
                category,
                title,
                dateandtime,
                location,
                imageUrl,
                campus,
                objective,
                introduction,
                facilitator,
                facilitatorinfo,
                instruction,
                targetparty,
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
                        Toast.makeText(this@Update_engagement, "Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }.addOnFailureListener { e ->
                    Toast.makeText(this@Update_engagement, e.message.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
        } else {

            val dataClass = DataClass(
                uploadersId,
                category,
                title,
                dateandtime,
                location,
                oldImageURL,
                campus,
                objective,
                introduction,
                facilitator,
                facilitatorinfo,
                instruction,
                targetparty,
                false
            )


            databaseReference.setValue(dataClass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@Update_engagement, "Updated", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }.addOnFailureListener { e ->
                    Toast.makeText(this@Update_engagement, e.message.toString(), Toast.LENGTH_SHORT)
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
}
