package com.meuplantao.data.datasource

import com.meuplantao.domain.model.Location


interface LocationLocalDataSource {
    suspend fun getAllLocations(): List<Location>
    suspend fun createLocation(location: Location)
    suspend fun deleteLocation(id: Long)
    suspend fun updateLocation(location: Location)
    suspend fun getLocation(id: Long): Location?
}