package com.example.civicall.Recognition

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class RecognitionLeaderBoard : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var leaderboardAdapter: RecognitionAdapter
    private lateinit var userList: MutableList<User>
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recognition_leader_board)

        recyclerView = findViewById(R.id.recognitionRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        FirebaseDatabase.getInstance().purgeOutstandingWrites()

        userList = mutableListOf()
        leaderboardAdapter = RecognitionAdapter(this, userList)
        recyclerView.adapter = leaderboardAdapter
        val backbtn: ImageView = findViewById(R.id.backbtn)


        backbtn.setOnClickListener {
            super.onBackPressed()
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        databaseReference = FirebaseDatabase.getInstance().reference.child("Users")
        databaseReference.keepSynced(true)

        databaseReference.orderByChild("activepts").addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                userList.clear()
                for (snapshot in dataSnapshot.children) {
                    val verificationStatus = snapshot.child("verificationStatus").getValue(Boolean::class.java)

                    if (verificationStatus == true) {
                        // Now, you can fetch the other user details if needed
                        val user = snapshot.getValue(User::class.java)
                        user?.let {
                            userList.add(it)
                        }
                    }
                }
                userList.reverse()
                leaderboardAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error
            }
        })

    }
}


