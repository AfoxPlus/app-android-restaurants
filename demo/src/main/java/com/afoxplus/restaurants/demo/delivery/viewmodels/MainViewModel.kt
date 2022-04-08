package com.afoxplus.restaurants.demo.delivery.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.restaurants.delivery.flow.RestaurantBridge
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.uikit.di.UIKitMainDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val restaurantBridge: RestaurantBridge,
    @UIKitMainDispatcher private val dispatcherMain: CoroutineDispatcher
) : ViewModel() {

    private val mOnClickRestaurantHome: MutableLiveData<Restaurant> by lazy { MutableLiveData<Restaurant>() }
    val onClickRestaurantHome: LiveData<Restaurant> get() = mOnClickRestaurantHome

    init {
        viewModelScope.launch(dispatcherMain) {
            restaurantBridge.fetchRestaurant().observeForever {
                mOnClickRestaurantHome.postValue(it)
            }
        }
    }
}
