package com.example.civicall.Forum

class DataClassForum {
    var uploadersUID: String? = null
    var category: String? = null
    var postText: String? = null
    var postImage: String? = null
    var campus: String? = null
    var hiddenByUsers: List<String>? = null
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
        hiddenByUsers: List<String>?,
        verificationStatus: Boolean

    ) {
        this.uploadersUID = uploadersuid
        this.category = category
        this.postText = postText
        this.postImage = postImage
        this.campus = campus
        this.hiddenByUsers = hiddenByUsers
        this.verificationStatus = verificationStatus
    }

    constructor() {}
}
