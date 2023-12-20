package com.example.civicall.Forum

import androidx.recyclerview.widget.DiffUtil

class CommentDiffCallback(
    private val oldList: Map<String, DataComment>,
    private val newList: Map<String, DataComment>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEntry = oldList.entries.elementAt(oldItemPosition)
        val newEntry = newList.entries.elementAt(newItemPosition)
        return oldEntry.key == newEntry.key
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEntry = oldList.entries.elementAt(oldItemPosition)
        val newEntry = newList.entries.elementAt(newItemPosition)
        return oldEntry == newEntry
    }
}
