package com.afoxplus.restaurants.usecases.actions

import com.afoxplus.restaurants.entities.Restaurant

fun interface SetToContextRestaurant {
    operator fun invoke(restaurant: Restaurant)
}