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

class BanAccountAdapter(private val banList: List<BanData>) :
    RecyclerView.Adapter<BanAccountAdapter.BanViewHolder>() {

    inner class BanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val label: TextView = itemView.findViewById(R.id.label)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val dateandTime: TextView = itemView.findViewById(R.id.dateandTime)
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val schedule: TextView = itemView.findViewById(R.id.schedule)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BanViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_recycler_item, parent, false)
        return BanViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BanViewHolder, position: Int) {
        val currentBan = banList[position]

        val labelLayoutParams = holder.label.layoutParams as ViewGroup.MarginLayoutParams
        labelLayoutParams.topMargin = dpToPx(30)
        holder.label.layoutParams = labelLayoutParams

        holder.label.textSize = 12f
        holder.recTitle.textSize = 13f
        holder.dateandTime.textSize = 12f
        holder.recImage.setImageResource(R.drawable.banccc)
        holder.label.text = "Your Account Has Been Banned!!"
        holder.dateandTime.text ="Since: ${currentBan.banTimeStamp}"
        holder.recTitle.text = "Your post in the forum has led to this ban."

        holder.categoryTextView.visibility = View.GONE
        holder.schedule.visibility = View.GONE
    }

    private fun dpToPx(dp: Int): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dp * scale).toInt()
    }

    override fun getItemCount(): Int {
        return banList.size
    }

    data class BanData(
        val banTimeStamp: String
    )
}
