package com.bigneardranch.android.whereisbus.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//노선번호로 검색시 요청에 대한 응답
//routeId로 검색

private const val TAG = "BUS_ITEM_RESPONSE"

@JsonClass(generateAdapter = true)
data class BusItemResponse(
    @Json(name = "itemList")
    val bus: List<Bus>
)