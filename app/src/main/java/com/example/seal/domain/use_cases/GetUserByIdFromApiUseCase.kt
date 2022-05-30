package com.example.seal.domain.use_cases

import android.content.SharedPreferences
import com.example.seal.data.models.UserDto
import com.example.seal.data.repo.UserRepo
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

//class GetUserByIdFromApiUseCase @Inject constructor(
//    private val userRepo: UserRepo
//) {
//
//    operator fun invoke(email: String): Single<UserDto> {
//        return userRepo.getUserByIdFromApi(email)
//            .subscribeOn(Schedulers.io())
//            .map {
//                userRepo.saveUserToDB(it.toUserEntity())
//                it
//            }
//            .observeOn(AndroidSchedulers.mainThread())
//    }
//}