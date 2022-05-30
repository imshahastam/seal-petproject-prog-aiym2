package com.example.seal.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.seal.data.storage.AppDatabase
import com.example.seal.data.storage.CafeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {
    @Provides
    fun provideDao(appDatabase: AppDatabase): CafeDao {
        return appDatabase.cafeDao()
    }

//    @Provides
//    fun provideUserDao(appDatabase: AppDatabase): UserDao {
//        return appDatabase.userDao()
//    }

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("preferences_name", Context.MODE_PRIVATE)
    }
}