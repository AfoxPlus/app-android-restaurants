package com.afoxplus.restaurants.usecases.repositories

import androidx.annotation.RestrictTo
import com.afoxplus.restaurants.entities.Restaurant

@RestrictTo(RestrictTo.Scope.LIBRARY)
interface RestaurantRepository {

    suspend fun fetchHome(): List<Restaurant>
    suspend fun findByCode(code: String): Restaurant

    fun setToLocalScope(restaurant: Restaurant)
}