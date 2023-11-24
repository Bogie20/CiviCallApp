package com.example.civicall.Recognition

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R


class RecognitionAdapter(private val context: Context, private val userList: List<Users>) :
    RecyclerView.Adapter<RecognitionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recognition_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]

        // Load image using Glide or any other image loading library
        Glide.with(context).load(user.ImageProfile).into(holder.profilePic)

        holder.nameRec.text = "${user.firstname} ${user.lastname}"
        holder.activePts.text = "${user.activepts} pts"

        // Set the ranking number
        holder.rankingNum.text = (position + 1).toString()

        // Change the text color for the top 10 rankings to gold
        if (position < 10) {
            holder.rankingNum.setTextColor(ContextCompat.getColor(context, R.color.softGoldColor))
        } else {
            // Reset the text color for other rankings
            holder.rankingNum.setTextColor(ContextCompat.getColor(context, R.color.DarkGray))
        }

        // Set badge image based on activepts range
        when (user.activepts) {
            in 0..300 -> holder.badgeImageView.setImageResource(R.drawable.civicalllogo)
            in 301..1000 -> holder.badgeImageView.setImageResource(R.drawable.landslide)
            else -> holder.badgeImageView.setImageResource(R.drawable.batanggolden)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profilePic: ImageView = itemView.findViewById(R.id.profilePic)
        val nameRec: TextView = itemView.findViewById(R.id.nameRec)
        val activePts: TextView = itemView.findViewById(R.id.activepts)
        val rankingNum: TextView = itemView.findViewById(R.id.rankingnum)
        val badgeImageView: ImageView = itemView.findViewById(R.id.badge_25)
    }
}



