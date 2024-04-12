package com.afoxplus.restaurants.delivery.models

import com.afoxplus.uikit.exceptions.UIException


internal sealed interface UIState<T> {
    class OnLoading<T> : UIState<T>
    data class OnSuccess<T>(val data: T) : UIState<T>
    data class OnError<T>(val uiException: UIException) : UIState<T>
}