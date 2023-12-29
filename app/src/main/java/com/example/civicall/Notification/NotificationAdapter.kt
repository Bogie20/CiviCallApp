package com.example.civicall.Notification

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.Notification.NotificationFragment.Companion.DATE_FORMAT
import com.example.civicall.R
import com.google.android.material.imageview.ShapeableImageView
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class NotificationAdapter(private val notificationList: List<DataClassNotif>) :
    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    inner class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val schedule: TextView = itemView.findViewById(R.id.schedule)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
        val dateandTime: TextView = itemView.findViewById(R.id.dateandTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.notification_recycler_item, parent, false)
        return NotificationViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val currentItem = notificationList[position]

        holder.categoryTextView.text = currentItem.category
        holder.recTitle.text = currentItem.title
        holder.schedule.text = "${currentItem.startDate} - ${currentItem.endDate}"

        val calendar = Calendar.getInstance()
        val currentDate = calendar.time
        val engagementStartDate = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(currentItem.startDate)

        val timeDifference = engagementStartDate?.time?.minus(currentDate.time) ?: 0

        if (timeDifference <= TWELVE_HOURS_IN_MILLIS && timeDifference > 0) {
            // Within 12 hours
            holder.dateandTime.text = currentItem.currentTime
            holder.itemView.findViewById<TextView>(R.id.label).text = "The engagement is near!"
        } else if (isEngagementOngoing(currentItem.startDate)) {
            // Display current date and time when the engagement is ongoing
            holder.dateandTime.text = currentItem.currentTime
            holder.itemView.findViewById<TextView>(R.id.label).text = "The engagement is On-Going Hurry!"
        } else {
            // Display the calculated timestamp when the engagement is upcoming
            holder.dateandTime.text = currentItem.timestamp
            holder.itemView.findViewById<TextView>(R.id.label).text = "The engagement is 24 hours away!"
        }

        Glide.with(holder.recImage.context)
            .load(currentItem.imageUrl)
            .into(holder.recImage)
    }

    companion object {
        private const val TWELVE_HOURS_IN_MILLIS = 12 * 60 * 60 * 1000
    }

    private fun isEngagementOngoing(startDateStr: String): Boolean {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        try {
            val startDate = dateFormat.parse(startDateStr)
            val currentDate = Calendar.getInstance().time

            // Check if the engagement has started
            return currentDate.after(startDate)
        } catch (e: ParseException) {
            // Handle the parsing exception
            e.printStackTrace()
        }
        // Default to false in case of errors
        return false
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }
}
