package com.example.civicall.Forum

class DataClassForum {
    var uploadersUID: String? = null
    var category: String? = null
    var postText: String? = null
    var postImage: String? = null
    var campus: String? = null
//    var firstname: String? = null
//    var lastname: String? = null
//    var ImageProfile: String? =null
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
//        firstname: String?,
//        lastname: String?,
//        ImageProfile: String?,
        verificationStatus: Boolean

    ) {
        this.uploadersUID = uploadersuid
        this.category = category
        this.postText = postText
        this.postImage = postImage
        this.campus = campus
//        this.firstname = firstname
//        this.lastname = lastname
//        this.ImageProfile = ImageProfile
        this.verificationStatus = verificationStatus
    }

    constructor() {}
}
