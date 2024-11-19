package com.example.salatprayertime

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/timingsByCity")
    fun getPrayerTimes(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Int = 2
    ): Call<TimingsResponse>
}