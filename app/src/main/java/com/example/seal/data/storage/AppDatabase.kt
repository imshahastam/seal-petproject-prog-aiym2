package com.example.seal.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.seal.data.models.CafeEntity

@Database(entities = [CafeEntity::class], version = 2)
//@TypeConverters(RoomModelsConverter::class, RoomCollectionsConverter::class)
abstract class AppDatabase: RoomDatabase()  {

    abstract fun cafeDao(): CafeDao

    companion object {
        const val DB_NAME = "database"
    }
}