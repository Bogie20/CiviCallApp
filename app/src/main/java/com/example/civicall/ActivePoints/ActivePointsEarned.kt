package com.example.civicall.ActivePoints

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.NotificationTwo.DataClassAct
import com.example.civicall.NotificationTwo.ActivePtsAdapter
import com.example.civicall.ProfileDetails
import com.example.civicall.R
import com.google.firebase.auth.FirebaseAuth
import com.example.civicall.databinding.ActivityActivePointsEarnedBinding
import com.google.firebase.database.*

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivePointsEarnedBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        databaseReference = FirebaseDatabase.getInstance().reference.child("Upload Engagement")

        databaseReference.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                notificationList.clear()

                // Inside onDataChange method
                for (engagementSnapshot in dataSnapshot.children) {
                    val postKey = engagementSnapshot.key ?: ""

                    // Check if the current user is a participant in this engagement
                    val participantsRef = engagementSnapshot.child("Participants")
                    val joined =
                        participantsRef.child(currentUserUid!!).child("joined").value as? Boolean

                    if (joined == true) {
                        // User is a participant, retrieve and display information
                        val title = engagementSnapshot.child("title").value.toString()
                        val activepts =
                            (engagementSnapshot.child("activepoints").value as? Long)?.toInt()
                                ?: 0

                        // Get the timestamp from the Participants node
                        val attendedStamp = participantsRef.child(currentUserUid)
                            .child("attendedStamp").value.toString()

                        val notificationItem = DataClassAct(
                            postKey,
                            title,
                            activepts,
                            attendedStamp
                        )
                        notificationList.add(0, notificationItem)
                    }
                }

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
                // Handle error
            }
        })
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ProfileDetails::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }
}
