package com.example.seal.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CafeEntity (
    @PrimaryKey(autoGenerate = false)
    val objectId: String,
    val name: String,
    val address: String
)