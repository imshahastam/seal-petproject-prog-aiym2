package com.example.seal.data.models

//для сети
data class ResponseCafies(
    val response: List<CafeDto>
)

data class CafeDto (
    val objectId: String,
    val name: String
)