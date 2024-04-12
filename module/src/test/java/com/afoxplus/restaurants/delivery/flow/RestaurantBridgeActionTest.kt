package com.afoxplus.restaurants.delivery.flow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.afoxplus.restaurants.delivery.models.RestaurantEventModel
import com.afoxplus.restaurants.utils.TestCoroutineRule
import com.afoxplus.restaurants.utils.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.spy

@ExperimentalCoroutinesApi
class RestaurantBridgeActionTest {

    @get:Rule
    val ruleInstantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val ruleTestCoroutineRule = TestCoroutineRule()

    private val sutRestaurantBridgeAction: RestaurantBridgeAction = spy()

    @Test
    fun `Given a restaurant When execute saveRestaurant Then validate that save it's ok`() {
        ruleTestCoroutineRule.runBlockingTest {
            val restaurantData = RestaurantEventModel(code = "AS1D23", name = "Restaurant")

            sutRestaurantBridgeAction.saveRestaurant(restaurant = restaurantData)
            val resultRestaurant = sutRestaurantBridgeAction.restaurant.getOrAwaitValue()
            sutRestaurantBridgeAction.fetchRestaurant()

            assertNotNull(sutRestaurantBridgeAction)
            assertNotNull(resultRestaurant)
            assertEquals(restaurantData, resultRestaurant)
        }
    }
}