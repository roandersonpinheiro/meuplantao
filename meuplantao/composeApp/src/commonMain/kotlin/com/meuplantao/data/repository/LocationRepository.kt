package com.meuplantao.data.repository

import com.meuplantao.domain.model.Location


interface LocationRepository {
    suspend fun getAllLocations(): List<Location>
    suspend fun createLocation(location: Location)
    suspend fun updateLocation(location: Location)
    suspend fun deleteLocation(id: Long)
    suspend fun getLocation(id: Long): Location?
}