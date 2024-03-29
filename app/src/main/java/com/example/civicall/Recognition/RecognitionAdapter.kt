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


class RecognitionAdapter(private val context: Context, private val userList: List<User>) :
    RecyclerView.Adapter<RecognitionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recognition_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]

        Glide.with(context)
            .load(user.ImageProfile)
            .placeholder(R.drawable.user)
            .error(R.drawable.user)
            .into(holder.profilePic)

        holder.nameRec.text = "${user.firstname} ${user.lastname}"
        val formattedActivePts = formatNumber(user.activepts)
        holder.activePts.text = "${formattedActivePts} pts"
        holder.campus.text = user.campus

        if (position < 99) {
            holder.rankingNum.text = (position + 1).toString()
            holder.rankingNum.visibility = View.VISIBLE

            holder.rankingNum.setTextColor(ContextCompat.getColor(context, R.color.softGoldColor))
        } else {
            // Hide ranking number for other rankings
            holder.rankingNum.visibility = View.INVISIBLE
        }

        when {
            user.activepts in 0..99 -> holder.badgeImageView.setImageResource(R.drawable.bronzes)
            user.activepts in 100..499 -> holder.badgeImageView.setImageResource(R.drawable.silver)
            user.activepts in 500..1999 -> holder.badgeImageView.setImageResource(R.drawable.gold)
            else -> holder.badgeImageView.setImageResource(R.drawable.platinum)
        }
    }
    fun formatNumber(number: Int): String {
        return when {
            number < 10000 -> number.toString()
            number < 1000000 -> String.format("%.1fk", number / 1000.0)
            else -> String.format("%.1fM", number / 1000000.0)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profilePic: ImageView = itemView.findViewById(R.id.profilePic)
        val nameRec: TextView = itemView.findViewById(R.id.nameRec)
        val activePts: TextView = itemView.findViewById(R.id.activepts)
        val campus: TextView = itemView.findViewById(R.id.userCampus)
        val rankingNum: TextView = itemView.findViewById(R.id.rankingnum)
        val badgeImageView: ImageView = itemView.findViewById(R.id.badge_25)
    }
}
