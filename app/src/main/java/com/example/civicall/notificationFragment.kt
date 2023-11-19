package com.example.civicall
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.Notification.NotificationAdapter
import com.example.civicall.Notification.NotificationModel

class notificationFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewNotifications)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Sample data (replace with your actual data fetching logic)
        val notificationList = getNotificationData()

        // Initialize and set up the adapter
        notificationAdapter = NotificationAdapter(notificationList)
        recyclerView.adapter = notificationAdapter

        // Apply animation to the RecyclerView
        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.animate_fade_enter)
        recyclerView.startAnimation(anim)

        return view
    }

    // Sample method to get notification data (replace with your actual data fetching logic)
    private fun getNotificationData(): List<NotificationModel> {
        return listOf(
            NotificationModel("Notification 1", "Campus A", "2023-11-17 12:00 PM"),
            NotificationModel("Notification 2", "Campus B", "2023-11-18 02:30 PM"),
            // Add more notifications as needed
        )
    }
}