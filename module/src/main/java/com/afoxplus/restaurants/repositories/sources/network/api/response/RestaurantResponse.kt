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
    @SerializedName("registrationState") var registrationState: RegistrationStateResponse,
    @SerializedName("itemViewType") var itemViewType: Int
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
        registrationState = registrationState.toRegistrationState(),
        itemViewType = HOME_VIEW_TYPE
    )
}