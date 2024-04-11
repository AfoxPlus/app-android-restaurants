package com.afoxplus.restaurants.delivery.flow

import androidx.compose.runtime.Composable
import com.afoxplus.restaurants.delivery.events.OnClickRestaurantHome
import com.afoxplus.restaurants.delivery.views.screens.RestaurantHomeScreen
import javax.inject.Inject

interface RestaurantFlow {
    @Composable
    fun RestaurantsComponent(onClickRestaurantHome: OnClickRestaurantHome)
}

class RestaurantFlowAction @Inject constructor() : RestaurantFlow {

    @Composable
    override fun RestaurantsComponent(onClickRestaurantHome: OnClickRestaurantHome) =
        RestaurantHomeScreen(onClickRestaurantHome = onClickRestaurantHome)

}