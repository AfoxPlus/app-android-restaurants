package com.afoxplus.restaurants.repositories.sources.network.service


import com.afoxplus.network.extensions.map
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.entities.Restaurant.Companion.HOME_VIEW_TYPE
import com.afoxplus.restaurants.repositories.sources.network.RestaurantNetworkDataSource
import com.afoxplus.restaurants.repositories.sources.network.api.RestaurantApiNetwork
import javax.inject.Inject

internal class RestaurantNetworkService @Inject constructor(
    private val restaurantApi: RestaurantApiNetwork
) :
    RestaurantNetworkDataSource {
    override suspend fun fetchHome(): List<Restaurant> {
        restaurantApi.fetchHome().map {
            return it.payload.map { item -> item.apply { itemViewType = HOME_VIEW_TYPE } }
        }
        return emptyList()
    }
}