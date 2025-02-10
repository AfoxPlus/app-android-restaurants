package com.afoxplus.restaurants.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    val code: String,
    val name: String,
    val primaryType: String,
    val description: String,
    val urlImageLogo: String,
    val urlImageBanner: String,
    val ownDelivery: Boolean,
    val isOpen: Boolean,
    val rating: Float,
    val address: String,
    val hasSubscription: Boolean,
    val phone: String,
    val registrationState: RegistrationState,
    var itemViewType: Int,
    val paymentMethods: List<PaymentMethod>
) : Parcelable {

    companion object {
        const val HOME_VIEW_TYPE: Int = 0
        const val NEW_STATE: String = "NEW"
    }

    fun isNewRestaurant(): Boolean = registrationState.code == NEW_STATE
}
