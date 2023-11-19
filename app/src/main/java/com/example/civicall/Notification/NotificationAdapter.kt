package com.example.civicall.Notification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.android.material.imageview.ShapeableImageView

class NotificationAdapter(private val notificationList: List<NotificationModel>) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notification = notificationList[position]
        holder.recTitle.text = notification.title
        holder.dateandTime.text = notification.dateAndTime
        // Set other data as needed, e.g., image
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val dateandTime: TextView = itemView.findViewById(R.id.dateandTime)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
        // Set click listeners or other actions as needed
    }
}