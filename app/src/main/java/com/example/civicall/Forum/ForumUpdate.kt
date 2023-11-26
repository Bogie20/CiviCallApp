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

    private lateinit var updateObjective: EditText
    private lateinit var updateInstruction: EditText
    private lateinit var updateIntro: EditText
    private lateinit var updateImage: ImageView
    private lateinit var updateButton: Button
    private lateinit var updateStartDate: AutoCompleteTextView
    private lateinit var updateEndDate: AutoCompleteTextView
    private lateinit var updateTitle: EditText
    private lateinit var updateFundCollected: EditText
    private lateinit var updatePaymentRecipient: EditText
    private lateinit var updateFacilitator: EditText
    private lateinit var updateTargetParty: EditText
    private lateinit var updateActivePoints: EditText
    private lateinit var updateFacilitatorInfo: EditText
    private lateinit var updateLocation: EditText
    private lateinit var updateCampus: AutoCompleteTextView
    private lateinit var updateCategory: AutoCompleteTextView
    private lateinit var updatePaymentMethod: AutoCompleteTextView
    private lateinit var networkUtils: NetworkUtils
    private var title: String = ""
    private var paymentrecipient: String = ""
    private var objective: String = ""
    private var instruction: String = ""
    private var introduction: String = ""
    private var facilitator: String = ""
    private var facilitatorinfo: String = ""
    private var startdate: String = ""
    private var enddate: String = ""
    private var location: String = ""
    private var targetparty: Int = 0
    private var activepoints: Int = 0
    private var imageUrl: String = ""
    private var key: String = ""
    private var oldImageURL: String = ""
    private var campus: String = ""
    private var category: String = ""
    private var paymentmethod: String = ""
    private var uri: Uri? = null
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var binding: ActivityForumUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForumUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateButton = binding.updateButton
        updateStartDate = binding.updateStartDate
        updateEndDate = binding.updateEndDate
        updateImage = binding.updateImage
        updateLocation = binding.updateLocation
        updateTitle = binding.updateTitle
        updateFundCollected = binding.updateFundCollected
        updatePaymentRecipient = binding.updatePaymentRecipient
        updateTargetParty = binding.updateTargetParty
        updateTargetParty.inputType = InputType.TYPE_CLASS_NUMBER
        updateActivePoints = binding.updateActivePoints
        updateActivePoints.inputType = InputType.TYPE_CLASS_NUMBER
        updateFacilitator = binding.updateFacilitator
        updateFacilitatorInfo = binding.updateFacilitatorInfo
        updateCampus = binding.updateCampus
        updateCategory = binding.updateCategory
        updatePaymentMethod = binding.updatePaymentMethod
        updateObjective = binding.updateObjective
        updateInstruction = binding.updateInstruction
        updateIntro = binding.updateIntro
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
            updatePaymentMethod.setText(bundle.getString("PaymentMethod"))
            updatePaymentRecipient.setText(bundle.getString("PaymentRecipient"))
            updateTitle.setText(bundle.getString("PostText"))
            updateStartDate.setText(bundle.getString("StartDate"))
            updateEndDate.setText(bundle.getString("EndDate"))
            updateLocation.setText(bundle.getString("Location"))
            updateCampus.setText(bundle.getString("Campus"))
            updateObjective.setText(bundle.getString("Objective"))
            updateInstruction.setText(bundle.getString("Instruction"))
            updateIntro.setText(bundle.getString("Introduction"))
            updateTargetParty.setText(bundle.getString("TargetParticipants"))
            updateActivePoints.setText(bundle.getString("ActivePoints"))
            updateFacilitator.setText(bundle.getString("Facilitator"))
            updateFacilitatorInfo.setText(bundle.getString("FacilitatorConEm"))
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
        updateStartDate.setOnClickListener {
            showDateTimePicker(updateStartDate, null)
        }

        updateEndDate.setOnClickListener {
            // Parse the start date to a Calendar object for comparison
            val startDateCalendar = Calendar.getInstance()
            try {
                val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US)
                startDateCalendar.time = dateFormat.parse(updateStartDate.text.toString())
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            showDateTimePicker(updateEndDate, startDateCalendar)
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

                if (!isDateTimeInPast(updateStartDate.text.toString())) {
                    // If the date and time are not in the past, proceed with data upload
                    updateData()
                    dialog.dismiss()
                } else {
                    dialog.dismiss()
                    Toast.makeText(
                        this@ForumUpdate,
                        "Selected date and time are in the past",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.addOnFailureListener { e ->
                dialog.dismiss()
                // Handle the image upload failure, e.g., show an error message
                Toast.makeText(
                    this@ForumUpdate,
                    "Image upload failed: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            // No new image selected, just update the data
            if (!isDateTimeInPast(updateStartDate.text.toString())) {
                updateData()
                dialog.dismiss()
            } else {
                dialog.dismiss()
                Toast.makeText(
                    this@ForumUpdate,
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

    private fun showDateTimePicker(editText: EditText, startDate: Calendar?) {
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
                                this@ForumUpdate,
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

        datePickerDialog.show()
    }

    private fun updateData() {
        title = updateTitle.text.toString().trim()
        startdate = updateStartDate.text.toString().trim()
        enddate = updateEndDate.text.toString().trim()
        location = updateLocation.text.toString()
        campus = updateCampus.text.toString()
        targetparty = updateTargetParty.text.toString().toInt()
        activepoints = updateActivePoints.text.toString().toInt()
        category = updateCategory.text.toString()
        paymentmethod = updatePaymentMethod.text.toString()
        facilitator = updateFacilitator.text.toString()
        facilitatorinfo = updateFacilitatorInfo.text.toString()
        objective = updateObjective.text.toString()
        instruction = updateInstruction.text.toString()
        introduction = updateIntro.text.toString()
        val fundcollected = if (updateFundCollected.text.isNullOrBlank()) 0.0 else updateFundCollected.text.toString().toDouble()


        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid
        if (uri != null) {

            val dataClass = DataClassForum(
                uploadersId,
                category,
                title,
                startdate,
                enddate,
                location,
                imageUrl,
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
                startdate,
                enddate,
                location,
                oldImageURL,
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
