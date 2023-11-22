package com.example.civicall.CalendarView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import java.util.ArrayList

class EventAdapter(private var events: List<Event>) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    fun updateData(newEvents: List<Event>) {
        events = newEvents
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = events[position]

        // Assuming item_event.xml contains TextViews with IDs textEventTitle and textEventDateTime
        holder.itemView.findViewById<TextView>(R.id.textEventTitle).text = event.eventName
        holder.itemView.findViewById<TextView>(R.id.textEventDateTime).text = event.eventDate
    }

    override fun getItemCount(): Int {
        return events.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}