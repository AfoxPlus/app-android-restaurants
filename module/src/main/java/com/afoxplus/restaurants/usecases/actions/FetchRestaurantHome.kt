package com.afoxplus.restaurants.usecases.actions

import com.afoxplus.restaurants.entities.Restaurant

fun interface FetchRestaurantHome {
    suspend operator fun invoke(): List<Restaurant>
}