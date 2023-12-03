package com.example.civicall.Forum

data class DataComment(
    var commentText: String? = null,
    var commenterUID: String? = null,
    var commentTime: String? = null,
    var upReactCount: Int = 0,
    var downReactCount: Int = 0,
    var key: String? = null,
    val currentUserReact: String? = null,
    var reactComment: Map<String, Boolean> = mapOf()
) {
    constructor(
        commentText: String?,
        commenterUID: String?,
        commentTime: String?,
        currentUserReact: String?,
        upReactCount: Int,
        downReactCount: Int,
    ) : this(commentText, commenterUID, commentTime, upReactCount, downReactCount, null,currentUserReact)
}
