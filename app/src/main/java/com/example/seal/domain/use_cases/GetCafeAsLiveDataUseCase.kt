package com.example.seal.domain.use_cases

import androidx.lifecycle.LiveData
import com.example.seal.data.models.CafeEntity
import com.example.seal.data.repo.CafeRepo
import javax.inject.Inject

class GetCafeAsLiveDataUseCase @Inject constructor(
    private val cafeRepo: CafeRepo
) {

    operator fun invoke(): LiveData<List<CafeEntity>> {
        return cafeRepo.getCafiesFromDB()
    }
}