package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.entities.RestaurantViewType
import com.afoxplus.restaurants.repositories.sources.network.RestaurantNetworkDataSource
import com.afoxplus.restaurants.repositories.sources.network.api.RestaurantApiNetwork
import com.afoxplus.restaurants.repositories.sources.network.service.RestaurantNetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object RestaurantNetworkDataSourceModule {

    @Provides
    fun provideRestaurantNetworkDataSource(
        restaurantApi: RestaurantApiNetwork,
        @RestaurantHomeViewType homeViewType: RestaurantViewType
    ): RestaurantNetworkDataSource =
        RestaurantNetworkService(restaurantApi, homeViewType)
}