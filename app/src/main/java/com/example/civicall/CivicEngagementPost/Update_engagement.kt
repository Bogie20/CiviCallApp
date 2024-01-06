package com.example.civicall.CivicEngagementPost

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
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
    private lateinit var binding: ActivityUpdateEngagementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateEngagementBinding.inflate(layoutInflater)
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
            dismissCustomDialog()
            super.onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        val paymentDropdown = binding.updatePaymentMethod
        val paymentArray = resources.getStringArray(R.array.payment_category)
        val adapterpayment = ArrayAdapter(this, R.layout.dropdown_item, paymentArray)
        (paymentDropdown as? AutoCompleteTextView)?.setAdapter(adapterpayment)

        val paymentTextInputLayout = binding.PaymentTextInputLayout
        val paymentRecepientTextInputLayout = binding.PaymentRecepientTextInputLayout

        updateCategory.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed, but required by the interface
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed, but required by the interface
            }

            override fun afterTextChanged(s: Editable?) {
                val selectedCategory = s.toString()
                if (selectedCategory == "Fund Raising" || selectedCategory == "Donations") {
                    paymentTextInputLayout.visibility = View.VISIBLE
                    paymentRecepientTextInputLayout.visibility = View.VISIBLE
                } else {
                    paymentTextInputLayout.visibility = View.GONE
                    paymentRecepientTextInputLayout.visibility = View.GONE
                }
            }
        })

        updateCampus.setOnClickListener {
            showCheckBoxCampus()
        }
        updateCategory.setOnClickListener {
            showCategorySelectionDialog()
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
            updatePaymentMethod.setText(bundle.getString("PaymentMethod"))
            updatePaymentRecipient.setText(bundle.getString("PaymentRecipient"))
            updateTitle.setText(bundle.getString("Title"))
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
            if (networkUtils.isOnline) {
                showUpdateConfirmation()
            } else {
                if (!isNoInternetDialogShowing) {
                    dismissCustomDialog()
                    showNoInternetPopup()
                }
            }
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

                if (!isDateTimeInPast(updateStartDate.text.toString())) {
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
            if (!isDateTimeInPast(updateStartDate.text.toString())) {
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
        val selectedCampuses = binding.updateCampus.text.toString().split(", ")
        for (checkBox in checkBoxes) {
            checkBox.isChecked = selectedCampuses.contains(checkBox.text.toString())
        }

        btnSelectCampus.setOnClickListener {
            val selectedCampuses = checkBoxes.filter { it.isChecked }.map { it.text.toString() }
            val selectedCampusesText = selectedCampuses.joinToString(", ")

            // Set the selected campuses in the AutoCompleteTextView
            binding.updateCampus.setText(selectedCampusesText)

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
                                this@Update_engagement,
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
        paymentrecipient = updatePaymentRecipient.text.toString()
        facilitator = updateFacilitator.text.toString()
        facilitatorinfo = updateFacilitatorInfo.text.toString()
        objective = updateObjective.text.toString()
        instruction = updateInstruction.text.toString()
        introduction = updateIntro.text.toString()
        val fundcollected = if (updateFundCollected.text.isNullOrBlank()) 0.0 else updateFundCollected.text.toString().toDouble()


        val user = FirebaseAuth.getInstance().currentUser
        val uploadersId = user?.uid
        if (uri != null) {

            val dataClass = DataClass(
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
                false,
                key

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
                false,
               key
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
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
    override fun onPause() {
        super.onPause()
        dismissCustomDialog()
    }
}
