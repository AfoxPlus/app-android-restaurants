package com.afoxplus.restaurants.usecases.actions

import com.afoxplus.restaurants.entities.Restaurant

fun interface FindAndSetToContextRestaurant {
    suspend operator fun invoke(code: String): Restaurant
}