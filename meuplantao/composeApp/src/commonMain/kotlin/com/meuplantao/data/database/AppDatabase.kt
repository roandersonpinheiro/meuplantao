package com.meuplantao.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.meuplantao.domain.model.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [Location::class], version = 2)
abstract class AppDatabase : RoomDatabase(), DB {
    abstract fun locationDao(): LocationDao
    override fun clearAllTables(): Unit {}
}

interface DB {
    fun clearAllTables(): Unit {}
}
fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}