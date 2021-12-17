package com.afoxplus.restaurants.repositories

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.repositories.sources.network.RestaurantNetworkDataSource
import com.afoxplus.restaurants.usecases.repositories.RestaurantRepository
import javax.inject.Inject

internal class RestaurantRepositorySource @Inject constructor(
    private val restaurantNetworkDataSource: RestaurantNetworkDataSource
) : RestaurantRepository {
    override suspend fun fetchHome(): List<Restaurant> = restaurantNetworkDataSource.fetchHome()
}