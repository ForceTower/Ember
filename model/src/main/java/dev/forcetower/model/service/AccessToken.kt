package dev.forcetower.model.service

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AccessToken(
    @PrimaryKey
    val token: String
)