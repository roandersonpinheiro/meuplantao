package com.meuplantao.di

import com.meuplantao.data.datasource.LocationLocalDataSource
import com.meuplantao.data.datasource.LocationLocalDataSourceImpl
import com.meuplantao.data.repository.LocationRepository
import com.meuplantao.data.repository.LocationRepositoryImpl
import com.meuplantao.domain.CreateLocalUseCase
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module


expect fun platformModule(): Module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            provideDataSourceModule, provideRepositoryModule, provideUseCaseModule,
            platformModule()
        )
    }

val provideDataSourceModule = module {
    single { LocationLocalDataSourceImpl(get()) } bind LocationLocalDataSource::class
}

val provideRepositoryModule = module {
    single { LocationRepositoryImpl(get()) } bind LocationRepository::class
}

val provideUseCaseModule = module {
    single { CreateLocalUseCase() }
}