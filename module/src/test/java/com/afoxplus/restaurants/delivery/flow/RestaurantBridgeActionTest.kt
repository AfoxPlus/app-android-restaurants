package com.afoxplus.restaurants.delivery.flow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.afoxplus.home.utils.TestCoroutineRule
import com.afoxplus.restaurants.entities.RegistrationState
import com.afoxplus.restaurants.entities.Restaurant
import com.hacybeyker.movieoh.getOrAwaitValue
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

    private val mockRestaurant: Restaurant = Restaurant(
        "123", "Viky", "description", "",
        RegistrationState("", ""), 0
    )

    @Test
    fun pklpkpk() {
        ruleTestCoroutineRule.runBlockingTest {
            //Given
            val restaurantData = mockRestaurant
            //When
            sutRestaurantBridgeAction.saveRestaurant(restaurant = restaurantData)
            val resultRestaurant = sutRestaurantBridgeAction.restaurantLD.getOrAwaitValue()
            sutRestaurantBridgeAction.fetchRestaurant()
            //Then
            assertNotNull(sutRestaurantBridgeAction)
            assertNotNull(resultRestaurant)
            assertEquals(restaurantData, restaurantData)
        }
    }


}