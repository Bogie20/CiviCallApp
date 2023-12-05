package com.example.civicall.Calendar

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.CivicEngagementPost.DataClass
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
    private val currentUserUid = FirebaseAuth.getInstance().currentUser?.uid

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.calendar_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val engagementData = engagementList[position]

        Glide.with(holder.itemView)
            .load(engagementData.engagementImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(holder.engagementImage)
        holder.recTitle.text = engagementData.recTitle
        holder.location.text = engagementData.location
        holder.dateAndTime.text = engagementData.dateAndTime

        val currentDate = Calendar.getInstance(timeZone).time
        val sdf = SimpleDateFormat("MM/dd/yyyy HH:mm", Locale.getDefault()).apply {
            timeZone = this@CalendarAdapter.timeZone
        }
        val startDate = sdf.parse(engagementData.dateAndTime.split(" - ")[0]) ?: Date()
        val endDate = sdf.parse(engagementData.dateAndTime.split(" - ")[1]) ?: Date()

        val nearColor = ContextCompat.getColor(holder.itemView.context, R.color.redpink)
        val ongoingColor = ContextCompat.getColor(holder.itemView.context, R.color.blue)
        val finishColor = ContextCompat.getColor(holder.itemView.context, R.color.greenish)
        val notAttendedColor = ContextCompat.getColor(holder.itemView.context, R.color.red)

        if (currentDate.before(startDate)) {
            // Engagement is near
            holder.indicatorIcon.setImageResource(R.drawable.near)
            holder.indicatorIcon.setColorFilter(nearColor)
        } else if (currentDate in startDate..endDate) {
            // Engagement is ongoing
            holder.indicatorIcon.setImageResource(R.drawable.play)
            holder.indicatorIcon.setColorFilter(ongoingColor)
        } else {
            val engagementId = engagementData.postKey

            if (currentUserUid != null && engagementId != null) {
                val participantsRef = FirebaseDatabase.getInstance().reference
                    .child("Upload Engagement")
                    .child(engagementId)
                    .child("Participants")

                participantsRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val hasAttended = dataSnapshot.child(currentUserUid).getValue(Boolean::class.java) ?: false

                        if (currentDate.after(endDate) && !hasAttended) {
                            // User did not attend the engagement and it's past the end date
                            holder.indicatorIcon.setImageResource(R.drawable.broken)
                            holder.indicatorIcon.setColorFilter(notAttendedColor)
                        }else if (currentDate.after(endDate) && hasAttended) {

                            holder.indicatorIcon.setImageResource(R.drawable.finishnapo)
                            holder.indicatorIcon.setColorFilter(finishColor)
                        } else {
                            // Handle other cases if needed
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Handle onCancelled
                    }
                })
            }
        }
        }
    override fun getItemCount(): Int {
        return engagementList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val engagementImage: ImageView = itemView.findViewById(R.id.engagementImage)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val location: TextView = itemView.findViewById(R.id.location)
        val dateAndTime: TextView = itemView.findViewById(R.id.dateandTime)
        val indicatorIcon: ShapeableImageView = itemView.findViewById(R.id.iconIndicator)
    }
}
