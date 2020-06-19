package com.example.sampleapplication.model

import com.google.gson.annotations.SerializedName

data class VehicleModel (

    @SerializedName("data")
    var vehicleModel : List<VehicleData>

)




