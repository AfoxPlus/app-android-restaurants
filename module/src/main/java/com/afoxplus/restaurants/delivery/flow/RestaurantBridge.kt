package com.afoxplus.restaurants.delivery.flow

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.afoxplus.restaurants.entities.Restaurant
import javax.inject.Inject

interface RestaurantBridge {
    suspend fun saveRestaurant(restaurant: Restaurant)
    fun fetchRestaurant(): LiveData<Restaurant>
}

class RestaurantBridgeAction @Inject constructor() : RestaurantBridge {

    private val restaurantMLD: MutableLiveData<Restaurant> by lazy { MutableLiveData<Restaurant>() }
    @VisibleForTesting
    val restaurantLD: LiveData<Restaurant> get() = restaurantMLD

    override suspend fun saveRestaurant(restaurant: Restaurant) {
        this.restaurantMLD.postValue(restaurant)
    }

    override fun fetchRestaurant(): LiveData<Restaurant> {
        return restaurantLD
    }
}