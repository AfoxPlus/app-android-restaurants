package com.afoxplus.restaurants.demo.global

import com.afoxplus.network.global.AppProperties
import com.afoxplus.restaurants.demo.BuildConfig
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class AppPropertiesDemo @Inject constructor() : AppProperties {
    override fun getDeviceData(): String {
        return "restaurant_demo"
    }

    override fun isAppDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}