package com.example.civicall.Forum

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.civicall.R

class ForumAdapter(private val context: Context, private var dataList: List<DataClassForum>) :
    RecyclerView.Adapter<ForumAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.forum_post_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]

        Glide.with(context).load(data.imagePost).into(holder.postImage)
        holder.postInput.text = data.postinputs
        holder.commentBtn.setOnClickListener {
            val intent = Intent(context, ForumComment::class.java).apply {
                putExtra("PostImage", data.imagePost)
                putExtra("PostInputs", data.postinputs)
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

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postImage: ImageView = itemView.findViewById(R.id.postImage)
        val postInput: TextView = itemView.findViewById(R.id.postInputtxt)
        val commentBtn: TextView = itemView.findViewById(R.id.commentBtn)
    }
}
