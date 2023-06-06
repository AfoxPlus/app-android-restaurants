package com.afoxplus.restaurants.repositories.sources.network

import com.afoxplus.restaurants.entities.Restaurant

internal interface RestaurantNetworkDataSource {

    suspend fun fetchHome(): List<Restaurant>
    suspend fun findByCode(code: String): Restaurant

}