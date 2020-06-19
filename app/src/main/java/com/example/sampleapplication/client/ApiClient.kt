package com.example.sampleapplication.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        private const val BASE_URL = "https://search.outdoorsy.co"
        var retrofit: Retrofit? = null

        fun getApiClient() : Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }

        fun getVehicleFilter(filter: String, page: String) : Map<String, String> {
            var mapFilter = HashMap<String, String>(2)
            mapFilter["filters"] = filter
            mapFilter["limit"] = page
            return mapFilter
        }
    }
}