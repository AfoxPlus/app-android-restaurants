package com.afoxplus.restaurants.services.sources.network.api.response

import com.google.gson.annotations.SerializedName

internal data class InformationResponse(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)