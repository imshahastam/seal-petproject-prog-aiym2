package com.example.seal.data.network

import com.example.seal.data.models.UserDto
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface UserApi {

    @POST("User")
    fun saveUser(@Body user: UserDto) : Observable<Unit>

//    @FormUrlEncoded
//    @PUT("User/{email}")
//    fun addChequeToUser(
//        @Path("email") email: String,
//        @Field("cheque") cheque: Int
//    ) : Observable<Unit>

    @GET("User/{objectId}")
    fun getUserById(@Path ("objectId") objectId: String) : Single<UserDto>
}