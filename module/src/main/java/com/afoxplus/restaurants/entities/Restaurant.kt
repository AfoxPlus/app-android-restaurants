package com.afoxplus.restaurants.entities

import android.os.Parcelable

interface Restaurant : Parcelable {
    val code: String
    val name: String
    val description: String
    val urlImageLogo: String
    val registrationState: RegistrationState
    var itemViewType: Int
    fun isNewRestaurant(): Boolean = registrationState.code == NEW_STATE

    companion object {
        const val HOME_VIEW_TYPE: Int = 0
        const val NEW_STATE: String = "NEW"
    }
}