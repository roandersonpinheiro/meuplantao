package com.meuplantao.di

import com.meuplantao.data.repository.MedicalShiftRepositoryImpl
import com.meuplantao.domain.MedicalShiftRepository
import com.meuplantao.screen.detail.DetailViewModel
import com.meuplantao.screen.home.HomeViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single<MedicalShiftRepository> { MedicalShiftRepositoryImpl() }
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}

fun initializeKoin() {
    startKoin {
        modules(appModule)
    }
}