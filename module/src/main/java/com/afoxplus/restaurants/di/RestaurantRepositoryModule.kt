package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.repositories.RestaurantRepositorySource
import com.afoxplus.restaurants.repositories.sources.network.RestaurantNetworkDataSource
import com.afoxplus.restaurants.usecases.repositories.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object RestaurantRepositoryModule {

    @Provides
    fun provideRestaurantRepository(restaurantNetworkDataSource: RestaurantNetworkDataSource): RestaurantRepository =
        RestaurantRepositorySource(restaurantNetworkDataSource)
}