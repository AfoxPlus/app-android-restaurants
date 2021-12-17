package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.delivery.flow.RestaurantFlow
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object RestaurantFlowModule {
    @Provides
    fun bindProductFlow(): RestaurantFlow = RestaurantFlow.build()
}