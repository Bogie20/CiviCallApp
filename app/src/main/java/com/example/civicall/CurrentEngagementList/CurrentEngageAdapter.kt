package com.example.civicall.CurrentEngagementList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.google.android.material.imageview.ShapeableImageView
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*

class CurrentEngageAdapter(private val currentEngagements: List<DataClassCurrent>) :
    RecyclerView.Adapter<CurrentEngageAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val engagementImage: ShapeableImageView = itemView.findViewById(R.id.engagementImage)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val location: TextView = itemView.findViewById(R.id.location)
        val dateAndTime: TextView = itemView.findViewById(R.id.dateandTime)
        val category: TextView = itemView.findViewById(R.id.category)
        val indicatorIcon: ShapeableImageView = itemView.findViewById(R.id.iconIndicator)
        val timeStamp: TextView = itemView.findViewById(R.id.dateTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.engagement_activity_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = currentEngagements[position]

        Glide.with(holder.itemView)
            .load(activity.engagementImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(holder.engagementImage)

        holder.recTitle.text = activity.titleEvent
        holder.location.text = activity.location
        holder.dateAndTime.text = "${activity.startDate} - ${activity.endDate}"
        holder.category.text = "Category: ${activity.category}"

        setIndicatorIcon(holder, activity.startDate, activity.endDate)

        holder.timeStamp.text = activity.timeStamp
    }

    override fun getItemCount(): Int {
        return currentEngagements.size
    }

    private fun isDateTimeInRange(selectedDateTime: String, startDate: String, endDate: String): Boolean {
        val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("Asia/Manila")

        val selectedDateTimeFormatted = sdf.parse(selectedDateTime)
        val startDateFormatted = sdf.parse(startDate)
        val endDateFormatted = sdf.parse(endDate)

        return selectedDateTimeFormatted?.inRange(startDateFormatted, endDateFormatted) ?: false
    }

    private fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone("Asia/Manila")
        return dateFormat.format(calendar.time)
    }

    private fun setIndicatorIcon(holder: ViewHolder, startDate: String, endDate: String) {
        val currentDate = getCurrentDate()

        val nearColor = ContextCompat.getColor(holder.itemView.context, R.color.redpink)
        val ongoingColor = ContextCompat.getColor(holder.itemView.context, R.color.blue)

        if (isDateTimeInRange(currentDate, startDate, endDate)) {
            setIndicatorIconWithColor(holder, R.drawable.play, ongoingColor)
        } else {
            setIndicatorIconWithColor(holder, R.drawable.near, nearColor)
        }
    }

    private fun setIndicatorIconWithColor(holder: ViewHolder, iconRes: Int, color: Int) {
        holder.indicatorIcon.setImageResource(iconRes)
        holder.indicatorIcon.setColorFilter(color)
    }

    private fun Date.inRange(start: Date, end: Date): Boolean {
        return this.after(start) && this.before(end)
    }

}
