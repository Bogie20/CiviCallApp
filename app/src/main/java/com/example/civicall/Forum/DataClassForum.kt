package com.example.civicall.Forum

class DataClassForum {
    var uploadersUID: String? = null
    var category: String? = null
    var postText: String? = null
    var startDate: String? = null
    var endDate: String? = null
    var postImage: String? = null
    var campus: String? = null
    var targetparty: Int = 0
    var activepoints: Int = 0
    var fundcollected: Double = 0.0
    var verificationStatus: Boolean = false

    var key: String? = null
        set(value) {
            field = value
        }

    constructor(
        uploadersuid: String?,
        category: String?,
        postText: String?,
        startDate: String?,
        endDate: String?,
        postImage: String,
        campus: String?,
        targetparty: Int,
        activepoints: Int,
        fundcollected: Double,
        verificationStatus: Boolean

    ) {
        this.uploadersUID = uploadersuid
        this.category = category
        this.postText = postText
        this.startDate = startDate
        this.endDate = endDate
        this.postImage = postImage
        this.campus = campus
        this.targetparty = targetparty
        this.activepoints = activepoints
        this.fundcollected = fundcollected
        this.verificationStatus = verificationStatus
    }

    constructor() {}
}
