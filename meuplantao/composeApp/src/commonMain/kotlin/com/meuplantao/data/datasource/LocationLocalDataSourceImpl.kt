package com.meuplantao.data.datasource

import com.meuplantao.data.database.AppDatabase
import com.meuplantao.domain.model.Location


class LocationLocalDataSourceImpl(private val appDatabase: AppDatabase) : LocationLocalDataSource {
    override suspend fun getAllLocations(): List<Location> = appDatabase.locationDao().getAllLocations()

    override suspend fun createLocation(note: Location) = appDatabase.locationDao().createLocation(note)

    override suspend fun deleteLocation(id: Long) = appDatabase.locationDao().deleteLocationById(id)

    override suspend fun updateLocation(note: Location) = appDatabase.locationDao().updateLocation(note)

    override suspend fun getLocation(id: Long) = appDatabase.locationDao().getLocationById(id)
}