package com.afoxplus.restaurants.repositories.sources.local

import com.afoxplus.restaurants.entities.Restaurant

internal interface RestaurantLocalDataSource {
    fun saveRestaurant(restaurant: Restaurant)
    fun getCurrentRestaurant(): Restaurant?
}