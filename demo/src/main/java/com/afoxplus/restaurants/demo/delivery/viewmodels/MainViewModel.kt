package com.afoxplus.restaurants.demo.delivery.viewmodels

import androidx.lifecycle.ViewModel
import com.afoxplus.uikit.bus.UIKitEventBusWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val eventBusWrapper: UIKitEventBusWrapper
) : ViewModel() {


    val eventBusListener = eventBusWrapper.listen()
}
