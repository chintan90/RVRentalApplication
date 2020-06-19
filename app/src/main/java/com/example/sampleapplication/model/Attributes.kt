package com.example.sampleapplication.model

import com.google.gson.annotations.SerializedName

data class Attributes (
    @SerializedName("name")
    var vehicleName: String ?= null,

    @SerializedName("primary_image_url")
    var vehicleImage : String ?= null
)
