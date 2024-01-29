package com.example.civicall.Notification

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.civicall.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import me.leolin.shortcutbadger.ShortcutBadger
import nl.joery.animatedbottombar.AnimatedBottomBar
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class NotificationFragment : Fragment() {

    private lateinit var RecyclerViewAccApproved: RecyclerView
    private lateinit var RecyclerViewAccReject: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var notificationList: MutableList<DataClassNotif>
    private lateinit var rejectedList: MutableList<AccountRejectAdapter.RejectedData>
    private lateinit var noPostsImage: ImageView
    private lateinit var nestedScrollView: NestedScrollView
    private lateinit var noPostsText: TextView
    private lateinit var databaseReference: DatabaseReference
    private lateinit var databaseReferenceJoined: DatabaseReference
    private lateinit var databaseReferenceActivePoints: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerViewEngageUpdate: RecyclerView
    private lateinit var accountVerificationAdapter: AccountVerificationAdapter
    private lateinit var userList: MutableList<AccountVerificationAdapter.UserData>
    private lateinit var joinedList: MutableList<EngagementJoinedAdapter.EngagementJoinedData>
    private lateinit var databaseReferenceUsers: DatabaseReference
    private lateinit var databaseReferenceRequestVerify: DatabaseReference
    private lateinit var RecyclerViewEngagementApproved: RecyclerView
    private lateinit var recyclerViewEngageJoined: RecyclerView
    private lateinit var recyclerViewAct: RecyclerView
    private lateinit var databaseReferenceAccReject: DatabaseReference
    private lateinit var activePtsAdapter: ActivePointsAdapter
    private lateinit var engagementJoinedAdapter: EngagementJoinedAdapter
    private lateinit var rejectVerificationAdapter: AccountRejectAdapter
    private lateinit var requestVerificationAdapter: RequestVerificationAdapter
    private lateinit var ActivePtsList: MutableList<ActivePointsAdapter.ActiveData>
    private lateinit var requestList: MutableList<RequestVerificationAdapter.RequestData>
    private lateinit var databaseReferenceAttended: DatabaseReference
    private lateinit var RecyclerViewAttended: RecyclerView
    private lateinit var attendedAdapter: AttendedAdapter
    private lateinit var attendedList: MutableList<AttendedAdapter.AttendedData>
    @SuppressLint("SuspiciousIndentation")
    private fun updateAppIndicator() {
        if (isAdded) {
        val totalNotificationCount = notificationList.size
        val totalUserCount = userList.size
        val totalJoinedCount = joinedList.size
            val totalRejectCount = rejectedList.size
        val totalActivePtsCount = ActivePtsList.size
        val totalRequestCount = requestList.size
        val totalAttendedCount = attendedList.size

        val totalCount = totalNotificationCount + totalUserCount + totalJoinedCount + totalActivePtsCount + totalRequestCount + totalAttendedCount + totalRejectCount

            ShortcutBadger.applyCount(requireContext(), totalCount)
        }
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)
        noPostsImage = view.findViewById(R.id.noPostsImage)
        noPostsText = view.findViewById(R.id.noPostsText)
        recyclerViewEngageUpdate = view.findViewById(R.id.recyclerViewEngageUpdate)
        nestedScrollView = view.findViewById(R.id.nestedRecycler)
        recyclerViewEngageUpdate.layoutManager = LinearLayoutManager(activity)
        notificationList = mutableListOf()
        progressBar = view.findViewById(R.id.progressBar)
        notificationAdapter = NotificationAdapter(notificationList)
        recyclerViewEngageUpdate.adapter = notificationAdapter
        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        view.startAnimation(anim)
        auth = FirebaseAuth.getInstance()
        val currentUserUid = auth.currentUser?.uid

        recyclerViewAct = view.findViewById(R.id.recyclerViewAct)
        recyclerViewAct.layoutManager = LinearLayoutManager(activity)
        ActivePtsList = mutableListOf()
        activePtsAdapter = ActivePointsAdapter(ActivePtsList)
        recyclerViewAct.adapter = activePtsAdapter

        RecyclerViewAttended = view.findViewById(R.id.recyclerViewAttended)
        attendedList = mutableListOf()
        attendedAdapter = AttendedAdapter(attendedList)
        RecyclerViewAttended.layoutManager = LinearLayoutManager(activity)
        RecyclerViewAttended.adapter = attendedAdapter

        RecyclerViewAccApproved = view.findViewById(R.id.RecyclerViewAccApproved)
        RecyclerViewAccApproved.layoutManager = LinearLayoutManager(activity)
        userList = mutableListOf()
        accountVerificationAdapter = AccountVerificationAdapter(userList)
        RecyclerViewAccApproved.adapter = accountVerificationAdapter

        recyclerViewEngageJoined = view.findViewById(R.id.recyclerViewEngageJoined)
        recyclerViewEngageJoined.layoutManager = LinearLayoutManager(activity)
        joinedList = mutableListOf()
        engagementJoinedAdapter = EngagementJoinedAdapter(joinedList)
        recyclerViewEngageJoined.adapter = engagementJoinedAdapter

        RecyclerViewEngagementApproved = view.findViewById(R.id.RecyclerViewEngagementApproved)
        RecyclerViewEngagementApproved.layoutManager = LinearLayoutManager(activity)
        requestList = mutableListOf()
        requestVerificationAdapter = RequestVerificationAdapter(requestList)
        RecyclerViewEngagementApproved.adapter = requestVerificationAdapter

        RecyclerViewAccReject = view.findViewById(R.id.RecyclerViewAccReject)
        RecyclerViewAccReject.layoutManager = LinearLayoutManager(activity)
        rejectedList = mutableListOf()
        rejectVerificationAdapter = AccountRejectAdapter(rejectedList)
        RecyclerViewAccReject.adapter = rejectVerificationAdapter

        databaseReferenceAccReject = FirebaseDatabase.getInstance().reference.child("Users")
        databaseReference = FirebaseDatabase.getInstance().reference.child("Upload_Engagement")
        databaseReferenceRequestVerify = FirebaseDatabase.getInstance().reference.child("Upload_Engagement")
        databaseReferenceUsers = FirebaseDatabase.getInstance().reference.child("Users")
        databaseReferenceActivePoints = FirebaseDatabase.getInstance().reference.child("Upload_Engagement")
        databaseReferenceJoined = FirebaseDatabase.getInstance().reference.child("Upload_Engagement")
        databaseReferenceAttended = FirebaseDatabase.getInstance().reference.child("Upload_Engagement")
        databaseReference.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                notificationList.clear()

                for (engagementSnapshot in dataSnapshot.children) {
                    val postKey = engagementSnapshot.key ?: ""

                    // Check if the current user is a participant in this engagement
                    val participantsRef = engagementSnapshot.child("Participants")
                    if (participantsRef.hasChild(currentUserUid!!)) {
                        // User is a participant, retrieve and display information

                        // Retrieve start date and time from the database
                        val startDateStr = engagementSnapshot.child("startDate").value.toString()
                        val endDateStr = engagementSnapshot.child("endDate").value.toString()

                        // Check if the engagement is within 24 hours from the current date and time
                        if (isWithin24Hours(startDateStr)) {
                            // User is a participant, retrieve and display information
                            val category = engagementSnapshot.child("category").value.toString()
                            val titleEvent = engagementSnapshot.child("titleEvent").value.toString()
                            val startDate = engagementSnapshot.child("startDate").value.toString()
                            val endDate = engagementSnapshot.child("endDate").value.toString()
                            val imageUrl = engagementSnapshot.child("image").value.toString()

                            // Calculate the timestamp 24 hours before the start date
                            val timestamp24HoursBefore = calculateTimestamp24HoursBefore(startDate)

                            val notificationItem = DataClassNotif(
                                postKey,
                                category,
                                titleEvent,
                                startDate,
                                endDate,
                                imageUrl,
                                timestamp24HoursBefore
                            )
                            val currentDate = Date()
                            val endDateTime = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(endDateStr)

                            val calendar = Calendar.getInstance()
                            calendar.time = endDateTime
                            calendar.add(Calendar.WEEK_OF_MONTH, 1)

                            if (currentDate.after(calendar.time)) {
                                // Skip this item as it's more than 1 month after the engagement has ended
                                continue
                            }


                            notificationList.add(notificationItem)
                        }
                    }
                }
                notificationList.sortByDescending { it.timestamp }
                notificationAdapter.notifyDataSetChanged()
                updateAppIndicator()
                updateNoPostsVisibility()
                // Check if the notificationList is empty
                if (notificationList.isEmpty()) {
                    recyclerViewEngageUpdate.visibility = View.GONE

                } else {
                    recyclerViewEngageUpdate.visibility = View.VISIBLE
                }
                progressBar.visibility = View.GONE
            }
            override fun onCancelled(databaseError: DatabaseError) {
                progressBar.visibility = View.GONE
            }
        })
        databaseReferenceAttended.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                attendedList.clear()

                // Get the UID of the current user
                val currentUserUid = auth.currentUser?.uid

                for (engagementSnapshot in dataSnapshot.children) {
                    val participantsRef = engagementSnapshot.child("Participants")
                    val joined = participantsRef.child(currentUserUid!!).child("joined").value as? Boolean

                    // Check if the current user is a participant and has joined the event
                    if (participantsRef.hasChild(currentUserUid) && joined == true) {
                        val postKey = engagementSnapshot.key ?: ""
                        val titleEvent = engagementSnapshot.child("titleEvent").value.toString()
                        val category = engagementSnapshot.child("category").value.toString()

                        // Check if attendedStamp is not null before parsing
                        val attendedStamp = participantsRef.child(currentUserUid).child("attendedStamp").value?.toString()
                        val endDateTime = attendedStamp?.let { SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(it) }

                        if (endDateTime != null) {
                            val currentDate = Date()
                            val calendar = Calendar.getInstance()
                            calendar.time = endDateTime
                            calendar.add(Calendar.MONTH, 1)

                            if (currentDate.after(calendar.time)) {
                                continue
                            }

                            val attendedData = AttendedAdapter.AttendedData(postKey, titleEvent, category, attendedStamp)
                            attendedList.add(attendedData)

                        }
                    }
                }
                attendedList.sortByDescending { it.attendedStamp }
                attendedAdapter.notifyDataSetChanged()
                updateAppIndicator()
                updateNoPostsVisibility()
                // Check if the attendedList is empty
                if (attendedList.isEmpty()) {
                    // If empty, hide the RecyclerViewAttended
                    RecyclerViewAttended.visibility = View.GONE
                } else {
                    // If not empty, show the RecyclerViewAttended
                    RecyclerViewAttended.visibility = View.VISIBLE
                }
                progressBar.visibility = View.GONE
            }

            override fun onCancelled(databaseError: DatabaseError) {
                progressBar.visibility = View.GONE
            }
        })

        databaseReferenceUsers.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                userList.clear()

                // Get the UID of the current user
                val currentUserUid = auth.currentUser?.uid

                for (userSnapshot in dataSnapshot.children) {
                    // Check if the current user matches the UID in the snapshot
                    if (userSnapshot.key == currentUserUid) {
                        // Retrieve verification status for the current user
                        val verificationStatus =
                            userSnapshot.child("verificationStatus").getValue(Boolean::class.java) ?: false

                        if (verificationStatus) {
                            // If verification status is true, add the user data to the list
                            val uid = userSnapshot.key ?: ""
                            val email = userSnapshot.child("email").getValue(String::class.java) ?: ""
                            val firstname = userSnapshot.child("firstname").getValue(String::class.java) ?: ""
                            val lastname = userSnapshot.child("lastname").getValue(String::class.java) ?: ""

                            // Retrieve the verifiedTimeStamp if it exists
                            val verifiedTimeStamp =
                                userSnapshot.child("verifiedTimeStamp").getValue(String::class.java) ?: ""

                            val userData = AccountVerificationAdapter.UserData(
                                uid,
                                email,
                                firstname,
                                lastname,
                                verificationStatus,
                                verifiedTimeStamp
                            )
                            val currentDate = Date()
                            val endDateTime = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(verifiedTimeStamp)

                            val calendar = Calendar.getInstance()
                            if (endDateTime != null) {
                                calendar.time = endDateTime
                            }
                            calendar.add(Calendar.MONTH, 1)

                            if (currentDate.after(calendar.time)) {
                                continue
                            }
                            userList.add(userData)
                        }
                    }
                }
                userList.sortByDescending { it.verifiedTimeStamp }
                accountVerificationAdapter.notifyDataSetChanged()
                updateAppIndicator()
                updateNoPostsVisibility()
                if (userList.isEmpty()) {
                    RecyclerViewAccApproved.visibility = View.GONE
                } else {

                    RecyclerViewAccApproved.visibility = View.VISIBLE
                }
                progressBar.visibility = View.GONE
            }

            override fun onCancelled(databaseError: DatabaseError) {
                progressBar.visibility = View.GONE
            }
        })
        databaseReferenceRequestVerify.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                requestList.clear()

                // Get the UID of the current user
                val currentUserUid = auth.currentUser?.uid

                for (requestSnapshot in dataSnapshot.children) {
                    // Check if the current user matches the UID in the snapshot and verificationStatus is true
                    if (requestSnapshot.child("uploadersUID").getValue(String::class.java) == currentUserUid
                        && requestSnapshot.child("verificationStatus").getValue(Boolean::class.java) == true
                    ) {
                        // Add the request data to the list
                        val titleEvent = requestSnapshot.child("titleEvent").getValue(String::class.java) ?: ""
                        val category = requestSnapshot.child("category").getValue(String::class.java) ?: ""
                        val approveTimeStamp = requestSnapshot.child("approveTimeStamp").getValue(String::class.java) ?: ""

                        val endDateTime = SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(approveTimeStamp)

                        if (endDateTime != null && isWithinOneMonth(endDateTime)) {
                            continue
                        }

                        requestList.add(RequestVerificationAdapter.RequestData(titleEvent, category, approveTimeStamp))

                    }
                }
                requestList.sortByDescending { it.approveTimeStamp }
                requestVerificationAdapter.notifyDataSetChanged()
                updateAppIndicator()
                updateNoPostsVisibility()
                if (requestList.isEmpty()) {
                    RecyclerViewEngagementApproved.visibility = View.GONE
                } else {
                    RecyclerViewEngagementApproved.visibility = View.VISIBLE
                }
                progressBar.visibility = View.GONE
            }

            override fun onCancelled(databaseError: DatabaseError) {
                progressBar.visibility = View.GONE
            }
        })
        databaseReferenceActivePoints.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                ActivePtsList.clear()

                val currentDate = Calendar.getInstance().time

                for (engagementSnapshot in dataSnapshot.children) {
                    val postKey = engagementSnapshot.key ?: ""
                    val participantsRef = engagementSnapshot.child("Participants")
                    val joined = participantsRef.child(currentUserUid!!).child("joined").value as? Boolean

                    if (joined == true) {
                        val titleEvent = engagementSnapshot.child("titleEvent").value.toString()
                        val activepts = (engagementSnapshot.child("activepoints").value as? Long)?.toInt() ?: 0

                        if (participantsRef.child(currentUserUid).hasChild("receivedStamp")) {
                            val receivedStamp =
                                participantsRef.child(currentUserUid).child("receivedStamp").value.toString()

                            if (receivedStamp.isNotEmpty()) {
                                // Calculate the timestamp 1 year after the receivedStamp
                                val endDateTime =
                                    SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(receivedStamp)
                                val calendar = Calendar.getInstance()

                                if (endDateTime != null) {
                                    calendar.time = endDateTime
                                    calendar.add(Calendar.MONTH, 1)

                                    if (currentDate.after(calendar.time)) {
                                        continue
                                    }
                                }
                                val notificationItem = ActivePointsAdapter.ActiveData(
                                    postKey,
                                    titleEvent,
                                    activepts,
                                    receivedStamp
                                )
                                ActivePtsList.add(notificationItem)
                            }
                        }
                    }
                }

                ActivePtsList.sortByDescending { it.receivedStamp }

                activePtsAdapter.notifyDataSetChanged()
                updateAppIndicator()
                updateNoPostsVisibility()
                if (ActivePtsList.isEmpty()) {
                    recyclerViewAct.visibility = View.GONE
                } else {
                    recyclerViewAct.visibility = View.VISIBLE
                }
                progressBar.visibility = View.GONE
            }

            override fun onCancelled(databaseError: DatabaseError) {
                progressBar.visibility = View.GONE
            }
        })

        databaseReferenceJoined.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                joinedList.clear()

                // Get the UID of the current user
                val currentUserUid = auth.currentUser?.uid

                for (engagementSnapshot in dataSnapshot.children) {
                    val postKey = engagementSnapshot.key ?: ""

                    // Check if the current user is a participant in this engagement
                    val participantsRef = engagementSnapshot.child("Participants")
                    if (participantsRef.hasChild(currentUserUid!!)) {

                        // Retrieve timestamp for the current user's participation
                        val timestamp = participantsRef.child(currentUserUid).child("timestamp").value.toString()

                        // Check if the engagement is within 24 hours from the current date and time
                        if (isWithin24Hours(timestamp)) {
                            val category = engagementSnapshot.child("category").value.toString()
                            val titleEvent = engagementSnapshot.child("titleEvent").value.toString()
                            val startDate = engagementSnapshot.child("startDate").value.toString()

                            // Create EngagementJoinedData instance
                            val engagementJoinedData = EngagementJoinedAdapter.EngagementJoinedData(
                                postKey,
                                titleEvent,
                                category,
                                startDate,
                                timestamp
                            )
                            joinedList.add(engagementJoinedData)
                        }
                    }
                }

                joinedList.sortByDescending { it.timestamp }
                engagementJoinedAdapter.notifyDataSetChanged()
                updateAppIndicator()
                updateNoPostsVisibility()
                // Check if the joinedList is empty
                if (joinedList.isEmpty()) {
                    // If empty, hide the RecyclerView or handle as needed
                    recyclerViewEngageJoined.visibility = View.GONE
                } else {
                    // If not empty, show the RecyclerView
                    recyclerViewEngageJoined.visibility = View.VISIBLE
                }
                progressBar.visibility = View.GONE
            }

            override fun onCancelled(databaseError: DatabaseError) {
                progressBar.visibility = View.GONE
            }
        })
        databaseReferenceAccReject.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                rejectedList.clear()
                val currentUserUid = auth.currentUser?.uid

                for (userSnapshot in dataSnapshot.children) {
                    if (userSnapshot.key == currentUserUid) {
                        val rejectReason = userSnapshot.child("rejectReason").getValue(String::class.java)
                        val rejectTimestamp = userSnapshot.child("rejectTimestamp").getValue(String::class.java)

                        // Add only if rejectReason is not null and verificationStatus is false
                        if (!rejectReason.isNullOrBlank() && !(userSnapshot.child("verificationStatus").getValue(Boolean::class.java) ?: true)) {
                            // Parse the rejectTimestamp
                            val endDateTime = rejectTimestamp?.let { SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(it) }

                            // Continue only if endDateTime is not null
                            if (endDateTime != null) {
                                val currentDate = Date()
                                val calendar = Calendar.getInstance()
                                calendar.time = endDateTime
                                calendar.add(Calendar.MONTH, 1)

                                // If currentDate is after 1 month of rejectTimestamp, skip this item
                                if (currentDate.after(calendar.time)) {
                                    continue
                                }
                                rejectedList.add(AccountRejectAdapter.RejectedData(rejectReason, rejectTimestamp))
                            }
                        }
                    }
                }

                val rejectedAdapter = AccountRejectAdapter(rejectedList)
                RecyclerViewAccReject.adapter = rejectedAdapter

                if (rejectedList.isEmpty()) {
                    RecyclerViewAccReject.visibility = View.GONE
                } else {
                    RecyclerViewAccReject.visibility = View.VISIBLE
                }

                rejectedList.sortByDescending { it.rejectTimestamp }
                updateAppIndicator()
                updateNoPostsVisibility()
                rejectedAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                progressBar.visibility = View.GONE
            }
        })

        val animatedBottomBar = requireActivity().findViewById<AnimatedBottomBar>(R.id.bottom_bar)
        val fab = requireActivity().findViewById<FloatingActionButton>(R.id.fab)
        val faback = requireActivity().findViewById<FloatingActionButton>(R.id.faback)

        nestedScrollView.setOnScrollChangeListener(View.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
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

        return view

    }
    private fun updateNoPostsVisibility() {
        val isNotificationListEmpty = notificationList.isEmpty()
        val isUserListEmpty = userList.isEmpty()
        val isJoinedListEmpty = joinedList.isEmpty()
        val isRejectListEmpty = rejectedList.isEmpty()
        val isActivePtsListEmpty = ActivePtsList.isEmpty()
        val isRequestListEmpty = requestList.isEmpty()
        val isAttendedListEmpty = attendedList.isEmpty()

        noPostsImage.visibility = if (isNotificationListEmpty && isUserListEmpty && isJoinedListEmpty &&
            isActivePtsListEmpty && isRequestListEmpty && isAttendedListEmpty && isRejectListEmpty
        ) {
            View.VISIBLE
        } else {
            View.GONE
        }

        noPostsText.visibility = if (isNotificationListEmpty && isUserListEmpty && isJoinedListEmpty &&
            isActivePtsListEmpty && isRequestListEmpty && isAttendedListEmpty && isRejectListEmpty
        ) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun isWithinOneMonth(endDateTime: Date): Boolean {
        val calendar = Calendar.getInstance()
        val currentDate = Date()
        calendar.time = endDateTime
        calendar.add(Calendar.MONTH, 1)

        return currentDate.after(calendar.time)
    }

    companion object {
        const val DATE_FORMAT = "MM/dd/yyyy hh:mm a"
    }
    private fun isWithin24Hours(startDateStr: String): Boolean {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        try {
            val startDate = dateFormat.parse(startDateStr)
            val currentDate = Date()

            // Calculate the difference in milliseconds
            val timeDifference = startDate.time - currentDate.time

            // Check if the time difference is less than 24 hours
            return timeDifference <= 24 * 60 * 60 * 1000
        } catch (e: ParseException) {
            // Handle the parsing exception
            e.printStackTrace()
        }
        return false
    }
    // Modify the calculateTimestamp24HoursBefore function
    private fun calculateTimestamp24HoursBefore(startDateStr: String): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        try {
            val startDate = dateFormat.parse(startDateStr)
            val currentDate = Calendar.getInstance().time

            // If the engagement has started, use the start date directly
            return if (currentDate.after(startDate)) {
                startDateStr
            } else {
                // Subtract 24 hours from the start date
                val calendar = Calendar.getInstance()
                calendar.time = startDate
                calendar.add(Calendar.HOUR_OF_DAY, -24)

                // Format the result as a timestamp
                dateFormat.format(calendar.time)
            }
        } catch (e: ParseException) {
            // Handle the parsing exception
            e.printStackTrace()
        }
        // Default to an empty string in case of errors
        return ""
    }
}