package com.example.civicall.CivicEngagementPost


import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.github.clans.fab.FloatingActionButton
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class DetailPost : AppCompatActivity() {

    private lateinit var detailDateandTime: TextView
    private lateinit var detailTitle: TextView
    private lateinit var detailLocation: TextView
    private lateinit var detailImage: ImageView
    private lateinit var deleteButton: FloatingActionButton
    private lateinit var editButton: FloatingActionButton
    private var key = ""
    private var imageUrl = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_post)

        detailDateandTime = findViewById(R.id.detailDateandTime)
        detailImage = findViewById(R.id.detailImage)
        detailTitle = findViewById(R.id.detailTitle)
        deleteButton = findViewById(R.id.deleteButton)
        editButton = findViewById(R.id.editButton)
        detailLocation= findViewById(R.id.detailLocation)

        val bundle = intent.extras
        bundle?.let {
            detailDateandTime.text = it.getString("Date&Time")
            detailTitle.text = it.getString("Title")
            detailLocation.text = it.getString("Location")
            key = it.getString("Key") ?: ""
            imageUrl = it.getString("Image") ?: ""
            Glide.with(this).load(it.getString("Image")).into(detailImage)
        }

        deleteButton.setOnClickListener {
            val reference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Upload Engagement")
            val storage: FirebaseStorage = FirebaseStorage.getInstance()

            val storageReference: StorageReference = storage.getReferenceFromUrl(imageUrl)
            storageReference.delete().addOnSuccessListener(OnSuccessListener {
                reference.child(key).removeValue()
                Toast.makeText(this@DetailPost, "Deleted", Toast.LENGTH_SHORT).show()
                startActivity(Intent(applicationContext, CivicPostFragment::class.java))
                finish()
            })
        }

        editButton.setOnClickListener {
            val intent = Intent(this@DetailPost, Update_engagement::class.java)
                .putExtra("Title", detailTitle.text.toString())
                .putExtra("Date&Time", detailDateandTime.text.toString())
                .putExtra("Location", detailLocation.text.toString())
                .putExtra("Image", imageUrl)
                .putExtra("Key", key)
            startActivity(intent)
        }
    }
}