package com.example.seal.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CafeEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String)