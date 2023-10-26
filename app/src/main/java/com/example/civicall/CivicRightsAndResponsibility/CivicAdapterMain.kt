package com.example.civicall.CivicRightsAndResponsibility

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.CivicEngagementInfo.DataMain
import com.example.civicall.R

class CivicAdapterMain(private val campusList: List<DataMain>, private val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<CivicAdapterMain.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTv: TextView = itemView.findViewById(R.id.titleTv)

        init {
            // Add click listener to the item view
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.civicengageinfomain, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val campusItem = campusList[position]
        holder.titleTv.text = campusItem.title
    }

    override fun getItemCount(): Int {
        return campusList.size
    }
}