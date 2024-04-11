package com.afoxplus.restaurants.utils

import com.afoxplus.network.response.BaseResponse
import com.afoxplus.restaurants.domain.entities.PaymentMethod
import com.afoxplus.restaurants.domain.entities.RegistrationState
import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.services.sources.network.api.response.PaymentMethodResponse
import com.afoxplus.restaurants.services.sources.network.api.response.RegistrationStateResponse
import com.afoxplus.restaurants.services.sources.network.api.response.RestaurantResponse

internal fun getBaseResponse(): BaseResponse<List<RestaurantResponse>> {
    return BaseResponse(success = true, message = "", payload = getListRestaurantResponse())
}

internal fun getListRestaurantResponse(): List<RestaurantResponse> {
    return arrayListOf(getRestaurantResponse())
}

internal fun getRestaurantResponse(): RestaurantResponse {
    return RestaurantResponse(
        code = "321",
        name = "Chilis",
        description = "This is restaurant",
        urlImageLogo = "https://www.tulogo.com",
        ownDelivery = false,
        registrationState = RegistrationStateResponse(code = "123", state = ""),
        itemViewType = 0,
        paymentMethods = listOf(PaymentMethodResponse("1", "Yape", true))
    )
}

internal fun getRestaurant(): Restaurant {
    return Restaurant(
        code = "321",
        name = "Chilis",
        category = "",
        summary = "This is restaurant",
        urlImageBanner = "",
        information = listOf(),
        urlImageLogo = "https://www.tulogo.com",
        ownDelivery = true,
        registrationState = RegistrationState(code = "123", state = ""),
        paymentMethods = listOf(PaymentMethod("1", "Yape", true))
    )
}