package com.example.civicall.Notification
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class NotificationAdapter(private val context: Context, private var notificationList: List<NotificationModel>) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val dateandTime: TextView = itemView.findViewById(R.id.dateandTime)
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)

        fun bind(title: String, startDate: String, category: String) {
            recTitle.text = title
            dateandTime.text = startDate
            categoryTextView.text = category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.notification_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notification = notificationList[position]
        holder.bind(notification.title, notification.startDate, notification.category)

        // Load image using Picasso if imageUrl is not empty or null
        if (!notification.recImage.isNullOrEmpty()) {
            Picasso.get()
                .load(notification.recImage)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.img_5)
                .into(holder.recImage)
        } else {
            // Handle case when imageUrl is empty or null
            // You can set a default image or hide the ImageView
            holder.recImage.setImageResource(R.drawable.img_5)
        }
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }

    fun updateData(newNotificationList: List<NotificationModel>) {
        notificationList = newNotificationList
        notifyDataSetChanged()
    }

    fun clearData() {
        notificationList = emptyList()
        notifyDataSetChanged()
    }
}
