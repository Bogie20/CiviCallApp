package com.example.civicall.NotificationTwo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class ActivePtsAdapter(private val notificationList: List<DataClassAct>) :
    RecyclerView.Adapter<ActivePtsAdapter.NotificationViewHolder>() {

    inner class NotificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleEngagement: TextView = itemView.findViewById(R.id.titleEngagement)
        val activeptsEarned: TextView = itemView.findViewById(R.id.activeptsEarned)
        val dateandTime: TextView = itemView.findViewById(R.id.dateandTime)
        val labelPts: TextView = itemView.findViewById(R.id.labelPts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activepts_item, parent, false)
        return NotificationViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val currentItem = notificationList[position]

        holder.activeptsEarned.text = "${currentItem.activepts} Points"
        holder.titleEngagement.text = currentItem.title
        holder.dateandTime.text = currentItem.attendedStamp

        // Set the text for the label TextView
        holder.labelPts.text = "You've Earned Active Points!!"
    }

    override fun getItemCount(): Int {
        return notificationList.size
    }
}
