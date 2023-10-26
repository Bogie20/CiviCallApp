package com.example.civicall.CivicEngagementPost

class DataClass {
    var dataTitle: String? = null
    var dataDateandTime: String? = null
    var dataLocation: String? = null
    var dataImage: String? = null
    var key: String? = null
        set(value) {
            field = value
        }

    constructor(dataTitle: String?, dataDateandTime: String?, dataLocation: String?, dataImage: String?) {
        this.dataTitle = dataTitle
        this.dataDateandTime = dataDateandTime
        this.dataLocation = dataLocation
        this.dataImage = dataImage
    }

    constructor() {}
}
