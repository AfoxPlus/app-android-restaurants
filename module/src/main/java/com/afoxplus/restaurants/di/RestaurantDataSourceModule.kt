package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.repositories.sources.local.RestaurantLocalDataSource
import com.afoxplus.restaurants.repositories.sources.local.cache.RestaurantCacheDataSource
import com.afoxplus.restaurants.repositories.sources.network.RestaurantNetworkDataSource
import com.afoxplus.restaurants.repositories.sources.network.service.RestaurantNetworkService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RestaurantDataSourceModule {
    @Binds
    fun bindsRestaurantNetworkDataSource(restaurantNetworkService: RestaurantNetworkService): RestaurantNetworkDataSource
    @Binds
    fun bindRestaurantLocalDataSource(restaurantCacheDataSource: RestaurantCacheDataSource): RestaurantLocalDataSource
}