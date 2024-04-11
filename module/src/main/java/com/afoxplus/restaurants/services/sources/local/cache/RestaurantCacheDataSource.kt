package com.afoxplus.restaurants.services.sources.local.cache

import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.services.sources.local.RestaurantLocalDataSource
import javax.inject.Inject

internal class RestaurantCacheDataSource @Inject constructor() : RestaurantLocalDataSource {
    private var restaurant: Restaurant? = null

    override fun saveRestaurant(restaurant: Restaurant) {
        this.restaurant = restaurant
    }

    override fun getCurrentRestaurant(): Restaurant? = this.restaurant
}