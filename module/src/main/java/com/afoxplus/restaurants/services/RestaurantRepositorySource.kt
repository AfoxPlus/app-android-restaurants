package com.afoxplus.restaurants.services

import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.services.sources.local.RestaurantLocalDataSource
import com.afoxplus.restaurants.services.sources.network.RestaurantNetworkDataSource
import com.afoxplus.restaurants.domain.repositories.RestaurantRepository
import javax.inject.Inject

internal class RestaurantRepositorySource @Inject constructor(
    private val restaurantNetworkDataSource: RestaurantNetworkDataSource,
    private val restaurantLocalDataSource: RestaurantLocalDataSource
) : RestaurantRepository {

    override suspend fun fetchHome(): List<Restaurant> {
        return restaurantNetworkDataSource.fetchHome()
    }

    override suspend fun findByCode(code: String): Restaurant {
        var currentRestaurant = restaurantLocalDataSource.getCurrentRestaurant()
        if (currentRestaurant == null) {
            currentRestaurant = restaurantNetworkDataSource.findByCode(code)
            setToLocalScope(currentRestaurant)
        } else if (currentRestaurant.code != code) {
            currentRestaurant = restaurantNetworkDataSource.findByCode(code)
        }
        return currentRestaurant
    }

    override fun setToLocalScope(restaurant: Restaurant) {
        restaurantLocalDataSource.saveRestaurant(restaurant)
    }
}