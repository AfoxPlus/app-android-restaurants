package com.afoxplus.restaurants.entities

import android.os.Parcelable
import com.afoxplus.restaurants.entities.states.NewRegistrationState
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    val code: String,
    val name: String,
    val description: String,
    val urlImageLogo: String,
    val registrationState: RegistrationState
) : Parcelable {
    fun isNewRestaurant(): Boolean = registrationState is NewRegistrationState
}