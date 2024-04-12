package com.afoxplus.restaurants.domain.usecases

import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.domain.repositories.RestaurantRepository
import javax.inject.Inject

internal class FetchRestaurantHomeUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {

    suspend operator fun invoke(): List<Restaurant> = restaurantRepository.fetchHome()

}