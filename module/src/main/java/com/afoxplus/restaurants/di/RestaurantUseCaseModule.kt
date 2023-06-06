package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.usecases.FetchRestaurantHomeUseCase
import com.afoxplus.restaurants.usecases.GetRestaurantByCodeUseCase
import com.afoxplus.restaurants.usecases.SetRestaurantToScopeUseCase
import com.afoxplus.restaurants.usecases.actions.FetchRestaurantHome
import com.afoxplus.restaurants.usecases.actions.GetRestaurantByCode
import com.afoxplus.restaurants.usecases.actions.SetRestaurantToScope
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
    fun bindGetRestaurantByCodeUseCase(getRestaurantByCodeUseCase: GetRestaurantByCodeUseCase): GetRestaurantByCode

    @Binds
    fun bindSetRestaurantToScope(setRestaurantToScopeUseCase: SetRestaurantToScopeUseCase): SetRestaurantToScope
}