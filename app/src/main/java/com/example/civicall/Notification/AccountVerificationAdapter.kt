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


class AccountVerificationAdapter(private val userList: List<UserData>) :
    RecyclerView.Adapter<AccountVerificationAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTextView: TextView = itemView.findViewById(R.id.categoryTextView)
        val recTitle: TextView = itemView.findViewById(R.id.recTitle)
        val schedule: TextView = itemView.findViewById(R.id.schedule)
        val label: TextView = itemView.findViewById(R.id.label)
        val recImage: ShapeableImageView = itemView.findViewById(R.id.recImage)
        val dateandTime: TextView = itemView.findViewById(R.id.dateandTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.notification_recycler_item, parent, false)
        return UserViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]

        // Set label with a top margin of 30dp
        val labelLayoutParams = holder.label.layoutParams as ViewGroup.MarginLayoutParams
        labelLayoutParams.topMargin = dpToPx(25) // Use your desired top margin in dp
        holder.label.layoutParams = labelLayoutParams

        // Set text size for label, recTitle, and schedule to 12sp
        holder.label.textSize = 12f
        holder.recTitle.textSize = 12f
        holder.schedule.textSize = 12f

        holder.label.text = "Your Account has been Verified"

        holder.recImage.setImageResource(R.drawable.verifiednotif)
        holder.recTitle.text = currentUser.email
        holder.dateandTime.text = "Since: ${currentUser.verifiedTimeStamp}"
        // Set firstname with lastname to schedule
        holder.schedule.text = "${currentUser.firstname} ${currentUser.lastname}"

        holder.categoryTextView.visibility = View.GONE
    }

    private fun dpToPx(dp: Int): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dp * scale).toInt()
    }


    override fun getItemCount(): Int {
        return userList.size
    }

    // Your data class representing user data
    data class UserData(
        val uid: String,
        val email: String,
        val firstname: String,
        val lastname: String,
        val verificationStatus: Boolean,
        val verifiedTimeStamp: String
    )
}
