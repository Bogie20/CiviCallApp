package com.example.civicall.CivicEngagementPost


import androidx.recyclerview.widget.DiffUtil

class CivicDiffCallBack(private val oldList: List<DataClass>, private val newList: List<DataClass>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].key == newList[newItemPosition].key
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
