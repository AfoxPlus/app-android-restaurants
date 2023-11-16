package com.afoxplus.restaurants.demo.di

import com.afoxplus.demo_config.delivery.flow.StartDemoFlow
import com.afoxplus.restaurants.demo.global.RestaurantStartDemoFlow
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DemoModule {

    @Binds
    fun bindStartDemoFlow(demo: RestaurantStartDemoFlow): StartDemoFlow
}