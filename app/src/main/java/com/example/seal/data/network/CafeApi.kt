package com.example.seal.data.network

import com.example.seal.data.models.CafeDto
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface CafeApi {

    @GET("Cafies")
    fun getCafies(): Single<List<CafeDto>>
}