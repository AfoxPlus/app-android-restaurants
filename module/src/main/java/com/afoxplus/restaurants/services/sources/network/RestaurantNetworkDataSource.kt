package com.afoxplus.restaurants.services.sources.network

import com.afoxplus.restaurants.domain.entities.Restaurant

internal interface RestaurantNetworkDataSource {

    suspend fun fetchHome(): List<Restaurant>
    suspend fun findByCode(code: String): Restaurant

}