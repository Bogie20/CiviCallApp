package com.example.civicall.Notification

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R

class VerificationAdapter(private val context: Context,
                          private val verificationList: List<VerificationModel>
) : RecyclerView.Adapter<VerificationAdapter.VerificationViewHolder>() {

    // ViewHolder class for the verification items
    class VerificationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Declare and initialize views in the verification item layout
        // Example: val verificationStatusTextView: TextView = itemView.findViewById(R.id.verificationStatusTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerificationViewHolder {
        // Inflate the verification item layout and create a ViewHolder
        val view = LayoutInflater.from(context).inflate(R.layout.verified_account_notification_item, parent, false)
        return VerificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: VerificationViewHolder, position: Int) {
        // Bind data to the views in the verification item layout
        // Example: val verificationModel = verificationList[position]
        //          holder.verificationStatusTextView.text = verificationModel.verificationStatus.toString()
    }

    override fun getItemCount(): Int {
        return verificationList.size
    }

    fun updateData(verificationList: List<VerificationModel>) {
        TODO("Not yet implemented")
    }
}