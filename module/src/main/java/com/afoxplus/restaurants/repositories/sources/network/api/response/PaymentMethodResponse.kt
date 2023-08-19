package com.afoxplus.restaurants.repositories.sources.network.api.response

import com.afoxplus.restaurants.entities.PaymentMethod
import com.google.gson.annotations.SerializedName

data class PaymentMethodResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("paymentMethod")
    val name: String,
    @SerializedName("isDefaultSelected")
    val isSelected: Boolean
)

fun List<PaymentMethodResponse>.toPaymentMethods(): List<PaymentMethod> {
    return this.map { PaymentMethod(it.id, it.name, it.isSelected) }
}