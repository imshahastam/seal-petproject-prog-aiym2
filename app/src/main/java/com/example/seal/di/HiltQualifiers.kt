package com.example.seal.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class InterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NoInterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class InterceptorRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NoInterceptorRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class InterceptorApi

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NoInterceptorApi