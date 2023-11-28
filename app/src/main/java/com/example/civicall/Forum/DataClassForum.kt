package com.example.civicall.Forum

class DataClassForum {
    var uploadersUID: String? = null
    var category: String? = null
    var postText: String? = null
    var postImage: String? = null
    var campus: String? = null
    var isHidden: Boolean = false
    var verificationStatus: Boolean = false

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
        verificationStatus: Boolean

    ) {
        this.uploadersUID = uploadersuid
        this.category = category
        this.postText = postText
        this.postImage = postImage
        this.campus = campus
        this.isHidden = isHidden
        this.verificationStatus = verificationStatus
    }

    constructor() {}
}
