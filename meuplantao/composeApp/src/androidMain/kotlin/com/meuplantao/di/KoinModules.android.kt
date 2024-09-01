package com.meuplantao.di

import com.meuplantao.data.database.AppDatabase
import com.meuplantao.db.getDatabaseBuilder
import org.koin.dsl.module

actual fun platformModule() = module {
    single<AppDatabase> { getDatabaseBuilder(get()) }
}