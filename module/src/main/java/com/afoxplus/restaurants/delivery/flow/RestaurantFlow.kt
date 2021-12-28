package com.afoxplus.restaurants.delivery.flow

import com.afoxplus.restaurants.delivery.views.fragments.RestaurantHomeFragment
import com.afoxplus.uikit.fragments.BaseFragment

interface RestaurantFlow {
    fun getRestaurantHomeFragment(): BaseFragment

    companion object {
        fun build(): RestaurantFlow = object : RestaurantFlow {
            override fun getRestaurantHomeFragment(): BaseFragment = RestaurantHomeFragment()
        }
    }
}