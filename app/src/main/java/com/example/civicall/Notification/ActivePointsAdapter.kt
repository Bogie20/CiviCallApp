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

class ActivePointsAdapter(private val requestList: List<ActiveData>) :
    RecyclerView.Adapter<ActivePointsAdapter.ActViewHolder>() {

    inner class ActViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val titleEngagement: TextView = itemView.findViewById(R.id.recTitle)
        val activeptsEarned: TextView = itemView.findViewById(R.id.schedule)
        val label: TextView = itemView.findViewById(R.id.label)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
        val dateandTime: TextView = itemView.findViewById(R.id.dateandTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_recycler_item, parent, false)
        return ActViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ActViewHolder, position: Int) {
        val currentRequest = requestList[position]

        // Set label with a top margin of 30dp
        val labelLayoutParams = holder.label.layoutParams as ViewGroup.MarginLayoutParams
        labelLayoutParams.topMargin = dpToPx(25) // Use your desired top margin in dp
        holder.label.layoutParams = labelLayoutParams

        // Set text size for label, recTitle, and schedule to 12sp
        holder.label.textSize = 12f
        holder.titleEngagement.textSize = 12f
        holder.activeptsEarned.textSize = 12f

        // Set label
        holder.label.text = "You have earned Active Points."

        holder.dateandTime.text = "Since: ${currentRequest.receivedStamp}"
        holder.titleEngagement.text = "Title: ${currentRequest.titleEvent}"
        holder.activeptsEarned.text = "Claimed: ${currentRequest.activepts} pts"

        holder.recImage.setImageResource(R.drawable.rate)
        holder.categoryTextView.visibility = View.GONE
    }

    private fun dpToPx(dp: Int): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dp * scale).toInt()
    }

    override fun getItemCount(): Int {
        return requestList.size
    }

    data class ActiveData(
        val postKey: String,
        val titleEvent: String,
        val activepts: Int,
        val receivedStamp: String
    )
}

