package com.afoxplus.restaurants.di

import com.afoxplus.restaurants.delivery.flow.RestaurantBridge
import com.afoxplus.restaurants.delivery.flow.RestaurantBridgeAction
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RestaurantBridgeModule {

    @Singleton
    @Binds
    abstract fun bindsRestaurantBridgeAction(restaurantBridgeAction: RestaurantBridgeAction): RestaurantBridge

}