package com.afoxplus.restaurants.delivery.flow

import androidx.compose.runtime.Composable
import com.afoxplus.restaurants.delivery.views.screens.RestaurantHomeScreen
import javax.inject.Inject

interface RestaurantFlow {
    @Composable
    fun RestaurantsComponent()
}

class RestaurantFlowAction @Inject constructor() : RestaurantFlow {

    @Composable
    override fun RestaurantsComponent() = RestaurantHomeScreen()

}