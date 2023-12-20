package com.example.civicall.Calendar

data class CalendarData(
    val engagementImage: String,
    val recTitle: String,
    val location: String,
    val startDate: String,
    val endDate: String,
    val postKey: String,
    var hasAttended: Boolean
)
