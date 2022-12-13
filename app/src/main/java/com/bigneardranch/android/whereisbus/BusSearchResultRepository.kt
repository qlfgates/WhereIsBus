package com.bigneardranch.android.whereisbus

import android.content.Context
import androidx.room.Room
import com.bigneardranch.android.whereisbus.api.BusApi
import com.bigneardranch.android.whereisbus.data.Bus
import com.bigneardranch.android.whereisbus.database.BusDatabase
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

private const val DATABASE_NAME = "bus-database"

class BusSearchResultRepository private constructor(context: Context){

    private val busApi: BusApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ws.bus.go.kr/api/rest/buspos/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        busApi = retrofit.create()
    }

    suspend fun fetchContents() = busApi.fetchContents()
    suspend fun fetchBuses(): List<Bus> = busApi.fetchBus().buses.bus

    private val database: BusDatabase = Room.databaseBuilder(
        context.applicationContext,
        BusDatabase::class.java,
        DATABASE_NAME
    ).build()
}