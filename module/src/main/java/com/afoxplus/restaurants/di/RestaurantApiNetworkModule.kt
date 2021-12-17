package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.repositories.sources.network.api.RestaurantApiNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object RestaurantApiNetworkModule {

    @Provides
    fun provideNetworkService(
        @RestaurantRetrofit retrofit: Retrofit
    ): RestaurantApiNetwork = retrofit.create(RestaurantApiNetwork::class.java)
}