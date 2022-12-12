package com.bigneardranch.android.whereisbus.database

import androidx.room.Dao
import androidx.room.Query
import com.bigneardranch.android.whereisbus.Bus

@Dao
interface BusDAO {

    @Query("SELECT * FROM bus")
    suspend fun getBuses(): List<Bus>

    @Query("SELECT * FROM bus WHERE routeId")
    suspend fun getBusesRouteId(): List<Bus>

}