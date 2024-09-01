package com.meuplantao.domain


import com.meuplantao.data.repository.LocationRepository
import com.meuplantao.domain.model.Location
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CreateLocalUseCase : KoinComponent {
    private val localRepository: LocationRepository by inject()
    suspend fun execute(location: Location) = localRepository.createLocation(location)
}