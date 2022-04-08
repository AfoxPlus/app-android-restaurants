package com.afoxplus.restaurants.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegistrationState(
    val code: String,
    val state: String
) : Parcelable