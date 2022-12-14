package com.bigneardranch.android.whereisbus

import com.bigneardranch.android.whereisbus.api.BusApi
import com.bigneardranch.android.whereisbus.api.BusLocationInterceptor
import com.bigneardranch.android.whereisbus.data.Bus
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class BusSearchResultRepository {

    private val busApi: BusApi

    init {

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(BusLocationInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ws.bus.go.kr/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
        busApi = retrofit.create()
    }

    suspend fun fetchContents() = busApi.fetchContents()
    suspend fun fetchBuses(): List<Bus> = busApi.fetchBus().buses.bus

//    suspend fun searchPhotos(query: String): List<Bus> =
}