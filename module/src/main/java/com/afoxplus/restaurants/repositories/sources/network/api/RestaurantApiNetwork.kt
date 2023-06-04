package com.afoxplus.restaurants.repositories.sources.network.api

import com.afoxplus.network.annotations.ServiceClient
import com.afoxplus.network.api.UrlProvider
import com.afoxplus.network.response.BaseResponse
import com.afoxplus.restaurants.repositories.sources.network.api.response.RestaurantResponse
import retrofit2.http.GET

@ServiceClient(type = UrlProvider.Type.API_RESTAURANTS)
internal interface RestaurantApiNetwork {

    companion object {
        const val PATH_RESTAURANT = "restaurant"
    }

    @GET("$PATH_RESTAURANT/home")
    suspend fun fetchHome(): BaseResponse<List<RestaurantResponse>>
}