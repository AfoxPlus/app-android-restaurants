package com.afoxplus.restaurants.delivery.viewmodels

import com.afoxplus.restaurants.delivery.models.UIState
import com.afoxplus.restaurants.domain.entities.Restaurant
import com.afoxplus.restaurants.domain.usecases.FetchRestaurantHomeUseCase
import com.afoxplus.restaurants.domain.usecases.SetToContextRestaurantUseCase
import com.afoxplus.restaurants.utils.BaseViewModelTest
import com.afoxplus.restaurants.utils.getRestaurant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class RestaurantViewModelTest : BaseViewModelTest() {

    private val mockFetchRestaurant: FetchRestaurantHomeUseCase = mock()
    private val mockSetToContextRestaurant: SetToContextRestaurantUseCase = mock()

    private lateinit var sutRestaurantVewModel: RestaurantViewModel

    @Before
    fun setup() {
        sutRestaurantVewModel = RestaurantViewModel(
            fetchRestaurant = mockFetchRestaurant,
            setToContextRestaurant = mockSetToContextRestaurant,
            coroutineDispatcher = testDispatcherProvider
        )
    }

    @Test
    fun `Given restaurant view model When executed fetchRestaurantHome Then validated that flow is ok`() {
        runTest {
            whenever(mockFetchRestaurant()).doReturn(arrayListOf(getRestaurant()))
            val results = mutableListOf<UIState<List<Restaurant>>>()
            val job =
                launch(testDispatcher) { sutRestaurantVewModel.uiStateRestaurant.toList(results) }

            sutRestaurantVewModel.fetchRestaurantHome()

            val resultRestaurant = (results.last() as UIState.OnSuccess).data
            assertNotNull(sutRestaurantVewModel)
            assertNotNull(resultRestaurant)
            assertEquals(arrayListOf(getRestaurant()), resultRestaurant)
            assertEquals(1, resultRestaurant.size)
            job.cancel()
        }
    }

    @Test
    fun `Given restaurant view model When executed fetchRestaurantHome Then validated that flow is not ok`() {
        runTest {
            whenever(mockFetchRestaurant()).doAnswer { throw Exception() }

            val results = mutableListOf<UIState<List<Restaurant>>>()
            val job =
                launch(testDispatcher) { sutRestaurantVewModel.uiStateRestaurant.toList(results) }

            sutRestaurantVewModel.fetchRestaurantHome()

            assertNotNull(sutRestaurantVewModel)
            assertTrue(results.last() is UIState.OnError)

            job.cancel()
        }
    }

    @Test
    fun `Should set restaurant to context`() {
        runTest {

            sutRestaurantVewModel.updateContextRestaurant(getRestaurant())
        }
    }
}
