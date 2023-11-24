package com.example.civicall.Notification

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.google.android.material.imageview.ShapeableImageView

class NotificationAdapter(private val context: Context, private var notificationList: List<NotificationModel>) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val dateandTime: TextView = itemView.findViewById(R.id.dateandTime)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.notification_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notification = notificationList[position]

        holder.recTitle.text = notification.rectitle
        holder.dateandTime.text = notification.dateandTime

        // Set the default image to the ShapeableImageView
        holder.recImage.setImageResource(R.drawable.img_5)
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }

    fun updateData(newNotificationList: List<NotificationModel>) {
        notificationList = newNotificationList
        notifyDataSetChanged()
    }
}