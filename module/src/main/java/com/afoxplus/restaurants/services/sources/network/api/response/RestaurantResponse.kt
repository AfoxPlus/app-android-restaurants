package com.afoxplus.restaurants.services.sources.network.api.response

import com.google.gson.annotations.SerializedName

internal data class RestaurantResponse(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("category") val category: String? = null,
    @SerializedName("urlImageBanner") val urlImageBanner: String? = null,
    @SerializedName("description") val description: String,
    @SerializedName("urlImageLogo") val urlImageLogo: String,
    @SerializedName("ownDelivery") val ownDelivery: Boolean,
    @SerializedName("registrationState") val registrationState: RegistrationStateResponse,
    @SerializedName("itemViewType") val itemViewType: Int,
    @SerializedName("paymentMethods") val paymentMethods: List<PaymentMethodResponse>,
    @SerializedName("information") val informationResponse: List<InformationResponse>? = null
)