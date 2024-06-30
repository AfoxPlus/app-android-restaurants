package com.afoxplus.restaurants.services.sources.network

import com.afoxplus.restaurants.cross.mappers.toListRestaurant
import com.afoxplus.restaurants.cross.mappers.toRestaurant
import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.services.sources.network.api.RestaurantApiNetwork

import javax.inject.Inject

internal class RestaurantNetworkDataSource @Inject constructor(
    private val restaurantApi: RestaurantApiNetwork
)  {

    suspend fun fetchHome(): List<Restaurant> {
        return restaurantApi.fetchHome().toListRestaurant()
    }

    suspend fun findByCode(code: String): Restaurant {
        return restaurantApi.findByCode(code).payload.toRestaurant()
    }
}