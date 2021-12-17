package com.afoxplus.restaurants.delivery.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.restaurants.delivery.views.events.OnClickRestaurantHomeEvent
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.FetchRestaurantHome
import com.afoxplus.uikit.bus.EventBusListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RestaurantViewModel @Inject constructor(
    private val fetchHome: FetchRestaurantHome,
    private val eventBus: EventBusListener
) : ViewModel() {
    private val mRestaurantsHome: MutableLiveData<List<Restaurant>> by lazy { MutableLiveData<List<Restaurant>>() }
    val restaurantsHome: LiveData<List<Restaurant>> get() = mRestaurantsHome

    fun fetchRestaurantHome() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val result = fetchHome()
            mRestaurantsHome.postValue(result)
        } catch (ex: Exception) {
            Log.d("RESTAURANT", "$ex")
        }
    }

    fun onClickCardRestaurant(restaurant: Restaurant) = viewModelScope.launch(Dispatchers.Main) {
        eventBus.send(OnClickRestaurantHomeEvent.build(restaurant))
    }
}