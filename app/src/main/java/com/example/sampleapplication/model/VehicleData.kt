package com.example.sampleapplication.model

import com.google.gson.annotations.SerializedName

data class VehicleData (
    @SerializedName("attributes")
    var attributes: Attributes
)
