package com.afoxplus.restaurants.repositories.sources.network.service

import com.afoxplus.home.utils.TestCoroutineRule
import com.afoxplus.network.response.BaseResponse
import com.afoxplus.restaurants.repositories.sources.network.api.RestaurantApiNetwork
import com.afoxplus.restaurants.repositories.sources.network.api.response.RegistrationStateResponse
import com.afoxplus.restaurants.repositories.sources.network.api.response.RestaurantResponse
import com.afoxplus.restaurants.repositories.sources.network.api.response.toListRestaurant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class RestaurantNetworkServiceTest {

    @get:Rule
    val ruleTestCoroutine = TestCoroutineRule()

    private val mockRestaurantApi: RestaurantApiNetwork = mock()

    private lateinit var sutService: RestaurantNetworkService

    @Before
    fun setup() {
        sutService = RestaurantNetworkService(mockRestaurantApi)
    }

    private fun getRestaurantResponse(): BaseResponse<List<RestaurantResponse>> {
        val listRestaurantResponse = arrayListOf(
            RestaurantResponse(
                code = "321",
                name = "Chilis",
                description = "This is restaurant",
                urlImageLogo = "",
                registrationState = RegistrationStateResponse("951", ""),
                itemViewType = 0
            )
        )
        return BaseResponse(success = true, message = "", payload = listRestaurantResponse)
    }

    @Test
    fun invokeFetchHome() {
        ruleTestCoroutine.runBlockingTest {
            //Given
            val restaurantResponse = getRestaurantResponse()
            val resultMapper = restaurantResponse.toListRestaurant()
            whenever(mockRestaurantApi.fetchHome()).doReturn(restaurantResponse)
            //When
            val resultData = sutService.fetchHome()
            //Then
            assertNotNull(mockRestaurantApi)
            assertNotNull(sutService)
            assertNotNull(resultData)
            assertTrue(resultData.isNotEmpty())
            verify(mockRestaurantApi, times(numInvocations = 1)).fetchHome()
            assertEquals(resultMapper, resultData)
        }
    }

}