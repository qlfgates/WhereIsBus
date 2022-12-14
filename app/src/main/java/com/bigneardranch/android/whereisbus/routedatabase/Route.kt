package com.bigneardranch.android.whereisbus.routedatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Route(
    @PrimaryKey val busId: String,
    val busNumber: String
)