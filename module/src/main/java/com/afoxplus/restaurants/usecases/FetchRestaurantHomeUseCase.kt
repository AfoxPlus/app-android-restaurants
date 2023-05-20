package com.afoxplus.restaurants.usecases

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.FetchRestaurantHome
import com.afoxplus.restaurants.usecases.repositories.RestaurantRepository
import javax.inject.Inject

internal class FetchRestaurantHomeUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) : FetchRestaurantHome {

    override suspend fun invoke(): List<Restaurant> {
        return restaurantRepository.fetchHome()
    }

}