package com.meuplantao.di


import com.meuplantao.data.database.AppDatabase
import org.koin.dsl.module

actual fun platformModule() = module {
    single<AppDatabase> { getDatabaseBuilder() }
}