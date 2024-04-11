package com.afoxplus.restaurants.cross.mappers

import com.afoxplus.network.response.BaseResponse
import com.afoxplus.restaurants.domain.entities.PaymentMethod
import com.afoxplus.restaurants.domain.entities.RegistrationState
import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.services.sources.network.api.response.PaymentMethodResponse
import com.afoxplus.restaurants.services.sources.network.api.response.RegistrationStateResponse
import com.afoxplus.restaurants.services.sources.network.api.response.RestaurantResponse

internal fun BaseResponse<List<RestaurantResponse>>.toListRestaurant(): List<Restaurant> {
    return this.payload.map { it.toRestaurant() }
}

internal fun List<PaymentMethodResponse>.toPaymentMethods(): List<PaymentMethod> {
    return this.map { PaymentMethod(it.id, it.name, it.isSelected) }
}

internal fun RegistrationStateResponse.toRegistrationState(): RegistrationState {
    return RegistrationState(
        code = code,
        state = state
    )
}

//TODO: Complete with backend
internal fun RestaurantResponse.toRestaurant(): Restaurant {
    return Restaurant(
        code = code,
        name = name,
        category = "Caffe & Resto",
        summary = description,
        urlImageLogo = urlImageLogo,
        urlImageBanner = "",
        ownDelivery = ownDelivery,
        registrationState = registrationState.toRegistrationState(),
        paymentMethods = paymentMethods.toPaymentMethods(),
        information = listOf(
            Restaurant.Information("CEL", "+51 966998544"),
            Restaurant.Information("ADDRESS", "Avenida arenales 1241")
        )
    )
}