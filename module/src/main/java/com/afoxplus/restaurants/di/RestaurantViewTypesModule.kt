package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.entities.RestaurantViewType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RestaurantViewTypesModule {

    @Provides
    @Singleton
    @RestaurantHomeViewType
    fun provideRestaurantHomeViewType(): RestaurantViewType = RestaurantViewType.getHomeViewType()
}