package com.example.civicall.Recognition

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.MainMenu
import com.google.firebase.database.*
import com.example.civicall.R


class RecognitionLeaderBoard : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var leaderboardAdapter: RecognitionAdapter
    private lateinit var userList: MutableList<Users>
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recognition_leader_board)

        recyclerView = findViewById(R.id.recognitionRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userList = mutableListOf()
        leaderboardAdapter = RecognitionAdapter(this, userList)
        recyclerView.adapter = leaderboardAdapter
        val backbtn: ImageView = findViewById(R.id.backbtn)


        backbtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
            onBackPressed()
        }
        databaseReference = FirebaseDatabase.getInstance().reference.child("Users")

        databaseReference.orderByChild("activepts").addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                userList.clear()
                for (snapshot in dataSnapshot.children) {
                    val user = snapshot.getValue(Users::class.java)
                    user?.let {
                        userList.add(it)
                    }
                }
                userList.reverse() // If you want to display in descending order
                leaderboardAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error
            }
        })
    }
}


