package com.afoxplus.restaurants.services.sources.network.api.response

import com.google.gson.annotations.SerializedName

internal data class RegistrationStateResponse(
    @SerializedName("code") val code: String,
    @SerializedName("state") val state: String
)