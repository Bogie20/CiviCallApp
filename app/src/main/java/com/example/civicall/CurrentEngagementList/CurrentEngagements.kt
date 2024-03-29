package com.example.civicall.CurrentEngagementList

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.ProfileDetails
import com.example.civicall.databinding.ActivityCurrentEngagementsBinding
import com.example.civicall.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*
import com.example.civicall.NetworkUtils
class CurrentEngagements : AppCompatActivity() {
    private lateinit var binding: ActivityCurrentEngagementsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var currentEngageAdapter: CurrentEngageAdapter
    private lateinit var currentEngagements: MutableList<DataClassCurrent>
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private var childEventListener: ChildEventListener? = null
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrentEngagementsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()

        recyclerView = binding.currentRecycler
        auth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().reference.child("Upload_Engagement")
        currentEngagements = mutableListOf()
        currentEngageAdapter = CurrentEngageAdapter(currentEngagements)

        recyclerView.adapter = currentEngageAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchCurrentEngagements()

        binding.backbtn.setOnClickListener {
            val intent = Intent(this, ProfileDetails::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
    }

    private fun fetchCurrentEngagements() {
        val currentUserUid = auth.currentUser?.uid
        val currentDate = getCurrentDate()

        val participantsQuery = databaseReference.orderByChild("Participants/$currentUserUid/joined").equalTo(false)
        participantsQuery.addListenerForSingleValueEvent(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                currentEngagements.clear()

                for (engagementSnapshot in snapshot.children) {
                    val startDate = engagementSnapshot.child("startDate").getValue(String::class.java) ?: ""
                    val endDate = engagementSnapshot.child("endDate").getValue(String::class.java) ?: ""

                    val isParticipant = engagementSnapshot.child("Participants/$currentUserUid/joined").getValue(Boolean::class.java) ?: false
                    val contributionStatus = engagementSnapshot.child("TransparencyImage/$currentUserUid/contributionStatus").getValue(Boolean::class.java) ?: false

                    if (isDateTimeInRange(currentDate, endDate) && !(isParticipant || contributionStatus)) {
                        val postKey = engagementSnapshot.key ?: ""
                        val currentEngagement = DataClassCurrent(
                            engagementSnapshot.child("image").getValue(String::class.java) ?: "",
                            engagementSnapshot.child("titleEvent").getValue(String::class.java) ?: "",
                            engagementSnapshot.child("location").getValue(String::class.java) ?: "",
                            engagementSnapshot.child("category").getValue(String::class.java) ?: "",
                            startDate,
                            endDate,
                            postKey,
                            engagementSnapshot.child("Participants/$currentUserUid/timestamp").getValue(String::class.java) ?: ""
                        )
                        currentEngagements.add(currentEngagement)
                    }
                }
                currentEngagements.sortByDescending { it.timeStamp }
                currentEngageAdapter.notifyDataSetChanged()
                currentEngageAdapter = CurrentEngageAdapter(currentEngagements)
                recyclerView.adapter = currentEngageAdapter

                // Show or hide noPostsImage and noPostsText based on the data
                if (currentEngagements.isEmpty()) {
                    binding.noPostsImage.visibility = View.VISIBLE
                    binding.noPostsText.visibility = View.VISIBLE
                } else {
                    binding.noPostsImage.visibility = View.GONE
                    binding.noPostsText.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                val errorMessage = "Database error: ${error.message}"

                Log.e("CurrentEngagements", errorMessage)

                Toast.makeText(this@CurrentEngagements, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone("Asia/Manila")
        return dateFormat.format(calendar.time)
    }
    private fun isDateTimeInRange(selectedDateTime: String, endDateTime: String): Boolean {
        val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("Asia/Manila")

        val selectedDateTimeFormatted = sdf.parse(selectedDateTime)
        val endDateTimeFormatted = sdf.parse(endDateTime)

        // Show engagements only if the current date and time are before the endDate
        return selectedDateTimeFormatted?.before(endDateTimeFormatted) ?: false
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
