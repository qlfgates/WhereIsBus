package com.bigneardranch.android.whereisbus.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//노선번호로 검색시 요청에 대한 응답
//routeId로 검색

private const val TAG = "BUS_RESPONSE"

@JsonClass(generateAdapter = true)
data class BusResponse(
    @Json(name = "msgBody")
    val buses: BusItemResponse
)