package com.example.urbanspots.ui.Viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.urbanspots.Data.Remote.Response.SpotInfo
import com.example.urbanspots.Repository.SpotRepository
import com.example.urbanspots.util.Ressource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SpotViewModel(private val repository: SpotRepository) : ViewModel() {

    private val _spotInfo = MutableStateFlow<Ressource<SpotInfo>?>(null)
    val spotInfo: StateFlow<Ressource<SpotInfo>?> = _spotInfo

    fun fetchSpotInfo(id: Int) {
        viewModelScope.launch {
            val result = repository.getSpotInfo(id)
            _spotInfo.value = result
        }
    }
}