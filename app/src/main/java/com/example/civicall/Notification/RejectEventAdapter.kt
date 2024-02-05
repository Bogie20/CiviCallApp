package com.example.civicall.Notification

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.android.material.imageview.ShapeableImageView

class RejectEventAdapter(private val rejectedList: List<RejectData>) :
    RecyclerView.Adapter<RejectEventAdapter.RejectedViewHolder>() {

    inner class RejectedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label: TextView = itemView.findViewById(R.id.label)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val dateandTime: TextView = itemView.findViewById(R.id.dateandTime)
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val schedule: TextView = itemView.findViewById(R.id.schedule)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RejectedViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_recycler_item, parent, false)
        return RejectedViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RejectedViewHolder, position: Int) {
        val currentRejected = rejectedList[position]

        val labelLayoutParams = holder.label.layoutParams as ViewGroup.MarginLayoutParams
        labelLayoutParams.topMargin = dpToPx(19)
        holder.label.layoutParams = labelLayoutParams

        holder.label.textSize = 12f
        holder.recTitle.textSize = 12f
        holder.dateandTime.textSize = 12f
        holder.schedule.textSize = 12f
        holder.recImage.setImageResource(R.drawable.rejectedimage)
        holder.label.text = "Your request has been rejected"
        holder.recTitle.text = "Title: ${currentRejected.titleEvent}"
        holder.schedule.text = "Reason: ${currentRejected.rejectReason}"
        holder.dateandTime.text ="Since: ${currentRejected.rejecttime}"

        holder.categoryTextView.visibility = View.GONE
        holder.recTitle.maxLines = 1
        holder.schedule.maxLines = 2
        holder.schedule.setLineSpacing(0f, 1.2f)
    }
    private fun dpToPx(dp: Int): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dp * scale).toInt()
    }

    override fun getItemCount(): Int {
        return rejectedList.size
    }

    data class RejectData(
        val rejectReason: String,
        val rejecttime: String,
        val titleEvent: String
    )
}
