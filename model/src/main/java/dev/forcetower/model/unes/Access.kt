package dev.forcetower.model.unes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Access(
    @PrimaryKey
    val username: String,
    val password: String
)