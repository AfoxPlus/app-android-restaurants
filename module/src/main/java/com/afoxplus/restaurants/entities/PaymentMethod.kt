package com.afoxplus.restaurants.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PaymentMethod(
    val id: String,
    val paymentName: String,
    val isSelected: Boolean
) : Parcelable