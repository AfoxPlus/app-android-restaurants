package com.afoxplus.restaurants.delivery.flow

import com.afoxplus.restaurants.delivery.views.fragments.RestaurantHomeFragment
import com.afoxplus.uikit.fragments.BaseFragment
import javax.inject.Inject

interface RestaurantFlow {
    fun getRestaurantHomeFragment(): BaseFragment
}

class RestaurantFlowAction @Inject constructor() : RestaurantFlow {
    override fun getRestaurantHomeFragment(): BaseFragment {
        return RestaurantHomeFragment()
    }
}