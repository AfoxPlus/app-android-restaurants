package com.afoxplus.restaurants.demo.delivery.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.restaurants.delivery.views.events.OnClickRestaurantHomeEvent
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.uikit.bus.Event
import com.afoxplus.uikit.bus.EventBusListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(private val eventBusListener: EventBusListener) :
    ViewModel() {

    private val mOnClickRestaurantHome: MutableLiveData<Event<Restaurant>> by lazy { MutableLiveData<Event<Restaurant>>() }
    val onClickRestaurantHome: LiveData<Event<Restaurant>> get() = mOnClickRestaurantHome

    init {
        viewModelScope.launch(Dispatchers.Main) {
            eventBusListener.subscribe().collectLatest { event ->
                if (event is OnClickRestaurantHomeEvent) {
                    mOnClickRestaurantHome.postValue(Event(event.restaurant))
                }
            }
        }
    }
}