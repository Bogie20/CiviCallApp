package com.example.civicall.CivicEngagementPost

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class PostAdapter (private val context: Context, private var dataList: List<DataClass>) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_civicengagement, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]

        Glide.with(context).load(data.image).into(holder.recImage)
        holder.recTitle.text = data.title
        holder.recStartDate.text = data.startDate
        holder.recEndDate.text = data.endDate
        holder.recLocation.text = data.location
        holder.recCategory.text = data.category
        holder.recCard.setOnClickListener {
            val intent = Intent(context, DetailPost::class.java).apply {
                putExtra("Image", data.image)
                putExtra("StartDate", data.startDate)
                putExtra("EndDate", data.endDate)
                putExtra("Category", data.category)
                putExtra("PaymentMethod", data.paymentMethod)
                putExtra("FundCollected", data.fundcollected)
                putExtra("PaymentRecipient", data.paymentRecipient)
                putExtra("Title", data.title)
                putExtra("Facilitator", data.facilitatorsName)
                putExtra("FacilitatorConEm", data.facilitatorsContactorEmail)
                putExtra("Objective", data.objective)
                putExtra("TargetParticipants", data.targetparty)
                putExtra("ActivePoints", data.activepoints)
                putExtra("Instruction", data.instruction)
                putExtra("Introduction", data.intro)
                putExtra("Key", data.key)
                putExtra("Location", data.location)
                putExtra("Campus", data.campus)
            }
            context.startActivity(intent)
        }
        val currentDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Manila")).time

        if (data.verificationStatus == true) {
            val dateFormat = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US)
            dateFormat.timeZone = TimeZone.getTimeZone("Asia/Manila")

            try {
                val startDate = dateFormat.parse(data.startDate)
                val endDate = dateFormat.parse(data.endDate)

                if (startDate != null && endDate != null) {
                    if (currentDate.after(startDate) && currentDate.before(endDate)) {
                        // If current date is between start and end date, set a drawable for playing
                        holder.recTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.play, 0)
                        // Tint the drawable with blue color
                        holder.recTitle.compoundDrawables[2]?.setColorFilter(
                            ContextCompat.getColor(context, R.color.blue),
                            PorterDuff.Mode.SRC_IN
                        )
                    } else if (currentDate.after(endDate)) {
                        // If current date is after the end date, set a drawable for finishing
                        holder.recTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.finishnapo, 0)
                        // Tint the drawable with green color
                        holder.recTitle.compoundDrawables[2]?.setColorFilter(
                            ContextCompat.getColor(context, R.color.greenish),
                            PorterDuff.Mode.SRC_IN
                        )
                    } else {
                        // If current date is not between start and end date, set a drawable for verified posts
                        holder.recTitle.setCompoundDrawablesWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.verifiedalready,
                            0
                        )
                        // Tint the drawable for verified posts with the 'verified' color
                        holder.recTitle.compoundDrawables[2]?.setColorFilter(
                            ContextCompat.getColor(context, R.color.verifiedblue),
                            PorterDuff.Mode.SRC_IN
                        )
                    }
                }
            } catch (e: ParseException) {
                e.printStackTrace()
            }
        } else {
            holder.recTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.notveri, 0)
            // Tint the drawable for unverified posts with the 'unverified' color
            holder.recTitle.compoundDrawables[2]?.setColorFilter(
                ContextCompat.getColor(context, R.color.unverified),
                PorterDuff.Mode.SRC_IN
            )
        }
        }
        override fun getItemCount(): Int {
        return dataList.size
    }

    fun searchDataList(searchList: ArrayList<DataClass>) {
        dataList = searchList
        notifyDataSetChanged()
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val recImage: ImageView = itemView.findViewById(R.id.recImage)
    val recCard: CardView = itemView.findViewById(R.id.recCard)
    val recStartDate: TextView = itemView.findViewById(R.id.civicStartDate)
    val recEndDate: TextView = itemView.findViewById(R.id.civicEndDate)
    val recLocation: TextView = itemView.findViewById(R.id.civicLocation)
    val recTitle: TextView = itemView.findViewById(R.id.civicTitle)
    val recCategory: TextView = itemView.findViewById(R.id.civicCategory)
}
