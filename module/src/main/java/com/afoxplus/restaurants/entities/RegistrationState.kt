package com.afoxplus.restaurants.entities

import android.os.Parcelable

interface RegistrationState: Parcelable {
    val code: String
    val state: String
}