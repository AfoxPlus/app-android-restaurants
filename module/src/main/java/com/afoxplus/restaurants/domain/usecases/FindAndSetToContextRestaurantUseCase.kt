package com.afoxplus.restaurants.domain.usecases

import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.domain.repositories.RestaurantRepository
import javax.inject.Inject

internal class FindAndSetToContextRestaurantUseCase @Inject constructor(private val repository: RestaurantRepository) {
    suspend operator fun invoke(code: String): Restaurant {
        val restaurant = repository.findByCode(code)
        repository.setToLocalScope(restaurant)
        return restaurant
    }
}