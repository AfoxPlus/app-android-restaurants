package com.afoxplus.restaurants.usecases

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.SetRestaurantToScope
import com.afoxplus.restaurants.usecases.repositories.RestaurantRepository
import javax.inject.Inject

internal class SetRestaurantToScopeUseCase @Inject constructor(private val repository: RestaurantRepository) :
    SetRestaurantToScope {

    override fun invoke(restaurant: Restaurant) {
        repository.setToLocalScope(restaurant)
    }
}