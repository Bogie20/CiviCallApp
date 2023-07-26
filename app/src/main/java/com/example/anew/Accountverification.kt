package com.example.anew
import PopupDialogFragment
import androidx.fragment.app.FragmentTransaction
import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentResolver
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.fragment.app.FragmentManager

class Accountverification : AppCompatActivity() {
    private lateinit var BackClick: ImageView
    private lateinit var uploadButton: Button
    private lateinit var fileNameTextView: TextView

    private val REQUEST_CODE_DOCUMENT_PICKER = 1
    private var isFileUploaded = false
    private lateinit var sharedPreferences: SharedPreferences
    private val FILE_NAME_KEY = "file_name_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accountverification)

        BackClick = findViewById(R.id.back100)
        BackClick.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

        uploadButton = findViewById(R.id.button223)
        fileNameTextView = findViewById(R.id.selectedFileNameTextView)

        // Get the SharedPreferences instance
        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE)

        // Retrieve the file name from SharedPreferences if it exists
        val savedFileName = sharedPreferences.getString(FILE_NAME_KEY, null)
        if (savedFileName != null) {
            // File name exists, display it in the TextView
            fileNameTextView.text = "Selected File: $savedFileName"
            // Update the flag and disable the upload button
            isFileUploaded = true
            uploadButton.isEnabled = false
        } else {
            // File name doesn't exist, enable the upload button
            uploadButton.isEnabled = true
            uploadButton.setOnClickListener {
                openDocumentPicker()
            }
        }
    }

    // Restores the file name and upload status when the activity is resumed
    override fun onResume() {
        super.onResume()
        val savedFileName = sharedPreferences.getString(FILE_NAME_KEY, null)
        if (savedFileName != null) {
            fileNameTextView.text = "Selected File: $savedFileName"
            isFileUploaded = true
            uploadButton.isEnabled = false
        }
    }

    private fun showConfirmationDialog(fileName: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmation")
        builder.setMessage("Are you sure you want to proceed?")
        builder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
            // Show the popup dialog with the file name
            showPopupDialog(fileName)
        }
        builder.setNegativeButton("No") { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }
        builder.show()
    }

    private fun openDocumentPicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*" // Allow all file types
        startActivityForResult(intent, REQUEST_CODE_DOCUMENT_PICKER)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_DOCUMENT_PICKER && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                // Check if the selected file has the desired MIME type (PDF or Word document)
                if (isFileAllowed(uri)) {
                    // Get the file name from the URI
                    val fileName = getFileName(uri)

                    // Save the file name in SharedPreferences
                    val editor = sharedPreferences.edit()
                    editor.putString(FILE_NAME_KEY, fileName)
                    editor.apply()

                    // Show the confirmation dialog before showing the popup dialog
                    showConfirmationDialog(fileName)
                } else {
                    // Display a message or handle the case when an invalid file type is selected.
                    // For example, show a toast or dialog informing the user about the allowed file types.
                    Toast.makeText(this, "Only PDF and Word documents are allowed.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // Helper function to check if the selected file has the desired MIME type (PDF or Word document)
    private fun isFileAllowed(uri: Uri): Boolean {
        val contentResolver: ContentResolver = contentResolver
        val mime = contentResolver.getType(uri)
        return mime?.startsWith("application/pdf") == true ||
                mime?.startsWith("application/vnd.openxmlformats-officedocument.wordprocessingml.document") == true
    }

    // Helper function to get the file name from the URI
    private fun getFileName(uri: Uri): String {
        val contentResolver: ContentResolver = contentResolver
        val cursor: Cursor? = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val displayName: String = it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                it.close()
                return displayName
            }
        }
        return "Unknown File"
    }

    private fun showPopupDialog(fileName: String) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = PopupDialogFragment(fileName)
        fragment.show(fragmentTransaction, "popup_dialog")
    }
}


