package com.example.civicall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EngagementAdapter(private val engagementList: MutableList<EngagementCalendarClass>) :
    RecyclerView.Adapter<EngagementAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.recTitle)
        val dateAndTimeTextView: TextView = itemView.findViewById(R.id.dateandTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.calendar_recycler_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val engagement = engagementList[position]

        // Set the data to views

    }

    override fun getItemCount(): Int {
        return engagementList.size
    }
}