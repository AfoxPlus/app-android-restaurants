package com.afoxplus.restaurants.usecases.actions

import com.afoxplus.restaurants.entities.Restaurant

interface FetchRestaurantHome {
    suspend operator fun invoke(): List<Restaurant>
}