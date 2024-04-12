package com.afoxplus.restaurants.domain.usecases

import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.domain.repositories.RestaurantRepository
import javax.inject.Inject

internal class SetToContextRestaurantUseCase @Inject constructor(private val repository: RestaurantRepository) {
    operator fun invoke(restaurant: Restaurant) = repository.setToLocalScope(restaurant)
}