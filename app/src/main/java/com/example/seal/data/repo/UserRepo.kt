package com.example.seal.data.repo

import com.example.seal.data.models.CafeEntity
import com.example.seal.data.models.UserDto
import com.example.seal.data.network.CafeApi
import com.example.seal.data.network.UserApi
import com.example.seal.data.storage.CafeDao
import io.reactivex.Single
import retrofit2.http.Body
import javax.inject.Inject

class UserRepo @Inject constructor(
    private var userApi: UserApi
) {

    fun saveUser(user: UserDto) = userApi.saveUser(user)

//    fun addChequeToUser(email: String, cheque: Int) = userApi.addChequeToUser(email, cheque)
//
    fun getUserByIdFromApi(userId: String) = userApi.getUserById(userId)

//    fun saveUserToDB(user: UserEntity) = userDao.insert(user)
}