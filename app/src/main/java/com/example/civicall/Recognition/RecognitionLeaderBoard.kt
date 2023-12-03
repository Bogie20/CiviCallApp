package com.example.civicall.Recognition

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.firebase.auth.FirebaseAuth
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
    private lateinit var campusTitleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recognition_leader_board)
        campusTitleTextView = findViewById(R.id.campusTitle)
        recyclerView = findViewById(R.id.recognitionRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        FirebaseDatabase.getInstance().purgeOutstandingWrites()

        userList = mutableListOf()
        leaderboardAdapter = RecognitionAdapter(this, userList)
        recyclerView.adapter = leaderboardAdapter
        val backbtn: ImageView = findViewById(R.id.backbtn)
        val filterCampus: ImageView = findViewById(R.id.filterCampus)
        filterCampus.setOnClickListener {
            showCampusFilterDialog()
        }

        backbtn.setOnClickListener {
            super.onBackPressed()
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
                            override fun onDataChange(dataSnapshot: DataSnapshot) {
                                userList.clear()
                                val users = mutableListOf<User>()

                                for (snapshot in dataSnapshot.children) {
                                    // Filter out users with verificationStatus = false
                                    val verificationStatus =
                                        snapshot.child("verificationStatus")
                                            .getValue(Boolean::class.java)

                                    if (verificationStatus == true) {
                                        val user = snapshot.getValue(User::class.java)
                                        user?.let {
                                            users.add(it)
                                        }
                                    }
                                }

                                // Sort users by activepts in descending order
                                users.sortByDescending { it.activepts }

                                // Add sorted users to the main user list
                                userList.addAll(users)

                                leaderboardAdapter.notifyDataSetChanged()
                            }

                            override fun onCancelled(databaseError: DatabaseError) {
                                // Handle error
                            }
                        })
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Handle error
                    }
                })
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
                selectedCampus.isEmpty() -> "BatStateU TNEU Overall Champions"
                else -> selectedCampus
            }

            val query = if (selectedCampus.isEmpty()) {
                databaseReference.orderByChild("activepts")
            } else {
                databaseReference.orderByChild("campus").equalTo(selectedCampus)
            }

            query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    userList.clear()
                    val users = mutableListOf<User>()

                    for (snapshot in dataSnapshot.children) {
                        // Filter out users with verificationStatus = false
                        val verificationStatus =
                            snapshot.child("verificationStatus").getValue(Boolean::class.java)

                        if (verificationStatus == true) {
                            val user = snapshot.getValue(User::class.java)
                            user?.let {
                                users.add(it)
                            }
                        }
                    }

                    // Sort users by activepts in descending order
                    users.sortByDescending { it.activepts }

                    // Add sorted users to the main user list
                    userList.addAll(users)

                    leaderboardAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle error
                }
            })
        }
    }
}