package com.meuplantao.db

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.meuplantao.data.database.AppDatabase
import kotlinx.coroutines.Dispatchers

fun getDatabaseBuilder(ctx: Context): AppDatabase {
    val dbFile = ctx.getDatabasePath("medical_shift.db")
    return Room.databaseBuilder<AppDatabase>(ctx, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}