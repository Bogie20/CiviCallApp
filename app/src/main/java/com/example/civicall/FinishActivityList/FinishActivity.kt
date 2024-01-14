package com.example.civicall.FinishActivityList

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.ProfileDetails
import com.example.civicall.R
import com.example.civicall.databinding.ActivityFinishBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import com.example.civicall.NetworkUtils
class FinishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinishBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var finishActAdapter: FinishActAdapter
    private lateinit var finishedActivities: MutableList<DataClassFinish>
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private var childEventListener: ChildEventListener? = null
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        recyclerView = binding.finishRecycler
        auth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().reference.child("Upload Engagement")
        finishedActivities = mutableListOf()
        finishActAdapter = FinishActAdapter(finishedActivities)

        recyclerView.adapter = finishActAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchFinishedActivities()

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
    }
    private fun fetchFinishedActivities() {
        val currentUserUid = auth.currentUser?.uid
        val currentDate = getCurrentDate()

        val participantsQuery = databaseReference.orderByChild("Participants/$currentUserUid/joined").equalTo(true)
        participantsQuery.addListenerForSingleValueEvent(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                finishedActivities.clear() // Clear existing data before updating

                for (engagementSnapshot in snapshot.children) {
                    val startDate = engagementSnapshot.child("startDate").getValue(String::class.java) ?: ""
                    val endDate = engagementSnapshot.child("endDate").getValue(String::class.java) ?: ""

                    // Check if the current date and time are equal to or later than the endDate
                    if (isDateMatched(currentDate, endDate)) {
                        val postKey = engagementSnapshot.key ?: ""
                        val finishData = DataClassFinish(
                            engagementSnapshot.child("image").getValue(String::class.java) ?: "",
                            engagementSnapshot.child("title").getValue(String::class.java) ?: "",
                            engagementSnapshot.child("location").getValue(String::class.java) ?: "",
                            engagementSnapshot.child("category").getValue(String::class.java) ?: "",
                            startDate,
                            endDate,
                            postKey,
                            engagementSnapshot.child("Participants/$currentUserUid/receivedStamp").getValue(String::class.java) ?: ""
                        )
                        finishedActivities.add(0, finishData)
                    }
                }
                finishActAdapter = FinishActAdapter(finishedActivities)
                recyclerView.adapter = finishActAdapter

                // Show or hide noPostsImage and noPostsText based on the data
                if (finishedActivities.isEmpty()) {
                    binding.noPostsImage.visibility = View.VISIBLE
                    binding.noPostsText.visibility = View.VISIBLE
                } else {
                    binding.noPostsImage.visibility = View.GONE
                    binding.noPostsText.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle onCancelled
            }
        })
    }

    private fun isDateMatched(currentDate: String, endDate: String): Boolean {
        val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        val currentDateTime = sdf.parse(currentDate)
        val endDateTime = sdf.parse(endDate)

        return currentDateTime?.after(endDateTime) == true || currentDateTime?.equals(endDateTime) == true
    }

    private fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }


    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
        childEventListener?.let {
            databaseReference.removeEventListener(it)
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, ProfileDetails::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }

}
