package com.meuplantao.screen.detail

import androidx.lifecycle.ViewModel

class DetailViewModel(): ViewModel() {
    init {
        println("Detail ViewModel initializing...")
    }

    override fun onCleared() {
        super.onCleared()
        println("Detail ViewModel clearing...")
    }
}