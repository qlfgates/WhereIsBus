package com.bigneardranch.android.whereisbus.api

import com.bigneardranch.android.whereisbus.data.BusResponse
import retrofit2.http.GET

private const val API_KEY = "zH5Ha%2BqqrVSIOJ8Sq9nKTBxPEwVzbrapRS2OEzmyEcDi0y6EtEjOrrWMRHfOmOkyhXp8Jb9zMeGgpT8YHc0pAw%3D%3D"

interface BusApi {

    @GET("/")
    suspend fun fetchContents(): BusResponse

    @GET("api/rest/buspos/getBusPosByRtid?")
    suspend fun fetchBus(): BusResponse

}