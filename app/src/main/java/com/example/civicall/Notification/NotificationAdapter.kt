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

        holder.categoryTextView.text = "Category: ${currentItem.category}"
        holder.recTitle.text = currentItem.titleEvent
        holder.schedule.text = "${currentItem.startDate} - ${currentItem.endDate}"

        val calendar = Calendar.getInstance()
        val currentDate = calendar.time
        val engagementStartDate =
            SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(currentItem.startDate)
        val engagementEndDate =
            SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(currentItem.endDate)

        val timeDifferenceStart = engagementStartDate?.time?.minus(currentDate.time) ?: 0
        val timeDifferenceEnd = engagementEndDate?.time?.minus(currentDate.time) ?: 0

        if (timeDifferenceStart <= TWELVE_HOURS_IN_MILLIS && timeDifferenceStart > 0) {
            val timestampMinus12Hours = calculateTimestampMinusHours(currentItem.startDate, 12)
            holder.dateandTime.text = "Since: ${timestampMinus12Hours}"
            holder.itemView.findViewById<TextView>(R.id.label).text = "12 hours until the engagement!"
        } else if (isEngagementOngoing(currentItem.startDate, currentItem.endDate)) {

        holder.dateandTime.text = "Since: ${currentItem.startDate}"
        holder.itemView.findViewById<TextView>(R.id.label).text = "The engagement has started!"

       } else if (timeDifferenceEnd <= 0) {
        // Engagement has finished
        holder.dateandTime.text = "Since: ${currentItem.endDate}"
        holder.itemView.findViewById<TextView>(R.id.label).text = "Finish! Rate to claim points if attended"
        } else {
            // Outside 12 hours, show "The engagement is 24 hours away!" until it's less than 12 hours away
            if (timeDifferenceStart > TWELVE_HOURS_IN_MILLIS) {
                holder.dateandTime.text = "Since: ${currentItem.timestamp}"
                holder.itemView.findViewById<TextView>(R.id.label).text = "The engagement is 24 hours away!"
            }
        }
        Glide.with(holder.recImage.context)
            .load(currentItem.imageUrl)
            .into(holder.recImage)
    }


    companion object {
        private const val TWELVE_HOURS_IN_MILLIS = 12 * 60 * 60 * 1000
        private const val ONE_MINUTE_IN_MILLIS = 1 * 60 * 1000
    }

    private fun isEngagementOngoing(startDateStr: String, endDateStr: String): Boolean {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        try {
            val startDate = dateFormat.parse(startDateStr)
            val endDate = dateFormat.parse(endDateStr)
            val currentDate = Calendar.getInstance().time

            // Check if the engagement has started and is ongoing, but not more than 1 minute after endDate
            return currentDate.after(startDate) && currentDate.before(endDate) && endDate.time - currentDate.time > ONE_MINUTE_IN_MILLIS
        } catch (e: ParseException) {
            // Handle the parsing exception
            e.printStackTrace()
        }
        // Default to false in case of errors
        return false
    }
    private fun calculateTimestampMinusHours(timestamp: String, hours: Int): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        try {
            val originalDate = dateFormat.parse(timestamp)

            // Subtract hours from the original date
            val calendar = Calendar.getInstance()
            calendar.time = originalDate
            calendar.add(Calendar.HOUR_OF_DAY, -hours)

            // Format the result as a timestamp
            return dateFormat.format(calendar.time)
        } catch (e: ParseException) {
            // Handle the parsing exception
            e.printStackTrace()
        }
        // Default to an empty string in case of errors
        return ""
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }
    private fun calculateTimestampMinusMinutes(timestamp: String, minutes: Int): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        try {
            val originalDate = dateFormat.parse(timestamp)

            // Subtract minutes from the original date
            val calendar = Calendar.getInstance()
            calendar.time = originalDate
            calendar.add(Calendar.MINUTE, -minutes)

            // Format the result as a timestamp
            return dateFormat.format(calendar.time)
        } catch (e: ParseException) {
            // Handle the parsing exception
            e.printStackTrace()
        }
        // Default to an empty string in case of errors
        return ""
    }
}
