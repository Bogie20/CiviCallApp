package com.example.civicall.FinishActivityList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R
import com.google.android.material.imageview.ShapeableImageView

class FinishActAdapter(private val finishedActivities: List<DataClassFinish>) :
    RecyclerView.Adapter<FinishActAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define your views here
        val engagementImage: ShapeableImageView = itemView.findViewById(R.id.engagementImage)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val location: TextView = itemView.findViewById(R.id.location)
        val dateAndTime: TextView = itemView.findViewById(R.id.dateandTime)
        val category: TextView = itemView.findViewById(R.id.category)
        val receivedStamp: TextView = itemView.findViewById(R.id.dateTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.engagement_activity_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = finishedActivities[position]

        Glide.with(holder.itemView)
            .load(activity.engagementImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(holder.engagementImage)

        holder.recTitle.text = activity.titleEvent
        holder.location.text = activity.location
        holder.dateAndTime.text = activity.startDate + " - " + activity.endDate
        holder.category.text = "Category: ${activity.category}"

        // Set attendedStamp text
        holder.receivedStamp.text = activity.receivedStamp
    }

    override fun getItemCount(): Int {
        return finishedActivities.size
    }
}
