package com.example.seal.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.seal.data.models.CafeEntity
import io.reactivex.Single

//@Dao
//interface UserDao {
//
//    @Query("SELECT * FROM UserEntity WHERE email = :email")
//    fun getById(email: String): Single<UserEntity>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insert(user: UserEntity)
//}