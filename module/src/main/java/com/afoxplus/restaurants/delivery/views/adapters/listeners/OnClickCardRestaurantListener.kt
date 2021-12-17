package com.afoxplus.restaurants.delivery.views.adapters.listeners

import com.afoxplus.restaurants.entities.Restaurant

internal fun interface OnClickCardRestaurantListener {
    operator fun invoke(restaurant: Restaurant)
}
