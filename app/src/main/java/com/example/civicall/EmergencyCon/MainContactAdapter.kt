package com.example.civicall.EmergencyCon

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.android.material.card.MaterialCardView

class MainContactAdapter(var mList: List<ContactData>) :
    RecyclerView.Adapter<MainContactAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: MaterialCardView = itemView.findViewById(R.id.clickthis)
        val logo: ImageView = itemView.findViewById(R.id.logoIv)
        val titleTv: TextView = itemView.findViewById(R.id.titleTv)
    }

    fun setFilteredList(mList: List<ContactData>) {
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_each_contact_option, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.logo.setImageResource(mList[position].logo)
        holder.titleTv.text = mList[position].title

        // Set click listener on the card view
        holder.cardView.setOnClickListener {
            val context = holder.itemView.context
            when (position) {
                0 -> context.startActivity(Intent(context, BalayanCont::class.java))
                1 -> context.startActivity(Intent(context, LemeryCont::class.java))
                2 -> context.startActivity(Intent(context, LipaCont::class.java))
                3 -> context.startActivity(Intent(context, LoboCont::class.java))
                4 -> context.startActivity(Intent(context, MabiniCont::class.java))
                5 -> context.startActivity(Intent(context, MalvarCont::class.java))
                6 -> context.startActivity(Intent(context, NasugbuCont::class.java))
                7 -> context.startActivity(Intent(context, PabloBorbon1Cont::class.java))
                8 -> context.startActivity(Intent(context, PabloBorbon2Cont::class.java))
                9 -> context.startActivity(Intent(context, RosarioCont::class.java))
                10 -> context.startActivity(Intent(context, SanJuanCont::class.java))
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}
