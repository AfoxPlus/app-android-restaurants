package com.afoxplus.restaurants.repositories.sources.network.api.response

import com.afoxplus.restaurants.entities.RegistrationState
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class RegistrationStateResponse(
    @SerializedName("code") override val code: String,
    @SerializedName("state") override val state: String
) : RegistrationState