package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.repositories.RestaurantRepositorySource
import com.afoxplus.restaurants.usecases.repositories.RestaurantRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RestaurantRepositoryModule {
    @Binds
    abstract fun bindsRestaurantRepository(restaurantRepositorySource: RestaurantRepositorySource): RestaurantRepository
}