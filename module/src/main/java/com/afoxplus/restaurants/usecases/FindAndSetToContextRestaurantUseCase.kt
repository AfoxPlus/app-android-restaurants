package com.afoxplus.restaurants.usecases

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.FindAndSetToContextRestaurant
import com.afoxplus.restaurants.usecases.repositories.RestaurantRepository
import javax.inject.Inject

class FindAndSetToContextRestaurantUseCase @Inject constructor(private val repository: RestaurantRepository) :
    FindAndSetToContextRestaurant {
    override suspend fun invoke(code: String): Restaurant {
        val restaurant = repository.findByCode(code)
        repository.setToLocalScope(restaurant)
        return restaurant
    }
}