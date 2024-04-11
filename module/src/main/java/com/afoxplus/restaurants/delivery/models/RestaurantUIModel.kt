package com.afoxplus.restaurants.delivery.models

internal data class RestaurantUIModel(
    val urlBanner: String,
    val urlLogo: String,
    val name: String,
    val category: String,
    val summary: String,
    val data: Map<Int, String>
)
