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

internal fun RestaurantResponse.toRestaurant(): Restaurant {
    return Restaurant(
        code = code,
        name = name,
        category = category.orEmpty(),
        summary = description,
        urlImageLogo = urlImageLogo,
        urlImageBanner = urlImageBanner.orEmpty(),
        ownDelivery = ownDelivery,
        registrationState = registrationState.toRegistrationState(),
        paymentMethods = paymentMethods.toPaymentMethods(),
        information = informationResponse?.map { item ->
            Restaurant.Information(item.code, item.name)
        }
    )
}