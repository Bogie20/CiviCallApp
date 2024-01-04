package com.example.civicall.Calendar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.google.android.material.imageview.ShapeableImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class CalendarAdapter(private val engagementList: List<CalendarData>) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    private val timeZone = TimeZone.getTimeZone("Asia/Manila")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_recycler_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val engagementData = engagementList[position]

        Glide.with(holder.itemView)
            .load(engagementData.engagementImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(holder.engagementImage)
        holder.recTitle.text = engagementData.recTitle
        holder.location.text = engagementData.location
        holder.startDateAndEndDate.text = "Schedule: ${engagementData.startDate} - ${engagementData.endDate}"
        holder.engagementId = engagementData.postKey

        val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid
        val engagementId = holder.engagementId
        if (currentUserUid != null && engagementId != null) {
            val participantsRef = FirebaseDatabase.getInstance().getReference("Upload Engagement")
                .child(engagementId)
                .child("Participants")
                .child(currentUserUid)

            participantsRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(participantSnapshot: DataSnapshot) {
                    // Handle changes in participant data if needed
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle onCancelled
                }
            })
        }
    }

    override fun getItemCount(): Int {
        return engagementList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val engagementImage: ImageView = itemView.findViewById(R.id.engagementImage)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val location: TextView = itemView.findViewById(R.id.location)
        val startDateAndEndDate: TextView = itemView.findViewById(R.id.dateandTime)
        var engagementId: String? = null
    }
}
