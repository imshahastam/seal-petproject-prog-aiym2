package com.example.seal.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.seal.data.models.CafeEntity
import io.reactivex.Single

@Dao
interface CafeDao {

    @Query("SELECT * FROM CafeEntity")
    fun getAll(): LiveData<List<CafeEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(cafiesList: List<CafeEntity>)

}