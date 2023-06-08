package com.afoxplus.restaurants.demo.delivery.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.restaurants.delivery.flow.RestaurantBridge
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.FindAndSetToContextRestaurant
import com.afoxplus.uikit.di.UIKitCoroutineDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val restaurantBridge: RestaurantBridge,
    private val findAndSetToContextRestaurant: FindAndSetToContextRestaurant,
    private val coroutines: UIKitCoroutineDispatcher
) : ViewModel() {

    private val mOnClickRestaurantHome: MutableLiveData<Restaurant> by lazy { MutableLiveData<Restaurant>() }
    val onClickRestaurantHome: LiveData<Restaurant> get() = mOnClickRestaurantHome

    init {
        viewModelScope.launch(coroutines.getMainDispatcher()) {
            restaurantBridge.fetchRestaurant().observeForever {
                testFindRestaurant(it.code)
                mOnClickRestaurantHome.postValue(it)
            }
        }
    }

    private fun testFindRestaurant(code: String) =
        viewModelScope.launch(coroutines.getIODispatcher()) {
            viewModelScope.launch(coroutines.getIODispatcher()) {
                val restaurant = findAndSetToContextRestaurant(code)
                Log.d(
                    "RESTAURANT",
                    "RESTAURANT: ${restaurant.code} - ${restaurant.description}"
                )
            }
        }
}
