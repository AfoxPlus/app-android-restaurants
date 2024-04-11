package com.afoxplus.restaurants.delivery.flow

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.afoxplus.restaurants.delivery.models.RestaurantEventModel
import com.afoxplus.restaurants.domain.entities.Restaurant
import javax.inject.Inject

interface RestaurantBridge {
    suspend fun saveRestaurant(restaurant: RestaurantEventModel)
    fun fetchRestaurant(): LiveData<RestaurantEventModel>
}

internal class RestaurantBridgeAction @Inject constructor() : RestaurantBridge {

    private val restaurantMutable: MutableLiveData<RestaurantEventModel> by lazy { MutableLiveData<RestaurantEventModel>() }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val restaurant: LiveData<RestaurantEventModel> get() = restaurantMutable

    override suspend fun saveRestaurant(restaurant: RestaurantEventModel) {
        this.restaurantMutable.postValue(restaurant)
    }

    override fun fetchRestaurant(): LiveData<RestaurantEventModel> {
        return restaurant
    }
}