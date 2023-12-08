package com.example.civicall.Forum

import androidx.recyclerview.widget.DiffUtil

class CommentDiffCallback(
    private val oldList: Map<String, DataComment>,
    private val newList: Map<String, DataComment>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldKeys = oldList.keys.toList()
        val newKeys = newList.keys.toList()
        return oldKeys[oldItemPosition] == newKeys[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldKeys = oldList.keys.toList()
        val oldComment = oldList[oldKeys[oldItemPosition]]

        val newKeys = newList.keys.toList()
        val newComment = newList[newKeys[newItemPosition]]

        // Compare the content of the items
        return oldComment == newComment
    }
}
