package com.afoxplus.restaurants.delivery.views.events

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.uikit.bus.UIKitEventBus

interface OnClickDeliveryEvent : UIKitEventBus {
    val restaurant: Restaurant

    companion object {
        fun build(restaurant: Restaurant): OnClickDeliveryEvent =
            object : OnClickDeliveryEvent {
                override val restaurant: Restaurant
                    get() = restaurant
            }
    }
}