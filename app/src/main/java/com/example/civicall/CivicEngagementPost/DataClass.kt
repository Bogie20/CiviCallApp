package com.example.civicall.CivicEngagementPost

class DataClass {
    var uploadersUID: String? = null
    var dataTitle: String? = null
    var dataDateandTime: String? = null
    var dataLocation: String? = null
    var dataImage: String? = null
    var verificationStatus: Boolean = false

    var key: String? = null
        set(value) {
            field = value
        }

    constructor(
        uploadersid: String?,
        dataTitle: String?,
        dataDateandTime: String?,
        dataLocation: String?,
        dataImage: String,
        verificationStatus: Boolean
    ) {
        this.uploadersUID = uploadersid
        this.dataTitle = dataTitle
        this.dataDateandTime = dataDateandTime
        this.dataLocation = dataLocation
        this.dataImage = dataImage
        this.verificationStatus = verificationStatus
    }

    constructor() {}
}