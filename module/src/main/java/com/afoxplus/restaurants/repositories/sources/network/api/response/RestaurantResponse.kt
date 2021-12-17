package com.afoxplus.restaurants.repositories.sources.network.api.response

import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.entities.RestaurantViewType
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class RestaurantResponse(
    @SerializedName("code") override val code: String,
    @SerializedName("name") override val name: String,
    @SerializedName("description") override val description: String,
    @SerializedName("urlImageLogo") override val urlImageLogo: String,
    @SerializedName("registrationState") override val registrationState: RegistrationStateResponse,
    override val viewType: RestaurantViewType = RestaurantViewType.getHomeViewType()
) : Restaurant