package com.afoxplus.restaurants.delivery.events

import com.afoxplus.restaurants.delivery.models.RestaurantEventModel

fun interface OnClickRestaurantHome {
    operator fun invoke(restaurant: RestaurantEventModel)
}