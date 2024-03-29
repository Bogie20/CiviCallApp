package com.example.civicall.ActivePoints

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.ProfileDetails
import com.example.civicall.R
import com.google.firebase.auth.FirebaseAuth
import com.example.civicall.databinding.ActivityActivePointsEarnedBinding
import com.google.firebase.database.*
import com.example.civicall.NetworkUtils

class ActivePointsEarned : AppCompatActivity() {

    private lateinit var binding: ActivityActivePointsEarnedBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationAdapter: ActivePtsAdapter
    private lateinit var notificationList: MutableList<DataClassAct>
    private lateinit var noPostsImage: ImageView
    private lateinit var nestedScrollView: NestedScrollView
    private lateinit var noPostsText: TextView
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivePointsEarnedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        noPostsImage = findViewById(R.id.noPostsImage)
        noPostsText = findViewById(R.id.noPostsText)
        recyclerView = findViewById(R.id.recyclerView)
        nestedScrollView = findViewById(R.id.nestedRecycler)

        recyclerView.layoutManager = LinearLayoutManager(this)
        notificationList = mutableListOf()
        notificationAdapter = ActivePtsAdapter(notificationList)
        recyclerView.adapter = notificationAdapter

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }

        val anim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        findViewById<View>(android.R.id.content).startAnimation(anim)

        auth = FirebaseAuth.getInstance()
        val currentUserUid = auth.currentUser?.uid

        databaseReference = FirebaseDatabase.getInstance().reference.child("Upload_Engagement")

        databaseReference.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                notificationList.clear()
                for (engagementSnapshot in dataSnapshot.children) {
                    val postKey = engagementSnapshot.key ?: ""

                    // Check if the current user is a participant in this engagement
                    val participantsRef = engagementSnapshot.child("Participants")
                    val joined = participantsRef.child(currentUserUid!!).child("joined").value as? Boolean

                    if (joined == true) {
                        // User is a participant, retrieve and display information
                        val titleEvent = engagementSnapshot.child("titleEvent").value.toString()
                        val activepts = (engagementSnapshot.child("activepoints").value as? Long)?.toInt() ?: 0

                        // Check if the "receivedStamp" key exists and is not null or empty
                        if (participantsRef.child(currentUserUid).hasChild("receivedStamp")) {
                            val receivedStamp =
                                participantsRef.child(currentUserUid).child("receivedStamp").value.toString()

                            // Check if receivedStamp is not empty, and add to the list
                            if (receivedStamp.isNotEmpty()) {
                                val notificationItem = DataClassAct(postKey, titleEvent, activepts, receivedStamp)
                                notificationList.add(notificationItem)
                            }
                        }
                    }
                }
                notificationList.sortByDescending { it.receivedStamp }

                notificationAdapter.notifyDataSetChanged()

                // Check if the notificationList is empty
                if (notificationList.isEmpty()) {
                    // If empty, show the "noPostsImage" and "noPostsText"
                    noPostsImage.visibility = View.VISIBLE
                    noPostsText.visibility = View.VISIBLE
                } else {
                    // If not empty, hide the "noPostsImage" and "noPostsText"
                    noPostsImage.visibility = View.GONE
                    noPostsText.visibility = View.GONE
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ProfileDetails::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }

}
