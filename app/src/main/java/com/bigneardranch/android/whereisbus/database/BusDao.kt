package com.bigneardranch.android.whereisbus.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bigneardranch.android.whereisbus.data.Bus
import kotlinx.coroutines.flow.Flow

@Dao
interface BusDao {

    @Query("SELECT * FROM Bus")
    fun getBuses(): Flow<List<Bus>>

    @Query("SELECT * FROM bus WHERE routeId=(:routeId)")
    suspend fun getBusesRouteId(routeId: String): Bus

    @Insert
    suspend fun addBus(bus: Bus)

}