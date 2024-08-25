package com.meuplantao.screen.detail

import androidx.lifecycle.ViewModel
import com.meuplantao.domain.MedicalShiftRepository

class DetailViewModel(private val repo: MedicalShiftRepository): ViewModel() {
    init {
        println("Detail ViewModel initializing...")
    }

    override fun onCleared() {
        super.onCleared()
        println("Detail ViewModel clearing...")
    }
}