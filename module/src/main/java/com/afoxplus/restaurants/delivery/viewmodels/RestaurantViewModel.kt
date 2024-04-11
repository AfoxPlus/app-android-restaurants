package com.afoxplus.restaurants.delivery.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.restaurants.delivery.models.UIState
import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.domain.usecases.FetchRestaurantHomeUseCase
import com.afoxplus.restaurants.domain.usecases.SetToContextRestaurantUseCase
import com.afoxplus.uikit.di.UIKitCoroutineDispatcher
import com.afoxplus.uikit.exceptions.UIException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RestaurantViewModel @Inject constructor(
    private val fetchRestaurant: FetchRestaurantHomeUseCase,
    private val setToContextRestaurant: SetToContextRestaurantUseCase,
    private val coroutineDispatcher: UIKitCoroutineDispatcher
) : ViewModel() {

    private val uiStateRestaurants: MutableStateFlow<UIState<List<Restaurant>>> by lazy {
        MutableStateFlow(UIState.OnLoading())
    }
    val uiStateRestaurant: StateFlow<UIState<List<Restaurant>>> get() = uiStateRestaurants

    fun fetchRestaurantHome() {
        viewModelScope.launch(coroutineDispatcher.getIODispatcher()) {
            try {
                uiStateRestaurants.value = UIState.OnSuccess(fetchRestaurant())
            } catch (ex: Exception) {
                uiStateRestaurants.value = UIState.OnError(UIException(ex.message))
            }
        }
    }

    fun updateContextRestaurant(restaurant: Restaurant) {
        viewModelScope.launch(coroutineDispatcher.getMainDispatcher()) {
            setToContextRestaurant(restaurant)
        }
    }
}