package com.afoxplus.restaurants.usecases

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.SetToContextRestaurant
import com.afoxplus.restaurants.usecases.repositories.RestaurantRepository
import javax.inject.Inject

internal class SetToContextRestaurantUseCase @Inject constructor(private val repository: RestaurantRepository) :
    SetToContextRestaurant {

    override fun invoke(restaurant: Restaurant) {
        repository.setToLocalScope(restaurant)
    }
}