package com.afoxplus.restaurants.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class RegistrationState(
    val code: String,
    val state: String
) : Parcelable