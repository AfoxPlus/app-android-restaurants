package com.afoxplus.restaurants.entities

import android.os.Parcelable
import com.afoxplus.restaurants.entities.viewtypes.RestaurantHomeViewType

interface RestaurantViewType : Parcelable {
    val code: Int

    companion object {
        const val HOME_VIEW_TYPE: Int = 0
        fun getHomeViewType(): RestaurantViewType = RestaurantHomeViewType(HOME_VIEW_TYPE)
    }
}