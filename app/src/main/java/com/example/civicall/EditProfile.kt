package com.example.civicall


import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.civicall.databinding.ActivityEditProfileBinding
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import java.io.ByteArrayOutputStream
import java.util.Calendar
import java.util.UUID


class EditProfile : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var database: DatabaseReference
    private lateinit var storage: FirebaseStorage
    private lateinit var imageRef: StorageReference
    private var selectedImageUri: Uri? = null
    private val REQUEST_CAMERA_PERMISSION = 1
    private lateinit var firebaseAuth: FirebaseAuth
    private var fullFname: String = ""
    private var fullMname: String = ""
    private var fullLname: String = ""
    private var fullAddress: String = ""
    private var fullMobileNumber: String = ""
    private var fullEmeMobileNumber: String = ""
    private var fullCourse: String = ""
    private var fullSrcode: String = ""
    private var isPopupShowing = false
    private lateinit var networkUtils: NetworkUtils


    private val takePictureLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val imageBitmap = result.data?.extras?.get("data") as Bitmap
                selectedImageUri = getImageUri(imageBitmap)
                binding.profileImage.setImageURI(selectedImageUri)
            } else {
                Log.e("TakePhoto", "Failed to capture photo. Result code: ${result.resultCode}")
            }
        }

    private val selectImageLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                selectedImageUri = result.data?.data
                binding.profileImage.setImageURI(selectedImageUri)
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        firebaseAuth = FirebaseAuth.getInstance()
        storage = FirebaseStorage.getInstance()
        imageRef = storage.reference.child("profileImages")
        checkUser()


        val usercategoryDropdown = binding.usercategory
        val usercategoryArray = resources.getStringArray(R.array.user_category)
        val adapterusertype = ArrayAdapter(this, R.layout.dropdown_item, usercategoryArray)
        (usercategoryDropdown as? AutoCompleteTextView)?.setAdapter(adapterusertype)

        val campusDropdown = binding.campus
        val campusArray = resources.getStringArray(R.array.allowed_campuses)
        val adaptercampus = ArrayAdapter(this, R.layout.dropdown_item, campusArray)
        (campusDropdown as? AutoCompleteTextView)?.setAdapter(adaptercampus)

        val genderDropdown = binding.gender
        val genderArray = resources.getStringArray(R.array.gender_array)
        val adaptergender = ArrayAdapter(this, R.layout.dropdown_item, genderArray)
        (genderDropdown as? AutoCompleteTextView)?.setAdapter(adaptergender)

        val nstpcategoryDropdown = binding.nstp
        val nstpcategoryArray = resources.getStringArray(R.array.nstp_category)
        val adapternstp = ArrayAdapter(this, R.layout.dropdown_item, nstpcategoryArray)
        (nstpcategoryDropdown as? AutoCompleteTextView)?.setAdapter(adapternstp)

        val birthday = binding.birthdate
        val cal = Calendar.getInstance()
        val Myear = cal.get(Calendar.YEAR)
        val Mmonth = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        birthday.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    val dateString = "${month + 1}/${dayOfMonth}/${year}"
                    birthday.setText(dateString)
                },
                Myear,
                Mmonth,
                day
            )
            datePickerDialog.show()
        }




        fullMname = binding.mname.text.toString()
        fullLname = binding.Lname.text.toString()
        fullAddress = binding.address.text.toString()
        fullMobileNumber = binding.Contactline.text.toString()
        fullEmeMobileNumber = binding.ContactEme.text.toString()
        fullFname = binding.fname.text.toString()
        fullCourse = binding.Course.text.toString()
        fullSrcode = binding.SrCode.text.toString()

        val maxLength = 80 // Max character limit for name fields
        val maxContactLength = 20 // Max character limit for contact field
        val maxAddressLength = 255 // Max character limit for address field
        // Create a map of EditText fields and their respective character limits
        val editTextsToLimit = mapOf(
            binding.fname to maxLength,
            binding.mname to maxLength,
            binding.Lname to maxLength,
            binding.Course to maxLength,
            binding.address to maxAddressLength,
            binding.Contactline to maxContactLength,
            binding.ContactEme to maxContactLength,
            binding.SrCode to maxContactLength
        )

        for ((editText, limit) in editTextsToLimit) {
            addTextWatcher(editText, limit)
        }
        // Add a focus change listener to the fname field
        binding.fname.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                // When focus is lost, set the cursor position to the end
                binding.fname.setSelection(fullFname.length)
            }
        }
        binding.mname.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.mname.setSelection(fullMname.length)
            }
        }

        binding.Lname.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.Lname.setSelection(fullLname.length)
            }
        }
        binding.Course.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.Course.setSelection(fullCourse.length)
            }
        }

        binding.address.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.address.setSelection(fullAddress.length)
            }
        }

        binding.Contactline.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.Contactline.setSelection(fullMobileNumber.length)
            }
        }
        binding.ContactEme.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.ContactEme.setSelection(fullEmeMobileNumber.length)
            }
        }
        binding.SrCode.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                binding.SrCode.setSelection(fullSrcode.length)
            }
        }
        binding.savebtn.setOnClickListener {
            showSaveConfirmationDialog()
        }

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }

        binding.profileImage.setOnClickListener {
            showImageDialog()

            checkAndRequestPermissions()
        }
    }

    private fun addTextWatcher(editText: EditText, maxLength: Int) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not used in this example
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not used in this example
            }

            override fun afterTextChanged(editable: Editable?) {
                val text = editable.toString()
                if (text.length > maxLength) {
                    editText.setText(text.substring(0, maxLength))
                    editText.setSelection(maxLength)
                }
            }
        })
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

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            startActivity(Intent(this, Login::class.java))
            finish()
        } else {
            val uid = firebaseUser.uid
            database = FirebaseDatabase.getInstance().reference.child("Users").child(uid)
            readData()
        }
    }

    private fun readData() {
        database.get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val user = snapshot.getValue(User::class.java)
                if (user != null) {
                    displayUserData(user)
                }
            } else {
                Toast.makeText(this, "User Not existed", Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun displayUserData(user: User) {
        binding.email1.text = user.email
        binding.fname.text = Editable.Factory.getInstance().newEditable(user.firstname)
        binding.mname.text = Editable.Factory.getInstance().newEditable(user.middlename)
        binding.Lname.text = Editable.Factory.getInstance().newEditable(user.lastname)
        binding.Course.text = Editable.Factory.getInstance().newEditable(user.course)
        binding.address.text = Editable.Factory.getInstance().newEditable(user.address)
        binding.SrCode.text = Editable.Factory.getInstance().newEditable(user.srcode)
        binding.Contactline.text = Editable.Factory.getInstance().newEditable(user.phoneno)
        binding.ContactEme.text =
            Editable.Factory.getInstance().newEditable(user.ContactEme) // Set the ContactEme field
        binding.usercategory.setText(user.userType, false)
        binding.campus.setText(user.campus, false)
        binding.birthdate.setText(user.birthday, false)
        binding.nstp.setText(user.nstp, false)
        binding.gender.setText(user.gender, false)

        if (!user.ImageProfile.isNullOrEmpty()) {
            Picasso.get().load(user.ImageProfile).into(binding.profileImage)
        }
    }


    private fun updateProfile() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            val uid = firebaseUser.uid
            database = FirebaseDatabase.getInstance().reference.child("Users").child(uid)

            // Your code to update the user's profile data
            val updatedFirstName = binding.fname.text.toString()
            val updatedMiddleName = binding.mname.text.toString()
            val updatedLastName = binding.Lname.text.toString()
            val updatedAddress = binding.address.text.toString()
            val updatedContact = binding.Contactline.text.toString()
            val updatedCourse = binding.Course.text.toString()
            val updatedSrCode = binding.SrCode.text.toString()
            val updatedUserType = binding.usercategory.text.toString()
            val updatedCampus = binding.campus.text.toString()
            val updatedBirthday = binding.birthdate.text.toString()
            val updatedGender = binding.gender.text.toString()
            val updatedContactEme = binding.ContactEme.text.toString()
            val updatedNstp = binding.nstp.text.toString()


            // Add validation checks and return early if there is an error

            if (!validateAddress()) {
                binding.address.error = "Please enter a valid Address"
            }
            if (!validateFirstName()) {
                binding.fname.error = "Please enter a valid first name"
            }
            if (!validateMiddleName()) {
                binding.mname.error = "Please enter a valid middle name"
            }
            if (!validateLastName()) {
                binding.Lname.error = "Please enter a valid last name"
            }
            if (!validateContactNumber()) {
                binding.Contactline.error = "Invalid contact number"
            }
            if (!validateEmeContactNumber()) {
                binding.ContactEme.error = "Invalid contact number"
            }
            !validateBirthday()

            if (!validateFirstName() || !validateMiddleName() || !validateLastName() || !validateAddress() || !validateBirthday() || !validateContactNumber() || !validateEmeContactNumber() || !validateCourse() || !validateSrCode() || !validateGender() || !validateUserType() || !validateCampus() || !validateNstp()) {
                showCustomPopup("Please provide valid information for the following fields.")
                return
            }

            val updateData = mapOf(
                "firstname" to updatedFirstName,
                "middlename" to updatedMiddleName,
                "lastname" to updatedLastName,
                "course" to updatedCourse,
                "srcode" to updatedSrCode,
                "address" to updatedAddress,
                "phoneno" to updatedContact,
                "userType" to updatedUserType,
                "campus" to updatedCampus,
                "birthday" to updatedBirthday,
                "gender" to updatedGender,
                "ContactEme" to updatedContactEme,
                "nstp" to updatedNstp,
            )

            database.updateChildren(updateData)
                .addOnSuccessListener {
                    showCustomPopupSuccess("Profile updated successfully")
                }
                .addOnFailureListener {
                    showCustomPopupError("Failed to update profile")
                }

            if (selectedImageUri != null) {
                uploadProfileImage(selectedImageUri!!)
            }
        }
    }

    private var isSaveConfirmationDialogShowing = false // Add this variable

    private fun showSaveConfirmationDialog() {
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
        logoutMsg.text = "Are you sure you want to save these changes?"

        saveBtn.text = "Save"
        saveBtn.setOnClickListener {
            alertDialog.dismiss()
            dismissCustomDialog()

            updateProfile()
        }
        cancelBtn.text = "Cancel"
        cancelBtn.setOnClickListener {
            isSaveConfirmationDialogShowing = false
            alertDialog.dismiss()
        }
        alertDialog.setOnDismissListener{
            isSaveConfirmationDialogShowing = false
        }

        alertDialog.show()
        isSaveConfirmationDialogShowing =
            true
    }
    private fun showCustomPopup(message: String) {
        // Check if the pop-up is already showing, and if so, return early
        if (isPopupShowing) {
            return
        }

        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_flat, null)

        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()

        // Set the animation style
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val messageTextView = dialogView.findViewById<TextView>(R.id.dialog_message_flat)
        val okButton = dialogView.findViewById<Button>(R.id.btn_action_flat)

        messageTextView.text = message

        okButton.setOnClickListener {
            alertDialog.dismiss()
            isPopupShowing = false // Set the variable to false when the pop-up is dismissed
        }
        alertDialog.setOnDismissListener{
            isPopupShowing = false
        }


        alertDialog.show()
        isPopupShowing = true // Set the variable to true when the pop-up is displayed
    }
    private fun showCustomPopupSuccess(message: String) {
        // Check if the pop-up is already showing, and if so, return early
        if (isPopupShowing) {
            return
        }
        dismissCustomDialog()
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_success, null)

        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()

        // Set the animation style
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val messageTextView = dialogView.findViewById<TextView>(R.id.dialog_message_flat)
        val okButton = dialogView.findViewById<Button>(R.id.btn_action_flat)

        messageTextView.text = message

        okButton.setOnClickListener {
            alertDialog.dismiss()
            isPopupShowing = false // Set the variable to false when the pop-up is dismissed
        }
        alertDialog.setOnDismissListener{
            isPopupShowing = false
        }

        alertDialog.show()
        isPopupShowing = true // Set the variable to true when the pop-up is displayed
    }
    private fun showCustomPopupError(message: String) {
        // Check if the pop-up is already showing, and if so, return early
        if (isPopupShowing) {
            return
        }
        dismissCustomDialog()
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_error, null)

        dialogBuilder.setView(dialogView)
        val alertDialog = dialogBuilder.create()

        // Set the animation style
        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink

        // Set the background to be transparent
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val messageTextView = dialogView.findViewById<TextView>(R.id.dialog_message_flat)
        val okButton = dialogView.findViewById<Button>(R.id.btn_action_flat)

        messageTextView.text = message

        okButton.setOnClickListener {
            alertDialog.dismiss()
            isPopupShowing = false // Set the variable to false when the pop-up is dismissed
        }
        alertDialog.setOnDismissListener{
            isPopupShowing = false
        }


        alertDialog.show()
        isPopupShowing = true // Set the variable to true when the pop-up is displayed
    }
    private fun dismissCustomDialog() {
        if (isPopupShowing) {

            isPopupShowing = false
        }
        if (isSaveConfirmationDialogShowing) {

            isSaveConfirmationDialogShowing = false
        }
        if (isImageDialogShowing) {
            isImageDialogShowing = false
        }
    }
    private fun validateBirthday(): Boolean {
        val birthday = binding.birthdate.text.toString().trim()
        val birthdateTextInputLayout = binding.birthdateTextInputLayout

        if (birthday.isEmpty()) {
            birthdateTextInputLayout.error = null
            showCustomPopup("Date of Birth is Required")
            return false
        } else {
            val dobParts = birthday.split("/")
            if (dobParts.size == 3) {
                val month = dobParts[0].toInt()
                val day = dobParts[1].toInt()
                val year = dobParts[2].toInt()

                val calendar = Calendar.getInstance()
                val currentYear = calendar.get(Calendar.YEAR)
                val currentMonth = calendar.get(Calendar.MONTH) + 1
                val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

                val age =
                    currentYear - year - if (currentMonth < month || (currentMonth == month && currentDay < day)) 1 else 0

                if (age < 18) {
                    showCustomPopup("You must be at least 18 years old")
                    return false
                }
            } else {
                showCustomPopupError("Invalid Date of Birth format")
                return false
            }

            // Clear the error message when valid input is provided
            binding.birthdateTextInputLayout.error = null
            return true
        }
    }

    private fun validateContactNumber(): Boolean {
        val contactNumber = binding.Contactline.text.toString().trim()

        if (contactNumber.isEmpty()) {
            binding.Contactline.error = "Please enter Contact Number"
            return false
        } else if (!isValidPhoneNumber(contactNumber)) {
            binding.Contactline.error = "Invalid Contact Number"
            return false
        } else {
            binding.Contactline.error = null
            return true
        }
    }
    private fun validateEmeContactNumber(): Boolean {
        val emecontactNumber = binding.ContactEme.text.toString().trim()

        if (emecontactNumber.isEmpty()) {
            binding.ContactEme.error = "Please enter Contact Number"
            return false
        } else if (!isValidPhoneNumber(emecontactNumber)) {
            binding.ContactEme.error = "Invalid Contact Number"
            return false
        } else {
            binding.ContactEme.error = null
            return true
        }
    }
    private fun isValidPhoneNumber(contactNumber: String): Boolean {

        val sanitizedNumber = contactNumber.replace("\\s".toRegex(), "")

        return if (sanitizedNumber.startsWith("+63")) {
            sanitizedNumber.length == 13
        } else if (sanitizedNumber.startsWith("63")) {
            sanitizedNumber.length == 12
        } else if (sanitizedNumber.startsWith("09")) {
            sanitizedNumber.length == 11
        } else {
            false
        }
    }
    private fun validateFirstName(): Boolean {
        val firstName = binding.fname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (firstName.isEmpty()) {
            binding.fname.error = "Required"
            return false
        } else if (!firstName.matches(regex.toRegex())) {
            binding.fname.error =
                "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            binding.fname.error = null
            return true
        }
    }

    private fun validateAddress(): Boolean {
        val address = binding.address.text.toString().trim()

        if (address.isEmpty()) {
            binding.address.error = "Address is required"
            return false
        } else if (address.length < 5) {
            binding.address.error = "Address is too short"
            return false
        } else {
            binding.address.error = null
            return true
        }
    }
    private fun validateCourse(): Boolean {
        val Course = binding.Course.text.toString().trim()

        if (Course.isEmpty()) {
            binding.Course.error = "Course field is required"
            return false
        } else if (Course.length < 8) {
            binding.Course.error = "It is too short"
            return false
        } else {
            binding.Course.error = null
            return true
        }
    }
    private fun validateGender(): Boolean {
        val Gender = binding.gender.text.toString().trim()

        if (Gender.isEmpty()) {
            binding.gender.error = "Gender field is required"
            return false
        }  else {
            binding.gender.error = null
            return true
        }
    }
    private fun validateUserType(): Boolean {
        val UserType = binding.usercategory.text.toString().trim()

        if (UserType.isEmpty()) {
            binding.usercategory.error = "User Type field is required"
            return false
        }  else {
            binding.usercategory.error = null
            return true
        }
    }
    private fun validateNstp(): Boolean {
        val Nstp = binding.nstp.text.toString().trim()

        if (Nstp.isEmpty()) {
            binding.nstp.error = "NSTP Program field is required"
            return false
        }  else {
            binding.nstp.error = null
            return true
        }
    }
    private fun validateCampus(): Boolean {
        val Campus = binding.campus.text.toString().trim()

        if (Campus.isEmpty()) {
            binding.campus.error = "Campus field is required"
            return false
        }  else {
            binding.campus.error = null
            return true
        }
    }
    private fun validateSrCode(): Boolean {
        val SrCode = binding.SrCode.text.toString().trim()

        if (SrCode.isEmpty()) {
            binding.SrCode.error = "SrCode field is required"
            return false
        } else if (SrCode.length <= 7) {
            binding.SrCode.error = "Input is too short"
            return false
        } else {
            binding.SrCode.error = null
            return true
        }
    }
    private fun validateMiddleName(): Boolean {
        val middleName = binding.mname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (middleName.isEmpty()) {
            binding.mname.error = "Required"
            return false
        } else if (!middleName.matches(regex.toRegex())) {
            binding.mname.error =
                "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            binding.mname.error = null
            return true
        }
    }

    private fun validateLastName(): Boolean {
        val lastName = binding.Lname.text.toString().trim()
        val regex = "^[a-zA-Z.\\s-]+$"

        if (lastName.isEmpty()) {
            binding.Lname.error = "Required"
            return false
        } else if (!lastName.matches(regex.toRegex())) {
            binding.Lname.error =
                "Only letters and symbols (, . -) are allowed"
            return false
        } else {
            binding.lastNameTextInputLayout.error = null
            return true
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
            alertDialog.dismiss() // Close the dialog after clicking "Take a photo"
            // Reset the flag when dismissing the dialog
            isImageDialogShowing = false
        }

        lytGalleryPick.setOnClickListener {
            chooseFromGallery()
            alertDialog.dismiss() // Close the dialog after clicking "Choose from gallery"
            // Reset the flag when dismissing the dialog
            isImageDialogShowing = false
        }

        alertDialog.setOnDismissListener {
            // Reset the flag when dismissing the dialog
            isImageDialogShowing = false
        }

        alertDialog.show()
        // Set the flag to true when the dialog is displayed
        isImageDialogShowing = true
    }




    private fun takePicture() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        takePictureLauncher.launch(intent)
    }


    private fun chooseFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        selectImageLauncher.launch(intent)
    }


    private fun getImageUri(inImage: Bitmap): Uri {
        val bytes = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(contentResolver, inImage, "Title", null)
        return Uri.parse(path)
    }

    private fun uploadProfileImage(imageUri: Uri) {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            val uid = firebaseUser.uid
            val imageFileName = UUID.randomUUID().toString()
            val userImageRef = imageRef.child("$uid/$imageFileName.jpg")


            userImageRef.putFile(imageUri)
                .addOnSuccessListener {
                    userImageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                        val imageUrl = downloadUrl.toString()
                        updateProfileImage(imageUrl)
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to upload image", Toast.LENGTH_SHORT).show()
                }
        }
    }


    private fun updateProfileImage(imageUrl: String) {
        database.child("ImageProfile").setValue(imageUrl)
            .addOnSuccessListener {
                Toast.makeText(this, "Profile image updated successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to update profile image", Toast.LENGTH_SHORT).show()
            }
    }
    override fun onDestroy() {
        super.onDestroy()

        // Cleanup to unregister the network callback
        networkUtils.cleanup()
    }

}



data class User(
    val firstname: String = "",
    val middlename: String = "",
    val lastname: String = "",
    val address: String = "",
    val course: String = "",
    val srcode: String = "",
    val phoneno: String = "",
    val userType: String = "",
    val campus: String = "",
    val birthday: String = "",
    val gender: String = "",
    val email: String = "",
    val ImageProfile: String = "",
    val ContactEme: String = "",
    val nstp: String = ""

)



