package com.bigneardranch.android.whereisbus.routedatabase

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RouteDao {

    @Query("SELECT * FROM Route")
    fun getBusIdS(): Flow<List<Route>>

    @Query("SELECT * FROM Route WHERE busNumber=(:busNumber)")
    suspend fun getBusId(busNumber: String): Route
}