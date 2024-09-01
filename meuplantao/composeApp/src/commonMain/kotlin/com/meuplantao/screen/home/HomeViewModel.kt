package com.meuplantao.screen.home

import androidx.lifecycle.ViewModel

class HomeViewModel(): ViewModel() {
    init {
        println("Home ViewModel initializing...")
    }

    override fun onCleared() {
        super.onCleared()
        println("Home ViewModel clearing...")
    }
}