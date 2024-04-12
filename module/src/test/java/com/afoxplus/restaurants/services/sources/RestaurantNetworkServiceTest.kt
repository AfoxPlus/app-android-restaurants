package com.afoxplus.restaurants.services.sources

import com.afoxplus.restaurants.cross.mappers.toListRestaurant
import com.afoxplus.restaurants.services.sources.network.api.RestaurantApiNetwork
import com.afoxplus.restaurants.services.sources.network.service.RestaurantNetworkService
import com.afoxplus.restaurants.utils.TestCoroutineRule
import com.afoxplus.restaurants.utils.getBaseResponse
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

    @Test
    fun `Given a restaurant response When execute fetchHome Then validate flow it's ok`() {
        ruleTestCoroutine.runBlockingTest {
            val restaurantResponse = getBaseResponse()
            val resultMapper = restaurantResponse.toListRestaurant()
            whenever(mockRestaurantApi.fetchHome()).doReturn(restaurantResponse)

            val resultData = sutService.fetchHome()

            assertNotNull(mockRestaurantApi)
            assertNotNull(sutService)
            assertNotNull(resultData)
            assertTrue(resultData.isNotEmpty())
            verify(mockRestaurantApi, times(numInvocations = 1)).fetchHome()
            assertEquals(resultMapper, resultData)
        }
    }
}