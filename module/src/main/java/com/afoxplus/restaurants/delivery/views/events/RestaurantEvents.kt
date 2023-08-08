package com.afoxplus.restaurants.delivery.views.events

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.uikit.bus.UIKitEventBus

data class OnClickDeliveryEvent(val restaurant: Restaurant) : UIKitEventBus
data class OnClickRestaurantHomeEvent(val restaurant: Restaurant) : UIKitEventBus