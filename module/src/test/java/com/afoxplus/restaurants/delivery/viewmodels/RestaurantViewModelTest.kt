package com.afoxplus.restaurants.delivery.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.afoxplus.restaurants.delivery.flow.RestaurantBridge
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.FetchRestaurantHome
import com.afoxplus.restaurants.utils.TestCoroutineRule
import com.afoxplus.restaurants.utils.getOrAwaitValue
import com.afoxplus.restaurants.utils.getRestaurant
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class RestaurantViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val ruleCoroutineRule = TestCoroutineRule()

    private val mockFetchRestaurant: FetchRestaurantHome = mock()

    private val mockRestaurantBridge: RestaurantBridge = mock()

    private val mockDispatcherIO: CoroutineDispatcher by lazy { Dispatchers.IO }

    private val mockDispatcherMain: CoroutineDispatcher by lazy { Dispatchers.Main }

    private lateinit var sutRestaurantVewModel: RestaurantViewModel

    @Before
    fun setup() {
        sutRestaurantVewModel = RestaurantViewModel(
            fetchRestaurant = mockFetchRestaurant,
            restaurantBridge = mockRestaurantBridge,
            dispatcherIO = mockDispatcherIO,
            dispatcherMain = mockDispatcherMain
        )
    }

    @Test
    fun `Given restaurant view model When executed fetchRestaurantHome Then validated that flow is ok`() {
        ruleCoroutineRule.runBlockingTest {
            whenever(mockFetchRestaurant()).doReturn(arrayListOf(getRestaurant()))

            sutRestaurantVewModel.fetchRestaurantHome()
            val resultRestaurant = sutRestaurantVewModel.restaurantsHome.getOrAwaitValue()

            assertNotNull(sutRestaurantVewModel)
            assertNotNull(resultRestaurant)
            assertEquals(arrayListOf(getRestaurant()), resultRestaurant)
            assertEquals(1, resultRestaurant.size)
        }
    }

    @Test
    fun `Given restaurant view model When executed fetchRestaurantHome Then validated that flow is not ok`() {
        ruleCoroutineRule.runBlockingTest {
            whenever(mockFetchRestaurant()).doAnswer { throw Exception() }

            sutRestaurantVewModel.fetchRestaurantHome()
            val resultRestaurant = sutRestaurantVewModel.restaurantsHome.getOrAwaitValue()

            assertNotNull(sutRestaurantVewModel)
            assertNotNull(resultRestaurant)
            assertEquals(emptyList<List<Restaurant>>(), resultRestaurant)
        }
    }

    @Test
    fun `Given restaurant view model When executed onClickRestaurant Then validated that flow is ok`() {
        ruleCoroutineRule.runBlockingTest {
            val mockRestaurant: Restaurant = getRestaurant()
            whenever(mockRestaurantBridge.saveRestaurant(mockRestaurant)).doReturn(println("Guardado!!!"))

            sutRestaurantVewModel.onClickCardRestaurant(mockRestaurant)

            delay(1500L)
            verify(mockRestaurantBridge, times(numInvocations = 1)).saveRestaurant(mockRestaurant)
        }
    }
}
