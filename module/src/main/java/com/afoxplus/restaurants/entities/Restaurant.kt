package com.afoxplus.restaurants.entities

import android.os.Parcelable
import com.afoxplus.restaurants.entities.states.NewRegistrationState

interface Restaurant : Parcelable {
    val code: String
    val name: String
    val description: String
    val urlImageLogo: String
    val registrationState: RegistrationState
    var itemViewType: Int
    fun isNewRestaurant(): Boolean = registrationState is NewRegistrationState

    companion object {
        const val HOME_VIEW_TYPE: Int = 0
    }
}