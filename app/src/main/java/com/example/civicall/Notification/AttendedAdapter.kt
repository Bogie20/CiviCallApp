package com.example.civicall.Notification

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.android.material.imageview.ShapeableImageView

class AttendedAdapter(private val attendedList: List<AttendedData>) :
    RecyclerView.Adapter<AttendedAdapter.AttendedViewHolder>() {

    inner class AttendedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val title: TextView = itemView.findViewById(R.id.recTitle)
        val label: TextView = itemView.findViewById(R.id.label)
        val category: TextView = itemView.findViewById(R.id.schedule)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
        val dateAndTime: TextView = itemView.findViewById(R.id.dateandTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendedViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_recycler_item, parent, false)
        return AttendedViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AttendedViewHolder, position: Int) {
        val currentAttendedEvent = attendedList[position]

        val labelLayoutParams = holder.label.layoutParams as ViewGroup.MarginLayoutParams
        labelLayoutParams.topMargin = dpToPx(25) // Use your desired top margin in dp
        holder.label.layoutParams = labelLayoutParams

        // Set text size for label, recTitle, and dateAndTime to 12sp
        holder.label.textSize = 12f
        holder.title.textSize = 11f
        holder.category.textSize = 11f
        holder.dateAndTime.textSize = 11f
        holder.categoryTextView.textSize = 11f

        holder.label.text = "Attendance confirmed! Rate to claim points."

        holder.dateAndTime.text = "Since: ${currentAttendedEvent.attendedStamp}"
        holder.title.text = "Title: ${currentAttendedEvent.titleEvent}"
        holder.category.text = "Category: ${currentAttendedEvent.category}"
        holder.recImage.setImageResource(R.drawable.attendednotif)
        holder.categoryTextView.visibility = View.GONE
    }

    private fun dpToPx(dp: Int): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dp * scale).toInt()
    }

    override fun getItemCount(): Int {
        return attendedList.size
    }

    data class AttendedData(
        val postKey: String,
        val titleEvent: String,
        val category: String,
        val attendedStamp: String
    )
}
