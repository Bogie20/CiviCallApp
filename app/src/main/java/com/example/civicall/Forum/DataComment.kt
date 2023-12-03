package com.example.civicall.Forum

data class DataComment(
    var commentText: String? = null,
    var commenterUID: String? = null,
    var commentTime: String? = null,
    var commentKey: String? = null,
    var upReactCount: Int = 0,
    var downReactCount: Int = 0,
    val currentUserReact: String? = null,
    var isHidden: Boolean = false,
    var reactComment: Map<String, Boolean> = mapOf()
) {
    constructor(
        commentText: String?,
        commenterUID: String?,
        commentTime: String?,
        commentKey: String?,
        currentUserReact: String?,
        upReactCount: Int,
        downReactCount: Int,
        isHidden: Boolean

    ) : this(commentText, commenterUID, commentTime, commentKey, upReactCount, downReactCount, currentUserReact, isHidden)
}

