package com.example.civicall.CivicEngagementPost

class DataClass {
    var uploadersUID: String? = null
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
    var verificationStatus: Boolean = false

    var key: String? = null
        set(value) {
            field = value
        }

    constructor(
        uploadersuid: String?,
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
        verificationStatus: Boolean
    ) {
        this.uploadersUID = uploadersuid
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
        this.verificationStatus = verificationStatus
    }

    constructor() {}
}
