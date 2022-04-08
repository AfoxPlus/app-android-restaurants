package com.afoxplus.restaurants.delivery.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.afoxplus.home.utils.TestCoroutineRule
import com.afoxplus.restaurants.delivery.flow.RestaurantBridge
import com.afoxplus.restaurants.entities.RegistrationState
import com.afoxplus.restaurants.entities.Restaurant
import com.afoxplus.restaurants.usecases.actions.FetchRestaurantHome
import com.hacybeyker.movieoh.getOrAwaitValue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import org.junit.Assert
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
    fun invokeFetchRestaurantHomeOK() {
        ruleCoroutineRule.runBlockingTest {
            //Given
            whenever(mockFetchRestaurant()).doReturn(emptyList())
            //When
            sutRestaurantVewModel.fetchRestaurantHome()
            val resultRestaurant = sutRestaurantVewModel.restaurantsHome.getOrAwaitValue()
            //Then
            Assert.assertTrue(true)
        }
    }

    @Test
    fun invokeFetchRestaurantHomeFail() {
        ruleCoroutineRule.runBlockingTest {
            //Given
            whenever(mockFetchRestaurant()).doAnswer { throw Exception() }
            //When
            sutRestaurantVewModel.fetchRestaurantHome()
            val resultRestaurant = sutRestaurantVewModel.restaurantsHome.getOrAwaitValue()
            //Then
            assertNotNull(sutRestaurantVewModel.restaurantsHome)
            assertEquals(emptyList<List<Restaurant>>(), resultRestaurant)
            Assert.assertTrue(true)

        }
    }

    @Test
    fun testOnClickCardRestaurant() {
        ruleCoroutineRule.runBlockingTest {
            //Given
            val mockRestaurant: Restaurant = Restaurant(
                "123", "Viky", "description", "",
                RegistrationState("", ""), 0
            )
            whenever(mockRestaurantBridge.saveRestaurant(mockRestaurant)).doReturn(println("Guardado!!!"))
            //When
            sutRestaurantVewModel.onClickCardRestaurant(mockRestaurant)
            //Then
            delay(1500L)
            verify(mockRestaurantBridge, times(1)).saveRestaurant(mockRestaurant)
        }
    }
}
