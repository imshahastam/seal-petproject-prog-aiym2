package com.example.seal.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.seal.data.models.CafeEntity
import com.example.seal.data.repo.CafeRepo
import io.reactivex.Observable
import javax.inject.Inject

class GetCafiesFromDBUseCase @Inject constructor(
    private val cafeRepo: CafeRepo
) {

    operator fun invoke(): LiveData<List<CafeEntity>> {
        return cafeRepo.getCafiesFromDB()
    }
}