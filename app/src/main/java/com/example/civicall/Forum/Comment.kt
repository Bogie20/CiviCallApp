package com.example.civicall.Forum

data class Comment(
    val commentText: String = "",
    val commenterUID: String = "",
    val commentTime: String = "",
    val upReactCount: Int = 0,
    val downReactCount: Int = 0,
    val reactType: String? = null
)



