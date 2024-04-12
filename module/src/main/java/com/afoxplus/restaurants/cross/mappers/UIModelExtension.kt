package com.afoxplus.restaurants.cross.mappers

import com.afoxplus.restaurants.delivery.models.RestaurantEventModel
import com.afoxplus.restaurants.domain.entities.Restaurant

internal fun Restaurant.toEventModel(): RestaurantEventModel =
    RestaurantEventModel(code = this.code, name = this.name)