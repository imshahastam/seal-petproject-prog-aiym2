package com.example.seal.di.modules

import androidx.viewbinding.BuildConfig
import com.example.seal.BuildConfig.BASE_URL
import com.example.seal.data.network.CafeApi
import com.example.seal.di.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideCafeApi(retrofit: Retrofit): CafeApi = retrofit.create(CafeApi::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = createOkHttpClientBuilder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okhttpClient: OkHttpClient): Retrofit = createRetrofit(okhttpClient)

    private fun createOkHttpClientBuilder(): OkHttpClient.Builder {
        val interceptor = HttpLoggingInterceptor()
            .apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

        return OkHttpClient.Builder()
            .apply {
                connectTimeout(2, TimeUnit.MINUTES)
                writeTimeout(2, TimeUnit.MINUTES)
                readTimeout(2, TimeUnit.MINUTES)
                if (BuildConfig.DEBUG) {
                    addInterceptor(interceptor)
                }
            }
    }

    private fun createRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
    }

    companion object {
        private const val BASE_URL = "https://shybasket.backendless.app/api/data/"
    }
}