package com.afoxplus.restaurants.entities

import android.os.Parcelable
import com.afoxplus.restaurants.entities.states.NewRegistrationState

interface Restaurant : Parcelable {
    val code: String
    val name: String
    val description: String
    val urlImageLogo: String
    val registrationState: RegistrationState
    var viewType: RestaurantViewType
    fun isNewRestaurant(): Boolean = registrationState is NewRegistrationState
    fun getItemViewType(): Int = viewType.code
}