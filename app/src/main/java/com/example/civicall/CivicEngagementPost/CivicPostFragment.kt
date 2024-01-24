package com.example.civicall.CivicEngagementPost

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import nl.joery.animatedbottombar.AnimatedBottomBar
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class CivicPostFragment : Fragment() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private val dataList = ArrayList<DataClass>()
    private lateinit var adapter: PostAdapter
    private lateinit var searchView: SearchView
    private lateinit var nestedRecycler: NestedScrollView
    private lateinit var rootView: View
    private lateinit var noPostsImage: ImageView
    private lateinit var noPostsText: TextView
    private lateinit var progressBar: ProgressBar

    companion object {
        private val TIME_ZONE = TimeZone.getTimeZone("Asia/Manila")
        private const val MAX_POST_AGE_MILLIS = 365 * 24 * 60 * 60 * 1000L
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        rootView = inflater.inflate(R.layout.fragment_civic_post, container, false)

        recyclerView = rootView.findViewById(R.id.recyclerView)
        nestedRecycler = rootView.findViewById(R.id.nestedRecycler)
        searchView = rootView.findViewById(R.id.search)
        searchView.clearFocus()
        noPostsImage = rootView.findViewById(R.id.noPostsImage)
        noPostsText = rootView.findViewById(R.id.noPostsText)
        progressBar = rootView.findViewById(R.id.progressBar)
        val filterIcon = rootView.findViewById<ImageView>(R.id.filterIcon)
        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)

        rootView.startAnimation(anim)

        filterIcon.setOnClickListener {
            showFilterDialog()
        }
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.layoutManager = gridLayoutManager

        adapter = PostAdapter(requireContext(), dataList)
        recyclerView.adapter = adapter

        databaseReference = FirebaseDatabase.getInstance().getReference("Upload Engagement")

        databaseReference.addValueEventListener(object : ValueEventListener {

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                val currentUser = FirebaseAuth.getInstance().currentUser
                val userUid = currentUser?.uid
                val userCampusRef = FirebaseDatabase.getInstance().getReference("Users/$userUid/campus")

                userCampusRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(userCampusSnapshot: DataSnapshot) {
                        val userCampus = userCampusSnapshot.value.toString()
                        val newDataList = ArrayList<DataClass>()

                        val currentMillis = Calendar.getInstance(TimeZone.getTimeZone("Asia/Manila")).timeInMillis


                        for (itemSnapshot in snapshot.children) {
                            val dataClass = itemSnapshot.getValue(DataClass::class.java)
                            dataClass?.key = itemSnapshot.key

                            dataClass?.let {
                                val uploadEngagementCampuses =
                                    it.campus?.split(", ")?.map { it.trim() } ?: emptyList()
                                if (userCampus in uploadEngagementCampuses) {
                                    val postTimeMillis = it.endDate?.let { it1 ->
                                        SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
                                            .apply {
                                                timeZone = TIME_ZONE
                                            }
                                            .parse(it1 + " Asia/Manila")?.time
                                    } ?: 0


                                    if (currentMillis - postTimeMillis <= MAX_POST_AGE_MILLIS) {
                                        newDataList.add(0, it)
                                    }
                                }
                            }
                        }
                        dataList.clear()
                        dataList.addAll(newDataList)
                        adapter.notifyDataSetChanged()
                        progressBar.visibility = View.GONE

                        if (dataList.isEmpty()) {
                            rootView.findViewById<ImageView>(R.id.noPostsImage).visibility = View.VISIBLE
                            rootView.findViewById<TextView>(R.id.noPostsText).visibility = View.VISIBLE
                            recyclerView.visibility = View.GONE
                        } else {
                            rootView.findViewById<ImageView>(R.id.noPostsImage).visibility = View.GONE
                            rootView.findViewById<TextView>(R.id.noPostsText).visibility = View.GONE
                            recyclerView.visibility = View.VISIBLE
                        }
                            progressBar.visibility = View.GONE
                    }
                    override fun onCancelled(error: DatabaseError) {
                        progressBar.visibility = View.GONE
                    }
                })
            }

            override fun onCancelled(error: DatabaseError) {
                progressBar.visibility = View.GONE
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
        val faback = requireActivity().findViewById<FloatingActionButton>(R.id.faback)

        nestedRecycler.setOnScrollChangeListener(View.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            // Scroll down
            if (scrollY > oldScrollY) {
                if (animatedBottomBar.isShown) {
                    animatedBottomBar.visibility = View.GONE
                }
                if (fab.isShown) {
                    fab.hide()
                }
                if (faback.isShown) {
                    faback.hide()
                }
            } else if (scrollY < oldScrollY) {
                // Scroll up
                if (!animatedBottomBar.isShown) {
                    animatedBottomBar.visibility = View.VISIBLE
                }
                if (!fab.isShown) {
                    fab.show()
                }
                if (!faback.isShown) {
                    faback.show()
                }
            }
        })


        return rootView
    }


    fun toggleSearchFilterVisibility() {
        val searchView = rootView.findViewById<SearchView>(R.id.search)
        val filterIcon = rootView.findViewById<ImageView>(R.id.filterIcon)

        if (searchView.visibility == View.VISIBLE) {
            searchView.visibility = View.GONE
            filterIcon.visibility = View.GONE
        } else {
            searchView.visibility = View.VISIBLE
            filterIcon.visibility = View.VISIBLE
        }
    }

    private var isFilterDialogShowing = false // Add this variable

    private fun showFilterDialog() {
        if (isFilterDialogShowing) {
            return
        }
        dismissCustomDialog()
        val dialogView = layoutInflater.inflate(R.layout.filter_dialog_bottom, null)
        val alertDialog = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .create()


        val treeplant: TextView = dialogView.findViewById(R.id.TreePlanting)
        val fund: TextView = dialogView.findViewById(R.id.FundRaising)
        val donate: TextView = dialogView.findViewById(R.id.Donations)
        val cleanup: TextView = dialogView.findViewById(R.id.CleanUpDrive)
        val feed: TextView = dialogView.findViewById(R.id.FeedingProgram)
        val relief: TextView = dialogView.findViewById(R.id.ReliefOperation)
        val seminar: TextView = dialogView.findViewById(R.id.Seminar)
        val teach: TextView = dialogView.findViewById(R.id.Teaching)
        val allCategory: TextView = dialogView.findViewById(R.id.all)

        alertDialog.window?.attributes?.windowAnimations = R.style.DialogAnimationShrink


        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        treeplant.setOnClickListener {
            filterByCategory("Tree Planting")
            alertDialog.dismiss()
        }
        fund.setOnClickListener {
            filterByCategory("Fund Raising")
            alertDialog.dismiss()
        }
        donate.setOnClickListener {
            filterByCategory("Donation")
            alertDialog.dismiss()
        }
        cleanup.setOnClickListener {
            filterByCategory("Clean Up Drive")
            alertDialog.dismiss()
        }
        feed.setOnClickListener {
            filterByCategory("Feeding Program")
            alertDialog.dismiss()
        }
        relief.setOnClickListener {
            filterByCategory("Relief Operations")
            alertDialog.dismiss()
        }
        seminar.setOnClickListener {
            filterByCategory("Seminar Training")
            alertDialog.dismiss()
        }
        teach.setOnClickListener {
            filterByCategory("Teaching Literacy")
            alertDialog.dismiss()
        }
        allCategory.setOnClickListener {
            filterByCategory("")
            alertDialog.dismiss()
        }


        alertDialog.setOnDismissListener{
            isFilterDialogShowing = false
        }

        alertDialog.show()
        isFilterDialogShowing =
            true
    }
    private fun dismissCustomDialog() {
        if (isFilterDialogShowing) {

            isFilterDialogShowing = false
        }
    }
    private fun filterByCategory(category: String) {
        if (category.isEmpty()) {
            adapter.updateData(dataList)
            adapter.searchDataList(dataList)
            hideNoPostsMessage()
        } else {
            val filteredList = dataList.filter { it.category == category }

            if (filteredList.isEmpty()) {
                showNoPostsMessage(category)
            } else {
                hideNoPostsMessage()
                val filteredArrayList = ArrayList<DataClass>(filteredList)
                adapter.searchDataList(filteredArrayList)
            }
        }
    }
    private fun showNoPostsMessage(category: String) {
        noPostsImage.setImageResource(R.drawable.notinlist)
        noPostsText.text = "Sorry, the category \"$category\" is currently unavailable."
        noPostsImage.visibility = View.VISIBLE
        noPostsText.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }
    private fun showNoSearchMessage(searchText: String) {
        noPostsImage.setImageResource(R.drawable.notinlist)
        noPostsText.text = "Sorry, no results found for \"$searchText\"."
        noPostsImage.visibility = View.VISIBLE
        noPostsText.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    private fun hideNoPostsMessage() {
        noPostsImage.visibility = View.GONE
        noPostsText.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    private fun searchList(text: String) {
        val searchList = ArrayList<DataClass>()
        for (dataClass in dataList) {
            if (dataClass?.titleEvent?.toLowerCase()?.contains(text.toLowerCase()) == true) {
                searchList.add(dataClass)
            }
        }

        if (searchList.isEmpty()) {
            showNoSearchMessage(text)
        } else {
            hideNoPostsMessage()
            val searchArrayList = ArrayList<DataClass>(searchList)
            adapter.updateData(dataList)
            adapter.searchDataList(searchArrayList)
        }
    }
}