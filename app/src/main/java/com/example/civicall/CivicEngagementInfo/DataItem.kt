package com.example.civicall.CivicEngagementInfo

data class DataItem(
    val title: String,
    val paragraph: String,
    val imageLink: String,
    val link: String,
    var scaleFactor: Float = 1.0f
)
