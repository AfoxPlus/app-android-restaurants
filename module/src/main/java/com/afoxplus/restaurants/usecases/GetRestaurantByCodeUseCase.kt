package com.afoxplus.restaurants.usecases

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.GetRestaurantByCode
import com.afoxplus.restaurants.usecases.repositories.RestaurantRepository
import javax.inject.Inject

class GetRestaurantByCodeUseCase @Inject constructor(private val repository: RestaurantRepository) :
    GetRestaurantByCode {
    override suspend fun invoke(code: String): Restaurant {
        return repository.findByCode(code)
    }
}