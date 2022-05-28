package com.example.seal.domain.use_cases

import com.example.seal.data.models.CafeDto
import com.example.seal.data.models.CafeEntity
import com.example.seal.data.repo.CafeRepo
import com.example.seal.domain.models.Cafe
import com.example.seal.extensions.toCafe
import com.example.seal.extensions.toCafeEntity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetCafiesUseCase @Inject constructor(
    private val cafeRepo: CafeRepo
) {

    operator fun invoke(): Single<List<Cafe>> {
        return cafeRepo.getCafiesFromApi()
            .subscribeOn(Schedulers.io())
            .map {
                cafeRepo.saveCafiesToDB(it.map { it.toCafeEntity() })
                it.map { it.toCafe() }
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}