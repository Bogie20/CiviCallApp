package com.example.civicall.Forum

class DataClassForum {
    var uploadersUID: String? = null
    var category: String? = null
    var postText: String? = null
    var postImage: String? = null
    var campus: String? = null
    var isHidden: Boolean = false
    var postTime: String? = null
    var commentCount: Int = 0
    var reactType: String? = null
    var upReactCount: Int = 0
    var downReactCount: Int = 0

    var key: String? = null
        set(value) {
            field = value
        }

    constructor(
        uploadersuid: String?,
        category: String?,
        postText: String?,
        postImage: String,
        campus: String?,
        isHidden: Boolean,
        postTime: String,
        commentCount: Int,
        reactType: String?,
        upReactCount: Int,
        downReactCount: Int

    ) {
        this.uploadersUID = uploadersuid
        this.category = category
        this.postText = postText
        this.postImage = postImage
        this.campus = campus
        this.isHidden = isHidden
        this.postTime = postTime
        this.commentCount = commentCount
        this.reactType = reactType
        this.upReactCount = upReactCount
        this.downReactCount = downReactCount
    }

    constructor() {}
}
