package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.usecases.FetchRestaurantHomeUseCase
import com.afoxplus.restaurants.usecases.actions.FetchRestaurantHome
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RestaurantUseCaseModule {
    @Binds
    abstract fun bindsFetchRestaurantHomeUseCase(fetchRestaurantHomeUseCase: FetchRestaurantHomeUseCase): FetchRestaurantHome
}