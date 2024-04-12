package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.services.RestaurantRepositorySource
import com.afoxplus.restaurants.domain.repositories.RestaurantRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal fun interface RestaurantRepositoryModule {
    @Binds
    fun bindsRestaurantRepository(restaurantRepositorySource: RestaurantRepositorySource): RestaurantRepository
}