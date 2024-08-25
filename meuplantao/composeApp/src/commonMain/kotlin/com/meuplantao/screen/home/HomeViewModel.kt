package com.meuplantao.screen.home

import androidx.lifecycle.ViewModel
import com.meuplantao.domain.MedicalShiftRepository

class HomeViewModel(private val repo: MedicalShiftRepository): ViewModel() {
    init {
        println("Home ViewModel initializing...")
    }

    override fun onCleared() {
        super.onCleared()
        println("Home ViewModel clearing...")
    }
}