package com.example.seal.data.models

//для сети
data class ResponseCafies(
    val response: List<CafeDto>
)

data class CafeDto (
    val id: Int,
    val name: String
)