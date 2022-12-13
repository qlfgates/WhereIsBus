package com.bigneardranch.android.whereisbus

import android.content.Context
import androidx.room.Room
import com.bigneardranch.android.whereisbus.data.Bus
import com.bigneardranch.android.whereisbus.database.BusDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope

private const val DATABASE_NAME = "bus-database"

class BusRepository private constructor(context: Context, private val coroutineScope: CoroutineScope = GlobalScope) {

    private val database: BusDatabase = Room.databaseBuilder(
        context.applicationContext,
        BusDatabase::class.java,
        DATABASE_NAME
    ).createFromAsset(DATABASE_NAME).build()

    suspend fun getBuses(): List<Bus> = database.busDao().getBuses()
    suspend fun getBusesRouteId(routeId: String): List<Bus> = database.busDao().getBusesRouteId(routeId)

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