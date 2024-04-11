package com.afoxplus.restaurants.domain.repositories

import androidx.annotation.RestrictTo
import com.afoxplus.restaurants.domain.entities.Restaurant

@RestrictTo(RestrictTo.Scope.LIBRARY)
internal interface RestaurantRepository {
    suspend fun fetchHome(): List<Restaurant>
    suspend fun findByCode(code: String): Restaurant
    fun setToLocalScope(restaurant: Restaurant)
}