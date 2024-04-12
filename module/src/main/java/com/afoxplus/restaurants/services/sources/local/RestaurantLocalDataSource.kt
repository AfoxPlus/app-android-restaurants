package com.afoxplus.restaurants.services.sources.local

import com.afoxplus.restaurants.domain.entities.Restaurant

internal interface RestaurantLocalDataSource {
    fun saveRestaurant(restaurant: Restaurant)
    fun getCurrentRestaurant(): Restaurant?
}