package com.example.civicall.Notification

data class DataClassNotif(
    val postKey: String,
    val category: String,
    val titleEvent: String,
    val startDate: String,
    val endDate: String,
    val imageUrl: String,
    val timestamp: String
)
