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

    private val restaurantMutable: MutableLiveData<Restaurant> by lazy { MutableLiveData<Restaurant>() }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val restaurant: LiveData<Restaurant> get() = restaurantMutable

    override suspend fun saveRestaurant(restaurant: Restaurant) {
        this.restaurantMutable.postValue(restaurant)
    }

    override fun fetchRestaurant(): LiveData<Restaurant> {
        return restaurant
    }
}