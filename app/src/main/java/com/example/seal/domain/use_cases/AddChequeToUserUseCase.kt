package com.example.seal.domain.use_cases

import com.example.seal.data.models.UserDto
import com.example.seal.data.repo.UserRepo
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddChequeToUserUseCase @Inject constructor(
    private val userRepo: UserRepo
) {

//    operator fun invoke(email: String, cheque: Int) {
//        userRepo.addChequeToUser(email, cheque)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//    }
}