package com.afoxplus.restaurants.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RestaurantGsonConverterFactory

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RestaurantHttpLoggingInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RestaurantInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RestaurantRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RestaurantOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RestaurantBaseURL