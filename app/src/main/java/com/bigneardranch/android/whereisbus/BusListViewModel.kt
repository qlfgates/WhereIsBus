package com.bigneardranch.android.whereisbus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigneardranch.android.whereisbus.routedatabase.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "BusListViewModel"

class BusListViewModel() : ViewModel() {

    private val busRepository = BusRepository.get()

    private val _routes: MutableStateFlow<List<Route>> = MutableStateFlow(emptyList())
    val routes: StateFlow<List<Route>>
        get() = _routes.asStateFlow()

    init{
        viewModelScope.launch {
            busRepository.getBusIds().collect(){
                _routes.value = it
            }
        }
    }
}