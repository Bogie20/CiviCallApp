package com.example.civicall.CivicEngagementPost

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import nl.joery.animatedbottombar.AnimatedBottomBar

class CivicPostFragment : Fragment() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var eventListener: ValueEventListener
    private lateinit var recyclerView: RecyclerView
    private val dataList = ArrayList<DataClass>()
    private lateinit var adapter: PostAdapter
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_civic_post, container, false)

        recyclerView = rootView.findViewById(R.id.recyclerView)
        searchView = rootView.findViewById(R.id.search)
        searchView.clearFocus()

        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)

        rootView.startAnimation(anim)

        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.layoutManager = gridLayoutManager

        val builder = AlertDialog.Builder(requireContext())
        builder.setCancelable(false)
        val dialog = builder.create()
        dialog.show()

        adapter = PostAdapter(requireContext(), dataList)
        recyclerView.adapter = adapter

        databaseReference = FirebaseDatabase.getInstance().getReference("Upload Engagement")
        dialog.show()
        eventListener = databaseReference.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                dataList.clear()
                for (itemSnapshot in snapshot.children) {
                    val dataClass = itemSnapshot.getValue(DataClass::class.java)
                    dataClass?.key = itemSnapshot.key
                    dataClass?.let { dataList.add(it) }
                }
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                dialog.dismiss()
            }
        })

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { searchList(it) }
                return true
            }
        })

        val animatedBottomBar = requireActivity().findViewById<AnimatedBottomBar>(R.id.bottom_bar)
        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    // Scrolling down
                    if (animatedBottomBar.isShown) {
                        animatedBottomBar.visibility = View.GONE
                    }
                    if (fab.isShown) {
                        fab.hide()
                    }
                } else if (dy < 0) {
                    // Scrolling up
                    if (!animatedBottomBar.isShown) {
                        animatedBottomBar.visibility = View.VISIBLE
                    }
                    if (!fab.isShown) {
                        fab.show()
                    }
                }
            }
        })

        return rootView
    }
    private fun searchList(text: String) {
        val searchList = ArrayList<DataClass>()
        for (dataClass in dataList) {
            if (dataClass?.title?.toLowerCase()?.contains(text.toLowerCase()) == true) {
                searchList.add(dataClass)
            }
        }
        adapter.searchDataList(searchList)
    }
}