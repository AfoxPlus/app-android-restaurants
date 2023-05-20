package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.delivery.flow.RestaurantFlow
import com.afoxplus.restaurants.delivery.flow.RestaurantFlowAction
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RestaurantFlowModule {
    @Binds
    abstract fun bindsRestaurantFlow(restaurantFlowAction: RestaurantFlowAction): RestaurantFlow
}