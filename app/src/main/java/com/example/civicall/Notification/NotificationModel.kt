package com.example.civicall.Notification

data class NotificationModel(
    val id: String,
    val recImage: String,

    val imageUrl: String,
    val startDate: String,
    val title: String,

    val category: String,
val status:String// Add this property for event category
)
