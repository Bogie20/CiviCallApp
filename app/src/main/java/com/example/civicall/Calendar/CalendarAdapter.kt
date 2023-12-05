package com.example.civicall.Calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R

class CalendarAdapter(private val engagementList: List<CalendarData>) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.calendar_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val engagementData = engagementList[position]

        Glide.with(holder.itemView)
            .load(engagementData.engagementImage)
            .placeholder(R.drawable.placeholder) // Optional: Placeholder image while loading
            .error(R.drawable.placeholder) // Optional: Error image if the loading fails
            .into(holder.engagementImage)
        holder.recTitle.text = engagementData.recTitle
        holder.location.text = engagementData.location
        holder.dateAndTime.text = engagementData.dateAndTime
    }

    override fun getItemCount(): Int {
        return engagementList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val engagementImage: ImageView = itemView.findViewById(R.id.engagementImage)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val location: TextView = itemView.findViewById(R.id.location)
        val dateAndTime: TextView = itemView.findViewById(R.id.dateandTime)
    }
}
