package com.afoxplus.restaurants.delivery.flow

import com.afoxplus.restaurants.delivery.views.fragments.RestaurantHomeFragment
import com.afoxplus.uikit.fragments.UIKitBaseFragment
import javax.inject.Inject

interface RestaurantFlow {
    fun getRestaurantHomeFragment(): UIKitBaseFragment
}

class RestaurantFlowAction @Inject constructor() : RestaurantFlow {
    override fun getRestaurantHomeFragment(): UIKitBaseFragment {
        return RestaurantHomeFragment()
    }
}