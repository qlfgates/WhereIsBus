package com.bigneardranch.android.whereisbus

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.bigneardranch.android.whereisbus.data.Bus
import com.bigneardranch.android.whereisbus.routedatabase.Route
import com.bigneardranch.android.whereisbus.routedatabase.RouteDatabase
import com.opencsv.CSVReader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow

private const val DATABASE_NAME = "route-db.db"

class BusRepository private constructor(context: Context, private val coroutineScope: CoroutineScope = GlobalScope) {

    private val routeDatabase: RouteDatabase = Room.databaseBuilder(
        context.applicationContext,
        RouteDatabase::class.java,
        DATABASE_NAME
    ).createFromAsset(DATABASE_NAME).build()

    fun getBusIds(): Flow<List<Route>> = routeDatabase.routeDao().getBusIdS()
    suspend fun getBusId(busNumber: String): Route = routeDatabase.routeDao().getBusId(busNumber)

    companion object{
        private var INSTANCE: BusRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = BusRepository(context)
            }
        }

        fun get(): BusRepository{
            return INSTANCE ?: throw IllegalStateException("BusRepository must be initialized")
        }
    }
}