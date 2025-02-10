package com.afoxplus.restaurants.repositories.sources.network.api.response

import com.afoxplus.network.response.BaseResponse
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.entities.Restaurant.Companion.HOME_VIEW_TYPE
import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("urlImageLogo") val urlImageLogo: String,
    @SerializedName("ownDelivery") val ownDelivery: Boolean,
    @SerializedName("primaryType") val primaryType: String,
    @SerializedName("urlImageBanner") val urlImageBanner: String? = null,
    @SerializedName("openNow") val isOpen: Boolean,
    @SerializedName("rating") val rating: Float,
    @SerializedName("address") val address: String? = null,
    @SerializedName("isVerified") val hasSubscription: Boolean,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("registrationState") var registrationState: RegistrationStateResponse,
    @SerializedName("itemViewType") var itemViewType: Int,
    @SerializedName("paymentMethods") var paymentMethods: List<PaymentMethodResponse>
)

fun BaseResponse<List<RestaurantResponse>>.toListRestaurant(): List<Restaurant> {
    return this.payload.map { it.toRestaurant() }
}

fun RestaurantResponse.toRestaurant(): Restaurant {
    return Restaurant(
        code = code,
        name = name,
        description = description,
        urlImageLogo = urlImageLogo,
        ownDelivery = ownDelivery,
        primaryType = primaryType,
        urlImageBanner = urlImageBanner.orEmpty(),
        isOpen = isOpen,
        rating = rating,
        address = address.orEmpty(),
        hasSubscription = hasSubscription,
        phone = phone.orEmpty(),
        registrationState = registrationState.toRegistrationState(),
        itemViewType = HOME_VIEW_TYPE,
        paymentMethods = paymentMethods.toPaymentMethods()
    )
}