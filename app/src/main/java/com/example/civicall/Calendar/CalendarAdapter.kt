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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.calendar_recycler_item, parent, false)
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
        holder.startDateAndEndDate.text =
            "${engagementData.startDate} - ${engagementData.endDate}"  // Updated line
        holder.engagementId = engagementData.postKey
        val currentDate = Calendar.getInstance(timeZone).time
        val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault()).apply {
            timeZone = this@CalendarAdapter.timeZone
        }
        val startDate = sdf.parse(engagementData.startDate) ?: Date()  // Updated line
        val endDate = sdf.parse(engagementData.endDate) ?: Date()  // Updated line

        setIndicatorIcon(holder, currentDate, startDate, endDate)

        val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid
        val engagementId = holder.engagementId
        if (currentUserUid != null && engagementId != null) {
            val participantsRef = FirebaseDatabase.getInstance().getReference("Upload Engagement")
                .child(engagementId)
                .child("Participants")
                .child(currentUserUid)

            participantsRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(participantSnapshot: DataSnapshot) {
                    val joined =
                        participantSnapshot.child("joined").getValue(Boolean::class.java) ?: false

                    if (currentDate.after(endDate)) {
                        if (!joined) {
                            setIndicatorIconWithColor(
                                holder,
                                R.drawable.broken,
                                ContextCompat.getColor(holder.itemView.context, R.color.red)
                            )
                        } else {
                            setIndicatorIconWithColor(
                                holder,
                                R.drawable.finishnapo,
                                ContextCompat.getColor(holder.itemView.context, R.color.greenish)
                            )
                        }
                    } else {
                        // Handle the case when the current date is not after endDate
                        // Set indicator icon based on startDate, endDate, and currentDate
                        setIndicatorIcon(holder, currentDate, startDate, endDate)
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Handle onCancelled
                }
            })
        }
    }
    private fun setIndicatorIcon(
        holder: ViewHolder,
        currentDate: Date,
        startDate: Date,
        endDate: Date
    ) {
        val nearColor = ContextCompat.getColor(holder.itemView.context, R.color.redpink)
        val ongoingColor = ContextCompat.getColor(holder.itemView.context, R.color.blue)

        if (currentDate.before(startDate)) {
            setIndicatorIconWithColor(holder, R.drawable.near, nearColor)
        } else if (currentDate in startDate..endDate) {
            setIndicatorIconWithColor(holder, R.drawable.play, ongoingColor)
        }
    }

    private fun setIndicatorIconWithColor(holder: ViewHolder, iconRes: Int, color: Int) {
        holder.indicatorIcon.setImageResource(iconRes)
        holder.indicatorIcon.setColorFilter(color)
    }

    override fun getItemCount(): Int {
        return engagementList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val engagementImage: ImageView = itemView.findViewById(R.id.engagementImage)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val location: TextView = itemView.findViewById(R.id.location)
        val startDateAndEndDate: TextView = itemView.findViewById(R.id.dateandTime)
        val indicatorIcon: ShapeableImageView = itemView.findViewById(R.id.iconIndicator)
        var engagementId: String? = null
    }
}