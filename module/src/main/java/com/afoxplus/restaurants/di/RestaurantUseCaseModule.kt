package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.usecases.FetchRestaurantHomeUseCase
import com.afoxplus.restaurants.usecases.actions.FetchRestaurantHome
import com.afoxplus.restaurants.usecases.repositories.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object RestaurantUseCaseModule {

    @Provides
    fun provideFetchRestaurantHomeUseCase(restaurantRepository: RestaurantRepository): FetchRestaurantHome =
        FetchRestaurantHomeUseCase(restaurantRepository)
}