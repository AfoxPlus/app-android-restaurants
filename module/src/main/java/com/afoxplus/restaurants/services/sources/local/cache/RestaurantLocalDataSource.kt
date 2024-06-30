package com.afoxplus.restaurants.services.sources.local.cache

import com.afoxplus.restaurants.domain.entities.Restaurant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class RestaurantLocalDataSource @Inject constructor() {
    private var restaurant: Restaurant? = null

    fun saveRestaurant(restaurant: Restaurant) {
        this.restaurant = restaurant
    }

    fun getCurrentRestaurant(): Restaurant? = this.restaurant
}