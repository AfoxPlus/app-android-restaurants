package com.afoxplus.restaurants.demo.delivery.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.restaurants.delivery.flow.RestaurantBridge
import com.afoxplus.restaurants.delivery.views.events.OnClickDeliveryEvent
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.FindAndSetToContextRestaurant
import com.afoxplus.uikit.bus.UIKitEventBus
import com.afoxplus.uikit.bus.UIKitEventBusWrapper
import com.afoxplus.uikit.di.UIKitCoroutineDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val restaurantBridge: RestaurantBridge,
    private val findAndSetToContextRestaurant: FindAndSetToContextRestaurant,
    private val coroutines: UIKitCoroutineDispatcher,
    private val eventBusWrapper: UIKitEventBusWrapper
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

    val onClickDeliveryEvent: SharedFlow<OnClickDeliveryEvent> by lazy {
        eventBusWrapper.getBusEventFlow()
            .flowOn(coroutines.getMainDispatcher())
            .filter { event -> event is OnClickDeliveryEvent }
            .map { event -> event as OnClickDeliveryEvent }
            .shareIn(scope = viewModelScope, started = SharingStarted.Eagerly)
    }

    private fun testFindRestaurant(code: String) =
        viewModelScope.launch(coroutines.getIODispatcher()) {
            val restaurant = findAndSetToContextRestaurant(code)
            Log.d(
                "RESTAURANT",
                "RESTAURANT: ${restaurant.code} - ${restaurant.description}"
            )
        }
}
