package com.bigneardranch.android.whereisbus.api

import retrofit2.http.GET

interface BusApi {

    @GET("/")
    suspend fun fetchContents(): String
}