package com.example.civicall


import android.Manifest
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.civicall.databinding.ActivityEditProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import java.io.ByteArrayOutputStream
import java.util.UUID


class EditProfile : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var database: DatabaseReference
    private lateinit var storage: FirebaseStorage
    private lateinit var imageRef: StorageReference
    private var selectedImageUri: Uri? = null
    private val REQUEST_CAMERA_PERMISSION = 1
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog
    private var fullFname: String = ""
    private var fullMname: String = ""
    private var fullLname: String = ""
    private var fullAddress: String = ""
    private var fullMobileNumber: String = ""



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


        firebaseAuth = FirebaseAuth.getInstance()
        storage = FirebaseStorage.getInstance()
        imageRef = storage.reference.child("profileImages")

        checkUser()
        fullMname = binding.mname.text.toString()
        fullLname = binding.Lname.text.toString()
        fullAddress = binding.address.text.toString()
        fullMobileNumber = binding.Contactline.text.toString()
        fullFname = binding.fname.text.toString()

        val maxLength = 80 // Max character limit for name fields
        val maxContactLength = 20 // Max character limit for contact field
        val maxAddressLength = 255 // Max character limit for address field

        // Create a map of EditText fields and their respective character limits
        val editTextsToLimit = mapOf(
            binding.fname to maxLength,
            binding.mname to maxLength,
            binding.Lname to maxLength,
            binding.address to maxAddressLength,
            binding.Contactline to maxContactLength
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




        binding.savebtn.setOnClickListener {
            updateProfile()
        }


        binding.back1.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
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
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
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
        binding.address.text = Editable.Factory.getInstance().newEditable(user.address)
        binding.Contactline.text = Editable.Factory.getInstance().newEditable(user.phoneno)
        binding.campus.text = Editable.Factory.getInstance().newEditable(user.campus)
        binding.usercategory.text = Editable.Factory.getInstance().newEditable(user.userType)
        binding.birthdate.text = Editable.Factory.getInstance().newEditable(user.birthday)
        binding.spinnerSex.text = Editable.Factory.getInstance().newEditable(user.gender)


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
            val updatedCampus = binding.campus.text.toString()
            val updatedUserType = binding.usercategory.text.toString()
            val updatedBirthday = binding.birthdate.text.toString()
            val updatedGender = binding.spinnerSex.text.toString()

            if (updatedAddress.isEmpty()) {
                binding.address.error = "Address is required"
                return
            }
            // Check if the address has a minimum length of 5 characters
            if (updatedAddress.length < 5) {
                binding.address.error = "Address is short"
                return
            }
            if (updatedFirstName.isEmpty()) {
                binding.fname.error = "FirstName is required"
                return
            }
            if (updatedMiddleName.isEmpty()) {
                binding.mname.error = "MiddleName is required"
                return
            }
            if (updatedLastName.isEmpty()) {
                binding.Lname.error = "LastName is required"
                return
            }
            if (!isValidName(updatedFirstName) || !isValidName(updatedMiddleName) || !isValidName(updatedLastName)) {
                // Display an error message to the user
                Toast.makeText(this, "Invalid Name. It should only contain alphabets, '.', ',', and '-'", Toast.LENGTH_SHORT).show()
                return
            }
            if (updatedAddress.isEmpty() || updatedFirstName.isEmpty() || updatedMiddleName.isEmpty() || updatedLastName.isEmpty()) {
                // Display a single error message
                Toast.makeText(this, "Please fill in all required fields correctly.", Toast.LENGTH_SHORT).show()
                return
            }

            if (!isValidPhoneNumber(updatedContact)) {
                binding.Contactline.error = "Invalid contact number"
                return
            }



            val updateData = mapOf(
                "firstname" to updatedFirstName,
                "middlename" to updatedMiddleName,
                "lastname" to updatedLastName,
                "address" to updatedAddress,
                "phoneno" to updatedContact,
                "campus" to updatedCampus,
                "userType" to updatedUserType,
                "birthday" to updatedBirthday,
                "gender" to updatedGender
            )


            database.updateChildren(updateData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to update profile", Toast.LENGTH_SHORT).show()
                }


            if (selectedImageUri != null) {
                uploadProfileImage(selectedImageUri!!)
            }
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
    private fun isValidName(name: String): Boolean {
        // Define a regex pattern for valid names
        val regexPattern = "^[A-Za-z.,\\-]+\$"
        return name.matches(Regex(regexPattern))
    }

    private fun showImageDialog() {
        val items = arrayOf("Take a photo", "Choose from gallery")
        val builder = AlertDialog.Builder(this)
        builder.setItems(items) { _, which ->
            when (which) {
                0 -> takePicture()
                1 -> chooseFromGallery()
            }
        }
        builder.show()
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
}


data class User(
    val firstname: String = "",
    val middlename: String = "",
    val lastname: String = "",
    val address: String = "",
    val phoneno: String = "",
    val campus: String = "",
    val userType: String = "",
    val birthday: String = "",
    val gender: String = "",
    val email: String = "",
    val ImageProfile: String = ""
)


