package com.meuplantao.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class Location(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val name: String,
    val address: String,
    val color: String?,
    val createdAt: Long,
    val updatedAt: Long?,
)