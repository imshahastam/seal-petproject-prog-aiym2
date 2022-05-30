package com.example.seal.domain.use_cases

import com.example.seal.data.models.UserDto
import com.example.seal.data.repo.CafeRepo
import com.example.seal.data.repo.UserRepo
import com.example.seal.domain.models.Cafe
import com.example.seal.extensions.toCafe
import com.example.seal.extensions.toCafeEntity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val userRepo: UserRepo
) {

    operator fun invoke(user: UserDto): Observable<Unit> {
        return userRepo.saveUser(user)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}