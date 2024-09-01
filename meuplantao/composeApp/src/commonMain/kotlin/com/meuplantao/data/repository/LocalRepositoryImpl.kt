package com.meuplantao.data.repository


import com.meuplantao.data.datasource.LocationLocalDataSource
import com.meuplantao.domain.model.Location


class LocationRepositoryImpl(private val repository: LocationLocalDataSource) : LocationRepository {
    override suspend fun getAllLocations(): List<Location> = repository.getAllLocations()

    override suspend fun createLocation(location: Location) = repository.createLocation(location)

    override suspend fun updateLocation(location: Location) = repository.updateLocation(location)

    override suspend fun deleteLocation(id: Long) = repository.deleteLocation(id)

    override suspend fun getLocation(id: Long): Location? = repository.getLocation(id)
}