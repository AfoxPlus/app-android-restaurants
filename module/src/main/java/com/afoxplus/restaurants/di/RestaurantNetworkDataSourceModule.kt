package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.repositories.sources.network.RestaurantNetworkDataSource
import com.afoxplus.restaurants.repositories.sources.network.service.RestaurantNetworkService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RestaurantNetworkDataSourceModule {
    @Binds
    abstract fun bindsRestaurantNetworkDataSource(restaurantNetworkService: RestaurantNetworkService): RestaurantNetworkDataSource
}