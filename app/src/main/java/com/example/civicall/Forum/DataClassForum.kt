package com.example.civicall.Forum

class DataClassForum {
    var uploaderUid: String? = null
    var category: String? = null
    var postinputs: String? = null
    var imagePost: String? = null
    var postTime: String? = null
    var verificationStatus: Boolean = false

    var key: String? = null
        set(value) {
            field = value
        }

    constructor(
        uploaderUid: String?,
        category: String?,
        postinputs: String?,
        postTime: String?,
        imagePost: String,
        verificationStatus: Boolean
    ) {
        this.uploaderUid = uploaderUid
        this.category = category
        this.postinputs = postinputs
        this.postTime = postTime
        this.imagePost = imagePost
        this.verificationStatus = verificationStatus
    }
    constructor() {}
}
