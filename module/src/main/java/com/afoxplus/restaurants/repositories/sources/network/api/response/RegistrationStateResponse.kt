package com.afoxplus.restaurants.repositories.sources.network.api.response

import com.afoxplus.restaurants.entities.RegistrationState
import com.google.gson.annotations.SerializedName

data class RegistrationStateResponse(
    @SerializedName("code") val code: String,
    @SerializedName("state") val state: String
)

fun RegistrationStateResponse.toRegistrationState(): RegistrationState {
    return RegistrationState(
        code = code,
        state = state
    )
}