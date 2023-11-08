package com.example.civicall.CivicEngagementPost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R

class PostAdapter (private val context: Context, private var dataList: List<DataClass>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_recycler, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]

        Glide.with(context).load(data.image).into(holder.recImage)
        holder.recTitle.text = data.title
        holder.recDateandTime.text = data.dateandTime
        holder.recLocation.text = data.location
        holder.recCampus.text = data.campus // Add this line

        holder.recCard.setOnClickListener {
            val intent = Intent(context, DetailPost::class.java).apply {
                putExtra("Image", data.image)
                putExtra("Date&Time", data.dateandTime)
                putExtra("Category", data.category)
                putExtra("Title", data.title)
                putExtra("Facilitator", data.facilitatorsName)
                putExtra("FacilitatorConEm", data.facilitatorsContactorEmail)
                putExtra("Objective", data.objective)
                putExtra("TargetParticipants", data.targetparty)
                putExtra("Instruction", data.instruction)
                putExtra("Introduction", data.intro)
                putExtra("Key", data.key)
                putExtra("Location", data.location)
                putExtra("Campus", data.campus)
            }
            context.startActivity(intent)
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
    val recDateandTime: TextView = itemView.findViewById(R.id.civicDateandTime)
    val recLocation: TextView = itemView.findViewById(R.id.civicLocation)
    val recTitle: TextView = itemView.findViewById(R.id.civicTitle)
    val recCampus: TextView = itemView.findViewById(R.id.civicCampus)
}
