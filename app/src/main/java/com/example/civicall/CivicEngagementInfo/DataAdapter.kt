package com.example.civicall.CivicEngagementInfo

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class DataAdapter(private val dataList: List<DataItem>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    // Define an interface to handle item clicks
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    // Add a variable to hold the click listener
    private var itemClickListener: OnItemClickListener? = null

    // Provide a method to set the click listener from outside the adapter
    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val paragraphTextView: TextView = itemView.findViewById(R.id.paragraphTextView)
        val imageView: ImageView = itemView.findViewById(R.id.feed_post_image)
        val referenceTextView: TextView = itemView.findViewById(R.id.reference)

        init {
            // Add a click listener to the referenceTextView
            referenceTextView.setOnClickListener {
                itemClickListener?.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.titleTextView.text = currentItem.title
        holder.paragraphTextView.text = currentItem.paragraph
        holder.imageView.setImageResource(currentItem.imageResourceId)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
