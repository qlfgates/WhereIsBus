package com.bigneardranch.android.whereisbus

import com.bigneardranch.android.whereisbus.api.BusApi
import com.bigneardranch.android.whereisbus.data.Bus
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class BusSearchResultRepository {

    private val busApi: BusApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ws.bus.go.kr/api/rest/buspos/")
//            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        busApi = retrofit.create()
    }

    suspend fun fetchContents() = busApi.fetchContents()
    suspend fun fetchBuses(): List<Bus> = busApi.fetchBus().buses.bus
}