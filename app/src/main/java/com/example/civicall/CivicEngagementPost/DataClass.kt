package com.example.civicall.CivicEngagementPost

class DataClass {
    var uploadersUID: String? = null
    var category: String? = null
    var title: String? = null
    var dateandTime: String? = null
    var location: String? = null
    var image: String? = null
    var campus: String? = null
    var objective: String? = null
    var intro: String? = null
    var facilitatorsName: String? = null
    var facilitatorsContactorEmail: String? = null
    var instruction: String? = null
    var targetparty: String? = null
    var verificationStatus: Boolean = false

    var key: String? = null
        set(value) {
            field = value
        }

    constructor(
        uploadersuid: String?,
        category: String?,
        title: String?,
        dateandTime: String?,
        location: String?,
        image: String,
        campus: String?,
        objective: String,
        intro: String?,
        facilitatorsName: String?,
        facilitatorsContactorEmail: String?,
        instruction: String?,
        targetparty: String?,
        verificationStatus: Boolean
    ) {
        this.uploadersUID = uploadersuid
        this.category = category
        this.title = title
        this.dateandTime = dateandTime
        this.location = location
        this.image = image
        this.campus = campus
        this.objective = objective
        this.intro = intro
        this.facilitatorsName = facilitatorsName
        this.facilitatorsContactorEmail = facilitatorsContactorEmail
        this.instruction = instruction
        this.targetparty = targetparty
        this.verificationStatus = verificationStatus
    }

    constructor() {}
}
