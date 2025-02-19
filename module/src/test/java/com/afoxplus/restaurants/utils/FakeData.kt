package com.afoxplus.restaurants.utils

import com.afoxplus.network.response.BaseResponse
import com.afoxplus.restaurants.entities.PaymentMethod
import com.afoxplus.restaurants.entities.RegistrationState
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.repositories.sources.network.api.response.PaymentMethodResponse
import com.afoxplus.restaurants.repositories.sources.network.api.response.RegistrationStateResponse
import com.afoxplus.restaurants.repositories.sources.network.api.response.RestaurantResponse

fun getBaseResponse(): BaseResponse<List<RestaurantResponse>> {
    return BaseResponse(success = true, message = "", payload = getListRestaurantResponse())
}

fun getListRestaurantResponse(): List<RestaurantResponse> {
    return arrayListOf(getRestaurantResponse())
}

fun getRestaurantResponse(): RestaurantResponse {
    return RestaurantResponse(
        code = "321",
        name = "Chilis",
        primaryType = "Restaurant",
        urlImageBanner = "",
        isOpen = false,
        rating = 46.6f,
        address = "",
        hasSubscription = false,
        phone = "",
        description = "This is restaurant",
        urlImageLogo = "https://www.tulogo.com",
        ownDelivery = false,
        registrationState = RegistrationStateResponse(code = "123", state = ""),
        itemViewType = 0,
        paymentMethods = listOf(PaymentMethodResponse("1", "Yape", true))
    )
}

fun getRestaurant(): Restaurant {
    return Restaurant(
        code = "321",
        name = "Chilis",
        primaryType = "Restaurant",
        urlImageBanner = "",
        isOpen = false,
        rating = 46.6f,
        address = "",
        hasSubscription = false,
        phone = "",
        description = "This is restaurant",
        urlImageLogo = "https://www.tulogo.com",
        ownDelivery = true,
        registrationState = RegistrationState(code = "123", state = ""),
        itemViewType = 0,
        paymentMethods = listOf(PaymentMethod("1", "Yape", true))
    )
}