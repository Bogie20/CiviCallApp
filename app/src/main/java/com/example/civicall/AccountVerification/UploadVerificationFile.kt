package com.example.civicall.AccountVerification

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.OpenableColumns
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.civicall.databinding.ActivityUploadVerificationFileBinding

class UploadVerificationFile : AppCompatActivity() {
    private lateinit var binding: ActivityUploadVerificationFileBinding

    private val pickFileLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                data?.data?.let { uri ->
                    handleSelectedFile(uri)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadVerificationFileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.underlineTextView.setOnClickListener {
            checkStoragePermission()
        }

        binding.Reg.setOnClickListener {
            // Add your code to handle the "Send" button click
        }
    }

    private fun checkStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                openFilePicker()
            } else {
                requestPermissions(
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    STORAGE_PERMISSION_REQUEST_CODE
                )
            }
        } else {
            openFilePicker()
        }
    }

    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"
        intent.putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("application/pdf", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
        pickFileLauncher.launch(intent)
    }

    private fun handleSelectedFile(uri: Uri) {
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val displayNameColumnIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (displayNameColumnIndex != -1) {
                    val displayName = it.getString(displayNameColumnIndex)
                    binding.filename.text = displayName.toEditable()
                }
            }
        }
    }

    // Extension function to convert String to Editable
    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)



    companion object {
        private const val STORAGE_PERMISSION_REQUEST_CODE = 123
    }
}
