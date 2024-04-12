package com.afoxplus.restaurants.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class PaymentMethod(
    val id: String,
    val paymentName: String,
    val isSelected: Boolean
) : Parcelable