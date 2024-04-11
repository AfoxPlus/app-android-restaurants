package com.afoxplus.restaurants.services.sources.network.api.response
import com.google.gson.annotations.SerializedName

internal data class RestaurantResponse(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("urlImageLogo") val urlImageLogo: String,
    @SerializedName("ownDelivery") val ownDelivery: Boolean,
    @SerializedName("registrationState") var registrationState: RegistrationStateResponse,
    @SerializedName("itemViewType") var itemViewType: Int,
    @SerializedName("paymentMethods") var paymentMethods: List<PaymentMethodResponse>
)