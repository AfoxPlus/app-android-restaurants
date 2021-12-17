package com.afoxplus.restaurants.entities

import android.os.Parcelable
import com.afoxplus.restaurants.entities.states.NewRegistrationState

interface Restaurant : Parcelable {
    val code: String
    val name: String
    val description: String
    val urlImageLogo: String
    val registrationState: RegistrationState
    val viewType: RestaurantViewType
    fun isNewRestaurant(): Boolean = registrationState is NewRegistrationState
    fun getViewType(): Int = viewType.code
}