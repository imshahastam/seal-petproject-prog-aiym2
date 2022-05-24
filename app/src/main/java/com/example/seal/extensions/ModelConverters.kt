package com.example.seal.extensions

import com.example.seal.data.models.CafeDto
import com.example.seal.data.models.CafeEntity
import com.example.seal.domain.models.Cafe

fun CafeDto.toCafeEntity() : CafeEntity {
    return CafeEntity(
        id,
        name
    )
}

fun CafeDto.toCafe() : Cafe {
    return Cafe(
        id,
        name
    )
}