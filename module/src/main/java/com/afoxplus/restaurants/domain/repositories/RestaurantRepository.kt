package com.afoxplus.restaurants.domain.repositories

import com.afoxplus.restaurants.domain.entities.Restaurant

internal interface RestaurantRepository {
    suspend fun fetchHome(): List<Restaurant>
    suspend fun findByCode(code: String): Restaurant
    fun setToLocalScope(restaurant: Restaurant)
}