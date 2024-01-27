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
class EngagementJoinedAdapter(private val joinedList: List<EngagementJoinedData>) :
    RecyclerView.Adapter<EngagementJoinedAdapter.EngagementJoinedViewHolder>() {

    inner class EngagementJoinedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val title: TextView = itemView.findViewById(R.id.recTitle)
        val schedule: TextView = itemView.findViewById(R.id.schedule)
        val label: TextView = itemView.findViewById(R.id.label)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
        val timeStamp: TextView = itemView.findViewById(R.id.dateandTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngagementJoinedViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_recycler_item, parent, false)
        return EngagementJoinedViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EngagementJoinedViewHolder, position: Int) {
        val currentJoinedEngagement = joinedList[position]

        val labelLayoutParams = holder.label.layoutParams as ViewGroup.MarginLayoutParams
        labelLayoutParams.topMargin = dpToPx(15) // Use your desired top margin in dp
        holder.label.layoutParams = labelLayoutParams

        // Set text size for label, recTitle, and schedule to 12sp
        holder.label.textSize = 12f
        holder.title.textSize = 11f
        holder.schedule.textSize = 11f
        holder.categoryTextView.textSize = 11f

        // Set label
        holder.label.text = "You've Joined the Cause"

        holder.timeStamp.text = "Since: ${currentJoinedEngagement.timestamp}"
        holder.schedule.text = "Formal Start: ${currentJoinedEngagement.startDate}"
        holder.title.text = "Title: ${currentJoinedEngagement.titleEvent}"
        holder.categoryTextView.text = "Category: ${currentJoinedEngagement.category}"

        holder.recImage.setImageResource(R.drawable.joinedengage)

    }

    private fun dpToPx(dp: Int): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dp * scale).toInt()
    }

    override fun getItemCount(): Int {
        return joinedList.size
    }

    data class EngagementJoinedData(
        val postKey: String,
        val titleEvent: String,
        val category: String,
        val startDate: String,
        val timestamp: String
    )

}
