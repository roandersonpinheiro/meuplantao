package com.meuplantao.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.meuplantao.domain.model.Location

@Dao
interface LocationDao {
    @Query("SELECT * FROM locations")
    suspend fun getAllLocations(): List<Location>

    @Update
    suspend fun updateLocation(note: Location)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createLocation(note: Location)

    @Query("DELETE FROM locations WHERE id = :noteId")
    suspend fun deleteLocationById(noteId: Long)

    @Query("SELECT * FROM locations WHERE id = :noteId")
    suspend fun getLocationById(noteId: Long): Location?
}