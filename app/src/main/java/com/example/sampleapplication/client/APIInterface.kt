package com.example.sampleapplication.client

import com.example.sampleapplication.model.VehicleModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface APIInterface {

    @GET("/rentals")
    fun getVehicles(@QueryMap filters: Map<String, String>): Call<VehicleModel>

}