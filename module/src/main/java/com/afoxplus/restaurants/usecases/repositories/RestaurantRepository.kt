package com.afoxplus.restaurants.usecases.repositories

import com.afoxplus.restaurants.entities.Restaurant

internal interface RestaurantRepository {

    suspend fun fetchHome(): List<Restaurant>

}