    package com.example.civicall

    import android.app.Activity
    import android.app.AlertDialog
    import android.app.ProgressDialog
    import android.content.ContentValues
    import android.content.Intent
    import android.net.Uri
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.provider.MediaStore
    import android.view.View
    import android.widget.AdapterView
    import android.widget.ArrayAdapter
    import android.widget.Spinner
    import android.widget.Toast
    import androidx.activity.result.ActivityResultCallback
    import androidx.activity.result.contract.ActivityResultContracts
    import com.example.civicall.databinding.ActivityMyprofileBinding
    import com.google.firebase.auth.FirebaseAuth
    import com.google.firebase.database.DatabaseReference
    import com.google.firebase.database.FirebaseDatabase
    import com.google.firebase.storage.FirebaseStorage
    import com.squareup.picasso.Picasso

    @Suppress("IMPLICIT_CAST_TO_ANY")
    class Myprofile : AppCompatActivity() {


        private lateinit var binding: ActivityMyprofileBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMyprofileBinding.inflate(layoutInflater)
            setContentView(binding.root)


        }
    }










