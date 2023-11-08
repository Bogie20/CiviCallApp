package com.example.civicall.CivicEngagementPost

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class DetailPost : AppCompatActivity() {

    private lateinit var detailDateandTime: TextView
    private lateinit var detailTitle: TextView
    private lateinit var detailFaciName: TextView
    private lateinit var detailFaciInfo: TextView
    private lateinit var detailLocation: TextView
    private lateinit var detailImage: ImageView
    private lateinit var detailTargetParty: TextView
    private lateinit var detailObjective: TextView
    private lateinit var detailInstruction: TextView
    private lateinit var detailIntro: TextView
    private lateinit var detailcampus: TextView
    private lateinit var detailCategory: TextView
    private lateinit var deleteButton: FloatingActionButton
    private lateinit var editButton: FloatingActionButton
    private lateinit var fabMenu: FloatingActionMenu
    private var key = ""
    private var imageUrl = ""
    private var uploadersUID = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_post)

        detailDateandTime = findViewById(R.id.detailDateandTime)
        detailImage = findViewById(R.id.detailImage)
        detailCategory = findViewById(R.id.detailCategory)
        detailTitle = findViewById(R.id.detailTitle)
        detailTargetParty = findViewById(R.id.detailTargetParty)
        detailFaciName = findViewById(R.id.detailFaciName)
        detailFaciInfo = findViewById(R.id.detailFaciInfo)
        detailObjective = findViewById(R.id.detailDesc)
        detailInstruction = findViewById(R.id.detailInstruction)
        detailIntro = findViewById(R.id.detailIntro)
        deleteButton = findViewById(R.id.deleteButton)
        editButton = findViewById(R.id.editButton)
        detailLocation = findViewById(R.id.detailLocation)
        detailcampus = findViewById(R.id.detailcampus)
        fabMenu = findViewById(R.id.fabicon)

        val bundle = intent.extras
        bundle?.let {
            detailCategory.text = it.getString("Category")
            detailTitle.text = it.getString("Title")
            detailDateandTime.text = it.getString("Date&Time")
            detailLocation.text = it.getString("Location")
            detailcampus.text = it.getString("Campus")
            detailFaciName.text = it.getString("Facilitator")
            detailFaciInfo.text = it.getString("FacilitatorConEm")
            detailObjective.text = it.getString("Objective")
            detailInstruction.text = it.getString("Instruction")
            detailIntro.text = it.getString("Introduction")
            detailTargetParty.text = it.getString("TargetParticipants")
            key = it.getString("Key") ?: ""
            imageUrl = it.getString("Image") ?: ""
            Glide.with(this).load(it.getString("Image")).into(detailImage)
        }


        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid
        val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Upload Engagement")

        databaseReference.child(key).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    uploadersUID = dataSnapshot.child("uploadersUID").value.toString()

                    // Check if the current user is the uploader of the post
                    if (currentUserId != null && currentUserId == uploadersUID) {
                        fabMenu.visibility = View.VISIBLE
                    } else {
                        fabMenu.visibility = View.GONE
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@DetailPost, "Database error: " + databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })
        databaseReference.child(key).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    uploadersUID = dataSnapshot.child("uploadersUID").value.toString()
                    val verificationStatus = dataSnapshot.child("verificationStatus").getValue(Boolean::class.java) ?: false

                    // Check if the current user is the uploader of the post and verificationStatus is false
                    if (currentUserId != null && currentUserId == uploadersUID && !verificationStatus) {
                        fabMenu.visibility = View.VISIBLE
                    } else {
                        fabMenu.visibility = View.GONE
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@DetailPost, "Database error: " + databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })


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
                .putExtra("Category", detailCategory.text.toString())
                .putExtra("Title", detailTitle.text.toString())
                .putExtra("Date&Time", detailDateandTime.text.toString())
                .putExtra("Location", detailLocation.text.toString())
                .putExtra("Image", imageUrl)
                .putExtra("Facilitator", detailFaciName.text.toString())
                .putExtra("FacilitatorConEm", detailFaciInfo.text.toString())
                .putExtra("Campus", detailcampus.text.toString())
                .putExtra("Objective", detailObjective.text.toString())
                .putExtra("Instruction", detailInstruction.text.toString())
                .putExtra("Introduction", detailIntro.text.toString())
                .putExtra("TargetParticipants", detailTargetParty.text.toString())
                .putExtra("Key", key)
            startActivity(intent)
        }
    }
}
