package com.afoxplus.restaurants.repositories.sources.network.api

import com.afoxplus.network.response.BaseResponse
import com.afoxplus.restaurants.repositories.sources.network.api.response.RestaurantResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface RestaurantApiNetwork {

    companion object {
        const val PATH_RESTAURANT = "restaurant"
        const val PATH_HOME = "home"
        const val PATH_CODE = "code"
    }

    @GET("$PATH_RESTAURANT/$PATH_HOME")
    suspend fun fetchHome(): BaseResponse<List<RestaurantResponse>>

    @GET("$PATH_RESTAURANT/{$PATH_CODE}")
    suspend fun findByCode(@Path(PATH_CODE) code: String): BaseResponse<RestaurantResponse>
}