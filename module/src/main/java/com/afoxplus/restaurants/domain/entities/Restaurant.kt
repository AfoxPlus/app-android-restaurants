package com.afoxplus.restaurants.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Restaurant(
    val code: String,
    val name: String,
    val category: String,
    val summary: String,
    val urlImageLogo: String,
    val urlImageBanner: String,
    val ownDelivery: Boolean,
    val registrationState: RegistrationState,
    val paymentMethods: List<PaymentMethod>,
    val information: List<Information>?
) : Parcelable {

    companion object {
        const val NEW_STATE: String = "NEW"
    }

    fun isNewRestaurant(): Boolean = registrationState.code == NEW_STATE

    @Parcelize
    data class Information(val code: String, val name: String) : Parcelable
}
