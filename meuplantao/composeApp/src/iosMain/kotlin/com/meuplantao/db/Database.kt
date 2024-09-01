package com.meuplantao.db

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.meuplantao.data.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): AppDatabase {
    val dbFile = "${NSHomeDirectory()}/medical_shift.db"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile,
        factory = { AppDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}