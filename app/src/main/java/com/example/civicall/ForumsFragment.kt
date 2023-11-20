package com.example.civicall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.Forum.ForumAdapter
import com.example.civicall.Forum.Forummodel
import com.example.civicall.databinding.FragmentForumsBinding
import com.example.civicall.databinding.CommentDialogBinding

class ForumsFragment : Fragment() {
    private lateinit var binding: FragmentForumsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sample data for Forummodel (replace this with your actual data)
        val forumPosts: List<Forummodel> = getSampleForumData()

        // Set up the RecyclerView and the ForumAdapter
        val recyclerView: RecyclerView = binding.recyclerViewForum
        val noPostsImage: ImageView = binding.noPostsImage
        val noPostsText: TextView = binding.noPostsText

        val adapter = ForumAdapter(forumPosts) { forumModel: Forummodel ->
            showCommentDialog(forumModel)
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        // Update visibility based on the data list
        if (forumPosts.isEmpty()) {
            noPostsImage.visibility = View.VISIBLE
            noPostsText.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            noPostsImage.visibility = View.GONE
            noPostsText.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
            adapter.notifyDataSetChanged()
        }
    }

    // Replace this with your actual data fetching logic
    private fun getSampleForumData(): List<Forummodel> {
        // Sample data, replace this with your actual data fetching logic
        val forumPosts = mutableListOf<Forummodel>()
        forumPosts.add(
            Forummodel(
                postId = 1,
                author = "Jane Doe",
                title = "Sample Title",
                content = "Your time is limited...",
                timestamp = System.currentTimeMillis(),
                quote = "Your time is limited, so don't waste it living someone else's life. " +
                        "Don't be trapped by dogma – which is living with the results of other people's thinking."
            )
        )

        // Add more forum posts if needed

        return forumPosts // Don't forget to return the list
    }

    // Function to show the comment dialog
    private fun showCommentDialog(forumModel: Forummodel) {
        val dialogBinding = CommentDialogBinding.inflate(layoutInflater)
        val dialogView = dialogBinding.root
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)

            .create()

        dialogBuilder.show()
    }
}