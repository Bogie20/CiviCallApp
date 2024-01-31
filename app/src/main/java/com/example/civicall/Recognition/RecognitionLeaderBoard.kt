package com.example.civicall.Recognition

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.MainMenu
import com.example.civicall.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.example.civicall.NetworkUtils
import java.text.SimpleDateFormat
import java.util.Locale

class RecognitionLeaderBoard : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var leaderboardAdapter: RecognitionAdapter
    private lateinit var userList: MutableList<User>
    private lateinit var databaseReference: DatabaseReference
    private lateinit var campusTitleTextView: TextView
    private lateinit var noPostsImage: ImageView
    private lateinit var noPostsText: TextView
    private lateinit var networkUtils: NetworkUtils
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recognition_leader_board)
        campusTitleTextView = findViewById(R.id.campusTitle)
        recyclerView = findViewById(R.id.recognitionRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        FirebaseDatabase.getInstance().purgeOutstandingWrites()
        noPostsImage = findViewById(R.id.noPostsImage)
        noPostsText = findViewById(R.id.noPostsText)
        userList = mutableListOf()
        leaderboardAdapter = RecognitionAdapter(this, userList)
        recyclerView.adapter = leaderboardAdapter
        networkUtils = NetworkUtils(this)
        networkUtils.initialize()
        val backbtn: ImageView = findViewById(R.id.backbtn)
        val filterCampus: ImageView = findViewById(R.id.filterCampus)
        filterCampus.setOnClickListener {
            showCampusFilterDialog()
        }

        backbtn.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
        }
        databaseReference = FirebaseDatabase.getInstance().reference.child("Users")
        databaseReference.keepSynced(true)

        val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid
        if (currentUserUid != null) {
            databaseReference = FirebaseDatabase.getInstance().reference.child("Users")
            databaseReference.keepSynced(true)

            // Get the current user's campus
            FirebaseDatabase.getInstance().reference.child("Users").child(currentUserUid)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val currentUserCampus =
                            dataSnapshot.child("campus").getValue(String::class.java)
                        campusTitleTextView.text = currentUserCampus ?: ""
                        val query = if (currentUserCampus.isNullOrEmpty()) {
                            databaseReference.orderByChild("activepts")
                        } else {
                            databaseReference.orderByChild("campus").equalTo(currentUserCampus)
                        }

                        query.addListenerForSingleValueEvent(object : ValueEventListener {
                            @SuppressLint("NotifyDataSetChanged")
                            override fun onDataChange(dataSnapshot: DataSnapshot) {
                                userList.clear()
                                val users = mutableListOf<User>()

                                val oneYearInMillis = 365 * 24 * 60 * 60 * 1000L  // One year in milliseconds

                                for (snapshot in dataSnapshot.children) {
                                    val activePoints = snapshot.child("activepts").getValue(Int::class.java)

                                    // Skip processing if activepts is less than or equal to 0
                                    if (activePoints != null && activePoints <= 0) {
                                        continue
                                    }

                                    // Continue processing for users with activepts greater than 0
                                    val lastLoginString = snapshot.child("lastLogin").getValue(String::class.java)

                                    // Skip processing if lastLogin is empty or null
                                    if (lastLoginString.isNullOrEmpty()) {
                                        continue
                                    }

                                    val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
                                    val lastLoginDate = sdf.parse(lastLoginString)

                                    // Check if last login is more than 1 year ago
                                    val currentTime = System.currentTimeMillis()
                                    if (lastLoginDate != null && currentTime - lastLoginDate.time >= oneYearInMillis) {
                                        // Filter out users with last login more than 1 year ago
                                        continue
                                    }

                                    // Continue processing for users with last login within the past year
                                    val verificationStatus = snapshot.child("verificationStatus").getValue(Boolean::class.java)
                                    val campus = snapshot.child("campus").getValue(String::class.java)

                                    val currentUserCampus = campusTitleTextView.text.toString()

                                    // Skip processing if the current user's campus is empty or null
                                    if (currentUserCampus.isNullOrEmpty()) {
                                        continue
                                    }

                                    // Check if the user's campus matches the current user's campus
                                    if (verificationStatus == true && campus == currentUserCampus) {
                                        val user = snapshot.getValue(User::class.java)
                                        user?.let {
                                            users.add(it)
                                        }
                                    }
                                }

                                users.sortByDescending { it.activepts }

                                userList.addAll(users)

                                leaderboardAdapter.notifyDataSetChanged()

                                handleNoPostsMessage(users, currentUserCampus ?: "")

                            }

                            override fun onCancelled(databaseError: DatabaseError) {

                            }
                        })
                    }

                    override fun onCancelled(databaseError: DatabaseError) {

                    }
                })
        }
    }
    private fun handleNoPostsMessage(users: List<User>, selectedCampus: String) {
        if (users.isEmpty()) {
            showNoPostsMessage(selectedCampus)
        } else {
            hideNoPostsMessage()
        }
    }
    private var isFilterDialogShowing = false // Add this variable

    private fun showCampusFilterDialog() {
        if (isFilterDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.filter_campus, null)
        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()


        val nasugbu: TextView = dialogView.findViewById(R.id.Nasugbu)
        val balayan: TextView = dialogView.findViewById(R.id.Balayan)
        val malvar: TextView = dialogView.findViewById(R.id.Malvar)
        val lemery: TextView = dialogView.findViewById(R.id.Lemery)
        val lobo: TextView = dialogView.findViewById(R.id.Lobo)
        val mabini: TextView = dialogView.findViewById(R.id.Mabini)
        val rosario: TextView = dialogView.findViewById(R.id.Rosario)
        val pabloI: TextView = dialogView.findViewById(R.id.PabloI)
        val pabloII: TextView = dialogView.findViewById(R.id.PabloII)
        val sanjuan: TextView = dialogView.findViewById(R.id.SanJuan)
        val lipa: TextView = dialogView.findViewById(R.id.Lipa)
        val all: TextView = dialogView.findViewById(R.id.All)

        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink


        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        nasugbu.setOnClickListener {
            filterByCategory("ARASOF Nasugbu Campus")
            alertDialog.dismiss()
        }
        balayan.setOnClickListener {
            filterByCategory("Balayan Campus")
            alertDialog.dismiss()
        }
        malvar.setOnClickListener {
            filterByCategory("JPLPC Malvar Campus")
            alertDialog.dismiss()
        }
        lemery.setOnClickListener {
            filterByCategory("Lemery Campus")
            alertDialog.dismiss()
        }
        lobo.setOnClickListener {
            filterByCategory("Lobo Campus")
            alertDialog.dismiss()
        }
        mabini.setOnClickListener {
            filterByCategory("Mabini Campus")
            alertDialog.dismiss()
        }
        rosario.setOnClickListener {
            filterByCategory("Rosario Campus")
            alertDialog.dismiss()
        }
        pabloI.setOnClickListener {
            filterByCategory("Pablo Borbon Campus I")
            alertDialog.dismiss()
        }
        pabloII.setOnClickListener {
            filterByCategory("Pablo Borbon Campus II")
            alertDialog.dismiss()
        }
        sanjuan.setOnClickListener {
            filterByCategory("San Juan Campus")
            alertDialog.dismiss()
        }
        lipa.setOnClickListener {
            filterByCategory("Lipa Campus")
            alertDialog.dismiss()
        }
        all.setOnClickListener {
            filterByCategory("")
            alertDialog.dismiss()
        }

        alertDialog.setOnDismissListener {
            isFilterDialogShowing = false
        }

        alertDialog.show()
        isFilterDialogShowing =
            true
    }

    private fun dismissCustomDialog() {
        if (isFilterDialogShowing) {

            isFilterDialogShowing = false
        }
    }

    private fun filterByCategory(selectedCampus: String) {
        val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid

        if (currentUserUid != null) {
            databaseReference = FirebaseDatabase.getInstance().reference.child("Users")
            databaseReference.keepSynced(true)

            // Update the text based on the selected campus
            campusTitleTextView.text = when {
                selectedCampus.isEmpty() -> "\"BatStateU TNEU Civic Champions\""
                else -> selectedCampus
            }

            val query = if (selectedCampus.isEmpty()) {
                databaseReference.orderByChild("activepts")
            } else {
                databaseReference.orderByChild("campus").equalTo(selectedCampus)
            }

            query.addListenerForSingleValueEvent(object : ValueEventListener {
                @SuppressLint("NotifyDataSetChanged")
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    userList.clear()
                    val users = mutableListOf<User>()

                    val oneYearInMillis = 365 * 24 * 60 * 60 * 1000L  // One year in milliseconds

                    for (snapshot in dataSnapshot.children) {
                        val activePoints = snapshot.child("activepts").getValue(Int::class.java)

                        // Skip processing if activepts is less than or equal to 0
                        if (activePoints != null && activePoints <= 0) {
                            continue
                        }

                        // Continue processing for users with activepts greater than 0
                        val lastLoginString = snapshot.child("lastLogin").getValue(String::class.java)

                        // Skip processing if lastLogin is empty or null
                        if (lastLoginString.isNullOrEmpty()) {
                            continue
                        }

                        val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
                        val lastLoginDate = sdf.parse(lastLoginString)

                        // Check if last login is more than 1 year ago
                        val currentTime = System.currentTimeMillis()
                        if (lastLoginDate != null && currentTime - lastLoginDate.time >= oneYearInMillis) {
                            // Filter out users with last login more than 1 year ago
                            continue
                        }

                        // Continue processing for users with last login within the past year
                        val verificationStatus = snapshot.child("verificationStatus").getValue(Boolean::class.java)
                        val campus = snapshot.child("campus").getValue(String::class.java)

                        if (verificationStatus == true && !campus.isNullOrEmpty()) {
                            val user = snapshot.getValue(User::class.java)
                            user?.let {
                                users.add(it)
                            }
                        }
                    }


                    users.sortByDescending { it.activepts }

                    userList.addAll(users)

                    leaderboardAdapter.notifyDataSetChanged()


                    // Handle no posts
                    if (users.isEmpty()) {
                        showNoPostsMessage(selectedCampus)
                    } else {
                        hideNoPostsMessage()
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })
        }
    }
    private fun showNoPostsMessage(campus: String) {
        noPostsImage.setImageResource(R.drawable.leaderboard)
        noPostsText.text = "There are no lists from \"$campus\" that are currently available."
        noPostsImage.visibility = View.VISIBLE
        noPostsText.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    private fun hideNoPostsMessage() {
        noPostsImage.visibility = View.GONE
        noPostsText.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }
    override fun onDestroy() {
        super.onDestroy()
        networkUtils.cleanup()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainMenu::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit)
    }

}