package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.usecases.FetchRestaurantHomeUseCase
import com.afoxplus.restaurants.usecases.FindAndSetToContextRestaurantUseCase
import com.afoxplus.restaurants.usecases.SetToContextRestaurantUseCase
import com.afoxplus.restaurants.usecases.actions.FetchRestaurantHome
import com.afoxplus.restaurants.usecases.actions.FindAndSetToContextRestaurant
import com.afoxplus.restaurants.usecases.actions.SetToContextRestaurant
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RestaurantUseCaseModule {
    @Binds
    fun bindsFetchRestaurantHomeUseCase(fetchRestaurantHomeUseCase: FetchRestaurantHomeUseCase): FetchRestaurantHome

    @Binds
    fun bindGetRestaurantByCodeUseCase(findAndSetToScopeRestaurantUseCase: FindAndSetToContextRestaurantUseCase): FindAndSetToContextRestaurant

    @Binds
    fun bindSetRestaurantToScope(setRestaurantToScopeUseCase: SetToContextRestaurantUseCase): SetToContextRestaurant
}