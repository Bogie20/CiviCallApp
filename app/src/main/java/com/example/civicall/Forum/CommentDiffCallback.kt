package com.example.civicall.Forum

import androidx.recyclerview.widget.DiffUtil

class CommentDiffCallback(
    private val oldList: List<DataComment>,
    private val newList: List<DataComment>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].commentKey == newList[newItemPosition].commentKey
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
