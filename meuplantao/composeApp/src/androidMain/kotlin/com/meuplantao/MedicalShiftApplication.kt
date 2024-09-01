package com.meuplantao

import android.app.Application
import com.meuplantao.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent


class MedicalShiftApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@MedicalShiftApplication)
        }
    }
}