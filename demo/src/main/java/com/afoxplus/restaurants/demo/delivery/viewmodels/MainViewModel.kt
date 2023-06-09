package com.afoxplus.restaurants.demo.delivery.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.restaurants.delivery.views.events.OnClickDeliveryEvent
import com.afoxplus.restaurants.delivery.views.events.OnClickRestaurantHomeEvent
import com.afoxplus.uikit.bus.UIKitEventBus
import com.afoxplus.uikit.bus.UIKitEventBusWrapper
import com.afoxplus.uikit.di.UIKitCoroutineDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val coroutines: UIKitCoroutineDispatcher,
    private val eventBusWrapper: UIKitEventBusWrapper
) : ViewModel() {


    val onEvents: SharedFlow<UIKitEventBus> by lazy {
        eventBusWrapper.getBusEventFlow()
            .flowOn(coroutines.getMainDispatcher())
            .filter { event -> event is OnClickDeliveryEvent || event is OnClickRestaurantHomeEvent }
            .shareIn(scope = viewModelScope, started = SharingStarted.Eagerly)
    }
}
