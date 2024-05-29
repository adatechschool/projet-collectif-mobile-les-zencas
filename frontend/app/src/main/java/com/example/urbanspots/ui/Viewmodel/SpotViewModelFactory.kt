package com.example.urbanspots.ui.Viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.urbanspots.Repository.SpotRepository

class SpotViewModelFactory(private val repository: SpotRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SpotViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SpotViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}