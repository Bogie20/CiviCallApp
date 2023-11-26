package com.example.civicall.Forum

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R

class ForumAdapter (private val context: Context, private var dataList: List<DataClassForum>) :
    RecyclerView.Adapter<MyViewHolderForum>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderForum {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forum_post_view, parent, false)
        return MyViewHolderForum(view)

    }
    override fun onBindViewHolder(holder: MyViewHolderForum, position: Int) {
        val data = dataList[position]

        Glide.with(context).load(data.postImage).into(holder.forumImage)
        holder.forumText.text = data.postText
        holder.commentbutton.setOnClickListener {
            val intent = Intent(context, ForumComment::class.java).apply {
                putExtra("PostImage", data.postImage)
                putExtra("StartDate", data.startDate)
                putExtra("EndDate", data.endDate)
                putExtra("Category", data.category)
                putExtra("PaymentMethod", data.paymentMethod)
                putExtra("FundCollected", data.fundcollected)
                putExtra("PaymentRecipient", data.paymentRecipient)
                putExtra("PostText", data.postText)
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

    }
    override fun getItemCount(): Int {
        return dataList.size
    }

    fun searchDataList(searchList: ArrayList<DataClassForum>) {
        dataList = searchList
        notifyDataSetChanged()
    }
}

class MyViewHolderForum(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val forumImage: ImageView = itemView.findViewById(R.id.postImage)
    val commentbutton: AppCompatImageButton = itemView.findViewById(R.id.commentBtn) as AppCompatImageButton
    val forumText: TextView = itemView.findViewById(R.id.postInputtxt)

}
