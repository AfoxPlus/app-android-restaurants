package com.afoxplus.restaurants.delivery.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.restaurants.delivery.flow.RestaurantBridge
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.FetchRestaurantHome
import com.afoxplus.restaurants.usecases.actions.SetRestaurantToScope
import com.afoxplus.uikit.di.UIKitCoroutineDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RestaurantViewModel @Inject constructor(
    private val fetchRestaurant: FetchRestaurantHome,
    private val restaurantBridge: RestaurantBridge,
    private val setRestaurantToScope: SetRestaurantToScope,
    private val coroutineDispatcher: UIKitCoroutineDispatcher
) : ViewModel() {

    private val mRestaurantsHome: MutableLiveData<List<Restaurant>> by lazy { MutableLiveData<List<Restaurant>>() }
    val restaurantsHome: LiveData<List<Restaurant>> get() = mRestaurantsHome

    fun fetchRestaurantHome() {
        viewModelScope.launch(coroutineDispatcher.getIODispatcher()) {
            try {
                val result = fetchRestaurant()
                mRestaurantsHome.postValue(result)
            } catch (ex: Exception) {
                mRestaurantsHome.postValue(emptyList())
            }
        }
    }

    fun onClickCardRestaurant(restaurant: Restaurant) {
        viewModelScope.launch(coroutineDispatcher.getMainDispatcher()) {
            setRestaurantToScope(restaurant)
            restaurantBridge.saveRestaurant(restaurant)
        }
    }
}