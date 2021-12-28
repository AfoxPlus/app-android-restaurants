package com.afoxplus.restaurants.delivery.views.events

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.uikit.bus.EventBus

interface OnClickRestaurantHomeEvent : EventBus {
    val restaurant: Restaurant

    companion object {
        fun build(restaurant: Restaurant): OnClickRestaurantHomeEvent =
            object : OnClickRestaurantHomeEvent {
                override val restaurant: Restaurant
                    get() = restaurant
            }
    }
}