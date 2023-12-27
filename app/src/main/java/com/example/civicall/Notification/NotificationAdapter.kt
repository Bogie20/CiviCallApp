package com.example.civicall.Notification

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.google.android.material.imageview.ShapeableImageView

class NotificationAdapter(private val notificationList: List<DataClassNotif>) :
    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    inner class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val schedule: TextView = itemView.findViewById(R.id.schedule)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
        val dateandTIme: TextView = itemView.findViewById(R.id.dateandTime)
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
        holder.dateandTIme.text = currentItem.timestamp

        // Set the text for the label TextView
        holder.itemView.findViewById<TextView>(R.id.label).text = "Exciting news – you're in!"

        // Load image using Glide or your preferred image loading library
        Glide.with(holder.recImage.context)
            .load(currentItem.imageUrl)
            .into(holder.recImage)
    }



    override fun getItemCount(): Int {
        return notificationList.size
    }
}
