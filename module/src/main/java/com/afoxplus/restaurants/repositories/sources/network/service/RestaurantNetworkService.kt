package com.afoxplus.restaurants.repositories.sources.network.service

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.repositories.sources.network.RestaurantNetworkDataSource
import com.afoxplus.restaurants.repositories.sources.network.api.RestaurantApiNetwork
import com.afoxplus.restaurants.repositories.sources.network.api.response.toListRestaurant
import com.afoxplus.restaurants.repositories.sources.network.api.response.toRestaurant

import javax.inject.Inject

internal class RestaurantNetworkService @Inject constructor(
    private val restaurantApi: RestaurantApiNetwork
) : RestaurantNetworkDataSource {

    override suspend fun fetchHome(): List<Restaurant> {
        return restaurantApi.fetchHome().toListRestaurant()
    }

    override suspend fun findByCode(code: String): Restaurant {
        return restaurantApi.findByCode(code).payload.toRestaurant()
    }
}