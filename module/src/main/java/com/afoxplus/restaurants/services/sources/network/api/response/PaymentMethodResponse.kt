package com.afoxplus.restaurants.services.sources.network.api.response

import com.google.gson.annotations.SerializedName

internal data class PaymentMethodResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("paymentMethod")
    val name: String,
    @SerializedName("isDefaultSelected")
    val isSelected: Boolean
)