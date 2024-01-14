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

class RequestVerificationAdapter(private val requestList: List<RequestData>) :
    RecyclerView.Adapter<RequestVerificationAdapter.RequestViewHolder>() {

    inner class RequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val title: TextView = itemView.findViewById(R.id.recTitle)
        val category: TextView = itemView.findViewById(R.id.schedule)
        val label: TextView = itemView.findViewById(R.id.label)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
        val approveTimeStamp: TextView = itemView.findViewById(R.id.dateandTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_recycler_item, parent, false)
        return RequestViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        val currentRequest = requestList[position]

        // Set label with a top margin of 30dp
        val labelLayoutParams = holder.label.layoutParams as ViewGroup.MarginLayoutParams
        labelLayoutParams.topMargin = dpToPx(25) // Use your desired top margin in dp
        holder.label.layoutParams = labelLayoutParams

        // Set text size for label, recTitle, and schedule to 12sp
        holder.label.textSize = 12f
        holder.title.textSize = 12f
        holder.category.textSize = 12f

        // Set label
        holder.label.text = "Your Request has been Approved"


        holder.approveTimeStamp.text = "Since: ${currentRequest.approveTimeStamp}"
        holder.title.text = "Title: ${currentRequest.title}"
        holder.category.text = "Category: ${currentRequest.category}"

        holder.recImage.setImageResource(R.drawable.approved)

        holder.categoryTextView.visibility = View.GONE
    }

    private fun dpToPx(dp: Int): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dp * scale).toInt()
    }

    override fun getItemCount(): Int {
        return requestList.size
    }

    data class RequestData(
        val title: String,
        val category: String,
        val approveTimeStamp: String
    )
}

