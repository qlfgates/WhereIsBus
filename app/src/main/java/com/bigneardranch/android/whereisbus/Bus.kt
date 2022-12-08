package com.bigneardranch.android.whereisbus


data class Bus(
    //구간순번
    val selectOrd: String,
    //정류소도착여부
    val stopFlag: String,
    //구간ID
    val selectId: String,
    //버스ID
    val vehId: String,
    //차량번호
    val plainNo: String,
    //노선ID:버스노선(2412 등)
    val routeId: String,
)