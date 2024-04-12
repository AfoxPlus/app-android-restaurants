package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.services.sources.local.RestaurantLocalDataSource
import com.afoxplus.restaurants.services.sources.local.cache.RestaurantCacheDataSource
import com.afoxplus.restaurants.services.sources.network.RestaurantNetworkDataSource
import com.afoxplus.restaurants.services.sources.network.service.RestaurantNetworkService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RestaurantDataSourceModule {
    @Binds
    fun bindsRestaurantNetworkDataSource(restaurantNetworkService: RestaurantNetworkService): RestaurantNetworkDataSource

    @Binds
    @Singleton
    fun bindRestaurantLocalDataSource(restaurantCacheDataSource: RestaurantCacheDataSource): RestaurantLocalDataSource
}