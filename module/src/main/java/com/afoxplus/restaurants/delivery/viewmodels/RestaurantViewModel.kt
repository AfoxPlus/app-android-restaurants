package com.afoxplus.restaurants.delivery.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.restaurants.delivery.events.OnClickDeliveryEvent
import com.afoxplus.restaurants.delivery.events.OnClickRestaurantHomeEvent
import com.afoxplus.restaurants.delivery.models.RestaurantEventModel
import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.domain.usecases.FetchRestaurantHomeUseCase
import com.afoxplus.restaurants.domain.usecases.SetToContextRestaurantUseCase
import com.afoxplus.uikit.bus.UIKitEventBusWrapper
import com.afoxplus.uikit.di.UIKitCoroutineDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RestaurantViewModel @Inject constructor(
    private val fetchRestaurant: FetchRestaurantHomeUseCase,
    private val setToContextRestaurant: SetToContextRestaurantUseCase,
    private val eventBusWrapper: UIKitEventBusWrapper,
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
            setToContextRestaurant(restaurant)
            eventBusWrapper.send(
                OnClickRestaurantHomeEvent(
                    restaurant = RestaurantEventModel(
                        code = restaurant.code,
                        name = restaurant.name
                    )
                )
            )
        }
    }

    fun onClickDelivery(restaurant: Restaurant) =
        viewModelScope.launch(coroutineDispatcher.getMainDispatcher()) {
            setToContextRestaurant(restaurant)
            eventBusWrapper.send(
                OnClickDeliveryEvent(
                    restaurant = RestaurantEventModel(
                        code = restaurant.code,
                        name = restaurant.name
                    )
                )
            )
        }
}