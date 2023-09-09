package com.example.civicall.CivicEngagementPost

class DataClass {
    var dataTitle: String? = null
    var dataDesc: String? = null
    var dataIntro: String? = null
    var dataImage: String? = null
    var key: String? = null
        set(value) {
            field = value
        }

    constructor(dataTitle: String?, dataDesc: String?, dataIntro: String?, dataImage: String?) {
        this.dataTitle = dataTitle
        this.dataDesc = dataDesc
        this.dataIntro = dataIntro
        this.dataImage = dataImage
    }

    constructor() {}
}
