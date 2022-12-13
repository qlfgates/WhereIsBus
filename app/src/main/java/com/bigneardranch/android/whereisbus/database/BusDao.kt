package com.bigneardranch.android.whereisbus.database

import androidx.room.Dao
import androidx.room.Query
import com.bigneardranch.android.whereisbus.data.Bus

@Dao
interface BusDao {

    @Query("SELECT * FROM Bus")
    suspend fun getBuses(): List<Bus>

    @Query("SELECT * FROM bus WHERE routeId=(:routeId)")
    suspend fun getBusesRouteId(routeId: String): List<Bus>

}