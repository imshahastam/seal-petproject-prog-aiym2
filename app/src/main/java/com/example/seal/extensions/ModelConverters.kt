package com.example.seal.extensions

import com.example.seal.data.models.CafeDto
import com.example.seal.data.models.CafeEntity
import com.example.seal.data.models.UserDto
import com.example.seal.domain.models.Cafe
import io.reactivex.Single

fun CafeDto.toCafeEntity() : CafeEntity {
    return CafeEntity(
        objectId,
        name,
        address
    )
}

fun CafeDto.toCafe() : Cafe {
    return Cafe(
        objectId,
        name,
        address
    )
}

//fun UserDto.toUserEntity() : UserEntity {
//    return UserEntity(
//        email, name, surname, cheque
//    )
//}