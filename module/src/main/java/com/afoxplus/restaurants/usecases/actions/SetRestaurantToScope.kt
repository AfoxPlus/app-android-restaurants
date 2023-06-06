package com.afoxplus.restaurants.usecases.actions

import com.afoxplus.restaurants.entities.Restaurant

fun interface SetRestaurantToScope {
    operator fun invoke(restaurant: Restaurant)
}