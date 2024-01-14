package com.example.civicall.CivicEngagementPost

class DataClass {
    var uploadersUID: String? = null
    var category: String? = null
    var title: String? = null
    var startDate: String? = null
    var endDate: String? = null
    var location: String? = null
    var image: String? = null
    var campus: String? = null
    var objective: String? = null
    var intro: String? = null
    var facilitatorsName: String? = null
    var facilitatorsContactorEmail: String? = null
    var instruction: String? = null
    var targetparty: Int = 0
    var activepoints: Int = 0
    var paymentMethod: String? = null
    var paymentRecipient: String? = null
    var fundcollected: Double = 0.0
    var verificationStatus: Boolean = false

    var key: String? = null
        set(value) {
            field = value
        }

    constructor(
        uploadersuid: String?,
        category: String?,
        title: String?,
        startDate: String?,
        endDate: String?,
        location: String?,
        image: String,
        campus: String?,
        objective: String,
        intro: String?,
        facilitatorsName: String?,
        facilitatorsContactorEmail: String?,
        instruction: String?,
        targetparty: Int,
        activepoints: Int,
        paymentMethod: String?,
        paymentRecipient: String?,
        fundcollected: Double,
        verificationStatus: Boolean,


    ) {
        this.uploadersUID = uploadersuid
        this.category = category
        this.title = title
        this.startDate = startDate
        this.endDate = endDate
        this.location = location
        this.image = image
        this.campus = campus
        this.objective = objective
        this.intro = intro
        this.facilitatorsName = facilitatorsName
        this.facilitatorsContactorEmail = facilitatorsContactorEmail
        this.instruction = instruction
        this.targetparty = targetparty
        this.activepoints = activepoints
        this.paymentMethod = paymentMethod
        this.paymentRecipient = paymentRecipient
        this.fundcollected = fundcollected
        this.verificationStatus = verificationStatus

    }

    constructor() {}
}
