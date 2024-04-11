package com.afoxplus.restaurants.delivery.events

import com.afoxplus.restaurants.delivery.models.RestaurantEventModel
import com.afoxplus.uikit.bus.UIKitEventBus

data class OnClickDeliveryEvent(val restaurant: RestaurantEventModel) : UIKitEventBus
data class OnClickRestaurantHomeEvent(val restaurant: RestaurantEventModel) : UIKitEventBus