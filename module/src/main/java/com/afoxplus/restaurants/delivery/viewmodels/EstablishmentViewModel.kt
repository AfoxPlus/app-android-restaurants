package com.afoxplus.restaurants.delivery.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.restaurants.delivery.views.events.OnClickRestaurantHomeEvent
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.FetchRestaurantHome
import com.afoxplus.restaurants.usecases.actions.SetToContextRestaurant
import com.afoxplus.uikit.bus.UIKitEventBusWrapper
import com.afoxplus.uikit.common.UIState
import com.afoxplus.uikit.di.UIKitCoroutineDispatcher
import com.afoxplus.uikit.exceptions.UIException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class EstablishmentViewModel @Inject constructor(
    private val fetchRestaurant: FetchRestaurantHome,
    private val setToContextRestaurant: SetToContextRestaurant,
    private val eventBusWrapper: UIKitEventBusWrapper,
    private val coroutineDispatcher: UIKitCoroutineDispatcher
) : ViewModel() {

    private val mEstablishmentState: MutableStateFlow<UIState<List<Restaurant>>> by lazy {
        MutableStateFlow(UIState.OnLoading())
    }
    val establishmentState = mEstablishmentState.asStateFlow()

    init {
        fetchRestaurantHome()
    }

    private fun fetchRestaurantHome() {
        viewModelScope.launch(coroutineDispatcher.getIODispatcher()) {
            try {
                val result = fetchRestaurant()
                mEstablishmentState.value = UIState.OnSuccess(result)
            } catch (ex: Exception) {
                mEstablishmentState.value = UIState.OnError(UIException(message = ex.message))
            }
        }
    }

    fun onClickCardRestaurant(restaurant: Restaurant) {
        viewModelScope.launch(coroutineDispatcher.getMainDispatcher()) {
            setToContextRestaurant(restaurant)
            eventBusWrapper.send(OnClickRestaurantHomeEvent(restaurant = restaurant))
        }
    }
}