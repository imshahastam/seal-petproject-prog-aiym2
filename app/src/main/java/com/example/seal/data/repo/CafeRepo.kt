package com.example.seal.data.repo

import com.example.seal.data.models.CafeDto
import com.example.seal.data.models.CafeEntity
import com.example.seal.data.network.CafeApi
import com.example.seal.data.storage.CafeDao
import javax.inject.Inject

class CafeRepo @Inject constructor(
    private var cafeDao: CafeDao,
    private var cafeApi: CafeApi
) {

    fun getCafiesFromApi() = cafeApi.getCafies()

    fun saveCafiesToDB(cafies: List<CafeEntity>) = cafeDao.insertList(cafies)

    fun getCafiesFromDB() = cafeDao.getAll()
}