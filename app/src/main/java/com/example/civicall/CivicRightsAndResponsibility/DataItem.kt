package com.example.civicall.CivicRightsAndResponsibility

data class DataItem(
val title: String,
val paragraph: String,
val imageResourceId: Int,
val link: String,
val imageLink: String,
var scaleFactor: Float = 1.0f
)